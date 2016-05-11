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
public class fk {
    private Animation bmG;
    private Animation bmH;
    private View bmI;
    private cn bmJ;
    private com.baidu.tieba.frs.h.m bmK;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int bmL = 0;
    private int bmM = 0;
    private boolean bmO = true;
    private boolean bmP = false;
    private final Handler.Callback bmQ = new fl(this);
    private final Handler mHandler = new Handler(this.bmQ);
    private boolean bmN = UtilHelper.canUseStyleImmersiveSticky();

    public void cX(boolean z) {
        this.bmP = z;
    }

    public void cY(boolean z) {
        this.bmO = z;
    }

    public fk(Context context, cn cnVar, com.baidu.tieba.frs.h.m mVar) {
        this.mContext = context;
        this.bmJ = cnVar;
        this.mNavigationBar = cnVar.Rf();
        this.bmI = cnVar.QA();
        this.bmK = mVar;
        RT();
        cZ(false);
    }

    private void RI() {
        this.bmG = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_out);
        this.bmG.setAnimationListener(new fm(this));
    }

    private void RJ() {
        this.bmH = AnimationUtils.loadAnimation(this.mContext, t.a.bavigationbar_slide_in);
        this.bmH.setAnimationListener(new fn(this));
    }

    public void RK() {
        j(false, false);
    }

    public void RL() {
        j(false, true);
    }

    public void j(boolean z, boolean z2) {
        if (this.bmI != null && this.bmI.getVisibility() == 0 && !RQ()) {
            if (z2) {
                this.bmI.setVisibility(8);
                return;
            }
            if (this.bmG == null) {
                RI();
            }
            this.bmI.startAnimation(this.bmG);
            i(false, true);
        }
    }

    public void RM() {
        if (this.bmI != null && this.bmI.getVisibility() != 0 && !RQ()) {
            this.bmI.setVisibility(0);
            if (this.bmH == null) {
                RJ();
            }
            this.bmI.startAnimation(this.bmH);
            i(true, true);
        }
    }

    public void RN() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void RO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void RP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean RQ() {
        return ac(this.bmI);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void i(boolean z, boolean z2) {
        if (this.bmJ != null) {
            this.bmJ.i(z, z2);
        }
    }

    public void RR() {
        if (this.bmO && this.bmI != null && this.bmL >= this.bmM && this.bmI.getVisibility() != 8) {
            RO();
            cZ(true);
        }
    }

    public void RS() {
        if (this.bmO && this.bmI != null && this.bmI.getVisibility() != 0) {
            RN();
            cZ(false);
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, com.baidu.tbadk.util.e<Boolean> eVar) {
        if (this.bmO) {
            if (i > this.bmL && i > i4 && this.bmI.getVisibility() != 8) {
                RR();
            } else if (i < this.bmL && this.bmI.getVisibility() != 0) {
                RS();
            }
            a(i, eVar);
            this.bmL = i;
            this.bmM = i4;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bmO && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.bmL && firstVisiblePosition > this.bmM) {
                RO();
            } else if (firstVisiblePosition < this.bmL) {
                RN();
            } else if (firstVisiblePosition == this.bmL) {
                if (!this.bmP || firstVisiblePosition <= this.bmM || b(absListView)) {
                    RN();
                } else {
                    RO();
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
        if (this.bmO && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bmK != null && this.bmK.TJ() != null && this.bmK.TJ().getView() != null) {
            int measuredHeight = this.bmK.TJ().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bmK.TJ().getView().getTop());
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
            if (i > this.bmM && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                if (eVar != null) {
                    eVar.C(false);
                }
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
            if (i != 0 && this.bmL >= this.bmM && this.bmN) {
                cZ(true);
            } else {
                cZ(false);
            }
        }
    }

    private void RT() {
        if (this.bmJ != null && this.bmJ.QB() != null) {
            View QB = this.bmJ.QB();
            if (this.bmN && QB.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = QB.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                QB.setLayoutParams(layoutParams);
                cZ(true);
                return;
            }
            cZ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(boolean z) {
        if (this.bmJ != null && this.bmJ.QB() != null) {
            View QB = this.bmJ.QB();
            if (this.bmN && z && QB.getVisibility() != 0) {
                QB.setVisibility(0);
            } else if (!z && QB.getVisibility() != 8) {
                QB.setVisibility(8);
            }
        }
    }
}
