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
    private static int iCc = 5000;
    private AppBarLayout XP;
    private ValueAnimator euO;
    private PullRefreshFrameLayout iCd;
    private ValueAnimator iCe;
    private au iCh;
    private o iCi;
    private View iCj;
    private int iCm;
    private int iCn;
    private BdTypeRecyclerView icD;
    private FrsHeaderViewContainer icY;
    private boolean iCf = false;
    private boolean iCg = false;
    private RelativeLayout.LayoutParams iCk = null;
    private int iCl = 0;
    private PullRefreshFrameLayout.d iCo = new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void t(double d) {
            if (k.this.iCj != null && k.this.iCk != null) {
                k.this.iCk.height = (int) (k.this.iCl + (PullRefreshFrameLayout.euv * d));
                k.this.iCj.setLayoutParams(k.this.iCk);
                if (k.this.iCi != null) {
                    k.this.iCi.x(d);
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void c(final int i, double d) {
            if (k.this.iCj != null && k.this.iCk != null && k.this.iCi != null) {
                k.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.euO.setDuration(150L);
                final int i2 = k.this.iCk.height;
                final int height = k.this.iCi.getHeight();
                k.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        k.this.iCk.height = (int) (i2 - (i * animatedFraction));
                        k.this.iCj.setLayoutParams(k.this.iCk);
                        if (k.this.iCi != null) {
                            k.this.iCi.setHeight((int) (height - (animatedFraction * i)));
                        }
                    }
                });
                k.this.euO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        k.this.iCm = k.this.iCk.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                k.this.euO.start();
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
        public void blz() {
            if (k.this.iCk != null) {
                final int i = k.this.iCk.height;
                final int i2 = k.this.iCk.height - k.this.iCl;
                final int i3 = 0;
                if (k.this.iCi != null) {
                    i3 = k.this.iCi.cpW();
                }
                if (i2 > 0) {
                    k.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    k.this.euO.setDuration(300L);
                    k.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            k.this.iCk.height = (int) (i - (i2 * floatValue));
                            k.this.iCj.setLayoutParams(k.this.iCk);
                            if (k.this.iCi != null && i3 > 0) {
                                k.this.iCi.setHeight((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    k.this.euO.start();
                    k.this.euO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            k.this.iCm = 0;
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    if (k.this.iCh != null) {
                        k.this.iCh.blz();
                    }
                }
            }
        }
    };
    private PullRefreshFrameLayout.c iCp = new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
        public void bly() {
            k.this.cxb();
        }
    };
    private Runnable iCq = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.iCg) {
                k.this.cxc();
            }
        }
    };

    public k(@NonNull FrsFragment frsFragment) {
        this.iCd = null;
        View rootView = frsFragment.getRootView();
        this.iCd = (PullRefreshFrameLayout) rootView.findViewById(R.id.frs_content_layout);
        this.iCd.setFromFrs();
        this.iCd.setOnTouchCallback(this.iCo);
        this.iCd.setOnPullRefreshListener(this.iCp);
        this.iCd.blw();
        this.icY = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        this.XP = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
        this.icD = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        cqS();
    }

    public void setInterceptScrollDown(boolean z) {
        this.iCd.setInterceptScrollDown(z);
    }

    public int cwZ() {
        return this.iCm;
    }

    public int cxa() {
        return this.iCl;
    }

    public void dismissLoading() {
        if (this.iCd != null) {
            this.iCd.dismissLoading();
        }
    }

    public void O(int i, boolean z) {
        if (i == this.iCn) {
            this.iCf = z;
            if (z) {
                startPullRefresh();
                return;
            }
            this.icD.getAdapter().notifyDataSetChanged();
            bHu();
        }
    }

    public boolean cpK() {
        return this.iCf;
    }

    public void onDestroy() {
        if (this.iCg) {
            cxc();
        }
        if (this.euO != null) {
            this.euO.cancel();
            this.euO.removeAllListeners();
            this.euO.removeAllUpdateListeners();
            this.euO = null;
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iCq);
    }

    public void startPullRefresh() {
        if (this.iCd != null || this.iCd.isEnable()) {
            if (this.icD != null) {
                this.icD.setSelection(0);
            }
            if (this.XP != null) {
                this.XP.setExpanded(true);
            }
            if (!this.iCg) {
                this.iCe = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.iCe.setDuration(300L);
                this.iCe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.k.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (k.this.iCk != null) {
                            k.this.iCk.height = (int) (k.this.iCl + (PullRefreshFrameLayout.euu * floatValue));
                            k.this.iCj.setLayoutParams(k.this.iCk);
                        }
                        if (k.this.iCi != null) {
                            k.this.iCi.setHeight((int) ((floatValue * PullRefreshFrameLayout.euu) + k.this.iCi.getOriginHeight()));
                        }
                    }
                });
                this.iCe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.vc.k.5
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!k.this.iCg && k.this.iCd != null && !k.this.iCd.isLoading()) {
                            k.this.cxc();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iCe.start();
                this.iCd.setRefreshing(true);
                cxb();
            }
        }
    }

    public void cqR() {
        final View headBgContainer;
        if (this.icY != null && (headBgContainer = this.icY.getHeadBgContainer()) != null) {
            if (this.iCi == null) {
                this.iCi = new o(headBgContainer);
            }
            if (this.iCi.cpW() > 0) {
                this.iCi.setHeight(this.iCi.cpW());
            }
            headBgContainer.post(new Runnable() { // from class: com.baidu.tieba.frs.vc.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.iCi.getOriginHeight() < 0) {
                        k.this.iCi.setOriginHeight(headBgContainer.getMeasuredHeight());
                    }
                    if (k.this.iCi.cpW() < 0) {
                        k.this.iCi.xw(headBgContainer.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public void cqS() {
        if (this.icY != null) {
            this.iCj = this.icY.getHeaderEmptyView();
            if (this.iCj != null) {
                this.iCl = 0;
                this.iCk = (RelativeLayout.LayoutParams) this.iCj.getLayoutParams();
                if (this.iCj.getHeight() > 0) {
                    this.iCk.height = this.iCl;
                    this.iCj.setLayoutParams(this.iCk);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxb() {
        com.baidu.adp.lib.f.e.mX().postDelayed(this.iCq, iCc);
        this.iCg = true;
        if (this.iCh != null) {
            this.iCh.bly();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public void cxc() {
        this.iCg = false;
        if (this.iCd != null) {
            this.iCd.blv();
        }
    }

    public void bHu() {
        if (this.iCg) {
            cxc();
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iCq);
        }
    }

    public void ox(boolean z) {
        if (this.iCd != null) {
            this.iCd.setEnable(z);
        }
    }

    public void a(au auVar) {
        this.iCh = auVar;
    }

    public void xJ(int i) {
        this.iCn = i;
    }

    public PullRefreshFrameLayout cxd() {
        return this.iCd;
    }
}
