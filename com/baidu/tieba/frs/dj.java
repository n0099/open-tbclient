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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dj {
    private View bTA;
    private bm bTB;
    private com.baidu.tieba.frs.i.p bTC;
    private Animation bTy;
    private Animation bTz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aQi = 0;
    private int bTD = 0;
    private boolean bJy = true;
    private boolean bJx = false;
    private final Handler.Callback bJz = new dk(this);
    private final Handler mHandler = new Handler(this.bJz);
    private boolean bJw = UtilHelper.canUseStyleImmersiveSticky();

    public void dp(boolean z) {
        this.bJx = z;
    }

    public void dO(boolean z) {
        this.bJy = z;
    }

    public dj(Context context, bm bmVar, com.baidu.tieba.frs.i.p pVar) {
        this.mContext = context;
        this.bTB = bmVar;
        this.mNavigationBar = bmVar.abM();
        this.bTA = bmVar.abm();
        this.bTC = pVar;
        YP();
        dq(false);
    }

    private void YF() {
        this.bTy = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_out);
        this.bTy.setAnimationListener(new dl(this));
    }

    private void YG() {
        this.bTz = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_in);
        this.bTz.setAnimationListener(new dm(this));
    }

    public void YH() {
        m(false, false);
    }

    public void YI() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.bTA != null && this.bTA.getVisibility() == 0 && !YM()) {
            if (z2) {
                this.bTA.setVisibility(8);
                return;
            }
            if (this.bTy == null) {
                YF();
            }
            this.bTA.startAnimation(this.bTy);
            n(false, true);
        }
    }

    public void YJ() {
        if (this.bTA != null && this.bTA.getVisibility() != 0 && !YM()) {
            this.bTA.setVisibility(0);
            if (this.bTz == null) {
                YG();
            }
            this.bTA.startAnimation(this.bTz);
            n(true, true);
        }
    }

    public void YK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void YL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aco() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean YM() {
        return ac(this.bTA);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(boolean z, boolean z2) {
        if (this.bTB != null) {
            this.bTB.n(z, z2);
        }
    }

    public void YN() {
        if (this.bJy && this.bTA != null && this.aQi >= this.bTD && this.bTA.getVisibility() != 8) {
            YL();
        }
    }

    public void YO() {
        if (this.bJy && this.bTA != null && this.bTA.getVisibility() != 0) {
            YK();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, com.baidu.tbadk.util.e<Boolean> eVar) {
        if (this.bJy) {
            if (i > this.aQi && i > i4 && this.bTA.getVisibility() != 8) {
                YN();
            } else if (i < this.aQi && this.bTA.getVisibility() != 0) {
                YO();
            }
            a(i, eVar);
            this.aQi = i;
            this.bTD = i4;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bJy && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aQi && firstVisiblePosition > this.bTD) {
                YL();
            } else if (firstVisiblePosition < this.aQi) {
                YK();
            } else if (firstVisiblePosition == this.aQi) {
                if (!this.bJx || firstVisiblePosition <= this.bTD || b(absListView)) {
                    YK();
                } else {
                    YL();
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
        if (this.bJy && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bTC != null && this.bTC.afp() != null && this.bTC.afp().getView() != null) {
            int measuredHeight = this.bTC.afp().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bTC.afp().getView().getTop());
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
            if (i > this.bTD && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
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

    private void YP() {
        if (this.bTB != null && this.bTB.abn() != null) {
            View abn = this.bTB.abn();
            if (this.bJw && abn.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = abn.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                abn.setLayoutParams(layoutParams);
                dq(true);
                return;
            }
            dq(false);
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.frs.dm.onAnimationEnd(android.view.animation.Animation):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(dj djVar, boolean z) {
        djVar.dq(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(boolean z) {
        if (this.bTB != null && this.bTB.abn() != null) {
            View abn = this.bTB.abn();
            if (this.bJw && z && abn.getVisibility() != 0) {
                abn.setVisibility(0);
            } else if (!z && abn.getVisibility() != 8) {
                abn.setVisibility(8);
            }
        }
    }
}
