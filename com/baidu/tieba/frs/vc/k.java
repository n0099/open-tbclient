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
    private static int jxA = 5000;
    private AppBarLayout Zj;
    private ValueAnimator fbQ;
    private BdTypeRecyclerView iVD;
    private FrsHeaderViewContainer iVY;
    private PullRefreshFrameLayout jxB;
    private ValueAnimator jxC;
    private at jxF;
    private o jxG;
    private View jxH;
    private int jxK;
    private int jxL;
    private boolean jxD = false;
    private boolean jxE = false;
    private RelativeLayout.LayoutParams jxI = null;
    private int jxJ = 0;
    private PullRefreshFrameLayout.d jxM = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void w(double d) {
            if (k.this.jxH != null && k.this.jxI != null) {
                k.this.jxI.height = (int) (k.this.jxJ + (PullRefreshFrameLayout.fbv * d));
                k.this.jxH.setLayoutParams(k.this.jxI);
                if (k.this.jxG != null) {
                    k.this.jxG.C(d);
                }
                k.this.jxB.bvo();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.jxH != null && k.this.jxI != null && k.this.jxG != null) {
                k.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.fbQ.setDuration(150L);
                final int i2 = k.this.jxI.height;
                final int height = k.this.jxG.getHeight();
                k.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jxI.height = (int) (i2 - (i * animatedFraction));
                        k.this.jxH.setLayoutParams(k.this.jxI);
                        if (k.this.jxG != null) {
                            k.this.jxG.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jxK = k.this.jxI.height;
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
            if (k.this.jxI != null) {
                final int i = k.this.jxI.height;
                final int i2 = k.this.jxI.height - k.this.jxJ;
                final int i3 = 0;
                if (k.this.jxG != null) {
                    i3 = k.this.jxG.cCW();
                }
                if (i2 > 0) {
                    k.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.fbQ.setDuration(300L);
                    k.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jxI.height = (int) (i - (i2 * floatValue));
                            k.this.jxH.setLayoutParams(k.this.jxI);
                            if (k.this.jxG != null && i3 > 0) {
                                k.this.jxG.setHeight((int) (i3 - (floatValue * i2)));
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
                            k.this.jxK = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jxF != null) {
                        k.this.jxF.bvr();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jxN = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bvq() {
            k.this.cLb();
        }
    };
    private Runnable jxO = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jxE) {
                k.this.cLc();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jxB = null;
        View rootView = frsFragment.getRootView();
        this.jxB = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jxB.setFromFrs();
        this.jxB.setOnTouchCallback(this.jxM);
        this.jxB.setOnPullRefreshListener(this.jxN);
        this.jxB.bvn();
        this.iVY = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Zj = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.iVD = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cDR();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jxB.setInterceptScrollDown(z);
    }

    public int cKZ() {
        return this.jxK;
    }

    public int cLa() {
        return this.jxJ;
    }

    public void dismissLoading() {
        if (this.jxB != null) {
            this.jxB.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jxL) {
            this.jxD = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.iVD.getAdapter().notifyDataSetChanged();
            bSl();
        }
    }

    public boolean cCK() {
        return this.jxD;
    }

    public void onDestroy() {
        if (this.jxE) {
            cLc();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxO);
    }

    public void startPullRefresh() {
        if (this.jxB != null || this.jxB.isEnable()) {
            if (this.iVD != null) {
                this.iVD.setSelection(0);
            }
            if (this.Zj != null) {
                this.Zj.setExpanded(true);
            }
            if (!this.jxE) {
                this.jxC = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jxC.setDuration(300L);
                this.jxC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jxI != null) {
                            k.this.jxI.height = (int) (k.this.jxJ + (PullRefreshFrameLayout.fbu * floatValue));
                            k.this.jxH.setLayoutParams(k.this.jxI);
                        }
                        if (k.this.jxG != null) {
                            k.this.jxG.setHeight((int) ((floatValue * PullRefreshFrameLayout.fbu) + k.this.jxG.getOriginHeight()));
                        }
                    }
                });
                this.jxC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jxE && k.this.jxB != null && !k.this.jxB.isLoading()) {
                            k.this.cLc();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jxC.start();
                this.jxB.setRefreshing(true);
                cLb();
            }
        }
    }

    public void cDQ() {
        final View headBgContainer;
        if (this.iVY != null && (headBgContainer = this.iVY.getHeadBgContainer()) != null) {
            if (this.jxG == null) {
                this.jxG = new o(headBgContainer);
            }
            if (this.jxG.cCW() > 0) {
                this.jxG.setHeight(this.jxG.cCW());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jxG.getOriginHeight() < 0) {
                        k.this.jxG.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jxG.cCW() < 0) {
                        k.this.jxG.zL(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cDR() {
        if (this.iVY != null) {
            this.jxH = this.iVY.getHeaderEmptyView();
            if (this.jxH != null) {
                this.jxJ = 0;
                this.jxI = (RelativeLayout.LayoutParams) this.jxH.getLayoutParams();
                if (this.jxH.getHeight() > 0) {
                    this.jxI.height = this.jxJ;
                    this.jxH.setLayoutParams(this.jxI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLb() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jxO, jxA);
        this.jxE = true;
        if (this.jxF != null) {
            this.jxF.bvq();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cLc() {
        this.jxE = false;
        if (this.jxB != null) {
            this.jxB.bvm();
        }
    }

    public void bSl() {
        if (this.jxE) {
            cLc();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxO);
        }
    }

    public void qd(boolean z) {
        if (this.jxB != null) {
            this.jxB.setEnable(z);
        }
    }

    public void a(at atVar) {
        this.jxF = atVar;
    }

    public void zY(int i) {
        this.jxL = i;
    }

    public PullRefreshFrameLayout cLd() {
        return this.jxB;
    }
}
