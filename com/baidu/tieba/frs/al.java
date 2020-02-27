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
public class al {
    private ViewGroup gsg;
    private l gsh;
    private com.baidu.tieba.frs.vc.h gsi;
    private com.baidu.tieba.f.b gsm;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int dGL = 0;
    private int gsj = 0;
    private boolean gsk = true;
    private boolean gsl = true;
    private boolean dGM = false;
    private final Handler.Callback gsn = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.bFN()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.bFM();
                    return true;
                case 2:
                    al.this.bFK();
                    return true;
                case 3:
                    al.this.bFL();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gsn);
    private a.InterfaceC0499a fRx = new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2)) {
                al.this.lC(true);
                al.this.hideFloatingView();
            }
            if (al.this.gsh != null) {
                al.this.gsh.lu(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2)) {
                al.this.lC(false);
                al.this.showFloatingView();
            }
            if (al.this.gsh != null) {
                al.this.gsh.lu(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean aCb = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bFJ() {
        return this.gsm;
    }

    public void lC(boolean z) {
        this.dGM = z;
    }

    public void lD(boolean z) {
        this.gsk = z;
    }

    public al(Context context, l lVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.gsh = lVar;
        this.mNavigationBar = lVar.beJ();
        this.gsg = lVar.bEz();
        this.gsi = hVar;
        Af();
        this.gsm = new com.baidu.tieba.f.b(context);
        this.gsm.a(this.fRx);
    }

    public void bFK() {
        N(false, false);
    }

    public void bFL() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.gsg != null && this.gsh != null && this.gsh.bEJ() != null && this.gsh.bEJ().bHi()) {
            M(false, true);
        }
    }

    public void bFM() {
        if (this.gsg != null && this.gsh != null && this.gsh.bEJ() != null && !this.gsh.bEJ().bHi()) {
            M(true, true);
        }
    }

    public void aSk() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSl() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWG() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bFN() {
        return bO(this.gsg);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void M(boolean z, boolean z2) {
        if (this.gsh != null) {
            this.gsh.M(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.gsk && this.gsl && this.gsg != null && this.dGL >= this.gsj) {
            aSl();
        }
    }

    public void showFloatingView() {
        if (this.gsk && this.gsl && this.gsg != null) {
            aSk();
        }
    }

    private void Af() {
        if (this.gsh != null && this.gsh.Ak() != null) {
            View Ak = this.gsh.Ak();
            if (this.aCb && Ak.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Ak.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Ak.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    private void bs(boolean z) {
        if (this.gsh != null && this.gsh.Ak() != null) {
            View Ak = this.gsh.Ak();
            if (this.aCb && z && Ak.getVisibility() != 0) {
                Ak.setVisibility(0);
            } else if (!z && Ak.getVisibility() != 8) {
                Ak.setVisibility(8);
            }
        }
    }
}
