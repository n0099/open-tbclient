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
    private com.baidu.tieba.e.b cof;
    private ViewGroup dHq;
    private k dHr;
    private com.baidu.tieba.frs.g.f dHs;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bDk = 0;
    private int dHt = 0;
    private boolean dHv = true;
    private boolean dHw = true;
    private boolean bDl = false;
    private final Handler.Callback dHx = new Handler.Callback() { // from class: com.baidu.tieba.frs.ap.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ap.this.awv()) {
                ap.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ap.this.awu();
                    return true;
                case 2:
                    ap.this.aws();
                    return true;
                case 3:
                    ap.this.awt();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dHx);
    private a.InterfaceC0143a cog = new a.InterfaceC0143a() { // from class: com.baidu.tieba.frs.ap.2
        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
            if (af(i2)) {
                ap.this.fW(false);
                ap.this.showFloatingView();
            }
            if (ap.this.dHr != null) {
                ap.this.dHr.fT(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
            if (af(i2)) {
                ap.this.fW(true);
                ap.this.hideFloatingView();
            }
            if (ap.this.dHr != null) {
                ap.this.dHr.fT(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void ba(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dHu = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b awr() {
        return this.cof;
    }

    public void fW(boolean z) {
        this.bDl = z;
    }

    public void fX(boolean z) {
        this.dHv = z;
    }

    public ap(Context context, k kVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.dHr = kVar;
        this.mNavigationBar = kVar.avk();
        this.dHq = kVar.avr();
        this.dHs = fVar;
        XD();
        this.cof = new com.baidu.tieba.e.b(context);
        this.cof.a(this.cog);
    }

    public void aws() {
        z(false, false);
    }

    public void awt() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.dHq != null && this.dHr != null && this.dHr.avG() != null && this.dHr.avG().axz()) {
            y(false, true);
        }
    }

    public void awu() {
        if (this.dHq != null && this.dHr != null && this.dHr.avG() != null && !this.dHr.avG().axz()) {
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

    public boolean awv() {
        return bL(this.dHq);
    }

    private boolean bL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void y(boolean z, boolean z2) {
        if (this.dHr != null) {
            this.dHr.y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dHv && this.dHw && this.dHq != null && this.bDk >= this.dHt) {
            Pj();
        }
    }

    public void showFloatingView() {
        if (this.dHv && this.dHw && this.dHq != null) {
            Pi();
        }
    }

    private void XD() {
        if (this.dHr != null && this.dHr.avs() != null) {
            View avs = this.dHr.avs();
            if (this.dHu && avs.getLayoutParams() != null) {
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
        if (this.dHr != null && this.dHr.avs() != null) {
            View avs = this.dHr.avs();
            if (this.dHu && z && avs.getVisibility() != 0) {
                avs.setVisibility(0);
            } else if (!z && avs.getVisibility() != 8) {
                avs.setVisibility(8);
            }
        }
    }
}
