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
    private View bHk;
    private Animation bQi;
    private Animation bQj;
    private View cxt;
    private Context mContext;
    private int bHm = 0;
    private boolean bHn = false;
    private final Handler.Callback bHp = new b(this);
    private final Handler mHandler = new Handler(this.bHp);
    private boolean bHl = UtilHelper.canUseStyleImmersiveSticky();

    public void dk(boolean z) {
        this.bHn = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cxt = view;
        this.bHk = view2;
        WM();
        dl(false);
    }

    private void WB() {
        this.bQi = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_out);
        this.bQi.setAnimationListener(new c(this));
    }

    private void WC() {
        this.bQj = AnimationUtils.loadAnimation(this.mContext, w.a.bavigationbar_slide_in);
        this.bQj.setAnimationListener(new d(this));
    }

    public void WD() {
        l(false, false);
    }

    public void WE() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.cxt != null && this.cxt.getVisibility() == 0 && !WJ()) {
            if (z2) {
                this.cxt.setVisibility(8);
                return;
            }
            if (this.bQi == null) {
                WB();
            }
            this.cxt.startAnimation(this.bQi);
        }
    }

    public void WF() {
        if (this.cxt != null && this.cxt.getVisibility() != 0 && !WJ()) {
            this.cxt.setVisibility(0);
            if (this.bQj == null) {
                WC();
            }
            this.cxt.startAnimation(this.bQj);
        }
    }

    public void WG() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void WH() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void WI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean WJ() {
        return af(this.cxt);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void eP(boolean z) {
        if (this.cxt != null) {
            if (z || this.cxt.getVisibility() != 8) {
                WH();
            }
        }
    }

    public void eQ(boolean z) {
        if (this.cxt != null) {
            if (z || this.cxt.getVisibility() != 0) {
                WG();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cxt != null) {
            if (i != 0 && i2 > i && this.cxt.getVisibility() != 8) {
                eP(false);
            } else if ((i == 0 || i2 < i) && this.cxt.getVisibility() != 0) {
                eQ(false);
            }
            this.bHm = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bHm) {
                eP(true);
            } else if (firstVisiblePosition < this.bHm) {
                eQ(true);
            } else if (firstVisiblePosition == this.bHm) {
                if (firstVisiblePosition == 0 || !this.bHn) {
                    eQ(true);
                } else {
                    eP(true);
                }
            }
        }
    }

    private void WM() {
        if (this.bHk != null) {
            if (this.bHl && this.bHk.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHk.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHk.setLayoutParams(layoutParams);
                dl(true);
                return;
            }
            dl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(boolean z) {
        if (this.bHk != null) {
            if (this.bHl && z && this.bHk.getVisibility() != 0) {
                this.bHk.setVisibility(0);
            } else if (!z && this.bHk.getVisibility() != 8) {
                this.bHk.setVisibility(8);
            }
        }
    }
}
