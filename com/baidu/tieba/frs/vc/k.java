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
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
/* loaded from: classes16.dex */
public class k {
    private static int iuA = 5000;
    private AppBarLayout Xv;
    private ValueAnimator esF;
    private FrsHeaderViewContainer hVS;
    private BdTypeRecyclerView hVx;
    private PullRefreshFrameLayout iuB;
    private ValueAnimator iuC;
    private au iuF;
    private o iuG;
    private View iuH;
    private int iuK;
    private int iuL;
    private boolean iuD = false;
    private boolean iuE = false;
    private RelativeLayout.LayoutParams iuI = null;
    private int iuJ = 0;
    private PullRefreshFrameLayout.d iuM = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void t(double d) {
            if (k.this.iuH != null && k.this.iuI != null) {
                k.this.iuI.height = (int) (k.this.iuJ + (PullRefreshFrameLayout.esm * d));
                k.this.iuH.setLayoutParams(k.this.iuI);
                if (k.this.iuG != null) {
                    k.this.iuG.x(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.iuH != null && k.this.iuI != null && k.this.iuG != null) {
                k.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.esF.setDuration(150L);
                final int i2 = k.this.iuI.height;
                final int height = k.this.iuG.getHeight();
                k.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.iuI.height = (int) (i2 - (i * animatedFraction));
                        k.this.iuH.setLayoutParams(k.this.iuI);
                        if (k.this.iuG != null) {
                            k.this.iuG.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.esF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.iuK = k.this.iuI.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.esF.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void bkE() {
            if (k.this.iuI != null) {
                final int i = k.this.iuI.height;
                final int i2 = k.this.iuI.height - k.this.iuJ;
                final int i3 = 0;
                if (k.this.iuG != null) {
                    i3 = k.this.iuG.cmJ();
                }
                if (i2 > 0) {
                    k.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.esF.setDuration(300L);
                    k.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.iuI.height = (int) (i - (i2 * floatValue));
                            k.this.iuH.setLayoutParams(k.this.iuI);
                            if (k.this.iuG != null && i3 > 0) {
                                k.this.iuG.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.esF.start();
                    k.this.esF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.iuK = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.iuF != null) {
                        k.this.iuF.bkE();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c iuN = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bkD() {
            k.this.ctI();
        }
    };
    private Runnable iuO = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.iuE) {
                k.this.ctJ();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.iuB = null;
        View rootView = frsFragment.getRootView();
        this.iuB = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.iuB.setFromFrs();
        this.iuB.setOnTouchCallback(this.iuM);
        this.iuB.setOnPullRefreshListener(this.iuN);
        this.iuB.bkB();
        this.hVS = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Xv = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hVx = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cnF();
    }

    public void setInterceptScrollDown(boolean z) {
        this.iuB.setInterceptScrollDown(z);
    }

    public int ctG() {
        return this.iuK;
    }

    public int ctH() {
        return this.iuJ;
    }

    public void dismissLoading() {
        if (this.iuB != null) {
            this.iuB.dismissLoading();
        }
    }

    public void O(int i, boolean z) {
        if (i == this.iuL) {
            this.iuD = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hVx.getAdapter().notifyDataSetChanged();
            bGd();
        }
    }

    public boolean cmx() {
        return this.iuD;
    }

    public void onDestroy() {
        if (this.iuE) {
            ctJ();
        }
        if (this.esF != null) {
            this.esF.cancel();
            this.esF.removeAllListeners();
            this.esF.removeAllUpdateListeners();
            this.esF = null;
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuO);
    }

    public void startPullRefresh() {
        if (this.iuB != null || this.iuB.isEnable()) {
            if (this.hVx != null) {
                this.hVx.setSelection(0);
            }
            if (this.Xv != null) {
                this.Xv.setExpanded(true);
            }
            if (!this.iuE) {
                this.iuC = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.iuC.setDuration(300L);
                this.iuC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.iuI != null) {
                            k.this.iuI.height = (int) (k.this.iuJ + (PullRefreshFrameLayout.esl * floatValue));
                            k.this.iuH.setLayoutParams(k.this.iuI);
                        }
                        if (k.this.iuG != null) {
                            k.this.iuG.setHeight((int) ((floatValue * PullRefreshFrameLayout.esl) + k.this.iuG.getOriginHeight()));
                        }
                    }
                });
                this.iuC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.iuE && k.this.iuB != null && !k.this.iuB.isLoading()) {
                            k.this.ctJ();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iuC.start();
                this.iuB.setRefreshing(true);
                ctI();
            }
        }
    }

    public void cnE() {
        final View headBgContainer;
        if (this.hVS != null && (headBgContainer = this.hVS.getHeadBgContainer()) != null) {
            if (this.iuG == null) {
                this.iuG = new o(headBgContainer);
            }
            if (this.iuG.cmJ() > 0) {
                this.iuG.setHeight(this.iuG.cmJ());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.iuG.getOriginHeight() < 0) {
                        k.this.iuG.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.iuG.cmJ() < 0) {
                        k.this.iuG.wX(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cnF() {
        if (this.hVS != null) {
            this.iuH = this.hVS.getHeaderEmptyView();
            if (this.iuH != null) {
                this.iuJ = 0;
                this.iuI = (RelativeLayout.LayoutParams) this.iuH.getLayoutParams();
                if (this.iuH.getHeight() > 0) {
                    this.iuI.height = this.iuJ;
                    this.iuH.setLayoutParams(this.iuI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctI() {
        com.baidu.adp.lib.f.e.mS().postDelayed(this.iuO, iuA);
        this.iuE = true;
        if (this.iuF != null) {
            this.iuF.bkD();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void ctJ() {
        this.iuE = false;
        if (this.iuB != null) {
            this.iuB.bkA();
        }
    }

    public void bGd() {
        if (this.iuE) {
            ctJ();
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuO);
        }
    }

    public void op(boolean z) {
        if (this.iuB != null) {
            this.iuB.setEnable(z);
        }
    }

    public void a(au auVar) {
        this.iuF = auVar;
    }

    public void xk(int i) {
        this.iuL = i;
    }
}
