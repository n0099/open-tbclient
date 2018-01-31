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
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<be> {
    private boolean aXA;
    private boolean bcX;
    private final View.OnClickListener bcm;
    public ThreadSourceShareAndPraiseLayout cSM;
    private View cUu;
    private TextView cUv;
    private boolean cUx;
    public OriginalThreadCardView cVR;
    private View cWk;
    private TbImageView cWl;
    private be cWm;
    private OriginalThreadCardView.a cWn;
    public ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    private com.baidu.tieba.NEGFeedBack.c cje;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cje = null;
        this.aXA = true;
        this.cUx = true;
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.akg() != null) {
                    t.this.akg().a(view, t.this.cWm);
                }
            }
        };
        this.cWn = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.5
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.cWm != null && t.this.cWm.threadData != null) {
                    String id = t.this.cWm.threadData.getId();
                    k.kj(id);
                    t.this.km(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.cje = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cje.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cUv = (TextView) view.findViewById(d.g.thread_abstract);
        this.cVR = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cVR.setSubClickListener(this.cWn);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.ciT.setOnClickListener(this);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.akg() != null) {
                    t.this.akg().a(view2, t.this.cWm);
                }
                if (t.this.cWm != null && t.this.cWm.threadData != null) {
                    k.kj(t.this.cWm.threadData.getId());
                    t.this.km(t.this.cWm.threadData.getId());
                }
            }
        });
        this.cSM = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.cSM.bcI.setOnClickListener(this);
        this.cSM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.akg() != null) {
                    t.this.akg().a(view2, t.this.cWm);
                }
                if (t.this.cWm != null && t.this.cWm.threadData != null) {
                    k.kj(t.this.cWm.threadData.getId());
                    t.this.km(t.this.cWm.threadData.getId());
                }
            }
        });
        this.cUu = view.findViewById(d.g.divider_line_above_praise);
        this.cWk = view.findViewById(d.g.card_divider_line);
        this.cWl = (TbImageView) view.findViewById(d.g.thread_theme_card);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cUu, d.C0108d.cp_bg_line_e);
            this.ciT.onChangeSkinType();
            this.ciS.onChangeSkinType();
            if (this.cje != null) {
                this.cje.onChangeSkinType();
            }
            this.cVR.onChangeSkinType();
            aj.t(this.cWk, d.C0108d.cp_bg_line_e);
            this.cSM.onChangeSkinType();
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
        this.cWm = beVar;
        bd bdVar = beVar.threadData;
        if (this.cWm.aPh == 1) {
            this.ciS.setFrom(3);
            H(bdVar);
        }
        this.ciS.setIsFromConcern(this.bcX);
        this.ciS.setData(bdVar);
        this.ciS.setUserAfterClickListener(this.bcm);
        if (this.ciS.getHeaderImg() != null) {
            if (this.ciS.getIsSimpleThread()) {
                this.ciS.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (bdVar.yT() == null || bdVar.yT().getPendantData() == null || StringUtils.isNull(bdVar.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ciS.getHeaderImg().setVisibility(0);
                this.ciS.getHeaderImg().setData(bdVar);
            } else {
                this.ciS.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(bdVar);
            }
        }
        if (this.cje != null) {
            SparseArray<String> xM = bdVar.xM();
            if (xM != null && xM.size() > 0 && this.cUx) {
                ah ahVar = new ah();
                ahVar.cK(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(xM);
                this.cje.setData(ahVar);
                this.cje.setFirstRowSingleColumn(true);
                this.cje.setVisibility(G(bdVar) ? 8 : 0);
            } else {
                this.cje.setVisibility(8);
            }
        }
        A(bdVar);
        this.cVR.b(bdVar.aPc);
        lD(bdVar.aPd);
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        km(bdVar.getId());
    }

    private void A(bd bdVar) {
        if (bdVar != null) {
            SpannableStringBuilder j = bdVar.j(false, true);
            if (j == null || StringUtils.isNull(j.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            k.a(this.mTitle, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
    }

    private boolean G(bd bdVar) {
        if (bdVar == null || bdVar.yT() == null || StringUtils.isNull(bdVar.yT().getUserId())) {
            return false;
        }
        return bdVar.yT().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cje != null) {
            this.cje.setUniqueId(bdUniqueId);
        }
        if (this.ciS != null) {
            this.ciS.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cje != null) {
            this.cje.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout akL() {
        return this.ciT;
    }

    public ThreadCommentAndPraiseInfoLayout akM() {
        return this.cSM.bcI;
    }

    public void eI(boolean z) {
        if (this.cWk != null) {
            this.cWk.setVisibility(z ? 0 : 8);
        }
    }

    public void eE(boolean z) {
        this.cUx = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bcX = z;
    }

    private void akA() {
        if (this.cWm != null && this.cWm.threadData != null) {
            bd bdVar = this.cWm.threadData;
            k.kj(bdVar.getId());
            km(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.cWm.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.yZ());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            k.kj(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(String str) {
        k.a(this.mTitle, str, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        k.a(this.cUv, str, d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        this.cVR.setReadState(k.kk(str));
    }

    public void H(bd bdVar) {
        MetaData yT;
        if (bdVar != null && this.cWl != null && (yT = bdVar.yT()) != null) {
            final ThemeCardInUserData themeCard = yT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cWl.setVisibility(8);
                return;
            }
            this.cWl.setVisibility(0);
            this.cWl.setImageBitmap(null);
            this.cWl.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akg() != null) {
            akg().a(view, this.cWm);
        }
        if (view == getView()) {
            akA();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciS != null) {
            return this.ciS.bch;
        }
        return null;
    }

    public View akj() {
        if (this.ciS != null) {
            return this.ciS.bci;
        }
        return null;
    }

    public void lD(int i) {
        if (this.cWm != null && this.cWm.threadData != null) {
            if (i == 1) {
                this.ciT.setVisibility(8);
                this.cSM.setFrom(this.cWm.aPg);
                this.cSM.setShareReportFrom(this.cWm.aPh);
                this.cSM.setStType(this.cWm.stType);
                this.cSM.setData(this.cWm.threadData);
                this.ciS.showForumNameView(false);
                return;
            }
            this.ciT.setFrom(this.cWm.aPg);
            this.ciT.setShareReportFrom(this.cWm.aPh);
            this.ciT.setStType(this.cWm.stType);
            this.ciT.setData(this.cWm.threadData);
            this.cSM.setVisibility(8);
            this.ciS.showForumNameView(true);
        }
    }
}
