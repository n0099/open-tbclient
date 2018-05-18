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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class c extends com.baidu.tieba.card.a<bd> implements com.baidu.tieba.a.e, aa {
    protected bd alf;
    private final View.OnClickListener apj;
    public View ban;
    public View biI;
    private String bwO;
    private HeadPendantClickableView bxM;
    protected ThreadSourceShareAndPraiseLayout bxQ;
    private ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    public LinearLayout byb;
    private ThreadGodReplyLayout cnh;
    private View.OnClickListener cnk;
    public TbImageView crL;
    private TbImageView crN;
    private com.baidu.tieba.frs.vc.g dfM;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ac(View view2);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.alf);
                }
                c.this.eo(view2 == c.this.cnh);
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.alf);
                }
            }
        };
        View view2 = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bxM = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bxM.setAfterClickListener(this.apj);
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.crN = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
        this.ban = view2.findViewById(d.g.divider_line);
        this.biI = view2.findViewById(d.g.top_divider_line);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bxa.setUserAfterClickListener(this.apj);
        this.bxa.setFrom(3);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this.cnk);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setShareVisible(true);
        this.bxb.setShareReportFrom(1);
        this.bxb.setFrom(2);
        this.bxb.setStType("frs_page");
        this.bxb.abW = 3;
        if (view2 instanceof ViewGroup) {
            this.dfM = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view2);
        } else {
            this.dfM = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bxa);
        }
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this.cnk);
        this.bxQ.setFrom(2);
        this.bxQ.setShareReportFrom(1);
        this.bxQ.setSourceFromForPb(3);
        this.bxQ.setStType("frs_page");
        this.bxQ.setHideBarName(true);
        this.bxQ.apG.setNeedAddReplyIcon(true);
        this.dfM.setUniqueId(getTag());
        this.cnh = (ThreadGodReplyLayout) view2.findViewById(d.g.card_home_page_god_reply_layout);
        this.cnh.setOnClickListener(this.cnk);
        this.crL = (TbImageView) view2.findViewById(d.g.frs_normal_item_theme_card);
        this.crL.setPageId(getTag());
        this.byb = (LinearLayout) view2.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ac(view2);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.j(this.ban, d.C0126d.cp_bg_line_e);
            ak.j(this.biI, d.C0126d.cp_bg_line_e);
            this.bxb.onChangeSkinType();
            this.bxa.onChangeSkinType();
            this.cnh.onChangeSkinType();
            this.dfM.onChangeSkinType();
            if (this.bxQ != null && this.bxQ.getVisibility() == 0) {
                this.bxQ.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void I(final bd bdVar) {
        if (this.crN != null) {
            if (this.crL == null || bdVar == null) {
                this.crN.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abN) && this.crL.getVisibility() != 0) {
                if (this.dfM != null && this.dfM.avq() && (this.crN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.crN.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.crN.setLayoutParams(layoutParams);
                }
                this.crN.setVisibility(0);
                this.crN.setImageDrawable(null);
                this.crN.startLoad(bdVar.abN, 10, false);
                this.crN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bdVar.abO, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.crN.setVisibility(8);
            }
        }
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
        this.alf = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cnk);
        }
        if (!afd() && o.kz(this.alf.getId())) {
            afe();
        }
        L(bdVar);
        this.dfM.X(this.alf);
        I(bdVar);
        this.bxa.setData(this.alf);
        this.cnh.setData(this.alf.tb());
        this.bxa.setUserAfterClickListener(this.apj);
        if (this.bxa.getHeaderImg() != null) {
            if (this.bxa.getIsSimpleThread()) {
                this.bxa.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (bdVar.rP() == null || bdVar.rP().getPendantData() == null || StringUtils.isNull(bdVar.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.bxa.getHeaderImg().setVisibility(0);
                this.bxa.getHeaderImg().setData(bdVar);
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(bdVar);
            }
        }
        hc(gn(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void L(bd bdVar) {
        MetaData rP;
        if (bdVar != null && this.crL != null && (rP = bdVar.rP()) != null) {
            final ThemeCardInUserData themeCard = rP.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crL.setVisibility(8);
                return;
            }
            this.crL.setVisibility(0);
            this.crL.setImageBitmap(null);
            this.crL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.crL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bxb != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bxa != null) {
            this.bxa.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        if (this.alf != null) {
            o.ky(this.alf.getId());
            afe();
            n sH = this.alf.sH();
            if (sH != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    az.aJ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), sH.getCartoonId(), sH.getChapterId(), 2)));
                return;
            }
            k kVar = this.alf.abj;
            if (this.alf.abi == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.WT;
                long j = kVar.WU;
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.pageContext = this.mPageContext;
                alVar.Xh = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.alf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.alf.getFid()));
            addLocateParam.setForumName(this.alf.rU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean afd() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afe() {
        o.a(this.cnh.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bxb;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        return this.bxQ.apG;
    }

    public void hc(int i) {
        if (this.alf != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setData(this.alf);
                return;
            }
            this.bxb.setData(this.alf);
            this.bxQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
