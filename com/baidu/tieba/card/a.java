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
    public ThreadCommentAndPraiseInfoLayout hbN;
    protected NEGFeedBackView hbY;
    public ThreadCommentAndPraiseInfoLayout igX;
    protected FollowUserDecorView igY;
    protected ForumEnterLayout igZ;
    protected boolean iha;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hbY = null;
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
            if (this.hbY != null) {
                this.hbY.setUniqueId(bdUniqueId);
            }
            if (this.igY != null) {
                this.igY.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hbY != null) {
            this.hbY.setEventCallback(aVar);
        }
    }

    public void ye(int i) {
        this.currentPageType = i;
        if (this.hbN != null) {
            this.hbN.fdg = i;
        }
        if (this.igX != null) {
            this.igX.fdg = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.hbN != null) {
            this.hbN.onChangeSkinType();
        }
        if (this.igX != null) {
            this.igX.onChangeSkinType();
        }
        if (this.hbY != null) {
            this.hbY.onChangeSkinType();
        }
        if (this.ajp != null) {
            this.ajp.onChangeSkinType();
        }
        if (this.igZ != null) {
            this.igZ.onChangeSkinType(tbPageContext, i);
        }
        if (this.igY != null) {
            this.igY.onChangeSkinType(i);
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
        crG();
        crH();
        crF();
    }

    private void crF() {
        if ((this.igZ == null || this.igZ.getVisibility() != 0) && !com.baidu.tbadk.a.d.bkq()) {
            setMarginsTop(this.hbN, getDimens(R.dimen.tbds20));
            setMarginsTop(this.igX, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.hbN, 0);
        setMarginsTop(this.igX, 0);
    }

    private void crG() {
        if (this.agJ != null && this.agJ.bmn() != null && this.igZ != null) {
            if (this.agJ.bmr()) {
                this.igZ.setData(this.agJ.bmn());
            } else if (this.feo) {
                this.igZ.setData(this.agJ.bmn());
            }
        }
    }

    public void crH() {
        if (this.agJ != null && this.agJ.bmn() != null) {
            by bmn = this.agJ.bmn();
            this.hbN.setVisibility(8);
            this.iha = this.igX.setData(bmn);
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
            if (this.hbY == null) {
                this.hbY = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.hbY);
            }
            this.hbY.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.hbY.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.hbY.setLayoutParams(layoutParams);
            at atVar = new at();
            atVar.setTid(this.agJ.bmn().getTid());
            atVar.setFid(this.agJ.bmn().getFid());
            atVar.setNid(this.agJ.bmn().getNid());
            atVar.setFeedBackReasonMap(this.agJ.feedBackReasonMap);
            this.hbY.setVisibility(0);
            this.hbY.setData(atVar);
            this.hbY.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.hbY != null) {
            this.hbY.setVisibility(8);
        }
        return false;
    }

    private void d(ViewGroup viewGroup, boolean z) {
        if (this.agJ != null && this.agJ.bmn() != null) {
            if (this.igY == null) {
                this.igY = new FollowUserDecorView(this.eNx.getPageActivity());
                viewGroup.addView(this.igY);
            }
            if (crI()) {
                this.igY.setPageUniqueId(this.mBdUniqueId);
                this.igY.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bkq()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.igY.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.igY.setLayoutParams(layoutParams);
                this.igY.setData(this.agJ.bmn());
            } else if (this.igY != null) {
                this.igY.setVisibility(8);
            }
        }
    }

    private boolean crI() {
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
