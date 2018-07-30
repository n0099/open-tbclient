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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class x extends a<bc> implements com.baidu.tieba.a.e {
    private String aiZ;
    private boolean asR;
    private View axE;
    private final View.OnClickListener axO;
    private boolean ayI;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    private NEGFeedBackView bIa;
    private HeadPendantClickableView bIz;
    private View cAJ;
    private TbImageView cAK;
    private bc cAL;
    private TbImageView cAM;
    private OriginalThreadCardView.a cAN;
    public OriginalThreadCardView cAp;
    private View czc;
    private TextView czd;
    private boolean czf;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.asR = true;
        this.czf = true;
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.aiz() != null) {
                    x.this.aiz().a(view, x.this.cAL);
                }
            }
        };
        this.cAN = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cAL != null && x.this.cAL.threadData != null) {
                    if (x.this.aiz() != null) {
                        x.this.aiz().a(x.this.cAp, x.this.cAL);
                    }
                    String id = x.this.cAL.threadData.getId();
                    o.kW(id);
                    x.this.kY(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bIz = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mPageContext);
        this.bIa.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.czd = (TextView) view.findViewById(d.g.thread_abstract);
        this.cAp = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cAp.setSubClickListener(this.cAN);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bHO.setOnClickListener(this);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aiz() != null) {
                    x.this.aiz().a(view2, x.this.cAL);
                }
                if (x.this.cAL != null && x.this.cAL.threadData != null) {
                    o.kW(x.this.cAL.threadData.getId());
                    x.this.kY(x.this.cAL.threadData.getId());
                }
            }
        });
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this);
        this.bIC.ayr.setNeedAddReplyIcon(true);
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aiz() != null) {
                    x.this.aiz().a(view2, x.this.cAL);
                }
                if (view2 != x.this.bIC.ayq && x.this.cAL != null && x.this.cAL.threadData != null) {
                    o.kW(x.this.cAL.threadData.getId());
                    x.this.kY(x.this.cAL.threadData.getId());
                }
            }
        });
        this.czc = view.findViewById(d.g.divider_line_above_praise);
        this.cAJ = view.findViewById(d.g.card_divider_line);
        this.cAK = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.cAM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.axE = view.findViewById(d.g.thread_multi_del_mask_view);
        this.axE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.bHO.changeSelectStatus();
            }
        });
        this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aU(boolean z) {
                am.j(x.this.axE, z ? d.C0140d.cp_bg_line_d : d.C0140d.transparent);
            }
        });
    }

    private void M(final bb bbVar) {
        if (this.cAM != null) {
            if (this.cAK == null || bbVar == null) {
                this.cAM.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI) && this.cAK.getVisibility() != 0) {
                if (this.bIa != null && this.bIa.getVisibility() == 0 && (this.cAM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAM.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cAM.setLayoutParams(layoutParams);
                }
                this.cAM.setVisibility(0);
                this.cAM.setImageDrawable(null);
                this.cAM.startLoad(bbVar.ajI, 10, false);
                this.cAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAM.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.j(this.czc, d.C0140d.cp_bg_line_e);
            this.bHO.onChangeSkinType();
            this.bHN.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            this.cAp.onChangeSkinType();
            am.j(this.cAJ, d.C0140d.cp_bg_line_e);
            this.bIC.onChangeSkinType();
        }
        if (this.cAL != null && this.cAL.threadData != null) {
            am.j(this.axE, this.cAL.threadData.wH() ? d.C0140d.cp_bg_line_d : d.C0140d.transparent);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_transmit_thread_view;
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
        this.cAL = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.bIa != null) {
            SparseArray<String> ui = bbVar.ui();
            if (ui != null && ui.size() > 0 && this.czf) {
                ah ahVar = new ah();
                ahVar.dh(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(ui);
                this.bIa.setData(ahVar);
                this.bIa.setFirstRowSingleColumn(true);
                this.bIa.setVisibility(O(bbVar) ? 8 : 0);
            } else {
                this.bIa.setVisibility(8);
            }
        }
        if (this.cAL.ajX == 1) {
            this.bHN.setFrom(3);
            P(bbVar);
            M(bbVar);
        }
        if (this.currentPageType == 15) {
            this.bHN.setFrom(5);
        }
        this.bHN.setIsFromConcern(this.ayI);
        this.bHN.setData(bbVar);
        this.bHN.setUserAfterClickListener(this.axO);
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (bbVar.vk() == null || bbVar.vk().getPendantData() == null || StringUtils.isNull(bbVar.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(bbVar);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(bbVar);
            }
        }
        N(bbVar);
        this.cAp.b(bbVar.ajH);
        hn(gu(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        kY(bbVar.getId());
        if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atD().atE()) {
            this.axE.setVisibility(0);
            if (bbVar.wH() || bbVar.wI()) {
                am.j(this.axE, d.C0140d.cp_bg_line_d);
                return;
            } else {
                this.axE.setBackgroundResource(d.C0140d.transparent);
                return;
            }
        }
        this.axE.setVisibility(8);
    }

    private void N(bb bbVar) {
        if (bbVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.aiZ)) {
                bbVar.O(this.mUrl, this.aiZ);
            }
            SpannableStringBuilder g = bbVar.g(false, true);
            if (g == null || StringUtils.isNull(g.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
    }

    private boolean O(bb bbVar) {
        if (bbVar == null || bbVar.vk() == null || StringUtils.isNull(bbVar.vk().getUserId())) {
            return false;
        }
        return bbVar.vk().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bIa != null) {
            this.bIa.setUniqueId(bdUniqueId);
        }
        if (this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout VA() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VB() {
        return this.bIC.ayr;
    }

    public void ez(boolean z) {
        if (this.cAJ != null) {
            this.cAJ.setVisibility(z ? 0 : 8);
        }
    }

    public void ev(boolean z) {
        this.czf = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayI = z;
    }

    private void aiS() {
        if (this.cAL != null && this.cAL.threadData != null) {
            bb bbVar = this.cAL.threadData;
            o.kW(bbVar.getId());
            kY(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.cAL.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.kW(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY(String str) {
        o.a(this.mTitle, str, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        o.a(this.czd, str, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        this.cAp.setReadState(o.kX(str));
    }

    public void P(bb bbVar) {
        MetaData vk;
        if (bbVar != null && this.cAK != null && (vk = bbVar.vk()) != null) {
            final ThemeCardInUserData themeCard = vk.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAK.setVisibility(8);
                return;
            }
            this.cAK.setVisibility(0);
            this.cAK.setImageBitmap(null);
            this.cAK.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiz() != null) {
            aiz().a(view, this.cAL);
        }
        if (view == getView()) {
            aiS();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axK;
        }
        return null;
    }

    public View aiC() {
        if (this.bHN != null) {
            return this.bHN.axL;
        }
        return null;
    }

    public void hn(int i) {
        if (this.cAL != null && this.cAL.threadData != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setFrom(this.cAL.ajW);
                this.bIC.setShareReportFrom(this.cAL.ajX);
                this.bIC.setStType(this.cAL.stType);
                this.bIC.setData(this.cAL.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setFrom(this.cAL.ajW);
            this.bHO.setShareReportFrom(this.cAL.ajX);
            this.bHO.setStType(this.cAL.stType);
            this.bHO.setData(this.cAL.threadData);
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
        }
    }

    public void O(String str, String str2) {
        this.mUrl = str;
        this.aiZ = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
