package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class am {
    private com.baidu.tbadk.util.g<Boolean> ckc;
    private ViewGroup clV;
    private i clW;
    private com.baidu.tieba.frs.g.f clX;
    private com.baidu.tieba.e.b cma;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aMP = 0;
    private int clY = 0;
    private boolean caF = true;
    private boolean clZ = true;
    private boolean aMQ = false;
    private final Handler.Callback caG = new Handler.Callback() { // from class: com.baidu.tieba.frs.am.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && am.this.acu()) {
                am.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    am.this.act();
                    return true;
                case 2:
                    am.this.acr();
                    return true;
                case 3:
                    am.this.acs();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.caG);
    private a.InterfaceC0079a bWf = new a.InterfaceC0079a() { // from class: com.baidu.tieba.frs.am.2
        final int byc = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ah(int i, int i2) {
            if (Y(i2)) {
                am.this.en(false);
                am.this.showFloatingView();
            }
            if (am.this.clW != null) {
                am.this.clW.eK(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ai(int i, int i2) {
            if (Y(i2)) {
                am.this.en(true);
                if (Math.abs(i2) > this.byc) {
                    am.this.hideFloatingView();
                }
            }
            if (am.this.clW != null) {
                am.this.clW.eK(false);
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean caE = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b agl() {
        return this.cma;
    }

    public void en(boolean z) {
        this.aMQ = z;
    }

    public void eM(boolean z) {
        this.caF = z;
    }

    public void a(com.baidu.tbadk.util.g<Boolean> gVar) {
        this.ckc = gVar;
    }

    public am(Context context, i iVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.clW = iVar;
        this.mNavigationBar = iVar.afq();
        this.clV = iVar.afw();
        this.clX = fVar;
        acv();
        eo(false);
        this.cma = new com.baidu.tieba.e.b(context);
        this.cma.a(this.bWf);
    }

    public void acr() {
        p(false, false);
    }

    public void acs() {
        p(false, true);
    }

    public void p(boolean z, boolean z2) {
        if (this.clV != null && this.clW != null && this.clW.afA() != null && this.clW.afA().agW()) {
            s(false, true);
        }
    }

    public void act() {
        if (this.clV != null && this.clW != null && this.clW.afA() != null && !this.clW.afA().agW()) {
            s(true, true);
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
        return aj(this.clV);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void s(boolean z, boolean z2) {
        if (this.clW != null) {
            this.clW.s(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.caF && this.clZ && this.clV != null && this.aMP >= this.clY && this.clV.getVisibility() != 8) {
            Hn();
        }
    }

    public void showFloatingView() {
        if (this.caF && this.clZ && this.clV != null && this.clV.getVisibility() != 0) {
            Hm();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.caF) {
            if (i > this.aMP && i > i4 && this.clV.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMP && this.clV.getVisibility() != 0) {
                showFloatingView();
            }
            p(i, z);
            this.aMP = i;
            this.clY = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.caF && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aMP && firstVisiblePosition > this.clY) {
                Hn();
            } else if (firstVisiblePosition < this.aMP) {
                Hm();
            } else if (firstVisiblePosition == this.aMP) {
                if (!this.aMQ || firstVisiblePosition <= this.clY || a(absListView)) {
                    Hm();
                } else {
                    Hn();
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

    private void p(int i, boolean z) {
        if (this.caF && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.clX != null && this.clX.aju() != null && this.clX.aju().getView() != null) {
            int measuredHeight = this.clX.aju().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.clX.aju().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    eN(false);
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                eN(false);
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                eN(true);
            }
            if ((z || i > this.clY) && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                eN(true);
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void eN(boolean z) {
        if (this.ckc != null) {
            this.ckc.F(Boolean.valueOf(z));
        }
    }

    private void acv() {
        if (this.clW != null && this.clW.afx() != null) {
            View afx = this.clW.afx();
            if (this.caE && afx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = afx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                afx.setLayoutParams(layoutParams);
                eo(true);
                return;
            }
            eo(false);
        }
    }

    private void eo(boolean z) {
        if (this.clW != null && this.clW.afx() != null) {
            View afx = this.clW.afx();
            if (this.caE && z && afx.getVisibility() != 0) {
                afx.setVisibility(0);
            } else if (!z && afx.getVisibility() != 8) {
                afx.setVisibility(8);
            }
        }
    }
}
