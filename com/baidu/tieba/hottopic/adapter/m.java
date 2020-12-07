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
    private com.baidu.tieba.hottopic.a.g kca;
    private boolean kcb;
    private boolean kcc;
    private boolean kcd;
    private boolean kce;
    private CyberPlayerManager.OnErrorListener kcf;
    private CustomMessageListener kcg;
    private CustomMessageListener kch;
    private CustomMessageListener kci;
    private CustomMessageListener kcj;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kcb = false;
        this.kcc = false;
        this.abq = false;
        this.kcd = false;
        this.kce = true;
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.kca != null && m.this.kca.gqT != null) {
                    m.this.kca.gqT.stopPlayback();
                }
                m.this.cRo();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.kcc && m.this.kca != null && m.this.kca.gqT != null && m.this.kca.kfn != null && m.this.kca.kfq != null && m.this.kca.kfs != null) {
                            if (m.this.kca.gqT.getCurrentPosition() > 0) {
                                m.this.kca.kfn.setVisibility(8);
                                m.this.kca.kfq.setVisibility(8);
                                m.this.kca.kfs.setVisibility(8);
                                m.this.b((o) message.obj, m.this.kca);
                                m.this.c(m.this.kca);
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
        this.kcf = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.kcc) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).brB();
                }
                m.this.cRo();
                return true;
            }
        };
        this.kcg = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cRq();
            }
        };
        this.kch = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.kca != null && m.this.kca.kfn != null && m.this.kca.kfq != null && m.this.kca.gqT != null) {
                    m.this.kca.kfn.setVisibility(0);
                    m.this.kca.kfq.setVisibility(8);
                    m.this.kca.gqT.stopPlayback();
                    m.this.kcc = true;
                    m.this.c(m.this.kca);
                }
            }
        };
        this.kci = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.kca != null && m.this.kca.kfw != null) {
                    int[] iArr = new int[2];
                    m.this.kca.kfw.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.kca.kfw.getHeight() < 0) {
                    }
                }
            }
        };
        this.kcj = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.kca != null && m.this.kca.kfo != null && m.this.kca.kfp != null) {
                    m.this.kca.kfo.destroy();
                    m.this.kca.kfp.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.kcg);
            baseActivity.registerListener(this.kch);
            baseActivity.registerListener(this.kci);
            baseActivity.registerListener(this.kcj);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public com.baidu.tieba.hottopic.a.g c(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.kca = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cRo();
        }
        return this.kca;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRo() {
        if (this.kca != null && this.kca.kfn != null && this.kca.kfq != null) {
            this.kca.kfn.setVisibility(0);
            this.kca.kfq.setVisibility(8);
            this.kcc = true;
            c(this.kca);
            a(this.kca);
        }
    }

    public void cRp() {
        this.kcb = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.kcb) {
                this.kcb = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.kce = true;
                    gVar.kfo.setVisibility(8);
                    gVar.kfp.setVisibility(8);
                    gVar.elr.setVisibility(8);
                } else {
                    this.kce = false;
                    gVar.elr.setVisibility(0);
                    if (this.abq) {
                        gVar.kfo.setVisibility(8);
                        gVar.kfp.setVisibility(0);
                    } else {
                        gVar.kfo.setVisibility(0);
                        gVar.kfp.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.kfn.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.kfn.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.kfn.setForegroundDrawable(0);
                    gVar.kfn.setOnClickListener(null);
                }
                gVar.kfn.setDefaultErrorResource(0);
                gVar.kfn.setTag(Integer.valueOf(i));
                gVar.kfn.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.blV().isShowImages()) {
                    gVar.kfn.setNoImageBottomTextColor(R.color.CAM_X0108);
                    gVar.kfn.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.kfn.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.kfn.setSupportNoImage(true);
                    gVar.kfn.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.kfn.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.gqT.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.kfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.kfq.setVisibility(8);
                        if (gVar.gqT != null) {
                            gVar.gqT.setPlayMode("2");
                        }
                        gVar.gqT.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.gqT.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.gqT != null && gVar.kfo != null) {
                            int curProgress = gVar.kfo.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.gqT.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.kfo;
                                gVar.gqT.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.gqT.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.kfq.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.gqT.setOnErrorListener(this.kcf);
                gVar.gqT.setOnSurfaceDestroyedListener(this.fMW);
                gVar.elr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.gqT.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.gqT.pause();
                        gVar.kfs.setVisibility(0);
                    }
                });
                if (this.abq) {
                    gVar.kfp.setPlayer(gVar.gqT);
                } else {
                    gVar.kfo.setPlayer(gVar.gqT);
                }
                if (StringUtils.isNull(oVar.eIa)) {
                    gVar.kfu.setVisibility(8);
                    gVar.kfv.setVisibility(8);
                } else {
                    gVar.kfu.setVisibility(0);
                    gVar.kfv.setVisibility(0);
                    gVar.kfu.setText(oVar.eIa);
                    gVar.kfu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eIa, "")));
                        }
                    });
                }
            }
            if (gVar.aku != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.CAM_X0201);
                gVar.kfo.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.kfs, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.kfr, R.color.CAM_X0101, 1);
                gVar.kfp.onChangeSkinType(this.mSkinType);
                gVar.kfr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.kfu, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(gVar.kfv, R.color.CAM_X0204);
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
                    if (gVar != null && gVar.gqT != null) {
                        gVar.gqT.setPlayMode("2");
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
        gVar.gqT.start();
        gVar.kfs.setVisibility(8);
        gVar.kfq.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private o kcn;
        private com.baidu.tieba.hottopic.a.g kco;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.kcn = oVar;
            this.kco = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.kcn != null && this.kco != null && this.kco.kft != null && this.kco.gqT != null) {
                if (this.kco.kft.getVisibility() == 0) {
                    this.kco.gqT.stopPlayback();
                    m.this.kcc = true;
                    m.this.c(this.kco);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.Bq(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cRr();
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
                    cRr();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cRr() {
            if (this.kcn != null && this.kco != null && this.kco.gqT != null) {
                this.kco.gqT.setPlayMode("2");
                this.kco.gqT.setVideoPath(this.kcn.videoUrl);
                this.kco.gqT.start();
                m.this.kcc = false;
                m.this.b(this.kco);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.kfn.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.kfn.startLoad(oVar.picUrl, 17, false);
            }
            gVar.kfn.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.kfn.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.abq) {
                gVar.kfp.initProgress();
            } else {
                gVar.kfo.bB(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.abq) {
                gVar.kfp.showProgress();
            } else {
                gVar.kfo.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.kfo != null && gVar.kfp != null) {
            gVar.kfo.aSx();
            gVar.kfp.aSx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.kft.setVisibility(0);
            gVar.kfn.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.kft.setVisibility(8);
            if (this.kce) {
                gVar.kfn.setForegroundDrawable(0);
            } else {
                gVar.kfn.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRq() {
        if (this.kca != null && this.kca.gqT != null && this.kca.kfs != null && this.kca.kft != null) {
            if (this.kca.gqT.isPlaying()) {
                this.kca.gqT.pause();
                this.kca.kfs.setVisibility(0);
            } else if (this.kca.kft.getVisibility() == 0) {
                this.kca.gqT.stopPlayback();
                this.kcc = true;
                c(this.kca);
            }
        }
    }
}
