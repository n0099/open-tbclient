package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
/* renamed from: com.baidu.tieba.frs.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo {
    private Animation bIs;
    private Animation bIt;
    private View bIu;
    private bq bIv;
    private com.baidu.tieba.frs.j.p bIw;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aLv = 0;
    private int bIx = 0;
    private boolean bIz = true;
    private boolean bIA = false;
    private final Handler.Callback bIB = new dp(this);
    private final Handler mHandler = new Handler(this.bIB);
    private boolean bIy = UtilHelper.canUseStyleImmersiveSticky();

    public void dq(boolean z) {
        this.bIA = z;
    }

    public void dr(boolean z) {
        this.bIz = z;
    }

    public Cdo(Context context, bq bqVar, com.baidu.tieba.frs.j.p pVar) {
        this.mContext = context;
        this.bIv = bqVar;
        this.mNavigationBar = bqVar.WQ();
        this.bIu = bqVar.Wp();
        this.bIw = pVar;
        XD();
        ds(false);
    }

    private void Xs() {
        this.bIs = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_out);
        this.bIs.setAnimationListener(new dq(this));
    }

    private void Xt() {
        this.bIt = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_in);
        this.bIt.setAnimationListener(new dr(this));
    }

    public void Xu() {
        k(false, false);
    }

    public void Xv() {
        k(false, true);
    }

    public void k(boolean z, boolean z2) {
        if (this.bIu != null && this.bIu.getVisibility() == 0 && !XA()) {
            if (z2) {
                this.bIu.setVisibility(8);
                return;
            }
            if (this.bIs == null) {
                Xs();
            }
            this.bIu.startAnimation(this.bIs);
            j(false, true);
        }
    }

    public void Xw() {
        if (this.bIu != null && this.bIu.getVisibility() != 0 && !XA()) {
            this.bIu.setVisibility(0);
            if (this.bIt == null) {
                Xt();
            }
            this.bIu.startAnimation(this.bIt);
            j(true, true);
        }
    }

    public void Xx() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xy() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xz() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean XA() {
        return ac(this.bIu);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void j(boolean z, boolean z2) {
        if (this.bIv != null) {
            this.bIv.j(z, z2);
        }
    }

    public void XB() {
        if (this.bIz && this.bIu != null && this.aLv >= this.bIx && this.bIu.getVisibility() != 8) {
            Xy();
        }
    }

    public void XC() {
        if (this.bIz && this.bIu != null && this.bIu.getVisibility() != 0) {
            Xx();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, com.baidu.tbadk.util.e<Boolean> eVar) {
        if (this.bIz) {
            if (i > this.aLv && i > i4 && this.bIu.getVisibility() != 8) {
                XB();
            } else if (i < this.aLv && this.bIu.getVisibility() != 0) {
                XC();
            }
            a(i, eVar);
            this.aLv = i;
            this.bIx = i4;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bIz && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aLv && firstVisiblePosition > this.bIx) {
                Xy();
            } else if (firstVisiblePosition < this.aLv) {
                Xx();
            } else if (firstVisiblePosition == this.aLv) {
                if (!this.bIA || firstVisiblePosition <= this.bIx || b(absListView)) {
                    Xx();
                } else {
                    Xy();
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

    private void a(int i, com.baidu.tbadk.util.e<Boolean> eVar) {
        if (this.bIz && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bIw != null && this.bIw.aaE() != null && this.bIw.aaE().getView() != null) {
            int measuredHeight = this.bIw.aaE().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bIw.aaE().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    if (eVar != null) {
                        eVar.F(false);
                    }
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                if (eVar != null) {
                    eVar.F(false);
                }
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                if (eVar != null) {
                    eVar.F(true);
                }
            }
            if (i > this.bIx && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                if (eVar != null) {
                    eVar.F(true);
                }
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void XD() {
        if (this.bIv != null && this.bIv.Wq() != null) {
            View Wq = this.bIv.Wq();
            if (this.bIy && Wq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = Wq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                Wq.setLayoutParams(layoutParams);
                ds(true);
                return;
            }
            ds(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(boolean z) {
        if (this.bIv != null && this.bIv.Wq() != null) {
            View Wq = this.bIv.Wq();
            if (this.bIy && z && Wq.getVisibility() != 0) {
                Wq.setVisibility(0);
            } else if (!z && Wq.getVisibility() != 8) {
                Wq.setVisibility(8);
            }
        }
    }
}
