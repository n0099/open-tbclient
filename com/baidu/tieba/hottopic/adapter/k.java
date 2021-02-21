package com.baidu.tieba.hottopic.adapter;

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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.hottopic.holder.TopicMediaHolder;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes8.dex */
public class k extends com.baidu.adp.widget.ListView.a<o, TopicMediaHolder> {
    private boolean abT;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fUi;
    private TopicMediaHolder kte;
    private boolean ktf;
    private boolean ktg;
    private boolean kth;
    private boolean kti;
    private CyberPlayerManager.OnErrorListener ktj;
    private CustomMessageListener ktk;
    private CustomMessageListener ktl;
    private CustomMessageListener ktm;
    private CustomMessageListener ktn;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.ktf = false;
        this.ktg = false;
        this.abT = false;
        this.kth = false;
        this.kti = true;
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.k.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (k.this.kte != null && k.this.kte.gAl != null) {
                    k.this.kte.gAl.stopPlayback();
                }
                k.this.cSK();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.k.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!k.this.ktg && k.this.kte != null && k.this.kte.gAl != null && k.this.kte.kwr != null && k.this.kte.kwu != null && k.this.kte.kww != null) {
                            if (k.this.kte.gAl.getCurrentPosition() > 0) {
                                k.this.kte.kwr.setVisibility(8);
                                k.this.kte.kwu.setVisibility(8);
                                k.this.kte.kww.setVisibility(8);
                                k.this.b((o) message.obj, k.this.kte);
                                k.this.c(k.this.kte);
                                return;
                            }
                            Message obtainMessage = k.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = message.obj;
                            k.this.mHandler.sendMessageDelayed(obtainMessage, 50L);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ktj = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.k.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!k.this.ktg) {
                    BdToast.b(k.this.activity.getPageContext().getPageActivity(), k.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
                }
                k.this.cSK();
                return true;
            }
        };
        this.ktk = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cSM();
            }
        };
        this.ktl = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kte != null && k.this.kte.kwr != null && k.this.kte.kwu != null && k.this.kte.gAl != null) {
                    k.this.kte.kwr.setVisibility(0);
                    k.this.kte.kwu.setVisibility(8);
                    k.this.kte.gAl.stopPlayback();
                    k.this.ktg = true;
                    k.this.c(k.this.kte);
                }
            }
        };
        this.ktm = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kte != null && k.this.kte.kwA != null) {
                    int[] iArr = new int[2];
                    k.this.kte.kwA.getLocationInWindow(iArr);
                    if (iArr[1] + k.this.kte.kwA.getHeight() < 0) {
                    }
                }
            }
        };
        this.ktn = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.k.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.mHandler != null) {
                    k.this.mHandler.removeMessages(1);
                }
                if (k.this.kte != null && k.this.kte.kws != null && k.this.kte.kwt != null) {
                    k.this.kte.kws.destroy();
                    k.this.kte.kwt.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.ktk);
            baseActivity.registerListener(this.ktl);
            baseActivity.registerListener(this.ktm);
            baseActivity.registerListener(this.ktn);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public TopicMediaHolder e(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.kte = new TopicMediaHolder(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cSK();
        }
        return this.kte;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSK() {
        if (this.kte != null && this.kte.kwr != null && this.kte.kwu != null) {
            this.kte.kwr.setVisibility(0);
            this.kte.kwu.setVisibility(8);
            this.ktg = true;
            c(this.kte);
            a(this.kte);
        }
    }

    public void cSL() {
        this.ktf = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (!this.ktf) {
                this.ktf = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.kti = true;
                    topicMediaHolder.kws.setVisibility(8);
                    topicMediaHolder.kwt.setVisibility(8);
                    topicMediaHolder.erP.setVisibility(8);
                } else {
                    this.kti = false;
                    topicMediaHolder.erP.setVisibility(0);
                    if (this.abT) {
                        topicMediaHolder.kws.setVisibility(8);
                        topicMediaHolder.kwt.setVisibility(0);
                    } else {
                        topicMediaHolder.kws.setVisibility(0);
                        topicMediaHolder.kwt.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    topicMediaHolder.kwr.setForegroundDrawable(R.drawable.icon_play_video);
                    topicMediaHolder.kwr.setOnClickListener(new a(oVar, topicMediaHolder));
                } else {
                    topicMediaHolder.kwr.setForegroundDrawable(0);
                    topicMediaHolder.kwr.setOnClickListener(null);
                }
                topicMediaHolder.kwr.setTag(Integer.valueOf(i));
                topicMediaHolder.kwr.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bkT().isShowImages()) {
                    topicMediaHolder.kwr.setNoImageBottomTextColor(R.color.CAM_X0108);
                    topicMediaHolder.kwr.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    topicMediaHolder.kwr.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    topicMediaHolder.kwr.setSupportNoImage(true);
                    topicMediaHolder.kwr.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    topicMediaHolder.kwr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!topicMediaHolder.gAl.isPlaying()) {
                        a(oVar, topicMediaHolder);
                    }
                }
                topicMediaHolder.kwv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        topicMediaHolder.kwu.setVisibility(8);
                        if (topicMediaHolder.gAl != null) {
                            topicMediaHolder.gAl.setPlayMode("2");
                        }
                        topicMediaHolder.gAl.start();
                        k.this.b(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gAl.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.k.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (topicMediaHolder != null && topicMediaHolder.gAl != null && topicMediaHolder.kws != null) {
                            int curProgress = topicMediaHolder.kws.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * topicMediaHolder.gAl.getDuration();
                                TopicVideoControllerView topicVideoControllerView = topicMediaHolder.kws;
                                topicMediaHolder.gAl.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = k.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            k.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                topicMediaHolder.gAl.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.k.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        topicMediaHolder.kwu.setVisibility(0);
                        k.this.a(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gAl.setOnErrorListener(this.ktj);
                topicMediaHolder.gAl.setOnSurfaceDestroyedListener(this.fUi);
                topicMediaHolder.erP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!topicMediaHolder.gAl.isPlaying()) {
                            k.this.a(topicMediaHolder, oVar);
                            return;
                        }
                        topicMediaHolder.gAl.pause();
                        topicMediaHolder.kww.setVisibility(0);
                    }
                });
                if (this.abT) {
                    topicMediaHolder.kwt.setPlayer(topicMediaHolder.gAl);
                } else {
                    topicMediaHolder.kws.setPlayer(topicMediaHolder.gAl);
                }
                if (StringUtils.isNull(oVar.ePt)) {
                    topicMediaHolder.kwy.setVisibility(8);
                    topicMediaHolder.kwz.setVisibility(8);
                } else {
                    topicMediaHolder.kwy.setVisibility(0);
                    topicMediaHolder.kwz.setVisibility(0);
                    topicMediaHolder.kwy.setText(oVar.ePt);
                    topicMediaHolder.kwy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            k.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(k.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.ePt, "")));
                        }
                    });
                }
            }
            if (topicMediaHolder.ajU != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.CAM_X0201);
                topicMediaHolder.kws.onChangeSkinType(this.mSkinType);
                ap.setImageResource(topicMediaHolder.kww, R.drawable.icon_play_video);
                ap.setViewTextColor(topicMediaHolder.kwv, R.color.CAM_X0101, 1);
                topicMediaHolder.kwt.onChangeSkinType(this.mSkinType);
                topicMediaHolder.kwv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(topicMediaHolder.kwy, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(topicMediaHolder.kwz, R.color.CAM_X0204);
            }
            topicMediaHolder.ajU = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final TopicMediaHolder topicMediaHolder, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.Au(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (topicMediaHolder != null && topicMediaHolder.gAl != null) {
                        topicMediaHolder.gAl.setPlayMode("2");
                    }
                    k.this.b(topicMediaHolder, oVar);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.activity.getPageContext()).bqx();
            return;
        }
        b(topicMediaHolder, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder, o oVar) {
        topicMediaHolder.gAl.start();
        topicMediaHolder.kww.setVisibility(8);
        topicMediaHolder.kwu.setVisibility(8);
        b(oVar, topicMediaHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private o ktr;
        private TopicMediaHolder kts;

        public a(o oVar, TopicMediaHolder topicMediaHolder) {
            this.ktr = oVar;
            this.kts = topicMediaHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ktr != null && this.kts != null && this.kts.kwx != null && this.kts.gAl != null) {
                if (this.kts.kwx.getVisibility() == 0) {
                    this.kts.gAl.stopPlayback();
                    k.this.ktg = true;
                    k.this.c(this.kts);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(k.this.activity.getPageContext().getPageActivity());
                    aVar.Au(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cSN();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(k.this.activity.getPageContext()).bqx();
                } else {
                    cSN();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cSN() {
            if (this.ktr != null && this.kts != null && this.kts.gAl != null) {
                this.kts.gAl.setPlayMode("2");
                this.kts.gAl.setVideoPath(this.ktr.videoUrl);
                this.kts.gAl.start();
                k.this.ktg = false;
                k.this.b(this.kts);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                topicMediaHolder.kwr.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                topicMediaHolder.kwr.startLoad(oVar.picUrl, 17, false);
            }
            topicMediaHolder.kwr.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                topicMediaHolder.kwr.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.hottopic.adapter.k.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                    }
                });
            }
            if (this.abT) {
                topicMediaHolder.kwt.initProgress();
            } else {
                topicMediaHolder.kws.bx(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (this.abT) {
                topicMediaHolder.kwt.showProgress();
            } else {
                topicMediaHolder.kws.showProgress();
            }
        }
    }

    private void a(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null && topicMediaHolder.kws != null && topicMediaHolder.kwt != null) {
            topicMediaHolder.kws.aRo();
            topicMediaHolder.kwt.aRo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.kwx.setVisibility(0);
            topicMediaHolder.kwr.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.kwx.setVisibility(8);
            if (this.kti) {
                topicMediaHolder.kwr.setForegroundDrawable(0);
            } else {
                topicMediaHolder.kwr.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSM() {
        if (this.kte != null && this.kte.gAl != null && this.kte.kww != null && this.kte.kwx != null) {
            if (this.kte.gAl.isPlaying()) {
                this.kte.gAl.pause();
                this.kte.kww.setVisibility(0);
            } else if (this.kte.kwx.getVisibility() == 0) {
                this.kte.gAl.stopPlayback();
                this.ktg = true;
                c(this.kte);
            }
        }
    }
}
