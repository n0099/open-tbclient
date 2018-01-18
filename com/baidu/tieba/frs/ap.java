package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e.a;
/* loaded from: classes2.dex */
public class ap {
    private com.baidu.tieba.e.b ckL;
    private ViewGroup dDY;
    private k dDZ;
    private com.baidu.tieba.frs.f.f dEa;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bBi = 0;
    private int dEb = 0;
    private boolean dEd = true;
    private boolean dEe = true;
    private boolean bBj = false;
    private final Handler.Callback dEf = new Handler.Callback() { // from class: com.baidu.tieba.frs.ap.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ap.this.avr()) {
                ap.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ap.this.avq();
                    return true;
                case 2:
                    ap.this.avo();
                    return true;
                case 3:
                    ap.this.avp();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dEf);
    private a.InterfaceC0108a ckM = new a.InterfaceC0108a() { // from class: com.baidu.tieba.frs.ap.2
        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aY(int i, int i2) {
            if (Z(i2)) {
                ap.this.fM(false);
                ap.this.showFloatingView();
            }
            if (ap.this.dDZ != null) {
                ap.this.dDZ.fI(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aZ(int i, int i2) {
            if (Z(i2)) {
                ap.this.fM(true);
                ap.this.hideFloatingView();
            }
            if (ap.this.dDZ != null) {
                ap.this.dDZ.fI(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void ba(int i, int i2) {
        }

        private boolean Z(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dEc = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b avn() {
        return this.ckL;
    }

    public void fM(boolean z) {
        this.bBj = z;
    }

    public void fN(boolean z) {
        this.dEd = z;
    }

    public ap(Context context, k kVar, com.baidu.tieba.frs.f.f fVar) {
        this.mContext = context;
        this.dDZ = kVar;
        this.mNavigationBar = kVar.aup();
        this.dDY = kVar.auw();
        this.dEa = fVar;
        avs();
        this.ckL = new com.baidu.tieba.e.b(context);
        this.ckL.a(this.ckM);
    }

    public void avo() {
        y(false, false);
    }

    public void avp() {
        y(false, true);
    }

    public void y(boolean z, boolean z2) {
        if (this.dDY != null && this.dDZ != null && this.dDZ.auA() != null && this.dDZ.auA().awu()) {
            x(false, true);
        }
    }

    public void avq() {
        if (this.dDY != null && this.dDZ != null && this.dDZ.auA() != null && !this.dDZ.auA().awu()) {
            x(true, true);
        }
    }

    public void OB() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OC() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OD() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avr() {
        return bM(this.dDY);
    }

    private boolean bM(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void x(boolean z, boolean z2) {
        if (this.dDZ != null) {
            this.dDZ.x(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dEd && this.dEe && this.dDY != null && this.bBi >= this.dEb) {
            OC();
        }
    }

    public void showFloatingView() {
        if (this.dEd && this.dEe && this.dDY != null) {
            OB();
        }
    }

    private void avs() {
        if (this.dDZ != null && this.dDZ.aux() != null) {
            View aux = this.dDZ.aux();
            if (this.dEc && aux.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aux.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aux.setLayoutParams(layoutParams);
                fO(true);
                return;
            }
            fO(false);
        }
    }

    private void fO(boolean z) {
        if (this.dDZ != null && this.dDZ.aux() != null) {
            View aux = this.dDZ.aux();
            if (this.dEc && z && aux.getVisibility() != 0) {
                aux.setVisibility(0);
            } else if (!z && aux.getVisibility() != 8) {
                aux.setVisibility(8);
            }
        }
    }
}
