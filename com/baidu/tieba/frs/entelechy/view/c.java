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
/* loaded from: classes2.dex */
public abstract class c extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private final View.OnClickListener aBE;
    protected bb awf;
    public ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    private String bNq;
    public LinearLayout bOC;
    private HeadPendantClickableView bOo;
    protected ThreadSourceShareAndPraiseLayout bOr;
    public View bqy;
    public View byL;
    private ThreadGodReplyLayout cCi;
    private View.OnClickListener cCl;
    private TbImageView cGB;
    public TbImageView cGz;
    private com.baidu.tieba.frs.vc.g dBC;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void av(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.awf);
                }
                c.this.eJ(view == c.this.cCi);
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.awf);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bOo = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0141e.ds70));
            this.bOo.setAfterClickListener(this.aBE);
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.cGB = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.bqy = view.findViewById(e.g.divider_line);
        this.byL = view.findViewById(e.g.top_divider_line);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bNC.setUserAfterClickListener(this.aBE);
        this.bNC.setFrom(3);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this.cCl);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setIsBarViewVisible(false);
        this.bND.setShareVisible(true);
        this.bND.setShareReportFrom(1);
        this.bND.setFrom(2);
        this.bND.setDisPraiseFrom(2);
        this.bND.setStType("frs_page");
        this.bND.amD = 3;
        if (view instanceof ViewGroup) {
            this.dBC = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dBC = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bNC);
        }
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this.cCl);
        this.bOr.setFrom(2);
        this.bOr.setShareReportFrom(1);
        this.bOr.setSourceFromForPb(3);
        this.bOr.setStType("frs_page");
        this.bOr.setHideBarName(true);
        this.bOr.aBl.setNeedAddReplyIcon(true);
        this.dBC.setUniqueId(getTag());
        this.cCi = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cCi.setOnClickListener(this.cCl);
        this.cGz = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cGz.setPageId(getTag());
        this.bOC = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        av(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.bqy, e.d.cp_bg_line_e);
            al.j(this.byL, e.d.cp_bg_line_e);
            this.bND.onChangeSkinType();
            this.bNC.onChangeSkinType();
            this.cCi.onChangeSkinType();
            this.dBC.onChangeSkinType();
            if (this.bOr != null && this.bOr.getVisibility() == 0) {
                this.bOr.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void N(final bb bbVar) {
        if (this.cGB != null) {
            if (this.cGz == null || bbVar == null) {
                this.cGB.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.amm) && this.cGz.getVisibility() != 0) {
                if (this.dBC != null && this.dBC.aCS() && (this.cGB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGB.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0141e.tbds106);
                    this.cGB.setLayoutParams(layoutParams);
                }
                this.cGB.setVisibility(0);
                this.cGB.setImageDrawable(null);
                this.cGB.startLoad(bbVar.amm, 10, false);
                this.cGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.amn, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cGB.setVisibility(8);
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
        this.awf = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cCl);
        }
        if (!akq() && o.lB(this.awf.getId())) {
            akr();
        }
        Q(bbVar);
        this.dBC.af(this.awf);
        N(bbVar);
        this.bNC.setData(this.awf);
        this.cCi.setData(this.awf.xD());
        this.bNC.setUserAfterClickListener(this.aBE);
        if (this.bNC.getHeaderImg() != null) {
            if (this.bNC.getIsSimpleThread()) {
                this.bNC.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (bbVar.wm() == null || bbVar.wm().getPendantData() == null || StringUtils.isNull(bbVar.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.bNC.getHeaderImg().setVisibility(0);
                this.bNC.getHeaderImg().setData(bbVar);
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(bbVar);
            }
        }
        hM(gT(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void Q(bb bbVar) {
        MetaData wm;
        if (bbVar != null && this.cGz != null && (wm = bbVar.wm()) != null) {
            final ThemeCardInUserData themeCard = wm.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cGz.setVisibility(8);
                return;
            }
            this.cGz.setVisibility(0);
            this.cGz.setImageBitmap(null);
            this.cGz.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bND != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bNC != null) {
            this.bNC.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        if (this.awf != null) {
            o.lA(this.awf.getId());
            akr();
            m xh = this.awf.xh();
            if (xh != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bz(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), xh.getCartoonId(), xh.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.awf.alH;
            if (this.awf.alG == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.ahe;
                long j = jVar.ahf;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.ahs = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.awf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean akq() {
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
    public void hK(int i) {
        this.currentPageType = i;
        if (this.bND != null) {
            this.bND.amD = i;
            if (i == 15) {
                this.bND.setFrom(10);
                return;
            }
            this.bND.setFrom(2);
            this.bND.setDisPraiseFrom(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akr() {
        o.a(this.cCi.getGodReplyContent(), this.awf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout Xq() {
        return this.bND;
    }

    public ThreadCommentAndPraiseInfoLayout Xr() {
        return this.bOr.aBl;
    }

    public void hM(int i) {
        if (this.awf != null) {
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setData(this.awf);
                return;
            }
            this.bND.setData(this.awf);
            this.bOr.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }
}
