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
/* loaded from: classes2.dex */
public abstract class c extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aBE;
    public ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    private NEGFeedBackView bNP;
    private String bNq;
    private HeadPendantClickableView bOo;
    public ThreadSourceShareAndPraiseLayout bOr;
    private ThreadGodReplyLayout cCi;
    private View cCj;
    protected com.baidu.tieba.card.data.k cCk;
    private View.OnClickListener cCl;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void av(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bNP = null;
        this.mSkinType = 3;
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.cCk);
                }
                c.this.eJ(view == c.this.cCi);
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.cCk);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bOo = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0141e.ds70));
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bNP = new NEGFeedBackView(this.mPageContext);
        this.bNP.a((ViewGroup) this.bOo.getParent(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds120), 0);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.cCj = view.findViewById(e.g.divider_line);
        this.bND.setOnClickListener(this.cCl);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view2, c.this.cCk);
                }
                if (c.this.cCk != null && c.this.cCk.threadData != null) {
                    o.lA(c.this.cCk.threadData.getId());
                    if (!c.this.akq()) {
                        c.this.akr();
                    }
                }
            }
        });
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this.cCl);
        this.bOr.setShareReportFrom(3);
        this.bOr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view2, c.this.cCk);
                }
                if (c.this.cCk != null && c.this.cCk.threadData != null && view2 != c.this.bOr.aBk) {
                    o.lA(c.this.cCk.threadData.getId());
                    if (!c.this.akq()) {
                        c.this.akr();
                    }
                }
            }
        });
        this.cCi = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cCi.setOnClickListener(this.cCl);
        av(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.bND.onChangeSkinType();
            this.cCi.onChangeSkinType();
            this.bNC.onChangeSkinType();
            if (this.bNP != null) {
                this.bNP.onChangeSkinType();
            }
            al.j(this.cCj, e.d.cp_bg_line_c);
            this.bOr.onChangeSkinType();
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
        this.cCk = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cCl);
        }
        if (this.bNP != null && this.cCk.UT() != null && kVar.threadData.wm() != null && !StringUtils.isNull(kVar.threadData.wm().getUserId())) {
            if (kVar.threadData.wm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bNP.setVisibility(8);
            } else {
                this.bNP.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cCk.UT().getTid());
                ahVar.setFid(this.cCk.UT().getFid());
                ahVar.a(this.cCk.aiT);
                this.bNP.setData(ahVar);
                this.bNP.setFirstRowSingleColumn(true);
            }
        }
        this.bNC.setData(kVar.threadData);
        this.cCi.setData(kVar.threadData.xD());
        if (!akq() && o.lB(this.cCk.threadData.getId())) {
            akr();
        }
        this.bNC.setUserAfterClickListener(this.aBE);
        bb UT = kVar.UT();
        if (this.bNC.getHeaderImg() != null) {
            if (this.bNC.getIsSimpleThread()) {
                this.bNC.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (UT.wm() == null || UT.wm().getPendantData() == null || StringUtils.isNull(UT.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.bNC.getHeaderImg().setVisibility(0);
                this.bNC.getHeaderImg().setData(UT);
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(UT);
            }
        }
        b(kVar);
        hM(gT(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bNP != null) {
            this.bNP.setUniqueId(bdUniqueId);
        }
        if (this.bNC != null) {
            this.bNC.setPageUniqueId(bdUniqueId);
        }
    }

    public View ako() {
        return this.cCi;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bNP != null) {
            this.bNP.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bNC != null) {
            return this.bNC.aBr;
        }
        return null;
    }

    public View akp() {
        if (this.bNC != null) {
            return this.bNC.aBt;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        if (this.cCk != null && this.cCk.threadData != null) {
            if (!akq()) {
                o.lA(this.cCk.threadData.getId());
                akr();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cCk.threadData, null, o.wa(), 18003, true, false, false).addLocateParam(this.cCk.akX());
            addLocateParam.setForumId(String.valueOf(this.cCk.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akq() {
        return this.cCk.cIa && !this.cCk.aQN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akr() {
        o.a(this.cCi.getGodReplyContent(), this.cCk.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hM(int i) {
        if (this.cCk != null && this.cCk.threadData != null) {
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setData(this.cCk.threadData);
                this.bNC.showForumNameView(false);
                return;
            }
            this.bND.setData(this.cCk.threadData);
            this.bOr.setVisibility(8);
            this.bNC.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }
}
