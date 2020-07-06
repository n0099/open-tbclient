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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public abstract class a<T extends AbsThreadDataSupport> extends b<T> {
    protected T aea;
    protected UnfollowedDecorView agz;
    protected TbPageContext<?> dPv;
    protected boolean efc;
    public ThreadCommentAndPraiseInfoLayout fRI;
    protected NEGFeedBackView fRT;
    public ThreadCommentAndPraiseInfoLayout gOF;
    protected FollowUserDecorView gOG;
    protected ForumEnterLayout gOH;
    protected boolean gOI;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fRT = null;
        this.agz = null;
        this.efc = false;
    }

    public int bh(int i) {
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
            cVar.dHq = 7;
            cVar.dHw = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.fRT != null) {
                this.fRT.setUniqueId(bdUniqueId);
            }
            if (this.gOG != null) {
                this.gOG.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fRT != null) {
            this.fRT.setEventCallback(aVar);
        }
    }

    public void sI(int i) {
        this.currentPageType = i;
        if (this.fRI != null) {
            this.fRI.edR = i;
        }
        if (this.gOF != null) {
            this.gOF.edR = i;
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.fRI != null) {
            this.fRI.onChangeSkinType();
        }
        if (this.gOF != null) {
            this.gOF.onChangeSkinType();
        }
        if (this.fRT != null) {
            this.fRT.onChangeSkinType();
        }
        if (this.agz != null) {
            this.agz.onChangeSkinType();
        }
        if (this.gOH != null) {
            this.gOH.onChangeSkinType(tbPageContext, i);
        }
        if (this.gOG != null) {
            this.gOG.onChangeSkinType(i);
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

    public void aN(ViewGroup viewGroup) {
        e(viewGroup, aP(viewGroup));
        aO(viewGroup);
        bOa();
        bOb();
        bNZ();
    }

    private void bNZ() {
        if (this.gOH == null || this.gOH.getVisibility() != 0) {
            setMarginsTop(this.fRI, bh(R.dimen.tbds20));
            setMarginsTop(this.gOF, bh(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.fRI, 0);
        setMarginsTop(this.gOF, 0);
    }

    private void bOa() {
        if (this.aea != null && this.aea.aPS() != null && this.gOH != null) {
            if (this.aea.aPY() || this.aea.aQa()) {
                this.gOH.setData(this.aea.aPS());
            } else if (this.efc) {
                this.gOH.setData(this.aea.aPS());
            }
        }
    }

    public void bOb() {
        if (this.aea != null && this.aea.aPS() != null) {
            bu aPS = this.aea.aPS();
            if (this.aea.aPZ()) {
                this.fRI.setVisibility(8);
                this.gOI = this.gOF.setData(aPS);
                return;
            }
            this.gOF.setVisibility(8);
            this.gOI = this.fRI.setData(aPS);
        }
    }

    private void aO(ViewGroup viewGroup) {
        if (this.aea != null && this.aea.aPS() != null) {
            if (this.agz == null) {
                this.agz = new UnfollowedDecorView(this.dPv.getPageActivity());
                viewGroup.addView(this.agz);
            }
            if (this.aea.aPS().dOz && !aw.v(this.aea.aPS())) {
                if (this.aea.aPZ()) {
                    this.agz.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                    int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                    int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                    layoutParams.rightMargin = dimens3;
                    layoutParams.topMargin = dimens4;
                    layoutParams.gravity = 53;
                    this.agz.setPadding(dimens2, dimens2, dimens2, dimens2);
                    this.agz.setLayoutParams(layoutParams);
                } else {
                    this.agz.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                    int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
                    int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                    int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                    int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens5, dimens5);
                    layoutParams2.bottomMargin = dimens8;
                    layoutParams2.rightMargin = dimens7;
                    layoutParams2.gravity = 85;
                    this.agz.setPadding(dimens6, dimens6, dimens6, dimens6);
                    this.agz.setLayoutParams(layoutParams2);
                }
                this.agz.setVisibility(0);
                this.agz.q(this.aea.aPS());
            } else if (this.agz != null) {
                this.agz.setVisibility(8);
            }
        }
    }

    private boolean aP(ViewGroup viewGroup) {
        if (this.aea == null || this.aea.aPS() == null) {
            return false;
        }
        if (this.aea.aPS() != null && this.aea.feedBackReasonMap != null && this.aea.feedBackReasonMap.size() > 0) {
            if (this.fRT == null) {
                this.fRT = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.fRT);
            }
            if (this.aea.aPZ()) {
                this.fRT.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.fRT.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.fRT.setLayoutParams(layoutParams);
            } else {
                this.fRT.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
                int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens5, dimens5);
                layoutParams2.bottomMargin = dimens8;
                layoutParams2.rightMargin = dimens7;
                layoutParams2.gravity = 85;
                this.fRT.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.fRT.setLayoutParams(layoutParams2);
            }
            ap apVar = new ap();
            apVar.setTid(this.aea.aPS().getTid());
            apVar.setFid(this.aea.aPS().getFid());
            apVar.setNid(this.aea.aPS().getNid());
            apVar.setFeedBackReasonMap(this.aea.feedBackReasonMap);
            this.fRT.setVisibility(0);
            this.fRT.setData(apVar);
            this.fRT.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.fRT != null) {
            this.fRT.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.aea != null && this.aea.aPS() != null) {
            if (this.gOG == null) {
                this.gOG = new FollowUserDecorView(this.dPv.getPageActivity());
                viewGroup.addView(this.gOG);
            }
            if (bOc()) {
                boolean aPZ = this.aea.aPZ();
                this.gOG.setPageUniqueId(this.mBdUniqueId);
                this.gOG.setSvgIconResId(this.aea.aQb() ? R.drawable.icon_pure_add12_svg : 0);
                int bh = bh(R.dimen.tbds166);
                int bh2 = bh(R.dimen.tbds78);
                int bh3 = bh((z && aPZ) ? R.dimen.tbds104 : R.dimen.tbds44);
                int bh4 = bh(R.dimen.tbds50);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bh, bh2);
                layoutParams.topMargin = bh4;
                layoutParams.rightMargin = bh3;
                layoutParams.gravity = 53;
                this.gOG.setLayoutParams(layoutParams);
                this.gOG.setData(this.aea.aPS());
            } else if (this.gOG != null) {
                this.gOG.setVisibility(8);
            }
        }
    }

    private boolean bOc() {
        if (this.aea == null || this.aea.aPS() == null || this.aea.aPS().aSp() == null) {
            return false;
        }
        bu aPS = this.aea.aPS();
        if (aw.v(aPS)) {
            return false;
        }
        if (this.aea.aQb()) {
            MetaData aSp = aPS.aSp();
            boolean hadConcerned = aSp.hadConcerned();
            return (!hadConcerned || (hadConcerned && !aSp.isLikeStatusFromNet())) && aPS.dOy;
        }
        boolean z = aPS.aUk() || aPS.aQX() || aPS.aQY();
        if (z && aPS.dOy) {
            return true;
        }
        if (z && aPS.dOA && !aPS.aSp().hadConcerned()) {
            return true;
        }
        return aPS.aSJ() != null && com.baidu.tieba.card.data.j.ad(aPS) && aPS.dOy;
    }
}
