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
    private Animation bGW;
    private Animation bGX;
    private View bGY;
    private bq bGZ;
    private com.baidu.tieba.frs.i.p bHa;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aKC = 0;
    private int bHb = 0;
    private boolean bHd = true;
    private boolean bHe = false;
    private final Handler.Callback bHf = new dp(this);
    private final Handler mHandler = new Handler(this.bHf);
    private boolean bHc = UtilHelper.canUseStyleImmersiveSticky();

    public void dt(boolean z) {
        this.bHe = z;
    }

    public void du(boolean z) {
        this.bHd = z;
    }

    public Cdo(Context context, bq bqVar, com.baidu.tieba.frs.i.p pVar) {
        this.mContext = context;
        this.bGZ = bqVar;
        this.mNavigationBar = bqVar.Wz();
        this.bGY = bqVar.VY();
        this.bHa = pVar;
        Xl();
        dv(false);
    }

    private void Xa() {
        this.bGW = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_out);
        this.bGW.setAnimationListener(new dq(this));
    }

    private void Xb() {
        this.bGX = AnimationUtils.loadAnimation(this.mContext, u.a.bavigationbar_slide_in);
        this.bGX.setAnimationListener(new dr(this));
    }

    public void Xc() {
        k(false, false);
    }

    public void Xd() {
        k(false, true);
    }

    public void k(boolean z, boolean z2) {
        if (this.bGY != null && this.bGY.getVisibility() == 0 && !Xi()) {
            if (z2) {
                this.bGY.setVisibility(8);
                return;
            }
            if (this.bGW == null) {
                Xa();
            }
            this.bGY.startAnimation(this.bGW);
            j(false, true);
        }
    }

    public void Xe() {
        if (this.bGY != null && this.bGY.getVisibility() != 0 && !Xi()) {
            this.bGY.setVisibility(0);
            if (this.bGX == null) {
                Xb();
            }
            this.bGY.startAnimation(this.bGX);
            j(true, true);
        }
    }

    public void Xf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Xg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Xh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Xi() {
        return ae(this.bGY);
    }

    private boolean ae(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void j(boolean z, boolean z2) {
        if (this.bGZ != null) {
            this.bGZ.j(z, z2);
        }
    }

    public void Xj() {
        if (this.bHd && this.bGY != null && this.aKC >= this.bHb && this.bGY.getVisibility() != 8) {
            Xg();
        }
    }

    public void Xk() {
        if (this.bHd && this.bGY != null && this.bGY.getVisibility() != 0) {
            Xf();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, com.baidu.tbadk.util.e<Boolean> eVar) {
        if (this.bHd) {
            if (i > this.aKC && i > i4 && this.bGY.getVisibility() != 8) {
                Xj();
            } else if (i < this.aKC && this.bGY.getVisibility() != 0) {
                Xk();
            }
            a(i, eVar);
            this.aKC = i;
            this.bHb = i4;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bHd && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aKC && firstVisiblePosition > this.bHb) {
                Xg();
            } else if (firstVisiblePosition < this.aKC) {
                Xf();
            } else if (firstVisiblePosition == this.aKC) {
                if (!this.bHe || firstVisiblePosition <= this.bHb || b(absListView)) {
                    Xf();
                } else {
                    Xg();
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
        if (this.bHd && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bHa != null && this.bHa.aac() != null && this.bHa.aac().getView() != null) {
            int measuredHeight = this.bHa.aac().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bHa.aac().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    if (eVar != null) {
                        eVar.C(false);
                    }
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                if (eVar != null) {
                    eVar.C(false);
                }
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                if (eVar != null) {
                    eVar.C(true);
                }
            }
            if (i > this.bHb && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                if (eVar != null) {
                    eVar.C(true);
                }
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void Xl() {
        if (this.bGZ != null && this.bGZ.VZ() != null) {
            View VZ = this.bGZ.VZ();
            if (this.bHc && VZ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = VZ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                VZ.setLayoutParams(layoutParams);
                dv(true);
                return;
            }
            dv(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(boolean z) {
        if (this.bGZ != null && this.bGZ.VZ() != null) {
            View VZ = this.bGZ.VZ();
            if (this.bHc && z && VZ.getVisibility() != 0) {
                VZ.setVisibility(0);
            } else if (!z && VZ.getVisibility() != 8) {
                VZ.setVisibility(8);
            }
        }
    }
}
