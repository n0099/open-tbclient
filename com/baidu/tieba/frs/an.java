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
public class an {
    private com.baidu.tieba.f.b bKb;
    private ViewGroup dpE;
    private k dpF;
    private com.baidu.tieba.frs.vc.f dpG;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aWC = 0;
    private int dpH = 0;
    private boolean dpJ = true;
    private boolean dpK = true;
    private boolean aWD = false;
    private final Handler.Callback dpL = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.avR()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.avQ();
                    return true;
                case 2:
                    an.this.avO();
                    return true;
                case 3:
                    an.this.avP();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dpL);
    private a.InterfaceC0145a bKc = new a.InterfaceC0145a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Y(int i, int i2) {
            if (ae(i2)) {
                an.this.fN(false);
                an.this.showFloatingView();
            }
            if (an.this.dpF != null) {
                an.this.dpF.fK(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Z(int i, int i2) {
            if (ae(i2)) {
                an.this.fN(true);
                an.this.hideFloatingView();
            }
            if (an.this.dpF != null) {
                an.this.dpF.fK(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void aa(int i, int i2) {
        }

        private boolean ae(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dpI = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b avN() {
        return this.bKb;
    }

    public void fN(boolean z) {
        this.aWD = z;
    }

    public void fO(boolean z) {
        this.dpJ = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dpF = kVar;
        this.mNavigationBar = kVar.Vf();
        this.dpE = kVar.auP();
        this.dpG = fVar;
        Ua();
        this.bKb = new com.baidu.tieba.f.b(context);
        this.bKb.a(this.bKc);
    }

    public void avO() {
        x(false, false);
    }

    public void avP() {
        x(false, true);
    }

    public void x(boolean z, boolean z2) {
        if (this.dpE != null && this.dpF != null && this.dpF.avd() != null && this.dpF.avd().axk()) {
            w(false, true);
        }
    }

    public void avQ() {
        if (this.dpE != null && this.dpF != null && this.dpF.avd() != null && !this.dpF.avd().axk()) {
            w(true, true);
        }
    }

    public void Lr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Ls() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lt() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avR() {
        return av(this.dpE);
    }

    private boolean av(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void w(boolean z, boolean z2) {
        if (this.dpF != null) {
            this.dpF.w(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dpJ && this.dpK && this.dpE != null && this.aWC >= this.dpH) {
            Ls();
        }
    }

    public void showFloatingView() {
        if (this.dpJ && this.dpK && this.dpE != null) {
            Lr();
        }
    }

    private void Ua() {
        if (this.dpF != null && this.dpF.auQ() != null) {
            View auQ = this.dpF.auQ();
            if (this.dpI && auQ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = auQ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                auQ.setLayoutParams(layoutParams);
                fP(true);
                return;
            }
            fP(false);
        }
    }

    private void fP(boolean z) {
        if (this.dpF != null && this.dpF.auQ() != null) {
            View auQ = this.dpF.auQ();
            if (this.dpI && z && auQ.getVisibility() != 0) {
                auQ.setVisibility(0);
            } else if (!z && auQ.getVisibility() != 8) {
                auQ.setVisibility(8);
            }
        }
    }
}
