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
    private View bMp;
    private Animation bVx;
    private Animation bVy;
    private View cJx;
    private Context mContext;
    private int aTs = 0;
    private boolean bMr = false;
    private final Handler.Callback bMt = new b(this);
    private final Handler mHandler = new Handler(this.bMt);
    private boolean bMq = UtilHelper.canUseStyleImmersiveSticky();

    public void dv(boolean z) {
        this.bMr = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cJx = view;
        this.bMp = view2;
        aag();
        dw(false);
    }

    private void ZV() {
        this.bVx = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bVx.setAnimationListener(new c(this));
    }

    private void ZW() {
        this.bVy = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bVy.setAnimationListener(new d(this));
    }

    public void ZX() {
        l(false, false);
    }

    public void ZY() {
        l(false, true);
    }

    public void l(boolean z, boolean z2) {
        if (this.cJx != null && this.cJx.getVisibility() == 0 && !aad()) {
            if (z2) {
                this.cJx.setVisibility(8);
                return;
            }
            if (this.bVx == null) {
                ZV();
            }
            this.cJx.startAnimation(this.bVx);
        }
    }

    public void ZZ() {
        if (this.cJx != null && this.cJx.getVisibility() != 0 && !aad()) {
            this.cJx.setVisibility(0);
            if (this.bVy == null) {
                ZW();
            }
            this.cJx.startAnimation(this.bVy);
        }
    }

    public void aaa() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aab() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aac() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aad() {
        return ac(this.cJx);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void fj(boolean z) {
        if (this.cJx != null) {
            if (z || this.cJx.getVisibility() != 8) {
                aab();
            }
        }
    }

    public void fk(boolean z) {
        if (this.cJx != null) {
            if (z || this.cJx.getVisibility() != 0) {
                aaa();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cJx != null) {
            if (i != 0 && i2 > i && this.cJx.getVisibility() != 8) {
                fj(false);
            } else if ((i == 0 || i2 < i) && this.cJx.getVisibility() != 0) {
                fk(false);
            }
            this.aTs = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aTs) {
                fj(true);
            } else if (firstVisiblePosition < this.aTs) {
                fk(true);
            } else if (firstVisiblePosition == this.aTs) {
                if (firstVisiblePosition == 0 || !this.bMr) {
                    fk(true);
                } else {
                    fj(true);
                }
            }
        }
    }

    private void aag() {
        if (this.bMp != null) {
            if (this.bMq && this.bMp.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMp.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMp.setLayoutParams(layoutParams);
                dw(true);
                return;
            }
            dw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(boolean z) {
        if (this.bMp != null) {
            if (this.bMq && z && this.bMp.getVisibility() != 0) {
                this.bMp.setVisibility(0);
            } else if (!z && this.bMp.getVisibility() != 8) {
                this.bMp.setVisibility(8);
            }
        }
    }
}
