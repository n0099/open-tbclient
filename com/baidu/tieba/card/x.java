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
    private boolean aEr;
    private final View.OnClickListener aKC;
    private boolean aKE;
    private String auJ;
    private View cXO;
    private TextView cXP;
    private boolean cXR;
    public OriginalThreadCardView cZb;
    private View cZv;
    private TbImageView cZw;
    private bc cZx;
    private TbImageView cZy;
    private OriginalThreadCardView.a cZz;
    public ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    private NEGFeedBackView caX;
    private String caz;
    private HeadPendantClickableView cbw;
    public ThreadSourceShareAndPraiseLayout cbz;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caX = null;
        this.aEr = true;
        this.cXR = true;
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.apS() != null) {
                    x.this.apS().a(view, x.this.cZx);
                }
            }
        };
        this.cZz = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cZx != null && x.this.cZx.threadData != null) {
                    if (x.this.apS() != null) {
                        x.this.apS().a(x.this.cZb, x.this.cZx);
                    }
                    String id = x.this.cZx.threadData.getId();
                    o.mG(id);
                    x.this.mI(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cbw = (HeadPendantClickableView) view.findViewById(e.g.thread_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.thread_user_info_layout);
        this.caX = new NEGFeedBackView(this.mPageContext);
        this.caX.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cXP = (TextView) view.findViewById(e.g.thread_abstract);
        this.cZb = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.cZb.setSubClickListener(this.cZz);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_layout);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.caM.setOnClickListener(this);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.apS() != null) {
                    x.this.apS().a(view2, x.this.cZx);
                }
                if (x.this.cZx != null && x.this.cZx.threadData != null) {
                    o.mG(x.this.cZx.threadData.getId());
                    x.this.mI(x.this.cZx.threadData.getId());
                }
            }
        });
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_transmit_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this);
        this.cbz.aKk.setNeedAddReplyIcon(true);
        this.cbz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.apS() != null) {
                    x.this.apS().a(view2, x.this.cZx);
                }
                if (view2 != x.this.cbz.aKj && x.this.cZx != null && x.this.cZx.threadData != null) {
                    o.mG(x.this.cZx.threadData.getId());
                    x.this.mI(x.this.cZx.threadData.getId());
                }
            }
        });
        this.cXO = view.findViewById(e.g.divider_line_above_praise);
        this.cZv = view.findViewById(e.g.card_divider_line);
        this.cZw = (TbImageView) view.findViewById(e.g.thread_theme_card);
        this.cZy = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.caM.changeSelectStatus();
            }
        });
        this.caM.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bJ(boolean z) {
                al.j(x.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
            }
        });
    }

    private void N(final bb bbVar) {
        if (this.cZy != null) {
            if (this.cZw == null || bbVar == null) {
                this.cZy.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu) && this.cZw.getVisibility() != 0) {
                if (this.caX != null && this.caX.getVisibility() == 0 && (this.cZy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cZy.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.cZy.setLayoutParams(layoutParams);
                }
                this.cZy.setVisibility(0);
                this.cZy.setImageDrawable(null);
                this.cZy.startLoad(bbVar.avu, 10, false);
                this.cZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cZy.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cXO, e.d.cp_bg_line_e);
            this.caM.onChangeSkinType();
            this.caL.onChangeSkinType();
            if (this.caX != null) {
                this.caX.onChangeSkinType();
            }
            this.cZb.onChangeSkinType();
            al.j(this.cZv, e.d.cp_bg_line_e);
            this.cbz.onChangeSkinType();
        }
        if (this.cZx != null && this.cZx.threadData != null) {
            al.j(this.mMaskView, this.cZx.threadData.Bh() ? e.d.cp_bg_line_d : e.d.transparent);
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
        this.cZx = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.caX != null) {
            SparseArray<String> yF = bbVar.yF();
            if (yF != null && yF.size() > 0 && this.cXR) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(yF);
                this.caX.setData(ahVar);
                this.caX.setFirstRowSingleColumn(true);
                this.caX.setVisibility(P(bbVar) ? 8 : 0);
            } else {
                this.caX.setVisibility(8);
            }
        }
        if (this.cZx.avL == 1) {
            this.caL.setFrom(3);
            Q(bbVar);
            N(bbVar);
        }
        if (this.currentPageType == 15) {
            this.caL.setFrom(5);
        }
        this.caL.setIsFromConcern(this.aKE);
        this.caL.setData(bbVar);
        this.caL.setUserAfterClickListener(this.aKC);
        if (this.caL.getHeaderImg() != null) {
            if (this.caL.getIsSimpleThread()) {
                this.caL.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (bbVar.zG() == null || bbVar.zG().getPendantData() == null || StringUtils.isNull(bbVar.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.caL.getHeaderImg().setVisibility(0);
                this.caL.getHeaderImg().setData(bbVar);
            } else {
                this.caL.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(bbVar);
            }
        }
        O(bbVar);
        this.cZb.b(bbVar.avt);
        iM(hD(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        mI(bbVar.getId());
        if (this.caM.isInFrsAllThread() && com.baidu.tieba.frs.a.aAJ().aAK()) {
            this.mMaskView.setVisibility(0);
            if (bbVar.Bh() || bbVar.Bi()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.auJ)) {
                bbVar.al(this.mUrl, this.auJ);
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
        if (bbVar == null || bbVar.zG() == null || StringUtils.isNull(bbVar.zG().getUserId())) {
            return false;
        }
        return bbVar.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.caX != null) {
            this.caX.setUniqueId(bdUniqueId);
        }
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caX != null) {
            this.caX.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout acq() {
        return this.caM;
    }

    public ThreadCommentAndPraiseInfoLayout acr() {
        return this.cbz.aKk;
    }

    public void fw(boolean z) {
        if (this.cZv != null) {
            this.cZv.setVisibility(z ? 0 : 8);
        }
    }

    public void fs(boolean z) {
        this.cXR = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aKE = z;
    }

    private void aqm() {
        if (this.cZx != null && this.cZx.threadData != null) {
            bb bbVar = this.cZx.threadData;
            o.mG(bbVar.getId());
            mI(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.cZx.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.mG(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(String str) {
        o.a(this.mTitle, str, e.d.cp_cont_b, e.d.cp_cont_d);
        o.a(this.cXP, str, e.d.cp_cont_b, e.d.cp_cont_d);
        this.cZb.setReadState(o.mH(str));
    }

    public void Q(bb bbVar) {
        MetaData zG;
        if (bbVar != null && this.cZw != null && (zG = bbVar.zG()) != null) {
            final ThemeCardInUserData themeCard = zG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cZw.setVisibility(8);
                return;
            }
            this.cZw.setVisibility(0);
            this.cZw.setImageBitmap(null);
            this.cZw.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apS() != null) {
            apS().a(view, this.cZx);
        }
        if (view == getView()) {
            aqm();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caL != null) {
            return this.caL.aKp;
        }
        return null;
    }

    public View apV() {
        if (this.caL != null) {
            return this.caL.aKr;
        }
        return null;
    }

    public void iM(int i) {
        if (this.cZx != null && this.cZx.threadData != null) {
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setFrom(this.cZx.avK);
                this.cbz.setShareReportFrom(this.cZx.avL);
                this.cbz.setStType(this.cZx.stType);
                this.cbz.setData(this.cZx.threadData);
                this.caL.showForumNameView(false);
                return;
            }
            this.caM.setFrom(this.cZx.avK);
            this.caM.setShareReportFrom(this.cZx.avL);
            this.caM.setStType(this.cZx.stType);
            this.caM.setData(this.cZx.threadData);
            this.caM.setDisPraiseFrom(this.cZx.avN);
            this.cbz.setVisibility(8);
            this.caL.showForumNameView(true);
        }
    }

    public void al(String str, String str2) {
        this.mUrl = str;
        this.auJ = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }

    public void kL(int i) {
        if (this.caM != null) {
            this.caM.aJD = String.valueOf(i);
        }
    }
}
