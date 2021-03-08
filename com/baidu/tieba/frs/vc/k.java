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
    private static int jMU = 5000;
    private AppBarLayout abf;
    private ValueAnimator fkG;
    private PullRefreshFrameLayout jMV;
    private ValueAnimator jMW;
    private aq jMZ;
    private o jNa;
    private View jNb;
    private int jNe;
    private int jNf;
    private BdTypeRecyclerView jkO;
    private FrsHeaderViewContainer jlj;
    private boolean jMX = false;
    private boolean jMY = false;
    private RelativeLayout.LayoutParams jNc = null;
    private int jNd = 0;
    private PullRefreshFrameLayout.d jNg = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void q(double d) {
            if (k.this.jNb != null && k.this.jNc != null) {
                k.this.jNc.height = (int) (k.this.jNd + (PullRefreshFrameLayout.fkl * d));
                k.this.jNb.setLayoutParams(k.this.jNc);
                if (k.this.jNa != null) {
                    k.this.jNa.v(d);
                }
                k.this.jMV.bun();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void b(final int i, double d) {
            if (k.this.jNb != null && k.this.jNc != null && k.this.jNa != null) {
                k.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.fkG.setDuration(150L);
                final int i2 = k.this.jNc.height;
                final int height = k.this.jNa.getHeight();
                k.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jNc.height = (int) (i2 - (i * animatedFraction));
                        k.this.jNb.setLayoutParams(k.this.jNc);
                        if (k.this.jNa != null) {
                            k.this.jNa.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.fkG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jNe = k.this.jNc.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.fkG.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void buq() {
            if (k.this.jNc != null) {
                final int i = k.this.jNc.height;
                final int i2 = k.this.jNc.height - k.this.jNd;
                final int i3 = 0;
                if (k.this.jNa != null) {
                    i3 = k.this.jNa.cDz();
                }
                if (i2 > 0) {
                    k.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.fkG.setDuration(300L);
                    k.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jNc.height = (int) (i - (i2 * floatValue));
                            k.this.jNb.setLayoutParams(k.this.jNc);
                            if (k.this.jNa != null && i3 > 0) {
                                k.this.jNa.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.fkG.start();
                    k.this.fkG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jNe = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jMZ != null) {
                        k.this.jMZ.buq();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jNh = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bup() {
            k.this.cLN();
        }
    };
    private Runnable jNi = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jMY) {
                k.this.cLO();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jMV = null;
        View rootView = frsFragment.getRootView();
        this.jMV = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jMV.setFromFrs();
        this.jMV.setOnTouchCallback(this.jNg);
        this.jMV.setOnPullRefreshListener(this.jNh);
        this.jMV.bum();
        this.jlj = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.abf = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.jkO = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cEu();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jMV.setInterceptScrollDown(z);
    }

    public int cLL() {
        return this.jNe;
    }

    public int cLM() {
        return this.jNd;
    }

    public void dismissLoading() {
        if (this.jMV != null) {
            this.jMV.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jNf) {
            this.jMX = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.jkO.getAdapter().notifyDataSetChanged();
            bRO();
        }
    }

    public boolean cDn() {
        return this.jMX;
    }

    public void onDestroy() {
        if (this.jMY) {
            cLO();
        }
        if (this.fkG != null) {
            this.fkG.cancel();
            this.fkG.removeAllListeners();
            this.fkG.removeAllUpdateListeners();
            this.fkG = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNi);
    }

    public void startPullRefresh() {
        if (this.jMV != null || this.jMV.isEnable()) {
            if (this.jkO != null) {
                this.jkO.setSelection(0);
            }
            if (this.abf != null) {
                this.abf.setExpanded(true);
            }
            if (!this.jMY) {
                this.jMW = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jMW.setDuration(300L);
                this.jMW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jNc != null) {
                            k.this.jNc.height = (int) (k.this.jNd + (PullRefreshFrameLayout.fkk * floatValue));
                            k.this.jNb.setLayoutParams(k.this.jNc);
                        }
                        if (k.this.jNa != null) {
                            k.this.jNa.setHeight((int) ((floatValue * PullRefreshFrameLayout.fkk) + k.this.jNa.getOriginHeight()));
                        }
                    }
                });
                this.jMW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jMY && k.this.jMV != null && !k.this.jMV.isLoading()) {
                            k.this.cLO();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jMW.start();
                this.jMV.setRefreshing(true);
                cLN();
            }
        }
    }

    public void cEt() {
        final View headBgContainer;
        if (this.jlj != null && (headBgContainer = this.jlj.getHeadBgContainer()) != null) {
            if (this.jNa == null) {
                this.jNa = new o(headBgContainer);
            }
            if (this.jNa.cDz() > 0) {
                this.jNa.setHeight(this.jNa.cDz());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jNa.getOriginHeight() < 0) {
                        k.this.jNa.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jNa.cDz() < 0) {
                        k.this.jNa.yD(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cEu() {
        if (this.jlj != null) {
            this.jNb = this.jlj.getHeaderEmptyView();
            if (this.jNb != null) {
                this.jNd = 0;
                this.jNc = (RelativeLayout.LayoutParams) this.jNb.getLayoutParams();
                if (this.jNb.getHeight() > 0) {
                    this.jNc.height = this.jNd;
                    this.jNb.setLayoutParams(this.jNc);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLN() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jNi, jMU);
        this.jMY = true;
        if (this.jMZ != null) {
            this.jMZ.bup();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cLO() {
        this.jMY = false;
        if (this.jMV != null) {
            this.jMV.bul();
        }
    }

    public void bRO() {
        if (this.jMY) {
            cLO();
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNi);
        }
    }

    public void qH(boolean z) {
        if (this.jMV != null) {
            this.jMV.setEnable(z);
        }
    }

    public void a(aq aqVar) {
        this.jMZ = aqVar;
    }

    public aq cLP() {
        return this.jMZ;
    }

    public void yP(int i) {
        this.jNf = i;
    }

    public PullRefreshFrameLayout cLQ() {
        return this.jMV;
    }
}
