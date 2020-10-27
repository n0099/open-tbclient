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
    private boolean aap;
    private BaseActivity<?> activity;
    private TbCyberVideoView.a fzS;
    private com.baidu.tieba.hottopic.a.g jHP;
    private boolean jHQ;
    private boolean jHR;
    private boolean jHS;
    private boolean jHT;
    private CyberPlayerManager.OnErrorListener jHU;
    private CustomMessageListener jHV;
    private CustomMessageListener jHW;
    private CustomMessageListener jHX;
    private CustomMessageListener jHY;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.jHQ = false;
        this.jHR = false;
        this.aap = false;
        this.jHS = false;
        this.jHT = true;
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                if (m.this.jHP != null && m.this.jHP.gdn != null) {
                    m.this.jHP.gdn.stopPlayback();
                }
                m.this.cJS();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.jHR && m.this.jHP != null && m.this.jHP.gdn != null && m.this.jHP.jLc != null && m.this.jHP.jLf != null && m.this.jHP.jLh != null) {
                            if (m.this.jHP.gdn.getCurrentPosition() > 0) {
                                m.this.jHP.jLc.setVisibility(8);
                                m.this.jHP.jLf.setVisibility(8);
                                m.this.jHP.jLh.setVisibility(8);
                                m.this.b((o) message.obj, m.this.jHP);
                                m.this.c(m.this.jHP);
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
        this.jHU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                if (!m.this.jHR) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).bmI();
                }
                m.this.cJS();
                return true;
            }
        };
        this.jHV = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cJU();
            }
        };
        this.jHW = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jHP != null && m.this.jHP.jLc != null && m.this.jHP.jLf != null && m.this.jHP.gdn != null) {
                    m.this.jHP.jLc.setVisibility(0);
                    m.this.jHP.jLf.setVisibility(8);
                    m.this.jHP.gdn.stopPlayback();
                    m.this.jHR = true;
                    m.this.c(m.this.jHP);
                }
            }
        };
        this.jHX = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.jHP != null && m.this.jHP.jLl != null) {
                    int[] iArr = new int[2];
                    m.this.jHP.jLl.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.jHP.jLl.getHeight() < 0) {
                    }
                }
            }
        };
        this.jHY = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.jHP != null && m.this.jHP.jLd != null && m.this.jHP.jLe != null) {
                    m.this.jHP.jLd.destroy();
                    m.this.jHP.jLe.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.jHV);
            baseActivity.registerListener(this.jHW);
            baseActivity.registerListener(this.jHX);
            baseActivity.registerListener(this.jHY);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public com.baidu.tieba.hottopic.a.g c(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.jHP = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            cJS();
        }
        return this.jHP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJS() {
        if (this.jHP != null && this.jHP.jLc != null && this.jHP.jLf != null) {
            this.jHP.jLc.setVisibility(0);
            this.jHP.jLf.setVisibility(8);
            this.jHR = true;
            c(this.jHP);
            a(this.jHP);
        }
    }

    public void cJT() {
        this.jHQ = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.jHQ) {
                this.jHQ = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.jHT = true;
                    gVar.jLd.setVisibility(8);
                    gVar.jLe.setVisibility(8);
                    gVar.eag.setVisibility(8);
                } else {
                    this.jHT = false;
                    gVar.eag.setVisibility(0);
                    if (this.aap) {
                        gVar.jLd.setVisibility(8);
                        gVar.jLe.setVisibility(0);
                    } else {
                        gVar.jLd.setVisibility(0);
                        gVar.jLe.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.jLc.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.jLc.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.jLc.setForegroundDrawable(0);
                    gVar.jLc.setOnClickListener(null);
                }
                gVar.jLc.setDefaultErrorResource(0);
                gVar.jLc.setTag(Integer.valueOf(i));
                gVar.jLc.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.bhh().isShowImages()) {
                    gVar.jLc.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.jLc.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.jLc.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.jLc.setSupportNoImage(true);
                    gVar.jLc.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.jLc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.gdn.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.jLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.jLf.setVisibility(8);
                        if (gVar.gdn != null) {
                            gVar.gdn.setPlayMode("2");
                        }
                        gVar.gdn.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.gdn.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                    public void onPrepared() {
                        if (gVar != null && gVar.gdn != null && gVar.jLd != null) {
                            int curProgress = gVar.jLd.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.gdn.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.jLd;
                                gVar.gdn.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.gdn.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                    public void onCompletion() {
                        gVar.jLf.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.gdn.setOnErrorListener(this.jHU);
                gVar.gdn.setOnSurfaceDestroyedListener(this.fzS);
                gVar.eag.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.gdn.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.gdn.pause();
                        gVar.jLh.setVisibility(0);
                    }
                });
                if (this.aap) {
                    gVar.jLe.setPlayer(gVar.gdn);
                } else {
                    gVar.jLd.setPlayer(gVar.gdn);
                }
                if (StringUtils.isNull(oVar.ewR)) {
                    gVar.jLj.setVisibility(8);
                    gVar.jLk.setVisibility(8);
                } else {
                    gVar.jLj.setVisibility(0);
                    gVar.jLk.setVisibility(0);
                    gVar.jLj.setText(oVar.ewR);
                    gVar.jLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.ewR, "")));
                        }
                    });
                }
            }
            if (gVar.ajq != this.mSkinType) {
                ap.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.jLd.onChangeSkinType(this.mSkinType);
                ap.setImageResource(gVar.jLh, R.drawable.icon_play_video);
                ap.setViewTextColor(gVar.jLg, R.color.cp_cont_a, 1);
                gVar.jLe.onChangeSkinType(this.mSkinType);
                gVar.jLg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                ap.setViewTextColor(gVar.jLj, R.color.cp_cont_b, 1);
                ap.setBackgroundColor(gVar.jLk, R.color.cp_bg_line_c);
            }
            gVar.ajq = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.Ba(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.gdn != null) {
                        gVar.gdn.setPlayMode("2");
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
            aVar.b(this.activity.getPageContext()).bmC();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.gdn.start();
        gVar.jLh.setVisibility(8);
        gVar.jLf.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private o jIc;
        private com.baidu.tieba.hottopic.a.g jId;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.jIc = oVar;
            this.jId = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.jIc != null && this.jId != null && this.jId.jLi != null && this.jId.gdn != null) {
                if (this.jId.jLi.getVisibility() == 0) {
                    this.jId.gdn.stopPlayback();
                    m.this.jHR = true;
                    m.this.c(this.jId);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.Ba(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cJV();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).bmC();
                } else {
                    cJV();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cJV() {
            if (this.jIc != null && this.jId != null && this.jId.gdn != null) {
                this.jId.gdn.setPlayMode("2");
                this.jId.gdn.setVideoPath(this.jIc.videoUrl);
                this.jId.gdn.start();
                m.this.jHR = false;
                m.this.b(this.jId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.jLc.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.jLc.startLoad(oVar.picUrl, 17, false);
            }
            gVar.jLc.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.jLc.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.aap) {
                gVar.jLe.initProgress();
            } else {
                gVar.jLd.bz(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.aap) {
                gVar.jLe.showProgress();
            } else {
                gVar.jLd.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.jLd != null && gVar.jLe != null) {
            gVar.jLd.aNA();
            gVar.jLe.aNA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jLi.setVisibility(0);
            gVar.jLc.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.jLi.setVisibility(8);
            if (this.jHT) {
                gVar.jLc.setForegroundDrawable(0);
            } else {
                gVar.jLc.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJU() {
        if (this.jHP != null && this.jHP.gdn != null && this.jHP.jLh != null && this.jHP.jLi != null) {
            if (this.jHP.gdn.isPlaying()) {
                this.jHP.gdn.pause();
                this.jHP.jLh.setVisibility(0);
            } else if (this.jHP.jLi.getVisibility() == 0) {
                this.jHP.gdn.stopPlayback();
                this.jHR = true;
                c(this.jHP);
            }
        }
    }
}
