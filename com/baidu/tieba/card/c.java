package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private final View.OnClickListener aoX;
    private View bGA;
    protected com.baidu.tieba.card.data.l bGB;
    private View.OnClickListener bGC;
    private HeadPendantClickableView bGw;
    private ThreadGodReplyLayout bGx;
    private View bGy;
    private com.baidu.tbadk.core.view.h bGz;
    public ThreadUserInfoLayout bla;
    public ThreadCommentAndPraiseInfoLayout ble;
    private int mSkinType;
    private TbPageContext<?> oW;

    protected abstract void T(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGz = null;
        this.mSkinType = 3;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.bGB);
                }
                c.this.dE(view == c.this.bGx);
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.bGB);
                }
            }
        };
        View view = getView();
        this.oW = tbPageContext;
        this.bGw = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bla = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bGz = new com.baidu.tbadk.core.view.h(this.oW);
        this.bGz.wL();
        this.bGz.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bla.addView(this.bGz);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.bGA = view.findViewById(d.h.divider_line);
        this.ble.setOnClickListener(this.bGC);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.ble.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view2, c.this.bGB);
                }
            }
        });
        this.bGx = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bGx.setOnClickListener(this.bGC);
        T(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.ble.onChangeSkinType();
            this.bGx.onChangeSkinType();
            this.bla.onChangeSkinType();
            if (this.bGz != null) {
                this.bGz.onChangeSkinType();
            }
            ai.k(this.bGA, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bGB = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        if (this.bGz != null && this.bGB.MF() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bGz.setVisibility(8);
            } else {
                this.bGz.setVisibility(0);
                an anVar = new an();
                anVar.cI(this.bGB.MF().getTid());
                anVar.setFid(this.bGB.MF().getFid());
                anVar.a(this.bGB.XW);
                this.bGz.setData(anVar);
                this.bGz.setFirstRowSingleColumn(true);
            }
        }
        this.bla.a(lVar.threadData);
        this.bGx.setData(lVar.threadData.sV());
        if (!WB() && m.ji(this.bGB.threadData.getId())) {
            WC();
        }
        this.bla.setUserAfterClickListener(this.aoX);
        this.ble.a(lVar.threadData);
        this.bGy.setVisibility(0);
        bl MF = lVar.MF();
        if (this.bla.getHeaderImg() != null) {
            if (this.bla.getIsSimpleThread()) {
                this.bla.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.bla.getHeaderImg().setVisibility(0);
                this.bla.getHeaderImg().setData(MF);
            } else {
                this.bla.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(MF);
            }
        }
        b(lVar);
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bGz != null) {
            this.bGz.setUniqueId(bdUniqueId);
        }
        if (this.bla != null) {
            this.bla.setPageUniqueId(bdUniqueId);
        }
    }

    public View Wz() {
        return this.bGx;
    }

    public void a(h.a aVar) {
        if (this.bGz != null) {
            this.bGz.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bla != null) {
            return this.bla.aoS;
        }
        return null;
    }

    public View WA() {
        if (this.bla != null) {
            return this.bla.aoT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(boolean z) {
        if (this.bGB != null && this.bGB.threadData != null) {
            if (!WB()) {
                m.jh(this.bGB.threadData.getId());
                WC();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oW.getPageActivity()).createFromThreadCfg(this.bGB.threadData, null, m.rx(), 18003, true, false, false).addLocateParam(this.bGB.WZ());
            addLocateParam.setForumId(String.valueOf(this.bGB.threadData.getFid()));
            if (this.bGB.bKa == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bGB.bKa);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WB() {
        return this.bGB.bKs && !this.bGB.aDw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WC() {
        m.a(this.bGx.getGodReplyContent(), this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bGx.getPraiseNum(), this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
