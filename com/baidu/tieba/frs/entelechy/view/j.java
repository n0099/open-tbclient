package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.tieba.card.a<bd> implements u {
    protected bd ajJ;
    private final View.OnClickListener aod;
    private HeadPendantClickableView bZe;
    private ThreadGodReplyLayout bZf;
    private View.OnClickListener bZj;
    public View ban;
    public View biS;
    private ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    public LinearLayout bvL;
    private boolean cNQ;
    private com.baidu.tieba.frs.g.g cOS;
    public TbImageView ccH;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void af(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.ajJ);
                }
                j.this.dO(view == j.this.bZf);
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.ajJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bZe.setAfterClickListener(this.aod);
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.ban = view.findViewById(d.g.divider_line);
        this.biS = view.findViewById(d.g.top_divider_line);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bvE.setUserAfterClickListener(this.aod);
        this.bvE.setFrom(3);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bvI.setOnClickListener(this.bZj);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setShareVisible(true);
        this.bvI.setShareReportFrom(1);
        this.bvI.setFrom(2);
        this.bvI.setStType("frs_page");
        this.bvI.anO = 3;
        if (view instanceof ViewGroup) {
            this.cOS = new com.baidu.tieba.frs.g.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.cOS = new com.baidu.tieba.frs.g.g(this.mPageContext, this.bvE);
        }
        this.cOS.setUniqueId(getTag());
        this.bZf = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZf.setOnClickListener(this.bZj);
        this.ccH = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccH.setPageId(getTag());
        this.bvL = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        af(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.ban, d.C0096d.cp_bg_line_e);
            aj.k(this.biS, d.C0096d.cp_bg_line_e);
            this.bvI.onChangeSkinType();
            this.bvE.onChangeSkinType();
            this.bZf.onChangeSkinType();
            this.cOS.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajJ = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZj);
        }
        if (!abx() && com.baidu.tieba.card.k.jP(this.ajJ.getId())) {
            aby();
        }
        this.cOS.U(this.ajJ);
        this.bvE.setData(this.ajJ);
        this.bZf.setData(this.ajJ.sM());
        if (!this.cNQ) {
            this.bvI.setData(bdVar);
        }
        this.bvE.setUserAfterClickListener(this.aod);
        if (this.bvE.getHeaderImg() != null) {
            if (this.bvE.getIsSimpleThread()) {
                this.bvE.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (bdVar.rv() == null || bdVar.rv().getPendantData() == null || StringUtils.isNull(bdVar.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.bvE.getHeaderImg().setVisibility(0);
                this.bvE.getHeaderImg().setData(bdVar);
            } else {
                this.bvE.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(bdVar);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        D(bdVar);
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccH != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccH.setVisibility(8);
                return;
            }
            this.ccH.setVisibility(0);
            this.ccH.setImageBitmap(null);
            this.ccH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvI != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvE != null) {
            this.bvE.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(boolean z) {
        if (this.ajJ != null) {
            com.baidu.tieba.card.k.jO(this.ajJ.getId());
            aby();
            m ss = this.ajJ.ss();
            if (ss != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aR(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.ajJ.ZX;
            if (this.ajJ.ZW == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VM;
                long j = jVar.VN;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wa = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajJ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajJ.getFid()));
            addLocateParam.setForumName(this.ajJ.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abx() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        com.baidu.tieba.card.k.a(this.bZf.getGodReplyContent(), this.ajJ.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
    }

    public void fn(boolean z) {
        this.cNQ = z;
    }

    public ThreadCommentAndPraiseInfoLayout abY() {
        return this.bvI;
    }
}
