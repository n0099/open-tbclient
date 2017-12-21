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
    protected bd ajM;
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private ThreadGodReplyLayout bZj;
    private View.OnClickListener bZn;
    public View bas;
    public View biW;
    private ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    public LinearLayout bvP;
    private boolean cNU;
    private com.baidu.tieba.frs.g.g cOW;
    public TbImageView ccL;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void af(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.ajM);
                }
                j.this.dO(view == j.this.bZj);
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.ajM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bZi.setAfterClickListener(this.aog);
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.bas = view.findViewById(d.g.divider_line);
        this.biW = view.findViewById(d.g.top_divider_line);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bvI.setUserAfterClickListener(this.aog);
        this.bvI.setFrom(3);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bvM.setOnClickListener(this.bZn);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setShareVisible(true);
        this.bvM.setShareReportFrom(1);
        this.bvM.setFrom(2);
        this.bvM.setStType("frs_page");
        this.bvM.anR = 3;
        if (view instanceof ViewGroup) {
            this.cOW = new com.baidu.tieba.frs.g.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.cOW = new com.baidu.tieba.frs.g.g(this.mPageContext, this.bvI);
        }
        this.cOW.setUniqueId(getTag());
        this.bZj = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZj.setOnClickListener(this.bZn);
        this.ccL = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccL.setPageId(getTag());
        this.bvP = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        af(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.bas, d.C0095d.cp_bg_line_e);
            aj.k(this.biW, d.C0095d.cp_bg_line_e);
            this.bvM.onChangeSkinType();
            this.bvI.onChangeSkinType();
            this.bZj.onChangeSkinType();
            this.cOW.onChangeSkinType();
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
        this.ajM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZn);
        }
        if (!abx() && com.baidu.tieba.card.k.jP(this.ajM.getId())) {
            aby();
        }
        this.cOW.U(this.ajM);
        this.bvI.setData(this.ajM);
        this.bZj.setData(this.ajM.sM());
        if (!this.cNU) {
            this.bvM.setData(bdVar);
        }
        this.bvI.setUserAfterClickListener(this.aog);
        if (this.bvI.getHeaderImg() != null) {
            if (this.bvI.getIsSimpleThread()) {
                this.bvI.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (bdVar.rv() == null || bdVar.rv().getPendantData() == null || StringUtils.isNull(bdVar.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.bvI.getHeaderImg().setVisibility(0);
                this.bvI.getHeaderImg().setData(bdVar);
            } else {
                this.bvI.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(bdVar);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        D(bdVar);
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccL != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccL.setVisibility(8);
                return;
            }
            this.ccL.setVisibility(0);
            this.ccL.setImageBitmap(null);
            this.ccL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvM != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvI != null) {
            this.bvI.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(boolean z) {
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jO(this.ajM.getId());
            aby();
            m ss = this.ajM.ss();
            if (ss != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aR(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.ajM.aaa;
            if (this.ajM.ZZ == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VP;
                long j = jVar.VQ;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wd = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajM.getFid()));
            addLocateParam.setForumName(this.ajM.rB());
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
        com.baidu.tieba.card.k.a(this.bZj.getGodReplyContent(), this.ajM.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
    }

    public void fn(boolean z) {
        this.cNU = z;
    }

    public ThreadCommentAndPraiseInfoLayout abX() {
        return this.bvM;
    }
}
