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
    private String cTk;
    private boolean djh;
    private NEGFeedBackView eNK;
    public ThreadUserInfoLayout eNy;
    public ThreadCommentAndPraiseInfoLayout eNz;
    public ThreadSourceShareAndPraiseLayout eOl;
    private HeadPendantClickableView fJC;
    private View fKa;
    private boolean fKe;
    private View fLH;
    private TbImageView fLI;
    private bk fLJ;
    private TbImageView fLK;
    private ViewGroup fLL;
    public OriginalThreadCardView fLo;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNK = null;
        this.NJ = true;
        this.fKe = true;
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.buH() != null) {
                    t.this.buH().a(view, t.this.fLJ);
                }
            }
        };
        this.Mw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.fLJ != null && t.this.fLJ.cRg != null) {
                    if (t.this.buH() != null) {
                        t.this.buH().a(t.this.fLo, t.this.fLJ);
                    }
                    String id = t.this.fLJ.cRg.getId();
                    l.zT(id);
                    t.this.cb(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.fLL = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.fLL.setOnClickListener(this);
        this.fJC = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.fJC.getHeadView() != null) {
            this.fJC.getHeadView().setIsRound(true);
            this.fJC.getHeadView().setDrawBorder(false);
            this.fJC.getHeadView().setDefaultResource(17170445);
            this.fJC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJC.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.fJC.getHeadView().setPlaceHolder(1);
        }
        this.fJC.setHasPendantStyle();
        if (this.fJC.getPendantView() != null) {
            this.fJC.getPendantView().setIsRound(true);
            this.fJC.getPendantView().setDrawBorder(false);
        }
        this.eNy = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.eNK = new NEGFeedBackView(this.mPageContext);
        this.eNK.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.KA = (TextView) view.findViewById(R.id.thread_abstract);
        this.fLo = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.fLo.setSubClickListener(this.Mw);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.eNz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNz.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.eNz.setOnClickListener(this);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setNeedAddPraiseIcon(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setShareVisible(true);
        this.eNz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buH() != null) {
                    t.this.buH().a(view2, t.this.fLJ);
                }
                if (t.this.fLJ != null && t.this.fLJ.cRg != null) {
                    l.zT(t.this.fLJ.cRg.getId());
                    t.this.cb(t.this.fLJ.cRg.getId());
                }
            }
        });
        this.eOl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.eOl.diU.setOnClickListener(this);
        this.eOl.diU.setNeedAddReplyIcon(true);
        this.eOl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.buH() != null) {
                    t.this.buH().a(view2, t.this.fLJ);
                }
                if (view2 != t.this.eOl.dih && t.this.fLJ != null && t.this.fLJ.cRg != null) {
                    l.zT(t.this.fLJ.cRg.getId());
                    t.this.cb(t.this.fLJ.cRg.getId());
                }
            }
        });
        this.fKa = view.findViewById(R.id.divider_line_above_praise);
        this.fLH = view.findViewById(R.id.card_divider_line);
        this.fLI = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.fLK = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.eNz.changeSelectStatus();
            }
        });
        this.eNz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void X(final bj bjVar) {
        if (this.fLK != null) {
            if (this.fLI == null || bjVar == null) {
                this.fLK.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTS) && this.fLI.getVisibility() != 0) {
                if (this.eNK != null && this.eNK.getVisibility() == 0 && (this.fLK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLK.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fLK.setLayoutParams(layoutParams);
                }
                this.fLK.setVisibility(0);
                this.fLK.setImageDrawable(null);
                this.fLK.startLoad(bjVar.cTS, 10, false);
                this.fLK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.cTT, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLK.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fKa, R.color.cp_bg_line_c);
            this.eNz.onChangeSkinType();
            this.eNy.onChangeSkinType();
            if (this.eNK != null) {
                this.eNK.onChangeSkinType();
            }
            this.fLo.onChangeSkinType();
            am.setBackgroundColor(this.fLH, R.color.cp_bg_line_e);
            this.eOl.onChangeSkinType();
        }
        if (this.fLJ != null && this.fLJ.cRg != null) {
            am.setBackgroundColor(this.mMaskView, this.fLJ.cRg.aDV() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.fJC != null && this.fJC.getHeadView() != null && (this.fJC.getHeadView() instanceof TbImageView)) {
            this.fJC.getHeadView().setPlaceHolder(1);
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
        if (bkVar == null || bkVar.cRg == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.fLJ = bkVar;
        bj bjVar = bkVar.cRg;
        if (this.eNK != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.fKe) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.eNK.setData(alVar);
                this.eNK.setFirstRowSingleColumn(true);
                this.eNK.setVisibility(Z(bjVar) ? 8 : 0);
            } else {
                this.eNK.setVisibility(8);
            }
        }
        if (this.fLJ.cUC == 1) {
            this.eNy.setFrom(3);
            b(bjVar);
            X(bjVar);
        }
        this.eNy.setIsFromConcern(this.djh);
        this.eNy.setData(bjVar);
        this.eNy.setUserAfterClickListener(this.Nw);
        if (this.eNy.getHeaderImg() != null) {
            if (this.eNy.getIsSimpleThread()) {
                this.eNy.getHeaderImg().setVisibility(8);
                this.fJC.setVisibility(8);
            } else if (bjVar.aCo() == null || bjVar.aCo().getPendantData() == null || StringUtils.isNull(bjVar.aCo().getPendantData().aAG())) {
                this.fJC.setVisibility(8);
                this.eNy.getHeaderImg().setVisibility(0);
                this.eNy.getHeaderImg().setData(bjVar);
            } else {
                this.eNy.getHeaderImg().setVisibility(4);
                this.fJC.setVisibility(0);
                this.fJC.setData(bjVar);
            }
        }
        Y(bjVar);
        this.fLo.b(bjVar.cTR);
        pB(oc(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cb(bjVar.getId());
        if (this.eNz.isInFrsAllThread() && com.baidu.tieba.frs.a.bCW().bCX()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTk)) {
                bjVar.cp(this.mUrl, this.cTk);
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
        if (this.eNK != null) {
            this.eNK.setUniqueId(bdUniqueId);
        }
        if (this.eNy != null) {
            this.eNy.setPageUniqueId(bdUniqueId);
        }
    }

    public void kq(boolean z) {
        if (this.fLH != null) {
            this.fLH.setVisibility(z ? 0 : 8);
        }
    }

    public void kl(boolean z) {
        this.fKe = z;
    }

    private void aMz() {
        if (this.fLJ != null && this.fLJ.cRg != null) {
            bj bjVar = this.fLJ.cRg;
            l.zT(bjVar.getId());
            cb(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.fLJ.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            l.zT(bjVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(String str) {
        l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        l.a(this.KA, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.fLo.setReadState(l.zU(str));
    }

    public void b(bj bjVar) {
        MetaData aCo;
        if (bjVar != null && this.fLI != null && (aCo = bjVar.aCo()) != null) {
            final ThemeCardInUserData themeCard = aCo.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fLI.setVisibility(8);
                return;
            }
            this.fLI.setVisibility(0);
            this.fLI.setImageBitmap(null);
            this.fLI.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            buH().a(view, this.fLJ);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aMz();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eNy != null) {
            return this.eNy.diD;
        }
        return null;
    }

    public View buM() {
        if (this.eNy != null) {
            return this.eNy.Nl;
        }
        return null;
    }

    public void pB(int i) {
        if (this.fLJ != null && this.fLJ.cRg != null) {
            if (i == 1) {
                this.eNz.setVisibility(8);
                this.eOl.setFrom(this.fLJ.cUB);
                this.eOl.setShareReportFrom(this.fLJ.cUC);
                this.eOl.setStType(this.fLJ.stType);
                this.eOl.setData(this.fLJ.cRg);
                this.eNy.fR(false);
                return;
            }
            this.eNz.setFrom(this.fLJ.cUB);
            this.eNz.setShareReportFrom(this.fLJ.cUC);
            this.eNz.setStType(this.fLJ.stType);
            this.eNz.setData(this.fLJ.cRg);
            this.eNz.setDisPraiseFrom(this.fLJ.cUD);
            this.eOl.setVisibility(8);
            this.eNy.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXG().ai(this.LC, i);
    }
}
