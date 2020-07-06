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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
public class u extends b<bv> implements com.baidu.tieba.a.e {
    private TextView aeA;
    private String afG;
    private OriginalThreadCardView.a agx;
    private final View.OnClickListener ahM;
    private boolean aik;
    private String dNq;
    private boolean efc;
    public ThreadUserInfoLayout fRH;
    public ThreadCommentAndPraiseInfoLayout fRI;
    private NEGFeedBackView fRT;
    public ThreadSourceShareAndPraiseLayout fSu;
    private HeadPendantClickableView gQN;
    private View gRl;
    private boolean gRp;
    public OriginalThreadCardView gSC;
    private View gSV;
    private TbImageView gSW;
    private bv gSX;
    private TbImageView gSY;
    private ViewGroup gSZ;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fRT = null;
        this.aik = true;
        this.gRp = true;
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.bOd() != null) {
                    u.this.bOd().a(view, u.this.gSX);
                }
            }
        };
        this.agx = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.gSX != null && u.this.gSX.dLi != null) {
                    if (u.this.bOd() != null) {
                        u.this.bOd().a(u.this.gSC, u.this.gSX);
                    }
                    String id = u.this.gSX.dLi.getId();
                    m.DO(id);
                    u.this.cY(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.gSZ = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.gSZ.setOnClickListener(this);
        this.gQN = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.gQN.getHeadView() != null) {
            this.gQN.getHeadView().setIsRound(true);
            this.gQN.getHeadView().setDrawBorder(false);
            this.gQN.getHeadView().setDefaultResource(17170445);
            this.gQN.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gQN.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.gQN.getHeadView().setPlaceHolder(1);
        }
        this.gQN.setHasPendantStyle();
        if (this.gQN.getPendantView() != null) {
            this.gQN.getPendantView().setIsRound(true);
            this.gQN.getPendantView().setDrawBorder(false);
        }
        this.fRH = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.fRT = new NEGFeedBackView(this.mPageContext);
        this.fRT.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.aeA = (TextView) view.findViewById(R.id.thread_abstract);
        this.gSC = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gSC.setSubClickListener(this.agx);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.fRI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fRI.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.fRI.setOnClickListener(this);
        this.fRI.setReplyTimeVisible(false);
        this.fRI.setShowPraiseNum(true);
        this.fRI.setNeedAddPraiseIcon(true);
        this.fRI.setNeedAddReplyIcon(true);
        this.fRI.setShareVisible(true);
        this.fRI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bOd() != null) {
                    u.this.bOd().a(view2, u.this.gSX);
                }
                if (u.this.gSX != null && u.this.gSX.dLi != null) {
                    m.DO(u.this.gSX.dLi.getId());
                    u.this.cY(u.this.gSX.dLi.getId());
                }
            }
        });
        this.fSu = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.fSu.eeP.setOnClickListener(this);
        this.fSu.eeP.setNeedAddReplyIcon(true);
        this.fSu.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bOd() != null) {
                    u.this.bOd().a(view2, u.this.gSX);
                }
                if (view2 != u.this.fSu.eee && u.this.gSX != null && u.this.gSX.dLi != null) {
                    m.DO(u.this.gSX.dLi.getId());
                    u.this.cY(u.this.gSX.dLi.getId());
                }
            }
        });
        this.gRl = view.findViewById(R.id.divider_line_above_praise);
        this.gSV = view.findViewById(R.id.card_divider_line);
        this.gSW = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.gSY = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.fRI.changeSelectStatus();
            }
        });
        this.fRI.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hy(boolean z) {
                an.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void aa(final bu buVar) {
        if (this.gSY != null) {
            if (this.gSW == null || buVar == null) {
                this.gSY.setVisibility(8);
            } else if (!StringUtils.isNull(buVar.dNY) && this.gSW.getVisibility() != 0) {
                if (this.fRT != null && this.fRT.getVisibility() == 0 && (this.gSY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSY.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gSY.setLayoutParams(layoutParams);
                }
                this.gSY.setVisibility(0);
                this.gSY.setImageDrawable(null);
                this.gSY.startLoad(buVar.dNY, 10, false);
                this.gSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", buVar.dNZ, true)));
                        }
                        TiebaStatic.log(new ao(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gSY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            an.setBackgroundColor(this.gRl, R.color.cp_bg_line_c);
            this.fRI.onChangeSkinType();
            this.fRH.onChangeSkinType();
            if (this.fRT != null) {
                this.fRT.onChangeSkinType();
            }
            this.gSC.onChangeSkinType();
            an.setBackgroundColor(this.gSV, R.color.cp_bg_line_e);
            this.fSu.onChangeSkinType();
        }
        if (this.gSX != null && this.gSX.dLi != null) {
            an.setBackgroundColor(this.mMaskView, (this.gSX.dLi.aUa() || this.gSX.dLi.aUb()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.gQN != null && this.gQN.getHeadView() != null && (this.gQN.getHeadView() instanceof TbImageView)) {
            this.gQN.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bv bvVar) {
        if (bvVar == null || bvVar.dLi == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.gSX = bvVar;
        bu buVar = bvVar.dLi;
        if (this.fRT != null) {
            SparseArray<String> feedBackReasonMap = buVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.gRp) {
                ap apVar = new ap();
                apVar.setTid(buVar.getTid());
                apVar.setFid(buVar.getFid());
                apVar.setNid(buVar.getNid());
                apVar.setFeedBackReasonMap(feedBackReasonMap);
                this.fRT.setData(apVar);
                this.fRT.setFirstRowSingleColumn(true);
                this.fRT.setVisibility(ac(buVar) ? 8 : 0);
            } else {
                this.fRT.setVisibility(8);
            }
        }
        if (this.gSX.dOP == 1) {
            this.fRH.setFrom(3);
            b(buVar);
            aa(buVar);
        }
        this.fRH.setIsFromConcern(this.efc);
        this.fRH.setData(buVar);
        this.fRH.setUserAfterClickListener(this.ahM);
        if (this.fRH.getHeaderImg() != null) {
            if (this.fRH.getIsSimpleThread()) {
                this.fRH.getHeaderImg().setVisibility(8);
                this.gQN.setVisibility(8);
            } else if (buVar.aSp() == null || buVar.aSp().getPendantData() == null || StringUtils.isNull(buVar.aSp().getPendantData().aQl())) {
                this.gQN.setVisibility(8);
                this.fRH.getHeaderImg().setVisibility(0);
                this.fRH.getHeaderImg().setData(buVar);
            } else {
                this.fRH.getHeaderImg().setVisibility(4);
                this.gQN.setVisibility(0);
                this.gQN.setData(buVar);
            }
        }
        ab(buVar);
        this.gSC.b(buVar.dNX);
        qZ(pz(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cY(buVar.getId());
        if (this.fRI.isInFrsAllThread() && (com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX())) {
            this.mMaskView.setVisibility(0);
            if (buVar.aUa() || buVar.aUb() || buVar.aUc()) {
                an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void ab(bu buVar) {
        if (buVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dNq)) {
                buVar.db(this.mUrl, this.dNq);
            }
            SpannableStringBuilder x = buVar.x(false, true);
            if (x == null || StringUtils.isNull(x.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(x));
            this.mTitle.setText(x);
            m.a(this.mTitle, buVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean ac(bu buVar) {
        if (buVar == null || buVar.aSp() == null || StringUtils.isNull(buVar.aSp().getUserId())) {
            return false;
        }
        return buVar.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fRT != null) {
            this.fRT.setUniqueId(bdUniqueId);
        }
        if (this.fRH != null) {
            this.fRH.setPageUniqueId(bdUniqueId);
        }
    }

    public void md(boolean z) {
        if (this.gSV != null) {
            this.gSV.setVisibility(z ? 0 : 8);
        }
    }

    public void lY(boolean z) {
        this.gRp = z;
    }

    private void bdl() {
        if (this.gSX != null && this.gSX.dLi != null) {
            bu buVar = this.gSX.dLi;
            m.DO(buVar.getId());
            cY(buVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(buVar, null, this.gSX.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.DO(buVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(String str) {
        m.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        m.a(this.aeA, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.gSC.setReadState(m.DP(str));
    }

    public void b(bu buVar) {
        MetaData aSp;
        if (buVar != null && this.gSW != null && (aSp = buVar.aSp()) != null) {
            final ThemeCardInUserData themeCard = aSp.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gSW.setVisibility(8);
                return;
            }
            this.gSW.setVisibility(0);
            this.gSW.setImageBitmap(null);
            this.gSW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOd() != null) {
            bOd().a(view, this.gSX);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bdl();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fRH != null) {
            return this.fRH.eey;
        }
        return null;
    }

    public View bOh() {
        if (this.fRH != null) {
            return this.fRH.ahA;
        }
        return null;
    }

    public void qZ(int i) {
        if (this.gSX != null && this.gSX.dLi != null) {
            if (i == 1) {
                this.fRI.setVisibility(8);
                this.fSu.setFrom(this.gSX.dOO);
                this.fSu.setShareReportFrom(this.gSX.dOP);
                this.fSu.setStType(this.gSX.stType);
                this.fSu.setData(this.gSX.dLi);
                this.fRH.hz(false);
                return;
            }
            this.fRI.setFrom(this.gSX.dOO);
            this.fRI.setShareReportFrom(this.gSX.dOP);
            this.fRI.setStType(this.gSX.stType);
            this.fRI.setData(this.gSX.dLi);
            this.fRI.setDisPraiseFrom(this.gSX.dOQ);
            this.fSu.setVisibility(8);
            this.fRH.hz(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public int pz(int i) {
        return com.baidu.tieba.a.d.boB().as(this.afG, i);
    }
}
