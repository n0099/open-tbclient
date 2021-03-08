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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tbadk.core.data.a> extends b<T> {
    protected T ahB;
    protected UnfollowedDecorView akp;
    protected TbPageContext<?> eWx;
    protected boolean fnf;
    public ThreadCommentAndPraiseInfoLayout hpe;
    protected NEGFeedBackView hpp;
    public ThreadCommentAndPraiseInfoLayout iwm;
    protected FollowUserDecorView iwn;
    protected ForumEnterLayout iwo;
    protected boolean iwp;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hpp = null;
        this.akp = null;
        this.fnf = false;
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
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eNB = 7;
            eVar.eNH = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(eVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.hpp != null) {
                this.hpp.setUniqueId(bdUniqueId);
            }
            if (this.iwn != null) {
                this.iwn.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hpp != null) {
            this.hpp.setEventCallback(aVar);
        }
    }

    public void wW(int i) {
        this.currentPageType = i;
        if (this.hpe != null) {
            this.hpe.flV = i;
        }
        if (this.iwm != null) {
            this.iwm.flV = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.hpe != null) {
            this.hpe.onChangeSkinType();
        }
        if (this.iwm != null) {
            this.iwm.onChangeSkinType();
        }
        if (this.hpp != null) {
            this.hpp.onChangeSkinType();
        }
        if (this.akp != null) {
            this.akp.onChangeSkinType();
        }
        if (this.iwo != null) {
            this.iwo.onChangeSkinType(tbPageContext, i);
        }
        if (this.iwn != null) {
            this.iwn.onChangeSkinType(i);
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

    public void ba(ViewGroup viewGroup) {
        d(viewGroup, bc(viewGroup));
        bb(viewGroup);
        csf();
        csg();
        cse();
    }

    private void cse() {
        if ((this.iwo == null || this.iwo.getVisibility() != 0) && !com.baidu.tbadk.a.d.biZ()) {
            setMarginsTop(this.hpe, getDimens(R.dimen.tbds20));
            setMarginsTop(this.iwm, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.hpe, 0);
        setMarginsTop(this.iwm, 0);
    }

    private void csf() {
        if (this.ahB != null && this.ahB.blp() != null && this.iwo != null) {
            if (this.ahB.blt()) {
                this.iwo.setData(this.ahB.blp());
            } else if (this.fnf) {
                this.iwo.setData(this.ahB.blp());
            }
        }
    }

    public void csg() {
        if (this.ahB != null && this.ahB.blp() != null) {
            cb blp = this.ahB.blp();
            this.hpe.setVisibility(8);
            this.iwp = this.iwm.setData(blp);
        }
    }

    private void bb(ViewGroup viewGroup) {
        if (this.ahB != null && this.ahB.blp() != null) {
            if (this.akp == null) {
                this.akp = new UnfollowedDecorView(this.eWx.getPageActivity());
                viewGroup.addView(this.akp);
            }
            if (this.ahB.blp().eVg && !az.x(this.ahB.blp())) {
                this.akp.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.akp.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.akp.setLayoutParams(layoutParams);
                this.akp.setVisibility(0);
                this.akp.r(this.ahB.blp());
            } else if (this.akp != null) {
                this.akp.setVisibility(8);
            }
        }
    }

    private boolean bc(ViewGroup viewGroup) {
        if (this.ahB == null || this.ahB.blp() == null) {
            return false;
        }
        if (this.ahB.blp() != null && this.ahB.feedBackReasonMap != null && this.ahB.feedBackReasonMap.size() > 0) {
            if (this.hpp == null) {
                this.hpp = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.hpp);
            }
            this.hpp.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.hpp.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.hpp.setLayoutParams(layoutParams);
            av avVar = new av();
            avVar.setTid(this.ahB.blp().getTid());
            avVar.setFid(this.ahB.blp().getFid());
            avVar.setNid(this.ahB.blp().bmq());
            avVar.setFeedBackReasonMap(this.ahB.feedBackReasonMap);
            this.hpp.setVisibility(0);
            this.hpp.setData(avVar);
            this.hpp.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.hpp != null) {
            this.hpp.setVisibility(8);
        }
        return false;
    }

    private void d(ViewGroup viewGroup, boolean z) {
        if (this.ahB != null && this.ahB.blp() != null) {
            if (this.iwn == null) {
                this.iwn = new FollowUserDecorView(this.eWx.getPageActivity());
                viewGroup.addView(this.iwn);
            }
            if (csh()) {
                this.iwn.setPageUniqueId(this.mBdUniqueId);
                this.iwn.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.biZ()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.iwn.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.iwn.setLayoutParams(layoutParams);
                this.iwn.setData(this.ahB.blp());
            } else if (this.iwn != null) {
                this.iwn.setVisibility(8);
            }
        }
    }

    private boolean csh() {
        if (this.ahB == null || this.ahB.blp() == null || this.ahB.blp().bnS() == null) {
            return false;
        }
        cb blp = this.ahB.blp();
        if (!az.x(blp)) {
            boolean z = blp.bpO() || blp.bmz() || blp.bmA();
            if (z && blp.eVf) {
                return true;
            }
            if (z && blp.eVh && !blp.bnS().hadConcerned()) {
                return true;
            }
            if (blp.bol() != null && com.baidu.tieba.card.data.j.ae(blp) && blp.eVf) {
                return true;
            }
        }
        return false;
    }
}
