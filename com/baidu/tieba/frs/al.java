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
    private ViewGroup gsi;
    private l gsj;
    private com.baidu.tieba.frs.vc.h gsk;
    private com.baidu.tieba.f.b gso;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int dGM = 0;
    private int gsl = 0;
    private boolean gsm = true;
    private boolean gsn = true;
    private boolean dGN = false;
    private final Handler.Callback gsp = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.bFP()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.bFO();
                    return true;
                case 2:
                    al.this.bFM();
                    return true;
                case 3:
                    al.this.bFN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gsp);
    private a.InterfaceC0499a fRz = new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2)) {
                al.this.lC(true);
                al.this.hideFloatingView();
            }
            if (al.this.gsj != null) {
                al.this.gsj.lu(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2)) {
                al.this.lC(false);
                al.this.showFloatingView();
            }
            if (al.this.gsj != null) {
                al.this.gsj.lu(true);
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
    private boolean aCc = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bFL() {
        return this.gso;
    }

    public void lC(boolean z) {
        this.dGN = z;
    }

    public void lD(boolean z) {
        this.gsm = z;
    }

    public al(Context context, l lVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.gsj = lVar;
        this.mNavigationBar = lVar.beL();
        this.gsi = lVar.bEB();
        this.gsk = hVar;
        Ah();
        this.gso = new com.baidu.tieba.f.b(context);
        this.gso.a(this.fRz);
    }

    public void bFM() {
        N(false, false);
    }

    public void bFN() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.gsi != null && this.gsj != null && this.gsj.bEL() != null && this.gsj.bEL().bHk()) {
            M(false, true);
        }
    }

    public void bFO() {
        if (this.gsi != null && this.gsj != null && this.gsj.bEL() != null && !this.gsj.bEL().bHk()) {
            M(true, true);
        }
    }

    public void aSm() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSn() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bFP() {
        return bO(this.gsi);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void M(boolean z, boolean z2) {
        if (this.gsj != null) {
            this.gsj.M(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.gsm && this.gsn && this.gsi != null && this.dGM >= this.gsl) {
            aSn();
        }
    }

    public void showFloatingView() {
        if (this.gsm && this.gsn && this.gsi != null) {
            aSm();
        }
    }

    private void Ah() {
        if (this.gsj != null && this.gsj.Am() != null) {
            View Am = this.gsj.Am();
            if (this.aCc && Am.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Am.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Am.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    private void bs(boolean z) {
        if (this.gsj != null && this.gsj.Am() != null) {
            View Am = this.gsj.Am();
            if (this.aCc && z && Am.getVisibility() != 0) {
                Am.setVisibility(0);
            } else if (!z && Am.getVisibility() != 8) {
                Am.setVisibility(8);
            }
        }
    }
}
