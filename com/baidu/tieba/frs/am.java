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
    private ViewGroup cmI;
    private i cmJ;
    private com.baidu.tieba.frs.g.f cmK;
    private com.baidu.tieba.e.b cmN;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aMR = 0;
    private int cmL = 0;
    private boolean cbs = true;
    private boolean cmM = true;
    private boolean aMS = false;
    private final Handler.Callback cbt = new Handler.Callback() { // from class: com.baidu.tieba.frs.am.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && am.this.acL()) {
                am.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    am.this.acK();
                    return true;
                case 2:
                    am.this.acI();
                    return true;
                case 3:
                    am.this.acJ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cbt);
    private a.InterfaceC0080a bWS = new a.InterfaceC0080a() { // from class: com.baidu.tieba.frs.am.2
        final int byM = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2)) {
                am.this.eo(false);
                am.this.showFloatingView();
            }
            if (am.this.cmJ != null) {
                am.this.cmJ.eM(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            if (Y(i2)) {
                am.this.eo(true);
                if (Math.abs(i2) > this.byM) {
                    am.this.hideFloatingView();
                }
            }
            if (am.this.cmJ != null) {
                am.this.cmJ.eM(false);
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cbr = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b agA() {
        return this.cmN;
    }

    public void eo(boolean z) {
        this.aMS = z;
    }

    public void eP(boolean z) {
        this.cbs = z;
    }

    public am(Context context, i iVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.cmJ = iVar;
        this.mNavigationBar = iVar.afG();
        this.cmI = iVar.afN();
        this.cmK = fVar;
        acM();
        ep(false);
        this.cmN = new com.baidu.tieba.e.b(context);
        this.cmN.a(this.bWS);
    }

    public void acI() {
        q(false, false);
    }

    public void acJ() {
        q(false, true);
    }

    public void q(boolean z, boolean z2) {
        if (this.cmI != null && this.cmJ != null && this.cmJ.afR() != null && this.cmJ.afR().ahl()) {
            t(false, true);
        }
    }

    public void acK() {
        if (this.cmI != null && this.cmJ != null && this.cmJ.afR() != null && !this.cmJ.afR().ahl()) {
            t(true, true);
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

    public boolean acL() {
        return ai(this.cmI);
    }

    private boolean ai(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void t(boolean z, boolean z2) {
        if (this.cmJ != null) {
            this.cmJ.t(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cbs && this.cmM && this.cmI != null && this.aMR >= this.cmL && this.cmI.getVisibility() != 8) {
            Hn();
        }
    }

    public void showFloatingView() {
        if (this.cbs && this.cmM && this.cmI != null && this.cmI.getVisibility() != 0) {
            Hm();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.cbs) {
            if (i > this.aMR && i > i4 && this.cmI.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMR && this.cmI.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMR = i;
            this.cmL = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.cbs && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aMR && firstVisiblePosition > this.cmL) {
                Hn();
            } else if (firstVisiblePosition < this.aMR) {
                Hm();
            } else if (firstVisiblePosition == this.aMR) {
                if (!this.aMS || firstVisiblePosition <= this.cmL || a(absListView)) {
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

    private void acM() {
        if (this.cmJ != null && this.cmJ.afO() != null) {
            View afO = this.cmJ.afO();
            if (this.cbr && afO.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = afO.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                afO.setLayoutParams(layoutParams);
                ep(true);
                return;
            }
            ep(false);
        }
    }

    private void ep(boolean z) {
        if (this.cmJ != null && this.cmJ.afO() != null) {
            View afO = this.cmJ.afO();
            if (this.cbr && z && afO.getVisibility() != 0) {
                afO.setVisibility(0);
            } else if (!z && afO.getVisibility() != 8) {
                afO.setVisibility(8);
            }
        }
    }
}
