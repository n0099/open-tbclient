package com.baidu.tieba.frs.vc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
/* loaded from: classes9.dex */
public class k {
    private static int hMt = 5000;
    private AppBarLayout Wr;
    private ValueAnimator dVl;
    private View hMA;
    private int hMD;
    private int hME;
    private PullRefreshFrameLayout hMu;
    private ValueAnimator hMv;
    private an hMy;
    private com.baidu.tieba.frs.l hMz;
    private FrsHeaderViewContainer hpL;
    private BdTypeRecyclerView hpo;
    private boolean hMw = false;
    private boolean hMx = false;
    private RelativeLayout.LayoutParams hMB = null;
    private int hMC = 0;
    private PullRefreshFrameLayout.b hMF = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void n(double d) {
            if (k.this.hMA != null && k.this.hMB != null) {
                k.this.hMB.height = (int) (k.this.hMC + (PullRefreshFrameLayout.dUU * d));
                k.this.hMA.setLayoutParams(k.this.hMB);
                if (k.this.hMz != null) {
                    k.this.hMz.r(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void c(final int i, double d) {
            if (k.this.hMA != null && k.this.hMB != null && k.this.hMz != null) {
                k.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.dVl.setDuration(150L);
                final int i2 = k.this.hMB.height;
                final int height = k.this.hMz.getHeight();
                k.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.hMB.height = (int) (i2 - (i * animatedFraction));
                        k.this.hMA.setLayoutParams(k.this.hMB);
                        if (k.this.hMz != null) {
                            k.this.hMz.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.hMD = k.this.hMB.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.dVl.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void aWp() {
            if (k.this.hMB != null) {
                final int i = k.this.hMB.height;
                final int i2 = k.this.hMB.height - k.this.hMC;
                final int i3 = 0;
                if (k.this.hMz != null) {
                    i3 = k.this.hMz.bVE();
                }
                if (i2 > 0) {
                    k.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.dVl.setDuration(300L);
                    k.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.hMB.height = (int) (i - (i2 * floatValue));
                            k.this.hMA.setLayoutParams(k.this.hMB);
                            if (k.this.hMz != null && i3 > 0) {
                                k.this.hMz.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.dVl.start();
                    k.this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.hMD = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.hMy != null) {
                        k.this.hMy.aWp();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.a hMG = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
        public void aWo() {
            k.this.cce();
        }
    };
    private Runnable hMH = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.hMx) {
                k.this.ccf();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.hMu = null;
        View rootView = frsFragment.getRootView();
        this.hMu = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.hMu.setFromFrs();
        this.hMu.setOnTouchCallback(this.hMF);
        this.hMu.setOnPullRefreshListener(this.hMG);
        this.hMu.aWn();
        this.hpL = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Wr = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hpo = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        bWy();
    }

    public void setInterceptScrollDown(boolean z) {
        this.hMu.setInterceptScrollDown(z);
    }

    public int ccc() {
        return this.hMD;
    }

    public int ccd() {
        return this.hMC;
    }

    public void dismissLoading() {
        if (this.hMu != null) {
            this.hMu.dismissLoading();
        }
    }

    public void K(int i, boolean z) {
        if (i == this.hME) {
            this.hMw = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hpo.getAdapter().notifyDataSetChanged();
            bqV();
        }
    }

    public boolean bVt() {
        return this.hMw;
    }

    public void onDestroy() {
        if (this.hMx) {
            ccf();
        }
        if (this.dVl != null) {
            this.dVl.cancel();
            this.dVl.removeAllListeners();
            this.dVl.removeAllUpdateListeners();
            this.dVl = null;
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hMH);
    }

    public void startPullRefresh() {
        if (this.hMu != null || this.hMu.isEnable()) {
            if (this.hpo != null) {
                this.hpo.setSelection(0);
            }
            if (this.Wr != null) {
                this.Wr.setExpanded(true);
            }
            if (!this.hMx) {
                this.hMv = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.hMv.setDuration(300L);
                this.hMv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.hMB != null) {
                            k.this.hMB.height = (int) (k.this.hMC + (PullRefreshFrameLayout.dUT * floatValue));
                            k.this.hMA.setLayoutParams(k.this.hMB);
                        }
                        if (k.this.hMz != null) {
                            k.this.hMz.setHeight((int) ((floatValue * PullRefreshFrameLayout.dUT) + k.this.hMz.getOriginHeight()));
                        }
                    }
                });
                this.hMv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.hMx && k.this.hMu != null && !k.this.hMu.isLoading()) {
                            k.this.ccf();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.hMv.start();
                this.hMu.setRefreshing(true);
                cce();
            }
        }
    }

    public void bWx() {
        final View headBgContainer;
        if (this.hpL != null && (headBgContainer = this.hpL.getHeadBgContainer()) != null) {
            if (this.hMz == null) {
                this.hMz = new com.baidu.tieba.frs.l(headBgContainer);
            }
            if (this.hMz.bVE() > 0) {
                this.hMz.setHeight(this.hMz.bVE());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.hMz.getOriginHeight() < 0) {
                        k.this.hMz.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.hMz.bVE() < 0) {
                        k.this.hMz.tL(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void bWy() {
        if (this.hpL != null) {
            this.hMA = this.hpL.getHeaderEmptyView();
            if (this.hMA != null) {
                this.hMC = 0;
                this.hMB = (RelativeLayout.LayoutParams) this.hMA.getLayoutParams();
                if (this.hMA.getHeight() > 0) {
                    this.hMB.height = this.hMC;
                    this.hMA.setLayoutParams(this.hMB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cce() {
        com.baidu.adp.lib.f.e.ld().postDelayed(this.hMH, hMt);
        this.hMx = true;
        if (this.hMy != null) {
            this.hMy.aWo();
        }
    }

    public void ccf() {
        this.hMx = false;
        if (this.hMu != null) {
            this.hMu.aWm();
        }
    }

    public void bqV() {
        if (this.hMx) {
            ccf();
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hMH);
        }
    }

    public void mV(boolean z) {
        if (this.hMu != null) {
            this.hMu.setEnable(z);
        }
    }

    public void a(an anVar) {
        this.hMy = anVar;
    }

    public void tW(int i) {
        this.hME = i;
    }
}
