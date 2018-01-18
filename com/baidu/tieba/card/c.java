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
    private final View.OnClickListener bce;
    private ThreadGodReplyLayout cSp;
    private View cSq;
    public ThreadSourceShareAndPraiseLayout cSr;
    protected com.baidu.tieba.card.data.l cSs;
    private View.OnClickListener cSt;
    public ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private com.baidu.tieba.NEGFeedBack.c ciW;
    private HeadPendantClickableView cju;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    protected abstract void bz(View view);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciW = null;
        this.mSkinType = 3;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akb() != null) {
                    c.this.akb().a(view, c.this.cSs);
                }
                c.this.ez(view == c.this.cSp);
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akb() != null) {
                    c.this.akb().a(view, c.this.cSs);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
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
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciW = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.ciW.a((ViewGroup) this.cju.getParent(), com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120), 0);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.cSq = view.findViewById(d.g.divider_line);
        this.ciL.setOnClickListener(this.cSt);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akb() != null) {
                    c.this.akb().a(view2, c.this.cSs);
                }
                if (c.this.cSs != null && c.this.cSs.threadData != null) {
                    k.kc(c.this.cSs.threadData.getId());
                    if (!c.this.akf()) {
                        c.this.akg();
                    }
                }
            }
        });
        this.cSr = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cSr.bcA.setOnClickListener(this.cSt);
        this.cSr.setShareReportFrom(3);
        this.cSr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akb() != null) {
                    c.this.akb().a(view2, c.this.cSs);
                }
                if (c.this.cSs != null && c.this.cSs.threadData != null) {
                    k.kc(c.this.cSs.threadData.getId());
                    if (!c.this.akf()) {
                        c.this.akg();
                    }
                }
            }
        });
        this.cSp = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cSp.setOnClickListener(this.cSt);
        bz(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.ciL.onChangeSkinType();
            this.cSp.onChangeSkinType();
            this.ciK.onChangeSkinType();
            if (this.ciW != null) {
                this.ciW.onChangeSkinType();
            }
            aj.t(this.cSq, d.C0107d.cp_bg_line_c);
            this.cSr.onChangeSkinType();
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
        this.cSs = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        if (this.ciW != null && this.cSs.VK() != null && lVar.threadData.yS() != null && !StringUtils.isNull(lVar.threadData.yS().getUserId())) {
            if (lVar.threadData.yS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.ciW.setVisibility(8);
            } else {
                this.ciW.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cK(this.cSs.VK().getTid());
                ahVar.setFid(this.cSs.VK().getFid());
                ahVar.a(this.cSs.aLV);
                this.ciW.setData(ahVar);
                this.ciW.setFirstRowSingleColumn(true);
            }
        }
        this.ciK.setData(lVar.threadData);
        this.cSp.setData(lVar.threadData.Ag());
        if (!akf() && k.kd(this.cSs.threadData.getId())) {
            akg();
        }
        this.ciK.setUserAfterClickListener(this.bce);
        bd VK = lVar.VK();
        if (this.ciK.getHeaderImg() != null) {
            if (this.ciK.getIsSimpleThread()) {
                this.ciK.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (VK.yS() == null || VK.yS().getPendantData() == null || StringUtils.isNull(VK.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ciK.getHeaderImg().setVisibility(0);
                this.ciK.getHeaderImg().setData(VK);
            } else {
                this.ciK.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(VK);
            }
        }
        b(lVar);
        lD(lVar.threadData.aPa);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
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

    public View akd() {
        return this.cSp;
    }

    public void a(c.a aVar) {
        if (this.ciW != null) {
            this.ciW.setEventCallback(aVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(boolean z) {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (!akf()) {
                k.kc(this.cSs.threadData.getId());
                akg();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSs.threadData, null, k.yI(), 18003, true, false, false).addLocateParam(this.cSs.akO());
            addLocateParam.setForumId(String.valueOf(this.cSs.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akf() {
        return this.cSs.cXd && !this.cSs.brt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akg() {
        k.a(this.cSp.getGodReplyContent(), this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void lD(int i) {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (i == 1) {
                this.ciL.setVisibility(8);
                this.cSr.setData(this.cSs.threadData);
                this.ciK.showForumNameView(false);
                return;
            }
            this.ciL.setData(this.cSs.threadData);
            this.cSr.setVisibility(8);
            this.ciK.showForumNameView(true);
        }
    }
}
