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
    private TextView VW;
    private String WN;
    private final View.OnClickListener XU;
    private OriginalThreadCardView.a Xw;
    private boolean Yd;
    private String bLg;
    private boolean ccS;
    public ThreadUserInfoLayout dEH;
    public ThreadCommentAndPraiseInfoLayout dEI;
    private NEGFeedBackView dET;
    public ThreadSourceShareAndPraiseLayout dFv;
    private View eCR;
    private boolean eCV;
    private HeadPendantClickableView eCr;
    private TbImageView eEA;
    private bi eEB;
    private TbImageView eEC;
    private ViewGroup eED;
    public OriginalThreadCardView eEg;
    private View eEz;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dET = null;
        this.Yd = true;
        this.eCV = true;
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aZq() != null) {
                    v.this.aZq().a(view, v.this.eEB);
                }
            }
        };
        this.Xw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.eEB != null && v.this.eEB.threadData != null) {
                    if (v.this.aZq() != null) {
                        v.this.aZq().a(v.this.eEg, v.this.eEB);
                    }
                    String id = v.this.eEB.threadData.getId();
                    n.vx(id);
                    v.this.cg(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.eED = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.eED.setOnClickListener(this);
        this.eCr = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.eCr.getHeadView() != null) {
            this.eCr.getHeadView().setIsRound(true);
            this.eCr.getHeadView().setDrawBorder(false);
            this.eCr.getHeadView().setDefaultResource(17170445);
            this.eCr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCr.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCr.setHasPendantStyle();
        if (this.eCr.getPendantView() != null) {
            this.eCr.getPendantView().setIsRound(true);
            this.eCr.getPendantView().setDrawBorder(false);
        }
        this.dEH = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.dET = new NEGFeedBackView(this.mPageContext);
        this.dET.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.VW = (TextView) view.findViewById(R.id.thread_abstract);
        this.eEg = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.eEg.setSubClickListener(this.Xw);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.dEI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEI.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dEI.setOnClickListener(this);
        this.dEI.setReplyTimeVisible(false);
        this.dEI.setShowPraiseNum(true);
        this.dEI.setNeedAddPraiseIcon(true);
        this.dEI.setNeedAddReplyIcon(true);
        this.dEI.setShareVisible(true);
        this.dEI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZq() != null) {
                    v.this.aZq().a(view2, v.this.eEB);
                }
                if (v.this.eEB != null && v.this.eEB.threadData != null) {
                    n.vx(v.this.eEB.threadData.getId());
                    v.this.cg(v.this.eEB.threadData.getId());
                }
            }
        });
        this.dFv = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.dFv.ccH.setOnClickListener(this);
        this.dFv.ccH.setNeedAddReplyIcon(true);
        this.dFv.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZq() != null) {
                    v.this.aZq().a(view2, v.this.eEB);
                }
                if (view2 != v.this.dFv.cbV && v.this.eEB != null && v.this.eEB.threadData != null) {
                    n.vx(v.this.eEB.threadData.getId());
                    v.this.cg(v.this.eEB.threadData.getId());
                }
            }
        });
        this.eCR = view.findViewById(R.id.divider_line_above_praise);
        this.eEz = view.findViewById(R.id.card_divider_line);
        this.eEA = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.eEC = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dEI.changeSelectStatus();
            }
        });
        this.dEI.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eu(boolean z) {
                am.l(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void S(final bh bhVar) {
        if (this.eEC != null) {
            if (this.eEA == null || bhVar == null) {
                this.eEC.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.bLW) && this.eEA.getVisibility() != 0) {
                if (this.dET != null && this.dET.getVisibility() == 0 && (this.eEC.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEC.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eEC.setLayoutParams(layoutParams);
                }
                this.eEC.setVisibility(0);
                this.eEC.setImageDrawable(null);
                this.eEC.startLoad(bhVar.bLW, 10, false);
                this.eEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bhVar.bLX, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eEC.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.l(this.eCR, R.color.cp_bg_line_e);
            this.dEI.onChangeSkinType();
            this.dEH.onChangeSkinType();
            if (this.dET != null) {
                this.dET.onChangeSkinType();
            }
            this.eEg.onChangeSkinType();
            am.l(this.eEz, R.color.cp_bg_line_e);
            this.dFv.onChangeSkinType();
        }
        if (this.eEB != null && this.eEB.threadData != null) {
            am.l(this.mMaskView, this.eEB.threadData.agh() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.eCr != null && this.eCr.getHeadView() != null && (this.eCr.getHeadView() instanceof TbImageView)) {
            this.eCr.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
        this.eEB = biVar;
        bh bhVar = biVar.threadData;
        if (this.dET != null) {
            SparseArray<String> adh = bhVar.adh();
            if (adh != null && adh.size() > 0 && this.eCV) {
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.b(adh);
                this.dET.setData(ajVar);
                this.dET.setFirstRowSingleColumn(true);
                this.dET.setVisibility(U(bhVar) ? 8 : 0);
            } else {
                this.dET.setVisibility(8);
            }
        }
        if (this.eEB.bMy == 1) {
            this.dEH.setFrom(3);
            b(bhVar);
            S(bhVar);
        }
        if (this.currentPageType == 15) {
            this.dEH.setFrom(5);
        }
        this.dEH.setIsFromConcern(this.ccS);
        this.dEH.setData(bhVar);
        this.dEH.setUserAfterClickListener(this.XU);
        if (this.dEH.getHeaderImg() != null) {
            if (this.dEH.getIsSimpleThread()) {
                this.dEH.getHeaderImg().setVisibility(8);
                this.eCr.setVisibility(8);
            } else if (bhVar.aey() == null || bhVar.aey().getPendantData() == null || StringUtils.isNull(bhVar.aey().getPendantData().acV())) {
                this.eCr.setVisibility(8);
                this.dEH.getHeaderImg().setVisibility(0);
                this.dEH.getHeaderImg().setData(bhVar);
            } else {
                this.dEH.getHeaderImg().setVisibility(4);
                this.eCr.setVisibility(0);
                this.eCr.setData(bhVar);
            }
        }
        T(bhVar);
        this.eEg.b(bhVar.bLV);
        nF(mp(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cg(bhVar.getId());
        if (this.dEI.isInFrsAllThread() && com.baidu.tieba.frs.a.blf().blg()) {
            this.mMaskView.setVisibility(0);
            if (bhVar.agh() || bhVar.agi()) {
                am.l(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void T(bh bhVar) {
        if (bhVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLg)) {
                bhVar.bC(this.mUrl, this.bLg);
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

    private boolean U(bh bhVar) {
        if (bhVar == null || bhVar.aey() == null || StringUtils.isNull(bhVar.aey().getUserId())) {
            return false;
        }
        return bhVar.aey().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dET != null) {
            this.dET.setUniqueId(bdUniqueId);
        }
        if (this.dEH != null) {
            this.dEH.setPageUniqueId(bdUniqueId);
        }
    }

    public void iF(boolean z) {
        if (this.eEz != null) {
            this.eEz.setVisibility(z ? 0 : 8);
        }
    }

    public void iB(boolean z) {
        this.eCV = z;
    }

    private void aqd() {
        if (this.eEB != null && this.eEB.threadData != null) {
            bh bhVar = this.eEB.threadData;
            n.vx(bhVar.getId());
            cg(bhVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bhVar, null, this.eEB.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.vx(bhVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(String str) {
        n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(this.VW, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.eEg.setReadState(n.vy(str));
    }

    public void b(bh bhVar) {
        MetaData aey;
        if (bhVar != null && this.eEA != null && (aey = bhVar.aey()) != null) {
            final ThemeCardInUserData themeCard = aey.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eEA.setVisibility(8);
                return;
            }
            this.eEA.setVisibility(0);
            this.eEA.setImageBitmap(null);
            this.eEA.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eEA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZq() != null) {
            aZq().a(view, this.eEB);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aqd();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dEH != null) {
            return this.dEH.cco;
        }
        return null;
    }

    public View aZv() {
        if (this.dEH != null) {
            return this.dEH.XL;
        }
        return null;
    }

    public void nF(int i) {
        if (this.eEB != null && this.eEB.threadData != null) {
            if (i == 1) {
                this.dEI.setVisibility(8);
                this.dFv.setFrom(this.eEB.bMx);
                this.dFv.setShareReportFrom(this.eEB.bMy);
                this.dFv.setStType(this.eEB.stType);
                this.dFv.setData(this.eEB.threadData);
                this.dEH.en(false);
                return;
            }
            this.dEI.setFrom(this.eEB.bMx);
            this.dEI.setShareReportFrom(this.eEB.bMy);
            this.dEI.setStType(this.eEB.stType);
            this.dEI.setData(this.eEB.threadData);
            this.dEI.setDisPraiseFrom(this.eEB.bMz);
            this.dFv.setVisibility(8);
            this.dEH.en(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mp(int i) {
        return com.baidu.tieba.a.d.aCH().ag(this.WN, i);
    }
}
