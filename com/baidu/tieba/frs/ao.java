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
public class ao {
    private com.baidu.tieba.e.b bHP;
    private ViewGroup cKs;
    private j cKt;
    private com.baidu.tieba.frs.g.f cKu;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aNm = 0;
    private int cKv = 0;
    private boolean cKx = true;
    private boolean cKy = true;
    private boolean aNn = false;
    private final Handler.Callback cKz = new Handler.Callback() { // from class: com.baidu.tieba.frs.ao.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ao.this.amH()) {
                ao.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ao.this.amG();
                    return true;
                case 2:
                    ao.this.amE();
                    return true;
                case 3:
                    ao.this.amF();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cKz);
    private a.InterfaceC0096a bHQ = new a.InterfaceC0096a() { // from class: com.baidu.tieba.frs.ao.2
        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ag(int i, int i2) {
            if (K(i2)) {
                ao.this.fc(false);
                ao.this.showFloatingView();
            }
            if (ao.this.cKt != null) {
                ao.this.cKt.eY(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ah(int i, int i2) {
            if (K(i2)) {
                ao.this.fc(true);
                ao.this.hideFloatingView();
            }
            if (ao.this.cKt != null) {
                ao.this.cKt.eY(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ai(int i, int i2) {
        }

        private boolean K(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cKw = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b amD() {
        return this.bHP;
    }

    public void fc(boolean z) {
        this.aNn = z;
    }

    public void fd(boolean z) {
        this.cKx = z;
    }

    public ao(Context context, j jVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.cKt = jVar;
        this.mNavigationBar = jVar.alD();
        this.cKs = jVar.alJ();
        this.cKu = fVar;
        amI();
        fe(false);
        this.bHP = new com.baidu.tieba.e.b(context);
        this.bHP.a(this.bHQ);
    }

    public void amE() {
        w(false, false);
    }

    public void amF() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.cKs != null && this.cKt != null && this.cKt.alN() != null && this.cKt.alN().anO()) {
            v(false, true);
        }
    }

    public void amG() {
        if (this.cKs != null && this.cKt != null && this.cKt.alN() != null && !this.cKt.alN().anO()) {
            v(true, true);
        }
    }

    public void Ho() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hp() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean amH() {
        return ax(this.cKs);
    }

    private boolean ax(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void v(boolean z, boolean z2) {
        if (this.cKt != null) {
            this.cKt.v(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cKx && this.cKy && this.cKs != null && this.aNm >= this.cKv) {
            Hp();
        }
    }

    public void showFloatingView() {
        if (this.cKx && this.cKy && this.cKs != null) {
            Ho();
        }
    }

    private void amI() {
        if (this.cKt != null && this.cKt.alK() != null) {
            View alK = this.cKt.alK();
            if (this.cKw && alK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = alK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                alK.setLayoutParams(layoutParams);
                fe(true);
                return;
            }
            fe(false);
        }
    }

    private void fe(boolean z) {
        if (this.cKt != null && this.cKt.alK() != null) {
            View alK = this.cKt.alK();
            if (this.cKw && z && alK.getVisibility() != 0) {
                alK.setVisibility(0);
            } else if (!z && alK.getVisibility() != 8) {
                alK.setVisibility(8);
            }
        }
    }
}
