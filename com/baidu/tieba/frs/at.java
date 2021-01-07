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
    private ViewGroup jjX;
    private q jjY;
    private com.baidu.tieba.frs.vc.h jjZ;
    private com.baidu.tieba.f.b jkd;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fPD = 0;
    private int jka = 0;
    private boolean jkb = true;
    private boolean jkc = true;
    private boolean fPE = false;
    private final Handler.Callback jke = new Handler.Callback() { // from class: com.baidu.tieba.frs.at.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && at.this.cHt()) {
                at.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    at.this.cHr();
                    return true;
                case 2:
                    at.this.cHp();
                    return true;
                case 3:
                    at.this.cHq();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jke);
    private a.InterfaceC0727a iEb = new a.InterfaceC0727a() { // from class: com.baidu.tieba.frs.at.2
        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void G(int i, int i2) {
            if (aA(i2)) {
                at.this.qL(true);
                at.this.hideFloatingView();
            }
            if (at.this.jjY != null) {
                at.this.jjY.qE(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            if (aA(i2)) {
                at.this.qL(false);
                at.this.showFloatingView();
            }
            if (at.this.jjY != null) {
                at.this.jjY.qE(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void I(int i, int i2) {
        }

        private boolean aA(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bMm = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cHo() {
        return this.jkd;
    }

    public void qL(boolean z) {
        this.fPE = z;
    }

    public void qM(boolean z) {
        this.jkb = z;
    }

    public at(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.jjY = qVar;
        this.mNavigationBar = qVar.bYr();
        this.jjX = qVar.cFV();
        this.jjZ = hVar;
        Wt();
        this.jkd = new com.baidu.tieba.f.b(context);
        this.jkd.a(this.iEb);
    }

    public void cHp() {
        ab(false, false);
    }

    public void cHq() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.jjX != null && this.jjY != null && this.jjY.cGf() != null && this.jjY.cGf().cJg()) {
            aa(false, true);
        }
    }

    public void cHr() {
        if (this.jjX != null && this.jjY != null && this.jjY.cGf() != null && !this.jjY.cGf().cJg()) {
            aa(true, true);
        }
    }

    public void bJc() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bJd() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cHs() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cHt() {
        return cW(this.jjX);
    }

    private boolean cW(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aa(boolean z, boolean z2) {
        if (this.jjY != null) {
            this.jjY.aa(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.jkb && this.jkc && this.jjX != null && this.fPD >= this.jka) {
            bJd();
        }
    }

    public void showFloatingView() {
        if (this.jkb && this.jkc && this.jjX != null) {
            bJc();
        }
    }

    private void Wt() {
        if (this.jjY != null && this.jjY.Wy() != null) {
            View Wy = this.jjY.Wy();
            if (this.bMm && Wy.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Wy.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Wy.setLayoutParams(layoutParams);
                di(true);
                return;
            }
            di(false);
        }
    }

    private void di(boolean z) {
        if (this.jjY != null && this.jjY.Wy() != null) {
            View Wy = this.jjY.Wy();
            if (this.bMm && z && Wy.getVisibility() != 0) {
                Wy.setVisibility(0);
            } else if (!z && Wy.getVisibility() != 8) {
                Wy.setVisibility(8);
            }
        }
    }
}
