package com.baidu.tieba.homepage.framework.b;

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
public class a {
    private View bJu;
    private Animation bSo;
    private Animation bSp;
    private View cyk;
    private Context mContext;
    private int bJw = 0;
    private boolean bJx = false;
    private final Handler.Callback bJz = new b(this);
    private final Handler mHandler = new Handler(this.bJz);
    private boolean bJv = UtilHelper.canUseStyleImmersiveSticky();

    public void dw(boolean z) {
        this.bJx = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cyk = view;
        this.bJu = view2;
        Yl();
        dx(false);
    }

    private void Ya() {
        this.bSo = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bSo.setAnimationListener(new c(this));
    }

    private void Yb() {
        this.bSp = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bSp.setAnimationListener(new d(this));
    }

    public void Yc() {
        l(false, false);
    }

    public void Yd() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.cyk != null && this.cyk.getVisibility() == 0 && !Yi()) {
            if (z2) {
                this.cyk.setVisibility(8);
                return;
            }
            if (this.bSo == null) {
                Ya();
            }
            this.cyk.startAnimation(this.bSo);
        }
    }

    public void Ye() {
        if (this.cyk != null && this.cyk.getVisibility() != 0 && !Yi()) {
            this.cyk.setVisibility(0);
            if (this.bSp == null) {
                Yb();
            }
            this.cyk.startAnimation(this.bSp);
        }
    }

    public void Yf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Yg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Yh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Yi() {
        return af(this.cyk);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void eZ(boolean z) {
        if (this.cyk != null) {
            if (z || this.cyk.getVisibility() != 8) {
                Yg();
            }
        }
    }

    public void fa(boolean z) {
        if (this.cyk != null) {
            if (z || this.cyk.getVisibility() != 0) {
                Yf();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cyk != null) {
            if (i != 0 && i2 > i && this.cyk.getVisibility() != 8) {
                eZ(false);
            } else if ((i == 0 || i2 < i) && this.cyk.getVisibility() != 0) {
                fa(false);
            }
            this.bJw = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bJw) {
                eZ(true);
            } else if (firstVisiblePosition < this.bJw) {
                fa(true);
            } else if (firstVisiblePosition == this.bJw) {
                if (firstVisiblePosition == 0 || !this.bJx) {
                    fa(true);
                } else {
                    eZ(true);
                }
            }
        }
    }

    private void Yl() {
        if (this.bJu != null) {
            if (this.bJv && this.bJu.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bJu.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bJu.setLayoutParams(layoutParams);
                dx(true);
                return;
            }
            dx(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(boolean z) {
        if (this.bJu != null) {
            if (this.bJv && z && this.bJu.getVisibility() != 0) {
                this.bJu.setVisibility(0);
            } else if (!z && this.bJu.getVisibility() != 8) {
                this.bJu.setVisibility(8);
            }
        }
    }
}
