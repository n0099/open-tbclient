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
    private ViewGroup iGh;
    private q iGi;
    private com.baidu.tieba.frs.vc.h iGj;
    private com.baidu.tieba.f.b iGn;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int ftg = 0;
    private int iGk = 0;
    private boolean iGl = true;
    private boolean iGm = true;
    private boolean fth = false;
    private final Handler.Callback iGo = new Handler.Callback() { // from class: com.baidu.tieba.frs.ax.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ax.this.cyc()) {
                ax.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ax.this.cya();
                    return true;
                case 2:
                    ax.this.cxY();
                    return true;
                case 3:
                    ax.this.cxZ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iGo);
    private a.InterfaceC0705a iac = new a.InterfaceC0705a() { // from class: com.baidu.tieba.frs.ax.2
        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void H(int i, int i2) {
            if (at(i2)) {
                ax.this.pE(true);
                ax.this.hideFloatingView();
            }
            if (ax.this.iGi != null) {
                ax.this.iGi.px(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void I(int i, int i2) {
            if (at(i2)) {
                ax.this.pE(false);
                ax.this.showFloatingView();
            }
            if (ax.this.iGi != null) {
                ax.this.iGi.px(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void ce(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void J(int i, int i2) {
        }

        private boolean at(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bxR = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cxX() {
        return this.iGn;
    }

    public void pE(boolean z) {
        this.fth = z;
    }

    public void pF(boolean z) {
        this.iGl = z;
    }

    public ax(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.iGi = qVar;
        this.mNavigationBar = qVar.bQh();
        this.iGh = qVar.cwE();
        this.iGj = hVar;
        QR();
        this.iGn = new com.baidu.tieba.f.b(context);
        this.iGn.a(this.iac);
    }

    public void cxY() {
        Z(false, false);
    }

    public void cxZ() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.iGh != null && this.iGi != null && this.iGi.cwO() != null && this.iGi.cwO().czI()) {
            Y(false, true);
        }
    }

    public void cya() {
        if (this.iGh != null && this.iGi != null && this.iGi.cwO() != null && !this.iGi.cwO().czI()) {
            Y(true, true);
        }
    }

    public void bBr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bBs() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cyb() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cyc() {
        return cw(this.iGh);
    }

    private boolean cw(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void Y(boolean z, boolean z2) {
        if (this.iGi != null) {
            this.iGi.Y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.iGl && this.iGm && this.iGh != null && this.ftg >= this.iGk) {
            bBs();
        }
    }

    public void showFloatingView() {
        if (this.iGl && this.iGm && this.iGh != null) {
            bBr();
        }
    }

    private void QR() {
        if (this.iGi != null && this.iGi.QW() != null) {
            View QW = this.iGi.QW();
            if (this.bxR && QW.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = QW.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                QW.setLayoutParams(layoutParams);
                cI(true);
                return;
            }
            cI(false);
        }
    }

    private void cI(boolean z) {
        if (this.iGi != null && this.iGi.QW() != null) {
            View QW = this.iGi.QW();
            if (this.bxR && z && QW.getVisibility() != 0) {
                QW.setVisibility(0);
            } else if (!z && QW.getVisibility() != 8) {
                QW.setVisibility(8);
            }
        }
    }
}
