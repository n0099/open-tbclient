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
    private com.baidu.tieba.f.b dWj;
    private ViewGroup fsT;
    private k fsU;
    private com.baidu.tieba.frs.vc.f fsV;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int cBQ = 0;
    private int fsW = 0;
    private boolean fsY = true;
    private boolean fsZ = true;
    private boolean cBR = false;
    private final Handler.Callback fta = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.blP()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.blO();
                    return true;
                case 2:
                    ak.this.blM();
                    return true;
                case 3:
                    ak.this.blN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fta);
    private a.InterfaceC0302a dWk = new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (ax(i2)) {
                ak.this.kb(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fsU != null) {
                ak.this.fsU.jT(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (ax(i2)) {
                ak.this.kb(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fsU != null) {
                ak.this.fsU.jT(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fsX = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b blL() {
        return this.dWj;
    }

    public void kb(boolean z) {
        this.cBR = z;
    }

    public void kc(boolean z) {
        this.fsY = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fsU = kVar;
        this.mNavigationBar = kVar.aJC();
        this.fsT = kVar.bkx();
        this.fsV = fVar;
        aIz();
        this.dWj = new com.baidu.tieba.f.b(context);
        this.dWj.a(this.dWk);
    }

    public void blM() {
        F(false, false);
    }

    public void blN() {
        F(false, true);
    }

    public void F(boolean z, boolean z2) {
        if (this.fsT != null && this.fsU != null && this.fsU.bkI() != null && this.fsU.bkI().bne()) {
            E(false, true);
        }
    }

    public void blO() {
        if (this.fsT != null && this.fsU != null && this.fsU.bkI() != null && !this.fsU.bkI().bne()) {
            E(true, true);
        }
    }

    public void avk() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void avl() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void avm() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean blP() {
        return bO(this.fsT);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void E(boolean z, boolean z2) {
        if (this.fsU != null) {
            this.fsU.E(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fsY && this.fsZ && this.fsT != null && this.cBQ >= this.fsW) {
            avl();
        }
    }

    public void showFloatingView() {
        if (this.fsY && this.fsZ && this.fsT != null) {
            avk();
        }
    }

    private void aIz() {
        if (this.fsU != null && this.fsU.bky() != null) {
            View bky = this.fsU.bky();
            if (this.fsX && bky.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bky.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bky.setLayoutParams(layoutParams);
                kd(true);
                return;
            }
            kd(false);
        }
    }

    private void kd(boolean z) {
        if (this.fsU != null && this.fsU.bky() != null) {
            View bky = this.fsU.bky();
            if (this.fsX && z && bky.getVisibility() != 0) {
                bky.setVisibility(0);
            } else if (!z && bky.getVisibility() != 8) {
                bky.setVisibility(8);
            }
        }
    }
}
