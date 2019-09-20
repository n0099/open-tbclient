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
    private com.baidu.tieba.f.b ebS;
    private ViewGroup fAb;
    private k fAc;
    private com.baidu.tieba.frs.vc.f fAd;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int cEg = 0;
    private int fAe = 0;
    private boolean fAg = true;
    private boolean fAh = true;
    private boolean cEh = false;
    private final Handler.Callback fAi = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.boL()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.boK();
                    return true;
                case 2:
                    ak.this.boI();
                    return true;
                case 3:
                    ak.this.boJ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fAi);
    private a.InterfaceC0316a ebT = new a.InterfaceC0316a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aY(int i, int i2) {
            if (ax(i2)) {
                ak.this.ko(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fAc != null) {
                ak.this.fAc.kg(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aZ(int i, int i2) {
            if (ax(i2)) {
                ak.this.ko(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fAc != null) {
                ak.this.fAc.kg(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void ba(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fAf = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b boH() {
        return this.ebS;
    }

    public void ko(boolean z) {
        this.cEh = z;
    }

    public void kp(boolean z) {
        this.fAg = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fAc = kVar;
        this.mNavigationBar = kVar.aLN();
        this.fAb = kVar.bnu();
        this.fAd = fVar;
        aKG();
        this.ebS = new com.baidu.tieba.f.b(context);
        this.ebS.a(this.ebT);
    }

    public void boI() {
        I(false, false);
    }

    public void boJ() {
        I(false, true);
    }

    public void I(boolean z, boolean z2) {
        if (this.fAb != null && this.fAc != null && this.fAc.bnF() != null && this.fAc.bnF().bqd()) {
            H(false, true);
        }
    }

    public void boK() {
        if (this.fAb != null && this.fAc != null && this.fAc.bnF() != null && !this.fAc.bnF().bqd()) {
            H(true, true);
        }
    }

    public void awH() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void awI() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean boL() {
        return bR(this.fAb);
    }

    private boolean bR(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void H(boolean z, boolean z2) {
        if (this.fAc != null) {
            this.fAc.H(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fAg && this.fAh && this.fAb != null && this.cEg >= this.fAe) {
            awI();
        }
    }

    public void showFloatingView() {
        if (this.fAg && this.fAh && this.fAb != null) {
            awH();
        }
    }

    private void aKG() {
        if (this.fAc != null && this.fAc.bnv() != null) {
            View bnv = this.fAc.bnv();
            if (this.fAf && bnv.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bnv.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bnv.setLayoutParams(layoutParams);
                kq(true);
                return;
            }
            kq(false);
        }
    }

    private void kq(boolean z) {
        if (this.fAc != null && this.fAc.bnv() != null) {
            View bnv = this.fAc.bnv();
            if (this.fAf && z && bnv.getVisibility() != 0) {
                bnv.setVisibility(0);
            } else if (!z && bnv.getVisibility() != 8) {
                bnv.setVisibility(8);
            }
        }
    }
}
