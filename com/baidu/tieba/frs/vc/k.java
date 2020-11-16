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
/* loaded from: classes21.dex */
public class k {
    private static int jjX = 5000;
    private AppBarLayout Ym;
    private ValueAnimator eUt;
    private BdTypeRecyclerView iKK;
    private FrsHeaderViewContainer iLf;
    private PullRefreshFrameLayout jjY;
    private ValueAnimator jjZ;
    private au jkc;
    private o jkd;
    private View jke;
    private int jkh;
    private int jki;
    private boolean jka = false;
    private boolean jkb = false;
    private RelativeLayout.LayoutParams jkf = null;
    private int jkg = 0;
    private PullRefreshFrameLayout.d jkj = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void w(double d) {
            if (k.this.jke != null && k.this.jkf != null) {
                k.this.jkf.height = (int) (k.this.jkg + (PullRefreshFrameLayout.eTY * d));
                k.this.jke.setLayoutParams(k.this.jkf);
                if (k.this.jkd != null) {
                    k.this.jkd.B(d);
                }
                k.this.jjY.brP();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.jke != null && k.this.jkf != null && k.this.jkd != null) {
                k.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.eUt.setDuration(150L);
                final int i2 = k.this.jkf.height;
                final int height = k.this.jkd.getHeight();
                k.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.jkf.height = (int) (i2 - (i * animatedFraction));
                        k.this.jke.setLayoutParams(k.this.jkf);
                        if (k.this.jkd != null) {
                            k.this.jkd.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.eUt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.jkh = k.this.jkf.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.eUt.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void brS() {
            if (k.this.jkf != null) {
                final int i = k.this.jkf.height;
                final int i2 = k.this.jkf.height - k.this.jkg;
                final int i3 = 0;
                if (k.this.jkd != null) {
                    i3 = k.this.jkd.cyF();
                }
                if (i2 > 0) {
                    k.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.eUt.setDuration(300L);
                    k.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.jkf.height = (int) (i - (i2 * floatValue));
                            k.this.jke.setLayoutParams(k.this.jkf);
                            if (k.this.jkd != null && i3 > 0) {
                                k.this.jkd.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.eUt.start();
                    k.this.eUt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.jkh = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.jkc != null) {
                        k.this.jkc.brS();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c jkk = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void brR() {
            k.this.cFL();
        }
    };
    private Runnable jkl = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.jkb) {
                k.this.cFM();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.jjY = null;
        View rootView = frsFragment.getRootView();
        this.jjY = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.jjY.setFromFrs();
        this.jjY.setOnTouchCallback(this.jkj);
        this.jjY.setOnPullRefreshListener(this.jkk);
        this.jjY.brO();
        this.iLf = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.Ym = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.iKK = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        czB();
    }

    public void setInterceptScrollDown(boolean z) {
        this.jjY.setInterceptScrollDown(z);
    }

    public int cFJ() {
        return this.jkh;
    }

    public int cFK() {
        return this.jkg;
    }

    public void dismissLoading() {
        if (this.jjY != null) {
            this.jjY.dismissLoading();
        }
    }

    public void Q(int i, boolean z) {
        if (i == this.jki) {
            this.jka = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.iKK.getAdapter().notifyDataSetChanged();
            bOA();
        }
    }

    public boolean cyt() {
        return this.jka;
    }

    public void onDestroy() {
        if (this.jkb) {
            cFM();
        }
        if (this.eUt != null) {
            this.eUt.cancel();
            this.eUt.removeAllListeners();
            this.eUt.removeAllUpdateListeners();
            this.eUt = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkl);
    }

    public void startPullRefresh() {
        if (this.jjY != null || this.jjY.isEnable()) {
            if (this.iKK != null) {
                this.iKK.setSelection(0);
            }
            if (this.Ym != null) {
                this.Ym.setExpanded(true);
            }
            if (!this.jkb) {
                this.jjZ = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.jjZ.setDuration(300L);
                this.jjZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.jkf != null) {
                            k.this.jkf.height = (int) (k.this.jkg + (PullRefreshFrameLayout.eTX * floatValue));
                            k.this.jke.setLayoutParams(k.this.jkf);
                        }
                        if (k.this.jkd != null) {
                            k.this.jkd.setHeight((int) ((floatValue * PullRefreshFrameLayout.eTX) + k.this.jkd.getOriginHeight()));
                        }
                    }
                });
                this.jjZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.jkb && k.this.jjY != null && !k.this.jjY.isLoading()) {
                            k.this.cFM();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jjZ.start();
                this.jjY.setRefreshing(true);
                cFL();
            }
        }
    }

    public void czA() {
        final View headBgContainer;
        if (this.iLf != null && (headBgContainer = this.iLf.getHeadBgContainer()) != null) {
            if (this.jkd == null) {
                this.jkd = new o(headBgContainer);
            }
            if (this.jkd.cyF() > 0) {
                this.jkd.setHeight(this.jkd.cyF());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.jkd.getOriginHeight() < 0) {
                        k.this.jkd.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.jkd.cyF() < 0) {
                        k.this.jkd.zg(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void czB() {
        if (this.iLf != null) {
            this.jke = this.iLf.getHeaderEmptyView();
            if (this.jke != null) {
                this.jkg = 0;
                this.jkf = (RelativeLayout.LayoutParams) this.jke.getLayoutParams();
                if (this.jke.getHeight() > 0) {
                    this.jkf.height = this.jkg;
                    this.jke.setLayoutParams(this.jkf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFL() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.jkl, jjX);
        this.jkb = true;
        if (this.jkc != null) {
            this.jkc.brR();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cFM() {
        this.jkb = false;
        if (this.jjY != null) {
            this.jjY.brN();
        }
    }

    public void bOA() {
        if (this.jkb) {
            cFM();
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkl);
        }
    }

    public void pG(boolean z) {
        if (this.jjY != null) {
            this.jjY.setEnable(z);
        }
    }

    public void a(au auVar) {
        this.jkc = auVar;
    }

    public void zt(int i) {
        this.jki = i;
    }

    public PullRefreshFrameLayout cFN() {
        return this.jjY;
    }
}
