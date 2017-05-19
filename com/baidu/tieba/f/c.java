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
    private View bIA;
    private a bIw;
    private Animation bIx;
    private Animation bIy;
    private View bIz;
    private Context mContext;
    private boolean aus = false;
    private int aJq = 0;
    private boolean aJr = false;
    private boolean bIC = true;
    private final Handler.Callback bID = new d(this);
    private final Handler mHandler = new Handler(this.bID);
    private boolean bIB = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void dz(boolean z);
    }

    public void dx(boolean z) {
        this.aJr = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.bIz = view;
        this.bIA = view2;
        Xc();
        dy(false);
    }

    private void WU() {
        this.bIx = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_out);
        this.bIx.setAnimationListener(new e(this));
    }

    private void WV() {
        this.bIy = AnimationUtils.loadAnimation(this.mContext, w.a.pull_up_refresh_in);
        this.bIy.setAnimationListener(new f(this));
    }

    public void WW() {
        l(false, false);
    }

    public void WX() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.bIz != null && this.bIz.getVisibility() == 0 && !WZ()) {
            if (z2) {
                this.bIz.setVisibility(8);
                return;
            }
            if (this.bIx == null) {
                WU();
            }
            if (this.bIy != null) {
                this.bIy.cancel();
            }
            this.bIz.startAnimation(this.bIx);
        }
    }

    public void WY() {
        if (this.bIz != null && this.bIz.getVisibility() != 0 && !WZ()) {
            this.bIz.setVisibility(0);
            if (this.bIy == null) {
                WV();
            }
            if (this.bIx != null) {
                this.bIx.cancel();
            }
            this.bIz.startAnimation(this.bIy);
        }
    }

    public void Gy() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Gz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean WZ() {
        return ad(this.bIz);
    }

    private boolean ad(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void Xa() {
        if (this.bIC) {
            if (this.aus) {
                dy(true);
            } else if (this.bIz != null && this.bIz.getVisibility() != 8) {
                Gz();
            }
        }
    }

    public void Xb() {
        if (this.bIC) {
            if (this.aus) {
                dy(true);
            } else if (this.bIz != null && this.bIz.getVisibility() != 0) {
                Gy();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bIC && this.bIz != null) {
            if (i > this.aJq && this.bIz.getVisibility() != 8) {
                Xa();
            } else if (i < this.aJq && this.bIz.getVisibility() != 0) {
                Xb();
            }
            this.aJq = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bIC) {
            if (this.aus) {
                dy(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aJq) {
                    Gz();
                } else if (firstVisiblePosition < this.aJq) {
                    Gy();
                } else if (firstVisiblePosition == this.aJq) {
                    if (!this.aJr || a(absListView)) {
                        Gy();
                    } else {
                        Gz();
                    }
                }
            }
        }
    }

    public boolean a(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void Xc() {
        if (this.bIA != null) {
            if (this.bIB && this.bIA.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bIA.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bIA.setLayoutParams(layoutParams);
                dy(true);
                return;
            }
            dy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        if (this.bIA != null) {
            if (this.bIB && z && this.bIA.getVisibility() != 0) {
                this.bIA.setVisibility(0);
            } else if (!z && this.bIA.getVisibility() != 8) {
                this.bIA.setVisibility(8);
            }
        }
    }
}
