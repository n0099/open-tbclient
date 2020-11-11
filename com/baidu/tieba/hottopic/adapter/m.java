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
/* loaded from: classes21.dex */
public class m extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.hottopic.a.g> {
    private boolean aap;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fFI;
    private com.baidu.tieba.hottopic.a.g jNN;
    private boolean jNO;
    private boolean jNP;
    private boolean jNQ;
    private boolean jNR;
    private CyberPlayerManager.OnErrorListener jNS;
    private CustomMessageListener jNT;
    private CustomMessageListener jNU;
    private CustomMessageListener jNV;
    private CustomMessageListener jNW;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jNO = false;
        this.jNP = false;
        this.aap = false;
        this.jNQ = false;
        this.jNR = true;
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.jNN != null && m.this.jNN.gjd != null) {
                    m.this.jNN.gjd.stopPlayback();
                }
                m.this.cMt();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.jNP && m.this.jNN != null && m.this.jNN.gjd != null && m.this.jNN.jQZ != null && m.this.jNN.jRc != null && m.this.jNN.jRe != null) {
                            if (m.this.jNN.gjd.getCurrentPosition() > 0) {
                                m.this.jNN.jQZ.setVisibility(8);
                                m.this.jNN.jRc.setVisibility(8);
                                m.this.jNN.jRe.setVisibility(8);
                                m.this.b((o) message.obj, m.this.jNN);
                                m.this.c(m.this.jNN);
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
        this.jNS = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.jNP) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bpi();
                }
                m.this.cMt();
                return true;
            }
        };
        this.jNT = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cMv();
            }
        };
        this.jNU = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jNN != null && m.this.jNN.jQZ != null && m.this.jNN.jRc != null && m.this.jNN.gjd != null) {
                    m.this.jNN.jQZ.setVisibility(0);
                    m.this.jNN.jRc.setVisibility(8);
                    m.this.jNN.gjd.stopPlayback();
                    m.this.jNP = true;
                    m.this.c(m.this.jNN);
                }
            }
        };
        this.jNV = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jNN != null && m.this.jNN.jRi != null) {
                    int[] iArr = new int[2];
                    m.this.jNN.jRi.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.jNN.jRi.getHeight() < 0) {
                    }
                }
            }
        };
        this.jNW = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.jNN != null && m.this.jNN.jRa != null && m.this.jNN.jRb != null) {
                    m.this.jNN.jRa.destroy();
                    m.this.jNN.jRb.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.jNT);
            baseActivity.registerListener(this.jNU);
            baseActivity.registerListener(this.jNV);
            baseActivity.registerListener(this.jNW);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public com.baidu.tieba.hottopic.a.g c(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.jNN = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cMt();
        }
        return this.jNN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMt() {
        if (this.jNN != null && this.jNN.jQZ != null && this.jNN.jRc != null) {
            this.jNN.jQZ.setVisibility(0);
            this.jNN.jRc.setVisibility(8);
            this.jNP = true;
            c(this.jNN);
            a(this.jNN);
        }
    }

    public void cMu() {
        this.jNO = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.jNO) {
                this.jNO = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.jNR = true;
                    gVar.jRa.setVisibility(8);
                    gVar.jRb.setVisibility(8);
                    gVar.efX.setVisibility(8);
                } else {
                    this.jNR = false;
                    gVar.efX.setVisibility(0);
                    if (this.aap) {
                        gVar.jRa.setVisibility(8);
                        gVar.jRb.setVisibility(0);
                    } else {
                        gVar.jRa.setVisibility(0);
                        gVar.jRb.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.jQZ.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.jQZ.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.jQZ.setForegroundDrawable(0);
                    gVar.jQZ.setOnClickListener(null);
                }
                gVar.jQZ.setDefaultErrorResource(0);
                gVar.jQZ.setTag(Integer.valueOf(i));
                gVar.jQZ.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bjH().isShowImages()) {
                    gVar.jQZ.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.jQZ.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.jQZ.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.jQZ.setSupportNoImage(true);
                    gVar.jQZ.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.jQZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.gjd.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.jRd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.jRc.setVisibility(8);
                        if (gVar.gjd != null) {
                            gVar.gjd.setPlayMode("2");
                        }
                        gVar.gjd.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.gjd.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.gjd != null && gVar.jRa != null) {
                            int curProgress = gVar.jRa.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.gjd.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.jRa;
                                gVar.gjd.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.gjd.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.jRc.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.gjd.setOnErrorListener(this.jNS);
                gVar.gjd.setOnSurfaceDestroyedListener(this.fFI);
                gVar.efX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.gjd.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.gjd.pause();
                        gVar.jRe.setVisibility(0);
                    }
                });
                if (this.aap) {
                    gVar.jRb.setPlayer(gVar.gjd);
                } else {
                    gVar.jRa.setPlayer(gVar.gjd);
                }
                if (StringUtils.isNull(oVar.eCJ)) {
                    gVar.jRg.setVisibility(8);
                    gVar.jRh.setVisibility(8);
                } else {
                    gVar.jRg.setVisibility(0);
                    gVar.jRh.setVisibility(0);
                    gVar.jRg.setText(oVar.eCJ);
                    gVar.jRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eCJ, "")));
                        }
                    });
                }
            }
            if (gVar.ajq != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.jRa.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.jRe, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.jRd, R.color.cp_cont_a, 1);
                gVar.jRb.onChangeSkinType(this.mSkinType);
                gVar.jRd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.jRg, R.color.cp_cont_b, 1);
                ap.setBackgroundColor(gVar.jRh, R.color.cp_bg_line_c);
            }
            gVar.ajq = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.gjd != null) {
                        gVar.gjd.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).bpc();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.gjd.start();
        gVar.jRe.setVisibility(8);
        gVar.jRc.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private o jOa;
        private com.baidu.tieba.hottopic.a.g jOb;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.jOa = oVar;
            this.jOb = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jOa != null && this.jOb != null && this.jOb.jRf != null && this.jOb.gjd != null) {
                if (this.jOb.jRf.getVisibility() == 0) {
                    this.jOb.gjd.stopPlayback();
                    m.this.jNP = true;
                    m.this.c(this.jOb);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cMw();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).bpc();
                } else {
                    cMw();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cMw() {
            if (this.jOa != null && this.jOb != null && this.jOb.gjd != null) {
                this.jOb.gjd.setPlayMode("2");
                this.jOb.gjd.setVideoPath(this.jOa.videoUrl);
                this.jOb.gjd.start();
                m.this.jNP = false;
                m.this.b(this.jOb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.jQZ.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.jQZ.startLoad(oVar.picUrl, 17, false);
            }
            gVar.jQZ.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.jQZ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.aap) {
                gVar.jRb.initProgress();
            } else {
                gVar.jRa.bz(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.aap) {
                gVar.jRb.showProgress();
            } else {
                gVar.jRa.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.jRa != null && gVar.jRb != null) {
            gVar.jRa.aQa();
            gVar.jRb.aQa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jRf.setVisibility(0);
            gVar.jQZ.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jRf.setVisibility(8);
            if (this.jNR) {
                gVar.jQZ.setForegroundDrawable(0);
            } else {
                gVar.jQZ.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMv() {
        if (this.jNN != null && this.jNN.gjd != null && this.jNN.jRe != null && this.jNN.jRf != null) {
            if (this.jNN.gjd.isPlaying()) {
                this.jNN.gjd.pause();
                this.jNN.jRe.setVisibility(0);
            } else if (this.jNN.jRf.getVisibility() == 0) {
                this.jNN.gjd.stopPlayback();
                this.jNP = true;
                c(this.jNN);
            }
        }
    }
}
