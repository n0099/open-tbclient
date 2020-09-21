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
/* loaded from: classes21.dex */
public class ax {
    private ViewGroup ieO;
    private q ieP;
    private com.baidu.tieba.frs.vc.h ieQ;
    private com.baidu.tieba.f.b ieU;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int eYv = 0;
    private int ieR = 0;
    private boolean ieS = true;
    private boolean ieT = true;
    private boolean eYw = false;
    private final Handler.Callback ieV = new Handler.Callback() { // from class: com.baidu.tieba.frs.ax.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ax.this.crx()) {
                ax.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ax.this.crv();
                    return true;
                case 2:
                    ax.this.crt();
                    return true;
                case 3:
                    ax.this.cru();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.ieV);
    private a.InterfaceC0671a hyK = new a.InterfaceC0671a() { // from class: com.baidu.tieba.frs.ax.2
        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void H(int i, int i2) {
            if (al(i2)) {
                ax.this.oH(true);
                ax.this.hideFloatingView();
            }
            if (ax.this.ieP != null) {
                ax.this.ieP.oA(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void I(int i, int i2) {
            if (al(i2)) {
                ax.this.oH(false);
                ax.this.showFloatingView();
            }
            if (ax.this.ieP != null) {
                ax.this.ieP.oA(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void J(int i, int i2) {
        }

        private boolean al(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean brP = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b crs() {
        return this.ieU;
    }

    public void oH(boolean z) {
        this.eYw = z;
    }

    public void oI(boolean z) {
        this.ieS = z;
    }

    public ax(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.ieP = qVar;
        this.mNavigationBar = qVar.bKS();
        this.ieO = qVar.cpZ();
        this.ieQ = hVar;
        OR();
        this.ieU = new com.baidu.tieba.f.b(context);
        this.ieU.a(this.hyK);
    }

    public void crt() {
        X(false, false);
    }

    public void cru() {
        X(false, true);
    }

    public void X(boolean z, boolean z2) {
        if (this.ieO != null && this.ieP != null && this.ieP.cqj() != null && this.ieP.cqj().cte()) {
            W(false, true);
        }
    }

    public void crv() {
        if (this.ieO != null && this.ieP != null && this.ieP.cqj() != null && !this.ieP.cqj().cte()) {
            W(true, true);
        }
    }

    public void bwO() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bwP() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void crw() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean crx() {
        return co(this.ieO);
    }

    private boolean co(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void W(boolean z, boolean z2) {
        if (this.ieP != null) {
            this.ieP.W(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.ieS && this.ieT && this.ieO != null && this.eYv >= this.ieR) {
            bwP();
        }
    }

    public void showFloatingView() {
        if (this.ieS && this.ieT && this.ieO != null) {
            bwO();
        }
    }

    private void OR() {
        if (this.ieP != null && this.ieP.OW() != null) {
            View OW = this.ieP.OW();
            if (this.brP && OW.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = OW.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                OW.setLayoutParams(layoutParams);
                cz(true);
                return;
            }
            cz(false);
        }
    }

    private void cz(boolean z) {
        if (this.ieP != null && this.ieP.OW() != null) {
            View OW = this.ieP.OW();
            if (this.brP && z && OW.getVisibility() != 0) {
                OW.setVisibility(0);
            } else if (!z && OW.getVisibility() != 8) {
                OW.setVisibility(8);
            }
        }
    }
}
