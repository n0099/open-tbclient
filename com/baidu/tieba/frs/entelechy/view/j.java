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
    protected bd aZM;
    public View bQA;
    public View bYB;
    private final View.OnClickListener bec;
    private ThreadGodReplyLayout cVG;
    private View.OnClickListener cVJ;
    public TbImageView cYW;
    private TbImageView cYY;
    private HeadPendantClickableView cmU;
    protected ThreadSourceShareAndPraiseLayout cmX;
    private ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    public LinearLayout cnj;
    private com.baidu.tieba.frs.g.g dLJ;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void by(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akP() != null) {
                    j.this.akP().a(view, j.this.aZM);
                }
                j.this.eI(view == j.this.cVG);
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akP() != null) {
                    j.this.akP().a(view, j.this.aZM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cmU.setAfterClickListener(this.bec);
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.cYY = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.bQA = view.findViewById(d.g.divider_line);
        this.bYB = view.findViewById(d.g.top_divider_line);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmj.setUserAfterClickListener(this.bec);
        this.cmj.setFrom(3);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this.cVJ);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setShareVisible(true);
        this.cmk.setShareReportFrom(1);
        this.cmk.setFrom(2);
        this.cmk.setStType("frs_page");
        this.cmk.aQE = 3;
        if (view instanceof ViewGroup) {
            this.dLJ = new com.baidu.tieba.frs.g.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dLJ = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cmj);
        }
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this.cVJ);
        this.cmX.setFrom(2);
        this.cmX.setShareReportFrom(1);
        this.cmX.setSourceFromForPb(3);
        this.cmX.setStType("frs_page");
        this.cmX.setHideBarName(true);
        this.cmX.bez.setNeedAddReplyIcon(true);
        this.dLJ.setUniqueId(getTag());
        this.cVG = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVG.setOnClickListener(this.cVJ);
        this.cYW = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYW.setPageId(getTag());
        this.cnj = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        by(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bQA, d.C0140d.cp_bg_line_e);
            aj.t(this.bYB, d.C0140d.cp_bg_line_e);
            this.cmk.onChangeSkinType();
            this.cmj.onChangeSkinType();
            this.cVG.onChangeSkinType();
            this.dLJ.onChangeSkinType();
            if (this.cmX != null && this.cmX.getVisibility() == 0) {
                this.cmX.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void H(final bd bdVar) {
        if (this.cYY != null) {
            if (this.cYW == null || bdVar == null) {
                this.cYY.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQx) && this.cYW.getVisibility() != 0) {
                if (this.dLJ != null && this.dLJ.aAu() && (this.cYY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYY.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYY.setLayoutParams(layoutParams);
                }
                this.cYY.setVisibility(0);
                this.cYY.setImageDrawable(null);
                this.cYY.startLoad(bdVar.aQx, 10, false);
                this.cYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.this.mPageContext != null) {
                            j.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(j.this.mPageContext.getPageActivity(), "", bdVar.aQy, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYY.setVisibility(8);
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
        this.aZM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVJ);
        }
        if (!akT() && com.baidu.tieba.card.j.ks(this.aZM.getId())) {
            akU();
        }
        K(bdVar);
        this.dLJ.W(this.aZM);
        H(bdVar);
        this.cmj.setData(this.aZM);
        this.cVG.setData(this.aZM.AA());
        this.cmj.setUserAfterClickListener(this.bec);
        if (this.cmj.getHeaderImg() != null) {
            if (this.cmj.getIsSimpleThread()) {
                this.cmj.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.cmj.getHeaderImg().setVisibility(0);
                this.cmj.getHeaderImg().setData(bdVar);
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(bdVar);
            }
        }
        jX(bdVar.aQz);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYW != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYW.setVisibility(8);
                return;
            }
            this.cYW.setVisibility(0);
            this.cYW.setImageBitmap(null);
            this.cYW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cmk != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cmj != null) {
            this.cmj.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.aZM != null) {
            com.baidu.tieba.card.j.kr(this.aZM.getId());
            akU();
            com.baidu.tbadk.core.data.m Ag = this.aZM.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aZM.aPT;
            if (this.aZM.aPS == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLH;
                long j = jVar.aLI;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLV = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZM, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZM.getFid()));
            addLocateParam.setForumName(this.aZM.zt());
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
        com.baidu.tieba.card.j.a(this.cVG.getGodReplyContent(), this.aZM.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmk;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmX.bez;
    }

    public void jX(int i) {
        if (this.aZM != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setData(this.aZM);
                return;
            }
            this.cmk.setData(this.aZM);
            this.cmX.setVisibility(8);
        }
    }
}
