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
    protected T agj;
    protected UnfollowedDecorView aiX;
    protected TbPageContext<?> eUY;
    protected boolean flF;
    protected NEGFeedBackView hnF;
    public ThreadCommentAndPraiseInfoLayout hnu;
    public ThreadCommentAndPraiseInfoLayout iuD;
    protected FollowUserDecorView iuE;
    protected ForumEnterLayout iuF;
    protected boolean iuG;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hnF = null;
        this.aiX = null;
        this.flF = false;
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
            eVar.eMa = 7;
            eVar.eMg = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(eVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.hnF != null) {
                this.hnF.setUniqueId(bdUniqueId);
            }
            if (this.iuE != null) {
                this.iuE.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hnF != null) {
            this.hnF.setEventCallback(aVar);
        }
    }

    public void wV(int i) {
        this.currentPageType = i;
        if (this.hnu != null) {
            this.hnu.fkw = i;
        }
        if (this.iuD != null) {
            this.iuD.fkw = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.hnu != null) {
            this.hnu.onChangeSkinType();
        }
        if (this.iuD != null) {
            this.iuD.onChangeSkinType();
        }
        if (this.hnF != null) {
            this.hnF.onChangeSkinType();
        }
        if (this.aiX != null) {
            this.aiX.onChangeSkinType();
        }
        if (this.iuF != null) {
            this.iuF.onChangeSkinType(tbPageContext, i);
        }
        if (this.iuE != null) {
            this.iuE.onChangeSkinType(i);
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
        crZ();
        csa();
        crY();
    }

    private void crY() {
        if ((this.iuF == null || this.iuF.getVisibility() != 0) && !com.baidu.tbadk.a.d.biX()) {
            setMarginsTop(this.hnu, getDimens(R.dimen.tbds20));
            setMarginsTop(this.iuD, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.hnu, 0);
        setMarginsTop(this.iuD, 0);
    }

    private void crZ() {
        if (this.agj != null && this.agj.bln() != null && this.iuF != null) {
            if (this.agj.blr()) {
                this.iuF.setData(this.agj.bln());
            } else if (this.flF) {
                this.iuF.setData(this.agj.bln());
            }
        }
    }

    public void csa() {
        if (this.agj != null && this.agj.bln() != null) {
            cb bln = this.agj.bln();
            this.hnu.setVisibility(8);
            this.iuG = this.iuD.setData(bln);
        }
    }

    private void bb(ViewGroup viewGroup) {
        if (this.agj != null && this.agj.bln() != null) {
            if (this.aiX == null) {
                this.aiX = new UnfollowedDecorView(this.eUY.getPageActivity());
                viewGroup.addView(this.aiX);
            }
            if (this.agj.bln().eTF && !az.x(this.agj.bln())) {
                this.aiX.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.aiX.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.aiX.setLayoutParams(layoutParams);
                this.aiX.setVisibility(0);
                this.aiX.r(this.agj.bln());
            } else if (this.aiX != null) {
                this.aiX.setVisibility(8);
            }
        }
    }

    private boolean bc(ViewGroup viewGroup) {
        if (this.agj == null || this.agj.bln() == null) {
            return false;
        }
        if (this.agj.bln() != null && this.agj.feedBackReasonMap != null && this.agj.feedBackReasonMap.size() > 0) {
            if (this.hnF == null) {
                this.hnF = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.hnF);
            }
            this.hnF.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.hnF.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.hnF.setLayoutParams(layoutParams);
            av avVar = new av();
            avVar.setTid(this.agj.bln().getTid());
            avVar.setFid(this.agj.bln().getFid());
            avVar.setNid(this.agj.bln().bmo());
            avVar.setFeedBackReasonMap(this.agj.feedBackReasonMap);
            this.hnF.setVisibility(0);
            this.hnF.setData(avVar);
            this.hnF.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.hnF != null) {
            this.hnF.setVisibility(8);
        }
        return false;
    }

    private void d(ViewGroup viewGroup, boolean z) {
        if (this.agj != null && this.agj.bln() != null) {
            if (this.iuE == null) {
                this.iuE = new FollowUserDecorView(this.eUY.getPageActivity());
                viewGroup.addView(this.iuE);
            }
            if (csb()) {
                this.iuE.setPageUniqueId(this.mBdUniqueId);
                this.iuE.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.biX()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.iuE.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.iuE.setLayoutParams(layoutParams);
                this.iuE.setData(this.agj.bln());
            } else if (this.iuE != null) {
                this.iuE.setVisibility(8);
            }
        }
    }

    private boolean csb() {
        if (this.agj == null || this.agj.bln() == null || this.agj.bln().bnQ() == null) {
            return false;
        }
        cb bln = this.agj.bln();
        if (!az.x(bln)) {
            boolean z = bln.bpM() || bln.bmx() || bln.bmy();
            if (z && bln.eTE) {
                return true;
            }
            if (z && bln.eTG && !bln.bnQ().hadConcerned()) {
                return true;
            }
            if (bln.boj() != null && com.baidu.tieba.card.data.j.ae(bln) && bln.eTE) {
                return true;
            }
        }
        return false;
    }
}
