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
public class al {
    private ViewGroup gmW;
    private l gmX;
    private com.baidu.tieba.frs.vc.h gmY;
    private com.baidu.tieba.f.b gnc;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int dCx = 0;
    private int gmZ = 0;
    private boolean gna = true;
    private boolean gnb = true;
    private boolean dCy = false;
    private final Handler.Callback gnd = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.bDj()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.bDi();
                    return true;
                case 2:
                    al.this.bDg();
                    return true;
                case 3:
                    al.this.bDh();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gnd);
    private a.InterfaceC0488a fLT = new a.InterfaceC0488a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void u(int i, int i2) {
            if (ax(i2)) {
                al.this.lo(true);
                al.this.hideFloatingView();
            }
            if (al.this.gmX != null) {
                al.this.gmX.lg(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void v(int i, int i2) {
            if (ax(i2)) {
                al.this.lo(false);
                al.this.showFloatingView();
            }
            if (al.this.gmX != null) {
                al.this.gmX.lg(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void w(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean axc = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bDf() {
        return this.gnc;
    }

    public void lo(boolean z) {
        this.dCy = z;
    }

    public void lp(boolean z) {
        this.gna = z;
    }

    public al(Context context, l lVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.gmX = lVar;
        this.mNavigationBar = lVar.bcb();
        this.gmW = lVar.bBU();
        this.gmY = hVar;
        xy();
        this.gnc = new com.baidu.tieba.f.b(context);
        this.gnc.a(this.fLT);
    }

    public void bDg() {
        L(false, false);
    }

    public void bDh() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.gmW != null && this.gmX != null && this.gmX.bCe() != null && this.gmX.bCe().bEE()) {
            K(false, true);
        }
    }

    public void bDi() {
        if (this.gmW != null && this.gmX != null && this.gmX.bCe() != null && !this.gmX.bCe().bEE()) {
            K(true, true);
        }
    }

    public void aPA() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aPB() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aTW() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bDj() {
        return bJ(this.gmW);
    }

    private boolean bJ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void K(boolean z, boolean z2) {
        if (this.gmX != null) {
            this.gmX.K(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.gna && this.gnb && this.gmW != null && this.dCx >= this.gmZ) {
            aPB();
        }
    }

    public void showFloatingView() {
        if (this.gna && this.gnb && this.gmW != null) {
            aPA();
        }
    }

    private void xy() {
        if (this.gmX != null && this.gmX.xD() != null) {
            View xD = this.gmX.xD();
            if (this.axc && xD.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = xD.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                xD.setLayoutParams(layoutParams);
                bg(true);
                return;
            }
            bg(false);
        }
    }

    private void bg(boolean z) {
        if (this.gmX != null && this.gmX.xD() != null) {
            View xD = this.gmX.xD();
            if (this.axc && z && xD.getVisibility() != 0) {
                xD.setVisibility(0);
            } else if (!z && xD.getVisibility() != 8) {
                xD.setVisibility(8);
            }
        }
    }
}
