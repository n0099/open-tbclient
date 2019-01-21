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
    private com.baidu.tieba.f.b cxB;
    private ViewGroup dPe;
    private k dPf;
    private com.baidu.tieba.frs.vc.f dPg;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bjA = 0;
    private int dPh = 0;
    private boolean dPj = true;
    private boolean dPk = true;
    private boolean bjB = false;
    private final Handler.Callback dPl = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
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
    private final Handler mHandler = new Handler(this.dPl);
    private a.InterfaceC0214a cxC = new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (ag(i2)) {
                an.this.gT(false);
                an.this.showFloatingView();
            }
            if (an.this.dPf != null) {
                an.this.dPf.gK(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (ag(i2)) {
                an.this.gT(true);
                an.this.hideFloatingView();
            }
            if (an.this.dPf != null) {
                an.this.dPf.gK(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dPi = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aDM() {
        return this.cxB;
    }

    public void gT(boolean z) {
        this.bjB = z;
    }

    public void gU(boolean z) {
        this.dPj = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dPf = kVar;
        this.mNavigationBar = kVar.act();
        this.dPe = kVar.aCy();
        this.dPg = fVar;
        abn();
        this.cxB = new com.baidu.tieba.f.b(context);
        this.cxB.a(this.cxC);
    }

    public void aDN() {
        C(false, false);
    }

    public void aDO() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.dPe != null && this.dPf != null && this.dPf.aCK() != null && this.dPf.aCK().aFi()) {
            B(false, true);
        }
    }

    public void aDP() {
        if (this.dPe != null && this.dPf != null && this.dPf.aCK() != null && !this.dPf.aCK().aFi()) {
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
        return aO(this.dPe);
    }

    private boolean aO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void B(boolean z, boolean z2) {
        if (this.dPf != null) {
            this.dPf.B(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dPj && this.dPk && this.dPe != null && this.bjA >= this.dPh) {
            Qy();
        }
    }

    public void showFloatingView() {
        if (this.dPj && this.dPk && this.dPe != null) {
            Qx();
        }
    }

    private void abn() {
        if (this.dPf != null && this.dPf.aCz() != null) {
            View aCz = this.dPf.aCz();
            if (this.dPi && aCz.getLayoutParams() != null) {
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
        if (this.dPf != null && this.dPf.aCz() != null) {
            View aCz = this.dPf.aCz();
            if (this.dPi && z && aCz.getVisibility() != 0) {
                aCz.setVisibility(0);
            } else if (!z && aCz.getVisibility() != 8) {
                aCz.setVisibility(8);
            }
        }
    }
}
