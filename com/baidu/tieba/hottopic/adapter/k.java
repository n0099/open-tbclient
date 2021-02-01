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
    private TopicMediaHolder ksQ;
    private boolean ksR;
    private boolean ksS;
    private boolean ksT;
    private boolean ksU;
    private CyberPlayerManager.OnErrorListener ksV;
    private CustomMessageListener ksW;
    private CustomMessageListener ksX;
    private CustomMessageListener ksY;
    private CustomMessageListener ksZ;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.ksR = false;
        this.ksS = false;
        this.abT = false;
        this.ksT = false;
        this.ksU = true;
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.k.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (k.this.ksQ != null && k.this.ksQ.gzX != null) {
                    k.this.ksQ.gzX.stopPlayback();
                }
                k.this.cSD();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.k.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!k.this.ksS && k.this.ksQ != null && k.this.ksQ.gzX != null && k.this.ksQ.kwd != null && k.this.ksQ.kwg != null && k.this.ksQ.kwi != null) {
                            if (k.this.ksQ.gzX.getCurrentPosition() > 0) {
                                k.this.ksQ.kwd.setVisibility(8);
                                k.this.ksQ.kwg.setVisibility(8);
                                k.this.ksQ.kwi.setVisibility(8);
                                k.this.b((o) message.obj, k.this.ksQ);
                                k.this.c(k.this.ksQ);
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
        this.ksV = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.k.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!k.this.ksS) {
                    BdToast.b(k.this.activity.getPageContext().getPageActivity(), k.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
                }
                k.this.cSD();
                return true;
            }
        };
        this.ksW = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cSF();
            }
        };
        this.ksX = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.ksQ != null && k.this.ksQ.kwd != null && k.this.ksQ.kwg != null && k.this.ksQ.gzX != null) {
                    k.this.ksQ.kwd.setVisibility(0);
                    k.this.ksQ.kwg.setVisibility(8);
                    k.this.ksQ.gzX.stopPlayback();
                    k.this.ksS = true;
                    k.this.c(k.this.ksQ);
                }
            }
        };
        this.ksY = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.ksQ != null && k.this.ksQ.kwm != null) {
                    int[] iArr = new int[2];
                    k.this.ksQ.kwm.getLocationInWindow(iArr);
                    if (iArr[1] + k.this.ksQ.kwm.getHeight() < 0) {
                    }
                }
            }
        };
        this.ksZ = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.k.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.mHandler != null) {
                    k.this.mHandler.removeMessages(1);
                }
                if (k.this.ksQ != null && k.this.ksQ.kwe != null && k.this.ksQ.kwf != null) {
                    k.this.ksQ.kwe.destroy();
                    k.this.ksQ.kwf.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.ksW);
            baseActivity.registerListener(this.ksX);
            baseActivity.registerListener(this.ksY);
            baseActivity.registerListener(this.ksZ);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public TopicMediaHolder e(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.ksQ = new TopicMediaHolder(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cSD();
        }
        return this.ksQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSD() {
        if (this.ksQ != null && this.ksQ.kwd != null && this.ksQ.kwg != null) {
            this.ksQ.kwd.setVisibility(0);
            this.ksQ.kwg.setVisibility(8);
            this.ksS = true;
            c(this.ksQ);
            a(this.ksQ);
        }
    }

    public void cSE() {
        this.ksR = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (!this.ksR) {
                this.ksR = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.ksU = true;
                    topicMediaHolder.kwe.setVisibility(8);
                    topicMediaHolder.kwf.setVisibility(8);
                    topicMediaHolder.erP.setVisibility(8);
                } else {
                    this.ksU = false;
                    topicMediaHolder.erP.setVisibility(0);
                    if (this.abT) {
                        topicMediaHolder.kwe.setVisibility(8);
                        topicMediaHolder.kwf.setVisibility(0);
                    } else {
                        topicMediaHolder.kwe.setVisibility(0);
                        topicMediaHolder.kwf.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    topicMediaHolder.kwd.setForegroundDrawable(R.drawable.icon_play_video);
                    topicMediaHolder.kwd.setOnClickListener(new a(oVar, topicMediaHolder));
                } else {
                    topicMediaHolder.kwd.setForegroundDrawable(0);
                    topicMediaHolder.kwd.setOnClickListener(null);
                }
                topicMediaHolder.kwd.setTag(Integer.valueOf(i));
                topicMediaHolder.kwd.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bkT().isShowImages()) {
                    topicMediaHolder.kwd.setNoImageBottomTextColor(R.color.CAM_X0108);
                    topicMediaHolder.kwd.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    topicMediaHolder.kwd.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    topicMediaHolder.kwd.setSupportNoImage(true);
                    topicMediaHolder.kwd.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    topicMediaHolder.kwd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!topicMediaHolder.gzX.isPlaying()) {
                        a(oVar, topicMediaHolder);
                    }
                }
                topicMediaHolder.kwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        topicMediaHolder.kwg.setVisibility(8);
                        if (topicMediaHolder.gzX != null) {
                            topicMediaHolder.gzX.setPlayMode("2");
                        }
                        topicMediaHolder.gzX.start();
                        k.this.b(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gzX.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.k.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (topicMediaHolder != null && topicMediaHolder.gzX != null && topicMediaHolder.kwe != null) {
                            int curProgress = topicMediaHolder.kwe.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * topicMediaHolder.gzX.getDuration();
                                TopicVideoControllerView topicVideoControllerView = topicMediaHolder.kwe;
                                topicMediaHolder.gzX.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = k.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            k.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                topicMediaHolder.gzX.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.k.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        topicMediaHolder.kwg.setVisibility(0);
                        k.this.a(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gzX.setOnErrorListener(this.ksV);
                topicMediaHolder.gzX.setOnSurfaceDestroyedListener(this.fUi);
                topicMediaHolder.erP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!topicMediaHolder.gzX.isPlaying()) {
                            k.this.a(topicMediaHolder, oVar);
                            return;
                        }
                        topicMediaHolder.gzX.pause();
                        topicMediaHolder.kwi.setVisibility(0);
                    }
                });
                if (this.abT) {
                    topicMediaHolder.kwf.setPlayer(topicMediaHolder.gzX);
                } else {
                    topicMediaHolder.kwe.setPlayer(topicMediaHolder.gzX);
                }
                if (StringUtils.isNull(oVar.ePt)) {
                    topicMediaHolder.kwk.setVisibility(8);
                    topicMediaHolder.kwl.setVisibility(8);
                } else {
                    topicMediaHolder.kwk.setVisibility(0);
                    topicMediaHolder.kwl.setVisibility(0);
                    topicMediaHolder.kwk.setText(oVar.ePt);
                    topicMediaHolder.kwk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            k.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(k.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.ePt, "")));
                        }
                    });
                }
            }
            if (topicMediaHolder.ajU != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.CAM_X0201);
                topicMediaHolder.kwe.onChangeSkinType(this.mSkinType);
                ap.setImageResource(topicMediaHolder.kwi, R.drawable.icon_play_video);
                ap.setViewTextColor(topicMediaHolder.kwh, R.color.CAM_X0101, 1);
                topicMediaHolder.kwf.onChangeSkinType(this.mSkinType);
                topicMediaHolder.kwh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(topicMediaHolder.kwk, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(topicMediaHolder.kwl, R.color.CAM_X0204);
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
                    if (topicMediaHolder != null && topicMediaHolder.gzX != null) {
                        topicMediaHolder.gzX.setPlayMode("2");
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
        topicMediaHolder.gzX.start();
        topicMediaHolder.kwi.setVisibility(8);
        topicMediaHolder.kwg.setVisibility(8);
        b(oVar, topicMediaHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private o ktd;
        private TopicMediaHolder kte;

        public a(o oVar, TopicMediaHolder topicMediaHolder) {
            this.ktd = oVar;
            this.kte = topicMediaHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ktd != null && this.kte != null && this.kte.kwj != null && this.kte.gzX != null) {
                if (this.kte.kwj.getVisibility() == 0) {
                    this.kte.gzX.stopPlayback();
                    k.this.ksS = true;
                    k.this.c(this.kte);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(k.this.activity.getPageContext().getPageActivity());
                    aVar.Au(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cSG();
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
                    cSG();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cSG() {
            if (this.ktd != null && this.kte != null && this.kte.gzX != null) {
                this.kte.gzX.setPlayMode("2");
                this.kte.gzX.setVideoPath(this.ktd.videoUrl);
                this.kte.gzX.start();
                k.this.ksS = false;
                k.this.b(this.kte);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                topicMediaHolder.kwd.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                topicMediaHolder.kwd.startLoad(oVar.picUrl, 17, false);
            }
            topicMediaHolder.kwd.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                topicMediaHolder.kwd.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.hottopic.adapter.k.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                    }
                });
            }
            if (this.abT) {
                topicMediaHolder.kwf.initProgress();
            } else {
                topicMediaHolder.kwe.bw(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (this.abT) {
                topicMediaHolder.kwf.showProgress();
            } else {
                topicMediaHolder.kwe.showProgress();
            }
        }
    }

    private void a(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null && topicMediaHolder.kwe != null && topicMediaHolder.kwf != null) {
            topicMediaHolder.kwe.aRo();
            topicMediaHolder.kwf.aRo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.kwj.setVisibility(0);
            topicMediaHolder.kwd.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.kwj.setVisibility(8);
            if (this.ksU) {
                topicMediaHolder.kwd.setForegroundDrawable(0);
            } else {
                topicMediaHolder.kwd.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSF() {
        if (this.ksQ != null && this.ksQ.gzX != null && this.ksQ.kwi != null && this.ksQ.kwj != null) {
            if (this.ksQ.gzX.isPlaying()) {
                this.ksQ.gzX.pause();
                this.ksQ.kwi.setVisibility(0);
            } else if (this.ksQ.kwj.getVisibility() == 0) {
                this.ksQ.gzX.stopPlayback();
                this.ksS = true;
                c(this.ksQ);
            }
        }
    }
}
