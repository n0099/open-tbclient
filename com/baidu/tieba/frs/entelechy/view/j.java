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
/* loaded from: classes2.dex */
public abstract class j extends com.baidu.tieba.card.a<bd> implements u {
    protected bd aYc;
    public View bOs;
    public View bWs;
    private final View.OnClickListener bcm;
    private ThreadGodReplyLayout cSK;
    private View.OnClickListener cSO;
    public TbImageView cWl;
    private ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    public LinearLayout cjQ;
    private com.baidu.tieba.frs.f.g dII;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void bz(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akg() != null) {
                    j.this.akg().a(view, j.this.aYc);
                }
                j.this.eB(view == j.this.cSK);
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akg() != null) {
                    j.this.akg().a(view, j.this.aYc);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cjC.setAfterClickListener(this.bcm);
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.bOs = view.findViewById(d.g.divider_line);
        this.bWs = view.findViewById(d.g.top_divider_line);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciS.setUserAfterClickListener(this.bcm);
        this.ciS.setFrom(3);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this.cSO);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setShareVisible(true);
        this.ciT.setShareReportFrom(1);
        this.ciT.setFrom(2);
        this.ciT.setStType("frs_page");
        this.ciT.bbX = 3;
        if (view instanceof ViewGroup) {
            this.dII = new com.baidu.tieba.frs.f.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dII = new com.baidu.tieba.frs.f.g(this.mPageContext, this.ciS);
        }
        this.dII.setUniqueId(getTag());
        this.cSK = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cSK.setOnClickListener(this.cSO);
        this.cWl = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cWl.setPageId(getTag());
        this.cjQ = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        bz(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bOs, d.C0108d.cp_bg_line_e);
            aj.t(this.bWs, d.C0108d.cp_bg_line_e);
            this.ciT.onChangeSkinType();
            this.ciS.onChangeSkinType();
            this.cSK.onChangeSkinType();
            this.dII.onChangeSkinType();
        }
        this.mSkinType = i;
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
        this.aYc = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSO);
        }
        if (!akk() && com.baidu.tieba.card.k.kk(this.aYc.getId())) {
            akl();
        }
        this.dII.T(this.aYc);
        this.ciS.setData(this.aYc);
        this.cSK.setData(this.aYc.Ah());
        this.ciS.setUserAfterClickListener(this.bcm);
        if (this.ciS.getHeaderImg() != null) {
            if (this.ciS.getIsSimpleThread()) {
                this.ciS.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (bdVar.yT() == null || bdVar.yT().getPendantData() == null || StringUtils.isNull(bdVar.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ciS.getHeaderImg().setVisibility(0);
                this.ciS.getHeaderImg().setData(bdVar);
            } else {
                this.ciS.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(bdVar);
            }
        }
        this.ciT.setData(bdVar);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        H(bdVar);
    }

    public void H(bd bdVar) {
        MetaData yT;
        if (bdVar != null && this.cWl != null && (yT = bdVar.yT()) != null) {
            final ThemeCardInUserData themeCard = yT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cWl.setVisibility(8);
                return;
            }
            this.cWl.setVisibility(0);
            this.cWl.setImageBitmap(null);
            this.cWl.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciT != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciS != null) {
            this.ciS.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(boolean z) {
        if (this.aYc != null) {
            com.baidu.tieba.card.k.kj(this.aYc.getId());
            akl();
            m zN = this.aYc.zN();
            if (zN != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.ba(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zN.getCartoonId(), zN.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aYc.aOA;
            if (this.aYc.aOz == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKn;
                long j = jVar.aKo;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aKB = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aYc, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aYc.getFid()));
            addLocateParam.setForumName(this.aYc.yZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean akk() {
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
    public void akl() {
        com.baidu.tieba.card.k.a(this.cSK.getGodReplyContent(), this.aYc.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout akL() {
        return this.ciT;
    }
}
