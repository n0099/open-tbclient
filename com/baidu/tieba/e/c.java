package com.baidu.tieba.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private a bMl;
    private Animation bMm;
    private Animation bMn;
    private View bMo;
    private View bMp;
    private Context mContext;
    private boolean apU = false;
    private int aTs = 0;
    private boolean bMr = false;
    private boolean bMs = true;
    private final Handler.Callback bMt = new d(this);
    private final Handler mHandler = new Handler(this.bMt);
    private boolean bMq = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dx(boolean z);
    }

    public void dv(boolean z) {
        this.bMr = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bMo = view;
        this.bMp = view2;
        aag();
        dw(false);
    }

    private void ZV() {
        this.bMm = AnimationUtils.loadAnimation(this.mContext, r.a.pull_up_refresh_out);
        this.bMm.setAnimationListener(new e(this));
    }

    private void ZW() {
        this.bMn = AnimationUtils.loadAnimation(this.mContext, r.a.pull_up_refresh_in);
        this.bMn.setAnimationListener(new f(this));
    }

    public void ZX() {
        l(false, false);
    }

    public void ZY() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bMo != null && this.bMo.getVisibility() == 0 && !aad()) {
            if (z2) {
                this.bMo.setVisibility(8);
                return;
            }
            if (this.bMm == null) {
                ZV();
            }
            if (this.bMn != null) {
                this.bMn.cancel();
            }
            this.bMo.startAnimation(this.bMm);
        }
    }

    public void ZZ() {
        if (this.bMo != null && this.bMo.getVisibility() != 0 && !aad()) {
            this.bMo.setVisibility(0);
            if (this.bMn == null) {
                ZW();
            }
            if (this.bMm != null) {
                this.bMm.cancel();
            }
            this.bMo.startAnimation(this.bMn);
        }
    }

    public void aaa() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aab() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aac() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aad() {
        return ac(this.bMo);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void aae() {
        if (this.bMs) {
            if (this.apU) {
                dw(true);
            } else if (this.bMo != null && this.bMo.getVisibility() != 8) {
                aab();
            }
        }
    }

    public void aaf() {
        if (this.bMs) {
            if (this.apU) {
                dw(true);
            } else if (this.bMo != null && this.bMo.getVisibility() != 0) {
                aaa();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bMs && this.bMo != null) {
            if (i > this.aTs && this.bMo.getVisibility() != 8) {
                aae();
            } else if (i < this.aTs && this.bMo.getVisibility() != 0) {
                aaf();
            }
            this.aTs = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bMs) {
            if (this.apU) {
                dw(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aTs) {
                    aab();
                } else if (firstVisiblePosition < this.aTs) {
                    aaa();
                } else if (firstVisiblePosition == this.aTs) {
                    if (!this.bMr || b(absListView)) {
                        aaa();
                    } else {
                        aab();
                    }
                }
            }
        }
    }

    public boolean b(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void aag() {
        if (this.bMp != null) {
            if (this.bMq && this.bMp.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMp.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMp.setLayoutParams(layoutParams);
                dw(true);
                return;
            }
            dw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(boolean z) {
        if (this.bMp != null) {
            if (this.bMq && z && this.bMp.getVisibility() != 0) {
                this.bMp.setVisibility(0);
            } else if (!z && this.bMp.getVisibility() != 8) {
                this.bMp.setVisibility(8);
            }
        }
    }
}
