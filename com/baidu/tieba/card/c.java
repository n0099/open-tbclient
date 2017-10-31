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
    private final View.OnClickListener anS;
    private HeadPendantClickableView bQP;
    private ThreadGodReplyLayout bQQ;
    private com.baidu.tieba.NEGFeedBack.c bQR;
    private View bQS;
    protected com.baidu.tieba.card.data.l bQT;
    private View.OnClickListener bQU;
    public ThreadCommentAndPraiseInfoLayout boD;
    public ThreadUserInfoLayout boz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ad(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bQR = null;
        this.mSkinType = 3;
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Zx() != null) {
                    c.this.Zx().a(view, c.this.bQT);
                }
                c.this.dy(view == c.this.bQQ);
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Zx() != null) {
                    c.this.Zx().a(view, c.this.bQT);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bQP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.boz = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bQR = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bQR.Ku();
        this.bQR.setLeftPadding((int) getContext().getResources().getDimension(d.e.ds60));
        this.boz.addView(this.bQR);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.bQS = view.findViewById(d.g.divider_line);
        this.boD.setOnClickListener(this.bQU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setShareVisible(true);
        this.boD.setShareReportFrom(3);
        this.boD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.Zx() != null) {
                    c.this.Zx().a(view2, c.this.bQT);
                }
            }
        });
        this.bQQ = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bQQ.setOnClickListener(this.bQU);
        ad(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.boD.onChangeSkinType();
            this.bQQ.onChangeSkinType();
            this.boz.onChangeSkinType();
            if (this.bQR != null) {
                this.bQR.onChangeSkinType();
            }
            aj.k(this.bQS, d.C0080d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.blk == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bQT = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bQU);
        }
        if (this.bQR != null && this.bQT.Np() != null && lVar.blk.rt() != null && !StringUtils.isNull(lVar.blk.rt().getUserId())) {
            if (lVar.blk.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bQR.setVisibility(8);
            } else {
                this.bQR.setVisibility(0);
                al alVar = new al();
                alVar.cD(this.bQT.Np().getTid());
                alVar.setFid(this.bQT.Np().getFid());
                alVar.a(this.bQT.Xm);
                this.bQR.setData(alVar);
                this.bQR.setFirstRowSingleColumn(true);
            }
        }
        this.boz.setData(lVar.blk);
        this.bQQ.setData(lVar.blk.sL());
        if (!ZB() && m.jL(this.bQT.blk.getId())) {
            ZC();
        }
        this.boz.setUserAfterClickListener(this.anS);
        this.boD.setData(lVar.blk);
        bh Np = lVar.Np();
        if (this.boz.getHeaderImg() != null) {
            if (this.boz.getIsSimpleThread()) {
                this.boz.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (Np.rt() == null || Np.rt().getPendantData() == null || StringUtils.isNull(Np.rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.boz.getHeaderImg().setVisibility(0);
                this.boz.getHeaderImg().setData(Np);
            } else {
                this.boz.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(Np);
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
        if (this.bQR != null) {
            this.bQR.setUniqueId(bdUniqueId);
        }
        if (this.boz != null) {
            this.boz.setPageUniqueId(bdUniqueId);
        }
    }

    public View Zz() {
        return this.bQQ;
    }

    public void a(c.a aVar) {
        if (this.bQR != null) {
            this.bQR.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.boz != null) {
            return this.boz.anN;
        }
        return null;
    }

    public View ZA() {
        if (this.boz != null) {
            return this.boz.anO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        if (this.bQT != null && this.bQT.blk != null) {
            if (!ZB()) {
                m.jK(this.bQT.blk.getId());
                ZC();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bQT.blk, null, m.rj(), 18003, true, false, false).addLocateParam(this.bQT.aab());
            addLocateParam.setForumId(String.valueOf(this.bQT.blk.getFid()));
            if (this.bQT.bUF == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bQT.bUF);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZB() {
        return this.bQT.bUY && !this.bQT.aCw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZC() {
        m.a(this.bQQ.getGodReplyContent(), this.bQT.blk.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
