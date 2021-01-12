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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.o;
import com.baidu.tieba.hottopic.holder.TopicMediaHolder;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes7.dex */
public class k extends com.baidu.adp.widget.ListView.a<o, TopicMediaHolder> {
    private boolean abY;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fRT;
    private TopicMediaHolder kkJ;
    private boolean kkK;
    private boolean kkL;
    private boolean kkM;
    private boolean kkN;
    private CyberPlayerManager.OnErrorListener kkO;
    private CustomMessageListener kkP;
    private CustomMessageListener kkQ;
    private CustomMessageListener kkR;
    private CustomMessageListener kkS;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kkK = false;
        this.kkL = false;
        this.abY = false;
        this.kkM = false;
        this.kkN = true;
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.k.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (k.this.kkJ != null && k.this.kkJ.gxn != null) {
                    k.this.kkJ.gxn.stopPlayback();
                }
                k.this.cQE();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.k.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!k.this.kkL && k.this.kkJ != null && k.this.kkJ.gxn != null && k.this.kkJ.knW != null && k.this.kkJ.knZ != null && k.this.kkJ.kob != null) {
                            if (k.this.kkJ.gxn.getCurrentPosition() > 0) {
                                k.this.kkJ.knW.setVisibility(8);
                                k.this.kkJ.knZ.setVisibility(8);
                                k.this.kkJ.kob.setVisibility(8);
                                k.this.b((o) message.obj, k.this.kkJ);
                                k.this.c(k.this.kkJ);
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
        this.kkO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.k.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!k.this.kkL) {
                    BdToast.b(k.this.activity.getPageContext().getPageActivity(), k.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
                }
                k.this.cQE();
                return true;
            }
        };
        this.kkP = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cQG();
            }
        };
        this.kkQ = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kkJ != null && k.this.kkJ.knW != null && k.this.kkJ.knZ != null && k.this.kkJ.gxn != null) {
                    k.this.kkJ.knW.setVisibility(0);
                    k.this.kkJ.knZ.setVisibility(8);
                    k.this.kkJ.gxn.stopPlayback();
                    k.this.kkL = true;
                    k.this.c(k.this.kkJ);
                }
            }
        };
        this.kkR = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kkJ != null && k.this.kkJ.kof != null) {
                    int[] iArr = new int[2];
                    k.this.kkJ.kof.getLocationInWindow(iArr);
                    if (iArr[1] + k.this.kkJ.kof.getHeight() < 0) {
                    }
                }
            }
        };
        this.kkS = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.k.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.mHandler != null) {
                    k.this.mHandler.removeMessages(1);
                }
                if (k.this.kkJ != null && k.this.kkJ.knX != null && k.this.kkJ.knY != null) {
                    k.this.kkJ.knX.destroy();
                    k.this.kkJ.knY.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.kkP);
            baseActivity.registerListener(this.kkQ);
            baseActivity.registerListener(this.kkR);
            baseActivity.registerListener(this.kkS);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public TopicMediaHolder e(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.kkJ = new TopicMediaHolder(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cQE();
        }
        return this.kkJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQE() {
        if (this.kkJ != null && this.kkJ.knW != null && this.kkJ.knZ != null) {
            this.kkJ.knW.setVisibility(0);
            this.kkJ.knZ.setVisibility(8);
            this.kkL = true;
            c(this.kkJ);
            a(this.kkJ);
        }
    }

    public void cQF() {
        this.kkK = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (!this.kkK) {
                this.kkK = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.kkN = true;
                    topicMediaHolder.knX.setVisibility(8);
                    topicMediaHolder.knY.setVisibility(8);
                    topicMediaHolder.epI.setVisibility(8);
                } else {
                    this.kkN = false;
                    topicMediaHolder.epI.setVisibility(0);
                    if (this.abY) {
                        topicMediaHolder.knX.setVisibility(8);
                        topicMediaHolder.knY.setVisibility(0);
                    } else {
                        topicMediaHolder.knX.setVisibility(0);
                        topicMediaHolder.knY.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    topicMediaHolder.knW.setForegroundDrawable(R.drawable.icon_play_video);
                    topicMediaHolder.knW.setOnClickListener(new a(oVar, topicMediaHolder));
                } else {
                    topicMediaHolder.knW.setForegroundDrawable(0);
                    topicMediaHolder.knW.setOnClickListener(null);
                }
                topicMediaHolder.knW.setTag(Integer.valueOf(i));
                topicMediaHolder.knW.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bkB().isShowImages()) {
                    topicMediaHolder.knW.setNoImageBottomTextColor(R.color.CAM_X0108);
                    topicMediaHolder.knW.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    topicMediaHolder.knW.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    topicMediaHolder.knW.setSupportNoImage(true);
                    topicMediaHolder.knW.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    topicMediaHolder.knW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!topicMediaHolder.gxn.isPlaying()) {
                        a(oVar, topicMediaHolder);
                    }
                }
                topicMediaHolder.koa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        topicMediaHolder.knZ.setVisibility(8);
                        if (topicMediaHolder.gxn != null) {
                            topicMediaHolder.gxn.setPlayMode("2");
                        }
                        topicMediaHolder.gxn.start();
                        k.this.b(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gxn.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.k.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (topicMediaHolder != null && topicMediaHolder.gxn != null && topicMediaHolder.knX != null) {
                            int curProgress = topicMediaHolder.knX.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * topicMediaHolder.gxn.getDuration();
                                TopicVideoControllerView topicVideoControllerView = topicMediaHolder.knX;
                                topicMediaHolder.gxn.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = k.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            k.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                topicMediaHolder.gxn.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.k.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        topicMediaHolder.knZ.setVisibility(0);
                        k.this.a(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gxn.setOnErrorListener(this.kkO);
                topicMediaHolder.gxn.setOnSurfaceDestroyedListener(this.fRT);
                topicMediaHolder.epI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!topicMediaHolder.gxn.isPlaying()) {
                            k.this.a(topicMediaHolder, oVar);
                            return;
                        }
                        topicMediaHolder.gxn.pause();
                        topicMediaHolder.kob.setVisibility(0);
                    }
                });
                if (this.abY) {
                    topicMediaHolder.knY.setPlayer(topicMediaHolder.gxn);
                } else {
                    topicMediaHolder.knX.setPlayer(topicMediaHolder.gxn);
                }
                if (StringUtils.isNull(oVar.eNh)) {
                    topicMediaHolder.kod.setVisibility(8);
                    topicMediaHolder.koe.setVisibility(8);
                } else {
                    topicMediaHolder.kod.setVisibility(0);
                    topicMediaHolder.koe.setVisibility(0);
                    topicMediaHolder.kod.setText(oVar.eNh);
                    topicMediaHolder.kod.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            k.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(k.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eNh, "")));
                        }
                    });
                }
            }
            if (topicMediaHolder.akf != this.mSkinType) {
                ao.setBackgroundColor(view, R.color.CAM_X0201);
                topicMediaHolder.knX.onChangeSkinType(this.mSkinType);
                ao.setImageResource(topicMediaHolder.kob, R.drawable.icon_play_video);
                ao.setViewTextColor(topicMediaHolder.koa, R.color.CAM_X0101, 1);
                topicMediaHolder.knY.onChangeSkinType(this.mSkinType);
                topicMediaHolder.koa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ao.setViewTextColor(topicMediaHolder.kod, R.color.CAM_X0105, 1);
                ao.setBackgroundColor(topicMediaHolder.koe, R.color.CAM_X0204);
            }
            topicMediaHolder.akf = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final TopicMediaHolder topicMediaHolder, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.Ad(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (topicMediaHolder != null && topicMediaHolder.gxn != null) {
                        topicMediaHolder.gxn.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).bqe();
            return;
        }
        b(topicMediaHolder, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder, o oVar) {
        topicMediaHolder.gxn.start();
        topicMediaHolder.kob.setVisibility(8);
        topicMediaHolder.knZ.setVisibility(8);
        b(oVar, topicMediaHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private o kkW;
        private TopicMediaHolder kkX;

        public a(o oVar, TopicMediaHolder topicMediaHolder) {
            this.kkW = oVar;
            this.kkX = topicMediaHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.kkW != null && this.kkX != null && this.kkX.koc != null && this.kkX.gxn != null) {
                if (this.kkX.koc.getVisibility() == 0) {
                    this.kkX.gxn.stopPlayback();
                    k.this.kkL = true;
                    k.this.c(this.kkX);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(k.this.activity.getPageContext().getPageActivity());
                    aVar.Ad(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cQH();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(k.this.activity.getPageContext()).bqe();
                } else {
                    cQH();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cQH() {
            if (this.kkW != null && this.kkX != null && this.kkX.gxn != null) {
                this.kkX.gxn.setPlayMode("2");
                this.kkX.gxn.setVideoPath(this.kkW.videoUrl);
                this.kkX.gxn.start();
                k.this.kkL = false;
                k.this.b(this.kkX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                topicMediaHolder.knW.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                topicMediaHolder.knW.startLoad(oVar.picUrl, 17, false);
            }
            topicMediaHolder.knW.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                topicMediaHolder.knW.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.hottopic.adapter.k.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                    }
                });
            }
            if (this.abY) {
                topicMediaHolder.knY.initProgress();
            } else {
                topicMediaHolder.knX.bz(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (this.abY) {
                topicMediaHolder.knY.showProgress();
            } else {
                topicMediaHolder.knX.showProgress();
            }
        }
    }

    private void a(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null && topicMediaHolder.knX != null && topicMediaHolder.knY != null) {
            topicMediaHolder.knX.aQY();
            topicMediaHolder.knY.aQY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.koc.setVisibility(0);
            topicMediaHolder.knW.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.koc.setVisibility(8);
            if (this.kkN) {
                topicMediaHolder.knW.setForegroundDrawable(0);
            } else {
                topicMediaHolder.knW.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQG() {
        if (this.kkJ != null && this.kkJ.gxn != null && this.kkJ.kob != null && this.kkJ.koc != null) {
            if (this.kkJ.gxn.isPlaying()) {
                this.kkJ.gxn.pause();
                this.kkJ.kob.setVisibility(0);
            } else if (this.kkJ.koc.getVisibility() == 0) {
                this.kkJ.gxn.stopPlayback();
                this.kkL = true;
                c(this.kkJ);
            }
        }
    }
}
