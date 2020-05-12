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
    private ViewGroup hcq;
    private n hcr;
    private com.baidu.tieba.frs.vc.h hcs;
    private com.baidu.tieba.f.b hcw;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int ehb = 0;
    private int hct = 0;
    private boolean hcu = true;
    private boolean hcv = true;
    private boolean ehc = false;
    private final Handler.Callback hcx = new Handler.Callback() { // from class: com.baidu.tieba.frs.aq.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && aq.this.bQC()) {
                aq.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    aq.this.bQB();
                    return true;
                case 2:
                    aq.this.bQz();
                    return true;
                case 3:
                    aq.this.bQA();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hcx);
    private a.InterfaceC0557a gxj = new a.InterfaceC0557a() { // from class: com.baidu.tieba.frs.aq.2
        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void y(int i, int i2) {
            if (af(i2)) {
                aq.this.mK(true);
                aq.this.hideFloatingView();
            }
            if (aq.this.hcr != null) {
                aq.this.hcr.mD(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void z(int i, int i2) {
            if (af(i2)) {
                aq.this.mK(false);
                aq.this.showFloatingView();
            }
            if (aq.this.hcr != null) {
                aq.this.hcr.mD(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void A(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean aWd = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bQy() {
        return this.hcw;
    }

    public void mK(boolean z) {
        this.ehc = z;
    }

    public void mL(boolean z) {
        this.hcu = z;
    }

    public aq(Context context, n nVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hcr = nVar;
        this.mNavigationBar = nVar.bof();
        this.hcq = nVar.bPl();
        this.hcs = hVar;
        Fl();
        this.hcw = new com.baidu.tieba.f.b(context);
        this.hcw.a(this.gxj);
    }

    public void bQz() {
        N(false, false);
    }

    public void bQA() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.hcq != null && this.hcr != null && this.hcr.bPv() != null && this.hcr.bPv().bSa()) {
            M(false, true);
        }
    }

    public void bQB() {
        if (this.hcq != null && this.hcr != null && this.hcr.bPv() != null && !this.hcr.bPv().bSa()) {
            M(true, true);
        }
    }

    public void bay() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void baz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void beR() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bQC() {
        return bW(this.hcq);
    }

    private boolean bW(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void M(boolean z, boolean z2) {
        if (this.hcr != null) {
            this.hcr.M(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hcu && this.hcv && this.hcq != null && this.ehb >= this.hct) {
            baz();
        }
    }

    public void showFloatingView() {
        if (this.hcu && this.hcv && this.hcq != null) {
            bay();
        }
    }

    private void Fl() {
        if (this.hcr != null && this.hcr.Fq() != null) {
            View Fq = this.hcr.Fq();
            if (this.aWd && Fq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Fq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Fq.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    private void bX(boolean z) {
        if (this.hcr != null && this.hcr.Fq() != null) {
            View Fq = this.hcr.Fq();
            if (this.aWd && z && Fq.getVisibility() != 0) {
                Fq.setVisibility(0);
            } else if (!z && Fq.getVisibility() != 8) {
                Fq.setVisibility(8);
            }
        }
    }
}
