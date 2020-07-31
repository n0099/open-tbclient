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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes15.dex */
public class u extends b<bw> implements com.baidu.tieba.a.e {
    private TextView aeq;
    private String afx;
    private OriginalThreadCardView.a ago;
    private final View.OnClickListener ahD;
    private boolean aib;
    private String dTB;
    private boolean elm;
    public ThreadSourceShareAndPraiseLayout fXN;
    public ThreadUserInfoLayout fXa;
    public ThreadCommentAndPraiseInfoLayout fXb;
    private NEGFeedBackView fXm;
    private View gWQ;
    private boolean gWU;
    private HeadPendantClickableView gWt;
    private View gYA;
    private TbImageView gYB;
    private bw gYC;
    private TbImageView gYD;
    private ViewGroup gYE;
    public OriginalThreadCardView gYh;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fXm = null;
        this.aib = true;
        this.gWU = true;
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.bRn() != null) {
                    u.this.bRn().a(view, u.this.gYC);
                }
            }
        };
        this.ago = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.gYC != null && u.this.gYC.dLK != null) {
                    if (u.this.bRn() != null) {
                        u.this.bRn().a(u.this.gYh, u.this.gYC);
                    }
                    String id = u.this.gYC.dLK.getId();
                    m.Ez(id);
                    u.this.cX(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.gYE = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.gYE.setOnClickListener(this);
        this.gWt = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.gWt.getHeadView() != null) {
            this.gWt.getHeadView().setIsRound(true);
            this.gWt.getHeadView().setDrawBorder(false);
            this.gWt.getHeadView().setDefaultResource(17170445);
            this.gWt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gWt.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.gWt.getHeadView().setPlaceHolder(1);
        }
        this.gWt.setHasPendantStyle();
        if (this.gWt.getPendantView() != null) {
            this.gWt.getPendantView().setIsRound(true);
            this.gWt.getPendantView().setDrawBorder(false);
        }
        this.fXa = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.fXm = new NEGFeedBackView(this.mPageContext);
        this.fXm.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.aeq = (TextView) view.findViewById(R.id.thread_abstract);
        this.gYh = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gYh.setSubClickListener(this.ago);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.fXb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fXb.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.fXb.setOnClickListener(this);
        this.fXb.setReplyTimeVisible(false);
        this.fXb.setShowPraiseNum(true);
        this.fXb.setNeedAddPraiseIcon(true);
        this.fXb.setNeedAddReplyIcon(true);
        this.fXb.setShareVisible(true);
        this.fXb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bRn() != null) {
                    u.this.bRn().a(view2, u.this.gYC);
                }
                if (u.this.gYC != null && u.this.gYC.dLK != null) {
                    m.Ez(u.this.gYC.dLK.getId());
                    u.this.cX(u.this.gYC.dLK.getId());
                }
            }
        });
        this.fXN = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.fXN.ekZ.setOnClickListener(this);
        this.fXN.ekZ.setNeedAddReplyIcon(true);
        this.fXN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bRn() != null) {
                    u.this.bRn().a(view2, u.this.gYC);
                }
                if (view2 != u.this.fXN.eko && u.this.gYC != null && u.this.gYC.dLK != null) {
                    m.Ez(u.this.gYC.dLK.getId());
                    u.this.cX(u.this.gYC.dLK.getId());
                }
            }
        });
        this.gWQ = view.findViewById(R.id.divider_line_above_praise);
        this.gYA = view.findViewById(R.id.card_divider_line);
        this.gYB = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.gYD = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.fXb.changeSelectStatus();
            }
        });
        this.fXb.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void id(boolean z) {
                ao.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void X(final bv bvVar) {
        if (this.gYD != null) {
            if (this.gYB == null || bvVar == null) {
                this.gYD.setVisibility(8);
            } else if (!StringUtils.isNull(bvVar.dUj) && this.gYB.getVisibility() != 0) {
                if (this.fXm != null && this.fXm.getVisibility() == 0 && (this.gYD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYD.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gYD.setLayoutParams(layoutParams);
                }
                this.gYD.setVisibility(0);
                this.gYD.setImageDrawable(null);
                this.gYD.startLoad(bvVar.dUj, 10, false);
                this.gYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bvVar.dUk, true)));
                        }
                        TiebaStatic.log(new ap(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gYD.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.gWQ, R.color.cp_bg_line_c);
            this.fXb.onChangeSkinType();
            this.fXa.onChangeSkinType();
            if (this.fXm != null) {
                this.fXm.onChangeSkinType();
            }
            this.gYh.onChangeSkinType();
            ao.setBackgroundColor(this.gYA, R.color.cp_bg_line_e);
            this.fXN.onChangeSkinType();
        }
        if (this.gYC != null && this.gYC.dLK != null) {
            ao.setBackgroundColor(this.mMaskView, (this.gYC.dLK.aXW() || this.gYC.dLK.aXX()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.gWt != null && this.gWt.getHeadView() != null && (this.gWt.getHeadView() instanceof TbImageView)) {
            this.gWt.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        if (bwVar == null || bwVar.dLK == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.gYC = bwVar;
        bv bvVar = bwVar.dLK;
        if (this.fXm != null) {
            SparseArray<String> feedBackReasonMap = bvVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.gWU) {
                aq aqVar = new aq();
                aqVar.setTid(bvVar.getTid());
                aqVar.setFid(bvVar.getFid());
                aqVar.setNid(bvVar.getNid());
                aqVar.setFeedBackReasonMap(feedBackReasonMap);
                aqVar.dPE = bvVar.dPE;
                this.fXm.setData(aqVar);
                this.fXm.setFirstRowSingleColumn(true);
                this.fXm.setVisibility(Z(bvVar) ? 8 : 0);
            } else {
                this.fXm.setVisibility(8);
            }
        }
        if (this.gYC.dVb == 1) {
            this.fXa.setFrom(3);
            b(bvVar);
            X(bvVar);
        }
        this.fXa.setIsFromConcern(this.elm);
        this.fXa.setData(bvVar);
        this.fXa.setUserAfterClickListener(this.ahD);
        if (this.fXa.getHeaderImg() != null) {
            if (this.fXa.getIsSimpleThread()) {
                this.fXa.getHeaderImg().setVisibility(8);
                this.gWt.setVisibility(8);
            } else if (bvVar.aWl() == null || bvVar.aWl().getPendantData() == null || StringUtils.isNull(bvVar.aWl().getPendantData().aUh())) {
                this.gWt.setVisibility(8);
                this.fXa.getHeaderImg().setVisibility(0);
                this.fXa.getHeaderImg().setData(bvVar);
            } else {
                this.fXa.getHeaderImg().setVisibility(4);
                this.gWt.setVisibility(0);
                this.gWt.setData(bvVar);
            }
        }
        Y(bvVar);
        this.gYh.b(bvVar.dUi);
        rp(pM(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cX(bvVar.getId());
        if (this.fXb.isInFrsAllThread() && (com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq())) {
            this.mMaskView.setVisibility(0);
            if (bvVar.aXW() || bvVar.aXX() || bvVar.aXY()) {
                ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void Y(bv bvVar) {
        if (bvVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dTB)) {
                bvVar.de(this.mUrl, this.dTB);
            }
            SpannableStringBuilder y = bvVar.y(false, true);
            if (y == null || StringUtils.isNull(y.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(y));
            this.mTitle.setText(y);
            m.a(this.mTitle, bvVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
    }

    private boolean Z(bv bvVar) {
        if (bvVar == null || bvVar.aWl() == null || StringUtils.isNull(bvVar.aWl().getUserId())) {
            return false;
        }
        return bvVar.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fXm != null) {
            this.fXm.setUniqueId(bdUniqueId);
        }
        if (this.fXa != null) {
            this.fXa.setPageUniqueId(bdUniqueId);
        }
    }

    public void mI(boolean z) {
        if (this.gYA != null) {
            this.gYA.setVisibility(z ? 0 : 8);
        }
    }

    public void mD(boolean z) {
        this.gWU = z;
    }

    private void bgS() {
        if (this.gYC != null && this.gYC.dLK != null) {
            bv bvVar = this.gYC.dLK;
            m.Ez(bvVar.getId());
            cX(bvVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bvVar, null, this.gYC.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.Ez(bvVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str) {
        m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(this.aeq, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.gYh.setReadState(m.EA(str));
    }

    public void b(bv bvVar) {
        MetaData aWl;
        if (bvVar != null && this.gYB != null && (aWl = bvVar.aWl()) != null) {
            final ThemeCardInUserData themeCard = aWl.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gYB.setVisibility(8);
                return;
            }
            this.gYB.setVisibility(0);
            this.gYB.setImageBitmap(null);
            this.gYB.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gYB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(view, this.gYC);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bgS();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fXa != null) {
            return this.fXa.ekI;
        }
        return null;
    }

    public View bRr() {
        if (this.fXa != null) {
            return this.fXa.ahr;
        }
        return null;
    }

    public void rp(int i) {
        if (this.gYC != null && this.gYC.dLK != null) {
            if (i == 1) {
                this.fXb.setVisibility(8);
                this.fXN.setFrom(this.gYC.dVa);
                this.fXN.setShareReportFrom(this.gYC.dVb);
                this.fXN.setStType(this.gYC.stType);
                this.fXN.setData(this.gYC.dLK);
                this.fXa.ie(false);
                return;
            }
            this.fXb.setFrom(this.gYC.dVa);
            this.fXb.setShareReportFrom(this.gYC.dVb);
            this.fXb.setStType(this.gYC.stType);
            this.fXb.setData(this.gYC.dLK);
            this.fXb.setDisPraiseFrom(this.gYC.dVc);
            this.fXN.setVisibility(8);
            this.fXa.ie(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public int pM(int i) {
        return com.baidu.tieba.a.d.brD().ar(this.afx, i);
    }
}
