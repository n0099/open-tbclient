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
    private a bGZ;
    private Animation bHa;
    private Animation bHb;
    private View bHc;
    private View bHd;
    private Context mContext;
    private boolean aum = false;
    private int bHf = 0;
    private boolean bHg = false;
    private boolean bHh = true;
    private final Handler.Callback bHi = new d(this);
    private final Handler mHandler = new Handler(this.bHi);
    private boolean bHe = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: do  reason: not valid java name */
        void m17do(boolean z);
    }

    public void dm(boolean z) {
        this.bHg = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bHc = view;
        this.bHd = view2;
        Xk();
        dn(false);
    }

    private void WZ() {
        this.bHa = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_out);
        this.bHa.setAnimationListener(new e(this));
    }

    private void Xa() {
        this.bHb = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_in);
        this.bHb.setAnimationListener(new f(this));
    }

    public void Xb() {
        l(false, false);
    }

    public void Xc() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bHc != null && this.bHc.getVisibility() == 0 && !Xh()) {
            if (z2) {
                this.bHc.setVisibility(8);
                return;
            }
            if (this.bHa == null) {
                WZ();
            }
            if (this.bHb != null) {
                this.bHb.cancel();
            }
            this.bHc.startAnimation(this.bHa);
        }
    }

    public void Xd() {
        if (this.bHc != null && this.bHc.getVisibility() != 0 && !Xh()) {
            this.bHc.setVisibility(0);
            if (this.bHb == null) {
                Xa();
            }
            if (this.bHa != null) {
                this.bHa.cancel();
            }
            this.bHc.startAnimation(this.bHb);
        }
    }

    public void Xe() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Xh() {
        return af(this.bHc);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Xi() {
        if (this.bHh) {
            if (this.aum) {
                dn(true);
            } else if (this.bHc != null && this.bHc.getVisibility() != 8) {
                Xf();
            }
        }
    }

    public void Xj() {
        if (this.bHh) {
            if (this.aum) {
                dn(true);
            } else if (this.bHc != null && this.bHc.getVisibility() != 0) {
                Xe();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bHh && this.bHc != null) {
            if (i > this.bHf && this.bHc.getVisibility() != 8) {
                Xi();
            } else if (i < this.bHf && this.bHc.getVisibility() != 0) {
                Xj();
            }
            this.bHf = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bHh) {
            if (this.aum) {
                dn(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bHf) {
                    Xf();
                } else if (firstVisiblePosition < this.bHf) {
                    Xe();
                } else if (firstVisiblePosition == this.bHf) {
                    if (!this.bHg || b(absListView)) {
                        Xe();
                    } else {
                        Xf();
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

    private void Xk() {
        if (this.bHd != null) {
            if (this.bHe && this.bHd.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHd.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHd.setLayoutParams(layoutParams);
                dn(true);
                return;
            }
            dn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(boolean z) {
        if (this.bHd != null) {
            if (this.bHe && z && this.bHd.getVisibility() != 0) {
                this.bHd.setVisibility(0);
            } else if (!z && this.bHd.getVisibility() != 8) {
                this.bHd.setVisibility(8);
            }
        }
    }
}
