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
/* loaded from: classes6.dex */
public class an {
    private com.baidu.tieba.f.b cvK;
    private ViewGroup dLG;
    private k dLH;
    private com.baidu.tieba.frs.vc.f dLI;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int biJ = 0;
    private int dLJ = 0;
    private boolean dLL = true;
    private boolean dLM = true;
    private boolean biK = false;
    private final Handler.Callback dLN = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.aCE()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aCD();
                    return true;
                case 2:
                    an.this.aCB();
                    return true;
                case 3:
                    an.this.aCC();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dLN);
    private a.InterfaceC0214a cvL = new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void aq(int i, int i2) {
            if (ag(i2)) {
                an.this.gN(false);
                an.this.showFloatingView();
            }
            if (an.this.dLH != null) {
                an.this.dLH.gE(true);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (ag(i2)) {
                an.this.gN(true);
                an.this.hideFloatingView();
            }
            if (an.this.dLH != null) {
                an.this.dLH.gE(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
        }

        private boolean ag(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean dLK = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.f.b aCA() {
        return this.cvK;
    }

    public void gN(boolean z) {
        this.biK = z;
    }

    public void gO(boolean z) {
        this.dLL = z;
    }

    public an(Context context, k kVar, com.baidu.tieba.frs.vc.f fVar) {
        this.mContext = context;
        this.dLH = kVar;
        this.mNavigationBar = kVar.abU();
        this.dLG = kVar.aBm();
        this.dLI = fVar;
        aaO();
        this.cvK = new com.baidu.tieba.f.b(context);
        this.cvK.a(this.cvL);
    }

    public void aCB() {
        C(false, false);
    }

    public void aCC() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.dLG != null && this.dLH != null && this.dLH.aBy() != null && this.dLH.aBy().aDW()) {
            B(false, true);
        }
    }

    public void aCD() {
        if (this.dLG != null && this.dLH != null && this.dLH.aBy() != null && !this.dLH.aBy().aDW()) {
            B(true, true);
        }
    }

    public void Qa() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qb() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qc() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aCE() {
        return aL(this.dLG);
    }

    private boolean aL(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void B(boolean z, boolean z2) {
        if (this.dLH != null) {
            this.dLH.B(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.dLL && this.dLM && this.dLG != null && this.biJ >= this.dLJ) {
            Qb();
        }
    }

    public void showFloatingView() {
        if (this.dLL && this.dLM && this.dLG != null) {
            Qa();
        }
    }

    private void aaO() {
        if (this.dLH != null && this.dLH.aBn() != null) {
            View aBn = this.dLH.aBn();
            if (this.dLK && aBn.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = aBn.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                aBn.setLayoutParams(layoutParams);
                gP(true);
                return;
            }
            gP(false);
        }
    }

    private void gP(boolean z) {
        if (this.dLH != null && this.dLH.aBn() != null) {
            View aBn = this.dLH.aBn();
            if (this.dLK && z && aBn.getVisibility() != 0) {
                aBn.setVisibility(0);
            } else if (!z && aBn.getVisibility() != 8) {
                aBn.setVisibility(8);
            }
        }
    }
}
