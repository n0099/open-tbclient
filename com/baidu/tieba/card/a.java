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
    protected T aeY;
    protected UnfollowedDecorView ahA;
    protected TbPageContext<?> efr;
    protected boolean evl;
    public ThreadCommentAndPraiseInfoLayout gje;
    protected NEGFeedBackView gjp;
    public ThreadCommentAndPraiseInfoLayout hhh;
    protected FollowUserDecorView hhi;
    protected ForumEnterLayout hhj;
    protected boolean hhk;
    protected BdUniqueId mBdUniqueId;
    protected View mDivider;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gjp = null;
        this.ahA = null;
        this.evl = false;
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
            cVar.dWO = 7;
            cVar.dWU = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.gjp != null) {
                this.gjp.setUniqueId(bdUniqueId);
            }
            if (this.hhi != null) {
                this.hhi.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gjp != null) {
            this.gjp.setEventCallback(aVar);
        }
    }

    public void vp(int i) {
        this.currentPageType = i;
        if (this.gje != null) {
            this.gje.eua = i;
        }
        if (this.hhh != null) {
            this.hhh.eua = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.gje != null) {
            this.gje.onChangeSkinType();
        }
        if (this.hhh != null) {
            this.hhh.onChangeSkinType();
        }
        if (this.gjp != null) {
            this.gjp.onChangeSkinType();
        }
        if (this.ahA != null) {
            this.ahA.onChangeSkinType();
        }
        if (this.hhj != null) {
            this.hhj.onChangeSkinType(tbPageContext, i);
        }
        if (this.hhi != null) {
            this.hhi.onChangeSkinType(i);
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
        cbx();
        cby();
        cbw();
        com.baidu.tbadk.a.b.a.a(this.mDivider, this.aeY);
    }

    private void cbw() {
        if ((this.hhj == null || this.hhj.getVisibility() != 0) && !com.baidu.tbadk.a.d.bad()) {
            setMarginsTop(this.gje, aP(R.dimen.tbds20));
            setMarginsTop(this.hhh, aP(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.gje, 0);
        setMarginsTop(this.hhh, 0);
    }

    private void cbx() {
        if (this.aeY != null && this.aeY.bce() != null && this.hhj != null) {
            if (this.aeY.bck()) {
                this.hhj.setData(this.aeY.bce());
            } else if (this.evl) {
                this.hhj.setData(this.aeY.bce());
            }
        }
    }

    public void cby() {
        if (this.aeY != null && this.aeY.bce() != null) {
            bw bce = this.aeY.bce();
            this.gje.setVisibility(8);
            this.hhk = this.hhh.setData(bce);
        }
    }

    private void aO(ViewGroup viewGroup) {
        if (this.aeY != null && this.aeY.bce() != null) {
            if (this.ahA == null) {
                this.ahA = new UnfollowedDecorView(this.efr.getPageActivity());
                viewGroup.addView(this.ahA);
            }
            if (this.aeY.bce().eek && !ay.w(this.aeY.bce())) {
                this.ahA.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.ahA.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.ahA.setLayoutParams(layoutParams);
                this.ahA.setVisibility(0);
                this.ahA.q(this.aeY.bce());
            } else if (this.ahA != null) {
                this.ahA.setVisibility(8);
            }
        }
    }

    private boolean aP(ViewGroup viewGroup) {
        if (this.aeY == null || this.aeY.bce() == null) {
            return false;
        }
        if (this.aeY.bce() != null && this.aeY.feedBackReasonMap != null && this.aeY.feedBackReasonMap.size() > 0) {
            if (this.gjp == null) {
                this.gjp = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.gjp);
            }
            this.gjp.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.gjp.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.gjp.setLayoutParams(layoutParams);
            ar arVar = new ar();
            arVar.setTid(this.aeY.bce().getTid());
            arVar.setFid(this.aeY.bce().getFid());
            arVar.setNid(this.aeY.bce().getNid());
            arVar.setFeedBackReasonMap(this.aeY.feedBackReasonMap);
            this.gjp.setVisibility(0);
            this.gjp.setData(arVar);
            this.gjp.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.gjp != null) {
            this.gjp.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.aeY != null && this.aeY.bce() != null) {
            if (this.hhi == null) {
                this.hhi = new FollowUserDecorView(this.efr.getPageActivity());
                viewGroup.addView(this.hhi);
            }
            if (cbz()) {
                this.hhi.setPageUniqueId(this.mBdUniqueId);
                this.hhi.setSvgIconResId(0);
                int aP = aP(R.dimen.tbds166);
                int aP2 = aP(R.dimen.tbds78);
                int aP3 = aP(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int aP4 = aP(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bad()) {
                    aP = aP(R.dimen.tbds177);
                    aP2 = aP(R.dimen.tbds76);
                    aP3 = aP(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    aP4 = aP(R.dimen.tbds52);
                    this.hhi.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aP, aP2);
                layoutParams.topMargin = aP4;
                layoutParams.rightMargin = aP3;
                layoutParams.gravity = 53;
                this.hhi.setLayoutParams(layoutParams);
                this.hhi.setData(this.aeY.bce());
            } else if (this.hhi != null) {
                this.hhi.setVisibility(8);
            }
        }
    }

    private boolean cbz() {
        if (this.aeY == null || this.aeY.bce() == null || this.aeY.bce().beE() == null) {
            return false;
        }
        bw bce = this.aeY.bce();
        if (!ay.w(bce)) {
            boolean z = bce.bgy() || bce.bdm() || bce.bdn();
            if (z && bce.eej) {
                return true;
            }
            if (z && bce.eel && !bce.beE().hadConcerned()) {
                return true;
            }
            if (bce.beY() != null && com.baidu.tieba.card.data.k.aa(bce) && bce.eej) {
                return true;
            }
        }
        return false;
    }
}
