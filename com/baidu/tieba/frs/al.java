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
public class al {
    private com.baidu.tieba.f.b bHu;
    private ViewGroup dkF;
    private i dkG;
    private com.baidu.tieba.frs.vc.f dkH;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aVF = 0;
    private int dkI = 0;
    private boolean dkK = true;
    private boolean dkL = true;
    private boolean aVG = false;
    private final Handler.Callback dkM = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.auS()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.auR();
                    return true;
                case 2:
                    al.this.auP();
                    return true;
                case 3:
                    al.this.auQ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dkM);
    private a.InterfaceC0146a bHv = new a.InterfaceC0146a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void X(int i, int i2) {
            if (ad(i2)) {
                al.this.fH(false);
                al.this.showFloatingView();
            }
            if (al.this.dkG != null) {
                al.this.dkG.fE(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Y(int i, int i2) {
            if (ad(i2)) {
                al.this.fH(true);
                al.this.hideFloatingView();
            }
            if (al.this.dkG != null) {
                al.this.dkG.fE(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0146a
        public void Z(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dkJ = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b auO() {
        return this.bHu;
    }

    public void fH(boolean z) {
        this.aVG = z;
    }

    public void fI(boolean z) {
        this.dkK = z;
    }

    public al(Context context, i iVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dkG = iVar;
        this.mNavigationBar = iVar.UB();
        this.dkF = iVar.atT();
        this.dkH = fVar;
        Ty();
        this.bHu = new com.baidu.tieba.f.b(context);
        this.bHu.a(this.bHv);
    }

    public void auP() {
        v(false, false);
    }

    public void auQ() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.dkF != null && this.dkG != null && this.dkG.auh() != null && this.dkG.auh().awb()) {
            u(false, true);
        }
    }

    public void auR() {
        if (this.dkF != null && this.dkG != null && this.dkG.auh() != null && !this.dkG.auh().awb()) {
            u(true, true);
        }
    }

    public void Le() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean auS() {
        return aq(this.dkF);
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void u(boolean z, boolean z2) {
        if (this.dkG != null) {
            this.dkG.u(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dkK && this.dkL && this.dkF != null && this.aVF >= this.dkI) {
            Lf();
        }
    }

    public void showFloatingView() {
        if (this.dkK && this.dkL && this.dkF != null) {
            Le();
        }
    }

    private void Ty() {
        if (this.dkG != null && this.dkG.atU() != null) {
            View atU = this.dkG.atU();
            if (this.dkJ && atU.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = atU.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                atU.setLayoutParams(layoutParams);
                fJ(true);
                return;
            }
            fJ(false);
        }
    }

    private void fJ(boolean z) {
        if (this.dkG != null && this.dkG.atU() != null) {
            View atU = this.dkG.atU();
            if (this.dkJ && z && atU.getVisibility() != 0) {
                atU.setVisibility(0);
            } else if (!z && atU.getVisibility() != 8) {
                atU.setVisibility(8);
            }
        }
    }
}
