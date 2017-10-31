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
    private com.baidu.tieba.e.b bzz;
    private ViewGroup cAH;
    private i cAI;
    private com.baidu.tieba.frs.g.f cAJ;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aMx = 0;
    private int cAK = 0;
    private boolean cAM = true;
    private boolean cAN = true;
    private boolean aMy = false;
    private final Handler.Callback cAO = new Handler.Callback() { // from class: com.baidu.tieba.frs.an.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && an.this.ako()) {
                an.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    an.this.akn();
                    return true;
                case 2:
                    an.this.akl();
                    return true;
                case 3:
                    an.this.akm();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cAO);
    private a.InterfaceC0081a bzA = new a.InterfaceC0081a() { // from class: com.baidu.tieba.frs.an.2
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            if (J(i2)) {
                an.this.eF(false);
                an.this.showFloatingView();
            }
            if (an.this.cAI != null) {
                an.this.cAI.eB(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            if (J(i2)) {
                an.this.eF(true);
                an.this.hideFloatingView();
            }
            if (an.this.cAI != null) {
                an.this.cAI.eB(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }

        private boolean J(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cAL = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b akk() {
        return this.bzz;
    }

    public void eF(boolean z) {
        this.aMy = z;
    }

    public void eG(boolean z) {
        this.cAM = z;
    }

    public an(Context context, i iVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.cAI = iVar;
        this.mNavigationBar = iVar.ajm();
        this.cAH = iVar.ajs();
        this.cAJ = fVar;
        akp();
        eH(false);
        this.bzz = new com.baidu.tieba.e.b(context);
        this.bzz.a(this.bzA);
    }

    public void akl() {
        w(false, false);
    }

    public void akm() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.cAH != null && this.cAI != null && this.cAI.ajw() != null && this.cAI.ajw().alw()) {
            v(false, true);
        }
    }

    public void akn() {
        if (this.cAH != null && this.cAI != null && this.cAI.ajw() != null && !this.cAI.ajw().alw()) {
            v(true, true);
        }
    }

    public void GV() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GW() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GX() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean ako() {
        return at(this.cAH);
    }

    private boolean at(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void v(boolean z, boolean z2) {
        if (this.cAI != null) {
            this.cAI.v(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cAM && this.cAN && this.cAH != null && this.aMx >= this.cAK) {
            GW();
        }
    }

    public void showFloatingView() {
        if (this.cAM && this.cAN && this.cAH != null) {
            GV();
        }
    }

    private void akp() {
        if (this.cAI != null && this.cAI.ajt() != null) {
            View ajt = this.cAI.ajt();
            if (this.cAL && ajt.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = ajt.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                ajt.setLayoutParams(layoutParams);
                eH(true);
                return;
            }
            eH(false);
        }
    }

    private void eH(boolean z) {
        if (this.cAI != null && this.cAI.ajt() != null) {
            View ajt = this.cAI.ajt();
            if (this.cAL && z && ajt.getVisibility() != 0) {
                ajt.setVisibility(0);
            } else if (!z && ajt.getVisibility() != 8) {
                ajt.setVisibility(8);
            }
        }
    }
}
