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
    private final View.OnClickListener ZH;
    private boolean ZQ;
    private OriginalThreadCardView.a Zj;
    private String bCJ;
    private boolean bTM;
    private NEGFeedBackView dqJ;
    public ThreadUserInfoLayout dqx;
    public ThreadCommentAndPraiseInfoLayout dqy;
    public ThreadSourceShareAndPraiseLayout drn;
    private View ehX;
    private HeadPendantClickableView ehw;
    private boolean eib;
    private View ejG;
    private TbImageView ejH;
    private bh ejI;
    private TbImageView ejJ;
    public OriginalThreadCardView ejm;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqJ = null;
        this.ZQ = true;
        this.eib = true;
        this.ZH = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aQf() != null) {
                    v.this.aQf().a(view, v.this.ejI);
                }
            }
        };
        this.Zj = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.ejI != null && v.this.ejI.threadData != null) {
                    if (v.this.aQf() != null) {
                        v.this.aQf().a(v.this.ejm, v.this.ejI);
                    }
                    String id = v.this.ejI.threadData.getId();
                    n.tz(id);
                    v.this.cu(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ehw = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.ehw.getHeadView() != null) {
            this.ehw.getHeadView().setIsRound(true);
            this.ehw.getHeadView().setDrawBorder(false);
            this.ehw.getHeadView().setDefaultResource(17170445);
            this.ehw.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehw.setHasPendantStyle();
        if (this.ehw.getPendantView() != null) {
            this.ehw.getPendantView().setIsRound(true);
            this.ehw.getPendantView().setDrawBorder(false);
        }
        this.dqx = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.dqJ = new NEGFeedBackView(this.mPageContext);
        this.dqJ.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.XK = (TextView) view.findViewById(d.g.thread_abstract);
        this.ejm = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.ejm.setSubClickListener(this.Zj);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.dqy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqy.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dqy.setOnClickListener(this);
        this.dqy.setReplyTimeVisible(false);
        this.dqy.setShowPraiseNum(true);
        this.dqy.setNeedAddPraiseIcon(true);
        this.dqy.setNeedAddReplyIcon(true);
        this.dqy.setShareVisible(true);
        this.dqy.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aQf() != null) {
                    v.this.aQf().a(view2, v.this.ejI);
                }
                if (v.this.ejI != null && v.this.ejI.threadData != null) {
                    n.tz(v.this.ejI.threadData.getId());
                    v.this.cu(v.this.ejI.threadData.getId());
                }
            }
        });
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.drn.bTB.setOnClickListener(this);
        this.drn.bTB.setNeedAddReplyIcon(true);
        this.drn.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aQf() != null) {
                    v.this.aQf().a(view2, v.this.ejI);
                }
                if (view2 != v.this.drn.bSS && v.this.ejI != null && v.this.ejI.threadData != null) {
                    n.tz(v.this.ejI.threadData.getId());
                    v.this.cu(v.this.ejI.threadData.getId());
                }
            }
        });
        this.ehX = view.findViewById(d.g.divider_line_above_praise);
        this.ejG = view.findViewById(d.g.card_divider_line);
        this.ejH = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.ejJ = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dqy.changeSelectStatus();
            }
        });
        this.dqy.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                al.l(v.this.mMaskView, z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
            }
        });
    }

    private void R(final bg bgVar) {
        if (this.ejJ != null) {
            if (this.ejH == null || bgVar == null) {
                this.ejJ.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDz) && this.ejH.getVisibility() != 0) {
                if (this.dqJ != null && this.dqJ.getVisibility() == 0 && (this.ejJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejJ.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ejJ.setLayoutParams(layoutParams);
                }
                this.ejJ.setVisibility(0);
                this.ejJ.setImageDrawable(null);
                this.ejJ.startLoad(bgVar.bDz, 10, false);
                this.ejJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bgVar.bDA, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.ehX, d.C0277d.cp_bg_line_e);
            this.dqy.onChangeSkinType();
            this.dqx.onChangeSkinType();
            if (this.dqJ != null) {
                this.dqJ.onChangeSkinType();
            }
            this.ejm.onChangeSkinType();
            al.l(this.ejG, d.C0277d.cp_bg_line_e);
            this.drn.onChangeSkinType();
        }
        if (this.ejI != null && this.ejI.threadData != null) {
            al.l(this.mMaskView, this.ejI.threadData.aax() ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
        }
        if (this.ehw != null && this.ehw.getHeadView() != null && (this.ehw.getHeadView() instanceof TbImageView)) {
            this.ehw.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ejI = bhVar;
        bg bgVar = bhVar.threadData;
        if (this.dqJ != null) {
            SparseArray<String> Xx = bgVar.Xx();
            if (Xx != null && Xx.size() > 0 && this.eib) {
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(Xx);
                this.dqJ.setData(ajVar);
                this.dqJ.setFirstRowSingleColumn(true);
                this.dqJ.setVisibility(T(bgVar) ? 8 : 0);
            } else {
                this.dqJ.setVisibility(8);
            }
        }
        if (this.ejI.bDY == 1) {
            this.dqx.setFrom(3);
            b(bgVar);
            R(bgVar);
        }
        if (this.currentPageType == 15) {
            this.dqx.setFrom(5);
        }
        this.dqx.setIsFromConcern(this.bTM);
        this.dqx.setData(bgVar);
        this.dqx.setUserAfterClickListener(this.ZH);
        if (this.dqx.getHeaderImg() != null) {
            if (this.dqx.getIsSimpleThread()) {
                this.dqx.getHeaderImg().setVisibility(8);
                this.ehw.setVisibility(8);
            } else if (bgVar.YO() == null || bgVar.YO().getPendantData() == null || StringUtils.isNull(bgVar.YO().getPendantData().Xk())) {
                this.ehw.setVisibility(8);
                this.dqx.getHeaderImg().setVisibility(0);
                this.dqx.getHeaderImg().setData(bgVar);
            } else {
                this.dqx.getHeaderImg().setVisibility(4);
                this.ehw.setVisibility(0);
                this.ehw.setData(bgVar);
            }
        }
        S(bgVar);
        this.ejm.b(bgVar.bDy);
        mE(ls(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cu(bgVar.getId());
        if (this.dqy.isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.mMaskView.setVisibility(0);
            if (bgVar.aax() || bgVar.aay()) {
                al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(d.C0277d.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void S(bg bgVar) {
        if (bgVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCJ)) {
                bgVar.bt(this.mUrl, this.bCJ);
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

    private boolean T(bg bgVar) {
        if (bgVar == null || bgVar.YO() == null || StringUtils.isNull(bgVar.YO().getUserId())) {
            return false;
        }
        return bgVar.YO().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dqJ != null) {
            this.dqJ.setUniqueId(bdUniqueId);
        }
        if (this.dqx != null) {
            this.dqx.setPageUniqueId(bdUniqueId);
        }
    }

    public void hR(boolean z) {
        if (this.ejG != null) {
            this.ejG.setVisibility(z ? 0 : 8);
        }
    }

    public void hN(boolean z) {
        this.eib = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bTM = z;
    }

    private void ajU() {
        if (this.ejI != null && this.ejI.threadData != null) {
            bg bgVar = this.ejI.threadData;
            n.tz(bgVar.getId());
            cu(bgVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bgVar, null, this.ejI.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.tz(bgVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(String str) {
        n.a(this.mTitle, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        n.a(this.XK, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        this.ejm.setReadState(n.tA(str));
    }

    public void b(bg bgVar) {
        MetaData YO;
        if (bgVar != null && this.ejH != null && (YO = bgVar.YO()) != null) {
            final ThemeCardInUserData themeCard = YO.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejH.setVisibility(8);
                return;
            }
            this.ejH.setVisibility(0);
            this.ejH.setImageBitmap(null);
            this.ejH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ejI);
        }
        if (view == getView()) {
            ajU();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dqx != null) {
            return this.dqx.bTl;
        }
        return null;
    }

    public View aQk() {
        if (this.dqx != null) {
            return this.dqx.Zy;
        }
        return null;
    }

    public void mE(int i) {
        if (this.ejI != null && this.ejI.threadData != null) {
            if (i == 1) {
                this.dqy.setVisibility(8);
                this.drn.setFrom(this.ejI.bDX);
                this.drn.setShareReportFrom(this.ejI.bDY);
                this.drn.setStType(this.ejI.stType);
                this.drn.setData(this.ejI.threadData);
                this.dqx.dN(false);
                return;
            }
            this.dqy.setFrom(this.ejI.bDX);
            this.dqy.setShareReportFrom(this.ejI.bDY);
            this.dqy.setStType(this.ejI.stType);
            this.dqy.setData(this.ejI.threadData);
            this.dqy.setDisPraiseFrom(this.ejI.bDZ);
            this.drn.setVisibility(8);
            this.dqx.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }
}
