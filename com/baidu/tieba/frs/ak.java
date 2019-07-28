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
    private com.baidu.tieba.f.b eab;
    private ViewGroup fxP;
    private k fxQ;
    private com.baidu.tieba.frs.vc.f fxR;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int cDi = 0;
    private int fxS = 0;
    private boolean fxU = true;
    private boolean fxV = true;
    private boolean cDj = false;
    private final Handler.Callback fxW = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.bnQ()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.bnP();
                    return true;
                case 2:
                    ak.this.bnN();
                    return true;
                case 3:
                    ak.this.bnO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fxW);
    private a.InterfaceC0305a eac = new a.InterfaceC0305a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            if (ax(i2)) {
                ak.this.kl(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fxQ != null) {
                ak.this.fxQ.kd(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            if (ax(i2)) {
                ak.this.kl(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fxQ != null) {
                ak.this.fxQ.kd(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fxT = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bnM() {
        return this.eab;
    }

    public void kl(boolean z) {
        this.cDj = z;
    }

    public void km(boolean z) {
        this.fxU = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fxQ = kVar;
        this.mNavigationBar = kVar.aLh();
        this.fxP = kVar.bmz();
        this.fxR = fVar;
        aKa();
        this.eab = new com.baidu.tieba.f.b(context);
        this.eab.a(this.eac);
    }

    public void bnN() {
        I(false, false);
    }

    public void bnO() {
        I(false, true);
    }

    public void I(boolean z, boolean z2) {
        if (this.fxP != null && this.fxQ != null && this.fxQ.bmK() != null && this.fxQ.bmK().bpf()) {
            H(false, true);
        }
    }

    public void bnP() {
        if (this.fxP != null && this.fxQ != null && this.fxQ.bmK() != null && !this.fxQ.bmK().bpf()) {
            H(true, true);
        }
    }

    public void awt() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void awu() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awv() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bnQ() {
        return bQ(this.fxP);
    }

    private boolean bQ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void H(boolean z, boolean z2) {
        if (this.fxQ != null) {
            this.fxQ.H(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fxU && this.fxV && this.fxP != null && this.cDi >= this.fxS) {
            awu();
        }
    }

    public void showFloatingView() {
        if (this.fxU && this.fxV && this.fxP != null) {
            awt();
        }
    }

    private void aKa() {
        if (this.fxQ != null && this.fxQ.bmA() != null) {
            View bmA = this.fxQ.bmA();
            if (this.fxT && bmA.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bmA.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bmA.setLayoutParams(layoutParams);
                kn(true);
                return;
            }
            kn(false);
        }
    }

    private void kn(boolean z) {
        if (this.fxQ != null && this.fxQ.bmA() != null) {
            View bmA = this.fxQ.bmA();
            if (this.fxT && z && bmA.getVisibility() != 0) {
                bmA.setVisibility(0);
            } else if (!z && bmA.getVisibility() != 8) {
                bmA.setVisibility(8);
            }
        }
    }
}
