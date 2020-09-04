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
    private static int iuG = 5000;
    private AppBarLayout Xx;
    private ValueAnimator esJ;
    private BdTypeRecyclerView hVD;
    private FrsHeaderViewContainer hVY;
    private PullRefreshFrameLayout iuH;
    private ValueAnimator iuI;
    private au iuL;
    private o iuM;
    private View iuN;
    private int iuQ;
    private int iuR;
    private boolean iuJ = false;
    private boolean iuK = false;
    private RelativeLayout.LayoutParams iuO = null;
    private int iuP = 0;
    private PullRefreshFrameLayout.d iuS = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void t(double d) {
            if (k.this.iuN != null && k.this.iuO != null) {
                k.this.iuO.height = (int) (k.this.iuP + (PullRefreshFrameLayout.esq * d));
                k.this.iuN.setLayoutParams(k.this.iuO);
                if (k.this.iuM != null) {
                    k.this.iuM.x(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.iuN != null && k.this.iuO != null && k.this.iuM != null) {
                k.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.esJ.setDuration(150L);
                final int i2 = k.this.iuO.height;
                final int height = k.this.iuM.getHeight();
                k.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.iuO.height = (int) (i2 - (i * animatedFraction));
                        k.this.iuN.setLayoutParams(k.this.iuO);
                        if (k.this.iuM != null) {
                            k.this.iuM.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.esJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.iuQ = k.this.iuO.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.esJ.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void bkE() {
            if (k.this.iuO != null) {
                final int i = k.this.iuO.height;
                final int i2 = k.this.iuO.height - k.this.iuP;
                final int i3 = 0;
                if (k.this.iuM != null) {
                    i3 = k.this.iuM.cmK();
                }
                if (i2 > 0) {
                    k.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.esJ.setDuration(300L);
                    k.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.iuO.height = (int) (i - (i2 * floatValue));
                            k.this.iuN.setLayoutParams(k.this.iuO);
                            if (k.this.iuM != null && i3 > 0) {
                                k.this.iuM.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.esJ.start();
                    k.this.esJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.iuQ = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.iuL != null) {
                        k.this.iuL.bkE();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c iuT = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bkD() {
            k.this.ctJ();
        }
    };
    private Runnable iuU = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.iuK) {
                k.this.ctK();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.iuH = null;
        View rootView = frsFragment.getRootView();
        this.iuH = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.iuH.setFromFrs();
        this.iuH.setOnTouchCallback(this.iuS);
        this.iuH.setOnPullRefreshListener(this.iuT);
        this.iuH.bkB();
        this.hVY = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Xx = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hVD = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cnG();
    }

    public void setInterceptScrollDown(boolean z) {
        this.iuH.setInterceptScrollDown(z);
    }

    public int ctH() {
        return this.iuQ;
    }

    public int ctI() {
        return this.iuP;
    }

    public void dismissLoading() {
        if (this.iuH != null) {
            this.iuH.dismissLoading();
        }
    }

    public void O(int i, boolean z) {
        if (i == this.iuR) {
            this.iuJ = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hVD.getAdapter().notifyDataSetChanged();
            bGe();
        }
    }

    public boolean cmy() {
        return this.iuJ;
    }

    public void onDestroy() {
        if (this.iuK) {
            ctK();
        }
        if (this.esJ != null) {
            this.esJ.cancel();
            this.esJ.removeAllListeners();
            this.esJ.removeAllUpdateListeners();
            this.esJ = null;
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuU);
    }

    public void startPullRefresh() {
        if (this.iuH != null || this.iuH.isEnable()) {
            if (this.hVD != null) {
                this.hVD.setSelection(0);
            }
            if (this.Xx != null) {
                this.Xx.setExpanded(true);
            }
            if (!this.iuK) {
                this.iuI = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.iuI.setDuration(300L);
                this.iuI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.iuO != null) {
                            k.this.iuO.height = (int) (k.this.iuP + (PullRefreshFrameLayout.esp * floatValue));
                            k.this.iuN.setLayoutParams(k.this.iuO);
                        }
                        if (k.this.iuM != null) {
                            k.this.iuM.setHeight((int) ((floatValue * PullRefreshFrameLayout.esp) + k.this.iuM.getOriginHeight()));
                        }
                    }
                });
                this.iuI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.iuK && k.this.iuH != null && !k.this.iuH.isLoading()) {
                            k.this.ctK();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iuI.start();
                this.iuH.setRefreshing(true);
                ctJ();
            }
        }
    }

    public void cnF() {
        final View headBgContainer;
        if (this.hVY != null && (headBgContainer = this.hVY.getHeadBgContainer()) != null) {
            if (this.iuM == null) {
                this.iuM = new o(headBgContainer);
            }
            if (this.iuM.cmK() > 0) {
                this.iuM.setHeight(this.iuM.cmK());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.iuM.getOriginHeight() < 0) {
                        k.this.iuM.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.iuM.cmK() < 0) {
                        k.this.iuM.wX(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cnG() {
        if (this.hVY != null) {
            this.iuN = this.hVY.getHeaderEmptyView();
            if (this.iuN != null) {
                this.iuP = 0;
                this.iuO = (RelativeLayout.LayoutParams) this.iuN.getLayoutParams();
                if (this.iuN.getHeight() > 0) {
                    this.iuO.height = this.iuP;
                    this.iuN.setLayoutParams(this.iuO);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctJ() {
        com.baidu.adp.lib.f.e.mS().postDelayed(this.iuU, iuG);
        this.iuK = true;
        if (this.iuL != null) {
            this.iuL.bkD();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void ctK() {
        this.iuK = false;
        if (this.iuH != null) {
            this.iuH.bkA();
        }
    }

    public void bGe() {
        if (this.iuK) {
            ctK();
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuU);
        }
    }

    public void or(boolean z) {
        if (this.iuH != null) {
            this.iuH.setEnable(z);
        }
    }

    public void a(au auVar) {
        this.iuL = auVar;
    }

    public void xk(int i) {
        this.iuR = i;
    }
}
