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
    private final View.OnClickListener aKA;
    private ThreadGodReplyLayout cSq;
    private View cSr;
    protected com.baidu.tieba.card.data.k cSs;
    private View.OnClickListener cSt;
    public ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private NEGFeedBackView caU;
    private String caw;
    private HeadPendantClickableView cbt;
    public ThreadSourceShareAndPraiseLayout cbw;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ax(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caU = null;
        this.mSkinType = 3;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.cSs);
                }
                c.this.fn(view == c.this.cSq);
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.cSs);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cbt = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caU = new NEGFeedBackView(this.mPageContext);
        this.caU.a((ViewGroup) this.cbt.getParent(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.cSr = view.findViewById(e.g.divider_line);
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view2, c.this.cSs);
                }
                if (c.this.cSs != null && c.this.cSs.threadData != null) {
                    o.mD(c.this.cSs.threadData.getId());
                    if (!c.this.apg()) {
                        c.this.aph();
                    }
                }
            }
        });
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this.cSt);
        this.cbw.setShareReportFrom(3);
        this.cbw.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view2, c.this.cSs);
                }
                if (c.this.cSs != null && c.this.cSs.threadData != null && view2 != c.this.cbw.aKh) {
                    o.mD(c.this.cSs.threadData.getId());
                    if (!c.this.apg()) {
                        c.this.aph();
                    }
                }
            }
        });
        this.cSq = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cSq.setOnClickListener(this.cSt);
        ax(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.caJ.onChangeSkinType();
            this.cSq.onChangeSkinType();
            this.caI.onChangeSkinType();
            if (this.caU != null) {
                this.caU.onChangeSkinType();
            }
            al.j(this.cSr, e.d.cp_bg_line_c);
            this.cbw.onChangeSkinType();
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
        this.cSs = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        if (this.caU != null && this.cSs.ZR() != null && kVar.threadData.zG() != null && !StringUtils.isNull(kVar.threadData.zG().getUserId())) {
            if (kVar.threadData.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.caU.setVisibility(8);
            } else {
                this.caU.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cSs.ZR().getTid());
                ahVar.setFid(this.cSs.ZR().getFid());
                ahVar.a(this.cSs.asc);
                this.caU.setData(ahVar);
                this.caU.setFirstRowSingleColumn(true);
            }
        }
        this.caI.setData(kVar.threadData);
        this.cSq.setData(kVar.threadData.AX());
        if (!apg() && o.mE(this.cSs.threadData.getId())) {
            aph();
        }
        this.caI.setUserAfterClickListener(this.aKA);
        bb ZR = kVar.ZR();
        if (this.caI.getHeaderImg() != null) {
            if (this.caI.getIsSimpleThread()) {
                this.caI.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (ZR.zG() == null || ZR.zG().getPendantData() == null || StringUtils.isNull(ZR.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.caI.getHeaderImg().setVisibility(0);
                this.caI.getHeaderImg().setData(ZR);
            } else {
                this.caI.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(ZR);
            }
        }
        b(kVar);
        iL(hC(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.caU != null) {
            this.caU.setUniqueId(bdUniqueId);
        }
        if (this.caI != null) {
            this.caI.setPageUniqueId(bdUniqueId);
        }
    }

    public View ape() {
        return this.cSq;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caU != null) {
            this.caU.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caI != null) {
            return this.caI.aKn;
        }
        return null;
    }

    public View apf() {
        if (this.caI != null) {
            return this.caI.aKp;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (!apg()) {
                o.mD(this.cSs.threadData.getId());
                aph();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSs.threadData, null, o.zu(), 18003, true, false, false).addLocateParam(this.cSs.apO());
            addLocateParam.setForumId(String.valueOf(this.cSs.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apg() {
        return this.cSs.cYg && !this.cSs.aZB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aph() {
        o.a(this.cSq.getGodReplyContent(), this.cSs.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iL(int i) {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setData(this.cSs.threadData);
                this.caI.showForumNameView(false);
                return;
            }
            this.caJ.setData(this.cSs.threadData);
            this.cbw.setVisibility(8);
            this.caI.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }
}
