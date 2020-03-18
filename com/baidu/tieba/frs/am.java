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
public class am {
    private ViewGroup gsZ;
    private m gta;
    private com.baidu.tieba.frs.vc.h gtb;
    private com.baidu.tieba.f.b gtf;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int dHp = 0;
    private int gtc = 0;
    private boolean gtd = true;
    private boolean gte = true;
    private boolean dHq = false;
    private final Handler.Callback gtg = new Handler.Callback() { // from class: com.baidu.tieba.frs.am.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && am.this.bGb()) {
                am.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    am.this.bGa();
                    return true;
                case 2:
                    am.this.bFY();
                    return true;
                case 3:
                    am.this.bFZ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gtg);
    private a.InterfaceC0499a fSv = new a.InterfaceC0499a() { // from class: com.baidu.tieba.frs.am.2
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2)) {
                am.this.lH(true);
                am.this.hideFloatingView();
            }
            if (am.this.gta != null) {
                am.this.gta.lA(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2)) {
                am.this.lH(false);
                am.this.showFloatingView();
            }
            if (am.this.gta != null) {
                am.this.gta.lA(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bB(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean aCr = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bFX() {
        return this.gtf;
    }

    public void lH(boolean z) {
        this.dHq = z;
    }

    public void lI(boolean z) {
        this.gtd = z;
    }

    public am(Context context, m mVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.gta = mVar;
        this.mNavigationBar = mVar.beR();
        this.gsZ = mVar.bEM();
        this.gtb = hVar;
        Ao();
        this.gtf = new com.baidu.tieba.f.b(context);
        this.gtf.a(this.fSv);
    }

    public void bFY() {
        N(false, false);
    }

    public void bFZ() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.gsZ != null && this.gta != null && this.gta.bEW() != null && this.gta.bEW().bHA()) {
            M(false, true);
        }
    }

    public void bGa() {
        if (this.gsZ != null && this.gta != null && this.gta.bEW() != null && !this.gta.bEW().bHA()) {
            M(true, true);
        }
    }

    public void aSr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSs() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWN() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bGb() {
        return bO(this.gsZ);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void M(boolean z, boolean z2) {
        if (this.gta != null) {
            this.gta.M(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.gtd && this.gte && this.gsZ != null && this.dHp >= this.gtc) {
            aSs();
        }
    }

    public void showFloatingView() {
        if (this.gtd && this.gte && this.gsZ != null) {
            aSr();
        }
    }

    private void Ao() {
        if (this.gta != null && this.gta.At() != null) {
            View At = this.gta.At();
            if (this.aCr && At.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = At.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                At.setLayoutParams(layoutParams);
                bt(true);
                return;
            }
            bt(false);
        }
    }

    private void bt(boolean z) {
        if (this.gta != null && this.gta.At() != null) {
            View At = this.gta.At();
            if (this.aCr && z && At.getVisibility() != 0) {
                At.setVisibility(0);
            } else if (!z && At.getVisibility() != 8) {
                At.setVisibility(8);
            }
        }
    }
}
