package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.o;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes15.dex */
public class m extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.hottopic.a.g> {
    private boolean ZD;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fcj;
    private com.baidu.tieba.hottopic.a.g iXF;
    private boolean iXG;
    private boolean iXH;
    private boolean iXI;
    private boolean iXJ;
    private CyberPlayerManager.OnErrorListener iXK;
    private CustomMessageListener iXL;
    private CustomMessageListener iXM;
    private CustomMessageListener iXN;
    private CustomMessageListener iXO;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iXG = false;
        this.iXH = false;
        this.ZD = false;
        this.iXI = false;
        this.iXJ = true;
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.iXF != null && m.this.iXF.fDL != null) {
                    m.this.iXF.fDL.stopPlayback();
                }
                m.this.czu();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.iXH && m.this.iXF != null && m.this.iXF.fDL != null && m.this.iXF.jaT != null && m.this.iXF.jaW != null && m.this.iXF.jaY != null) {
                            if (m.this.iXF.fDL.getCurrentPosition() > 0) {
                                m.this.iXF.jaT.setVisibility(8);
                                m.this.iXF.jaW.setVisibility(8);
                                m.this.iXF.jaY.setVisibility(8);
                                m.this.b((o) message.obj, m.this.iXF);
                                m.this.c(m.this.iXF);
                                return;
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = message.obj;
                            m.this.mHandler.sendMessageDelayed(obtainMessage, 50L);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.iXK = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.iXH) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bhm();
                }
                m.this.czu();
                return true;
            }
        };
        this.iXL = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.czw();
            }
        };
        this.iXM = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iXF != null && m.this.iXF.jaT != null && m.this.iXF.jaW != null && m.this.iXF.fDL != null) {
                    m.this.iXF.jaT.setVisibility(0);
                    m.this.iXF.jaW.setVisibility(8);
                    m.this.iXF.fDL.stopPlayback();
                    m.this.iXH = true;
                    m.this.c(m.this.iXF);
                }
            }
        };
        this.iXN = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iXF != null && m.this.iXF.jbc != null) {
                    int[] iArr = new int[2];
                    m.this.iXF.jbc.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.iXF.jbc.getHeight() < 0) {
                    }
                }
            }
        };
        this.iXO = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.iXF != null && m.this.iXF.jaU != null && m.this.iXF.jaV != null) {
                    m.this.iXF.jaU.destroy();
                    m.this.iXF.jaV.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.iXL);
            baseActivity.registerListener(this.iXM);
            baseActivity.registerListener(this.iXN);
            baseActivity.registerListener(this.iXO);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public com.baidu.tieba.hottopic.a.g b(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.iXF = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            czu();
        }
        return this.iXF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czu() {
        if (this.iXF != null && this.iXF.jaT != null && this.iXF.jaW != null) {
            this.iXF.jaT.setVisibility(0);
            this.iXF.jaW.setVisibility(8);
            this.iXH = true;
            c(this.iXF);
            a(this.iXF);
        }
    }

    public void czv() {
        this.iXG = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.iXG) {
                this.iXG = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.iXJ = true;
                    gVar.jaU.setVisibility(8);
                    gVar.jaV.setVisibility(8);
                    gVar.dDE.setVisibility(8);
                } else {
                    this.iXJ = false;
                    gVar.dDE.setVisibility(0);
                    if (this.ZD) {
                        gVar.jaU.setVisibility(8);
                        gVar.jaV.setVisibility(0);
                    } else {
                        gVar.jaU.setVisibility(0);
                        gVar.jaV.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.jaT.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.jaT.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.jaT.setForegroundDrawable(0);
                    gVar.jaT.setOnClickListener(null);
                }
                gVar.jaT.setDefaultErrorResource(0);
                gVar.jaT.setTag(Integer.valueOf(i));
                gVar.jaT.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bbM().isShowImages()) {
                    gVar.jaT.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.jaT.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.jaT.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.jaT.setSupportNoImage(true);
                    gVar.jaT.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.jaT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.fDL.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.jaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.jaW.setVisibility(8);
                        if (gVar.fDL != null) {
                            gVar.fDL.setPlayMode("2");
                        }
                        gVar.fDL.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.fDL.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.fDL != null && gVar.jaU != null) {
                            int curProgress = gVar.jaU.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.fDL.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.jaU;
                                gVar.fDL.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.fDL.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.jaW.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.fDL.setOnErrorListener(this.iXK);
                gVar.fDL.setOnSurfaceDestroyedListener(this.fcj);
                gVar.dDE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.fDL.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.fDL.pause();
                        gVar.jaY.setVisibility(0);
                    }
                });
                if (this.ZD) {
                    gVar.jaV.setPlayer(gVar.fDL);
                } else {
                    gVar.jaU.setPlayer(gVar.fDL);
                }
                if (StringUtils.isNull(oVar.eab)) {
                    gVar.jba.setVisibility(8);
                    gVar.jbb.setVisibility(8);
                } else {
                    gVar.jba.setVisibility(0);
                    gVar.jbb.setVisibility(0);
                    gVar.jba.setText(oVar.eab);
                    gVar.jba.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eab, "")));
                        }
                    });
                }
            }
            if (gVar.aiB != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.jaU.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.jaY, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.jaX, R.color.cp_cont_a, 1);
                gVar.jaV.onChangeSkinType(this.mSkinType);
                gVar.jaX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.jba, R.color.cp_cont_b, 1);
                ap.setBackgroundColor(gVar.jbb, R.color.cp_bg_line_c);
            }
            gVar.aiB = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.zz(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.fDL != null) {
                        gVar.fDL.setPlayMode("2");
                    }
                    m.this.b(gVar, oVar);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.activity.getPageContext()).bhg();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.fDL.start();
        gVar.jaY.setVisibility(8);
        gVar.jaW.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private o iXS;
        private com.baidu.tieba.hottopic.a.g iXT;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.iXS = oVar;
            this.iXT = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iXS != null && this.iXT != null && this.iXT.jaZ != null && this.iXT.fDL != null) {
                if (this.iXT.jaZ.getVisibility() == 0) {
                    this.iXT.fDL.stopPlayback();
                    m.this.iXH = true;
                    m.this.c(this.iXT);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.zz(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.czx();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).bhg();
                } else {
                    czx();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void czx() {
            if (this.iXS != null && this.iXT != null && this.iXT.fDL != null) {
                this.iXT.fDL.setPlayMode("2");
                this.iXT.fDL.setVideoPath(this.iXS.videoUrl);
                this.iXT.fDL.start();
                m.this.iXH = false;
                m.this.b(this.iXT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.jaT.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.jaT.startLoad(oVar.picUrl, 17, false);
            }
            gVar.jaT.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.jaT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.ZD) {
                gVar.jaV.initProgress();
            } else {
                gVar.jaU.bz(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.ZD) {
                gVar.jaV.showProgress();
            } else {
                gVar.jaU.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.jaU != null && gVar.jaV != null) {
            gVar.jaU.aIm();
            gVar.jaV.aIm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jaZ.setVisibility(0);
            gVar.jaT.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jaZ.setVisibility(8);
            if (this.iXJ) {
                gVar.jaT.setForegroundDrawable(0);
            } else {
                gVar.jaT.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czw() {
        if (this.iXF != null && this.iXF.fDL != null && this.iXF.jaY != null && this.iXF.jaZ != null) {
            if (this.iXF.fDL.isPlaying()) {
                this.iXF.fDL.pause();
                this.iXF.jaY.setVisibility(0);
            } else if (this.iXF.jaZ.getVisibility() == 0) {
                this.iXF.fDL.stopPlayback();
                this.iXH = true;
                c(this.iXF);
            }
        }
    }
}
