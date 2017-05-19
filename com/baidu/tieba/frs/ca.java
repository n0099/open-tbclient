package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class ca {
    private ViewGroup bRa;
    private at bRb;
    private com.baidu.tieba.frs.e.u bRc;
    private com.baidu.tieba.e.c bRf;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aJq = 0;
    private int bRd = 0;
    private boolean bIC = true;
    private boolean bRe = true;
    private boolean aJr = false;
    private final Handler.Callback bID = new cb(this);
    private final Handler mHandler = new Handler(this.bID);
    private a.InterfaceC0059a aRJ = new cc(this);
    private boolean bIB = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.c aae() {
        return this.bRf;
    }

    public void dx(boolean z) {
        this.aJr = z;
    }

    public void dU(boolean z) {
        this.bIC = z;
    }

    public ca(Context context, at atVar, com.baidu.tieba.frs.e.u uVar) {
        this.mContext = context;
        this.bRb = atVar;
        this.mNavigationBar = atVar.JH();
        this.bRa = atVar.Zw();
        this.bRc = uVar;
        Xc();
        dy(false);
        this.bRf = new com.baidu.tieba.e.c(context);
        this.bRf.a(this.aRJ);
    }

    public void WW() {
        l(false, false);
    }

    public void WX() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bRa != null && this.bRb != null && this.bRb.Zz() != null && this.bRb.Zz().aaK()) {
            n(false, true);
        }
    }

    public void WY() {
        if (this.bRa != null && this.bRb != null && this.bRb.Zz() != null && !this.bRb.Zz().aaK()) {
            n(true, true);
        }
    }

    public void Gy() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Gz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean WZ() {
        return ad(this.bRa);
    }

    private boolean ad(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(boolean z, boolean z2) {
        if (this.bRb != null) {
            this.bRb.n(z, z2);
        }
    }

    public void Xa() {
        if (this.bIC && this.bRe && this.bRa != null && this.aJq >= this.bRd && this.bRa.getVisibility() != 8) {
            Gz();
        }
    }

    public void Xb() {
        if (this.bIC && this.bRe && this.bRa != null && this.bRa.getVisibility() != 0) {
            Gy();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bIC) {
            if (i > this.aJq && i > i4 && this.bRa.getVisibility() != 8) {
                Xa();
            } else if (i < this.aJq && this.bRa.getVisibility() != 0) {
                Xb();
            }
            this.aJq = i;
            this.bRd = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bIC && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aJq && firstVisiblePosition > this.bRd) {
                Gz();
            } else if (firstVisiblePosition < this.aJq) {
                Gy();
            } else if (firstVisiblePosition == this.aJq) {
                if (!this.aJr || firstVisiblePosition <= this.bRd || a(absListView)) {
                    Gy();
                } else {
                    Gz();
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

    private void Xc() {
        if (this.bRb != null && this.bRb.Zx() != null) {
            View Zx = this.bRb.Zx();
            if (this.bIB && Zx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Zx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Zx.setLayoutParams(layoutParams);
                dy(true);
                return;
            }
            dy(false);
        }
    }

    private void dy(boolean z) {
        if (this.bRb != null && this.bRb.Zx() != null) {
            View Zx = this.bRb.Zx();
            if (this.bIB && z && Zx.getVisibility() != 0) {
                Zx.setVisibility(0);
            } else if (!z && Zx.getVisibility() != 8) {
                Zx.setVisibility(8);
            }
        }
    }
}
