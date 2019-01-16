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
    protected bb aFI;
    private final View.OnClickListener aLe;
    public View bMJ;
    public View bzG;
    private ThreadGodReplyLayout cVR;
    private View.OnClickListener cVU;
    private String cbk;
    public ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    protected ThreadSourceShareAndPraiseLayout cck;
    public LinearLayout ccw;
    private com.baidu.tieba.frs.vc.g dUG;
    public TbImageView dah;
    private TbImageView daj;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void aA(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.aFI);
                }
                c.this.fs(view == c.this.cVR);
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.aFI);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cch = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
            this.cch.setAfterClickListener(this.aLe);
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.daj = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.bzG = view.findViewById(e.g.divider_line);
        this.bMJ = view.findViewById(e.g.top_divider_line);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbw.setUserAfterClickListener(this.aLe);
        this.cbw.setFrom(3);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setForumAfterClickListener(this.aLe);
        this.cbx.setShareVisible(true);
        this.cbx.setShareReportFrom(1);
        this.cbx.setFrom(2);
        this.cbx.setDisPraiseFrom(2);
        this.cbx.setStType("frs_page");
        this.cbx.awo = 3;
        if (view instanceof ViewGroup) {
            this.dUG = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dUG = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cbw);
        }
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this.cVU);
        this.cck.setFrom(2);
        this.cck.setShareReportFrom(1);
        this.cck.setSourceFromForPb(3);
        this.cck.setStType("frs_page");
        this.cck.setHideBarName(true);
        this.cck.aKM.setNeedAddReplyIcon(true);
        this.dUG.setUniqueId(getTag());
        this.cVR = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVR.setOnClickListener(this.cVU);
        this.dah = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.dah.setPageId(getTag());
        this.ccw = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        aA(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.bzG, e.d.cp_bg_line_e);
            al.j(this.bMJ, e.d.cp_bg_line_e);
            this.cbx.onChangeSkinType();
            this.cbw.onChangeSkinType();
            this.cVR.onChangeSkinType();
            this.dUG.onChangeSkinType();
            if (this.cck != null && this.cck.getVisibility() == 0) {
                this.cck.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void N(final bb bbVar) {
        if (this.daj != null) {
            if (this.dah == null || bbVar == null) {
                this.daj.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avW) && this.dah.getVisibility() != 0) {
                if (this.dUG != null && this.dUG.aIE() && (this.daj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daj.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.daj.setLayoutParams(layoutParams);
                }
                this.daj.setVisibility(0);
                this.daj.setImageDrawable(null);
                this.daj.startLoad(bbVar.avW, 10, false);
                this.daj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.avX, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.daj.setVisibility(8);
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
        this.aFI = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        if (!aqt() && o.mX(this.aFI.getId())) {
            aqu();
        }
        Q(bbVar);
        this.dUG.af(this.aFI);
        N(bbVar);
        this.cbw.setData(this.aFI);
        this.cVR.setData(this.aFI.Bk());
        this.cbw.setUserAfterClickListener(this.aLe);
        if (this.cbw.getHeaderImg() != null) {
            if (this.cbw.getIsSimpleThread()) {
                this.cbw.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (bbVar.zT() == null || bbVar.zT().getPendantData() == null || StringUtils.isNull(bbVar.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.cbw.getHeaderImg().setVisibility(0);
                this.cbw.getHeaderImg().setData(bbVar);
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(bbVar);
            }
        }
        iM(hD(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void Q(bb bbVar) {
        MetaData zT;
        if (bbVar != null && this.dah != null && (zT = bbVar.zT()) != null) {
            final ThemeCardInUserData themeCard = zT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dah.setVisibility(8);
                return;
            }
            this.dah.setVisibility(0);
            this.dah.setImageBitmap(null);
            this.dah.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.dah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cbx != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbw != null) {
            this.cbw.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.aFI != null) {
            o.mW(this.aFI.getId());
            aqu();
            m AO = this.aFI.AO();
            if (AO != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AO.getCartoonId(), AO.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFI.avr;
            if (this.aFI.avq == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqQ;
                long j = jVar.aqR;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.are = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFI, null, "frs_page", 18003, true, false, false).addLocateParam("");
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
        if (this.cbx != null) {
            this.cbx.awo = i;
            if (i == 15) {
                this.cbx.setFrom(10);
                return;
            }
            this.cbx.setFrom(2);
            this.cbx.setDisPraiseFrom(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqu() {
        o.a(this.cVR.getGodReplyContent(), this.aFI.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cbx;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        return this.cck.aKM;
    }

    public void iM(int i) {
        if (this.aFI != null) {
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setData(this.aFI);
                return;
            }
            this.cbx.setData(this.aFI);
            this.cck.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }
}
