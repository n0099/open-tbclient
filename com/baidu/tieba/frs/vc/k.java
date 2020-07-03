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
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
/* loaded from: classes9.dex */
public class k {
    private static int ias = 5000;
    private AppBarLayout WW;
    private ValueAnimator ecC;
    private FrsHeaderViewContainer hCE;
    private BdTypeRecyclerView hCj;
    private int iaC;
    private int iaD;
    private PullRefreshFrameLayout iat;
    private ValueAnimator iau;
    private as iax;
    private com.baidu.tieba.frs.n iay;
    private View iaz;
    private boolean iav = false;
    private boolean iaw = false;
    private RelativeLayout.LayoutParams iaA = null;
    private int iaB = 0;
    private PullRefreshFrameLayout.b iaE = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void n(double d) {
            if (k.this.iaz != null && k.this.iaA != null) {
                k.this.iaA.height = (int) (k.this.iaB + (PullRefreshFrameLayout.ecl * d));
                k.this.iaz.setLayoutParams(k.this.iaA);
                if (k.this.iay != null) {
                    k.this.iay.r(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void c(final int i, double d) {
            if (k.this.iaz != null && k.this.iaA != null && k.this.iay != null) {
                k.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.ecC.setDuration(150L);
                final int i2 = k.this.iaA.height;
                final int height = k.this.iay.getHeight();
                k.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.iaA.height = (int) (i2 - (i * animatedFraction));
                        k.this.iaz.setLayoutParams(k.this.iaA);
                        if (k.this.iay != null) {
                            k.this.iay.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.ecC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.iaC = k.this.iaA.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.ecC.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void aYh() {
            if (k.this.iaA != null) {
                final int i = k.this.iaA.height;
                final int i2 = k.this.iaA.height - k.this.iaB;
                final int i3 = 0;
                if (k.this.iay != null) {
                    i3 = k.this.iay.bYO();
                }
                if (i2 > 0) {
                    k.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.ecC.setDuration(300L);
                    k.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.iaA.height = (int) (i - (i2 * floatValue));
                            k.this.iaz.setLayoutParams(k.this.iaA);
                            if (k.this.iay != null && i3 > 0) {
                                k.this.iay.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.ecC.start();
                    k.this.ecC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.iaC = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.iax != null) {
                        k.this.iax.aYh();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.a iaF = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
        public void aYg() {
            k.this.cfE();
        }
    };
    private Runnable iaG = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.iaw) {
                k.this.cfF();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.iat = null;
        View rootView = frsFragment.getRootView();
        this.iat = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.iat.setFromFrs();
        this.iat.setOnTouchCallback(this.iaE);
        this.iat.setOnPullRefreshListener(this.iaF);
        this.iat.aYf();
        this.hCE = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.WW = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hCj = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        bZK();
    }

    public void setInterceptScrollDown(boolean z) {
        this.iat.setInterceptScrollDown(z);
    }

    public int cfC() {
        return this.iaC;
    }

    public int cfD() {
        return this.iaB;
    }

    public void dismissLoading() {
        if (this.iat != null) {
            this.iat.dismissLoading();
        }
    }

    public void M(int i, boolean z) {
        if (i == this.iaD) {
            this.iav = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hCj.getAdapter().notifyDataSetChanged();
            btU();
        }
    }

    public boolean bYC() {
        return this.iav;
    }

    public void onDestroy() {
        if (this.iaw) {
            cfF();
        }
        if (this.ecC != null) {
            this.ecC.cancel();
            this.ecC.removeAllListeners();
            this.ecC.removeAllUpdateListeners();
            this.ecC = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iaG);
    }

    public void startPullRefresh() {
        if (this.iat != null || this.iat.isEnable()) {
            if (this.hCj != null) {
                this.hCj.setSelection(0);
            }
            if (this.WW != null) {
                this.WW.setExpanded(true);
            }
            if (!this.iaw) {
                this.iau = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.iau.setDuration(300L);
                this.iau.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.iaA != null) {
                            k.this.iaA.height = (int) (k.this.iaB + (PullRefreshFrameLayout.eck * floatValue));
                            k.this.iaz.setLayoutParams(k.this.iaA);
                        }
                        if (k.this.iay != null) {
                            k.this.iay.setHeight((int) ((floatValue * PullRefreshFrameLayout.eck) + k.this.iay.getOriginHeight()));
                        }
                    }
                });
                this.iau.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.iaw && k.this.iat != null && !k.this.iat.isLoading()) {
                            k.this.cfF();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iau.start();
                this.iat.setRefreshing(true);
                cfE();
            }
        }
    }

    public void bZJ() {
        final View headBgContainer;
        if (this.hCE != null && (headBgContainer = this.hCE.getHeadBgContainer()) != null) {
            if (this.iay == null) {
                this.iay = new com.baidu.tieba.frs.n(headBgContainer);
            }
            if (this.iay.bYO() > 0) {
                this.iay.setHeight(this.iay.bYO());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.iay.getOriginHeight() < 0) {
                        k.this.iay.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.iay.bYO() < 0) {
                        k.this.iay.uq(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void bZK() {
        if (this.hCE != null) {
            this.iaz = this.hCE.getHeaderEmptyView();
            if (this.iaz != null) {
                this.iaB = 0;
                this.iaA = (RelativeLayout.LayoutParams) this.iaz.getLayoutParams();
                if (this.iaz.getHeight() > 0) {
                    this.iaA.height = this.iaB;
                    this.iaz.setLayoutParams(this.iaA);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfE() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.iaG, ias);
        this.iaw = true;
        if (this.iax != null) {
            this.iax.aYg();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cfF() {
        this.iaw = false;
        if (this.iat != null) {
            this.iat.aYe();
        }
    }

    public void btU() {
        if (this.iaw) {
            cfF();
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iaG);
        }
    }

    public void ng(boolean z) {
        if (this.iat != null) {
            this.iat.setEnable(z);
        }
    }

    public void a(as asVar) {
        this.iax = asVar;
    }

    public void uD(int i) {
        this.iaD = i;
    }
}
