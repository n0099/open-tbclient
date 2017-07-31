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
    private TbPageContext<?> alI;
    private final View.OnClickListener aoW;
    private HeadPendantClickableView bFM;
    private ThreadGodReplyLayout bFN;
    private View bFO;
    private com.baidu.tbadk.core.view.h bFP;
    private View bFQ;
    protected com.baidu.tieba.card.data.l bFR;
    private View.OnClickListener bFS;
    public ThreadUserInfoLayout bkV;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    private int mSkinType;

    protected abstract void U(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFP = null;
        this.mSkinType = 3;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.We() != null) {
                    c.this.We().a(view, c.this.bFR);
                }
                c.this.dD(view == c.this.bFN);
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.We() != null) {
                    c.this.We().a(view, c.this.bFR);
                }
            }
        };
        View view = getView();
        this.alI = tbPageContext;
        this.bFM = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bkV = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bFP = new com.baidu.tbadk.core.view.h(this.alI);
        this.bFP.wK();
        this.bFP.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bkV.addView(this.bFP);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bFQ = view.findViewById(d.h.divider_line);
        this.bkZ.setOnClickListener(this.bFS);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bkZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.We() != null) {
                    c.this.We().a(view2, c.this.bFR);
                }
            }
        });
        this.bFN = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bFN.setOnClickListener(this.bFS);
        U(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bkZ.onChangeSkinType();
            this.bFN.onChangeSkinType();
            this.bkV.onChangeSkinType();
            if (this.bFP != null) {
                this.bFP.onChangeSkinType();
            }
            ai.k(this.bFQ, d.e.cp_bg_line_c);
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
        this.bFR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        if (this.bFP != null && this.bFR.MF() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bFP.setVisibility(8);
            } else {
                this.bFP.setVisibility(0);
                an anVar = new an();
                anVar.cF(this.bFR.MF().getTid());
                anVar.setFid(this.bFR.MF().getFid());
                anVar.a(this.bFR.XT);
                this.bFP.setData(anVar);
                this.bFP.setFirstRowSingleColumn(true);
            }
        }
        this.bkV.a(lVar.threadData);
        this.bFN.setData(lVar.threadData.sU());
        if (!Wi() && m.je(this.bFR.threadData.getId())) {
            Wj();
        }
        this.bkV.setUserAfterClickListener(this.aoW);
        this.bkZ.a(lVar.threadData);
        this.bFO.setVisibility(0);
        bl MF = lVar.MF();
        if (this.bkV.getHeaderImg() != null) {
            if (this.bkV.getIsSimpleThread()) {
                this.bkV.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.bkV.getHeaderImg().setVisibility(0);
                this.bkV.getHeaderImg().setData(MF);
            } else {
                this.bkV.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(MF);
            }
        }
        b(lVar);
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bFP != null) {
            this.bFP.setUniqueId(bdUniqueId);
        }
        if (this.bkV != null) {
            this.bkV.setPageUniqueId(bdUniqueId);
        }
    }

    public View Wg() {
        return this.bFN;
    }

    public void a(h.a aVar) {
        if (this.bFP != null) {
            this.bFP.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bkV != null) {
            return this.bkV.aoR;
        }
        return null;
    }

    public View Wh() {
        if (this.bkV != null) {
            return this.bkV.aoS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.bFR != null && this.bFR.threadData != null) {
            if (!Wi()) {
                m.jd(this.bFR.threadData.getId());
                Wj();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.alI.getPageActivity()).createFromThreadCfg(this.bFR.threadData, null, m.rw(), 18003, true, false, false).addLocateParam(this.bFR.WG());
            addLocateParam.setForumId(String.valueOf(this.bFR.threadData.getFid()));
            if (this.bFR.bJq == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bFR.bJq);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.alI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wi() {
        return this.bFR.bJI && !this.bFR.aDu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wj() {
        m.a(this.bFN.getGodReplyContent(), this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bFN.getPraiseNum(), this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
