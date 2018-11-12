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
    private final View.OnClickListener aHa;
    private String bWE;
    public ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    public ThreadSourceShareAndPraiseLayout bXE;
    private NEGFeedBackView bXc;
    private ThreadGodReplyLayout cLJ;
    private View cLK;
    protected com.baidu.tieba.card.data.k cLL;
    private View.OnClickListener cLM;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ax(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bXc = null;
        this.mSkinType = 3;
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.cLL);
                }
                c.this.fm(view == c.this.cLJ);
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.cLL);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bXB = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds70));
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bXc = new NEGFeedBackView(this.mPageContext);
        this.bXc.a((ViewGroup) this.bXB.getParent(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds120), 0);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.cLK = view.findViewById(e.g.divider_line);
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view2, c.this.cLL);
                }
                if (c.this.cLL != null && c.this.cLL.threadData != null) {
                    o.me(c.this.cLL.threadData.getId());
                    if (!c.this.anu()) {
                        c.this.anv();
                    }
                }
            }
        });
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this.cLM);
        this.bXE.setShareReportFrom(3);
        this.bXE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view2, c.this.cLL);
                }
                if (c.this.cLL != null && c.this.cLL.threadData != null && view2 != c.this.bXE.aGH) {
                    o.me(c.this.cLL.threadData.getId());
                    if (!c.this.anu()) {
                        c.this.anv();
                    }
                }
            }
        });
        this.cLJ = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cLJ.setOnClickListener(this.cLM);
        ax(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.bWR.onChangeSkinType();
            this.cLJ.onChangeSkinType();
            this.bWQ.onChangeSkinType();
            if (this.bXc != null) {
                this.bXc.onChangeSkinType();
            }
            al.j(this.cLK, e.d.cp_bg_line_c);
            this.bXE.onChangeSkinType();
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
        this.cLL = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cLM);
        }
        if (this.bXc != null && this.cLL.YL() != null && kVar.threadData.yC() != null && !StringUtils.isNull(kVar.threadData.yC().getUserId())) {
            if (kVar.threadData.yC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bXc.setVisibility(8);
            } else {
                this.bXc.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cLL.YL().getTid());
                ahVar.setFid(this.cLL.YL().getFid());
                ahVar.a(this.cLL.aoB);
                this.bXc.setData(ahVar);
                this.bXc.setFirstRowSingleColumn(true);
            }
        }
        this.bWQ.setData(kVar.threadData);
        this.cLJ.setData(kVar.threadData.zT());
        if (!anu() && o.mf(this.cLL.threadData.getId())) {
            anv();
        }
        this.bWQ.setUserAfterClickListener(this.aHa);
        bb YL = kVar.YL();
        if (this.bWQ.getHeaderImg() != null) {
            if (this.bWQ.getIsSimpleThread()) {
                this.bWQ.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (YL.yC() == null || YL.yC().getPendantData() == null || StringUtils.isNull(YL.yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.bWQ.getHeaderImg().setVisibility(0);
                this.bWQ.getHeaderImg().setData(YL);
            } else {
                this.bWQ.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(YL);
            }
        }
        b(kVar);
        ix(ho(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bXc != null) {
            this.bXc.setUniqueId(bdUniqueId);
        }
        if (this.bWQ != null) {
            this.bWQ.setPageUniqueId(bdUniqueId);
        }
    }

    public View ans() {
        return this.cLJ;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bXc != null) {
            this.bXc.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWQ != null) {
            return this.bWQ.aGN;
        }
        return null;
    }

    public View ant() {
        if (this.bWQ != null) {
            return this.bWQ.aGP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (this.cLL != null && this.cLL.threadData != null) {
            if (!anu()) {
                o.me(this.cLL.threadData.getId());
                anv();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cLL.threadData, null, o.yq(), 18003, true, false, false).addLocateParam(this.cLL.aob());
            addLocateParam.setForumId(String.valueOf(this.cLL.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anu() {
        return this.cLL.cRz && !this.cLL.aWe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anv() {
        o.a(this.cLJ.getGodReplyContent(), this.cLL.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ix(int i) {
        if (this.cLL != null && this.cLL.threadData != null) {
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setData(this.cLL.threadData);
                this.bWQ.showForumNameView(false);
                return;
            }
            this.bWR.setData(this.cLL.threadData);
            this.bXE.setVisibility(8);
            this.bWQ.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }
}
