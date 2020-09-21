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
/* loaded from: classes20.dex */
public abstract class a<T extends AbsThreadDataSupport> extends b<T> {
    protected T afq;
    protected UnfollowedDecorView ahU;
    protected TbPageContext<?> ehG;
    protected boolean exp;
    public ThreadCommentAndPraiseInfoLayout gml;
    protected NEGFeedBackView gmw;
    public ThreadCommentAndPraiseInfoLayout hol;
    protected FollowUserDecorView hom;
    protected ForumEnterLayout hon;
    protected boolean hoo;
    protected BdUniqueId mBdUniqueId;
    protected View mDivider;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gmw = null;
        this.ahU = null;
        this.exp = false;
    }

    public int aT(int i) {
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
            cVar.dYY = 7;
            cVar.dZe = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.gmw != null) {
                this.gmw.setUniqueId(bdUniqueId);
            }
            if (this.hom != null) {
                this.hom.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gmw != null) {
            this.gmw.setEventCallback(aVar);
        }
    }

    public void vO(int i) {
        this.currentPageType = i;
        if (this.gml != null) {
            this.gml.ewe = i;
        }
        if (this.hol != null) {
            this.hol.ewe = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.gml != null) {
            this.gml.onChangeSkinType();
        }
        if (this.hol != null) {
            this.hol.onChangeSkinType();
        }
        if (this.gmw != null) {
            this.gmw.onChangeSkinType();
        }
        if (this.ahU != null) {
            this.ahU.onChangeSkinType();
        }
        if (this.hon != null) {
            this.hon.onChangeSkinType(tbPageContext, i);
        }
        if (this.hom != null) {
            this.hom.onChangeSkinType(i);
        }
        com.baidu.tbadk.a.b.a.aY(this.mDivider);
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
        ceM();
        ceN();
        ceL();
        com.baidu.tbadk.a.b.a.a(this.mDivider, this.afq);
    }

    private void ceL() {
        if ((this.hon == null || this.hon.getVisibility() != 0) && !com.baidu.tbadk.a.d.baT()) {
            setMarginsTop(this.gml, aT(R.dimen.tbds20));
            setMarginsTop(this.hol, aT(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.gml, 0);
        setMarginsTop(this.hol, 0);
    }

    private void ceM() {
        if (this.afq != null && this.afq.bcY() != null && this.hon != null) {
            if (this.afq.bde()) {
                this.hon.setData(this.afq.bcY());
            } else if (this.exp) {
                this.hon.setData(this.afq.bcY());
            }
        }
    }

    public void ceN() {
        if (this.afq != null && this.afq.bcY() != null) {
            bw bcY = this.afq.bcY();
            this.gml.setVisibility(8);
            this.hoo = this.hol.setData(bcY);
        }
    }

    private void aP(ViewGroup viewGroup) {
        if (this.afq != null && this.afq.bcY() != null) {
            if (this.ahU == null) {
                this.ahU = new UnfollowedDecorView(this.ehG.getPageActivity());
                viewGroup.addView(this.ahU);
            }
            if (this.afq.bcY().egu && !ay.x(this.afq.bcY())) {
                this.ahU.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.ahU.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.ahU.setLayoutParams(layoutParams);
                this.ahU.setVisibility(0);
                this.ahU.r(this.afq.bcY());
            } else if (this.ahU != null) {
                this.ahU.setVisibility(8);
            }
        }
    }

    private boolean aQ(ViewGroup viewGroup) {
        if (this.afq == null || this.afq.bcY() == null) {
            return false;
        }
        if (this.afq.bcY() != null && this.afq.feedBackReasonMap != null && this.afq.feedBackReasonMap.size() > 0) {
            if (this.gmw == null) {
                this.gmw = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.gmw);
            }
            this.gmw.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.gmw.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.gmw.setLayoutParams(layoutParams);
            ar arVar = new ar();
            arVar.setTid(this.afq.bcY().getTid());
            arVar.setFid(this.afq.bcY().getFid());
            arVar.setNid(this.afq.bcY().getNid());
            arVar.setFeedBackReasonMap(this.afq.feedBackReasonMap);
            this.gmw.setVisibility(0);
            this.gmw.setData(arVar);
            this.gmw.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.gmw != null) {
            this.gmw.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.afq != null && this.afq.bcY() != null) {
            if (this.hom == null) {
                this.hom = new FollowUserDecorView(this.ehG.getPageActivity());
                viewGroup.addView(this.hom);
            }
            if (ceO()) {
                this.hom.setPageUniqueId(this.mBdUniqueId);
                this.hom.setSvgIconResId(0);
                int aT = aT(R.dimen.tbds166);
                int aT2 = aT(R.dimen.tbds78);
                int aT3 = aT(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int aT4 = aT(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.baT()) {
                    aT = aT(R.dimen.tbds177);
                    aT2 = aT(R.dimen.tbds76);
                    aT3 = aT(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    aT4 = aT(R.dimen.tbds52);
                    this.hom.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aT, aT2);
                layoutParams.topMargin = aT4;
                layoutParams.rightMargin = aT3;
                layoutParams.gravity = 53;
                this.hom.setLayoutParams(layoutParams);
                this.hom.setData(this.afq.bcY());
            } else if (this.hom != null) {
                this.hom.setVisibility(8);
            }
        }
    }

    private boolean ceO() {
        if (this.afq == null || this.afq.bcY() == null || this.afq.bcY().bfy() == null) {
            return false;
        }
        bw bcY = this.afq.bcY();
        if (!ay.x(bcY)) {
            boolean z = bcY.bhs() || bcY.beg() || bcY.beh();
            if (z && bcY.egt) {
                return true;
            }
            if (z && bcY.egv && !bcY.bfy().hadConcerned()) {
                return true;
            }
            if (bcY.bfS() != null && com.baidu.tieba.card.data.k.ab(bcY) && bcY.egt) {
                return true;
            }
        }
        return false;
    }
}
