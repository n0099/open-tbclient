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
/* loaded from: classes2.dex */
public class ap {
    private com.baidu.tieba.e.b ckD;
    private ViewGroup dzx;
    private k dzy;
    private com.baidu.tieba.frs.f.f dzz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bAZ = 0;
    private int dzA = 0;
    private boolean dzC = true;
    private boolean dzD = true;
    private boolean bBa = false;
    private final Handler.Callback dzE = new Handler.Callback() { // from class: com.baidu.tieba.frs.ap.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ap.this.auo()) {
                ap.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ap.this.aun();
                    return true;
                case 2:
                    ap.this.aul();
                    return true;
                case 3:
                    ap.this.aum();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dzE);
    private a.InterfaceC0109a ckE = new a.InterfaceC0109a() { // from class: com.baidu.tieba.frs.ap.2
        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            if (aa(i2)) {
                ap.this.fI(false);
                ap.this.showFloatingView();
            }
            if (ap.this.dzy != null) {
                ap.this.dzy.fE(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            if (aa(i2)) {
                ap.this.fI(true);
                ap.this.hideFloatingView();
            }
            if (ap.this.dzy != null) {
                ap.this.dzy.fE(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }

        private boolean aa(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dzB = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b auk() {
        return this.ckD;
    }

    public void fI(boolean z) {
        this.bBa = z;
    }

    public void fJ(boolean z) {
        this.dzC = z;
    }

    public ap(Context context, k kVar, com.baidu.tieba.frs.f.f fVar) {
        this.mContext = context;
        this.dzy = kVar;
        this.mNavigationBar = kVar.atm();
        this.dzx = kVar.att();
        this.dzz = fVar;
        aup();
        this.ckD = new com.baidu.tieba.e.b(context);
        this.ckD.a(this.ckE);
    }

    public void aul() {
        y(false, false);
    }

    public void aum() {
        y(false, true);
    }

    public void y(boolean z, boolean z2) {
        if (this.dzx != null && this.dzy != null && this.dzy.atx() != null && this.dzy.atx().avr()) {
            x(false, true);
        }
    }

    public void aun() {
        if (this.dzx != null && this.dzy != null && this.dzy.atx() != null && !this.dzy.atx().avr()) {
            x(true, true);
        }
    }

    public void ON() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean auo() {
        return bK(this.dzx);
    }

    private boolean bK(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void x(boolean z, boolean z2) {
        if (this.dzy != null) {
            this.dzy.x(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dzC && this.dzD && this.dzx != null && this.bAZ >= this.dzA) {
            OO();
        }
    }

    public void showFloatingView() {
        if (this.dzC && this.dzD && this.dzx != null) {
            ON();
        }
    }

    private void aup() {
        if (this.dzy != null && this.dzy.atu() != null) {
            View atu = this.dzy.atu();
            if (this.dzB && atu.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = atu.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                atu.setLayoutParams(layoutParams);
                fK(true);
                return;
            }
            fK(false);
        }
    }

    private void fK(boolean z) {
        if (this.dzy != null && this.dzy.atu() != null) {
            View atu = this.dzy.atu();
            if (this.dzB && z && atu.getVisibility() != 0) {
                atu.setVisibility(0);
            } else if (!z && atu.getVisibility() != 8) {
                atu.setVisibility(8);
            }
        }
    }
}
