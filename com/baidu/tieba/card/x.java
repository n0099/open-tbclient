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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class x extends a<bc> implements com.baidu.tieba.a.e {
    private String aiZ;
    private boolean asS;
    private View axB;
    private final View.OnClickListener axL;
    private boolean ayF;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    private NEGFeedBackView bIa;
    private HeadPendantClickableView bIz;
    private View cAG;
    private TbImageView cAH;
    private bc cAI;
    private TbImageView cAJ;
    private OriginalThreadCardView.a cAK;
    public OriginalThreadCardView cAm;
    private View cyZ;
    private TextView cza;
    private boolean czc;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.asS = true;
        this.czc = true;
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.aiC() != null) {
                    x.this.aiC().a(view, x.this.cAI);
                }
            }
        };
        this.cAK = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cAI != null && x.this.cAI.threadData != null) {
                    if (x.this.aiC() != null) {
                        x.this.aiC().a(x.this.cAm, x.this.cAI);
                    }
                    String id = x.this.cAI.threadData.getId();
                    o.kY(id);
                    x.this.la(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bIz = (HeadPendantClickableView) view.findViewById(f.g.thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.thread_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mPageContext);
        this.bIa.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds16));
        this.mTitle = (TextView) view.findViewById(f.g.thread_title);
        this.cza = (TextView) view.findViewById(f.g.thread_abstract);
        this.cAm = (OriginalThreadCardView) view.findViewById(f.g.original_thread_view);
        this.cAm.setSubClickListener(this.cAK);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.thread_comment_layout);
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
                if (x.this.aiC() != null) {
                    x.this.aiC().a(view2, x.this.cAI);
                }
                if (x.this.cAI != null && x.this.cAI.threadData != null) {
                    o.kY(x.this.cAI.threadData.getId());
                    x.this.la(x.this.cAI.threadData.getId());
                }
            }
        });
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_transmit_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this);
        this.bIC.ayo.setNeedAddReplyIcon(true);
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aiC() != null) {
                    x.this.aiC().a(view2, x.this.cAI);
                }
                if (view2 != x.this.bIC.ayn && x.this.cAI != null && x.this.cAI.threadData != null) {
                    o.kY(x.this.cAI.threadData.getId());
                    x.this.la(x.this.cAI.threadData.getId());
                }
            }
        });
        this.cyZ = view.findViewById(f.g.divider_line_above_praise);
        this.cAG = view.findViewById(f.g.card_divider_line);
        this.cAH = (TbImageView) view.findViewById(f.g.thread_theme_card);
        this.cAJ = (TbImageView) view.findViewById(f.g.frs_normal_item_star_view);
        this.axB = view.findViewById(f.g.thread_multi_del_mask_view);
        this.axB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.bHO.changeSelectStatus();
            }
        });
        this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aV(boolean z) {
                am.j(x.this.axB, z ? f.d.cp_bg_line_d : f.d.transparent);
            }
        });
    }

    private void M(final bb bbVar) {
        if (this.cAJ != null) {
            if (this.cAH == null || bbVar == null) {
                this.cAJ.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI) && this.cAH.getVisibility() != 0) {
                if (this.bIa != null && this.bIa.getVisibility() == 0 && (this.cAJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAJ.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.tbds106);
                    this.cAJ.setLayoutParams(layoutParams);
                }
                this.cAJ.setVisibility(0);
                this.cAJ.setImageDrawable(null);
                this.cAJ.startLoad(bbVar.ajI, 10, false);
                this.cAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.addresslist_item_bg);
            am.j(this.cyZ, f.d.cp_bg_line_e);
            this.bHO.onChangeSkinType();
            this.bHN.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            this.cAm.onChangeSkinType();
            am.j(this.cAG, f.d.cp_bg_line_e);
            this.bIC.onChangeSkinType();
        }
        if (this.cAI != null && this.cAI.threadData != null) {
            am.j(this.axB, this.cAI.threadData.wG() ? f.d.cp_bg_line_d : f.d.transparent);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_transmit_thread_view;
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
        this.cAI = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.bIa != null) {
            SparseArray<String> uh = bbVar.uh();
            if (uh != null && uh.size() > 0 && this.czc) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(uh);
                this.bIa.setData(ahVar);
                this.bIa.setFirstRowSingleColumn(true);
                this.bIa.setVisibility(O(bbVar) ? 8 : 0);
            } else {
                this.bIa.setVisibility(8);
            }
        }
        if (this.cAI.ajX == 1) {
            this.bHN.setFrom(3);
            P(bbVar);
            M(bbVar);
        }
        if (this.currentPageType == 15) {
            this.bHN.setFrom(5);
        }
        this.bHN.setIsFromConcern(this.ayF);
        this.bHN.setData(bbVar);
        this.bHN.setUserAfterClickListener(this.axL);
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (bbVar.vj() == null || bbVar.vj().getPendantData() == null || StringUtils.isNull(bbVar.vj().getPendantData().tT())) {
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
        this.cAm.b(bbVar.ajH);
        hm(gt(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        la(bbVar.getId());
        if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atC().atD()) {
            this.axB.setVisibility(0);
            if (bbVar.wG() || bbVar.wH()) {
                am.j(this.axB, f.d.cp_bg_line_d);
                return;
            } else {
                this.axB.setBackgroundResource(f.d.transparent);
                return;
            }
        }
        this.axB.setVisibility(8);
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
            o.a(this.mTitle, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        }
    }

    private boolean O(bb bbVar) {
        if (bbVar == null || bbVar.vj() == null || StringUtils.isNull(bbVar.vj().getUserId())) {
            return false;
        }
        return bbVar.vj().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
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

    public ThreadCommentAndPraiseInfoLayout VD() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VE() {
        return this.bIC.ayo;
    }

    public void ez(boolean z) {
        if (this.cAG != null) {
            this.cAG.setVisibility(z ? 0 : 8);
        }
    }

    public void ev(boolean z) {
        this.czc = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayF = z;
    }

    private void aiV() {
        if (this.cAI != null && this.cAI.threadData != null) {
            bb bbVar = this.cAI.threadData;
            o.kY(bbVar.getId());
            la(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.cAI.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.kY(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(String str) {
        o.a(this.mTitle, str, f.d.cp_cont_b, f.d.cp_cont_d);
        o.a(this.cza, str, f.d.cp_cont_b, f.d.cp_cont_d);
        this.cAm.setReadState(o.kZ(str));
    }

    public void P(bb bbVar) {
        MetaData vj;
        if (bbVar != null && this.cAH != null && (vj = bbVar.vj()) != null) {
            final ThemeCardInUserData themeCard = vj.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAH.setVisibility(8);
                return;
            }
            this.cAH.setVisibility(0);
            this.cAH.setImageBitmap(null);
            this.cAH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiC() != null) {
            aiC().a(view, this.cAI);
        }
        if (view == getView()) {
            aiV();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axH;
        }
        return null;
    }

    public View aiF() {
        if (this.bHN != null) {
            return this.bHN.axI;
        }
        return null;
    }

    public void hm(int i) {
        if (this.cAI != null && this.cAI.threadData != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setFrom(this.cAI.ajW);
                this.bIC.setShareReportFrom(this.cAI.ajX);
                this.bIC.setStType(this.cAI.stType);
                this.bIC.setData(this.cAI.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setFrom(this.cAI.ajW);
            this.bHO.setShareReportFrom(this.cAI.ajX);
            this.bHO.setStType(this.cAI.stType);
            this.bHO.setData(this.cAI.threadData);
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

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
