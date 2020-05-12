package com.baidu.tieba.frs.vc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
/* loaded from: classes9.dex */
public class k {
    private static int hxG = 5000;
    private AppBarLayout Wc;
    private ValueAnimator dGZ;
    private BdTypeRecyclerView haA;
    private FrsHeaderViewContainer haX;
    private PullRefreshFrameLayout hxH;
    private ValueAnimator hxI;
    private an hxL;
    private com.baidu.tieba.frs.l hxM;
    private View hxN;
    private int hxQ;
    private int hxR;
    private boolean hxJ = false;
    private boolean hxK = false;
    private RelativeLayout.LayoutParams hxO = null;
    private int hxP = 0;
    private PullRefreshFrameLayout.b hxS = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void m(double d) {
            if (k.this.hxN != null && k.this.hxO != null) {
                k.this.hxO.height = (int) (k.this.hxP + (PullRefreshFrameLayout.dGI * d));
                k.this.hxN.setLayoutParams(k.this.hxO);
                if (k.this.hxM != null) {
                    k.this.hxM.q(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void c(final int i, double d) {
            if (k.this.hxN != null && k.this.hxO != null && k.this.hxM != null) {
                k.this.dGZ = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.dGZ.setDuration(150L);
                final int i2 = k.this.hxO.height;
                final int height = k.this.hxM.getHeight();
                k.this.dGZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.hxO.height = (int) (i2 - (i * animatedFraction));
                        k.this.hxN.setLayoutParams(k.this.hxO);
                        if (k.this.hxM != null) {
                            k.this.hxM.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.dGZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.hxQ = k.this.hxO.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.dGZ.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void aQl() {
            if (k.this.hxO != null) {
                final int i = k.this.hxO.height;
                final int i2 = k.this.hxO.height - k.this.hxP;
                final int i3 = 0;
                if (k.this.hxM != null) {
                    i3 = k.this.hxM.bPi();
                }
                if (i2 > 0) {
                    k.this.dGZ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.dGZ.setDuration(300L);
                    k.this.dGZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.hxO.height = (int) (i - (i2 * floatValue));
                            k.this.hxN.setLayoutParams(k.this.hxO);
                            if (k.this.hxM != null && i3 > 0) {
                                k.this.hxM.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.dGZ.start();
                    k.this.dGZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.hxQ = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.hxL != null) {
                        k.this.hxL.aQl();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.a hxT = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
        public void aQk() {
            k.this.bVG();
        }
    };
    private Runnable hxU = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.hxK) {
                k.this.bVH();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.hxH = null;
        View rootView = frsFragment.getRootView();
        this.hxH = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.hxH.setFromFrs();
        this.hxH.setOnTouchCallback(this.hxS);
        this.hxH.setOnPullRefreshListener(this.hxT);
        this.hxH.aQj();
        this.haX = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Wc = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.haA = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        bQc();
    }

    public void setInterceptScrollDown(boolean z) {
        this.hxH.setInterceptScrollDown(z);
    }

    public int bVE() {
        return this.hxQ;
    }

    public int bVF() {
        return this.hxP;
    }

    public void aqg() {
        if (this.hxH != null) {
            this.hxH.aqg();
        }
    }

    public void H(int i, boolean z) {
        if (i == this.hxR) {
            this.hxJ = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.haA.getAdapter().notifyDataSetChanged();
            blx();
        }
    }

    public boolean bOY() {
        return this.hxJ;
    }

    public void onDestroy() {
        if (this.hxK) {
            bVH();
        }
        if (this.dGZ != null) {
            this.dGZ.cancel();
            this.dGZ.removeAllListeners();
            this.dGZ.removeAllUpdateListeners();
            this.dGZ = null;
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxU);
    }

    public void startPullRefresh() {
        if (this.hxH != null || this.hxH.isEnable()) {
            if (this.haA != null) {
                this.haA.setSelection(0);
            }
            if (this.Wc != null) {
                this.Wc.setExpanded(true);
            }
            if (!this.hxK) {
                this.hxI = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.hxI.setDuration(300L);
                this.hxI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.hxO != null) {
                            k.this.hxO.height = (int) (k.this.hxP + (PullRefreshFrameLayout.dGH * floatValue));
                            k.this.hxN.setLayoutParams(k.this.hxO);
                        }
                        if (k.this.hxM != null) {
                            k.this.hxM.setHeight((int) ((floatValue * PullRefreshFrameLayout.dGH) + k.this.hxM.getOriginHeight()));
                        }
                    }
                });
                this.hxI.start();
                this.hxH.setRefreshing(true);
                bVG();
            }
        }
    }

    public void bQb() {
        final View headBgContainer;
        if (this.haX != null && (headBgContainer = this.haX.getHeadBgContainer()) != null) {
            if (this.hxM == null) {
                this.hxM = new com.baidu.tieba.frs.l(headBgContainer);
            }
            if (this.hxM.bPi() > 0) {
                this.hxM.setHeight(this.hxM.bPi());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.5
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.hxM.getOriginHeight() < 0) {
                        k.this.hxM.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.hxM.bPi() < 0) {
                        k.this.hxM.tg(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void bQc() {
        if (this.haX != null) {
            this.hxN = this.haX.getHeaderEmptyView();
            if (this.hxN != null) {
                this.hxP = 0;
                this.hxO = (RelativeLayout.LayoutParams) this.hxN.getLayoutParams();
                if (this.hxN.getHeight() > 0) {
                    this.hxO.height = this.hxP;
                    this.hxN.setLayoutParams(this.hxO);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVG() {
        com.baidu.adp.lib.f.e.lb().postDelayed(this.hxU, hxG);
        this.hxK = true;
        if (this.hxL != null) {
            this.hxL.aQk();
        }
    }

    public void bVH() {
        this.hxK = false;
        if (this.hxH != null) {
            this.hxH.aQi();
        }
    }

    public void blx() {
        if (this.hxK) {
            bVH();
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxU);
        }
    }

    public void mA(boolean z) {
        if (this.hxH != null) {
            this.hxH.setEnable(z);
        }
    }

    public void a(an anVar) {
        this.hxL = anVar;
    }

    public void tr(int i) {
        this.hxR = i;
    }
}
