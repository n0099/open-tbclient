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
public class an {
    private com.baidu.tieba.f.b bKa;
    private ViewGroup dpC;
    private k dpD;
    private com.baidu.tieba.frs.vc.f dpE;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aWC = 0;
    private int dpF = 0;
    private boolean dpH = true;
    private boolean dpI = true;
    private boolean aWD = false;
    private final Handler.Callback dpJ = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.avQ()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.avP();
                    return true;
                case 2:
                    an.this.avN();
                    return true;
                case 3:
                    an.this.avO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dpJ);
    private a.InterfaceC0144a bKb = new a.InterfaceC0144a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Y(int i, int i2) {
            if (ad(i2)) {
                an.this.fN(false);
                an.this.showFloatingView();
            }
            if (an.this.dpD != null) {
                an.this.dpD.fK(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Z(int i, int i2) {
            if (ad(i2)) {
                an.this.fN(true);
                an.this.hideFloatingView();
            }
            if (an.this.dpD != null) {
                an.this.dpD.fK(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void aa(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dpG = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b avM() {
        return this.bKa;
    }

    public void fN(boolean z) {
        this.aWD = z;
    }

    public void fO(boolean z) {
        this.dpH = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dpD = kVar;
        this.mNavigationBar = kVar.Vj();
        this.dpC = kVar.auO();
        this.dpE = fVar;
        Ud();
        this.bKa = new com.baidu.tieba.f.b(context);
        this.bKa.a(this.bKb);
    }

    public void avN() {
        x(false, false);
    }

    public void avO() {
        x(false, true);
    }

    public void x(boolean z, boolean z2) {
        if (this.dpC != null && this.dpD != null && this.dpD.avc() != null && this.dpD.avc().axj()) {
            w(false, true);
        }
    }

    public void avP() {
        if (this.dpC != null && this.dpD != null && this.dpD.avc() != null && !this.dpD.avc().axj()) {
            w(true, true);
        }
    }

    public void Lv() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lw() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lx() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avQ() {
        return av(this.dpC);
    }

    private boolean av(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void w(boolean z, boolean z2) {
        if (this.dpD != null) {
            this.dpD.w(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dpH && this.dpI && this.dpC != null && this.aWC >= this.dpF) {
            Lw();
        }
    }

    public void showFloatingView() {
        if (this.dpH && this.dpI && this.dpC != null) {
            Lv();
        }
    }

    private void Ud() {
        if (this.dpD != null && this.dpD.auP() != null) {
            View auP = this.dpD.auP();
            if (this.dpG && auP.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = auP.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                auP.setLayoutParams(layoutParams);
                fP(true);
                return;
            }
            fP(false);
        }
    }

    private void fP(boolean z) {
        if (this.dpD != null && this.dpD.auP() != null) {
            View auP = this.dpD.auP();
            if (this.dpG && z && auP.getVisibility() != 0) {
                auP.setVisibility(0);
            } else if (!z && auP.getVisibility() != 8) {
                auP.setVisibility(8);
            }
        }
    }
}
