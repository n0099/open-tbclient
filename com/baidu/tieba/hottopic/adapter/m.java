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
    private boolean abq;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fMW;
    private com.baidu.tieba.hottopic.a.g kcc;
    private boolean kcd;
    private boolean kce;
    private boolean kcf;
    private boolean kcg;
    private CyberPlayerManager.OnErrorListener kch;
    private CustomMessageListener kci;
    private CustomMessageListener kcj;
    private CustomMessageListener kck;
    private CustomMessageListener kcl;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kcd = false;
        this.kce = false;
        this.abq = false;
        this.kcf = false;
        this.kcg = true;
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.kcc != null && m.this.kcc.gqV != null) {
                    m.this.kcc.gqV.stopPlayback();
                }
                m.this.cRp();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.kce && m.this.kcc != null && m.this.kcc.gqV != null && m.this.kcc.kfp != null && m.this.kcc.kfs != null && m.this.kcc.kfu != null) {
                            if (m.this.kcc.gqV.getCurrentPosition() > 0) {
                                m.this.kcc.kfp.setVisibility(8);
                                m.this.kcc.kfs.setVisibility(8);
                                m.this.kcc.kfu.setVisibility(8);
                                m.this.b((o) message.obj, m.this.kcc);
                                m.this.c(m.this.kcc);
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
        this.kch = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.kce) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).brB();
                }
                m.this.cRp();
                return true;
            }
        };
        this.kci = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cRr();
            }
        };
        this.kcj = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.kcc != null && m.this.kcc.kfp != null && m.this.kcc.kfs != null && m.this.kcc.gqV != null) {
                    m.this.kcc.kfp.setVisibility(0);
                    m.this.kcc.kfs.setVisibility(8);
                    m.this.kcc.gqV.stopPlayback();
                    m.this.kce = true;
                    m.this.c(m.this.kcc);
                }
            }
        };
        this.kck = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.kcc != null && m.this.kcc.kfy != null) {
                    int[] iArr = new int[2];
                    m.this.kcc.kfy.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.kcc.kfy.getHeight() < 0) {
                    }
                }
            }
        };
        this.kcl = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.kcc != null && m.this.kcc.kfq != null && m.this.kcc.kfr != null) {
                    m.this.kcc.kfq.destroy();
                    m.this.kcc.kfr.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.kci);
            baseActivity.registerListener(this.kcj);
            baseActivity.registerListener(this.kck);
            baseActivity.registerListener(this.kcl);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public com.baidu.tieba.hottopic.a.g c(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.kcc = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cRp();
        }
        return this.kcc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRp() {
        if (this.kcc != null && this.kcc.kfp != null && this.kcc.kfs != null) {
            this.kcc.kfp.setVisibility(0);
            this.kcc.kfs.setVisibility(8);
            this.kce = true;
            c(this.kcc);
            a(this.kcc);
        }
    }

    public void cRq() {
        this.kcd = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.kcd) {
                this.kcd = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.kcg = true;
                    gVar.kfq.setVisibility(8);
                    gVar.kfr.setVisibility(8);
                    gVar.elr.setVisibility(8);
                } else {
                    this.kcg = false;
                    gVar.elr.setVisibility(0);
                    if (this.abq) {
                        gVar.kfq.setVisibility(8);
                        gVar.kfr.setVisibility(0);
                    } else {
                        gVar.kfq.setVisibility(0);
                        gVar.kfr.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.kfp.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.kfp.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.kfp.setForegroundDrawable(0);
                    gVar.kfp.setOnClickListener(null);
                }
                gVar.kfp.setDefaultErrorResource(0);
                gVar.kfp.setTag(Integer.valueOf(i));
                gVar.kfp.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.blV().isShowImages()) {
                    gVar.kfp.setNoImageBottomTextColor(R.color.CAM_X0108);
                    gVar.kfp.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.kfp.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.kfp.setSupportNoImage(true);
                    gVar.kfp.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.kfp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.gqV.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.kft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.kfs.setVisibility(8);
                        if (gVar.gqV != null) {
                            gVar.gqV.setPlayMode("2");
                        }
                        gVar.gqV.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.gqV.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.gqV != null && gVar.kfq != null) {
                            int curProgress = gVar.kfq.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.gqV.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.kfq;
                                gVar.gqV.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.gqV.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.kfs.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.gqV.setOnErrorListener(this.kch);
                gVar.gqV.setOnSurfaceDestroyedListener(this.fMW);
                gVar.elr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.gqV.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.gqV.pause();
                        gVar.kfu.setVisibility(0);
                    }
                });
                if (this.abq) {
                    gVar.kfr.setPlayer(gVar.gqV);
                } else {
                    gVar.kfq.setPlayer(gVar.gqV);
                }
                if (StringUtils.isNull(oVar.eIa)) {
                    gVar.kfw.setVisibility(8);
                    gVar.kfx.setVisibility(8);
                } else {
                    gVar.kfw.setVisibility(0);
                    gVar.kfx.setVisibility(0);
                    gVar.kfw.setText(oVar.eIa);
                    gVar.kfw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eIa, "")));
                        }
                    });
                }
            }
            if (gVar.aku != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.CAM_X0201);
                gVar.kfq.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.kfu, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.kft, R.color.CAM_X0101, 1);
                gVar.kfr.onChangeSkinType(this.mSkinType);
                gVar.kft.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.kfw, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(gVar.kfx, R.color.CAM_X0204);
            }
            gVar.aku = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.Bq(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.gqV != null) {
                        gVar.gqV.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).brv();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.gqV.start();
        gVar.kfu.setVisibility(8);
        gVar.kfs.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private o kcp;
        private com.baidu.tieba.hottopic.a.g kcq;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.kcp = oVar;
            this.kcq = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.kcp != null && this.kcq != null && this.kcq.kfv != null && this.kcq.gqV != null) {
                if (this.kcq.kfv.getVisibility() == 0) {
                    this.kcq.gqV.stopPlayback();
                    m.this.kce = true;
                    m.this.c(this.kcq);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.Bq(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cRs();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).brv();
                } else {
                    cRs();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cRs() {
            if (this.kcp != null && this.kcq != null && this.kcq.gqV != null) {
                this.kcq.gqV.setPlayMode("2");
                this.kcq.gqV.setVideoPath(this.kcp.videoUrl);
                this.kcq.gqV.start();
                m.this.kce = false;
                m.this.b(this.kcq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.kfp.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.kfp.startLoad(oVar.picUrl, 17, false);
            }
            gVar.kfp.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.kfp.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.abq) {
                gVar.kfr.initProgress();
            } else {
                gVar.kfq.bB(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.abq) {
                gVar.kfr.showProgress();
            } else {
                gVar.kfq.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.kfq != null && gVar.kfr != null) {
            gVar.kfq.aSx();
            gVar.kfr.aSx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.kfv.setVisibility(0);
            gVar.kfp.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.kfv.setVisibility(8);
            if (this.kcg) {
                gVar.kfp.setForegroundDrawable(0);
            } else {
                gVar.kfp.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRr() {
        if (this.kcc != null && this.kcc.gqV != null && this.kcc.kfu != null && this.kcc.kfv != null) {
            if (this.kcc.gqV.isPlaying()) {
                this.kcc.gqV.pause();
                this.kcc.kfu.setVisibility(0);
            } else if (this.kcc.kfv.getVisibility() == 0) {
                this.kcc.gqV.stopPlayback();
                this.kce = true;
                c(this.kcc);
            }
        }
    }
}
