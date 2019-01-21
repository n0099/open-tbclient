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
    private boolean aEU;
    private final View.OnClickListener aLf;
    private boolean aLh;
    private String avm;
    private View cYA;
    private TextView cYB;
    private boolean cYD;
    public OriginalThreadCardView cZN;
    private NEGFeedBackView cbJ;
    private String cbl;
    public ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    public ThreadSourceShareAndPraiseLayout ccl;
    private View dah;
    private TbImageView dai;
    private bc daj;
    private TbImageView dak;
    private OriginalThreadCardView.a dal;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbJ = null;
        this.aEU = true;
        this.cYD = true;
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.aqp() != null) {
                    x.this.aqp().a(view, x.this.daj);
                }
            }
        };
        this.dal = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.daj != null && x.this.daj.threadData != null) {
                    if (x.this.aqp() != null) {
                        x.this.aqp().a(x.this.cZN, x.this.daj);
                    }
                    String id = x.this.daj.threadData.getId();
                    o.mW(id);
                    x.this.mY(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cci = (HeadPendantClickableView) view.findViewById(e.g.thread_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.thread_user_info_layout);
        this.cbJ = new NEGFeedBackView(this.mPageContext);
        this.cbJ.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cYB = (TextView) view.findViewById(e.g.thread_abstract);
        this.cZN = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.cZN.setSubClickListener(this.dal);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_layout);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.cby.setOnClickListener(this);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aqp() != null) {
                    x.this.aqp().a(view2, x.this.daj);
                }
                if (x.this.daj != null && x.this.daj.threadData != null) {
                    o.mW(x.this.daj.threadData.getId());
                    x.this.mY(x.this.daj.threadData.getId());
                }
            }
        });
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_transmit_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this);
        this.ccl.aKN.setNeedAddReplyIcon(true);
        this.ccl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aqp() != null) {
                    x.this.aqp().a(view2, x.this.daj);
                }
                if (view2 != x.this.ccl.aKM && x.this.daj != null && x.this.daj.threadData != null) {
                    o.mW(x.this.daj.threadData.getId());
                    x.this.mY(x.this.daj.threadData.getId());
                }
            }
        });
        this.cYA = view.findViewById(e.g.divider_line_above_praise);
        this.dah = view.findViewById(e.g.card_divider_line);
        this.dai = (TbImageView) view.findViewById(e.g.thread_theme_card);
        this.dak = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.cby.changeSelectStatus();
            }
        });
        this.cby.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bK(boolean z) {
                al.j(x.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
            }
        });
    }

    private void N(final bb bbVar) {
        if (this.dak != null) {
            if (this.dai == null || bbVar == null) {
                this.dak.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avX) && this.dai.getVisibility() != 0) {
                if (this.cbJ != null && this.cbJ.getVisibility() == 0 && (this.dak.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dak.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.dak.setLayoutParams(layoutParams);
                }
                this.dak.setVisibility(0);
                this.dak.setImageDrawable(null);
                this.dak.startLoad(bbVar.avX, 10, false);
                this.dak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.avY, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.dak.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cYA, e.d.cp_bg_line_e);
            this.cby.onChangeSkinType();
            this.cbx.onChangeSkinType();
            if (this.cbJ != null) {
                this.cbJ.onChangeSkinType();
            }
            this.cZN.onChangeSkinType();
            al.j(this.dah, e.d.cp_bg_line_e);
            this.ccl.onChangeSkinType();
        }
        if (this.daj != null && this.daj.threadData != null) {
            al.j(this.mMaskView, this.daj.threadData.Bu() ? e.d.cp_bg_line_d : e.d.transparent);
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
        this.daj = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.cbJ != null) {
            SparseArray<String> yS = bbVar.yS();
            if (yS != null && yS.size() > 0 && this.cYD) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(yS);
                this.cbJ.setData(ahVar);
                this.cbJ.setFirstRowSingleColumn(true);
                this.cbJ.setVisibility(P(bbVar) ? 8 : 0);
            } else {
                this.cbJ.setVisibility(8);
            }
        }
        if (this.daj.awo == 1) {
            this.cbx.setFrom(3);
            Q(bbVar);
            N(bbVar);
        }
        if (this.currentPageType == 15) {
            this.cbx.setFrom(5);
        }
        this.cbx.setIsFromConcern(this.aLh);
        this.cbx.setData(bbVar);
        this.cbx.setUserAfterClickListener(this.aLf);
        if (this.cbx.getHeaderImg() != null) {
            if (this.cbx.getIsSimpleThread()) {
                this.cbx.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (bbVar.zT() == null || bbVar.zT().getPendantData() == null || StringUtils.isNull(bbVar.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.cbx.getHeaderImg().setVisibility(0);
                this.cbx.getHeaderImg().setData(bbVar);
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(bbVar);
            }
        }
        O(bbVar);
        this.cZN.b(bbVar.avW);
        iM(hD(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        mY(bbVar.getId());
        if (this.cby.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.avm)) {
                bbVar.am(this.mUrl, this.avm);
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
        if (this.cbJ != null) {
            this.cbJ.setUniqueId(bdUniqueId);
        }
        if (this.cbx != null) {
            this.cbx.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbJ != null) {
            this.cbJ.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cby;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        return this.ccl.aKN;
    }

    public void fz(boolean z) {
        if (this.dah != null) {
            this.dah.setVisibility(z ? 0 : 8);
        }
    }

    public void fv(boolean z) {
        this.cYD = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aLh = z;
    }

    private void aqJ() {
        if (this.daj != null && this.daj.threadData != null) {
            bb bbVar = this.daj.threadData;
            o.mW(bbVar.getId());
            mY(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.daj.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.mW(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(String str) {
        o.a(this.mTitle, str, e.d.cp_cont_b, e.d.cp_cont_d);
        o.a(this.cYB, str, e.d.cp_cont_b, e.d.cp_cont_d);
        this.cZN.setReadState(o.mX(str));
    }

    public void Q(bb bbVar) {
        MetaData zT;
        if (bbVar != null && this.dai != null && (zT = bbVar.zT()) != null) {
            final ThemeCardInUserData themeCard = zT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dai.setVisibility(8);
                return;
            }
            this.dai.setVisibility(0);
            this.dai.setImageBitmap(null);
            this.dai.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.dai.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
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
            aqp().a(view, this.daj);
        }
        if (view == getView()) {
            aqJ();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbx != null) {
            return this.cbx.aKS;
        }
        return null;
    }

    public View aqs() {
        if (this.cbx != null) {
            return this.cbx.aKU;
        }
        return null;
    }

    public void iM(int i) {
        if (this.daj != null && this.daj.threadData != null) {
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setFrom(this.daj.awn);
                this.ccl.setShareReportFrom(this.daj.awo);
                this.ccl.setStType(this.daj.stType);
                this.ccl.setData(this.daj.threadData);
                this.cbx.showForumNameView(false);
                return;
            }
            this.cby.setFrom(this.daj.awn);
            this.cby.setShareReportFrom(this.daj.awo);
            this.cby.setStType(this.daj.stType);
            this.cby.setData(this.daj.threadData);
            this.cby.setDisPraiseFrom(this.daj.awq);
            this.ccl.setVisibility(8);
            this.cbx.showForumNameView(true);
        }
    }

    public void am(String str, String str2) {
        this.mUrl = str;
        this.avm = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    public void kL(int i) {
        if (this.cby != null) {
            this.cby.aKg = String.valueOf(i);
        }
    }
}
