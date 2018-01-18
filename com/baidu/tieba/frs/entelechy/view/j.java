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
    protected bd aXU;
    public View bOk;
    public View bWk;
    private final View.OnClickListener bce;
    private ThreadGodReplyLayout cSp;
    private View.OnClickListener cSt;
    public TbImageView cVQ;
    private ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    public LinearLayout cjI;
    private HeadPendantClickableView cju;
    private com.baidu.tieba.frs.f.g dIn;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void bz(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akb() != null) {
                    j.this.akb().a(view, j.this.aXU);
                }
                j.this.ez(view == j.this.cSp);
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.akb() != null) {
                    j.this.akb().a(view, j.this.aXU);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cju.setAfterClickListener(this.bce);
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.bOk = view.findViewById(d.g.divider_line);
        this.bWk = view.findViewById(d.g.top_divider_line);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciK.setUserAfterClickListener(this.bce);
        this.ciK.setFrom(3);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this.cSt);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setShareVisible(true);
        this.ciL.setShareReportFrom(1);
        this.ciL.setFrom(2);
        this.ciL.setStType("frs_page");
        this.ciL.bbP = 3;
        if (view instanceof ViewGroup) {
            this.dIn = new com.baidu.tieba.frs.f.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dIn = new com.baidu.tieba.frs.f.g(this.mPageContext, this.ciK);
        }
        this.dIn.setUniqueId(getTag());
        this.cSp = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cSp.setOnClickListener(this.cSt);
        this.cVQ = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cVQ.setPageId(getTag());
        this.cjI = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        bz(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bOk, d.C0107d.cp_bg_line_e);
            aj.t(this.bWk, d.C0107d.cp_bg_line_e);
            this.ciL.onChangeSkinType();
            this.ciK.onChangeSkinType();
            this.cSp.onChangeSkinType();
            this.dIn.onChangeSkinType();
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
        this.aXU = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        if (!akf() && com.baidu.tieba.card.k.kd(this.aXU.getId())) {
            akg();
        }
        this.dIn.T(this.aXU);
        this.ciK.setData(this.aXU);
        this.cSp.setData(this.aXU.Ag());
        this.ciK.setUserAfterClickListener(this.bce);
        if (this.ciK.getHeaderImg() != null) {
            if (this.ciK.getIsSimpleThread()) {
                this.ciK.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (bdVar.yS() == null || bdVar.yS().getPendantData() == null || StringUtils.isNull(bdVar.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ciK.getHeaderImg().setVisibility(0);
                this.ciK.getHeaderImg().setData(bdVar);
            } else {
                this.ciK.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(bdVar);
            }
        }
        this.ciL.setData(bdVar);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        H(bdVar);
    }

    public void H(bd bdVar) {
        MetaData yS;
        if (bdVar != null && this.cVQ != null && (yS = bdVar.yS()) != null) {
            final ThemeCardInUserData themeCard = yS.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cVQ.setVisibility(8);
                return;
            }
            this.cVQ.setVisibility(0);
            this.cVQ.setImageBitmap(null);
            this.cVQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciL != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciK != null) {
            this.ciK.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(boolean z) {
        if (this.aXU != null) {
            com.baidu.tieba.card.k.kc(this.aXU.getId());
            akg();
            m zM = this.aXU.zM();
            if (zM != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.bd(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zM.getCartoonId(), zM.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aXU.aOx;
            if (this.aXU.aOw == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKk;
                long j = jVar.aKl;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aKy = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXU, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aXU.getFid()));
            addLocateParam.setForumName(this.aXU.yY());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean akf() {
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
    public void akg() {
        com.baidu.tieba.card.k.a(this.cSp.getGodReplyContent(), this.aXU.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout akG() {
        return this.ciL;
    }
}
