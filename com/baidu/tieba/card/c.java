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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
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
    private final View.OnClickListener axr;
    private String bER;
    private HeadPendantClickableView bFP;
    public ThreadSourceShareAndPraiseLayout bFT;
    public ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    private NEGFeedBackView bFq;
    private ThreadGodReplyLayout cvM;
    private View cvN;
    protected com.baidu.tieba.card.data.k cvO;
    private View.OnClickListener cvP;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ac(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFq = null;
        this.mSkinType = 3;
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, c.this.cvO);
                }
                c.this.es(view == c.this.cvM);
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, c.this.cvO);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bFP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bFq = new NEGFeedBackView(this.mPageContext);
        this.bFq.a((ViewGroup) this.bFP.getParent(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.cvN = view.findViewById(d.g.divider_line);
        this.bFe.setOnClickListener(this.cvP);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view2, c.this.cvO);
                }
                if (c.this.cvO != null && c.this.cvO.threadData != null) {
                    o.lb(c.this.cvO.threadData.getId());
                    if (!c.this.aiM()) {
                        c.this.aiN();
                    }
                }
            }
        });
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this.cvP);
        this.bFT.setShareReportFrom(3);
        this.bFT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view2, c.this.cvO);
                }
                if (c.this.cvO != null && c.this.cvO.threadData != null && view2 != c.this.bFT.axM) {
                    o.lb(c.this.cvO.threadData.getId());
                    if (!c.this.aiM()) {
                        c.this.aiN();
                    }
                }
            }
        });
        this.cvM = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cvM.setOnClickListener(this.cvP);
        ac(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            this.bFe.onChangeSkinType();
            this.cvM.onChangeSkinType();
            this.bFd.onChangeSkinType();
            if (this.bFq != null) {
                this.bFq.onChangeSkinType();
            }
            al.j(this.cvN, d.C0141d.cp_bg_line_c);
            this.bFT.onChangeSkinType();
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
        this.cvO = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cvP);
        }
        if (this.bFq != null && this.cvO.Sz() != null && kVar.threadData.vm() != null && !StringUtils.isNull(kVar.threadData.vm().getUserId())) {
            if (kVar.threadData.vm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bFq.setVisibility(8);
            } else {
                this.bFq.setVisibility(0);
                ai aiVar = new ai();
                aiVar.dh(this.cvO.Sz().getTid());
                aiVar.setFid(this.cvO.Sz().getFid());
                aiVar.a(this.cvO.agK);
                this.bFq.setData(aiVar);
                this.bFq.setFirstRowSingleColumn(true);
            }
        }
        this.bFd.setData(kVar.threadData);
        this.cvM.setData(kVar.threadData.wy());
        if (!aiM() && o.lc(this.cvO.threadData.getId())) {
            aiN();
        }
        this.bFd.setUserAfterClickListener(this.axr);
        bd Sz = kVar.Sz();
        if (this.bFd.getHeaderImg() != null) {
            if (this.bFd.getIsSimpleThread()) {
                this.bFd.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (Sz.vm() == null || Sz.vm().getPendantData() == null || StringUtils.isNull(Sz.vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.bFd.getHeaderImg().setVisibility(0);
                this.bFd.getHeaderImg().setData(Sz);
            } else {
                this.bFd.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(Sz);
            }
        }
        b(kVar);
        hd(go(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bFq != null) {
            this.bFq.setUniqueId(bdUniqueId);
        }
        if (this.bFd != null) {
            this.bFd.setPageUniqueId(bdUniqueId);
        }
    }

    public View aiK() {
        return this.cvM;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bFq != null) {
            this.bFq.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bFd != null) {
            return this.bFd.axn;
        }
        return null;
    }

    public View aiL() {
        if (this.bFd != null) {
            return this.bFd.axo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cvO != null && this.cvO.threadData != null) {
            if (!aiM()) {
                o.lb(this.cvO.threadData.getId());
                aiN();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cvO.threadData, null, o.vb(), 18003, true, false, false).addLocateParam(this.cvO.ajq());
            addLocateParam.setForumId(String.valueOf(this.cvO.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiM() {
        return this.cvO.cBM && !this.cvO.aMC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiN() {
        o.a(this.cvM.getGodReplyContent(), this.cvO.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hd(int i) {
        if (this.cvO != null && this.cvO.threadData != null) {
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setData(this.cvO.threadData);
                this.bFd.showForumNameView(false);
                return;
            }
            this.bFe.setData(this.cvO.threadData);
            this.bFT.setVisibility(8);
            this.bFd.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
