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
public class v extends a<bh> implements com.baidu.tieba.a.e {
    private TextView VW;
    private String WN;
    private final View.OnClickListener XU;
    private OriginalThreadCardView.a Xw;
    private boolean Yd;
    private String bLb;
    private boolean ccL;
    public ThreadUserInfoLayout dEA;
    public ThreadCommentAndPraiseInfoLayout dEB;
    private NEGFeedBackView dEM;
    public ThreadSourceShareAndPraiseLayout dFo;
    private View eCK;
    private boolean eCO;
    private HeadPendantClickableView eCk;
    public OriginalThreadCardView eDZ;
    private View eEs;
    private TbImageView eEt;
    private bh eEu;
    private TbImageView eEv;
    private ViewGroup eEw;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dEM = null;
        this.Yd = true;
        this.eCO = true;
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aZo() != null) {
                    v.this.aZo().a(view, v.this.eEu);
                }
            }
        };
        this.Xw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.eEu != null && v.this.eEu.threadData != null) {
                    if (v.this.aZo() != null) {
                        v.this.aZo().a(v.this.eDZ, v.this.eEu);
                    }
                    String id = v.this.eEu.threadData.getId();
                    n.vw(id);
                    v.this.cg(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.eEw = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.eEw.setOnClickListener(this);
        this.eCk = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.eCk.getHeadView() != null) {
            this.eCk.getHeadView().setIsRound(true);
            this.eCk.getHeadView().setDrawBorder(false);
            this.eCk.getHeadView().setDefaultResource(17170445);
            this.eCk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCk.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCk.setHasPendantStyle();
        if (this.eCk.getPendantView() != null) {
            this.eCk.getPendantView().setIsRound(true);
            this.eCk.getPendantView().setDrawBorder(false);
        }
        this.dEA = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.dEM = new NEGFeedBackView(this.mPageContext);
        this.dEM.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.VW = (TextView) view.findViewById(R.id.thread_abstract);
        this.eDZ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.eDZ.setSubClickListener(this.Xw);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.dEB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEB.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEB.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dEB.setOnClickListener(this);
        this.dEB.setReplyTimeVisible(false);
        this.dEB.setShowPraiseNum(true);
        this.dEB.setNeedAddPraiseIcon(true);
        this.dEB.setNeedAddReplyIcon(true);
        this.dEB.setShareVisible(true);
        this.dEB.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZo() != null) {
                    v.this.aZo().a(view2, v.this.eEu);
                }
                if (v.this.eEu != null && v.this.eEu.threadData != null) {
                    n.vw(v.this.eEu.threadData.getId());
                    v.this.cg(v.this.eEu.threadData.getId());
                }
            }
        });
        this.dFo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.dFo.ccA.setOnClickListener(this);
        this.dFo.ccA.setNeedAddReplyIcon(true);
        this.dFo.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZo() != null) {
                    v.this.aZo().a(view2, v.this.eEu);
                }
                if (view2 != v.this.dFo.cbO && v.this.eEu != null && v.this.eEu.threadData != null) {
                    n.vw(v.this.eEu.threadData.getId());
                    v.this.cg(v.this.eEu.threadData.getId());
                }
            }
        });
        this.eCK = view.findViewById(R.id.divider_line_above_praise);
        this.eEs = view.findViewById(R.id.card_divider_line);
        this.eEt = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.eEv = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dEB.changeSelectStatus();
            }
        });
        this.dEB.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eu(boolean z) {
                am.l(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void R(final bg bgVar) {
        if (this.eEv != null) {
            if (this.eEt == null || bgVar == null) {
                this.eEv.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bLR) && this.eEt.getVisibility() != 0) {
                if (this.dEM != null && this.dEM.getVisibility() == 0 && (this.eEv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEv.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eEv.setLayoutParams(layoutParams);
                }
                this.eEv.setVisibility(0);
                this.eEv.setImageDrawable(null);
                this.eEv.startLoad(bgVar.bLR, 10, false);
                this.eEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bgVar.bLS, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eEv.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.l(this.eCK, R.color.cp_bg_line_e);
            this.dEB.onChangeSkinType();
            this.dEA.onChangeSkinType();
            if (this.dEM != null) {
                this.dEM.onChangeSkinType();
            }
            this.eDZ.onChangeSkinType();
            am.l(this.eEs, R.color.cp_bg_line_e);
            this.dFo.onChangeSkinType();
        }
        if (this.eEu != null && this.eEu.threadData != null) {
            am.l(this.mMaskView, this.eEu.threadData.agg() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.eCk != null && this.eCk.getHeadView() != null && (this.eCk.getHeadView() instanceof TbImageView)) {
            this.eCk.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
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
        this.eEu = bhVar;
        bg bgVar = bhVar.threadData;
        if (this.dEM != null) {
            SparseArray<String> adg = bgVar.adg();
            if (adg != null && adg.size() > 0 && this.eCO) {
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(adg);
                this.dEM.setData(ajVar);
                this.dEM.setFirstRowSingleColumn(true);
                this.dEM.setVisibility(T(bgVar) ? 8 : 0);
            } else {
                this.dEM.setVisibility(8);
            }
        }
        if (this.eEu.bMt == 1) {
            this.dEA.setFrom(3);
            b(bgVar);
            R(bgVar);
        }
        if (this.currentPageType == 15) {
            this.dEA.setFrom(5);
        }
        this.dEA.setIsFromConcern(this.ccL);
        this.dEA.setData(bgVar);
        this.dEA.setUserAfterClickListener(this.XU);
        if (this.dEA.getHeaderImg() != null) {
            if (this.dEA.getIsSimpleThread()) {
                this.dEA.getHeaderImg().setVisibility(8);
                this.eCk.setVisibility(8);
            } else if (bgVar.aex() == null || bgVar.aex().getPendantData() == null || StringUtils.isNull(bgVar.aex().getPendantData().acU())) {
                this.eCk.setVisibility(8);
                this.dEA.getHeaderImg().setVisibility(0);
                this.dEA.getHeaderImg().setData(bgVar);
            } else {
                this.dEA.getHeaderImg().setVisibility(4);
                this.eCk.setVisibility(0);
                this.eCk.setData(bgVar);
            }
        }
        S(bgVar);
        this.eDZ.b(bgVar.bLQ);
        nE(mo(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cg(bgVar.getId());
        if (this.dEB.isInFrsAllThread() && com.baidu.tieba.frs.a.bkY().bkZ()) {
            this.mMaskView.setVisibility(0);
            if (bgVar.agg() || bgVar.agh()) {
                am.l(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void S(bg bgVar) {
        if (bgVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLb)) {
                bgVar.bC(this.mUrl, this.bLb);
            }
            SpannableStringBuilder o = bgVar.o(false, true);
            if (o == null || StringUtils.isNull(o.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean T(bg bgVar) {
        if (bgVar == null || bgVar.aex() == null || StringUtils.isNull(bgVar.aex().getUserId())) {
            return false;
        }
        return bgVar.aex().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dEM != null) {
            this.dEM.setUniqueId(bdUniqueId);
        }
        if (this.dEA != null) {
            this.dEA.setPageUniqueId(bdUniqueId);
        }
    }

    public void iF(boolean z) {
        if (this.eEs != null) {
            this.eEs.setVisibility(z ? 0 : 8);
        }
    }

    public void iB(boolean z) {
        this.eCO = z;
    }

    private void aqb() {
        if (this.eEu != null && this.eEu.threadData != null) {
            bg bgVar = this.eEu.threadData;
            n.vw(bgVar.getId());
            cg(bgVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bgVar, null, this.eEu.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.vw(bgVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(String str) {
        n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(this.VW, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.eDZ.setReadState(n.vx(str));
    }

    public void b(bg bgVar) {
        MetaData aex;
        if (bgVar != null && this.eEt != null && (aex = bgVar.aex()) != null) {
            final ThemeCardInUserData themeCard = aex.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eEt.setVisibility(8);
                return;
            }
            this.eEt.setVisibility(0);
            this.eEt.setImageBitmap(null);
            this.eEt.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZo() != null) {
            aZo().a(view, this.eEu);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aqb();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dEA != null) {
            return this.dEA.cch;
        }
        return null;
    }

    public View aZt() {
        if (this.dEA != null) {
            return this.dEA.XL;
        }
        return null;
    }

    public void nE(int i) {
        if (this.eEu != null && this.eEu.threadData != null) {
            if (i == 1) {
                this.dEB.setVisibility(8);
                this.dFo.setFrom(this.eEu.bMs);
                this.dFo.setShareReportFrom(this.eEu.bMt);
                this.dFo.setStType(this.eEu.stType);
                this.dFo.setData(this.eEu.threadData);
                this.dEA.en(false);
                return;
            }
            this.dEB.setFrom(this.eEu.bMs);
            this.dEB.setShareReportFrom(this.eEu.bMt);
            this.dEB.setStType(this.eEu.stType);
            this.dEB.setData(this.eEu.threadData);
            this.dEB.setDisPraiseFrom(this.eEu.bMu);
            this.dFo.setVisibility(8);
            this.dEA.en(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mo(int i) {
        return com.baidu.tieba.a.d.aCF().ag(this.WN, i);
    }
}
