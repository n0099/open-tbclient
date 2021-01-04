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
    protected T ahi;
    protected UnfollowedDecorView aka;
    protected TbPageContext<?> eXu;
    protected boolean fnX;
    protected NEGFeedBackView hnK;
    public ThreadCommentAndPraiseInfoLayout hnz;
    public ThreadCommentAndPraiseInfoLayout its;
    protected FollowUserDecorView itt;
    protected ForumEnterLayout itu;
    protected boolean itv;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hnK = null;
        this.aka = null;
        this.fnX = false;
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
            dVar.eOz = 7;
            dVar.eOF = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(dVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.hnK != null) {
                this.hnK.setUniqueId(bdUniqueId);
            }
            if (this.itt != null) {
                this.itt.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hnK != null) {
            this.hnK.setEventCallback(aVar);
        }
    }

    public void ys(int i) {
        this.currentPageType = i;
        if (this.hnz != null) {
            this.hnz.fmP = i;
        }
        if (this.its != null) {
            this.its.fmP = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.hnz != null) {
            this.hnz.onChangeSkinType();
        }
        if (this.its != null) {
            this.its.onChangeSkinType();
        }
        if (this.hnK != null) {
            this.hnK.onChangeSkinType();
        }
        if (this.aka != null) {
            this.aka.onChangeSkinType();
        }
        if (this.itu != null) {
            this.itu.onChangeSkinType(tbPageContext, i);
        }
        if (this.itt != null) {
            this.itt.onChangeSkinType(i);
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
        cuz();
        cuA();
        cuy();
    }

    private void cuy() {
        if ((this.itu == null || this.itu.getVisibility() != 0) && !com.baidu.tbadk.a.d.bmE()) {
            setMarginsTop(this.hnz, getDimens(R.dimen.tbds20));
            setMarginsTop(this.its, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.hnz, 0);
        setMarginsTop(this.its, 0);
    }

    private void cuz() {
        if (this.ahi != null && this.ahi.boO() != null && this.itu != null) {
            if (this.ahi.boS()) {
                this.itu.setData(this.ahi.boO());
            } else if (this.fnX) {
                this.itu.setData(this.ahi.boO());
            }
        }
    }

    public void cuA() {
        if (this.ahi != null && this.ahi.boO() != null) {
            bz boO = this.ahi.boO();
            this.hnz.setVisibility(8);
            this.itv = this.its.setData(boO);
        }
    }

    private void bb(ViewGroup viewGroup) {
        if (this.ahi != null && this.ahi.boO() != null) {
            if (this.aka == null) {
                this.aka = new UnfollowedDecorView(this.eXu.getPageActivity());
                viewGroup.addView(this.aka);
            }
            if (this.ahi.boO().eWe && !ay.x(this.ahi.boO())) {
                this.aka.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.aka.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.aka.setLayoutParams(layoutParams);
                this.aka.setVisibility(0);
                this.aka.r(this.ahi.boO());
            } else if (this.aka != null) {
                this.aka.setVisibility(8);
            }
        }
    }

    private boolean bc(ViewGroup viewGroup) {
        if (this.ahi == null || this.ahi.boO() == null) {
            return false;
        }
        if (this.ahi.boO() != null && this.ahi.feedBackReasonMap != null && this.ahi.feedBackReasonMap.size() > 0) {
            if (this.hnK == null) {
                this.hnK = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.hnK);
            }
            this.hnK.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.hnK.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.hnK.setLayoutParams(layoutParams);
            at atVar = new at();
            atVar.setTid(this.ahi.boO().getTid());
            atVar.setFid(this.ahi.boO().getFid());
            atVar.setNid(this.ahi.boO().bpO());
            atVar.setFeedBackReasonMap(this.ahi.feedBackReasonMap);
            this.hnK.setVisibility(0);
            this.hnK.setData(atVar);
            this.hnK.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.hnK != null) {
            this.hnK.setVisibility(8);
        }
        return false;
    }

    private void d(ViewGroup viewGroup, boolean z) {
        if (this.ahi != null && this.ahi.boO() != null) {
            if (this.itt == null) {
                this.itt = new FollowUserDecorView(this.eXu.getPageActivity());
                viewGroup.addView(this.itt);
            }
            if (cuB()) {
                this.itt.setPageUniqueId(this.mBdUniqueId);
                this.itt.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bmE()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.itt.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.itt.setLayoutParams(layoutParams);
                this.itt.setData(this.ahi.boO());
            } else if (this.itt != null) {
                this.itt.setVisibility(8);
            }
        }
    }

    private boolean cuB() {
        if (this.ahi == null || this.ahi.boO() == null || this.ahi.boO().brq() == null) {
            return false;
        }
        bz boO = this.ahi.boO();
        if (!ay.x(boO)) {
            boolean z = boO.btn() || boO.bpX() || boO.bpY();
            if (z && boO.eWd) {
                return true;
            }
            if (z && boO.eWf && !boO.brq().hadConcerned()) {
                return true;
            }
            if (boO.brJ() != null && com.baidu.tieba.card.data.j.ad(boO) && boO.eWd) {
                return true;
            }
        }
        return false;
    }
}
