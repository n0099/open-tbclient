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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public abstract class c extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axL;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    private NEGFeedBackView bIa;
    private HeadPendantClickableView bIz;
    private ThreadGodReplyLayout cws;
    private View cwt;
    protected com.baidu.tieba.card.data.k cwu;
    private View.OnClickListener cwv;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ah(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.mSkinType = 3;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.cwu);
                }
                c.this.es(view == c.this.cws);
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.cwu);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bIz = (HeadPendantClickableView) view.findViewById(f.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mPageContext);
        this.bIa.a((ViewGroup) this.bIz.getParent(), com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds120), 0);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.cwt = view.findViewById(f.g.divider_line);
        this.bHO.setOnClickListener(this.cwv);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view2, c.this.cwu);
                }
                if (c.this.cwu != null && c.this.cwu.threadData != null) {
                    o.kY(c.this.cwu.threadData.getId());
                    if (!c.this.aiG()) {
                        c.this.aiH();
                    }
                }
            }
        });
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_link_thread_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this.cwv);
        this.bIC.setShareReportFrom(3);
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view2, c.this.cwu);
                }
                if (c.this.cwu != null && c.this.cwu.threadData != null && view2 != c.this.bIC.ayn) {
                    o.kY(c.this.cwu.threadData.getId());
                    if (!c.this.aiG()) {
                        c.this.aiH();
                    }
                }
            }
        });
        this.cws = (ThreadGodReplyLayout) view.findViewById(f.g.card_home_page_god_reply_layout);
        this.cws.setOnClickListener(this.cwv);
        ah(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.addresslist_item_bg);
            this.bHO.onChangeSkinType();
            this.cws.onChangeSkinType();
            this.bHN.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            am.j(this.cwt, f.d.cp_bg_line_c);
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
        this.cwu = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwv);
        }
        if (this.bIa != null && this.cwu.Tg() != null && kVar.threadData.vj() != null && !StringUtils.isNull(kVar.threadData.vj().getUserId())) {
            if (kVar.threadData.vj().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bIa.setVisibility(8);
            } else {
                this.bIa.setVisibility(0);
                ah ahVar = new ah();
                ahVar.setTid(this.cwu.Tg().getTid());
                ahVar.setFid(this.cwu.Tg().getFid());
                ahVar.a(this.cwu.agt);
                this.bIa.setData(ahVar);
                this.bIa.setFirstRowSingleColumn(true);
            }
        }
        this.bHN.setData(kVar.threadData);
        this.cws.setData(kVar.threadData.ww());
        if (!aiG() && o.kZ(this.cwu.threadData.getId())) {
            aiH();
        }
        this.bHN.setUserAfterClickListener(this.axL);
        bb Tg = kVar.Tg();
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Tg.vj() == null || Tg.vj().getPendantData() == null || StringUtils.isNull(Tg.vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(Tg);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Tg);
            }
        }
        b(kVar);
        hm(gt(1));
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

    public View aiE() {
        return this.cws;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axH;
        }
        return null;
    }

    public View aiF() {
        if (this.bHN != null) {
            return this.bHN.axI;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cwu != null && this.cwu.threadData != null) {
            if (!aiG()) {
                o.kY(this.cwu.threadData.getId());
                aiH();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cwu.threadData, null, o.uX(), 18003, true, false, false).addLocateParam(this.cwu.ajm());
            addLocateParam.setForumId(String.valueOf(this.cwu.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiG() {
        return this.cwu.cCj && !this.cwu.aNv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiH() {
        o.a(this.cws.getGodReplyContent(), this.cwu.threadData.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hm(int i) {
        if (this.cwu != null && this.cwu.threadData != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.cwu.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cwu.threadData);
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
