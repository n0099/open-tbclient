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
    private ViewGroup csc;
    private i csd;
    private com.baidu.tieba.frs.h.f cse;
    private com.baidu.tieba.e.b csh;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aMx = 0;
    private int csf = 0;
    private boolean cej = true;
    private boolean csg = true;
    private boolean aMy = false;
    private final Handler.Callback cek = new Handler.Callback() { // from class: com.baidu.tieba.frs.am.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && am.this.adJ()) {
                am.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    am.this.adI();
                    return true;
                case 2:
                    am.this.adG();
                    return true;
                case 3:
                    am.this.adH();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cek);
    private a.InterfaceC0082a bZO = new a.InterfaceC0082a() { // from class: com.baidu.tieba.frs.am.2
        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ag(int i, int i2) {
            if (N(i2)) {
                am.this.er(false);
                am.this.showFloatingView();
            }
            if (am.this.csd != null) {
                am.this.csd.eP(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ah(int i, int i2) {
            if (N(i2)) {
                am.this.er(true);
                am.this.hideFloatingView();
            }
            if (am.this.csd != null) {
                am.this.csd.eP(false);
            }
        }

        private boolean N(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cei = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b ahY() {
        return this.csh;
    }

    public void er(boolean z) {
        this.aMy = z;
    }

    public void eS(boolean z) {
        this.cej = z;
    }

    public am(Context context, i iVar, com.baidu.tieba.frs.h.f fVar) {
        this.mContext = context;
        this.csd = iVar;
        this.mNavigationBar = iVar.ahe();
        this.csc = iVar.ahl();
        this.cse = fVar;
        adK();
        es(false);
        this.csh = new com.baidu.tieba.e.b(context);
        this.csh.a(this.bZO);
    }

    public void adG() {
        r(false, false);
    }

    public void adH() {
        r(false, true);
    }

    public void r(boolean z, boolean z2) {
        if (this.csc != null && this.csd != null && this.csd.ahp() != null && this.csd.ahp().aiY()) {
            u(false, true);
        }
    }

    public void adI() {
        if (this.csc != null && this.csd != null && this.csd.ahp() != null && !this.csd.ahp().aiY()) {
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

    public boolean adJ() {
        return aq(this.csc);
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void u(boolean z, boolean z2) {
        if (this.csd != null) {
            this.csd.u(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cej && this.csg && this.csc != null && this.aMx >= this.csf) {
            Hm();
        }
    }

    public void showFloatingView() {
        if (this.cej && this.csg && this.csc != null) {
            Hl();
        }
    }

    private void adK() {
        if (this.csd != null && this.csd.ahm() != null) {
            View ahm = this.csd.ahm();
            if (this.cei && ahm.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = ahm.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                ahm.setLayoutParams(layoutParams);
                es(true);
                return;
            }
            es(false);
        }
    }

    private void es(boolean z) {
        if (this.csd != null && this.csd.ahm() != null) {
            View ahm = this.csd.ahm();
            if (this.cei && z && ahm.getVisibility() != 0) {
                ahm.setVisibility(0);
            } else if (!z && ahm.getVisibility() != 8) {
                ahm.setVisibility(8);
            }
        }
    }
}
