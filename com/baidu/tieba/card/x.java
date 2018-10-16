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
    private boolean aAb;
    private final View.OnClickListener aGk;
    private boolean aGm;
    private String aqw;
    private String bVS;
    private HeadPendantClickableView bWP;
    public ThreadSourceShareAndPraiseLayout bWS;
    public ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    private NEGFeedBackView bWq;
    private View cNl;
    private TextView cNm;
    private boolean cNo;
    private View cOS;
    private TbImageView cOT;
    private bc cOU;
    private TbImageView cOV;
    private OriginalThreadCardView.a cOW;
    public OriginalThreadCardView cOy;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bWq = null;
        this.aAb = true;
        this.cNo = true;
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.anO() != null) {
                    x.this.anO().a(view, x.this.cOU);
                }
            }
        };
        this.cOW = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cOU != null && x.this.cOU.threadData != null) {
                    if (x.this.anO() != null) {
                        x.this.anO().a(x.this.cOy, x.this.cOU);
                    }
                    String id = x.this.cOU.threadData.getId();
                    o.md(id);
                    x.this.mf(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bWP = (HeadPendantClickableView) view.findViewById(e.g.thread_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0175e.ds70));
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.thread_user_info_layout);
        this.bWq = new NEGFeedBackView(this.mPageContext);
        this.bWq.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.tbds16));
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cNm = (TextView) view.findViewById(e.g.thread_abstract);
        this.cOy = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.cOy.setSubClickListener(this.cOW);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_layout);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bWf.setOnClickListener(this);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.anO() != null) {
                    x.this.anO().a(view2, x.this.cOU);
                }
                if (x.this.cOU != null && x.this.cOU.threadData != null) {
                    o.md(x.this.cOU.threadData.getId());
                    x.this.mf(x.this.cOU.threadData.getId());
                }
            }
        });
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_transmit_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this);
        this.bWS.aFS.setNeedAddReplyIcon(true);
        this.bWS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.anO() != null) {
                    x.this.anO().a(view2, x.this.cOU);
                }
                if (view2 != x.this.bWS.aFR && x.this.cOU != null && x.this.cOU.threadData != null) {
                    o.md(x.this.cOU.threadData.getId());
                    x.this.mf(x.this.cOU.threadData.getId());
                }
            }
        });
        this.cNl = view.findViewById(e.g.divider_line_above_praise);
        this.cOS = view.findViewById(e.g.card_divider_line);
        this.cOT = (TbImageView) view.findViewById(e.g.thread_theme_card);
        this.cOV = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.bWf.changeSelectStatus();
            }
        });
        this.bWf.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void br(boolean z) {
                al.j(x.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
            }
        });
    }

    private void N(final bb bbVar) {
        if (this.cOV != null) {
            if (this.cOT == null || bbVar == null) {
                this.cOV.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arh) && this.cOT.getVisibility() != 0) {
                if (this.bWq != null && this.bWq.getVisibility() == 0 && (this.cOV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOV.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0175e.tbds106);
                    this.cOV.setLayoutParams(layoutParams);
                }
                this.cOV.setVisibility(0);
                this.cOV.setImageDrawable(null);
                this.cOV.startLoad(bbVar.arh, 10, false);
                this.cOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.ari, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cOV.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cNl, e.d.cp_bg_line_e);
            this.bWf.onChangeSkinType();
            this.bWe.onChangeSkinType();
            if (this.bWq != null) {
                this.bWq.onChangeSkinType();
            }
            this.cOy.onChangeSkinType();
            al.j(this.cOS, e.d.cp_bg_line_e);
            this.bWS.onChangeSkinType();
        }
        if (this.cOU != null && this.cOU.threadData != null) {
            al.j(this.mMaskView, this.cOU.threadData.zW() ? e.d.cp_bg_line_d : e.d.transparent);
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
        this.cOU = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.bWq != null) {
            SparseArray<String> xt = bbVar.xt();
            if (xt != null && xt.size() > 0 && this.cNo) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(xt);
                this.bWq.setData(ahVar);
                this.bWq.setFirstRowSingleColumn(true);
                this.bWq.setVisibility(P(bbVar) ? 8 : 0);
            } else {
                this.bWq.setVisibility(8);
            }
        }
        if (this.cOU.arx == 1) {
            this.bWe.setFrom(3);
            Q(bbVar);
            N(bbVar);
        }
        if (this.currentPageType == 15) {
            this.bWe.setFrom(5);
        }
        this.bWe.setIsFromConcern(this.aGm);
        this.bWe.setData(bbVar);
        this.bWe.setUserAfterClickListener(this.aGk);
        if (this.bWe.getHeaderImg() != null) {
            if (this.bWe.getIsSimpleThread()) {
                this.bWe.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (bbVar.yv() == null || bbVar.yv().getPendantData() == null || StringUtils.isNull(bbVar.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.bWe.getHeaderImg().setVisibility(0);
                this.bWe.getHeaderImg().setData(bbVar);
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(bbVar);
            }
        }
        O(bbVar);
        this.cOy.b(bbVar.arg);
        ik(hb(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        mf(bbVar.getId());
        if (this.bWf.isInFrsAllThread() && com.baidu.tieba.frs.a.ayM().ayN()) {
            this.mMaskView.setVisibility(0);
            if (bbVar.zW() || bbVar.zX()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.aqw)) {
                bbVar.ai(this.mUrl, this.aqw);
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
        if (bbVar == null || bbVar.yv() == null || StringUtils.isNull(bbVar.yv().getUserId())) {
            return false;
        }
        return bbVar.yv().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bWq != null) {
            this.bWq.setUniqueId(bdUniqueId);
        }
        if (this.bWe != null) {
            this.bWe.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bWq != null) {
            this.bWq.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout aaX() {
        return this.bWf;
    }

    public ThreadCommentAndPraiseInfoLayout aaY() {
        return this.bWS.aFS;
    }

    public void fi(boolean z) {
        if (this.cOS != null) {
            this.cOS.setVisibility(z ? 0 : 8);
        }
    }

    public void fe(boolean z) {
        this.cNo = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aGm = z;
    }

    private void aoi() {
        if (this.cOU != null && this.cOU.threadData != null) {
            bb bbVar = this.cOU.threadData;
            o.md(bbVar.getId());
            mf(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.cOU.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.md(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(String str) {
        o.a(this.mTitle, str, e.d.cp_cont_b, e.d.cp_cont_d);
        o.a(this.cNm, str, e.d.cp_cont_b, e.d.cp_cont_d);
        this.cOy.setReadState(o.me(str));
    }

    public void Q(bb bbVar) {
        MetaData yv;
        if (bbVar != null && this.cOT != null && (yv = bbVar.yv()) != null) {
            final ThemeCardInUserData themeCard = yv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cOT.setVisibility(8);
                return;
            }
            this.cOT.setVisibility(0);
            this.cOT.setImageBitmap(null);
            this.cOT.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cOT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anO() != null) {
            anO().a(view, this.cOU);
        }
        if (view == getView()) {
            aoi();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWe != null) {
            return this.bWe.aFX;
        }
        return null;
    }

    public View anR() {
        if (this.bWe != null) {
            return this.bWe.aFZ;
        }
        return null;
    }

    public void ik(int i) {
        if (this.cOU != null && this.cOU.threadData != null) {
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setFrom(this.cOU.arw);
                this.bWS.setShareReportFrom(this.cOU.arx);
                this.bWS.setStType(this.cOU.stType);
                this.bWS.setData(this.cOU.threadData);
                this.bWe.showForumNameView(false);
                return;
            }
            this.bWf.setFrom(this.cOU.arw);
            this.bWf.setShareReportFrom(this.cOU.arx);
            this.bWf.setStType(this.cOU.stType);
            this.bWf.setData(this.cOU.threadData);
            this.bWf.setDisPraiseFrom(this.cOU.arz);
            this.bWS.setVisibility(8);
            this.bWe.showForumNameView(true);
        }
    }

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.aqw = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }
}
