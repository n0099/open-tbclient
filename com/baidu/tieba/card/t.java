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
    private OriginalThreadCardView.a Mw;
    private boolean NJ;
    private final View.OnClickListener Nw;
    private String cTi;
    private boolean diT;
    public ThreadSourceShareAndPraiseLayout eNX;
    public ThreadUserInfoLayout eNk;
    public ThreadCommentAndPraiseInfoLayout eNl;
    private NEGFeedBackView eNw;
    private View fJL;
    private boolean fJP;
    private HeadPendantClickableView fJn;
    public OriginalThreadCardView fKZ;
    private View fLs;
    private TbImageView fLt;
    private bk fLu;
    private TbImageView fLv;
    private ViewGroup fLw;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNw = null;
        this.NJ = true;
        this.fJP = true;
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.buE() != null) {
                    t.this.buE().a(view, t.this.fLu);
                }
            }
        };
        this.Mw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.fLu != null && t.this.fLu.cRe != null) {
                    if (t.this.buE() != null) {
                        t.this.buE().a(t.this.fKZ, t.this.fLu);
                    }
                    String id = t.this.fLu.cRe.getId();
                    l.zS(id);
                    t.this.cb(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.fLw = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.fLw.setOnClickListener(this);
        this.fJn = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.fJn.getHeadView() != null) {
            this.fJn.getHeadView().setIsRound(true);
            this.fJn.getHeadView().setDrawBorder(false);
            this.fJn.getHeadView().setDefaultResource(17170445);
            this.fJn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJn.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.fJn.getHeadView().setPlaceHolder(1);
        }
        this.fJn.setHasPendantStyle();
        if (this.fJn.getPendantView() != null) {
            this.fJn.getPendantView().setIsRound(true);
            this.fJn.getPendantView().setDrawBorder(false);
        }
        this.eNk = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.eNw = new NEGFeedBackView(this.mPageContext);
        this.eNw.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.KA = (TextView) view.findViewById(R.id.thread_abstract);
        this.fKZ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.fKZ.setSubClickListener(this.Mw);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.eNl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNl.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNl.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.eNl.setOnClickListener(this);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setShareVisible(true);
        this.eNl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buE() != null) {
                    t.this.buE().a(view2, t.this.fLu);
                }
                if (t.this.fLu != null && t.this.fLu.cRe != null) {
                    l.zS(t.this.fLu.cRe.getId());
                    t.this.cb(t.this.fLu.cRe.getId());
                }
            }
        });
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.eNX.diG.setOnClickListener(this);
        this.eNX.diG.setNeedAddReplyIcon(true);
        this.eNX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buE() != null) {
                    t.this.buE().a(view2, t.this.fLu);
                }
                if (view2 != t.this.eNX.dhS && t.this.fLu != null && t.this.fLu.cRe != null) {
                    l.zS(t.this.fLu.cRe.getId());
                    t.this.cb(t.this.fLu.cRe.getId());
                }
            }
        });
        this.fJL = view.findViewById(R.id.divider_line_above_praise);
        this.fLs = view.findViewById(R.id.card_divider_line);
        this.fLt = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.fLv = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.eNl.changeSelectStatus();
            }
        });
        this.eNl.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void X(final bj bjVar) {
        if (this.fLv != null) {
            if (this.fLt == null || bjVar == null) {
                this.fLv.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTQ) && this.fLt.getVisibility() != 0) {
                if (this.eNw != null && this.eNw.getVisibility() == 0 && (this.fLv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLv.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fLv.setLayoutParams(layoutParams);
                }
                this.fLv.setVisibility(0);
                this.fLv.setImageDrawable(null);
                this.fLv.startLoad(bjVar.cTQ, 10, false);
                this.fLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.cTR, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLv.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fJL, R.color.cp_bg_line_c);
            this.eNl.onChangeSkinType();
            this.eNk.onChangeSkinType();
            if (this.eNw != null) {
                this.eNw.onChangeSkinType();
            }
            this.fKZ.onChangeSkinType();
            am.setBackgroundColor(this.fLs, R.color.cp_bg_line_e);
            this.eNX.onChangeSkinType();
        }
        if (this.fLu != null && this.fLu.cRe != null) {
            am.setBackgroundColor(this.mMaskView, this.fLu.cRe.aDT() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.fJn != null && this.fJn.getHeadView() != null && (this.fJn.getHeadView() instanceof TbImageView)) {
            this.fJn.getHeadView().setPlaceHolder(1);
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
        if (bkVar == null || bkVar.cRe == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.fLu = bkVar;
        bj bjVar = bkVar.cRe;
        if (this.eNw != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.fJP) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.eNw.setData(alVar);
                this.eNw.setFirstRowSingleColumn(true);
                this.eNw.setVisibility(Z(bjVar) ? 8 : 0);
            } else {
                this.eNw.setVisibility(8);
            }
        }
        if (this.fLu.cUA == 1) {
            this.eNk.setFrom(3);
            b(bjVar);
            X(bjVar);
        }
        this.eNk.setIsFromConcern(this.diT);
        this.eNk.setData(bjVar);
        this.eNk.setUserAfterClickListener(this.Nw);
        if (this.eNk.getHeaderImg() != null) {
            if (this.eNk.getIsSimpleThread()) {
                this.eNk.getHeaderImg().setVisibility(8);
                this.fJn.setVisibility(8);
            } else if (bjVar.aCm() == null || bjVar.aCm().getPendantData() == null || StringUtils.isNull(bjVar.aCm().getPendantData().aAE())) {
                this.fJn.setVisibility(8);
                this.eNk.getHeaderImg().setVisibility(0);
                this.eNk.getHeaderImg().setData(bjVar);
            } else {
                this.eNk.getHeaderImg().setVisibility(4);
                this.fJn.setVisibility(0);
                this.fJn.setData(bjVar);
            }
        }
        Y(bjVar);
        this.fKZ.b(bjVar.cTP);
        pB(oc(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cb(bjVar.getId());
        if (this.eNl.isInFrsAllThread() && com.baidu.tieba.frs.a.bCT().bCU()) {
            this.mMaskView.setVisibility(0);
            if (bjVar.aDT() || bjVar.aDU()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void Y(bj bjVar) {
        if (bjVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTi)) {
                bjVar.cp(this.mUrl, this.cTi);
            }
            SpannableStringBuilder u = bjVar.u(false, true);
            if (u == null || StringUtils.isNull(u.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.h(u));
            this.mTitle.setText(u);
            l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean Z(bj bjVar) {
        if (bjVar == null || bjVar.aCm() == null || StringUtils.isNull(bjVar.aCm().getUserId())) {
            return false;
        }
        return bjVar.aCm().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eNw != null) {
            this.eNw.setUniqueId(bdUniqueId);
        }
        if (this.eNk != null) {
            this.eNk.setPageUniqueId(bdUniqueId);
        }
    }

    public void kq(boolean z) {
        if (this.fLs != null) {
            this.fLs.setVisibility(z ? 0 : 8);
        }
    }

    public void kl(boolean z) {
        this.fJP = z;
    }

    private void aMw() {
        if (this.fLu != null && this.fLu.cRe != null) {
            bj bjVar = this.fLu.cRe;
            l.zS(bjVar.getId());
            cb(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.fLu.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            l.zS(bjVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(String str) {
        l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        l.a(this.KA, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.fKZ.setReadState(l.zT(str));
    }

    public void b(bj bjVar) {
        MetaData aCm;
        if (bjVar != null && this.fLt != null && (aCm = bjVar.aCm()) != null) {
            final ThemeCardInUserData themeCard = aCm.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fLt.setVisibility(8);
                return;
            }
            this.fLt.setVisibility(0);
            this.fLt.setImageBitmap(null);
            this.fLt.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buE() != null) {
            buE().a(view, this.fLu);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aMw();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eNk != null) {
            return this.eNk.din;
        }
        return null;
    }

    public View buJ() {
        if (this.eNk != null) {
            return this.eNk.Nl;
        }
        return null;
    }

    public void pB(int i) {
        if (this.fLu != null && this.fLu.cRe != null) {
            if (i == 1) {
                this.eNl.setVisibility(8);
                this.eNX.setFrom(this.fLu.cUz);
                this.eNX.setShareReportFrom(this.fLu.cUA);
                this.eNX.setStType(this.fLu.stType);
                this.eNX.setData(this.fLu.cRe);
                this.eNk.fR(false);
                return;
            }
            this.eNl.setFrom(this.fLu.cUz);
            this.eNl.setShareReportFrom(this.fLu.cUA);
            this.eNl.setStType(this.fLu.stType);
            this.eNl.setData(this.fLu.cRe);
            this.eNl.setDisPraiseFrom(this.fLu.cUB);
            this.eNX.setVisibility(8);
            this.eNk.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }
}
