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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bf;
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
public class t extends a<bf> {
    private boolean aXt;
    private boolean bcJ;
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private boolean cPA;
    private View cPx;
    private TextView cPy;
    public OriginalThreadCardView cQU;
    private View cRn;
    private TbImageView cRo;
    private bf cRp;
    private OriginalThreadCardView.a cRq;
    public ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    private com.baidu.tieba.NEGFeedBack.c ciP;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciP = null;
        this.aXt = true;
        this.cPA = true;
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.aiY() != null) {
                    t.this.aiY().a(view, t.this.cRp);
                }
            }
        };
        this.cRq = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.cRp != null && t.this.cRp.threadData != null) {
                    String id = t.this.cRp.threadData.getId();
                    k.jT(id);
                    t.this.jW(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.ciP = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.ciP.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cPy = (TextView) view.findViewById(d.g.thread_abstract);
        this.cQU = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cQU.setSubClickListener(this.cRq);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.ciE.setOnClickListener(this);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.aiY() != null) {
                    t.this.aiY().a(view2, t.this.cRp);
                }
                if (t.this.cRp != null && t.this.cRp.threadData != null) {
                    k.jT(t.this.cRp.threadData.getId());
                    t.this.jW(t.this.cRp.threadData.getId());
                }
            }
        });
        this.cPx = view.findViewById(d.g.divider_line_above_praise);
        this.cRn = view.findViewById(d.g.card_divider_line);
        this.cRo = (TbImageView) view.findViewById(d.g.thread_theme_card);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cPx, d.C0108d.cp_bg_line_e);
            this.ciE.onChangeSkinType();
            this.ciD.onChangeSkinType();
            if (this.ciP != null) {
                this.ciP.onChangeSkinType();
            }
            this.cQU.onChangeSkinType();
            aj.t(this.cRn, d.C0108d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bf bfVar) {
        if (bfVar == null || bfVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.cRp = bfVar;
        be beVar = bfVar.threadData;
        if (this.cRp.aPf == 1) {
            this.ciD.setFrom(3);
            H(beVar);
        }
        this.ciD.setIsFromConcern(this.bcJ);
        this.ciD.setData(beVar);
        this.ciD.setUserAfterClickListener(this.bce);
        if (this.ciD.getHeaderImg() != null) {
            if (this.ciD.getIsSimpleThread()) {
                this.ciD.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (beVar.yX() == null || beVar.yX().getPendantData() == null || StringUtils.isNull(beVar.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.ciD.getHeaderImg().setVisibility(0);
                this.ciD.getHeaderImg().setData(beVar);
            } else {
                this.ciD.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(beVar);
            }
        }
        if (this.ciP != null) {
            SparseArray<String> xO = beVar.xO();
            if (xO != null && xO.size() > 0 && this.cPA) {
                ai aiVar = new ai();
                aiVar.cK(beVar.getTid());
                aiVar.setFid(beVar.getFid());
                aiVar.a(xO);
                this.ciP.setData(aiVar);
                this.ciP.setFirstRowSingleColumn(true);
                this.ciP.setVisibility(G(beVar) ? 8 : 0);
            } else {
                this.ciP.setVisibility(8);
            }
        }
        A(beVar);
        this.cQU.b(beVar.aPb);
        this.ciE.setStType(this.cRp.stType);
        this.ciE.setFrom(this.cRp.aPe);
        this.ciE.setShareReportFrom(this.cRp.aPf);
        this.ciE.setData(beVar);
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        jW(beVar.getId());
    }

    private void A(be beVar) {
        if (beVar != null) {
            SpannableStringBuilder j = beVar.j(false, true);
            if (j == null || StringUtils.isNull(j.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            k.a(this.mTitle, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
    }

    private boolean G(be beVar) {
        if (beVar == null || beVar.yX() == null || StringUtils.isNull(beVar.yX().getUserId())) {
            return false;
        }
        return beVar.yX().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ciP != null) {
            this.ciP.setUniqueId(bdUniqueId);
        }
        if (this.ciD != null) {
            this.ciD.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.ciP != null) {
            this.ciP.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout ajD() {
        return this.ciE;
    }

    public void eC(boolean z) {
        if (this.cRn != null) {
            this.cRn.setVisibility(z ? 0 : 8);
        }
    }

    public void ey(boolean z) {
        this.cPA = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bcJ = z;
    }

    private void ajs() {
        if (this.cRp != null && this.cRp.threadData != null) {
            be beVar = this.cRp.threadData;
            k.jT(beVar.getId());
            jW(beVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(beVar, null, this.cRp.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(beVar.getFid()));
            createFromThreadCfg.setForumName(beVar.zd());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            k.jT(beVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(String str) {
        k.a(this.mTitle, str, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        k.a(this.cPy, str, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        this.cQU.setReadState(k.jU(str));
    }

    public void H(be beVar) {
        MetaData yX;
        if (beVar != null && this.cRo != null && (yX = beVar.yX()) != null) {
            final ThemeCardInUserData themeCard = yX.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cRo.setVisibility(8);
                return;
            }
            this.cRo.setVisibility(0);
            this.cRo.setImageBitmap(null);
            this.cRo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cRo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiY() != null) {
            aiY().a(view, this.cRp);
        }
        if (view == getView()) {
            ajs();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciD != null) {
            return this.ciD.bbZ;
        }
        return null;
    }

    public View ajb() {
        if (this.ciD != null) {
            return this.ciD.bca;
        }
        return null;
    }
}
