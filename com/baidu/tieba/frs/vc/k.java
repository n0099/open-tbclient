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
    private static int jJZ = 5000;
    private AppBarLayout ZS;
    private ValueAnimator flz;
    private PullRefreshFrameLayout jKa;
    private ValueAnimator jKb;
    private aq jKe;
    private o jKf;
    private View jKg;
    private int jKj;
    private int jKk;
    private BdTypeRecyclerView jhR;
    private FrsHeaderViewContainer jin;
    private boolean jKc = false;
    private boolean jKd = false;
    private RelativeLayout.LayoutParams jKh = null;
    private int jKi = 0;
    private PullRefreshFrameLayout.d jKl = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void w(double d) {
            if (k.this.jKg != null && k.this.jKh != null) {
                k.this.jKh.height = (int) (k.this.jKi + (PullRefreshFrameLayout.fle * d));
                k.this.jKg.setLayoutParams(k.this.jKh);
                if (k.this.jKf != null) {
                    k.this.jKf.B(d);
                }
                k.this.jKa.bxK();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void b(final int i, double d) {
            if (k.this.jKg != null && k.this.jKh != null && k.this.jKf != null) {
                k.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.flz.setDuration(150L);
                final int i2 = k.this.jKh.height;
                final int height = k.this.jKf.getHeight();
                k.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jKh.height = (int) (i2 - (i * animatedFraction));
                        k.this.jKg.setLayoutParams(k.this.jKh);
                        if (k.this.jKf != null) {
                            k.this.jKf.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.flz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jKj = k.this.jKh.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.flz.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void bxN() {
            if (k.this.jKh != null) {
                final int i = k.this.jKh.height;
                final int i2 = k.this.jKh.height - k.this.jKi;
                final int i3 = 0;
                if (k.this.jKf != null) {
                    i3 = k.this.jKf.cFS();
                }
                if (i2 > 0) {
                    k.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.flz.setDuration(300L);
                    k.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jKh.height = (int) (i - (i2 * floatValue));
                            k.this.jKg.setLayoutParams(k.this.jKh);
                            if (k.this.jKf != null && i3 > 0) {
                                k.this.jKf.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.flz.start();
                    k.this.flz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jKj = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jKe != null) {
                        k.this.jKe.bxN();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jKm = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bxM() {
            k.this.cOe();
        }
    };
    private Runnable jKn = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jKd) {
                k.this.cOf();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jKa = null;
        View rootView = frsFragment.getRootView();
        this.jKa = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jKa.setFromFrs();
        this.jKa.setOnTouchCallback(this.jKl);
        this.jKa.setOnPullRefreshListener(this.jKm);
        this.jKa.bxJ();
        this.jin = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.ZS = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.jhR = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cGN();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jKa.setInterceptScrollDown(z);
    }

    public int cOc() {
        return this.jKj;
    }

    public int cOd() {
        return this.jKi;
    }

    public void dismissLoading() {
        if (this.jKa != null) {
            this.jKa.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jKk) {
            this.jKc = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.jhR.getAdapter().notifyDataSetChanged();
            bUP();
        }
    }

    public boolean cFG() {
        return this.jKc;
    }

    public void onDestroy() {
        if (this.jKd) {
            cOf();
        }
        if (this.flz != null) {
            this.flz.cancel();
            this.flz.removeAllListeners();
            this.flz.removeAllUpdateListeners();
            this.flz = null;
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jKn);
    }

    public void startPullRefresh() {
        if (this.jKa != null || this.jKa.isEnable()) {
            if (this.jhR != null) {
                this.jhR.setSelection(0);
            }
            if (this.ZS != null) {
                this.ZS.setExpanded(true);
            }
            if (!this.jKd) {
                this.jKb = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jKb.setDuration(300L);
                this.jKb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jKh != null) {
                            k.this.jKh.height = (int) (k.this.jKi + (PullRefreshFrameLayout.fld * floatValue));
                            k.this.jKg.setLayoutParams(k.this.jKh);
                        }
                        if (k.this.jKf != null) {
                            k.this.jKf.setHeight((int) ((floatValue * PullRefreshFrameLayout.fld) + k.this.jKf.getOriginHeight()));
                        }
                    }
                });
                this.jKb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jKd && k.this.jKa != null && !k.this.jKa.isLoading()) {
                            k.this.cOf();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jKb.start();
                this.jKa.setRefreshing(true);
                cOe();
            }
        }
    }

    public void cGM() {
        final View headBgContainer;
        if (this.jin != null && (headBgContainer = this.jin.getHeadBgContainer()) != null) {
            if (this.jKf == null) {
                this.jKf = new o(headBgContainer);
            }
            if (this.jKf.cFS() > 0) {
                this.jKf.setHeight(this.jKf.cFS());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jKf.getOriginHeight() < 0) {
                        k.this.jKf.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jKf.cFS() < 0) {
                        k.this.jKf.zY(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cGN() {
        if (this.jin != null) {
            this.jKg = this.jin.getHeaderEmptyView();
            if (this.jKg != null) {
                this.jKi = 0;
                this.jKh = (RelativeLayout.LayoutParams) this.jKg.getLayoutParams();
                if (this.jKg.getHeight() > 0) {
                    this.jKh.height = this.jKi;
                    this.jKg.setLayoutParams(this.jKh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOe() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jKn, jJZ);
        this.jKd = true;
        if (this.jKe != null) {
            this.jKe.bxM();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cOf() {
        this.jKd = false;
        if (this.jKa != null) {
            this.jKa.bxI();
        }
    }

    public void bUP() {
        if (this.jKd) {
            cOf();
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jKn);
        }
    }

    public void qB(boolean z) {
        if (this.jKa != null) {
            this.jKa.setEnable(z);
        }
    }

    public void a(aq aqVar) {
        this.jKe = aqVar;
    }

    public aq cOg() {
        return this.jKe;
    }

    public void Ak(int i) {
        this.jKk = i;
    }

    public PullRefreshFrameLayout cOh() {
        return this.jKa;
    }
}
