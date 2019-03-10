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
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class v extends a<bh> implements e {
    private TextView XJ;
    private String Yz;
    private final View.OnClickListener ZF;
    private boolean ZO;
    private OriginalThreadCardView.a Zi;
    private String bCE;
    private boolean bTJ;
    private NEGFeedBackView dqK;
    public ThreadUserInfoLayout dqy;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    private HeadPendantClickableView ehO;
    private View eip;
    private boolean eit;
    public OriginalThreadCardView ejE;
    private View ejY;
    private TbImageView ejZ;
    private bh eka;
    private TbImageView ekb;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqK = null;
        this.ZO = true;
        this.eit = true;
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aQi() != null) {
                    v.this.aQi().a(view, v.this.eka);
                }
            }
        };
        this.Zi = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.eka != null && v.this.eka.threadData != null) {
                    if (v.this.aQi() != null) {
                        v.this.aQi().a(v.this.ejE, v.this.eka);
                    }
                    String id = v.this.eka.threadData.getId();
                    n.tC(id);
                    v.this.cu(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ehO = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.ehO.getHeadView() != null) {
            this.ehO.getHeadView().setIsRound(true);
            this.ehO.getHeadView().setDrawBorder(false);
            this.ehO.getHeadView().setDefaultResource(17170445);
            this.ehO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehO.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehO.setHasPendantStyle();
        if (this.ehO.getPendantView() != null) {
            this.ehO.getPendantView().setIsRound(true);
            this.ehO.getPendantView().setDrawBorder(false);
        }
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.dqK = new NEGFeedBackView(this.mPageContext);
        this.dqK.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.XJ = (TextView) view.findViewById(d.g.thread_abstract);
        this.ejE = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.ejE.setSubClickListener(this.Zi);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dqz.setOnClickListener(this);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aQi() != null) {
                    v.this.aQi().a(view2, v.this.eka);
                }
                if (v.this.eka != null && v.this.eka.threadData != null) {
                    n.tC(v.this.eka.threadData.getId());
                    v.this.cu(v.this.eka.threadData.getId());
                }
            }
        });
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.dro.bTy.setOnClickListener(this);
        this.dro.bTy.setNeedAddReplyIcon(true);
        this.dro.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aQi() != null) {
                    v.this.aQi().a(view2, v.this.eka);
                }
                if (view2 != v.this.dro.bSP && v.this.eka != null && v.this.eka.threadData != null) {
                    n.tC(v.this.eka.threadData.getId());
                    v.this.cu(v.this.eka.threadData.getId());
                }
            }
        });
        this.eip = view.findViewById(d.g.divider_line_above_praise);
        this.ejY = view.findViewById(d.g.card_divider_line);
        this.ejZ = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.ekb = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dqz.changeSelectStatus();
            }
        });
        this.dqz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                al.l(v.this.mMaskView, z ? d.C0236d.cp_bg_line_d : d.C0236d.transparent);
            }
        });
    }

    private void S(final bg bgVar) {
        if (this.ekb != null) {
            if (this.ejZ == null || bgVar == null) {
                this.ekb.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDu) && this.ejZ.getVisibility() != 0) {
                if (this.dqK != null && this.dqK.getVisibility() == 0 && (this.ekb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ekb.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ekb.setLayoutParams(layoutParams);
                }
                this.ekb.setVisibility(0);
                this.ekb.setImageDrawable(null);
                this.ekb.startLoad(bgVar.bDu, 10, false);
                this.ekb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bgVar.bDv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ekb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.eip, d.C0236d.cp_bg_line_e);
            this.dqz.onChangeSkinType();
            this.dqy.onChangeSkinType();
            if (this.dqK != null) {
                this.dqK.onChangeSkinType();
            }
            this.ejE.onChangeSkinType();
            al.l(this.ejY, d.C0236d.cp_bg_line_e);
            this.dro.onChangeSkinType();
        }
        if (this.eka != null && this.eka.threadData != null) {
            al.l(this.mMaskView, this.eka.threadData.aaA() ? d.C0236d.cp_bg_line_d : d.C0236d.transparent);
        }
        if (this.ehO != null && this.ehO.getHeadView() != null && (this.ehO.getHeadView() instanceof TbImageView)) {
            this.ehO.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.eka = bhVar;
        bg bgVar = bhVar.threadData;
        if (this.dqK != null) {
            SparseArray<String> XA = bgVar.XA();
            if (XA != null && XA.size() > 0 && this.eit) {
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(XA);
                this.dqK.setData(ajVar);
                this.dqK.setFirstRowSingleColumn(true);
                this.dqK.setVisibility(U(bgVar) ? 8 : 0);
            } else {
                this.dqK.setVisibility(8);
            }
        }
        if (this.eka.bDT == 1) {
            this.dqy.setFrom(3);
            b(bgVar);
            S(bgVar);
        }
        if (this.currentPageType == 15) {
            this.dqy.setFrom(5);
        }
        this.dqy.setIsFromConcern(this.bTJ);
        this.dqy.setData(bgVar);
        this.dqy.setUserAfterClickListener(this.ZF);
        if (this.dqy.getHeaderImg() != null) {
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehO.setVisibility(8);
            } else if (bgVar.YR() == null || bgVar.YR().getPendantData() == null || StringUtils.isNull(bgVar.YR().getPendantData().Xn())) {
                this.ehO.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(bgVar);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehO.setVisibility(0);
                this.ehO.setData(bgVar);
            }
        }
        T(bgVar);
        this.ejE.b(bgVar.bDt);
        mF(lt(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cu(bgVar.getId());
        if (this.dqz.isInFrsAllThread() && com.baidu.tieba.frs.a.bbG().bbH()) {
            this.mMaskView.setVisibility(0);
            if (bgVar.aaA() || bgVar.aaB()) {
                al.l(this.mMaskView, d.C0236d.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(d.C0236d.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void T(bg bgVar) {
        if (bgVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCE)) {
                bgVar.bt(this.mUrl, this.bCE);
            }
            SpannableStringBuilder m = bgVar.m(false, true);
            if (m == null || StringUtils.isNull(m.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
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
        if (this.dqK != null) {
            this.dqK.setUniqueId(bdUniqueId);
        }
        if (this.dqy != null) {
            this.dqy.setPageUniqueId(bdUniqueId);
        }
    }

    public void hR(boolean z) {
        if (this.ejY != null) {
            this.ejY.setVisibility(z ? 0 : 8);
        }
    }

    public void hN(boolean z) {
        this.eit = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bTJ = z;
    }

    private void ajY() {
        if (this.eka != null && this.eka.threadData != null) {
            bg bgVar = this.eka.threadData;
            n.tC(bgVar.getId());
            cu(bgVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bgVar, null, this.eka.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.tC(bgVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(String str) {
        n.a(this.mTitle, str, d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        n.a(this.XJ, str, d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        this.ejE.setReadState(n.tD(str));
    }

    public void b(bg bgVar) {
        MetaData YR;
        if (bgVar != null && this.ejZ != null && (YR = bgVar.YR()) != null) {
            final ThemeCardInUserData themeCard = YR.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejZ.setVisibility(8);
                return;
            }
            this.ejZ.setVisibility(0);
            this.ejZ.setImageBitmap(null);
            this.ejZ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQi() != null) {
            aQi().a(view, this.eka);
        }
        if (view == getView()) {
            ajY();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dqy != null) {
            return this.dqy.bTi;
        }
        return null;
    }

    public View aQn() {
        if (this.dqy != null) {
            return this.dqy.Zx;
        }
        return null;
    }

    public void mF(int i) {
        if (this.eka != null && this.eka.threadData != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setFrom(this.eka.bDS);
                this.dro.setShareReportFrom(this.eka.bDT);
                this.dro.setStType(this.eka.stType);
                this.dro.setData(this.eka.threadData);
                this.dqy.dN(false);
                return;
            }
            this.dqz.setFrom(this.eka.bDS);
            this.dqz.setShareReportFrom(this.eka.bDT);
            this.dqz.setStType(this.eka.stType);
            this.dqz.setData(this.eka.threadData);
            this.dqz.setDisPraiseFrom(this.eka.bDU);
            this.dro.setVisibility(8);
            this.dqy.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awl().ak(this.Yz, i);
    }
}
