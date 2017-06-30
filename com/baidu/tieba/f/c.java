package com.baidu.tieba.f;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private a bVf;
    private Animation bVg;
    private Animation bVh;
    private View bVi;
    private View bVj;
    private Context mContext;
    private boolean avf = false;
    private int aKs = 0;
    private boolean aKt = false;
    private boolean bVl = true;
    private final Handler.Callback bVm = new d(this);
    private final Handler mHandler = new Handler(this.bVm);
    private boolean bVk = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void eg(boolean z);
    }

    public void ee(boolean z) {
        this.aKt = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bVi = view;
        this.bVj = view2;
        abE();
        ef(false);
    }

    private void aby() {
        this.bVg = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_out);
        this.bVg.setAnimationListener(new e(this));
    }

    private void abz() {
        this.bVh = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_in);
        this.bVh.setAnimationListener(new f(this));
    }

    public void abA() {
        o(false, false);
    }

    public void abB() {
        o(false, true);
    }

    public void o(boolean z, boolean z2) {
        if (this.bVi != null && this.bVi.getVisibility() == 0 && !abD()) {
            if (z2) {
                this.bVi.setVisibility(8);
                return;
            }
            if (this.bVg == null) {
                aby();
            }
            if (this.bVh != null) {
                this.bVh.cancel();
            }
            this.bVi.startAnimation(this.bVg);
        }
    }

    public void abC() {
        if (this.bVi != null && this.bVi.getVisibility() != 0 && !abD()) {
            this.bVi.setVisibility(0);
            if (this.bVh == null) {
                abz();
            }
            if (this.bVg != null) {
                this.bVg.cancel();
            }
            this.bVi.startAnimation(this.bVh);
        }
    }

    public void GP() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GQ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GR() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean abD() {
        return ae(this.bVi);
    }

    private boolean ae(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.bVl) {
            if (this.avf) {
                ef(true);
            } else if (this.bVi != null && this.bVi.getVisibility() != 8) {
                GQ();
            }
        }
    }

    public void showFloatingView() {
        if (this.bVl) {
            if (this.avf) {
                ef(true);
            } else if (this.bVi != null && this.bVi.getVisibility() != 0) {
                GP();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bVl && this.bVi != null) {
            if (i > this.aKs && this.bVi.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aKs && this.bVi.getVisibility() != 0) {
                showFloatingView();
            }
            this.aKs = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bVl) {
            if (this.avf) {
                ef(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aKs) {
                    GQ();
                } else if (firstVisiblePosition < this.aKs) {
                    GP();
                } else if (firstVisiblePosition == this.aKs) {
                    if (!this.aKt || a(absListView)) {
                        GP();
                    } else {
                        GQ();
                    }
                }
            }
        }
    }

    public boolean a(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void abE() {
        if (this.bVj != null) {
            if (this.bVk && this.bVj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bVj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bVj.setLayoutParams(layoutParams);
                ef(true);
                return;
            }
            ef(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ef(boolean z) {
        if (this.bVj != null) {
            if (this.bVk && z && this.bVj.getVisibility() != 0) {
                this.bVj.setVisibility(0);
            } else if (!z && this.bVj.getVisibility() != 8) {
                this.bVj.setVisibility(8);
            }
        }
    }
}
