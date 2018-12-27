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
    private final View.OnClickListener aKC;
    private ThreadGodReplyLayout cVg;
    private View cVh;
    protected com.baidu.tieba.card.data.k cVi;
    private View.OnClickListener cVj;
    public ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    private NEGFeedBackView caX;
    private String caz;
    private HeadPendantClickableView cbw;
    public ThreadSourceShareAndPraiseLayout cbz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void aA(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caX = null;
        this.mSkinType = 3;
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.cVi);
                }
                c.this.fp(view == c.this.cVg);
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.cVi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cbw = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caX = new NEGFeedBackView(this.mPageContext);
        this.caX.a((ViewGroup) this.cbw.getParent(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.cVh = view.findViewById(e.g.divider_line);
        this.caM.setOnClickListener(this.cVj);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view2, c.this.cVi);
                }
                if (c.this.cVi != null && c.this.cVi.threadData != null) {
                    o.mG(c.this.cVi.threadData.getId());
                    if (!c.this.apW()) {
                        c.this.apX();
                    }
                }
            }
        });
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this.cVj);
        this.cbz.setShareReportFrom(3);
        this.cbz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view2, c.this.cVi);
                }
                if (c.this.cVi != null && c.this.cVi.threadData != null && view2 != c.this.cbz.aKj) {
                    o.mG(c.this.cVi.threadData.getId());
                    if (!c.this.apW()) {
                        c.this.apX();
                    }
                }
            }
        });
        this.cVg = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVg.setOnClickListener(this.cVj);
        aA(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.caM.onChangeSkinType();
            this.cVg.onChangeSkinType();
            this.caL.onChangeSkinType();
            if (this.caX != null) {
                this.caX.onChangeSkinType();
            }
            al.j(this.cVh, e.d.cp_bg_line_c);
            this.cbz.onChangeSkinType();
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
        this.cVi = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        if (this.caX != null && this.cVi.ZT() != null && kVar.threadData.zG() != null && !StringUtils.isNull(kVar.threadData.zG().getUserId())) {
            if (kVar.threadData.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.caX.setVisibility(8);
            } else {
                this.caX.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cVi.ZT().getTid());
                ahVar.setFid(this.cVi.ZT().getFid());
                ahVar.a(this.cVi.asc);
                this.caX.setData(ahVar);
                this.caX.setFirstRowSingleColumn(true);
            }
        }
        this.caL.setData(kVar.threadData);
        this.cVg.setData(kVar.threadData.AX());
        if (!apW() && o.mH(this.cVi.threadData.getId())) {
            apX();
        }
        this.caL.setUserAfterClickListener(this.aKC);
        bb ZT = kVar.ZT();
        if (this.caL.getHeaderImg() != null) {
            if (this.caL.getIsSimpleThread()) {
                this.caL.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (ZT.zG() == null || ZT.zG().getPendantData() == null || StringUtils.isNull(ZT.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.caL.getHeaderImg().setVisibility(0);
                this.caL.getHeaderImg().setData(ZT);
            } else {
                this.caL.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(ZT);
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
        if (this.caX != null) {
            this.caX.setUniqueId(bdUniqueId);
        }
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
    }

    public View apU() {
        return this.cVg;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caX != null) {
            this.caX.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caL != null) {
            return this.caL.aKp;
        }
        return null;
    }

    public View apV() {
        if (this.caL != null) {
            return this.caL.aKr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.cVi != null && this.cVi.threadData != null) {
            if (!apW()) {
                o.mG(this.cVi.threadData.getId());
                apX();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVi.threadData, null, o.zu(), 18003, true, false, false).addLocateParam(this.cVi.aqD());
            addLocateParam.setForumId(String.valueOf(this.cVi.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apW() {
        return this.cVi.daY && !this.cVi.aZE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apX() {
        o.a(this.cVg.getGodReplyContent(), this.cVi.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.cVi != null && this.cVi.threadData != null) {
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setData(this.cVi.threadData);
                this.caL.showForumNameView(false);
                return;
            }
            this.caM.setData(this.cVi.threadData);
            this.cbz.setVisibility(8);
            this.caL.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }
}
