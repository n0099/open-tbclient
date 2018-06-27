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
    private com.baidu.tieba.f.b bJn;
    private ViewGroup dmM;
    private k dmN;
    private com.baidu.tieba.frs.vc.f dmO;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aWA = 0;
    private int dmP = 0;
    private boolean dmR = true;
    private boolean dmS = true;
    private boolean aWB = false;
    private final Handler.Callback dmT = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.avm()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.avl();
                    return true;
                case 2:
                    an.this.avj();
                    return true;
                case 3:
                    an.this.avk();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dmT);
    private a.InterfaceC0147a bJo = new a.InterfaceC0147a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void W(int i, int i2) {
            if (ad(i2)) {
                an.this.fL(false);
                an.this.showFloatingView();
            }
            if (an.this.dmN != null) {
                an.this.dmN.fI(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void X(int i, int i2) {
            if (ad(i2)) {
                an.this.fL(true);
                an.this.hideFloatingView();
            }
            if (an.this.dmN != null) {
                an.this.dmN.fI(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void Y(int i, int i2) {
        }

        private boolean ad(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dmQ = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b avi() {
        return this.bJn;
    }

    public void fL(boolean z) {
        this.aWB = z;
    }

    public void fM(boolean z) {
        this.dmR = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dmN = kVar;
        this.mNavigationBar = kVar.UW();
        this.dmM = kVar.aul();
        this.dmO = fVar;
        TS();
        this.bJn = new com.baidu.tieba.f.b(context);
        this.bJn.a(this.bJo);
    }

    public void avj() {
        x(false, false);
    }

    public void avk() {
        x(false, true);
    }

    public void x(boolean z, boolean z2) {
        if (this.dmM != null && this.dmN != null && this.dmN.auz() != null && this.dmN.auz().awF()) {
            w(false, true);
        }
    }

    public void avl() {
        if (this.dmM != null && this.dmN != null && this.dmN.auz() != null && !this.dmN.auz().awF()) {
            w(true, true);
        }
    }

    public void Lw() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lx() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Ly() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avm() {
        return as(this.dmM);
    }

    private boolean as(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void w(boolean z, boolean z2) {
        if (this.dmN != null) {
            this.dmN.w(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dmR && this.dmS && this.dmM != null && this.aWA >= this.dmP) {
            Lx();
        }
    }

    public void showFloatingView() {
        if (this.dmR && this.dmS && this.dmM != null) {
            Lw();
        }
    }

    private void TS() {
        if (this.dmN != null && this.dmN.aum() != null) {
            View aum = this.dmN.aum();
            if (this.dmQ && aum.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aum.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aum.setLayoutParams(layoutParams);
                fN(true);
                return;
            }
            fN(false);
        }
    }

    private void fN(boolean z) {
        if (this.dmN != null && this.dmN.aum() != null) {
            View aum = this.dmN.aum();
            if (this.dmQ && z && aum.getVisibility() != 0) {
                aum.setVisibility(0);
            } else if (!z && aum.getVisibility() != 8) {
                aum.setVisibility(8);
            }
        }
    }
}
