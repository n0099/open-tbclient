package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private final View.OnClickListener aou;
    private HeadPendantClickableView bKh;
    private ThreadGodReplyLayout bKi;
    private View bKj;
    private com.baidu.tbadk.core.view.h bKk;
    private View bKl;
    protected com.baidu.tieba.card.data.l bKm;
    private View.OnClickListener bKn;
    public ThreadUserInfoLayout blu;
    public ThreadCommentAndPraiseInfoLayout bly;
    private TbPageContext<?> mF;
    private int mSkinType;

    protected abstract void ab(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bKk = null;
        this.mSkinType = 3;
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view, c.this.bKm);
                }
                c.this.dI(view == c.this.bKi);
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view, c.this.bKm);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.bKh = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blu = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bKk = new com.baidu.tbadk.core.view.h(this.mF);
        this.bKk.wI();
        this.bKk.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blu.addView(this.bKk);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bKl = view.findViewById(d.h.divider_line);
        this.bly.setOnClickListener(this.bKn);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setShareVisible(true);
        this.bly.setShareReportFrom(3);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view2, c.this.bKm);
                }
            }
        });
        this.bKi = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bKi.setOnClickListener(this.bKn);
        ab(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bly.onChangeSkinType();
            this.bKi.onChangeSkinType();
            this.blu.onChangeSkinType();
            if (this.bKk != null) {
                this.bKk.onChangeSkinType();
            }
            aj.k(this.bKl, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bKm = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bKn);
        }
        if (this.bKk != null && this.bKm.MR() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bKk.setVisibility(8);
            } else {
                this.bKk.setVisibility(0);
                an anVar = new an();
                anVar.cy(this.bKm.MR().getTid());
                anVar.setFid(this.bKm.MR().getFid());
                anVar.a(this.bKm.Xf);
                this.bKk.setData(anVar);
                this.bKk.setFirstRowSingleColumn(true);
            }
        }
        this.blu.c(lVar.threadData);
        this.bKi.setData(lVar.threadData.sR());
        if (!XP() && m.jv(this.bKm.threadData.getId())) {
            XQ();
        }
        this.blu.setUserAfterClickListener(this.aou);
        this.bly.c(lVar.threadData);
        this.bKj.setVisibility(0);
        bj MR = lVar.MR();
        if (this.blu.getHeaderImg() != null) {
            if (this.blu.getIsSimpleThread()) {
                this.blu.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (MR.getAuthor() == null || MR.getAuthor().getPendantData() == null || StringUtils.isNull(MR.getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.blu.getHeaderImg().setVisibility(0);
                this.blu.getHeaderImg().setData(MR);
            } else {
                this.blu.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(MR);
            }
        }
        b(lVar);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bKk != null) {
            this.bKk.setUniqueId(bdUniqueId);
        }
        if (this.blu != null) {
            this.blu.setPageUniqueId(bdUniqueId);
        }
    }

    public View XN() {
        return this.bKi;
    }

    public void a(h.a aVar) {
        if (this.bKk != null) {
            this.bKk.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.blu != null) {
            return this.blu.aop;
        }
        return null;
    }

    public View XO() {
        if (this.blu != null) {
            return this.blu.aoq;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(boolean z) {
        if (this.bKm != null && this.bKm.threadData != null) {
            if (!XP()) {
                m.ju(this.bKm.threadData.getId());
                XQ();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.bKm.threadData, null, m.rs(), 18003, true, false, false).addLocateParam(this.bKm.Yn());
            addLocateParam.setForumId(String.valueOf(this.bKm.threadData.getFid()));
            if (this.bKm.bNJ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKm.bNJ);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XP() {
        return this.bKm.bOb && !this.bKm.aCG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XQ() {
        m.a(this.bKi.getGodReplyContent(), this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bKi.getPraiseNum(), this.bKm.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
