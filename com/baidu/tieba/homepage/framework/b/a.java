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
    private View bJw;
    private Animation bTr;
    private Animation bTs;
    private View cEj;
    private Context mContext;
    private int aRr = 0;
    private boolean bJy = false;
    private final Handler.Callback bJA = new b(this);
    private final Handler mHandler = new Handler(this.bJA);
    private boolean bJx = UtilHelper.canUseStyleImmersiveSticky();

    public void dq(boolean z) {
        this.bJy = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.cEj = view;
        this.bJw = view2;
        Ze();
        dr(false);
    }

    private void YT() {
        this.bTr = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bTr.setAnimationListener(new c(this));
    }

    private void YU() {
        this.bTs = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bTs.setAnimationListener(new d(this));
    }

    public void YV() {
        m(false, false);
    }

    public void YW() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.cEj != null && this.cEj.getVisibility() == 0 && !Zb()) {
            if (z2) {
                this.cEj.setVisibility(8);
                return;
            }
            if (this.bTr == null) {
                YT();
            }
            this.cEj.startAnimation(this.bTr);
        }
    }

    public void YX() {
        if (this.cEj != null && this.cEj.getVisibility() != 0 && !Zb()) {
            this.cEj.setVisibility(0);
            if (this.bTs == null) {
                YU();
            }
            this.cEj.startAnimation(this.bTs);
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
        return ab(this.cEj);
    }

    private boolean ab(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void eU(boolean z) {
        if (this.cEj != null) {
            if (z || this.cEj.getVisibility() != 8) {
                YZ();
            }
        }
    }

    public void eV(boolean z) {
        if (this.cEj != null) {
            if (z || this.cEj.getVisibility() != 0) {
                YY();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.cEj != null) {
            if (i != 0 && i2 > i && this.cEj.getVisibility() != 8) {
                eU(false);
            } else if ((i == 0 || i2 < i) && this.cEj.getVisibility() != 0) {
                eV(false);
            }
            this.aRr = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aRr) {
                eU(true);
            } else if (firstVisiblePosition < this.aRr) {
                eV(true);
            } else if (firstVisiblePosition == this.aRr) {
                if (firstVisiblePosition == 0 || !this.bJy) {
                    eV(true);
                } else {
                    eU(true);
                }
            }
        }
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
