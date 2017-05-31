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
public class cb {
    private ViewGroup bWR;
    private au bWS;
    private com.baidu.tieba.frs.f.u bWT;
    private com.baidu.tieba.e.c bwH;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aJd = 0;
    private int bWU = 0;
    private boolean bOq = true;
    private boolean bWV = true;
    private boolean aJe = false;
    private final Handler.Callback bOr = new cc(this);
    private final Handler mHandler = new Handler(this.bOr);
    private a.InterfaceC0059a bwT = new cd(this);
    private boolean bOp = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.c abg() {
        return this.bwH;
    }

    public void dO(boolean z) {
        this.aJe = z;
    }

    public void ek(boolean z) {
        this.bOq = z;
    }

    public cb(Context context, au auVar, com.baidu.tieba.frs.f.u uVar) {
        this.mContext = context;
        this.bWS = auVar;
        this.mNavigationBar = auVar.aaU();
        this.bWR = auVar.aaz();
        this.bWT = uVar;
        Yf();
        dP(false);
        this.bwH = new com.baidu.tieba.e.c(context);
        this.bwH.a(this.bwT);
    }

    public void XZ() {
        n(false, false);
    }

    public void Ya() {
        n(false, true);
    }

    public void n(boolean z, boolean z2) {
        if (this.bWR != null && this.bWS != null && this.bWS.aaD() != null && this.bWS.aaD().abO()) {
            q(false, true);
        }
    }

    public void Yb() {
        if (this.bWR != null && this.bWS != null && this.bWS.aaD() != null && !this.bWS.aaD().abO()) {
            q(true, true);
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
        return ad(this.bWR);
    }

    private boolean ad(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void q(boolean z, boolean z2) {
        if (this.bWS != null) {
            this.bWS.q(z, z2);
        }
    }

    public void Yd() {
        if (this.bOq && this.bWV && this.bWR != null && this.aJd >= this.bWU && this.bWR.getVisibility() != 8) {
            Gt();
        }
    }

    public void Ye() {
        if (this.bOq && this.bWV && this.bWR != null && this.bWR.getVisibility() != 0) {
            Gs();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bOq) {
            if (i > this.aJd && i > i4 && this.bWR.getVisibility() != 8) {
                Yd();
            } else if (i < this.aJd && this.bWR.getVisibility() != 0) {
                Ye();
            }
            this.aJd = i;
            this.bWU = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bOq && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aJd && firstVisiblePosition > this.bWU) {
                Gt();
            } else if (firstVisiblePosition < this.aJd) {
                Gs();
            } else if (firstVisiblePosition == this.aJd) {
                if (!this.aJe || firstVisiblePosition <= this.bWU || a(absListView)) {
                    Gs();
                } else {
                    Gt();
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
        if (this.bWS != null && this.bWS.aaA() != null) {
            View aaA = this.bWS.aaA();
            if (this.bOp && aaA.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aaA.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aaA.setLayoutParams(layoutParams);
                dP(true);
                return;
            }
            dP(false);
        }
    }

    private void dP(boolean z) {
        if (this.bWS != null && this.bWS.aaA() != null) {
            View aaA = this.bWS.aaA();
            if (this.bOp && z && aaA.getVisibility() != 0) {
                aaA.setVisibility(0);
            } else if (!z && aaA.getVisibility() != 8) {
                aaA.setVisibility(8);
            }
        }
    }
}
