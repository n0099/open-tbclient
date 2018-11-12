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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bc;
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
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class x extends a<bc> implements com.baidu.tieba.a.e {
    private boolean aAQ;
    private final View.OnClickListener aHa;
    private boolean aHc;
    private String arj;
    private String bWE;
    public ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    public ThreadSourceShareAndPraiseLayout bXE;
    private NEGFeedBackView bXc;
    private View cOr;
    private TextView cOs;
    private boolean cOu;
    public OriginalThreadCardView cPE;
    private View cPY;
    private TbImageView cPZ;
    private bc cQa;
    private TbImageView cQb;
    private OriginalThreadCardView.a cQc;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bXc = null;
        this.aAQ = true;
        this.cOu = true;
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.anq() != null) {
                    x.this.anq().a(view, x.this.cQa);
                }
            }
        };
        this.cQc = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cQa != null && x.this.cQa.threadData != null) {
                    if (x.this.anq() != null) {
                        x.this.anq().a(x.this.cPE, x.this.cQa);
                    }
                    String id = x.this.cQa.threadData.getId();
                    o.me(id);
                    x.this.mg(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bXB = (HeadPendantClickableView) view.findViewById(e.g.thread_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds70));
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.thread_user_info_layout);
        this.bXc = new NEGFeedBackView(this.mPageContext);
        this.bXc.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds16));
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cOs = (TextView) view.findViewById(e.g.thread_abstract);
        this.cPE = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.cPE.setSubClickListener(this.cQc);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_layout);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bWR.setOnClickListener(this);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.anq() != null) {
                    x.this.anq().a(view2, x.this.cQa);
                }
                if (x.this.cQa != null && x.this.cQa.threadData != null) {
                    o.me(x.this.cQa.threadData.getId());
                    x.this.mg(x.this.cQa.threadData.getId());
                }
            }
        });
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_transmit_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this);
        this.bXE.aGI.setNeedAddReplyIcon(true);
        this.bXE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.anq() != null) {
                    x.this.anq().a(view2, x.this.cQa);
                }
                if (view2 != x.this.bXE.aGH && x.this.cQa != null && x.this.cQa.threadData != null) {
                    o.me(x.this.cQa.threadData.getId());
                    x.this.mg(x.this.cQa.threadData.getId());
                }
            }
        });
        this.cOr = view.findViewById(e.g.divider_line_above_praise);
        this.cPY = view.findViewById(e.g.card_divider_line);
        this.cPZ = (TbImageView) view.findViewById(e.g.thread_theme_card);
        this.cQb = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.bWR.changeSelectStatus();
            }
        });
        this.bWR.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bI(boolean z) {
                al.j(x.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
            }
        });
    }

    private void N(final bb bbVar) {
        if (this.cQb != null) {
            if (this.cPZ == null || bbVar == null) {
                this.cQb.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arU) && this.cPZ.getVisibility() != 0) {
                if (this.bXc != null && this.bXc.getVisibility() == 0 && (this.cQb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cQb.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.tbds106);
                    this.cQb.setLayoutParams(layoutParams);
                }
                this.cQb.setVisibility(0);
                this.cQb.setImageDrawable(null);
                this.cQb.startLoad(bbVar.arU, 10, false);
                this.cQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.arV, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cQb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cOr, e.d.cp_bg_line_e);
            this.bWR.onChangeSkinType();
            this.bWQ.onChangeSkinType();
            if (this.bXc != null) {
                this.bXc.onChangeSkinType();
            }
            this.cPE.onChangeSkinType();
            al.j(this.cPY, e.d.cp_bg_line_e);
            this.bXE.onChangeSkinType();
        }
        if (this.cQa != null && this.cQa.threadData != null) {
            al.j(this.mMaskView, this.cQa.threadData.Ad() ? e.d.cp_bg_line_d : e.d.transparent);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bc bcVar) {
        if (bcVar == null || bcVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.cQa = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.bXc != null) {
            SparseArray<String> xB = bbVar.xB();
            if (xB != null && xB.size() > 0 && this.cOu) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(xB);
                this.bXc.setData(ahVar);
                this.bXc.setFirstRowSingleColumn(true);
                this.bXc.setVisibility(P(bbVar) ? 8 : 0);
            } else {
                this.bXc.setVisibility(8);
            }
        }
        if (this.cQa.ask == 1) {
            this.bWQ.setFrom(3);
            Q(bbVar);
            N(bbVar);
        }
        if (this.currentPageType == 15) {
            this.bWQ.setFrom(5);
        }
        this.bWQ.setIsFromConcern(this.aHc);
        this.bWQ.setData(bbVar);
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
        O(bbVar);
        this.cPE.b(bbVar.arT);
        ix(ho(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        mg(bbVar.getId());
        if (this.bWR.isInFrsAllThread() && com.baidu.tieba.frs.a.ayk().ayl()) {
            this.mMaskView.setVisibility(0);
            if (bbVar.Ad() || bbVar.Ae()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void O(bb bbVar) {
        if (bbVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.arj)) {
                bbVar.ai(this.mUrl, this.arj);
            }
            SpannableStringBuilder i = bbVar.i(false, true);
            if (i == null || StringUtils.isNull(i.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private boolean P(bb bbVar) {
        if (bbVar == null || bbVar.yC() == null || StringUtils.isNull(bbVar.yC().getUserId())) {
            return false;
        }
        return bbVar.yC().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bXc != null) {
            this.bXc.setUniqueId(bdUniqueId);
        }
        if (this.bWQ != null) {
            this.bWQ.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bXc != null) {
            this.bXc.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout abi() {
        return this.bWR;
    }

    public ThreadCommentAndPraiseInfoLayout abj() {
        return this.bXE.aGI;
    }

    public void ft(boolean z) {
        if (this.cPY != null) {
            this.cPY.setVisibility(z ? 0 : 8);
        }
    }

    public void fp(boolean z) {
        this.cOu = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aHc = z;
    }

    private void anK() {
        if (this.cQa != null && this.cQa.threadData != null) {
            bb bbVar = this.cQa.threadData;
            o.me(bbVar.getId());
            mg(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.cQa.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.me(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mg(String str) {
        o.a(this.mTitle, str, e.d.cp_cont_b, e.d.cp_cont_d);
        o.a(this.cOs, str, e.d.cp_cont_b, e.d.cp_cont_d);
        this.cPE.setReadState(o.mf(str));
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
            this.cPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anq() != null) {
            anq().a(view, this.cQa);
        }
        if (view == getView()) {
            anK();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWQ != null) {
            return this.bWQ.aGN;
        }
        return null;
    }

    public View ant() {
        if (this.bWQ != null) {
            return this.bWQ.aGP;
        }
        return null;
    }

    public void ix(int i) {
        if (this.cQa != null && this.cQa.threadData != null) {
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setFrom(this.cQa.asj);
                this.bXE.setShareReportFrom(this.cQa.ask);
                this.bXE.setStType(this.cQa.stType);
                this.bXE.setData(this.cQa.threadData);
                this.bWQ.showForumNameView(false);
                return;
            }
            this.bWR.setFrom(this.cQa.asj);
            this.bWR.setShareReportFrom(this.cQa.ask);
            this.bWR.setStType(this.cQa.stType);
            this.bWR.setData(this.cQa.threadData);
            this.bWR.setDisPraiseFrom(this.cQa.asm);
            this.bXE.setVisibility(8);
            this.bWQ.showForumNameView(true);
        }
    }

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.arj = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }
}
