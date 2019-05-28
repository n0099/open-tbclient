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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes3.dex */
public class v extends a<bh> implements com.baidu.tieba.a.e {
    private TextView VC;
    private String Wt;
    private final View.OnClickListener XA;
    private boolean XJ;
    private OriginalThreadCardView.a Xc;
    private String bKa;
    private boolean cbH;
    public ThreadSourceShareAndPraiseLayout dBT;
    public ThreadUserInfoLayout dBe;
    public ThreadCommentAndPraiseInfoLayout dBf;
    private NEGFeedBackView dBq;
    private View exM;
    private boolean exQ;
    private HeadPendantClickableView exl;
    private ViewGroup ezA;
    public OriginalThreadCardView ezc;
    private View ezw;
    private TbImageView ezx;
    private bh ezy;
    private TbImageView ezz;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dBq = null;
        this.XJ = true;
        this.exQ = true;
        this.XA = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aXr() != null) {
                    v.this.aXr().a(view, v.this.ezy);
                }
            }
        };
        this.Xc = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.ezy != null && v.this.ezy.threadData != null) {
                    if (v.this.aXr() != null) {
                        v.this.aXr().a(v.this.ezc, v.this.ezy);
                    }
                    String id = v.this.ezy.threadData.getId();
                    n.uS(id);
                    v.this.ce(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ezA = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.ezA.setOnClickListener(this);
        this.exl = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.exl.getHeadView() != null) {
            this.exl.getHeadView().setIsRound(true);
            this.exl.getHeadView().setDrawBorder(false);
            this.exl.getHeadView().setDefaultResource(17170445);
            this.exl.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exl.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.exl.setHasPendantStyle();
        if (this.exl.getPendantView() != null) {
            this.exl.getPendantView().setIsRound(true);
            this.exl.getPendantView().setDrawBorder(false);
        }
        this.dBe = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.dBq = new NEGFeedBackView(this.mPageContext);
        this.dBq.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.VC = (TextView) view.findViewById(R.id.thread_abstract);
        this.ezc = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.ezc.setSubClickListener(this.Xc);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.dBf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBf.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dBf.setOnClickListener(this);
        this.dBf.setReplyTimeVisible(false);
        this.dBf.setShowPraiseNum(true);
        this.dBf.setNeedAddPraiseIcon(true);
        this.dBf.setNeedAddReplyIcon(true);
        this.dBf.setShareVisible(true);
        this.dBf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aXr() != null) {
                    v.this.aXr().a(view2, v.this.ezy);
                }
                if (v.this.ezy != null && v.this.ezy.threadData != null) {
                    n.uS(v.this.ezy.threadData.getId());
                    v.this.ce(v.this.ezy.threadData.getId());
                }
            }
        });
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.dBT.cbw.setOnClickListener(this);
        this.dBT.cbw.setNeedAddReplyIcon(true);
        this.dBT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aXr() != null) {
                    v.this.aXr().a(view2, v.this.ezy);
                }
                if (view2 != v.this.dBT.caL && v.this.ezy != null && v.this.ezy.threadData != null) {
                    n.uS(v.this.ezy.threadData.getId());
                    v.this.ce(v.this.ezy.threadData.getId());
                }
            }
        });
        this.exM = view.findViewById(R.id.divider_line_above_praise);
        this.ezw = view.findViewById(R.id.card_divider_line);
        this.ezx = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.ezz = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dBf.changeSelectStatus();
            }
        });
        this.dBf.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eq(boolean z) {
                al.l(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void R(final bg bgVar) {
        if (this.ezz != null) {
            if (this.ezx == null || bgVar == null) {
                this.ezz.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bKQ) && this.ezx.getVisibility() != 0) {
                if (this.dBq != null && this.dBq.getVisibility() == 0 && (this.ezz.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ezz.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ezz.setLayoutParams(layoutParams);
                }
                this.ezz.setVisibility(0);
                this.ezz.setImageDrawable(null);
                this.ezz.startLoad(bgVar.bKQ, 10, false);
                this.ezz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bgVar.bKR, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ezz.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.addresslist_item_bg);
            al.l(this.exM, R.color.cp_bg_line_e);
            this.dBf.onChangeSkinType();
            this.dBe.onChangeSkinType();
            if (this.dBq != null) {
                this.dBq.onChangeSkinType();
            }
            this.ezc.onChangeSkinType();
            al.l(this.ezw, R.color.cp_bg_line_e);
            this.dBT.onChangeSkinType();
        }
        if (this.ezy != null && this.ezy.threadData != null) {
            al.l(this.mMaskView, this.ezy.threadData.afe() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.exl != null && this.exl.getHeadView() != null && (this.exl.getHeadView() instanceof TbImageView)) {
            this.exl.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null || bhVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.ezy = bhVar;
        bg bgVar = bhVar.threadData;
        if (this.dBq != null) {
            SparseArray<String> ace = bgVar.ace();
            if (ace != null && ace.size() > 0 && this.exQ) {
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(ace);
                this.dBq.setData(ajVar);
                this.dBq.setFirstRowSingleColumn(true);
                this.dBq.setVisibility(T(bgVar) ? 8 : 0);
            } else {
                this.dBq.setVisibility(8);
            }
        }
        if (this.ezy.bLs == 1) {
            this.dBe.setFrom(3);
            b(bgVar);
            R(bgVar);
        }
        if (this.currentPageType == 15) {
            this.dBe.setFrom(5);
        }
        this.dBe.setIsFromConcern(this.cbH);
        this.dBe.setData(bgVar);
        this.dBe.setUserAfterClickListener(this.XA);
        if (this.dBe.getHeaderImg() != null) {
            if (this.dBe.getIsSimpleThread()) {
                this.dBe.getHeaderImg().setVisibility(8);
                this.exl.setVisibility(8);
            } else if (bgVar.adv() == null || bgVar.adv().getPendantData() == null || StringUtils.isNull(bgVar.adv().getPendantData().abS())) {
                this.exl.setVisibility(8);
                this.dBe.getHeaderImg().setVisibility(0);
                this.dBe.getHeaderImg().setData(bgVar);
            } else {
                this.dBe.getHeaderImg().setVisibility(4);
                this.exl.setVisibility(0);
                this.exl.setData(bgVar);
            }
        }
        S(bgVar);
        this.ezc.b(bgVar.bKP);
        nv(mh(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        ce(bgVar.getId());
        if (this.dBf.isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.mMaskView.setVisibility(0);
            if (bgVar.afe() || bgVar.aff()) {
                al.l(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void S(bg bgVar) {
        if (bgVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bKa)) {
                bgVar.bC(this.mUrl, this.bKa);
            }
            SpannableStringBuilder m = bgVar.m(false, true);
            if (m == null || StringUtils.isNull(m.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean T(bg bgVar) {
        if (bgVar == null || bgVar.adv() == null || StringUtils.isNull(bgVar.adv().getUserId())) {
            return false;
        }
        return bgVar.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dBq != null) {
            this.dBq.setUniqueId(bdUniqueId);
        }
        if (this.dBe != null) {
            this.dBe.setPageUniqueId(bdUniqueId);
        }
    }

    public void iw(boolean z) {
        if (this.ezw != null) {
            this.ezw.setVisibility(z ? 0 : 8);
        }
    }

    public void is(boolean z) {
        this.exQ = z;
    }

    private void aoV() {
        if (this.ezy != null && this.ezy.threadData != null) {
            bg bgVar = this.ezy.threadData;
            n.uS(bgVar.getId());
            ce(bgVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bgVar, null, this.ezy.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.uS(bgVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(String str) {
        n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(this.VC, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.ezc.setReadState(n.uT(str));
    }

    public void b(bg bgVar) {
        MetaData adv;
        if (bgVar != null && this.ezx != null && (adv = bgVar.adv()) != null) {
            final ThemeCardInUserData themeCard = adv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ezx.setVisibility(8);
                return;
            }
            this.ezx.setVisibility(0);
            this.ezx.setImageBitmap(null);
            this.ezx.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ezx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXr() != null) {
            aXr().a(view, this.ezy);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aoV();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dBe != null) {
            return this.dBe.cbe;
        }
        return null;
    }

    public View aXw() {
        if (this.dBe != null) {
            return this.dBe.Xr;
        }
        return null;
    }

    public void nv(int i) {
        if (this.ezy != null && this.ezy.threadData != null) {
            if (i == 1) {
                this.dBf.setVisibility(8);
                this.dBT.setFrom(this.ezy.bLr);
                this.dBT.setShareReportFrom(this.ezy.bLs);
                this.dBT.setStType(this.ezy.stType);
                this.dBT.setData(this.ezy.threadData);
                this.dBe.ej(false);
                return;
            }
            this.dBf.setFrom(this.ezy.bLr);
            this.dBf.setShareReportFrom(this.ezy.bLs);
            this.dBf.setStType(this.ezy.stType);
            this.dBf.setData(this.ezy.threadData);
            this.dBf.setDisPraiseFrom(this.ezy.bLt);
            this.dBT.setVisibility(8);
            this.dBe.ej(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Wt, i);
    }
}
