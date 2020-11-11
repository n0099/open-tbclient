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
    protected T afI;
    protected UnfollowedDecorView ain;
    protected TbPageContext<?> eIc;
    protected boolean eXK;
    public ThreadCommentAndPraiseInfoLayout gSR;
    protected NEGFeedBackView gTc;
    protected ForumEnterLayout hVA;
    protected boolean hVB;
    public ThreadCommentAndPraiseInfoLayout hVy;
    protected FollowUserDecorView hVz;
    protected BdUniqueId mBdUniqueId;
    protected View mDivider;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gTc = null;
        this.ain = null;
        this.eXK = false;
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
            cVar.ezt = 7;
            cVar.ezz = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.gTc != null) {
                this.gTc.setUniqueId(bdUniqueId);
            }
            if (this.hVz != null) {
                this.hVz.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gTc != null) {
            this.gTc.setEventCallback(aVar);
        }
    }

    public void xa(int i) {
        this.currentPageType = i;
        if (this.gSR != null) {
            this.gSR.eWz = i;
        }
        if (this.hVy != null) {
            this.hVy.eWz = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.gSR != null) {
            this.gSR.onChangeSkinType();
        }
        if (this.hVy != null) {
            this.hVy.onChangeSkinType();
        }
        if (this.gTc != null) {
            this.gTc.onChangeSkinType();
        }
        if (this.ain != null) {
            this.ain.onChangeSkinType();
        }
        if (this.hVA != null) {
            this.hVA.onChangeSkinType(tbPageContext, i);
        }
        if (this.hVz != null) {
            this.hVz.onChangeSkinType(i);
        }
        com.baidu.tbadk.a.b.a.be(this.mDivider);
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

    public void aS(ViewGroup viewGroup) {
        e(viewGroup, aU(viewGroup));
        aT(viewGroup);
        cnQ();
        cnR();
        cnP();
        com.baidu.tbadk.a.b.a.a(this.mDivider, this.afI);
    }

    private void cnP() {
        if ((this.hVA == null || this.hVA.getVisibility() != 0) && !com.baidu.tbadk.a.d.bhU()) {
            setMarginsTop(this.gSR, aT(R.dimen.tbds20));
            setMarginsTop(this.hVy, aT(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.gSR, 0);
        setMarginsTop(this.hVy, 0);
    }

    private void cnQ() {
        if (this.afI != null && this.afI.bjZ() != null && this.hVA != null) {
            if (this.afI.bkf()) {
                this.hVA.setData(this.afI.bjZ());
            } else if (this.eXK) {
                this.hVA.setData(this.afI.bjZ());
            }
        }
    }

    public void cnR() {
        if (this.afI != null && this.afI.bjZ() != null) {
            bw bjZ = this.afI.bjZ();
            this.gSR.setVisibility(8);
            this.hVB = this.hVy.setData(bjZ);
        }
    }

    private void aT(ViewGroup viewGroup) {
        if (this.afI != null && this.afI.bjZ() != null) {
            if (this.ain == null) {
                this.ain = new UnfollowedDecorView(this.eIc.getPageActivity());
                viewGroup.addView(this.ain);
            }
            if (this.afI.bjZ().eGP && !ay.x(this.afI.bjZ())) {
                this.ain.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.ain.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.ain.setLayoutParams(layoutParams);
                this.ain.setVisibility(0);
                this.ain.r(this.afI.bjZ());
            } else if (this.ain != null) {
                this.ain.setVisibility(8);
            }
        }
    }

    private boolean aU(ViewGroup viewGroup) {
        if (this.afI == null || this.afI.bjZ() == null) {
            return false;
        }
        if (this.afI.bjZ() != null && this.afI.feedBackReasonMap != null && this.afI.feedBackReasonMap.size() > 0) {
            if (this.gTc == null) {
                this.gTc = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.gTc);
            }
            this.gTc.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.gTc.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.gTc.setLayoutParams(layoutParams);
            ar arVar = new ar();
            arVar.setTid(this.afI.bjZ().getTid());
            arVar.setFid(this.afI.bjZ().getFid());
            arVar.setNid(this.afI.bjZ().getNid());
            arVar.setFeedBackReasonMap(this.afI.feedBackReasonMap);
            this.gTc.setVisibility(0);
            this.gTc.setData(arVar);
            this.gTc.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.gTc != null) {
            this.gTc.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.afI != null && this.afI.bjZ() != null) {
            if (this.hVz == null) {
                this.hVz = new FollowUserDecorView(this.eIc.getPageActivity());
                viewGroup.addView(this.hVz);
            }
            if (cnS()) {
                this.hVz.setPageUniqueId(this.mBdUniqueId);
                this.hVz.setSvgIconResId(0);
                int aT = aT(R.dimen.tbds166);
                int aT2 = aT(R.dimen.tbds78);
                int aT3 = aT(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int aT4 = aT(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bhU()) {
                    aT = aT(R.dimen.tbds177);
                    aT2 = aT(R.dimen.tbds76);
                    aT3 = aT(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    aT4 = aT(R.dimen.tbds52);
                    this.hVz.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aT, aT2);
                layoutParams.topMargin = aT4;
                layoutParams.rightMargin = aT3;
                layoutParams.gravity = 53;
                this.hVz.setLayoutParams(layoutParams);
                this.hVz.setData(this.afI.bjZ());
            } else if (this.hVz != null) {
                this.hVz.setVisibility(8);
            }
        }
    }

    private boolean cnS() {
        if (this.afI == null || this.afI.bjZ() == null || this.afI.bjZ().bmA() == null) {
            return false;
        }
        bw bjZ = this.afI.bjZ();
        if (!ay.x(bjZ)) {
            boolean z = bjZ.bou() || bjZ.bli() || bjZ.blj();
            if (z && bjZ.eGO) {
                return true;
            }
            if (z && bjZ.eGQ && !bjZ.bmA().hadConcerned()) {
                return true;
            }
            if (bjZ.bmU() != null && com.baidu.tieba.card.data.k.ab(bjZ) && bjZ.eGO) {
                return true;
            }
        }
        return false;
    }
}
