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
    private static int jFt = 5000;
    private AppBarLayout ZQ;
    private ValueAnimator fgO;
    private View jFA;
    private int jFD;
    private int jFE;
    private PullRefreshFrameLayout jFu;
    private ValueAnimator jFv;
    private aq jFy;
    private o jFz;
    private FrsHeaderViewContainer jdF;
    private BdTypeRecyclerView jdk;
    private boolean jFw = false;
    private boolean jFx = false;
    private RelativeLayout.LayoutParams jFB = null;
    private int jFC = 0;
    private PullRefreshFrameLayout.d jFF = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void q(double d) {
            if (k.this.jFA != null && k.this.jFB != null) {
                k.this.jFB.height = (int) (k.this.jFC + (PullRefreshFrameLayout.fgt * d));
                k.this.jFA.setLayoutParams(k.this.jFB);
                if (k.this.jFz != null) {
                    k.this.jFz.v(d);
                }
                k.this.jFu.btQ();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void b(final int i, double d) {
            if (k.this.jFA != null && k.this.jFB != null && k.this.jFz != null) {
                k.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.fgO.setDuration(150L);
                final int i2 = k.this.jFB.height;
                final int height = k.this.jFz.getHeight();
                k.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jFB.height = (int) (i2 - (i * animatedFraction));
                        k.this.jFA.setLayoutParams(k.this.jFB);
                        if (k.this.jFz != null) {
                            k.this.jFz.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.fgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jFD = k.this.jFB.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.fgO.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void btT() {
            if (k.this.jFB != null) {
                final int i = k.this.jFB.height;
                final int i2 = k.this.jFB.height - k.this.jFC;
                final int i3 = 0;
                if (k.this.jFz != null) {
                    i3 = k.this.jFz.cCa();
                }
                if (i2 > 0) {
                    k.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.fgO.setDuration(300L);
                    k.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jFB.height = (int) (i - (i2 * floatValue));
                            k.this.jFA.setLayoutParams(k.this.jFB);
                            if (k.this.jFz != null && i3 > 0) {
                                k.this.jFz.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.fgO.start();
                    k.this.fgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jFD = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jFy != null) {
                        k.this.jFy.btT();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jFG = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void btS() {
            k.this.cKm();
        }
    };
    private Runnable jFH = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jFx) {
                k.this.cKn();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jFu = null;
        View rootView = frsFragment.getRootView();
        this.jFu = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jFu.setFromFrs();
        this.jFu.setOnTouchCallback(this.jFF);
        this.jFu.setOnPullRefreshListener(this.jFG);
        this.jFu.btP();
        this.jdF = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.ZQ = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.jdk = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cCV();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jFu.setInterceptScrollDown(z);
    }

    public int cKk() {
        return this.jFD;
    }

    public int cKl() {
        return this.jFC;
    }

    public void dismissLoading() {
        if (this.jFu != null) {
            this.jFu.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jFE) {
            this.jFw = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.jdk.getAdapter().notifyDataSetChanged();
            bQX();
        }
    }

    public boolean cBO() {
        return this.jFw;
    }

    public void onDestroy() {
        if (this.jFx) {
            cKn();
        }
        if (this.fgO != null) {
            this.fgO.cancel();
            this.fgO.removeAllListeners();
            this.fgO.removeAllUpdateListeners();
            this.fgO = null;
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jFH);
    }

    public void startPullRefresh() {
        if (this.jFu != null || this.jFu.isEnable()) {
            if (this.jdk != null) {
                this.jdk.setSelection(0);
            }
            if (this.ZQ != null) {
                this.ZQ.setExpanded(true);
            }
            if (!this.jFx) {
                this.jFv = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jFv.setDuration(300L);
                this.jFv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jFB != null) {
                            k.this.jFB.height = (int) (k.this.jFC + (PullRefreshFrameLayout.fgs * floatValue));
                            k.this.jFA.setLayoutParams(k.this.jFB);
                        }
                        if (k.this.jFz != null) {
                            k.this.jFz.setHeight((int) ((floatValue * PullRefreshFrameLayout.fgs) + k.this.jFz.getOriginHeight()));
                        }
                    }
                });
                this.jFv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jFx && k.this.jFu != null && !k.this.jFu.isLoading()) {
                            k.this.cKn();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jFv.start();
                this.jFu.setRefreshing(true);
                cKm();
            }
        }
    }

    public void cCU() {
        final View headBgContainer;
        if (this.jdF != null && (headBgContainer = this.jdF.getHeadBgContainer()) != null) {
            if (this.jFz == null) {
                this.jFz = new o(headBgContainer);
            }
            if (this.jFz.cCa() > 0) {
                this.jFz.setHeight(this.jFz.cCa());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jFz.getOriginHeight() < 0) {
                        k.this.jFz.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jFz.cCa() < 0) {
                        k.this.jFz.ys(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cCV() {
        if (this.jdF != null) {
            this.jFA = this.jdF.getHeaderEmptyView();
            if (this.jFA != null) {
                this.jFC = 0;
                this.jFB = (RelativeLayout.LayoutParams) this.jFA.getLayoutParams();
                if (this.jFA.getHeight() > 0) {
                    this.jFB.height = this.jFC;
                    this.jFA.setLayoutParams(this.jFB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKm() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jFH, jFt);
        this.jFx = true;
        if (this.jFy != null) {
            this.jFy.btS();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cKn() {
        this.jFx = false;
        if (this.jFu != null) {
            this.jFu.btO();
        }
    }

    public void bQX() {
        if (this.jFx) {
            cKn();
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jFH);
        }
    }

    public void qx(boolean z) {
        if (this.jFu != null) {
            this.jFu.setEnable(z);
        }
    }

    public void a(aq aqVar) {
        this.jFy = aqVar;
    }

    public aq cKo() {
        return this.jFy;
    }

    public void yE(int i) {
        this.jFE = i;
    }

    public PullRefreshFrameLayout cKp() {
        return this.jFu;
    }
}
