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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
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
/* loaded from: classes8.dex */
public class u extends b<bl> implements com.baidu.tieba.a.e {
    private TextView adV;
    private String aeX;
    private OriginalThreadCardView.a afM;
    private final View.OnClickListener agI;
    private boolean aha;
    private String dGF;
    private boolean dXG;
    public ThreadUserInfoLayout fGn;
    public ThreadCommentAndPraiseInfoLayout fGo;
    private NEGFeedBackView fGz;
    public ThreadSourceShareAndPraiseLayout fHa;
    private HeadPendantClickableView gDM;
    private View gEk;
    private boolean gEo;
    private View gFR;
    private TbImageView gFS;
    private bl gFT;
    private TbImageView gFU;
    private ViewGroup gFV;
    public OriginalThreadCardView gFy;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fGz = null;
        this.aha = true;
        this.gEo = true;
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.bKS() != null) {
                    u.this.bKS().a(view, u.this.gFT);
                }
            }
        };
        this.afM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.gFT != null && u.this.gFT.dEA != null) {
                    if (u.this.bKS() != null) {
                        u.this.bKS().a(u.this.gFy, u.this.gFT);
                    }
                    String id = u.this.gFT.dEA.getId();
                    m.Dn(id);
                    u.this.cX(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.gFV = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.gFV.setOnClickListener(this);
        this.gDM = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.gDM.getHeadView() != null) {
            this.gDM.getHeadView().setIsRound(true);
            this.gDM.getHeadView().setDrawBorder(false);
            this.gDM.getHeadView().setDefaultResource(17170445);
            this.gDM.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDM.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.gDM.getHeadView().setPlaceHolder(1);
        }
        this.gDM.setHasPendantStyle();
        if (this.gDM.getPendantView() != null) {
            this.gDM.getPendantView().setIsRound(true);
            this.gDM.getPendantView().setDrawBorder(false);
        }
        this.fGn = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.fGz = new NEGFeedBackView(this.mPageContext);
        this.fGz.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.adV = (TextView) view.findViewById(R.id.thread_abstract);
        this.gFy = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gFy.setSubClickListener(this.afM);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.fGo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGo.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGo.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.fGo.setOnClickListener(this);
        this.fGo.setReplyTimeVisible(false);
        this.fGo.setShowPraiseNum(true);
        this.fGo.setNeedAddPraiseIcon(true);
        this.fGo.setNeedAddReplyIcon(true);
        this.fGo.setShareVisible(true);
        this.fGo.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bKS() != null) {
                    u.this.bKS().a(view2, u.this.gFT);
                }
                if (u.this.gFT != null && u.this.gFT.dEA != null) {
                    m.Dn(u.this.gFT.dEA.getId());
                    u.this.cX(u.this.gFT.dEA.getId());
                }
            }
        });
        this.fHa = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.fHa.dXt.setOnClickListener(this);
        this.fHa.dXt.setNeedAddReplyIcon(true);
        this.fHa.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bKS() != null) {
                    u.this.bKS().a(view2, u.this.gFT);
                }
                if (view2 != u.this.fHa.dWI && u.this.gFT != null && u.this.gFT.dEA != null) {
                    m.Dn(u.this.gFT.dEA.getId());
                    u.this.cX(u.this.gFT.dEA.getId());
                }
            }
        });
        this.gEk = view.findViewById(R.id.divider_line_above_praise);
        this.gFR = view.findViewById(R.id.card_divider_line);
        this.gFS = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.gFU = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.fGo.changeSelectStatus();
            }
        });
        this.fGo.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hp(boolean z) {
                am.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Z(final bk bkVar) {
        if (this.gFU != null) {
            if (this.gFS == null || bkVar == null) {
                this.gFU.setVisibility(8);
            } else if (!StringUtils.isNull(bkVar.dHn) && this.gFS.getVisibility() != 0) {
                if (this.fGz != null && this.fGz.getVisibility() == 0 && (this.gFU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFU.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gFU.setLayoutParams(layoutParams);
                }
                this.gFU.setVisibility(0);
                this.gFU.setImageDrawable(null);
                this.gFU.startLoad(bkVar.dHn, 10, false);
                this.gFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bkVar.dHo, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gFU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.gEk, R.color.cp_bg_line_c);
            this.fGo.onChangeSkinType();
            this.fGn.onChangeSkinType();
            if (this.fGz != null) {
                this.fGz.onChangeSkinType();
            }
            this.gFy.onChangeSkinType();
            am.setBackgroundColor(this.gFR, R.color.cp_bg_line_e);
            this.fHa.onChangeSkinType();
        }
        if (this.gFT != null && this.gFT.dEA != null) {
            am.setBackgroundColor(this.mMaskView, this.gFT.dEA.aSk() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.gDM != null && this.gDM.getHeadView() != null && (this.gDM.getHeadView() instanceof TbImageView)) {
            this.gDM.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bl blVar) {
        if (blVar == null || blVar.dEA == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.gFT = blVar;
        bk bkVar = blVar.dEA;
        if (this.fGz != null) {
            SparseArray<String> feedBackReasonMap = bkVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.gEo) {
                ak akVar = new ak();
                akVar.setTid(bkVar.getTid());
                akVar.setFid(bkVar.getFid());
                akVar.setNid(bkVar.getNid());
                akVar.setFeedBackReasonMap(feedBackReasonMap);
                this.fGz.setData(akVar);
                this.fGz.setFirstRowSingleColumn(true);
                this.fGz.setVisibility(ab(bkVar) ? 8 : 0);
            } else {
                this.fGz.setVisibility(8);
            }
        }
        if (this.gFT.dHZ == 1) {
            this.fGn.setFrom(3);
            b(bkVar);
            Z(bkVar);
        }
        this.fGn.setIsFromConcern(this.dXG);
        this.fGn.setData(bkVar);
        this.fGn.setUserAfterClickListener(this.agI);
        if (this.fGn.getHeaderImg() != null) {
            if (this.fGn.getIsSimpleThread()) {
                this.fGn.getHeaderImg().setVisibility(8);
                this.gDM.setVisibility(8);
            } else if (bkVar.aQx() == null || bkVar.aQx().getPendantData() == null || StringUtils.isNull(bkVar.aQx().getPendantData().aOP())) {
                this.gDM.setVisibility(8);
                this.fGn.getHeaderImg().setVisibility(0);
                this.fGn.getHeaderImg().setData(bkVar);
            } else {
                this.fGn.getHeaderImg().setVisibility(4);
                this.gDM.setVisibility(0);
                this.gDM.setData(bkVar);
            }
        }
        aa(bkVar);
        this.gFy.b(bkVar.dHm);
        qy(oY(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cX(bkVar.getId());
        if (this.fGo.isInFrsAllThread() && com.baidu.tieba.frs.a.bTX().bTY()) {
            this.mMaskView.setVisibility(0);
            if (bkVar.aSk() || bkVar.aSl()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void aa(bk bkVar) {
        if (bkVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dGF)) {
                bkVar.cY(this.mUrl, this.dGF);
            }
            SpannableStringBuilder x = bkVar.x(false, true);
            if (x == null || StringUtils.isNull(x.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(x));
            this.mTitle.setText(x);
            m.a(this.mTitle, bkVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean ab(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null || StringUtils.isNull(bkVar.aQx().getUserId())) {
            return false;
        }
        return bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fGz != null) {
            this.fGz.setUniqueId(bdUniqueId);
        }
        if (this.fGn != null) {
            this.fGn.setPageUniqueId(bdUniqueId);
        }
    }

    public void lU(boolean z) {
        if (this.gFR != null) {
            this.gFR.setVisibility(z ? 0 : 8);
        }
    }

    public void lP(boolean z) {
        this.gEo = z;
    }

    private void bbi() {
        if (this.gFT != null && this.gFT.dEA != null) {
            bk bkVar = this.gFT.dEA;
            m.Dn(bkVar.getId());
            cX(bkVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bkVar, null, this.gFT.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.Dn(bkVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str) {
        m.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        m.a(this.adV, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.gFy.setReadState(m.Do(str));
    }

    public void b(bk bkVar) {
        MetaData aQx;
        if (bkVar != null && this.gFS != null && (aQx = bkVar.aQx()) != null) {
            final ThemeCardInUserData themeCard = aQx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gFS.setVisibility(8);
                return;
            }
            this.gFS.setVisibility(0);
            this.gFS.setImageBitmap(null);
            this.gFS.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(view, this.gFT);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bbi();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fGn != null) {
            return this.fGn.dXc;
        }
        return null;
    }

    public View bKW() {
        if (this.fGn != null) {
            return this.fGn.agw;
        }
        return null;
    }

    public void qy(int i) {
        if (this.gFT != null && this.gFT.dEA != null) {
            if (i == 1) {
                this.fGo.setVisibility(8);
                this.fHa.setFrom(this.gFT.dHY);
                this.fHa.setShareReportFrom(this.gFT.dHZ);
                this.fHa.setStType(this.gFT.stType);
                this.fHa.setData(this.gFT.dEA);
                this.fGn.hq(false);
                return;
            }
            this.fGo.setFrom(this.gFT.dHY);
            this.fGo.setShareReportFrom(this.gFT.dHZ);
            this.fGo.setStType(this.gFT.stType);
            this.fGo.setData(this.gFT.dEA);
            this.fGo.setDisPraiseFrom(this.gFT.dIa);
            this.fHa.setVisibility(8);
            this.fGn.hq(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int oY(int i) {
        return com.baidu.tieba.a.d.blZ().as(this.aeX, i);
    }
}
