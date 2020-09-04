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
    private ViewGroup hXK;
    private q hXL;
    private com.baidu.tieba.frs.vc.h hXM;
    private com.baidu.tieba.f.b hXQ;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int eVE = 0;
    private int hXN = 0;
    private boolean hXO = true;
    private boolean hXP = true;
    private boolean eVF = false;
    private final Handler.Callback hXR = new Handler.Callback() { // from class: com.baidu.tieba.frs.ax.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ax.this.cok()) {
                ax.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ax.this.coi();
                    return true;
                case 2:
                    ax.this.cog();
                    return true;
                case 3:
                    ax.this.coh();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hXR);
    private a.InterfaceC0674a hrF = new a.InterfaceC0674a() { // from class: com.baidu.tieba.frs.ax.2
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            if (al(i2)) {
                ax.this.oB(true);
                ax.this.hideFloatingView();
            }
            if (ax.this.hXL != null) {
                ax.this.hXL.ou(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            if (al(i2)) {
                ax.this.oB(false);
                ax.this.showFloatingView();
            }
            if (ax.this.hXL != null) {
                ax.this.hXL.ou(true);
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
    private boolean boG = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cof() {
        return this.hXQ;
    }

    public void oB(boolean z) {
        this.eVF = z;
    }

    public void oC(boolean z) {
        this.hXO = z;
    }

    public ax(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hXL = qVar;
        this.mNavigationBar = qVar.bJI();
        this.hXK = qVar.cmN();
        this.hXM = hVar;
        Oo();
        this.hXQ = new com.baidu.tieba.f.b(context);
        this.hXQ.a(this.hrF);
    }

    public void cog() {
        V(false, false);
    }

    public void coh() {
        V(false, true);
    }

    public void V(boolean z, boolean z2) {
        if (this.hXK != null && this.hXL != null && this.hXL.cmX() != null && this.hXL.cmX().cpR()) {
            U(false, true);
        }
    }

    public void coi() {
        if (this.hXK != null && this.hXL != null && this.hXL.cmX() != null && !this.hXL.cmX().cpR()) {
            U(true, true);
        }
    }

    public void bvF() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bvG() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void coj() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cok() {
        return cf(this.hXK);
    }

    private boolean cf(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void U(boolean z, boolean z2) {
        if (this.hXL != null) {
            this.hXL.U(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hXO && this.hXP && this.hXK != null && this.eVE >= this.hXN) {
            bvG();
        }
    }

    public void showFloatingView() {
        if (this.hXO && this.hXP && this.hXK != null) {
            bvF();
        }
    }

    private void Oo() {
        if (this.hXL != null && this.hXL.Ot() != null) {
            View Ot = this.hXL.Ot();
            if (this.boG && Ot.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Ot.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Ot.setLayoutParams(layoutParams);
                cy(true);
                return;
            }
            cy(false);
        }
    }

    private void cy(boolean z) {
        if (this.hXL != null && this.hXL.Ot() != null) {
            View Ot = this.hXL.Ot();
            if (this.boG && z && Ot.getVisibility() != 0) {
                Ot.setVisibility(0);
            } else if (!z && Ot.getVisibility() != 8) {
                Ot.setVisibility(8);
            }
        }
    }
}
