package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.g.a;
/* loaded from: classes22.dex */
public class aw {
    private ViewGroup iXI;
    private q iXJ;
    private com.baidu.tieba.frs.vc.h iXK;
    private com.baidu.tieba.g.b iXO;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fGa = 0;
    private int iXL = 0;
    private boolean iXM = true;
    private boolean iXN = true;
    private boolean fGb = false;
    private final Handler.Callback iXP = new Handler.Callback() { // from class: com.baidu.tieba.frs.aw.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && aw.this.cEw()) {
                aw.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    aw.this.cEu();
                    return true;
                case 2:
                    aw.this.cEs();
                    return true;
                case 3:
                    aw.this.cEt();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iXP);
    private a.InterfaceC0756a irM = new a.InterfaceC0756a() { // from class: com.baidu.tieba.frs.aw.2
        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            if (ay(i2)) {
                aw.this.qn(true);
                aw.this.hideFloatingView();
            }
            if (aw.this.iXJ != null) {
                aw.this.iXJ.qg(false);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            if (ay(i2)) {
                aw.this.qn(false);
                aw.this.showFloatingView();
            }
            if (aw.this.iXJ != null) {
                aw.this.iXJ.qg(true);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void ck(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void I(int i, int i2) {
        }

        private boolean ay(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bHz = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.g.b cEr() {
        return this.iXO;
    }

    public void qn(boolean z) {
        this.fGb = z;
    }

    public void qo(boolean z) {
        this.iXM = z;
    }

    public aw(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.iXJ = qVar;
        this.mNavigationBar = qVar.bVK();
        this.iXI = qVar.cCZ();
        this.iXK = hVar;
        Vq();
        this.iXO = new com.baidu.tieba.g.b(context);
        this.iXO.a(this.irM);
    }

    public void cEs() {
        Z(false, false);
    }

    public void cEt() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.iXI != null && this.iXJ != null && this.iXJ.cDj() != null && this.iXJ.cDj().cGf()) {
            Y(false, true);
        }
    }

    public void cEu() {
        if (this.iXI != null && this.iXJ != null && this.iXJ.cDj() != null && !this.iXJ.cDj().cGf()) {
            Y(true, true);
        }
    }

    public void bGI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bGJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cEv() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cEw() {
        return cM(this.iXI);
    }

    private boolean cM(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void Y(boolean z, boolean z2) {
        if (this.iXJ != null) {
            this.iXJ.Y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.iXM && this.iXN && this.iXI != null && this.fGa >= this.iXL) {
            bGJ();
        }
    }

    public void showFloatingView() {
        if (this.iXM && this.iXN && this.iXI != null) {
            bGI();
        }
    }

    private void Vq() {
        if (this.iXJ != null && this.iXJ.Vv() != null) {
            View Vv = this.iXJ.Vv();
            if (this.bHz && Vv.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Vv.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Vv.setLayoutParams(layoutParams);
                df(true);
                return;
            }
            df(false);
        }
    }

    private void df(boolean z) {
        if (this.iXJ != null && this.iXJ.Vv() != null) {
            View Vv = this.iXJ.Vv();
            if (this.bHz && z && Vv.getVisibility() != 0) {
                Vv.setVisibility(0);
            } else if (!z && Vv.getVisibility() != 8) {
                Vv.setVisibility(8);
            }
        }
    }
}
