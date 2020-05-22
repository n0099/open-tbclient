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
    private ViewGroup hre;
    private n hrf;
    private com.baidu.tieba.frs.vc.h hrg;
    private com.baidu.tieba.f.b hrk;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int evt = 0;
    private int hrh = 0;
    private boolean hri = true;
    private boolean hrj = true;
    private boolean evu = false;
    private final Handler.Callback hrl = new Handler.Callback() { // from class: com.baidu.tieba.frs.aq.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && aq.this.bWY()) {
                aq.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    aq.this.bWX();
                    return true;
                case 2:
                    aq.this.bWV();
                    return true;
                case 3:
                    aq.this.bWW();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hrl);
    private a.InterfaceC0607a gLT = new a.InterfaceC0607a() { // from class: com.baidu.tieba.frs.aq.2
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            if (ad(i2)) {
                aq.this.nf(true);
                aq.this.hideFloatingView();
            }
            if (aq.this.hrf != null) {
                aq.this.hrf.mY(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            if (ad(i2)) {
                aq.this.nf(false);
                aq.this.showFloatingView();
            }
            if (aq.this.hrf != null) {
                aq.this.hrf.mY(true);
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

    public com.baidu.tieba.f.b bWU() {
        return this.hrk;
    }

    public void nf(boolean z) {
        this.evu = z;
    }

    public void ng(boolean z) {
        this.hri = z;
    }

    public aq(Context context, n nVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hrf = nVar;
        this.mNavigationBar = nVar.btY();
        this.hre = nVar.bVH();
        this.hrg = hVar;
        Hc();
        this.hrk = new com.baidu.tieba.f.b(context);
        this.hrk.a(this.gLT);
    }

    public void bWV() {
        Q(false, false);
    }

    public void bWW() {
        Q(false, true);
    }

    public void Q(boolean z, boolean z2) {
        if (this.hre != null && this.hrf != null && this.hrf.bVR() != null && this.hrf.bVR().bYv()) {
            P(false, true);
        }
    }

    public void bWX() {
        if (this.hre != null && this.hrf != null && this.hrf.bVR() != null && !this.hrf.bVR().bYv()) {
            P(true, true);
        }
    }

    public void bgJ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bgK() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void bld() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bWY() {
        return bW(this.hre);
    }

    private boolean bW(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void P(boolean z, boolean z2) {
        if (this.hrf != null) {
            this.hrf.P(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hri && this.hrj && this.hre != null && this.evt >= this.hrh) {
            bgK();
        }
    }

    public void showFloatingView() {
        if (this.hri && this.hrj && this.hre != null) {
            bgJ();
        }
    }

    private void Hc() {
        if (this.hrf != null && this.hrf.Hh() != null) {
            View Hh = this.hrf.Hh();
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
        if (this.hrf != null && this.hrf.Hh() != null) {
            View Hh = this.hrf.Hh();
            if (this.bdr && z && Hh.getVisibility() != 0) {
                Hh.setVisibility(0);
            } else if (!z && Hh.getVisibility() != 8) {
                Hh.setVisibility(8);
            }
        }
    }
}
