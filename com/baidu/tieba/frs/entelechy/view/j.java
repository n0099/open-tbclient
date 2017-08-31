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
    private View aVm;
    protected bj ajF;
    private final View.OnClickListener aow;
    private HeadPendantClickableView bJq;
    private ThreadGodReplyLayout bJr;
    private View bJs;
    private View.OnClickListener bJw;
    public LinearLayout blD;
    private ThreadUserInfoLayout blv;
    private ThreadCommentAndPraiseInfoLayout blz;
    public TbImageView crf;
    private com.baidu.tieba.frs.h.g cvV;
    private TbPageContext<?> mF;
    private String mForumName;
    private int mSkinType;

    protected abstract void ab(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XA() != null) {
                    j.this.XA().a(view, j.this.ajF);
                }
                j.this.dH(view == j.this.bJr);
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XA() != null) {
                    j.this.XA().a(view, j.this.ajF);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        this.bJq = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
            this.bJq.setAfterClickListener(this.aow);
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.aVm = view.findViewById(d.h.divider_line);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blv = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.blv.setUserAfterClickListener(this.aow);
        this.blv.setFrom(3);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this.bJw);
        this.blz.setReplyTimeVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setIsBarViewVisible(false);
        this.blz.setShareVisible(true);
        this.blz.setShareReportFrom(1);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setFrom(2);
        this.cvV = new com.baidu.tieba.frs.h.g(this.mF, this.blv);
        this.cvV.setUniqueId(getTag());
        this.bJr = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJr.setOnClickListener(this.bJw);
        this.crf = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.crf.setPageId(getTag());
        this.blD = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        ab(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.aVm, d.e.cp_bg_line_c);
            this.blz.onChangeSkinType();
            this.blv.onChangeSkinType();
            this.bJr.onChangeSkinType();
            this.cvV.onChangeSkinType();
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
        this.ajF = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        if (!XE() && m.jt(this.ajF.getId())) {
            XF();
        }
        this.cvV.T(this.ajF);
        this.blv.c(this.ajF);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.mF.getResources().getDimension(d.f.ds10);
        this.blz.setLayoutParams(layoutParams);
        this.bJr.setData(this.ajF.sR());
        this.blz.c(bjVar);
        this.blv.setUserAfterClickListener(this.aow);
        this.bJs.setVisibility(0);
        if (this.blv.getHeaderImg() != null) {
            if (this.blv.getIsSimpleThread()) {
                this.blv.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (bjVar.getAuthor() == null || bjVar.getAuthor().getPendantData() == null || StringUtils.isNull(bjVar.getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.blv.getHeaderImg().setVisibility(0);
                this.blv.getHeaderImg().setData(bjVar);
            } else {
                this.blv.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(bjVar);
            }
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        K(bjVar);
    }

    public void K(bj bjVar) {
        MetaData author;
        if (bjVar != null && this.crf != null && (author = bjVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crf.setVisibility(8);
                return;
            }
            this.crf.setVisibility(0);
            this.crf.setImageBitmap(null);
            this.crf.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.crf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mF.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.blz != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.blv != null) {
            this.blv.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(boolean z) {
        if (this.ajF != null) {
            m.js(this.ajF.getId());
            XF();
            n sx = this.ajF.sx();
            if (sx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mF.getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ajF.ZB;
            if (this.ajF.ZA == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UR;
                long j = kVar.US;
                aq aqVar = new aq();
                aqVar.pageContext = this.mF;
                aqVar.Vp = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajF, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajF.getFid()));
            addLocateParam.setForumName(this.ajF.rG());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XE() {
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
    public void XF() {
        m.a(this.bJr.getGodReplyContent(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bJr.getPraiseNum(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }
}
