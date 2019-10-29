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
    private ViewGroup fzq;
    private k fzr;
    private com.baidu.tieba.frs.vc.f fzs;
    private com.baidu.tieba.f.b fzw;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int cPm = 0;
    private int fzt = 0;
    private boolean fzu = true;
    private boolean fzv = true;
    private boolean cPn = false;
    private final Handler.Callback fzx = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.blP()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.blO();
                    return true;
                case 2:
                    ak.this.blM();
                    return true;
                case 3:
                    ak.this.blN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fzx);
    private a.InterfaceC0405a eYb = new a.InterfaceC0405a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
            if (aj(i2)) {
                ak.this.kc(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fzr != null) {
                ak.this.fzr.jU(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void w(int i, int i2) {
            if (aj(i2)) {
                ak.this.kc(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fzr != null) {
                ak.this.fzr.jU(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void x(int i, int i2) {
        }

        private boolean aj(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean apD = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b blL() {
        return this.fzw;
    }

    public void kc(boolean z) {
        this.cPn = z;
    }

    public void kd(boolean z) {
        this.fzu = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fzr = kVar;
        this.mNavigationBar = kVar.aKR();
        this.fzq = kVar.bkA();
        this.fzs = fVar;
        vz();
        this.fzw = new com.baidu.tieba.f.b(context);
        this.fzw.a(this.eYb);
    }

    public void blM() {
        L(false, false);
    }

    public void blN() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.fzq != null && this.fzr != null && this.fzr.bkK() != null && this.fzr.bkK().bni()) {
            K(false, true);
        }
    }

    public void blO() {
        if (this.fzq != null && this.fzr != null && this.fzr.bkK() != null && !this.fzr.bkK().bni()) {
            K(true, true);
        }
    }

    public void axK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void axL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void axM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean blP() {
        return bO(this.fzq);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void K(boolean z, boolean z2) {
        if (this.fzr != null) {
            this.fzr.K(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fzu && this.fzv && this.fzq != null && this.cPm >= this.fzt) {
            axL();
        }
    }

    public void showFloatingView() {
        if (this.fzu && this.fzv && this.fzq != null) {
            axK();
        }
    }

    private void vz() {
        if (this.fzr != null && this.fzr.vE() != null) {
            View vE = this.fzr.vE();
            if (this.apD && vE.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = vE.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                vE.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    private void aP(boolean z) {
        if (this.fzr != null && this.fzr.vE() != null) {
            View vE = this.fzr.vE();
            if (this.apD && z && vE.getVisibility() != 0) {
                vE.setVisibility(0);
            } else if (!z && vE.getVisibility() != 8) {
                vE.setVisibility(8);
            }
        }
    }
}
