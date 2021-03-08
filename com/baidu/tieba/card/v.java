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
    private TextView air;
    private String ajx;
    private OriginalThreadCardView.a akn;
    private final View.OnClickListener alB;
    private boolean amh;
    private String eTW;
    private boolean fnf;
    public ThreadSourceShareAndPraiseLayout hpQ;
    public ThreadUserInfoLayout hpd;
    public ThreadCommentAndPraiseInfoLayout hpe;
    private NEGFeedBackView hpp;
    private View iAI;
    private TbImageView iAJ;
    private cc iAK;
    private TbImageView iAL;
    private ViewGroup iAM;
    public OriginalThreadCardView iAm;
    private View iyS;
    private boolean iyW;
    private HeadPendantClickableView iyv;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hpp = null;
        this.amh = true;
        this.iyW = true;
        this.alB = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.csi() != null) {
                    v.this.csi().a(view, v.this.iAK);
                }
            }
        };
        this.akn = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.iAK != null && v.this.iAK.eLr != null) {
                    if (v.this.csi() != null) {
                        v.this.csi().a(v.this.iAm, v.this.iAK);
                    }
                    String id = v.this.iAK.eLr.getId();
                    m.IW(id);
                    v.this.dh(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.iAM = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.iAM.setOnClickListener(this);
        this.iyv = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.iyv.getHeadView() != null) {
            this.iyv.getHeadView().setIsRound(true);
            this.iyv.getHeadView().setDrawBorder(false);
            this.iyv.getHeadView().setDefaultResource(17170445);
            this.iyv.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.iyv.getHeadView().setPlaceHolder(1);
        }
        this.iyv.setHasPendantStyle();
        if (this.iyv.getPendantView() != null) {
            this.iyv.getPendantView().setIsRound(true);
            this.iyv.getPendantView().setDrawBorder(false);
        }
        this.hpd = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.hpp = new NEGFeedBackView(this.mPageContext);
        this.hpp.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.air = (TextView) view.findViewById(R.id.thread_abstract);
        this.iAm = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.iAm.setSubClickListener(this.akn);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.hpe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hpe.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.hpe.setOnClickListener(this);
        this.hpe.setReplyTimeVisible(false);
        this.hpe.setShowPraiseNum(true);
        this.hpe.setNeedAddPraiseIcon(true);
        this.hpe.setNeedAddReplyIcon(true);
        this.hpe.setShareVisible(true);
        this.hpe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.csi() != null) {
                    v.this.csi().a(view2, v.this.iAK);
                }
                if (v.this.iAK != null && v.this.iAK.eLr != null) {
                    m.IW(v.this.iAK.eLr.getId());
                    v.this.dh(v.this.iAK.eLr.getId());
                }
            }
        });
        this.hpQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.hpQ.fmS.setOnClickListener(this);
        this.hpQ.fmS.setNeedAddReplyIcon(true);
        this.hpQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.csi() != null) {
                    v.this.csi().a(view2, v.this.iAK);
                }
                if (view2 != v.this.hpQ.fmg && v.this.iAK != null && v.this.iAK.eLr != null) {
                    m.IW(v.this.iAK.eLr.getId());
                    v.this.dh(v.this.iAK.eLr.getId());
                }
            }
        });
        this.iyS = view.findViewById(R.id.divider_line_above_praise);
        this.iAI = view.findViewById(R.id.card_divider_line);
        this.iAJ = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.iAL = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.hpe.changeSelectStatus();
            }
        });
        this.hpe.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void ke(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void ab(final cb cbVar) {
        if (this.iAL != null) {
            if (this.iAJ == null || cbVar == null) {
                this.iAL.setVisibility(8);
            } else if (!StringUtils.isNull(cbVar.eUE) && this.iAJ.getVisibility() != 0) {
                if (this.hpp != null && this.hpp.getVisibility() == 0 && (this.iAL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iAL.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.iAL.setLayoutParams(layoutParams);
                }
                this.iAL.setVisibility(0);
                this.iAL.setImageDrawable(null);
                this.iAL.startLoad(cbVar.eUE, 10, false);
                this.iAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", cbVar.eUF, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.iAL.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.iyS, R.color.CAM_X0204);
            this.hpe.onChangeSkinType();
            this.hpd.onChangeSkinType();
            if (this.hpp != null) {
                this.hpp.onChangeSkinType();
            }
            this.iAm.onChangeSkinType();
            ap.setBackgroundColor(this.iAI, R.color.CAM_X0205);
            this.hpQ.onChangeSkinType();
        }
        if (this.iAK != null && this.iAK.eLr != null) {
            ap.setBackgroundColor(this.mMaskView, (this.iAK.eLr.bpF() || this.iAK.eLr.bpG()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.iyv != null && this.iyv.getHeadView() != null && (this.iyv.getHeadView() instanceof TbImageView)) {
            this.iyv.getHeadView().setPlaceHolder(1);
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
        if (ccVar == null || ccVar.eLr == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.iAK = ccVar;
        cb cbVar = ccVar.eLr;
        if (this.hpp != null) {
            SparseArray<String> feedBackReasonMap = cbVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.iyW) {
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmq());
                avVar.setFeedBackReasonMap(feedBackReasonMap);
                avVar.ePP = cbVar.ePP;
                this.hpp.setData(avVar);
                this.hpp.setFirstRowSingleColumn(true);
                this.hpp.setVisibility(ad(cbVar) ? 8 : 0);
            } else {
                this.hpp.setVisibility(8);
            }
        }
        if (this.iAK.eVJ == 1) {
            this.hpd.setFrom(3);
            b(cbVar);
            ab(cbVar);
        }
        this.hpd.setIsFromConcern(this.fnf);
        this.hpd.setData(cbVar);
        this.hpd.setUserAfterClickListener(this.alB);
        if (this.hpd.getHeaderImg() != null) {
            if (this.hpd.getIsSimpleThread()) {
                this.hpd.getHeaderImg().setVisibility(8);
                this.iyv.setVisibility(8);
            } else if (cbVar.bnS() == null || cbVar.bnS().getPendantData() == null || StringUtils.isNull(cbVar.bnS().getPendantData().getImgUrl())) {
                this.iyv.setVisibility(8);
                this.hpd.getHeaderImg().setVisibility(0);
                this.hpd.getHeaderImg().setData(cbVar);
            } else {
                this.hpd.getHeaderImg().setVisibility(4);
                this.iyv.setVisibility(0);
                this.iyv.setData(cbVar);
            }
        }
        ac(cbVar);
        this.iAm.b(cbVar.eUD);
        vb(sY(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dh(cbVar.getId());
        if (this.hpe.isInFrsAllThread() && (com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy())) {
            this.mMaskView.setVisibility(0);
            if (cbVar.bpF() || cbVar.bpG() || cbVar.bpH()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eTW)) {
                cbVar.dD(this.mUrl, this.eTW);
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
        if (cbVar == null || cbVar.bnS() == null || StringUtils.isNull(cbVar.bnS().getUserId())) {
            return false;
        }
        return cbVar.bnS().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hpp != null) {
            this.hpp.setUniqueId(bdUniqueId);
        }
        if (this.hpd != null) {
            this.hpd.setPageUniqueId(bdUniqueId);
        }
    }

    public void pC(boolean z) {
        if (this.iAI != null) {
            this.iAI.setVisibility(z ? 0 : 8);
        }
    }

    public void px(boolean z) {
        this.iyW = z;
    }

    private void bzn() {
        if (this.iAK != null && this.iAK.eLr != null) {
            cb cbVar = this.iAK.eLr;
            m.IW(cbVar.getId());
            dh(cbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(cbVar, null, this.iAK.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.IW(cbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(String str) {
        m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(this.air, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.iAm.setReadState(m.IX(str));
    }

    public void b(cb cbVar) {
        MetaData bnS;
        if (cbVar != null && this.iAJ != null && (bnS = cbVar.bnS()) != null) {
            final ThemeCardInUserData themeCard = bnS.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.iAJ.setVisibility(8);
                return;
            }
            this.iAJ.setVisibility(0);
            this.iAJ.setImageBitmap(null);
            this.iAJ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.iAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(view, this.iAK);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bzn();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.hpd != null) {
            return this.hpd.fmB;
        }
        return null;
    }

    public View csm() {
        if (this.hpd != null) {
            return this.hpd.alr;
        }
        return null;
    }

    public void vb(int i) {
        if (this.iAK != null && this.iAK.eLr != null) {
            if (i == 1) {
                this.hpe.setVisibility(8);
                this.hpQ.setFrom(this.iAK.eVI);
                this.hpQ.setShareReportFrom(this.iAK.eVJ);
                this.hpQ.setStType(this.iAK.stType);
                this.hpQ.setData(this.iAK.eLr);
                this.hpd.kf(false);
                return;
            }
            this.hpe.setFrom(this.iAK.eVI);
            this.hpe.setShareReportFrom(this.iAK.eVJ);
            this.hpe.setStType(this.iAK.stType);
            this.hpe.setData(this.iAK.eLr);
            this.hpe.setDisPraiseFrom(this.iAK.eVK);
            this.hpQ.setVisibility(8);
            this.hpd.kf(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public int sY(int i) {
        return com.baidu.tieba.a.d.bKY().aB(this.ajx, i);
    }
}
