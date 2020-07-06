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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.o;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
/* loaded from: classes8.dex */
public class m extends com.baidu.adp.widget.ListView.a<o, com.baidu.tieba.hottopic.a.g> {
    private boolean Zh;
    private BaseActivity<?> activity;
    private QuickVideoView.b eLi;
    private com.baidu.tieba.hottopic.a.g iCB;
    private boolean iCC;
    private boolean iCD;
    private boolean iCE;
    private boolean iCF;
    private g.b iCG;
    private CustomMessageListener iCH;
    private CustomMessageListener iCI;
    private CustomMessageListener iCJ;
    private CustomMessageListener iCK;
    private Handler mHandler;
    public int mSkinType;
    private View mView;

    public m(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.iCC = false;
        this.iCD = false;
        this.Zh = false;
        this.iCE = false;
        this.iCF = true;
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.hottopic.adapter.m.12
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                if (m.this.iCB != null && m.this.iCB.fnh != null) {
                    m.this.iCB.fnh.stopPlayback();
                }
                m.this.clb();
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.hottopic.adapter.m.13
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (!m.this.iCD && m.this.iCB != null && m.this.iCB.fnh != null && m.this.iCB.iFP != null && m.this.iCB.iFS != null && m.this.iCB.iFU != null) {
                            if (m.this.iCB.fnh.getCurrentPosition() > 0) {
                                m.this.iCB.iFP.setVisibility(8);
                                m.this.iCB.iFS.setVisibility(8);
                                m.this.iCB.iFU.setVisibility(8);
                                m.this.b((o) message.obj, m.this.iCB);
                                m.this.c(m.this.iCB);
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
        this.iCG = new g.b() { // from class: com.baidu.tieba.hottopic.adapter.m.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (!m.this.iCD) {
                    BdToast.a((Context) m.this.activity.getPageContext().getPageActivity(), (CharSequence) m.this.activity.getPageContext().getResources().getString(R.string.pb_play_error), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aUS();
                }
                m.this.clb();
                return true;
            }
        };
        this.iCH = new CustomMessageListener(CmdConfigCustom.PB_PAUSE_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m.this.cld();
            }
        };
        this.iCI = new CustomMessageListener(CmdConfigCustom.PB_REFRESH_VIDEO) { // from class: com.baidu.tieba.hottopic.adapter.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iCB != null && m.this.iCB.iFP != null && m.this.iCB.iFS != null && m.this.iCB.fnh != null) {
                    m.this.iCB.iFP.setVisibility(0);
                    m.this.iCB.iFS.setVisibility(8);
                    m.this.iCB.fnh.stopPlayback();
                    m.this.iCD = true;
                    m.this.c(m.this.iCB);
                }
            }
        };
        this.iCJ = new CustomMessageListener(CmdConfigCustom.PB_ON_SCROLL) { // from class: com.baidu.tieba.hottopic.adapter.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.iCB != null && m.this.iCB.fnh != null) {
                    int[] iArr = new int[2];
                    m.this.iCB.fnh.getLocationInWindow(iArr);
                    if (iArr[1] + m.this.iCB.fnh.getHeight() < 0) {
                    }
                }
            }
        };
        this.iCK = new CustomMessageListener(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY) { // from class: com.baidu.tieba.hottopic.adapter.m.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (m.this.mHandler != null) {
                    m.this.mHandler.removeMessages(1);
                }
                if (m.this.iCB != null && m.this.iCB.iFQ != null && m.this.iCB.iFR != null) {
                    m.this.iCB.iFQ.destroy();
                    m.this.iCB.iFR.destroy();
                }
            }
        };
        this.activity = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.iCH);
            baseActivity.registerListener(this.iCI);
            baseActivity.registerListener(this.iCJ);
            baseActivity.registerListener(this.iCK);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public com.baidu.tieba.hottopic.a.g b(ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.topic_vedio_item, viewGroup, false);
            this.iCB = new com.baidu.tieba.hottopic.a.g(this.mView);
            View findViewById = this.mView.findViewById(R.id.topic_layout_video_view);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
            if (layoutParams != null) {
                layoutParams.height = (int) (equipmentWidth / 1.8d);
                findViewById.setLayoutParams(layoutParams);
            }
        } else {
            clb();
        }
        return this.iCB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clb() {
        if (this.iCB != null && this.iCB.iFP != null && this.iCB.iFS != null) {
            this.iCB.iFP.setVisibility(0);
            this.iCB.iFS.setVisibility(8);
            this.iCD = true;
            c(this.iCB);
            a(this.iCB);
        }
    }

    public void clc() {
        this.iCC = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final o oVar, final com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (!this.iCC) {
                this.iCC = true;
                if (StringUtils.isNull(oVar.videoUrl) || oVar.videoDuration <= 0) {
                    this.iCF = true;
                    gVar.iFQ.setVisibility(8);
                    gVar.iFR.setVisibility(8);
                    gVar.dnJ.setVisibility(8);
                } else {
                    this.iCF = false;
                    gVar.dnJ.setVisibility(0);
                    if (this.Zh) {
                        gVar.iFQ.setVisibility(8);
                        gVar.iFR.setVisibility(0);
                    } else {
                        gVar.iFQ.setVisibility(0);
                        gVar.iFR.setVisibility(8);
                    }
                }
                if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                    gVar.iFP.setForegroundDrawable(R.drawable.icon_play_video);
                    gVar.iFP.setOnClickListener(new a(oVar, gVar));
                } else {
                    gVar.iFP.setForegroundDrawable(0);
                    gVar.iFP.setOnClickListener(null);
                }
                gVar.iFP.setDefaultErrorResource(0);
                gVar.iFP.setTag(Integer.valueOf(i));
                gVar.iFP.setDefaultResource(0);
                if (!com.baidu.tbadk.core.k.aPA().isShowImages()) {
                    gVar.iFP.setNoImageBottomTextColor(R.color.cp_cont_c);
                    gVar.iFP.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                    gVar.iFP.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                    gVar.iFP.setSupportNoImage(true);
                    gVar.iFP.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                } else {
                    gVar.iFP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    if (!gVar.fnh.isPlaying()) {
                        a(oVar, gVar);
                    }
                }
                gVar.iFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        gVar.iFS.setVisibility(8);
                        if (gVar.fnj != null) {
                            gVar.fnj.La("2");
                        }
                        gVar.fnh.start();
                        m.this.b(oVar, gVar);
                    }
                });
                gVar.fnh.setOnPreparedListener(new g.f() { // from class: com.baidu.tieba.hottopic.adapter.m.8
                    @Override // com.baidu.tieba.play.g.f
                    public void onPrepared(com.baidu.tieba.play.g gVar2) {
                        if (gVar != null && gVar.fnh != null && gVar.iFQ != null) {
                            int curProgress = gVar.iFQ.getCurProgress();
                            if (curProgress > 0) {
                                float duration = curProgress * 1.0f * gVar.fnh.getDuration();
                                TopicVideoControllerView topicVideoControllerView = gVar.iFQ;
                                gVar.fnh.seekTo((int) (duration / 10000.0f));
                            }
                            Message obtainMessage = m.this.mHandler.obtainMessage(1);
                            obtainMessage.obj = oVar;
                            m.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
                gVar.fnh.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.hottopic.adapter.m.9
                    @Override // com.baidu.tieba.play.g.a
                    public void onCompletion(com.baidu.tieba.play.g gVar2) {
                        gVar.iFS.setVisibility(0);
                        m.this.a(oVar, gVar);
                    }
                });
                gVar.fnh.setOnErrorListener(this.iCG);
                gVar.fnh.setOnSurfaceDestroyedListener(this.eLi);
                gVar.dnJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!gVar.fnh.isPlaying()) {
                            m.this.a(gVar, oVar);
                            return;
                        }
                        gVar.fnh.pause();
                        gVar.iFU.setVisibility(0);
                    }
                });
                if (this.Zh) {
                    gVar.iFR.setPlayer(gVar.fnh);
                } else {
                    gVar.iFQ.setPlayer(gVar.fnh);
                }
                if (StringUtils.isNull(oVar.dKw)) {
                    gVar.iFW.setVisibility(8);
                    gVar.iFX.setVisibility(8);
                } else {
                    gVar.iFW.setVisibility(0);
                    gVar.iFX.setVisibility(0);
                    gVar.iFW.setText(oVar.dKw);
                    gVar.iFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.m.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            m.this.activity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(m.this.activity.getActivity()).createNormalConfig(String.valueOf(oVar.topicId), oVar.dKw, "")));
                        }
                    });
                }
            }
            if (gVar.ahx != this.mSkinType) {
                an.setBackgroundColor(view, R.color.cp_bg_line_d);
                gVar.iFQ.onChangeSkinType(this.mSkinType);
                an.setImageResource(gVar.iFU, R.drawable.icon_play_video);
                an.setViewTextColor(gVar.iFT, R.color.cp_cont_a, 1);
                gVar.iFR.onChangeSkinType(this.mSkinType);
                gVar.iFT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                an.setViewTextColor(gVar.iFW, R.color.cp_cont_b, 1);
                an.setBackgroundColor(gVar.iFX, R.color.cp_bg_line_c);
            }
            gVar.ahx = this.mSkinType;
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.hottopic.a.g gVar, final o oVar) {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.activity.getPageContext().getPageActivity());
            aVar.we(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (gVar != null && gVar.fnj != null) {
                        gVar.fnj.La("2");
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
            aVar.b(this.activity.getPageContext()).aUN();
            return;
        }
        b(gVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar, o oVar) {
        gVar.fnh.start();
        gVar.iFU.setVisibility(8);
        gVar.iFS.setVisibility(8);
        b(oVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private o iCO;
        private com.baidu.tieba.hottopic.a.g iCP;

        public a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
            this.iCO = oVar;
            this.iCP = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iCO != null && this.iCP != null && this.iCP.iFV != null && this.iCP.fnh != null) {
                if (this.iCP.iFV.getVisibility() == 0) {
                    this.iCP.fnh.stopPlayback();
                    m.this.iCD = true;
                    m.this.c(this.iCP);
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(m.this.activity.getPageContext().getPageActivity());
                    aVar.we(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            a.this.cle();
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.hottopic.adapter.m.a.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(m.this.activity.getPageContext()).aUN();
                } else {
                    cle();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cle() {
            if (this.iCO != null && this.iCP != null && this.iCP.fnh != null && this.iCP.fnj != null) {
                this.iCP.fnj.La("2");
                this.iCP.fnj.cVC();
                this.iCP.fnh.setVideoPath(this.iCO.videoUrl);
                this.iCP.fnh.start();
                m.this.iCD = false;
                m.this.b(this.iCP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null) {
            if (!StringUtils.isNull(oVar.videoUrl) && oVar.videoDuration > 0) {
                gVar.iFP.startLoad(oVar.thumbnailUrl, 17, false);
            } else {
                gVar.iFP.startLoad(oVar.picUrl, 17, false);
            }
            gVar.iFP.setNoImageBottomText("");
            if (!StringUtils.isNull(oVar.thumbnailUrl)) {
                gVar.iFP.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.hottopic.adapter.m.2
                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onComplete(String str, boolean z) {
                    }

                    @Override // com.baidu.tbadk.widget.TbImageView.a
                    public void onCancel() {
                    }
                });
            }
            if (this.Zh) {
                gVar.iFR.initProgress();
            } else {
                gVar.iFQ.bn(0, oVar.videoDuration * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, com.baidu.tieba.hottopic.a.g gVar) {
        if (oVar != null && gVar != null) {
            if (this.Zh) {
                gVar.iFR.showProgress();
            } else {
                gVar.iFQ.showProgress();
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null && gVar.iFQ != null && gVar.iFR != null) {
            gVar.iFQ.axj();
            gVar.iFR.axj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.iFV.setVisibility(0);
            gVar.iFP.setForegroundDrawable(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.hottopic.a.g gVar) {
        if (gVar != null) {
            gVar.iFV.setVisibility(8);
            if (this.iCF) {
                gVar.iFP.setForegroundDrawable(0);
            } else {
                gVar.iFP.setForegroundDrawable(R.drawable.icon_play_video);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cld() {
        if (this.iCB != null && this.iCB.fnh != null && this.iCB.iFU != null && this.iCB.iFV != null) {
            if (this.iCB.fnh.isPlaying()) {
                this.iCB.fnh.pause();
                this.iCB.iFU.setVisibility(0);
            } else if (this.iCB.iFV.getVisibility() == 0) {
                this.iCB.fnh.stopPlayback();
                this.iCD = true;
                c(this.iCB);
            }
        }
    }
}
