package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    private View bJv;
    private Animation bTy;
    private Animation bTz;
    private View cDF;
    private Context mContext;
    private int aQi = 0;
    private boolean bJx = false;
    private final Handler.Callback bJz = new b(this);
    private final Handler mHandler = new Handler(this.bJz);
    private boolean bJw = UtilHelper.canUseStyleImmersiveSticky();

    public void dp(boolean z) {
        this.bJx = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cDF = view;
        this.bJv = view2;
        YP();
        dq(false);
    }

    private void YF() {
        this.bTy = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_out);
        this.bTy.setAnimationListener(new c(this));
    }

    private void YG() {
        this.bTz = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_in);
        this.bTz.setAnimationListener(new d(this));
    }

    public void YH() {
        m(false, false);
    }

    public void YI() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.cDF != null && this.cDF.getVisibility() == 0 && !YM()) {
            if (z2) {
                this.cDF.setVisibility(8);
                return;
            }
            if (this.bTy == null) {
                YF();
            }
            this.cDF.startAnimation(this.bTy);
        }
    }

    public void YJ() {
        if (this.cDF != null && this.cDF.getVisibility() != 0 && !YM()) {
            this.cDF.setVisibility(0);
            if (this.bTz == null) {
                YG();
            }
            this.cDF.startAnimation(this.bTz);
        }
    }

    public void YK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void YL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aco() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean YM() {
        return ac(this.cDF);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void eT(boolean z) {
        if (this.cDF != null) {
            if (z || this.cDF.getVisibility() != 8) {
                YL();
            }
        }
    }

    public void eU(boolean z) {
        if (this.cDF != null) {
            if (z || this.cDF.getVisibility() != 0) {
                YK();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cDF != null) {
            if (i != 0 && i2 > i && this.cDF.getVisibility() != 8) {
                eT(false);
            } else if ((i == 0 || i2 < i) && this.cDF.getVisibility() != 0) {
                eU(false);
            }
            this.aQi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aQi) {
                eT(true);
            } else if (firstVisiblePosition < this.aQi) {
                eU(true);
            } else if (firstVisiblePosition == this.aQi) {
                if (firstVisiblePosition == 0 || !this.bJx) {
                    eU(true);
                } else {
                    eT(true);
                }
            }
        }
    }

    private void YP() {
        if (this.bJv != null) {
            if (this.bJw && this.bJv.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bJv.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bJv.setLayoutParams(layoutParams);
                dq(true);
                return;
            }
            dq(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(boolean z) {
        if (this.bJv != null) {
            if (this.bJw && z && this.bJv.getVisibility() != 0) {
                this.bJv.setVisibility(0);
            } else if (!z && this.bJv.getVisibility() != 8) {
                this.bJv.setVisibility(8);
            }
        }
    }
}
