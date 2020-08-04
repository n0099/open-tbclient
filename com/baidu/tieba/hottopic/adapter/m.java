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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.o;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes15.dex */
public class m extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.hottopic.a.g> {
    private boolean YX;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a eRD;
    private com.baidu.tieba.hottopic.a.g iIH;
    private boolean iII;
    private boolean iIJ;
    private boolean iIK;
    private boolean iIL;
    private CyberPlayerManager.OnErrorListener iIM;
    private CustomMessageListener iIN;
    private CustomMessageListener iIO;
    private CustomMessageListener iIP;
    private CustomMessageListener iIQ;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iII = false;
        this.iIJ = false;
        this.YX = false;
        this.iIK = false;
        this.iIL = true;
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.iIH != null && m.this.iIH.fsr != null) {
                    m.this.iIH.fsr.stopPlayback();
                }
                m.this.coB();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.iIJ && m.this.iIH != null && m.this.iIH.fsr != null && m.this.iIH.iLV != null && m.this.iIH.iLY != null && m.this.iIH.iMa != null) {
                            if (m.this.iIH.fsr.getCurrentPosition() > 0) {
                                m.this.iIH.iLV.setVisibility(8);
                                m.this.iIH.iLY.setVisibility(8);
                                m.this.iIH.iMa.setVisibility(8);
                                m.this.b((o) message.obj, m.this.iIH);
                                m.this.c(m.this.iIH);
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
        this.iIM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.iIJ) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).aYR();
                }
                m.this.coB();
                return true;
            }
        };
        this.iIN = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.coD();
            }
        };
        this.iIO = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iIH != null && m.this.iIH.iLV != null && m.this.iIH.iLY != null && m.this.iIH.fsr != null) {
                    m.this.iIH.iLV.setVisibility(0);
                    m.this.iIH.iLY.setVisibility(8);
                    m.this.iIH.fsr.stopPlayback();
                    m.this.iIJ = true;
                    m.this.c(m.this.iIH);
                }
            }
        };
        this.iIP = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iIH != null && m.this.iIH.iMe != null) {
                    int[] iArr = new int[2];
                    m.this.iIH.iMe.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.iIH.iMe.getHeight() < 0) {
                    }
                }
            }
        };
        this.iIQ = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.iIH != null && m.this.iIH.iLW != null && m.this.iIH.iLX != null) {
                    m.this.iIH.iLW.destroy();
                    m.this.iIH.iLX.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.iIN);
            baseActivity.registerListener(this.iIO);
            baseActivity.registerListener(this.iIP);
            baseActivity.registerListener(this.iIQ);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public com.baidu.tieba.hottopic.a.g b(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.iIH = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            coB();
        }
        return this.iIH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coB() {
        if (this.iIH != null && this.iIH.iLV != null && this.iIH.iLY != null) {
            this.iIH.iLV.setVisibility(0);
            this.iIH.iLY.setVisibility(8);
            this.iIJ = true;
            c(this.iIH);
            a(this.iIH);
        }
    }

    public void coC() {
        this.iII = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.iII) {
                this.iII = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.iIL = true;
                    gVar.iLW.setVisibility(8);
                    gVar.iLX.setVisibility(8);
                    gVar.dtF.setVisibility(8);
                } else {
                    this.iIL = false;
                    gVar.dtF.setVisibility(0);
                    if (this.YX) {
                        gVar.iLW.setVisibility(8);
                        gVar.iLX.setVisibility(0);
                    } else {
                        gVar.iLW.setVisibility(0);
                        gVar.iLX.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.iLV.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.iLV.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.iLV.setForegroundDrawable(0);
                    gVar.iLV.setOnClickListener(null);
                }
                gVar.iLV.setDefaultErrorResource(0);
                gVar.iLV.setTag(Integer.valueOf(i));
                gVar.iLV.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.aTv().isShowImages()) {
                    gVar.iLV.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.iLV.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.iLV.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.iLV.setSupportNoImage(true);
                    gVar.iLV.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.iLV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.fsr.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.iLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.iLY.setVisibility(8);
                        if (gVar.fsr != null) {
                            gVar.fsr.setPlayMode("2");
                        }
                        gVar.fsr.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.fsr.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.fsr != null && gVar.iLW != null) {
                            int curProgress = gVar.iLW.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.fsr.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.iLW;
                                gVar.fsr.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.fsr.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.iLY.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.fsr.setOnErrorListener(this.iIM);
                gVar.fsr.setOnSurfaceDestroyedListener(this.eRD);
                gVar.dtF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.fsr.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.fsr.pause();
                        gVar.iMa.setVisibility(0);
                    }
                });
                if (this.YX) {
                    gVar.iLX.setPlayer(gVar.fsr);
                } else {
                    gVar.iLW.setPlayer(gVar.fsr);
                }
                if (StringUtils.isNull(oVar.dQI)) {
                    gVar.iMc.setVisibility(8);
                    gVar.iMd.setVisibility(8);
                } else {
                    gVar.iMc.setVisibility(0);
                    gVar.iMd.setVisibility(0);
                    gVar.iMc.setText(oVar.dQI);
                    gVar.iMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.dQI, "")));
                        }
                    });
                }
            }
            if (gVar.aho != this.mSkinType) {
                ao.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.iLW.onChangeSkinType(this.mSkinType);
                ao.setImageResource(gVar.iMa, R.drawable.icon_play_video);
                ao.setViewTextColor(gVar.iLZ, R.color.cp_cont_a, 1);
                gVar.iLX.onChangeSkinType(this.mSkinType);
                gVar.iLZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ao.setViewTextColor(gVar.iMc, R.color.cp_cont_b, 1);
                ao.setBackgroundColor(gVar.iMd, R.color.cp_bg_line_c);
            }
            gVar.aho = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.xl(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.fsr != null) {
                        gVar.fsr.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).aYL();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.fsr.start();
        gVar.iMa.setVisibility(8);
        gVar.iLY.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private o iIU;
        private com.baidu.tieba.hottopic.a.g iIV;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.iIU = oVar;
            this.iIV = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iIU != null && this.iIV != null && this.iIV.iMb != null && this.iIV.fsr != null) {
                if (this.iIV.iMb.getVisibility() == 0) {
                    this.iIV.fsr.stopPlayback();
                    m.this.iIJ = true;
                    m.this.c(this.iIV);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.xl(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.coE();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).aYL();
                } else {
                    coE();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void coE() {
            if (this.iIU != null && this.iIV != null && this.iIV.fsr != null) {
                this.iIV.fsr.setPlayMode("2");
                this.iIV.fsr.setVideoPath(this.iIU.videoUrl);
                this.iIV.fsr.start();
                m.this.iIJ = false;
                m.this.b(this.iIV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.iLV.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.iLV.startLoad(oVar.picUrl, 17, false);
            }
            gVar.iLV.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.iLV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.YX) {
                gVar.iLX.initProgress();
            } else {
                gVar.iLW.bq(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.YX) {
                gVar.iLX.showProgress();
            } else {
                gVar.iLW.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.iLW != null && gVar.iLX != null) {
            gVar.iLW.azZ();
            gVar.iLX.azZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.iMb.setVisibility(0);
            gVar.iLV.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.iMb.setVisibility(8);
            if (this.iIL) {
                gVar.iLV.setForegroundDrawable(0);
            } else {
                gVar.iLV.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coD() {
        if (this.iIH != null && this.iIH.fsr != null && this.iIH.iMa != null && this.iIH.iMb != null) {
            if (this.iIH.fsr.isPlaying()) {
                this.iIH.fsr.pause();
                this.iIH.iMa.setVisibility(0);
            } else if (this.iIH.iMb.getVisibility() == 0) {
                this.iIH.fsr.stopPlayback();
                this.iIJ = true;
                c(this.iIH);
            }
        }
    }
}
