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
public class at {
    private ViewGroup jfp;
    private q jfq;
    private com.baidu.tieba.frs.vc.h jfr;
    private com.baidu.tieba.f.b jfv;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int fKW = 0;
    private int jfs = 0;
    private boolean jft = true;
    private boolean jfu = true;
    private boolean fKX = false;
    private final Handler.Callback jfw = new Handler.Callback() { // from class: com.baidu.tieba.frs.at.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && at.this.cDB()) {
                at.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    at.this.cDz();
                    return true;
                case 2:
                    at.this.cDx();
                    return true;
                case 3:
                    at.this.cDy();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jfw);
    private a.InterfaceC0710a izu = new a.InterfaceC0710a() { // from class: com.baidu.tieba.frs.at.2
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            if (aA(i2)) {
                at.this.qH(true);
                at.this.hideFloatingView();
            }
            if (at.this.jfq != null) {
                at.this.jfq.qA(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            if (aA(i2)) {
                at.this.qH(false);
                at.this.showFloatingView();
            }
            if (at.this.jfq != null) {
                at.this.jfq.qA(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }

        private boolean aA(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bHA = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b cDw() {
        return this.jfv;
    }

    public void qH(boolean z) {
        this.fKX = z;
    }

    public void qI(boolean z) {
        this.jft = z;
    }

    public at(Context context, q qVar, com.baidu.tieba.frs.vc.h hVar) {
        this.mContext = context;
        this.jfq = qVar;
        this.mNavigationBar = qVar.bUz();
        this.jfp = qVar.cCd();
        this.jfr = hVar;
        SA();
        this.jfv = new com.baidu.tieba.f.b(context);
        this.jfv.a(this.izu);
    }

    public void cDx() {
        ab(false, false);
    }

    public void cDy() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.jfp != null && this.jfq != null && this.jfq.cCn() != null && this.jfq.cCn().cFo()) {
            aa(false, true);
        }
    }

    public void cDz() {
        if (this.jfp != null && this.jfq != null && this.jfq.cCn() != null && !this.jfq.cCn().cFo()) {
            aa(true, true);
        }
    }

    public void bFk() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFl() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cDA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cDB() {
        return cW(this.jfp);
    }

    private boolean cW(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void aa(boolean z, boolean z2) {
        if (this.jfq != null) {
            this.jfq.aa(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.jft && this.jfu && this.jfp != null && this.fKW >= this.jfs) {
            bFl();
        }
    }

    public void showFloatingView() {
        if (this.jft && this.jfu && this.jfp != null) {
            bFk();
        }
    }

    private void SA() {
        if (this.jfq != null && this.jfq.SF() != null) {
            View SF = this.jfq.SF();
            if (this.bHA && SF.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = SF.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                SF.setLayoutParams(layoutParams);
                de(true);
                return;
            }
            de(false);
        }
    }

    private void de(boolean z) {
        if (this.jfq != null && this.jfq.SF() != null) {
            View SF = this.jfq.SF();
            if (this.bHA && z && SF.getVisibility() != 0) {
                SF.setVisibility(0);
            } else if (!z && SF.getVisibility() != 8) {
                SF.setVisibility(8);
            }
        }
    }
}
