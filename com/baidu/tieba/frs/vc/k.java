package com.baidu.tieba.frs.vc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes2.dex */
public class k {
    private static int jLl = 5000;
    private AppBarLayout ZM;
    private ValueAnimator fjh;
    private PullRefreshFrameLayout jLm;
    private ValueAnimator jLn;
    private aq jLq;
    private o jLr;
    private View jLs;
    private int jLv;
    private int jLw;
    private FrsHeaderViewContainer jjA;
    private BdTypeRecyclerView jjf;
    private boolean jLo = false;
    private boolean jLp = false;
    private RelativeLayout.LayoutParams jLt = null;
    private int jLu = 0;
    private PullRefreshFrameLayout.d jLx = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void q(double d) {
            if (k.this.jLs != null && k.this.jLt != null) {
                k.this.jLt.height = (int) (k.this.jLu + (PullRefreshFrameLayout.fiM * d));
                k.this.jLs.setLayoutParams(k.this.jLt);
                if (k.this.jLr != null) {
                    k.this.jLr.v(d);
                }
                k.this.jLm.buk();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void b(final int i, double d) {
            if (k.this.jLs != null && k.this.jLt != null && k.this.jLr != null) {
                k.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.fjh.setDuration(150L);
                final int i2 = k.this.jLt.height;
                final int height = k.this.jLr.getHeight();
                k.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jLt.height = (int) (i2 - (i * animatedFraction));
                        k.this.jLs.setLayoutParams(k.this.jLt);
                        if (k.this.jLr != null) {
                            k.this.jLr.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jLv = k.this.jLt.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.fjh.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void bun() {
            if (k.this.jLt != null) {
                final int i = k.this.jLt.height;
                final int i2 = k.this.jLt.height - k.this.jLu;
                final int i3 = 0;
                if (k.this.jLr != null) {
                    i3 = k.this.jLr.cDt();
                }
                if (i2 > 0) {
                    k.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.fjh.setDuration(300L);
                    k.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jLt.height = (int) (i - (i2 * floatValue));
                            k.this.jLs.setLayoutParams(k.this.jLt);
                            if (k.this.jLr != null && i3 > 0) {
                                k.this.jLr.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.fjh.start();
                    k.this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jLv = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jLq != null) {
                        k.this.jLq.bun();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jLy = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bum() {
            k.this.cLH();
        }
    };
    private Runnable jLz = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jLp) {
                k.this.cLI();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jLm = null;
        View rootView = frsFragment.getRootView();
        this.jLm = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jLm.setFromFrs();
        this.jLm.setOnTouchCallback(this.jLx);
        this.jLm.setOnPullRefreshListener(this.jLy);
        this.jLm.buj();
        this.jjA = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.ZM = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.jjf = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cEo();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jLm.setInterceptScrollDown(z);
    }

    public int cLF() {
        return this.jLv;
    }

    public int cLG() {
        return this.jLu;
    }

    public void dismissLoading() {
        if (this.jLm != null) {
            this.jLm.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jLw) {
            this.jLo = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.jjf.getAdapter().notifyDataSetChanged();
            bRI();
        }
    }

    public boolean cDh() {
        return this.jLo;
    }

    public void onDestroy() {
        if (this.jLp) {
            cLI();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLz);
    }

    public void startPullRefresh() {
        if (this.jLm != null || this.jLm.isEnable()) {
            if (this.jjf != null) {
                this.jjf.setSelection(0);
            }
            if (this.ZM != null) {
                this.ZM.setExpanded(true);
            }
            if (!this.jLp) {
                this.jLn = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jLn.setDuration(300L);
                this.jLn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jLt != null) {
                            k.this.jLt.height = (int) (k.this.jLu + (PullRefreshFrameLayout.fiL * floatValue));
                            k.this.jLs.setLayoutParams(k.this.jLt);
                        }
                        if (k.this.jLr != null) {
                            k.this.jLr.setHeight((int) ((floatValue * PullRefreshFrameLayout.fiL) + k.this.jLr.getOriginHeight()));
                        }
                    }
                });
                this.jLn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jLp && k.this.jLm != null && !k.this.jLm.isLoading()) {
                            k.this.cLI();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jLn.start();
                this.jLm.setRefreshing(true);
                cLH();
            }
        }
    }

    public void cEn() {
        final View headBgContainer;
        if (this.jjA != null && (headBgContainer = this.jjA.getHeadBgContainer()) != null) {
            if (this.jLr == null) {
                this.jLr = new o(headBgContainer);
            }
            if (this.jLr.cDt() > 0) {
                this.jLr.setHeight(this.jLr.cDt());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jLr.getOriginHeight() < 0) {
                        k.this.jLr.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jLr.cDt() < 0) {
                        k.this.jLr.yC(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cEo() {
        if (this.jjA != null) {
            this.jLs = this.jjA.getHeaderEmptyView();
            if (this.jLs != null) {
                this.jLu = 0;
                this.jLt = (RelativeLayout.LayoutParams) this.jLs.getLayoutParams();
                if (this.jLs.getHeight() > 0) {
                    this.jLt.height = this.jLu;
                    this.jLs.setLayoutParams(this.jLt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLH() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jLz, jLl);
        this.jLp = true;
        if (this.jLq != null) {
            this.jLq.bum();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cLI() {
        this.jLp = false;
        if (this.jLm != null) {
            this.jLm.bui();
        }
    }

    public void bRI() {
        if (this.jLp) {
            cLI();
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLz);
        }
    }

    public void qH(boolean z) {
        if (this.jLm != null) {
            this.jLm.setEnable(z);
        }
    }

    public void a(aq aqVar) {
        this.jLq = aqVar;
    }

    public aq cLJ() {
        return this.jLq;
    }

    public void yO(int i) {
        this.jLw = i;
    }

    public PullRefreshFrameLayout cLK() {
        return this.jLm;
    }
}
