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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
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
public abstract class c extends com.baidu.tieba.card.a<bc> implements com.baidu.tieba.a.e, ab {
    protected bc atZ;
    private final View.OnClickListener ayi;
    private String bGM;
    public ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    protected ThreadSourceShareAndPraiseLayout bHN;
    public LinearLayout bHY;
    public View bjZ;
    public View bsm;
    private ThreadGodReplyLayout ctS;
    private View.OnClickListener ctV;
    public TbImageView cyh;
    private TbImageView cyj;
    private com.baidu.tieba.frs.vc.g dsk;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ae(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, c.this.atZ);
                }
                c.this.er(view == c.this.ctS);
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, c.this.atZ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bHK = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bHK.setAfterClickListener(this.ayi);
        }
        this.bHK.setHasPendantStyle();
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.cyj = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.bjZ = view.findViewById(d.g.divider_line);
        this.bsm = view.findViewById(d.g.top_divider_line);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bGY.setUserAfterClickListener(this.ayi);
        this.bGY.setFrom(3);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this.ctV);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setShareVisible(true);
        this.bGZ.setShareReportFrom(1);
        this.bGZ.setFrom(2);
        this.bGZ.setStType("frs_page");
        this.bGZ.akz = 3;
        if (view instanceof ViewGroup) {
            this.dsk = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dsk = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bGY);
        }
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this.ctV);
        this.bHN.setFrom(2);
        this.bHN.setShareReportFrom(1);
        this.bHN.setSourceFromForPb(3);
        this.bHN.setStType("frs_page");
        this.bHN.setHideBarName(true);
        this.bHN.ayE.setNeedAddReplyIcon(true);
        this.dsk.setUniqueId(getTag());
        this.ctS = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.ctS.setOnClickListener(this.ctV);
        this.cyh = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cyh.setPageId(getTag());
        this.bHY = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ae(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.j(this.bjZ, d.C0142d.cp_bg_line_e);
            am.j(this.bsm, d.C0142d.cp_bg_line_e);
            this.bGZ.onChangeSkinType();
            this.bGY.onChangeSkinType();
            this.ctS.onChangeSkinType();
            this.dsk.onChangeSkinType();
            if (this.bHN != null && this.bHN.getVisibility() == 0) {
                this.bHN.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void K(final bc bcVar) {
        if (this.cyj != null) {
            if (this.cyh == null || bcVar == null) {
                this.cyj.setVisibility(8);
            } else if (!StringUtils.isNull(bcVar.akl) && this.cyh.getVisibility() != 0) {
                if (this.dsk != null && this.dsk.aAf() && (this.cyj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cyj.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cyj.setLayoutParams(layoutParams);
                }
                this.cyj.setVisibility(0);
                this.cyj.setImageDrawable(null);
                this.cyj.startLoad(bcVar.akl, 10, false);
                this.cyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bcVar.akm, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cyj.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(bc bcVar) {
        if (bcVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atZ = bcVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ctV);
        }
        if (!aie() && o.kZ(this.atZ.getId())) {
            aif();
        }
        N(bcVar);
        this.dsk.ac(this.atZ);
        K(bcVar);
        this.bGY.setData(this.atZ);
        this.ctS.setData(this.atZ.wI());
        this.bGY.setUserAfterClickListener(this.ayi);
        if (this.bGY.getHeaderImg() != null) {
            if (this.bGY.getIsSimpleThread()) {
                this.bGY.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (bcVar.vw() == null || bcVar.vw().getPendantData() == null || StringUtils.isNull(bcVar.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.bGY.getHeaderImg().setVisibility(0);
                this.bGY.getHeaderImg().setData(bcVar);
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(bcVar);
            }
        }
        hh(gp(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void N(bc bcVar) {
        MetaData vw;
        if (bcVar != null && this.cyh != null && (vw = bcVar.vw()) != null) {
            final ThemeCardInUserData themeCard = vw.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cyh.setVisibility(8);
                return;
            }
            this.cyh.setVisibility(0);
            this.cyh.setImageBitmap(null);
            this.cyh.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bGZ != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bGY != null) {
            this.bGY.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(boolean z) {
        if (this.atZ != null) {
            o.kY(this.atZ.getId());
            aif();
            n wo = this.atZ.wo();
            if (wo != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bb.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), wo.getCartoonId(), wo.getChapterId(), 2)));
                return;
            }
            k kVar = this.atZ.ajI;
            if (this.atZ.ajH == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.afj;
                long j = kVar.afk;
                al alVar = new al();
                alVar.pageContext = this.mPageContext;
                alVar.afx = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atZ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aie() {
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
    public void hf(int i) {
        this.currentPageType = i;
        if (this.bGZ != null) {
            this.bGZ.akz = i;
            if (i == 15) {
                this.bGZ.setFrom(10);
            } else {
                this.bGZ.setFrom(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aif() {
        o.a(this.ctS.getGodReplyContent(), this.atZ.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout Vr() {
        return this.bGZ;
    }

    public ThreadCommentAndPraiseInfoLayout Vs() {
        return this.bHN.ayE;
    }

    public void hh(int i) {
        if (this.atZ != null) {
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setData(this.atZ);
                return;
            }
            this.bGZ.setData(this.atZ);
            this.bHN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
