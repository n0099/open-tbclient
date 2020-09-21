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
/* loaded from: classes20.dex */
public class m extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.hottopic.a.g> {
    private boolean ZX;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a ffg;
    private CustomMessageListener jgA;
    private com.baidu.tieba.hottopic.a.g jgr;
    private boolean jgs;
    private boolean jgt;
    private boolean jgu;
    private boolean jgv;
    private CyberPlayerManager.OnErrorListener jgw;
    private CustomMessageListener jgx;
    private CustomMessageListener jgy;
    private CustomMessageListener jgz;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jgs = false;
        this.jgt = false;
        this.ZX = false;
        this.jgu = false;
        this.jgv = true;
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.jgr != null && m.this.jgr.fHb != null) {
                    m.this.jgr.fHb.stopPlayback();
                }
                m.this.cDc();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.jgt && m.this.jgr != null && m.this.jgr.fHb != null && m.this.jgr.jjF != null && m.this.jgr.jjI != null && m.this.jgr.jjK != null) {
                            if (m.this.jgr.fHb.getCurrentPosition() > 0) {
                                m.this.jgr.jjF.setVisibility(8);
                                m.this.jgr.jjI.setVisibility(8);
                                m.this.jgr.jjK.setVisibility(8);
                                m.this.b((o) message.obj, m.this.jgr);
                                m.this.c(m.this.jgr);
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
        this.jgw = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.jgt) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).big();
                }
                m.this.cDc();
                return true;
            }
        };
        this.jgx = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cDe();
            }
        };
        this.jgy = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jgr != null && m.this.jgr.jjF != null && m.this.jgr.jjI != null && m.this.jgr.fHb != null) {
                    m.this.jgr.jjF.setVisibility(0);
                    m.this.jgr.jjI.setVisibility(8);
                    m.this.jgr.fHb.stopPlayback();
                    m.this.jgt = true;
                    m.this.c(m.this.jgr);
                }
            }
        };
        this.jgz = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jgr != null && m.this.jgr.jjO != null) {
                    int[] iArr = new int[2];
                    m.this.jgr.jjO.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.jgr.jjO.getHeight() < 0) {
                    }
                }
            }
        };
        this.jgA = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.jgr != null && m.this.jgr.jjG != null && m.this.jgr.jjH != null) {
                    m.this.jgr.jjG.destroy();
                    m.this.jgr.jjH.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.jgx);
            baseActivity.registerListener(this.jgy);
            baseActivity.registerListener(this.jgz);
            baseActivity.registerListener(this.jgA);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
    public com.baidu.tieba.hottopic.a.g c(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.jgr = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cDc();
        }
        return this.jgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDc() {
        if (this.jgr != null && this.jgr.jjF != null && this.jgr.jjI != null) {
            this.jgr.jjF.setVisibility(0);
            this.jgr.jjI.setVisibility(8);
            this.jgt = true;
            c(this.jgr);
            a(this.jgr);
        }
    }

    public void cDd() {
        this.jgs = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.jgs) {
                this.jgs = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.jgv = true;
                    gVar.jjG.setVisibility(8);
                    gVar.jjH.setVisibility(8);
                    gVar.dFJ.setVisibility(8);
                } else {
                    this.jgv = false;
                    gVar.dFJ.setVisibility(0);
                    if (this.ZX) {
                        gVar.jjG.setVisibility(8);
                        gVar.jjH.setVisibility(0);
                    } else {
                        gVar.jjG.setVisibility(0);
                        gVar.jjH.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.jjF.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.jjF.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.jjF.setForegroundDrawable(0);
                    gVar.jjF.setOnClickListener(null);
                }
                gVar.jjF.setDefaultErrorResource(0);
                gVar.jjF.setTag(Integer.valueOf(i));
                gVar.jjF.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bcG().isShowImages()) {
                    gVar.jjF.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.jjF.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.jjF.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.jjF.setSupportNoImage(true);
                    gVar.jjF.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.jjF.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.fHb.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.jjJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.jjI.setVisibility(8);
                        if (gVar.fHb != null) {
                            gVar.fHb.setPlayMode("2");
                        }
                        gVar.fHb.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.fHb.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.fHb != null && gVar.jjG != null) {
                            int curProgress = gVar.jjG.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.fHb.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.jjG;
                                gVar.fHb.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.fHb.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.jjI.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.fHb.setOnErrorListener(this.jgw);
                gVar.fHb.setOnSurfaceDestroyedListener(this.ffg);
                gVar.dFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.fHb.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.fHb.pause();
                        gVar.jjK.setVisibility(0);
                    }
                });
                if (this.ZX) {
                    gVar.jjH.setPlayer(gVar.fHb);
                } else {
                    gVar.jjG.setPlayer(gVar.fHb);
                }
                if (StringUtils.isNull(oVar.ecp)) {
                    gVar.jjM.setVisibility(8);
                    gVar.jjN.setVisibility(8);
                } else {
                    gVar.jjM.setVisibility(0);
                    gVar.jjN.setVisibility(0);
                    gVar.jjM.setText(oVar.ecp);
                    gVar.jjM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.ecp, "")));
                        }
                    });
                }
            }
            if (gVar.aiX != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.jjG.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.jjK, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.jjJ, R.color.cp_cont_a, 1);
                gVar.jjH.onChangeSkinType(this.mSkinType);
                gVar.jjJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.jjM, R.color.cp_cont_b, 1);
                ap.setBackgroundColor(gVar.jjN, R.color.cp_bg_line_c);
            }
            gVar.aiX = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.zV(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.fHb != null) {
                        gVar.fHb.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).bia();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.fHb.start();
        gVar.jjK.setVisibility(8);
        gVar.jjI.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private o jgE;
        private com.baidu.tieba.hottopic.a.g jgF;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.jgE = oVar;
            this.jgF = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jgE != null && this.jgF != null && this.jgF.jjL != null && this.jgF.fHb != null) {
                if (this.jgF.jjL.getVisibility() == 0) {
                    this.jgF.fHb.stopPlayback();
                    m.this.jgt = true;
                    m.this.c(this.jgF);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.zV(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cDf();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).bia();
                } else {
                    cDf();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cDf() {
            if (this.jgE != null && this.jgF != null && this.jgF.fHb != null) {
                this.jgF.fHb.setPlayMode("2");
                this.jgF.fHb.setVideoPath(this.jgE.videoUrl);
                this.jgF.fHb.start();
                m.this.jgt = false;
                m.this.b(this.jgF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.jjF.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.jjF.startLoad(oVar.picUrl, 17, false);
            }
            gVar.jjF.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.jjF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.ZX) {
                gVar.jjH.initProgress();
            } else {
                gVar.jjG.bz(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.ZX) {
                gVar.jjH.showProgress();
            } else {
                gVar.jjG.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.jjG != null && gVar.jjH != null) {
            gVar.jjG.aIX();
            gVar.jjH.aIX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jjL.setVisibility(0);
            gVar.jjF.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jjL.setVisibility(8);
            if (this.jgv) {
                gVar.jjF.setForegroundDrawable(0);
            } else {
                gVar.jjF.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDe() {
        if (this.jgr != null && this.jgr.fHb != null && this.jgr.jjK != null && this.jgr.jjL != null) {
            if (this.jgr.fHb.isPlaying()) {
                this.jgr.fHb.pause();
                this.jgr.jjK.setVisibility(0);
            } else if (this.jgr.jjL.getVisibility() == 0) {
                this.jgr.fHb.stopPlayback();
                this.jgt = true;
                c(this.jgr);
            }
        }
    }
}
