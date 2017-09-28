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
    private com.baidu.tieba.e.b ctE;
    private ViewGroup ctw;
    private i cty;
    private com.baidu.tieba.frs.h.f ctz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aLW = 0;
    private int ctA = 0;
    private boolean ctC = true;
    private boolean ctD = true;
    private boolean aLX = false;
    private final Handler.Callback ctF = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.ail()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.aik();
                    return true;
                case 2:
                    an.this.aii();
                    return true;
                case 3:
                    an.this.aij();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.ctF);
    private a.InterfaceC0081a caG = new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            if (Q(i2)) {
                an.this.eK(false);
                an.this.showFloatingView();
            }
            if (an.this.cty != null) {
                an.this.cty.eG(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            if (Q(i2)) {
                an.this.eK(true);
                an.this.hideFloatingView();
            }
            if (an.this.cty != null) {
                an.this.cty.eG(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }

        private boolean Q(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean ctB = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b aih() {
        return this.ctE;
    }

    public void eK(boolean z) {
        this.aLX = z;
    }

    public void eL(boolean z) {
        this.ctC = z;
    }

    public an(Context context, i iVar, com.baidu.tieba.frs.h.f fVar) {
        this.mContext = context;
        this.cty = iVar;
        this.mNavigationBar = iVar.ahj();
        this.ctw = iVar.ahp();
        this.ctz = fVar;
        aim();
        eM(false);
        this.ctE = new com.baidu.tieba.e.b(context);
        this.ctE.a(this.caG);
    }

    public void aii() {
        v(false, false);
    }

    public void aij() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.ctw != null && this.cty != null && this.cty.aht() != null && this.cty.aht().ajo()) {
            u(false, true);
        }
    }

    public void aik() {
        if (this.ctw != null && this.cty != null && this.cty.aht() != null && !this.cty.aht().ajo()) {
            u(true, true);
        }
    }

    public void GP() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GQ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GR() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean ail() {
        return aq(this.ctw);
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void u(boolean z, boolean z2) {
        if (this.cty != null) {
            this.cty.u(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.ctC && this.ctD && this.ctw != null && this.aLW >= this.ctA) {
            GQ();
        }
    }

    public void showFloatingView() {
        if (this.ctC && this.ctD && this.ctw != null) {
            GP();
        }
    }

    private void aim() {
        if (this.cty != null && this.cty.ahq() != null) {
            View ahq = this.cty.ahq();
            if (this.ctB && ahq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = ahq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                ahq.setLayoutParams(layoutParams);
                eM(true);
                return;
            }
            eM(false);
        }
    }

    private void eM(boolean z) {
        if (this.cty != null && this.cty.ahq() != null) {
            View ahq = this.cty.ahq();
            if (this.ctB && z && ahq.getVisibility() != 0) {
                ahq.setVisibility(0);
            } else if (!z && ahq.getVisibility() != 8) {
                ahq.setVisibility(8);
            }
        }
    }
}
