package com.baidu.tieba.f;

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
public class c {
    private a bJr;
    private Animation bJs;
    private Animation bJt;
    private View bJu;
    private View bJv;
    private Context mContext;
    private boolean aps = false;
    private int aQi = 0;
    private boolean bJx = false;
    private boolean bJy = true;
    private final Handler.Callback bJz = new d(this);
    private final Handler mHandler = new Handler(this.bJz);
    private boolean bJw = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dr(boolean z);
    }

    public void dp(boolean z) {
        this.bJx = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bJu = view;
        this.bJv = view2;
        YP();
        dq(false);
    }

    private void YF() {
        this.bJs = AnimationUtils.loadAnimation(this.mContext, t.a.pull_up_refresh_out);
        this.bJs.setAnimationListener(new e(this));
    }

    private void YG() {
        this.bJt = AnimationUtils.loadAnimation(this.mContext, t.a.pull_up_refresh_in);
        this.bJt.setAnimationListener(new f(this));
    }

    public void YH() {
        m(false, false);
    }

    public void YI() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.bJu != null && this.bJu.getVisibility() == 0 && !YM()) {
            if (z2) {
                this.bJu.setVisibility(8);
                return;
            }
            if (this.bJs == null) {
                YF();
            }
            if (this.bJt != null) {
                this.bJt.cancel();
            }
            this.bJu.startAnimation(this.bJs);
        }
    }

    public void YJ() {
        if (this.bJu != null && this.bJu.getVisibility() != 0 && !YM()) {
            this.bJu.setVisibility(0);
            if (this.bJt == null) {
                YG();
            }
            if (this.bJs != null) {
                this.bJs.cancel();
            }
            this.bJu.startAnimation(this.bJt);
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

    public boolean YM() {
        return ac(this.bJu);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void YN() {
        if (this.bJy) {
            if (this.aps) {
                dq(true);
            } else if (this.bJu != null && this.bJu.getVisibility() != 8) {
                YL();
            }
        }
    }

    public void YO() {
        if (this.bJy) {
            if (this.aps) {
                dq(true);
            } else if (this.bJu != null && this.bJu.getVisibility() != 0) {
                YK();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJy && this.bJu != null) {
            if (i > this.aQi && this.bJu.getVisibility() != 8) {
                YN();
            } else if (i < this.aQi && this.bJu.getVisibility() != 0) {
                YO();
            }
            this.aQi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bJy) {
            if (this.aps) {
                dq(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aQi) {
                    YL();
                } else if (firstVisiblePosition < this.aQi) {
                    YK();
                } else if (firstVisiblePosition == this.aQi) {
                    if (!this.bJx || b(absListView)) {
                        YK();
                    } else {
                        YL();
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
