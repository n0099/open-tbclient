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
public class cc {
    private ViewGroup ceZ;
    private av cfa;
    private com.baidu.tieba.frs.f.m cfb;
    private com.baidu.tieba.e.c cfe;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aKs = 0;
    private int cfc = 0;
    private boolean bVl = true;
    private boolean cfd = true;
    private boolean aKt = false;
    private final Handler.Callback bVm = new cd(this);
    private final Handler mHandler = new Handler(this.bVm);
    private a.InterfaceC0062a bQR = new ce(this);
    private boolean bVk = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.c aeX() {
        return this.cfe;
    }

    public void ee(boolean z) {
        this.aKt = z;
    }

    public void eC(boolean z) {
        this.bVl = z;
    }

    public cc(Context context, av avVar, com.baidu.tieba.frs.f.m mVar) {
        this.mContext = context;
        this.cfa = avVar;
        this.mNavigationBar = avVar.aeL();
        this.ceZ = avVar.aep();
        this.cfb = mVar;
        abE();
        ef(false);
        this.cfe = new com.baidu.tieba.e.c(context);
        this.cfe.a(this.bQR);
    }

    public void abA() {
        o(false, false);
    }

    public void abB() {
        o(false, true);
    }

    public void o(boolean z, boolean z2) {
        if (this.ceZ != null && this.cfa != null && this.cfa.aet() != null && this.cfa.aet().afF()) {
            r(false, true);
        }
    }

    public void abC() {
        if (this.ceZ != null && this.cfa != null && this.cfa.aet() != null && !this.cfa.aet().afF()) {
            r(true, true);
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
        return ae(this.ceZ);
    }

    private boolean ae(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void r(boolean z, boolean z2) {
        if (this.cfa != null) {
            this.cfa.r(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.bVl && this.cfd && this.ceZ != null && this.aKs >= this.cfc && this.ceZ.getVisibility() != 8) {
            GQ();
        }
    }

    public void showFloatingView() {
        if (this.bVl && this.cfd && this.ceZ != null && this.ceZ.getVisibility() != 0) {
            GP();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bVl) {
            if (i > this.aKs && i > i4 && this.ceZ.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aKs && this.ceZ.getVisibility() != 0) {
                showFloatingView();
            }
            this.aKs = i;
            this.cfc = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bVl && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aKs && firstVisiblePosition > this.cfc) {
                GQ();
            } else if (firstVisiblePosition < this.aKs) {
                GP();
            } else if (firstVisiblePosition == this.aKs) {
                if (!this.aKt || firstVisiblePosition <= this.cfc || a(absListView)) {
                    GP();
                } else {
                    GQ();
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
        if (this.cfa != null && this.cfa.aeq() != null) {
            View aeq = this.cfa.aeq();
            if (this.bVk && aeq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aeq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aeq.setLayoutParams(layoutParams);
                ef(true);
                return;
            }
            ef(false);
        }
    }

    private void ef(boolean z) {
        if (this.cfa != null && this.cfa.aeq() != null) {
            View aeq = this.cfa.aeq();
            if (this.bVk && z && aeq.getVisibility() != 0) {
                aeq.setVisibility(0);
            } else if (!z && aeq.getVisibility() != 8) {
                aeq.setVisibility(8);
            }
        }
    }
}
