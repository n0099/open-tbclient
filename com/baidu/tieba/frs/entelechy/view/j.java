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
    private final View.OnClickListener aob;
    private HeadPendantClickableView bZa;
    private ThreadGodReplyLayout bZb;
    private View.OnClickListener bZf;
    public View bam;
    public View biR;
    private ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    public LinearLayout bvK;
    private boolean cNF;
    private com.baidu.tieba.frs.g.g cOH;
    public TbImageView ccC;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ae(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abs() != null) {
                    j.this.abs().a(view, j.this.ajM);
                }
                j.this.dN(view == j.this.bZb);
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abs() != null) {
                    j.this.abs().a(view, j.this.ajM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bZa.setAfterClickListener(this.aob);
        }
        this.bZa.wk();
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.bam = view.findViewById(d.g.divider_line);
        this.biR = view.findViewById(d.g.top_divider_line);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bvD.setUserAfterClickListener(this.aob);
        this.bvD.setFrom(3);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bvH.setOnClickListener(this.bZf);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setShareVisible(true);
        this.bvH.setShareReportFrom(1);
        this.bvH.setFrom(2);
        this.bvH.setStType("frs_page");
        this.bvH.anM = 3;
        if (view instanceof ViewGroup) {
            this.cOH = new com.baidu.tieba.frs.g.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.cOH = new com.baidu.tieba.frs.g.g(this.mPageContext, this.bvD);
        }
        this.cOH.setUniqueId(getTag());
        this.bZb = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZb.setOnClickListener(this.bZf);
        this.ccC = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccC.setPageId(getTag());
        this.bvK = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ae(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.bam, d.C0082d.cp_bg_line_e);
            aj.k(this.biR, d.C0082d.cp_bg_line_e);
            this.bvH.onChangeSkinType();
            this.bvD.onChangeSkinType();
            this.bZb.onChangeSkinType();
            this.cOH.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: y */
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
            getView().setOnClickListener(this.bZf);
        }
        if (!abw() && com.baidu.tieba.card.k.jR(this.ajM.getId())) {
            abx();
        }
        this.cOH.S(this.ajM);
        this.bvD.setData(this.ajM);
        this.bZb.setData(this.ajM.sO());
        if (!this.cNF) {
            this.bvH.setData(bdVar);
        }
        this.bvD.setUserAfterClickListener(this.aob);
        if (this.bvD.getHeaderImg() != null) {
            if (this.bvD.getIsSimpleThread()) {
                this.bvD.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (bdVar.rx() == null || bdVar.rx().getPendantData() == null || StringUtils.isNull(bdVar.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.bvD.getHeaderImg().setVisibility(0);
                this.bvD.getHeaderImg().setData(bdVar);
            } else {
                this.bvD.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(bdVar);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        B(bdVar);
    }

    public void B(bd bdVar) {
        MetaData rx;
        if (bdVar != null && this.ccC != null && (rx = bdVar.rx()) != null) {
            final ThemeCardInUserData themeCard = rx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccC.setVisibility(8);
                return;
            }
            this.ccC.setVisibility(0);
            this.ccC.setImageBitmap(null);
            this.ccC.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvH != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvD != null) {
            this.bvD.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(boolean z) {
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jQ(this.ajM.getId());
            abx();
            m su = this.ajM.su();
            if (su != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aU(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.ajM.aad;
            if (this.ajM.aac == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VS;
                long j = jVar.VT;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wg = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajM.getFid()));
            addLocateParam.setForumName(this.ajM.rD());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abw() {
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
    public void abx() {
        com.baidu.tieba.card.k.a(this.bZb.getGodReplyContent(), this.ajM.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
    }

    public void fm(boolean z) {
        this.cNF = z;
    }
}
