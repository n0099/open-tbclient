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
    private View aVD;
    protected bl akl;
    private final View.OnClickListener aoX;
    private View.OnClickListener bGC;
    private HeadPendantClickableView bGw;
    private ThreadGodReplyLayout bGx;
    private View bGy;
    private ThreadUserInfoLayout bla;
    private ThreadCommentAndPraiseInfoLayout ble;
    private com.baidu.tieba.frs.g.g cpq;
    private String mForumName;
    private int mSkinType;
    private TbPageContext<?> oW;

    protected abstract void T(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Wx() != null) {
                    j.this.Wx().a(view, j.this.akl);
                }
                j.this.dE(view == j.this.bGx);
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Wx() != null) {
                    j.this.Wx().a(view, j.this.akl);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.oW = tbPageContext;
        this.bGw = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
            this.bGw.setAfterClickListener(this.aoX);
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.aVD = view.findViewById(d.h.divider_line);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bla = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bla.setUserAfterClickListener(this.aoX);
        this.bla.setFrom(3);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this.bGC);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setIsBarViewVisible(false);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.cpq = new com.baidu.tieba.frs.g.g(this.oW, this.bla);
        this.cpq.setUniqueId(getTag());
        this.bGx = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bGx.setOnClickListener(this.bGC);
        T(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            ai.k(this.aVD, d.e.cp_bg_line_c);
            this.ble.onChangeSkinType();
            this.bla.onChangeSkinType();
            this.bGx.onChangeSkinType();
            this.cpq.onChangeSkinType();
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
        this.akl = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        if (!WB() && m.ji(this.akl.getId())) {
            WC();
        }
        this.cpq.P(this.akl);
        this.bla.a(this.akl);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.oW.getResources().getDimension(d.f.ds10);
        this.ble.setLayoutParams(layoutParams);
        this.bGx.setData(this.akl.sV());
        this.ble.a(blVar);
        this.bla.setUserAfterClickListener(this.aoX);
        this.bGy.setVisibility(0);
        if (this.bla.getHeaderImg() != null) {
            if (this.bla.getIsSimpleThread()) {
                this.bla.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.bla.getHeaderImg().setVisibility(0);
                this.bla.getHeaderImg().setData(blVar);
            } else {
                this.bla.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(blVar);
            }
        }
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ble != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bla != null) {
            this.bla.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(boolean z) {
        if (this.akl != null) {
            m.jh(this.akl.getId());
            WC();
            n sC = this.akl.sC();
            if (sC != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.oW.getPageActivity(), sC.getCartoonId(), sC.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.akl.aax;
            if (this.akl.aaw == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VO;
                long j = kVar.VP;
                aq aqVar = new aq();
                aqVar.pageContext = this.oW;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oW.getPageActivity()).createFromThreadCfg(this.akl, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.akl.getFid()));
            addLocateParam.setForumName(this.akl.rL());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WB() {
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
    public void WC() {
        m.a(this.bGx.getGodReplyContent(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bGx.getPraiseNum(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }
}
