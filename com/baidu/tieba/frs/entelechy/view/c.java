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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class c extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected bb atD;
    private final View.OnClickListener axO;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    protected ThreadSourceShareAndPraiseLayout bIC;
    public LinearLayout bIN;
    private HeadPendantClickableView bIz;
    public View bkE;
    public View bsS;
    public TbImageView cAK;
    private TbImageView cAM;
    private ThreadGodReplyLayout cwv;
    private View.OnClickListener cwy;
    private com.baidu.tieba.frs.vc.g duX;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ah(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.atD);
                }
                c.this.es(view == c.this.cwv);
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.atD);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bIz = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bIz.setAfterClickListener(this.axO);
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.cAM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.bkE = view.findViewById(d.g.divider_line);
        this.bsS = view.findViewById(d.g.top_divider_line);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bHN.setUserAfterClickListener(this.axO);
        this.bHN.setFrom(3);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwy);
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
            this.duX = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.duX = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bHN);
        }
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this.cwy);
        this.bIC.setFrom(2);
        this.bIC.setShareReportFrom(1);
        this.bIC.setSourceFromForPb(3);
        this.bIC.setStType("frs_page");
        this.bIC.setHideBarName(true);
        this.bIC.ayr.setNeedAddReplyIcon(true);
        this.duX.setUniqueId(getTag());
        this.cwv = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cwv.setOnClickListener(this.cwy);
        this.cAK = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cAK.setPageId(getTag());
        this.bIN = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ah(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.j(this.bkE, d.C0140d.cp_bg_line_e);
            am.j(this.bsS, d.C0140d.cp_bg_line_e);
            this.bHO.onChangeSkinType();
            this.bHN.onChangeSkinType();
            this.cwv.onChangeSkinType();
            this.duX.onChangeSkinType();
            if (this.bIC != null && this.bIC.getVisibility() == 0) {
                this.bIC.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void M(final bb bbVar) {
        if (this.cAM != null) {
            if (this.cAK == null || bbVar == null) {
                this.cAM.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI) && this.cAK.getVisibility() != 0) {
                if (this.duX != null && this.duX.aAM() && (this.cAM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAM.getLayoutParams();
                    layoutParams.rightMargin = l.f(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cAM.setLayoutParams(layoutParams);
                }
                this.cAM.setVisibility(0);
                this.cAM.setImageDrawable(null);
                this.cAM.startLoad(bbVar.ajI, 10, false);
                this.cAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAM.setVisibility(8);
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
        this.atD = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        if (!aiD() && o.kX(this.atD.getId())) {
            aiE();
        }
        P(bbVar);
        this.duX.ae(this.atD);
        M(bbVar);
        this.bHN.setData(this.atD);
        this.cwv.setData(this.atD.wx());
        this.bHN.setUserAfterClickListener(this.axO);
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (bbVar.vk() == null || bbVar.vk().getPendantData() == null || StringUtils.isNull(bbVar.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(bbVar);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(bbVar);
            }
        }
        hn(gu(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void P(bb bbVar) {
        MetaData vk;
        if (bbVar != null && this.cAK != null && (vk = bbVar.vk()) != null) {
            final ThemeCardInUserData themeCard = vk.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAK.setVisibility(8);
                return;
            }
            this.cAK.setVisibility(0);
            this.cAK.setImageBitmap(null);
            this.cAK.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
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
        if (this.atD != null) {
            o.kW(this.atD.getId());
            aiE();
            m wd = this.atD.wd();
            if (wd != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.aU(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), wd.getCartoonId(), wd.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.atD.ajf;
            if (this.atD.aje == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aeD;
                long j = jVar.aeE;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aeR = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atD, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aiD() {
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
    public void hl(int i) {
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
    public void aiE() {
        o.a(this.cwv.getGodReplyContent(), this.atD.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout VA() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VB() {
        return this.bIC.ayr;
    }

    public void hn(int i) {
        if (this.atD != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.atD);
                return;
            }
            this.bHO.setData(this.atD);
            this.bIC.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
