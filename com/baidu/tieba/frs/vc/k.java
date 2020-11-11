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
    private static int jjm = 5000;
    private AppBarLayout Yh;
    private ValueAnimator eVj;
    private BdTypeRecyclerView iJX;
    private FrsHeaderViewContainer iKs;
    private PullRefreshFrameLayout jjn;
    private ValueAnimator jjo;
    private au jjr;
    private o jjs;
    private View jjt;
    private int jjw;
    private int jjx;
    private boolean jjp = false;
    private boolean jjq = false;
    private RelativeLayout.LayoutParams jju = null;
    private int jjv = 0;
    private PullRefreshFrameLayout.d jjy = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void x(double d) {
            if (k.this.jjt != null && k.this.jju != null) {
                k.this.jju.height = (int) (k.this.jjv + (PullRefreshFrameLayout.eUQ * d));
                k.this.jjt.setLayoutParams(k.this.jju);
                if (k.this.jjs != null) {
                    k.this.jjs.B(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.jjt != null && k.this.jju != null && k.this.jjs != null) {
                k.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.eVj.setDuration(150L);
                final int i2 = k.this.jju.height;
                final int height = k.this.jjs.getHeight();
                k.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jju.height = (int) (i2 - (i * animatedFraction));
                        k.this.jjt.setLayoutParams(k.this.jju);
                        if (k.this.jjs != null) {
                            k.this.jjs.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.eVj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jjw = k.this.jju.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.eVj.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void bsC() {
            if (k.this.jju != null) {
                final int i = k.this.jju.height;
                final int i2 = k.this.jju.height - k.this.jjv;
                final int i3 = 0;
                if (k.this.jjs != null) {
                    i3 = k.this.jjs.czc();
                }
                if (i2 > 0) {
                    k.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.eVj.setDuration(300L);
                    k.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jju.height = (int) (i - (i2 * floatValue));
                            k.this.jjt.setLayoutParams(k.this.jju);
                            if (k.this.jjs != null && i3 > 0) {
                                k.this.jjs.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.eVj.start();
                    k.this.eVj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jjw = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jjr != null) {
                        k.this.jjr.bsC();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jjz = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bsB() {
            k.this.cGg();
        }
    };
    private Runnable jjA = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jjq) {
                k.this.cGh();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jjn = null;
        View rootView = frsFragment.getRootView();
        this.jjn = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jjn.setFromFrs();
        this.jjn.setOnTouchCallback(this.jjy);
        this.jjn.setOnPullRefreshListener(this.jjz);
        this.jjn.bsz();
        this.iKs = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Yh = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.iJX = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        czY();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jjn.setInterceptScrollDown(z);
    }

    public int cGe() {
        return this.jjw;
    }

    public int cGf() {
        return this.jjv;
    }

    public void dismissLoading() {
        if (this.jjn != null) {
            this.jjn.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jjx) {
            this.jjp = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.iJX.getAdapter().notifyDataSetChanged();
            bPh();
        }
    }

    public boolean cyQ() {
        return this.jjp;
    }

    public void onDestroy() {
        if (this.jjq) {
            cGh();
        }
        if (this.eVj != null) {
            this.eVj.cancel();
            this.eVj.removeAllListeners();
            this.eVj.removeAllUpdateListeners();
            this.eVj = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjA);
    }

    public void startPullRefresh() {
        if (this.jjn != null || this.jjn.isEnable()) {
            if (this.iJX != null) {
                this.iJX.setSelection(0);
            }
            if (this.Yh != null) {
                this.Yh.setExpanded(true);
            }
            if (!this.jjq) {
                this.jjo = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jjo.setDuration(300L);
                this.jjo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jju != null) {
                            k.this.jju.height = (int) (k.this.jjv + (PullRefreshFrameLayout.eUP * floatValue));
                            k.this.jjt.setLayoutParams(k.this.jju);
                        }
                        if (k.this.jjs != null) {
                            k.this.jjs.setHeight((int) ((floatValue * PullRefreshFrameLayout.eUP) + k.this.jjs.getOriginHeight()));
                        }
                    }
                });
                this.jjo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jjq && k.this.jjn != null && !k.this.jjn.isLoading()) {
                            k.this.cGh();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jjo.start();
                this.jjn.setRefreshing(true);
                cGg();
            }
        }
    }

    public void czX() {
        final View headBgContainer;
        if (this.iKs != null && (headBgContainer = this.iKs.getHeadBgContainer()) != null) {
            if (this.jjs == null) {
                this.jjs = new o(headBgContainer);
            }
            if (this.jjs.czc() > 0) {
                this.jjs.setHeight(this.jjs.czc());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jjs.getOriginHeight() < 0) {
                        k.this.jjs.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jjs.czc() < 0) {
                        k.this.jjs.yI(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void czY() {
        if (this.iKs != null) {
            this.jjt = this.iKs.getHeaderEmptyView();
            if (this.jjt != null) {
                this.jjv = 0;
                this.jju = (RelativeLayout.LayoutParams) this.jjt.getLayoutParams();
                if (this.jjt.getHeight() > 0) {
                    this.jju.height = this.jjv;
                    this.jjt.setLayoutParams(this.jju);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGg() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jjA, jjm);
        this.jjq = true;
        if (this.jjr != null) {
            this.jjr.bsB();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cGh() {
        this.jjq = false;
        if (this.jjn != null) {
            this.jjn.bsy();
        }
    }

    public void bPh() {
        if (this.jjq) {
            cGh();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjA);
        }
    }

    public void pD(boolean z) {
        if (this.jjn != null) {
            this.jjn.setEnable(z);
        }
    }

    public void a(au auVar) {
        this.jjr = auVar;
    }

    public void yV(int i) {
        this.jjx = i;
    }

    public PullRefreshFrameLayout cGi() {
        return this.jjn;
    }
}
