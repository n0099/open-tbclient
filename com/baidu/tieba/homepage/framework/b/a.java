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
    private View bFz;
    private Animation bGW;
    private Animation bGX;
    private View cpS;
    private Context mContext;
    private int aKC = 0;
    private boolean bHe = false;
    private final Handler.Callback bHf = new b(this);
    private final Handler mHandler = new Handler(this.bHf);
    private boolean bHc = UtilHelper.canUseStyleImmersiveSticky();

    public void dt(boolean z) {
        this.bHe = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cpS = view;
        this.bFz = view2;
        Xl();
        dv(false);
    }

    private void Xa() {
        this.bGW = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_out);
        this.bGW.setAnimationListener(new c(this));
    }

    private void Xb() {
        this.bGX = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_in);
        this.bGX.setAnimationListener(new d(this));
    }

    public void Xc() {
        k(false, false);
    }

    public void Xd() {
        k(false, true);
    }

    public void k(boolean z, boolean z2) {
        if (this.cpS != null && this.cpS.getVisibility() == 0 && !Xi()) {
            if (z2) {
                this.cpS.setVisibility(8);
                return;
            }
            if (this.bGW == null) {
                Xa();
            }
            this.cpS.startAnimation(this.bGW);
        }
    }

    public void Xe() {
        if (this.cpS != null && this.cpS.getVisibility() != 0 && !Xi()) {
            this.cpS.setVisibility(0);
            if (this.bGX == null) {
                Xb();
            }
            this.cpS.startAnimation(this.bGX);
        }
    }

    public void Xf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Xi() {
        return ae(this.cpS);
    }

    private boolean ae(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void ew(boolean z) {
        if (this.cpS != null) {
            if (z || this.cpS.getVisibility() != 8) {
                Xg();
            }
        }
    }

    public void ex(boolean z) {
        if (this.cpS != null) {
            if (z || this.cpS.getVisibility() != 0) {
                Xf();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cpS != null) {
            if (i != 0 && i2 > i && this.cpS.getVisibility() != 8) {
                ew(false);
            } else if ((i == 0 || i2 < i) && this.cpS.getVisibility() != 0) {
                ex(false);
            }
            this.aKC = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aKC) {
                ew(true);
            } else if (firstVisiblePosition < this.aKC) {
                ex(true);
            } else if (firstVisiblePosition == this.aKC) {
                if (firstVisiblePosition == 0 || !this.bHe) {
                    ex(true);
                } else {
                    ew(true);
                }
            }
        }
    }

    private void Xl() {
        if (this.bFz != null) {
            if (this.bHc && this.bFz.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bFz.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bFz.setLayoutParams(layoutParams);
                dv(true);
                return;
            }
            dv(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(boolean z) {
        if (this.bFz != null) {
            if (this.bHc && z && this.bFz.getVisibility() != 0) {
                this.bFz.setVisibility(0);
            } else if (!z && this.bFz.getVisibility() != 8) {
                this.bFz.setVisibility(8);
            }
        }
    }
}
