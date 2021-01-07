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
/* loaded from: classes8.dex */
public class k extends com.baidu.adp.widget.ListView.a<o, TopicMediaHolder> {
    private boolean aca;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fWA;
    private TopicMediaHolder kpo;
    private boolean kpp;
    private boolean kpq;
    private boolean kpr;
    private boolean kps;
    private CyberPlayerManager.OnErrorListener kpt;
    private CustomMessageListener kpu;
    private CustomMessageListener kpv;
    private CustomMessageListener kpw;
    private CustomMessageListener kpx;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kpp = false;
        this.kpq = false;
        this.aca = false;
        this.kpr = false;
        this.kps = true;
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.k.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (k.this.kpo != null && k.this.kpo.gBU != null) {
                    k.this.kpo.gBU.stopPlayback();
                }
                k.this.cUw();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.k.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!k.this.kpq && k.this.kpo != null && k.this.kpo.gBU != null && k.this.kpo.ksB != null && k.this.kpo.ksE != null && k.this.kpo.ksG != null) {
                            if (k.this.kpo.gBU.getCurrentPosition() > 0) {
                                k.this.kpo.ksB.setVisibility(8);
                                k.this.kpo.ksE.setVisibility(8);
                                k.this.kpo.ksG.setVisibility(8);
                                k.this.b((o) message.obj, k.this.kpo);
                                k.this.c(k.this.kpo);
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
        this.kpt = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.k.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!k.this.kpq) {
                    BdToast.b(k.this.activity.getPageContext().getPageActivity(), k.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bue();
                }
                k.this.cUw();
                return true;
            }
        };
        this.kpu = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cUy();
            }
        };
        this.kpv = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kpo != null && k.this.kpo.ksB != null && k.this.kpo.ksE != null && k.this.kpo.gBU != null) {
                    k.this.kpo.ksB.setVisibility(0);
                    k.this.kpo.ksE.setVisibility(8);
                    k.this.kpo.gBU.stopPlayback();
                    k.this.kpq = true;
                    k.this.c(k.this.kpo);
                }
            }
        };
        this.kpw = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kpo != null && k.this.kpo.ksK != null) {
                    int[] iArr = new int[2];
                    k.this.kpo.ksK.getLocationInWindow(iArr);
                    if (iArr[1] + k.this.kpo.ksK.getHeight() < 0) {
                    }
                }
            }
        };
        this.kpx = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.k.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.mHandler != null) {
                    k.this.mHandler.removeMessages(1);
                }
                if (k.this.kpo != null && k.this.kpo.ksC != null && k.this.kpo.ksD != null) {
                    k.this.kpo.ksC.destroy();
                    k.this.kpo.ksD.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.kpu);
            baseActivity.registerListener(this.kpv);
            baseActivity.registerListener(this.kpw);
            baseActivity.registerListener(this.kpx);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public TopicMediaHolder e(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.kpo = new TopicMediaHolder(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cUw();
        }
        return this.kpo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUw() {
        if (this.kpo != null && this.kpo.ksB != null && this.kpo.ksE != null) {
            this.kpo.ksB.setVisibility(0);
            this.kpo.ksE.setVisibility(8);
            this.kpq = true;
            c(this.kpo);
            a(this.kpo);
        }
    }

    public void cUx() {
        this.kpp = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (!this.kpp) {
                this.kpp = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.kps = true;
                    topicMediaHolder.ksC.setVisibility(8);
                    topicMediaHolder.ksD.setVisibility(8);
                    topicMediaHolder.euw.setVisibility(8);
                } else {
                    this.kps = false;
                    topicMediaHolder.euw.setVisibility(0);
                    if (this.aca) {
                        topicMediaHolder.ksC.setVisibility(8);
                        topicMediaHolder.ksD.setVisibility(0);
                    } else {
                        topicMediaHolder.ksC.setVisibility(0);
                        topicMediaHolder.ksD.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    topicMediaHolder.ksB.setForegroundDrawable(R.drawable.icon_play_video);
                    topicMediaHolder.ksB.setOnClickListener(new a(oVar, topicMediaHolder));
                } else {
                    topicMediaHolder.ksB.setForegroundDrawable(0);
                    topicMediaHolder.ksB.setOnClickListener(null);
                }
                topicMediaHolder.ksB.setTag(Integer.valueOf(i));
                topicMediaHolder.ksB.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bov().isShowImages()) {
                    topicMediaHolder.ksB.setNoImageBottomTextColor(R.color.CAM_X0108);
                    topicMediaHolder.ksB.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    topicMediaHolder.ksB.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    topicMediaHolder.ksB.setSupportNoImage(true);
                    topicMediaHolder.ksB.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    topicMediaHolder.ksB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!topicMediaHolder.gBU.isPlaying()) {
                        a(oVar, topicMediaHolder);
                    }
                }
                topicMediaHolder.ksF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        topicMediaHolder.ksE.setVisibility(8);
                        if (topicMediaHolder.gBU != null) {
                            topicMediaHolder.gBU.setPlayMode("2");
                        }
                        topicMediaHolder.gBU.start();
                        k.this.b(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gBU.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.k.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (topicMediaHolder != null && topicMediaHolder.gBU != null && topicMediaHolder.ksC != null) {
                            int curProgress = topicMediaHolder.ksC.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * topicMediaHolder.gBU.getDuration();
                                TopicVideoControllerView topicVideoControllerView = topicMediaHolder.ksC;
                                topicMediaHolder.gBU.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = k.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            k.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                topicMediaHolder.gBU.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.k.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        topicMediaHolder.ksE.setVisibility(0);
                        k.this.a(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gBU.setOnErrorListener(this.kpt);
                topicMediaHolder.gBU.setOnSurfaceDestroyedListener(this.fWA);
                topicMediaHolder.euw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!topicMediaHolder.gBU.isPlaying()) {
                            k.this.a(topicMediaHolder, oVar);
                            return;
                        }
                        topicMediaHolder.gBU.pause();
                        topicMediaHolder.ksG.setVisibility(0);
                    }
                });
                if (this.aca) {
                    topicMediaHolder.ksD.setPlayer(topicMediaHolder.gBU);
                } else {
                    topicMediaHolder.ksC.setPlayer(topicMediaHolder.gBU);
                }
                if (StringUtils.isNull(oVar.eRS)) {
                    topicMediaHolder.ksI.setVisibility(8);
                    topicMediaHolder.ksJ.setVisibility(8);
                } else {
                    topicMediaHolder.ksI.setVisibility(0);
                    topicMediaHolder.ksJ.setVisibility(0);
                    topicMediaHolder.ksI.setText(oVar.eRS);
                    topicMediaHolder.ksI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            k.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(k.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eRS, "")));
                        }
                    });
                }
            }
            if (topicMediaHolder.akW != this.mSkinType) {
                ao.setBackgroundColor(view, R.color.CAM_X0201);
                topicMediaHolder.ksC.onChangeSkinType(this.mSkinType);
                ao.setImageResource(topicMediaHolder.ksG, R.drawable.icon_play_video);
                ao.setViewTextColor(topicMediaHolder.ksF, R.color.CAM_X0101, 1);
                topicMediaHolder.ksD.onChangeSkinType(this.mSkinType);
                topicMediaHolder.ksF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ao.setViewTextColor(topicMediaHolder.ksI, R.color.CAM_X0105, 1);
                ao.setBackgroundColor(topicMediaHolder.ksJ, R.color.CAM_X0204);
            }
            topicMediaHolder.akW = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final TopicMediaHolder topicMediaHolder, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (topicMediaHolder != null && topicMediaHolder.gBU != null) {
                        topicMediaHolder.gBU.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).btY();
            return;
        }
        b(topicMediaHolder, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder, o oVar) {
        topicMediaHolder.gBU.start();
        topicMediaHolder.ksG.setVisibility(8);
        topicMediaHolder.ksE.setVisibility(8);
        b(oVar, topicMediaHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private o kpB;
        private TopicMediaHolder kpC;

        public a(o oVar, TopicMediaHolder topicMediaHolder) {
            this.kpB = oVar;
            this.kpC = topicMediaHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.kpB != null && this.kpC != null && this.kpC.ksH != null && this.kpC.gBU != null) {
                if (this.kpC.ksH.getVisibility() == 0) {
                    this.kpC.gBU.stopPlayback();
                    k.this.kpq = true;
                    k.this.c(this.kpC);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(k.this.activity.getPageContext().getPageActivity());
                    aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cUz();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(k.this.activity.getPageContext()).btY();
                } else {
                    cUz();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cUz() {
            if (this.kpB != null && this.kpC != null && this.kpC.gBU != null) {
                this.kpC.gBU.setPlayMode("2");
                this.kpC.gBU.setVideoPath(this.kpB.videoUrl);
                this.kpC.gBU.start();
                k.this.kpq = false;
                k.this.b(this.kpC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                topicMediaHolder.ksB.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                topicMediaHolder.ksB.startLoad(oVar.picUrl, 17, false);
            }
            topicMediaHolder.ksB.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                topicMediaHolder.ksB.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.hottopic.adapter.k.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                    }
                });
            }
            if (this.aca) {
                topicMediaHolder.ksD.initProgress();
            } else {
                topicMediaHolder.ksC.bz(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (this.aca) {
                topicMediaHolder.ksD.showProgress();
            } else {
                topicMediaHolder.ksC.showProgress();
            }
        }
    }

    private void a(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null && topicMediaHolder.ksC != null && topicMediaHolder.ksD != null) {
            topicMediaHolder.ksC.aUS();
            topicMediaHolder.ksD.aUS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.ksH.setVisibility(0);
            topicMediaHolder.ksB.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.ksH.setVisibility(8);
            if (this.kps) {
                topicMediaHolder.ksB.setForegroundDrawable(0);
            } else {
                topicMediaHolder.ksB.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUy() {
        if (this.kpo != null && this.kpo.gBU != null && this.kpo.ksG != null && this.kpo.ksH != null) {
            if (this.kpo.gBU.isPlaying()) {
                this.kpo.gBU.pause();
                this.kpo.ksG.setVisibility(0);
            } else if (this.kpo.ksH.getVisibility() == 0) {
                this.kpo.gBU.stopPlayback();
                this.kpq = true;
                c(this.kpo);
            }
        }
    }
}
