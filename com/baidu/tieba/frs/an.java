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
public class an {
    private com.baidu.tieba.e.b bHH;
    private ViewGroup cKe;
    private i cKf;
    private com.baidu.tieba.frs.g.f cKg;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aNg = 0;
    private int cKh = 0;
    private boolean cKj = true;
    private boolean cKk = true;
    private boolean aNh = false;
    private final Handler.Callback cKl = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.amy()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.amx();
                    return true;
                case 2:
                    an.this.amv();
                    return true;
                case 3:
                    an.this.amw();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cKl);
    private a.InterfaceC0083a bHI = new a.InterfaceC0083a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void af(int i, int i2) {
            if (K(i2)) {
                an.this.fb(false);
                an.this.showFloatingView();
            }
            if (an.this.cKf != null) {
                an.this.cKf.eX(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ag(int i, int i2) {
            if (K(i2)) {
                an.this.fb(true);
                an.this.hideFloatingView();
            }
            if (an.this.cKf != null) {
                an.this.cKf.eX(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0083a
        public void ah(int i, int i2) {
        }

        private boolean K(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cKi = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b amu() {
        return this.bHH;
    }

    public void fb(boolean z) {
        this.aNh = z;
    }

    public void fc(boolean z) {
        this.cKj = z;
    }

    public an(Context context, i iVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.cKf = iVar;
        this.mNavigationBar = iVar.alu();
        this.cKe = iVar.alA();
        this.cKg = fVar;
        amz();
        fd(false);
        this.bHH = new com.baidu.tieba.e.b(context);
        this.bHH.a(this.bHI);
    }

    public void amv() {
        w(false, false);
    }

    public void amw() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.cKe != null && this.cKf != null && this.cKf.alE() != null && this.cKf.alE().anF()) {
            v(false, true);
        }
    }

    public void amx() {
        if (this.cKe != null && this.cKf != null && this.cKf.alE() != null && !this.cKf.alE().anF()) {
            v(true, true);
        }
    }

    public void Hn() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Ho() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hp() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean amy() {
        return av(this.cKe);
    }

    private boolean av(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void v(boolean z, boolean z2) {
        if (this.cKf != null) {
            this.cKf.v(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cKj && this.cKk && this.cKe != null && this.aNg >= this.cKh) {
            Ho();
        }
    }

    public void showFloatingView() {
        if (this.cKj && this.cKk && this.cKe != null) {
            Hn();
        }
    }

    private void amz() {
        if (this.cKf != null && this.cKf.alB() != null) {
            View alB = this.cKf.alB();
            if (this.cKi && alB.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = alB.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                alB.setLayoutParams(layoutParams);
                fd(true);
                return;
            }
            fd(false);
        }
    }

    private void fd(boolean z) {
        if (this.cKf != null && this.cKf.alB() != null) {
            View alB = this.cKf.alB();
            if (this.cKi && z && alB.getVisibility() != 0) {
                alB.setVisibility(0);
            } else if (!z && alB.getVisibility() != 8) {
                alB.setVisibility(8);
            }
        }
    }
}
