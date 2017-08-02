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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.tieba.card.a<bl> implements v {
    private View aUp;
    protected bl aiQ;
    private TbPageContext<?> ako;
    private final View.OnClickListener anD;
    private HeadPendantClickableView bEC;
    private ThreadGodReplyLayout bED;
    private View bEE;
    private View.OnClickListener bEI;
    private ThreadUserInfoLayout bjL;
    private ThreadCommentAndPraiseInfoLayout bjP;
    private com.baidu.tieba.frs.h.g cnw;
    private String mForumName;
    private int mSkinType;

    protected abstract void U(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.VZ() != null) {
                    j.this.VZ().a(view, j.this.aiQ);
                }
                j.this.dD(view == j.this.bED);
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.VZ() != null) {
                    j.this.VZ().a(view, j.this.aiQ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.ako = tbPageContext;
        this.bEC = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
            this.bEC.setAfterClickListener(this.anD);
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.aUp = view.findViewById(d.h.divider_line);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bjL = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bjL.setUserAfterClickListener(this.anD);
        this.bjL.setFrom(3);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bjP.setOnClickListener(this.bEI);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(true);
        this.bjP.setIsBarViewVisible(false);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.cnw = new com.baidu.tieba.frs.h.g(this.ako, this.bjL);
        this.cnw.setUniqueId(getTag());
        this.bED = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bED.setOnClickListener(this.bEI);
        U(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            ai.k(this.aUp, d.e.cp_bg_line_c);
            this.bjP.onChangeSkinType();
            this.bjL.onChangeSkinType();
            this.bED.onChangeSkinType();
            this.cnw.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiQ = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        if (!Wd() && m.iZ(this.aiQ.getId())) {
            We();
        }
        this.cnw.P(this.aiQ);
        this.bjL.a(this.aiQ);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.ako.getResources().getDimension(d.f.ds10);
        this.bjP.setLayoutParams(layoutParams);
        this.bED.setData(this.aiQ.sK());
        this.bjP.a(blVar);
        this.bjL.setUserAfterClickListener(this.anD);
        this.bEE.setVisibility(0);
        if (this.bjL.getHeaderImg() != null) {
            if (this.bjL.getIsSimpleThread()) {
                this.bjL.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.bjL.getHeaderImg().setVisibility(0);
                this.bjL.getHeaderImg().setData(blVar);
            } else {
                this.bjL.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(blVar);
            }
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bjP != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bjL != null) {
            this.bjL.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.aiQ != null) {
            m.iY(this.aiQ.getId());
            We();
            n sr = this.aiQ.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aM(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ako.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.aiQ.YZ;
            if (this.aiQ.YY == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Um;
                long j = kVar.Un;
                aq aqVar = new aq();
                aqVar.pageContext = this.ako;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ako.getPageActivity()).createFromThreadCfg(this.aiQ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiQ.getFid()));
            addLocateParam.setForumName(this.aiQ.rA());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ako.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wd() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void We() {
        m.a(this.bED.getGodReplyContent(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bED.getPraiseNum(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }
}
