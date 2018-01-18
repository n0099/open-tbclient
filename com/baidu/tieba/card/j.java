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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.y;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class j extends a<n> implements View.OnClickListener {
    private TbPageContext<?> aQp;
    private g.f bNn;
    private g.b bNo;
    private String bOE;
    private View bOk;
    private com.baidu.tieba.play.j bYI;
    private com.baidu.tieba.play.n bYJ;
    private QuickVideoView.b bYO;
    private ImageView bYt;
    private Animation bYx;
    private final View.OnClickListener bbR;
    public ThreadGodReplyLayout cSp;
    public ThreadSourceShareAndPraiseLayout cSr;
    private n cTA;
    private View cTB;
    private int cTC;
    private int cTD;
    private boolean cTE;
    private boolean cTF;
    private boolean cTG;
    private TextView cTH;
    private Handler cTI;
    private VideoLoadingProgressView.a cTJ;
    private TbImageView.a cTK;
    private Runnable cTL;
    private Runnable cTM;
    private final View.OnClickListener cTN;
    private final View.OnClickListener cTO;
    private CustomMessageListener cTP;
    private j.a cTQ;
    private Animation.AnimationListener cTR;
    private TbImageView cTl;
    private TextView cTm;
    private View cTn;
    public FrameLayout cTs;
    private QuickVideoView cTt;
    private com.baidu.tieba.play.g cTu;
    private TextView cTv;
    private LinearLayout cTw;
    private TextView cTx;
    private View cTy;
    private y cTz;
    private RelativeLayout ciJ;
    public ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private com.baidu.tieba.NEGFeedBack.c ciW;
    protected LinearLayout cjI;
    private HeadPendantClickableView cju;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        if (this.cTu != null) {
            try {
                this.cTt.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akk() {
        if (this.cTA != null && this.cTA.bXa != null) {
            aa aaVar = new aa();
            aaVar.mLocate = this.cTA.sourceType == 0 ? "index" : "hot_juhe";
            aaVar.bAT = this.cTA.bXa.getTid();
            aaVar.cWM = this.cTA.bXa.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.cTA.bXa.mRecomSource;
            aaVar.gtV = this.cTA.bXa.mRecomAbTag;
            aaVar.gtW = this.cTA.bXa.mRecomWeight;
            aaVar.gtX = "";
            aaVar.aLe = this.cTA.getExtra();
            if (this.cTA.bXa.zk() != null) {
                aaVar.gtZ = this.cTA.bXa.zk().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cTA.bXa.zk().video_md5, "", "1", aaVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciW = null;
        this.mSkinType = 3;
        this.cTC = 0;
        this.cTD = 1;
        this.cTE = false;
        this.cTF = true;
        this.cTG = false;
        this.cTI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case HttpStatus.SC_ACCEPTED /* 202 */:
                        j.this.akm();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        j.this.akn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bNn = new g.f() { // from class: com.baidu.tieba.card.j.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                j.this.cTu = gVar;
                if (j.this.cTu != null) {
                    j.this.cTu.setVolume(0.0f, 0.0f);
                }
                j.this.cTz.bkB();
            }
        };
        this.bNo = new g.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.i(true, 4);
                return true;
            }
        };
        this.cTJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.j.12
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                j.this.akj();
            }
        };
        this.cTK = new TbImageView.a() { // from class: com.baidu.tieba.card.j.13
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && j.this.cTl != null) {
                    j.this.cTl.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cTL = new Runnable() { // from class: com.baidu.tieba.card.j.17
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.cTt != null && !j.this.cTt.isPlaying()) {
                    j.this.i(true, 1);
                }
            }
        };
        this.cTM = new Runnable() { // from class: com.baidu.tieba.card.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.i(true, 4);
            }
        };
        this.bYO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.cTN = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akb() != null) {
                    j.this.akb().a(view, j.this.cTA);
                }
            }
        };
        this.cTO = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akb() != null) {
                    j.this.akb().a(view, j.this.cTA);
                }
            }
        };
        this.cTP = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.cTG = false;
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cTA != null) {
                    if (j.this.akb() != null) {
                        j.this.akb().a(view, j.this.cTA);
                    }
                    if (j.this.cTA.bXa != null) {
                        k.kc(j.this.cTA.bXa.getId());
                        if (!j.this.akf()) {
                            k.a(j.this.mTextTitle, j.this.cTA.bXa.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                            k.a(j.this.cSp.getGodReplyContent(), j.this.cTA.VK().getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cTQ = new j.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tieba.play.j.a
            public void akr() {
                if (j.this.cTA != null && j.this.cTA.bXa != null && j.this.cTA.bXa.zk() != null) {
                    j.this.akk();
                }
            }
        };
        this.cTR = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.cTl != null) {
                    j.this.cTl.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aQp = tbPageContext;
        View view = getView();
        this.ciJ = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cju = (HeadPendantClickableView) this.ciJ.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.ds70));
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.cTz = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cTz.setLoadingAnimationListener(this.cTJ);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.ciW = new com.baidu.tieba.NEGFeedBack.c(aka());
        int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16);
        this.ciW.a(this.ciJ, s, 0);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.setShareReportFrom(3);
        this.ciL.setForumAfterClickListener(this.bbR);
        this.ciL.setFrom(1);
        this.cSr = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cSr.bcA.setOnClickListener(this);
        this.cSr.setFrom(1);
        this.cSr.setShareReportFrom(3);
        this.cSr.setForumAfterClickListener(this.bbR);
        this.cTn = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cTs = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cTs.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ao(this.aQp.getPageActivity()) - com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cTs.setLayoutParams(layoutParams2);
        this.cTl = (TbImageView) view.findViewById(d.g.image_video);
        this.cTl.setDefaultErrorResource(0);
        this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTl.setGifIconSupport(false);
        this.cTl.setEvent(this.cTK);
        this.bYt = (ImageView) view.findViewById(d.g.image_video_play);
        this.ciJ.setOnClickListener(this);
        this.cTt = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bYJ = new com.baidu.tieba.play.n(this.aQp.getPageActivity());
        this.cTt.setBusiness(this.bYJ);
        this.cTt.setOnPreparedListener(this.bNn);
        this.cTt.setOnErrorListener(this.bNo);
        this.cTt.setOnSurfaceDestroyedListener(this.bYO);
        this.bYI = new com.baidu.tieba.play.j();
        this.bYI.setPlayer(this.cTt);
        this.bYI.a(this.cTQ);
        this.cTv = (TextView) view.findViewById(d.g.text_video_duration);
        this.cTw = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cTm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cTB = view.findViewById(d.g.auto_video_black_mask);
        this.cTx = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cTy = view.findViewById(d.g.auto_video_error_background);
        this.cjI = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bYx = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bYx.setAnimationListener(this.cTR);
        this.cSp = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cSp.setOnClickListener(this);
        this.bOk = view.findViewById(d.g.divider_line);
        this.cTH = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.cTt.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cTA != null && this.cTA.bXa != null && this.cTA.bXa.aOX > 0) {
            if (akb() != null) {
                akb().a(view, this.cTA);
            }
            this.aQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.aQp.getPageActivity(), this.cTA.bXa.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, k.yI(), this.cTA.akO())));
            return;
        }
        if (view == this.ciJ || view == this.cSp) {
            bD(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cTt) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bC(getView());
            } else {
                bD(getView());
            }
        }
    }

    private void bC(View view) {
        if (akb() != null) {
            akb().a(view, this.cTA);
        }
        if (!com.baidu.adp.lib.util.j.oI()) {
            com.baidu.adp.lib.util.l.showToast(this.aQp.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQp.getPageActivity());
            aVar.cZ(this.aQp.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.j.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    j.this.akl();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.j.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aV(true);
            aVar.b(this.mTbPageContext).AA();
        } else {
            akl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        if (this.cTA != null && this.cTA.bXa != null && this.cTA.bXa.getId() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQp.getPageActivity(), "index", this.cTA.bXa.getTid(), k.yI(), this.cTA.akO())));
        }
    }

    private void bD(View view) {
        if (akb() != null) {
            akb().a(view, this.cTA);
        }
        if (this.cTA != null && this.cTA.bXa != null) {
            if (!akf()) {
                k.kc(this.cTA.bXa.getId());
                k.a(this.mTextTitle, this.cTA.bXa.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aQp.getPageActivity()).createFromThreadCfg(this.cTA.bXa, null, k.yI(), 18003, true, false, false).addLocateParam(this.cTA.akO());
            addLocateParam.setVideo_source(this.cTA.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cTA.bXa.getFid()));
            addLocateParam.setForumName(this.cTA.bXa.yY());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cSp) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akf() {
        return this.cTA.cXd && !this.cTA.cXr;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.cTA = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akm() {
        this.cTI.removeMessages(HttpStatus.SC_ACCEPTED);
        if (this.cTt.getCurrentPosition() > 0) {
            i(true, 3);
            this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cTI.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cTt.getCurrentPosition();
        if (currentPosition != this.cTC) {
            this.cTC = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bYt != null && this.cTl != null && this.cTB != null && this.cTz != null && this.cTy != null && this.cTx != null) {
            if (z || this.cTD != i) {
                this.cTD = i;
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTM);
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTL);
                if (i == 2) {
                    this.bYt.setVisibility(8);
                    this.bYx.cancel();
                    this.cTl.clearAnimation();
                    this.cTl.setVisibility(0);
                    this.cTB.setVisibility(0);
                    this.cTw.setVisibility(0);
                    this.cTH.setVisibility(8);
                    this.cTz.startLoading();
                    this.cTy.setVisibility(8);
                    this.cTx.setVisibility(8);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cTM, 60000L);
                } else if (i == 3) {
                    this.bYt.setVisibility(8);
                    this.cTl.startAnimation(this.bYx);
                    this.cTB.setVisibility(8);
                    this.cTw.setVisibility(8);
                    if (this.cTA != null && this.cTA.VK() != null && this.cTA.VK().aOX > 0) {
                        this.cTH.setVisibility(0);
                    }
                    this.cTz.bkC();
                    this.cTy.setVisibility(8);
                    this.cTx.setVisibility(8);
                } else if (i == 4) {
                    this.bYt.setVisibility(8);
                    this.cTl.startAnimation(this.bYx);
                    this.cTB.setVisibility(8);
                    this.cTz.bkD();
                    this.cTy.setVisibility(0);
                    this.cTx.setVisibility(0);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cTL, 2000L);
                } else {
                    this.bYt.setVisibility(0);
                    this.bYx.cancel();
                    this.cTl.clearAnimation();
                    this.cTl.setVisibility(0);
                    this.cTB.setVisibility(0);
                    this.cTw.setVisibility(0);
                    this.cTz.bkD();
                    this.cTy.setVisibility(8);
                    this.cTx.setVisibility(8);
                }
                if (this.cTA != null && this.cTA.VK() != null && this.cTA.VK().aOX > 0) {
                    this.cTw.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cTA == null || this.cTA.bXa == null || this.cTA.bXa.yS() == null) {
            this.ciJ.setVisibility(8);
            return;
        }
        this.ciJ.setVisibility(0);
        akq();
        if (!akf() && k.kd(this.cTA.bXa.getId())) {
            k.a(this.mTextTitle, this.cTA.bXa.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            k.a(this.cSp.getGodReplyContent(), this.cTA.VK().getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
        }
        this.cTA.VK().zB();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cTA.VK().zs());
        if (this.cTA.VK().zy() && !StringUtils.isNull(this.cTA.VK().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cTA.VK().getTid();
            spannableStringBuilder.append((CharSequence) this.cTA.VK().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.j.16
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0107d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.ciK.setData(this.cTA.VK());
        this.ciK.setUserAfterClickListener(this.cTN);
        if (this.ciK.getHeaderImg() != null) {
            this.ciK.getHeaderImg().setAfterClickListener(this.cTO);
            if (this.ciK.getIsSimpleThread()) {
                this.ciK.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (this.cTA.VK() == null || this.cTA.VK().yS() == null || this.cTA.VK().yS().getPendantData() == null || StringUtils.isNull(this.cTA.VK().yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ciK.getHeaderImg().setVisibility(0);
                if (this.cTA.VK().aOX > 0 && this.cTA.VK().aOY == 0) {
                    this.cTA.VK().yS().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.ciK.getHeaderImg().a(this.cTA.VK(), false);
                } else {
                    this.ciK.getHeaderImg().setData(this.cTA.VK());
                    this.ciK.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.ciK.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(this.cTA.VK());
            }
        }
        this.cTv.setText(am.fV(this.cTA.bXa.zk().video_duration.intValue() * 1000));
        this.cTm.setText(String.format(this.aQp.getResources().getString(d.j.play_count), am.J(this.cTA.bXa.zk().play_count.intValue())));
        if (this.ciW != null && this.cTA.VK() != null) {
            ah ahVar = new ah();
            ahVar.cK(this.cTA.VK().getTid());
            ahVar.setFid(this.cTA.VK().getFid());
            ahVar.a(this.cTA.aLV);
            this.ciW.setData(ahVar);
            this.ciW.setFirstRowSingleColumn(true);
            this.ciW.setVisibility(this.cTF ? 0 : 8);
        }
        this.cSp.setData(this.cTA.VK().Ag());
        lD(this.cTA.VK().aPa);
        d(this.aQp, TbadkCoreApplication.getInst().getSkinType());
        if (k.kd(this.cTA.bXa.getId())) {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_b, 1);
        }
    }

    private void ako() {
        this.cTI.removeMessages(HttpStatus.SC_ACCEPTED);
        this.cTI.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void akp() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTL);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTM);
    }

    private void akq() {
        akp();
        ako();
        if (this.cTl != null && this.cTs != null && this.cTt != null) {
            if (com.baidu.tbadk.core.i.wA().wG() && this.cTA != null && this.cTA.bXa != null && this.cTA.bXa.zk() != null) {
                this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cTl.startLoad(this.cTA.bXa.zk().thumbnail_url, 10, false);
                this.cTs.setVisibility(0);
                stopPlay();
                this.bOE = this.cTA.bXa.zk().video_url;
                if (StringUtils.isNull(this.cTA.bXa.zk().video_url)) {
                    i(true, 4);
                }
                if (this.bYJ != null && this.bYJ.bkl() != null) {
                    this.bYJ.bkl().d(this.cTA.bXa.zk());
                    return;
                }
                return;
            }
            this.cTs.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciJ, d.f.addresslist_item_bg);
            aj.c(this.bYt, d.f.btn_icon_play_video_n);
            aj.r(this.cTx, d.C0107d.cp_cont_i);
            aj.r(this.cTv, d.C0107d.cp_cont_i);
            aj.r(this.cTm, d.C0107d.cp_cont_i);
            aj.r(this.cTH, d.C0107d.cp_cont_i);
            aj.t(this.cTy, d.C0107d.common_color_10014);
            aj.t(this.bOk, d.C0107d.cp_bg_line_e);
            if (this.cTx != null) {
                this.cTx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cSp.onChangeSkinType();
            if (this.ciW != null) {
                this.ciW.onChangeSkinType();
            }
            this.ciK.onChangeSkinType();
            this.ciL.onChangeSkinType();
            this.cSr.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cTP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTP);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciK != null) {
            this.ciK.setPageUniqueId(bdUniqueId);
        }
        if (this.cTl != null) {
            this.cTl.setPageId(bdUniqueId);
        }
        if (this.ciW != null) {
            this.ciW.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cTE;
    }

    public boolean isPlaying() {
        if (this.cTt == null) {
            return false;
        }
        return this.cTt.isPlaying();
    }

    public void startPlay() {
        if (!this.cTE && this.cTA != null && this.cTA.bXa != null && this.cTA.bXa.zk() != null && this.cTt != null && com.baidu.tbadk.util.y.p(1, this.bOE)) {
            i(true, 2);
            if (StringUtils.isNull(this.bOE)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "index").ab("tid", this.cTA.tid));
                this.bOE = this.cTA.bXa.zk().video_url;
            }
            this.cTt.bO(this.bOE, this.cTA.tid);
            this.cTt.setLooping(true);
            if (this.bYI != null) {
                this.bYI.start();
            }
            this.cTE = true;
            akk();
        }
    }

    public void stopPlay() {
        akp();
        ako();
        i(true, 1);
        if (this.cTt != null) {
            this.cTt.stopPlayback();
            if (this.bYI != null) {
                this.bYI.stop();
            }
        }
        this.cTE = false;
    }

    public View getVideoContainer() {
        return this.cTs;
    }

    public String getPlayUrl() {
        return this.bOE;
    }

    public int getCurrentPosition() {
        if (this.cTt == null) {
            return 0;
        }
        return this.cTt.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.bYJ != null) {
            this.bYJ.setVideoStatsData(aaVar);
        }
    }

    public void a(c.a aVar) {
        if (this.ciW != null) {
            this.ciW.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciK != null) {
            return this.ciK.bbZ;
        }
        return null;
    }

    public View ake() {
        if (this.ciK != null) {
            return this.ciK.bca;
        }
        return null;
    }

    public void eA(boolean z) {
        this.cTF = z;
    }

    public void lD(int i) {
        if (this.cTA != null && this.cTA.bXa != null) {
            if (i == 1) {
                if (this.cTA.bXa.aOX > 0) {
                    this.cSr.bcA.setShowPraiseNum(false);
                    this.cSr.bcA.setShareVisible(false);
                    this.cTH.setText(am.J(this.cTA.bXa.aOX));
                    this.cTH.setVisibility(0);
                } else {
                    this.cSr.bcA.setShowPraiseNum(true);
                    this.cSr.bcA.setShareVisible(true);
                    this.cTH.setVisibility(8);
                }
                this.cSr.setData(this.cTA.bXa);
                this.ciL.setVisibility(8);
                this.ciK.showForumNameView(false);
                return;
            }
            this.cSr.setVisibility(8);
            this.ciK.showForumNameView(true);
            if (this.cTA.bXa.aOX > 0) {
                this.ciL.setShowPraiseNum(false);
                this.ciL.setShareVisible(false);
                this.cTH.setText(am.J(this.cTA.bXa.aOX));
                this.cTH.setVisibility(0);
            } else {
                this.ciL.setShowPraiseNum(true);
                this.ciL.setShareVisible(true);
                this.cTH.setVisibility(8);
            }
            if (this.ciL.setData(this.cTA.bXa)) {
                this.cTn.setVisibility(8);
            } else {
                this.cTn.setVisibility(0);
            }
        }
    }
}
