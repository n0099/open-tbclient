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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class c extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axO;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    private NEGFeedBackView bIa;
    private HeadPendantClickableView bIz;
    private ThreadGodReplyLayout cwv;
    private View cww;
    protected com.baidu.tieba.card.data.k cwx;
    private View.OnClickListener cwy;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ah(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.mSkinType = 3;
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.cwx);
                }
                c.this.es(view == c.this.cwv);
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.cwx);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bIz = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mPageContext);
        this.bIa.a((ViewGroup) this.bIz.getParent(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.cww = view.findViewById(d.g.divider_line);
        this.bHO.setOnClickListener(this.cwy);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view2, c.this.cwx);
                }
                if (c.this.cwx != null && c.this.cwx.threadData != null) {
                    o.kW(c.this.cwx.threadData.getId());
                    if (!c.this.aiD()) {
                        c.this.aiE();
                    }
                }
            }
        });
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this.cwy);
        this.bIC.setShareReportFrom(3);
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view2, c.this.cwx);
                }
                if (c.this.cwx != null && c.this.cwx.threadData != null && view2 != c.this.bIC.ayq) {
                    o.kW(c.this.cwx.threadData.getId());
                    if (!c.this.aiD()) {
                        c.this.aiE();
                    }
                }
            }
        });
        this.cwv = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cwv.setOnClickListener(this.cwy);
        ah(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            this.bHO.onChangeSkinType();
            this.cwv.onChangeSkinType();
            this.bHN.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            am.j(this.cww, d.C0140d.cp_bg_line_c);
            this.bIC.onChangeSkinType();
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
        this.cwx = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        if (this.bIa != null && this.cwx.Td() != null && kVar.threadData.vk() != null && !StringUtils.isNull(kVar.threadData.vk().getUserId())) {
            if (kVar.threadData.vk().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bIa.setVisibility(8);
            } else {
                this.bIa.setVisibility(0);
                ah ahVar = new ah();
                ahVar.dh(this.cwx.Td().getTid());
                ahVar.setFid(this.cwx.Td().getFid());
                ahVar.a(this.cwx.agt);
                this.bIa.setData(ahVar);
                this.bIa.setFirstRowSingleColumn(true);
            }
        }
        this.bHN.setData(kVar.threadData);
        this.cwv.setData(kVar.threadData.wx());
        if (!aiD() && o.kX(this.cwx.threadData.getId())) {
            aiE();
        }
        this.bHN.setUserAfterClickListener(this.axO);
        bb Td = kVar.Td();
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Td.vk() == null || Td.vk().getPendantData() == null || StringUtils.isNull(Td.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(Td);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Td);
            }
        }
        b(kVar);
        hn(gu(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bIa != null) {
            this.bIa.setUniqueId(bdUniqueId);
        }
        if (this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
    }

    public View aiB() {
        return this.cwv;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axK;
        }
        return null;
    }

    public View aiC() {
        if (this.bHN != null) {
            return this.bHN.axL;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cwx != null && this.cwx.threadData != null) {
            if (!aiD()) {
                o.kW(this.cwx.threadData.getId());
                aiE();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cwx.threadData, null, o.uY(), 18003, true, false, false).addLocateParam(this.cwx.ajj());
            addLocateParam.setForumId(String.valueOf(this.cwx.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiD() {
        return this.cwx.cCm && !this.cwx.aNy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiE() {
        o.a(this.cwv.getGodReplyContent(), this.cwx.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hn(int i) {
        if (this.cwx != null && this.cwx.threadData != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.cwx.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cwx.threadData);
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
