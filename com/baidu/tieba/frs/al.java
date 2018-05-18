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
    private com.baidu.tieba.f.b bzr;
    private ViewGroup dbp;
    private i dbq;
    private com.baidu.tieba.frs.vc.f dbr;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aNI = 0;
    private int dbs = 0;
    private boolean dbu = true;
    private boolean dbv = true;
    private boolean aNJ = false;
    private final Handler.Callback dbw = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.aqN()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.aqM();
                    return true;
                case 2:
                    al.this.aqK();
                    return true;
                case 3:
                    al.this.aqL();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dbw);
    private a.InterfaceC0131a bzs = new a.InterfaceC0131a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            if (T(i2)) {
                al.this.fC(false);
                al.this.showFloatingView();
            }
            if (al.this.dbq != null) {
                al.this.dbq.fz(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
            if (T(i2)) {
                al.this.fC(true);
                al.this.hideFloatingView();
            }
            if (al.this.dbq != null) {
                al.this.dbq.fz(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void Y(int i, int i2) {
        }

        private boolean T(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dbt = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aqJ() {
        return this.bzr;
    }

    public void fC(boolean z) {
        this.aNJ = z;
    }

    public void fD(boolean z) {
        this.dbu = z;
    }

    public al(Context context, i iVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dbq = iVar;
        this.mNavigationBar = iVar.Rd();
        this.dbp = iVar.apO();
        this.dbr = fVar;
        Qa();
        this.bzr = new com.baidu.tieba.f.b(context);
        this.bzr.a(this.bzs);
    }

    public void aqK() {
        v(false, false);
    }

    public void aqL() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.dbp != null && this.dbq != null && this.dbq.aqc() != null && this.dbq.aqc().arW()) {
            u(false, true);
        }
    }

    public void aqM() {
        if (this.dbp != null && this.dbq != null && this.dbq.aqc() != null && !this.dbq.aqc().arW()) {
            u(true, true);
        }
    }

    public void HI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void HJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void HK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aqN() {
        return aq(this.dbp);
    }

    private boolean aq(View view2) {
        Animation animation;
        return (view2 == null || (animation = view2.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void u(boolean z, boolean z2) {
        if (this.dbq != null) {
            this.dbq.u(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dbu && this.dbv && this.dbp != null && this.aNI >= this.dbs) {
            HJ();
        }
    }

    public void showFloatingView() {
        if (this.dbu && this.dbv && this.dbp != null) {
            HI();
        }
    }

    private void Qa() {
        if (this.dbq != null && this.dbq.apP() != null) {
            View apP = this.dbq.apP();
            if (this.dbt && apP.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = apP.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                apP.setLayoutParams(layoutParams);
                fE(true);
                return;
            }
            fE(false);
        }
    }

    private void fE(boolean z) {
        if (this.dbq != null && this.dbq.apP() != null) {
            View apP = this.dbq.apP();
            if (this.dbt && z && apP.getVisibility() != 0) {
                apP.setVisibility(0);
            } else if (!z && apP.getVisibility() != 8) {
                apP.setVisibility(8);
            }
        }
    }
}
