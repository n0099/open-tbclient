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
    private a ceV;
    private Animation ceW;
    private Animation ceX;
    private View ceY;
    private View ceZ;
    private Context mContext;
    private boolean awy = false;
    private int aMu = 0;
    private boolean aMv = false;
    private boolean cfb = true;
    private final Handler.Callback cfc = new Handler.Callback() { // from class: com.baidu.tieba.f.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && c.this.adU()) {
                c.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    c.this.adT();
                    return true;
                case 2:
                    c.this.adR();
                    return true;
                case 3:
                    c.this.adS();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cfc);
    private boolean cfa = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void eu(boolean z);
    }

    public void es(boolean z) {
        this.aMv = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.ceY = view;
        this.ceZ = view2;
        adV();
        et(false);
    }

    private void adP() {
        this.ceW = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_out);
        this.ceW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.ceY != null) {
                    c.this.ceY.clearAnimation();
                    c.this.ceY.setVisibility(8);
                    c.this.et(true);
                    if (c.this.ceV != null) {
                        c.this.ceV.eu(false);
                    }
                }
            }
        });
    }

    private void adQ() {
        this.ceX = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_in);
        this.ceX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.ceY != null) {
                    c.this.ceY.clearAnimation();
                    c.this.ceY.setVisibility(0);
                    c.this.et(false);
                    if (c.this.ceV != null) {
                        c.this.ceV.eu(true);
                    }
                }
            }
        });
    }

    public void adR() {
        r(false, false);
    }

    public void adS() {
        r(false, true);
    }

    public void r(boolean z, boolean z2) {
        if (this.ceY != null && this.ceY.getVisibility() == 0 && !adU()) {
            if (z2) {
                this.ceY.setVisibility(8);
                return;
            }
            if (this.ceW == null) {
                adP();
            }
            if (this.ceX != null) {
                this.ceX.cancel();
            }
            this.ceY.startAnimation(this.ceW);
        }
    }

    public void adT() {
        if (this.ceY != null && this.ceY.getVisibility() != 0 && !adU()) {
            this.ceY.setVisibility(0);
            if (this.ceX == null) {
                adQ();
            }
            if (this.ceW != null) {
                this.ceW.cancel();
            }
            this.ceY.startAnimation(this.ceX);
        }
    }

    public void Hl() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hn() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean adU() {
        return aq(this.ceY);
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.cfb) {
            if (this.awy) {
                et(true);
            } else if (this.ceY != null && this.ceY.getVisibility() != 8) {
                Hm();
            }
        }
    }

    public void showFloatingView() {
        if (this.cfb) {
            if (this.awy) {
                et(true);
            } else if (this.ceY != null && this.ceY.getVisibility() != 0) {
                Hl();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cfb && this.ceY != null) {
            if (i > this.aMu && this.ceY.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMu && this.ceY.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMu = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.cfb) {
            if (this.awy) {
                et(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMu) {
                    Hm();
                } else if (firstVisiblePosition < this.aMu) {
                    Hl();
                } else if (firstVisiblePosition == this.aMu) {
                    if (!this.aMv || a(absListView)) {
                        Hl();
                    } else {
                        Hm();
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

    private void adV() {
        if (this.ceZ != null) {
            if (this.cfa && this.ceZ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.ceZ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.ceZ.setLayoutParams(layoutParams);
                et(true);
                return;
            }
            et(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(boolean z) {
        if (this.ceZ != null) {
            if (this.cfa && z && this.ceZ.getVisibility() != 0) {
                this.ceZ.setVisibility(0);
            } else if (!z && this.ceZ.getVisibility() != 8) {
                this.ceZ.setVisibility(8);
            }
        }
    }
}
