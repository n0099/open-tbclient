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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public abstract class a<T extends AbsThreadDataSupport> extends b<T> {
    protected T adQ;
    protected UnfollowedDecorView agq;
    protected TbPageContext<?> dVN;
    protected boolean elm;
    public ThreadCommentAndPraiseInfoLayout fXb;
    protected NEGFeedBackView fXm;
    public ThreadCommentAndPraiseInfoLayout gUl;
    protected FollowUserDecorView gUm;
    protected ForumEnterLayout gUn;
    protected boolean gUo;
    protected BdUniqueId mBdUniqueId;
    protected View mDivider;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fXm = null;
        this.agq = null;
        this.elm = false;
    }

    public int bj(int i) {
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
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dNB = 7;
            cVar.dNH = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.fXm != null) {
                this.fXm.setUniqueId(bdUniqueId);
            }
            if (this.gUm != null) {
                this.gUm.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fXm != null) {
            this.fXm.setEventCallback(aVar);
        }
    }

    public void ta(int i) {
        this.currentPageType = i;
        if (this.fXb != null) {
            this.fXb.ekb = i;
        }
        if (this.gUl != null) {
            this.gUl.ekb = i;
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.fXb != null) {
            this.fXb.onChangeSkinType();
        }
        if (this.gUl != null) {
            this.gUl.onChangeSkinType();
        }
        if (this.fXm != null) {
            this.fXm.onChangeSkinType();
        }
        if (this.agq != null) {
            this.agq.onChangeSkinType();
        }
        if (this.gUn != null) {
            this.gUn.onChangeSkinType(tbPageContext, i);
        }
        if (this.gUm != null) {
            this.gUm.onChangeSkinType(i);
        }
        com.baidu.tbadk.a.b.a.aU(this.mDivider);
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

    public void aO(ViewGroup viewGroup) {
        e(viewGroup, aQ(viewGroup));
        aP(viewGroup);
        bRk();
        bRl();
        bRj();
        com.baidu.tbadk.a.b.a.a(this.mDivider, this.adQ);
    }

    private void bRj() {
        if ((this.gUn == null || this.gUn.getVisibility() != 0) && !com.baidu.tbadk.a.d.aRL()) {
            setMarginsTop(this.fXb, bj(R.dimen.tbds20));
            setMarginsTop(this.gUl, bj(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.fXb, 0);
        setMarginsTop(this.gUl, 0);
    }

    private void bRk() {
        if (this.adQ != null && this.adQ.aTN() != null && this.gUn != null) {
            if (this.adQ.aTT()) {
                this.gUn.setData(this.adQ.aTN());
            } else if (this.elm) {
                this.gUn.setData(this.adQ.aTN());
            }
        }
    }

    public void bRl() {
        if (this.adQ != null && this.adQ.aTN() != null) {
            bv aTN = this.adQ.aTN();
            this.fXb.setVisibility(8);
            this.gUo = this.gUl.setData(aTN);
        }
    }

    private void aP(ViewGroup viewGroup) {
        if (this.adQ != null && this.adQ.aTN() != null) {
            if (this.agq == null) {
                this.agq = new UnfollowedDecorView(this.dVN.getPageActivity());
                viewGroup.addView(this.agq);
            }
            if (this.adQ.aTN().dUK && !ax.w(this.adQ.aTN())) {
                this.agq.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.agq.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.agq.setLayoutParams(layoutParams);
                this.agq.setVisibility(0);
                this.agq.q(this.adQ.aTN());
            } else if (this.agq != null) {
                this.agq.setVisibility(8);
            }
        }
    }

    private boolean aQ(ViewGroup viewGroup) {
        if (this.adQ == null || this.adQ.aTN() == null) {
            return false;
        }
        if (this.adQ.aTN() != null && this.adQ.feedBackReasonMap != null && this.adQ.feedBackReasonMap.size() > 0) {
            if (this.fXm == null) {
                this.fXm = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.fXm);
            }
            this.fXm.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.fXm.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.fXm.setLayoutParams(layoutParams);
            aq aqVar = new aq();
            aqVar.setTid(this.adQ.aTN().getTid());
            aqVar.setFid(this.adQ.aTN().getFid());
            aqVar.setNid(this.adQ.aTN().getNid());
            aqVar.setFeedBackReasonMap(this.adQ.feedBackReasonMap);
            this.fXm.setVisibility(0);
            this.fXm.setData(aqVar);
            this.fXm.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.fXm != null) {
            this.fXm.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.adQ != null && this.adQ.aTN() != null) {
            if (this.gUm == null) {
                this.gUm = new FollowUserDecorView(this.dVN.getPageActivity());
                viewGroup.addView(this.gUm);
            }
            if (bRm()) {
                this.gUm.setPageUniqueId(this.mBdUniqueId);
                this.gUm.setSvgIconResId(0);
                int bj = bj(R.dimen.tbds166);
                int bj2 = bj(R.dimen.tbds78);
                int bj3 = bj(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int bj4 = bj(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.aRL()) {
                    bj = bj(R.dimen.tbds177);
                    bj2 = bj(R.dimen.tbds76);
                    bj3 = bj(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    bj4 = bj(R.dimen.tbds52);
                    this.gUm.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bj, bj2);
                layoutParams.topMargin = bj4;
                layoutParams.rightMargin = bj3;
                layoutParams.gravity = 53;
                this.gUm.setLayoutParams(layoutParams);
                this.gUm.setData(this.adQ.aTN());
            } else if (this.gUm != null) {
                this.gUm.setVisibility(8);
            }
        }
    }

    private boolean bRm() {
        if (this.adQ == null || this.adQ.aTN() == null || this.adQ.aTN().aWl() == null) {
            return false;
        }
        bv aTN = this.adQ.aTN();
        if (!ax.w(aTN)) {
            boolean z = aTN.aYf() || aTN.aUT() || aTN.aUU();
            if (z && aTN.dUJ) {
                return true;
            }
            if (z && aTN.dUL && !aTN.aWl().hadConcerned()) {
                return true;
            }
            if (aTN.aWF() != null && com.baidu.tieba.card.data.j.aa(aTN) && aTN.dUJ) {
                return true;
            }
        }
        return false;
    }
}
