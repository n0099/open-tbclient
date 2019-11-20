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
/* loaded from: classes4.dex */
public class ak {
    private k fyA;
    private com.baidu.tieba.frs.vc.f fyB;
    private com.baidu.tieba.f.b fyF;
    private ViewGroup fyz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int cOv = 0;
    private int fyC = 0;
    private boolean fyD = true;
    private boolean fyE = true;
    private boolean cOw = false;
    private final Handler.Callback fyG = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.blN()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.blM();
                    return true;
                case 2:
                    ak.this.blK();
                    return true;
                case 3:
                    ak.this.blL();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fyG);
    private a.InterfaceC0405a eXk = new a.InterfaceC0405a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void t(int i, int i2) {
            if (aj(i2)) {
                ak.this.kc(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fyA != null) {
                ak.this.fyA.jU(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void u(int i, int i2) {
            if (aj(i2)) {
                ak.this.kc(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fyA != null) {
                ak.this.fyA.jU(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
        }

        private boolean aj(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean apk = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b blJ() {
        return this.fyF;
    }

    public void kc(boolean z) {
        this.cOw = z;
    }

    public void kd(boolean z) {
        this.fyD = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fyA = kVar;
        this.mNavigationBar = kVar.aKP();
        this.fyz = kVar.bky();
        this.fyB = fVar;
        vA();
        this.fyF = new com.baidu.tieba.f.b(context);
        this.fyF.a(this.eXk);
    }

    public void blK() {
        L(false, false);
    }

    public void blL() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.fyz != null && this.fyA != null && this.fyA.bkI() != null && this.fyA.bkI().bng()) {
            K(false, true);
        }
    }

    public void blM() {
        if (this.fyz != null && this.fyA != null && this.fyA.bkI() != null && !this.fyA.bkI().bng()) {
            K(true, true);
        }
    }

    public void axI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void axJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void axK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean blN() {
        return bO(this.fyz);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void K(boolean z, boolean z2) {
        if (this.fyA != null) {
            this.fyA.K(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fyD && this.fyE && this.fyz != null && this.cOv >= this.fyC) {
            axJ();
        }
    }

    public void showFloatingView() {
        if (this.fyD && this.fyE && this.fyz != null) {
            axI();
        }
    }

    private void vA() {
        if (this.fyA != null && this.fyA.vF() != null) {
            View vF = this.fyA.vF();
            if (this.apk && vF.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = vF.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                vF.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    private void aP(boolean z) {
        if (this.fyA != null && this.fyA.vF() != null) {
            View vF = this.fyA.vF();
            if (this.apk && z && vF.getVisibility() != 0) {
                vF.setVisibility(0);
            } else if (!z && vF.getVisibility() != 8) {
                vF.setVisibility(8);
            }
        }
    }
}
