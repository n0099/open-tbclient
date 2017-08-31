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
    private final View.OnClickListener aow;
    private HeadPendantClickableView bJq;
    private ThreadGodReplyLayout bJr;
    private View bJs;
    private com.baidu.tbadk.core.view.h bJt;
    private View bJu;
    protected com.baidu.tieba.card.data.l bJv;
    private View.OnClickListener bJw;
    public ThreadUserInfoLayout blv;
    public ThreadCommentAndPraiseInfoLayout blz;
    private TbPageContext<?> mF;
    private int mSkinType;

    protected abstract void ab(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJt = null;
        this.mSkinType = 3;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view, c.this.bJv);
                }
                c.this.dH(view == c.this.bJr);
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view, c.this.bJv);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.bJq = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.blv = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bJt = new com.baidu.tbadk.core.view.h(this.mF);
        this.bJt.wI();
        this.bJt.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blv.addView(this.bJt);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.bJu = view.findViewById(d.h.divider_line);
        this.blz.setOnClickListener(this.bJw);
        this.blz.setReplyTimeVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setShareVisible(true);
        this.blz.setShareReportFrom(3);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view2, c.this.bJv);
                }
            }
        });
        this.bJr = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJr.setOnClickListener(this.bJw);
        ab(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.blz.onChangeSkinType();
            this.bJr.onChangeSkinType();
            this.blv.onChangeSkinType();
            if (this.bJt != null) {
                this.bJt.onChangeSkinType();
            }
            aj.k(this.bJu, d.e.cp_bg_line_c);
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
        this.bJv = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        if (this.bJt != null && this.bJv.MR() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bJt.setVisibility(8);
            } else {
                this.bJt.setVisibility(0);
                an anVar = new an();
                anVar.cy(this.bJv.MR().getTid());
                anVar.setFid(this.bJv.MR().getFid());
                anVar.a(this.bJv.Xf);
                this.bJt.setData(anVar);
                this.bJt.setFirstRowSingleColumn(true);
            }
        }
        this.blv.c(lVar.threadData);
        this.bJr.setData(lVar.threadData.sR());
        if (!XE() && m.jt(this.bJv.threadData.getId())) {
            XF();
        }
        this.blv.setUserAfterClickListener(this.aow);
        this.blz.c(lVar.threadData);
        this.bJs.setVisibility(0);
        bj MR = lVar.MR();
        if (this.blv.getHeaderImg() != null) {
            if (this.blv.getIsSimpleThread()) {
                this.blv.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (MR.getAuthor() == null || MR.getAuthor().getPendantData() == null || StringUtils.isNull(MR.getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.blv.getHeaderImg().setVisibility(0);
                this.blv.getHeaderImg().setData(MR);
            } else {
                this.blv.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(MR);
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
        if (this.bJt != null) {
            this.bJt.setUniqueId(bdUniqueId);
        }
        if (this.blv != null) {
            this.blv.setPageUniqueId(bdUniqueId);
        }
    }

    public View XC() {
        return this.bJr;
    }

    public void a(h.a aVar) {
        if (this.bJt != null) {
            this.bJt.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.blv != null) {
            return this.blv.aor;
        }
        return null;
    }

    public View XD() {
        if (this.blv != null) {
            return this.blv.aos;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(boolean z) {
        if (this.bJv != null && this.bJv.threadData != null) {
            if (!XE()) {
                m.js(this.bJv.threadData.getId());
                XF();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.bJv.threadData, null, m.rs(), 18003, true, false, false).addLocateParam(this.bJv.Yc());
            addLocateParam.setForumId(String.valueOf(this.bJv.threadData.getFid()));
            if (this.bJv.bMS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJv.bMS);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XE() {
        return this.bJv.bNk && !this.bJv.aCJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XF() {
        m.a(this.bJr.getGodReplyContent(), this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bJr.getPraiseNum(), this.bJv.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
