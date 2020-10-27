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
    private static int jdo = 5000;
    private AppBarLayout Yh;
    private ValueAnimator ePu;
    private BdTypeRecyclerView iEa;
    private FrsHeaderViewContainer iEv;
    private PullRefreshFrameLayout jdp;
    private ValueAnimator jdq;
    private au jdt;
    private o jdu;
    private View jdv;
    private int jdy;
    private int jdz;
    private boolean jdr = false;
    private boolean jds = false;
    private RelativeLayout.LayoutParams jdw = null;
    private int jdx = 0;
    private PullRefreshFrameLayout.d jdA = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void x(double d) {
            if (k.this.jdv != null && k.this.jdw != null) {
                k.this.jdw.height = (int) (k.this.jdx + (PullRefreshFrameLayout.ePb * d));
                k.this.jdv.setLayoutParams(k.this.jdw);
                if (k.this.jdu != null) {
                    k.this.jdu.B(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.jdv != null && k.this.jdw != null && k.this.jdu != null) {
                k.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.ePu.setDuration(150L);
                final int i2 = k.this.jdw.height;
                final int height = k.this.jdu.getHeight();
                k.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jdw.height = (int) (i2 - (i * animatedFraction));
                        k.this.jdv.setLayoutParams(k.this.jdw);
                        if (k.this.jdu != null) {
                            k.this.jdu.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.ePu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jdy = k.this.jdw.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.ePu.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void bqc() {
            if (k.this.jdw != null) {
                final int i = k.this.jdw.height;
                final int i2 = k.this.jdw.height - k.this.jdx;
                final int i3 = 0;
                if (k.this.jdu != null) {
                    i3 = k.this.jdu.cwB();
                }
                if (i2 > 0) {
                    k.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.ePu.setDuration(300L);
                    k.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jdw.height = (int) (i - (i2 * floatValue));
                            k.this.jdv.setLayoutParams(k.this.jdw);
                            if (k.this.jdu != null && i3 > 0) {
                                k.this.jdu.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.ePu.start();
                    k.this.ePu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jdy = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jdt != null) {
                        k.this.jdt.bqc();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jdB = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bqb() {
            k.this.cDF();
        }
    };
    private Runnable jdC = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jds) {
                k.this.cDG();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jdp = null;
        View rootView = frsFragment.getRootView();
        this.jdp = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jdp.setFromFrs();
        this.jdp.setOnTouchCallback(this.jdA);
        this.jdp.setOnPullRefreshListener(this.jdB);
        this.jdp.bpZ();
        this.iEv = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Yh = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.iEa = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cxx();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jdp.setInterceptScrollDown(z);
    }

    public int cDD() {
        return this.jdy;
    }

    public int cDE() {
        return this.jdx;
    }

    public void dismissLoading() {
        if (this.jdp != null) {
            this.jdp.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jdz) {
            this.jdr = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.iEa.getAdapter().notifyDataSetChanged();
            bMH();
        }
    }

    public boolean cwp() {
        return this.jdr;
    }

    public void onDestroy() {
        if (this.jds) {
            cDG();
        }
        if (this.ePu != null) {
            this.ePu.cancel();
            this.ePu.removeAllListeners();
            this.ePu.removeAllUpdateListeners();
            this.ePu = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jdC);
    }

    public void startPullRefresh() {
        if (this.jdp != null || this.jdp.isEnable()) {
            if (this.iEa != null) {
                this.iEa.setSelection(0);
            }
            if (this.Yh != null) {
                this.Yh.setExpanded(true);
            }
            if (!this.jds) {
                this.jdq = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jdq.setDuration(300L);
                this.jdq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jdw != null) {
                            k.this.jdw.height = (int) (k.this.jdx + (PullRefreshFrameLayout.ePa * floatValue));
                            k.this.jdv.setLayoutParams(k.this.jdw);
                        }
                        if (k.this.jdu != null) {
                            k.this.jdu.setHeight((int) ((floatValue * PullRefreshFrameLayout.ePa) + k.this.jdu.getOriginHeight()));
                        }
                    }
                });
                this.jdq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jds && k.this.jdp != null && !k.this.jdp.isLoading()) {
                            k.this.cDG();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jdq.start();
                this.jdp.setRefreshing(true);
                cDF();
            }
        }
    }

    public void cxw() {
        final View headBgContainer;
        if (this.iEv != null && (headBgContainer = this.iEv.getHeadBgContainer()) != null) {
            if (this.jdu == null) {
                this.jdu = new o(headBgContainer);
            }
            if (this.jdu.cwB() > 0) {
                this.jdu.setHeight(this.jdu.cwB());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jdu.getOriginHeight() < 0) {
                        k.this.jdu.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jdu.cwB() < 0) {
                        k.this.jdu.yv(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cxx() {
        if (this.iEv != null) {
            this.jdv = this.iEv.getHeaderEmptyView();
            if (this.jdv != null) {
                this.jdx = 0;
                this.jdw = (RelativeLayout.LayoutParams) this.jdv.getLayoutParams();
                if (this.jdv.getHeight() > 0) {
                    this.jdw.height = this.jdx;
                    this.jdv.setLayoutParams(this.jdw);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDF() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jdC, jdo);
        this.jds = true;
        if (this.jdt != null) {
            this.jdt.bqb();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cDG() {
        this.jds = false;
        if (this.jdp != null) {
            this.jdp.bpY();
        }
    }

    public void bMH() {
        if (this.jds) {
            cDG();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jdC);
        }
    }

    public void pu(boolean z) {
        if (this.jdp != null) {
            this.jdp.setEnable(z);
        }
    }

    public void a(au auVar) {
        this.jdt = auVar;
    }

    public void yI(int i) {
        this.jdz = i;
    }

    public PullRefreshFrameLayout cDH() {
        return this.jdp;
    }
}
