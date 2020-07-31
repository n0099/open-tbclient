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
    private com.baidu.tieba.hottopic.a.g iIF;
    private boolean iIG;
    private boolean iIH;
    private boolean iII;
    private boolean iIJ;
    private CyberPlayerManager.OnErrorListener iIK;
    private CustomMessageListener iIL;
    private CustomMessageListener iIM;
    private CustomMessageListener iIN;
    private CustomMessageListener iIO;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iIG = false;
        this.iIH = false;
        this.YX = false;
        this.iII = false;
        this.iIJ = true;
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.iIF != null && m.this.iIF.fsr != null) {
                    m.this.iIF.fsr.stopPlayback();
                }
                m.this.coB();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.iIH && m.this.iIF != null && m.this.iIF.fsr != null && m.this.iIF.iLT != null && m.this.iIF.iLW != null && m.this.iIF.iLY != null) {
                            if (m.this.iIF.fsr.getCurrentPosition() > 0) {
                                m.this.iIF.iLT.setVisibility(8);
                                m.this.iIF.iLW.setVisibility(8);
                                m.this.iIF.iLY.setVisibility(8);
                                m.this.b((o) message.obj, m.this.iIF);
                                m.this.c(m.this.iIF);
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
        this.iIK = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.iIH) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).aYR();
                }
                m.this.coB();
                return true;
            }
        };
        this.iIL = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.coD();
            }
        };
        this.iIM = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iIF != null && m.this.iIF.iLT != null && m.this.iIF.iLW != null && m.this.iIF.fsr != null) {
                    m.this.iIF.iLT.setVisibility(0);
                    m.this.iIF.iLW.setVisibility(8);
                    m.this.iIF.fsr.stopPlayback();
                    m.this.iIH = true;
                    m.this.c(m.this.iIF);
                }
            }
        };
        this.iIN = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iIF != null && m.this.iIF.iMc != null) {
                    int[] iArr = new int[2];
                    m.this.iIF.iMc.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.iIF.iMc.getHeight() < 0) {
                    }
                }
            }
        };
        this.iIO = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.iIF != null && m.this.iIF.iLU != null && m.this.iIF.iLV != null) {
                    m.this.iIF.iLU.destroy();
                    m.this.iIF.iLV.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.iIL);
            baseActivity.registerListener(this.iIM);
            baseActivity.registerListener(this.iIN);
            baseActivity.registerListener(this.iIO);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public com.baidu.tieba.hottopic.a.g b(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.iIF = new com.baidu.tieba.hottopic.a.g(this.mView);
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
        return this.iIF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coB() {
        if (this.iIF != null && this.iIF.iLT != null && this.iIF.iLW != null) {
            this.iIF.iLT.setVisibility(0);
            this.iIF.iLW.setVisibility(8);
            this.iIH = true;
            c(this.iIF);
            a(this.iIF);
        }
    }

    public void coC() {
        this.iIG = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.iIG) {
                this.iIG = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.iIJ = true;
                    gVar.iLU.setVisibility(8);
                    gVar.iLV.setVisibility(8);
                    gVar.dtF.setVisibility(8);
                } else {
                    this.iIJ = false;
                    gVar.dtF.setVisibility(0);
                    if (this.YX) {
                        gVar.iLU.setVisibility(8);
                        gVar.iLV.setVisibility(0);
                    } else {
                        gVar.iLU.setVisibility(0);
                        gVar.iLV.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.iLT.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.iLT.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.iLT.setForegroundDrawable(0);
                    gVar.iLT.setOnClickListener(null);
                }
                gVar.iLT.setDefaultErrorResource(0);
                gVar.iLT.setTag(Integer.valueOf(i));
                gVar.iLT.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.aTv().isShowImages()) {
                    gVar.iLT.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.iLT.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.iLT.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.iLT.setSupportNoImage(true);
                    gVar.iLT.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.iLT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.fsr.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.iLX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.iLW.setVisibility(8);
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
                        if (gVar != null && gVar.fsr != null && gVar.iLU != null) {
                            int curProgress = gVar.iLU.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.fsr.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.iLU;
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
                        gVar.iLW.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.fsr.setOnErrorListener(this.iIK);
                gVar.fsr.setOnSurfaceDestroyedListener(this.eRD);
                gVar.dtF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.fsr.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.fsr.pause();
                        gVar.iLY.setVisibility(0);
                    }
                });
                if (this.YX) {
                    gVar.iLV.setPlayer(gVar.fsr);
                } else {
                    gVar.iLU.setPlayer(gVar.fsr);
                }
                if (StringUtils.isNull(oVar.dQI)) {
                    gVar.iMa.setVisibility(8);
                    gVar.iMb.setVisibility(8);
                } else {
                    gVar.iMa.setVisibility(0);
                    gVar.iMb.setVisibility(0);
                    gVar.iMa.setText(oVar.dQI);
                    gVar.iMa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.dQI, "")));
                        }
                    });
                }
            }
            if (gVar.aho != this.mSkinType) {
                ao.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.iLU.onChangeSkinType(this.mSkinType);
                ao.setImageResource(gVar.iLY, R.drawable.icon_play_video);
                ao.setViewTextColor(gVar.iLX, R.color.cp_cont_a, 1);
                gVar.iLV.onChangeSkinType(this.mSkinType);
                gVar.iLX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ao.setViewTextColor(gVar.iMa, R.color.cp_cont_b, 1);
                ao.setBackgroundColor(gVar.iMb, R.color.cp_bg_line_c);
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
        gVar.iLY.setVisibility(8);
        gVar.iLW.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private o iIS;
        private com.baidu.tieba.hottopic.a.g iIT;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.iIS = oVar;
            this.iIT = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iIS != null && this.iIT != null && this.iIT.iLZ != null && this.iIT.fsr != null) {
                if (this.iIT.iLZ.getVisibility() == 0) {
                    this.iIT.fsr.stopPlayback();
                    m.this.iIH = true;
                    m.this.c(this.iIT);
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
            if (this.iIS != null && this.iIT != null && this.iIT.fsr != null) {
                this.iIT.fsr.setPlayMode("2");
                this.iIT.fsr.setVideoPath(this.iIS.videoUrl);
                this.iIT.fsr.start();
                m.this.iIH = false;
                m.this.b(this.iIT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.iLT.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.iLT.startLoad(oVar.picUrl, 17, false);
            }
            gVar.iLT.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.iLT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.YX) {
                gVar.iLV.initProgress();
            } else {
                gVar.iLU.bq(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.YX) {
                gVar.iLV.showProgress();
            } else {
                gVar.iLU.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.iLU != null && gVar.iLV != null) {
            gVar.iLU.azZ();
            gVar.iLV.azZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.iLZ.setVisibility(0);
            gVar.iLT.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.iLZ.setVisibility(8);
            if (this.iIJ) {
                gVar.iLT.setForegroundDrawable(0);
            } else {
                gVar.iLT.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coD() {
        if (this.iIF != null && this.iIF.fsr != null && this.iIF.iLY != null && this.iIF.iLZ != null) {
            if (this.iIF.fsr.isPlaying()) {
                this.iIF.fsr.pause();
                this.iIF.iLY.setVisibility(0);
            } else if (this.iIF.iLZ.getVisibility() == 0) {
                this.iIF.fsr.stopPlayback();
                this.iIH = true;
                c(this.iIF);
            }
        }
    }
}
