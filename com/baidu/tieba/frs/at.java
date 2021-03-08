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
/* loaded from: classes2.dex */
public class at {
    private ViewGroup jmU;
    private q jmV;
    private com.baidu.tieba.frs.vc.h jmW;
    private com.baidu.tieba.f.b jna;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fOI = 0;
    private int jmX = 0;
    private boolean jmY = true;
    private boolean jmZ = true;
    private boolean fOJ = false;
    private final Handler.Callback jnb = new Handler.Callback() { // from class: com.baidu.tieba.frs.at.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && at.this.cFa()) {
                at.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    at.this.cEY();
                    return true;
                case 2:
                    at.this.cEW();
                    return true;
                case 3:
                    at.this.cEX();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jnb);
    private a.InterfaceC0717a iHb = new a.InterfaceC0717a() { // from class: com.baidu.tieba.frs.at.2
        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void G(int i, int i2) {
            if (aH(i2)) {
                at.this.qR(true);
                at.this.hideFloatingView();
            }
            if (at.this.jmV != null) {
                at.this.jmV.qK(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void H(int i, int i2) {
            if (aH(i2)) {
                at.this.qR(false);
                at.this.showFloatingView();
            }
            if (at.this.jmV != null) {
                at.this.jmV.qK(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void I(int i, int i2) {
        }

        private boolean aH(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bMK = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cEV() {
        return this.jna;
    }

    public void qR(boolean z) {
        this.fOJ = z;
    }

    public void qS(boolean z) {
        this.jmY = z;
    }

    public at(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.jmV = qVar;
        this.mNavigationBar = qVar.bVq();
        this.jmU = qVar.cDC();
        this.jmW = hVar;
        Uk();
        this.jna = new com.baidu.tieba.f.b(context);
        this.jna.a(this.iHb);
    }

    public void cEW() {
        ab(false, false);
    }

    public void cEX() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.jmU != null && this.jmV != null && this.jmV.cDM() != null && this.jmV.cDM().cGO()) {
            aa(false, true);
        }
    }

    public void cEY() {
        if (this.jmU != null && this.jmV != null && this.jmV.cDM() != null && !this.jmV.cDM().cGO()) {
            aa(true, true);
        }
    }

    public void bFH() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFI() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cEZ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cFa() {
        return cU(this.jmU);
    }

    private boolean cU(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aa(boolean z, boolean z2) {
        if (this.jmV != null) {
            this.jmV.aa(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.jmY && this.jmZ && this.jmU != null && this.fOI >= this.jmX) {
            bFI();
        }
    }

    public void showFloatingView() {
        if (this.jmY && this.jmZ && this.jmU != null) {
            bFH();
        }
    }

    private void Uk() {
        if (this.jmV != null && this.jmV.Up() != null) {
            View Up = this.jmV.Up();
            if (this.bMK && Up.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Up.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Up.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    private void dm(boolean z) {
        if (this.jmV != null && this.jmV.Up() != null) {
            View Up = this.jmV.Up();
            if (this.bMK && z && Up.getVisibility() != 0) {
                Up.setVisibility(0);
            } else if (!z && Up.getVisibility() != 8) {
                Up.setVisibility(8);
            }
        }
    }
}
