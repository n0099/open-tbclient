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
    protected bd aZA;
    public View bQn;
    public View bYp;
    private final View.OnClickListener bdQ;
    private ThreadGodReplyLayout cVu;
    private View.OnClickListener cVx;
    public TbImageView cYK;
    private TbImageView cYM;
    private ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    protected ThreadSourceShareAndPraiseLayout cmL;
    public LinearLayout cmX;
    private com.baidu.tieba.frs.g.g dLx;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void by(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akO() != null) {
                    j.this.akO().a(view, j.this.aZA);
                }
                j.this.eI(view == j.this.cVu);
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akO() != null) {
                    j.this.akO().a(view, j.this.aZA);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cmI = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cmI.setAfterClickListener(this.bdQ);
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.cYM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.bQn = view.findViewById(d.g.divider_line);
        this.bYp = view.findViewById(d.g.top_divider_line);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.clW.setUserAfterClickListener(this.bdQ);
        this.clW.setFrom(3);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this.cVx);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setIsBarViewVisible(false);
        this.clX.setShareVisible(true);
        this.clX.setShareReportFrom(1);
        this.clX.setFrom(2);
        this.clX.setStType("frs_page");
        this.clX.aQt = 3;
        if (view instanceof ViewGroup) {
            this.dLx = new com.baidu.tieba.frs.g.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dLx = new com.baidu.tieba.frs.g.g(this.mPageContext, this.clW);
        }
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this.cVx);
        this.cmL.setFrom(2);
        this.cmL.setShareReportFrom(1);
        this.cmL.setSourceFromForPb(3);
        this.cmL.setStType("frs_page");
        this.cmL.setHideBarName(true);
        this.cmL.bem.setNeedAddReplyIcon(true);
        this.dLx.setUniqueId(getTag());
        this.cVu = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVu.setOnClickListener(this.cVx);
        this.cYK = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYK.setPageId(getTag());
        this.cmX = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        by(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bQn, d.C0141d.cp_bg_line_e);
            aj.t(this.bYp, d.C0141d.cp_bg_line_e);
            this.clX.onChangeSkinType();
            this.clW.onChangeSkinType();
            this.cVu.onChangeSkinType();
            this.dLx.onChangeSkinType();
            if (this.cmL != null && this.cmL.getVisibility() == 0) {
                this.cmL.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void H(final bd bdVar) {
        if (this.cYM != null) {
            if (this.cYK == null || bdVar == null) {
                this.cYM.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQm) && this.cYK.getVisibility() != 0) {
                if (this.dLx != null && this.dLx.aAt() && (this.cYM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYM.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYM.setLayoutParams(layoutParams);
                }
                this.cYM.setVisibility(0);
                this.cYM.setImageDrawable(null);
                this.cYM.startLoad(bdVar.aQm, 10, false);
                this.cYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.this.mPageContext != null) {
                            j.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(j.this.mPageContext.getPageActivity(), "", bdVar.aQn, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYM.setVisibility(8);
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
        this.aZA = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVx);
        }
        if (!akS() && com.baidu.tieba.card.j.ks(this.aZA.getId())) {
            akT();
        }
        K(bdVar);
        this.dLx.W(this.aZA);
        H(bdVar);
        this.clW.setData(this.aZA);
        this.cVu.setData(this.aZA.AA());
        this.clW.setUserAfterClickListener(this.bdQ);
        if (this.clW.getHeaderImg() != null) {
            if (this.clW.getIsSimpleThread()) {
                this.clW.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.clW.getHeaderImg().setVisibility(0);
                this.clW.getHeaderImg().setData(bdVar);
            } else {
                this.clW.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(bdVar);
            }
        }
        jX(bdVar.aQo);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYK != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYK.setVisibility(8);
                return;
            }
            this.cYK.setVisibility(0);
            this.cYK.setImageBitmap(null);
            this.cYK.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.clX != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.clW != null) {
            this.clW.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.aZA != null) {
            com.baidu.tieba.card.j.kr(this.aZA.getId());
            akT();
            com.baidu.tbadk.core.data.m Ag = this.aZA.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aZA.aPI;
            if (this.aZA.aPH == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLw;
                long j = jVar.aLx;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLK = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZA, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZA.getFid()));
            addLocateParam.setForumName(this.aZA.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean akS() {
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
    public void akT() {
        com.baidu.tieba.card.j.a(this.cVu.getGodReplyContent(), this.aZA.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout alt() {
        return this.clX;
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmL.bem;
    }

    public void jX(int i) {
        if (this.aZA != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setData(this.aZA);
                return;
            }
            this.clX.setData(this.aZA);
            this.cmL.setVisibility(8);
        }
    }
}
