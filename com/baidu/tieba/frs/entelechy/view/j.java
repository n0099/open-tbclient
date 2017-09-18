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
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.tieba.card.a<bj> implements v {
    private View aVj;
    protected bj ajE;
    private final View.OnClickListener aou;
    private HeadPendantClickableView bKh;
    private ThreadGodReplyLayout bKi;
    private View bKj;
    private View.OnClickListener bKn;
    public LinearLayout blC;
    private ThreadUserInfoLayout blu;
    private ThreadCommentAndPraiseInfoLayout bly;
    public TbImageView crX;
    private com.baidu.tieba.frs.h.g cwN;
    private TbPageContext<?> mF;
    private String mForumName;
    private int mSkinType;

    protected abstract void ab(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XL() != null) {
                    j.this.XL().a(view, j.this.ajE);
                }
                j.this.dI(view == j.this.bKi);
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XL() != null) {
                    j.this.XL().a(view, j.this.ajE);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        this.bKh = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
            this.bKh.setAfterClickListener(this.aou);
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.aVj = view.findViewById(d.h.divider_line);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blu = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.blu.setUserAfterClickListener(this.aou);
        this.blu.setFrom(3);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this.bKn);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setIsBarViewVisible(false);
        this.bly.setShareVisible(true);
        this.bly.setShareReportFrom(1);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setFrom(2);
        this.cwN = new com.baidu.tieba.frs.h.g(this.mF, this.blu);
        this.cwN.setUniqueId(getTag());
        this.bKi = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bKi.setOnClickListener(this.bKn);
        this.crX = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.crX.setPageId(getTag());
        this.blC = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        ab(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.aVj, d.e.cp_bg_line_c);
            this.bly.onChangeSkinType();
            this.blu.onChangeSkinType();
            this.bKi.onChangeSkinType();
            this.cwN.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajE = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bKn);
        }
        if (!XP() && m.jv(this.ajE.getId())) {
            XQ();
        }
        this.cwN.T(this.ajE);
        this.blu.c(this.ajE);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.mF.getResources().getDimension(d.f.ds10);
        this.bly.setLayoutParams(layoutParams);
        this.bKi.setData(this.ajE.sR());
        this.bly.c(bjVar);
        this.blu.setUserAfterClickListener(this.aou);
        this.bKj.setVisibility(0);
        if (this.blu.getHeaderImg() != null) {
            if (this.blu.getIsSimpleThread()) {
                this.blu.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (bjVar.getAuthor() == null || bjVar.getAuthor().getPendantData() == null || StringUtils.isNull(bjVar.getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.blu.getHeaderImg().setVisibility(0);
                this.blu.getHeaderImg().setData(bjVar);
            } else {
                this.blu.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(bjVar);
            }
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        K(bjVar);
    }

    public void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && this.crX != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crX.setVisibility(8);
                return;
            }
            this.crX.setVisibility(0);
            this.crX.setImageBitmap(null);
            this.crX.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.crX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mF.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bly != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.blu != null) {
            this.blu.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(boolean z) {
        if (this.ajE != null) {
            m.ju(this.ajE.getId());
            XQ();
            n sx = this.ajE.sx();
            if (sx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ajE.ZB;
            if (this.ajE.ZA == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UR;
                long j = kVar.US;
                aq aqVar = new aq();
                aqVar.pageContext = this.mF;
                aqVar.Vp = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajE, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajE.getFid()));
            addLocateParam.setForumName(this.ajE.rG());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XP() {
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
    public void XQ() {
        m.a(this.bKi.getGodReplyContent(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bKi.getPraiseNum(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }
}
