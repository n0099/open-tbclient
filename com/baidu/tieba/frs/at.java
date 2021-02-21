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
/* loaded from: classes2.dex */
public class at {
    private ViewGroup jlk;
    private q jll;
    private com.baidu.tieba.frs.vc.h jlm;
    private com.baidu.tieba.f.b jlq;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fNi = 0;
    private int jln = 0;
    private boolean jlo = true;
    private boolean jlp = true;
    private boolean fNj = false;
    private final Handler.Callback jlr = new Handler.Callback() { // from class: com.baidu.tieba.frs.at.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && at.this.cEU()) {
                at.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    at.this.cES();
                    return true;
                case 2:
                    at.this.cEQ();
                    return true;
                case 3:
                    at.this.cER();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jlr);
    private a.InterfaceC0711a iFs = new a.InterfaceC0711a() { // from class: com.baidu.tieba.frs.at.2
        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void G(int i, int i2) {
            if (aD(i2)) {
                at.this.qR(true);
                at.this.hideFloatingView();
            }
            if (at.this.jll != null) {
                at.this.jll.qK(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void H(int i, int i2) {
            if (aD(i2)) {
                at.this.qR(false);
                at.this.showFloatingView();
            }
            if (at.this.jll != null) {
                at.this.jll.qK(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void I(int i, int i2) {
        }

        private boolean aD(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bLk = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cEP() {
        return this.jlq;
    }

    public void qR(boolean z) {
        this.fNj = z;
    }

    public void qS(boolean z) {
        this.jlo = z;
    }

    public at(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.jll = qVar;
        this.mNavigationBar = qVar.bVk();
        this.jlk = qVar.cDw();
        this.jlm = hVar;
        Uh();
        this.jlq = new com.baidu.tieba.f.b(context);
        this.jlq.a(this.iFs);
    }

    public void cEQ() {
        ab(false, false);
    }

    public void cER() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.jlk != null && this.jll != null && this.jll.cDG() != null && this.jll.cDG().cGI()) {
            aa(false, true);
        }
    }

    public void cES() {
        if (this.jlk != null && this.jll != null && this.jll.cDG() != null && !this.jll.cDG().cGI()) {
            aa(true, true);
        }
    }

    public void bFD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cET() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cEU() {
        return cU(this.jlk);
    }

    private boolean cU(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aa(boolean z, boolean z2) {
        if (this.jll != null) {
            this.jll.aa(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.jlo && this.jlp && this.jlk != null && this.fNi >= this.jln) {
            bFE();
        }
    }

    public void showFloatingView() {
        if (this.jlo && this.jlp && this.jlk != null) {
            bFD();
        }
    }

    private void Uh() {
        if (this.jll != null && this.jll.Um() != null) {
            View Um = this.jll.Um();
            if (this.bLk && Um.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Um.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Um.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    private void dm(boolean z) {
        if (this.jll != null && this.jll.Um() != null) {
            View Um = this.jll.Um();
            if (this.bLk && z && Um.getVisibility() != 0) {
                Um.setVisibility(0);
            } else if (!z && Um.getVisibility() != 8) {
                Um.setVisibility(8);
            }
        }
    }
}
