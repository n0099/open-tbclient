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
    private com.baidu.tbadk.util.e<Boolean> bPU;
    private Animation bSo;
    private Animation bSp;
    private ViewGroup bSq;
    private az bSr;
    private com.baidu.tieba.frs.g.u bSs;
    private com.baidu.tieba.e.c bSv;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bJw = 0;
    private int bSt = 0;
    private boolean bJy = true;
    private boolean bSu = true;
    private boolean bJx = false;
    private final Handler.Callback bJz = new ch(this);
    private final Handler mHandler = new Handler(this.bJz);
    private a.InterfaceC0055a aRo = new ci(this);
    private boolean bJv = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.c abF() {
        return this.bSv;
    }

    public void dw(boolean z) {
        this.bJx = z;
    }

    public void dX(boolean z) {
        this.bJy = z;
    }

    public void dY(boolean z) {
        this.bSu = z;
    }

    public void a(com.baidu.tbadk.util.e<Boolean> eVar) {
        this.bPU = eVar;
    }

    public cg(Context context, az azVar, com.baidu.tieba.frs.g.u uVar) {
        this.mContext = context;
        this.bSr = azVar;
        this.mNavigationBar = azVar.Kt();
        this.bSq = azVar.aaJ();
        this.bSs = uVar;
        Yl();
        dx(false);
        this.bSv = new com.baidu.tieba.e.c(context);
        this.bSv.a(this.aRo);
    }

    private void Ya() {
        this.bSo = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bSo.setAnimationListener(new cj(this));
    }

    private void Yb() {
        this.bSp = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bSp.setAnimationListener(new ck(this));
    }

    public void Yc() {
        l(false, false);
    }

    public void Yd() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bSq != null && this.bSq.getVisibility() == 0 && !Yi()) {
            if (z2) {
                this.bSq.setVisibility(8);
                return;
            }
            if (this.bSo == null) {
                Ya();
            }
            this.bSq.startAnimation(this.bSo);
            n(false, true);
        }
    }

    public void Ye() {
        if (this.bSq != null && this.bSq.getVisibility() != 0 && !Yi()) {
            this.bSq.setVisibility(0);
            if (this.bSp == null) {
                Yb();
            }
            this.bSq.startAnimation(this.bSp);
            n(true, true);
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
        return af(this.bSq);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(boolean z, boolean z2) {
        if (this.bSr != null) {
            this.bSr.n(z, z2);
        }
    }

    public void Yj() {
        if (this.bJy && this.bSu && this.bSq != null && this.bJw >= this.bSt && this.bSq.getVisibility() != 8) {
            Yg();
        }
    }

    public void Yk() {
        if (this.bJy && this.bSu && this.bSq != null && this.bSq.getVisibility() != 0) {
            Yf();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bJy) {
            if (i > this.bJw && i > i4 && this.bSq.getVisibility() != 8) {
                Yj();
            } else if (i < this.bJw && this.bSq.getVisibility() != 0) {
                Yk();
            }
            n(i, z);
            this.bJw = i;
            this.bSt = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bJy && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.bJw && firstVisiblePosition > this.bSt) {
                Yg();
            } else if (firstVisiblePosition < this.bJw) {
                Yf();
            } else if (firstVisiblePosition == this.bJw) {
                if (!this.bJx || firstVisiblePosition <= this.bSt || b(absListView)) {
                    Yf();
                } else {
                    Yg();
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
        if (this.bJy && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bSs != null && this.bSs.aeQ() != null && this.bSs.aeQ().getView() != null) {
            int measuredHeight = this.bSs.aeQ().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bSs.aeQ().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    dZ(false);
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                dZ(false);
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                dZ(true);
            }
            if ((z || i > this.bSt) && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                dZ(true);
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void dZ(boolean z) {
        if (this.bPU != null) {
            this.bPU.F(Boolean.valueOf(z));
        }
    }

    private void Yl() {
        if (this.bSr != null && this.bSr.aaK() != null) {
            View aaK = this.bSr.aaK();
            if (this.bJv && aaK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aaK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aaK.setLayoutParams(layoutParams);
                dx(true);
                return;
            }
            dx(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(boolean z) {
        if (this.bSr != null && this.bSr.aaK() != null) {
            View aaK = this.bSr.aaK();
            if (this.bJv && z && aaK.getVisibility() != 0) {
                aaK.setVisibility(0);
            } else if (!z && aaK.getVisibility() != 8) {
                aaK.setVisibility(8);
            }
        }
    }
}
