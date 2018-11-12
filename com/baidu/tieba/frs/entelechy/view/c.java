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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class c extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected bb aBF;
    private final View.OnClickListener aHa;
    public View bIe;
    private String bWE;
    public ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    protected ThreadSourceShareAndPraiseLayout bXE;
    public LinearLayout bXP;
    public View bvs;
    private ThreadGodReplyLayout cLJ;
    private View.OnClickListener cLM;
    public TbImageView cPZ;
    private TbImageView cQb;
    private com.baidu.tieba.frs.vc.g dKG;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ax(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.aBF);
                }
                c.this.fm(view == c.this.cLJ);
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.aBF);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bXB = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0200e.ds70));
            this.bXB.setAfterClickListener(this.aHa);
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.cQb = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.bvs = view.findViewById(e.g.divider_line);
        this.bIe = view.findViewById(e.g.top_divider_line);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bWQ.setUserAfterClickListener(this.aHa);
        this.bWQ.setFrom(3);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setShareVisible(true);
        this.bWR.setShareReportFrom(1);
        this.bWR.setFrom(2);
        this.bWR.setDisPraiseFrom(2);
        this.bWR.setStType("frs_page");
        this.bWR.asl = 3;
        if (view instanceof ViewGroup) {
            this.dKG = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dKG = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bWQ);
        }
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this.cLM);
        this.bXE.setFrom(2);
        this.bXE.setShareReportFrom(1);
        this.bXE.setSourceFromForPb(3);
        this.bXE.setStType("frs_page");
        this.bXE.setHideBarName(true);
        this.bXE.aGI.setNeedAddReplyIcon(true);
        this.dKG.setUniqueId(getTag());
        this.cLJ = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cLJ.setOnClickListener(this.cLM);
        this.cPZ = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cPZ.setPageId(getTag());
        this.bXP = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        ax(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.bvs, e.d.cp_bg_line_e);
            al.j(this.bIe, e.d.cp_bg_line_e);
            this.bWR.onChangeSkinType();
            this.bWQ.onChangeSkinType();
            this.cLJ.onChangeSkinType();
            this.dKG.onChangeSkinType();
            if (this.bXE != null && this.bXE.getVisibility() == 0) {
                this.bXE.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void N(final bb bbVar) {
        if (this.cQb != null) {
            if (this.cPZ == null || bbVar == null) {
                this.cQb.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arU) && this.cPZ.getVisibility() != 0) {
                if (this.dKG != null && this.dKG.aFG() && (this.cQb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cQb.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0200e.tbds106);
                    this.cQb.setLayoutParams(layoutParams);
                }
                this.cQb.setVisibility(0);
                this.cQb.setImageDrawable(null);
                this.cQb.startLoad(bbVar.arU, 10, false);
                this.cQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.arV, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cQb.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aBF = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cLM);
        }
        if (!anu() && o.mf(this.aBF.getId())) {
            anv();
        }
        Q(bbVar);
        this.dKG.af(this.aBF);
        N(bbVar);
        this.bWQ.setData(this.aBF);
        this.cLJ.setData(this.aBF.zT());
        this.bWQ.setUserAfterClickListener(this.aHa);
        if (this.bWQ.getHeaderImg() != null) {
            if (this.bWQ.getIsSimpleThread()) {
                this.bWQ.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (bbVar.yC() == null || bbVar.yC().getPendantData() == null || StringUtils.isNull(bbVar.yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.bWQ.getHeaderImg().setVisibility(0);
                this.bWQ.getHeaderImg().setData(bbVar);
            } else {
                this.bWQ.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(bbVar);
            }
        }
        ix(ho(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void Q(bb bbVar) {
        MetaData yC;
        if (bbVar != null && this.cPZ != null && (yC = bbVar.yC()) != null) {
            final ThemeCardInUserData themeCard = yC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cPZ.setVisibility(8);
                return;
            }
            this.cPZ.setVisibility(0);
            this.cPZ.setImageBitmap(null);
            this.cPZ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWR != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bWQ != null) {
            this.bWQ.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (this.aBF != null) {
            o.me(this.aBF.getId());
            anv();
            m zx = this.aBF.zx();
            if (zx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bF(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zx.getCartoonId(), zx.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aBF.arp;
            if (this.aBF.aro == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.amN;
                long j = jVar.amO;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.anb = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aBF, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean anu() {
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
    public void iv(int i) {
        this.currentPageType = i;
        if (this.bWR != null) {
            this.bWR.asl = i;
            if (i == 15) {
                this.bWR.setFrom(10);
                return;
            }
            this.bWR.setFrom(2);
            this.bWR.setDisPraiseFrom(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anv() {
        o.a(this.cLJ.getGodReplyContent(), this.aBF.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout abi() {
        return this.bWR;
    }

    public ThreadCommentAndPraiseInfoLayout abj() {
        return this.bXE.aGI;
    }

    public void ix(int i) {
        if (this.aBF != null) {
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setData(this.aBF);
                return;
            }
            this.bWR.setData(this.aBF);
            this.bXE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }
}
