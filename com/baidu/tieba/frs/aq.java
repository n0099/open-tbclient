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
/* loaded from: classes9.dex */
public class aq {
    private ViewGroup hrp;
    private n hrq;
    private com.baidu.tieba.frs.vc.h hrr;
    private com.baidu.tieba.f.b hrv;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int evt = 0;
    private int hrs = 0;
    private boolean hrt = true;
    private boolean hru = true;
    private boolean evu = false;
    private final Handler.Callback hrw = new Handler.Callback() { // from class: com.baidu.tieba.frs.aq.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && aq.this.bXa()) {
                aq.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    aq.this.bWZ();
                    return true;
                case 2:
                    aq.this.bWX();
                    return true;
                case 3:
                    aq.this.bWY();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hrw);
    private a.InterfaceC0607a gMe = new a.InterfaceC0607a() { // from class: com.baidu.tieba.frs.aq.2
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            if (ad(i2)) {
                aq.this.nf(true);
                aq.this.hideFloatingView();
            }
            if (aq.this.hrq != null) {
                aq.this.hrq.mY(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            if (ad(i2)) {
                aq.this.nf(false);
                aq.this.showFloatingView();
            }
            if (aq.this.hrq != null) {
                aq.this.hrq.mY(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bdr = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bWW() {
        return this.hrv;
    }

    public void nf(boolean z) {
        this.evu = z;
    }

    public void ng(boolean z) {
        this.hrt = z;
    }

    public aq(Context context, n nVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hrq = nVar;
        this.mNavigationBar = nVar.bua();
        this.hrp = nVar.bVJ();
        this.hrr = hVar;
        Hc();
        this.hrv = new com.baidu.tieba.f.b(context);
        this.hrv.a(this.gMe);
    }

    public void bWX() {
        Q(false, false);
    }

    public void bWY() {
        Q(false, true);
    }

    public void Q(boolean z, boolean z2) {
        if (this.hrp != null && this.hrq != null && this.hrq.bVT() != null && this.hrq.bVT().bYy()) {
            P(false, true);
        }
    }

    public void bWZ() {
        if (this.hrp != null && this.hrq != null && this.hrq.bVT() != null && !this.hrq.bVT().bYy()) {
            P(true, true);
        }
    }

    public void bgK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bgL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void blf() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bXa() {
        return bW(this.hrp);
    }

    private boolean bW(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void P(boolean z, boolean z2) {
        if (this.hrq != null) {
            this.hrq.P(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hrt && this.hru && this.hrp != null && this.evt >= this.hrs) {
            bgL();
        }
    }

    public void showFloatingView() {
        if (this.hrt && this.hru && this.hrp != null) {
            bgK();
        }
    }

    private void Hc() {
        if (this.hrq != null && this.hrq.Hh() != null) {
            View Hh = this.hrq.Hh();
            if (this.bdr && Hh.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Hh.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Hh.setLayoutParams(layoutParams);
                ch(true);
                return;
            }
            ch(false);
        }
    }

    private void ch(boolean z) {
        if (this.hrq != null && this.hrq.Hh() != null) {
            View Hh = this.hrq.Hh();
            if (this.bdr && z && Hh.getVisibility() != 0) {
                Hh.setVisibility(0);
            } else if (!z && Hh.getVisibility() != 8) {
                Hh.setVisibility(8);
            }
        }
    }
}
