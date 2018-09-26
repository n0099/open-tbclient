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
    private com.baidu.tieba.f.b bPP;
    private ViewGroup dvQ;
    private k dvR;
    private com.baidu.tieba.frs.vc.f dvS;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aZU = 0;
    private int dvT = 0;
    private boolean dvV = true;
    private boolean dvW = true;
    private boolean aZV = false;
    private final Handler.Callback dvX = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.ayb()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aya();
                    return true;
                case 2:
                    an.this.axY();
                    return true;
                case 3:
                    an.this.axZ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dvX);
    private a.InterfaceC0145a bPQ = new a.InterfaceC0145a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ac(int i, int i2) {
            if (af(i2)) {
                an.this.gk(false);
                an.this.showFloatingView();
            }
            if (an.this.dvR != null) {
                an.this.dvR.gb(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ad(int i, int i2) {
            if (af(i2)) {
                an.this.gk(true);
                an.this.hideFloatingView();
            }
            if (an.this.dvR != null) {
                an.this.dvR.gb(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void ae(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dvU = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b axX() {
        return this.bPP;
    }

    public void gk(boolean z) {
        this.aZV = z;
    }

    public void gl(boolean z) {
        this.dvV = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dvR = kVar;
        this.mNavigationBar = kVar.WW();
        this.dvQ = kVar.awH();
        this.dvS = fVar;
        VQ();
        this.bPP = new com.baidu.tieba.f.b(context);
        this.bPP.a(this.bPQ);
    }

    public void axY() {
        z(false, false);
    }

    public void axZ() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.dvQ != null && this.dvR != null && this.dvR.awV() != null && this.dvR.awV().azw()) {
            y(false, true);
        }
    }

    public void aya() {
        if (this.dvQ != null && this.dvR != null && this.dvR.awV() != null && !this.dvR.awV().azw()) {
            y(true, true);
        }
    }

    public void MN() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void MO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void MP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean ayb() {
        return aJ(this.dvQ);
    }

    private boolean aJ(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void y(boolean z, boolean z2) {
        if (this.dvR != null) {
            this.dvR.y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dvV && this.dvW && this.dvQ != null && this.aZU >= this.dvT) {
            MO();
        }
    }

    public void showFloatingView() {
        if (this.dvV && this.dvW && this.dvQ != null) {
            MN();
        }
    }

    private void VQ() {
        if (this.dvR != null && this.dvR.awI() != null) {
            View awI = this.dvR.awI();
            if (this.dvU && awI.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = awI.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                awI.setLayoutParams(layoutParams);
                gm(true);
                return;
            }
            gm(false);
        }
    }

    private void gm(boolean z) {
        if (this.dvR != null && this.dvR.awI() != null) {
            View awI = this.dvR.awI();
            if (this.dvU && z && awI.getVisibility() != 0) {
                awI.setVisibility(0);
            } else if (!z && awI.getVisibility() != 8) {
                awI.setVisibility(8);
            }
        }
    }
}
