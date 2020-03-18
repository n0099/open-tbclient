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
/* loaded from: classes8.dex */
public class t extends a<bk> implements com.baidu.tieba.a.e {
    private TextView KA;
    private String LC;
    private OriginalThreadCardView.a Mx;
    private boolean NK;
    private final View.OnClickListener Nx;
    private String cTx;
    private boolean dju;
    public ThreadUserInfoLayout eNW;
    public ThreadCommentAndPraiseInfoLayout eNX;
    public ThreadSourceShareAndPraiseLayout eOJ;
    private NEGFeedBackView eOi;
    private View fKI;
    private boolean fKM;
    private HeadPendantClickableView fKk;
    public OriginalThreadCardView fLW;
    private View fMp;
    private TbImageView fMq;
    private bk fMr;
    private TbImageView fMs;
    private ViewGroup fMt;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eOi = null;
        this.NK = true;
        this.fKM = true;
        this.Nx = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.buM() != null) {
                    t.this.buM().a(view, t.this.fMr);
                }
            }
        };
        this.Mx = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.fMr != null && t.this.fMr.cRt != null) {
                    if (t.this.buM() != null) {
                        t.this.buM().a(t.this.fLW, t.this.fMr);
                    }
                    String id = t.this.fMr.cRt.getId();
                    l.zU(id);
                    t.this.cb(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.fMt = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.fMt.setOnClickListener(this);
        this.fKk = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.fKk.getHeadView() != null) {
            this.fKk.getHeadView().setIsRound(true);
            this.fKk.getHeadView().setDrawBorder(false);
            this.fKk.getHeadView().setDefaultResource(17170445);
            this.fKk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fKk.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.fKk.getHeadView().setPlaceHolder(1);
        }
        this.fKk.setHasPendantStyle();
        if (this.fKk.getPendantView() != null) {
            this.fKk.getPendantView().setIsRound(true);
            this.fKk.getPendantView().setDrawBorder(false);
        }
        this.eNW = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.eOi = new NEGFeedBackView(this.mPageContext);
        this.eOi.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.KA = (TextView) view.findViewById(R.id.thread_abstract);
        this.fLW = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.fLW.setSubClickListener(this.Mx);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.eNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNX.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.eNX.setOnClickListener(this);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setShareVisible(true);
        this.eNX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buM() != null) {
                    t.this.buM().a(view2, t.this.fMr);
                }
                if (t.this.fMr != null && t.this.fMr.cRt != null) {
                    l.zU(t.this.fMr.cRt.getId());
                    t.this.cb(t.this.fMr.cRt.getId());
                }
            }
        });
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.eOJ.djh.setOnClickListener(this);
        this.eOJ.djh.setNeedAddReplyIcon(true);
        this.eOJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buM() != null) {
                    t.this.buM().a(view2, t.this.fMr);
                }
                if (view2 != t.this.eOJ.diw && t.this.fMr != null && t.this.fMr.cRt != null) {
                    l.zU(t.this.fMr.cRt.getId());
                    t.this.cb(t.this.fMr.cRt.getId());
                }
            }
        });
        this.fKI = view.findViewById(R.id.divider_line_above_praise);
        this.fMp = view.findViewById(R.id.card_divider_line);
        this.fMq = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.fMs = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.eNX.changeSelectStatus();
            }
        });
        this.eNX.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fU(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Y(final bj bjVar) {
        if (this.fMs != null) {
            if (this.fMq == null || bjVar == null) {
                this.fMs.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cUf) && this.fMq.getVisibility() != 0) {
                if (this.eOi != null && this.eOi.getVisibility() == 0 && (this.fMs.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMs.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fMs.setLayoutParams(layoutParams);
                }
                this.fMs.setVisibility(0);
                this.fMs.setImageDrawable(null);
                this.fMs.startLoad(bjVar.cUf, 10, false);
                this.fMs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.cUg, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fMs.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fKI, R.color.cp_bg_line_c);
            this.eNX.onChangeSkinType();
            this.eNW.onChangeSkinType();
            if (this.eOi != null) {
                this.eOi.onChangeSkinType();
            }
            this.fLW.onChangeSkinType();
            am.setBackgroundColor(this.fMp, R.color.cp_bg_line_e);
            this.eOJ.onChangeSkinType();
        }
        if (this.fMr != null && this.fMr.cRt != null) {
            am.setBackgroundColor(this.mMaskView, this.fMr.cRt.aDZ() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.fKk != null && this.fKk.getHeadView() != null && (this.fKk.getHeadView() instanceof TbImageView)) {
            this.fKk.getHeadView().setPlaceHolder(1);
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
        if (bkVar == null || bkVar.cRt == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.fMr = bkVar;
        bj bjVar = bkVar.cRt;
        if (this.eOi != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.fKM) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.eOi.setData(alVar);
                this.eOi.setFirstRowSingleColumn(true);
                this.eOi.setVisibility(aa(bjVar) ? 8 : 0);
            } else {
                this.eOi.setVisibility(8);
            }
        }
        if (this.fMr.cUP == 1) {
            this.eNW.setFrom(3);
            b(bjVar);
            Y(bjVar);
        }
        this.eNW.setIsFromConcern(this.dju);
        this.eNW.setData(bjVar);
        this.eNW.setUserAfterClickListener(this.Nx);
        if (this.eNW.getHeaderImg() != null) {
            if (this.eNW.getIsSimpleThread()) {
                this.eNW.getHeaderImg().setVisibility(8);
                this.fKk.setVisibility(8);
            } else if (bjVar.aCr() == null || bjVar.aCr().getPendantData() == null || StringUtils.isNull(bjVar.aCr().getPendantData().aAJ())) {
                this.fKk.setVisibility(8);
                this.eNW.getHeaderImg().setVisibility(0);
                this.eNW.getHeaderImg().setData(bjVar);
            } else {
                this.eNW.getHeaderImg().setVisibility(4);
                this.fKk.setVisibility(0);
                this.fKk.setData(bjVar);
            }
        }
        Z(bjVar);
        this.fLW.b(bjVar.cUe);
        pD(oe(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cb(bjVar.getId());
        if (this.eNX.isInFrsAllThread() && com.baidu.tieba.frs.a.bDd().bDe()) {
            this.mMaskView.setVisibility(0);
            if (bjVar.aDZ() || bjVar.aEa()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void Z(bj bjVar) {
        if (bjVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTx)) {
                bjVar.co(this.mUrl, this.cTx);
            }
            SpannableStringBuilder v = bjVar.v(false, true);
            if (v == null || StringUtils.isNull(v.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.h(v));
            this.mTitle.setText(v);
            l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean aa(bj bjVar) {
        if (bjVar == null || bjVar.aCr() == null || StringUtils.isNull(bjVar.aCr().getUserId())) {
            return false;
        }
        return bjVar.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eOi != null) {
            this.eOi.setUniqueId(bdUniqueId);
        }
        if (this.eNW != null) {
            this.eNW.setPageUniqueId(bdUniqueId);
        }
    }

    public void kv(boolean z) {
        if (this.fMp != null) {
            this.fMp.setVisibility(z ? 0 : 8);
        }
    }

    public void kq(boolean z) {
        this.fKM = z;
    }

    private void aMD() {
        if (this.fMr != null && this.fMr.cRt != null) {
            bj bjVar = this.fMr.cRt;
            l.zU(bjVar.getId());
            cb(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.fMr.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            l.zU(bjVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(String str) {
        l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        l.a(this.KA, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.fLW.setReadState(l.zV(str));
    }

    public void b(bj bjVar) {
        MetaData aCr;
        if (bjVar != null && this.fMq != null && (aCr = bjVar.aCr()) != null) {
            final ThemeCardInUserData themeCard = aCr.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fMq.setVisibility(8);
                return;
            }
            this.fMq.setVisibility(0);
            this.fMq.setImageBitmap(null);
            this.fMq.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buM() != null) {
            buM().a(view, this.fMr);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aMD();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eNW != null) {
            return this.eNW.diQ;
        }
        return null;
    }

    public View buR() {
        if (this.eNW != null) {
            return this.eNW.Nm;
        }
        return null;
    }

    public void pD(int i) {
        if (this.fMr != null && this.fMr.cRt != null) {
            if (i == 1) {
                this.eNX.setVisibility(8);
                this.eOJ.setFrom(this.fMr.cUO);
                this.eOJ.setShareReportFrom(this.fMr.cUP);
                this.eOJ.setStType(this.fMr.stType);
                this.eOJ.setData(this.fMr.cRt);
                this.eNW.fS(false);
                return;
            }
            this.eNX.setFrom(this.fMr.cUO);
            this.eNX.setShareReportFrom(this.fMr.cUP);
            this.eNX.setStType(this.fMr.stType);
            this.eNX.setData(this.fMr.cRt);
            this.eNX.setDisPraiseFrom(this.fMr.cUQ);
            this.eOJ.setVisibility(8);
            this.eNW.fS(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }
}
