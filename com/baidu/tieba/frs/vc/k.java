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
/* loaded from: classes22.dex */
public class k {
    private static int iQS = 5000;
    private AppBarLayout Yg;
    private ValueAnimator eGY;
    private PullRefreshFrameLayout iQT;
    private ValueAnimator iQU;
    private au iQX;
    private o iQY;
    private View iQZ;
    private int iRc;
    private int iRd;
    private BdTypeRecyclerView irE;
    private FrsHeaderViewContainer irZ;
    private boolean iQV = false;
    private boolean iQW = false;
    private RelativeLayout.LayoutParams iRa = null;
    private int iRb = 0;
    private PullRefreshFrameLayout.d iRe = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void w(double d) {
            if (k.this.iQZ != null && k.this.iRa != null) {
                k.this.iRa.height = (int) (k.this.iRb + (PullRefreshFrameLayout.eGF * d));
                k.this.iQZ.setLayoutParams(k.this.iRa);
                if (k.this.iQY != null) {
                    k.this.iQY.A(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.iQZ != null && k.this.iRa != null && k.this.iQY != null) {
                k.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.eGY.setDuration(150L);
                final int i2 = k.this.iRa.height;
                final int height = k.this.iQY.getHeight();
                k.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.iRa.height = (int) (i2 - (i * animatedFraction));
                        k.this.iQZ.setLayoutParams(k.this.iRa);
                        if (k.this.iQY != null) {
                            k.this.iQY.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.eGY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.iRc = k.this.iRa.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.eGY.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void boj() {
            if (k.this.iRa != null) {
                final int i = k.this.iRa.height;
                final int i2 = k.this.iRa.height - k.this.iRb;
                final int i3 = 0;
                if (k.this.iQY != null) {
                    i3 = k.this.iQY.ctu();
                }
                if (i2 > 0) {
                    k.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.eGY.setDuration(300L);
                    k.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.iRa.height = (int) (i - (i2 * floatValue));
                            k.this.iQZ.setLayoutParams(k.this.iRa);
                            if (k.this.iQY != null && i3 > 0) {
                                k.this.iQY.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.eGY.start();
                    k.this.eGY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.iRc = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.iQX != null) {
                        k.this.iQX.boj();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c iRf = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void boi() {
            k.this.cAy();
        }
    };
    private Runnable iRg = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.iQW) {
                k.this.cAz();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.iQT = null;
        View rootView = frsFragment.getRootView();
        this.iQT = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.iQT.setFromFrs();
        this.iQT.setOnTouchCallback(this.iRe);
        this.iQT.setOnPullRefreshListener(this.iRf);
        this.iQT.bog();
        this.irZ = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Yg = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.irE = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cuq();
    }

    public void setInterceptScrollDown(boolean z) {
        this.iQT.setInterceptScrollDown(z);
    }

    public int cAw() {
        return this.iRc;
    }

    public int cAx() {
        return this.iRb;
    }

    public void dismissLoading() {
        if (this.iQT != null) {
            this.iQT.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.iRd) {
            this.iQV = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.irE.getAdapter().notifyDataSetChanged();
            bKf();
        }
    }

    public boolean cti() {
        return this.iQV;
    }

    public void onDestroy() {
        if (this.iQW) {
            cAz();
        }
        if (this.eGY != null) {
            this.eGY.cancel();
            this.eGY.removeAllListeners();
            this.eGY.removeAllUpdateListeners();
            this.eGY = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRg);
    }

    public void startPullRefresh() {
        if (this.iQT != null || this.iQT.isEnable()) {
            if (this.irE != null) {
                this.irE.setSelection(0);
            }
            if (this.Yg != null) {
                this.Yg.setExpanded(true);
            }
            if (!this.iQW) {
                this.iQU = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.iQU.setDuration(300L);
                this.iQU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.iRa != null) {
                            k.this.iRa.height = (int) (k.this.iRb + (PullRefreshFrameLayout.eGE * floatValue));
                            k.this.iQZ.setLayoutParams(k.this.iRa);
                        }
                        if (k.this.iQY != null) {
                            k.this.iQY.setHeight((int) ((floatValue * PullRefreshFrameLayout.eGE) + k.this.iQY.getOriginHeight()));
                        }
                    }
                });
                this.iQU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.iQW && k.this.iQT != null && !k.this.iQT.isLoading()) {
                            k.this.cAz();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iQU.start();
                this.iQT.setRefreshing(true);
                cAy();
            }
        }
    }

    public void cup() {
        final View headBgContainer;
        if (this.irZ != null && (headBgContainer = this.irZ.getHeadBgContainer()) != null) {
            if (this.iQY == null) {
                this.iQY = new o(headBgContainer);
            }
            if (this.iQY.ctu() > 0) {
                this.iQY.setHeight(this.iQY.ctu());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.iQY.getOriginHeight() < 0) {
                        k.this.iQY.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.iQY.ctu() < 0) {
                        k.this.iQY.yc(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cuq() {
        if (this.irZ != null) {
            this.iQZ = this.irZ.getHeaderEmptyView();
            if (this.iQZ != null) {
                this.iRb = 0;
                this.iRa = (RelativeLayout.LayoutParams) this.iQZ.getLayoutParams();
                if (this.iQZ.getHeight() > 0) {
                    this.iRa.height = this.iRb;
                    this.iQZ.setLayoutParams(this.iRa);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAy() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.iRg, iQS);
        this.iQW = true;
        if (this.iQX != null) {
            this.iQX.boi();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cAz() {
        this.iQW = false;
        if (this.iQT != null) {
            this.iQT.bof();
        }
    }

    public void bKf() {
        if (this.iQW) {
            cAz();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRg);
        }
    }

    public void pc(boolean z) {
        if (this.iQT != null) {
            this.iQT.setEnable(z);
        }
    }

    public void a(au auVar) {
        this.iQX = auVar;
    }

    public void yp(int i) {
        this.iRd = i;
    }

    public PullRefreshFrameLayout cAA() {
        return this.iQT;
    }
}
