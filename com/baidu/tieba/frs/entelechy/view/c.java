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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
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
    protected bd atn;
    private final View.OnClickListener axr;
    private String bER;
    private HeadPendantClickableView bFP;
    protected ThreadSourceShareAndPraiseLayout bFT;
    private ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    public LinearLayout bGe;
    public View biz;
    public View bqM;
    public TbImageView cAo;
    private TbImageView cAq;
    private ThreadGodReplyLayout cvM;
    private View.OnClickListener cvP;
    private com.baidu.tieba.frs.vc.g dpb;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ac(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, c.this.atn);
                }
                c.this.es(view == c.this.cvM);
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, c.this.atn);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bFP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
            this.bFP.setAfterClickListener(this.axr);
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.cAq = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.biz = view.findViewById(d.g.divider_line);
        this.bqM = view.findViewById(d.g.top_divider_line);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bFd.setUserAfterClickListener(this.axr);
        this.bFd.setFrom(3);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this.cvP);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setShareVisible(true);
        this.bFe.setShareReportFrom(1);
        this.bFe.setFrom(2);
        this.bFe.setStType("frs_page");
        this.bFe.aka = 3;
        if (view instanceof ViewGroup) {
            this.dpb = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dpb = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bFd);
        }
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this.cvP);
        this.bFT.setFrom(2);
        this.bFT.setShareReportFrom(1);
        this.bFT.setSourceFromForPb(3);
        this.bFT.setStType("frs_page");
        this.bFT.setHideBarName(true);
        this.bFT.axN.setNeedAddReplyIcon(true);
        this.dpb.setUniqueId(getTag());
        this.cvM = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cvM.setOnClickListener(this.cvP);
        this.cAo = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cAo.setPageId(getTag());
        this.bGe = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        ac(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            al.j(this.biz, d.C0141d.cp_bg_line_e);
            al.j(this.bqM, d.C0141d.cp_bg_line_e);
            this.bFe.onChangeSkinType();
            this.bFd.onChangeSkinType();
            this.cvM.onChangeSkinType();
            this.dpb.onChangeSkinType();
            if (this.bFT != null && this.bFT.getVisibility() == 0) {
                this.bFT.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void I(final bd bdVar) {
        if (this.cAq != null) {
            if (this.cAo == null || bdVar == null) {
                this.cAq.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.ajQ) && this.cAo.getVisibility() != 0) {
                if (this.dpb != null && this.dpb.azz() && (this.cAq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAq.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cAq.setLayoutParams(layoutParams);
                }
                this.cAq.setVisibility(0);
                this.cAq.setImageDrawable(null);
                this.cAq.startLoad(bdVar.ajQ, 10, false);
                this.cAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bdVar.ajR, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cAq.setVisibility(8);
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
        this.atn = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cvP);
        }
        if (!aiM() && o.lc(this.atn.getId())) {
            aiN();
        }
        L(bdVar);
        this.dpb.X(this.atn);
        I(bdVar);
        this.bFd.setData(this.atn);
        this.cvM.setData(this.atn.wy());
        this.bFd.setUserAfterClickListener(this.axr);
        if (this.bFd.getHeaderImg() != null) {
            if (this.bFd.getIsSimpleThread()) {
                this.bFd.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (bdVar.vm() == null || bdVar.vm().getPendantData() == null || StringUtils.isNull(bdVar.vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.bFd.getHeaderImg().setVisibility(0);
                this.bFd.getHeaderImg().setData(bdVar);
            } else {
                this.bFd.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(bdVar);
            }
        }
        hd(go(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void L(bd bdVar) {
        MetaData vm;
        if (bdVar != null && this.cAo != null && (vm = bdVar.vm()) != null) {
            final ThemeCardInUserData themeCard = vm.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAo.setVisibility(8);
                return;
            }
            this.cAo.setVisibility(0);
            this.cAo.setImageBitmap(null);
            this.cAo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bFe != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bFd != null) {
            this.bFd.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.atn != null) {
            o.lb(this.atn.getId());
            aiN();
            n we = this.atn.we();
            if (we != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), we.getCartoonId(), we.getChapterId(), 2)));
                return;
            }
            k kVar = this.atn.ajn;
            if (this.atn.ajm == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.aeU;
                long j = kVar.aeV;
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.pageContext = this.mPageContext;
                alVar.afi = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atn, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.atn.getFid()));
            addLocateParam.setForumName(this.atn.vr());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aiM() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiN() {
        o.a(this.cvM.getGodReplyContent(), this.atn.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout UW() {
        return this.bFe;
    }

    public ThreadCommentAndPraiseInfoLayout UX() {
        return this.bFT.axN;
    }

    public void hd(int i) {
        if (this.atn != null) {
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setData(this.atn);
                return;
            }
            this.bFe.setData(this.atn);
            this.bFT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
