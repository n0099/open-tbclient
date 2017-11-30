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
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private final View.OnClickListener aob;
    private HeadPendantClickableView bZa;
    private ThreadGodReplyLayout bZb;
    private com.baidu.tieba.NEGFeedBack.c bZc;
    private View bZd;
    protected com.baidu.tieba.card.data.l bZe;
    private View.OnClickListener bZf;
    public ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ae(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZc = null;
        this.mSkinType = 3;
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abs() != null) {
                    c.this.abs().a(view, c.this.bZe);
                }
                c.this.dN(view == c.this.bZb);
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abs() != null) {
                    c.this.abs().a(view, c.this.bZe);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
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
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bZc = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bZc.a((ViewGroup) this.bZa.getParent(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bZd = view.findViewById(d.g.divider_line);
        this.bvH.setOnClickListener(this.bZf);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.setShareReportFrom(3);
        this.bvH.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.abs() != null) {
                    c.this.abs().a(view2, c.this.bZe);
                }
            }
        });
        this.bZb = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZb.setOnClickListener(this.bZf);
        ae(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bvH.onChangeSkinType();
            this.bZb.onChangeSkinType();
            this.bvD.onChangeSkinType();
            if (this.bZc != null) {
                this.bZc.onChangeSkinType();
            }
            aj.k(this.bZd, d.C0082d.cp_bg_line_c);
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
        this.bZe = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZf);
        }
        if (this.bZc != null && this.bZe.Ox() != null && lVar.threadData.rx() != null && !StringUtils.isNull(lVar.threadData.rx().getUserId())) {
            if (lVar.threadData.rx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bZc.setVisibility(8);
            } else {
                this.bZc.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cD(this.bZe.Ox().getTid());
                ahVar.setFid(this.bZe.Ox().getFid());
                ahVar.a(this.bZe.XE);
                this.bZc.setData(ahVar);
                this.bZc.setFirstRowSingleColumn(true);
            }
        }
        this.bvD.setData(lVar.threadData);
        this.bZb.setData(lVar.threadData.sO());
        if (!abw() && k.jR(this.bZe.threadData.getId())) {
            abx();
        }
        this.bvD.setUserAfterClickListener(this.aob);
        this.bvH.setData(lVar.threadData);
        bd Ox = lVar.Ox();
        if (this.bvD.getHeaderImg() != null) {
            if (this.bvD.getIsSimpleThread()) {
                this.bvD.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (Ox.rx() == null || Ox.rx().getPendantData() == null || StringUtils.isNull(Ox.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.bvD.getHeaderImg().setVisibility(0);
                this.bvD.getHeaderImg().setData(Ox);
            } else {
                this.bvD.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(Ox);
            }
        }
        b(lVar);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
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

    public View abu() {
        return this.bZb;
    }

    public void a(c.a aVar) {
        if (this.bZc != null) {
            this.bZc.setEventCallback(aVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(boolean z) {
        if (this.bZe != null && this.bZe.threadData != null) {
            if (!abw()) {
                k.jQ(this.bZe.threadData.getId());
                abx();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZe.threadData, null, k.rn(), 18003, true, false, false).addLocateParam(this.bZe.abW());
            addLocateParam.setForumId(String.valueOf(this.bZe.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abw() {
        return this.bZe.cdF && !this.bZe.aDh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abx() {
        k.a(this.bZb.getGodReplyContent(), this.bZe.threadData.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
