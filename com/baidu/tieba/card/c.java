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
    private final View.OnClickListener anx;
    private HeadPendantClickableView bJj;
    private ThreadGodReplyLayout bJk;
    private com.baidu.tieba.NEGFeedBack.c bJl;
    private View bJm;
    protected com.baidu.tieba.card.data.l bJn;
    private View.OnClickListener bJo;
    public ThreadUserInfoLayout bmR;
    public ThreadCommentAndPraiseInfoLayout bmV;
    private TbPageContext<?> mH;
    private int mSkinType;

    protected abstract void aa(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJl = null;
        this.mSkinType = 3;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.bJn);
                }
                c.this.dz(view == c.this.bJk);
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.bJn);
                }
            }
        };
        View view = getView();
        this.mH = tbPageContext;
        this.bJj = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bmR = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bJl = new com.baidu.tieba.NEGFeedBack.c(this.mH);
        this.bJl.Kl();
        this.bJl.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bmR.addView(this.bJl);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bJm = view.findViewById(d.h.divider_line);
        this.bmV.setOnClickListener(this.bJo);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setShareVisible(true);
        this.bmV.setShareReportFrom(3);
        this.bmV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view2, c.this.bJn);
                }
            }
        });
        this.bJk = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJk.setOnClickListener(this.bJo);
        aa(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bmV.onChangeSkinType();
            this.bJk.onChangeSkinType();
            this.bmR.onChangeSkinType();
            if (this.bJl != null) {
                this.bJl.onChangeSkinType();
            }
            aj.k(this.bJm, d.e.cp_bg_line_c);
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
        this.bJn = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJo);
        }
        if (this.bJl != null && this.bJn.Nd() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bJl.setVisibility(8);
            } else {
                this.bJl.setVisibility(0);
                al alVar = new al();
                alVar.cx(this.bJn.Nd().getTid());
                alVar.setFid(this.bJn.Nd().getFid());
                alVar.a(this.bJn.WU);
                this.bJl.setData(alVar);
                this.bJl.setFirstRowSingleColumn(true);
            }
        }
        this.bmR.setData(lVar.threadData);
        this.bJk.setData(lVar.threadData.sE());
        if (!Xr() && m.jm(this.bJn.threadData.getId())) {
            Xs();
        }
        this.bmR.setUserAfterClickListener(this.anx);
        this.bmV.setData(lVar.threadData);
        bh Nd = lVar.Nd();
        if (this.bmR.getHeaderImg() != null) {
            if (this.bmR.getIsSimpleThread()) {
                this.bmR.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (Nd.getAuthor() == null || Nd.getAuthor().getPendantData() == null || StringUtils.isNull(Nd.getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.bmR.getHeaderImg().setVisibility(0);
                this.bmR.getHeaderImg().setData(Nd);
            } else {
                this.bmR.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(Nd);
            }
        }
        b(lVar);
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bJl != null) {
            this.bJl.setUniqueId(bdUniqueId);
        }
        if (this.bmR != null) {
            this.bmR.setPageUniqueId(bdUniqueId);
        }
    }

    public View Xp() {
        return this.bJk;
    }

    public void a(c.a aVar) {
        if (this.bJl != null) {
            this.bJl.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bmR != null) {
            return this.bmR.ans;
        }
        return null;
    }

    public View Xq() {
        if (this.bmR != null) {
            return this.bmR.ant;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dz(boolean z) {
        if (this.bJn != null && this.bJn.threadData != null) {
            if (!Xr()) {
                m.jl(this.bJn.threadData.getId());
                Xs();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mH.getPageActivity()).createFromThreadCfg(this.bJn.threadData, null, m.rf(), 18003, true, false, false).addLocateParam(this.bJn.XR());
            addLocateParam.setForumId(String.valueOf(this.bJn.threadData.getFid()));
            if (this.bJn.bNb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJn.bNb);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xr() {
        return this.bJn.bNu && !this.bJn.aBN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xs() {
        m.a(this.bJk.getGodReplyContent(), this.bJn.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
