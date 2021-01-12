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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes.dex */
public class u extends b<ca> implements com.baidu.tieba.a.e {
    private TextView ahj;
    private String air;
    private OriginalThreadCardView.a ajh;
    private boolean akY;
    private final View.OnClickListener akt;
    private String eQj;
    private boolean fjo;
    public ThreadUserInfoLayout hiS;
    public ThreadCommentAndPraiseInfoLayout hiT;
    public ThreadSourceShareAndPraiseLayout hjF;
    private NEGFeedBackView hje;
    private HeadPendantClickableView iqU;
    private View irr;
    private boolean irv;
    public OriginalThreadCardView isH;
    private View itb;
    private TbImageView itc;
    private ca itd;
    private TbImageView ite;
    private ViewGroup itf;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hje = null;
        this.akY = true;
        this.irv = true;
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.cqL() != null) {
                    u.this.cqL().a(view, u.this.itd);
                }
            }
        };
        this.ajh = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.itd != null && u.this.itd.eHK != null) {
                    if (u.this.cqL() != null) {
                        u.this.cqL().a(u.this.isH, u.this.itd);
                    }
                    String id = u.this.itd.eHK.getId();
                    m.Ic(id);
                    u.this.dd(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.itf = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.itf.setOnClickListener(this);
        this.iqU = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.iqU.getHeadView() != null) {
            this.iqU.getHeadView().setIsRound(true);
            this.iqU.getHeadView().setDrawBorder(false);
            this.iqU.getHeadView().setDefaultResource(17170445);
            this.iqU.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.iqU.getHeadView().setPlaceHolder(1);
        }
        this.iqU.setHasPendantStyle();
        if (this.iqU.getPendantView() != null) {
            this.iqU.getPendantView().setIsRound(true);
            this.iqU.getPendantView().setDrawBorder(false);
        }
        this.hiS = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.hje = new NEGFeedBackView(this.mPageContext);
        this.hje.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.ahj = (TextView) view.findViewById(R.id.thread_abstract);
        this.isH = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.isH.setSubClickListener(this.ajh);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.hiT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hiT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hiT.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.hiT.setOnClickListener(this);
        this.hiT.setReplyTimeVisible(false);
        this.hiT.setShowPraiseNum(true);
        this.hiT.setNeedAddPraiseIcon(true);
        this.hiT.setNeedAddReplyIcon(true);
        this.hiT.setShareVisible(true);
        this.hiT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cqL() != null) {
                    u.this.cqL().a(view2, u.this.itd);
                }
                if (u.this.itd != null && u.this.itd.eHK != null) {
                    m.Ic(u.this.itd.eHK.getId());
                    u.this.dd(u.this.itd.eHK.getId());
                }
            }
        });
        this.hjF = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.hjF.fjb.setOnClickListener(this);
        this.hjF.fjb.setNeedAddReplyIcon(true);
        this.hjF.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cqL() != null) {
                    u.this.cqL().a(view2, u.this.itd);
                }
                if (view2 != u.this.hjF.fio && u.this.itd != null && u.this.itd.eHK != null) {
                    m.Ic(u.this.itd.eHK.getId());
                    u.this.dd(u.this.itd.eHK.getId());
                }
            }
        });
        this.irr = view.findViewById(R.id.divider_line_above_praise);
        this.itb = view.findViewById(R.id.card_divider_line);
        this.itc = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.ite = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.hiT.changeSelectStatus();
            }
        });
        this.hiT.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void kb(boolean z) {
                ao.setBackgroundColor(u.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void aa(final bz bzVar) {
        if (this.ite != null) {
            if (this.itc == null || bzVar == null) {
                this.ite.setVisibility(8);
            } else if (!StringUtils.isNull(bzVar.eQR) && this.itc.getVisibility() != 0) {
                if (this.hje != null && this.hje.getVisibility() == 0 && (this.ite.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ite.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ite.setLayoutParams(layoutParams);
                }
                this.ite.setVisibility(0);
                this.ite.setImageDrawable(null);
                this.ite.startLoad(bzVar.eQR, 10, false);
                this.ite.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bzVar.eQS, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ite.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.irr, R.color.CAM_X0204);
            this.hiT.onChangeSkinType();
            this.hiS.onChangeSkinType();
            if (this.hje != null) {
                this.hje.onChangeSkinType();
            }
            this.isH.onChangeSkinType();
            ao.setBackgroundColor(this.itb, R.color.CAM_X0205);
            this.hjF.onChangeSkinType();
        }
        if (this.itd != null && this.itd.eHK != null) {
            ao.setBackgroundColor(this.mMaskView, (this.itd.eHK.bpl() || this.itd.eHK.bpm()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.iqU != null && this.iqU.getHeadView() != null && (this.iqU.getHeadView() instanceof TbImageView)) {
            this.iqU.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(ca caVar) {
        if (caVar == null || caVar.eHK == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.itd = caVar;
        bz bzVar = caVar.eHK;
        if (this.hje != null) {
            SparseArray<String> feedBackReasonMap = bzVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.irv) {
                at atVar = new at();
                atVar.setTid(bzVar.getTid());
                atVar.setFid(bzVar.getFid());
                atVar.setNid(bzVar.blV());
                atVar.setFeedBackReasonMap(feedBackReasonMap);
                atVar.eMc = bzVar.eMc;
                this.hje.setData(atVar);
                this.hje.setFirstRowSingleColumn(true);
                this.hje.setVisibility(ac(bzVar) ? 8 : 0);
            } else {
                this.hje.setVisibility(8);
            }
        }
        if (this.itd.eRW == 1) {
            this.hiS.setFrom(3);
            b(bzVar);
            aa(bzVar);
        }
        this.hiS.setIsFromConcern(this.fjo);
        this.hiS.setData(bzVar);
        this.hiS.setUserAfterClickListener(this.akt);
        if (this.hiS.getHeaderImg() != null) {
            if (this.hiS.getIsSimpleThread()) {
                this.hiS.getHeaderImg().setVisibility(8);
                this.iqU.setVisibility(8);
            } else if (bzVar.bnx() == null || bzVar.bnx().getPendantData() == null || StringUtils.isNull(bzVar.bnx().getPendantData().getImgUrl())) {
                this.iqU.setVisibility(8);
                this.hiS.getHeaderImg().setVisibility(0);
                this.hiS.getHeaderImg().setData(bzVar);
            } else {
                this.hiS.getHeaderImg().setVisibility(4);
                this.iqU.setVisibility(0);
                this.iqU.setData(bzVar);
            }
        }
        ab(bzVar);
        this.isH.b(bzVar.eQQ);
        uP(sR(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dd(bzVar.getId());
        if (this.hiT.isInFrsAllThread() && (com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa())) {
            this.mMaskView.setVisibility(0);
            if (bzVar.bpl() || bzVar.bpm() || bzVar.bpn()) {
                ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void ab(bz bzVar) {
        if (bzVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eQj)) {
                bzVar.dJ(this.mUrl, this.eQj);
            }
            SpannableStringBuilder B = bzVar.B(false, true);
            if (B == null || StringUtils.isNull(B.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            m.a(this.mTitle, bzVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    private boolean ac(bz bzVar) {
        if (bzVar == null || bzVar.bnx() == null || StringUtils.isNull(bzVar.bnx().getUserId())) {
            return false;
        }
        return bzVar.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hje != null) {
            this.hje.setUniqueId(bdUniqueId);
        }
        if (this.hiS != null) {
            this.hiS.setPageUniqueId(bdUniqueId);
        }
    }

    public void ps(boolean z) {
        if (this.itb != null) {
            this.itb.setVisibility(z ? 0 : 8);
        }
    }

    public void pn(boolean z) {
        this.irv = z;
    }

    private void byS() {
        if (this.itd != null && this.itd.eHK != null) {
            bz bzVar = this.itd.eHK;
            m.Ic(bzVar.getId());
            dd(bzVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bzVar, null, this.itd.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.Ic(bzVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(this.ahj, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.isH.setReadState(m.Id(str));
    }

    public void b(bz bzVar) {
        MetaData bnx;
        if (bzVar != null && this.itc != null && (bnx = bzVar.bnx()) != null) {
            final ThemeCardInUserData themeCard = bnx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.itc.setVisibility(8);
                return;
            }
            this.itc.setVisibility(0);
            this.itc.setImageBitmap(null);
            this.itc.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.itc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            cqL().a(view, this.itd);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            byS();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.hiS != null) {
            return this.hiS.fiK;
        }
        return null;
    }

    public View cqP() {
        if (this.hiS != null) {
            return this.hiS.akj;
        }
        return null;
    }

    public void uP(int i) {
        if (this.itd != null && this.itd.eHK != null) {
            if (i == 1) {
                this.hiT.setVisibility(8);
                this.hjF.setFrom(this.itd.eRV);
                this.hjF.setShareReportFrom(this.itd.eRW);
                this.hjF.setStType(this.itd.stType);
                this.hjF.setData(this.itd.eHK);
                this.hiS.kc(false);
                return;
            }
            this.hiT.setFrom(this.itd.eRV);
            this.hiT.setShareReportFrom(this.itd.eRW);
            this.hiT.setStType(this.itd.stType);
            this.hiT.setData(this.itd.eHK);
            this.hiT.setDisPraiseFrom(this.itd.eRX);
            this.hjF.setVisibility(8);
            this.hiS.kc(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public int sR(int i) {
        return com.baidu.tieba.a.d.bKv().az(this.air, i);
    }
}
