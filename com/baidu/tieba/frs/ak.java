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
/* loaded from: classes4.dex */
public class ak {
    private com.baidu.tieba.f.b dMv;
    private ViewGroup fcS;
    private k fcT;
    private com.baidu.tieba.frs.vc.f fcU;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int ctH = 0;
    private int fcV = 0;
    private boolean fcX = true;
    private boolean fcY = true;
    private boolean ctI = false;
    private final Handler.Callback fcZ = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.bex()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.bew();
                    return true;
                case 2:
                    ak.this.beu();
                    return true;
                case 3:
                    ak.this.bev();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fcZ);
    private a.InterfaceC0243a dMw = new a.InterfaceC0243a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aR(int i, int i2) {
            if (av(i2)) {
                ak.this.jr(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fcT != null) {
                ak.this.fcT.jj(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aS(int i, int i2) {
            if (av(i2)) {
                ak.this.jr(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fcT != null) {
                ak.this.fcT.jj(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aT(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fcW = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bet() {
        return this.dMv;
    }

    public void jr(boolean z) {
        this.ctI = z;
    }

    public void js(boolean z) {
        this.fcX = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fcT = kVar;
        this.mNavigationBar = kVar.aDq();
        this.fcS = kVar.bdf();
        this.fcU = fVar;
        aCn();
        this.dMv = new com.baidu.tieba.f.b(context);
        this.dMv.a(this.dMw);
    }

    public void beu() {
        G(false, false);
    }

    public void bev() {
        G(false, true);
    }

    public void G(boolean z, boolean z2) {
        if (this.fcS != null && this.fcT != null && this.fcT.bdq() != null && this.fcT.bdq().bfL()) {
            F(false, true);
        }
    }

    public void bew() {
        if (this.fcS != null && this.fcT != null && this.fcT.bdq() != null && !this.fcT.bdq().bfL()) {
            F(true, true);
        }
    }

    public void aqj() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqk() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aql() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bex() {
        return bG(this.fcS);
    }

    private boolean bG(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void F(boolean z, boolean z2) {
        if (this.fcT != null) {
            this.fcT.F(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fcX && this.fcY && this.fcS != null && this.ctH >= this.fcV) {
            aqk();
        }
    }

    public void showFloatingView() {
        if (this.fcX && this.fcY && this.fcS != null) {
            aqj();
        }
    }

    private void aCn() {
        if (this.fcT != null && this.fcT.bdg() != null) {
            View bdg = this.fcT.bdg();
            if (this.fcW && bdg.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bdg.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bdg.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    private void jt(boolean z) {
        if (this.fcT != null && this.fcT.bdg() != null) {
            View bdg = this.fcT.bdg();
            if (this.fcW && z && bdg.getVisibility() != 0) {
                bdg.setVisibility(0);
            } else if (!z && bdg.getVisibility() != 8) {
                bdg.setVisibility(8);
            }
        }
    }
}
