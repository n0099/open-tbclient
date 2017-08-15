package com.baidu.tieba.f;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private a cbl;
    private Animation cbm;
    private Animation cbn;
    private View cbo;
    private View cbp;
    private Context mContext;
    private boolean axp = false;
    private int aMQ = 0;
    private boolean aMR = false;
    private boolean cbr = true;
    private final Handler.Callback cbs = new Handler.Callback() { // from class: com.baidu.tieba.f.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && c.this.acP()) {
                c.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    c.this.acO();
                    return true;
                case 2:
                    c.this.acM();
                    return true;
                case 3:
                    c.this.acN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cbs);
    private boolean cbq = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void eq(boolean z);
    }

    public void eo(boolean z) {
        this.aMR = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.cbo = view;
        this.cbp = view2;
        acQ();
        ep(false);
    }

    private void acK() {
        this.cbm = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_out);
        this.cbm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.cbo != null) {
                    c.this.cbo.clearAnimation();
                    c.this.cbo.setVisibility(8);
                    c.this.ep(true);
                    if (c.this.cbl != null) {
                        c.this.cbl.eq(false);
                    }
                }
            }
        });
    }

    private void acL() {
        this.cbn = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_in);
        this.cbn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.cbo != null) {
                    c.this.cbo.clearAnimation();
                    c.this.cbo.setVisibility(0);
                    c.this.ep(false);
                    if (c.this.cbl != null) {
                        c.this.cbl.eq(true);
                    }
                }
            }
        });
    }

    public void acM() {
        q(false, false);
    }

    public void acN() {
        q(false, true);
    }

    public void q(boolean z, boolean z2) {
        if (this.cbo != null && this.cbo.getVisibility() == 0 && !acP()) {
            if (z2) {
                this.cbo.setVisibility(8);
                return;
            }
            if (this.cbm == null) {
                acK();
            }
            if (this.cbn != null) {
                this.cbn.cancel();
            }
            this.cbo.startAnimation(this.cbm);
        }
    }

    public void acO() {
        if (this.cbo != null && this.cbo.getVisibility() != 0 && !acP()) {
            this.cbo.setVisibility(0);
            if (this.cbn == null) {
                acL();
            }
            if (this.cbm != null) {
                this.cbm.cancel();
            }
            this.cbo.startAnimation(this.cbn);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hn() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Ho() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean acP() {
        return aj(this.cbo);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.cbr) {
            if (this.axp) {
                ep(true);
            } else if (this.cbo != null && this.cbo.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void showFloatingView() {
        if (this.cbr) {
            if (this.axp) {
                ep(true);
            } else if (this.cbo != null && this.cbo.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cbr && this.cbo != null) {
            if (i > this.aMQ && this.cbo.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMQ && this.cbo.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMQ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.cbr) {
            if (this.axp) {
                ep(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMQ) {
                    Hn();
                } else if (firstVisiblePosition < this.aMQ) {
                    Hm();
                } else if (firstVisiblePosition == this.aMQ) {
                    if (!this.aMR || a(absListView)) {
                        Hm();
                    } else {
                        Hn();
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

    private void acQ() {
        if (this.cbp != null) {
            if (this.cbq && this.cbp.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cbp.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cbp.setLayoutParams(layoutParams);
                ep(true);
                return;
            }
            ep(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(boolean z) {
        if (this.cbp != null) {
            if (this.cbq && z && this.cbp.getVisibility() != 0) {
                this.cbp.setVisibility(0);
            } else if (!z && this.cbp.getVisibility() != 8) {
                this.cbp.setVisibility(8);
            }
        }
    }
}
