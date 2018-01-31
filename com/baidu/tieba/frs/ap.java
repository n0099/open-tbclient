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
    private com.baidu.tieba.e.b ckT;
    private ViewGroup dEt;
    private k dEu;
    private com.baidu.tieba.frs.f.f dEv;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bBq = 0;
    private int dEw = 0;
    private boolean dEy = true;
    private boolean dEz = true;
    private boolean bBr = false;
    private final Handler.Callback dEA = new Handler.Callback() { // from class: com.baidu.tieba.frs.ap.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ap.this.avw()) {
                ap.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ap.this.avv();
                    return true;
                case 2:
                    ap.this.avt();
                    return true;
                case 3:
                    ap.this.avu();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dEA);
    private a.InterfaceC0109a ckU = new a.InterfaceC0109a() { // from class: com.baidu.tieba.frs.ap.2
        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            if (Z(i2)) {
                ap.this.fO(false);
                ap.this.showFloatingView();
            }
            if (ap.this.dEu != null) {
                ap.this.dEu.fK(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            if (Z(i2)) {
                ap.this.fO(true);
                ap.this.hideFloatingView();
            }
            if (ap.this.dEu != null) {
                ap.this.dEu.fK(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }

        private boolean Z(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dEx = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b avs() {
        return this.ckT;
    }

    public void fO(boolean z) {
        this.bBr = z;
    }

    public void fP(boolean z) {
        this.dEy = z;
    }

    public ap(Context context, k kVar, com.baidu.tieba.frs.f.f fVar) {
        this.mContext = context;
        this.dEu = kVar;
        this.mNavigationBar = kVar.auu();
        this.dEt = kVar.auB();
        this.dEv = fVar;
        avx();
        this.ckT = new com.baidu.tieba.e.b(context);
        this.ckT.a(this.ckU);
    }

    public void avt() {
        y(false, false);
    }

    public void avu() {
        y(false, true);
    }

    public void y(boolean z, boolean z2) {
        if (this.dEt != null && this.dEu != null && this.dEu.auF() != null && this.dEu.auF().awz()) {
            x(false, true);
        }
    }

    public void avv() {
        if (this.dEt != null && this.dEu != null && this.dEu.auF() != null && !this.dEu.auF().awz()) {
            x(true, true);
        }
    }

    public void OD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OF() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avw() {
        return bM(this.dEt);
    }

    private boolean bM(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void x(boolean z, boolean z2) {
        if (this.dEu != null) {
            this.dEu.x(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dEy && this.dEz && this.dEt != null && this.bBq >= this.dEw) {
            OE();
        }
    }

    public void showFloatingView() {
        if (this.dEy && this.dEz && this.dEt != null) {
            OD();
        }
    }

    private void avx() {
        if (this.dEu != null && this.dEu.auC() != null) {
            View auC = this.dEu.auC();
            if (this.dEx && auC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = auC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                auC.setLayoutParams(layoutParams);
                fQ(true);
                return;
            }
            fQ(false);
        }
    }

    private void fQ(boolean z) {
        if (this.dEu != null && this.dEu.auC() != null) {
            View auC = this.dEu.auC();
            if (this.dEx && z && auC.getVisibility() != 0) {
                auC.setVisibility(0);
            } else if (!z && auC.getVisibility() != 8) {
                auC.setVisibility(8);
            }
        }
    }
}
