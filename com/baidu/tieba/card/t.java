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
    private boolean aXs;
    private boolean bcP;
    private final View.OnClickListener bce;
    public ThreadSourceShareAndPraiseLayout cSr;
    private View cTZ;
    private TextView cUa;
    private boolean cUc;
    private View cVP;
    private TbImageView cVQ;
    private be cVR;
    private OriginalThreadCardView.a cVS;
    public OriginalThreadCardView cVw;
    public ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private com.baidu.tieba.NEGFeedBack.c ciW;
    private HeadPendantClickableView cju;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciW = null;
        this.aXs = true;
        this.cUc = true;
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.akb() != null) {
                    t.this.akb().a(view, t.this.cVR);
                }
            }
        };
        this.cVS = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.5
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.cVR != null && t.this.cVR.threadData != null) {
                    String id = t.this.cVR.threadData.getId();
                    k.kc(id);
                    t.this.kf(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.ciW = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.ciW.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cUa = (TextView) view.findViewById(d.g.thread_abstract);
        this.cVw = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cVw.setSubClickListener(this.cVS);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.ciL.setOnClickListener(this);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.akb() != null) {
                    t.this.akb().a(view2, t.this.cVR);
                }
                if (t.this.cVR != null && t.this.cVR.threadData != null) {
                    k.kc(t.this.cVR.threadData.getId());
                    t.this.kf(t.this.cVR.threadData.getId());
                }
            }
        });
        this.cSr = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.cSr.bcA.setOnClickListener(this);
        this.cSr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.akb() != null) {
                    t.this.akb().a(view2, t.this.cVR);
                }
                if (t.this.cVR != null && t.this.cVR.threadData != null) {
                    k.kc(t.this.cVR.threadData.getId());
                    t.this.kf(t.this.cVR.threadData.getId());
                }
            }
        });
        this.cTZ = view.findViewById(d.g.divider_line_above_praise);
        this.cVP = view.findViewById(d.g.card_divider_line);
        this.cVQ = (TbImageView) view.findViewById(d.g.thread_theme_card);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cTZ, d.C0107d.cp_bg_line_e);
            this.ciL.onChangeSkinType();
            this.ciK.onChangeSkinType();
            if (this.ciW != null) {
                this.ciW.onChangeSkinType();
            }
            this.cVw.onChangeSkinType();
            aj.t(this.cVP, d.C0107d.cp_bg_line_e);
            this.cSr.onChangeSkinType();
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
        this.cVR = beVar;
        bd bdVar = beVar.threadData;
        if (this.cVR.aPe == 1) {
            this.ciK.setFrom(3);
            H(bdVar);
        }
        this.ciK.setIsFromConcern(this.bcP);
        this.ciK.setData(bdVar);
        this.ciK.setUserAfterClickListener(this.bce);
        if (this.ciK.getHeaderImg() != null) {
            if (this.ciK.getIsSimpleThread()) {
                this.ciK.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (bdVar.yS() == null || bdVar.yS().getPendantData() == null || StringUtils.isNull(bdVar.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ciK.getHeaderImg().setVisibility(0);
                this.ciK.getHeaderImg().setData(bdVar);
            } else {
                this.ciK.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(bdVar);
            }
        }
        if (this.ciW != null) {
            SparseArray<String> xL = bdVar.xL();
            if (xL != null && xL.size() > 0 && this.cUc) {
                ah ahVar = new ah();
                ahVar.cK(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(xL);
                this.ciW.setData(ahVar);
                this.ciW.setFirstRowSingleColumn(true);
                this.ciW.setVisibility(G(bdVar) ? 8 : 0);
            } else {
                this.ciW.setVisibility(8);
            }
        }
        A(bdVar);
        this.cVw.b(bdVar.aOZ);
        lD(bdVar.aPa);
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        kf(bdVar.getId());
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
            k.a(this.mTitle, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        }
    }

    private boolean G(bd bdVar) {
        if (bdVar == null || bdVar.yS() == null || StringUtils.isNull(bdVar.yS().getUserId())) {
            return false;
        }
        return bdVar.yS().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ciW != null) {
            this.ciW.setUniqueId(bdUniqueId);
        }
        if (this.ciK != null) {
            this.ciK.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.ciW != null) {
            this.ciW.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout akG() {
        return this.ciL;
    }

    public ThreadCommentAndPraiseInfoLayout akH() {
        return this.cSr.bcA;
    }

    public void eG(boolean z) {
        if (this.cVP != null) {
            this.cVP.setVisibility(z ? 0 : 8);
        }
    }

    public void eC(boolean z) {
        this.cUc = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bcP = z;
    }

    private void akv() {
        if (this.cVR != null && this.cVR.threadData != null) {
            bd bdVar = this.cVR.threadData;
            k.kc(bdVar.getId());
            kf(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.cVR.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.yY());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            k.kc(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(String str) {
        k.a(this.mTitle, str, d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        k.a(this.cUa, str, d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        this.cVw.setReadState(k.kd(str));
    }

    public void H(bd bdVar) {
        MetaData yS;
        if (bdVar != null && this.cVQ != null && (yS = bdVar.yS()) != null) {
            final ThemeCardInUserData themeCard = yS.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cVQ.setVisibility(8);
                return;
            }
            this.cVQ.setVisibility(0);
            this.cVQ.setImageBitmap(null);
            this.cVQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akb() != null) {
            akb().a(view, this.cVR);
        }
        if (view == getView()) {
            akv();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciK != null) {
            return this.ciK.bbZ;
        }
        return null;
    }

    public View ake() {
        if (this.ciK != null) {
            return this.ciK.bca;
        }
        return null;
    }

    public void lD(int i) {
        if (this.cVR != null && this.cVR.threadData != null) {
            if (i == 1) {
                this.ciL.setVisibility(8);
                this.cSr.setFrom(this.cVR.aPd);
                this.cSr.setShareReportFrom(this.cVR.aPe);
                this.cSr.setStType(this.cVR.stType);
                this.cSr.setData(this.cVR.threadData);
                this.ciK.showForumNameView(false);
                return;
            }
            this.ciL.setFrom(this.cVR.aPd);
            this.ciL.setShareReportFrom(this.cVR.aPe);
            this.ciL.setStType(this.cVR.stType);
            this.ciL.setData(this.cVR.threadData);
            this.cSr.setVisibility(8);
            this.ciK.showForumNameView(true);
        }
    }
}
