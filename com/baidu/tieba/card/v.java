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
    private TextView XL;
    private String YB;
    private final View.OnClickListener ZI;
    private boolean ZR;
    private OriginalThreadCardView.a Zk;
    private String bCK;
    private boolean bTN;
    private NEGFeedBackView dqK;
    public ThreadUserInfoLayout dqy;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    private View ehY;
    private HeadPendantClickableView ehx;
    private boolean eic;
    private View ejH;
    private TbImageView ejI;
    private bh ejJ;
    private TbImageView ejK;
    public OriginalThreadCardView ejn;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqK = null;
        this.ZR = true;
        this.eic = true;
        this.ZI = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aQf() != null) {
                    v.this.aQf().a(view, v.this.ejJ);
                }
            }
        };
        this.Zk = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.ejJ != null && v.this.ejJ.threadData != null) {
                    if (v.this.aQf() != null) {
                        v.this.aQf().a(v.this.ejn, v.this.ejJ);
                    }
                    String id = v.this.ejJ.threadData.getId();
                    n.tz(id);
                    v.this.cu(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ehx = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.ehx.getHeadView() != null) {
            this.ehx.getHeadView().setIsRound(true);
            this.ehx.getHeadView().setDrawBorder(false);
            this.ehx.getHeadView().setDefaultResource(17170445);
            this.ehx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehx.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehx.setHasPendantStyle();
        if (this.ehx.getPendantView() != null) {
            this.ehx.getPendantView().setIsRound(true);
            this.ehx.getPendantView().setDrawBorder(false);
        }
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.dqK = new NEGFeedBackView(this.mPageContext);
        this.dqK.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.XL = (TextView) view.findViewById(d.g.thread_abstract);
        this.ejn = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.ejn.setSubClickListener(this.Zk);
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
                if (v.this.aQf() != null) {
                    v.this.aQf().a(view2, v.this.ejJ);
                }
                if (v.this.ejJ != null && v.this.ejJ.threadData != null) {
                    n.tz(v.this.ejJ.threadData.getId());
                    v.this.cu(v.this.ejJ.threadData.getId());
                }
            }
        });
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.dro.bTC.setOnClickListener(this);
        this.dro.bTC.setNeedAddReplyIcon(true);
        this.dro.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aQf() != null) {
                    v.this.aQf().a(view2, v.this.ejJ);
                }
                if (view2 != v.this.dro.bST && v.this.ejJ != null && v.this.ejJ.threadData != null) {
                    n.tz(v.this.ejJ.threadData.getId());
                    v.this.cu(v.this.ejJ.threadData.getId());
                }
            }
        });
        this.ehY = view.findViewById(d.g.divider_line_above_praise);
        this.ejH = view.findViewById(d.g.card_divider_line);
        this.ejI = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.ejK = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
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
                al.l(v.this.mMaskView, z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
            }
        });
    }

    private void R(final bg bgVar) {
        if (this.ejK != null) {
            if (this.ejI == null || bgVar == null) {
                this.ejK.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDA) && this.ejI.getVisibility() != 0) {
                if (this.dqK != null && this.dqK.getVisibility() == 0 && (this.ejK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejK.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ejK.setLayoutParams(layoutParams);
                }
                this.ejK.setVisibility(0);
                this.ejK.setImageDrawable(null);
                this.ejK.startLoad(bgVar.bDA, 10, false);
                this.ejK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bgVar.bDB, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejK.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.ehY, d.C0277d.cp_bg_line_e);
            this.dqz.onChangeSkinType();
            this.dqy.onChangeSkinType();
            if (this.dqK != null) {
                this.dqK.onChangeSkinType();
            }
            this.ejn.onChangeSkinType();
            al.l(this.ejH, d.C0277d.cp_bg_line_e);
            this.dro.onChangeSkinType();
        }
        if (this.ejJ != null && this.ejJ.threadData != null) {
            al.l(this.mMaskView, this.ejJ.threadData.aax() ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
        }
        if (this.ehx != null && this.ehx.getHeadView() != null && (this.ehx.getHeadView() instanceof TbImageView)) {
            this.ehx.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ejJ = bhVar;
        bg bgVar = bhVar.threadData;
        if (this.dqK != null) {
            SparseArray<String> Xx = bgVar.Xx();
            if (Xx != null && Xx.size() > 0 && this.eic) {
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(Xx);
                this.dqK.setData(ajVar);
                this.dqK.setFirstRowSingleColumn(true);
                this.dqK.setVisibility(T(bgVar) ? 8 : 0);
            } else {
                this.dqK.setVisibility(8);
            }
        }
        if (this.ejJ.bDZ == 1) {
            this.dqy.setFrom(3);
            b(bgVar);
            R(bgVar);
        }
        if (this.currentPageType == 15) {
            this.dqy.setFrom(5);
        }
        this.dqy.setIsFromConcern(this.bTN);
        this.dqy.setData(bgVar);
        this.dqy.setUserAfterClickListener(this.ZI);
        if (this.dqy.getHeaderImg() != null) {
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehx.setVisibility(8);
            } else if (bgVar.YO() == null || bgVar.YO().getPendantData() == null || StringUtils.isNull(bgVar.YO().getPendantData().Xk())) {
                this.ehx.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(bgVar);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehx.setVisibility(0);
                this.ehx.setData(bgVar);
            }
        }
        S(bgVar);
        this.ejn.b(bgVar.bDz);
        mE(ls(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cu(bgVar.getId());
        if (this.dqz.isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCK)) {
                bgVar.bt(this.mUrl, this.bCK);
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
        if (this.dqK != null) {
            this.dqK.setUniqueId(bdUniqueId);
        }
        if (this.dqy != null) {
            this.dqy.setPageUniqueId(bdUniqueId);
        }
    }

    public void hR(boolean z) {
        if (this.ejH != null) {
            this.ejH.setVisibility(z ? 0 : 8);
        }
    }

    public void hN(boolean z) {
        this.eic = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bTN = z;
    }

    private void ajU() {
        if (this.ejJ != null && this.ejJ.threadData != null) {
            bg bgVar = this.ejJ.threadData;
            n.tz(bgVar.getId());
            cu(bgVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bgVar, null, this.ejJ.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.tz(bgVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(String str) {
        n.a(this.mTitle, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        n.a(this.XL, str, d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        this.ejn.setReadState(n.tA(str));
    }

    public void b(bg bgVar) {
        MetaData YO;
        if (bgVar != null && this.ejI != null && (YO = bgVar.YO()) != null) {
            final ThemeCardInUserData themeCard = YO.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejI.setVisibility(8);
                return;
            }
            this.ejI.setVisibility(0);
            this.ejI.setImageBitmap(null);
            this.ejI.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
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
            aQf().a(view, this.ejJ);
        }
        if (view == getView()) {
            ajU();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dqy != null) {
            return this.dqy.bTm;
        }
        return null;
    }

    public View aQk() {
        if (this.dqy != null) {
            return this.dqy.Zz;
        }
        return null;
    }

    public void mE(int i) {
        if (this.ejJ != null && this.ejJ.threadData != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setFrom(this.ejJ.bDY);
                this.dro.setShareReportFrom(this.ejJ.bDZ);
                this.dro.setStType(this.ejJ.stType);
                this.dro.setData(this.ejJ.threadData);
                this.dqy.dN(false);
                return;
            }
            this.dqz.setFrom(this.ejJ.bDY);
            this.dqz.setShareReportFrom(this.ejJ.bDZ);
            this.dqz.setStType(this.ejJ.stType);
            this.dqz.setData(this.ejJ.threadData);
            this.dqz.setDisPraiseFrom(this.ejJ.bEa);
            this.dro.setVisibility(8);
            this.dqy.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
    }
}
