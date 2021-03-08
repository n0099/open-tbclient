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
/* loaded from: classes7.dex */
public class k extends com.baidu.adp.widget.ListView.a<o, TopicMediaHolder> {
    private BaseActivity<?> activity;
    private boolean adq;
    private TbCyberVideoView.a fVI;
    private TopicMediaHolder kvg;
    private boolean kvh;
    private boolean kvi;
    private boolean kvj;
    private boolean kvk;
    private CyberPlayerManager.OnErrorListener kvl;
    private CustomMessageListener kvm;
    private CustomMessageListener kvn;
    private CustomMessageListener kvo;
    private CustomMessageListener kvp;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.kvh = false;
        this.kvi = false;
        this.adq = false;
        this.kvj = false;
        this.kvk = true;
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.k.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (k.this.kvg != null && k.this.kvg.gBU != null) {
                    k.this.kvg.gBU.stopPlayback();
                }
                k.this.cSR();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.k.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!k.this.kvi && k.this.kvg != null && k.this.kvg.gBU != null && k.this.kvg.kyt != null && k.this.kvg.kyw != null && k.this.kvg.kyy != null) {
                            if (k.this.kvg.gBU.getCurrentPosition() > 0) {
                                k.this.kvg.kyt.setVisibility(8);
                                k.this.kvg.kyw.setVisibility(8);
                                k.this.kvg.kyy.setVisibility(8);
                                k.this.b((o) message.obj, k.this.kvg);
                                k.this.c(k.this.kvg);
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
        this.kvl = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.k.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!k.this.kvi) {
                    BdToast.b(k.this.activity.getPageContext().getPageActivity(), k.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
                }
                k.this.cSR();
                return true;
            }
        };
        this.kvm = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.cST();
            }
        };
        this.kvn = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.k.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kvg != null && k.this.kvg.kyt != null && k.this.kvg.kyw != null && k.this.kvg.gBU != null) {
                    k.this.kvg.kyt.setVisibility(0);
                    k.this.kvg.kyw.setVisibility(8);
                    k.this.kvg.gBU.stopPlayback();
                    k.this.kvi = true;
                    k.this.c(k.this.kvg);
                }
            }
        };
        this.kvo = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.kvg != null && k.this.kvg.kyC != null) {
                    int[] iArr = new int[2];
                    k.this.kvg.kyC.getLocationInWindow(iArr);
                    if (iArr[1] + k.this.kvg.kyC.getHeight() < 0) {
                    }
                }
            }
        };
        this.kvp = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.k.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.mHandler != null) {
                    k.this.mHandler.removeMessages(1);
                }
                if (k.this.kvg != null && k.this.kvg.kyu != null && k.this.kvg.kyv != null) {
                    k.this.kvg.kyu.destroy();
                    k.this.kvg.kyv.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.kvm);
            baseActivity.registerListener(this.kvn);
            baseActivity.registerListener(this.kvo);
            baseActivity.registerListener(this.kvp);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public TopicMediaHolder e(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.kvg = new TopicMediaHolder(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cSR();
        }
        return this.kvg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSR() {
        if (this.kvg != null && this.kvg.kyt != null && this.kvg.kyw != null) {
            this.kvg.kyt.setVisibility(0);
            this.kvg.kyw.setVisibility(8);
            this.kvi = true;
            c(this.kvg);
            a(this.kvg);
        }
    }

    public void cSS() {
        this.kvh = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (!this.kvh) {
                this.kvh = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.kvk = true;
                    topicMediaHolder.kyu.setVisibility(8);
                    topicMediaHolder.kyv.setVisibility(8);
                    topicMediaHolder.etr.setVisibility(8);
                } else {
                    this.kvk = false;
                    topicMediaHolder.etr.setVisibility(0);
                    if (this.adq) {
                        topicMediaHolder.kyu.setVisibility(8);
                        topicMediaHolder.kyv.setVisibility(0);
                    } else {
                        topicMediaHolder.kyu.setVisibility(0);
                        topicMediaHolder.kyv.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    topicMediaHolder.kyt.setForegroundDrawable(R.drawable.icon_play_video);
                    topicMediaHolder.kyt.setOnClickListener(new a(oVar, topicMediaHolder));
                } else {
                    topicMediaHolder.kyt.setForegroundDrawable(0);
                    topicMediaHolder.kyt.setOnClickListener(null);
                }
                topicMediaHolder.kyt.setTag(Integer.valueOf(i));
                topicMediaHolder.kyt.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bkV().isShowImages()) {
                    topicMediaHolder.kyt.setNoImageBottomTextColor(R.color.CAM_X0108);
                    topicMediaHolder.kyt.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    topicMediaHolder.kyt.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    topicMediaHolder.kyt.setSupportNoImage(true);
                    topicMediaHolder.kyt.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    topicMediaHolder.kyt.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!topicMediaHolder.gBU.isPlaying()) {
                        a(oVar, topicMediaHolder);
                    }
                }
                topicMediaHolder.kyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        topicMediaHolder.kyw.setVisibility(8);
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
                        if (topicMediaHolder != null && topicMediaHolder.gBU != null && topicMediaHolder.kyu != null) {
                            int curProgress = topicMediaHolder.kyu.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * topicMediaHolder.gBU.getDuration();
                                TopicVideoControllerView topicVideoControllerView = topicMediaHolder.kyu;
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
                        topicMediaHolder.kyw.setVisibility(0);
                        k.this.a(oVar, topicMediaHolder);
                    }
                });
                topicMediaHolder.gBU.setOnErrorListener(this.kvl);
                topicMediaHolder.gBU.setOnSurfaceDestroyedListener(this.fVI);
                topicMediaHolder.etr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!topicMediaHolder.gBU.isPlaying()) {
                            k.this.a(topicMediaHolder, oVar);
                            return;
                        }
                        topicMediaHolder.gBU.pause();
                        topicMediaHolder.kyy.setVisibility(0);
                    }
                });
                if (this.adq) {
                    topicMediaHolder.kyv.setPlayer(topicMediaHolder.gBU);
                } else {
                    topicMediaHolder.kyu.setPlayer(topicMediaHolder.gBU);
                }
                if (StringUtils.isNull(oVar.eQU)) {
                    topicMediaHolder.kyA.setVisibility(8);
                    topicMediaHolder.kyB.setVisibility(8);
                } else {
                    topicMediaHolder.kyA.setVisibility(0);
                    topicMediaHolder.kyB.setVisibility(0);
                    topicMediaHolder.kyA.setText(oVar.eQU);
                    topicMediaHolder.kyA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.k.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            k.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(k.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.eQU, "")));
                        }
                    });
                }
            }
            if (topicMediaHolder.aln != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.CAM_X0201);
                topicMediaHolder.kyu.onChangeSkinType(this.mSkinType);
                ap.setImageResource(topicMediaHolder.kyy, R.drawable.icon_play_video);
                ap.setViewTextColor(topicMediaHolder.kyx, R.color.CAM_X0101, 1);
                topicMediaHolder.kyv.onChangeSkinType(this.mSkinType);
                topicMediaHolder.kyx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(topicMediaHolder.kyA, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(topicMediaHolder.kyB, R.color.CAM_X0204);
            }
            topicMediaHolder.aln = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final TopicMediaHolder topicMediaHolder, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.AB(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
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
            aVar.b(this.activity.getPageContext()).bqz();
            return;
        }
        b(topicMediaHolder, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder, o oVar) {
        topicMediaHolder.gBU.start();
        topicMediaHolder.kyy.setVisibility(8);
        topicMediaHolder.kyw.setVisibility(8);
        b(oVar, topicMediaHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private o kvt;
        private TopicMediaHolder kvu;

        public a(o oVar, TopicMediaHolder topicMediaHolder) {
            this.kvt = oVar;
            this.kvu = topicMediaHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.kvt != null && this.kvu != null && this.kvu.kyz != null && this.kvu.gBU != null) {
                if (this.kvu.kyz.getVisibility() == 0) {
                    this.kvu.gBU.stopPlayback();
                    k.this.kvi = true;
                    k.this.c(this.kvu);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(k.this.activity.getPageContext().getPageActivity());
                    aVar.AB(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cSU();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.k.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(k.this.activity.getPageContext()).bqz();
                } else {
                    cSU();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cSU() {
            if (this.kvt != null && this.kvu != null && this.kvu.gBU != null) {
                this.kvu.gBU.setPlayMode("2");
                this.kvu.gBU.setVideoPath(this.kvt.videoUrl);
                this.kvu.gBU.start();
                k.this.kvi = false;
                k.this.b(this.kvu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                topicMediaHolder.kyt.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                topicMediaHolder.kyt.startLoad(oVar.picUrl, 17, false);
            }
            topicMediaHolder.kyt.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                topicMediaHolder.kyt.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.hottopic.adapter.k.2
                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.b
                    public void onCancel() {
                    }
                });
            }
            if (this.adq) {
                topicMediaHolder.kyv.initProgress();
            } else {
                topicMediaHolder.kyu.bx(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, TopicMediaHolder topicMediaHolder) {
        if (oVar != null && topicMediaHolder != null) {
            if (this.adq) {
                topicMediaHolder.kyv.showProgress();
            } else {
                topicMediaHolder.kyu.showProgress();
            }
        }
    }

    private void a(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null && topicMediaHolder.kyu != null && topicMediaHolder.kyv != null) {
            topicMediaHolder.kyu.aRr();
            topicMediaHolder.kyv.aRr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.kyz.setVisibility(0);
            topicMediaHolder.kyt.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TopicMediaHolder topicMediaHolder) {
        if (topicMediaHolder != null) {
            topicMediaHolder.kyz.setVisibility(8);
            if (this.kvk) {
                topicMediaHolder.kyt.setForegroundDrawable(0);
            } else {
                topicMediaHolder.kyt.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        if (this.kvg != null && this.kvg.gBU != null && this.kvg.kyy != null && this.kvg.kyz != null) {
            if (this.kvg.gBU.isPlaying()) {
                this.kvg.gBU.pause();
                this.kvg.kyy.setVisibility(0);
            } else if (this.kvg.kyz.getVisibility() == 0) {
                this.kvg.gBU.stopPlayback();
                this.kvi = true;
                c(this.kvg);
            }
        }
    }
}
