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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.be;
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
/* loaded from: classes2.dex */
public abstract class j extends com.baidu.tieba.card.a<be> implements u {
    protected be aXV;
    public View bOc;
    public View bWd;
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private ThreadGodReplyLayout cNP;
    private View.OnClickListener cNS;
    public TbImageView cRo;
    private ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    public LinearLayout cjA;
    private com.baidu.tieba.frs.f.g dDM;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void bx(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aiY() != null) {
                    j.this.aiY().a(view, j.this.aXV);
                }
                j.this.ev(view == j.this.cNP);
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aiY() != null) {
                    j.this.aiY().a(view, j.this.aXV);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cNO.setAfterClickListener(this.bce);
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.bOc = view.findViewById(d.g.divider_line);
        this.bWd = view.findViewById(d.g.top_divider_line);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciD.setUserAfterClickListener(this.bce);
        this.ciD.setFrom(3);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this.cNS);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setShareVisible(true);
        this.ciE.setShareReportFrom(1);
        this.ciE.setFrom(2);
        this.ciE.setStType("frs_page");
        this.ciE.bbP = 3;
        if (view instanceof ViewGroup) {
            this.dDM = new com.baidu.tieba.frs.f.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dDM = new com.baidu.tieba.frs.f.g(this.mPageContext, this.ciD);
        }
        this.dDM.setUniqueId(getTag());
        this.cNP = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cNP.setOnClickListener(this.cNS);
        this.cRo = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cRo.setPageId(getTag());
        this.cjA = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        bx(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bOc, d.C0108d.cp_bg_line_e);
            aj.t(this.bWd, d.C0108d.cp_bg_line_e);
            this.ciE.onChangeSkinType();
            this.ciD.onChangeSkinType();
            this.cNP.onChangeSkinType();
            this.dDM.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(be beVar) {
        if (beVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aXV = beVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cNS);
        }
        if (!ajc() && com.baidu.tieba.card.k.jU(this.aXV.getId())) {
            ajd();
        }
        this.dDM.T(this.aXV);
        this.ciD.setData(this.aXV);
        this.cNP.setData(this.aXV.Ao());
        this.ciD.setUserAfterClickListener(this.bce);
        if (this.ciD.getHeaderImg() != null) {
            if (this.ciD.getIsSimpleThread()) {
                this.ciD.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (beVar.yX() == null || beVar.yX().getPendantData() == null || StringUtils.isNull(beVar.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.ciD.getHeaderImg().setVisibility(0);
                this.ciD.getHeaderImg().setData(beVar);
            } else {
                this.ciD.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(beVar);
            }
        }
        this.ciE.setData(beVar);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        H(beVar);
    }

    public void H(be beVar) {
        MetaData yX;
        if (beVar != null && this.cRo != null && (yX = beVar.yX()) != null) {
            final ThemeCardInUserData themeCard = yX.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cRo.setVisibility(8);
                return;
            }
            this.cRo.setVisibility(0);
            this.cRo.setImageBitmap(null);
            this.cRo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cRo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciE != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciD != null) {
            this.ciD.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(boolean z) {
        if (this.aXV != null) {
            com.baidu.tieba.card.k.jT(this.aXV.getId());
            ajd();
            m zU = this.aXV.zU();
            if (zU != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.bd(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zU.getCartoonId(), zU.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aXV.aOz;
            if (this.aXV.aOy == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKm;
                long j = jVar.aKn;
                al alVar = new al();
                alVar.pageContext = this.mPageContext;
                alVar.aKA = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXV, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aXV.getFid()));
            addLocateParam.setForumName(this.aXV.zd());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ajc() {
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
    public void ajd() {
        com.baidu.tieba.card.k.a(this.cNP.getGodReplyContent(), this.aXV.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout ajD() {
        return this.ciE;
    }
}
