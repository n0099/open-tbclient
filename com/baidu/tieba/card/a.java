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
/* loaded from: classes21.dex */
public abstract class a<T extends AbsThreadDataSupport> extends b<T> {
    protected T afH;
    protected UnfollowedDecorView aim;
    protected boolean eJz;
    protected TbPageContext<?> etO;
    public ThreadCommentAndPraiseInfoLayout gAE;
    protected NEGFeedBackView gAP;
    public ThreadCommentAndPraiseInfoLayout hDf;
    protected FollowUserDecorView hDg;
    protected ForumEnterLayout hDh;
    protected boolean hDi;
    protected BdUniqueId mBdUniqueId;
    protected View mDivider;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gAP = null;
        this.aim = null;
        this.eJz = false;
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
            cVar.ela = 7;
            cVar.elg = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.gAP != null) {
                this.gAP.setUniqueId(bdUniqueId);
            }
            if (this.hDg != null) {
                this.hDg.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gAP != null) {
            this.gAP.setEventCallback(aVar);
        }
    }

    public void wu(int i) {
        this.currentPageType = i;
        if (this.gAE != null) {
            this.gAE.eIo = i;
        }
        if (this.hDf != null) {
            this.hDf.eIo = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.gAE != null) {
            this.gAE.onChangeSkinType();
        }
        if (this.hDf != null) {
            this.hDf.onChangeSkinType();
        }
        if (this.gAP != null) {
            this.gAP.onChangeSkinType();
        }
        if (this.aim != null) {
            this.aim.onChangeSkinType();
        }
        if (this.hDh != null) {
            this.hDh.onChangeSkinType(tbPageContext, i);
        }
        if (this.hDg != null) {
            this.hDg.onChangeSkinType(i);
        }
        com.baidu.tbadk.a.b.a.aZ(this.mDivider);
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

    public void aQ(ViewGroup viewGroup) {
        e(viewGroup, aS(viewGroup));
        aR(viewGroup);
        cii();
        cij();
        cih();
        com.baidu.tbadk.a.b.a.a(this.mDivider, this.afH);
    }

    private void cih() {
        if ((this.hDh == null || this.hDh.getVisibility() != 0) && !com.baidu.tbadk.a.d.bdB()) {
            setMarginsTop(this.gAE, aT(R.dimen.tbds20));
            setMarginsTop(this.hDf, aT(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.gAE, 0);
        setMarginsTop(this.hDf, 0);
    }

    private void cii() {
        if (this.afH != null && this.afH.bfG() != null && this.hDh != null) {
            if (this.afH.bfM()) {
                this.hDh.setData(this.afH.bfG());
            } else if (this.eJz) {
                this.hDh.setData(this.afH.bfG());
            }
        }
    }

    public void cij() {
        if (this.afH != null && this.afH.bfG() != null) {
            bw bfG = this.afH.bfG();
            this.gAE.setVisibility(8);
            this.hDi = this.hDf.setData(bfG);
        }
    }

    private void aR(ViewGroup viewGroup) {
        if (this.afH != null && this.afH.bfG() != null) {
            if (this.aim == null) {
                this.aim = new UnfollowedDecorView(this.etO.getPageActivity());
                viewGroup.addView(this.aim);
            }
            if (this.afH.bfG().esA && !ay.x(this.afH.bfG())) {
                this.aim.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.aim.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.aim.setLayoutParams(layoutParams);
                this.aim.setVisibility(0);
                this.aim.r(this.afH.bfG());
            } else if (this.aim != null) {
                this.aim.setVisibility(8);
            }
        }
    }

    private boolean aS(ViewGroup viewGroup) {
        if (this.afH == null || this.afH.bfG() == null) {
            return false;
        }
        if (this.afH.bfG() != null && this.afH.feedBackReasonMap != null && this.afH.feedBackReasonMap.size() > 0) {
            if (this.gAP == null) {
                this.gAP = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.gAP);
            }
            this.gAP.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.gAP.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.gAP.setLayoutParams(layoutParams);
            ar arVar = new ar();
            arVar.setTid(this.afH.bfG().getTid());
            arVar.setFid(this.afH.bfG().getFid());
            arVar.setNid(this.afH.bfG().getNid());
            arVar.setFeedBackReasonMap(this.afH.feedBackReasonMap);
            this.gAP.setVisibility(0);
            this.gAP.setData(arVar);
            this.gAP.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.gAP != null) {
            this.gAP.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.afH != null && this.afH.bfG() != null) {
            if (this.hDg == null) {
                this.hDg = new FollowUserDecorView(this.etO.getPageActivity());
                viewGroup.addView(this.hDg);
            }
            if (cik()) {
                this.hDg.setPageUniqueId(this.mBdUniqueId);
                this.hDg.setSvgIconResId(0);
                int aT = aT(R.dimen.tbds166);
                int aT2 = aT(R.dimen.tbds78);
                int aT3 = aT(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int aT4 = aT(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bdB()) {
                    aT = aT(R.dimen.tbds177);
                    aT2 = aT(R.dimen.tbds76);
                    aT3 = aT(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    aT4 = aT(R.dimen.tbds52);
                    this.hDg.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aT, aT2);
                layoutParams.topMargin = aT4;
                layoutParams.rightMargin = aT3;
                layoutParams.gravity = 53;
                this.hDg.setLayoutParams(layoutParams);
                this.hDg.setData(this.afH.bfG());
            } else if (this.hDg != null) {
                this.hDg.setVisibility(8);
            }
        }
    }

    private boolean cik() {
        if (this.afH == null || this.afH.bfG() == null || this.afH.bfG().bih() == null) {
            return false;
        }
        bw bfG = this.afH.bfG();
        if (!ay.x(bfG)) {
            boolean z = bfG.bkb() || bfG.bgP() || bfG.bgQ();
            if (z && bfG.esz) {
                return true;
            }
            if (z && bfG.esB && !bfG.bih().hadConcerned()) {
                return true;
            }
            if (bfG.biB() != null && com.baidu.tieba.card.data.k.ab(bfG) && bfG.esz) {
                return true;
            }
        }
        return false;
    }
}
