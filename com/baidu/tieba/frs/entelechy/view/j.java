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
    public View aWK;
    protected bh aiU;
    private final View.OnClickListener anx;
    private HeadPendantClickableView bJj;
    private ThreadGodReplyLayout bJk;
    private View.OnClickListener bJo;
    private ThreadUserInfoLayout bmR;
    public ThreadCommentAndPraiseInfoLayout bmV;
    public LinearLayout bmZ;
    public TbImageView csi;
    private boolean cwB;
    public View cxX;
    private com.baidu.tieba.frs.h.g cxr;
    private String mForumName;
    private TbPageContext<?> mH;
    private int mSkinType;

    protected abstract void aa(View view);

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xn() != null) {
                    j.this.Xn().a(view, j.this.aiU);
                }
                j.this.dz(view == j.this.bJk);
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xn() != null) {
                    j.this.Xn().a(view, j.this.aiU);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mH = tbPageContext;
        this.bJj = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
            this.bJj.setAfterClickListener(this.anx);
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.aWK = view.findViewById(d.h.divider_line);
        this.cxX = view.findViewById(d.h.top_divider_line);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bmR = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bmR.setUserAfterClickListener(this.anx);
        this.bmR.setFrom(3);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this.bJo);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setShareVisible(true);
        this.bmV.setShareReportFrom(1);
        this.bmV.setFrom(2);
        this.cxr = new com.baidu.tieba.frs.h.g(this.mH, this.bmR);
        this.cxr.setUniqueId(getTag());
        this.bJk = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJk.setOnClickListener(this.bJo);
        this.csi = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.csi.setPageId(getTag());
        this.bmZ = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        aa(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.aWK, d.e.cp_bg_line_e);
            aj.k(this.cxX, d.e.cp_bg_line_e);
            this.bmV.onChangeSkinType();
            this.bmR.onChangeSkinType();
            this.bJk.onChangeSkinType();
            this.cxr.onChangeSkinType();
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
        this.aiU = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJo);
        }
        if (!Xr() && m.jm(this.aiU.getId())) {
            Xs();
        }
        this.cxr.O(this.aiU);
        this.bmR.setData(this.aiU);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bmV.setLayoutParams(layoutParams);
        this.bJk.setData(this.aiU.sE());
        if (!this.cwB) {
            this.bmV.setData(bhVar);
        }
        this.bmR.setUserAfterClickListener(this.anx);
        if (this.bmR.getHeaderImg() != null) {
            if (this.bmR.getIsSimpleThread()) {
                this.bmR.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (bhVar.getAuthor() == null || bhVar.getAuthor().getPendantData() == null || StringUtils.isNull(bhVar.getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.bmR.getHeaderImg().setVisibility(0);
                this.bmR.getHeaderImg().setData(bhVar);
            } else {
                this.bmR.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(bhVar);
            }
        }
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        F(bhVar);
    }

    public void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && this.csi != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.csi.setVisibility(8);
                return;
            }
            this.csi.setVisibility(0);
            this.csi.setImageBitmap(null);
            this.csi.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.csi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(j.this.mH.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bmV != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bmR != null) {
            this.bmR.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dz(boolean z) {
        if (this.aiU != null) {
            m.jl(this.aiU.getId());
            Xs();
            n sk = this.aiU.sk();
            if (sk != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mH.getPageActivity(), sk.getCartoonId(), sk.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.aiU.Zp;
            if (this.aiU.Zo == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UT;
                long j = kVar.UU;
                ao aoVar = new ao();
                aoVar.pageContext = this.mH;
                aoVar.Vr = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mH.getPageActivity()).createFromThreadCfg(this.aiU, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiU.getFid()));
            addLocateParam.setForumName(this.aiU.rt());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xr() {
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
    public void Xs() {
        m.a(this.bJk.getGodReplyContent(), this.aiU.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    public void eV(boolean z) {
        this.cwB = z;
    }
}
