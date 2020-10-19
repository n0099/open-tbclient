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
    private boolean aao;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a frv;
    private com.baidu.tieba.hottopic.a.g jvq;
    private boolean jvr;
    private boolean jvs;
    private boolean jvt;
    private boolean jvu;
    private CyberPlayerManager.OnErrorListener jvv;
    private CustomMessageListener jvw;
    private CustomMessageListener jvx;
    private CustomMessageListener jvy;
    private CustomMessageListener jvz;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jvr = false;
        this.jvs = false;
        this.aao = false;
        this.jvt = false;
        this.jvu = true;
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.jvq != null && m.this.jvq.fTk != null) {
                    m.this.jvq.fTk.stopPlayback();
                }
                m.this.cGL();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.jvs && m.this.jvq != null && m.this.jvq.fTk != null && m.this.jvq.jyD != null && m.this.jvq.jyG != null && m.this.jvq.jyI != null) {
                            if (m.this.jvq.fTk.getCurrentPosition() > 0) {
                                m.this.jvq.jyD.setVisibility(8);
                                m.this.jvq.jyG.setVisibility(8);
                                m.this.jvq.jyI.setVisibility(8);
                                m.this.b((o) message.obj, m.this.jvq);
                                m.this.c(m.this.jvq);
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
        this.jvv = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.jvs) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bkP();
                }
                m.this.cGL();
                return true;
            }
        };
        this.jvw = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cGN();
            }
        };
        this.jvx = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jvq != null && m.this.jvq.jyD != null && m.this.jvq.jyG != null && m.this.jvq.fTk != null) {
                    m.this.jvq.jyD.setVisibility(0);
                    m.this.jvq.jyG.setVisibility(8);
                    m.this.jvq.fTk.stopPlayback();
                    m.this.jvs = true;
                    m.this.c(m.this.jvq);
                }
            }
        };
        this.jvy = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jvq != null && m.this.jvq.jyM != null) {
                    int[] iArr = new int[2];
                    m.this.jvq.jyM.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.jvq.jyM.getHeight() < 0) {
                    }
                }
            }
        };
        this.jvz = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.jvq != null && m.this.jvq.jyE != null && m.this.jvq.jyF != null) {
                    m.this.jvq.jyE.destroy();
                    m.this.jvq.jyF.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.jvw);
            baseActivity.registerListener(this.jvx);
            baseActivity.registerListener(this.jvy);
            baseActivity.registerListener(this.jvz);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public com.baidu.tieba.hottopic.a.g c(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.jvq = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cGL();
        }
        return this.jvq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGL() {
        if (this.jvq != null && this.jvq.jyD != null && this.jvq.jyG != null) {
            this.jvq.jyD.setVisibility(0);
            this.jvq.jyG.setVisibility(8);
            this.jvs = true;
            c(this.jvq);
            a(this.jvq);
        }
    }

    public void cGM() {
        this.jvr = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.jvr) {
                this.jvr = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.jvu = true;
                    gVar.jyE.setVisibility(8);
                    gVar.jyF.setVisibility(8);
                    gVar.dRK.setVisibility(8);
                } else {
                    this.jvu = false;
                    gVar.dRK.setVisibility(0);
                    if (this.aao) {
                        gVar.jyE.setVisibility(8);
                        gVar.jyF.setVisibility(0);
                    } else {
                        gVar.jyE.setVisibility(0);
                        gVar.jyF.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.jyD.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.jyD.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.jyD.setForegroundDrawable(0);
                    gVar.jyD.setOnClickListener(null);
                }
                gVar.jyD.setDefaultErrorResource(0);
                gVar.jyD.setTag(Integer.valueOf(i));
                gVar.jyD.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bfo().isShowImages()) {
                    gVar.jyD.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.jyD.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.jyD.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.jyD.setSupportNoImage(true);
                    gVar.jyD.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.jyD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.fTk.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.jyH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.jyG.setVisibility(8);
                        if (gVar.fTk != null) {
                            gVar.fTk.setPlayMode("2");
                        }
                        gVar.fTk.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.fTk.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.fTk != null && gVar.jyE != null) {
                            int curProgress = gVar.jyE.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.fTk.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.jyE;
                                gVar.fTk.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.fTk.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.jyG.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.fTk.setOnErrorListener(this.jvv);
                gVar.fTk.setOnSurfaceDestroyedListener(this.frv);
                gVar.dRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.fTk.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.fTk.pause();
                        gVar.jyI.setVisibility(0);
                    }
                });
                if (this.aao) {
                    gVar.jyF.setPlayer(gVar.fTk);
                } else {
                    gVar.jyE.setPlayer(gVar.fTk);
                }
                if (StringUtils.isNull(oVar.eou)) {
                    gVar.jyK.setVisibility(8);
                    gVar.jyL.setVisibility(8);
                } else {
                    gVar.jyK.setVisibility(0);
                    gVar.jyL.setVisibility(0);
                    gVar.jyK.setText(oVar.eou);
                    gVar.jyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eou, "")));
                        }
                    });
                }
            }
            if (gVar.ajp != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.jyE.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.jyI, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.jyH, R.color.cp_cont_a, 1);
                gVar.jyF.onChangeSkinType(this.mSkinType);
                gVar.jyH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.jyK, R.color.cp_cont_b, 1);
                ap.setBackgroundColor(gVar.jyL, R.color.cp_bg_line_c);
            }
            gVar.ajp = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.AH(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.fTk != null) {
                        gVar.fTk.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).bkJ();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.fTk.start();
        gVar.jyI.setVisibility(8);
        gVar.jyG.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private o jvD;
        private com.baidu.tieba.hottopic.a.g jvE;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.jvD = oVar;
            this.jvE = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jvD != null && this.jvE != null && this.jvE.jyJ != null && this.jvE.fTk != null) {
                if (this.jvE.jyJ.getVisibility() == 0) {
                    this.jvE.fTk.stopPlayback();
                    m.this.jvs = true;
                    m.this.c(this.jvE);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.AH(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cGO();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).bkJ();
                } else {
                    cGO();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cGO() {
            if (this.jvD != null && this.jvE != null && this.jvE.fTk != null) {
                this.jvE.fTk.setPlayMode("2");
                this.jvE.fTk.setVideoPath(this.jvD.videoUrl);
                this.jvE.fTk.start();
                m.this.jvs = false;
                m.this.b(this.jvE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.jyD.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.jyD.startLoad(oVar.picUrl, 17, false);
            }
            gVar.jyD.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.jyD.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.aao) {
                gVar.jyF.initProgress();
            } else {
                gVar.jyE.by(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.aao) {
                gVar.jyF.showProgress();
            } else {
                gVar.jyE.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.jyE != null && gVar.jyF != null) {
            gVar.jyE.aLG();
            gVar.jyF.aLG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jyJ.setVisibility(0);
            gVar.jyD.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jyJ.setVisibility(8);
            if (this.jvu) {
                gVar.jyD.setForegroundDrawable(0);
            } else {
                gVar.jyD.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGN() {
        if (this.jvq != null && this.jvq.fTk != null && this.jvq.jyI != null && this.jvq.jyJ != null) {
            if (this.jvq.fTk.isPlaying()) {
                this.jvq.fTk.pause();
                this.jvq.jyI.setVisibility(0);
            } else if (this.jvq.jyJ.getVisibility() == 0) {
                this.jvq.fTk.stopPlayback();
                this.jvs = true;
                c(this.jvq);
            }
        }
    }
}
