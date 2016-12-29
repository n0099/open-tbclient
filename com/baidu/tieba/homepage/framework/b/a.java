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
    private Animation bBF;
    private Animation bBG;
    private View bst;
    private View coS;
    private Context mContext;
    private int aSJ = 0;
    private boolean bsv = false;
    private final Handler.Callback bsx = new b(this);
    private final Handler mHandler = new Handler(this.bsx);
    private boolean bsu = UtilHelper.canUseStyleImmersiveSticky();

    public void dd(boolean z) {
        this.bsv = z;
    }

    public a(Context context, View view, View view2) {
        this.mContext = context;
        this.coS = view;
        this.bst = view2;
        Ut();
        de(false);
    }

    private void Ui() {
        this.bBF = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bBF.setAnimationListener(new c(this));
    }

    private void Uj() {
        this.bBG = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bBG.setAnimationListener(new d(this));
    }

    public void Uk() {
        m(false, false);
    }

    public void Ul() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.coS != null && this.coS.getVisibility() == 0 && !Uq()) {
            if (z2) {
                this.coS.setVisibility(8);
                return;
            }
            if (this.bBF == null) {
                Ui();
            }
            this.coS.startAnimation(this.bBF);
        }
    }

    public void Um() {
        if (this.coS != null && this.coS.getVisibility() != 0 && !Uq()) {
            this.coS.setVisibility(0);
            if (this.bBG == null) {
                Uj();
            }
            this.coS.startAnimation(this.bBG);
        }
    }

    public void Un() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Uo() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Up() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Uq() {
        return ac(this.coS);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public void eU(boolean z) {
        if (this.coS != null) {
            if (z || this.coS.getVisibility() != 8) {
                Uo();
            }
        }
    }

    public void eV(boolean z) {
        if (this.coS != null) {
            if (z || this.coS.getVisibility() != 0) {
                Un();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.coS != null) {
            if (i != 0 && i2 > i && this.coS.getVisibility() != 8) {
                eU(false);
            } else if ((i == 0 || i2 < i) && this.coS.getVisibility() != 0) {
                eV(false);
            }
            this.aSJ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aSJ) {
                eU(true);
            } else if (firstVisiblePosition < this.aSJ) {
                eV(true);
            } else if (firstVisiblePosition == this.aSJ) {
                if (firstVisiblePosition == 0 || !this.bsv) {
                    eV(true);
                } else {
                    eU(true);
                }
            }
        }
    }

    private void Ut() {
        if (this.bst != null) {
            if (this.bsu && this.bst.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bst.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bst.setLayoutParams(layoutParams);
                de(true);
                return;
            }
            de(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(boolean z) {
        if (this.bst != null) {
            if (this.bsu && z && this.bst.getVisibility() != 0) {
                this.bst.setVisibility(0);
            } else if (!z && this.bst.getVisibility() != 8) {
                this.bst.setVisibility(8);
            }
        }
    }
}
