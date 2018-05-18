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
import com.baidu.tbadk.core.util.ak;
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
    private final View.OnClickListener apj;
    private String bwO;
    private HeadPendantClickableView bxM;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    private NEGFeedBackView bxn;
    private ThreadGodReplyLayout cnh;
    private View cni;
    protected com.baidu.tieba.card.data.k cnj;
    private View.OnClickListener cnk;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ac(View view2);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bxn = null;
        this.mSkinType = 3;
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cnj);
                }
                c.this.eo(view2 == c.this.cnh);
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cnj);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.bxM = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bxn = new NEGFeedBackView(this.mPageContext);
        this.bxn.a((ViewGroup) this.bxM.getParent(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.cni = view2.findViewById(d.g.divider_line);
        this.bxb.setOnClickListener(this.cnk);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view3, c.this.cnj);
                }
                if (c.this.cnj != null && c.this.cnj.threadData != null) {
                    o.ky(c.this.cnj.threadData.getId());
                    if (!c.this.afd()) {
                        c.this.afe();
                    }
                }
            }
        });
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this.cnk);
        this.bxQ.setShareReportFrom(3);
        this.bxQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view3, c.this.cnj);
                }
                if (c.this.cnj != null && c.this.cnj.threadData != null && view3 != c.this.bxQ.apF) {
                    o.ky(c.this.cnj.threadData.getId());
                    if (!c.this.afd()) {
                        c.this.afe();
                    }
                }
            }
        });
        this.cnh = (ThreadGodReplyLayout) view2.findViewById(d.g.card_home_page_god_reply_layout);
        this.cnh.setOnClickListener(this.cnk);
        ac(view2);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            this.bxb.onChangeSkinType();
            this.cnh.onChangeSkinType();
            this.bxa.onChangeSkinType();
            if (this.bxn != null) {
                this.bxn.onChangeSkinType();
            }
            ak.j(this.cni, d.C0126d.cp_bg_line_c);
            this.bxQ.onChangeSkinType();
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
        this.cnj = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cnk);
        }
        if (this.bxn != null && this.cnj.Pb() != null && kVar.threadData.rP() != null && !StringUtils.isNull(kVar.threadData.rP().getUserId())) {
            if (kVar.threadData.rP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bxn.setVisibility(8);
            } else {
                this.bxn.setVisibility(0);
                ai aiVar = new ai();
                aiVar.cJ(this.cnj.Pb().getTid());
                aiVar.setFid(this.cnj.Pb().getFid());
                aiVar.a(this.cnj.YI);
                this.bxn.setData(aiVar);
                this.bxn.setFirstRowSingleColumn(true);
            }
        }
        this.bxa.setData(kVar.threadData);
        this.cnh.setData(kVar.threadData.tb());
        if (!afd() && o.kz(this.cnj.threadData.getId())) {
            afe();
        }
        this.bxa.setUserAfterClickListener(this.apj);
        bd Pb = kVar.Pb();
        if (this.bxa.getHeaderImg() != null) {
            if (this.bxa.getIsSimpleThread()) {
                this.bxa.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (Pb.rP() == null || Pb.rP().getPendantData() == null || StringUtils.isNull(Pb.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.bxa.getHeaderImg().setVisibility(0);
                this.bxa.getHeaderImg().setData(Pb);
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(Pb);
            }
        }
        b(kVar);
        hc(gn(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bxn != null) {
            this.bxn.setUniqueId(bdUniqueId);
        }
        if (this.bxa != null) {
            this.bxa.setPageUniqueId(bdUniqueId);
        }
    }

    public View afb() {
        return this.cnh;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bxn != null) {
            this.bxn.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bxa != null) {
            return this.bxa.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bxa != null) {
            return this.bxa.apg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        if (this.cnj != null && this.cnj.threadData != null) {
            if (!afd()) {
                o.ky(this.cnj.threadData.getId());
                afe();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cnj.threadData, null, o.rF(), 18003, true, false, false).addLocateParam(this.cnj.afJ());
            addLocateParam.setForumId(String.valueOf(this.cnj.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afd() {
        return this.cnj.cth && !this.cnj.aEg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afe() {
        o.a(this.cnh.getGodReplyContent(), this.cnj.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public void hc(int i) {
        if (this.cnj != null && this.cnj.threadData != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setData(this.cnj.threadData);
                this.bxa.showForumNameView(false);
                return;
            }
            this.bxb.setData(this.cnj.threadData);
            this.bxQ.setVisibility(8);
            this.bxa.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
