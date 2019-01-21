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
    protected bb aFJ;
    private final View.OnClickListener aLf;
    public View bMK;
    public View bzH;
    private ThreadGodReplyLayout cVS;
    private View.OnClickListener cVV;
    private String cbl;
    public ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    protected ThreadSourceShareAndPraiseLayout ccl;
    public LinearLayout ccx;
    private com.baidu.tieba.frs.vc.g dUH;
    public TbImageView dai;
    private TbImageView dak;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void aA(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.aFJ);
                }
                c.this.fs(view == c.this.cVS);
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.aFJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cci = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
            this.cci.setAfterClickListener(this.aLf);
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.dak = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.bzH = view.findViewById(e.g.divider_line);
        this.bMK = view.findViewById(e.g.top_divider_line);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbx.setUserAfterClickListener(this.aLf);
        this.cbx.setFrom(3);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this.cVV);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setIsBarViewVisible(false);
        this.cby.setForumAfterClickListener(this.aLf);
        this.cby.setShareVisible(true);
        this.cby.setShareReportFrom(1);
        this.cby.setFrom(2);
        this.cby.setDisPraiseFrom(2);
        this.cby.setStType("frs_page");
        this.cby.awp = 3;
        if (view instanceof ViewGroup) {
            this.dUH = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dUH = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cbx);
        }
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this.cVV);
        this.ccl.setFrom(2);
        this.ccl.setShareReportFrom(1);
        this.ccl.setSourceFromForPb(3);
        this.ccl.setStType("frs_page");
        this.ccl.setHideBarName(true);
        this.ccl.aKN.setNeedAddReplyIcon(true);
        this.dUH.setUniqueId(getTag());
        this.cVS = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVS.setOnClickListener(this.cVV);
        this.dai = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.dai.setPageId(getTag());
        this.ccx = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        aA(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.bzH, e.d.cp_bg_line_e);
            al.j(this.bMK, e.d.cp_bg_line_e);
            this.cby.onChangeSkinType();
            this.cbx.onChangeSkinType();
            this.cVS.onChangeSkinType();
            this.dUH.onChangeSkinType();
            if (this.ccl != null && this.ccl.getVisibility() == 0) {
                this.ccl.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void N(final bb bbVar) {
        if (this.dak != null) {
            if (this.dai == null || bbVar == null) {
                this.dak.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avX) && this.dai.getVisibility() != 0) {
                if (this.dUH != null && this.dUH.aIE() && (this.dak.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dak.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.dak.setLayoutParams(layoutParams);
                }
                this.dak.setVisibility(0);
                this.dak.setImageDrawable(null);
                this.dak.startLoad(bbVar.avX, 10, false);
                this.dak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.avY, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.dak.setVisibility(8);
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
        this.aFJ = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        if (!aqt() && o.mX(this.aFJ.getId())) {
            aqu();
        }
        Q(bbVar);
        this.dUH.af(this.aFJ);
        N(bbVar);
        this.cbx.setData(this.aFJ);
        this.cVS.setData(this.aFJ.Bk());
        this.cbx.setUserAfterClickListener(this.aLf);
        if (this.cbx.getHeaderImg() != null) {
            if (this.cbx.getIsSimpleThread()) {
                this.cbx.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (bbVar.zT() == null || bbVar.zT().getPendantData() == null || StringUtils.isNull(bbVar.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.cbx.getHeaderImg().setVisibility(0);
                this.cbx.getHeaderImg().setData(bbVar);
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(bbVar);
            }
        }
        iM(hD(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void Q(bb bbVar) {
        MetaData zT;
        if (bbVar != null && this.dai != null && (zT = bbVar.zT()) != null) {
            final ThemeCardInUserData themeCard = zT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dai.setVisibility(8);
                return;
            }
            this.dai.setVisibility(0);
            this.dai.setImageBitmap(null);
            this.dai.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.dai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cby != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbx != null) {
            this.cbx.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.aFJ != null) {
            o.mW(this.aFJ.getId());
            aqu();
            m AO = this.aFJ.AO();
            if (AO != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AO.getCartoonId(), AO.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFJ.avs;
            if (this.aFJ.avr == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqR;
                long j = jVar.aqS;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.arf = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFJ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aqt() {
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
        if (this.cby != null) {
            this.cby.awp = i;
            if (i == 15) {
                this.cby.setFrom(10);
                return;
            }
            this.cby.setFrom(2);
            this.cby.setDisPraiseFrom(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqu() {
        o.a(this.cVS.getGodReplyContent(), this.aFJ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cby;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        return this.ccl.aKN;
    }

    public void iM(int i) {
        if (this.aFJ != null) {
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setData(this.aFJ);
                return;
            }
            this.cby.setData(this.aFJ);
            this.ccl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }
}
