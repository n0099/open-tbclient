package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class x extends a<be> implements com.baidu.tieba.a.e {
    private String ajh;
    private boolean asK;
    private final View.OnClickListener axr;
    private boolean ayd;
    private String bER;
    private HeadPendantClickableView bFP;
    public ThreadSourceShareAndPraiseLayout bFT;
    public ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    private NEGFeedBackView bFq;
    private View cAn;
    private TbImageView cAo;
    private be cAp;
    private TbImageView cAq;
    private OriginalThreadCardView.a cAr;
    private View cyF;
    private TextView cyG;
    private boolean cyI;
    public OriginalThreadCardView czT;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFq = null;
        this.asK = true;
        this.cyI = true;
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.aiI() != null) {
                    x.this.aiI().a(view, x.this.cAp);
                }
            }
        };
        this.cAr = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.6
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cAp != null && x.this.cAp.threadData != null) {
                    if (x.this.aiI() != null) {
                        x.this.aiI().a(x.this.czT, x.this.cAp);
                    }
                    String id = x.this.cAp.threadData.getId();
                    o.lb(id);
                    x.this.ld(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bFP = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.bFq = new NEGFeedBackView(this.mPageContext);
        this.bFq.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cyG = (TextView) view.findViewById(d.g.thread_abstract);
        this.czT = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.czT.setSubClickListener(this.cAr);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bFe.setOnClickListener(this);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aiI() != null) {
                    x.this.aiI().a(view2, x.this.cAp);
                }
                if (x.this.cAp != null && x.this.cAp.threadData != null) {
                    o.lb(x.this.cAp.threadData.getId());
                    x.this.ld(x.this.cAp.threadData.getId());
                }
            }
        });
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this);
        this.bFT.axN.setNeedAddReplyIcon(true);
        this.bFT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aiI() != null) {
                    x.this.aiI().a(view2, x.this.cAp);
                }
                if (view2 != x.this.bFT.axM && x.this.cAp != null && x.this.cAp.threadData != null) {
                    o.lb(x.this.cAp.threadData.getId());
                    x.this.ld(x.this.cAp.threadData.getId());
                }
            }
        });
        this.cyF = view.findViewById(d.g.divider_line_above_praise);
        this.cAn = view.findViewById(d.g.card_divider_line);
        this.cAo = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.cAq = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
    }

    private void I(final bd bdVar) {
        if (this.cAq != null) {
            if (this.cAo == null || bdVar == null) {
                this.cAq.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.ajQ) && this.cAo.getVisibility() != 0) {
                if (this.bFq != null && this.bFq.getVisibility() == 0 && (this.cAq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAq.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cAq.setLayoutParams(layoutParams);
                }
                this.cAq.setVisibility(0);
                this.cAq.setImageDrawable(null);
                this.cAq.startLoad(bdVar.ajQ, 10, false);
                this.cAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bdVar.ajR, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cAq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            al.j(this.cyF, d.C0141d.cp_bg_line_e);
            this.bFe.onChangeSkinType();
            this.bFd.onChangeSkinType();
            if (this.bFq != null) {
                this.bFq.onChangeSkinType();
            }
            this.czT.onChangeSkinType();
            al.j(this.cAn, d.C0141d.cp_bg_line_e);
            this.bFT.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(be beVar) {
        if (beVar == null || beVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.cAp = beVar;
        bd bdVar = beVar.threadData;
        if (this.bFq != null) {
            SparseArray<String> up = bdVar.up();
            if (up != null && up.size() > 0 && this.cyI) {
                ai aiVar = new ai();
                aiVar.dh(bdVar.getTid());
                aiVar.setFid(bdVar.getFid());
                aiVar.a(up);
                this.bFq.setData(aiVar);
                this.bFq.setFirstRowSingleColumn(true);
                this.bFq.setVisibility(K(bdVar) ? 8 : 0);
            } else {
                this.bFq.setVisibility(8);
            }
        }
        if (this.cAp.ajZ == 1) {
            this.bFd.setFrom(3);
            L(bdVar);
            I(bdVar);
        }
        this.bFd.setIsFromConcern(this.ayd);
        this.bFd.setData(bdVar);
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
        J(bdVar);
        this.czT.b(bdVar.ajP);
        hd(go(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        ld(bdVar.getId());
    }

    private void J(bd bdVar) {
        if (bdVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ajh)) {
                bdVar.P(this.mUrl, this.ajh);
            }
            SpannableStringBuilder g = bdVar.g(false, true);
            if (g == null || StringUtils.isNull(g.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
    }

    private boolean K(bd bdVar) {
        if (bdVar == null || bdVar.vm() == null || StringUtils.isNull(bdVar.vm().getUserId())) {
            return false;
        }
        return bdVar.vm().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bFq != null) {
            this.bFq.setUniqueId(bdUniqueId);
        }
        if (this.bFd != null) {
            this.bFd.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bFq != null) {
            this.bFq.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout UW() {
        return this.bFe;
    }

    public ThreadCommentAndPraiseInfoLayout UX() {
        return this.bFT.axN;
    }

    public void ez(boolean z) {
        if (this.cAn != null) {
            this.cAn.setVisibility(z ? 0 : 8);
        }
    }

    public void ev(boolean z) {
        this.cyI = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayd = z;
    }

    private void ajb() {
        if (this.cAp != null && this.cAp.threadData != null) {
            bd bdVar = this.cAp.threadData;
            o.lb(bdVar.getId());
            ld(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.cAp.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.vr());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.lb(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld(String str) {
        o.a(this.mTitle, str, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        o.a(this.cyG, str, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.czT.setReadState(o.lc(str));
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
            this.cAo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiI() != null) {
            aiI().a(view, this.cAp);
        }
        if (view == getView()) {
            ajb();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bFd != null) {
            return this.bFd.axn;
        }
        return null;
    }

    public View aiL() {
        if (this.bFd != null) {
            return this.bFd.axo;
        }
        return null;
    }

    public void hd(int i) {
        if (this.cAp != null && this.cAp.threadData != null) {
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setFrom(this.cAp.ajY);
                this.bFT.setShareReportFrom(this.cAp.ajZ);
                this.bFT.setStType(this.cAp.stType);
                this.bFT.setData(this.cAp.threadData);
                this.bFd.showForumNameView(false);
                return;
            }
            this.bFe.setFrom(this.cAp.ajY);
            this.bFe.setShareReportFrom(this.cAp.ajZ);
            this.bFe.setStType(this.cAp.stType);
            this.bFe.setData(this.cAp.threadData);
            this.bFT.setVisibility(8);
            this.bFd.showForumNameView(true);
        }
    }

    public void P(String str, String str2) {
        this.mUrl = str;
        this.ajh = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
