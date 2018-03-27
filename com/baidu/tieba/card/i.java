package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.y;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.m> implements View.OnClickListener {
    private TbPageContext<?> aRI;
    private g.f bPt;
    private g.b bPu;
    private String bQL;
    private View bQq;
    private final View.OnClickListener bdG;
    public ThreadGodReplyLayout cVx;
    private boolean cWA;
    private boolean cWB;
    private TextView cWC;
    private Handler cWD;
    private VideoLoadingProgressView.a cWE;
    private TbImageView.a cWF;
    private Runnable cWG;
    private Runnable cWH;
    private final View.OnClickListener cWI;
    private final View.OnClickListener cWJ;
    private CustomMessageListener cWK;
    private j.a cWL;
    private Animation.AnimationListener cWM;
    private TbImageView cWg;
    private TextView cWh;
    private View cWi;
    public FrameLayout cWn;
    private QuickVideoView cWo;
    private com.baidu.tieba.play.g cWp;
    private TextView cWq;
    private LinearLayout cWr;
    private TextView cWs;
    private View cWt;
    private y cWu;
    private com.baidu.tieba.card.data.m cWv;
    private View cWw;
    private int cWx;
    private int cWy;
    private boolean cWz;
    private ImageView caA;
    private Animation caE;
    private com.baidu.tieba.play.j caQ;
    private com.baidu.tieba.play.n caR;
    private QuickVideoView.b caY;
    private RelativeLayout clY;
    public ThreadUserInfoLayout clZ;
    private HeadPendantClickableView cmL;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    private com.baidu.tieba.NEGFeedBack.c cmm;
    protected LinearLayout cna;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.cWp != null) {
            try {
                this.cWo.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cWD.sendEmptyMessageDelayed(202, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.cWv != null && this.cWv.bZi != null) {
            aa aaVar = new aa();
            aaVar.mLocate = this.cWv.sourceType == 0 ? "index" : "hot_juhe";
            aaVar.bCV = this.cWv.bZi.getTid();
            aaVar.cZL = this.cWv.bZi.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.cWv.bZi.mRecomSource;
            aaVar.gwb = this.cWv.bZi.mRecomAbTag;
            aaVar.gwc = this.cWv.bZi.mRecomWeight;
            aaVar.gwd = "";
            aaVar.aMr = this.cWv.getExtra();
            if (this.cWv.bZi.zF() != null) {
                aaVar.gwf = this.cWv.bZi.zF().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cWv.bZi.zF().video_md5, "", "1", aaVar);
        }
    }

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmm = null;
        this.mSkinType = 3;
        this.cWx = 0;
        this.cWy = 1;
        this.cWz = false;
        this.cWA = true;
        this.cWB = false;
        this.cWD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        i.this.ala();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        i.this.alb();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.card.i.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                i.this.cWp = gVar;
                if (i.this.cWp != null) {
                    i.this.cWp.setVolume(0.0f, 0.0f);
                }
                i.this.cWu.blP();
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.card.i.11
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                i.this.i(true, 4);
                return true;
            }
        };
        this.cWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.i.12
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                i.this.akX();
            }
        };
        this.cWF = new TbImageView.a() { // from class: com.baidu.tieba.card.i.13
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && i.this.cWg != null) {
                    i.this.cWg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cWG = new Runnable() { // from class: com.baidu.tieba.card.i.17
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.cWo != null && !i.this.cWo.isPlaying()) {
                    i.this.i(true, 1);
                }
            }
        };
        this.cWH = new Runnable() { // from class: com.baidu.tieba.card.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.i(true, 4);
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.i.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                i.this.stopPlay();
            }
        };
        this.cWI = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.cWv);
                }
            }
        };
        this.cWJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.cWv);
                }
            }
        };
        this.cWK = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.i.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    i.this.cWB = false;
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.cWv != null) {
                    if (i.this.akP() != null) {
                        i.this.akP().a(view, i.this.cWv);
                    }
                    if (i.this.cWv.bZi != null && view != i.this.cmO.beo) {
                        j.kr(i.this.cWv.bZi.getId());
                        if (!i.this.akT()) {
                            j.a(i.this.mTextTitle, i.this.cWv.bZi.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                            j.a(i.this.cVx.getGodReplyContent(), i.this.cWv.WE().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cWL = new j.a() { // from class: com.baidu.tieba.card.i.8
            @Override // com.baidu.tieba.play.j.a
            public void alf() {
                if (i.this.cWv != null && i.this.cWv.bZi != null && i.this.cWv.bZi.zF() != null) {
                    i.this.akY();
                }
            }
        };
        this.cWM = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.i.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (i.this.cWg != null) {
                    i.this.cWg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aRI = tbPageContext;
        View view = getView();
        this.clY = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cmL = (HeadPendantClickableView) this.clY.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.ds70));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.cWu = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cWu.setLoadingAnimationListener(this.cWE);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.cmm = new com.baidu.tieba.NEGFeedBack.c(akO());
        int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16);
        this.cmm.a(this.clY, t, 0);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.setShareReportFrom(3);
        this.cma.setForumAfterClickListener(this.bdG);
        this.cma.setFrom(1);
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cmO.bep.setOnClickListener(this);
        this.cmO.setFrom(1);
        this.cmO.setShareReportFrom(3);
        this.cmO.setForumAfterClickListener(this.bdG);
        this.cWi = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cWn = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWn.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ao(this.aRI.getPageActivity()) - com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cWn.setLayoutParams(layoutParams2);
        this.cWg = (TbImageView) view.findViewById(d.g.image_video);
        this.cWg.setDefaultErrorResource(0);
        this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWg.setGifIconSupport(false);
        this.cWg.setEvent(this.cWF);
        this.caA = (ImageView) view.findViewById(d.g.image_video_play);
        this.clY.setOnClickListener(this);
        this.cWo = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.caR = new com.baidu.tieba.play.n(this.aRI.getPageActivity());
        this.cWo.setBusiness(this.caR);
        this.cWo.setOnPreparedListener(this.bPt);
        this.cWo.setOnErrorListener(this.bPu);
        this.cWo.setOnSurfaceDestroyedListener(this.caY);
        this.caQ = new com.baidu.tieba.play.j();
        this.caQ.setPlayer(this.cWo);
        this.caQ.a(this.cWL);
        this.cWq = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWr = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cWh = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cWw = view.findViewById(d.g.auto_video_black_mask);
        this.cWs = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cWt = view.findViewById(d.g.auto_video_error_background);
        this.cna = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.caE = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.caE.setAnimationListener(this.cWM);
        this.cVx = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVx.setOnClickListener(this);
        this.bQq = view.findViewById(d.g.divider_line);
        this.cWC = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.cWo.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cWv != null && this.cWv.bZi != null && this.cWv.bZi.aQk > 0) {
            if (akP() != null) {
                akP().a(view, this.cWv);
            }
            this.aRI.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.aRI.getPageActivity(), this.cWv.bZi.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, j.zd(), this.cWv.alC())));
            return;
        }
        if (view == this.clY || view == this.cVx) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cWo) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bB(getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bB(View view) {
        if (akP() != null) {
            akP().a(view, this.cWv);
        }
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.showToast(this.aRI.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
            aVar.dk(this.aRI.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.i.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    i.this.akZ();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.i.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aZ(true);
            aVar.b(this.mTbPageContext).AV();
        } else {
            akZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        if (this.cWv != null && this.cWv.bZi != null && this.cWv.bZi.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cWv.bZi);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.cna.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cna.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRI.getPageActivity(), "index", this.cWv.bZi.getTid(), j.zd(), this.cWv.alC(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bC(View view) {
        if (akP() != null) {
            akP().a(view, this.cWv);
        }
        if (this.cWv != null && this.cWv.bZi != null) {
            if (!akT()) {
                j.kr(this.cWv.bZi.getId());
                j.a(this.mTextTitle, this.cWv.bZi.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aRI.getPageActivity()).createFromThreadCfg(this.cWv.bZi, null, j.zd(), 18003, true, false, false).addLocateParam(this.cWv.alC());
            addLocateParam.setVideo_source(this.cWv.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cWv.bZi.getFid()));
            addLocateParam.setForumName(this.cWv.bZi.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVx) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aRI.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akT() {
        return this.cWv.dac && !this.cWv.daq;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.cWv = mVar;
        refreshView();
        if (mVar != null && mVar.bZi != null) {
            int i = mVar.bZi.aQp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        this.cWD.removeMessages(202);
        if (this.cWo.getCurrentPosition() > 0) {
            i(true, 3);
            this.cWD.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cWD.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cWD.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cWo.getCurrentPosition();
        if (currentPosition != this.cWx) {
            this.cWx = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cWD.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.caA != null && this.cWg != null && this.cWw != null && this.cWu != null && this.cWt != null && this.cWs != null) {
            if (z || this.cWy != i) {
                this.cWy = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWH);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWG);
                if (i == 2) {
                    this.caA.setVisibility(8);
                    this.caE.cancel();
                    this.cWg.clearAnimation();
                    this.cWg.setVisibility(0);
                    this.cWw.setVisibility(0);
                    this.cWr.setVisibility(0);
                    this.cWC.setVisibility(8);
                    this.cWu.startLoading();
                    this.cWt.setVisibility(8);
                    this.cWs.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWH, 60000L);
                } else if (i == 3) {
                    this.caA.setVisibility(8);
                    this.cWg.startAnimation(this.caE);
                    this.cWw.setVisibility(8);
                    this.cWr.setVisibility(8);
                    if (this.cWv != null && this.cWv.WE() != null && this.cWv.WE().aQk > 0) {
                        this.cWC.setVisibility(0);
                    }
                    this.cWu.blQ();
                    this.cWt.setVisibility(8);
                    this.cWs.setVisibility(8);
                } else if (i == 4) {
                    this.caA.setVisibility(8);
                    this.cWg.startAnimation(this.caE);
                    this.cWw.setVisibility(8);
                    this.cWu.blR();
                    this.cWt.setVisibility(0);
                    this.cWs.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWG, 2000L);
                } else {
                    this.caA.setVisibility(0);
                    this.caE.cancel();
                    this.cWg.clearAnimation();
                    this.cWg.setVisibility(0);
                    this.cWw.setVisibility(0);
                    this.cWr.setVisibility(0);
                    this.cWu.blR();
                    this.cWt.setVisibility(8);
                    this.cWs.setVisibility(8);
                }
                if (this.cWv != null && this.cWv.WE() != null && this.cWv.WE().aQk > 0) {
                    this.cWr.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cWv == null || this.cWv.bZi == null || this.cWv.bZi.zn() == null) {
            this.clY.setVisibility(8);
            return;
        }
        this.clY.setVisibility(0);
        ale();
        if (!akT() && j.ks(this.cWv.bZi.getId())) {
            j.a(this.mTextTitle, this.cWv.bZi.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cVx.getGodReplyContent(), this.cWv.WE().getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.cWv.WE().zW();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cWv.WE().zN());
        if (this.cWv.WE().zT() && !StringUtils.isNull(this.cWv.WE().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cWv.WE().getTid();
            spannableStringBuilder.append((CharSequence) this.cWv.WE().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.i.16
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.b.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.clZ.setData(this.cWv.WE());
        this.clZ.setUserAfterClickListener(this.cWI);
        if (this.clZ.getHeaderImg() != null) {
            this.clZ.getHeaderImg().setAfterClickListener(this.cWJ);
            if (this.clZ.getIsSimpleThread()) {
                this.clZ.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (this.cWv.WE() == null || this.cWv.WE().zn() == null || this.cWv.WE().zn().getPendantData() == null || StringUtils.isNull(this.cWv.WE().zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.clZ.getHeaderImg().setVisibility(0);
                if (this.cWv.WE().aQk > 0 && this.cWv.WE().aQl == 0) {
                    this.cWv.WE().zn().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.clZ.getHeaderImg().a(this.cWv.WE(), false);
                } else {
                    this.clZ.getHeaderImg().setData(this.cWv.WE());
                    this.clZ.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(this.cWv.WE());
            }
        }
        this.cWq.setText(am.fV(this.cWv.bZi.zF().video_duration.intValue() * 1000));
        this.cWh.setText(String.format(this.aRI.getResources().getString(d.j.play_count), am.J(this.cWv.bZi.zF().play_count.intValue())));
        if (this.cmm != null && this.cWv.WE() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cWv.WE().getTid());
            ahVar.setFid(this.cWv.WE().getFid());
            ahVar.a(this.cWv.aNh);
            this.cmm.setData(ahVar);
            this.cmm.setFirstRowSingleColumn(true);
            this.cmm.setVisibility(this.cWA ? 0 : 8);
        }
        this.cVx.setGrayScaleMode(this.cWv.WE().AC());
        this.cVx.setData(this.cWv.WE().AA());
        jX(this.cWv.WE().aQp);
        d(this.aRI, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWv.bZi.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
    }

    private void alc() {
        this.cWD.removeMessages(202);
        this.cWD.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void ald() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWG);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWH);
    }

    private void ale() {
        ald();
        alc();
        if (this.cWg != null && this.cWn != null && this.cWo != null) {
            if (com.baidu.tbadk.core.i.xo().xu() && this.cWv != null && this.cWv.bZi != null && this.cWv.bZi.zF() != null) {
                this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWg.startLoad(this.cWv.bZi.zF().thumbnail_url, 10, false);
                this.cWn.setVisibility(0);
                stopPlay();
                this.bQL = this.cWv.bZi.zF().video_url;
                if (StringUtils.isNull(this.cWv.bZi.zF().video_url)) {
                    i(true, 4);
                }
                if (this.caR != null && this.caR.blz() != null) {
                    this.caR.blz().d(this.cWv.bZi.zF());
                    return;
                }
                return;
            }
            this.cWn.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.clY, d.f.addresslist_item_bg);
            aj.c(this.caA, d.f.btn_icon_play_video_n);
            aj.r(this.cWs, d.C0141d.cp_cont_i);
            aj.r(this.cWq, d.C0141d.cp_cont_i);
            aj.r(this.cWh, d.C0141d.cp_cont_i);
            aj.r(this.cWC, d.C0141d.cp_cont_i);
            aj.t(this.cWt, d.C0141d.common_color_10014);
            aj.t(this.bQq, d.C0141d.cp_bg_line_e);
            if (this.cWs != null) {
                this.cWs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cVx.onChangeSkinType();
            if (this.cmm != null) {
                this.cmm.onChangeSkinType();
            }
            this.clZ.onChangeSkinType();
            this.cma.onChangeSkinType();
            this.cmO.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cWK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWK);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.clZ != null) {
            this.clZ.setPageUniqueId(bdUniqueId);
        }
        if (this.cWg != null) {
            this.cWg.setPageId(bdUniqueId);
        }
        if (this.cmm != null) {
            this.cmm.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cWz;
    }

    public boolean isPlaying() {
        if (this.cWo == null) {
            return false;
        }
        return this.cWo.isPlaying();
    }

    public void startPlay() {
        if (!this.cWz && this.cWv != null && this.cWv.bZi != null && this.cWv.bZi.zF() != null && this.cWo != null && com.baidu.tbadk.util.y.p(1, this.bQL)) {
            i(true, 2);
            if (StringUtils.isNull(this.bQL)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "index").ab("tid", this.cWv.tid));
                this.bQL = this.cWv.bZi.zF().video_url;
            }
            this.cWo.bN(this.bQL, this.cWv.tid);
            this.cWo.setLooping(true);
            if (this.caQ != null) {
                this.caQ.start();
            }
            this.cWz = true;
            akY();
        }
    }

    public void stopPlay() {
        ald();
        alc();
        i(true, 1);
        if (this.cWo != null) {
            this.cWo.stopPlayback();
            if (this.caQ != null) {
                this.caQ.stop();
            }
        }
        this.cWz = false;
    }

    public View getVideoContainer() {
        return this.cWn;
    }

    public String getPlayUrl() {
        return this.bQL;
    }

    public int getCurrentPosition() {
        if (this.cWo == null) {
            return 0;
        }
        return this.cWo.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.caR != null) {
            this.caR.setVideoStatsData(aaVar);
        }
    }

    public void a(c.a aVar) {
        if (this.cmm != null) {
            this.cmm.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clZ != null) {
            return this.clZ.bdO;
        }
        return null;
    }

    public View akS() {
        if (this.clZ != null) {
            return this.clZ.bdP;
        }
        return null;
    }

    public void eJ(boolean z) {
        this.cWA = z;
    }

    public void jX(int i) {
        if (this.cWv != null && this.cWv.bZi != null) {
            if (i == 1) {
                if (this.cWv.bZi.aQk > 0) {
                    this.cmO.bep.setShowPraiseNum(false);
                    this.cmO.bep.setShareVisible(false);
                    this.cWC.setText(am.J(this.cWv.bZi.aQk));
                    this.cWC.setVisibility(0);
                } else {
                    this.cmO.bep.setShowPraiseNum(true);
                    this.cmO.bep.setShareVisible(true);
                    this.cWC.setVisibility(8);
                }
                this.cmO.setData(this.cWv.bZi);
                this.cma.setVisibility(8);
                this.clZ.showForumNameView(false);
                return;
            }
            this.cmO.setVisibility(8);
            this.clZ.showForumNameView(true);
            if (this.cWv.bZi.aQk > 0) {
                this.cma.setShowPraiseNum(false);
                this.cma.setShareVisible(false);
                this.cWC.setText(am.J(this.cWv.bZi.aQk));
                this.cWC.setVisibility(0);
            } else {
                this.cma.setShowPraiseNum(true);
                this.cma.setShareVisible(true);
                this.cWC.setVisibility(8);
            }
            if (this.cma.setData(this.cWv.bZi)) {
                this.cWi.setVisibility(8);
            } else {
                this.cWi.setVisibility(0);
            }
        }
    }
}
