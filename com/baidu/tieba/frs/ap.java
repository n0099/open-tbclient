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
/* loaded from: classes2.dex */
public class ap {
    private com.baidu.tieba.e.b coo;
    private ViewGroup dHx;
    private k dHy;
    private com.baidu.tieba.frs.g.f dHz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bDu = 0;
    private int dHA = 0;
    private boolean dHC = true;
    private boolean dHD = true;
    private boolean bDv = false;
    private final Handler.Callback dHE = new Handler.Callback() { // from class: com.baidu.tieba.frs.ap.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ap.this.awu()) {
                ap.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ap.this.awt();
                    return true;
                case 2:
                    ap.this.awr();
                    return true;
                case 3:
                    ap.this.aws();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dHE);
    private a.InterfaceC0142a cop = new a.InterfaceC0142a() { // from class: com.baidu.tieba.frs.ap.2
        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aY(int i, int i2) {
            if (af(i2)) {
                ap.this.fW(false);
                ap.this.showFloatingView();
            }
            if (ap.this.dHy != null) {
                ap.this.dHy.fT(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void aZ(int i, int i2) {
            if (af(i2)) {
                ap.this.fW(true);
                ap.this.hideFloatingView();
            }
            if (ap.this.dHy != null) {
                ap.this.dHy.fT(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0142a
        public void ba(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dHB = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b awq() {
        return this.coo;
    }

    public void fW(boolean z) {
        this.bDv = z;
    }

    public void fX(boolean z) {
        this.dHC = z;
    }

    public ap(Context context, k kVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.dHy = kVar;
        this.mNavigationBar = kVar.avk();
        this.dHx = kVar.avr();
        this.dHz = fVar;
        XD();
        this.coo = new com.baidu.tieba.e.b(context);
        this.coo.a(this.cop);
    }

    public void awr() {
        z(false, false);
    }

    public void aws() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.dHx != null && this.dHy != null && this.dHy.avF() != null && this.dHy.avF().axy()) {
            y(false, true);
        }
    }

    public void awt() {
        if (this.dHx != null && this.dHy != null && this.dHy.avF() != null && !this.dHy.avF().axy()) {
            y(true, true);
        }
    }

    public void Pi() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Pj() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Pk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean awu() {
        return bL(this.dHx);
    }

    private boolean bL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void y(boolean z, boolean z2) {
        if (this.dHy != null) {
            this.dHy.y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dHC && this.dHD && this.dHx != null && this.bDu >= this.dHA) {
            Pj();
        }
    }

    public void showFloatingView() {
        if (this.dHC && this.dHD && this.dHx != null) {
            Pi();
        }
    }

    private void XD() {
        if (this.dHy != null && this.dHy.avs() != null) {
            View avs = this.dHy.avs();
            if (this.dHB && avs.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = avs.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                avs.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    private void fY(boolean z) {
        if (this.dHy != null && this.dHy.avs() != null) {
            View avs = this.dHy.avs();
            if (this.dHB && z && avs.getVisibility() != 0) {
                avs.setVisibility(0);
            } else if (!z && avs.getVisibility() != 8) {
                avs.setVisibility(8);
            }
        }
    }
}
