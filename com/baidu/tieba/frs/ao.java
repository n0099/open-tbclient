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
    private com.baidu.tieba.e.b bHL;
    private ViewGroup cKo;
    private j cKp;
    private com.baidu.tieba.frs.g.f cKq;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aNj = 0;
    private int cKr = 0;
    private boolean cKt = true;
    private boolean cKu = true;
    private boolean aNk = false;
    private final Handler.Callback cKv = new Handler.Callback() { // from class: com.baidu.tieba.frs.ao.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ao.this.amG()) {
                ao.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ao.this.amF();
                    return true;
                case 2:
                    ao.this.amD();
                    return true;
                case 3:
                    ao.this.amE();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cKv);
    private a.InterfaceC0097a bHM = new a.InterfaceC0097a() { // from class: com.baidu.tieba.frs.ao.2
        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ag(int i, int i2) {
            if (K(i2)) {
                ao.this.fc(false);
                ao.this.showFloatingView();
            }
            if (ao.this.cKp != null) {
                ao.this.cKp.eY(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ah(int i, int i2) {
            if (K(i2)) {
                ao.this.fc(true);
                ao.this.hideFloatingView();
            }
            if (ao.this.cKp != null) {
                ao.this.cKp.eY(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0097a
        public void ai(int i, int i2) {
        }

        private boolean K(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cKs = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b amC() {
        return this.bHL;
    }

    public void fc(boolean z) {
        this.aNk = z;
    }

    public void fd(boolean z) {
        this.cKt = z;
    }

    public ao(Context context, j jVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.cKp = jVar;
        this.mNavigationBar = jVar.alD();
        this.cKo = jVar.alI();
        this.cKq = fVar;
        amH();
        fe(false);
        this.bHL = new com.baidu.tieba.e.b(context);
        this.bHL.a(this.bHM);
    }

    public void amD() {
        w(false, false);
    }

    public void amE() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.cKo != null && this.cKp != null && this.cKp.alM() != null && this.cKp.alM().anN()) {
            v(false, true);
        }
    }

    public void amF() {
        if (this.cKo != null && this.cKp != null && this.cKp.alM() != null && !this.cKp.alM().anN()) {
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

    public boolean amG() {
        return ax(this.cKo);
    }

    private boolean ax(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void v(boolean z, boolean z2) {
        if (this.cKp != null) {
            this.cKp.v(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cKt && this.cKu && this.cKo != null && this.aNj >= this.cKr) {
            Hp();
        }
    }

    public void showFloatingView() {
        if (this.cKt && this.cKu && this.cKo != null) {
            Ho();
        }
    }

    private void amH() {
        if (this.cKp != null && this.cKp.alJ() != null) {
            View alJ = this.cKp.alJ();
            if (this.cKs && alJ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = alJ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                alJ.setLayoutParams(layoutParams);
                fe(true);
                return;
            }
            fe(false);
        }
    }

    private void fe(boolean z) {
        if (this.cKp != null && this.cKp.alJ() != null) {
            View alJ = this.cKp.alJ();
            if (this.cKs && z && alJ.getVisibility() != 0) {
                alJ.setVisibility(0);
            } else if (!z && alJ.getVisibility() != 8) {
                alJ.setVisibility(8);
            }
        }
    }
}
