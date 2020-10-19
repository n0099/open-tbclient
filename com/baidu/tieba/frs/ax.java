package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f.a;
/* loaded from: classes22.dex */
public class ax {
    private ViewGroup itL;
    private q itM;
    private com.baidu.tieba.frs.vc.h itN;
    private com.baidu.tieba.f.b itR;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fkH = 0;
    private int itO = 0;
    private boolean itP = true;
    private boolean itQ = true;
    private boolean fkI = false;
    private final Handler.Callback itS = new Handler.Callback() { // from class: com.baidu.tieba.frs.ax.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ax.this.cuV()) {
                ax.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ax.this.cuT();
                    return true;
                case 2:
                    ax.this.cuR();
                    return true;
                case 3:
                    ax.this.cuS();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.itS);
    private a.InterfaceC0689a hNF = new a.InterfaceC0689a() { // from class: com.baidu.tieba.frs.ax.2
        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void H(int i, int i2) {
            if (ar(i2)) {
                ax.this.pm(true);
                ax.this.hideFloatingView();
            }
            if (ax.this.itM != null) {
                ax.this.itM.pf(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void I(int i, int i2) {
            if (ar(i2)) {
                ax.this.pm(false);
                ax.this.showFloatingView();
            }
            if (ax.this.itM != null) {
                ax.this.itM.pf(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void J(int i, int i2) {
        }

        private boolean ar(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bvD = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cuQ() {
        return this.itR;
    }

    public void pm(boolean z) {
        this.fkI = z;
    }

    public void pn(boolean z) {
        this.itP = z;
    }

    public ax(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.itM = qVar;
        this.mNavigationBar = qVar.bNC();
        this.itL = qVar.ctx();
        this.itN = hVar;
        PW();
        this.itR = new com.baidu.tieba.f.b(context);
        this.itR.a(this.hNF);
    }

    public void cuR() {
        W(false, false);
    }

    public void cuS() {
        W(false, true);
    }

    public void W(boolean z, boolean z2) {
        if (this.itL != null && this.itM != null && this.itM.ctH() != null && this.itM.ctH().cwB()) {
            V(false, true);
        }
    }

    public void cuT() {
        if (this.itL != null && this.itM != null && this.itM.ctH() != null && !this.itM.ctH().cwB()) {
            V(true, true);
        }
    }

    public void bzy() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bzz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cuU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cuV() {
        return cs(this.itL);
    }

    private boolean cs(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void V(boolean z, boolean z2) {
        if (this.itM != null) {
            this.itM.V(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.itP && this.itQ && this.itL != null && this.fkH >= this.itO) {
            bzz();
        }
    }

    public void showFloatingView() {
        if (this.itP && this.itQ && this.itL != null) {
            bzy();
        }
    }

    private void PW() {
        if (this.itM != null && this.itM.Qb() != null) {
            View Qb = this.itM.Qb();
            if (this.bvD && Qb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Qb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Qb.setLayoutParams(layoutParams);
                cC(true);
                return;
            }
            cC(false);
        }
    }

    private void cC(boolean z) {
        if (this.itM != null && this.itM.Qb() != null) {
            View Qb = this.itM.Qb();
            if (this.bvD && z && Qb.getVisibility() != 0) {
                Qb.setVisibility(0);
            } else if (!z && Qb.getVisibility() != 8) {
                Qb.setVisibility(8);
            }
        }
    }
}
