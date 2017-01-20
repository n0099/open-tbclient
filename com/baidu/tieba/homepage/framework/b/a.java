package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a {
    private View bAe;
    private Animation bIZ;
    private Animation bJa;
    private View cvU;
    private Context mContext;
    private int bAg = 0;
    private boolean bAh = false;
    private final Handler.Callback bAj = new b(this);
    private final Handler mHandler = new Handler(this.bAj);
    private boolean bAf = UtilHelper.canUseStyleImmersiveSticky();

    public void dk(boolean z) {
        this.bAh = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cvU = view;
        this.bAe = view2;
        VO();
        dl(false);
    }

    private void VD() {
        this.bIZ = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bIZ.setAnimationListener(new c(this));
    }

    private void VE() {
        this.bJa = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bJa.setAnimationListener(new d(this));
    }

    public void VF() {
        m(false, false);
    }

    public void VG() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.cvU != null && this.cvU.getVisibility() == 0 && !VL()) {
            if (z2) {
                this.cvU.setVisibility(8);
                return;
            }
            if (this.bIZ == null) {
                VD();
            }
            this.cvU.startAnimation(this.bIZ);
        }
    }

    public void VH() {
        if (this.cvU != null && this.cvU.getVisibility() != 0 && !VL()) {
            this.cvU.setVisibility(0);
            if (this.bJa == null) {
                VE();
            }
            this.cvU.startAnimation(this.bJa);
        }
    }

    public void VI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void VJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void VK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean VL() {
        return ah(this.cvU);
    }

    private boolean ah(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void eY(boolean z) {
        if (this.cvU != null) {
            if (z || this.cvU.getVisibility() != 8) {
                VJ();
            }
        }
    }

    public void eZ(boolean z) {
        if (this.cvU != null) {
            if (z || this.cvU.getVisibility() != 0) {
                VI();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cvU != null) {
            if (i != 0 && i2 > i && this.cvU.getVisibility() != 8) {
                eY(false);
            } else if ((i == 0 || i2 < i) && this.cvU.getVisibility() != 0) {
                eZ(false);
            }
            this.bAg = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bAg) {
                eY(true);
            } else if (firstVisiblePosition < this.bAg) {
                eZ(true);
            } else if (firstVisiblePosition == this.bAg) {
                if (firstVisiblePosition == 0 || !this.bAh) {
                    eZ(true);
                } else {
                    eY(true);
                }
            }
        }
    }

    private void VO() {
        if (this.bAe != null) {
            if (this.bAf && this.bAe.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bAe.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bAe.setLayoutParams(layoutParams);
                dl(true);
                return;
            }
            dl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(boolean z) {
        if (this.bAe != null) {
            if (this.bAf && z && this.bAe.getVisibility() != 0) {
                this.bAe.setVisibility(0);
            } else if (!z && this.bAe.getVisibility() != 8) {
                this.bAe.setVisibility(8);
            }
        }
    }
}
