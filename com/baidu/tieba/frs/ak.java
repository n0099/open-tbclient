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
    private com.baidu.tieba.f.b eai;
    private ViewGroup fyo;
    private k fyp;
    private com.baidu.tieba.frs.vc.f fyq;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int cDp = 0;
    private int fyr = 0;
    private boolean fyt = true;
    private boolean fyu = true;
    private boolean cDq = false;
    private final Handler.Callback fyv = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.boa()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.bnZ();
                    return true;
                case 2:
                    ak.this.bnX();
                    return true;
                case 3:
                    ak.this.bnY();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fyv);
    private a.InterfaceC0305a eaj = new a.InterfaceC0305a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            if (ax(i2)) {
                ak.this.kl(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fyp != null) {
                ak.this.fyp.kd(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            if (ax(i2)) {
                ak.this.kl(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fyp != null) {
                ak.this.fyp.kd(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fys = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bnW() {
        return this.eai;
    }

    public void kl(boolean z) {
        this.cDq = z;
    }

    public void km(boolean z) {
        this.fyt = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fyp = kVar;
        this.mNavigationBar = kVar.aLj();
        this.fyo = kVar.bmJ();
        this.fyq = fVar;
        aKc();
        this.eai = new com.baidu.tieba.f.b(context);
        this.eai.a(this.eaj);
    }

    public void bnX() {
        I(false, false);
    }

    public void bnY() {
        I(false, true);
    }

    public void I(boolean z, boolean z2) {
        if (this.fyo != null && this.fyp != null && this.fyp.bmU() != null && this.fyp.bmU().bps()) {
            H(false, true);
        }
    }

    public void bnZ() {
        if (this.fyo != null && this.fyp != null && this.fyp.bmU() != null && !this.fyp.bmU().bps()) {
            H(true, true);
        }
    }

    public void awv() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aww() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awx() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean boa() {
        return bR(this.fyo);
    }

    private boolean bR(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void H(boolean z, boolean z2) {
        if (this.fyp != null) {
            this.fyp.H(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fyt && this.fyu && this.fyo != null && this.cDp >= this.fyr) {
            aww();
        }
    }

    public void showFloatingView() {
        if (this.fyt && this.fyu && this.fyo != null) {
            awv();
        }
    }

    private void aKc() {
        if (this.fyp != null && this.fyp.bmK() != null) {
            View bmK = this.fyp.bmK();
            if (this.fys && bmK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bmK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bmK.setLayoutParams(layoutParams);
                kn(true);
                return;
            }
            kn(false);
        }
    }

    private void kn(boolean z) {
        if (this.fyp != null && this.fyp.bmK() != null) {
            View bmK = this.fyp.bmK();
            if (this.fys && z && bmK.getVisibility() != 0) {
                bmK.setVisibility(0);
            } else if (!z && bmK.getVisibility() != 8) {
                bmK.setVisibility(8);
            }
        }
    }
}
