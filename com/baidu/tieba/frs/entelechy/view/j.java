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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bh;
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
public abstract class j extends com.baidu.tieba.card.a<bh> implements v {
    public View aWX;
    protected bh ajg;
    private final View.OnClickListener anJ;
    private View.OnClickListener bJA;
    private HeadPendantClickableView bJv;
    private ThreadGodReplyLayout bJw;
    private ThreadUserInfoLayout bnf;
    public ThreadCommentAndPraiseInfoLayout bnj;
    public LinearLayout bnn;
    public TbImageView csu;
    private boolean cwN;
    private com.baidu.tieba.frs.h.g cxD;
    public View cyj;
    private String mForumName;
    private TbPageContext<?> mG;
    private int mSkinType;

    protected abstract void aa(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xr() != null) {
                    j.this.Xr().a(view, j.this.ajg);
                }
                j.this.dA(view == j.this.bJw);
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xr() != null) {
                    j.this.Xr().a(view, j.this.ajg);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mG = tbPageContext;
        this.bJv = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
            this.bJv.setAfterClickListener(this.anJ);
        }
        this.bJv.wg();
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.aWX = view.findViewById(d.h.divider_line);
        this.cyj = view.findViewById(d.h.top_divider_line);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bnf = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bnf.setUserAfterClickListener(this.anJ);
        this.bnf.setFrom(3);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this.bJA);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setShareVisible(true);
        this.bnj.setShareReportFrom(1);
        this.bnj.setFrom(2);
        this.cxD = new com.baidu.tieba.frs.h.g(this.mG, this.bnf);
        this.cxD.setUniqueId(getTag());
        this.bJw = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJw.setOnClickListener(this.bJA);
        this.csu = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.csu.setPageId(getTag());
        this.bnn = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        aa(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.aWX, d.e.cp_bg_line_e);
            aj.k(this.cyj, d.e.cp_bg_line_e);
            this.bnj.onChangeSkinType();
            this.bnf.onChangeSkinType();
            this.bJw.onChangeSkinType();
            this.cxD.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajg = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJA);
        }
        if (!Xv() && m.jn(this.ajg.getId())) {
            Xw();
        }
        this.cxD.O(this.ajg);
        this.bnf.setData(this.ajg);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bnj.setLayoutParams(layoutParams);
        this.bJw.setData(this.ajg.sL());
        if (!this.cwN) {
            this.bnj.setData(bhVar);
        }
        this.bnf.setUserAfterClickListener(this.anJ);
        if (this.bnf.getHeaderImg() != null) {
            if (this.bnf.getIsSimpleThread()) {
                this.bnf.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (bhVar.getAuthor() == null || bhVar.getAuthor().getPendantData() == null || StringUtils.isNull(bhVar.getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.bnf.getHeaderImg().setVisibility(0);
                this.bnf.getHeaderImg().setData(bhVar);
            } else {
                this.bnf.getHeaderImg().setVisibility(4);
                this.bJv.setVisibility(0);
                this.bJv.setData(bhVar);
            }
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        F(bhVar);
    }

    public void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && this.csu != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.csu.setVisibility(8);
                return;
            }
            this.csu.setVisibility(0);
            this.csu.setImageBitmap(null);
            this.csu.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.csu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mG.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bnj != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bnf != null) {
            this.bnf.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(boolean z) {
        if (this.ajg != null) {
            m.jm(this.ajg.getId());
            Xw();
            n sr = this.ajg.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mG.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ajg.ZB;
            if (this.ajg.ZA == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Vf;
                long j = kVar.Vg;
                ao aoVar = new ao();
                aoVar.pageContext = this.mG;
                aoVar.VD = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mG.getPageActivity()).createFromThreadCfg(this.ajg, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajg.getFid()));
            addLocateParam.setForumName(this.ajg.rA());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xv() {
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
    public void Xw() {
        m.a(this.bJw.getGodReplyContent(), this.ajg.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    public void eW(boolean z) {
        this.cwN = z;
    }
}
