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
/* loaded from: classes2.dex */
public class x extends a<bc> implements com.baidu.tieba.a.e {
    private View aAH;
    private final View.OnClickListener aBE;
    private boolean aBG;
    private String alB;
    private boolean avq;
    public ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    private NEGFeedBackView bNP;
    private String bNq;
    private HeadPendantClickableView bOo;
    public ThreadSourceShareAndPraiseLayout bOr;
    private View cER;
    private TextView cES;
    private boolean cEU;
    private bc cGA;
    private TbImageView cGB;
    private OriginalThreadCardView.a cGC;
    public OriginalThreadCardView cGe;
    private View cGy;
    private TbImageView cGz;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bNP = null;
        this.avq = true;
        this.cEU = true;
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.akm() != null) {
                    x.this.akm().a(view, x.this.cGA);
                }
            }
        };
        this.cGC = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cGA != null && x.this.cGA.threadData != null) {
                    if (x.this.akm() != null) {
                        x.this.akm().a(x.this.cGe, x.this.cGA);
                    }
                    String id = x.this.cGA.threadData.getId();
                    o.lA(id);
                    x.this.lC(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bOo = (HeadPendantClickableView) view.findViewById(e.g.thread_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0141e.ds70));
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.thread_user_info_layout);
        this.bNP = new NEGFeedBackView(this.mPageContext);
        this.bNP.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds16));
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cES = (TextView) view.findViewById(e.g.thread_abstract);
        this.cGe = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.cGe.setSubClickListener(this.cGC);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_layout);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bND.setOnClickListener(this);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.akm() != null) {
                    x.this.akm().a(view2, x.this.cGA);
                }
                if (x.this.cGA != null && x.this.cGA.threadData != null) {
                    o.lA(x.this.cGA.threadData.getId());
                    x.this.lC(x.this.cGA.threadData.getId());
                }
            }
        });
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_transmit_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this);
        this.bOr.aBl.setNeedAddReplyIcon(true);
        this.bOr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.akm() != null) {
                    x.this.akm().a(view2, x.this.cGA);
                }
                if (view2 != x.this.bOr.aBk && x.this.cGA != null && x.this.cGA.threadData != null) {
                    o.lA(x.this.cGA.threadData.getId());
                    x.this.lC(x.this.cGA.threadData.getId());
                }
            }
        });
        this.cER = view.findViewById(e.g.divider_line_above_praise);
        this.cGy = view.findViewById(e.g.card_divider_line);
        this.cGz = (TbImageView) view.findViewById(e.g.thread_theme_card);
        this.cGB = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.aAH = view.findViewById(e.g.thread_multi_del_mask_view);
        this.aAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.bND.changeSelectStatus();
            }
        });
        this.bND.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bh(boolean z) {
                al.j(x.this.aAH, z ? e.d.cp_bg_line_d : e.d.transparent);
            }
        });
    }

    private void N(final bb bbVar) {
        if (this.cGB != null) {
            if (this.cGz == null || bbVar == null) {
                this.cGB.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.amm) && this.cGz.getVisibility() != 0) {
                if (this.bNP != null && this.bNP.getVisibility() == 0 && (this.cGB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGB.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0141e.tbds106);
                    this.cGB.setLayoutParams(layoutParams);
                }
                this.cGB.setVisibility(0);
                this.cGB.setImageDrawable(null);
                this.cGB.startLoad(bbVar.amm, 10, false);
                this.cGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.amn, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cGB.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cER, e.d.cp_bg_line_e);
            this.bND.onChangeSkinType();
            this.bNC.onChangeSkinType();
            if (this.bNP != null) {
                this.bNP.onChangeSkinType();
            }
            this.cGe.onChangeSkinType();
            al.j(this.cGy, e.d.cp_bg_line_e);
            this.bOr.onChangeSkinType();
        }
        if (this.cGA != null && this.cGA.threadData != null) {
            al.j(this.aAH, this.cGA.threadData.xN() ? e.d.cp_bg_line_d : e.d.transparent);
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
        this.cGA = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.bNP != null) {
            SparseArray<String> vk = bbVar.vk();
            if (vk != null && vk.size() > 0 && this.cEU) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(vk);
                this.bNP.setData(ahVar);
                this.bNP.setFirstRowSingleColumn(true);
                this.bNP.setVisibility(P(bbVar) ? 8 : 0);
            } else {
                this.bNP.setVisibility(8);
            }
        }
        if (this.cGA.amC == 1) {
            this.bNC.setFrom(3);
            Q(bbVar);
            N(bbVar);
        }
        if (this.currentPageType == 15) {
            this.bNC.setFrom(5);
        }
        this.bNC.setIsFromConcern(this.aBG);
        this.bNC.setData(bbVar);
        this.bNC.setUserAfterClickListener(this.aBE);
        if (this.bNC.getHeaderImg() != null) {
            if (this.bNC.getIsSimpleThread()) {
                this.bNC.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (bbVar.wm() == null || bbVar.wm().getPendantData() == null || StringUtils.isNull(bbVar.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.bNC.getHeaderImg().setVisibility(0);
                this.bNC.getHeaderImg().setData(bbVar);
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(bbVar);
            }
        }
        O(bbVar);
        this.cGe.b(bbVar.aml);
        hM(gT(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        lC(bbVar.getId());
        if (this.bND.isInFrsAllThread() && com.baidu.tieba.frs.a.avq().avr()) {
            this.aAH.setVisibility(0);
            if (bbVar.xN() || bbVar.xO()) {
                al.j(this.aAH, e.d.cp_bg_line_d);
                return;
            } else {
                this.aAH.setBackgroundResource(e.d.transparent);
                return;
            }
        }
        this.aAH.setVisibility(8);
    }

    private void O(bb bbVar) {
        if (bbVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.alB)) {
                bbVar.V(this.mUrl, this.alB);
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
        if (bbVar == null || bbVar.wm() == null || StringUtils.isNull(bbVar.wm().getUserId())) {
            return false;
        }
        return bbVar.wm().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bNP != null) {
            this.bNP.setUniqueId(bdUniqueId);
        }
        if (this.bNC != null) {
            this.bNC.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bNP != null) {
            this.bNP.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout Xq() {
        return this.bND;
    }

    public ThreadCommentAndPraiseInfoLayout Xr() {
        return this.bOr.aBl;
    }

    public void eQ(boolean z) {
        if (this.cGy != null) {
            this.cGy.setVisibility(z ? 0 : 8);
        }
    }

    public void eM(boolean z) {
        this.cEU = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aBG = z;
    }

    private void akG() {
        if (this.cGA != null && this.cGA.threadData != null) {
            bb bbVar = this.cGA.threadData;
            o.lA(bbVar.getId());
            lC(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.cGA.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.lA(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC(String str) {
        o.a(this.mTitle, str, e.d.cp_cont_b, e.d.cp_cont_d);
        o.a(this.cES, str, e.d.cp_cont_b, e.d.cp_cont_d);
        this.cGe.setReadState(o.lB(str));
    }

    public void Q(bb bbVar) {
        MetaData wm;
        if (bbVar != null && this.cGz != null && (wm = bbVar.wm()) != null) {
            final ThemeCardInUserData themeCard = wm.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cGz.setVisibility(8);
                return;
            }
            this.cGz.setVisibility(0);
            this.cGz.setImageBitmap(null);
            this.cGz.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akm() != null) {
            akm().a(view, this.cGA);
        }
        if (view == getView()) {
            akG();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bNC != null) {
            return this.bNC.aBr;
        }
        return null;
    }

    public View akp() {
        if (this.bNC != null) {
            return this.bNC.aBt;
        }
        return null;
    }

    public void hM(int i) {
        if (this.cGA != null && this.cGA.threadData != null) {
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setFrom(this.cGA.amB);
                this.bOr.setShareReportFrom(this.cGA.amC);
                this.bOr.setStType(this.cGA.stType);
                this.bOr.setData(this.cGA.threadData);
                this.bNC.showForumNameView(false);
                return;
            }
            this.bND.setFrom(this.cGA.amB);
            this.bND.setShareReportFrom(this.cGA.amC);
            this.bND.setStType(this.cGA.stType);
            this.bND.setData(this.cGA.threadData);
            this.bND.setDisPraiseFrom(this.cGA.amE);
            this.bOr.setVisibility(8);
            this.bNC.showForumNameView(true);
        }
    }

    public void V(String str, String str2) {
        this.mUrl = str;
        this.alB = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }
}
