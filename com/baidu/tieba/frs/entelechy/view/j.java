package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class j extends com.baidu.tieba.card.a<bd> implements t {
    protected bd aZC;
    public View bQq;
    public View bYs;
    private final View.OnClickListener bdT;
    private View.OnClickListener cVA;
    private ThreadGodReplyLayout cVx;
    public TbImageView cYN;
    private TbImageView cYP;
    private ThreadUserInfoLayout clZ;
    private HeadPendantClickableView cmL;
    protected ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    public LinearLayout cna;
    private com.baidu.tieba.frs.g.g dLC;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void by(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akP() != null) {
                    j.this.akP().a(view, j.this.aZC);
                }
                j.this.eI(view == j.this.cVx);
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akP() != null) {
                    j.this.akP().a(view, j.this.aZC);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cmL.setAfterClickListener(this.bdT);
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.cYP = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.bQq = view.findViewById(d.g.divider_line);
        this.bYs = view.findViewById(d.g.top_divider_line);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.clZ.setUserAfterClickListener(this.bdT);
        this.clZ.setFrom(3);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this.cVA);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setIsBarViewVisible(false);
        this.cma.setShareVisible(true);
        this.cma.setShareReportFrom(1);
        this.cma.setFrom(2);
        this.cma.setStType("frs_page");
        this.cma.aQv = 3;
        if (view instanceof ViewGroup) {
            this.dLC = new com.baidu.tieba.frs.g.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dLC = new com.baidu.tieba.frs.g.g(this.mPageContext, this.clZ);
        }
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this.cVA);
        this.cmO.setFrom(2);
        this.cmO.setShareReportFrom(1);
        this.cmO.setSourceFromForPb(3);
        this.cmO.setStType("frs_page");
        this.cmO.setHideBarName(true);
        this.cmO.bep.setNeedAddReplyIcon(true);
        this.dLC.setUniqueId(getTag());
        this.cVx = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVx.setOnClickListener(this.cVA);
        this.cYN = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYN.setPageId(getTag());
        this.cna = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        by(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bQq, d.C0141d.cp_bg_line_e);
            aj.t(this.bYs, d.C0141d.cp_bg_line_e);
            this.cma.onChangeSkinType();
            this.clZ.onChangeSkinType();
            this.cVx.onChangeSkinType();
            this.dLC.onChangeSkinType();
            if (this.cmO != null && this.cmO.getVisibility() == 0) {
                this.cmO.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void H(final bd bdVar) {
        if (this.cYP != null) {
            if (this.cYN == null || bdVar == null) {
                this.cYP.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQn) && this.cYN.getVisibility() != 0) {
                if (this.dLC != null && this.dLC.aAv() && (this.cYP.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYP.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYP.setLayoutParams(layoutParams);
                }
                this.cYP.setVisibility(0);
                this.cYP.setImageDrawable(null);
                this.cYP.startLoad(bdVar.aQn, 10, false);
                this.cYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.this.mPageContext != null && !StringUtils.isNull(bdVar.aQo)) {
                            j.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(j.this.mPageContext.getPageActivity(), "", bdVar.aQo, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYP.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aZC = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVA);
        }
        if (!akT() && com.baidu.tieba.card.j.ks(this.aZC.getId())) {
            akU();
        }
        K(bdVar);
        this.dLC.W(this.aZC);
        H(bdVar);
        this.clZ.setData(this.aZC);
        this.cVx.setGrayScaleMode(this.aZC.AC());
        this.cVx.setData(this.aZC.AA());
        this.clZ.setUserAfterClickListener(this.bdT);
        if (this.clZ.getHeaderImg() != null) {
            if (this.clZ.getIsSimpleThread()) {
                this.clZ.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.clZ.getHeaderImg().setVisibility(0);
                this.clZ.getHeaderImg().setData(bdVar);
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(bdVar);
            }
        }
        jX(bdVar.aQp);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYN != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYN.setVisibility(8);
                return;
            }
            this.cYN.setVisibility(0);
            this.cYN.setImageBitmap(null);
            this.cYN.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cma != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.clZ != null) {
            this.clZ.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.aZC != null) {
            com.baidu.tieba.card.j.kr(this.aZC.getId());
            akU();
            com.baidu.tbadk.core.data.m Ag = this.aZC.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aZC.aPJ;
            if (this.aZC.aPI == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLx;
                long j = jVar.aLy;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLL = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZC, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZC.getFid()));
            addLocateParam.setForumName(this.aZC.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean akT() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akU() {
        com.baidu.tieba.card.j.a(this.cVx.getGodReplyContent(), this.aZC.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cma;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmO.bep;
    }

    public void jX(int i) {
        if (this.aZC != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setData(this.aZC);
                return;
            }
            this.cma.setData(this.aZC);
            this.cmO.setVisibility(8);
        }
    }
}
