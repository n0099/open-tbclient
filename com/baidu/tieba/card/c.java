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
    private final View.OnClickListener aLf;
    private ThreadGodReplyLayout cVS;
    private View cVT;
    protected com.baidu.tieba.card.data.k cVU;
    private View.OnClickListener cVV;
    private NEGFeedBackView cbJ;
    private String cbl;
    public ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    public ThreadSourceShareAndPraiseLayout ccl;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void aA(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbJ = null;
        this.mSkinType = 3;
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cVU);
                }
                c.this.fs(view == c.this.cVS);
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.cVU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cci = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbJ = new NEGFeedBackView(this.mPageContext);
        this.cbJ.a((ViewGroup) this.cci.getParent(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cVT = view.findViewById(e.g.divider_line);
        this.cby.setOnClickListener(this.cVV);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view2, c.this.cVU);
                }
                if (c.this.cVU != null && c.this.cVU.threadData != null) {
                    o.mW(c.this.cVU.threadData.getId());
                    if (!c.this.aqt()) {
                        c.this.aqu();
                    }
                }
            }
        });
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this.cVV);
        this.ccl.setShareReportFrom(3);
        this.ccl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view2, c.this.cVU);
                }
                if (c.this.cVU != null && c.this.cVU.threadData != null && view2 != c.this.ccl.aKM) {
                    o.mW(c.this.cVU.threadData.getId());
                    if (!c.this.aqt()) {
                        c.this.aqu();
                    }
                }
            }
        });
        this.cVS = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVS.setOnClickListener(this.cVV);
        aA(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cby.onChangeSkinType();
            this.cVS.onChangeSkinType();
            this.cbx.onChangeSkinType();
            if (this.cbJ != null) {
                this.cbJ.onChangeSkinType();
            }
            al.j(this.cVT, e.d.cp_bg_line_c);
            this.ccl.onChangeSkinType();
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
        this.cVU = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        if (this.cbJ != null && this.cVU.aaq() != null && kVar.threadData.zT() != null && !StringUtils.isNull(kVar.threadData.zT().getUserId())) {
            if (kVar.threadData.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cbJ.setVisibility(8);
            } else {
                this.cbJ.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cVU.aaq().getTid());
                ahVar.setFid(this.cVU.aaq().getFid());
                ahVar.a(this.cVU.asF);
                this.cbJ.setData(ahVar);
                this.cbJ.setFirstRowSingleColumn(true);
            }
        }
        this.cbx.setData(kVar.threadData);
        this.cVS.setData(kVar.threadData.Bk());
        if (!aqt() && o.mX(this.cVU.threadData.getId())) {
            aqu();
        }
        this.cbx.setUserAfterClickListener(this.aLf);
        bb aaq = kVar.aaq();
        if (this.cbx.getHeaderImg() != null) {
            if (this.cbx.getIsSimpleThread()) {
                this.cbx.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.cbx.getHeaderImg().setVisibility(0);
                this.cbx.getHeaderImg().setData(aaq);
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(aaq);
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
        if (this.cbJ != null) {
            this.cbJ.setUniqueId(bdUniqueId);
        }
        if (this.cbx != null) {
            this.cbx.setPageUniqueId(bdUniqueId);
        }
    }

    public View aqr() {
        return this.cVS;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbJ != null) {
            this.cbJ.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbx != null) {
            return this.cbx.aKS;
        }
        return null;
    }

    public View aqs() {
        if (this.cbx != null) {
            return this.cbx.aKU;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.cVU != null && this.cVU.threadData != null) {
            if (!aqt()) {
                o.mW(this.cVU.threadData.getId());
                aqu();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVU.threadData, null, o.zH(), 18003, true, false, false).addLocateParam(this.cVU.ara());
            addLocateParam.setForumId(String.valueOf(this.cVU.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqt() {
        return this.cVU.dbK && !this.cVU.bap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqu() {
        o.a(this.cVS.getGodReplyContent(), this.cVU.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.cVU != null && this.cVU.threadData != null) {
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setData(this.cVU.threadData);
                this.cbx.showForumNameView(false);
                return;
            }
            this.cby.setData(this.cVU.threadData);
            this.ccl.setVisibility(8);
            this.cbx.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }
}
