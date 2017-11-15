package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private final View.OnClickListener anR;
    private HeadPendantClickableView bRc;
    private ThreadGodReplyLayout bRd;
    private com.baidu.tieba.NEGFeedBack.c bRe;
    private View bRf;
    protected com.baidu.tieba.card.data.l bRg;
    private View.OnClickListener bRh;
    public ThreadUserInfoLayout boI;
    public ThreadCommentAndPraiseInfoLayout boM;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ad(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bRe = null;
        this.mSkinType = 3;
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ZJ() != null) {
                    c.this.ZJ().a(view, c.this.bRg);
                }
                c.this.dD(view == c.this.bRd);
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ZJ() != null) {
                    c.this.ZJ().a(view, c.this.bRg);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bRc = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.boI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bRe = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bRe.KF();
        this.bRe.setLeftPadding((int) getContext().getResources().getDimension(d.e.ds60));
        this.boI.addView(this.bRe);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.bRf = view.findViewById(d.g.divider_line);
        this.boM.setOnClickListener(this.bRh);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setShareVisible(true);
        this.boM.setShareReportFrom(3);
        this.boM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.ZJ() != null) {
                    c.this.ZJ().a(view2, c.this.bRg);
                }
            }
        });
        this.bRd = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bRd.setOnClickListener(this.bRh);
        ad(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.boM.onChangeSkinType();
            this.bRd.onChangeSkinType();
            this.boI.onChangeSkinType();
            if (this.bRe != null) {
                this.bRe.onChangeSkinType();
            }
            aj.k(this.bRf, d.C0080d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.blt == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bRg = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bRh);
        }
        if (this.bRe != null && this.bRg.NA() != null && lVar.blt.rt() != null && !StringUtils.isNull(lVar.blt.rt().getUserId())) {
            if (lVar.blt.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bRe.setVisibility(8);
            } else {
                this.bRe.setVisibility(0);
                al alVar = new al();
                alVar.cD(this.bRg.NA().getTid());
                alVar.setFid(this.bRg.NA().getFid());
                alVar.a(this.bRg.Xm);
                this.bRe.setData(alVar);
                this.bRe.setFirstRowSingleColumn(true);
            }
        }
        this.boI.setData(lVar.blt);
        this.bRd.setData(lVar.blt.sL());
        if (!ZN() && m.jM(this.bRg.blt.getId())) {
            ZO();
        }
        this.boI.setUserAfterClickListener(this.anR);
        this.boM.setData(lVar.blt);
        bh NA = lVar.NA();
        if (this.boI.getHeaderImg() != null) {
            if (this.boI.getIsSimpleThread()) {
                this.boI.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (NA.rt() == null || NA.rt().getPendantData() == null || StringUtils.isNull(NA.rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.boI.getHeaderImg().setVisibility(0);
                this.boI.getHeaderImg().setData(NA);
            } else {
                this.boI.getHeaderImg().setVisibility(4);
                this.bRc.setVisibility(0);
                this.bRc.setData(NA);
            }
        }
        b(lVar);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bRe != null) {
            this.bRe.setUniqueId(bdUniqueId);
        }
        if (this.boI != null) {
            this.boI.setPageUniqueId(bdUniqueId);
        }
    }

    public View ZL() {
        return this.bRd;
    }

    public void a(c.a aVar) {
        if (this.bRe != null) {
            this.bRe.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.boI != null) {
            return this.boI.anM;
        }
        return null;
    }

    public View ZM() {
        if (this.boI != null) {
            return this.boI.anN;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.bRg != null && this.bRg.blt != null) {
            if (!ZN()) {
                m.jL(this.bRg.blt.getId());
                ZO();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bRg.blt, null, m.rj(), 18003, true, false, false).addLocateParam(this.bRg.aan());
            addLocateParam.setForumId(String.valueOf(this.bRg.blt.getFid()));
            if (this.bRg.bUS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bRg.bUS);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZN() {
        return this.bRg.bVl && !this.bRg.aCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZO() {
        m.a(this.bRd.getGodReplyContent(), this.bRg.blt.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
