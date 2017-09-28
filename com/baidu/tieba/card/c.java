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
    private final View.OnClickListener anJ;
    private View.OnClickListener bJA;
    private HeadPendantClickableView bJv;
    private ThreadGodReplyLayout bJw;
    private com.baidu.tieba.NEGFeedBack.c bJx;
    private View bJy;
    protected com.baidu.tieba.card.data.l bJz;
    public ThreadUserInfoLayout bnf;
    public ThreadCommentAndPraiseInfoLayout bnj;
    private TbPageContext<?> mG;
    private int mSkinType;

    protected abstract void aa(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJx = null;
        this.mSkinType = 3;
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.bJz);
                }
                c.this.dA(view == c.this.bJw);
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.bJz);
                }
            }
        };
        View view = getView();
        this.mG = tbPageContext;
        this.bJv = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
        }
        this.bJv.wg();
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bnf = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bJx = new com.baidu.tieba.NEGFeedBack.c(this.mG);
        this.bJx.Kr();
        this.bJx.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bnf.addView(this.bJx);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bJy = view.findViewById(d.h.divider_line);
        this.bnj.setOnClickListener(this.bJA);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setShareVisible(true);
        this.bnj.setShareReportFrom(3);
        this.bnj.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view2, c.this.bJz);
                }
            }
        });
        this.bJw = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bJw.setOnClickListener(this.bJA);
        aa(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bnj.onChangeSkinType();
            this.bJw.onChangeSkinType();
            this.bnf.onChangeSkinType();
            if (this.bJx != null) {
                this.bJx.onChangeSkinType();
            }
            aj.k(this.bJy, d.e.cp_bg_line_c);
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
        this.bJz = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJA);
        }
        if (this.bJx != null && this.bJz.Nj() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bJx.setVisibility(8);
            } else {
                this.bJx.setVisibility(0);
                al alVar = new al();
                alVar.cy(this.bJz.Nj().getTid());
                alVar.setFid(this.bJz.Nj().getFid());
                alVar.a(this.bJz.Xg);
                this.bJx.setData(alVar);
                this.bJx.setFirstRowSingleColumn(true);
            }
        }
        this.bnf.setData(lVar.threadData);
        this.bJw.setData(lVar.threadData.sL());
        if (!Xv() && m.jo(this.bJz.threadData.getId())) {
            Xw();
        }
        this.bnf.setUserAfterClickListener(this.anJ);
        this.bnj.setData(lVar.threadData);
        bh Nj = lVar.Nj();
        if (this.bnf.getHeaderImg() != null) {
            if (this.bnf.getIsSimpleThread()) {
                this.bnf.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (Nj.getAuthor() == null || Nj.getAuthor().getPendantData() == null || StringUtils.isNull(Nj.getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.bnf.getHeaderImg().setVisibility(0);
                this.bnf.getHeaderImg().setData(Nj);
            } else {
                this.bnf.getHeaderImg().setVisibility(4);
                this.bJv.setVisibility(0);
                this.bJv.setData(Nj);
            }
        }
        b(lVar);
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bJx != null) {
            this.bJx.setUniqueId(bdUniqueId);
        }
        if (this.bnf != null) {
            this.bnf.setPageUniqueId(bdUniqueId);
        }
    }

    public View Xt() {
        return this.bJw;
    }

    public void a(c.a aVar) {
        if (this.bJx != null) {
            this.bJx.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bnf != null) {
            return this.bnf.anE;
        }
        return null;
    }

    public View Xu() {
        if (this.bnf != null) {
            return this.bnf.anF;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(boolean z) {
        if (this.bJz != null && this.bJz.threadData != null) {
            if (!Xv()) {
                m.jn(this.bJz.threadData.getId());
                Xw();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mG.getPageActivity()).createFromThreadCfg(this.bJz.threadData, null, m.rm(), 18003, true, false, false).addLocateParam(this.bJz.XV());
            addLocateParam.setForumId(String.valueOf(this.bJz.threadData.getFid()));
            if (this.bJz.bNn == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJz.bNn);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xv() {
        return this.bJz.bNG && !this.bJz.aCa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xw() {
        m.a(this.bJw.getGodReplyContent(), this.bJz.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
