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
/* loaded from: classes21.dex */
public class ax {
    private ViewGroup iMR;
    private q iMS;
    private com.baidu.tieba.frs.vc.h iMT;
    private com.baidu.tieba.g.b iMX;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fyl = 0;
    private int iMU = 0;
    private boolean iMV = true;
    private boolean iMW = true;
    private boolean fym = false;
    private final Handler.Callback iMY = new Handler.Callback() { // from class: com.baidu.tieba.frs.ax.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ax.this.cAg()) {
                ax.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ax.this.cAe();
                    return true;
                case 2:
                    ax.this.cAc();
                    return true;
                case 3:
                    ax.this.cAd();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iMY);
    private a.InterfaceC0740a igS = new a.InterfaceC0740a() { // from class: com.baidu.tieba.frs.ax.2
        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void H(int i, int i2) {
            if (ax(i2)) {
                ax.this.pQ(true);
                ax.this.hideFloatingView();
            }
            if (ax.this.iMS != null) {
                ax.this.iMS.pJ(false);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void I(int i, int i2) {
            if (ax(i2)) {
                ax.this.pQ(false);
                ax.this.showFloatingView();
            }
            if (ax.this.iMS != null) {
                ax.this.iMS.pJ(true);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void J(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bCr = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.g.b cAb() {
        return this.iMX;
    }

    public void pQ(boolean z) {
        this.fym = z;
    }

    public void pR(boolean z) {
        this.iMV = z;
    }

    public ax(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.iMS = qVar;
        this.mNavigationBar = qVar.bSa();
        this.iMR = qVar.cyI();
        this.iMT = hVar;
        SQ();
        this.iMX = new com.baidu.tieba.g.b(context);
        this.iMX.a(this.igS);
    }

    public void cAc() {
        Z(false, false);
    }

    public void cAd() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.iMR != null && this.iMS != null && this.iMS.cyS() != null && this.iMS.cyS().cBM()) {
            Y(false, true);
        }
    }

    public void cAe() {
        if (this.iMR != null && this.iMS != null && this.iMS.cyS() != null && !this.iMS.cyS().cBM()) {
            Y(true, true);
        }
    }

    public void bDh() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bDi() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cAf() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cAg() {
        return cF(this.iMR);
    }

    private boolean cF(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void Y(boolean z, boolean z2) {
        if (this.iMS != null) {
            this.iMS.Y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.iMV && this.iMW && this.iMR != null && this.fyl >= this.iMU) {
            bDi();
        }
    }

    public void showFloatingView() {
        if (this.iMV && this.iMW && this.iMR != null) {
            bDh();
        }
    }

    private void SQ() {
        if (this.iMS != null && this.iMS.SV() != null) {
            View SV = this.iMS.SV();
            if (this.bCr && SV.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = SV.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                SV.setLayoutParams(layoutParams);
                cR(true);
                return;
            }
            cR(false);
        }
    }

    private void cR(boolean z) {
        if (this.iMS != null && this.iMS.SV() != null) {
            View SV = this.iMS.SV();
            if (this.bCr && z && SV.getVisibility() != 0) {
                SV.setVisibility(0);
            } else if (!z && SV.getVisibility() != 8) {
                SV.setVisibility(8);
            }
        }
    }
}
