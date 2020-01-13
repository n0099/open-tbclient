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
/* loaded from: classes7.dex */
public class al {
    private ViewGroup gqf;
    private l gqg;
    private com.baidu.tieba.frs.vc.h gqh;
    private com.baidu.tieba.f.b gql;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int dCH = 0;
    private int gqi = 0;
    private boolean gqj = true;
    private boolean gqk = true;
    private boolean dCI = false;
    private final Handler.Callback gqm = new Handler.Callback() { // from class: com.baidu.tieba.frs.al.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && al.this.bEl()) {
                al.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    al.this.bEk();
                    return true;
                case 2:
                    al.this.bEi();
                    return true;
                case 3:
                    al.this.bEj();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gqm);
    private a.InterfaceC0492a fPc = new a.InterfaceC0492a() { // from class: com.baidu.tieba.frs.al.2
        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void y(int i, int i2) {
            if (aw(i2)) {
                al.this.lz(true);
                al.this.hideFloatingView();
            }
            if (al.this.gqg != null) {
                al.this.gqg.lr(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void z(int i, int i2) {
            if (aw(i2)) {
                al.this.lz(false);
                al.this.showFloatingView();
            }
            if (al.this.gqg != null) {
                al.this.gqg.lr(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void bz(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void A(int i, int i2) {
        }

        private boolean aw(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean axL = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b bEh() {
        return this.gql;
    }

    public void lz(boolean z) {
        this.dCI = z;
    }

    public void lA(boolean z) {
        this.gqj = z;
    }

    public al(Context context, l lVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.gqg = lVar;
        this.mNavigationBar = lVar.bcw();
        this.gqf = lVar.bCW();
        this.gqh = hVar;
        xO();
        this.gql = new com.baidu.tieba.f.b(context);
        this.gql.a(this.fPc);
    }

    public void bEi() {
        L(false, false);
    }

    public void bEj() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.gqf != null && this.gqg != null && this.gqg.bDg() != null && this.gqg.bDg().bFG()) {
            K(false, true);
        }
    }

    public void bEk() {
        if (this.gqf != null && this.gqg != null && this.gqg.bDg() != null && !this.gqg.bDg().bFG()) {
            K(true, true);
        }
    }

    public void aPT() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aPU() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aUq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bEl() {
        return bO(this.gqf);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void K(boolean z, boolean z2) {
        if (this.gqg != null) {
            this.gqg.K(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.gqj && this.gqk && this.gqf != null && this.dCH >= this.gqi) {
            aPU();
        }
    }

    public void showFloatingView() {
        if (this.gqj && this.gqk && this.gqf != null) {
            aPT();
        }
    }

    private void xO() {
        if (this.gqg != null && this.gqg.xT() != null) {
            View xT = this.gqg.xT();
            if (this.axL && xT.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = xT.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                xT.setLayoutParams(layoutParams);
                bk(true);
                return;
            }
            bk(false);
        }
    }

    private void bk(boolean z) {
        if (this.gqg != null && this.gqg.xT() != null) {
            View xT = this.gqg.xT();
            if (this.axL && z && xT.getVisibility() != 0) {
                xT.setVisibility(0);
            } else if (!z && xT.getVisibility() != 8) {
                xT.setVisibility(8);
            }
        }
    }
}
