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
    private com.baidu.tieba.e.b coc;
    private ViewGroup dHl;
    private k dHm;
    private com.baidu.tieba.frs.g.f dHn;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bDh = 0;
    private int dHo = 0;
    private boolean dHq = true;
    private boolean dHr = true;
    private boolean bDi = false;
    private final Handler.Callback dHs = new Handler.Callback() { // from class: com.baidu.tieba.frs.ap.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ap.this.awt()) {
                ap.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ap.this.aws();
                    return true;
                case 2:
                    ap.this.awq();
                    return true;
                case 3:
                    ap.this.awr();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dHs);
    private a.InterfaceC0143a cod = new a.InterfaceC0143a() { // from class: com.baidu.tieba.frs.ap.2
        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
            if (af(i2)) {
                ap.this.fW(false);
                ap.this.showFloatingView();
            }
            if (ap.this.dHm != null) {
                ap.this.dHm.fT(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
            if (af(i2)) {
                ap.this.fW(true);
                ap.this.hideFloatingView();
            }
            if (ap.this.dHm != null) {
                ap.this.dHm.fT(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void ba(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dHp = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b awp() {
        return this.coc;
    }

    public void fW(boolean z) {
        this.bDi = z;
    }

    public void fX(boolean z) {
        this.dHq = z;
    }

    public ap(Context context, k kVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.dHm = kVar;
        this.mNavigationBar = kVar.avj();
        this.dHl = kVar.avq();
        this.dHn = fVar;
        XC();
        this.coc = new com.baidu.tieba.e.b(context);
        this.coc.a(this.cod);
    }

    public void awq() {
        z(false, false);
    }

    public void awr() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.dHl != null && this.dHm != null && this.dHm.avE() != null && this.dHm.avE().axx()) {
            y(false, true);
        }
    }

    public void aws() {
        if (this.dHl != null && this.dHm != null && this.dHm.avE() != null && !this.dHm.avE().axx()) {
            y(true, true);
        }
    }

    public void Ph() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Pi() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Pj() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean awt() {
        return bL(this.dHl);
    }

    private boolean bL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void y(boolean z, boolean z2) {
        if (this.dHm != null) {
            this.dHm.y(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dHq && this.dHr && this.dHl != null && this.bDh >= this.dHo) {
            Pi();
        }
    }

    public void showFloatingView() {
        if (this.dHq && this.dHr && this.dHl != null) {
            Ph();
        }
    }

    private void XC() {
        if (this.dHm != null && this.dHm.avr() != null) {
            View avr = this.dHm.avr();
            if (this.dHp && avr.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = avr.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                avr.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    private void fY(boolean z) {
        if (this.dHm != null && this.dHm.avr() != null) {
            View avr = this.dHm.avr();
            if (this.dHp && z && avr.getVisibility() != 0) {
                avr.setVisibility(0);
            } else if (!z && avr.getVisibility() != 8) {
                avr.setVisibility(8);
            }
        }
    }
}
