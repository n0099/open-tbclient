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
    public ThreadSourceShareAndPraiseLayout hnS;
    public ThreadUserInfoLayout hnf;
    public ThreadCommentAndPraiseInfoLayout hng;
    private NEGFeedBackView hnr;
    private View iwV;
    private boolean iwZ;
    private HeadPendantClickableView iwy;
    private View iyL;
    private TbImageView iyM;
    private cc iyN;
    private TbImageView iyO;
    private ViewGroup iyP;
    public OriginalThreadCardView iyp;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnr = null;
        this.akO = true;
        this.iwZ = true;
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.crV() != null) {
                    v.this.crV().a(view, v.this.iyN);
                }
            }
        };
        this.aiV = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.iyN != null && v.this.iyN.eJQ != null) {
                    if (v.this.crV() != null) {
                        v.this.crV().a(v.this.iyp, v.this.iyN);
                    }
                    String id = v.this.iyN.eJQ.getId();
                    m.IM(id);
                    v.this.dd(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.iyP = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.iyP.setOnClickListener(this);
        this.iwy = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.iwy.getHeadView() != null) {
            this.iwy.getHeadView().setIsRound(true);
            this.iwy.getHeadView().setDrawBorder(false);
            this.iwy.getHeadView().setDefaultResource(17170445);
            this.iwy.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.iwy.getHeadView().setPlaceHolder(1);
        }
        this.iwy.setHasPendantStyle();
        if (this.iwy.getPendantView() != null) {
            this.iwy.getPendantView().setIsRound(true);
            this.iwy.getPendantView().setDrawBorder(false);
        }
        this.hnf = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.hnr = new NEGFeedBackView(this.mPageContext);
        this.hnr.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.agY = (TextView) view.findViewById(R.id.thread_abstract);
        this.iyp = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.iyp.setSubClickListener(this.aiV);
        this.hng = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.hng.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hng.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hng.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.hng.setOnClickListener(this);
        this.hng.setReplyTimeVisible(false);
        this.hng.setShowPraiseNum(true);
        this.hng.setNeedAddPraiseIcon(true);
        this.hng.setNeedAddReplyIcon(true);
        this.hng.setShareVisible(true);
        this.hng.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.crV() != null) {
                    v.this.crV().a(view2, v.this.iyN);
                }
                if (v.this.iyN != null && v.this.iyN.eJQ != null) {
                    m.IM(v.this.iyN.eJQ.getId());
                    v.this.dd(v.this.iyN.eJQ.getId());
                }
            }
        });
        this.hnS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.hnS.fls.setOnClickListener(this);
        this.hnS.fls.setNeedAddReplyIcon(true);
        this.hnS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.crV() != null) {
                    v.this.crV().a(view2, v.this.iyN);
                }
                if (view2 != v.this.hnS.fkH && v.this.iyN != null && v.this.iyN.eJQ != null) {
                    m.IM(v.this.iyN.eJQ.getId());
                    v.this.dd(v.this.iyN.eJQ.getId());
                }
            }
        });
        this.iwV = view.findViewById(R.id.divider_line_above_praise);
        this.iyL = view.findViewById(R.id.card_divider_line);
        this.iyM = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.iyO = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.hng.changeSelectStatus();
            }
        });
        this.hng.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void ke(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void ab(final cb cbVar) {
        if (this.iyO != null) {
            if (this.iyM == null || cbVar == null) {
                this.iyO.setVisibility(8);
            } else if (!StringUtils.isNull(cbVar.eTd) && this.iyM.getVisibility() != 0) {
                if (this.hnr != null && this.hnr.getVisibility() == 0 && (this.iyO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iyO.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.iyO.setLayoutParams(layoutParams);
                }
                this.iyO.setVisibility(0);
                this.iyO.setImageDrawable(null);
                this.iyO.startLoad(cbVar.eTd, 10, false);
                this.iyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", cbVar.eTe, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.iyO.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.iwV, R.color.CAM_X0204);
            this.hng.onChangeSkinType();
            this.hnf.onChangeSkinType();
            if (this.hnr != null) {
                this.hnr.onChangeSkinType();
            }
            this.iyp.onChangeSkinType();
            ap.setBackgroundColor(this.iyL, R.color.CAM_X0205);
            this.hnS.onChangeSkinType();
        }
        if (this.iyN != null && this.iyN.eJQ != null) {
            ap.setBackgroundColor(this.mMaskView, (this.iyN.eJQ.bpD() || this.iyN.eJQ.bpE()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.iwy != null && this.iwy.getHeadView() != null && (this.iwy.getHeadView() instanceof TbImageView)) {
            this.iwy.getHeadView().setPlaceHolder(1);
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
        this.iyN = ccVar;
        cb cbVar = ccVar.eJQ;
        if (this.hnr != null) {
            SparseArray<String> feedBackReasonMap = cbVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.iwZ) {
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmo());
                avVar.setFeedBackReasonMap(feedBackReasonMap);
                avVar.eOo = cbVar.eOo;
                this.hnr.setData(avVar);
                this.hnr.setFirstRowSingleColumn(true);
                this.hnr.setVisibility(ad(cbVar) ? 8 : 0);
            } else {
                this.hnr.setVisibility(8);
            }
        }
        if (this.iyN.eUk == 1) {
            this.hnf.setFrom(3);
            b(cbVar);
            ab(cbVar);
        }
        this.hnf.setIsFromConcern(this.flF);
        this.hnf.setData(cbVar);
        this.hnf.setUserAfterClickListener(this.aki);
        if (this.hnf.getHeaderImg() != null) {
            if (this.hnf.getIsSimpleThread()) {
                this.hnf.getHeaderImg().setVisibility(8);
                this.iwy.setVisibility(8);
            } else if (cbVar.bnQ() == null || cbVar.bnQ().getPendantData() == null || StringUtils.isNull(cbVar.bnQ().getPendantData().getImgUrl())) {
                this.iwy.setVisibility(8);
                this.hnf.getHeaderImg().setVisibility(0);
                this.hnf.getHeaderImg().setData(cbVar);
            } else {
                this.hnf.getHeaderImg().setVisibility(4);
                this.iwy.setVisibility(0);
                this.iwy.setData(cbVar);
            }
        }
        ac(cbVar);
        this.iyp.b(cbVar.eTc);
        uZ(sW(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dd(cbVar.getId());
        if (this.hng.isInFrsAllThread() && (com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl())) {
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
        if (this.hnr != null) {
            this.hnr.setUniqueId(bdUniqueId);
        }
        if (this.hnf != null) {
            this.hnf.setPageUniqueId(bdUniqueId);
        }
    }

    public void pC(boolean z) {
        if (this.iyL != null) {
            this.iyL.setVisibility(z ? 0 : 8);
        }
    }

    public void px(boolean z) {
        this.iwZ = z;
    }

    private void bzk() {
        if (this.iyN != null && this.iyN.eJQ != null) {
            cb cbVar = this.iyN.eJQ;
            m.IM(cbVar.getId());
            dd(cbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(cbVar, null, this.iyN.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.IM(cbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(this.agY, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.iyp.setReadState(m.IN(str));
    }

    public void b(cb cbVar) {
        MetaData bnQ;
        if (cbVar != null && this.iyM != null && (bnQ = cbVar.bnQ()) != null) {
            final ThemeCardInUserData themeCard = bnQ.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.iyM.setVisibility(8);
                return;
            }
            this.iyM.setVisibility(0);
            this.iyM.setImageBitmap(null);
            this.iyM.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.iyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crV() != null) {
            crV().a(view, this.iyN);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bzk();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.hnf != null) {
            return this.hnf.flb;
        }
        return null;
    }

    public View crZ() {
        if (this.hnf != null) {
            return this.hnf.ajY;
        }
        return null;
    }

    public void uZ(int i) {
        if (this.iyN != null && this.iyN.eJQ != null) {
            if (i == 1) {
                this.hng.setVisibility(8);
                this.hnS.setFrom(this.iyN.eUj);
                this.hnS.setShareReportFrom(this.iyN.eUk);
                this.hnS.setStType(this.iyN.stType);
                this.hnS.setData(this.iyN.eJQ);
                this.hnf.kf(false);
                return;
            }
            this.hng.setFrom(this.iyN.eUj);
            this.hng.setShareReportFrom(this.iyN.eUk);
            this.hng.setStType(this.iyN.stType);
            this.hng.setData(this.iyN.eJQ);
            this.hng.setDisPraiseFrom(this.iyN.eUl);
            this.hnS.setVisibility(8);
            this.hnf.kf(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKP().aB(this.aif, i);
    }
}
