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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public abstract class c extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected bb atE;
    private final View.OnClickListener axL;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    protected ThreadSourceShareAndPraiseLayout bIC;
    public LinearLayout bIN;
    private HeadPendantClickableView bIz;
    public View bkJ;
    public View bsU;
    public TbImageView cAH;
    private TbImageView cAJ;
    private ThreadGodReplyLayout cws;
    private View.OnClickListener cwv;
    private com.baidu.tieba.frs.vc.g duU;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ah(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.atE);
                }
                c.this.es(view == c.this.cws);
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.atE);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bIz = (HeadPendantClickableView) view.findViewById(f.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), f.e.ds70));
            this.bIz.setAfterClickListener(this.axL);
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.cAJ = (TbImageView) view.findViewById(f.g.frs_normal_item_star_view);
        this.bkJ = view.findViewById(f.g.divider_line);
        this.bsU = view.findViewById(f.g.top_divider_line);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_user_info_layout);
        this.bHN.setUserAfterClickListener(this.axL);
        this.bHN.setFrom(3);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwv);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShareVisible(true);
        this.bHO.setShareReportFrom(1);
        this.bHO.setFrom(2);
        this.bHO.setStType("frs_page");
        this.bHO.ajY = 3;
        if (view instanceof ViewGroup) {
            this.duU = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.duU = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bHN);
        }
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_link_thread_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this.cwv);
        this.bIC.setFrom(2);
        this.bIC.setShareReportFrom(1);
        this.bIC.setSourceFromForPb(3);
        this.bIC.setStType("frs_page");
        this.bIC.setHideBarName(true);
        this.bIC.ayo.setNeedAddReplyIcon(true);
        this.duU.setUniqueId(getTag());
        this.cws = (ThreadGodReplyLayout) view.findViewById(f.g.card_home_page_god_reply_layout);
        this.cws.setOnClickListener(this.cwv);
        this.cAH = (TbImageView) view.findViewById(f.g.frs_normal_item_theme_card);
        this.cAH.setPageId(getTag());
        this.bIN = (LinearLayout) view.findViewById(f.g.card_home_page_normal_thread_content_layout);
        ah(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.addresslist_item_bg);
            am.j(this.bkJ, f.d.cp_bg_line_e);
            am.j(this.bsU, f.d.cp_bg_line_e);
            this.bHO.onChangeSkinType();
            this.bHN.onChangeSkinType();
            this.cws.onChangeSkinType();
            this.duU.onChangeSkinType();
            if (this.bIC != null && this.bIC.getVisibility() == 0) {
                this.bIC.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void M(final bb bbVar) {
        if (this.cAJ != null) {
            if (this.cAH == null || bbVar == null) {
                this.cAJ.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI) && this.cAH.getVisibility() != 0) {
                if (this.duU != null && this.duU.aAJ() && (this.cAJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAJ.getLayoutParams();
                    layoutParams.rightMargin = l.f(this.mPageContext.getPageActivity(), f.e.tbds106);
                    this.cAJ.setLayoutParams(layoutParams);
                }
                this.cAJ.setVisibility(0);
                this.cAJ.setImageDrawable(null);
                this.cAJ.startLoad(bbVar.ajI, 10, false);
                this.cAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAJ.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atE = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwv);
        }
        if (!aiG() && o.kZ(this.atE.getId())) {
            aiH();
        }
        P(bbVar);
        this.duU.ae(this.atE);
        M(bbVar);
        this.bHN.setData(this.atE);
        this.cws.setData(this.atE.ww());
        this.bHN.setUserAfterClickListener(this.axL);
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (bbVar.vj() == null || bbVar.vj().getPendantData() == null || StringUtils.isNull(bbVar.vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(bbVar);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(bbVar);
            }
        }
        hm(gt(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void P(bb bbVar) {
        MetaData vj;
        if (bbVar != null && this.cAH != null && (vj = bbVar.vj()) != null) {
            final ThemeCardInUserData themeCard = vj.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAH.setVisibility(8);
                return;
            }
            this.cAH.setVisibility(0);
            this.cAH.setImageBitmap(null);
            this.cAH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHO != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.atE != null) {
            o.kY(this.atE.getId());
            aiH();
            m wc = this.atE.wc();
            if (wc != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.core.util.bb.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), wc.getCartoonId(), wc.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.atE.ajf;
            if (this.atE.aje == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aeD;
                long j = jVar.aeE;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aeR = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atE, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aiG() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.currentPageType = i;
        if (this.bHO != null) {
            this.bHO.ajY = i;
            if (i == 15) {
                this.bHO.setFrom(10);
            } else {
                this.bHO.setFrom(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiH() {
        o.a(this.cws.getGodReplyContent(), this.atE.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout VD() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VE() {
        return this.bIC.ayo;
    }

    public void hm(int i) {
        if (this.atE != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.atE);
                return;
            }
            this.bHO.setData(this.atE);
            this.bIC.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
