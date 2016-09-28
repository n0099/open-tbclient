package com.baidu.tieba.e;

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
public class c {
    private a bJs;
    private Animation bJt;
    private Animation bJu;
    private View bJv;
    private View bJw;
    private Context mContext;
    private boolean aoZ = false;
    private int aRr = 0;
    private boolean bJy = false;
    private boolean bJz = true;
    private final Handler.Callback bJA = new d(this);
    private final Handler mHandler = new Handler(this.bJA);
    private boolean bJx = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void ds(boolean z);
    }

    public void dq(boolean z) {
        this.bJy = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bJv = view;
        this.bJw = view2;
        Ze();
        dr(false);
    }

    private void YT() {
        this.bJt = AnimationUtils.loadAnimation(this.mContext, r.a.pull_up_refresh_out);
        this.bJt.setAnimationListener(new e(this));
    }

    private void YU() {
        this.bJu = AnimationUtils.loadAnimation(this.mContext, r.a.pull_up_refresh_in);
        this.bJu.setAnimationListener(new f(this));
    }

    public void YV() {
        m(false, false);
    }

    public void YW() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.bJv != null && this.bJv.getVisibility() == 0 && !Zb()) {
            if (z2) {
                this.bJv.setVisibility(8);
                return;
            }
            if (this.bJt == null) {
                YT();
            }
            if (this.bJu != null) {
                this.bJu.cancel();
            }
            this.bJv.startAnimation(this.bJt);
        }
    }

    public void YX() {
        if (this.bJv != null && this.bJv.getVisibility() != 0 && !Zb()) {
            this.bJv.setVisibility(0);
            if (this.bJu == null) {
                YU();
            }
            if (this.bJt != null) {
                this.bJt.cancel();
            }
            this.bJv.startAnimation(this.bJu);
        }
    }

    public void YY() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void YZ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Za() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Zb() {
        return ab(this.bJv);
    }

    private boolean ab(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Zc() {
        if (this.bJz) {
            if (this.aoZ) {
                dr(true);
            } else if (this.bJv != null && this.bJv.getVisibility() != 8) {
                YZ();
            }
        }
    }

    public void Zd() {
        if (this.bJz) {
            if (this.aoZ) {
                dr(true);
            } else if (this.bJv != null && this.bJv.getVisibility() != 0) {
                YY();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJz && this.bJv != null) {
            if (i > this.aRr && this.bJv.getVisibility() != 8) {
                Zc();
            } else if (i < this.aRr && this.bJv.getVisibility() != 0) {
                Zd();
            }
            this.aRr = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bJz) {
            if (this.aoZ) {
                dr(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aRr) {
                    YZ();
                } else if (firstVisiblePosition < this.aRr) {
                    YY();
                } else if (firstVisiblePosition == this.aRr) {
                    if (!this.bJy || b(absListView)) {
                        YY();
                    } else {
                        YZ();
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

    private void Ze() {
        if (this.bJw != null) {
            if (this.bJx && this.bJw.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bJw.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bJw.setLayoutParams(layoutParams);
                dr(true);
                return;
            }
            dr(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.bJw != null) {
            if (this.bJx && z && this.bJw.getVisibility() != 0) {
                this.bJw.setVisibility(0);
            } else if (!z && this.bJw.getVisibility() != 8) {
                this.bJw.setVisibility(8);
            }
        }
    }
}
