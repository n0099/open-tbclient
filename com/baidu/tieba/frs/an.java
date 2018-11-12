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
/* loaded from: classes6.dex */
public class an {
    private com.baidu.tieba.f.b crR;
    private ViewGroup dFh;
    private k dFi;
    private com.baidu.tieba.frs.vc.f dFj;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bfj = 0;
    private int dFk = 0;
    private boolean dFm = true;
    private boolean dFn = true;
    private boolean bfk = false;
    private final Handler.Callback dFo = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.aAU()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aAT();
                    return true;
                case 2:
                    an.this.aAR();
                    return true;
                case 3:
                    an.this.aAS();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dFo);
    private a.InterfaceC0204a crS = new a.InterfaceC0204a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ap(int i, int i2) {
            if (ag(i2)) {
                an.this.gM(false);
                an.this.showFloatingView();
            }
            if (an.this.dFi != null) {
                an.this.dFi.gD(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void aq(int i, int i2) {
            if (ag(i2)) {
                an.this.gM(true);
                an.this.hideFloatingView();
            }
            if (an.this.dFi != null) {
                an.this.dFi.gD(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ar(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dFl = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aAQ() {
        return this.crR;
    }

    public void gM(boolean z) {
        this.bfk = z;
    }

    public void gN(boolean z) {
        this.dFm = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dFi = kVar;
        this.mNavigationBar = kVar.aaO();
        this.dFh = kVar.azB();
        this.dFj = fVar;
        ZI();
        this.crR = new com.baidu.tieba.f.b(context);
        this.crR.a(this.crS);
    }

    public void aAR() {
        C(false, false);
    }

    public void aAS() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.dFh != null && this.dFi != null && this.dFi.azO() != null && this.dFi.azO().aCk()) {
            B(false, true);
        }
    }

    public void aAT() {
        if (this.dFh != null && this.dFi != null && this.dFi.azO() != null && !this.dFi.azO().aCk()) {
            B(true, true);
        }
    }

    public void OU() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OV() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OW() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aAU() {
        return aL(this.dFh);
    }

    private boolean aL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void B(boolean z, boolean z2) {
        if (this.dFi != null) {
            this.dFi.B(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dFm && this.dFn && this.dFh != null && this.bfj >= this.dFk) {
            OV();
        }
    }

    public void showFloatingView() {
        if (this.dFm && this.dFn && this.dFh != null) {
            OU();
        }
    }

    private void ZI() {
        if (this.dFi != null && this.dFi.azC() != null) {
            View azC = this.dFi.azC();
            if (this.dFl && azC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = azC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                azC.setLayoutParams(layoutParams);
                gO(true);
                return;
            }
            gO(false);
        }
    }

    private void gO(boolean z) {
        if (this.dFi != null && this.dFi.azC() != null) {
            View azC = this.dFi.azC();
            if (this.dFl && z && azC.getVisibility() != 0) {
                azC.setVisibility(0);
            } else if (!z && azC.getVisibility() != 8) {
                azC.setVisibility(8);
            }
        }
    }
}
