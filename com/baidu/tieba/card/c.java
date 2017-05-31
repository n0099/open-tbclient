package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private TbPageContext<?> ajh;
    private final View.OnClickListener ama;
    public ThreadUserInfoLayout bdH;
    public ThreadCommentAndPraiseInfoLayout bdI;
    private HeadPendantClickableView bzC;
    private ThreadGodReplyLayout bzD;
    private View bzE;
    private com.baidu.tbadk.core.view.o bzF;
    private View bzG;
    protected com.baidu.tieba.card.data.l bzH;
    private View.OnClickListener bzI;
    private int mSkinType;

    protected abstract void T(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bzF = null;
        this.mSkinType = 3;
        this.bzI = new d(this);
        this.ama = new e(this);
        View view = getView();
        this.ajh = tbPageContext;
        this.bzC = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bzC.getHeadView() != null) {
            this.bzC.getHeadView().setIsRound(true);
            this.bzC.getHeadView().setDrawBorder(false);
            this.bzC.getHeadView().setDefaultResource(17170445);
            this.bzC.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bzC.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bzC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        }
        this.bzC.vV();
        if (this.bzC.getPendantView() != null) {
            this.bzC.getPendantView().setIsRound(true);
            this.bzC.getPendantView().setDrawBorder(false);
        }
        this.bdI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bdH = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bzF = new com.baidu.tbadk.core.view.o(this.ajh);
        this.bzF.wa();
        this.bzF.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bdH.addView(this.bzF);
        if (this.bdI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bdI.setLayoutParams(layoutParams);
        }
        this.bzG = view.findViewById(w.h.divider_line);
        this.bdI.setOnClickListener(this.bzI);
        this.bdI.setReplyTimeVisible(false);
        this.bdI.setShowPraiseNum(true);
        this.bdI.setNeedAddPraiseIcon(true);
        this.bdI.setNeedAddReplyIcon(true);
        this.bdI.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bdI.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bdI.setForumAfterClickListener(new f(this));
        this.bzD = (ThreadGodReplyLayout) view.findViewById(w.h.card_home_page_god_reply_layout);
        this.bzD.setOnClickListener(this.bzI);
        T(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            this.bdI.onChangeSkinType();
            this.bzD.onChangeSkinType();
            this.bdH.onChangeSkinType();
            if (this.bzF != null) {
                this.bzF.onChangeSkinType();
            }
            com.baidu.tbadk.core.util.aq.k(this.bzG, w.e.cp_bg_line_c);
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
        this.bzH = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bzI);
        }
        if (this.bzF != null && this.bzH.LH() != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.co(this.bzH.LH().getTid());
            anVar.setFid(this.bzH.LH().getFid());
            anVar.a(this.bzH.Wh);
            this.bzF.setData(anVar);
        }
        this.bdH.a(lVar.threadData);
        this.bzD.setData(lVar.threadData.sG());
        if (!Uh() && at.ic(this.bzH.threadData.getId())) {
            Ui();
        }
        this.bdH.setUserAfterClickListener(this.ama);
        this.bdI.a(lVar.threadData);
        this.bzE.setVisibility(0);
        com.baidu.tbadk.core.data.bl LH = lVar.LH();
        if (this.bdH.getHeaderImg() != null) {
            if (this.bdH.getIsSimpleThread()) {
                this.bdH.getHeaderImg().setVisibility(8);
                this.bzC.setVisibility(8);
            } else if (LH.getAuthor() == null || LH.getAuthor().getPendantData() == null || StringUtils.isNull(LH.getAuthor().getPendantData().pL())) {
                this.bzC.setVisibility(8);
                this.bdH.getHeaderImg().setVisibility(0);
                this.bdH.getHeaderImg().setData(LH);
            } else {
                this.bdH.getHeaderImg().setVisibility(4);
                this.bzC.setVisibility(0);
                this.bzC.setData(LH);
            }
        }
        b(lVar);
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bzF != null) {
            this.bzF.setUniqueId(bdUniqueId);
        }
        if (this.bdH != null) {
            this.bdH.setPageUniqueId(bdUniqueId);
        }
    }

    public View Uf() {
        return this.bzD;
    }

    public void a(o.a aVar) {
        if (this.bzF != null) {
            this.bzF.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bdH != null) {
            return this.bdH.alV;
        }
        return null;
    }

    public View Ug() {
        if (this.bdH != null) {
            return this.bdH.alW;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.bzH != null && this.bzH.threadData != null) {
            if (!Uh()) {
                at.ib(this.bzH.threadData.getId());
                Ui();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajh.getPageActivity()).createFromThreadCfg(this.bzH.threadData, null, at.rl(), 18003, true, false, false).addLocateParam(this.bzH.UC());
            addLocateParam.setForumId(String.valueOf(this.bzH.threadData.getFid()));
            if (this.bzH.bDb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bzH.bDb);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Uh() {
        return this.bzH.bDt && !this.bzH.aAa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ui() {
        at.a(this.bzD.getGodReplyContent(), this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        at.a(this.bzD.getPraiseNum(), this.bzH.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
