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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes3.dex */
public class v extends a<bi> implements com.baidu.tieba.a.e {
    private TextView VV;
    private String WM;
    private final View.OnClickListener XU;
    private OriginalThreadCardView.a Xv;
    private boolean Yd;
    private String bLE;
    private boolean cdL;
    private NEGFeedBackView dGE;
    public ThreadUserInfoLayout dGs;
    public ThreadCommentAndPraiseInfoLayout dGt;
    public ThreadSourceShareAndPraiseLayout dHg;
    private View eEA;
    private boolean eEE;
    private HeadPendantClickableView eEa;
    public OriginalThreadCardView eFP;
    private View eGi;
    private TbImageView eGj;
    private bi eGk;
    private TbImageView eGl;
    private ViewGroup eGm;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dGE = null;
        this.Yd = true;
        this.eEE = true;
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aZU() != null) {
                    v.this.aZU().a(view, v.this.eGk);
                }
            }
        };
        this.Xv = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.eGk != null && v.this.eGk.threadData != null) {
                    if (v.this.aZU() != null) {
                        v.this.aZU().a(v.this.eFP, v.this.eGk);
                    }
                    String id = v.this.eGk.threadData.getId();
                    n.vW(id);
                    v.this.cg(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.eGm = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.eGm.setOnClickListener(this);
        this.eEa = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.eEa.getHeadView() != null) {
            this.eEa.getHeadView().setIsRound(true);
            this.eEa.getHeadView().setDrawBorder(false);
            this.eEa.getHeadView().setDefaultResource(17170445);
            this.eEa.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eEa.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eEa.setHasPendantStyle();
        if (this.eEa.getPendantView() != null) {
            this.eEa.getPendantView().setIsRound(true);
            this.eEa.getPendantView().setDrawBorder(false);
        }
        this.dGs = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.dGE = new NEGFeedBackView(this.mPageContext);
        this.dGE.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.VV = (TextView) view.findViewById(R.id.thread_abstract);
        this.eFP = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.eFP.setSubClickListener(this.Xv);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.dGt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGt.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dGt.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dGt.setOnClickListener(this);
        this.dGt.setReplyTimeVisible(false);
        this.dGt.setShowPraiseNum(true);
        this.dGt.setNeedAddPraiseIcon(true);
        this.dGt.setNeedAddReplyIcon(true);
        this.dGt.setShareVisible(true);
        this.dGt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZU() != null) {
                    v.this.aZU().a(view2, v.this.eGk);
                }
                if (v.this.eGk != null && v.this.eGk.threadData != null) {
                    n.vW(v.this.eGk.threadData.getId());
                    v.this.cg(v.this.eGk.threadData.getId());
                }
            }
        });
        this.dHg = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.dHg.cdA.setOnClickListener(this);
        this.dHg.cdA.setNeedAddReplyIcon(true);
        this.dHg.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZU() != null) {
                    v.this.aZU().a(view2, v.this.eGk);
                }
                if (view2 != v.this.dHg.ccP && v.this.eGk != null && v.this.eGk.threadData != null) {
                    n.vW(v.this.eGk.threadData.getId());
                    v.this.cg(v.this.eGk.threadData.getId());
                }
            }
        });
        this.eEA = view.findViewById(R.id.divider_line_above_praise);
        this.eGi = view.findViewById(R.id.card_divider_line);
        this.eGj = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.eGl = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dGt.changeSelectStatus();
            }
        });
        this.dGt.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ex(boolean z) {
                am.l(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void T(final bh bhVar) {
        if (this.eGl != null) {
            if (this.eGj == null || bhVar == null) {
                this.eGl.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.bMu) && this.eGj.getVisibility() != 0) {
                if (this.dGE != null && this.dGE.getVisibility() == 0 && (this.eGl.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eGl.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eGl.setLayoutParams(layoutParams);
                }
                this.eGl.setVisibility(0);
                this.eGl.setImageDrawable(null);
                this.eGl.startLoad(bhVar.bMu, 10, false);
                this.eGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bhVar.bMv, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eGl.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.l(this.eEA, R.color.cp_bg_line_c);
            this.dGt.onChangeSkinType();
            this.dGs.onChangeSkinType();
            if (this.dGE != null) {
                this.dGE.onChangeSkinType();
            }
            this.eFP.onChangeSkinType();
            am.l(this.eGi, R.color.cp_bg_line_e);
            this.dHg.onChangeSkinType();
        }
        if (this.eGk != null && this.eGk.threadData != null) {
            am.l(this.mMaskView, this.eGk.threadData.agl() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.eEa != null && this.eEa.getHeadView() != null && (this.eEa.getHeadView() instanceof TbImageView)) {
            this.eEa.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bi biVar) {
        if (biVar == null || biVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.eGk = biVar;
        bh bhVar = biVar.threadData;
        if (this.dGE != null) {
            SparseArray<String> adl = bhVar.adl();
            if (adl != null && adl.size() > 0 && this.eEE) {
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.b(adl);
                this.dGE.setData(ajVar);
                this.dGE.setFirstRowSingleColumn(true);
                this.dGE.setVisibility(V(bhVar) ? 8 : 0);
            } else {
                this.dGE.setVisibility(8);
            }
        }
        if (this.eGk.bMX == 1) {
            this.dGs.setFrom(3);
            b(bhVar);
            T(bhVar);
        }
        if (this.currentPageType == 15) {
            this.dGs.setFrom(5);
        }
        this.dGs.setIsFromConcern(this.cdL);
        this.dGs.setData(bhVar);
        this.dGs.setUserAfterClickListener(this.XU);
        if (this.dGs.getHeaderImg() != null) {
            if (this.dGs.getIsSimpleThread()) {
                this.dGs.getHeaderImg().setVisibility(8);
                this.eEa.setVisibility(8);
            } else if (bhVar.aeC() == null || bhVar.aeC().getPendantData() == null || StringUtils.isNull(bhVar.aeC().getPendantData().acZ())) {
                this.eEa.setVisibility(8);
                this.dGs.getHeaderImg().setVisibility(0);
                this.dGs.getHeaderImg().setData(bhVar);
            } else {
                this.dGs.getHeaderImg().setVisibility(4);
                this.eEa.setVisibility(0);
                this.eEa.setData(bhVar);
            }
        }
        U(bhVar);
        this.eFP.b(bhVar.bMt);
        nJ(mt(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cg(bhVar.getId());
        if (this.dGt.isInFrsAllThread() && com.baidu.tieba.frs.a.blQ().blR()) {
            this.mMaskView.setVisibility(0);
            if (bhVar.agl() || bhVar.agm()) {
                am.l(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void U(bh bhVar) {
        if (bhVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLE)) {
                bhVar.bC(this.mUrl, this.bLE);
            }
            SpannableStringBuilder o = bhVar.o(false, true);
            if (o == null || StringUtils.isNull(o.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean V(bh bhVar) {
        if (bhVar == null || bhVar.aeC() == null || StringUtils.isNull(bhVar.aeC().getUserId())) {
            return false;
        }
        return bhVar.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dGE != null) {
            this.dGE.setUniqueId(bdUniqueId);
        }
        if (this.dGs != null) {
            this.dGs.setPageUniqueId(bdUniqueId);
        }
    }

    public void iI(boolean z) {
        if (this.eGi != null) {
            this.eGi.setVisibility(z ? 0 : 8);
        }
    }

    public void iE(boolean z) {
        this.eEE = z;
    }

    private void aqp() {
        if (this.eGk != null && this.eGk.threadData != null) {
            bh bhVar = this.eGk.threadData;
            n.vW(bhVar.getId());
            cg(bhVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bhVar, null, this.eGk.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.vW(bhVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(String str) {
        n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(this.VV, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.eFP.setReadState(n.vX(str));
    }

    public void b(bh bhVar) {
        MetaData aeC;
        if (bhVar != null && this.eGj != null && (aeC = bhVar.aeC()) != null) {
            final ThemeCardInUserData themeCard = aeC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eGj.setVisibility(8);
                return;
            }
            this.eGj.setVisibility(0);
            this.eGj.setImageBitmap(null);
            this.eGj.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZU() != null) {
            aZU().a(view, this.eGk);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aqp();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dGs != null) {
            return this.dGs.cdi;
        }
        return null;
    }

    public View aZZ() {
        if (this.dGs != null) {
            return this.dGs.XK;
        }
        return null;
    }

    public void nJ(int i) {
        if (this.eGk != null && this.eGk.threadData != null) {
            if (i == 1) {
                this.dGt.setVisibility(8);
                this.dHg.setFrom(this.eGk.bMW);
                this.dHg.setShareReportFrom(this.eGk.bMX);
                this.dHg.setStType(this.eGk.stType);
                this.dHg.setData(this.eGk.threadData);
                this.dGs.eq(false);
                return;
            }
            this.dGt.setFrom(this.eGk.bMW);
            this.dGt.setShareReportFrom(this.eGk.bMX);
            this.dGt.setStType(this.eGk.stType);
            this.dGt.setData(this.eGk.threadData);
            this.dGt.setDisPraiseFrom(this.eGk.bMY);
            this.dHg.setVisibility(8);
            this.dGs.eq(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public int mt(int i) {
        return com.baidu.tieba.a.d.aCV().ag(this.WM, i);
    }
}
