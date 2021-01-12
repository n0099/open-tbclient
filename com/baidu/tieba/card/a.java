package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tbadk.core.data.a> extends b<T> {
    protected T agr;
    protected UnfollowedDecorView ajj;
    protected TbPageContext<?> eSJ;
    protected boolean fjo;
    public ThreadCommentAndPraiseInfoLayout hiT;
    protected NEGFeedBackView hje;
    public ThreadCommentAndPraiseInfoLayout ioL;
    protected FollowUserDecorView ioM;
    protected ForumEnterLayout ioN;
    protected boolean ioO;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hje = null;
        this.ajj = null;
        this.fjo = false;
    }

    public int getDimens(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), i);
    }

    public void b(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.setOnClickListener(this);
            threadCommentAndPraiseInfoLayout.setReplyTimeVisible(false);
            threadCommentAndPraiseInfoLayout.setShowPraiseNum(true);
            threadCommentAndPraiseInfoLayout.setCommentNumEnable(true);
            threadCommentAndPraiseInfoLayout.setNeedAddReplyIcon(true);
            threadCommentAndPraiseInfoLayout.setNeedAddPraiseIcon(true);
            if (threadCommentAndPraiseInfoLayout.getCommentContainer() != null) {
                threadCommentAndPraiseInfoLayout.getCommentContainer().setOnClickListener(this);
            }
            threadCommentAndPraiseInfoLayout.setShareVisible(true);
            threadCommentAndPraiseInfoLayout.setFrom(7);
            threadCommentAndPraiseInfoLayout.setShareReportFrom(3);
            threadCommentAndPraiseInfoLayout.hideDisagree();
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eJO = 7;
            dVar.eJU = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(dVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.hje != null) {
                this.hje.setUniqueId(bdUniqueId);
            }
            if (this.ioM != null) {
                this.ioM.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hje != null) {
            this.hje.setEventCallback(aVar);
        }
    }

    public void wL(int i) {
        this.currentPageType = i;
        if (this.hiT != null) {
            this.hiT.fie = i;
        }
        if (this.ioL != null) {
            this.ioL.fie = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.hiT != null) {
            this.hiT.onChangeSkinType();
        }
        if (this.ioL != null) {
            this.ioL.onChangeSkinType();
        }
        if (this.hje != null) {
            this.hje.onChangeSkinType();
        }
        if (this.ajj != null) {
            this.ajj.onChangeSkinType();
        }
        if (this.ioN != null) {
            this.ioN.onChangeSkinType(tbPageContext, i);
        }
        if (this.ioM != null) {
            this.ioM.onChangeSkinType(i);
        }
    }

    public void setMarginsTop(View view, int i) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void ba(ViewGroup viewGroup) {
        d(viewGroup, bc(viewGroup));
        bb(viewGroup);
        cqI();
        cqJ();
        cqH();
    }

    private void cqH() {
        if ((this.ioN == null || this.ioN.getVisibility() != 0) && !com.baidu.tbadk.a.d.biL()) {
            setMarginsTop(this.hiT, getDimens(R.dimen.tbds20));
            setMarginsTop(this.ioL, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.hiT, 0);
        setMarginsTop(this.ioL, 0);
    }

    private void cqI() {
        if (this.agr != null && this.agr.bkV() != null && this.ioN != null) {
            if (this.agr.bkZ()) {
                this.ioN.setData(this.agr.bkV());
            } else if (this.fjo) {
                this.ioN.setData(this.agr.bkV());
            }
        }
    }

    public void cqJ() {
        if (this.agr != null && this.agr.bkV() != null) {
            bz bkV = this.agr.bkV();
            this.hiT.setVisibility(8);
            this.ioO = this.ioL.setData(bkV);
        }
    }

    private void bb(ViewGroup viewGroup) {
        if (this.agr != null && this.agr.bkV() != null) {
            if (this.ajj == null) {
                this.ajj = new UnfollowedDecorView(this.eSJ.getPageActivity());
                viewGroup.addView(this.ajj);
            }
            if (this.agr.bkV().eRt && !ay.x(this.agr.bkV())) {
                this.ajj.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.ajj.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.ajj.setLayoutParams(layoutParams);
                this.ajj.setVisibility(0);
                this.ajj.r(this.agr.bkV());
            } else if (this.ajj != null) {
                this.ajj.setVisibility(8);
            }
        }
    }

    private boolean bc(ViewGroup viewGroup) {
        if (this.agr == null || this.agr.bkV() == null) {
            return false;
        }
        if (this.agr.bkV() != null && this.agr.feedBackReasonMap != null && this.agr.feedBackReasonMap.size() > 0) {
            if (this.hje == null) {
                this.hje = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.hje);
            }
            this.hje.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.hje.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.hje.setLayoutParams(layoutParams);
            at atVar = new at();
            atVar.setTid(this.agr.bkV().getTid());
            atVar.setFid(this.agr.bkV().getFid());
            atVar.setNid(this.agr.bkV().blV());
            atVar.setFeedBackReasonMap(this.agr.feedBackReasonMap);
            this.hje.setVisibility(0);
            this.hje.setData(atVar);
            this.hje.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.hje != null) {
            this.hje.setVisibility(8);
        }
        return false;
    }

    private void d(ViewGroup viewGroup, boolean z) {
        if (this.agr != null && this.agr.bkV() != null) {
            if (this.ioM == null) {
                this.ioM = new FollowUserDecorView(this.eSJ.getPageActivity());
                viewGroup.addView(this.ioM);
            }
            if (cqK()) {
                this.ioM.setPageUniqueId(this.mBdUniqueId);
                this.ioM.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.biL()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.ioM.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.ioM.setLayoutParams(layoutParams);
                this.ioM.setData(this.agr.bkV());
            } else if (this.ioM != null) {
                this.ioM.setVisibility(8);
            }
        }
    }

    private boolean cqK() {
        if (this.agr == null || this.agr.bkV() == null || this.agr.bkV().bnx() == null) {
            return false;
        }
        bz bkV = this.agr.bkV();
        if (!ay.x(bkV)) {
            boolean z = bkV.bpu() || bkV.bme() || bkV.bmf();
            if (z && bkV.eRs) {
                return true;
            }
            if (z && bkV.eRu && !bkV.bnx().hadConcerned()) {
                return true;
            }
            if (bkV.bnQ() != null && com.baidu.tieba.card.data.j.ad(bkV) && bkV.eRs) {
                return true;
            }
        }
        return false;
    }
}
