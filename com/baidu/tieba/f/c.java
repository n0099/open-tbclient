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
    private a ced;
    private Animation cee;
    private Animation cef;
    private View ceg;
    private View ceh;
    private Context mContext;
    private boolean awB = false;
    private int aMx = 0;
    private boolean aMy = false;
    private boolean cej = true;
    private final Handler.Callback cek = new Handler.Callback() { // from class: com.baidu.tieba.f.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && c.this.adJ()) {
                c.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    c.this.adI();
                    return true;
                case 2:
                    c.this.adG();
                    return true;
                case 3:
                    c.this.adH();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cek);
    private boolean cei = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void et(boolean z);
    }

    public void er(boolean z) {
        this.aMy = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.ceg = view;
        this.ceh = view2;
        adK();
        es(false);
    }

    private void adE() {
        this.cee = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_out);
        this.cee.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.ceg != null) {
                    c.this.ceg.clearAnimation();
                    c.this.ceg.setVisibility(8);
                    c.this.es(true);
                    if (c.this.ced != null) {
                        c.this.ced.et(false);
                    }
                }
            }
        });
    }

    private void adF() {
        this.cef = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_in);
        this.cef.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.ceg != null) {
                    c.this.ceg.clearAnimation();
                    c.this.ceg.setVisibility(0);
                    c.this.es(false);
                    if (c.this.ced != null) {
                        c.this.ced.et(true);
                    }
                }
            }
        });
    }

    public void adG() {
        r(false, false);
    }

    public void adH() {
        r(false, true);
    }

    public void r(boolean z, boolean z2) {
        if (this.ceg != null && this.ceg.getVisibility() == 0 && !adJ()) {
            if (z2) {
                this.ceg.setVisibility(8);
                return;
            }
            if (this.cee == null) {
                adE();
            }
            if (this.cef != null) {
                this.cef.cancel();
            }
            this.ceg.startAnimation(this.cee);
        }
    }

    public void adI() {
        if (this.ceg != null && this.ceg.getVisibility() != 0 && !adJ()) {
            this.ceg.setVisibility(0);
            if (this.cef == null) {
                adF();
            }
            if (this.cee != null) {
                this.cee.cancel();
            }
            this.ceg.startAnimation(this.cef);
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

    public boolean adJ() {
        return aq(this.ceg);
    }

    private boolean aq(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.cej) {
            if (this.awB) {
                es(true);
            } else if (this.ceg != null && this.ceg.getVisibility() != 8) {
                Hm();
            }
        }
    }

    public void showFloatingView() {
        if (this.cej) {
            if (this.awB) {
                es(true);
            } else if (this.ceg != null && this.ceg.getVisibility() != 0) {
                Hl();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cej && this.ceg != null) {
            if (i > this.aMx && this.ceg.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMx && this.ceg.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMx = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.cej) {
            if (this.awB) {
                es(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMx) {
                    Hm();
                } else if (firstVisiblePosition < this.aMx) {
                    Hl();
                } else if (firstVisiblePosition == this.aMx) {
                    if (!this.aMy || a(absListView)) {
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

    private void adK() {
        if (this.ceh != null) {
            if (this.cei && this.ceh.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.ceh.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.ceh.setLayoutParams(layoutParams);
                es(true);
                return;
            }
            es(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.ceh != null) {
            if (this.cei && z && this.ceh.getVisibility() != 0) {
                this.ceh.setVisibility(0);
            } else if (!z && this.ceh.getVisibility() != 8) {
                this.ceh.setVisibility(8);
            }
        }
    }
}
