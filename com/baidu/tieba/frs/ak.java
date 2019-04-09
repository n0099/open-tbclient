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
    private com.baidu.tieba.f.b dLJ;
    private ViewGroup fcE;
    private k fcF;
    private com.baidu.tieba.frs.vc.f fcG;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int ctH = 0;
    private int fcH = 0;
    private boolean fcJ = true;
    private boolean fcK = true;
    private boolean ctI = false;
    private final Handler.Callback fcL = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.beu()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.bet();
                    return true;
                case 2:
                    ak.this.ber();
                    return true;
                case 3:
                    ak.this.bes();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fcL);
    private a.InterfaceC0284a dLK = new a.InterfaceC0284a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (av(i2)) {
                ak.this.jr(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fcF != null) {
                ak.this.fcF.jj(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
            if (av(i2)) {
                ak.this.jr(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fcF != null) {
                ak.this.fcF.jj(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aT(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fcI = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b beq() {
        return this.dLJ;
    }

    public void jr(boolean z) {
        this.ctI = z;
    }

    public void js(boolean z) {
        this.fcJ = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fcF = kVar;
        this.mNavigationBar = kVar.aDm();
        this.fcE = kVar.bdc();
        this.fcG = fVar;
        aCj();
        this.dLJ = new com.baidu.tieba.f.b(context);
        this.dLJ.a(this.dLK);
    }

    public void ber() {
        E(false, false);
    }

    public void bes() {
        E(false, true);
    }

    public void E(boolean z, boolean z2) {
        if (this.fcE != null && this.fcF != null && this.fcF.bdn() != null && this.fcF.bdn().bfI()) {
            D(false, true);
        }
    }

    public void bet() {
        if (this.fcE != null && this.fcF != null && this.fcF.bdn() != null && !this.fcF.bdn().bfI()) {
            D(true, true);
        }
    }

    public void aqf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aqh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean beu() {
        return bG(this.fcE);
    }

    private boolean bG(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void D(boolean z, boolean z2) {
        if (this.fcF != null) {
            this.fcF.D(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fcJ && this.fcK && this.fcE != null && this.ctH >= this.fcH) {
            aqg();
        }
    }

    public void showFloatingView() {
        if (this.fcJ && this.fcK && this.fcE != null) {
            aqf();
        }
    }

    private void aCj() {
        if (this.fcF != null && this.fcF.bdd() != null) {
            View bdd = this.fcF.bdd();
            if (this.fcI && bdd.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bdd.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bdd.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    private void jt(boolean z) {
        if (this.fcF != null && this.fcF.bdd() != null) {
            View bdd = this.fcF.bdd();
            if (this.fcI && z && bdd.getVisibility() != 0) {
                bdd.setVisibility(0);
            } else if (!z && bdd.getVisibility() != 8) {
                bdd.setVisibility(8);
            }
        }
    }
}
