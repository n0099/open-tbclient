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
    private TbPageContext<?> aQs;
    private g.f bNv;
    private g.b bNw;
    private String bON;
    private View bOs;
    private ImageView bYB;
    private Animation bYF;
    private com.baidu.tieba.play.j bYQ;
    private com.baidu.tieba.play.n bYR;
    private QuickVideoView.b bYW;
    private final View.OnClickListener bbZ;
    public ThreadGodReplyLayout cSK;
    public ThreadSourceShareAndPraiseLayout cSM;
    private TbImageView cTG;
    private TextView cTH;
    private View cTI;
    public FrameLayout cTN;
    private QuickVideoView cTO;
    private com.baidu.tieba.play.g cTP;
    private TextView cTQ;
    private LinearLayout cTR;
    private TextView cTS;
    private View cTT;
    private y cTU;
    private n cTV;
    private View cTW;
    private int cTX;
    private int cTY;
    private boolean cTZ;
    private boolean cUa;
    private boolean cUb;
    private TextView cUc;
    private Handler cUd;
    private VideoLoadingProgressView.a cUe;
    private TbImageView.a cUf;
    private Runnable cUg;
    private Runnable cUh;
    private final View.OnClickListener cUi;
    private final View.OnClickListener cUj;
    private CustomMessageListener cUk;
    private j.a cUl;
    private Animation.AnimationListener cUm;
    private RelativeLayout ciR;
    public ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    protected LinearLayout cjQ;
    private com.baidu.tieba.NEGFeedBack.c cje;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void ako() {
        if (this.cTP != null) {
            try {
                this.cTO.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        if (this.cTV != null && this.cTV.bXi != null) {
            aa aaVar = new aa();
            aaVar.mLocate = this.cTV.sourceType == 0 ? "index" : "hot_juhe";
            aaVar.bBb = this.cTV.bXi.getTid();
            aaVar.cXh = this.cTV.bXi.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.cTV.bXi.mRecomSource;
            aaVar.guq = this.cTV.bXi.mRecomAbTag;
            aaVar.gur = this.cTV.bXi.mRecomWeight;
            aaVar.gus = "";
            aaVar.aLh = this.cTV.getExtra();
            if (this.cTV.bXi.zl() != null) {
                aaVar.guu = this.cTV.bXi.zl().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cTV.bXi.zl().video_md5, "", "1", aaVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cje = null;
        this.mSkinType = 3;
        this.cTX = 0;
        this.cTY = 1;
        this.cTZ = false;
        this.cUa = true;
        this.cUb = false;
        this.cUd = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case HttpStatus.SC_ACCEPTED /* 202 */:
                        j.this.akr();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        j.this.aks();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bNv = new g.f() { // from class: com.baidu.tieba.card.j.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                j.this.cTP = gVar;
                if (j.this.cTP != null) {
                    j.this.cTP.setVolume(0.0f, 0.0f);
                }
                j.this.cTU.bkC();
            }
        };
        this.bNw = new g.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.i(true, 4);
                return true;
            }
        };
        this.cUe = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.j.12
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                j.this.ako();
            }
        };
        this.cUf = new TbImageView.a() { // from class: com.baidu.tieba.card.j.13
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && j.this.cTG != null) {
                    j.this.cTG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cUg = new Runnable() { // from class: com.baidu.tieba.card.j.17
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.cTO != null && !j.this.cTO.isPlaying()) {
                    j.this.i(true, 1);
                }
            }
        };
        this.cUh = new Runnable() { // from class: com.baidu.tieba.card.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.i(true, 4);
            }
        };
        this.bYW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.cUi = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akg() != null) {
                    j.this.akg().a(view, j.this.cTV);
                }
            }
        };
        this.cUj = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akg() != null) {
                    j.this.akg().a(view, j.this.cTV);
                }
            }
        };
        this.cUk = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.cUb = false;
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cTV != null) {
                    if (j.this.akg() != null) {
                        j.this.akg().a(view, j.this.cTV);
                    }
                    if (j.this.cTV.bXi != null) {
                        k.kk(j.this.cTV.bXi.getId());
                        if (!j.this.akk()) {
                            k.a(j.this.mTextTitle, j.this.cTV.bXi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                            k.a(j.this.cSK.getGodReplyContent(), j.this.cTV.VM().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cUl = new j.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tieba.play.j.a
            public void akw() {
                if (j.this.cTV != null && j.this.cTV.bXi != null && j.this.cTV.bXi.zl() != null) {
                    j.this.akp();
                }
            }
        };
        this.cUm = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.cTG != null) {
                    j.this.cTG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aQs = tbPageContext;
        View view = getView();
        this.ciR = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cjC = (HeadPendantClickableView) this.ciR.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.ds70));
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.cTU = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cTU.setLoadingAnimationListener(this.cUe);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.cje = new com.baidu.tieba.NEGFeedBack.c(akf());
        int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16);
        this.cje.a(this.ciR, s, 0);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.setShareReportFrom(3);
        this.ciT.setForumAfterClickListener(this.bbZ);
        this.ciT.setFrom(1);
        this.cSM = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cSM.bcI.setOnClickListener(this);
        this.cSM.setFrom(1);
        this.cSM.setShareReportFrom(3);
        this.cSM.setForumAfterClickListener(this.bbZ);
        this.cTI = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cTN = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cTN.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ao(this.aQs.getPageActivity()) - com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cTN.setLayoutParams(layoutParams2);
        this.cTG = (TbImageView) view.findViewById(d.g.image_video);
        this.cTG.setDefaultErrorResource(0);
        this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTG.setGifIconSupport(false);
        this.cTG.setEvent(this.cUf);
        this.bYB = (ImageView) view.findViewById(d.g.image_video_play);
        this.ciR.setOnClickListener(this);
        this.cTO = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bYR = new com.baidu.tieba.play.n(this.aQs.getPageActivity());
        this.cTO.setBusiness(this.bYR);
        this.cTO.setOnPreparedListener(this.bNv);
        this.cTO.setOnErrorListener(this.bNw);
        this.cTO.setOnSurfaceDestroyedListener(this.bYW);
        this.bYQ = new com.baidu.tieba.play.j();
        this.bYQ.setPlayer(this.cTO);
        this.bYQ.a(this.cUl);
        this.cTQ = (TextView) view.findViewById(d.g.text_video_duration);
        this.cTR = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cTH = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cTW = view.findViewById(d.g.auto_video_black_mask);
        this.cTS = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cTT = view.findViewById(d.g.auto_video_error_background);
        this.cjQ = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bYF = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bYF.setAnimationListener(this.cUm);
        this.cSK = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cSK.setOnClickListener(this);
        this.bOs = view.findViewById(d.g.divider_line);
        this.cUc = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.cTO.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cTV != null && this.cTV.bXi != null && this.cTV.bXi.aPa > 0) {
            if (akg() != null) {
                akg().a(view, this.cTV);
            }
            this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.aQs.getPageActivity(), this.cTV.bXi.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, k.yJ(), this.cTV.akT())));
            return;
        }
        if (view == this.ciR || view == this.cSK) {
            bD(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cTO) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bC(getView());
            } else {
                bD(getView());
            }
        }
    }

    private void bC(View view) {
        if (akg() != null) {
            akg().a(view, this.cTV);
        }
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.showToast(this.aQs.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQs.getPageActivity());
            aVar.cZ(this.aQs.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.j.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    j.this.akq();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.j.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(this.mTbPageContext).AB();
        } else {
            akq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akq() {
        if (this.cTV != null && this.cTV.bXi != null && this.cTV.bXi.getId() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQs.getPageActivity(), "index", this.cTV.bXi.getTid(), k.yJ(), this.cTV.akT())));
        }
    }

    private void bD(View view) {
        if (akg() != null) {
            akg().a(view, this.cTV);
        }
        if (this.cTV != null && this.cTV.bXi != null) {
            if (!akk()) {
                k.kk(this.cTV.bXi.getId());
                k.a(this.mTextTitle, this.cTV.bXi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aQs.getPageActivity()).createFromThreadCfg(this.cTV.bXi, null, k.yJ(), 18003, true, false, false).addLocateParam(this.cTV.akT());
            addLocateParam.setVideo_source(this.cTV.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cTV.bXi.getFid()));
            addLocateParam.setForumName(this.cTV.bXi.yZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cSK) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akk() {
        return this.cTV.cXy && !this.cTV.cXM;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.cTV = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        this.cUd.removeMessages(HttpStatus.SC_ACCEPTED);
        if (this.cTO.getCurrentPosition() > 0) {
            i(true, 3);
            this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cUd.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cTO.getCurrentPosition();
        if (currentPosition != this.cTX) {
            this.cTX = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bYB != null && this.cTG != null && this.cTW != null && this.cTU != null && this.cTT != null && this.cTS != null) {
            if (z || this.cTY != i) {
                this.cTY = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUh);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUg);
                if (i == 2) {
                    this.bYB.setVisibility(8);
                    this.bYF.cancel();
                    this.cTG.clearAnimation();
                    this.cTG.setVisibility(0);
                    this.cTW.setVisibility(0);
                    this.cTR.setVisibility(0);
                    this.cUc.setVisibility(8);
                    this.cTU.startLoading();
                    this.cTT.setVisibility(8);
                    this.cTS.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cUh, 60000L);
                } else if (i == 3) {
                    this.bYB.setVisibility(8);
                    this.cTG.startAnimation(this.bYF);
                    this.cTW.setVisibility(8);
                    this.cTR.setVisibility(8);
                    if (this.cTV != null && this.cTV.VM() != null && this.cTV.VM().aPa > 0) {
                        this.cUc.setVisibility(0);
                    }
                    this.cTU.bkD();
                    this.cTT.setVisibility(8);
                    this.cTS.setVisibility(8);
                } else if (i == 4) {
                    this.bYB.setVisibility(8);
                    this.cTG.startAnimation(this.bYF);
                    this.cTW.setVisibility(8);
                    this.cTU.bkE();
                    this.cTT.setVisibility(0);
                    this.cTS.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cUg, 2000L);
                } else {
                    this.bYB.setVisibility(0);
                    this.bYF.cancel();
                    this.cTG.clearAnimation();
                    this.cTG.setVisibility(0);
                    this.cTW.setVisibility(0);
                    this.cTR.setVisibility(0);
                    this.cTU.bkE();
                    this.cTT.setVisibility(8);
                    this.cTS.setVisibility(8);
                }
                if (this.cTV != null && this.cTV.VM() != null && this.cTV.VM().aPa > 0) {
                    this.cTR.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cTV == null || this.cTV.bXi == null || this.cTV.bXi.yT() == null) {
            this.ciR.setVisibility(8);
            return;
        }
        this.ciR.setVisibility(0);
        akv();
        if (!akk() && k.kl(this.cTV.bXi.getId())) {
            k.a(this.mTextTitle, this.cTV.bXi.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cSK.getGodReplyContent(), this.cTV.VM().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.cTV.VM().zC();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cTV.VM().zt());
        if (this.cTV.VM().zz() && !StringUtils.isNull(this.cTV.VM().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cTV.VM().getTid();
            spannableStringBuilder.append((CharSequence) this.cTV.VM().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.j.16
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0108d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.ciS.setData(this.cTV.VM());
        this.ciS.setUserAfterClickListener(this.cUi);
        if (this.ciS.getHeaderImg() != null) {
            this.ciS.getHeaderImg().setAfterClickListener(this.cUj);
            if (this.ciS.getIsSimpleThread()) {
                this.ciS.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (this.cTV.VM() == null || this.cTV.VM().yT() == null || this.cTV.VM().yT().getPendantData() == null || StringUtils.isNull(this.cTV.VM().yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ciS.getHeaderImg().setVisibility(0);
                if (this.cTV.VM().aPa > 0 && this.cTV.VM().aPb == 0) {
                    this.cTV.VM().yT().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.ciS.getHeaderImg().a(this.cTV.VM(), false);
                } else {
                    this.ciS.getHeaderImg().setData(this.cTV.VM());
                    this.ciS.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.ciS.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(this.cTV.VM());
            }
        }
        this.cTQ.setText(am.fV(this.cTV.bXi.zl().video_duration.intValue() * 1000));
        this.cTH.setText(String.format(this.aQs.getResources().getString(d.j.play_count), am.J(this.cTV.bXi.zl().play_count.intValue())));
        if (this.cje != null && this.cTV.VM() != null) {
            ah ahVar = new ah();
            ahVar.cK(this.cTV.VM().getTid());
            ahVar.setFid(this.cTV.VM().getFid());
            ahVar.a(this.cTV.aLY);
            this.cje.setData(ahVar);
            this.cje.setFirstRowSingleColumn(true);
            this.cje.setVisibility(this.cUa ? 0 : 8);
        }
        this.cSK.setData(this.cTV.VM().Ah());
        lD(this.cTV.VM().aPd);
        d(this.aQs, TbadkCoreApplication.getInst().getSkinType());
        if (k.kl(this.cTV.bXi.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
    }

    private void akt() {
        this.cUd.removeMessages(HttpStatus.SC_ACCEPTED);
        this.cUd.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aku() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUg);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUh);
    }

    private void akv() {
        aku();
        akt();
        if (this.cTG != null && this.cTN != null && this.cTO != null) {
            if (com.baidu.tbadk.core.i.wB().wH() && this.cTV != null && this.cTV.bXi != null && this.cTV.bXi.zl() != null) {
                this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cTG.startLoad(this.cTV.bXi.zl().thumbnail_url, 10, false);
                this.cTN.setVisibility(0);
                stopPlay();
                this.bON = this.cTV.bXi.zl().video_url;
                if (StringUtils.isNull(this.cTV.bXi.zl().video_url)) {
                    i(true, 4);
                }
                if (this.bYR != null && this.bYR.bkm() != null) {
                    this.bYR.bkm().d(this.cTV.bXi.zl());
                    return;
                }
                return;
            }
            this.cTN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciR, d.f.addresslist_item_bg);
            aj.c(this.bYB, d.f.btn_icon_play_video_n);
            aj.r(this.cTS, d.C0108d.cp_cont_i);
            aj.r(this.cTQ, d.C0108d.cp_cont_i);
            aj.r(this.cTH, d.C0108d.cp_cont_i);
            aj.r(this.cUc, d.C0108d.cp_cont_i);
            aj.t(this.cTT, d.C0108d.common_color_10014);
            aj.t(this.bOs, d.C0108d.cp_bg_line_e);
            if (this.cTS != null) {
                this.cTS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cSK.onChangeSkinType();
            if (this.cje != null) {
                this.cje.onChangeSkinType();
            }
            this.ciS.onChangeSkinType();
            this.ciT.onChangeSkinType();
            this.cSM.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cUk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cUk);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciS != null) {
            this.ciS.setPageUniqueId(bdUniqueId);
        }
        if (this.cTG != null) {
            this.cTG.setPageId(bdUniqueId);
        }
        if (this.cje != null) {
            this.cje.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cTZ;
    }

    public boolean isPlaying() {
        if (this.cTO == null) {
            return false;
        }
        return this.cTO.isPlaying();
    }

    public void startPlay() {
        if (!this.cTZ && this.cTV != null && this.cTV.bXi != null && this.cTV.bXi.zl() != null && this.cTO != null && com.baidu.tbadk.util.y.p(1, this.bON)) {
            i(true, 2);
            if (StringUtils.isNull(this.bON)) {
                TiebaStatic.log(new ak("c12619").aa("obj_locate", "index").aa("tid", this.cTV.tid));
                this.bON = this.cTV.bXi.zl().video_url;
            }
            this.cTO.bN(this.bON, this.cTV.tid);
            this.cTO.setLooping(true);
            if (this.bYQ != null) {
                this.bYQ.start();
            }
            this.cTZ = true;
            akp();
        }
    }

    public void stopPlay() {
        aku();
        akt();
        i(true, 1);
        if (this.cTO != null) {
            this.cTO.stopPlayback();
            if (this.bYQ != null) {
                this.bYQ.stop();
            }
        }
        this.cTZ = false;
    }

    public View getVideoContainer() {
        return this.cTN;
    }

    public String getPlayUrl() {
        return this.bON;
    }

    public int getCurrentPosition() {
        if (this.cTO == null) {
            return 0;
        }
        return this.cTO.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.bYR != null) {
            this.bYR.setVideoStatsData(aaVar);
        }
    }

    public void a(c.a aVar) {
        if (this.cje != null) {
            this.cje.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciS != null) {
            return this.ciS.bch;
        }
        return null;
    }

    public View akj() {
        if (this.ciS != null) {
            return this.ciS.bci;
        }
        return null;
    }

    public void eD(boolean z) {
        this.cUa = z;
    }

    public void lD(int i) {
        if (this.cTV != null && this.cTV.bXi != null) {
            if (i == 1) {
                if (this.cTV.bXi.aPa > 0) {
                    this.cSM.bcI.setShowPraiseNum(false);
                    this.cSM.bcI.setShareVisible(false);
                    this.cUc.setText(am.J(this.cTV.bXi.aPa));
                    this.cUc.setVisibility(0);
                } else {
                    this.cSM.bcI.setShowPraiseNum(true);
                    this.cSM.bcI.setShareVisible(true);
                    this.cUc.setVisibility(8);
                }
                this.cSM.setData(this.cTV.bXi);
                this.ciT.setVisibility(8);
                this.ciS.showForumNameView(false);
                return;
            }
            this.cSM.setVisibility(8);
            this.ciS.showForumNameView(true);
            if (this.cTV.bXi.aPa > 0) {
                this.ciT.setShowPraiseNum(false);
                this.ciT.setShareVisible(false);
                this.cUc.setText(am.J(this.cTV.bXi.aPa));
                this.cUc.setVisibility(0);
            } else {
                this.ciT.setShowPraiseNum(true);
                this.ciT.setShareVisible(true);
                this.cUc.setVisibility(8);
            }
            if (this.ciT.setData(this.cTV.bXi)) {
                this.cTI.setVisibility(8);
            } else {
                this.cTI.setVisibility(0);
            }
        }
    }
}
