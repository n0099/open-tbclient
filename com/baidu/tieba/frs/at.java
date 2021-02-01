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
public class at {
    private ViewGroup jkW;
    private q jkX;
    private com.baidu.tieba.frs.vc.h jkY;
    private com.baidu.tieba.f.b jlc;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fNi = 0;
    private int jkZ = 0;
    private boolean jla = true;
    private boolean jlb = true;
    private boolean fNj = false;
    private final Handler.Callback jld = new Handler.Callback() { // from class: com.baidu.tieba.frs.at.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && at.this.cEN()) {
                at.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    at.this.cEL();
                    return true;
                case 2:
                    at.this.cEJ();
                    return true;
                case 3:
                    at.this.cEK();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jld);
    private a.InterfaceC0710a iFe = new a.InterfaceC0710a() { // from class: com.baidu.tieba.frs.at.2
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            if (aD(i2)) {
                at.this.qR(true);
                at.this.hideFloatingView();
            }
            if (at.this.jkX != null) {
                at.this.jkX.qK(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            if (aD(i2)) {
                at.this.qR(false);
                at.this.showFloatingView();
            }
            if (at.this.jkX != null) {
                at.this.jkX.qK(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }

        private boolean aD(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bLk = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cEI() {
        return this.jlc;
    }

    public void qR(boolean z) {
        this.fNj = z;
    }

    public void qS(boolean z) {
        this.jla = z;
    }

    public at(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.jkX = qVar;
        this.mNavigationBar = qVar.bVd();
        this.jkW = qVar.cDp();
        this.jkY = hVar;
        Uh();
        this.jlc = new com.baidu.tieba.f.b(context);
        this.jlc.a(this.iFe);
    }

    public void cEJ() {
        ab(false, false);
    }

    public void cEK() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.jkW != null && this.jkX != null && this.jkX.cDz() != null && this.jkX.cDz().cGB()) {
            aa(false, true);
        }
    }

    public void cEL() {
        if (this.jkW != null && this.jkX != null && this.jkX.cDz() != null && !this.jkX.cDz().cGB()) {
            aa(true, true);
        }
    }

    public void bFD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cEM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cEN() {
        return cU(this.jkW);
    }

    private boolean cU(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aa(boolean z, boolean z2) {
        if (this.jkX != null) {
            this.jkX.aa(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.jla && this.jlb && this.jkW != null && this.fNi >= this.jkZ) {
            bFE();
        }
    }

    public void showFloatingView() {
        if (this.jla && this.jlb && this.jkW != null) {
            bFD();
        }
    }

    private void Uh() {
        if (this.jkX != null && this.jkX.Um() != null) {
            View Um = this.jkX.Um();
            if (this.bLk && Um.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Um.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Um.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    private void dm(boolean z) {
        if (this.jkX != null && this.jkX.Um() != null) {
            View Um = this.jkX.Um();
            if (this.bLk && z && Um.getVisibility() != 0) {
                Um.setVisibility(0);
            } else if (!z && Um.getVisibility() != 8) {
                Um.setVisibility(8);
            }
        }
    }
}
