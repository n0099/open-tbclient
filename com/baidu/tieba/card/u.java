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
    private TextView aia;
    private OriginalThreadCardView.a ajY;
    private String aji;
    private boolean alQ;
    private final View.OnClickListener alk;
    private String eUU;
    private boolean fnX;
    private NEGFeedBackView hnK;
    public ThreadUserInfoLayout hny;
    public ThreadCommentAndPraiseInfoLayout hnz;
    public ThreadSourceShareAndPraiseLayout hol;
    private HeadPendantClickableView ivB;
    private View ivY;
    private boolean iwc;
    private View ixI;
    private TbImageView ixJ;
    private ca ixK;
    private TbImageView ixL;
    private ViewGroup ixM;
    public OriginalThreadCardView ixo;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnK = null;
        this.alQ = true;
        this.iwc = true;
        this.alk = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.cuD() != null) {
                    u.this.cuD().a(view, u.this.ixK);
                }
            }
        };
        this.ajY = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.ixK != null && u.this.ixK.eMv != null) {
                    if (u.this.cuD() != null) {
                        u.this.cuD().a(u.this.ixo, u.this.ixK);
                    }
                    String id = u.this.ixK.eMv.getId();
                    m.Jn(id);
                    u.this.di(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ixM = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.ixM.setOnClickListener(this);
        this.ivB = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.ivB.getHeadView() != null) {
            this.ivB.getHeadView().setIsRound(true);
            this.ivB.getHeadView().setDrawBorder(false);
            this.ivB.getHeadView().setDefaultResource(17170445);
            this.ivB.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.ivB.getHeadView().setPlaceHolder(1);
        }
        this.ivB.setHasPendantStyle();
        if (this.ivB.getPendantView() != null) {
            this.ivB.getPendantView().setIsRound(true);
            this.ivB.getPendantView().setDrawBorder(false);
        }
        this.hny = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.hnK = new NEGFeedBackView(this.mPageContext);
        this.hnK.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.aia = (TextView) view.findViewById(R.id.thread_abstract);
        this.ixo = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.ixo.setSubClickListener(this.ajY);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.hnz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnz.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.hnz.setOnClickListener(this);
        this.hnz.setReplyTimeVisible(false);
        this.hnz.setShowPraiseNum(true);
        this.hnz.setNeedAddPraiseIcon(true);
        this.hnz.setNeedAddReplyIcon(true);
        this.hnz.setShareVisible(true);
        this.hnz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cuD() != null) {
                    u.this.cuD().a(view2, u.this.ixK);
                }
                if (u.this.ixK != null && u.this.ixK.eMv != null) {
                    m.Jn(u.this.ixK.eMv.getId());
                    u.this.di(u.this.ixK.eMv.getId());
                }
            }
        });
        this.hol = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.hol.fnK.setOnClickListener(this);
        this.hol.fnK.setNeedAddReplyIcon(true);
        this.hol.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cuD() != null) {
                    u.this.cuD().a(view2, u.this.ixK);
                }
                if (view2 != u.this.hol.fmZ && u.this.ixK != null && u.this.ixK.eMv != null) {
                    m.Jn(u.this.ixK.eMv.getId());
                    u.this.di(u.this.ixK.eMv.getId());
                }
            }
        });
        this.ivY = view.findViewById(R.id.divider_line_above_praise);
        this.ixI = view.findViewById(R.id.card_divider_line);
        this.ixJ = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.ixL = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.hnz.changeSelectStatus();
            }
        });
        this.hnz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void kf(boolean z) {
                ao.setBackgroundColor(u.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void aa(final bz bzVar) {
        if (this.ixL != null) {
            if (this.ixJ == null || bzVar == null) {
                this.ixL.setVisibility(8);
            } else if (!StringUtils.isNull(bzVar.eVC) && this.ixJ.getVisibility() != 0) {
                if (this.hnK != null && this.hnK.getVisibility() == 0 && (this.ixL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixL.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ixL.setLayoutParams(layoutParams);
                }
                this.ixL.setVisibility(0);
                this.ixL.setImageDrawable(null);
                this.ixL.startLoad(bzVar.eVC, 10, false);
                this.ixL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bzVar.eVD, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ixL.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.ivY, R.color.CAM_X0204);
            this.hnz.onChangeSkinType();
            this.hny.onChangeSkinType();
            if (this.hnK != null) {
                this.hnK.onChangeSkinType();
            }
            this.ixo.onChangeSkinType();
            ao.setBackgroundColor(this.ixI, R.color.CAM_X0205);
            this.hol.onChangeSkinType();
        }
        if (this.ixK != null && this.ixK.eMv != null) {
            ao.setBackgroundColor(this.mMaskView, (this.ixK.eMv.btf() || this.ixK.eMv.btg()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.ivB != null && this.ivB.getHeadView() != null && (this.ivB.getHeadView() instanceof TbImageView)) {
            this.ivB.getHeadView().setPlaceHolder(1);
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
        if (caVar == null || caVar.eMv == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.ixK = caVar;
        bz bzVar = caVar.eMv;
        if (this.hnK != null) {
            SparseArray<String> feedBackReasonMap = bzVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.iwc) {
                at atVar = new at();
                atVar.setTid(bzVar.getTid());
                atVar.setFid(bzVar.getFid());
                atVar.setNid(bzVar.bpP());
                atVar.setFeedBackReasonMap(feedBackReasonMap);
                atVar.eQN = bzVar.eQN;
                this.hnK.setData(atVar);
                this.hnK.setFirstRowSingleColumn(true);
                this.hnK.setVisibility(ac(bzVar) ? 8 : 0);
            } else {
                this.hnK.setVisibility(8);
            }
        }
        if (this.ixK.eWH == 1) {
            this.hny.setFrom(3);
            b(bzVar);
            aa(bzVar);
        }
        this.hny.setIsFromConcern(this.fnX);
        this.hny.setData(bzVar);
        this.hny.setUserAfterClickListener(this.alk);
        if (this.hny.getHeaderImg() != null) {
            if (this.hny.getIsSimpleThread()) {
                this.hny.getHeaderImg().setVisibility(8);
                this.ivB.setVisibility(8);
            } else if (bzVar.brr() == null || bzVar.brr().getPendantData() == null || StringUtils.isNull(bzVar.brr().getPendantData().getImgUrl())) {
                this.ivB.setVisibility(8);
                this.hny.getHeaderImg().setVisibility(0);
                this.hny.getHeaderImg().setData(bzVar);
            } else {
                this.hny.getHeaderImg().setVisibility(4);
                this.ivB.setVisibility(0);
                this.ivB.setData(bzVar);
            }
        }
        ab(bzVar);
        this.ixo.b(bzVar.eVB);
        wv(ux(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        di(bzVar.getId());
        if (this.hnz.isInFrsAllThread() && (com.baidu.tieba.frs.b.cDY().cDS() || com.baidu.tieba.frs.a.cDR().cDS())) {
            this.mMaskView.setVisibility(0);
            if (bzVar.btf() || bzVar.btg() || bzVar.bth()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eUU)) {
                bzVar.dK(this.mUrl, this.eUU);
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
        if (bzVar == null || bzVar.brr() == null || StringUtils.isNull(bzVar.brr().getUserId())) {
            return false;
        }
        return bzVar.brr().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hnK != null) {
            this.hnK.setUniqueId(bdUniqueId);
        }
        if (this.hny != null) {
            this.hny.setPageUniqueId(bdUniqueId);
        }
    }

    public void pw(boolean z) {
        if (this.ixI != null) {
            this.ixI.setVisibility(z ? 0 : 8);
        }
    }

    public void pr(boolean z) {
        this.iwc = z;
    }

    private void bCM() {
        if (this.ixK != null && this.ixK.eMv != null) {
            bz bzVar = this.ixK.eMv;
            m.Jn(bzVar.getId());
            di(bzVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bzVar, null, this.ixK.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.Jn(bzVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(String str) {
        m.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(this.aia, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.ixo.setReadState(m.Jo(str));
    }

    public void b(bz bzVar) {
        MetaData brr;
        if (bzVar != null && this.ixJ != null && (brr = bzVar.brr()) != null) {
            final ThemeCardInUserData themeCard = brr.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ixJ.setVisibility(8);
                return;
            }
            this.ixJ.setVisibility(0);
            this.ixJ.setImageBitmap(null);
            this.ixJ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ixJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuD() != null) {
            cuD().a(view, this.ixK);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bCM();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.hny != null) {
            return this.hny.fnt;
        }
        return null;
    }

    public View cuH() {
        if (this.hny != null) {
            return this.hny.ala;
        }
        return null;
    }

    public void wv(int i) {
        if (this.ixK != null && this.ixK.eMv != null) {
            if (i == 1) {
                this.hnz.setVisibility(8);
                this.hol.setFrom(this.ixK.eWG);
                this.hol.setShareReportFrom(this.ixK.eWH);
                this.hol.setStType(this.ixK.stType);
                this.hol.setData(this.ixK.eMv);
                this.hny.kg(false);
                return;
            }
            this.hnz.setFrom(this.ixK.eWG);
            this.hnz.setShareReportFrom(this.ixK.eWH);
            this.hnz.setStType(this.ixK.stType);
            this.hnz.setData(this.ixK.eMv);
            this.hnz.setDisPraiseFrom(this.ixK.eWI);
            this.hol.setVisibility(8);
            this.hny.kg(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public int ux(int i) {
        return com.baidu.tieba.a.d.bOn().az(this.aji, i);
    }
}
