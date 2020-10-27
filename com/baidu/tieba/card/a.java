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
    protected TbPageContext<?> eCn;
    protected boolean eRV;
    protected NEGFeedBackView gMD;
    public ThreadCommentAndPraiseInfoLayout gMs;
    public ThreadCommentAndPraiseInfoLayout hPB;
    protected FollowUserDecorView hPC;
    protected ForumEnterLayout hPD;
    protected boolean hPE;
    protected BdUniqueId mBdUniqueId;
    protected View mDivider;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gMD = null;
        this.ain = null;
        this.eRV = false;
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
            cVar.etA = 7;
            cVar.etG = 1;
            threadCommentAndPraiseInfoLayout.setAgreeStatisticData(cVar);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setTag(bdUniqueId);
            if (this.gMD != null) {
                this.gMD.setUniqueId(bdUniqueId);
            }
            if (this.hPC != null) {
                this.hPC.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gMD != null) {
            this.gMD.setEventCallback(aVar);
        }
    }

    public void wN(int i) {
        this.currentPageType = i;
        if (this.gMs != null) {
            this.gMs.eQK = i;
        }
        if (this.hPB != null) {
            this.hPB.eQK = i;
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.gMs != null) {
            this.gMs.onChangeSkinType();
        }
        if (this.hPB != null) {
            this.hPB.onChangeSkinType();
        }
        if (this.gMD != null) {
            this.gMD.onChangeSkinType();
        }
        if (this.ain != null) {
            this.ain.onChangeSkinType();
        }
        if (this.hPD != null) {
            this.hPD.onChangeSkinType(tbPageContext, i);
        }
        if (this.hPC != null) {
            this.hPC.onChangeSkinType(i);
        }
        com.baidu.tbadk.a.b.a.ba(this.mDivider);
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
        clp();
        clq();
        clo();
        com.baidu.tbadk.a.b.a.a(this.mDivider, this.afI);
    }

    private void clo() {
        if ((this.hPD == null || this.hPD.getVisibility() != 0) && !com.baidu.tbadk.a.d.bfu()) {
            setMarginsTop(this.gMs, aT(R.dimen.tbds20));
            setMarginsTop(this.hPB, aT(R.dimen.tbds20));
            return;
        }
        setMarginsTop(this.gMs, 0);
        setMarginsTop(this.hPB, 0);
    }

    private void clp() {
        if (this.afI != null && this.afI.bhz() != null && this.hPD != null) {
            if (this.afI.bhF()) {
                this.hPD.setData(this.afI.bhz());
            } else if (this.eRV) {
                this.hPD.setData(this.afI.bhz());
            }
        }
    }

    public void clq() {
        if (this.afI != null && this.afI.bhz() != null) {
            bw bhz = this.afI.bhz();
            this.gMs.setVisibility(8);
            this.hPE = this.hPB.setData(bhz);
        }
    }

    private void aR(ViewGroup viewGroup) {
        if (this.afI != null && this.afI.bhz() != null) {
            if (this.ain == null) {
                this.ain = new UnfollowedDecorView(this.eCn.getPageActivity());
                viewGroup.addView(this.ain);
            }
            if (this.afI.bhz().eBa && !ay.x(this.afI.bhz())) {
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
                this.ain.r(this.afI.bhz());
            } else if (this.ain != null) {
                this.ain.setVisibility(8);
            }
        }
    }

    private boolean aS(ViewGroup viewGroup) {
        if (this.afI == null || this.afI.bhz() == null) {
            return false;
        }
        if (this.afI.bhz() != null && this.afI.feedBackReasonMap != null && this.afI.feedBackReasonMap.size() > 0) {
            if (this.gMD == null) {
                this.gMD = new NEGFeedBackView(getTbPageContext());
                viewGroup.addView(this.gMD);
            }
            this.gMD.setSvgResId(R.drawable.icon_home_delete_n, R.color.cp_cont_g);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
            layoutParams.rightMargin = dimens3;
            layoutParams.topMargin = dimens4;
            layoutParams.gravity = 53;
            this.gMD.setPadding(dimens2, dimens2, dimens2, dimens2);
            this.gMD.setLayoutParams(layoutParams);
            ar arVar = new ar();
            arVar.setTid(this.afI.bhz().getTid());
            arVar.setFid(this.afI.bhz().getFid());
            arVar.setNid(this.afI.bhz().getNid());
            arVar.setFeedBackReasonMap(this.afI.feedBackReasonMap);
            this.gMD.setVisibility(0);
            this.gMD.setData(arVar);
            this.gMD.setFirstRowSingleColumn(true);
            return true;
        }
        if (this.gMD != null) {
            this.gMD.setVisibility(8);
        }
        return false;
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (this.afI != null && this.afI.bhz() != null) {
            if (this.hPC == null) {
                this.hPC = new FollowUserDecorView(this.eCn.getPageActivity());
                viewGroup.addView(this.hPC);
            }
            if (clr()) {
                this.hPC.setPageUniqueId(this.mBdUniqueId);
                this.hPC.setSvgIconResId(0);
                int aT = aT(R.dimen.tbds166);
                int aT2 = aT(R.dimen.tbds78);
                int aT3 = aT(z ? R.dimen.tbds104 : R.dimen.tbds44);
                int aT4 = aT(R.dimen.tbds50);
                if (com.baidu.tbadk.a.d.bfu()) {
                    aT = aT(R.dimen.tbds177);
                    aT2 = aT(R.dimen.tbds76);
                    aT3 = aT(z ? R.dimen.tbds126 : R.dimen.tbds44);
                    aT4 = aT(R.dimen.tbds52);
                    this.hPC.setUseNewStyle(true);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aT, aT2);
                layoutParams.topMargin = aT4;
                layoutParams.rightMargin = aT3;
                layoutParams.gravity = 53;
                this.hPC.setLayoutParams(layoutParams);
                this.hPC.setData(this.afI.bhz());
            } else if (this.hPC != null) {
                this.hPC.setVisibility(8);
            }
        }
    }

    private boolean clr() {
        if (this.afI == null || this.afI.bhz() == null || this.afI.bhz().bka() == null) {
            return false;
        }
        bw bhz = this.afI.bhz();
        if (!ay.x(bhz)) {
            boolean z = bhz.blU() || bhz.biI() || bhz.biJ();
            if (z && bhz.eAZ) {
                return true;
            }
            if (z && bhz.eBb && !bhz.bka().hadConcerned()) {
                return true;
            }
            if (bhz.bku() != null && com.baidu.tieba.card.data.k.ab(bhz) && bhz.eAZ) {
                return true;
            }
        }
        return false;
    }
}
