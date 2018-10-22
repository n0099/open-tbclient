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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class c extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aGk;
    private String bVS;
    private HeadPendantClickableView bWP;
    public ThreadSourceShareAndPraiseLayout bWS;
    public ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    private NEGFeedBackView bWq;
    private ThreadGodReplyLayout cKD;
    private View cKE;
    protected com.baidu.tieba.card.data.k cKF;
    private View.OnClickListener cKG;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void av(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bWq = null;
        this.mSkinType = 3;
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view, c.this.cKF);
                }
                c.this.fb(view == c.this.cKD);
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view, c.this.cKF);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bWP = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0175e.ds70));
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bWq = new NEGFeedBackView(this.mPageContext);
        this.bWq.a((ViewGroup) this.bWP.getParent(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds120), 0);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.cKE = view.findViewById(e.g.divider_line);
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view2, c.this.cKF);
                }
                if (c.this.cKF != null && c.this.cKF.threadData != null) {
                    o.md(c.this.cKF.threadData.getId());
                    if (!c.this.anT()) {
                        c.this.anU();
                    }
                }
            }
        });
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this.cKG);
        this.bWS.setShareReportFrom(3);
        this.bWS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view2, c.this.cKF);
                }
                if (c.this.cKF != null && c.this.cKF.threadData != null && view2 != c.this.bWS.aFR) {
                    o.md(c.this.cKF.threadData.getId());
                    if (!c.this.anT()) {
                        c.this.anU();
                    }
                }
            }
        });
        this.cKD = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cKD.setOnClickListener(this.cKG);
        av(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.bWf.onChangeSkinType();
            this.cKD.onChangeSkinType();
            this.bWe.onChangeSkinType();
            if (this.bWq != null) {
                this.bWq.onChangeSkinType();
            }
            al.j(this.cKE, e.d.cp_bg_line_c);
            this.bWS.onChangeSkinType();
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
        this.cKF = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        if (this.bWq != null && this.cKF.YB() != null && kVar.threadData.yv() != null && !StringUtils.isNull(kVar.threadData.yv().getUserId())) {
            if (kVar.threadData.yv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bWq.setVisibility(8);
            } else {
                this.bWq.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cKF.YB().getTid());
                ahVar.setFid(this.cKF.YB().getFid());
                ahVar.a(this.cKF.anO);
                this.bWq.setData(ahVar);
                this.bWq.setFirstRowSingleColumn(true);
            }
        }
        this.bWe.setData(kVar.threadData);
        this.cKD.setData(kVar.threadData.zM());
        if (!anT() && o.me(this.cKF.threadData.getId())) {
            anU();
        }
        this.bWe.setUserAfterClickListener(this.aGk);
        bb YB = kVar.YB();
        if (this.bWe.getHeaderImg() != null) {
            if (this.bWe.getIsSimpleThread()) {
                this.bWe.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (YB.yv() == null || YB.yv().getPendantData() == null || StringUtils.isNull(YB.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.bWe.getHeaderImg().setVisibility(0);
                this.bWe.getHeaderImg().setData(YB);
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(YB);
            }
        }
        b(kVar);
        ik(hb(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bWq != null) {
            this.bWq.setUniqueId(bdUniqueId);
        }
        if (this.bWe != null) {
            this.bWe.setPageUniqueId(bdUniqueId);
        }
    }

    public View anR() {
        return this.cKD;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bWq != null) {
            this.bWq.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWe != null) {
            return this.bWe.aFX;
        }
        return null;
    }

    public View anS() {
        if (this.bWe != null) {
            return this.bWe.aFZ;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        if (this.cKF != null && this.cKF.threadData != null) {
            if (!anT()) {
                o.md(this.cKF.threadData.getId());
                anU();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cKF.threadData, null, o.yj(), 18003, true, false, false).addLocateParam(this.cKF.aoA());
            addLocateParam.setForumId(String.valueOf(this.cKF.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anT() {
        return this.cKF.cQt && !this.cKF.aVo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anU() {
        o.a(this.cKD.getGodReplyContent(), this.cKF.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ik(int i) {
        if (this.cKF != null && this.cKF.threadData != null) {
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setData(this.cKF.threadData);
                this.bWe.showForumNameView(false);
                return;
            }
            this.bWf.setData(this.cKF.threadData);
            this.bWS.setVisibility(8);
            this.bWe.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }
}
