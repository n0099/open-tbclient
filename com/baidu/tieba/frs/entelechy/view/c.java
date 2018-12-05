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
    protected bb aFf;
    private final View.OnClickListener aKA;
    public View bLT;
    public View byP;
    private ThreadGodReplyLayout cSq;
    private View.OnClickListener cSt;
    public TbImageView cWG;
    private TbImageView cWI;
    public ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private String caw;
    public LinearLayout cbH;
    private HeadPendantClickableView cbt;
    protected ThreadSourceShareAndPraiseLayout cbw;
    private com.baidu.tieba.frs.vc.g dRj;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ax(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.aFf);
                }
                c.this.fn(view == c.this.cSq);
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.aFf);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cbt = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
            this.cbt.setAfterClickListener(this.aKA);
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.cWI = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.byP = view.findViewById(e.g.divider_line);
        this.bLT = view.findViewById(e.g.top_divider_line);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caI.setUserAfterClickListener(this.aKA);
        this.caI.setFrom(3);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setShareVisible(true);
        this.caJ.setShareReportFrom(1);
        this.caJ.setFrom(2);
        this.caJ.setDisPraiseFrom(2);
        this.caJ.setStType("frs_page");
        this.caJ.avL = 3;
        if (view instanceof ViewGroup) {
            this.dRj = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dRj = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.caI);
        }
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this.cSt);
        this.cbw.setFrom(2);
        this.cbw.setShareReportFrom(1);
        this.cbw.setSourceFromForPb(3);
        this.cbw.setStType("frs_page");
        this.cbw.setHideBarName(true);
        this.cbw.aKi.setNeedAddReplyIcon(true);
        this.dRj.setUniqueId(getTag());
        this.cSq = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cSq.setOnClickListener(this.cSt);
        this.cWG = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cWG.setPageId(getTag());
        this.cbH = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        ax(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.byP, e.d.cp_bg_line_e);
            al.j(this.bLT, e.d.cp_bg_line_e);
            this.caJ.onChangeSkinType();
            this.caI.onChangeSkinType();
            this.cSq.onChangeSkinType();
            this.dRj.onChangeSkinType();
            if (this.cbw != null && this.cbw.getVisibility() == 0) {
                this.cbw.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void N(final bb bbVar) {
        if (this.cWI != null) {
            if (this.cWG == null || bbVar == null) {
                this.cWI.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu) && this.cWG.getVisibility() != 0) {
                if (this.dRj != null && this.dRj.aHs() && (this.cWI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWI.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.cWI.setLayoutParams(layoutParams);
                }
                this.cWI.setVisibility(0);
                this.cWI.setImageDrawable(null);
                this.cWI.startLoad(bbVar.avu, 10, false);
                this.cWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cWI.setVisibility(8);
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
        this.aFf = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        if (!apg() && o.mE(this.aFf.getId())) {
            aph();
        }
        Q(bbVar);
        this.dRj.af(this.aFf);
        N(bbVar);
        this.caI.setData(this.aFf);
        this.cSq.setData(this.aFf.AX());
        this.caI.setUserAfterClickListener(this.aKA);
        if (this.caI.getHeaderImg() != null) {
            if (this.caI.getIsSimpleThread()) {
                this.caI.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (bbVar.zG() == null || bbVar.zG().getPendantData() == null || StringUtils.isNull(bbVar.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.caI.getHeaderImg().setVisibility(0);
                this.caI.getHeaderImg().setData(bbVar);
            } else {
                this.caI.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(bbVar);
            }
        }
        iL(hC(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void Q(bb bbVar) {
        MetaData zG;
        if (bbVar != null && this.cWG != null && (zG = bbVar.zG()) != null) {
            final ThemeCardInUserData themeCard = zG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cWG.setVisibility(8);
                return;
            }
            this.cWG.setVisibility(0);
            this.cWG.setImageBitmap(null);
            this.cWG.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caJ != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caI != null) {
            this.caI.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (this.aFf != null) {
            o.mD(this.aFf.getId());
            aph();
            m AB = this.aFf.AB();
            if (AB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AB.getCartoonId(), AB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFf.auP;
            if (this.aFf.auO == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqo;
                long j = jVar.aqp;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aqC = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean apg() {
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
    public void iJ(int i) {
        this.currentPageType = i;
        if (this.caJ != null) {
            this.caJ.avL = i;
            if (i == 15) {
                this.caJ.setFrom(10);
                return;
            }
            this.caJ.setFrom(2);
            this.caJ.setDisPraiseFrom(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aph() {
        o.a(this.cSq.getGodReplyContent(), this.aFf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout aco() {
        return this.caJ;
    }

    public ThreadCommentAndPraiseInfoLayout acp() {
        return this.cbw.aKi;
    }

    public void iL(int i) {
        if (this.aFf != null) {
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setData(this.aFf);
                return;
            }
            this.caJ.setData(this.aFf);
            this.cbw.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }
}
