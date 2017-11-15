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
    public View aXj;
    protected bh ajq;
    private final View.OnClickListener anR;
    private HeadPendantClickableView bRc;
    private ThreadGodReplyLayout bRd;
    private View.OnClickListener bRh;
    private ThreadUserInfoLayout boI;
    public ThreadCommentAndPraiseInfoLayout boM;
    public LinearLayout boQ;
    private boolean cEB;
    private com.baidu.tieba.frs.g.g cFB;
    public View cGj;
    public TbImageView czY;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ad(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.ZJ() != null) {
                    j.this.ZJ().a(view, j.this.ajq);
                }
                j.this.dD(view == j.this.bRd);
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.ZJ() != null) {
                    j.this.ZJ().a(view, j.this.ajq);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.bRc = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bRc.setAfterClickListener(this.anR);
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.aXj = view.findViewById(d.g.divider_line);
        this.cGj = view.findViewById(d.g.top_divider_line);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.boI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.boI.setUserAfterClickListener(this.anR);
        this.boI.setFrom(3);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this.bRh);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setIsBarViewVisible(false);
        this.boM.setShareVisible(true);
        this.boM.setShareReportFrom(1);
        this.boM.setFrom(2);
        this.boM.setStType("frs_page");
        this.cFB = new com.baidu.tieba.frs.g.g(this.mPageContext, this.boI);
        this.cFB.setUniqueId(getTag());
        this.bRd = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bRd.setOnClickListener(this.bRh);
        this.czY = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.czY.setPageId(getTag());
        this.boQ = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ad(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.aXj, d.C0080d.cp_bg_line_e);
            aj.k(this.cGj, d.C0080d.cp_bg_line_e);
            this.boM.onChangeSkinType();
            this.boI.onChangeSkinType();
            this.bRd.onChangeSkinType();
            this.cFB.onChangeSkinType();
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
            getView().setOnClickListener(this.bRh);
        }
        if (!ZN() && m.jM(this.ajq.getId())) {
            ZO();
        }
        this.cFB.Q(this.ajq);
        this.boI.setData(this.ajq);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.boM.setLayoutParams(layoutParams);
        this.bRd.setData(this.ajq.sL());
        if (!this.cEB) {
            this.boM.setData(bhVar);
        }
        this.boI.setUserAfterClickListener(this.anR);
        if (this.boI.getHeaderImg() != null) {
            if (this.boI.getIsSimpleThread()) {
                this.boI.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (bhVar.rt() == null || bhVar.rt().getPendantData() == null || StringUtils.isNull(bhVar.rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.boI.getHeaderImg().setVisibility(0);
                this.boI.getHeaderImg().setData(bhVar);
            } else {
                this.boI.getHeaderImg().setVisibility(4);
                this.bRc.setVisibility(0);
                this.bRc.setData(bhVar);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        G(bhVar);
    }

    public void G(bh bhVar) {
        MetaData rt;
        if (bhVar != null && this.czY != null && (rt = bhVar.rt()) != null) {
            final ThemeCardInUserData themeCard = rt.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.czY.setVisibility(8);
                return;
            }
            this.czY.setVisibility(0);
            this.czY.setImageBitmap(null);
            this.czY.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.czY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boM != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.boI != null) {
            this.boI.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.ajq != null) {
            m.jL(this.ajq.getId());
            ZO();
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

    private boolean ZN() {
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
    public void ZO() {
        m.a(this.bRd.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
    }

    public void eV(boolean z) {
        this.cEB = z;
    }
}
