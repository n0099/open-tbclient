package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class am {
    private ViewGroup csU;
    private i csV;
    private com.baidu.tieba.frs.h.f csW;
    private com.baidu.tieba.e.b csZ;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aMu = 0;
    private int csX = 0;
    private boolean cfb = true;
    private boolean csY = true;
    private boolean aMv = false;
    private final Handler.Callback cfc = new Handler.Callback() { // from class: com.baidu.tieba.frs.am.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && am.this.adU()) {
                am.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    am.this.adT();
                    return true;
                case 2:
                    am.this.adR();
                    return true;
                case 3:
                    am.this.adS();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cfc);
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.am.2
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ak(int i, int i2) {
            if (N(i2)) {
                am.this.es(false);
                am.this.showFloatingView();
            }
            if (am.this.csV != null) {
                am.this.csV.eQ(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void al(int i, int i2) {
            if (N(i2)) {
                am.this.es(true);
                am.this.hideFloatingView();
            }
            if (am.this.csV != null) {
                am.this.csV.eQ(false);
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cfa = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b aij() {
        return this.csZ;
    }

    public void es(boolean z) {
        this.aMv = z;
    }

    public void eT(boolean z) {
        this.cfb = z;
    }

    public am(Context context, i iVar, com.baidu.tieba.frs.h.f fVar) {
        this.mContext = context;
        this.csV = iVar;
        this.mNavigationBar = iVar.ahp();
        this.csU = iVar.ahw();
        this.csW = fVar;
        adV();
        et(false);
        this.csZ = new com.baidu.tieba.e.b(context);
        this.csZ.a(this.caG);
    }

    public void adR() {
        r(false, false);
    }

    public void adS() {
        r(false, true);
    }

    public void r(boolean z, boolean z2) {
        if (this.csU != null && this.csV != null && this.csV.ahA() != null && this.csV.ahA().ajj()) {
            u(false, true);
        }
    }

    public void adT() {
        if (this.csU != null && this.csV != null && this.csV.ahA() != null && !this.csV.ahA().ajj()) {
            u(true, true);
        }
    }

    public void Hl() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hn() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean adU() {
        return aq(this.csU);
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void u(boolean z, boolean z2) {
        if (this.csV != null) {
            this.csV.u(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cfb && this.csY && this.csU != null && this.aMu >= this.csX) {
            Hm();
        }
    }

    public void showFloatingView() {
        if (this.cfb && this.csY && this.csU != null) {
            Hl();
        }
    }

    private void adV() {
        if (this.csV != null && this.csV.ahx() != null) {
            View ahx = this.csV.ahx();
            if (this.cfa && ahx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = ahx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                ahx.setLayoutParams(layoutParams);
                et(true);
                return;
            }
            et(false);
        }
    }

    private void et(boolean z) {
        if (this.csV != null && this.csV.ahx() != null) {
            View ahx = this.csV.ahx();
            if (this.cfa && z && ahx.getVisibility() != 0) {
                ahx.setVisibility(0);
            } else if (!z && ahx.getVisibility() != 8) {
                ahx.setVisibility(8);
            }
        }
    }
}
