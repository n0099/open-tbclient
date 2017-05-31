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
    private a bOk;
    private Animation bOl;
    private Animation bOm;
    private View bOn;
    private View bOo;
    private Context mContext;
    private boolean auc = false;
    private int aJd = 0;
    private boolean aJe = false;
    private boolean bOq = true;
    private final Handler.Callback bOr = new d(this);
    private final Handler mHandler = new Handler(this.bOr);
    private boolean bOp = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dQ(boolean z);
    }

    public void dO(boolean z) {
        this.aJe = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bOn = view;
        this.bOo = view2;
        Yf();
        dP(false);
    }

    private void XX() {
        this.bOl = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_out);
        this.bOl.setAnimationListener(new e(this));
    }

    private void XY() {
        this.bOm = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_in);
        this.bOm.setAnimationListener(new f(this));
    }

    public void XZ() {
        n(false, false);
    }

    public void Ya() {
        n(false, true);
    }

    public void n(boolean z, boolean z2) {
        if (this.bOn != null && this.bOn.getVisibility() == 0 && !Yc()) {
            if (z2) {
                this.bOn.setVisibility(8);
                return;
            }
            if (this.bOl == null) {
                XX();
            }
            if (this.bOm != null) {
                this.bOm.cancel();
            }
            this.bOn.startAnimation(this.bOl);
        }
    }

    public void Yb() {
        if (this.bOn != null && this.bOn.getVisibility() != 0 && !Yc()) {
            this.bOn.setVisibility(0);
            if (this.bOm == null) {
                XY();
            }
            if (this.bOl != null) {
                this.bOl.cancel();
            }
            this.bOn.startAnimation(this.bOm);
        }
    }

    public void Gs() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Gt() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Gu() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Yc() {
        return ad(this.bOn);
    }

    private boolean ad(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Yd() {
        if (this.bOq) {
            if (this.auc) {
                dP(true);
            } else if (this.bOn != null && this.bOn.getVisibility() != 8) {
                Gt();
            }
        }
    }

    public void Ye() {
        if (this.bOq) {
            if (this.auc) {
                dP(true);
            } else if (this.bOn != null && this.bOn.getVisibility() != 0) {
                Gs();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bOq && this.bOn != null) {
            if (i > this.aJd && this.bOn.getVisibility() != 8) {
                Yd();
            } else if (i < this.aJd && this.bOn.getVisibility() != 0) {
                Ye();
            }
            this.aJd = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bOq) {
            if (this.auc) {
                dP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aJd) {
                    Gt();
                } else if (firstVisiblePosition < this.aJd) {
                    Gs();
                } else if (firstVisiblePosition == this.aJd) {
                    if (!this.aJe || a(absListView)) {
                        Gs();
                    } else {
                        Gt();
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

    private void Yf() {
        if (this.bOo != null) {
            if (this.bOp && this.bOo.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bOo.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bOo.setLayoutParams(layoutParams);
                dP(true);
                return;
            }
            dP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(boolean z) {
        if (this.bOo != null) {
            if (this.bOp && z && this.bOo.getVisibility() != 0) {
                this.bOo.setVisibility(0);
            } else if (!z && this.bOo.getVisibility() != 8) {
                this.bOo.setVisibility(8);
            }
        }
    }
}
