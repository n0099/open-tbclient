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
    private TbPageContext<?> ajP;
    private final View.OnClickListener amS;
    protected com.baidu.tieba.card.data.l bAA;
    private View.OnClickListener bAB;
    private HeadPendantClickableView bAv;
    private ThreadGodReplyLayout bAw;
    private View bAx;
    private com.baidu.tbadk.core.view.o bAy;
    private View bAz;
    public ThreadUserInfoLayout bgE;
    public ThreadCommentAndPraiseInfoLayout bgF;
    private int mSkinType;

    protected abstract void U(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bAy = null;
        this.mSkinType = 3;
        this.bAB = new d(this);
        this.amS = new e(this);
        View view = getView();
        this.ajP = tbPageContext;
        this.bAv = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bAv.getHeadView() != null) {
            this.bAv.getHeadView().setIsRound(true);
            this.bAv.getHeadView().setDrawBorder(false);
            this.bAv.getHeadView().setDefaultResource(17170445);
            this.bAv.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bAv.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bAv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        }
        this.bAv.wm();
        if (this.bAv.getPendantView() != null) {
            this.bAv.getPendantView().setIsRound(true);
            this.bAv.getPendantView().setDrawBorder(false);
        }
        this.bgF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bgE = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bAy = new com.baidu.tbadk.core.view.o(this.ajP);
        this.bAy.wr();
        this.bAy.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bgE.addView(this.bAy);
        if (this.bgF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bgF.setLayoutParams(layoutParams);
        }
        this.bAz = view.findViewById(w.h.divider_line);
        this.bgF.setOnClickListener(this.bAB);
        this.bgF.setReplyTimeVisible(false);
        this.bgF.setShowPraiseNum(true);
        this.bgF.setNeedAddPraiseIcon(true);
        this.bgF.setNeedAddReplyIcon(true);
        this.bgF.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bgF.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bgF.setForumAfterClickListener(new f(this));
        this.bAw = (ThreadGodReplyLayout) view.findViewById(w.h.card_home_page_god_reply_layout);
        this.bAw.setOnClickListener(this.bAB);
        U(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(getView(), w.g.addresslist_item_bg);
            this.bgF.onChangeSkinType();
            this.bAw.onChangeSkinType();
            this.bgE.onChangeSkinType();
            if (this.bAy != null) {
                this.bAy.onChangeSkinType();
            }
            com.baidu.tbadk.core.util.as.k(this.bAz, w.e.cp_bg_line_c);
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
        this.bAA = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bAB);
        }
        if (this.bAy != null && this.bAA.Mv() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bAy.setVisibility(8);
            } else {
                this.bAy.setVisibility(0);
                com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                aoVar.cu(this.bAA.Mv().getTid());
                aoVar.setFid(this.bAA.Mv().getFid());
                aoVar.a(this.bAA.Wh);
                this.bAy.setData(aoVar);
            }
        }
        this.bgE.a(lVar.threadData);
        this.bAw.setData(lVar.threadData.sE());
        if (!Vw() && at.iJ(this.bAA.threadData.getId())) {
            Vx();
        }
        this.bgE.setUserAfterClickListener(this.amS);
        this.bgF.a(lVar.threadData);
        this.bAx.setVisibility(0);
        com.baidu.tbadk.core.data.bm Mv = lVar.Mv();
        if (this.bgE.getHeaderImg() != null) {
            if (this.bgE.getIsSimpleThread()) {
                this.bgE.getHeaderImg().setVisibility(8);
                this.bAv.setVisibility(8);
            } else if (Mv.getAuthor() == null || Mv.getAuthor().getPendantData() == null || StringUtils.isNull(Mv.getAuthor().getPendantData().pI())) {
                this.bAv.setVisibility(8);
                this.bgE.getHeaderImg().setVisibility(0);
                this.bgE.getHeaderImg().setData(Mv);
            } else {
                this.bgE.getHeaderImg().setVisibility(4);
                this.bAv.setVisibility(0);
                this.bAv.setData(Mv);
            }
        }
        b(lVar);
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bAy != null) {
            this.bAy.setUniqueId(bdUniqueId);
        }
        if (this.bgE != null) {
            this.bgE.setPageUniqueId(bdUniqueId);
        }
    }

    public View Vu() {
        return this.bAw;
    }

    public void a(o.a aVar) {
        if (this.bAy != null) {
            this.bAy.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bgE != null) {
            return this.bgE.amN;
        }
        return null;
    }

    public View Vv() {
        if (this.bgE != null) {
            return this.bgE.amO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(boolean z) {
        if (this.bAA != null && this.bAA.threadData != null) {
            if (!Vw()) {
                at.iI(this.bAA.threadData.getId());
                Vx();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajP.getPageActivity()).createFromThreadCfg(this.bAA.threadData, null, at.ri(), 18003, true, false, false).addLocateParam(this.bAA.VT());
            addLocateParam.setForumId(String.valueOf(this.bAA.threadData.getFid()));
            if (this.bAA.bDU == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bAA.bDU);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Vw() {
        return this.bAA.bEm && !this.bAA.aBd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vx() {
        at.a(this.bAw.getGodReplyContent(), this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        at.a(this.bAw.getPraiseNum(), this.bAA.threadData.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
