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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public abstract class a<T extends com.baidu.tbadk.core.data.a> extends b<T> {
    protected T agJ;
    protected UnfollowedDecorView ajp;
    protected TbPageContext<?> eNx;
    protected boolean feo;
    public ThreadCommentAndPraiseInfoLayout hbL;
    protected NEGFeedBackView hbW;
    public ThreadCommentAndPraiseInfoLayout igV;
    protected FollowUserDecorView igW;
    protected ForumEnterLayout igX;
    protected boolean igY;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hbW = null;
        this.ajp = null;
        this.feo = false;
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
            dVar.eEJ = 7;
            dVar.eEP = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(dVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.hbW != null) {
                this.hbW.setUniqueId(bdUniqueId);
            }
            if (this.igW != null) {
                this.igW.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hbW != null) {
            this.hbW.setEventCallback(aVar);
        }
    }

    public void ye(int i) {
        this.currentPageType = i;
        if (this.hbL != null) {
            this.hbL.fdg = i;
        }
        if (this.igV != null) {
            this.igV.fdg = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.hbL != null) {
            this.hbL.onChangeSkinType();
        }
        if (this.igV != null) {
            this.igV.onChangeSkinType();
        }
        if (this.hbW != null) {
            this.hbW.onChangeSkinType();
        }
        if (this.ajp != null) {
            this.ajp.onChangeSkinType();
        }
        if (this.igX != null) {
            this.igX.onChangeSkinType(tbPageContext, i);
        }
        if (this.igW != null) {
            this.igW.onChangeSkinType(i);
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
        d(viewGroup, aQ(viewGroup));
        aP(viewGroup);
        crF();
        crG();
        crE();
    }

    private void crE() {
        if ((this.igX == null || this.igX.getVisibility() != 0) && !com.baidu.tbadk.a.d.bkq()) {
            setMarginsTop(this.hbL, getDimens(R.dimen.tbds20));
            setMarginsTop(this.igV, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.hbL, 0);
        setMarginsTop(this.igV, 0);
    }

    private void crF() {
        if (this.agJ != null && this.agJ.bmn() != null && this.igX != null) {
            if (this.agJ.bmr()) {
                this.igX.setData(this.agJ.bmn());
            } else if (this.feo) {
                this.igX.setData(this.agJ.bmn());
            }
        }
    }

    public void crG() {
        if (this.agJ != null && this.agJ.bmn() != null) {
            by bmn = this.agJ.bmn();
            this.hbL.setVisibility(8);
            this.igY = this.igV.setData(bmn);
        }
    }

    private void aP(ViewGroup viewGroup) {
        if (this.agJ != null && this.agJ.bmn() != null) {
            if (this.ajp == null) {
                this.ajp = new UnfollowedDecorView(this.eNx.getPageActivity());
                viewGroup.addView(this.ajp);
            }
            if (this.agJ.bmn().eMj && !az.x(this.agJ.bmn())) {
                this.ajp.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.ajp.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.ajp.setLayoutParams(layoutParams);
                this.ajp.setVisibility(0);
                this.ajp.r(this.agJ.bmn());
            } else if (this.ajp != null) {
                this.ajp.setVisibility(8);
            }
        }
    }

    private boolean aQ(ViewGroup viewGroup) {
        if (this.agJ == null || this.agJ.bmn() == null) {
            return false;
        }
        if (this.agJ.bmn() != null && this.agJ.feedBackReasonMap != null && this.agJ.feedBackReasonMap.size() > 0) {
            if (this.hbW == null) {
                this.hbW = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.hbW);
            }
            this.hbW.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.hbW.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.hbW.setLayoutParams(layoutParams);
            at atVar = new at();
            atVar.setTid(this.agJ.bmn().getTid());
            atVar.setFid(this.agJ.bmn().getFid());
            atVar.setNid(this.agJ.bmn().getNid());
            atVar.setFeedBackReasonMap(this.agJ.feedBackReasonMap);
            this.hbW.setVisibility(0);
            this.hbW.setData(atVar);
            this.hbW.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.hbW != null) {
            this.hbW.setVisibility(8);
        }
        return false;
    }

    private void d(ViewGroup viewGroup, boolean z) {
        if (this.agJ != null && this.agJ.bmn() != null) {
            if (this.igW == null) {
                this.igW = new FollowUserDecorView(this.eNx.getPageActivity());
                viewGroup.addView(this.igW);
            }
            if (crH()) {
                this.igW.setPageUniqueId(this.mBdUniqueId);
                this.igW.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bkq()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.igW.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.igW.setLayoutParams(layoutParams);
                this.igW.setData(this.agJ.bmn());
            } else if (this.igW != null) {
                this.igW.setVisibility(8);
            }
        }
    }

    private boolean crH() {
        if (this.agJ == null || this.agJ.bmn() == null || this.agJ.bmn().boP() == null) {
            return false;
        }
        by bmn = this.agJ.bmn();
        if (!az.x(bmn)) {
            boolean z = bmn.bqL() || bmn.bnx() || bmn.bny();
            if (z && bmn.eMi) {
                return true;
            }
            if (z && bmn.eMk && !bmn.boP().hadConcerned()) {
                return true;
            }
            if (bmn.bpj() != null && com.baidu.tieba.card.data.j.ad(bmn) && bmn.eMi) {
                return true;
            }
        }
        return false;
    }
}
