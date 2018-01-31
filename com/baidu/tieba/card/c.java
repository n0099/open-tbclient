package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private final View.OnClickListener bcm;
    private ThreadGodReplyLayout cSK;
    private View cSL;
    public ThreadSourceShareAndPraiseLayout cSM;
    protected com.baidu.tieba.card.data.l cSN;
    private View.OnClickListener cSO;
    public ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    private com.baidu.tieba.NEGFeedBack.c cje;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    protected abstract void bz(View view);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cje = null;
        this.mSkinType = 3;
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akg() != null) {
                    c.this.akg().a(view, c.this.cSN);
                }
                c.this.eB(view == c.this.cSK);
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akg() != null) {
                    c.this.akg().a(view, c.this.cSN);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
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
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cje = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cje.a((ViewGroup) this.cjC.getParent(), com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120), 0);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.cSL = view.findViewById(d.g.divider_line);
        this.ciT.setOnClickListener(this.cSO);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akg() != null) {
                    c.this.akg().a(view2, c.this.cSN);
                }
                if (c.this.cSN != null && c.this.cSN.threadData != null) {
                    k.kj(c.this.cSN.threadData.getId());
                    if (!c.this.akk()) {
                        c.this.akl();
                    }
                }
            }
        });
        this.cSM = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cSM.bcI.setOnClickListener(this.cSO);
        this.cSM.setShareReportFrom(3);
        this.cSM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akg() != null) {
                    c.this.akg().a(view2, c.this.cSN);
                }
                if (c.this.cSN != null && c.this.cSN.threadData != null) {
                    k.kj(c.this.cSN.threadData.getId());
                    if (!c.this.akk()) {
                        c.this.akl();
                    }
                }
            }
        });
        this.cSK = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cSK.setOnClickListener(this.cSO);
        bz(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.ciT.onChangeSkinType();
            this.cSK.onChangeSkinType();
            this.ciS.onChangeSkinType();
            if (this.cje != null) {
                this.cje.onChangeSkinType();
            }
            aj.t(this.cSL, d.C0108d.cp_bg_line_c);
            this.cSM.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cSN = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSO);
        }
        if (this.cje != null && this.cSN.VM() != null && lVar.threadData.yT() != null && !StringUtils.isNull(lVar.threadData.yT().getUserId())) {
            if (lVar.threadData.yT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cje.setVisibility(8);
            } else {
                this.cje.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cK(this.cSN.VM().getTid());
                ahVar.setFid(this.cSN.VM().getFid());
                ahVar.a(this.cSN.aLY);
                this.cje.setData(ahVar);
                this.cje.setFirstRowSingleColumn(true);
            }
        }
        this.ciS.setData(lVar.threadData);
        this.cSK.setData(lVar.threadData.Ah());
        if (!akk() && k.kk(this.cSN.threadData.getId())) {
            akl();
        }
        this.ciS.setUserAfterClickListener(this.bcm);
        bd VM = lVar.VM();
        if (this.ciS.getHeaderImg() != null) {
            if (this.ciS.getIsSimpleThread()) {
                this.ciS.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (VM.yT() == null || VM.yT().getPendantData() == null || StringUtils.isNull(VM.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ciS.getHeaderImg().setVisibility(0);
                this.ciS.getHeaderImg().setData(VM);
            } else {
                this.ciS.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(VM);
            }
        }
        b(lVar);
        lD(lVar.threadData.aPd);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
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

    public View aki() {
        return this.cSK;
    }

    public void a(c.a aVar) {
        if (this.cje != null) {
            this.cje.setEventCallback(aVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(boolean z) {
        if (this.cSN != null && this.cSN.threadData != null) {
            if (!akk()) {
                k.kj(this.cSN.threadData.getId());
                akl();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSN.threadData, null, k.yJ(), 18003, true, false, false).addLocateParam(this.cSN.akT());
            addLocateParam.setForumId(String.valueOf(this.cSN.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akk() {
        return this.cSN.cXy && !this.cSN.brC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akl() {
        k.a(this.cSK.getGodReplyContent(), this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void lD(int i) {
        if (this.cSN != null && this.cSN.threadData != null) {
            if (i == 1) {
                this.ciT.setVisibility(8);
                this.cSM.setData(this.cSN.threadData);
                this.ciS.showForumNameView(false);
                return;
            }
            this.ciT.setData(this.cSN.threadData);
            this.cSM.setVisibility(8);
            this.ciS.showForumNameView(true);
        }
    }
}
