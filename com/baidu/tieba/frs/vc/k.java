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
    private static int hNg = 5000;
    private AppBarLayout Wr;
    private ValueAnimator dVl;
    private PullRefreshFrameLayout hNh;
    private ValueAnimator hNi;
    private an hNl;
    private com.baidu.tieba.frs.l hNm;
    private View hNn;
    private int hNq;
    private int hNr;
    private FrsHeaderViewContainer hpW;
    private BdTypeRecyclerView hpz;
    private boolean hNj = false;
    private boolean hNk = false;
    private RelativeLayout.LayoutParams hNo = null;
    private int hNp = 0;
    private PullRefreshFrameLayout.b hNs = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void n(double d) {
            if (k.this.hNn != null && k.this.hNo != null) {
                k.this.hNo.height = (int) (k.this.hNp + (PullRefreshFrameLayout.dUU * d));
                k.this.hNn.setLayoutParams(k.this.hNo);
                if (k.this.hNm != null) {
                    k.this.hNm.r(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void c(final int i, double d) {
            if (k.this.hNn != null && k.this.hNo != null && k.this.hNm != null) {
                k.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.dVl.setDuration(150L);
                final int i2 = k.this.hNo.height;
                final int height = k.this.hNm.getHeight();
                k.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.hNo.height = (int) (i2 - (i * animatedFraction));
                        k.this.hNn.setLayoutParams(k.this.hNo);
                        if (k.this.hNm != null) {
                            k.this.hNm.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.hNq = k.this.hNo.height;
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
        public void aWq() {
            if (k.this.hNo != null) {
                final int i = k.this.hNo.height;
                final int i2 = k.this.hNo.height - k.this.hNp;
                final int i3 = 0;
                if (k.this.hNm != null) {
                    i3 = k.this.hNm.bVG();
                }
                if (i2 > 0) {
                    k.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.dVl.setDuration(300L);
                    k.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.hNo.height = (int) (i - (i2 * floatValue));
                            k.this.hNn.setLayoutParams(k.this.hNo);
                            if (k.this.hNm != null && i3 > 0) {
                                k.this.hNm.setHeight((int) (i3 - (floatValue * i2)));
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
                            k.this.hNq = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.hNl != null) {
                        k.this.hNl.aWq();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.a hNt = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
        public void aWp() {
            k.this.ccm();
        }
    };
    private Runnable hNu = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.hNk) {
                k.this.ccn();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.hNh = null;
        View rootView = frsFragment.getRootView();
        this.hNh = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.hNh.setFromFrs();
        this.hNh.setOnTouchCallback(this.hNs);
        this.hNh.setOnPullRefreshListener(this.hNt);
        this.hNh.aWo();
        this.hpW = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Wr = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hpz = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        bWA();
    }

    public void setInterceptScrollDown(boolean z) {
        this.hNh.setInterceptScrollDown(z);
    }

    public int cck() {
        return this.hNq;
    }

    public int ccl() {
        return this.hNp;
    }

    public void dismissLoading() {
        if (this.hNh != null) {
            this.hNh.dismissLoading();
        }
    }

    public void K(int i, boolean z) {
        if (i == this.hNr) {
            this.hNj = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hpz.getAdapter().notifyDataSetChanged();
            bqX();
        }
    }

    public boolean bVv() {
        return this.hNj;
    }

    public void onDestroy() {
        if (this.hNk) {
            ccn();
        }
        if (this.dVl != null) {
            this.dVl.cancel();
            this.dVl.removeAllListeners();
            this.dVl.removeAllUpdateListeners();
            this.dVl = null;
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hNu);
    }

    public void startPullRefresh() {
        if (this.hNh != null || this.hNh.isEnable()) {
            if (this.hpz != null) {
                this.hpz.setSelection(0);
            }
            if (this.Wr != null) {
                this.Wr.setExpanded(true);
            }
            if (!this.hNk) {
                this.hNi = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.hNi.setDuration(300L);
                this.hNi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.hNo != null) {
                            k.this.hNo.height = (int) (k.this.hNp + (PullRefreshFrameLayout.dUT * floatValue));
                            k.this.hNn.setLayoutParams(k.this.hNo);
                        }
                        if (k.this.hNm != null) {
                            k.this.hNm.setHeight((int) ((floatValue * PullRefreshFrameLayout.dUT) + k.this.hNm.getOriginHeight()));
                        }
                    }
                });
                this.hNi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.hNk && k.this.hNh != null && !k.this.hNh.isLoading()) {
                            k.this.ccn();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.hNi.start();
                this.hNh.setRefreshing(true);
                ccm();
            }
        }
    }

    public void bWz() {
        final View headBgContainer;
        if (this.hpW != null && (headBgContainer = this.hpW.getHeadBgContainer()) != null) {
            if (this.hNm == null) {
                this.hNm = new com.baidu.tieba.frs.l(headBgContainer);
            }
            if (this.hNm.bVG() > 0) {
                this.hNm.setHeight(this.hNm.bVG());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.hNm.getOriginHeight() < 0) {
                        k.this.hNm.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.hNm.bVG() < 0) {
                        k.this.hNm.tN(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void bWA() {
        if (this.hpW != null) {
            this.hNn = this.hpW.getHeaderEmptyView();
            if (this.hNn != null) {
                this.hNp = 0;
                this.hNo = (RelativeLayout.LayoutParams) this.hNn.getLayoutParams();
                if (this.hNn.getHeight() > 0) {
                    this.hNo.height = this.hNp;
                    this.hNn.setLayoutParams(this.hNo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        com.baidu.adp.lib.f.e.ld().postDelayed(this.hNu, hNg);
        this.hNk = true;
        if (this.hNl != null) {
            this.hNl.aWp();
        }
    }

    public void ccn() {
        this.hNk = false;
        if (this.hNh != null) {
            this.hNh.aWn();
        }
    }

    public void bqX() {
        if (this.hNk) {
            ccn();
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hNu);
        }
    }

    public void mV(boolean z) {
        if (this.hNh != null) {
            this.hNh.setEnable(z);
        }
    }

    public void a(an anVar) {
        this.hNl = anVar;
    }

    public void tY(int i) {
        this.hNr = i;
    }
}
