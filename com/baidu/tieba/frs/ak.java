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
    private com.baidu.tieba.f.b dWi;
    private ViewGroup fsS;
    private k fsT;
    private com.baidu.tieba.frs.vc.f fsU;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int cBQ = 0;
    private int fsV = 0;
    private boolean fsX = true;
    private boolean fsY = true;
    private boolean cBR = false;
    private final Handler.Callback fsZ = new Handler.Callback() { // from class: com.baidu.tieba.frs.ak.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && ak.this.blM()) {
                ak.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    ak.this.blL();
                    return true;
                case 2:
                    ak.this.blJ();
                    return true;
                case 3:
                    ak.this.blK();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fsZ);
    private a.InterfaceC0302a dWj = new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.ak.2
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (ax(i2)) {
                ak.this.kb(false);
                ak.this.showFloatingView();
            }
            if (ak.this.fsT != null) {
                ak.this.fsT.jT(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (ax(i2)) {
                ak.this.kb(true);
                ak.this.hideFloatingView();
            }
            if (ak.this.fsT != null) {
                ak.this.fsT.jT(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean fsW = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b blI() {
        return this.dWi;
    }

    public void kb(boolean z) {
        this.cBR = z;
    }

    public void kc(boolean z) {
        this.fsX = z;
    }

    public ak(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.fsT = kVar;
        this.mNavigationBar = kVar.aJz();
        this.fsS = kVar.bku();
        this.fsU = fVar;
        aIw();
        this.dWi = new com.baidu.tieba.f.b(context);
        this.dWi.a(this.dWj);
    }

    public void blJ() {
        F(false, false);
    }

    public void blK() {
        F(false, true);
    }

    public void F(boolean z, boolean z2) {
        if (this.fsS != null && this.fsT != null && this.fsT.bkF() != null && this.fsT.bkF().bnb()) {
            E(false, true);
        }
    }

    public void blL() {
        if (this.fsS != null && this.fsT != null && this.fsT.bkF() != null && !this.fsT.bkF().bnb()) {
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

    public boolean blM() {
        return bO(this.fsS);
    }

    private boolean bO(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void E(boolean z, boolean z2) {
        if (this.fsT != null) {
            this.fsT.E(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.fsX && this.fsY && this.fsS != null && this.cBQ >= this.fsV) {
            avl();
        }
    }

    public void showFloatingView() {
        if (this.fsX && this.fsY && this.fsS != null) {
            avk();
        }
    }

    private void aIw() {
        if (this.fsT != null && this.fsT.bkv() != null) {
            View bkv = this.fsT.bkv();
            if (this.fsW && bkv.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = bkv.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                bkv.setLayoutParams(layoutParams);
                kd(true);
                return;
            }
            kd(false);
        }
    }

    private void kd(boolean z) {
        if (this.fsT != null && this.fsT.bkv() != null) {
            View bkv = this.fsT.bkv();
            if (this.fsW && z && bkv.getVisibility() != 0) {
                bkv.setVisibility(0);
            } else if (!z && bkv.getVisibility() != 8) {
                bkv.setVisibility(8);
            }
        }
    }
}
