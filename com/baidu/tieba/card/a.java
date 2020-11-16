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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public abstract class a<T extends com.baidu.tbadk.core.data.a> extends b<T> {
    protected T afN;
    protected UnfollowedDecorView aiq;
    protected TbPageContext<?> eGu;
    protected boolean eWR;
    protected NEGFeedBackView gSJ;
    public ThreadCommentAndPraiseInfoLayout gSy;
    public ThreadCommentAndPraiseInfoLayout hVY;
    protected FollowUserDecorView hVZ;
    protected ForumEnterLayout hWa;
    protected boolean hWb;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gSJ = null;
        this.aiq = null;
        this.eWR = false;
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
            dVar.exI = 7;
            dVar.exO = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(dVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.gSJ != null) {
                this.gSJ.setUniqueId(bdUniqueId);
            }
            if (this.hVZ != null) {
                this.hVZ.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gSJ != null) {
            this.gSJ.setEventCallback(aVar);
        }
    }

    public void xy(int i) {
        this.currentPageType = i;
        if (this.gSy != null) {
            this.gSy.eVJ = i;
        }
        if (this.hVY != null) {
            this.hVY.eVJ = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.gSy != null) {
            this.gSy.onChangeSkinType();
        }
        if (this.hVY != null) {
            this.hVY.onChangeSkinType();
        }
        if (this.gSJ != null) {
            this.gSJ.onChangeSkinType();
        }
        if (this.aiq != null) {
            this.aiq.onChangeSkinType();
        }
        if (this.hWa != null) {
            this.hWa.onChangeSkinType(tbPageContext, i);
        }
        if (this.hVZ != null) {
            this.hVZ.onChangeSkinType(i);
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

    public void aO(ViewGroup viewGroup) {
        e(viewGroup, aQ(viewGroup));
        aP(viewGroup);
        cns();
        cnt();
        cnr();
    }

    private void cnr() {
        if ((this.hWa == null || this.hWa.getVisibility() != 0) && !com.baidu.tbadk.a.d.bhm()) {
            setMarginsTop(this.gSy, getDimens(R.dimen.tbds20));
            setMarginsTop(this.hVY, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.gSy, 0);
        setMarginsTop(this.hVY, 0);
    }

    private void cns() {
        if (this.afN != null && this.afN.bjd() != null && this.hWa != null) {
            if (this.afN.bjh()) {
                this.hWa.setData(this.afN.bjd());
            } else if (this.eWR) {
                this.hWa.setData(this.afN.bjd());
            }
        }
    }

    public void cnt() {
        if (this.afN != null && this.afN.bjd() != null) {
            bx bjd = this.afN.bjd();
            this.gSy.setVisibility(8);
            this.hWb = this.hVY.setData(bjd);
        }
    }

    private void aP(ViewGroup viewGroup) {
        if (this.afN != null && this.afN.bjd() != null) {
            if (this.aiq == null) {
                this.aiq = new UnfollowedDecorView(this.eGu.getPageActivity());
                viewGroup.addView(this.aiq);
            }
            if (this.afN.bjd().eFh && !az.x(this.afN.bjd())) {
                this.aiq.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.aiq.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.aiq.setLayoutParams(layoutParams);
                this.aiq.setVisibility(0);
                this.aiq.r(this.afN.bjd());
            } else if (this.aiq != null) {
                this.aiq.setVisibility(8);
            }
        }
    }

    private boolean aQ(ViewGroup viewGroup) {
        if (this.afN == null || this.afN.bjd() == null) {
            return false;
        }
        if (this.afN.bjd() != null && this.afN.feedBackReasonMap != null && this.afN.feedBackReasonMap.size() > 0) {
            if (this.gSJ == null) {
                this.gSJ = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.gSJ);
            }
            this.gSJ.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.gSJ.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.gSJ.setLayoutParams(layoutParams);
            as asVar = new as();
            asVar.setTid(this.afN.bjd().getTid());
            asVar.setFid(this.afN.bjd().getFid());
            asVar.setNid(this.afN.bjd().getNid());
            asVar.setFeedBackReasonMap(this.afN.feedBackReasonMap);
            this.gSJ.setVisibility(0);
            this.gSJ.setData(asVar);
            this.gSJ.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.gSJ != null) {
            this.gSJ.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.afN != null && this.afN.bjd() != null) {
            if (this.hVZ == null) {
                this.hVZ = new FollowUserDecorView(this.eGu.getPageActivity());
                viewGroup.addView(this.hVZ);
            }
            if (cnu()) {
                this.hVZ.setPageUniqueId(this.mBdUniqueId);
                this.hVZ.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bhm()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.hVZ.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.hVZ.setLayoutParams(layoutParams);
                this.hVZ.setData(this.afN.bjd());
            } else if (this.hVZ != null) {
                this.hVZ.setVisibility(8);
            }
        }
    }

    private boolean cnu() {
        if (this.afN == null || this.afN.bjd() == null || this.afN.bjd().blC() == null) {
            return false;
        }
        bx bjd = this.afN.bjd();
        if (!az.x(bjd)) {
            boolean z = bjd.bny() || bjd.bkk() || bjd.bkl();
            if (z && bjd.eFg) {
                return true;
            }
            if (z && bjd.eFi && !bjd.blC().hadConcerned()) {
                return true;
            }
            if (bjd.blW() != null && com.baidu.tieba.card.data.j.ad(bjd) && bjd.eFg) {
                return true;
            }
        }
        return false;
    }
}
