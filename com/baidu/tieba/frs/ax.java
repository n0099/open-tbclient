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
/* loaded from: classes22.dex */
public class ax {
    private ViewGroup iMe;
    private q iMf;
    private com.baidu.tieba.frs.vc.h iMg;
    private com.baidu.tieba.f.b iMk;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fyY = 0;
    private int iMh = 0;
    private boolean iMi = true;
    private boolean iMj = true;
    private boolean fyZ = false;
    private final Handler.Callback iMl = new Handler.Callback() { // from class: com.baidu.tieba.frs.ax.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ax.this.cAD()) {
                ax.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ax.this.cAB();
                    return true;
                case 2:
                    ax.this.cAz();
                    return true;
                case 3:
                    ax.this.cAA();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iMl);
    private a.InterfaceC0719a igd = new a.InterfaceC0719a() { // from class: com.baidu.tieba.frs.ax.2
        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void H(int i, int i2) {
            if (av(i2)) {
                ax.this.pN(true);
                ax.this.hideFloatingView();
            }
            if (ax.this.iMf != null) {
                ax.this.iMf.pG(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void I(int i, int i2) {
            if (av(i2)) {
                ax.this.pN(false);
                ax.this.showFloatingView();
            }
            if (ax.this.iMf != null) {
                ax.this.iMf.pG(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void J(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bEc = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cAy() {
        return this.iMk;
    }

    public void pN(boolean z) {
        this.fyZ = z;
    }

    public void pO(boolean z) {
        this.iMi = z;
    }

    public ax(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.iMf = qVar;
        this.mNavigationBar = qVar.bSH();
        this.iMe = qVar.czf();
        this.iMg = hVar;
        Tz();
        this.iMk = new com.baidu.tieba.f.b(context);
        this.iMk.a(this.igd);
    }

    public void cAz() {
        Z(false, false);
    }

    public void cAA() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.iMe != null && this.iMf != null && this.iMf.czp() != null && this.iMf.czp().cCj()) {
            Y(false, true);
        }
    }

    public void cAB() {
        if (this.iMe != null && this.iMf != null && this.iMf.czp() != null && !this.iMf.czp().cCj()) {
            Y(true, true);
        }
    }

    public void bDQ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bDR() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cAC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cAD() {
        return cB(this.iMe);
    }

    private boolean cB(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void Y(boolean z, boolean z2) {
        if (this.iMf != null) {
            this.iMf.Y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.iMi && this.iMj && this.iMe != null && this.fyY >= this.iMh) {
            bDR();
        }
    }

    public void showFloatingView() {
        if (this.iMi && this.iMj && this.iMe != null) {
            bDQ();
        }
    }

    private void Tz() {
        if (this.iMf != null && this.iMf.TE() != null) {
            View TE = this.iMf.TE();
            if (this.bEc && TE.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = TE.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                TE.setLayoutParams(layoutParams);
                cP(true);
                return;
            }
            cP(false);
        }
    }

    private void cP(boolean z) {
        if (this.iMf != null && this.iMf.TE() != null) {
            View TE = this.iMf.TE();
            if (this.bEc && z && TE.getVisibility() != 0) {
                TE.setVisibility(0);
            } else if (!z && TE.getVisibility() != 8) {
                TE.setVisibility(8);
            }
        }
    }
}
