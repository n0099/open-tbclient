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
    public View bam;
    public View bis;
    private String bvX;
    private HeadPendantClickableView bwV;
    protected ThreadSourceShareAndPraiseLayout bwZ;
    private ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    public LinearLayout bxk;
    private ThreadGodReplyLayout cma;
    private View.OnClickListener cme;
    public TbImageView cqE;
    private TbImageView cqG;
    private com.baidu.tieba.frs.vc.g deI;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ac(View view2);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cme = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.alf);
                }
                c.this.en(view2 == c.this.cma);
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
        this.bwV = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bwV.setAfterClickListener(this.apj);
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.cqG = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
        this.bam = view2.findViewById(d.g.divider_line);
        this.bis = view2.findViewById(d.g.top_divider_line);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bwj.setUserAfterClickListener(this.apj);
        this.bwj.setFrom(3);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this.cme);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setShareVisible(true);
        this.bwk.setShareReportFrom(1);
        this.bwk.setFrom(2);
        this.bwk.setStType("frs_page");
        this.bwk.abV = 3;
        if (view2 instanceof ViewGroup) {
            this.deI = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view2);
        } else {
            this.deI = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bwj);
        }
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.cme);
        this.bwZ.setFrom(2);
        this.bwZ.setShareReportFrom(1);
        this.bwZ.setSourceFromForPb(3);
        this.bwZ.setStType("frs_page");
        this.bwZ.setHideBarName(true);
        this.bwZ.apG.setNeedAddReplyIcon(true);
        this.deI.setUniqueId(getTag());
        this.cma = (ThreadGodReplyLayout) view2.findViewById(d.g.card_home_page_god_reply_layout);
        this.cma.setOnClickListener(this.cme);
        this.cqE = (TbImageView) view2.findViewById(d.g.frs_normal_item_theme_card);
        this.cqE.setPageId(getTag());
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ac(view2);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.j(this.bam, d.C0126d.cp_bg_line_e);
            ak.j(this.bis, d.C0126d.cp_bg_line_e);
            this.bwk.onChangeSkinType();
            this.bwj.onChangeSkinType();
            this.cma.onChangeSkinType();
            this.deI.onChangeSkinType();
            if (this.bwZ != null && this.bwZ.getVisibility() == 0) {
                this.bwZ.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void I(final bd bdVar) {
        if (this.cqG != null) {
            if (this.cqE == null || bdVar == null) {
                this.cqG.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abM) && this.cqE.getVisibility() != 0) {
                if (this.deI != null && this.deI.avr() && (this.cqG.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqG.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cqG.setLayoutParams(layoutParams);
                }
                this.cqG.setVisibility(0);
                this.cqG.setImageDrawable(null);
                this.cqG.startLoad(bdVar.abM, 10, false);
                this.cqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bdVar.abN, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.cqG.setVisibility(8);
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
            getView().setOnClickListener(this.cme);
        }
        if (!afd() && o.kw(this.alf.getId())) {
            afe();
        }
        L(bdVar);
        this.deI.X(this.alf);
        I(bdVar);
        this.bwj.setData(this.alf);
        this.cma.setData(this.alf.tc());
        this.bwj.setUserAfterClickListener(this.apj);
        if (this.bwj.getHeaderImg() != null) {
            if (this.bwj.getIsSimpleThread()) {
                this.bwj.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (bdVar.rQ() == null || bdVar.rQ().getPendantData() == null || StringUtils.isNull(bdVar.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.bwj.getHeaderImg().setVisibility(0);
                this.bwj.getHeaderImg().setData(bdVar);
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(bdVar);
            }
        }
        hb(gm(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void L(bd bdVar) {
        MetaData rQ;
        if (bdVar != null && this.cqE != null && (rQ = bdVar.rQ()) != null) {
            final ThemeCardInUserData themeCard = rQ.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cqE.setVisibility(8);
                return;
            }
            this.cqE.setVisibility(0);
            this.cqE.setImageBitmap(null);
            this.cqE.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cqE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bwk != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(boolean z) {
        if (this.alf != null) {
            o.kv(this.alf.getId());
            afe();
            n sI = this.alf.sI();
            if (sI != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    az.aJ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), sI.getCartoonId(), sI.getChapterId(), 2)));
                return;
            }
            k kVar = this.alf.abi;
            if (this.alf.abh == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.WS;
                long j = kVar.WT;
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.pageContext = this.mPageContext;
                alVar.Xg = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.alf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.alf.getFid()));
            addLocateParam.setForumName(this.alf.rV());
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
        o.a(this.cma.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bwk;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        return this.bwZ.apG;
    }

    public void hb(int i) {
        if (this.alf != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setData(this.alf);
                return;
            }
            this.bwk.setData(this.alf);
            this.bwZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
