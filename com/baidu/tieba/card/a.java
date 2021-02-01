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
    public ThreadCommentAndPraiseInfoLayout hng;
    protected NEGFeedBackView hnr;
    public ThreadCommentAndPraiseInfoLayout iup;
    protected FollowUserDecorView iuq;
    protected ForumEnterLayout iur;
    protected boolean ius;
    protected BdUniqueId mBdUniqueId;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hnr = null;
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
            if (this.hnr != null) {
                this.hnr.setUniqueId(bdUniqueId);
            }
            if (this.iuq != null) {
                this.iuq.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hnr != null) {
            this.hnr.setEventCallback(aVar);
        }
    }

    public void wV(int i) {
        this.currentPageType = i;
        if (this.hng != null) {
            this.hng.fkw = i;
        }
        if (this.iup != null) {
            this.iup.fkw = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.hng != null) {
            this.hng.onChangeSkinType();
        }
        if (this.iup != null) {
            this.iup.onChangeSkinType();
        }
        if (this.hnr != null) {
            this.hnr.onChangeSkinType();
        }
        if (this.aiX != null) {
            this.aiX.onChangeSkinType();
        }
        if (this.iur != null) {
            this.iur.onChangeSkinType(tbPageContext, i);
        }
        if (this.iuq != null) {
            this.iuq.onChangeSkinType(i);
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
        crS();
        crT();
        crR();
    }

    private void crR() {
        if ((this.iur == null || this.iur.getVisibility() != 0) && !com.baidu.tbadk.a.d.biX()) {
            setMarginsTop(this.hng, getDimens(R.dimen.tbds20));
            setMarginsTop(this.iup, getDimens(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.hng, 0);
        setMarginsTop(this.iup, 0);
    }

    private void crS() {
        if (this.agj != null && this.agj.bln() != null && this.iur != null) {
            if (this.agj.blr()) {
                this.iur.setData(this.agj.bln());
            } else if (this.flF) {
                this.iur.setData(this.agj.bln());
            }
        }
    }

    public void crT() {
        if (this.agj != null && this.agj.bln() != null) {
            cb bln = this.agj.bln();
            this.hng.setVisibility(8);
            this.ius = this.iup.setData(bln);
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
            if (this.hnr == null) {
                this.hnr = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.hnr);
            }
            this.hnr.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.hnr.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.hnr.setLayoutParams(layoutParams);
            av avVar = new av();
            avVar.setTid(this.agj.bln().getTid());
            avVar.setFid(this.agj.bln().getFid());
            avVar.setNid(this.agj.bln().bmo());
            avVar.setFeedBackReasonMap(this.agj.feedBackReasonMap);
            this.hnr.setVisibility(0);
            this.hnr.setData(avVar);
            this.hnr.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.hnr != null) {
            this.hnr.setVisibility(8);
        }
        return false;
    }

    private void d(ViewGroup viewGroup, boolean z) {
        if (this.agj != null && this.agj.bln() != null) {
            if (this.iuq == null) {
                this.iuq = new FollowUserDecorView(this.eUY.getPageActivity());
                viewGroup.addView(this.iuq);
            }
            if (crU()) {
                this.iuq.setPageUniqueId(this.mBdUniqueId);
                this.iuq.setSvgIconResId(0);
                int dimens = getDimens(R.dimen.tbds166);
                int dimens2 = getDimens(R.dimen.tbds78);
                int dimens3 = getDimens(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int dimens4 = getDimens(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.biX()) {
                    dimens = getDimens(R.dimen.tbds177);
                    dimens2 = getDimens(R.dimen.tbds76);
                    dimens3 = getDimens(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    dimens4 = getDimens(R.dimen.tbds52);
                    this.iuq.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens2);
                layoutParams.topMargin = dimens4;
                layoutParams.rightMargin = dimens3;
                layoutParams.gravity = 53;
                this.iuq.setLayoutParams(layoutParams);
                this.iuq.setData(this.agj.bln());
            } else if (this.iuq != null) {
                this.iuq.setVisibility(8);
            }
        }
    }

    private boolean crU() {
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
