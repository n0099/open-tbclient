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
import com.baidu.tieba.d.a;
import com.baidu.tieba.frs.acrossForum.j;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ch {
    private com.baidu.tbadk.util.e<Boolean> bSU;
    private au bVA;
    private com.baidu.tieba.frs.j.n bVB;
    private j.a bVE;
    private com.baidu.tieba.d.c bVF;
    private Animation bVx;
    private Animation bVy;
    private ViewGroup bVz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aTs = 0;
    private int bVC = 0;
    private boolean bMs = true;
    private boolean bVD = true;
    private boolean bMr = false;
    private final Handler.Callback bMt = new ci(this);
    private final Handler mHandler = new Handler(this.bMt);
    private a.InterfaceC0058a aMT = new cj(this);
    private boolean bMq = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.d.c adH() {
        return this.bVF;
    }

    public void dv(boolean z) {
        this.bMr = z;
    }

    public void dW(boolean z) {
        this.bMs = z;
    }

    public void dX(boolean z) {
        this.bVD = z;
    }

    public void a(com.baidu.tbadk.util.e<Boolean> eVar) {
        this.bSU = eVar;
    }

    public ch(Context context, au auVar, com.baidu.tieba.frs.j.n nVar) {
        this.mContext = context;
        this.bVA = auVar;
        this.mNavigationBar = auVar.JF();
        this.bVz = auVar.acH();
        this.bVB = nVar;
        aag();
        dw(false);
        this.bVF = new com.baidu.tieba.d.c(context);
        this.bVF.a(this.aMT);
    }

    public void a(j.a aVar) {
        this.bVE = aVar;
    }

    private void ZV() {
        this.bVx = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bVx.setAnimationListener(new ck(this));
    }

    private void ZW() {
        this.bVy = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bVy.setAnimationListener(new cl(this));
    }

    public void ZX() {
        l(false, false);
    }

    public void ZY() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bVz != null && this.bVz.getVisibility() == 0 && !aad()) {
            if (z2) {
                this.bVz.setVisibility(8);
                return;
            }
            if (this.bVx == null) {
                ZV();
            }
            this.bVz.startAnimation(this.bVx);
            n(false, true);
        }
    }

    public void ZZ() {
        if (this.bVz != null && this.bVz.getVisibility() != 0 && !aad()) {
            if (this.bVE != null) {
                this.bVE.z(this.bVz);
            }
            this.bVz.setVisibility(0);
            if (this.bVy == null) {
                ZW();
            }
            this.bVz.startAnimation(this.bVy);
            n(true, true);
        }
    }

    public void aaa() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aab() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aac() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aad() {
        return ac(this.bVz);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(boolean z, boolean z2) {
        if (this.bVA != null) {
            this.bVA.n(z, z2);
        }
    }

    public void aae() {
        if (this.bMs && this.bVD && this.bVz != null && this.aTs >= this.bVC && this.bVz.getVisibility() != 8) {
            aab();
        }
    }

    public void aaf() {
        if (this.bMs && this.bVD && this.bVz != null && this.bVz.getVisibility() != 0) {
            aaa();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bMs) {
            if (i > this.aTs && i > i4 && this.bVz.getVisibility() != 8) {
                aae();
            } else if (i < this.aTs && this.bVz.getVisibility() != 0) {
                aaf();
            }
            B(i, z);
            this.aTs = i;
            this.bVC = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bMs && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aTs && firstVisiblePosition > this.bVC) {
                aab();
            } else if (firstVisiblePosition < this.aTs) {
                aaa();
            } else if (firstVisiblePosition == this.aTs) {
                if (!this.bMr || firstVisiblePosition <= this.bVC || b(absListView)) {
                    aaa();
                } else {
                    aab();
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

    private void B(int i, boolean z) {
        if (this.bMs && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bVB != null && this.bVB.ahq() != null && this.bVB.ahq().getView() != null) {
            int measuredHeight = this.bVB.ahq().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bVB.ahq().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    dY(false);
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                dY(false);
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                dY(true);
            }
            if ((z || i > this.bVC) && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                dY(true);
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void dY(boolean z) {
        if (this.bSU != null) {
            this.bSU.F(Boolean.valueOf(z));
        }
    }

    private void aag() {
        if (this.bVA != null && this.bVA.acI() != null) {
            View acI = this.bVA.acI();
            if (this.bMq && acI.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = acI.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                acI.setLayoutParams(layoutParams);
                dw(true);
                return;
            }
            dw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(boolean z) {
        if (this.bVA != null && this.bVA.acI() != null) {
            View acI = this.bVA.acI();
            if (this.bMq && z && acI.getVisibility() != 0) {
                acI.setVisibility(0);
            } else if (!z && acI.getVisibility() != 8) {
                acI.setVisibility(8);
            }
        }
    }
}
