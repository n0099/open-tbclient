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
import com.baidu.tieba.f.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ce {
    private com.baidu.tbadk.util.e<Boolean> bGF;
    private Animation bIZ;
    private Animation bJa;
    private ViewGroup bJb;
    private ax bJc;
    private com.baidu.tieba.frs.f.u bJd;
    private com.baidu.tieba.f.c bJg;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bAg = 0;
    private int bJe = 0;
    private boolean bAi = true;
    private boolean bJf = true;
    private boolean bAh = false;
    private final Handler.Callback bAj = new cf(this);
    private final Handler mHandler = new Handler(this.bAj);
    private a.InterfaceC0057a aLl = new cg(this);
    private boolean bAf = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.c Zh() {
        return this.bJg;
    }

    public void dk(boolean z) {
        this.bAh = z;
    }

    public void dL(boolean z) {
        this.bAi = z;
    }

    public void dM(boolean z) {
        this.bJf = z;
    }

    public void a(com.baidu.tbadk.util.e<Boolean> eVar) {
        this.bGF = eVar;
    }

    public ce(Context context, ax axVar, com.baidu.tieba.frs.f.u uVar) {
        this.mContext = context;
        this.bJc = axVar;
        this.mNavigationBar = axVar.Jo();
        this.bJb = axVar.Yl();
        this.bJd = uVar;
        VO();
        dl(false);
        this.bJg = new com.baidu.tieba.f.c(context);
        this.bJg.a(this.aLl);
    }

    private void VD() {
        this.bIZ = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bIZ.setAnimationListener(new ch(this));
    }

    private void VE() {
        this.bJa = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bJa.setAnimationListener(new ci(this));
    }

    public void VF() {
        m(false, false);
    }

    public void VG() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.bJb != null && this.bJb.getVisibility() == 0 && !VL()) {
            if (z2) {
                this.bJb.setVisibility(8);
                return;
            }
            if (this.bIZ == null) {
                VD();
            }
            this.bJb.startAnimation(this.bIZ);
            o(false, true);
        }
    }

    public void VH() {
        if (this.bJb != null && this.bJb.getVisibility() != 0 && !VL()) {
            this.bJb.setVisibility(0);
            if (this.bJa == null) {
                VE();
            }
            this.bJb.startAnimation(this.bJa);
            o(true, true);
        }
    }

    public void VI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void VJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void VK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean VL() {
        return ah(this.bJb);
    }

    private boolean ah(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void o(boolean z, boolean z2) {
        if (this.bJc != null) {
            this.bJc.o(z, z2);
        }
    }

    public void VM() {
        if (this.bAi && this.bJf && this.bJb != null && this.bAg >= this.bJe && this.bJb.getVisibility() != 8) {
            VJ();
        }
    }

    public void VN() {
        if (this.bAi && this.bJf && this.bJb != null && this.bJb.getVisibility() != 0) {
            VI();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bAi) {
            if (i > this.bAg && i > i4 && this.bJb.getVisibility() != 8) {
                VM();
            } else if (i < this.bAg && this.bJb.getVisibility() != 0) {
                VN();
            }
            n(i, z);
            this.bAg = i;
            this.bJe = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bAi && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.bAg && firstVisiblePosition > this.bJe) {
                VJ();
            } else if (firstVisiblePosition < this.bAg) {
                VI();
            } else if (firstVisiblePosition == this.bAg) {
                if (!this.bAh || firstVisiblePosition <= this.bJe || b(absListView)) {
                    VI();
                } else {
                    VJ();
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
        if (this.bAi && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bJd != null && this.bJd.acU() != null && this.bJd.acU().getView() != null) {
            int measuredHeight = this.bJd.acU().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bJd.acU().getView().getTop());
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
            if ((z || i > this.bJe) && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
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
        if (this.bGF != null) {
            this.bGF.F(Boolean.valueOf(z));
        }
    }

    private void VO() {
        if (this.bJc != null && this.bJc.Ym() != null) {
            View Ym = this.bJc.Ym();
            if (this.bAf && Ym.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Ym.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Ym.setLayoutParams(layoutParams);
                dl(true);
                return;
            }
            dl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(boolean z) {
        if (this.bJc != null && this.bJc.Ym() != null) {
            View Ym = this.bJc.Ym();
            if (this.bAf && z && Ym.getVisibility() != 0) {
                Ym.setVisibility(0);
            } else if (!z && Ym.getVisibility() != 8) {
                Ym.setVisibility(8);
            }
        }
    }
}
