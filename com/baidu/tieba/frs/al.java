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
    private com.baidu.tieba.f.b byy;
    private ViewGroup daj;
    private i dak;
    private com.baidu.tieba.frs.vc.f dal;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aNH = 0;
    private int dam = 0;
    private boolean dao = true;
    private boolean dap = true;
    private boolean aNI = false;
    private final Handler.Callback daq = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.aqO()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.aqN();
                    return true;
                case 2:
                    al.this.aqL();
                    return true;
                case 3:
                    al.this.aqM();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.daq);
    private a.InterfaceC0131a byz = new a.InterfaceC0131a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            if (T(i2)) {
                al.this.fB(false);
                al.this.showFloatingView();
            }
            if (al.this.dak != null) {
                al.this.dak.fy(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
            if (T(i2)) {
                al.this.fB(true);
                al.this.hideFloatingView();
            }
            if (al.this.dak != null) {
                al.this.dak.fy(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void Y(int i, int i2) {
        }

        private boolean T(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dan = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aqK() {
        return this.byy;
    }

    public void fB(boolean z) {
        this.aNI = z;
    }

    public void fC(boolean z) {
        this.dao = z;
    }

    public al(Context context, i iVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dak = iVar;
        this.mNavigationBar = iVar.Rg();
        this.daj = iVar.apP();
        this.dal = fVar;
        Qd();
        this.byy = new com.baidu.tieba.f.b(context);
        this.byy.a(this.byz);
    }

    public void aqL() {
        v(false, false);
    }

    public void aqM() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.daj != null && this.dak != null && this.dak.aqd() != null && this.dak.aqd().arX()) {
            u(false, true);
        }
    }

    public void aqN() {
        if (this.daj != null && this.dak != null && this.dak.aqd() != null && !this.dak.aqd().arX()) {
            u(true, true);
        }
    }

    public void HK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void HL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void HM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aqO() {
        return aq(this.daj);
    }

    private boolean aq(View view2) {
        Animation animation;
        return (view2 == null || (animation = view2.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void u(boolean z, boolean z2) {
        if (this.dak != null) {
            this.dak.u(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dao && this.dap && this.daj != null && this.aNH >= this.dam) {
            HL();
        }
    }

    public void showFloatingView() {
        if (this.dao && this.dap && this.daj != null) {
            HK();
        }
    }

    private void Qd() {
        if (this.dak != null && this.dak.apQ() != null) {
            View apQ = this.dak.apQ();
            if (this.dan && apQ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = apQ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                apQ.setLayoutParams(layoutParams);
                fD(true);
                return;
            }
            fD(false);
        }
    }

    private void fD(boolean z) {
        if (this.dak != null && this.dak.apQ() != null) {
            View apQ = this.dak.apQ();
            if (this.dan && z && apQ.getVisibility() != 0) {
                apQ.setVisibility(0);
            } else if (!z && apQ.getVisibility() != 8) {
                apQ.setVisibility(8);
            }
        }
    }
}
