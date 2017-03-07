package com.baidu.tieba.f;

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
public class c {
    private a bHg;
    private Animation bHh;
    private Animation bHi;
    private View bHj;
    private View bHk;
    private Context mContext;
    private boolean atW = false;
    private int bHm = 0;
    private boolean bHn = false;
    private boolean bHo = true;
    private final Handler.Callback bHp = new d(this);
    private final Handler mHandler = new Handler(this.bHp);
    private boolean bHl = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dm(boolean z);
    }

    public void dk(boolean z) {
        this.bHn = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bHj = view;
        this.bHk = view2;
        WM();
        dl(false);
    }

    private void WB() {
        this.bHh = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_out);
        this.bHh.setAnimationListener(new e(this));
    }

    private void WC() {
        this.bHi = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_in);
        this.bHi.setAnimationListener(new f(this));
    }

    public void WD() {
        l(false, false);
    }

    public void WE() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bHj != null && this.bHj.getVisibility() == 0 && !WJ()) {
            if (z2) {
                this.bHj.setVisibility(8);
                return;
            }
            if (this.bHh == null) {
                WB();
            }
            if (this.bHi != null) {
                this.bHi.cancel();
            }
            this.bHj.startAnimation(this.bHh);
        }
    }

    public void WF() {
        if (this.bHj != null && this.bHj.getVisibility() != 0 && !WJ()) {
            this.bHj.setVisibility(0);
            if (this.bHi == null) {
                WC();
            }
            if (this.bHh != null) {
                this.bHh.cancel();
            }
            this.bHj.startAnimation(this.bHi);
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
        return af(this.bHj);
    }

    private boolean af(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void WK() {
        if (this.bHo) {
            if (this.atW) {
                dl(true);
            } else if (this.bHj != null && this.bHj.getVisibility() != 8) {
                WH();
            }
        }
    }

    public void WL() {
        if (this.bHo) {
            if (this.atW) {
                dl(true);
            } else if (this.bHj != null && this.bHj.getVisibility() != 0) {
                WG();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bHo && this.bHj != null) {
            if (i > this.bHm && this.bHj.getVisibility() != 8) {
                WK();
            } else if (i < this.bHm && this.bHj.getVisibility() != 0) {
                WL();
            }
            this.bHm = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bHo) {
            if (this.atW) {
                dl(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bHm) {
                    WH();
                } else if (firstVisiblePosition < this.bHm) {
                    WG();
                } else if (firstVisiblePosition == this.bHm) {
                    if (!this.bHn || b(absListView)) {
                        WG();
                    } else {
                        WH();
                    }
                }
            }
        }
    }

    public boolean b(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
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
