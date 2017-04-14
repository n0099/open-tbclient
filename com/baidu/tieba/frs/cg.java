package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cg {
    private com.baidu.tbadk.util.e<Boolean> bND;
    private Animation bPX;
    private Animation bPY;
    private ViewGroup bPZ;
    private az bQa;
    private com.baidu.tieba.frs.g.u bQb;
    private com.baidu.tieba.e.c bQe;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bHf = 0;
    private int bQc = 0;
    private boolean bHh = true;
    private boolean bQd = true;
    private boolean bHg = false;
    private final Handler.Callback bHi = new ch(this);
    private final Handler mHandler = new Handler(this.bHi);
    private a.InterfaceC0055a aRm = new ci(this);
    private boolean bHe = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.c aaE() {
        return this.bQe;
    }

    public void dm(boolean z) {
        this.bHg = z;
    }

    public void dN(boolean z) {
        this.bHh = z;
    }

    public void dO(boolean z) {
        this.bQd = z;
    }

    public void a(com.baidu.tbadk.util.e<Boolean> eVar) {
        this.bND = eVar;
    }

    public cg(Context context, az azVar, com.baidu.tieba.frs.g.u uVar) {
        this.mContext = context;
        this.bQa = azVar;
        this.mNavigationBar = azVar.Kt();
        this.bPZ = azVar.ZI();
        this.bQb = uVar;
        Xk();
        dn(false);
        this.bQe = new com.baidu.tieba.e.c(context);
        this.bQe.a(this.aRm);
    }

    private void WZ() {
        this.bPX = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bPX.setAnimationListener(new cj(this));
    }

    private void Xa() {
        this.bPY = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bPY.setAnimationListener(new ck(this));
    }

    public void Xb() {
        l(false, false);
    }

    public void Xc() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bPZ != null && this.bPZ.getVisibility() == 0 && !Xh()) {
            if (z2) {
                this.bPZ.setVisibility(8);
                return;
            }
            if (this.bPX == null) {
                WZ();
            }
            this.bPZ.startAnimation(this.bPX);
            n(false, true);
        }
    }

    public void Xd() {
        if (this.bPZ != null && this.bPZ.getVisibility() != 0 && !Xh()) {
            this.bPZ.setVisibility(0);
            if (this.bPY == null) {
                Xa();
            }
            this.bPZ.startAnimation(this.bPY);
            n(true, true);
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
        return af(this.bPZ);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(boolean z, boolean z2) {
        if (this.bQa != null) {
            this.bQa.n(z, z2);
        }
    }

    public void Xi() {
        if (this.bHh && this.bQd && this.bPZ != null && this.bHf >= this.bQc && this.bPZ.getVisibility() != 8) {
            Xf();
        }
    }

    public void Xj() {
        if (this.bHh && this.bQd && this.bPZ != null && this.bPZ.getVisibility() != 0) {
            Xe();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bHh) {
            if (i > this.bHf && i > i4 && this.bPZ.getVisibility() != 8) {
                Xi();
            } else if (i < this.bHf && this.bPZ.getVisibility() != 0) {
                Xj();
            }
            n(i, z);
            this.bHf = i;
            this.bQc = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bHh && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.bHf && firstVisiblePosition > this.bQc) {
                Xf();
            } else if (firstVisiblePosition < this.bHf) {
                Xe();
            } else if (firstVisiblePosition == this.bHf) {
                if (!this.bHg || firstVisiblePosition <= this.bQc || b(absListView)) {
                    Xe();
                } else {
                    Xf();
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

    private void n(int i, boolean z) {
        if (this.bHh && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bQb != null && this.bQb.adP() != null && this.bQb.adP().getView() != null) {
            int measuredHeight = this.bQb.adP().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bQb.adP().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    dP(false);
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                dP(false);
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                dP(true);
            }
            if ((z || i > this.bQc) && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                dP(true);
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void dP(boolean z) {
        if (this.bND != null) {
            this.bND.F(Boolean.valueOf(z));
        }
    }

    private void Xk() {
        if (this.bQa != null && this.bQa.ZJ() != null) {
            View ZJ = this.bQa.ZJ();
            if (this.bHe && ZJ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = ZJ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                ZJ.setLayoutParams(layoutParams);
                dn(true);
                return;
            }
            dn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(boolean z) {
        if (this.bQa != null && this.bQa.ZJ() != null) {
            View ZJ = this.bQa.ZJ();
            if (this.bHe && z && ZJ.getVisibility() != 0) {
                ZJ.setVisibility(0);
            } else if (!z && ZJ.getVisibility() != 8) {
                ZJ.setVisibility(8);
            }
        }
    }
}
