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
    protected com.baidu.tieba.card.data.l bGA;
    private View.OnClickListener bGB;
    private HeadPendantClickableView bGv;
    private ThreadGodReplyLayout bGw;
    private View bGx;
    private com.baidu.tbadk.core.view.h bGy;
    private View bGz;
    public ThreadUserInfoLayout bkZ;
    public ThreadCommentAndPraiseInfoLayout bld;
    private int mSkinType;
    private TbPageContext<?> oV;

    protected abstract void U(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGy = null;
        this.mSkinType = 3;
        this.bGB = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.WA() != null) {
                    c.this.WA().a(view, c.this.bGA);
                }
                c.this.dE(view == c.this.bGw);
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.WA() != null) {
                    c.this.WA().a(view, c.this.bGA);
                }
            }
        };
        View view = getView();
        this.oV = tbPageContext;
        this.bGv = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        }
        this.bGv.wD();
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bkZ = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bGx = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bGy = new com.baidu.tbadk.core.view.h(this.oV);
        this.bGy.wK();
        this.bGy.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bkZ.addView(this.bGy);
        if (this.bld.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bld.setLayoutParams(layoutParams);
        }
        this.bGz = view.findViewById(d.h.divider_line);
        this.bld.setOnClickListener(this.bGB);
        this.bld.setReplyTimeVisible(false);
        this.bld.setShowPraiseNum(true);
        this.bld.setNeedAddPraiseIcon(true);
        this.bld.setNeedAddReplyIcon(true);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bld.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.WA() != null) {
                    c.this.WA().a(view2, c.this.bGA);
                }
            }
        });
        this.bGw = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bGw.setOnClickListener(this.bGB);
        U(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bld.onChangeSkinType();
            this.bGw.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            if (this.bGy != null) {
                this.bGy.onChangeSkinType();
            }
            ai.k(this.bGz, d.e.cp_bg_line_c);
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
        this.bGA = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGB);
        }
        if (this.bGy != null && this.bGA.MF() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bGy.setVisibility(8);
            } else {
                this.bGy.setVisibility(0);
                an anVar = new an();
                anVar.cF(this.bGA.MF().getTid());
                anVar.setFid(this.bGA.MF().getFid());
                anVar.a(this.bGA.XV);
                this.bGy.setData(anVar);
                this.bGy.setFirstRowSingleColumn(true);
            }
        }
        this.bkZ.a(lVar.threadData);
        this.bGw.setData(lVar.threadData.sU());
        if (!WE() && m.jf(this.bGA.threadData.getId())) {
            WF();
        }
        this.bkZ.setUserAfterClickListener(this.aoX);
        this.bld.a(lVar.threadData);
        this.bGx.setVisibility(0);
        bl MF = lVar.MF();
        if (this.bkZ.getHeaderImg() != null) {
            if (this.bkZ.getIsSimpleThread()) {
                this.bkZ.getHeaderImg().setVisibility(8);
                this.bGv.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pV())) {
                this.bGv.setVisibility(8);
                this.bkZ.getHeaderImg().setVisibility(0);
                this.bkZ.getHeaderImg().setData(MF);
            } else {
                this.bkZ.getHeaderImg().setVisibility(4);
                this.bGv.setVisibility(0);
                this.bGv.setData(MF);
            }
        }
        b(lVar);
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bGy != null) {
            this.bGy.setUniqueId(bdUniqueId);
        }
        if (this.bkZ != null) {
            this.bkZ.setPageUniqueId(bdUniqueId);
        }
    }

    public View WC() {
        return this.bGw;
    }

    public void a(h.a aVar) {
        if (this.bGy != null) {
            this.bGy.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bkZ != null) {
            return this.bkZ.aoS;
        }
        return null;
    }

    public View WD() {
        if (this.bkZ != null) {
            return this.bkZ.aoT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(boolean z) {
        if (this.bGA != null && this.bGA.threadData != null) {
            if (!WE()) {
                m.je(this.bGA.threadData.getId());
                WF();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oV.getPageActivity()).createFromThreadCfg(this.bGA.threadData, null, m.rw(), 18003, true, false, false).addLocateParam(this.bGA.Xc());
            addLocateParam.setForumId(String.valueOf(this.bGA.threadData.getFid()));
            if (this.bGA.bJZ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bGA.bJZ);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WE() {
        return this.bGA.bKr && !this.bGA.aDv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WF() {
        m.a(this.bGw.getGodReplyContent(), this.bGA.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bGw.getPraiseNum(), this.bGA.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
