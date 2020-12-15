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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes21.dex */
public class v extends b<bz> implements com.baidu.tieba.a.e {
    private TextView ahp;
    private String aiw;
    private OriginalThreadCardView.a ajn;
    private final View.OnClickListener akI;
    private boolean alo;
    private String eLa;
    private boolean feo;
    public ThreadUserInfoLayout hbM;
    public ThreadCommentAndPraiseInfoLayout hbN;
    private NEGFeedBackView hbY;
    public ThreadSourceShareAndPraiseLayout hcz;
    private View ijD;
    private boolean ijH;
    private HeadPendantClickableView ijg;
    public OriginalThreadCardView ikT;
    private View iln;
    private TbImageView ilo;
    private bz ilp;
    private TbImageView ilq;
    private ViewGroup ilr;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hbY = null;
        this.alo = true;
        this.ijH = true;
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.crJ() != null) {
                    v.this.crJ().a(view, v.this.ilp);
                }
            }
        };
        this.ajn = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.ilp != null && v.this.ilp.eCR != null) {
                    if (v.this.crJ() != null) {
                        v.this.crJ().a(v.this.ikT, v.this.ilp);
                    }
                    String id = v.this.ilp.eCR.getId();
                    n.Jq(id);
                    v.this.dp(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ilr = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.ilr.setOnClickListener(this);
        this.ijg = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.ijg.getHeadView() != null) {
            this.ijg.getHeadView().setIsRound(true);
            this.ijg.getHeadView().setDrawBorder(false);
            this.ijg.getHeadView().setDefaultResource(17170445);
            this.ijg.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ijg.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.ijg.getHeadView().setPlaceHolder(1);
        }
        this.ijg.setHasPendantStyle();
        if (this.ijg.getPendantView() != null) {
            this.ijg.getPendantView().setIsRound(true);
            this.ijg.getPendantView().setDrawBorder(false);
        }
        this.hbM = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.hbY = new NEGFeedBackView(this.mPageContext);
        this.hbY.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.ahp = (TextView) view.findViewById(R.id.thread_abstract);
        this.ikT = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.ikT.setSubClickListener(this.ajn);
        this.hbN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.hbN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbN.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hbN.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.hbN.setOnClickListener(this);
        this.hbN.setReplyTimeVisible(false);
        this.hbN.setShowPraiseNum(true);
        this.hbN.setNeedAddPraiseIcon(true);
        this.hbN.setNeedAddReplyIcon(true);
        this.hbN.setShareVisible(true);
        this.hbN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.crJ() != null) {
                    v.this.crJ().a(view2, v.this.ilp);
                }
                if (v.this.ilp != null && v.this.ilp.eCR != null) {
                    n.Jq(v.this.ilp.eCR.getId());
                    v.this.dp(v.this.ilp.eCR.getId());
                }
            }
        });
        this.hcz = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.hcz.feb.setOnClickListener(this);
        this.hcz.feb.setNeedAddReplyIcon(true);
        this.hcz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.crJ() != null) {
                    v.this.crJ().a(view2, v.this.ilp);
                }
                if (view2 != v.this.hcz.fdq && v.this.ilp != null && v.this.ilp.eCR != null) {
                    n.Jq(v.this.ilp.eCR.getId());
                    v.this.dp(v.this.ilp.eCR.getId());
                }
            }
        });
        this.ijD = view.findViewById(R.id.divider_line_above_praise);
        this.iln = view.findViewById(R.id.card_divider_line);
        this.ilo = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.ilq = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.hbN.changeSelectStatus();
            }
        });
        this.hbN.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jJ(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void aa(final by byVar) {
        if (this.ilq != null) {
            if (this.ilo == null || byVar == null) {
                this.ilq.setVisibility(8);
            } else if (!StringUtils.isNull(byVar.eLI) && this.ilo.getVisibility() != 0) {
                if (this.hbY != null && this.hbY.getVisibility() == 0 && (this.ilq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilq.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ilq.setLayoutParams(layoutParams);
                }
                this.ilq.setVisibility(0);
                this.ilq.setImageDrawable(null);
                this.ilq.startLoad(byVar.eLI, 10, false);
                this.ilq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", byVar.eLJ, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ilq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.ijD, R.color.CAM_X0204);
            this.hbN.onChangeSkinType();
            this.hbM.onChangeSkinType();
            if (this.hbY != null) {
                this.hbY.onChangeSkinType();
            }
            this.ikT.onChangeSkinType();
            ap.setBackgroundColor(this.iln, R.color.CAM_X0205);
            this.hcz.onChangeSkinType();
        }
        if (this.ilp != null && this.ilp.eCR != null) {
            ap.setBackgroundColor(this.mMaskView, (this.ilp.eCR.bqC() || this.ilp.eCR.bqD()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.ijg != null && this.ijg.getHeadView() != null && (this.ijg.getHeadView() instanceof TbImageView)) {
            this.ijg.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        if (bzVar == null || bzVar.eCR == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.ilp = bzVar;
        by byVar = bzVar.eCR;
        if (this.hbY != null) {
            SparseArray<String> feedBackReasonMap = byVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.ijH) {
                at atVar = new at();
                atVar.setTid(byVar.getTid());
                atVar.setFid(byVar.getFid());
                atVar.setNid(byVar.getNid());
                atVar.setFeedBackReasonMap(feedBackReasonMap);
                atVar.eGW = byVar.eGW;
                this.hbY.setData(atVar);
                this.hbY.setFirstRowSingleColumn(true);
                this.hbY.setVisibility(ac(byVar) ? 8 : 0);
            } else {
                this.hbY.setVisibility(8);
            }
        }
        if (this.ilp.eMJ == 1) {
            this.hbM.setFrom(3);
            b(byVar);
            aa(byVar);
        }
        this.hbM.setIsFromConcern(this.feo);
        this.hbM.setData(byVar);
        this.hbM.setUserAfterClickListener(this.akI);
        if (this.hbM.getHeaderImg() != null) {
            if (this.hbM.getIsSimpleThread()) {
                this.hbM.getHeaderImg().setVisibility(8);
                this.ijg.setVisibility(8);
            } else if (byVar.boP() == null || byVar.boP().getPendantData() == null || StringUtils.isNull(byVar.boP().getPendantData().bmL())) {
                this.ijg.setVisibility(8);
                this.hbM.getHeaderImg().setVisibility(0);
                this.hbM.getHeaderImg().setData(byVar);
            } else {
                this.hbM.getHeaderImg().setVisibility(4);
                this.ijg.setVisibility(0);
                this.ijg.setData(byVar);
            }
        }
        ab(byVar);
        this.ikT.b(byVar.eLH);
        wk(ul(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dp(byVar.getId());
        if (this.hbN.isInFrsAllThread() && (com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY())) {
            this.mMaskView.setVisibility(0);
            if (byVar.bqC() || byVar.bqD() || byVar.bqE()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void ab(by byVar) {
        if (byVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eLa)) {
                byVar.dL(this.mUrl, this.eLa);
            }
            SpannableStringBuilder B = byVar.B(false, true);
            if (B == null || StringUtils.isNull(B.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, byVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    private boolean ac(by byVar) {
        if (byVar == null || byVar.boP() == null || StringUtils.isNull(byVar.boP().getUserId())) {
            return false;
        }
        return byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hbY != null) {
            this.hbY.setUniqueId(bdUniqueId);
        }
        if (this.hbM != null) {
            this.hbM.setPageUniqueId(bdUniqueId);
        }
    }

    public void oY(boolean z) {
        if (this.iln != null) {
            this.iln.setVisibility(z ? 0 : 8);
        }
    }

    public void oT(boolean z) {
        this.ijH = z;
    }

    private void bAr() {
        if (this.ilp != null && this.ilp.eCR != null) {
            by byVar = this.ilp.eCR;
            n.Jq(byVar.getId());
            dp(byVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(byVar, null, this.ilp.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.Jq(byVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(String str) {
        n.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        n.a(this.ahp, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.ikT.setReadState(n.Jr(str));
    }

    public void b(by byVar) {
        MetaData boP;
        if (byVar != null && this.ilo != null && (boP = byVar.boP()) != null) {
            final ThemeCardInUserData themeCard = boP.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ilo.setVisibility(8);
                return;
            }
            this.ilo.setVisibility(0);
            this.ilo.setImageBitmap(null);
            this.ilo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ilo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            crJ().a(view, this.ilp);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bAr();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.hbM != null) {
            return this.hbM.fdK;
        }
        return null;
    }

    public View crN() {
        if (this.hbM != null) {
            return this.hbM.aky;
        }
        return null;
    }

    public void wk(int i) {
        if (this.ilp != null && this.ilp.eCR != null) {
            if (i == 1) {
                this.hbN.setVisibility(8);
                this.hcz.setFrom(this.ilp.eMI);
                this.hcz.setShareReportFrom(this.ilp.eMJ);
                this.hcz.setStType(this.ilp.stType);
                this.hcz.setData(this.ilp.eCR);
                this.hbM.jK(false);
                return;
            }
            this.hbN.setFrom(this.ilp.eMI);
            this.hbN.setShareReportFrom(this.ilp.eMJ);
            this.hbN.setStType(this.ilp.stType);
            this.hbN.setData(this.ilp.eCR);
            this.hbN.setDisPraiseFrom(this.ilp.eMK);
            this.hcz.setVisibility(8);
            this.hbM.jK(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLU().ax(this.aiw, i);
    }
}
