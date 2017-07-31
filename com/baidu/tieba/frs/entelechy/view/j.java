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
    private View aVB;
    protected bl akj;
    private TbPageContext<?> alI;
    private final View.OnClickListener aoW;
    private HeadPendantClickableView bFM;
    private ThreadGodReplyLayout bFN;
    private View bFO;
    private View.OnClickListener bFS;
    private ThreadUserInfoLayout bkV;
    private ThreadCommentAndPraiseInfoLayout bkZ;
    private com.baidu.tieba.frs.g.g coH;
    private String mForumName;
    private int mSkinType;

    protected abstract void U(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.We() != null) {
                    j.this.We().a(view, j.this.akj);
                }
                j.this.dD(view == j.this.bFN);
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.We() != null) {
                    j.this.We().a(view, j.this.akj);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.alI = tbPageContext;
        this.bFM = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
            this.bFM.setAfterClickListener(this.aoW);
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.aVB = view.findViewById(d.h.divider_line);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bkV = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bkV.setUserAfterClickListener(this.aoW);
        this.bkV.setFrom(3);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this.bFS);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setIsBarViewVisible(false);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.coH = new com.baidu.tieba.frs.g.g(this.alI, this.bkV);
        this.coH.setUniqueId(getTag());
        this.bFN = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bFN.setOnClickListener(this.bFS);
        U(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            ai.k(this.aVB, d.e.cp_bg_line_c);
            this.bkZ.onChangeSkinType();
            this.bkV.onChangeSkinType();
            this.bFN.onChangeSkinType();
            this.coH.onChangeSkinType();
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
        this.akj = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        if (!Wi() && m.je(this.akj.getId())) {
            Wj();
        }
        this.coH.P(this.akj);
        this.bkV.a(this.akj);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.alI.getResources().getDimension(d.f.ds10);
        this.bkZ.setLayoutParams(layoutParams);
        this.bFN.setData(this.akj.sU());
        this.bkZ.a(blVar);
        this.bkV.setUserAfterClickListener(this.aoW);
        this.bFO.setVisibility(0);
        if (this.bkV.getHeaderImg() != null) {
            if (this.bkV.getIsSimpleThread()) {
                this.bkV.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.bkV.getHeaderImg().setVisibility(0);
                this.bkV.getHeaderImg().setData(blVar);
            } else {
                this.bkV.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(blVar);
            }
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkZ != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bkV != null) {
            this.bkV.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.akj != null) {
            m.jd(this.akj.getId());
            Wj();
            n sB = this.akj.sB();
            if (sB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.alI.getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.akj.aav;
            if (this.akj.aau == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VL;
                long j = kVar.VM;
                aq aqVar = new aq();
                aqVar.pageContext = this.alI;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.alI.getPageActivity()).createFromThreadCfg(this.akj, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.akj.getFid()));
            addLocateParam.setForumName(this.akj.rK());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.alI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wi() {
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
    public void Wj() {
        m.a(this.bFN.getGodReplyContent(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bFN.getPraiseNum(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }
}
