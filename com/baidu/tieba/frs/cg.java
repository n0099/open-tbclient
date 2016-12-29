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
import com.baidu.tbadk.util.e;
import com.baidu.tieba.d.a;
import com.baidu.tieba.frs.acrossForum.j;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cg {
    private Animation bBF;
    private Animation bBG;
    private ViewGroup bBH;
    private ax bBI;
    private com.baidu.tieba.frs.h.s bBJ;
    private j.a bBM;
    private com.baidu.tieba.d.c bBN;
    private e<Boolean> bzf;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aSJ = 0;
    private int bBK = 0;
    private boolean bsw = true;
    private boolean bBL = true;
    private boolean bsv = false;
    private final Handler.Callback bsx = new ch(this);
    private final Handler mHandler = new Handler(this.bsx);
    private a.InterfaceC0057a aMk = new ci(this);
    private boolean bsu = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.d.c Ya() {
        return this.bBN;
    }

    public void dd(boolean z) {
        this.bsv = z;
    }

    public void dF(boolean z) {
        this.bsw = z;
    }

    public void dG(boolean z) {
        this.bBL = z;
    }

    public void a(e<Boolean> eVar) {
        this.bzf = eVar;
    }

    public cg(Context context, ax axVar, com.baidu.tieba.frs.h.s sVar) {
        this.mContext = context;
        this.bBI = axVar;
        this.mNavigationBar = axVar.Ja();
        this.bBH = axVar.WU();
        this.bBJ = sVar;
        Ut();
        de(false);
        this.bBN = new com.baidu.tieba.d.c(context);
        this.bBN.a(this.aMk);
    }

    public void a(j.a aVar) {
        this.bBM = aVar;
    }

    private void Ui() {
        this.bBF = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bBF.setAnimationListener(new cj(this));
    }

    private void Uj() {
        this.bBG = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bBG.setAnimationListener(new ck(this));
    }

    public void Uk() {
        m(false, false);
    }

    public void Ul() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.bBH != null && this.bBH.getVisibility() == 0 && !Uq()) {
            if (z2) {
                this.bBH.setVisibility(8);
                return;
            }
            if (this.bBF == null) {
                Ui();
            }
            this.bBH.startAnimation(this.bBF);
            o(false, true);
        }
    }

    public void Um() {
        if (this.bBH != null && this.bBH.getVisibility() != 0 && !Uq()) {
            if (this.bBM != null) {
                this.bBM.u(this.bBH);
            }
            this.bBH.setVisibility(0);
            if (this.bBG == null) {
                Uj();
            }
            this.bBH.startAnimation(this.bBG);
            o(true, true);
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
        return ac(this.bBH);
    }

    private boolean ac(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void o(boolean z, boolean z2) {
        if (this.bBI != null) {
            this.bBI.o(z, z2);
        }
    }

    public void Ur() {
        if (this.bsw && this.bBL && this.bBH != null && this.aSJ >= this.bBK && this.bBH.getVisibility() != 8) {
            Uo();
        }
    }

    public void Us() {
        if (this.bsw && this.bBL && this.bBH != null && this.bBH.getVisibility() != 0) {
            Un();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bsw) {
            if (i > this.aSJ && i > i4 && this.bBH.getVisibility() != 8) {
                Ur();
            } else if (i < this.aSJ && this.bBH.getVisibility() != 0) {
                Us();
            }
            o(i, z);
            this.aSJ = i;
            this.bBK = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bsw && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aSJ && firstVisiblePosition > this.bBK) {
                Uo();
            } else if (firstVisiblePosition < this.aSJ) {
                Un();
            } else if (firstVisiblePosition == this.aSJ) {
                if (!this.bsv || firstVisiblePosition <= this.bBK || b(absListView)) {
                    Un();
                } else {
                    Uo();
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

    private void o(int i, boolean z) {
        if (this.bsw && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bBJ != null && this.bBJ.abN() != null && this.bBJ.abN().getView() != null) {
            int measuredHeight = this.bBJ.abN().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bBJ.abN().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    dH(false);
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                dH(false);
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                dH(true);
            }
            if ((z || i > this.bBK) && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                dH(true);
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void dH(boolean z) {
        if (this.bzf != null) {
            this.bzf.F(Boolean.valueOf(z));
        }
    }

    private void Ut() {
        if (this.bBI != null && this.bBI.WV() != null) {
            View WV = this.bBI.WV();
            if (this.bsu && WV.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = WV.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                WV.setLayoutParams(layoutParams);
                de(true);
                return;
            }
            de(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(boolean z) {
        if (this.bBI != null && this.bBI.WV() != null) {
            View WV = this.bBI.WV();
            if (this.bsu && z && WV.getVisibility() != 0) {
                WV.setVisibility(0);
            } else if (!z && WV.getVisibility() != 8) {
                WV.setVisibility(8);
            }
        }
    }
}
