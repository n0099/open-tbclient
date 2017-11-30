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
    private boolean ajn;
    private boolean aoE;
    private final View.OnClickListener aob;
    private HeadPendantClickableView bZa;
    private com.baidu.tieba.NEGFeedBack.c bZc;
    public ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    private View caJ;
    private TextView caK;
    private boolean caM;
    private View ccB;
    private TbImageView ccC;
    private be ccD;
    private OriginalThreadCardView.a ccE;
    public OriginalThreadCardView cci;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZc = null;
        this.ajn = true;
        this.caM = true;
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.abs() != null) {
                    t.this.abs().a(view, t.this.ccD);
                }
            }
        };
        this.ccE = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.ccD != null && t.this.ccD.threadData != null) {
                    String id = t.this.ccD.threadData.getId();
                    k.jQ(id);
                    t.this.jT(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZa.wk();
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.bZc = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bZc.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.caK = (TextView) view.findViewById(d.g.thread_abstract);
        this.cci = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cci.setSubClickListener(this.ccE);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bvH.setOnClickListener(this);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.abs() != null) {
                    t.this.abs().a(view2, t.this.ccD);
                }
            }
        });
        this.caJ = view.findViewById(d.g.divider_line_above_praise);
        this.ccB = view.findViewById(d.g.card_divider_line);
        this.ccC = (TbImageView) view.findViewById(d.g.thread_theme_card);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.caJ, d.C0082d.cp_bg_line_e);
            this.bvH.onChangeSkinType();
            this.bvD.onChangeSkinType();
            if (this.bZc != null) {
                this.bZc.onChangeSkinType();
            }
            this.cci.onChangeSkinType();
            aj.k(this.ccB, d.C0082d.cp_bg_line_e);
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
        this.ccD = beVar;
        bd bdVar = beVar.threadData;
        if (this.ccD.aaM == 1) {
            this.bvD.setFrom(3);
            B(bdVar);
        }
        this.bvD.setIsFromConcern(this.aoE);
        this.bvD.setData(bdVar);
        this.bvD.setUserAfterClickListener(this.aob);
        if (this.bvD.getHeaderImg() != null) {
            if (this.bvD.getIsSimpleThread()) {
                this.bvD.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (bdVar.rx() == null || bdVar.rx().getPendantData() == null || StringUtils.isNull(bdVar.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.bvD.getHeaderImg().setVisibility(0);
                this.bvD.getHeaderImg().setData(bdVar);
            } else {
                this.bvD.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(bdVar);
            }
        }
        if (this.bZc != null) {
            SparseArray<String> qn = bdVar.qn();
            if (qn != null && qn.size() > 0 && this.caM) {
                ah ahVar = new ah();
                ahVar.cD(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(qn);
                this.bZc.setData(ahVar);
                this.bZc.setFirstRowSingleColumn(true);
                this.bZc.setVisibility(A(bdVar) ? 8 : 0);
            } else {
                this.bZc.setVisibility(8);
            }
        }
        x(bdVar);
        this.cci.b(bdVar.aaI);
        this.bvH.setStType(this.ccD.stType);
        this.bvH.setFrom(this.ccD.aaL);
        this.bvH.setShareReportFrom(this.ccD.aaM);
        this.bvH.setData(bdVar);
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        jT(bdVar.getId());
    }

    private void x(bd bdVar) {
        if (bdVar != null) {
            SpannableStringBuilder g = bdVar.g(false, true);
            if (g == null || StringUtils.isNull(g.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            k.a(this.mTitle, bdVar.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        }
    }

    private boolean A(bd bdVar) {
        if (bdVar == null || bdVar.rx() == null || StringUtils.isNull(bdVar.rx().getUserId())) {
            return false;
        }
        return bdVar.rx().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bZc != null) {
            this.bZc.setUniqueId(bdUniqueId);
        }
        if (this.bvD != null) {
            this.bvD.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bZc != null) {
            this.bZc.setEventCallback(aVar);
        }
    }

    public void dU(boolean z) {
        if (this.ccB != null) {
            this.ccB.setVisibility(z ? 0 : 8);
        }
    }

    public void dQ(boolean z) {
        this.caM = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aoE = z;
    }

    private void abK() {
        if (this.ccD != null && this.ccD.threadData != null) {
            bd bdVar = this.ccD.threadData;
            k.jQ(bdVar.getId());
            jT(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.ccD.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.rD());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            k.jQ(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(String str) {
        k.a(this.mTitle, str, d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        k.a(this.caK, str, d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        this.cci.setReadState(k.jR(str));
    }

    public void B(bd bdVar) {
        MetaData rx;
        if (bdVar != null && this.ccC != null && (rx = bdVar.rx()) != null) {
            final ThemeCardInUserData themeCard = rx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccC.setVisibility(8);
                return;
            }
            this.ccC.setVisibility(0);
            this.ccC.setImageBitmap(null);
            this.ccC.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (abs() != null) {
            abs().a(view, this.ccD);
        }
        if (view == getView()) {
            abK();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvD != null) {
            return this.bvD.anW;
        }
        return null;
    }

    public View abv() {
        if (this.bvD != null) {
            return this.bvD.anX;
        }
        return null;
    }
}
