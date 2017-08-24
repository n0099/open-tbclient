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
    private a cbm;
    private Animation cbn;
    private Animation cbo;
    private View cbp;
    private View cbq;
    private Context mContext;
    private boolean axq = false;
    private int aMR = 0;
    private boolean aMS = false;
    private boolean cbs = true;
    private final Handler.Callback cbt = new Handler.Callback() { // from class: com.baidu.tieba.f.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && c.this.acL()) {
                c.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    c.this.acK();
                    return true;
                case 2:
                    c.this.acI();
                    return true;
                case 3:
                    c.this.acJ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cbt);
    private boolean cbr = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void eq(boolean z);
    }

    public void eo(boolean z) {
        this.aMS = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.cbp = view;
        this.cbq = view2;
        acM();
        ep(false);
    }

    private void acG() {
        this.cbn = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_out);
        this.cbn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.cbp != null) {
                    c.this.cbp.clearAnimation();
                    c.this.cbp.setVisibility(8);
                    c.this.ep(true);
                    if (c.this.cbm != null) {
                        c.this.cbm.eq(false);
                    }
                }
            }
        });
    }

    private void acH() {
        this.cbo = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_in);
        this.cbo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.cbp != null) {
                    c.this.cbp.clearAnimation();
                    c.this.cbp.setVisibility(0);
                    c.this.ep(false);
                    if (c.this.cbm != null) {
                        c.this.cbm.eq(true);
                    }
                }
            }
        });
    }

    public void acI() {
        q(false, false);
    }

    public void acJ() {
        q(false, true);
    }

    public void q(boolean z, boolean z2) {
        if (this.cbp != null && this.cbp.getVisibility() == 0 && !acL()) {
            if (z2) {
                this.cbp.setVisibility(8);
                return;
            }
            if (this.cbn == null) {
                acG();
            }
            if (this.cbo != null) {
                this.cbo.cancel();
            }
            this.cbp.startAnimation(this.cbn);
        }
    }

    public void acK() {
        if (this.cbp != null && this.cbp.getVisibility() != 0 && !acL()) {
            this.cbp.setVisibility(0);
            if (this.cbo == null) {
                acH();
            }
            if (this.cbn != null) {
                this.cbn.cancel();
            }
            this.cbp.startAnimation(this.cbo);
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

    public boolean acL() {
        return ai(this.cbp);
    }

    private boolean ai(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.cbs) {
            if (this.axq) {
                ep(true);
            } else if (this.cbp != null && this.cbp.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void showFloatingView() {
        if (this.cbs) {
            if (this.axq) {
                ep(true);
            } else if (this.cbp != null && this.cbp.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cbs && this.cbp != null) {
            if (i > this.aMR && this.cbp.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMR && this.cbp.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMR = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.cbs) {
            if (this.axq) {
                ep(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMR) {
                    Hn();
                } else if (firstVisiblePosition < this.aMR) {
                    Hm();
                } else if (firstVisiblePosition == this.aMR) {
                    if (!this.aMS || a(absListView)) {
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

    private void acM() {
        if (this.cbq != null) {
            if (this.cbr && this.cbq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cbq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cbq.setLayoutParams(layoutParams);
                ep(true);
                return;
            }
            ep(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(boolean z) {
        if (this.cbq != null) {
            if (this.cbr && z && this.cbq.getVisibility() != 0) {
                this.cbq.setVisibility(0);
            } else if (!z && this.cbq.getVisibility() != 8) {
                this.cbq.setVisibility(8);
            }
        }
    }
}
