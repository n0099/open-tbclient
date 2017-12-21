package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<be> {
    private boolean ajk;
    private boolean aoK;
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private com.baidu.tieba.NEGFeedBack.c bZk;
    public ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    private View caR;
    private TextView caS;
    private boolean caU;
    private View ccK;
    private TbImageView ccL;
    private be ccM;
    private OriginalThreadCardView.a ccN;
    public OriginalThreadCardView ccq;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZk = null;
        this.ajk = true;
        this.caU = true;
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.abt() != null) {
                    t.this.abt().a(view, t.this.ccM);
                }
            }
        };
        this.ccN = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.ccM != null && t.this.ccM.threadData != null) {
                    String id = t.this.ccM.threadData.getId();
                    k.jO(id);
                    t.this.jR(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.bZk = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bZk.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.caS = (TextView) view.findViewById(d.g.thread_abstract);
        this.ccq = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.ccq.setSubClickListener(this.ccN);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bvM.setOnClickListener(this);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.abt() != null) {
                    t.this.abt().a(view2, t.this.ccM);
                }
            }
        });
        this.caR = view.findViewById(d.g.divider_line_above_praise);
        this.ccK = view.findViewById(d.g.card_divider_line);
        this.ccL = (TbImageView) view.findViewById(d.g.thread_theme_card);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.caR, d.C0095d.cp_bg_line_e);
            this.bvM.onChangeSkinType();
            this.bvI.onChangeSkinType();
            if (this.bZk != null) {
                this.bZk.onChangeSkinType();
            }
            this.ccq.onChangeSkinType();
            aj.k(this.ccK, d.C0095d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(be beVar) {
        if (beVar == null || beVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.ccM = beVar;
        bd bdVar = beVar.threadData;
        if (this.ccM.aaJ == 1) {
            this.bvI.setFrom(3);
            D(bdVar);
        }
        this.bvI.setIsFromConcern(this.aoK);
        this.bvI.setData(bdVar);
        this.bvI.setUserAfterClickListener(this.aog);
        if (this.bvI.getHeaderImg() != null) {
            if (this.bvI.getIsSimpleThread()) {
                this.bvI.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (bdVar.rv() == null || bdVar.rv().getPendantData() == null || StringUtils.isNull(bdVar.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.bvI.getHeaderImg().setVisibility(0);
                this.bvI.getHeaderImg().setData(bdVar);
            } else {
                this.bvI.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(bdVar);
            }
        }
        if (this.bZk != null) {
            SparseArray<String> ql = bdVar.ql();
            if (ql != null && ql.size() > 0 && this.caU) {
                ah ahVar = new ah();
                ahVar.cD(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(ql);
                this.bZk.setData(ahVar);
                this.bZk.setFirstRowSingleColumn(true);
                this.bZk.setVisibility(C(bdVar) ? 8 : 0);
            } else {
                this.bZk.setVisibility(8);
            }
        }
        z(bdVar);
        this.ccq.b(bdVar.aaF);
        this.bvM.setStType(this.ccM.stType);
        this.bvM.setFrom(this.ccM.aaI);
        this.bvM.setShareReportFrom(this.ccM.aaJ);
        this.bvM.setData(bdVar);
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        jR(bdVar.getId());
    }

    private void z(bd bdVar) {
        if (bdVar != null) {
            SpannableStringBuilder g = bdVar.g(false, true);
            if (g == null || StringUtils.isNull(g.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            k.a(this.mTitle, bdVar.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        }
    }

    private boolean C(bd bdVar) {
        if (bdVar == null || bdVar.rv() == null || StringUtils.isNull(bdVar.rv().getUserId())) {
            return false;
        }
        return bdVar.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bZk != null) {
            this.bZk.setUniqueId(bdUniqueId);
        }
        if (this.bvI != null) {
            this.bvI.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bZk != null) {
            this.bZk.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout abX() {
        return this.bvM;
    }

    public void dV(boolean z) {
        if (this.ccK != null) {
            this.ccK.setVisibility(z ? 0 : 8);
        }
    }

    public void dR(boolean z) {
        this.caU = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aoK = z;
    }

    private void abM() {
        if (this.ccM != null && this.ccM.threadData != null) {
            bd bdVar = this.ccM.threadData;
            k.jO(bdVar.getId());
            jR(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.ccM.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.rB());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            k.jO(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR(String str) {
        k.a(this.mTitle, str, d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        k.a(this.caS, str, d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        this.ccq.setReadState(k.jP(str));
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccL != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccL.setVisibility(8);
                return;
            }
            this.ccL.setVisibility(0);
            this.ccL.setImageBitmap(null);
            this.ccL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (abt() != null) {
            abt().a(view, this.ccM);
        }
        if (view == getView()) {
            abM();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvI != null) {
            return this.bvI.aob;
        }
        return null;
    }

    public View abw() {
        if (this.bvI != null) {
            return this.bvI.aoc;
        }
        return null;
    }
}
