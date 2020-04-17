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
    private ViewGroup hck;
    private n hcl;
    private com.baidu.tieba.frs.vc.h hcm;
    private com.baidu.tieba.f.b hcq;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int egW = 0;
    private int hcn = 0;
    private boolean hco = true;
    private boolean hcp = true;
    private boolean egX = false;
    private final Handler.Callback hcr = new Handler.Callback() { // from class: com.baidu.tieba.frs.aq.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && aq.this.bQD()) {
                aq.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    aq.this.bQC();
                    return true;
                case 2:
                    aq.this.bQA();
                    return true;
                case 3:
                    aq.this.bQB();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hcr);
    private a.InterfaceC0536a gxd = new a.InterfaceC0536a() { // from class: com.baidu.tieba.frs.aq.2
        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void y(int i, int i2) {
            if (af(i2)) {
                aq.this.mK(true);
                aq.this.hideFloatingView();
            }
            if (aq.this.hcl != null) {
                aq.this.hcl.mD(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void z(int i, int i2) {
            if (af(i2)) {
                aq.this.mK(false);
                aq.this.showFloatingView();
            }
            if (aq.this.hcl != null) {
                aq.this.hcl.mD(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void A(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean aVY = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bQz() {
        return this.hcq;
    }

    public void mK(boolean z) {
        this.egX = z;
    }

    public void mL(boolean z) {
        this.hco = z;
    }

    public aq(Context context, n nVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hcl = nVar;
        this.mNavigationBar = nVar.boh();
        this.hck = nVar.bPm();
        this.hcm = hVar;
        Fm();
        this.hcq = new com.baidu.tieba.f.b(context);
        this.hcq.a(this.gxd);
    }

    public void bQA() {
        N(false, false);
    }

    public void bQB() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.hck != null && this.hcl != null && this.hcl.bPw() != null && this.hcl.bPw().bSb()) {
            M(false, true);
        }
    }

    public void bQC() {
        if (this.hck != null && this.hcl != null && this.hcl.bPw() != null && !this.hcl.bPw().bSb()) {
            M(true, true);
        }
    }

    public void baA() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void baB() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void beT() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bQD() {
        return bW(this.hck);
    }

    private boolean bW(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void M(boolean z, boolean z2) {
        if (this.hcl != null) {
            this.hcl.M(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hco && this.hcp && this.hck != null && this.egW >= this.hcn) {
            baB();
        }
    }

    public void showFloatingView() {
        if (this.hco && this.hcp && this.hck != null) {
            baA();
        }
    }

    private void Fm() {
        if (this.hcl != null && this.hcl.Fr() != null) {
            View Fr = this.hcl.Fr();
            if (this.aVY && Fr.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Fr.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Fr.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    private void bX(boolean z) {
        if (this.hcl != null && this.hcl.Fr() != null) {
            View Fr = this.hcl.Fr();
            if (this.aVY && z && Fr.getVisibility() != 0) {
                Fr.setVisibility(0);
            } else if (!z && Fr.getVisibility() != 8) {
                Fr.setVisibility(8);
            }
        }
    }
}
