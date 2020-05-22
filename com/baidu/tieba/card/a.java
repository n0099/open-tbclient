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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public abstract class a<T extends AbsThreadDataSupport> extends b<T> {
    protected T adw;
    protected UnfollowedDecorView afO;
    protected TbPageContext<?> dIF;
    protected boolean dXG;
    public ThreadCommentAndPraiseInfoLayout fGo;
    protected NEGFeedBackView fGz;
    public ThreadCommentAndPraiseInfoLayout gBE;
    protected FollowUserDecorView gBF;
    protected ForumEnterLayout gBG;
    protected boolean gBH;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fGz = null;
        this.afO = null;
        this.dXG = false;
    }

    public int bb(int i) {
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
            cVar.dAZ = 7;
            cVar.dBf = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.fGz != null) {
                this.fGz.setUniqueId(bdUniqueId);
            }
            if (this.gBF != null) {
                this.gBF.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fGz != null) {
            this.fGz.setEventCallback(aVar);
        }
    }

    public void si(int i) {
        this.currentPageType = i;
        if (this.fGo != null) {
            this.fGo.dWv = i;
        }
        if (this.gBE != null) {
            this.gBE.dWv = i;
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.fGo != null) {
            this.fGo.onChangeSkinType();
        }
        if (this.gBE != null) {
            this.gBE.onChangeSkinType();
        }
        if (this.fGz != null) {
            this.fGz.onChangeSkinType();
        }
        if (this.afO != null) {
            this.afO.onChangeSkinType();
        }
        if (this.gBG != null) {
            this.gBG.onChangeSkinType(tbPageContext, i);
        }
        if (this.gBF != null) {
            this.gBF.onChangeSkinType(i);
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

    public void aJ(ViewGroup viewGroup) {
        e(viewGroup, aL(viewGroup));
        aK(viewGroup);
        bKP();
        bKQ();
        bKO();
    }

    private void bKO() {
        if (this.gBG == null || this.gBG.getVisibility() != 0) {
            setMarginsTop(this.fGo, bb(R.dimen.tbds20));
            setMarginsTop(this.gBE, bb(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.fGo, 0);
        setMarginsTop(this.gBE, 0);
    }

    private void bKP() {
        if (this.adw != null && this.adw.aOi() != null && this.gBG != null) {
            if (this.adw.aOo() || this.adw.aOq()) {
                this.gBG.setData(this.adw.aOi());
            } else if (this.dXG) {
                this.gBG.setData(this.adw.aOi());
            }
        }
    }

    public void bKQ() {
        if (this.adw != null && this.adw.aOi() != null) {
            bk aOi = this.adw.aOi();
            if (this.adw.aOp()) {
                this.fGo.setVisibility(8);
                this.gBH = this.gBE.setData(aOi);
                return;
            }
            this.gBE.setVisibility(8);
            this.gBH = this.fGo.setData(aOi);
        }
    }

    private void aK(ViewGroup viewGroup) {
        if (this.adw != null && this.adw.aOi() != null) {
            if (this.afO == null) {
                this.afO = new UnfollowedDecorView(this.dIF.getPageActivity());
                viewGroup.addView(this.afO);
            }
            if (this.adw.aOi().dHN && !au.v(this.adw.aOi())) {
                if (this.adw.aOp()) {
                    this.afO.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                    int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                    int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                    layoutParams.rightMargin = dimens3;
                    layoutParams.topMargin = dimens4;
                    layoutParams.gravity = 53;
                    this.afO.setPadding(dimens2, dimens2, dimens2, dimens2);
                    this.afO.setLayoutParams(layoutParams);
                } else {
                    this.afO.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                    int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
                    int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                    int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                    int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens5, dimens5);
                    layoutParams2.bottomMargin = dimens8;
                    layoutParams2.rightMargin = dimens7;
                    layoutParams2.gravity = 85;
                    this.afO.setPadding(dimens6, dimens6, dimens6, dimens6);
                    this.afO.setLayoutParams(layoutParams2);
                }
                this.afO.setVisibility(0);
                this.afO.r(this.adw.aOi());
            } else if (this.afO != null) {
                this.afO.setVisibility(8);
            }
        }
    }

    private boolean aL(ViewGroup viewGroup) {
        if (this.adw == null || this.adw.aOi() == null) {
            return false;
        }
        if (this.adw.aOi() != null && this.adw.feedBackReasonMap != null && this.adw.feedBackReasonMap.size() > 0) {
            if (this.fGz == null) {
                this.fGz = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.fGz);
            }
            if (this.adw.aOp()) {
                this.fGz.setSvgResId(R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.fGz.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.fGz.setLayoutParams(layoutParams);
            } else {
                this.fGz.setSvgResId(R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g);
                int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds124);
                int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimens5, dimens5);
                layoutParams2.bottomMargin = dimens8;
                layoutParams2.rightMargin = dimens7;
                layoutParams2.gravity = 85;
                this.fGz.setPadding(dimens6, dimens6, dimens6, dimens6);
                this.fGz.setLayoutParams(layoutParams2);
            }
            ak akVar = new ak();
            akVar.setTid(this.adw.aOi().getTid());
            akVar.setFid(this.adw.aOi().getFid());
            akVar.setNid(this.adw.aOi().getNid());
            akVar.setFeedBackReasonMap(this.adw.feedBackReasonMap);
            this.fGz.setVisibility(0);
            this.fGz.setData(akVar);
            this.fGz.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.fGz != null) {
            this.fGz.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.adw != null && this.adw.aOi() != null) {
            if (this.gBF == null) {
                this.gBF = new FollowUserDecorView(this.dIF.getPageActivity());
                viewGroup.addView(this.gBF);
            }
            if (bKR()) {
                boolean aOp = this.adw.aOp();
                this.gBF.setPageUniqueId(this.mBdUniqueId);
                this.gBF.setSvgIconResId(this.adw.aOr() ? R.drawable.icon_pure_add12_svg : 0);
                int bb = bb(R.dimen.tbds166);
                int bb2 = bb(R.dimen.tbds78);
                int bb3 = bb((z && aOp) ? R.dimen.tbds104 : R.dimen.tbds44);
                int bb4 = bb(R.dimen.tbds50);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bb, bb2);
                layoutParams.topMargin = bb4;
                layoutParams.rightMargin = bb3;
                layoutParams.gravity = 53;
                this.gBF.setLayoutParams(layoutParams);
                this.gBF.setData(this.adw.aOi());
            } else if (this.gBF != null) {
                this.gBF.setVisibility(8);
            }
        }
    }

    private boolean bKR() {
        if (this.adw == null || this.adw.aOi() == null || this.adw.aOi().aQx() == null) {
            return false;
        }
        bk aOi = this.adw.aOi();
        if (au.v(aOi)) {
            return false;
        }
        if (this.adw.aOr()) {
            MetaData aQx = aOi.aQx();
            boolean hadConcerned = aQx.hadConcerned();
            return (!hadConcerned || (hadConcerned && !aQx.isLikeStatusFromNet())) && aOi.dHM;
        }
        boolean z = aOi.aSu() || aOi.aPm() || aOi.aPn();
        if (z && aOi.dHM) {
            return true;
        }
        if (z && aOi.dHO && !aOi.aQx().hadConcerned()) {
            return true;
        }
        return aOi.aQS() != null && com.baidu.tieba.card.data.j.ac(aOi) && aOi.dHM;
    }
}
