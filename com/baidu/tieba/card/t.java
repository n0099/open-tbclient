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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
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
/* loaded from: classes6.dex */
public class t extends a<bk> implements com.baidu.tieba.a.e {
    private TextView Kf;
    private OriginalThreadCardView.a LY;
    private String Lg;
    private final View.OnClickListener MX;
    private boolean Nj;
    private String cPg;
    private boolean deN;
    private NEGFeedBackView eJD;
    public ThreadUserInfoLayout eJq;
    public ThreadCommentAndPraiseInfoLayout eJr;
    public ThreadSourceShareAndPraiseLayout eKe;
    private HeadPendantClickableView fGQ;
    private View fHo;
    private boolean fHs;
    public OriginalThreadCardView fIC;
    private View fIV;
    private TbImageView fIW;
    private bk fIX;
    private TbImageView fIY;
    private ViewGroup fIZ;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eJD = null;
        this.Nj = true;
        this.fHs = true;
        this.MX = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.bta() != null) {
                    t.this.bta().a(view, t.this.fIX);
                }
            }
        };
        this.LY = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.fIX != null && t.this.fIX.cNb != null) {
                    if (t.this.bta() != null) {
                        t.this.bta().a(t.this.fIC, t.this.fIX);
                    }
                    String id = t.this.fIX.cNb.getId();
                    l.zC(id);
                    t.this.bZ(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.fIZ = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.fIZ.setOnClickListener(this);
        this.fGQ = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.fGQ.getHeadView() != null) {
            this.fGQ.getHeadView().setIsRound(true);
            this.fGQ.getHeadView().setDrawBorder(false);
            this.fGQ.getHeadView().setDefaultResource(17170445);
            this.fGQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fGQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.fGQ.getHeadView().setPlaceHolder(1);
        }
        this.fGQ.setHasPendantStyle();
        if (this.fGQ.getPendantView() != null) {
            this.fGQ.getPendantView().setIsRound(true);
            this.fGQ.getPendantView().setDrawBorder(false);
        }
        this.eJq = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.eJD = new NEGFeedBackView(this.mPageContext);
        this.eJD.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.Kf = (TextView) view.findViewById(R.id.thread_abstract);
        this.fIC = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.fIC.setSubClickListener(this.LY);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.eJr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eJr.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.eJr.setOnClickListener(this);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setShareVisible(true);
        this.eJr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.bta() != null) {
                    t.this.bta().a(view2, t.this.fIX);
                }
                if (t.this.fIX != null && t.this.fIX.cNb != null) {
                    l.zC(t.this.fIX.cNb.getId());
                    t.this.bZ(t.this.fIX.cNb.getId());
                }
            }
        });
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.eKe.deA.setOnClickListener(this);
        this.eKe.deA.setNeedAddReplyIcon(true);
        this.eKe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.bta() != null) {
                    t.this.bta().a(view2, t.this.fIX);
                }
                if (view2 != t.this.eKe.ddO && t.this.fIX != null && t.this.fIX.cNb != null) {
                    l.zC(t.this.fIX.cNb.getId());
                    t.this.bZ(t.this.fIX.cNb.getId());
                }
            }
        });
        this.fHo = view.findViewById(R.id.divider_line_above_praise);
        this.fIV = view.findViewById(R.id.card_divider_line);
        this.fIW = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.fIY = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.eJr.changeSelectStatus();
            }
        });
        this.eJr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fM(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void W(final bj bjVar) {
        if (this.fIY != null) {
            if (this.fIW == null || bjVar == null) {
                this.fIY.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cPO) && this.fIW.getVisibility() != 0) {
                if (this.eJD != null && this.eJD.getVisibility() == 0 && (this.fIY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fIY.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fIY.setLayoutParams(layoutParams);
                }
                this.fIY.setVisibility(0);
                this.fIY.setImageDrawable(null);
                this.fIY.startLoad(bjVar.cPO, 10, false);
                this.fIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.cPP, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fIY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fHo, R.color.cp_bg_line_c);
            this.eJr.onChangeSkinType();
            this.eJq.onChangeSkinType();
            if (this.eJD != null) {
                this.eJD.onChangeSkinType();
            }
            this.fIC.onChangeSkinType();
            am.setBackgroundColor(this.fIV, R.color.cp_bg_line_e);
            this.eKe.onChangeSkinType();
        }
        if (this.fIX != null && this.fIX.cNb != null) {
            am.setBackgroundColor(this.mMaskView, this.fIX.cNb.aBG() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.fGQ != null && this.fGQ.getHeadView() != null && (this.fGQ.getHeadView() instanceof TbImageView)) {
            this.fGQ.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bk bkVar) {
        if (bkVar == null || bkVar.cNb == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.fIX = bkVar;
        bj bjVar = bkVar.cNb;
        if (this.eJD != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.fHs) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.eJD.setData(alVar);
                this.eJD.setFirstRowSingleColumn(true);
                this.eJD.setVisibility(Y(bjVar) ? 8 : 0);
            } else {
                this.eJD.setVisibility(8);
            }
        }
        if (this.fIX.cQy == 1) {
            this.eJq.setFrom(3);
            b(bjVar);
            W(bjVar);
        }
        if (this.currentPageType == 15) {
            this.eJq.setFrom(5);
        }
        this.eJq.setIsFromConcern(this.deN);
        this.eJq.setData(bjVar);
        this.eJq.setUserAfterClickListener(this.MX);
        if (this.eJq.getHeaderImg() != null) {
            if (this.eJq.getIsSimpleThread()) {
                this.eJq.getHeaderImg().setVisibility(8);
                this.fGQ.setVisibility(8);
            } else if (bjVar.azX() == null || bjVar.azX().getPendantData() == null || StringUtils.isNull(bjVar.azX().getPendantData().ayq())) {
                this.fGQ.setVisibility(8);
                this.eJq.getHeaderImg().setVisibility(0);
                this.eJq.getHeaderImg().setData(bjVar);
            } else {
                this.eJq.getHeaderImg().setVisibility(4);
                this.fGQ.setVisibility(0);
                this.fGQ.setData(bjVar);
            }
        }
        X(bjVar);
        this.fIC.b(bjVar.cPN);
        pq(nL(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        bZ(bjVar.getId());
        if (this.eJr.isInFrsAllThread() && com.baidu.tieba.frs.a.bBr().bBs()) {
            this.mMaskView.setVisibility(0);
            if (bjVar.aBG() || bjVar.aBH()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void X(bj bjVar) {
        if (bjVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cPg)) {
                bjVar.cg(this.mUrl, this.cPg);
            }
            SpannableStringBuilder r = bjVar.r(false, true);
            if (r == null || StringUtils.isNull(r.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.h(r));
            this.mTitle.setText(r);
            l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean Y(bj bjVar) {
        if (bjVar == null || bjVar.azX() == null || StringUtils.isNull(bjVar.azX().getUserId())) {
            return false;
        }
        return bjVar.azX().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eJD != null) {
            this.eJD.setUniqueId(bdUniqueId);
        }
        if (this.eJq != null) {
            this.eJq.setPageUniqueId(bdUniqueId);
        }
    }

    public void ko(boolean z) {
        if (this.fIV != null) {
            this.fIV.setVisibility(z ? 0 : 8);
        }
    }

    public void kj(boolean z) {
        this.fHs = z;
    }

    private void aKa() {
        if (this.fIX != null && this.fIX.cNb != null) {
            bj bjVar = this.fIX.cNb;
            l.zC(bjVar.getId());
            bZ(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.fIX.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            l.zC(bjVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(String str) {
        l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        l.a(this.Kf, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.fIC.setReadState(l.zD(str));
    }

    public void b(bj bjVar) {
        MetaData azX;
        if (bjVar != null && this.fIW != null && (azX = bjVar.azX()) != null) {
            final ThemeCardInUserData themeCard = azX.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fIW.setVisibility(8);
                return;
            }
            this.fIW.setVisibility(0);
            this.fIW.setImageBitmap(null);
            this.fIW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fIW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(view, this.fIX);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aKa();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eJq != null) {
            return this.eJq.dei;
        }
        return null;
    }

    public View btf() {
        if (this.eJq != null) {
            return this.eJq.MK;
        }
        return null;
    }

    public void pq(int i) {
        if (this.fIX != null && this.fIX.cNb != null) {
            if (i == 1) {
                this.eJr.setVisibility(8);
                this.eKe.setFrom(this.fIX.cQx);
                this.eKe.setShareReportFrom(this.fIX.cQy);
                this.eKe.setStType(this.fIX.stType);
                this.eKe.setData(this.fIX.cNb);
                this.eJq.fK(false);
                return;
            }
            this.eJr.setFrom(this.fIX.cQx);
            this.eJr.setShareReportFrom(this.fIX.cQy);
            this.eJr.setStType(this.fIX.stType);
            this.eJr.setData(this.fIX.cNb);
            this.eJr.setDisPraiseFrom(this.fIX.cQz);
            this.eKe.setVisibility(8);
            this.eJq.fK(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }
}
