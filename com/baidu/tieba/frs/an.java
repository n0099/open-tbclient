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
    private com.baidu.tieba.f.b bYq;
    private ViewGroup dDR;
    private k dDS;
    private com.baidu.tieba.frs.vc.f dDT;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bew = 0;
    private int dDU = 0;
    private boolean dDW = true;
    private boolean dDX = true;
    private boolean bex = false;
    private final Handler.Callback dDY = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.aBw()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aBv();
                    return true;
                case 2:
                    an.this.aBt();
                    return true;
                case 3:
                    an.this.aBu();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dDY);
    private a.InterfaceC0179a bYr = new a.InterfaceC0179a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void af(int i, int i2) {
            if (ag(i2)) {
                an.this.gC(false);
                an.this.showFloatingView();
            }
            if (an.this.dDS != null) {
                an.this.dDS.gt(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ag(int i, int i2) {
            if (ag(i2)) {
                an.this.gC(true);
                an.this.hideFloatingView();
            }
            if (an.this.dDS != null) {
                an.this.dDS.gt(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ah(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dDV = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aBs() {
        return this.bYq;
    }

    public void gC(boolean z) {
        this.bex = z;
    }

    public void gD(boolean z) {
        this.dDW = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dDS = kVar;
        this.mNavigationBar = kVar.aaD();
        this.dDR = kVar.aAd();
        this.dDT = fVar;
        Zx();
        this.bYq = new com.baidu.tieba.f.b(context);
        this.bYq.a(this.bYr);
    }

    public void aBt() {
        A(false, false);
    }

    public void aBu() {
        A(false, true);
    }

    public void A(boolean z, boolean z2) {
        if (this.dDR != null && this.dDS != null && this.dDS.aAq() != null && this.dDS.aAq().aCP()) {
            z(false, true);
        }
    }

    public void aBv() {
        if (this.dDR != null && this.dDS != null && this.dDS.aAq() != null && !this.dDS.aAq().aCP()) {
            z(true, true);
        }
    }

    public void OL() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OM() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void ON() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aBw() {
        return aJ(this.dDR);
    }

    private boolean aJ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void z(boolean z, boolean z2) {
        if (this.dDS != null) {
            this.dDS.z(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dDW && this.dDX && this.dDR != null && this.bew >= this.dDU) {
            OM();
        }
    }

    public void showFloatingView() {
        if (this.dDW && this.dDX && this.dDR != null) {
            OL();
        }
    }

    private void Zx() {
        if (this.dDS != null && this.dDS.aAe() != null) {
            View aAe = this.dDS.aAe();
            if (this.dDV && aAe.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aAe.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aAe.setLayoutParams(layoutParams);
                gE(true);
                return;
            }
            gE(false);
        }
    }

    private void gE(boolean z) {
        if (this.dDS != null && this.dDS.aAe() != null) {
            View aAe = this.dDS.aAe();
            if (this.dDV && z && aAe.getVisibility() != 0) {
                aAe.setVisibility(0);
            } else if (!z && aAe.getVisibility() != 8) {
                aAe.setVisibility(8);
            }
        }
    }
}
