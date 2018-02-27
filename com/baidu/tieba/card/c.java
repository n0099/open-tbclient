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
    private final View.OnClickListener bdQ;
    private ThreadGodReplyLayout cVu;
    private View cVv;
    protected com.baidu.tieba.card.data.k cVw;
    private View.OnClickListener cVx;
    public ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    public ThreadSourceShareAndPraiseLayout cmL;
    private com.baidu.tieba.NEGFeedBack.c cmj;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    protected abstract void by(View view);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmj = null;
        this.mSkinType = 3;
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akO() != null) {
                    c.this.akO().a(view, c.this.cVw);
                }
                c.this.eI(view == c.this.cVu);
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akO() != null) {
                    c.this.akO().a(view, c.this.cVw);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cmI = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmj = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cmj.a((ViewGroup) this.cmI.getParent(), com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120), 0);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.cVv = view.findViewById(d.g.divider_line);
        this.clX.setOnClickListener(this.cVx);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akO() != null) {
                    c.this.akO().a(view2, c.this.cVw);
                }
                if (c.this.cVw != null && c.this.cVw.threadData != null) {
                    j.kr(c.this.cVw.threadData.getId());
                    if (!c.this.akS()) {
                        c.this.akT();
                    }
                }
            }
        });
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this.cVx);
        this.cmL.setShareReportFrom(3);
        this.cmL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akO() != null) {
                    c.this.akO().a(view2, c.this.cVw);
                }
                if (c.this.cVw != null && c.this.cVw.threadData != null && view2 != c.this.cmL.bel) {
                    j.kr(c.this.cVw.threadData.getId());
                    if (!c.this.akS()) {
                        c.this.akT();
                    }
                }
            }
        });
        this.cVu = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVu.setOnClickListener(this.cVx);
        by(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.clX.onChangeSkinType();
            this.cVu.onChangeSkinType();
            this.clW.onChangeSkinType();
            if (this.cmj != null) {
                this.cmj.onChangeSkinType();
            }
            aj.t(this.cVv, d.C0141d.cp_bg_line_c);
            this.cmL.onChangeSkinType();
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
        this.cVw = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVx);
        }
        if (this.cmj != null && this.cVw.WD() != null && kVar.threadData.zn() != null && !StringUtils.isNull(kVar.threadData.zn().getUserId())) {
            if (kVar.threadData.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cmj.setVisibility(8);
            } else {
                this.cmj.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cV(this.cVw.WD().getTid());
                ahVar.setFid(this.cVw.WD().getFid());
                ahVar.a(this.cVw.aNg);
                this.cmj.setData(ahVar);
                this.cmj.setFirstRowSingleColumn(true);
            }
        }
        this.clW.setData(kVar.threadData);
        this.cVu.setData(kVar.threadData.AA());
        if (!akS() && j.ks(this.cVw.threadData.getId())) {
            akT();
        }
        this.clW.setUserAfterClickListener(this.bdQ);
        bd WD = kVar.WD();
        if (this.clW.getHeaderImg() != null) {
            if (this.clW.getIsSimpleThread()) {
                this.clW.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (WD.zn() == null || WD.zn().getPendantData() == null || StringUtils.isNull(WD.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.clW.getHeaderImg().setVisibility(0);
                this.clW.getHeaderImg().setData(WD);
            } else {
                this.clW.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(WD);
            }
        }
        b(kVar);
        jX(kVar.threadData.aQo);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cmj != null) {
            this.cmj.setUniqueId(bdUniqueId);
        }
        if (this.clW != null) {
            this.clW.setPageUniqueId(bdUniqueId);
        }
    }

    public View akQ() {
        return this.cVu;
    }

    public void a(c.a aVar) {
        if (this.cmj != null) {
            this.cmj.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clW != null) {
            return this.clW.bdL;
        }
        return null;
    }

    public View akR() {
        if (this.clW != null) {
            return this.clW.bdM;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.cVw != null && this.cVw.threadData != null) {
            if (!akS()) {
                j.kr(this.cVw.threadData.getId());
                akT();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVw.threadData, null, j.zd(), 18003, true, false, false).addLocateParam(this.cVw.alB());
            addLocateParam.setForumId(String.valueOf(this.cVw.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akS() {
        return this.cVw.cZZ && !this.cVw.btD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akT() {
        j.a(this.cVu.getGodReplyContent(), this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.cVw != null && this.cVw.threadData != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setData(this.cVw.threadData);
                this.clW.showForumNameView(false);
                return;
            }
            this.clX.setData(this.cVw.threadData);
            this.cmL.setVisibility(8);
            this.clW.showForumNameView(true);
        }
    }
}
