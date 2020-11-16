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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes20.dex */
public class v extends b<by> implements com.baidu.tieba.a.e {
    private TextView agr;
    private String ahw;
    private OriginalThreadCardView.a aio;
    private final View.OnClickListener ajJ;
    private boolean akn;
    private String eDY;
    private boolean eWR;
    private NEGFeedBackView gSJ;
    public ThreadUserInfoLayout gSx;
    public ThreadCommentAndPraiseInfoLayout gSy;
    public ThreadSourceShareAndPraiseLayout gTk;
    private View hYE;
    private boolean hYI;
    private HeadPendantClickableView hYh;
    public OriginalThreadCardView hZV;
    private View iap;
    private TbImageView iaq;
    private by iar;
    private TbImageView ias;
    private ViewGroup iat;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gSJ = null;
        this.akn = true;
        this.hYI = true;
        this.ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.cnv() != null) {
                    v.this.cnv().a(view, v.this.iar);
                }
            }
        };
        this.aio = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.iar != null && v.this.iar.evQ != null) {
                    if (v.this.cnv() != null) {
                        v.this.cnv().a(v.this.hZV, v.this.iar);
                    }
                    String id = v.this.iar.evQ.getId();
                    n.IA(id);
                    v.this.dm(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.iat = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.iat.setOnClickListener(this);
        this.hYh = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.hYh.getHeadView() != null) {
            this.hYh.getHeadView().setIsRound(true);
            this.hYh.getHeadView().setDrawBorder(false);
            this.hYh.getHeadView().setDefaultResource(17170445);
            this.hYh.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hYh.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.hYh.getHeadView().setPlaceHolder(1);
        }
        this.hYh.setHasPendantStyle();
        if (this.hYh.getPendantView() != null) {
            this.hYh.getPendantView().setIsRound(true);
            this.hYh.getPendantView().setDrawBorder(false);
        }
        this.gSx = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.gSJ = new NEGFeedBackView(this.mPageContext);
        this.gSJ.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.agr = (TextView) view.findViewById(R.id.thread_abstract);
        this.hZV = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hZV.setSubClickListener(this.aio);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.gSy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSy.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.gSy.setOnClickListener(this);
        this.gSy.setReplyTimeVisible(false);
        this.gSy.setShowPraiseNum(true);
        this.gSy.setNeedAddPraiseIcon(true);
        this.gSy.setNeedAddReplyIcon(true);
        this.gSy.setShareVisible(true);
        this.gSy.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.cnv() != null) {
                    v.this.cnv().a(view2, v.this.iar);
                }
                if (v.this.iar != null && v.this.iar.evQ != null) {
                    n.IA(v.this.iar.evQ.getId());
                    v.this.dm(v.this.iar.evQ.getId());
                }
            }
        });
        this.gTk = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.gTk.eWE.setOnClickListener(this);
        this.gTk.eWE.setNeedAddReplyIcon(true);
        this.gTk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.cnv() != null) {
                    v.this.cnv().a(view2, v.this.iar);
                }
                if (view2 != v.this.gTk.eVT && v.this.iar != null && v.this.iar.evQ != null) {
                    n.IA(v.this.iar.evQ.getId());
                    v.this.dm(v.this.iar.evQ.getId());
                }
            }
        });
        this.hYE = view.findViewById(R.id.divider_line_above_praise);
        this.iap = view.findViewById(R.id.card_divider_line);
        this.iaq = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.ias = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.gSy.changeSelectStatus();
            }
        });
        this.gSy.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jt(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void aa(final bx bxVar) {
        if (this.ias != null) {
            if (this.iaq == null || bxVar == null) {
                this.ias.setVisibility(8);
            } else if (!StringUtils.isNull(bxVar.eEG) && this.iaq.getVisibility() != 0) {
                if (this.gSJ != null && this.gSJ.getVisibility() == 0 && (this.ias.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ias.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ias.setLayoutParams(layoutParams);
                }
                this.ias.setVisibility(0);
                this.ias.setImageDrawable(null);
                this.ias.startLoad(bxVar.eEG, 10, false);
                this.ias.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bxVar.eEH, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ias.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hYE, R.color.CAM_X0204);
            this.gSy.onChangeSkinType();
            this.gSx.onChangeSkinType();
            if (this.gSJ != null) {
                this.gSJ.onChangeSkinType();
            }
            this.hZV.onChangeSkinType();
            ap.setBackgroundColor(this.iap, R.color.CAM_X0205);
            this.gTk.onChangeSkinType();
        }
        if (this.iar != null && this.iar.evQ != null) {
            ap.setBackgroundColor(this.mMaskView, (this.iar.evQ.bnp() || this.iar.evQ.bnq()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.hYh != null && this.hYh.getHeadView() != null && (this.hYh.getHeadView() instanceof TbImageView)) {
            this.hYh.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(by byVar) {
        if (byVar == null || byVar.evQ == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.iar = byVar;
        bx bxVar = byVar.evQ;
        if (this.gSJ != null) {
            SparseArray<String> feedBackReasonMap = bxVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.hYI) {
                as asVar = new as();
                asVar.setTid(bxVar.getTid());
                asVar.setFid(bxVar.getFid());
                asVar.setNid(bxVar.getNid());
                asVar.setFeedBackReasonMap(feedBackReasonMap);
                asVar.ezX = bxVar.ezX;
                this.gSJ.setData(asVar);
                this.gSJ.setFirstRowSingleColumn(true);
                this.gSJ.setVisibility(ac(bxVar) ? 8 : 0);
            } else {
                this.gSJ.setVisibility(8);
            }
        }
        if (this.iar.eFG == 1) {
            this.gSx.setFrom(3);
            b(bxVar);
            aa(bxVar);
        }
        this.gSx.setIsFromConcern(this.eWR);
        this.gSx.setData(bxVar);
        this.gSx.setUserAfterClickListener(this.ajJ);
        if (this.gSx.getHeaderImg() != null) {
            if (this.gSx.getIsSimpleThread()) {
                this.gSx.getHeaderImg().setVisibility(8);
                this.hYh.setVisibility(8);
            } else if (bxVar.blC() == null || bxVar.blC().getPendantData() == null || StringUtils.isNull(bxVar.blC().getPendantData().bjy())) {
                this.hYh.setVisibility(8);
                this.gSx.getHeaderImg().setVisibility(0);
                this.gSx.getHeaderImg().setData(bxVar);
            } else {
                this.gSx.getHeaderImg().setVisibility(4);
                this.hYh.setVisibility(0);
                this.hYh.setData(bxVar);
            }
        }
        ab(bxVar);
        this.hZV.b(bxVar.eEF);
        vD(tH(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dm(bxVar.getId());
        if (this.gSy.isInFrsAllThread() && (com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI())) {
            this.mMaskView.setVisibility(0);
            if (bxVar.bnp() || bxVar.bnq() || bxVar.bnr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void ab(bx bxVar) {
        if (bxVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eDY)) {
                bxVar.dE(this.mUrl, this.eDY);
            }
            SpannableStringBuilder B = bxVar.B(false, true);
            if (B == null || StringUtils.isNull(B.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, bxVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    private boolean ac(bx bxVar) {
        if (bxVar == null || bxVar.blC() == null || StringUtils.isNull(bxVar.blC().getUserId())) {
            return false;
        }
        return bxVar.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gSJ != null) {
            this.gSJ.setUniqueId(bdUniqueId);
        }
        if (this.gSx != null) {
            this.gSx.setPageUniqueId(bdUniqueId);
        }
    }

    public void oC(boolean z) {
        if (this.iap != null) {
            this.iap.setVisibility(z ? 0 : 8);
        }
    }

    public void ox(boolean z) {
        this.hYI = z;
    }

    private void bwR() {
        if (this.iar != null && this.iar.evQ != null) {
            bx bxVar = this.iar.evQ;
            n.IA(bxVar.getId());
            dm(bxVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bxVar, null, this.iar.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.IA(bxVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(String str) {
        n.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        n.a(this.agr, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.hZV.setReadState(n.IB(str));
    }

    public void b(bx bxVar) {
        MetaData blC;
        if (bxVar != null && this.iaq != null && (blC = bxVar.blC()) != null) {
            final ThemeCardInUserData themeCard = blC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.iaq.setVisibility(8);
                return;
            }
            this.iaq.setVisibility(0);
            this.iaq.setImageBitmap(null);
            this.iaq.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.iaq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            cnv().a(view, this.iar);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bwR();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gSx != null) {
            return this.gSx.eWn;
        }
        return null;
    }

    public View cnz() {
        if (this.gSx != null) {
            return this.gSx.ajz;
        }
        return null;
    }

    public void vD(int i) {
        if (this.iar != null && this.iar.evQ != null) {
            if (i == 1) {
                this.gSy.setVisibility(8);
                this.gTk.setFrom(this.iar.eFF);
                this.gTk.setShareReportFrom(this.iar.eFG);
                this.gTk.setStType(this.iar.stType);
                this.gTk.setData(this.iar.evQ);
                this.gSx.ju(false);
                return;
            }
            this.gSy.setFrom(this.iar.eFF);
            this.gSy.setShareReportFrom(this.iar.eFG);
            this.gSy.setStType(this.iar.stType);
            this.gSy.setData(this.iar.evQ);
            this.gSy.setDisPraiseFrom(this.iar.eFH);
            this.gTk.setVisibility(8);
            this.gSx.ju(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    public int tH(int i) {
        return com.baidu.tieba.a.d.bIl().aw(this.ahw, i);
    }
}
