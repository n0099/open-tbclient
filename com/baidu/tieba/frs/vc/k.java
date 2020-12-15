package com.baidu.tieba.frs.vc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
/* loaded from: classes22.dex */
public class k {
    private static int jxC = 5000;
    private AppBarLayout Zj;
    private ValueAnimator fbQ;
    private BdTypeRecyclerView iVF;
    private FrsHeaderViewContainer iWa;
    private PullRefreshFrameLayout jxD;
    private ValueAnimator jxE;
    private at jxH;
    private o jxI;
    private View jxJ;
    private int jxM;
    private int jxN;
    private boolean jxF = false;
    private boolean jxG = false;
    private RelativeLayout.LayoutParams jxK = null;
    private int jxL = 0;
    private PullRefreshFrameLayout.d jxO = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void w(double d) {
            if (k.this.jxJ != null && k.this.jxK != null) {
                k.this.jxK.height = (int) (k.this.jxL + (PullRefreshFrameLayout.fbv * d));
                k.this.jxJ.setLayoutParams(k.this.jxK);
                if (k.this.jxI != null) {
                    k.this.jxI.C(d);
                }
                k.this.jxD.bvo();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.jxJ != null && k.this.jxK != null && k.this.jxI != null) {
                k.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.fbQ.setDuration(150L);
                final int i2 = k.this.jxK.height;
                final int height = k.this.jxI.getHeight();
                k.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jxK.height = (int) (i2 - (i * animatedFraction));
                        k.this.jxJ.setLayoutParams(k.this.jxK);
                        if (k.this.jxI != null) {
                            k.this.jxI.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jxM = k.this.jxK.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.fbQ.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void bvr() {
            if (k.this.jxK != null) {
                final int i = k.this.jxK.height;
                final int i2 = k.this.jxK.height - k.this.jxL;
                final int i3 = 0;
                if (k.this.jxI != null) {
                    i3 = k.this.jxI.cCX();
                }
                if (i2 > 0) {
                    k.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.fbQ.setDuration(300L);
                    k.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jxK.height = (int) (i - (i2 * floatValue));
                            k.this.jxJ.setLayoutParams(k.this.jxK);
                            if (k.this.jxI != null && i3 > 0) {
                                k.this.jxI.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.fbQ.start();
                    k.this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jxM = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jxH != null) {
                        k.this.jxH.bvr();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jxP = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bvq() {
            k.this.cLc();
        }
    };
    private Runnable jxQ = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jxG) {
                k.this.cLd();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jxD = null;
        View rootView = frsFragment.getRootView();
        this.jxD = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jxD.setFromFrs();
        this.jxD.setOnTouchCallback(this.jxO);
        this.jxD.setOnPullRefreshListener(this.jxP);
        this.jxD.bvn();
        this.iWa = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Zj = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.iVF = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cDS();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jxD.setInterceptScrollDown(z);
    }

    public int cLa() {
        return this.jxM;
    }

    public int cLb() {
        return this.jxL;
    }

    public void dismissLoading() {
        if (this.jxD != null) {
            this.jxD.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jxN) {
            this.jxF = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.iVF.getAdapter().notifyDataSetChanged();
            bSm();
        }
    }

    public boolean cCL() {
        return this.jxF;
    }

    public void onDestroy() {
        if (this.jxG) {
            cLd();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxQ);
    }

    public void startPullRefresh() {
        if (this.jxD != null || this.jxD.isEnable()) {
            if (this.iVF != null) {
                this.iVF.setSelection(0);
            }
            if (this.Zj != null) {
                this.Zj.setExpanded(true);
            }
            if (!this.jxG) {
                this.jxE = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jxE.setDuration(300L);
                this.jxE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jxK != null) {
                            k.this.jxK.height = (int) (k.this.jxL + (PullRefreshFrameLayout.fbu * floatValue));
                            k.this.jxJ.setLayoutParams(k.this.jxK);
                        }
                        if (k.this.jxI != null) {
                            k.this.jxI.setHeight((int) ((floatValue * PullRefreshFrameLayout.fbu) + k.this.jxI.getOriginHeight()));
                        }
                    }
                });
                this.jxE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jxG && k.this.jxD != null && !k.this.jxD.isLoading()) {
                            k.this.cLd();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jxE.start();
                this.jxD.setRefreshing(true);
                cLc();
            }
        }
    }

    public void cDR() {
        final View headBgContainer;
        if (this.iWa != null && (headBgContainer = this.iWa.getHeadBgContainer()) != null) {
            if (this.jxI == null) {
                this.jxI = new o(headBgContainer);
            }
            if (this.jxI.cCX() > 0) {
                this.jxI.setHeight(this.jxI.cCX());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jxI.getOriginHeight() < 0) {
                        k.this.jxI.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jxI.cCX() < 0) {
                        k.this.jxI.zL(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cDS() {
        if (this.iWa != null) {
            this.jxJ = this.iWa.getHeaderEmptyView();
            if (this.jxJ != null) {
                this.jxL = 0;
                this.jxK = (RelativeLayout.LayoutParams) this.jxJ.getLayoutParams();
                if (this.jxJ.getHeight() > 0) {
                    this.jxK.height = this.jxL;
                    this.jxJ.setLayoutParams(this.jxK);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLc() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxQ, jxC);
        this.jxG = true;
        if (this.jxH != null) {
            this.jxH.bvq();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cLd() {
        this.jxG = false;
        if (this.jxD != null) {
            this.jxD.bvm();
        }
    }

    public void bSm() {
        if (this.jxG) {
            cLd();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxQ);
        }
    }

    public void qd(boolean z) {
        if (this.jxD != null) {
            this.jxD.setEnable(z);
        }
    }

    public void a(at atVar) {
        this.jxH = atVar;
    }

    public void zY(int i) {
        this.jxN = i;
    }

    public PullRefreshFrameLayout cLe() {
        return this.jxD;
    }
}
