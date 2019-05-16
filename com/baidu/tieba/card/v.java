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
    public ThreadSourceShareAndPraiseLayout dBS;
    public ThreadUserInfoLayout dBd;
    public ThreadCommentAndPraiseInfoLayout dBe;
    private NEGFeedBackView dBp;
    private View exL;
    private boolean exP;
    private HeadPendantClickableView exk;
    public OriginalThreadCardView ezb;
    private View ezv;
    private TbImageView ezw;
    private bh ezx;
    private TbImageView ezy;
    private ViewGroup ezz;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dBp = null;
        this.XJ = true;
        this.exP = true;
        this.XA = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aXo() != null) {
                    v.this.aXo().a(view, v.this.ezx);
                }
            }
        };
        this.Xc = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.ezx != null && v.this.ezx.threadData != null) {
                    if (v.this.aXo() != null) {
                        v.this.aXo().a(v.this.ezb, v.this.ezx);
                    }
                    String id = v.this.ezx.threadData.getId();
                    n.uS(id);
                    v.this.ce(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ezz = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.ezz.setOnClickListener(this);
        this.exk = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.exk.getHeadView() != null) {
            this.exk.getHeadView().setIsRound(true);
            this.exk.getHeadView().setDrawBorder(false);
            this.exk.getHeadView().setDefaultResource(17170445);
            this.exk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exk.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.exk.setHasPendantStyle();
        if (this.exk.getPendantView() != null) {
            this.exk.getPendantView().setIsRound(true);
            this.exk.getPendantView().setDrawBorder(false);
        }
        this.dBd = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.dBp = new NEGFeedBackView(this.mPageContext);
        this.dBp.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.VC = (TextView) view.findViewById(R.id.thread_abstract);
        this.ezb = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.ezb.setSubClickListener(this.Xc);
        this.dBe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.dBe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBe.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dBe.setOnClickListener(this);
        this.dBe.setReplyTimeVisible(false);
        this.dBe.setShowPraiseNum(true);
        this.dBe.setNeedAddPraiseIcon(true);
        this.dBe.setNeedAddReplyIcon(true);
        this.dBe.setShareVisible(true);
        this.dBe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aXo() != null) {
                    v.this.aXo().a(view2, v.this.ezx);
                }
                if (v.this.ezx != null && v.this.ezx.threadData != null) {
                    n.uS(v.this.ezx.threadData.getId());
                    v.this.ce(v.this.ezx.threadData.getId());
                }
            }
        });
        this.dBS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.dBS.cbw.setOnClickListener(this);
        this.dBS.cbw.setNeedAddReplyIcon(true);
        this.dBS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aXo() != null) {
                    v.this.aXo().a(view2, v.this.ezx);
                }
                if (view2 != v.this.dBS.caL && v.this.ezx != null && v.this.ezx.threadData != null) {
                    n.uS(v.this.ezx.threadData.getId());
                    v.this.ce(v.this.ezx.threadData.getId());
                }
            }
        });
        this.exL = view.findViewById(R.id.divider_line_above_praise);
        this.ezv = view.findViewById(R.id.card_divider_line);
        this.ezw = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.ezy = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dBe.changeSelectStatus();
            }
        });
        this.dBe.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eq(boolean z) {
                al.l(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void R(final bg bgVar) {
        if (this.ezy != null) {
            if (this.ezw == null || bgVar == null) {
                this.ezy.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bKQ) && this.ezw.getVisibility() != 0) {
                if (this.dBp != null && this.dBp.getVisibility() == 0 && (this.ezy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ezy.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ezy.setLayoutParams(layoutParams);
                }
                this.ezy.setVisibility(0);
                this.ezy.setImageDrawable(null);
                this.ezy.startLoad(bgVar.bKQ, 10, false);
                this.ezy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bgVar.bKR, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ezy.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.addresslist_item_bg);
            al.l(this.exL, R.color.cp_bg_line_e);
            this.dBe.onChangeSkinType();
            this.dBd.onChangeSkinType();
            if (this.dBp != null) {
                this.dBp.onChangeSkinType();
            }
            this.ezb.onChangeSkinType();
            al.l(this.ezv, R.color.cp_bg_line_e);
            this.dBS.onChangeSkinType();
        }
        if (this.ezx != null && this.ezx.threadData != null) {
            al.l(this.mMaskView, this.ezx.threadData.afe() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.exk != null && this.exk.getHeadView() != null && (this.exk.getHeadView() instanceof TbImageView)) {
            this.exk.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.ezx = bhVar;
        bg bgVar = bhVar.threadData;
        if (this.dBp != null) {
            SparseArray<String> ace = bgVar.ace();
            if (ace != null && ace.size() > 0 && this.exP) {
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(ace);
                this.dBp.setData(ajVar);
                this.dBp.setFirstRowSingleColumn(true);
                this.dBp.setVisibility(T(bgVar) ? 8 : 0);
            } else {
                this.dBp.setVisibility(8);
            }
        }
        if (this.ezx.bLs == 1) {
            this.dBd.setFrom(3);
            b(bgVar);
            R(bgVar);
        }
        if (this.currentPageType == 15) {
            this.dBd.setFrom(5);
        }
        this.dBd.setIsFromConcern(this.cbH);
        this.dBd.setData(bgVar);
        this.dBd.setUserAfterClickListener(this.XA);
        if (this.dBd.getHeaderImg() != null) {
            if (this.dBd.getIsSimpleThread()) {
                this.dBd.getHeaderImg().setVisibility(8);
                this.exk.setVisibility(8);
            } else if (bgVar.adv() == null || bgVar.adv().getPendantData() == null || StringUtils.isNull(bgVar.adv().getPendantData().abS())) {
                this.exk.setVisibility(8);
                this.dBd.getHeaderImg().setVisibility(0);
                this.dBd.getHeaderImg().setData(bgVar);
            } else {
                this.dBd.getHeaderImg().setVisibility(4);
                this.exk.setVisibility(0);
                this.exk.setData(bgVar);
            }
        }
        S(bgVar);
        this.ezb.b(bgVar.bKP);
        nv(mh(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        ce(bgVar.getId());
        if (this.dBe.isInFrsAllThread() && com.baidu.tieba.frs.a.biT().biU()) {
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
        if (this.dBp != null) {
            this.dBp.setUniqueId(bdUniqueId);
        }
        if (this.dBd != null) {
            this.dBd.setPageUniqueId(bdUniqueId);
        }
    }

    public void iw(boolean z) {
        if (this.ezv != null) {
            this.ezv.setVisibility(z ? 0 : 8);
        }
    }

    public void is(boolean z) {
        this.exP = z;
    }

    private void aoV() {
        if (this.ezx != null && this.ezx.threadData != null) {
            bg bgVar = this.ezx.threadData;
            n.uS(bgVar.getId());
            ce(bgVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bgVar, null, this.ezx.stType, 18003, true, false, false);
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
        this.ezb.setReadState(n.uT(str));
    }

    public void b(bg bgVar) {
        MetaData adv;
        if (bgVar != null && this.ezw != null && (adv = bgVar.adv()) != null) {
            final ThemeCardInUserData themeCard = adv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ezw.setVisibility(8);
                return;
            }
            this.ezw.setVisibility(0);
            this.ezw.setImageBitmap(null);
            this.ezw.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ezw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXo() != null) {
            aXo().a(view, this.ezx);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aoV();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dBd != null) {
            return this.dBd.cbe;
        }
        return null;
    }

    public View aXt() {
        if (this.dBd != null) {
            return this.dBd.Xr;
        }
        return null;
    }

    public void nv(int i) {
        if (this.ezx != null && this.ezx.threadData != null) {
            if (i == 1) {
                this.dBe.setVisibility(8);
                this.dBS.setFrom(this.ezx.bLr);
                this.dBS.setShareReportFrom(this.ezx.bLs);
                this.dBS.setStType(this.ezx.stType);
                this.dBS.setData(this.ezx.threadData);
                this.dBd.ej(false);
                return;
            }
            this.dBe.setFrom(this.ezx.bLr);
            this.dBe.setShareReportFrom(this.ezx.bLs);
            this.dBe.setStType(this.ezx.stType);
            this.dBe.setData(this.ezx.threadData);
            this.dBe.setDisPraiseFrom(this.ezx.bLt);
            this.dBS.setVisibility(8);
            this.dBd.ej(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBn().ag(this.Wt, i);
    }
}
