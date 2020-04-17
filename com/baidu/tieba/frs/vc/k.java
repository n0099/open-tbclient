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
    private static int hxA = 5000;
    private AppBarLayout VZ;
    private ValueAnimator dGV;
    private FrsHeaderViewContainer haR;
    private BdTypeRecyclerView hau;
    private PullRefreshFrameLayout hxB;
    private ValueAnimator hxC;
    private an hxF;
    private com.baidu.tieba.frs.l hxG;
    private View hxH;
    private int hxK;
    private int hxL;
    private boolean hxD = false;
    private boolean hxE = false;
    private RelativeLayout.LayoutParams hxI = null;
    private int hxJ = 0;
    private PullRefreshFrameLayout.b hxM = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void m(double d) {
            if (k.this.hxH != null && k.this.hxI != null) {
                k.this.hxI.height = (int) (k.this.hxJ + (PullRefreshFrameLayout.dGE * d));
                k.this.hxH.setLayoutParams(k.this.hxI);
                if (k.this.hxG != null) {
                    k.this.hxG.q(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void c(final int i, double d) {
            if (k.this.hxH != null && k.this.hxI != null && k.this.hxG != null) {
                k.this.dGV = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.dGV.setDuration(150L);
                final int i2 = k.this.hxI.height;
                final int height = k.this.hxG.getHeight();
                k.this.dGV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.hxI.height = (int) (i2 - (i * animatedFraction));
                        k.this.hxH.setLayoutParams(k.this.hxI);
                        if (k.this.hxG != null) {
                            k.this.hxG.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.dGV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.hxK = k.this.hxI.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.dGV.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void aQo() {
            if (k.this.hxI != null) {
                final int i = k.this.hxI.height;
                final int i2 = k.this.hxI.height - k.this.hxJ;
                final int i3 = 0;
                if (k.this.hxG != null) {
                    i3 = k.this.hxG.bPj();
                }
                if (i2 > 0) {
                    k.this.dGV = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.dGV.setDuration(300L);
                    k.this.dGV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.hxI.height = (int) (i - (i2 * floatValue));
                            k.this.hxH.setLayoutParams(k.this.hxI);
                            if (k.this.hxG != null && i3 > 0) {
                                k.this.hxG.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.dGV.start();
                    k.this.dGV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.hxK = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.hxF != null) {
                        k.this.hxF.aQo();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.a hxN = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
        public void aQn() {
            k.this.bVH();
        }
    };
    private Runnable hxO = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.hxE) {
                k.this.bVI();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.hxB = null;
        View rootView = frsFragment.getRootView();
        this.hxB = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.hxB.setFromFrs();
        this.hxB.setOnTouchCallback(this.hxM);
        this.hxB.setOnPullRefreshListener(this.hxN);
        this.hxB.aQm();
        this.haR = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.VZ = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hau = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        bQd();
    }

    public void setInterceptScrollDown(boolean z) {
        this.hxB.setInterceptScrollDown(z);
    }

    public int bVF() {
        return this.hxK;
    }

    public int bVG() {
        return this.hxJ;
    }

    public void aqh() {
        if (this.hxB != null) {
            this.hxB.aqh();
        }
    }

    public void H(int i, boolean z) {
        if (i == this.hxL) {
            this.hxD = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hau.getAdapter().notifyDataSetChanged();
            blz();
        }
    }

    public boolean bOZ() {
        return this.hxD;
    }

    public void onDestroy() {
        if (this.hxE) {
            bVI();
        }
        if (this.dGV != null) {
            this.dGV.cancel();
            this.dGV.removeAllListeners();
            this.dGV.removeAllUpdateListeners();
            this.dGV = null;
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxO);
    }

    public void startPullRefresh() {
        if (this.hxB != null || this.hxB.isEnable()) {
            if (this.hau != null) {
                this.hau.setSelection(0);
            }
            if (this.VZ != null) {
                this.VZ.setExpanded(true);
            }
            if (!this.hxE) {
                this.hxC = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.hxC.setDuration(300L);
                this.hxC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.hxI != null) {
                            k.this.hxI.height = (int) (k.this.hxJ + (PullRefreshFrameLayout.dGD * floatValue));
                            k.this.hxH.setLayoutParams(k.this.hxI);
                        }
                        if (k.this.hxG != null) {
                            k.this.hxG.setHeight((int) ((floatValue * PullRefreshFrameLayout.dGD) + k.this.hxG.getOriginHeight()));
                        }
                    }
                });
                this.hxC.start();
                this.hxB.setRefreshing(true);
                bVH();
            }
        }
    }

    public void bQc() {
        final View headBgContainer;
        if (this.haR != null && (headBgContainer = this.haR.getHeadBgContainer()) != null) {
            if (this.hxG == null) {
                this.hxG = new com.baidu.tieba.frs.l(headBgContainer);
            }
            if (this.hxG.bPj() > 0) {
                this.hxG.setHeight(this.hxG.bPj());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.5
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.hxG.getOriginHeight() < 0) {
                        k.this.hxG.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.hxG.bPj() < 0) {
                        k.this.hxG.tg(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void bQd() {
        if (this.haR != null) {
            this.hxH = this.haR.getHeaderEmptyView();
            if (this.hxH != null) {
                this.hxJ = 0;
                this.hxI = (RelativeLayout.LayoutParams) this.hxH.getLayoutParams();
                if (this.hxH.getHeight() > 0) {
                    this.hxI.height = this.hxJ;
                    this.hxH.setLayoutParams(this.hxI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVH() {
        com.baidu.adp.lib.f.e.lb().postDelayed(this.hxO, hxA);
        this.hxE = true;
        if (this.hxF != null) {
            this.hxF.aQn();
        }
    }

    public void bVI() {
        this.hxE = false;
        if (this.hxB != null) {
            this.hxB.aQl();
        }
    }

    public void blz() {
        if (this.hxE) {
            bVI();
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxO);
        }
    }

    public void mA(boolean z) {
        if (this.hxB != null) {
            this.hxB.setEnable(z);
        }
    }

    public void a(an anVar) {
        this.hxF = anVar;
    }

    public void tr(int i) {
        this.hxL = i;
    }
}
