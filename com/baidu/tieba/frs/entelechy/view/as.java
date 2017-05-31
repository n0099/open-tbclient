package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class as extends com.baidu.tieba.card.a<bl> implements cg {
    private View aRT;
    protected bl ahM;
    private TbPageContext<?> ajh;
    private final View.OnClickListener ama;
    private com.baidu.tieba.frs.f.ae bZq;
    private ThreadUserInfoLayout bdH;
    private ThreadCommentAndPraiseInfoLayout bdI;
    private HeadPendantClickableView bzC;
    private ThreadGodReplyLayout bzD;
    private View bzE;
    private View.OnClickListener bzI;
    private String mForumName;
    private int mSkinType;

    protected abstract void T(View view);

    public as(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bzI = new at(this);
        this.ama = new au(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajh = tbPageContext;
        this.bzC = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bzC.getHeadView() != null) {
            this.bzC.getHeadView().setIsRound(true);
            this.bzC.getHeadView().setDrawBorder(false);
            this.bzC.getHeadView().setDefaultResource(17170445);
            this.bzC.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bzC.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bzC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
            this.bzC.setAfterClickListener(this.ama);
        }
        this.bzC.vV();
        if (this.bzC.getPendantView() != null) {
            this.bzC.getPendantView().setIsRound(true);
            this.bzC.getPendantView().setDrawBorder(false);
        }
        this.aRT = view.findViewById(w.h.divider_line);
        this.bdI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bdH = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bdH.setUserAfterClickListener(this.ama);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
        if (this.bdI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bdI.setLayoutParams(layoutParams);
        }
        this.bdI.setOnClickListener(this.bzI);
        this.bdI.setReplyTimeVisible(false);
        this.bdI.setShowPraiseNum(true);
        this.bdI.setNeedAddPraiseIcon(true);
        this.bdI.setNeedAddReplyIcon(true);
        this.bdI.setIsBarViewVisible(false);
        this.bdI.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bdI.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bZq = new com.baidu.tieba.frs.f.ae(this.ajh, this.bdH);
        this.bZq.setUniqueId(getTag());
        this.bzD = (ThreadGodReplyLayout) view.findViewById(w.h.card_home_page_god_reply_layout);
        this.bzD.setOnClickListener(this.bzI);
        T(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.aRT, w.e.cp_bg_line_c);
            this.bdI.onChangeSkinType();
            this.bdH.onChangeSkinType();
            this.bzD.onChangeSkinType();
            this.bZq.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: r */
    public void a(bl blVar) {
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahM = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bzI);
        }
        if (!Uh() && com.baidu.tieba.card.at.ic(this.ahM.getId())) {
            Ui();
        }
        this.bZq.K(this.ahM);
        this.bdH.a(this.ahM);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.ajh.getResources().getDimension(w.f.ds10);
        this.bdI.setLayoutParams(layoutParams);
        this.bzD.setData(this.ahM.sG());
        this.bdI.a(blVar);
        this.bdH.setUserAfterClickListener(this.ama);
        this.bzE.setVisibility(0);
        if (this.bdH.getHeaderImg() != null) {
            if (this.bdH.getIsSimpleThread()) {
                this.bdH.getHeaderImg().setVisibility(8);
                this.bzC.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pL())) {
                this.bzC.setVisibility(8);
                this.bdH.getHeaderImg().setVisibility(0);
                this.bdH.getHeaderImg().setData(blVar);
            } else {
                this.bdH.getHeaderImg().setVisibility(4);
                this.bzC.setVisibility(0);
                this.bzC.setData(blVar);
            }
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdI != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdH != null) {
            this.bdH.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.ahM != null) {
            com.baidu.tieba.card.at.ib(this.ahM.getId());
            Ui();
            com.baidu.tbadk.core.data.n sq = this.ahM.sq();
            if (sq != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajh.getPageActivity(), sq.getCartoonId(), sq.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ahM.YH;
            if (this.ahM.YG == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.TX;
                long j = kVar.TY;
                com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                aqVar.pageContext = this.ajh;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajh.getPageActivity()).createFromThreadCfg(this.ahM, null, com.baidu.tieba.card.at.rl(), 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ahM.getFid()));
            addLocateParam.setForumName(this.ahM.rz());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Uh() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ui() {
        com.baidu.tieba.card.at.a(this.bzD.getGodReplyContent(), this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        com.baidu.tieba.card.at.a(this.bzD.getPraiseNum(), this.ahM.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
    }
}
