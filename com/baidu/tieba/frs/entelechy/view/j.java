package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.tieba.card.a<bh> implements v {
    public View aXa;
    protected bh ajq;
    private final View.OnClickListener anS;
    private HeadPendantClickableView bQP;
    private ThreadGodReplyLayout bQQ;
    private View.OnClickListener bQU;
    public ThreadCommentAndPraiseInfoLayout boD;
    public LinearLayout boH;
    private ThreadUserInfoLayout boz;
    private boolean cEi;
    public View cFQ;
    private com.baidu.tieba.frs.g.g cFi;
    public TbImageView czF;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ad(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Zx() != null) {
                    j.this.Zx().a(view, j.this.ajq);
                }
                j.this.dy(view == j.this.bQQ);
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Zx() != null) {
                    j.this.Zx().a(view, j.this.ajq);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.bQP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bQP.setAfterClickListener(this.anS);
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.aXa = view.findViewById(d.g.divider_line);
        this.cFQ = view.findViewById(d.g.top_divider_line);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.boz = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.boz.setUserAfterClickListener(this.anS);
        this.boz.setFrom(3);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this.bQU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setIsBarViewVisible(false);
        this.boD.setShareVisible(true);
        this.boD.setShareReportFrom(1);
        this.boD.setFrom(2);
        this.boD.setStType("frs_page");
        this.cFi = new com.baidu.tieba.frs.g.g(this.mPageContext, this.boz);
        this.cFi.setUniqueId(getTag());
        this.bQQ = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bQQ.setOnClickListener(this.bQU);
        this.czF = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.czF.setPageId(getTag());
        this.boH = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ad(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.aXa, d.C0080d.cp_bg_line_e);
            aj.k(this.cFQ, d.C0080d.cp_bg_line_e);
            this.boD.onChangeSkinType();
            this.boz.onChangeSkinType();
            this.bQQ.onChangeSkinType();
            this.cFi.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajq = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bQU);
        }
        if (!ZB() && m.jL(this.ajq.getId())) {
            ZC();
        }
        this.cFi.Q(this.ajq);
        this.boz.setData(this.ajq);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.boD.setLayoutParams(layoutParams);
        this.bQQ.setData(this.ajq.sL());
        if (!this.cEi) {
            this.boD.setData(bhVar);
        }
        this.boz.setUserAfterClickListener(this.anS);
        if (this.boz.getHeaderImg() != null) {
            if (this.boz.getIsSimpleThread()) {
                this.boz.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (bhVar.rt() == null || bhVar.rt().getPendantData() == null || StringUtils.isNull(bhVar.rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.boz.getHeaderImg().setVisibility(0);
                this.boz.getHeaderImg().setData(bhVar);
            } else {
                this.boz.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(bhVar);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        G(bhVar);
    }

    public void G(bh bhVar) {
        MetaData rt;
        if (bhVar != null && this.czF != null && (rt = bhVar.rt()) != null) {
            final ThemeCardInUserData themeCard = rt.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.czF.setVisibility(8);
                return;
            }
            this.czF.setVisibility(0);
            this.czF.setImageBitmap(null);
            this.czF.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.czF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boD != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.boz != null) {
            this.boz.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        if (this.ajq != null) {
            m.jK(this.ajq.getId());
            ZC();
            n sr = this.ajq.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ajq.ZK;
            if (this.ajq.ZJ == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Vl;
                long j = kVar.Vm;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.VJ = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajq, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajq.getFid()));
            addLocateParam.setForumName(this.ajq.rz());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZB() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZC() {
        m.a(this.bQQ.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
    }

    public void eQ(boolean z) {
        this.cEi = z;
    }
}
