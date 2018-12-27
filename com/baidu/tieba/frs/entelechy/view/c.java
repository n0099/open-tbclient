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
    protected bb aFg;
    private final View.OnClickListener aKC;
    public View bLW;
    public View byS;
    private ThreadGodReplyLayout cVg;
    private View.OnClickListener cVj;
    public TbImageView cZw;
    private TbImageView cZy;
    public ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    private String caz;
    public LinearLayout cbK;
    private HeadPendantClickableView cbw;
    protected ThreadSourceShareAndPraiseLayout cbz;
    private com.baidu.tieba.frs.vc.g dUa;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void aA(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.aFg);
                }
                c.this.fp(view == c.this.cVg);
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.aFg);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cbw = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
            this.cbw.setAfterClickListener(this.aKC);
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.cZy = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.byS = view.findViewById(e.g.divider_line);
        this.bLW = view.findViewById(e.g.top_divider_line);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caL.setUserAfterClickListener(this.aKC);
        this.caL.setFrom(3);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this.cVj);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setIsBarViewVisible(false);
        this.caM.setForumAfterClickListener(this.aKC);
        this.caM.setShareVisible(true);
        this.caM.setShareReportFrom(1);
        this.caM.setFrom(2);
        this.caM.setDisPraiseFrom(2);
        this.caM.setStType("frs_page");
        this.caM.avM = 3;
        if (view instanceof ViewGroup) {
            this.dUa = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dUa = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.caL);
        }
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this.cVj);
        this.cbz.setFrom(2);
        this.cbz.setShareReportFrom(1);
        this.cbz.setSourceFromForPb(3);
        this.cbz.setStType("frs_page");
        this.cbz.setHideBarName(true);
        this.cbz.aKk.setNeedAddReplyIcon(true);
        this.dUa.setUniqueId(getTag());
        this.cVg = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVg.setOnClickListener(this.cVj);
        this.cZw = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cZw.setPageId(getTag());
        this.cbK = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        aA(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.byS, e.d.cp_bg_line_e);
            al.j(this.bLW, e.d.cp_bg_line_e);
            this.caM.onChangeSkinType();
            this.caL.onChangeSkinType();
            this.cVg.onChangeSkinType();
            this.dUa.onChangeSkinType();
            if (this.cbz != null && this.cbz.getVisibility() == 0) {
                this.cbz.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void N(final bb bbVar) {
        if (this.cZy != null) {
            if (this.cZw == null || bbVar == null) {
                this.cZy.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu) && this.cZw.getVisibility() != 0) {
                if (this.dUa != null && this.dUa.aIh() && (this.cZy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cZy.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.cZy.setLayoutParams(layoutParams);
                }
                this.cZy.setVisibility(0);
                this.cZy.setImageDrawable(null);
                this.cZy.startLoad(bbVar.avu, 10, false);
                this.cZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cZy.setVisibility(8);
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
        this.aFg = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        if (!apW() && o.mH(this.aFg.getId())) {
            apX();
        }
        Q(bbVar);
        this.dUa.af(this.aFg);
        N(bbVar);
        this.caL.setData(this.aFg);
        this.cVg.setData(this.aFg.AX());
        this.caL.setUserAfterClickListener(this.aKC);
        if (this.caL.getHeaderImg() != null) {
            if (this.caL.getIsSimpleThread()) {
                this.caL.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (bbVar.zG() == null || bbVar.zG().getPendantData() == null || StringUtils.isNull(bbVar.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.caL.getHeaderImg().setVisibility(0);
                this.caL.getHeaderImg().setData(bbVar);
            } else {
                this.caL.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(bbVar);
            }
        }
        iM(hD(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void Q(bb bbVar) {
        MetaData zG;
        if (bbVar != null && this.cZw != null && (zG = bbVar.zG()) != null) {
            final ThemeCardInUserData themeCard = zG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cZw.setVisibility(8);
                return;
            }
            this.cZw.setVisibility(0);
            this.cZw.setImageBitmap(null);
            this.cZw.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caM != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.aFg != null) {
            o.mG(this.aFg.getId());
            apX();
            m AB = this.aFg.AB();
            if (AB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AB.getCartoonId(), AB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFg.auP;
            if (this.aFg.auO == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqo;
                long j = jVar.aqp;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aqC = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFg, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean apW() {
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
    public void iK(int i) {
        this.currentPageType = i;
        if (this.caM != null) {
            this.caM.avM = i;
            if (i == 15) {
                this.caM.setFrom(10);
                return;
            }
            this.caM.setFrom(2);
            this.caM.setDisPraiseFrom(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apX() {
        o.a(this.cVg.getGodReplyContent(), this.aFg.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout acq() {
        return this.caM;
    }

    public ThreadCommentAndPraiseInfoLayout acr() {
        return this.cbz.aKk;
    }

    public void iM(int i) {
        if (this.aFg != null) {
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setData(this.aFg);
                return;
            }
            this.caM.setData(this.aFg);
            this.cbz.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }
}
