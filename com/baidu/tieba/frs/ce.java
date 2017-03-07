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
public class ce {
    private com.baidu.tbadk.util.e<Boolean> bNO;
    private Animation bQi;
    private Animation bQj;
    private ViewGroup bQk;
    private ax bQl;
    private com.baidu.tieba.frs.f.u bQm;
    private com.baidu.tieba.e.c bQp;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bHm = 0;
    private int bQn = 0;
    private boolean bHo = true;
    private boolean bQo = true;
    private boolean bHn = false;
    private final Handler.Callback bHp = new cf(this);
    private final Handler mHandler = new Handler(this.bHp);
    private a.InterfaceC0056a aQW = new cg(this);
    private boolean bHl = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.c aag() {
        return this.bQp;
    }

    public void dk(boolean z) {
        this.bHn = z;
    }

    public void dL(boolean z) {
        this.bHo = z;
    }

    public void dM(boolean z) {
        this.bQo = z;
    }

    public void a(com.baidu.tbadk.util.e<Boolean> eVar) {
        this.bNO = eVar;
    }

    public ce(Context context, ax axVar, com.baidu.tieba.frs.f.u uVar) {
        this.mContext = context;
        this.bQl = axVar;
        this.mNavigationBar = axVar.JT();
        this.bQk = axVar.Zk();
        this.bQm = uVar;
        WM();
        dl(false);
        this.bQp = new com.baidu.tieba.e.c(context);
        this.bQp.a(this.aQW);
    }

    private void WB() {
        this.bQi = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bQi.setAnimationListener(new ch(this));
    }

    private void WC() {
        this.bQj = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bQj.setAnimationListener(new ci(this));
    }

    public void WD() {
        l(false, false);
    }

    public void WE() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bQk != null && this.bQk.getVisibility() == 0 && !WJ()) {
            if (z2) {
                this.bQk.setVisibility(8);
                return;
            }
            if (this.bQi == null) {
                WB();
            }
            this.bQk.startAnimation(this.bQi);
            n(false, true);
        }
    }

    public void WF() {
        if (this.bQk != null && this.bQk.getVisibility() != 0 && !WJ()) {
            this.bQk.setVisibility(0);
            if (this.bQj == null) {
                WC();
            }
            this.bQk.startAnimation(this.bQj);
            n(true, true);
        }
    }

    public void WG() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void WH() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void WI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean WJ() {
        return af(this.bQk);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(boolean z, boolean z2) {
        if (this.bQl != null) {
            this.bQl.n(z, z2);
        }
    }

    public void WK() {
        if (this.bHo && this.bQo && this.bQk != null && this.bHm >= this.bQn && this.bQk.getVisibility() != 8) {
            WH();
        }
    }

    public void WL() {
        if (this.bHo && this.bQo && this.bQk != null && this.bQk.getVisibility() != 0) {
            WG();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bHo) {
            if (i > this.bHm && i > i4 && this.bQk.getVisibility() != 8) {
                WK();
            } else if (i < this.bHm && this.bQk.getVisibility() != 0) {
                WL();
            }
            n(i, z);
            this.bHm = i;
            this.bQn = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bHo && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.bHm && firstVisiblePosition > this.bQn) {
                WH();
            } else if (firstVisiblePosition < this.bHm) {
                WG();
            } else if (firstVisiblePosition == this.bHm) {
                if (!this.bHn || firstVisiblePosition <= this.bQn || b(absListView)) {
                    WG();
                } else {
                    WH();
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
        if (this.bHo && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bQm != null && this.bQm.adU() != null && this.bQm.adU().getView() != null) {
            int measuredHeight = this.bQm.adU().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bQm.adU().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    dN(false);
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                dN(false);
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                dN(true);
            }
            if ((z || i > this.bQn) && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                dN(true);
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void dN(boolean z) {
        if (this.bNO != null) {
            this.bNO.F(Boolean.valueOf(z));
        }
    }

    private void WM() {
        if (this.bQl != null && this.bQl.Zl() != null) {
            View Zl = this.bQl.Zl();
            if (this.bHl && Zl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Zl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Zl.setLayoutParams(layoutParams);
                dl(true);
                return;
            }
            dl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(boolean z) {
        if (this.bQl != null && this.bQl.Zl() != null) {
            View Zl = this.bQl.Zl();
            if (this.bHl && z && Zl.getVisibility() != 0) {
                Zl.setVisibility(0);
            } else if (!z && Zl.getVisibility() != 8) {
                Zl.setVisibility(8);
            }
        }
    }
}
