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
    private String bvX;
    private HeadPendantClickableView bwV;
    public ThreadSourceShareAndPraiseLayout bwZ;
    public ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    private NEGFeedBackView bww;
    private ThreadGodReplyLayout cma;
    private View cmb;
    protected com.baidu.tieba.card.data.k cmc;
    private View.OnClickListener cme;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ac(View view2);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bww = null;
        this.mSkinType = 3;
        this.cme = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cmc);
                }
                c.this.en(view2 == c.this.cma);
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cmc);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.bwV = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bww = new NEGFeedBackView(this.mPageContext);
        this.bww.a((ViewGroup) this.bwV.getParent(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.cmb = view2.findViewById(d.g.divider_line);
        this.bwk.setOnClickListener(this.cme);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view3, c.this.cmc);
                }
                if (c.this.cmc != null && c.this.cmc.threadData != null) {
                    o.kv(c.this.cmc.threadData.getId());
                    if (!c.this.afd()) {
                        c.this.afe();
                    }
                }
            }
        });
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.cme);
        this.bwZ.setShareReportFrom(3);
        this.bwZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view3, c.this.cmc);
                }
                if (c.this.cmc != null && c.this.cmc.threadData != null && view3 != c.this.bwZ.apF) {
                    o.kv(c.this.cmc.threadData.getId());
                    if (!c.this.afd()) {
                        c.this.afe();
                    }
                }
            }
        });
        this.cma = (ThreadGodReplyLayout) view2.findViewById(d.g.card_home_page_god_reply_layout);
        this.cma.setOnClickListener(this.cme);
        ac(view2);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            this.bwk.onChangeSkinType();
            this.cma.onChangeSkinType();
            this.bwj.onChangeSkinType();
            if (this.bww != null) {
                this.bww.onChangeSkinType();
            }
            ak.j(this.cmb, d.C0126d.cp_bg_line_c);
            this.bwZ.onChangeSkinType();
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
        this.cmc = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cme);
        }
        if (this.bww != null && this.cmc.Pe() != null && kVar.threadData.rQ() != null && !StringUtils.isNull(kVar.threadData.rQ().getUserId())) {
            if (kVar.threadData.rQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bww.setVisibility(8);
            } else {
                this.bww.setVisibility(0);
                ai aiVar = new ai();
                aiVar.cJ(this.cmc.Pe().getTid());
                aiVar.setFid(this.cmc.Pe().getFid());
                aiVar.a(this.cmc.YI);
                this.bww.setData(aiVar);
                this.bww.setFirstRowSingleColumn(true);
            }
        }
        this.bwj.setData(kVar.threadData);
        this.cma.setData(kVar.threadData.tc());
        if (!afd() && o.kw(this.cmc.threadData.getId())) {
            afe();
        }
        this.bwj.setUserAfterClickListener(this.apj);
        bd Pe = kVar.Pe();
        if (this.bwj.getHeaderImg() != null) {
            if (this.bwj.getIsSimpleThread()) {
                this.bwj.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (Pe.rQ() == null || Pe.rQ().getPendantData() == null || StringUtils.isNull(Pe.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.bwj.getHeaderImg().setVisibility(0);
                this.bwj.getHeaderImg().setData(Pe);
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(Pe);
            }
        }
        b(kVar);
        hb(gm(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bww != null) {
            this.bww.setUniqueId(bdUniqueId);
        }
        if (this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
    }

    public View afb() {
        return this.cma;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bww != null) {
            this.bww.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bwj != null) {
            return this.bwj.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bwj != null) {
            return this.bwj.apg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(boolean z) {
        if (this.cmc != null && this.cmc.threadData != null) {
            if (!afd()) {
                o.kv(this.cmc.threadData.getId());
                afe();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cmc.threadData, null, o.rG(), 18003, true, false, false).addLocateParam(this.cmc.afJ());
            addLocateParam.setForumId(String.valueOf(this.cmc.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afd() {
        return this.cmc.csb && !this.cmc.aEf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afe() {
        o.a(this.cma.getGodReplyContent(), this.cmc.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public void hb(int i) {
        if (this.cmc != null && this.cmc.threadData != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setData(this.cmc.threadData);
                this.bwj.showForumNameView(false);
                return;
            }
            this.bwk.setData(this.cmc.threadData);
            this.bwZ.setVisibility(8);
            this.bwj.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
