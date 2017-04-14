package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private View bHd;
    private Animation bPX;
    private Animation bPY;
    private View cvT;
    private Context mContext;
    private int bHf = 0;
    private boolean bHg = false;
    private final Handler.Callback bHi = new b(this);
    private final Handler mHandler = new Handler(this.bHi);
    private boolean bHe = UtilHelper.canUseStyleImmersiveSticky();

    public void dm(boolean z) {
        this.bHg = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cvT = view;
        this.bHd = view2;
        Xk();
        dn(false);
    }

    private void WZ() {
        this.bPX = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bPX.setAnimationListener(new c(this));
    }

    private void Xa() {
        this.bPY = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bPY.setAnimationListener(new d(this));
    }

    public void Xb() {
        l(false, false);
    }

    public void Xc() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.cvT != null && this.cvT.getVisibility() == 0 && !Xh()) {
            if (z2) {
                this.cvT.setVisibility(8);
                return;
            }
            if (this.bPX == null) {
                WZ();
            }
            this.cvT.startAnimation(this.bPX);
        }
    }

    public void Xd() {
        if (this.cvT != null && this.cvT.getVisibility() != 0 && !Xh()) {
            this.cvT.setVisibility(0);
            if (this.bPY == null) {
                Xa();
            }
            this.cvT.startAnimation(this.bPY);
        }
    }

    public void Xe() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Xh() {
        return af(this.cvT);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void eP(boolean z) {
        if (this.cvT != null) {
            if (z || this.cvT.getVisibility() != 8) {
                Xf();
            }
        }
    }

    public void eQ(boolean z) {
        if (this.cvT != null) {
            if (z || this.cvT.getVisibility() != 0) {
                Xe();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cvT != null) {
            if (i != 0 && i2 > i && this.cvT.getVisibility() != 8) {
                eP(false);
            } else if ((i == 0 || i2 < i) && this.cvT.getVisibility() != 0) {
                eQ(false);
            }
            this.bHf = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bHf) {
                eP(true);
            } else if (firstVisiblePosition < this.bHf) {
                eQ(true);
            } else if (firstVisiblePosition == this.bHf) {
                if (firstVisiblePosition == 0 || !this.bHg) {
                    eQ(true);
                } else {
                    eP(true);
                }
            }
        }
    }

    private void Xk() {
        if (this.bHd != null) {
            if (this.bHe && this.bHd.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHd.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHd.setLayoutParams(layoutParams);
                dn(true);
                return;
            }
            dn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(boolean z) {
        if (this.bHd != null) {
            if (this.bHe && z && this.bHd.getVisibility() != 0) {
                this.bHd.setVisibility(0);
            } else if (!z && this.bHd.getVisibility() != 8) {
                this.bHd.setVisibility(8);
            }
        }
    }
}
