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
/* loaded from: classes6.dex */
public class an {
    private com.baidu.tieba.f.b cwP;
    private ViewGroup dOu;
    private k dOv;
    private com.baidu.tieba.frs.vc.f dOw;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int biM = 0;
    private int dOx = 0;
    private boolean dOz = true;
    private boolean dOA = true;
    private boolean biN = false;
    private final Handler.Callback dOB = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.aDt()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aDs();
                    return true;
                case 2:
                    an.this.aDq();
                    return true;
                case 3:
                    an.this.aDr();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dOB);
    private a.InterfaceC0214a cwQ = new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (ag(i2)) {
                an.this.gQ(false);
                an.this.showFloatingView();
            }
            if (an.this.dOv != null) {
                an.this.dOv.gH(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (ag(i2)) {
                an.this.gQ(true);
                an.this.hideFloatingView();
            }
            if (an.this.dOv != null) {
                an.this.dOv.gH(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dOy = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aDp() {
        return this.cwP;
    }

    public void gQ(boolean z) {
        this.biN = z;
    }

    public void gR(boolean z) {
        this.dOz = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dOv = kVar;
        this.mNavigationBar = kVar.abW();
        this.dOu = kVar.aCb();
        this.dOw = fVar;
        aaQ();
        this.cwP = new com.baidu.tieba.f.b(context);
        this.cwP.a(this.cwQ);
    }

    public void aDq() {
        C(false, false);
    }

    public void aDr() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.dOu != null && this.dOv != null && this.dOv.aCn() != null && this.dOv.aCn().aEL()) {
            B(false, true);
        }
    }

    public void aDs() {
        if (this.dOu != null && this.dOv != null && this.dOv.aCn() != null && !this.dOv.aCn().aEL()) {
            B(true, true);
        }
    }

    public void Qc() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qd() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qe() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aDt() {
        return aO(this.dOu);
    }

    private boolean aO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void B(boolean z, boolean z2) {
        if (this.dOv != null) {
            this.dOv.B(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dOz && this.dOA && this.dOu != null && this.biM >= this.dOx) {
            Qd();
        }
    }

    public void showFloatingView() {
        if (this.dOz && this.dOA && this.dOu != null) {
            Qc();
        }
    }

    private void aaQ() {
        if (this.dOv != null && this.dOv.aCc() != null) {
            View aCc = this.dOv.aCc();
            if (this.dOy && aCc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aCc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aCc.setLayoutParams(layoutParams);
                gS(true);
                return;
            }
            gS(false);
        }
    }

    private void gS(boolean z) {
        if (this.dOv != null && this.dOv.aCc() != null) {
            View aCc = this.dOv.aCc();
            if (this.dOy && z && aCc.getVisibility() != 0) {
                aCc.setVisibility(0);
            } else if (!z && aCc.getVisibility() != 8) {
                aCc.setVisibility(8);
            }
        }
    }
}
