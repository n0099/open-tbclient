package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a {
    private View bGN;
    private Animation bIs;
    private Animation bIt;
    private View csx;
    private Context mContext;
    private int aLv = 0;
    private boolean bIA = false;
    private final Handler.Callback bIB = new b(this);
    private final Handler mHandler = new Handler(this.bIB);
    private boolean bIy = UtilHelper.canUseStyleImmersiveSticky();

    public void dq(boolean z) {
        this.bIA = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.csx = view;
        this.bGN = view2;
        XD();
        ds(false);
    }

    private void Xs() {
        this.bIs = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_out);
        this.bIs.setAnimationListener(new c(this));
    }

    private void Xt() {
        this.bIt = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_in);
        this.bIt.setAnimationListener(new d(this));
    }

    public void Xu() {
        k(false, false);
    }

    public void Xv() {
        k(false, true);
    }

    public void k(boolean z, boolean z2) {
        if (this.csx != null && this.csx.getVisibility() == 0 && !XA()) {
            if (z2) {
                this.csx.setVisibility(8);
                return;
            }
            if (this.bIs == null) {
                Xs();
            }
            this.csx.startAnimation(this.bIs);
        }
    }

    public void Xw() {
        if (this.csx != null && this.csx.getVisibility() != 0 && !XA()) {
            this.csx.setVisibility(0);
            if (this.bIt == null) {
                Xt();
            }
            this.csx.startAnimation(this.bIt);
        }
    }

    public void Xx() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xy() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xz() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean XA() {
        return ac(this.csx);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void ex(boolean z) {
        if (this.csx != null) {
            if (z || this.csx.getVisibility() != 8) {
                Xy();
            }
        }
    }

    public void ey(boolean z) {
        if (this.csx != null) {
            if (z || this.csx.getVisibility() != 0) {
                Xx();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.csx != null) {
            if (i != 0 && i2 > i && this.csx.getVisibility() != 8) {
                ex(false);
            } else if ((i == 0 || i2 < i) && this.csx.getVisibility() != 0) {
                ey(false);
            }
            this.aLv = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aLv) {
                ex(true);
            } else if (firstVisiblePosition < this.aLv) {
                ey(true);
            } else if (firstVisiblePosition == this.aLv) {
                if (firstVisiblePosition == 0 || !this.bIA) {
                    ey(true);
                } else {
                    ex(true);
                }
            }
        }
    }

    private void XD() {
        if (this.bGN != null) {
            if (this.bIy && this.bGN.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bGN.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bGN.setLayoutParams(layoutParams);
                ds(true);
                return;
            }
            ds(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(boolean z) {
        if (this.bGN != null) {
            if (this.bIy && z && this.bGN.getVisibility() != 0) {
                this.bGN.setVisibility(0);
            } else if (!z && this.bGN.getVisibility() != 8) {
                this.bGN.setVisibility(8);
            }
        }
    }
}
