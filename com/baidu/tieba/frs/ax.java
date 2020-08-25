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
/* loaded from: classes16.dex */
public class ax {
    private ViewGroup hXE;
    private q hXF;
    private com.baidu.tieba.frs.vc.h hXG;
    private com.baidu.tieba.f.b hXK;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int eVA = 0;
    private int hXH = 0;
    private boolean hXI = true;
    private boolean hXJ = true;
    private boolean eVB = false;
    private final Handler.Callback hXL = new Handler.Callback() { // from class: com.baidu.tieba.frs.ax.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ax.this.coj()) {
                ax.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ax.this.coh();
                    return true;
                case 2:
                    ax.this.cof();
                    return true;
                case 3:
                    ax.this.cog();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hXL);
    private a.InterfaceC0674a hrz = new a.InterfaceC0674a() { // from class: com.baidu.tieba.frs.ax.2
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            if (al(i2)) {
                ax.this.oz(true);
                ax.this.hideFloatingView();
            }
            if (ax.this.hXF != null) {
                ax.this.hXF.os(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            if (al(i2)) {
                ax.this.oz(false);
                ax.this.showFloatingView();
            }
            if (ax.this.hXF != null) {
                ax.this.hXF.os(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }

        private boolean al(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean boD = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b coe() {
        return this.hXK;
    }

    public void oz(boolean z) {
        this.eVB = z;
    }

    public void oA(boolean z) {
        this.hXI = z;
    }

    public ax(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hXF = qVar;
        this.mNavigationBar = qVar.bJH();
        this.hXE = qVar.cmM();
        this.hXG = hVar;
        Oo();
        this.hXK = new com.baidu.tieba.f.b(context);
        this.hXK.a(this.hrz);
    }

    public void cof() {
        V(false, false);
    }

    public void cog() {
        V(false, true);
    }

    public void V(boolean z, boolean z2) {
        if (this.hXE != null && this.hXF != null && this.hXF.cmW() != null && this.hXF.cmW().cpQ()) {
            U(false, true);
        }
    }

    public void coh() {
        if (this.hXE != null && this.hXF != null && this.hXF.cmW() != null && !this.hXF.cmW().cpQ()) {
            U(true, true);
        }
    }

    public void bvE() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bvF() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void coi() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean coj() {
        return cf(this.hXE);
    }

    private boolean cf(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void U(boolean z, boolean z2) {
        if (this.hXF != null) {
            this.hXF.U(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hXI && this.hXJ && this.hXE != null && this.eVA >= this.hXH) {
            bvF();
        }
    }

    public void showFloatingView() {
        if (this.hXI && this.hXJ && this.hXE != null) {
            bvE();
        }
    }

    private void Oo() {
        if (this.hXF != null && this.hXF.Ot() != null) {
            View Ot = this.hXF.Ot();
            if (this.boD && Ot.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Ot.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Ot.setLayoutParams(layoutParams);
                cx(true);
                return;
            }
            cx(false);
        }
    }

    private void cx(boolean z) {
        if (this.hXF != null && this.hXF.Ot() != null) {
            View Ot = this.hXF.Ot();
            if (this.boD && z && Ot.getVisibility() != 0) {
                Ot.setVisibility(0);
            } else if (!z && Ot.getVisibility() != 8) {
                Ot.setVisibility(8);
            }
        }
    }
}
