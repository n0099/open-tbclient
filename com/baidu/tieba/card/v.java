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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.cc;
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
/* loaded from: classes.dex */
public class v extends b<cc> implements com.baidu.tieba.a.e {
    private TextView agY;
    private OriginalThreadCardView.a aiV;
    private String aif;
    private boolean akO;
    private final View.OnClickListener aki;
    private String eSv;
    private boolean flF;
    private NEGFeedBackView hnF;
    public ThreadUserInfoLayout hnt;
    public ThreadCommentAndPraiseInfoLayout hnu;
    public ThreadSourceShareAndPraiseLayout hog;
    private HeadPendantClickableView iwM;
    private View ixj;
    private boolean ixn;
    public OriginalThreadCardView iyD;
    private View iyZ;
    private TbImageView iza;
    private cc izb;
    private TbImageView izc;
    private ViewGroup izd;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnF = null;
        this.akO = true;
        this.ixn = true;
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.csc() != null) {
                    v.this.csc().a(view, v.this.izb);
                }
            }
        };
        this.aiV = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.izb != null && v.this.izb.eJQ != null) {
                    if (v.this.csc() != null) {
                        v.this.csc().a(v.this.iyD, v.this.izb);
                    }
                    String id = v.this.izb.eJQ.getId();
                    m.IN(id);
                    v.this.dd(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.izd = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.izd.setOnClickListener(this);
        this.iwM = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.iwM.getHeadView() != null) {
            this.iwM.getHeadView().setIsRound(true);
            this.iwM.getHeadView().setDrawBorder(false);
            this.iwM.getHeadView().setDefaultResource(17170445);
            this.iwM.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.iwM.getHeadView().setPlaceHolder(1);
        }
        this.iwM.setHasPendantStyle();
        if (this.iwM.getPendantView() != null) {
            this.iwM.getPendantView().setIsRound(true);
            this.iwM.getPendantView().setDrawBorder(false);
        }
        this.hnt = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.hnF = new NEGFeedBackView(this.mPageContext);
        this.hnF.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.agY = (TextView) view.findViewById(R.id.thread_abstract);
        this.iyD = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.iyD.setSubClickListener(this.aiV);
        this.hnu = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.hnu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnu.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnu.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.hnu.setOnClickListener(this);
        this.hnu.setReplyTimeVisible(false);
        this.hnu.setShowPraiseNum(true);
        this.hnu.setNeedAddPraiseIcon(true);
        this.hnu.setNeedAddReplyIcon(true);
        this.hnu.setShareVisible(true);
        this.hnu.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.csc() != null) {
                    v.this.csc().a(view2, v.this.izb);
                }
                if (v.this.izb != null && v.this.izb.eJQ != null) {
                    m.IN(v.this.izb.eJQ.getId());
                    v.this.dd(v.this.izb.eJQ.getId());
                }
            }
        });
        this.hog = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.hog.fls.setOnClickListener(this);
        this.hog.fls.setNeedAddReplyIcon(true);
        this.hog.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.csc() != null) {
                    v.this.csc().a(view2, v.this.izb);
                }
                if (view2 != v.this.hog.fkH && v.this.izb != null && v.this.izb.eJQ != null) {
                    m.IN(v.this.izb.eJQ.getId());
                    v.this.dd(v.this.izb.eJQ.getId());
                }
            }
        });
        this.ixj = view.findViewById(R.id.divider_line_above_praise);
        this.iyZ = view.findViewById(R.id.card_divider_line);
        this.iza = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.izc = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.hnu.changeSelectStatus();
            }
        });
        this.hnu.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void ke(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void ab(final cb cbVar) {
        if (this.izc != null) {
            if (this.iza == null || cbVar == null) {
                this.izc.setVisibility(8);
            } else if (!StringUtils.isNull(cbVar.eTd) && this.iza.getVisibility() != 0) {
                if (this.hnF != null && this.hnF.getVisibility() == 0 && (this.izc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.izc.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.izc.setLayoutParams(layoutParams);
                }
                this.izc.setVisibility(0);
                this.izc.setImageDrawable(null);
                this.izc.startLoad(cbVar.eTd, 10, false);
                this.izc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", cbVar.eTe, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.izc.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.ixj, R.color.CAM_X0204);
            this.hnu.onChangeSkinType();
            this.hnt.onChangeSkinType();
            if (this.hnF != null) {
                this.hnF.onChangeSkinType();
            }
            this.iyD.onChangeSkinType();
            ap.setBackgroundColor(this.iyZ, R.color.CAM_X0205);
            this.hog.onChangeSkinType();
        }
        if (this.izb != null && this.izb.eJQ != null) {
            ap.setBackgroundColor(this.mMaskView, (this.izb.eJQ.bpD() || this.izb.eJQ.bpE()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.iwM != null && this.iwM.getHeadView() != null && (this.iwM.getHeadView() instanceof TbImageView)) {
            this.iwM.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cc ccVar) {
        if (ccVar == null || ccVar.eJQ == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.izb = ccVar;
        cb cbVar = ccVar.eJQ;
        if (this.hnF != null) {
            SparseArray<String> feedBackReasonMap = cbVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.ixn) {
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmo());
                avVar.setFeedBackReasonMap(feedBackReasonMap);
                avVar.eOo = cbVar.eOo;
                this.hnF.setData(avVar);
                this.hnF.setFirstRowSingleColumn(true);
                this.hnF.setVisibility(ad(cbVar) ? 8 : 0);
            } else {
                this.hnF.setVisibility(8);
            }
        }
        if (this.izb.eUk == 1) {
            this.hnt.setFrom(3);
            b(cbVar);
            ab(cbVar);
        }
        this.hnt.setIsFromConcern(this.flF);
        this.hnt.setData(cbVar);
        this.hnt.setUserAfterClickListener(this.aki);
        if (this.hnt.getHeaderImg() != null) {
            if (this.hnt.getIsSimpleThread()) {
                this.hnt.getHeaderImg().setVisibility(8);
                this.iwM.setVisibility(8);
            } else if (cbVar.bnQ() == null || cbVar.bnQ().getPendantData() == null || StringUtils.isNull(cbVar.bnQ().getPendantData().getImgUrl())) {
                this.iwM.setVisibility(8);
                this.hnt.getHeaderImg().setVisibility(0);
                this.hnt.getHeaderImg().setData(cbVar);
            } else {
                this.hnt.getHeaderImg().setVisibility(4);
                this.iwM.setVisibility(0);
                this.iwM.setData(cbVar);
            }
        }
        ac(cbVar);
        this.iyD.b(cbVar.eTc);
        uZ(sW(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dd(cbVar.getId());
        if (this.hnu.isInFrsAllThread() && (com.baidu.tieba.frs.b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs())) {
            this.mMaskView.setVisibility(0);
            if (cbVar.bpD() || cbVar.bpE() || cbVar.bpF()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void ac(cb cbVar) {
        if (cbVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eSv)) {
                cbVar.dD(this.mUrl, this.eSv);
            }
            SpannableStringBuilder A = cbVar.A(false, true);
            if (A == null || StringUtils.isNull(A.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(A));
            this.mTitle.setText(A);
            m.a(this.mTitle, cbVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    private boolean ad(cb cbVar) {
        if (cbVar == null || cbVar.bnQ() == null || StringUtils.isNull(cbVar.bnQ().getUserId())) {
            return false;
        }
        return cbVar.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hnF != null) {
            this.hnF.setUniqueId(bdUniqueId);
        }
        if (this.hnt != null) {
            this.hnt.setPageUniqueId(bdUniqueId);
        }
    }

    public void pC(boolean z) {
        if (this.iyZ != null) {
            this.iyZ.setVisibility(z ? 0 : 8);
        }
    }

    public void px(boolean z) {
        this.ixn = z;
    }

    private void bzk() {
        if (this.izb != null && this.izb.eJQ != null) {
            cb cbVar = this.izb.eJQ;
            m.IN(cbVar.getId());
            dd(cbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(cbVar, null, this.izb.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.IN(cbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(this.agY, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.iyD.setReadState(m.IO(str));
    }

    public void b(cb cbVar) {
        MetaData bnQ;
        if (cbVar != null && this.iza != null && (bnQ = cbVar.bnQ()) != null) {
            final ThemeCardInUserData themeCard = bnQ.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.iza.setVisibility(8);
                return;
            }
            this.iza.setVisibility(0);
            this.iza.setImageBitmap(null);
            this.iza.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.iza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            csc().a(view, this.izb);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bzk();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.hnt != null) {
            return this.hnt.flb;
        }
        return null;
    }

    public View csg() {
        if (this.hnt != null) {
            return this.hnt.ajY;
        }
        return null;
    }

    public void uZ(int i) {
        if (this.izb != null && this.izb.eJQ != null) {
            if (i == 1) {
                this.hnu.setVisibility(8);
                this.hog.setFrom(this.izb.eUj);
                this.hog.setShareReportFrom(this.izb.eUk);
                this.hog.setStType(this.izb.stType);
                this.hog.setData(this.izb.eJQ);
                this.hnt.kf(false);
                return;
            }
            this.hnu.setFrom(this.izb.eUj);
            this.hnu.setShareReportFrom(this.izb.eUk);
            this.hnu.setStType(this.izb.stType);
            this.hnu.setData(this.izb.eJQ);
            this.hnu.setDisPraiseFrom(this.izb.eUl);
            this.hog.setVisibility(8);
            this.hnt.kf(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKU().aB(this.aif, i);
    }
}
