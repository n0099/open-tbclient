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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
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
/* loaded from: classes3.dex */
public class v extends a<bh> implements com.baidu.tieba.a.e {
    private TextView XK;
    private String YA;
    private final View.OnClickListener ZG;
    private boolean ZP;
    private OriginalThreadCardView.a Zj;
    private String bCG;
    private boolean bTK;
    private NEGFeedBackView dqG;
    public ThreadUserInfoLayout dqu;
    public ThreadCommentAndPraiseInfoLayout dqv;
    public ThreadSourceShareAndPraiseLayout drk;
    private HeadPendantClickableView ehK;
    private View eil;
    private boolean eip;
    public OriginalThreadCardView ejA;
    private View ejU;
    private TbImageView ejV;
    private bh ejW;
    private TbImageView ejX;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqG = null;
        this.ZP = true;
        this.eip = true;
        this.ZG = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aQh() != null) {
                    v.this.aQh().a(view, v.this.ejW);
                }
            }
        };
        this.Zj = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.ejW != null && v.this.ejW.threadData != null) {
                    if (v.this.aQh() != null) {
                        v.this.aQh().a(v.this.ejA, v.this.ejW);
                    }
                    String id = v.this.ejW.threadData.getId();
                    n.tA(id);
                    v.this.cu(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ehK = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.ehK.getHeadView() != null) {
            this.ehK.getHeadView().setIsRound(true);
            this.ehK.getHeadView().setDrawBorder(false);
            this.ehK.getHeadView().setDefaultResource(17170445);
            this.ehK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehK.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehK.setHasPendantStyle();
        if (this.ehK.getPendantView() != null) {
            this.ehK.getPendantView().setIsRound(true);
            this.ehK.getPendantView().setDrawBorder(false);
        }
        this.dqu = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.dqG = new NEGFeedBackView(this.mPageContext);
        this.dqG.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.XK = (TextView) view.findViewById(d.g.thread_abstract);
        this.ejA = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.ejA.setSubClickListener(this.Zj);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.dqv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqv.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqv.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dqv.setOnClickListener(this);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setShareVisible(true);
        this.dqv.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aQh() != null) {
                    v.this.aQh().a(view2, v.this.ejW);
                }
                if (v.this.ejW != null && v.this.ejW.threadData != null) {
                    n.tA(v.this.ejW.threadData.getId());
                    v.this.cu(v.this.ejW.threadData.getId());
                }
            }
        });
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.drk.bTz.setOnClickListener(this);
        this.drk.bTz.setNeedAddReplyIcon(true);
        this.drk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aQh() != null) {
                    v.this.aQh().a(view2, v.this.ejW);
                }
                if (view2 != v.this.drk.bSQ && v.this.ejW != null && v.this.ejW.threadData != null) {
                    n.tA(v.this.ejW.threadData.getId());
                    v.this.cu(v.this.ejW.threadData.getId());
                }
            }
        });
        this.eil = view.findViewById(d.g.divider_line_above_praise);
        this.ejU = view.findViewById(d.g.card_divider_line);
        this.ejV = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.ejX = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dqv.changeSelectStatus();
            }
        });
        this.dqv.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                al.l(v.this.mMaskView, z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
            }
        });
    }

    private void S(final bg bgVar) {
        if (this.ejX != null) {
            if (this.ejV == null || bgVar == null) {
                this.ejX.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDw) && this.ejV.getVisibility() != 0) {
                if (this.dqG != null && this.dqG.getVisibility() == 0 && (this.ejX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejX.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ejX.setLayoutParams(layoutParams);
                }
                this.ejX.setVisibility(0);
                this.ejX.setImageDrawable(null);
                this.ejX.startLoad(bgVar.bDw, 10, false);
                this.ejX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bgVar.bDx, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejX.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.eil, d.C0277d.cp_bg_line_e);
            this.dqv.onChangeSkinType();
            this.dqu.onChangeSkinType();
            if (this.dqG != null) {
                this.dqG.onChangeSkinType();
            }
            this.ejA.onChangeSkinType();
            al.l(this.ejU, d.C0277d.cp_bg_line_e);
            this.drk.onChangeSkinType();
        }
        if (this.ejW != null && this.ejW.threadData != null) {
            al.l(this.mMaskView, this.ejW.threadData.aaA() ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
        }
        if (this.ehK != null && this.ehK.getHeadView() != null && (this.ehK.getHeadView() instanceof TbImageView)) {
            this.ehK.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null || bhVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.ejW = bhVar;
        bg bgVar = bhVar.threadData;
        if (this.dqG != null) {
            SparseArray<String> XA = bgVar.XA();
            if (XA != null && XA.size() > 0 && this.eip) {
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(XA);
                this.dqG.setData(ajVar);
                this.dqG.setFirstRowSingleColumn(true);
                this.dqG.setVisibility(U(bgVar) ? 8 : 0);
            } else {
                this.dqG.setVisibility(8);
            }
        }
        if (this.ejW.bDV == 1) {
            this.dqu.setFrom(3);
            b(bgVar);
            S(bgVar);
        }
        if (this.currentPageType == 15) {
            this.dqu.setFrom(5);
        }
        this.dqu.setIsFromConcern(this.bTK);
        this.dqu.setData(bgVar);
        this.dqu.setUserAfterClickListener(this.ZG);
        if (this.dqu.getHeaderImg() != null) {
            if (this.dqu.getIsSimpleThread()) {
                this.dqu.getHeaderImg().setVisibility(8);
                this.ehK.setVisibility(8);
            } else if (bgVar.YR() == null || bgVar.YR().getPendantData() == null || StringUtils.isNull(bgVar.YR().getPendantData().Xn())) {
                this.ehK.setVisibility(8);
                this.dqu.getHeaderImg().setVisibility(0);
                this.dqu.getHeaderImg().setData(bgVar);
            } else {
                this.dqu.getHeaderImg().setVisibility(4);
                this.ehK.setVisibility(0);
                this.ehK.setData(bgVar);
            }
        }
        T(bgVar);
        this.ejA.b(bgVar.bDv);
        mF(lt(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cu(bgVar.getId());
        if (this.dqv.isInFrsAllThread() && com.baidu.tieba.frs.a.bbF().bbG()) {
            this.mMaskView.setVisibility(0);
            if (bgVar.aaA() || bgVar.aaB()) {
                al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(d.C0277d.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void T(bg bgVar) {
        if (bgVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCG)) {
                bgVar.bt(this.mUrl, this.bCG);
            }
            SpannableStringBuilder m = bgVar.m(false, true);
            if (m == null || StringUtils.isNull(m.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private boolean U(bg bgVar) {
        if (bgVar == null || bgVar.YR() == null || StringUtils.isNull(bgVar.YR().getUserId())) {
            return false;
        }
        return bgVar.YR().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dqG != null) {
            this.dqG.setUniqueId(bdUniqueId);
        }
        if (this.dqu != null) {
            this.dqu.setPageUniqueId(bdUniqueId);
        }
    }

    public void hR(boolean z) {
        if (this.ejU != null) {
            this.ejU.setVisibility(z ? 0 : 8);
        }
    }

    public void hN(boolean z) {
        this.eip = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bTK = z;
    }

    private void ajX() {
        if (this.ejW != null && this.ejW.threadData != null) {
            bg bgVar = this.ejW.threadData;
            n.tA(bgVar.getId());
            cu(bgVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bgVar, null, this.ejW.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.tA(bgVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(String str) {
        n.a(this.mTitle, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        n.a(this.XK, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        this.ejA.setReadState(n.tB(str));
    }

    public void b(bg bgVar) {
        MetaData YR;
        if (bgVar != null && this.ejV != null && (YR = bgVar.YR()) != null) {
            final ThemeCardInUserData themeCard = YR.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejV.setVisibility(8);
                return;
            }
            this.ejV.setVisibility(0);
            this.ejV.setImageBitmap(null);
            this.ejV.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ejW);
        }
        if (view == getView()) {
            ajX();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dqu != null) {
            return this.dqu.bTj;
        }
        return null;
    }

    public View aQm() {
        if (this.dqu != null) {
            return this.dqu.Zy;
        }
        return null;
    }

    public void mF(int i) {
        if (this.ejW != null && this.ejW.threadData != null) {
            if (i == 1) {
                this.dqv.setVisibility(8);
                this.drk.setFrom(this.ejW.bDU);
                this.drk.setShareReportFrom(this.ejW.bDV);
                this.drk.setStType(this.ejW.stType);
                this.drk.setData(this.ejW.threadData);
                this.dqu.dN(false);
                return;
            }
            this.dqv.setFrom(this.ejW.bDU);
            this.dqv.setShareReportFrom(this.ejW.bDV);
            this.dqv.setStType(this.ejW.stType);
            this.dqv.setData(this.ejW.threadData);
            this.dqv.setDisPraiseFrom(this.ejW.bDW);
            this.drk.setVisibility(8);
            this.dqu.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }
}
