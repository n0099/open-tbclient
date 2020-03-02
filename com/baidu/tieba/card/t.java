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
    private String cTj;
    private boolean diU;
    public ThreadSourceShareAndPraiseLayout eNY;
    public ThreadUserInfoLayout eNl;
    public ThreadCommentAndPraiseInfoLayout eNm;
    private NEGFeedBackView eNx;
    private View fJN;
    private boolean fJR;
    private HeadPendantClickableView fJp;
    public OriginalThreadCardView fLb;
    private View fLu;
    private TbImageView fLv;
    private bk fLw;
    private TbImageView fLx;
    private ViewGroup fLy;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNx = null;
        this.NJ = true;
        this.fJR = true;
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.buG() != null) {
                    t.this.buG().a(view, t.this.fLw);
                }
            }
        };
        this.Mw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.fLw != null && t.this.fLw.cRf != null) {
                    if (t.this.buG() != null) {
                        t.this.buG().a(t.this.fLb, t.this.fLw);
                    }
                    String id = t.this.fLw.cRf.getId();
                    l.zS(id);
                    t.this.cb(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.fLy = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.fLy.setOnClickListener(this);
        this.fJp = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.fJp.getHeadView() != null) {
            this.fJp.getHeadView().setIsRound(true);
            this.fJp.getHeadView().setDrawBorder(false);
            this.fJp.getHeadView().setDefaultResource(17170445);
            this.fJp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJp.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.fJp.getHeadView().setPlaceHolder(1);
        }
        this.fJp.setHasPendantStyle();
        if (this.fJp.getPendantView() != null) {
            this.fJp.getPendantView().setIsRound(true);
            this.fJp.getPendantView().setDrawBorder(false);
        }
        this.eNl = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.eNx = new NEGFeedBackView(this.mPageContext);
        this.eNx.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.KA = (TextView) view.findViewById(R.id.thread_abstract);
        this.fLb = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.fLb.setSubClickListener(this.Mw);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.eNm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNm.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNm.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.eNm.setOnClickListener(this);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setShareVisible(true);
        this.eNm.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buG() != null) {
                    t.this.buG().a(view2, t.this.fLw);
                }
                if (t.this.fLw != null && t.this.fLw.cRf != null) {
                    l.zS(t.this.fLw.cRf.getId());
                    t.this.cb(t.this.fLw.cRf.getId());
                }
            }
        });
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.eNY.diH.setOnClickListener(this);
        this.eNY.diH.setNeedAddReplyIcon(true);
        this.eNY.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buG() != null) {
                    t.this.buG().a(view2, t.this.fLw);
                }
                if (view2 != t.this.eNY.dhT && t.this.fLw != null && t.this.fLw.cRf != null) {
                    l.zS(t.this.fLw.cRf.getId());
                    t.this.cb(t.this.fLw.cRf.getId());
                }
            }
        });
        this.fJN = view.findViewById(R.id.divider_line_above_praise);
        this.fLu = view.findViewById(R.id.card_divider_line);
        this.fLv = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.fLx = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.eNm.changeSelectStatus();
            }
        });
        this.eNm.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void X(final bj bjVar) {
        if (this.fLx != null) {
            if (this.fLv == null || bjVar == null) {
                this.fLx.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTR) && this.fLv.getVisibility() != 0) {
                if (this.eNx != null && this.eNx.getVisibility() == 0 && (this.fLx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLx.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fLx.setLayoutParams(layoutParams);
                }
                this.fLx.setVisibility(0);
                this.fLx.setImageDrawable(null);
                this.fLx.startLoad(bjVar.cTR, 10, false);
                this.fLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.cTS, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLx.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fJN, R.color.cp_bg_line_c);
            this.eNm.onChangeSkinType();
            this.eNl.onChangeSkinType();
            if (this.eNx != null) {
                this.eNx.onChangeSkinType();
            }
            this.fLb.onChangeSkinType();
            am.setBackgroundColor(this.fLu, R.color.cp_bg_line_e);
            this.eNY.onChangeSkinType();
        }
        if (this.fLw != null && this.fLw.cRf != null) {
            am.setBackgroundColor(this.mMaskView, this.fLw.cRf.aDV() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.fJp != null && this.fJp.getHeadView() != null && (this.fJp.getHeadView() instanceof TbImageView)) {
            this.fJp.getHeadView().setPlaceHolder(1);
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
        if (bkVar == null || bkVar.cRf == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.fLw = bkVar;
        bj bjVar = bkVar.cRf;
        if (this.eNx != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.fJR) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.eNx.setData(alVar);
                this.eNx.setFirstRowSingleColumn(true);
                this.eNx.setVisibility(Z(bjVar) ? 8 : 0);
            } else {
                this.eNx.setVisibility(8);
            }
        }
        if (this.fLw.cUB == 1) {
            this.eNl.setFrom(3);
            b(bjVar);
            X(bjVar);
        }
        this.eNl.setIsFromConcern(this.diU);
        this.eNl.setData(bjVar);
        this.eNl.setUserAfterClickListener(this.Nw);
        if (this.eNl.getHeaderImg() != null) {
            if (this.eNl.getIsSimpleThread()) {
                this.eNl.getHeaderImg().setVisibility(8);
                this.fJp.setVisibility(8);
            } else if (bjVar.aCo() == null || bjVar.aCo().getPendantData() == null || StringUtils.isNull(bjVar.aCo().getPendantData().aAG())) {
                this.fJp.setVisibility(8);
                this.eNl.getHeaderImg().setVisibility(0);
                this.eNl.getHeaderImg().setData(bjVar);
            } else {
                this.eNl.getHeaderImg().setVisibility(4);
                this.fJp.setVisibility(0);
                this.fJp.setData(bjVar);
            }
        }
        Y(bjVar);
        this.fLb.b(bjVar.cTQ);
        pB(oc(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cb(bjVar.getId());
        if (this.eNm.isInFrsAllThread() && com.baidu.tieba.frs.a.bCV().bCW()) {
            this.mMaskView.setVisibility(0);
            if (bjVar.aDV() || bjVar.aDW()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTj)) {
                bjVar.cp(this.mUrl, this.cTj);
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
        if (bjVar == null || bjVar.aCo() == null || StringUtils.isNull(bjVar.aCo().getUserId())) {
            return false;
        }
        return bjVar.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eNx != null) {
            this.eNx.setUniqueId(bdUniqueId);
        }
        if (this.eNl != null) {
            this.eNl.setPageUniqueId(bdUniqueId);
        }
    }

    public void kq(boolean z) {
        if (this.fLu != null) {
            this.fLu.setVisibility(z ? 0 : 8);
        }
    }

    public void kl(boolean z) {
        this.fJR = z;
    }

    private void aMy() {
        if (this.fLw != null && this.fLw.cRf != null) {
            bj bjVar = this.fLw.cRf;
            l.zS(bjVar.getId());
            cb(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.fLw.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
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
        this.fLb.setReadState(l.zT(str));
    }

    public void b(bj bjVar) {
        MetaData aCo;
        if (bjVar != null && this.fLv != null && (aCo = bjVar.aCo()) != null) {
            final ThemeCardInUserData themeCard = aCo.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fLv.setVisibility(8);
                return;
            }
            this.fLv.setVisibility(0);
            this.fLv.setImageBitmap(null);
            this.fLv.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buG() != null) {
            buG().a(view, this.fLw);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aMy();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eNl != null) {
            return this.eNl.dio;
        }
        return null;
    }

    public View buL() {
        if (this.eNl != null) {
            return this.eNl.Nl;
        }
        return null;
    }

    public void pB(int i) {
        if (this.fLw != null && this.fLw.cRf != null) {
            if (i == 1) {
                this.eNm.setVisibility(8);
                this.eNY.setFrom(this.fLw.cUA);
                this.eNY.setShareReportFrom(this.fLw.cUB);
                this.eNY.setStType(this.fLw.stType);
                this.eNY.setData(this.fLw.cRf);
                this.eNl.fR(false);
                return;
            }
            this.eNm.setFrom(this.fLw.cUA);
            this.eNm.setShareReportFrom(this.fLw.cUB);
            this.eNm.setStType(this.fLw.stType);
            this.eNm.setData(this.fLw.cRf);
            this.eNm.setDisPraiseFrom(this.fLw.cUC);
            this.eNY.setVisibility(8);
            this.eNl.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }
}
