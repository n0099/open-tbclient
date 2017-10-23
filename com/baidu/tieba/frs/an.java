package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class an {
    private ViewGroup ctk;
    private i ctl;
    private com.baidu.tieba.frs.h.f ctm;
    private com.baidu.tieba.e.b ctr;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aLJ = 0;
    private int ctn = 0;
    private boolean ctp = true;
    private boolean ctq = true;
    private boolean aLK = false;
    private final Handler.Callback cts = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.aig()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aif();
                    return true;
                case 2:
                    an.this.aid();
                    return true;
                case 3:
                    an.this.aie();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cts);
    private a.InterfaceC0081a cau = new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            if (Q(i2)) {
                an.this.eJ(false);
                an.this.showFloatingView();
            }
            if (an.this.ctl != null) {
                an.this.ctl.eF(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            if (Q(i2)) {
                an.this.eJ(true);
                an.this.hideFloatingView();
            }
            if (an.this.ctl != null) {
                an.this.ctl.eF(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }

        private boolean Q(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cto = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b aic() {
        return this.ctr;
    }

    public void eJ(boolean z) {
        this.aLK = z;
    }

    public void eK(boolean z) {
        this.ctp = z;
    }

    public an(Context context, i iVar, com.baidu.tieba.frs.h.f fVar) {
        this.mContext = context;
        this.ctl = iVar;
        this.mNavigationBar = iVar.ahe();
        this.ctk = iVar.ahk();
        this.ctm = fVar;
        aih();
        eL(false);
        this.ctr = new com.baidu.tieba.e.b(context);
        this.ctr.a(this.cau);
    }

    public void aid() {
        v(false, false);
    }

    public void aie() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.ctk != null && this.ctl != null && this.ctl.aho() != null && this.ctl.aho().ajj()) {
            u(false, true);
        }
    }

    public void aif() {
        if (this.ctk != null && this.ctl != null && this.ctl.aho() != null && !this.ctl.aho().ajj()) {
            u(true, true);
        }
    }

    public void GJ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GK() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GL() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aig() {
        return aq(this.ctk);
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void u(boolean z, boolean z2) {
        if (this.ctl != null) {
            this.ctl.u(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.ctp && this.ctq && this.ctk != null && this.aLJ >= this.ctn) {
            GK();
        }
    }

    public void showFloatingView() {
        if (this.ctp && this.ctq && this.ctk != null) {
            GJ();
        }
    }

    private void aih() {
        if (this.ctl != null && this.ctl.ahl() != null) {
            View ahl = this.ctl.ahl();
            if (this.cto && ahl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = ahl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                ahl.setLayoutParams(layoutParams);
                eL(true);
                return;
            }
            eL(false);
        }
    }

    private void eL(boolean z) {
        if (this.ctl != null && this.ctl.ahl() != null) {
            View ahl = this.ctl.ahl();
            if (this.cto && z && ahl.getVisibility() != 0) {
                ahl.setVisibility(0);
            } else if (!z && ahl.getVisibility() != 8) {
                ahl.setVisibility(8);
            }
        }
    }
}
