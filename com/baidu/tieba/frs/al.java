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
    private com.baidu.tieba.f.b gsB;
    private ViewGroup gsv;
    private l gsw;
    private com.baidu.tieba.frs.vc.h gsx;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int dGZ = 0;
    private int gsy = 0;
    private boolean gsz = true;
    private boolean gsA = true;
    private boolean dHa = false;
    private final Handler.Callback gsC = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.bFQ()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.bFP();
                    return true;
                case 2:
                    al.this.bFN();
                    return true;
                case 3:
                    al.this.bFO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gsC);
    private a.InterfaceC0499a fRM = new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2)) {
                al.this.lC(true);
                al.this.hideFloatingView();
            }
            if (al.this.gsw != null) {
                al.this.gsw.lu(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2)) {
                al.this.lC(false);
                al.this.showFloatingView();
            }
            if (al.this.gsw != null) {
                al.this.gsw.lu(true);
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
    private boolean aCd = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bFM() {
        return this.gsB;
    }

    public void lC(boolean z) {
        this.dHa = z;
    }

    public void lD(boolean z) {
        this.gsz = z;
    }

    public al(Context context, l lVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.gsw = lVar;
        this.mNavigationBar = lVar.beM();
        this.gsv = lVar.bEC();
        this.gsx = hVar;
        Ah();
        this.gsB = new com.baidu.tieba.f.b(context);
        this.gsB.a(this.fRM);
    }

    public void bFN() {
        N(false, false);
    }

    public void bFO() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.gsv != null && this.gsw != null && this.gsw.bEM() != null && this.gsw.bEM().bHl()) {
            M(false, true);
        }
    }

    public void bFP() {
        if (this.gsv != null && this.gsw != null && this.gsw.bEM() != null && !this.gsw.bEM().bHl()) {
            M(true, true);
        }
    }

    public void aSn() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSo() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bFQ() {
        return bO(this.gsv);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void M(boolean z, boolean z2) {
        if (this.gsw != null) {
            this.gsw.M(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.gsz && this.gsA && this.gsv != null && this.dGZ >= this.gsy) {
            aSo();
        }
    }

    public void showFloatingView() {
        if (this.gsz && this.gsA && this.gsv != null) {
            aSn();
        }
    }

    private void Ah() {
        if (this.gsw != null && this.gsw.Am() != null) {
            View Am = this.gsw.Am();
            if (this.aCd && Am.getLayoutParams() != null) {
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
        if (this.gsw != null && this.gsw.Am() != null) {
            View Am = this.gsw.Am();
            if (this.aCd && z && Am.getVisibility() != 0) {
                Am.setVisibility(0);
            } else if (!z && Am.getVisibility() != 8) {
                Am.setVisibility(8);
            }
        }
    }
}
