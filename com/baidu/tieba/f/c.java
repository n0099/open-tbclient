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
    private Animation caA;
    private Animation caB;
    private View caC;
    private View caD;
    private a caz;
    private Context mContext;
    private boolean axo = false;
    private int aMP = 0;
    private boolean aMQ = false;
    private boolean caF = true;
    private final Handler.Callback caG = new Handler.Callback() { // from class: com.baidu.tieba.f.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && c.this.acu()) {
                c.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    c.this.act();
                    return true;
                case 2:
                    c.this.acr();
                    return true;
                case 3:
                    c.this.acs();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.caG);
    private boolean caE = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void ep(boolean z);
    }

    public void en(boolean z) {
        this.aMQ = z;
    }

    public c(Context context, View view, View view2) {
        this.mContext = context;
        this.caC = view;
        this.caD = view2;
        acv();
        eo(false);
    }

    private void acp() {
        this.caA = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_out);
        this.caA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.caC != null) {
                    c.this.caC.clearAnimation();
                    c.this.caC.setVisibility(8);
                    c.this.eo(true);
                    if (c.this.caz != null) {
                        c.this.caz.ep(false);
                    }
                }
            }
        });
    }

    private void acq() {
        this.caB = AnimationUtils.loadAnimation(this.mContext, d.a.pull_up_refresh_in);
        this.caB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.f.c.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (c.this.caC != null) {
                    c.this.caC.clearAnimation();
                    c.this.caC.setVisibility(0);
                    c.this.eo(false);
                    if (c.this.caz != null) {
                        c.this.caz.ep(true);
                    }
                }
            }
        });
    }

    public void acr() {
        p(false, false);
    }

    public void acs() {
        p(false, true);
    }

    public void p(boolean z, boolean z2) {
        if (this.caC != null && this.caC.getVisibility() == 0 && !acu()) {
            if (z2) {
                this.caC.setVisibility(8);
                return;
            }
            if (this.caA == null) {
                acp();
            }
            if (this.caB != null) {
                this.caB.cancel();
            }
            this.caC.startAnimation(this.caA);
        }
    }

    public void act() {
        if (this.caC != null && this.caC.getVisibility() != 0 && !acu()) {
            this.caC.setVisibility(0);
            if (this.caB == null) {
                acq();
            }
            if (this.caA != null) {
                this.caA.cancel();
            }
            this.caC.startAnimation(this.caB);
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

    public boolean acu() {
        return aj(this.caC);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void hideFloatingView() {
        if (this.caF) {
            if (this.axo) {
                eo(true);
            } else if (this.caC != null && this.caC.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void showFloatingView() {
        if (this.caF) {
            if (this.axo) {
                eo(true);
            } else if (this.caC != null && this.caC.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.caF && this.caC != null) {
            if (i > this.aMP && this.caC.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMP && this.caC.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMP = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.caF) {
            if (this.axo) {
                eo(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMP) {
                    Hn();
                } else if (firstVisiblePosition < this.aMP) {
                    Hm();
                } else if (firstVisiblePosition == this.aMP) {
                    if (!this.aMQ || a(absListView)) {
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

    private void acv() {
        if (this.caD != null) {
            if (this.caE && this.caD.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.caD.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.caD.setLayoutParams(layoutParams);
                eo(true);
                return;
            }
            eo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        if (this.caD != null) {
            if (this.caE && z && this.caD.getVisibility() != 0) {
                this.caD.setVisibility(0);
            } else if (!z && this.caD.getVisibility() != 8) {
                this.caD.setVisibility(8);
            }
        }
    }
}
