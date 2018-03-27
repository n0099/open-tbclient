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
public abstract class c extends a<com.baidu.tieba.card.data.k> {
    private final View.OnClickListener bdT;
    private View.OnClickListener cVA;
    private ThreadGodReplyLayout cVx;
    private View cVy;
    protected com.baidu.tieba.card.data.k cVz;
    public ThreadUserInfoLayout clZ;
    private HeadPendantClickableView cmL;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    private com.baidu.tieba.NEGFeedBack.c cmm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    protected abstract void by(View view);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmm = null;
        this.mSkinType = 3;
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cVz);
                }
                c.this.eI(view == c.this.cVx);
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cVz);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmm = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cmm.a((ViewGroup) this.cmL.getParent(), com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120), 0);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cVy = view.findViewById(d.g.divider_line);
        this.cma.setOnClickListener(this.cVA);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view2, c.this.cVz);
                }
                if (c.this.cVz != null && c.this.cVz.threadData != null) {
                    j.kr(c.this.cVz.threadData.getId());
                    if (!c.this.akT()) {
                        c.this.akU();
                    }
                }
            }
        });
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this.cVA);
        this.cmO.setShareReportFrom(3);
        this.cmO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view2, c.this.cVz);
                }
                if (c.this.cVz != null && c.this.cVz.threadData != null && view2 != c.this.cmO.beo) {
                    j.kr(c.this.cVz.threadData.getId());
                    if (!c.this.akT()) {
                        c.this.akU();
                    }
                }
            }
        });
        this.cVx = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVx.setOnClickListener(this.cVA);
        by(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cma.onChangeSkinType();
            this.cVx.onChangeSkinType();
            this.clZ.onChangeSkinType();
            if (this.cmm != null) {
                this.cmm.onChangeSkinType();
            }
            aj.t(this.cVy, d.C0141d.cp_bg_line_c);
            this.cmO.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        if (kVar == null || kVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cVz = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVA);
        }
        if (this.cmm != null && this.cVz.WE() != null && kVar.threadData.zn() != null && !StringUtils.isNull(kVar.threadData.zn().getUserId())) {
            if (kVar.threadData.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cmm.setVisibility(8);
            } else {
                this.cmm.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cV(this.cVz.WE().getTid());
                ahVar.setFid(this.cVz.WE().getFid());
                ahVar.a(this.cVz.aNh);
                this.cmm.setData(ahVar);
                this.cmm.setFirstRowSingleColumn(true);
            }
        }
        this.clZ.setData(kVar.threadData);
        this.cVx.setGrayScaleMode(kVar.threadData.AC());
        this.cVx.setData(kVar.threadData.AA());
        if (!akT() && j.ks(this.cVz.threadData.getId())) {
            akU();
        }
        this.clZ.setUserAfterClickListener(this.bdT);
        bd WE = kVar.WE();
        if (this.clZ.getHeaderImg() != null) {
            if (this.clZ.getIsSimpleThread()) {
                this.clZ.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.clZ.getHeaderImg().setVisibility(0);
                this.clZ.getHeaderImg().setData(WE);
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(WE);
            }
        }
        b(kVar);
        jX(kVar.threadData.aQp);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cmm != null) {
            this.cmm.setUniqueId(bdUniqueId);
        }
        if (this.clZ != null) {
            this.clZ.setPageUniqueId(bdUniqueId);
        }
    }

    public View akR() {
        return this.cVx;
    }

    public void a(c.a aVar) {
        if (this.cmm != null) {
            this.cmm.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clZ != null) {
            return this.clZ.bdO;
        }
        return null;
    }

    public View akS() {
        if (this.clZ != null) {
            return this.clZ.bdP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.cVz != null && this.cVz.threadData != null) {
            if (!akT()) {
                j.kr(this.cVz.threadData.getId());
                akU();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVz.threadData, null, j.zd(), 18003, true, false, false).addLocateParam(this.cVz.alC());
            addLocateParam.setForumId(String.valueOf(this.cVz.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akT() {
        return this.cVz.dac && !this.cVz.btG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akU() {
        j.a(this.cVx.getGodReplyContent(), this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.cVz != null && this.cVz.threadData != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setData(this.cVz.threadData);
                this.clZ.showForumNameView(false);
                return;
            }
            this.cma.setData(this.cVz.threadData);
            this.cmO.setVisibility(8);
            this.clZ.showForumNameView(true);
        }
    }
}
