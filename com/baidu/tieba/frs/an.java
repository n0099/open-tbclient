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
    private com.baidu.tieba.e.b bzL;
    private ViewGroup cBa;
    private i cBb;
    private com.baidu.tieba.frs.g.f cBc;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aMF = 0;
    private int cBd = 0;
    private boolean cBf = true;
    private boolean cBg = true;
    private boolean aMG = false;
    private final Handler.Callback cBh = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.akC()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.akB();
                    return true;
                case 2:
                    an.this.akz();
                    return true;
                case 3:
                    an.this.akA();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cBh);
    private a.InterfaceC0081a bzM = new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            if (J(i2)) {
                an.this.eK(false);
                an.this.showFloatingView();
            }
            if (an.this.cBb != null) {
                an.this.cBb.eG(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            if (J(i2)) {
                an.this.eK(true);
                an.this.hideFloatingView();
            }
            if (an.this.cBb != null) {
                an.this.cBb.eG(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }

        private boolean J(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cBe = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b aky() {
        return this.bzL;
    }

    public void eK(boolean z) {
        this.aMG = z;
    }

    public void eL(boolean z) {
        this.cBf = z;
    }

    public an(Context context, i iVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.cBb = iVar;
        this.mNavigationBar = iVar.ajA();
        this.cBa = iVar.ajG();
        this.cBc = fVar;
        akD();
        eM(false);
        this.bzL = new com.baidu.tieba.e.b(context);
        this.bzL.a(this.bzM);
    }

    public void akz() {
        w(false, false);
    }

    public void akA() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.cBa != null && this.cBb != null && this.cBb.ajK() != null && this.cBb.ajK().alK()) {
            v(false, true);
        }
    }

    public void akB() {
        if (this.cBa != null && this.cBb != null && this.cBb.ajK() != null && !this.cBb.ajK().alK()) {
            v(true, true);
        }
    }

    public void Hg() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hh() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hi() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean akC() {
        return au(this.cBa);
    }

    private boolean au(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void v(boolean z, boolean z2) {
        if (this.cBb != null) {
            this.cBb.v(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cBf && this.cBg && this.cBa != null && this.aMF >= this.cBd) {
            Hh();
        }
    }

    public void showFloatingView() {
        if (this.cBf && this.cBg && this.cBa != null) {
            Hg();
        }
    }

    private void akD() {
        if (this.cBb != null && this.cBb.ajH() != null) {
            View ajH = this.cBb.ajH();
            if (this.cBe && ajH.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = ajH.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                ajH.setLayoutParams(layoutParams);
                eM(true);
                return;
            }
            eM(false);
        }
    }

    private void eM(boolean z) {
        if (this.cBb != null && this.cBb.ajH() != null) {
            View ajH = this.cBb.ajH();
            if (this.cBe && z && ajH.getVisibility() != 0) {
                ajH.setVisibility(0);
            } else if (!z && ajH.getVisibility() != 8) {
                ajH.setVisibility(8);
            }
        }
    }
}
