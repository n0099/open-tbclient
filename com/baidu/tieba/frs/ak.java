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
/* loaded from: classes4.dex */
public class ak {
    private com.baidu.tieba.f.b dMr;
    private ViewGroup fcR;
    private k fcS;
    private com.baidu.tieba.frs.vc.f fcT;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int ctE = 0;
    private int fcU = 0;
    private boolean fcW = true;
    private boolean fcX = true;
    private boolean ctF = false;
    private final Handler.Callback fcY = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.bew()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.bev();
                    return true;
                case 2:
                    ak.this.bet();
                    return true;
                case 3:
                    ak.this.beu();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fcY);
    private a.InterfaceC0284a dMs = new a.InterfaceC0284a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (av(i2)) {
                ak.this.jr(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fcS != null) {
                ak.this.fcS.jj(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
            if (av(i2)) {
                ak.this.jr(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fcS != null) {
                ak.this.fcS.jj(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aT(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fcV = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bes() {
        return this.dMr;
    }

    public void jr(boolean z) {
        this.ctF = z;
    }

    public void js(boolean z) {
        this.fcW = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fcS = kVar;
        this.mNavigationBar = kVar.aDp();
        this.fcR = kVar.bde();
        this.fcT = fVar;
        aCm();
        this.dMr = new com.baidu.tieba.f.b(context);
        this.dMr.a(this.dMs);
    }

    public void bet() {
        G(false, false);
    }

    public void beu() {
        G(false, true);
    }

    public void G(boolean z, boolean z2) {
        if (this.fcR != null && this.fcS != null && this.fcS.bdp() != null && this.fcS.bdp().bfK()) {
            F(false, true);
        }
    }

    public void bev() {
        if (this.fcR != null && this.fcS != null && this.fcS.bdp() != null && !this.fcS.bdp().bfK()) {
            F(true, true);
        }
    }

    public void aqi() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqj() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aqk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bew() {
        return bG(this.fcR);
    }

    private boolean bG(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void F(boolean z, boolean z2) {
        if (this.fcS != null) {
            this.fcS.F(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fcW && this.fcX && this.fcR != null && this.ctE >= this.fcU) {
            aqj();
        }
    }

    public void showFloatingView() {
        if (this.fcW && this.fcX && this.fcR != null) {
            aqi();
        }
    }

    private void aCm() {
        if (this.fcS != null && this.fcS.bdf() != null) {
            View bdf = this.fcS.bdf();
            if (this.fcV && bdf.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bdf.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bdf.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    private void jt(boolean z) {
        if (this.fcS != null && this.fcS.bdf() != null) {
            View bdf = this.fcS.bdf();
            if (this.fcV && z && bdf.getVisibility() != 0) {
                bdf.setVisibility(0);
            } else if (!z && bdf.getVisibility() != 8) {
                bdf.setVisibility(8);
            }
        }
    }
}
