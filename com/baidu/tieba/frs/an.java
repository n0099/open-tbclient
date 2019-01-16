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
/* loaded from: classes6.dex */
public class an {
    private com.baidu.tieba.f.b cxA;
    private ViewGroup dPd;
    private k dPe;
    private com.baidu.tieba.frs.vc.f dPf;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bjz = 0;
    private int dPg = 0;
    private boolean dPi = true;
    private boolean dPj = true;
    private boolean bjA = false;
    private final Handler.Callback dPk = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.aDQ()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aDP();
                    return true;
                case 2:
                    an.this.aDN();
                    return true;
                case 3:
                    an.this.aDO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dPk);
    private a.InterfaceC0214a cxB = new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (ag(i2)) {
                an.this.gT(false);
                an.this.showFloatingView();
            }
            if (an.this.dPe != null) {
                an.this.dPe.gK(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (ag(i2)) {
                an.this.gT(true);
                an.this.hideFloatingView();
            }
            if (an.this.dPe != null) {
                an.this.dPe.gK(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dPh = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aDM() {
        return this.cxA;
    }

    public void gT(boolean z) {
        this.bjA = z;
    }

    public void gU(boolean z) {
        this.dPi = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dPe = kVar;
        this.mNavigationBar = kVar.act();
        this.dPd = kVar.aCy();
        this.dPf = fVar;
        abn();
        this.cxA = new com.baidu.tieba.f.b(context);
        this.cxA.a(this.cxB);
    }

    public void aDN() {
        C(false, false);
    }

    public void aDO() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.dPd != null && this.dPe != null && this.dPe.aCK() != null && this.dPe.aCK().aFi()) {
            B(false, true);
        }
    }

    public void aDP() {
        if (this.dPd != null && this.dPe != null && this.dPe.aCK() != null && !this.dPe.aCK().aFi()) {
            B(true, true);
        }
    }

    public void Qx() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qy() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qz() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aDQ() {
        return aO(this.dPd);
    }

    private boolean aO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void B(boolean z, boolean z2) {
        if (this.dPe != null) {
            this.dPe.B(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dPi && this.dPj && this.dPd != null && this.bjz >= this.dPg) {
            Qy();
        }
    }

    public void showFloatingView() {
        if (this.dPi && this.dPj && this.dPd != null) {
            Qx();
        }
    }

    private void abn() {
        if (this.dPe != null && this.dPe.aCz() != null) {
            View aCz = this.dPe.aCz();
            if (this.dPh && aCz.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aCz.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aCz.setLayoutParams(layoutParams);
                gV(true);
                return;
            }
            gV(false);
        }
    }

    private void gV(boolean z) {
        if (this.dPe != null && this.dPe.aCz() != null) {
            View aCz = this.dPe.aCz();
            if (this.dPh && z && aCz.getVisibility() != 0) {
                aCz.setVisibility(0);
            } else if (!z && aCz.getVisibility() != 8) {
                aCz.setVisibility(8);
            }
        }
    }
}
