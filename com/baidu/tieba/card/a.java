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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public abstract class a<T extends AbsThreadDataSupport> extends b<T> {
    protected T aeW;
    protected UnfollowedDecorView ahy;
    protected TbPageContext<?> efn;
    protected boolean evh;
    public ThreadCommentAndPraiseInfoLayout gja;
    protected NEGFeedBackView gjl;
    public ThreadCommentAndPraiseInfoLayout hhd;
    protected FollowUserDecorView hhe;
    protected ForumEnterLayout hhf;
    protected boolean hhg;
    protected BdUniqueId mBdUniqueId;
    protected View mDivider;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gjl = null;
        this.ahy = null;
        this.evh = false;
    }

    public int aP(int i) {
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
            cVar.dWK = 7;
            cVar.dWQ = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.gjl != null) {
                this.gjl.setUniqueId(bdUniqueId);
            }
            if (this.hhe != null) {
                this.hhe.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gjl != null) {
            this.gjl.setEventCallback(aVar);
        }
    }

    public void vp(int i) {
        this.currentPageType = i;
        if (this.gja != null) {
            this.gja.etW = i;
        }
        if (this.hhd != null) {
            this.hhd.etW = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.gja != null) {
            this.gja.onChangeSkinType();
        }
        if (this.hhd != null) {
            this.hhd.onChangeSkinType();
        }
        if (this.gjl != null) {
            this.gjl.onChangeSkinType();
        }
        if (this.ahy != null) {
            this.ahy.onChangeSkinType();
        }
        if (this.hhf != null) {
            this.hhf.onChangeSkinType(tbPageContext, i);
        }
        if (this.hhe != null) {
            this.hhe.onChangeSkinType(i);
        }
        com.baidu.tbadk.a.b.a.aW(this.mDivider);
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

    public void aN(ViewGroup viewGroup) {
        e(viewGroup, aP(viewGroup));
        aO(viewGroup);
        cbw();
        cbx();
        cbv();
        com.baidu.tbadk.a.b.a.a(this.mDivider, this.aeW);
    }

    private void cbv() {
        if ((this.hhf == null || this.hhf.getVisibility() != 0) && !com.baidu.tbadk.a.d.bad()) {
            setMarginsTop(this.gja, aP(R.dimen.tbds20));
            setMarginsTop(this.hhd, aP(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.gja, 0);
        setMarginsTop(this.hhd, 0);
    }

    private void cbw() {
        if (this.aeW != null && this.aeW.bce() != null && this.hhf != null) {
            if (this.aeW.bck()) {
                this.hhf.setData(this.aeW.bce());
            } else if (this.evh) {
                this.hhf.setData(this.aeW.bce());
            }
        }
    }

    public void cbx() {
        if (this.aeW != null && this.aeW.bce() != null) {
            bw bce = this.aeW.bce();
            this.gja.setVisibility(8);
            this.hhg = this.hhd.setData(bce);
        }
    }

    private void aO(ViewGroup viewGroup) {
        if (this.aeW != null && this.aeW.bce() != null) {
            if (this.ahy == null) {
                this.ahy = new UnfollowedDecorView(this.efn.getPageActivity());
                viewGroup.addView(this.ahy);
            }
            if (this.aeW.bce().eeg && !ay.w(this.aeW.bce())) {
                this.ahy.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.ahy.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.ahy.setLayoutParams(layoutParams);
                this.ahy.setVisibility(0);
                this.ahy.q(this.aeW.bce());
            } else if (this.ahy != null) {
                this.ahy.setVisibility(8);
            }
        }
    }

    private boolean aP(ViewGroup viewGroup) {
        if (this.aeW == null || this.aeW.bce() == null) {
            return false;
        }
        if (this.aeW.bce() != null && this.aeW.feedBackReasonMap != null && this.aeW.feedBackReasonMap.size() > 0) {
            if (this.gjl == null) {
                this.gjl = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.gjl);
            }
            this.gjl.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.gjl.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.gjl.setLayoutParams(layoutParams);
            ar arVar = new ar();
            arVar.setTid(this.aeW.bce().getTid());
            arVar.setFid(this.aeW.bce().getFid());
            arVar.setNid(this.aeW.bce().getNid());
            arVar.setFeedBackReasonMap(this.aeW.feedBackReasonMap);
            this.gjl.setVisibility(0);
            this.gjl.setData(arVar);
            this.gjl.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.gjl != null) {
            this.gjl.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.aeW != null && this.aeW.bce() != null) {
            if (this.hhe == null) {
                this.hhe = new FollowUserDecorView(this.efn.getPageActivity());
                viewGroup.addView(this.hhe);
            }
            if (cby()) {
                this.hhe.setPageUniqueId(this.mBdUniqueId);
                this.hhe.setSvgIconResId(0);
                int aP = aP(R.dimen.tbds166);
                int aP2 = aP(R.dimen.tbds78);
                int aP3 = aP(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int aP4 = aP(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bad()) {
                    aP = aP(R.dimen.tbds177);
                    aP2 = aP(R.dimen.tbds76);
                    aP3 = aP(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    aP4 = aP(R.dimen.tbds52);
                    this.hhe.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aP, aP2);
                layoutParams.topMargin = aP4;
                layoutParams.rightMargin = aP3;
                layoutParams.gravity = 53;
                this.hhe.setLayoutParams(layoutParams);
                this.hhe.setData(this.aeW.bce());
            } else if (this.hhe != null) {
                this.hhe.setVisibility(8);
            }
        }
    }

    private boolean cby() {
        if (this.aeW == null || this.aeW.bce() == null || this.aeW.bce().beE() == null) {
            return false;
        }
        bw bce = this.aeW.bce();
        if (!ay.w(bce)) {
            boolean z = bce.bgy() || bce.bdm() || bce.bdn();
            if (z && bce.eef) {
                return true;
            }
            if (z && bce.eeh && !bce.beE().hadConcerned()) {
                return true;
            }
            if (bce.beY() != null && com.baidu.tieba.card.data.k.aa(bce) && bce.eef) {
                return true;
            }
        }
        return false;
    }
}
