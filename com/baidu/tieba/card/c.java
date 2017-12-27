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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private ThreadGodReplyLayout cNP;
    private View cNQ;
    protected com.baidu.tieba.card.data.l cNR;
    private View.OnClickListener cNS;
    public ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    private com.baidu.tieba.NEGFeedBack.c ciP;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    protected abstract void bx(View view);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciP = null;
        this.mSkinType = 3;
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiY() != null) {
                    c.this.aiY().a(view, c.this.cNR);
                }
                c.this.ev(view == c.this.cNP);
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiY() != null) {
                    c.this.aiY().a(view, c.this.cNR);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
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
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciP = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.ciP.a((ViewGroup) this.cNO.getParent(), com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120), 0);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.cNQ = view.findViewById(d.g.divider_line);
        this.ciE.setOnClickListener(this.cNS);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.setShareReportFrom(3);
        this.ciE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aiY() != null) {
                    c.this.aiY().a(view2, c.this.cNR);
                }
                if (c.this.cNR != null && c.this.cNR.threadData != null) {
                    k.jT(c.this.cNR.threadData.getId());
                    if (!c.this.ajc()) {
                        c.this.ajd();
                    }
                }
            }
        });
        this.cNP = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cNP.setOnClickListener(this.cNS);
        bx(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.ciE.onChangeSkinType();
            this.cNP.onChangeSkinType();
            this.ciD.onChangeSkinType();
            if (this.ciP != null) {
                this.ciP.onChangeSkinType();
            }
            aj.t(this.cNQ, d.C0108d.cp_bg_line_c);
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
        this.cNR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cNS);
        }
        if (this.ciP != null && this.cNR.VW() != null && lVar.threadData.yX() != null && !StringUtils.isNull(lVar.threadData.yX().getUserId())) {
            if (lVar.threadData.yX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.ciP.setVisibility(8);
            } else {
                this.ciP.setVisibility(0);
                ai aiVar = new ai();
                aiVar.cK(this.cNR.VW().getTid());
                aiVar.setFid(this.cNR.VW().getFid());
                aiVar.a(this.cNR.aLZ);
                this.ciP.setData(aiVar);
                this.ciP.setFirstRowSingleColumn(true);
            }
        }
        this.ciD.setData(lVar.threadData);
        this.cNP.setData(lVar.threadData.Ao());
        if (!ajc() && k.jU(this.cNR.threadData.getId())) {
            ajd();
        }
        this.ciD.setUserAfterClickListener(this.bce);
        this.ciE.setData(lVar.threadData);
        be VW = lVar.VW();
        if (this.ciD.getHeaderImg() != null) {
            if (this.ciD.getIsSimpleThread()) {
                this.ciD.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (VW.yX() == null || VW.yX().getPendantData() == null || StringUtils.isNull(VW.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.ciD.getHeaderImg().setVisibility(0);
                this.ciD.getHeaderImg().setData(VW);
            } else {
                this.ciD.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(VW);
            }
        }
        b(lVar);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
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

    public View aja() {
        return this.cNP;
    }

    public void a(c.a aVar) {
        if (this.ciP != null) {
            this.ciP.setEventCallback(aVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(boolean z) {
        if (this.cNR != null && this.cNR.threadData != null) {
            if (!ajc()) {
                k.jT(this.cNR.threadData.getId());
                ajd();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cNR.threadData, null, k.yN(), 18003, true, false, false).addLocateParam(this.cNR.ajL());
            addLocateParam.setForumId(String.valueOf(this.cNR.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajc() {
        return this.cNR.cSB && !this.cNR.brk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajd() {
        k.a(this.cNP.getGodReplyContent(), this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
