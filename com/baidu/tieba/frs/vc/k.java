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
    private static int jKX = 5000;
    private AppBarLayout ZM;
    private ValueAnimator fjh;
    private PullRefreshFrameLayout jKY;
    private ValueAnimator jKZ;
    private aq jLc;
    private o jLd;
    private View jLe;
    private int jLh;
    private int jLi;
    private BdTypeRecyclerView jiR;
    private FrsHeaderViewContainer jjm;
    private boolean jLa = false;
    private boolean jLb = false;
    private RelativeLayout.LayoutParams jLf = null;
    private int jLg = 0;
    private PullRefreshFrameLayout.d jLj = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void q(double d) {
            if (k.this.jLe != null && k.this.jLf != null) {
                k.this.jLf.height = (int) (k.this.jLg + (PullRefreshFrameLayout.fiM * d));
                k.this.jLe.setLayoutParams(k.this.jLf);
                if (k.this.jLd != null) {
                    k.this.jLd.v(d);
                }
                k.this.jKY.buk();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void b(final int i, double d) {
            if (k.this.jLe != null && k.this.jLf != null && k.this.jLd != null) {
                k.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.fjh.setDuration(150L);
                final int i2 = k.this.jLf.height;
                final int height = k.this.jLd.getHeight();
                k.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jLf.height = (int) (i2 - (i * animatedFraction));
                        k.this.jLe.setLayoutParams(k.this.jLf);
                        if (k.this.jLd != null) {
                            k.this.jLd.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jLh = k.this.jLf.height;
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
            if (k.this.jLf != null) {
                final int i = k.this.jLf.height;
                final int i2 = k.this.jLf.height - k.this.jLg;
                final int i3 = 0;
                if (k.this.jLd != null) {
                    i3 = k.this.jLd.cDm();
                }
                if (i2 > 0) {
                    k.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.fjh.setDuration(300L);
                    k.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jLf.height = (int) (i - (i2 * floatValue));
                            k.this.jLe.setLayoutParams(k.this.jLf);
                            if (k.this.jLd != null && i3 > 0) {
                                k.this.jLd.setHeight((int) (i3 - (floatValue * i2)));
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
                            k.this.jLh = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jLc != null) {
                        k.this.jLc.bun();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jLk = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bum() {
            k.this.cLA();
        }
    };
    private Runnable jLl = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jLb) {
                k.this.cLB();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jKY = null;
        View rootView = frsFragment.getRootView();
        this.jKY = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jKY.setFromFrs();
        this.jKY.setOnTouchCallback(this.jLj);
        this.jKY.setOnPullRefreshListener(this.jLk);
        this.jKY.buj();
        this.jjm = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.ZM = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.jiR = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cEh();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jKY.setInterceptScrollDown(z);
    }

    public int cLy() {
        return this.jLh;
    }

    public int cLz() {
        return this.jLg;
    }

    public void dismissLoading() {
        if (this.jKY != null) {
            this.jKY.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jLi) {
            this.jLa = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.jiR.getAdapter().notifyDataSetChanged();
            bRB();
        }
    }

    public boolean cDa() {
        return this.jLa;
    }

    public void onDestroy() {
        if (this.jLb) {
            cLB();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLl);
    }

    public void startPullRefresh() {
        if (this.jKY != null || this.jKY.isEnable()) {
            if (this.jiR != null) {
                this.jiR.setSelection(0);
            }
            if (this.ZM != null) {
                this.ZM.setExpanded(true);
            }
            if (!this.jLb) {
                this.jKZ = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jKZ.setDuration(300L);
                this.jKZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jLf != null) {
                            k.this.jLf.height = (int) (k.this.jLg + (PullRefreshFrameLayout.fiL * floatValue));
                            k.this.jLe.setLayoutParams(k.this.jLf);
                        }
                        if (k.this.jLd != null) {
                            k.this.jLd.setHeight((int) ((floatValue * PullRefreshFrameLayout.fiL) + k.this.jLd.getOriginHeight()));
                        }
                    }
                });
                this.jKZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jLb && k.this.jKY != null && !k.this.jKY.isLoading()) {
                            k.this.cLB();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jKZ.start();
                this.jKY.setRefreshing(true);
                cLA();
            }
        }
    }

    public void cEg() {
        final View headBgContainer;
        if (this.jjm != null && (headBgContainer = this.jjm.getHeadBgContainer()) != null) {
            if (this.jLd == null) {
                this.jLd = new o(headBgContainer);
            }
            if (this.jLd.cDm() > 0) {
                this.jLd.setHeight(this.jLd.cDm());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jLd.getOriginHeight() < 0) {
                        k.this.jLd.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jLd.cDm() < 0) {
                        k.this.jLd.yC(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cEh() {
        if (this.jjm != null) {
            this.jLe = this.jjm.getHeaderEmptyView();
            if (this.jLe != null) {
                this.jLg = 0;
                this.jLf = (RelativeLayout.LayoutParams) this.jLe.getLayoutParams();
                if (this.jLe.getHeight() > 0) {
                    this.jLf.height = this.jLg;
                    this.jLe.setLayoutParams(this.jLf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLA() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jLl, jKX);
        this.jLb = true;
        if (this.jLc != null) {
            this.jLc.bum();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cLB() {
        this.jLb = false;
        if (this.jKY != null) {
            this.jKY.bui();
        }
    }

    public void bRB() {
        if (this.jLb) {
            cLB();
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLl);
        }
    }

    public void qH(boolean z) {
        if (this.jKY != null) {
            this.jKY.setEnable(z);
        }
    }

    public void a(aq aqVar) {
        this.jLc = aqVar;
    }

    public aq cLC() {
        return this.jLc;
    }

    public void yO(int i) {
        this.jLi = i;
    }

    public PullRefreshFrameLayout cLD() {
        return this.jKY;
    }
}
