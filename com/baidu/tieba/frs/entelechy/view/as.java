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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class as extends com.baidu.tieba.card.a<bm> implements cg {
    private View aTm;
    protected bm aiu;
    private TbPageContext<?> ajP;
    private final View.OnClickListener amS;
    private View.OnClickListener bAB;
    private HeadPendantClickableView bAv;
    private ThreadGodReplyLayout bAw;
    private View bAx;
    private ThreadUserInfoLayout bgE;
    private ThreadCommentAndPraiseInfoLayout bgF;
    private com.baidu.tieba.frs.f.v chz;
    private String mForumName;
    private int mSkinType;

    protected abstract void U(View view);

    public as(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bAB = new at(this);
        this.amS = new au(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajP = tbPageContext;
        this.bAv = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bAv.getHeadView() != null) {
            this.bAv.getHeadView().setIsRound(true);
            this.bAv.getHeadView().setDrawBorder(false);
            this.bAv.getHeadView().setDefaultResource(17170445);
            this.bAv.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bAv.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bAv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
            this.bAv.setAfterClickListener(this.amS);
        }
        this.bAv.wm();
        if (this.bAv.getPendantView() != null) {
            this.bAv.getPendantView().setIsRound(true);
            this.bAv.getPendantView().setDrawBorder(false);
        }
        this.aTm = view.findViewById(w.h.divider_line);
        this.bgF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bgE = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bgE.setUserAfterClickListener(this.amS);
        this.bgE.setFrom(3);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
        if (this.bgF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bgF.setLayoutParams(layoutParams);
        }
        this.bgF.setOnClickListener(this.bAB);
        this.bgF.setReplyTimeVisible(false);
        this.bgF.setShowPraiseNum(true);
        this.bgF.setNeedAddPraiseIcon(true);
        this.bgF.setNeedAddReplyIcon(true);
        this.bgF.setIsBarViewVisible(false);
        this.bgF.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bgF.setPraiseIcon(w.g.icon_home_card_like_n);
        this.chz = new com.baidu.tieba.frs.f.v(this.ajP, this.bgE);
        this.chz.setUniqueId(getTag());
        this.bAw = (ThreadGodReplyLayout) view.findViewById(w.h.card_home_page_god_reply_layout);
        this.bAw.setOnClickListener(this.bAB);
        U(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.as.k(this.aTm, w.e.cp_bg_line_c);
            this.bgF.onChangeSkinType();
            this.bgE.onChangeSkinType();
            this.bAw.onChangeSkinType();
            this.chz.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: t */
    public void a(bm bmVar) {
        if (bmVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiu = bmVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bAB);
        }
        if (!Vw() && com.baidu.tieba.card.at.iJ(this.aiu.getId())) {
            Vx();
        }
        this.chz.L(this.aiu);
        this.bgE.a(this.aiu);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.ajP.getResources().getDimension(w.f.ds10);
        this.bgF.setLayoutParams(layoutParams);
        this.bAw.setData(this.aiu.sE());
        this.bgF.a(bmVar);
        this.bgE.setUserAfterClickListener(this.amS);
        this.bAx.setVisibility(0);
        if (this.bgE.getHeaderImg() != null) {
            if (this.bgE.getIsSimpleThread()) {
                this.bgE.getHeaderImg().setVisibility(8);
                this.bAv.setVisibility(8);
            } else if (bmVar.getAuthor() == null || bmVar.getAuthor().getPendantData() == null || StringUtils.isNull(bmVar.getAuthor().getPendantData().pI())) {
                this.bAv.setVisibility(8);
                this.bgE.getHeaderImg().setVisibility(0);
                this.bgE.getHeaderImg().setData(bmVar);
            } else {
                this.bgE.getHeaderImg().setVisibility(4);
                this.bAv.setVisibility(0);
                this.bAv.setData(bmVar);
            }
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bgF != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bgE != null) {
            this.bgE.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(boolean z) {
        if (this.aiu != null) {
            com.baidu.tieba.card.at.iI(this.aiu.getId());
            Vx();
            com.baidu.tbadk.core.data.o sn = this.aiu.sn();
            if (sn != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajP.getPageActivity(), sn.getCartoonId(), sn.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.aiu.YI;
            if (this.aiu.YH == 1 && lVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.TW;
                long j = lVar.TX;
                com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
                arVar.pageContext = this.ajP;
                arVar.bookId = str;
                arVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, arVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajP.getPageActivity()).createFromThreadCfg(this.aiu, null, com.baidu.tieba.card.at.ri(), 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiu.getFid()));
            addLocateParam.setForumName(this.aiu.rw());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Vw() {
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
    public void Vx() {
        com.baidu.tieba.card.at.a(this.bAw.getGodReplyContent(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        com.baidu.tieba.card.at.a(this.bAw.getPraiseNum(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
    }
}
