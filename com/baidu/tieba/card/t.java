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
    private boolean ajh;
    private boolean aoH;
    private final View.OnClickListener aod;
    private HeadPendantClickableView bZe;
    private com.baidu.tieba.NEGFeedBack.c bZg;
    public ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    private View caN;
    private TextView caO;
    private boolean caQ;
    private View ccG;
    private TbImageView ccH;
    private be ccI;
    private OriginalThreadCardView.a ccJ;
    public OriginalThreadCardView ccm;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZg = null;
        this.ajh = true;
        this.caQ = true;
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.abt() != null) {
                    t.this.abt().a(view, t.this.ccI);
                }
            }
        };
        this.ccJ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.ccI != null && t.this.ccI.threadData != null) {
                    String id = t.this.ccI.threadData.getId();
                    k.jO(id);
                    t.this.jR(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.bZg = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bZg.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.caO = (TextView) view.findViewById(d.g.thread_abstract);
        this.ccm = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.ccm.setSubClickListener(this.ccJ);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bvI.setOnClickListener(this);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.abt() != null) {
                    t.this.abt().a(view2, t.this.ccI);
                }
            }
        });
        this.caN = view.findViewById(d.g.divider_line_above_praise);
        this.ccG = view.findViewById(d.g.card_divider_line);
        this.ccH = (TbImageView) view.findViewById(d.g.thread_theme_card);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.caN, d.C0096d.cp_bg_line_e);
            this.bvI.onChangeSkinType();
            this.bvE.onChangeSkinType();
            if (this.bZg != null) {
                this.bZg.onChangeSkinType();
            }
            this.ccm.onChangeSkinType();
            aj.k(this.ccG, d.C0096d.cp_bg_line_e);
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
        this.ccI = beVar;
        bd bdVar = beVar.threadData;
        if (this.ccI.aaG == 1) {
            this.bvE.setFrom(3);
            D(bdVar);
        }
        this.bvE.setIsFromConcern(this.aoH);
        this.bvE.setData(bdVar);
        this.bvE.setUserAfterClickListener(this.aod);
        if (this.bvE.getHeaderImg() != null) {
            if (this.bvE.getIsSimpleThread()) {
                this.bvE.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (bdVar.rv() == null || bdVar.rv().getPendantData() == null || StringUtils.isNull(bdVar.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.bvE.getHeaderImg().setVisibility(0);
                this.bvE.getHeaderImg().setData(bdVar);
            } else {
                this.bvE.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(bdVar);
            }
        }
        if (this.bZg != null) {
            SparseArray<String> ql = bdVar.ql();
            if (ql != null && ql.size() > 0 && this.caQ) {
                ah ahVar = new ah();
                ahVar.cD(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(ql);
                this.bZg.setData(ahVar);
                this.bZg.setFirstRowSingleColumn(true);
                this.bZg.setVisibility(C(bdVar) ? 8 : 0);
            } else {
                this.bZg.setVisibility(8);
            }
        }
        z(bdVar);
        this.ccm.b(bdVar.aaC);
        this.bvI.setStType(this.ccI.stType);
        this.bvI.setFrom(this.ccI.aaF);
        this.bvI.setShareReportFrom(this.ccI.aaG);
        this.bvI.setData(bdVar);
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
            k.a(this.mTitle, bdVar.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
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
        if (this.bZg != null) {
            this.bZg.setUniqueId(bdUniqueId);
        }
        if (this.bvE != null) {
            this.bvE.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bZg != null) {
            this.bZg.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout abX() {
        return this.bvI;
    }

    public void dV(boolean z) {
        if (this.ccG != null) {
            this.ccG.setVisibility(z ? 0 : 8);
        }
    }

    public void dR(boolean z) {
        this.caQ = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aoH = z;
    }

    private void abM() {
        if (this.ccI != null && this.ccI.threadData != null) {
            bd bdVar = this.ccI.threadData;
            k.jO(bdVar.getId());
            jR(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.ccI.stType, 18003, true, false, false);
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
        k.a(this.mTitle, str, d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        k.a(this.caO, str, d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        this.ccm.setReadState(k.jP(str));
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccH != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccH.setVisibility(8);
                return;
            }
            this.ccH.setVisibility(0);
            this.ccH.setImageBitmap(null);
            this.ccH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
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
            abt().a(view, this.ccI);
        }
        if (view == getView()) {
            abM();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvE != null) {
            return this.bvE.anY;
        }
        return null;
    }

    public View abw() {
        if (this.bvE != null) {
            return this.bvE.anZ;
        }
        return null;
    }
}
