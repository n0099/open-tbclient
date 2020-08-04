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
    private static int igw = 5000;
    private AppBarLayout WP;
    private ValueAnimator eiM;
    private FrsHeaderViewContainer hIC;
    private BdTypeRecyclerView hIh;
    private as igB;
    private com.baidu.tieba.frs.n igC;
    private View igD;
    private int igG;
    private int igH;
    private PullRefreshFrameLayout igx;
    private ValueAnimator igy;
    private boolean igz = false;
    private boolean igA = false;
    private RelativeLayout.LayoutParams igE = null;
    private int igF = 0;
    private PullRefreshFrameLayout.b igI = new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void n(double d) {
            if (k.this.igD != null && k.this.igE != null) {
                k.this.igE.height = (int) (k.this.igF + (PullRefreshFrameLayout.eiv * d));
                k.this.igD.setLayoutParams(k.this.igE);
                if (k.this.igC != null) {
                    k.this.igC.r(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
        public void c(final int i, double d) {
            if (k.this.igD != null && k.this.igE != null && k.this.igC != null) {
                k.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.eiM.setDuration(150L);
                final int i2 = k.this.igE.height;
                final int height = k.this.igC.getHeight();
                k.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.igE.height = (int) (i2 - (i * animatedFraction));
                        k.this.igD.setLayoutParams(k.this.igE);
                        if (k.this.igC != null) {
                            k.this.igC.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.eiM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.igG = k.this.igE.height;
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
            if (k.this.igE != null) {
                final int i = k.this.igE.height;
                final int i2 = k.this.igE.height - k.this.igF;
                final int i3 = 0;
                if (k.this.igC != null) {
                    i3 = k.this.igC.ccm();
                }
                if (i2 > 0) {
                    k.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.eiM.setDuration(300L);
                    k.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.igE.height = (int) (i - (i2 * floatValue));
                            k.this.igD.setLayoutParams(k.this.igE);
                            if (k.this.igC != null && i3 > 0) {
                                k.this.igC.setHeight((int) (i3 - (floatValue * i2)));
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
                            k.this.igG = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.igB != null) {
                        k.this.igB.bch();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.a igJ = new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
        public void bcg() {
            k.this.cje();
        }
    };
    private Runnable igK = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.igA) {
                k.this.cjf();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.igx = null;
        View rootView = frsFragment.getRootView();
        this.igx = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.igx.setFromFrs();
        this.igx.setOnTouchCallback(this.igI);
        this.igx.setOnPullRefreshListener(this.igJ);
        this.igx.bcf();
        this.hIC = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.WP = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.hIh = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cdi();
    }

    public void setInterceptScrollDown(boolean z) {
        this.igx.setInterceptScrollDown(z);
    }

    public int cjc() {
        return this.igG;
    }

    public int cjd() {
        return this.igF;
    }

    public void dismissLoading() {
        if (this.igx != null) {
            this.igx.dismissLoading();
        }
    }

    public void M(int i, boolean z) {
        if (i == this.igH) {
            this.igz = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.hIh.getAdapter().notifyDataSetChanged();
            bxe();
        }
    }

    public boolean cca() {
        return this.igz;
    }

    public void onDestroy() {
        if (this.igA) {
            cjf();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igK);
    }

    public void startPullRefresh() {
        if (this.igx != null || this.igx.isEnable()) {
            if (this.hIh != null) {
                this.hIh.setSelection(0);
            }
            if (this.WP != null) {
                this.WP.setExpanded(true);
            }
            if (!this.igA) {
                this.igy = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.igy.setDuration(300L);
                this.igy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.igE != null) {
                            k.this.igE.height = (int) (k.this.igF + (PullRefreshFrameLayout.eiu * floatValue));
                            k.this.igD.setLayoutParams(k.this.igE);
                        }
                        if (k.this.igC != null) {
                            k.this.igC.setHeight((int) ((floatValue * PullRefreshFrameLayout.eiu) + k.this.igC.getOriginHeight()));
                        }
                    }
                });
                this.igy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.igA && k.this.igx != null && !k.this.igx.isLoading()) {
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
                this.igy.start();
                this.igx.setRefreshing(true);
                cje();
            }
        }
    }

    public void cdh() {
        final View headBgContainer;
        if (this.hIC != null && (headBgContainer = this.hIC.getHeadBgContainer()) != null) {
            if (this.igC == null) {
                this.igC = new com.baidu.tieba.frs.n(headBgContainer);
            }
            if (this.igC.ccm() > 0) {
                this.igC.setHeight(this.igC.ccm());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.igC.getOriginHeight() < 0) {
                        k.this.igC.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.igC.ccm() < 0) {
                        k.this.igC.uI(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cdi() {
        if (this.hIC != null) {
            this.igD = this.hIC.getHeaderEmptyView();
            if (this.igD != null) {
                this.igF = 0;
                this.igE = (RelativeLayout.LayoutParams) this.igD.getLayoutParams();
                if (this.igD.getHeight() > 0) {
                    this.igE.height = this.igF;
                    this.igD.setLayoutParams(this.igE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.igK, igw);
        this.igA = true;
        if (this.igB != null) {
            this.igB.bcg();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cjf() {
        this.igA = false;
        if (this.igx != null) {
            this.igx.bce();
        }
    }

    public void bxe() {
        if (this.igA) {
            cjf();
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igK);
        }
    }

    public void nL(boolean z) {
        if (this.igx != null) {
            this.igx.setEnable(z);
        }
    }

    public void a(as asVar) {
        this.igB = asVar;
    }

    public void uV(int i) {
        this.igH = i;
    }
}
