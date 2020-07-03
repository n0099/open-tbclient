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
public class av {
    private ViewGroup hEg;
    private p hEh;
    private com.baidu.tieba.frs.vc.h hEi;
    private com.baidu.tieba.f.b hEm;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int eEz = 0;
    private int hEj = 0;
    private boolean hEk = true;
    private boolean hEl = true;
    private boolean eEA = false;
    private final Handler.Callback hEn = new Handler.Callback() { // from class: com.baidu.tieba.frs.av.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && av.this.cal()) {
                av.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    av.this.cak();
                    return true;
                case 2:
                    av.this.cai();
                    return true;
                case 3:
                    av.this.caj();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hEn);
    private a.InterfaceC0614a gZb = new a.InterfaceC0614a() { // from class: com.baidu.tieba.frs.av.2
        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void D(int i, int i2) {
            if (af(i2)) {
                av.this.nq(true);
                av.this.hideFloatingView();
            }
            if (av.this.hEh != null) {
                av.this.hEh.nj(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void E(int i, int i2) {
            if (af(i2)) {
                av.this.nq(false);
                av.this.showFloatingView();
            }
            if (av.this.hEh != null) {
                av.this.hEh.nj(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void bO(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void F(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean biE = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cah() {
        return this.hEm;
    }

    public void nq(boolean z) {
        this.eEA = z;
    }

    public void nr(boolean z) {
        this.hEk = z;
    }

    public av(Context context, p pVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hEh = pVar;
        this.mNavigationBar = pVar.bwV();
        this.hEg = pVar.bYR();
        this.hEi = hVar;
        Ip();
        this.hEm = new com.baidu.tieba.f.b(context);
        this.hEm.a(this.gZb);
    }

    public void cai() {
        Q(false, false);
    }

    public void caj() {
        Q(false, true);
    }

    public void Q(boolean z, boolean z2) {
        if (this.hEg != null && this.hEh != null && this.hEh.bZb() != null && this.hEh.bZb().cbM()) {
            P(false, true);
        }
    }

    public void cak() {
        if (this.hEg != null && this.hEh != null && this.hEh.bZb() != null && !this.hEh.bZb().cbM()) {
            P(true, true);
        }
    }

    public void biX() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void biY() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void bnE() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cal() {
        return bX(this.hEg);
    }

    private boolean bX(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void P(boolean z, boolean z2) {
        if (this.hEh != null) {
            this.hEh.P(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hEk && this.hEl && this.hEg != null && this.eEz >= this.hEj) {
            biY();
        }
    }

    public void showFloatingView() {
        if (this.hEk && this.hEl && this.hEg != null) {
            biX();
        }
    }

    private void Ip() {
        if (this.hEh != null && this.hEh.Iu() != null) {
            View Iu = this.hEh.Iu();
            if (this.biE && Iu.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Iu.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Iu.setLayoutParams(layoutParams);
                cm(true);
                return;
            }
            cm(false);
        }
    }

    private void cm(boolean z) {
        if (this.hEh != null && this.hEh.Iu() != null) {
            View Iu = this.hEh.Iu();
            if (this.biE && z && Iu.getVisibility() != 0) {
                Iu.setVisibility(0);
            } else if (!z && Iu.getVisibility() != 8) {
                Iu.setVisibility(8);
            }
        }
    }
}
