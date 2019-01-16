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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class x extends a<bc> implements com.baidu.tieba.a.e {
    private boolean aET;
    private final View.OnClickListener aLe;
    private boolean aLg;
    private String avl;
    private TextView cYA;
    private boolean cYC;
    private View cYz;
    public OriginalThreadCardView cZM;
    private NEGFeedBackView cbI;
    private String cbk;
    public ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    public ThreadSourceShareAndPraiseLayout cck;
    private View dag;
    private TbImageView dah;
    private bc dai;
    private TbImageView daj;
    private OriginalThreadCardView.a dak;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbI = null;
        this.aET = true;
        this.cYC = true;
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.aqp() != null) {
                    x.this.aqp().a(view, x.this.dai);
                }
            }
        };
        this.dak = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.dai != null && x.this.dai.threadData != null) {
                    if (x.this.aqp() != null) {
                        x.this.aqp().a(x.this.cZM, x.this.dai);
                    }
                    String id = x.this.dai.threadData.getId();
                    o.mW(id);
                    x.this.mY(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cch = (HeadPendantClickableView) view.findViewById(e.g.thread_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.thread_user_info_layout);
        this.cbI = new NEGFeedBackView(this.mPageContext);
        this.cbI.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cYA = (TextView) view.findViewById(e.g.thread_abstract);
        this.cZM = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.cZM.setSubClickListener(this.dak);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_layout);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.cbx.setOnClickListener(this);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aqp() != null) {
                    x.this.aqp().a(view2, x.this.dai);
                }
                if (x.this.dai != null && x.this.dai.threadData != null) {
                    o.mW(x.this.dai.threadData.getId());
                    x.this.mY(x.this.dai.threadData.getId());
                }
            }
        });
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_transmit_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this);
        this.cck.aKM.setNeedAddReplyIcon(true);
        this.cck.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aqp() != null) {
                    x.this.aqp().a(view2, x.this.dai);
                }
                if (view2 != x.this.cck.aKL && x.this.dai != null && x.this.dai.threadData != null) {
                    o.mW(x.this.dai.threadData.getId());
                    x.this.mY(x.this.dai.threadData.getId());
                }
            }
        });
        this.cYz = view.findViewById(e.g.divider_line_above_praise);
        this.dag = view.findViewById(e.g.card_divider_line);
        this.dah = (TbImageView) view.findViewById(e.g.thread_theme_card);
        this.daj = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.cbx.changeSelectStatus();
            }
        });
        this.cbx.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bK(boolean z) {
                al.j(x.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
            }
        });
    }

    private void N(final bb bbVar) {
        if (this.daj != null) {
            if (this.dah == null || bbVar == null) {
                this.daj.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avW) && this.dah.getVisibility() != 0) {
                if (this.cbI != null && this.cbI.getVisibility() == 0 && (this.daj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daj.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.daj.setLayoutParams(layoutParams);
                }
                this.daj.setVisibility(0);
                this.daj.setImageDrawable(null);
                this.daj.startLoad(bbVar.avW, 10, false);
                this.daj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.avX, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.daj.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cYz, e.d.cp_bg_line_e);
            this.cbx.onChangeSkinType();
            this.cbw.onChangeSkinType();
            if (this.cbI != null) {
                this.cbI.onChangeSkinType();
            }
            this.cZM.onChangeSkinType();
            al.j(this.dag, e.d.cp_bg_line_e);
            this.cck.onChangeSkinType();
        }
        if (this.dai != null && this.dai.threadData != null) {
            al.j(this.mMaskView, this.dai.threadData.Bu() ? e.d.cp_bg_line_d : e.d.transparent);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bc bcVar) {
        if (bcVar == null || bcVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.dai = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.cbI != null) {
            SparseArray<String> yS = bbVar.yS();
            if (yS != null && yS.size() > 0 && this.cYC) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(yS);
                this.cbI.setData(ahVar);
                this.cbI.setFirstRowSingleColumn(true);
                this.cbI.setVisibility(P(bbVar) ? 8 : 0);
            } else {
                this.cbI.setVisibility(8);
            }
        }
        if (this.dai.awn == 1) {
            this.cbw.setFrom(3);
            Q(bbVar);
            N(bbVar);
        }
        if (this.currentPageType == 15) {
            this.cbw.setFrom(5);
        }
        this.cbw.setIsFromConcern(this.aLg);
        this.cbw.setData(bbVar);
        this.cbw.setUserAfterClickListener(this.aLe);
        if (this.cbw.getHeaderImg() != null) {
            if (this.cbw.getIsSimpleThread()) {
                this.cbw.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (bbVar.zT() == null || bbVar.zT().getPendantData() == null || StringUtils.isNull(bbVar.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.cbw.getHeaderImg().setVisibility(0);
                this.cbw.getHeaderImg().setData(bbVar);
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(bbVar);
            }
        }
        O(bbVar);
        this.cZM.b(bbVar.avV);
        iM(hD(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        mY(bbVar.getId());
        if (this.cbx.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.mMaskView.setVisibility(0);
            if (bbVar.Bu() || bbVar.Bv()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void O(bb bbVar) {
        if (bbVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.avl)) {
                bbVar.am(this.mUrl, this.avl);
            }
            SpannableStringBuilder i = bbVar.i(false, true);
            if (i == null || StringUtils.isNull(i.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private boolean P(bb bbVar) {
        if (bbVar == null || bbVar.zT() == null || StringUtils.isNull(bbVar.zT().getUserId())) {
            return false;
        }
        return bbVar.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cbI != null) {
            this.cbI.setUniqueId(bdUniqueId);
        }
        if (this.cbw != null) {
            this.cbw.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbI != null) {
            this.cbI.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cbx;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        return this.cck.aKM;
    }

    public void fz(boolean z) {
        if (this.dag != null) {
            this.dag.setVisibility(z ? 0 : 8);
        }
    }

    public void fv(boolean z) {
        this.cYC = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aLg = z;
    }

    private void aqJ() {
        if (this.dai != null && this.dai.threadData != null) {
            bb bbVar = this.dai.threadData;
            o.mW(bbVar.getId());
            mY(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.dai.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.mW(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(String str) {
        o.a(this.mTitle, str, e.d.cp_cont_b, e.d.cp_cont_d);
        o.a(this.cYA, str, e.d.cp_cont_b, e.d.cp_cont_d);
        this.cZM.setReadState(o.mX(str));
    }

    public void Q(bb bbVar) {
        MetaData zT;
        if (bbVar != null && this.dah != null && (zT = bbVar.zT()) != null) {
            final ThemeCardInUserData themeCard = zT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dah.setVisibility(8);
                return;
            }
            this.dah.setVisibility(0);
            this.dah.setImageBitmap(null);
            this.dah.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.dah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aqp() != null) {
            aqp().a(view, this.dai);
        }
        if (view == getView()) {
            aqJ();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbw != null) {
            return this.cbw.aKR;
        }
        return null;
    }

    public View aqs() {
        if (this.cbw != null) {
            return this.cbw.aKT;
        }
        return null;
    }

    public void iM(int i) {
        if (this.dai != null && this.dai.threadData != null) {
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setFrom(this.dai.awm);
                this.cck.setShareReportFrom(this.dai.awn);
                this.cck.setStType(this.dai.stType);
                this.cck.setData(this.dai.threadData);
                this.cbw.showForumNameView(false);
                return;
            }
            this.cbx.setFrom(this.dai.awm);
            this.cbx.setShareReportFrom(this.dai.awn);
            this.cbx.setStType(this.dai.stType);
            this.cbx.setData(this.dai.threadData);
            this.cbx.setDisPraiseFrom(this.dai.awp);
            this.cck.setVisibility(8);
            this.cbw.showForumNameView(true);
        }
    }

    public void am(String str, String str2) {
        this.mUrl = str;
        this.avl = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    public void kL(int i) {
        if (this.cbx != null) {
            this.cbx.aKf = String.valueOf(i);
        }
    }
}
