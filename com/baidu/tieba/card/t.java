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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
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
/* loaded from: classes5.dex */
public class t extends a<bk> implements com.baidu.tieba.a.e {
    private TextView JZ;
    private OriginalThreadCardView.a LS;
    private String La;
    private final View.OnClickListener MT;
    private boolean Nf;
    private String cOW;
    private boolean deB;
    public ThreadSourceShareAndPraiseLayout eIU;
    public ThreadUserInfoLayout eIg;
    public ThreadCommentAndPraiseInfoLayout eIh;
    private NEGFeedBackView eIt;
    private HeadPendantClickableView fDG;
    private View fEe;
    private boolean fEi;
    private View fFL;
    private TbImageView fFM;
    private bk fFN;
    private TbImageView fFO;
    private ViewGroup fFP;
    public OriginalThreadCardView fFs;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eIt = null;
        this.Nf = true;
        this.fEi = true;
        this.MT = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.brY() != null) {
                    t.this.brY().a(view, t.this.fFN);
                }
            }
        };
        this.LS = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.fFN != null && t.this.fFN.cMR != null) {
                    if (t.this.brY() != null) {
                        t.this.brY().a(t.this.fFs, t.this.fFN);
                    }
                    String id = t.this.fFN.cMR.getId();
                    l.zs(id);
                    t.this.bZ(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.fFP = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.fFP.setOnClickListener(this);
        this.fDG = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.fDG.getHeadView() != null) {
            this.fDG.getHeadView().setIsRound(true);
            this.fDG.getHeadView().setDrawBorder(false);
            this.fDG.getHeadView().setDefaultResource(17170445);
            this.fDG.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDG.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.fDG.getHeadView().setPlaceHolder(1);
        }
        this.fDG.setHasPendantStyle();
        if (this.fDG.getPendantView() != null) {
            this.fDG.getPendantView().setIsRound(true);
            this.fDG.getPendantView().setDrawBorder(false);
        }
        this.eIg = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.eIt = new NEGFeedBackView(this.mPageContext);
        this.eIt.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.JZ = (TextView) view.findViewById(R.id.thread_abstract);
        this.fFs = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.fFs.setSubClickListener(this.LS);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.eIh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIh.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eIh.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.eIh.setOnClickListener(this);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setShareVisible(true);
        this.eIh.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.brY() != null) {
                    t.this.brY().a(view2, t.this.fFN);
                }
                if (t.this.fFN != null && t.this.fFN.cMR != null) {
                    l.zs(t.this.fFN.cMR.getId());
                    t.this.bZ(t.this.fFN.cMR.getId());
                }
            }
        });
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.eIU.dep.setOnClickListener(this);
        this.eIU.dep.setNeedAddReplyIcon(true);
        this.eIU.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.brY() != null) {
                    t.this.brY().a(view2, t.this.fFN);
                }
                if (view2 != t.this.eIU.ddE && t.this.fFN != null && t.this.fFN.cMR != null) {
                    l.zs(t.this.fFN.cMR.getId());
                    t.this.bZ(t.this.fFN.cMR.getId());
                }
            }
        });
        this.fEe = view.findViewById(R.id.divider_line_above_praise);
        this.fFL = view.findViewById(R.id.card_divider_line);
        this.fFM = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.fFO = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.eIh.changeSelectStatus();
            }
        });
        this.eIh.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fH(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void V(final bj bjVar) {
        if (this.fFO != null) {
            if (this.fFM == null || bjVar == null) {
                this.fFO.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cPE) && this.fFM.getVisibility() != 0) {
                if (this.eIt != null && this.eIt.getVisibility() == 0 && (this.fFO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fFO.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fFO.setLayoutParams(layoutParams);
                }
                this.fFO.setVisibility(0);
                this.fFO.setImageDrawable(null);
                this.fFO.startLoad(bjVar.cPE, 10, false);
                this.fFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.cPF, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fFO.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fEe, R.color.cp_bg_line_c);
            this.eIh.onChangeSkinType();
            this.eIg.onChangeSkinType();
            if (this.eIt != null) {
                this.eIt.onChangeSkinType();
            }
            this.fFs.onChangeSkinType();
            am.setBackgroundColor(this.fFL, R.color.cp_bg_line_e);
            this.eIU.onChangeSkinType();
        }
        if (this.fFN != null && this.fFN.cMR != null) {
            am.setBackgroundColor(this.mMaskView, this.fFN.cMR.aBn() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.fDG != null && this.fDG.getHeadView() != null && (this.fDG.getHeadView() instanceof TbImageView)) {
            this.fDG.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bk bkVar) {
        if (bkVar == null || bkVar.cMR == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.fFN = bkVar;
        bj bjVar = bkVar.cMR;
        if (this.eIt != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.fEi) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.eIt.setData(alVar);
                this.eIt.setFirstRowSingleColumn(true);
                this.eIt.setVisibility(X(bjVar) ? 8 : 0);
            } else {
                this.eIt.setVisibility(8);
            }
        }
        if (this.fFN.cQo == 1) {
            this.eIg.setFrom(3);
            b(bjVar);
            V(bjVar);
        }
        if (this.currentPageType == 15) {
            this.eIg.setFrom(5);
        }
        this.eIg.setIsFromConcern(this.deB);
        this.eIg.setData(bjVar);
        this.eIg.setUserAfterClickListener(this.MT);
        if (this.eIg.getHeaderImg() != null) {
            if (this.eIg.getIsSimpleThread()) {
                this.eIg.getHeaderImg().setVisibility(8);
                this.fDG.setVisibility(8);
            } else if (bjVar.azE() == null || bjVar.azE().getPendantData() == null || StringUtils.isNull(bjVar.azE().getPendantData().axX())) {
                this.fDG.setVisibility(8);
                this.eIg.getHeaderImg().setVisibility(0);
                this.eIg.getHeaderImg().setData(bjVar);
            } else {
                this.eIg.getHeaderImg().setVisibility(4);
                this.fDG.setVisibility(0);
                this.fDG.setData(bjVar);
            }
        }
        W(bjVar);
        this.fFs.b(bjVar.cPD);
        pp(nL(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        bZ(bjVar.getId());
        if (this.eIh.isInFrsAllThread() && com.baidu.tieba.frs.a.bAp().bAq()) {
            this.mMaskView.setVisibility(0);
            if (bjVar.aBn() || bjVar.aBo()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void W(bj bjVar) {
        if (bjVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cOW)) {
                bjVar.cg(this.mUrl, this.cOW);
            }
            SpannableStringBuilder s = bjVar.s(false, true);
            if (s == null || StringUtils.isNull(s.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.h(s));
            this.mTitle.setText(s);
            l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean X(bj bjVar) {
        if (bjVar == null || bjVar.azE() == null || StringUtils.isNull(bjVar.azE().getUserId())) {
            return false;
        }
        return bjVar.azE().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eIt != null) {
            this.eIt.setUniqueId(bdUniqueId);
        }
        if (this.eIg != null) {
            this.eIg.setPageUniqueId(bdUniqueId);
        }
    }

    public void kd(boolean z) {
        if (this.fFL != null) {
            this.fFL.setVisibility(z ? 0 : 8);
        }
    }

    public void jY(boolean z) {
        this.fEi = z;
    }

    private void aJG() {
        if (this.fFN != null && this.fFN.cMR != null) {
            bj bjVar = this.fFN.cMR;
            l.zs(bjVar.getId());
            bZ(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.fFN.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            l.zs(bjVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(String str) {
        l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        l.a(this.JZ, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.fFs.setReadState(l.zt(str));
    }

    public void b(bj bjVar) {
        MetaData azE;
        if (bjVar != null && this.fFM != null && (azE = bjVar.azE()) != null) {
            final ThemeCardInUserData themeCard = azE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fFM.setVisibility(8);
                return;
            }
            this.fFM.setVisibility(0);
            this.fFM.setImageBitmap(null);
            this.fFM.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            brY().a(view, this.fFN);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aJG();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eIg != null) {
            return this.eIg.ddY;
        }
        return null;
    }

    public View bsd() {
        if (this.eIg != null) {
            return this.eIg.ME;
        }
        return null;
    }

    public void pp(int i) {
        if (this.fFN != null && this.fFN.cMR != null) {
            if (i == 1) {
                this.eIh.setVisibility(8);
                this.eIU.setFrom(this.fFN.cQn);
                this.eIU.setShareReportFrom(this.fFN.cQo);
                this.eIU.setStType(this.fFN.stType);
                this.eIU.setData(this.fFN.cMR);
                this.eIg.fF(false);
                return;
            }
            this.eIh.setFrom(this.fFN.cQn);
            this.eIh.setShareReportFrom(this.fFN.cQo);
            this.eIh.setStType(this.fFN.stType);
            this.eIh.setData(this.fFN.cMR);
            this.eIh.setDisPraiseFrom(this.fFN.cQp);
            this.eIU.setVisibility(8);
            this.eIg.fF(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }
}
