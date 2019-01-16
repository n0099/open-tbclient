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
    private final View.OnClickListener aLe;
    private ThreadGodReplyLayout cVR;
    private View cVS;
    protected com.baidu.tieba.card.data.k cVT;
    private View.OnClickListener cVU;
    private NEGFeedBackView cbI;
    private String cbk;
    public ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    public ThreadSourceShareAndPraiseLayout cck;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void aA(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbI = null;
        this.mSkinType = 3;
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cVT);
                }
                c.this.fs(view == c.this.cVR);
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cVT);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cch = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbI = new NEGFeedBackView(this.mPageContext);
        this.cbI.a((ViewGroup) this.cch.getParent(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cVS = view.findViewById(e.g.divider_line);
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view2, c.this.cVT);
                }
                if (c.this.cVT != null && c.this.cVT.threadData != null) {
                    o.mW(c.this.cVT.threadData.getId());
                    if (!c.this.aqt()) {
                        c.this.aqu();
                    }
                }
            }
        });
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this.cVU);
        this.cck.setShareReportFrom(3);
        this.cck.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view2, c.this.cVT);
                }
                if (c.this.cVT != null && c.this.cVT.threadData != null && view2 != c.this.cck.aKL) {
                    o.mW(c.this.cVT.threadData.getId());
                    if (!c.this.aqt()) {
                        c.this.aqu();
                    }
                }
            }
        });
        this.cVR = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVR.setOnClickListener(this.cVU);
        aA(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cbx.onChangeSkinType();
            this.cVR.onChangeSkinType();
            this.cbw.onChangeSkinType();
            if (this.cbI != null) {
                this.cbI.onChangeSkinType();
            }
            al.j(this.cVS, e.d.cp_bg_line_c);
            this.cck.onChangeSkinType();
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
        this.cVT = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        if (this.cbI != null && this.cVT.aaq() != null && kVar.threadData.zT() != null && !StringUtils.isNull(kVar.threadData.zT().getUserId())) {
            if (kVar.threadData.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cbI.setVisibility(8);
            } else {
                this.cbI.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cVT.aaq().getTid());
                ahVar.setFid(this.cVT.aaq().getFid());
                ahVar.a(this.cVT.asE);
                this.cbI.setData(ahVar);
                this.cbI.setFirstRowSingleColumn(true);
            }
        }
        this.cbw.setData(kVar.threadData);
        this.cVR.setData(kVar.threadData.Bk());
        if (!aqt() && o.mX(this.cVT.threadData.getId())) {
            aqu();
        }
        this.cbw.setUserAfterClickListener(this.aLe);
        bb aaq = kVar.aaq();
        if (this.cbw.getHeaderImg() != null) {
            if (this.cbw.getIsSimpleThread()) {
                this.cbw.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.cbw.getHeaderImg().setVisibility(0);
                this.cbw.getHeaderImg().setData(aaq);
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(aaq);
            }
        }
        b(kVar);
        iM(hD(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cbI != null) {
            this.cbI.setUniqueId(bdUniqueId);
        }
        if (this.cbw != null) {
            this.cbw.setPageUniqueId(bdUniqueId);
        }
    }

    public View aqr() {
        return this.cVR;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbI != null) {
            this.cbI.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbw != null) {
            return this.cbw.aKR;
        }
        return null;
    }

    public View aqs() {
        if (this.cbw != null) {
            return this.cbw.aKT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.cVT != null && this.cVT.threadData != null) {
            if (!aqt()) {
                o.mW(this.cVT.threadData.getId());
                aqu();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVT.threadData, null, o.zH(), 18003, true, false, false).addLocateParam(this.cVT.ara());
            addLocateParam.setForumId(String.valueOf(this.cVT.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqt() {
        return this.cVT.dbJ && !this.cVT.bao;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqu() {
        o.a(this.cVR.getGodReplyContent(), this.cVT.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.cVT != null && this.cVT.threadData != null) {
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setData(this.cVT.threadData);
                this.cbw.showForumNameView(false);
                return;
            }
            this.cbx.setData(this.cVT.threadData);
            this.cck.setVisibility(8);
            this.cbw.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }
}
