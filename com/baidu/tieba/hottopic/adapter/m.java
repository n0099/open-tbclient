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
    private boolean aau;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fFk;
    private boolean jOA;
    private boolean jOB;
    private CyberPlayerManager.OnErrorListener jOC;
    private CustomMessageListener jOD;
    private CustomMessageListener jOE;
    private CustomMessageListener jOF;
    private CustomMessageListener jOG;
    private com.baidu.tieba.hottopic.a.g jOx;
    private boolean jOy;
    private boolean jOz;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jOy = false;
        this.jOz = false;
        this.aau = false;
        this.jOA = false;
        this.jOB = true;
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.jOx != null && m.this.jOx.giK != null) {
                    m.this.jOx.giK.stopPlayback();
                }
                m.this.cMa();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.jOz && m.this.jOx != null && m.this.jOx.giK != null && m.this.jOx.jRJ != null && m.this.jOx.jRM != null && m.this.jOx.jRO != null) {
                            if (m.this.jOx.giK.getCurrentPosition() > 0) {
                                m.this.jOx.jRJ.setVisibility(8);
                                m.this.jOx.jRM.setVisibility(8);
                                m.this.jOx.jRO.setVisibility(8);
                                m.this.b((o) message.obj, m.this.jOx);
                                m.this.c(m.this.jOx);
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
        this.jOC = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.jOz) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bom();
                }
                m.this.cMa();
                return true;
            }
        };
        this.jOD = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cMc();
            }
        };
        this.jOE = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jOx != null && m.this.jOx.jRJ != null && m.this.jOx.jRM != null && m.this.jOx.giK != null) {
                    m.this.jOx.jRJ.setVisibility(0);
                    m.this.jOx.jRM.setVisibility(8);
                    m.this.jOx.giK.stopPlayback();
                    m.this.jOz = true;
                    m.this.c(m.this.jOx);
                }
            }
        };
        this.jOF = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jOx != null && m.this.jOx.jRS != null) {
                    int[] iArr = new int[2];
                    m.this.jOx.jRS.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.jOx.jRS.getHeight() < 0) {
                    }
                }
            }
        };
        this.jOG = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.jOx != null && m.this.jOx.jRK != null && m.this.jOx.jRL != null) {
                    m.this.jOx.jRK.destroy();
                    m.this.jOx.jRL.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.jOD);
            baseActivity.registerListener(this.jOE);
            baseActivity.registerListener(this.jOF);
            baseActivity.registerListener(this.jOG);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public com.baidu.tieba.hottopic.a.g c(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.jOx = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cMa();
        }
        return this.jOx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMa() {
        if (this.jOx != null && this.jOx.jRJ != null && this.jOx.jRM != null) {
            this.jOx.jRJ.setVisibility(0);
            this.jOx.jRM.setVisibility(8);
            this.jOz = true;
            c(this.jOx);
            a(this.jOx);
        }
    }

    public void cMb() {
        this.jOy = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.jOy) {
                this.jOy = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.jOB = true;
                    gVar.jRK.setVisibility(8);
                    gVar.jRL.setVisibility(8);
                    gVar.eeq.setVisibility(8);
                } else {
                    this.jOB = false;
                    gVar.eeq.setVisibility(0);
                    if (this.aau) {
                        gVar.jRK.setVisibility(8);
                        gVar.jRL.setVisibility(0);
                    } else {
                        gVar.jRK.setVisibility(0);
                        gVar.jRL.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.jRJ.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.jRJ.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.jRJ.setForegroundDrawable(0);
                    gVar.jRJ.setOnClickListener(null);
                }
                gVar.jRJ.setDefaultErrorResource(0);
                gVar.jRJ.setTag(Integer.valueOf(i));
                gVar.jRJ.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.biL().isShowImages()) {
                    gVar.jRJ.setNoImageBottomTextColor(R.color.CAM_X0108);
                    gVar.jRJ.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.jRJ.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.jRJ.setSupportNoImage(true);
                    gVar.jRJ.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.jRJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.giK.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.jRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.jRM.setVisibility(8);
                        if (gVar.giK != null) {
                            gVar.giK.setPlayMode("2");
                        }
                        gVar.giK.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.giK.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.giK != null && gVar.jRK != null) {
                            int curProgress = gVar.jRK.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.giK.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.jRK;
                                gVar.giK.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.giK.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.jRM.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.giK.setOnErrorListener(this.jOC);
                gVar.giK.setOnSurfaceDestroyedListener(this.fFk);
                gVar.eeq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.giK.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.giK.pause();
                        gVar.jRO.setVisibility(0);
                    }
                });
                if (this.aau) {
                    gVar.jRL.setPlayer(gVar.giK);
                } else {
                    gVar.jRK.setPlayer(gVar.giK);
                }
                if (StringUtils.isNull(oVar.eBa)) {
                    gVar.jRQ.setVisibility(8);
                    gVar.jRR.setVisibility(8);
                } else {
                    gVar.jRQ.setVisibility(0);
                    gVar.jRR.setVisibility(0);
                    gVar.jRQ.setText(oVar.eBa);
                    gVar.jRQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eBa, "")));
                        }
                    });
                }
            }
            if (gVar.ajv != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.CAM_X0201);
                gVar.jRK.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.jRO, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.jRN, R.color.CAM_X0101, 1);
                gVar.jRL.onChangeSkinType(this.mSkinType);
                gVar.jRN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.jRQ, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(gVar.jRR, R.color.CAM_X0204);
            }
            gVar.ajv = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.AJ(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.giK != null) {
                        gVar.giK.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).bog();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.giK.start();
        gVar.jRO.setVisibility(8);
        gVar.jRM.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private o jOK;
        private com.baidu.tieba.hottopic.a.g jOL;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.jOK = oVar;
            this.jOL = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jOK != null && this.jOL != null && this.jOL.jRP != null && this.jOL.giK != null) {
                if (this.jOL.jRP.getVisibility() == 0) {
                    this.jOL.giK.stopPlayback();
                    m.this.jOz = true;
                    m.this.c(this.jOL);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.AJ(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cMd();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).bog();
                } else {
                    cMd();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cMd() {
            if (this.jOK != null && this.jOL != null && this.jOL.giK != null) {
                this.jOL.giK.setPlayMode("2");
                this.jOL.giK.setVideoPath(this.jOK.videoUrl);
                this.jOL.giK.start();
                m.this.jOz = false;
                m.this.b(this.jOL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.jRJ.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.jRJ.startLoad(oVar.picUrl, 17, false);
            }
            gVar.jRJ.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.jRJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.aau) {
                gVar.jRL.initProgress();
            } else {
                gVar.jRK.bz(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.aau) {
                gVar.jRL.showProgress();
            } else {
                gVar.jRK.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.jRK != null && gVar.jRL != null) {
            gVar.jRK.aPs();
            gVar.jRL.aPs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jRP.setVisibility(0);
            gVar.jRJ.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jRP.setVisibility(8);
            if (this.jOB) {
                gVar.jRJ.setForegroundDrawable(0);
            } else {
                gVar.jRJ.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMc() {
        if (this.jOx != null && this.jOx.giK != null && this.jOx.jRO != null && this.jOx.jRP != null) {
            if (this.jOx.giK.isPlaying()) {
                this.jOx.giK.pause();
                this.jOx.jRO.setVisibility(0);
            } else if (this.jOx.jRP.getVisibility() == 0) {
                this.jOx.giK.stopPlayback();
                this.jOz = true;
                c(this.jOx);
            }
        }
    }
}
