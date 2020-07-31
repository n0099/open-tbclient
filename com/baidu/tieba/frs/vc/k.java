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
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
/* loaded from: classes16.dex */
public class k {
    private static int igu = 5000;
    private AppBarLayout WP;
    private ValueAnimator eiM;
    private FrsHeaderViewContainer hIC;
    private BdTypeRecyclerView hIh;
    private com.baidu.tieba.frs.n igA;
    private View igB;
    private int igE;
    private int igF;
    private PullRefreshFrameLayout igv;
    private ValueAnimator igw;
    private as igz;
    private boolean igx = false;
    private boolean igy = false;
    private RelativeLayout.LayoutParams igC = null;
    private int igD = 0;
    private PullRefreshFrameLayout.b igG = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void n(double d) {
            if (k.this.igB != null && k.this.igC != null) {
                k.this.igC.height = (int) (k.this.igD + (PullRefreshFrameLayout.eiv * d));
                k.this.igB.setLayoutParams(k.this.igC);
                if (k.this.igA != null) {
                    k.this.igA.r(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void c(final int i, double d) {
            if (k.this.igB != null && k.this.igC != null && k.this.igA != null) {
                k.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.eiM.setDuration(150L);
                final int i2 = k.this.igC.height;
                final int height = k.this.igA.getHeight();
                k.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.igC.height = (int) (i2 - (i * animatedFraction));
                        k.this.igB.setLayoutParams(k.this.igC);
                        if (k.this.igA != null) {
                            k.this.igA.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.eiM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.igE = k.this.igC.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.eiM.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void bch() {
            if (k.this.igC != null) {
                final int i = k.this.igC.height;
                final int i2 = k.this.igC.height - k.this.igD;
                final int i3 = 0;
                if (k.this.igA != null) {
                    i3 = k.this.igA.ccm();
                }
                if (i2 > 0) {
                    k.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.eiM.setDuration(300L);
                    k.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.igC.height = (int) (i - (i2 * floatValue));
                            k.this.igB.setLayoutParams(k.this.igC);
                            if (k.this.igA != null && i3 > 0) {
                                k.this.igA.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.eiM.start();
                    k.this.eiM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.igE = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.igz != null) {
                        k.this.igz.bch();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.a igH = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
        public void bcg() {
            k.this.cje();
        }
    };
    private Runnable igI = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.igy) {
                k.this.cjf();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.igv = null;
        View rootView = frsFragment.getRootView();
        this.igv = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.igv.setFromFrs();
        this.igv.setOnTouchCallback(this.igG);
        this.igv.setOnPullRefreshListener(this.igH);
        this.igv.bcf();
        this.hIC = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.WP = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hIh = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cdi();
    }

    public void setInterceptScrollDown(boolean z) {
        this.igv.setInterceptScrollDown(z);
    }

    public int cjc() {
        return this.igE;
    }

    public int cjd() {
        return this.igD;
    }

    public void dismissLoading() {
        if (this.igv != null) {
            this.igv.dismissLoading();
        }
    }

    public void M(int i, boolean z) {
        if (i == this.igF) {
            this.igx = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hIh.getAdapter().notifyDataSetChanged();
            bxe();
        }
    }

    public boolean cca() {
        return this.igx;
    }

    public void onDestroy() {
        if (this.igy) {
            cjf();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igI);
    }

    public void startPullRefresh() {
        if (this.igv != null || this.igv.isEnable()) {
            if (this.hIh != null) {
                this.hIh.setSelection(0);
            }
            if (this.WP != null) {
                this.WP.setExpanded(true);
            }
            if (!this.igy) {
                this.igw = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.igw.setDuration(300L);
                this.igw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.igC != null) {
                            k.this.igC.height = (int) (k.this.igD + (PullRefreshFrameLayout.eiu * floatValue));
                            k.this.igB.setLayoutParams(k.this.igC);
                        }
                        if (k.this.igA != null) {
                            k.this.igA.setHeight((int) ((floatValue * PullRefreshFrameLayout.eiu) + k.this.igA.getOriginHeight()));
                        }
                    }
                });
                this.igw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.igy && k.this.igv != null && !k.this.igv.isLoading()) {
                            k.this.cjf();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.igw.start();
                this.igv.setRefreshing(true);
                cje();
            }
        }
    }

    public void cdh() {
        final View headBgContainer;
        if (this.hIC != null && (headBgContainer = this.hIC.getHeadBgContainer()) != null) {
            if (this.igA == null) {
                this.igA = new com.baidu.tieba.frs.n(headBgContainer);
            }
            if (this.igA.ccm() > 0) {
                this.igA.setHeight(this.igA.ccm());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.igA.getOriginHeight() < 0) {
                        k.this.igA.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.igA.ccm() < 0) {
                        k.this.igA.uI(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cdi() {
        if (this.hIC != null) {
            this.igB = this.hIC.getHeaderEmptyView();
            if (this.igB != null) {
                this.igD = 0;
                this.igC = (RelativeLayout.LayoutParams) this.igB.getLayoutParams();
                if (this.igB.getHeight() > 0) {
                    this.igC.height = this.igD;
                    this.igB.setLayoutParams(this.igC);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.igI, igu);
        this.igy = true;
        if (this.igz != null) {
            this.igz.bcg();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cjf() {
        this.igy = false;
        if (this.igv != null) {
            this.igv.bce();
        }
    }

    public void bxe() {
        if (this.igy) {
            cjf();
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igI);
        }
    }

    public void nL(boolean z) {
        if (this.igv != null) {
            this.igv.setEnable(z);
        }
    }

    public void a(as asVar) {
        this.igz = asVar;
    }

    public void uV(int i) {
        this.igF = i;
    }
}
