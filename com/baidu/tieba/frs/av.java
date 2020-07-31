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
/* loaded from: classes16.dex */
public class av {
    private ViewGroup hKe;
    private p hKf;
    private com.baidu.tieba.frs.vc.h hKg;
    private com.baidu.tieba.f.b hKk;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int eKV = 0;
    private int hKh = 0;
    private boolean hKi = true;
    private boolean hKj = true;
    private boolean eKW = false;
    private final Handler.Callback hKl = new Handler.Callback() { // from class: com.baidu.tieba.frs.av.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && av.this.cdK()) {
                av.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    av.this.cdI();
                    return true;
                case 2:
                    av.this.cdG();
                    return true;
                case 3:
                    av.this.cdH();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hKl);
    private a.InterfaceC0623a heG = new a.InterfaceC0623a() { // from class: com.baidu.tieba.frs.av.2
        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void D(int i, int i2) {
            if (af(i2)) {
                av.this.nV(true);
                av.this.hideFloatingView();
            }
            if (av.this.hKf != null) {
                av.this.hKf.nO(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void E(int i, int i2) {
            if (af(i2)) {
                av.this.nV(false);
                av.this.showFloatingView();
            }
            if (av.this.hKf != null) {
                av.this.hKf.nO(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void bR(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void F(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean biY = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cdF() {
        return this.hKk;
    }

    public void nV(boolean z) {
        this.eKW = z;
    }

    public void nW(boolean z) {
        this.hKi = z;
    }

    public av(Context context, p pVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.hKf = pVar;
        this.mNavigationBar = pVar.bAm();
        this.hKe = pVar.ccp();
        this.hKg = hVar;
        Iv();
        this.hKk = new com.baidu.tieba.f.b(context);
        this.hKk.a(this.heG);
    }

    public void cdG() {
        R(false, false);
    }

    public void cdH() {
        R(false, true);
    }

    public void R(boolean z, boolean z2) {
        if (this.hKe != null && this.hKf != null && this.hKf.ccz() != null && this.hKf.ccz().cfl()) {
            Q(false, true);
        }
    }

    public void cdI() {
        if (this.hKe != null && this.hKf != null && this.hKf.ccz() != null && !this.hKf.ccz().cfl()) {
            Q(true, true);
        }
    }

    public void bmR() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bmS() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cdJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cdK() {
        return cd(this.hKe);
    }

    private boolean cd(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void Q(boolean z, boolean z2) {
        if (this.hKf != null) {
            this.hKf.Q(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.hKi && this.hKj && this.hKe != null && this.eKV >= this.hKh) {
            bmS();
        }
    }

    public void showFloatingView() {
        if (this.hKi && this.hKj && this.hKe != null) {
            bmR();
        }
    }

    private void Iv() {
        if (this.hKf != null && this.hKf.IA() != null) {
            View IA = this.hKf.IA();
            if (this.biY && IA.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = IA.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                IA.setLayoutParams(layoutParams);
                co(true);
                return;
            }
            co(false);
        }
    }

    private void co(boolean z) {
        if (this.hKf != null && this.hKf.IA() != null) {
            View IA = this.hKf.IA();
            if (this.biY && z && IA.getVisibility() != 0) {
                IA.setVisibility(0);
            } else if (!z && IA.getVisibility() != 8) {
                IA.setVisibility(8);
            }
        }
    }
}
