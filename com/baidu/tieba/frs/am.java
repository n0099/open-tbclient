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
    private ViewGroup cmH;
    private i cmI;
    private com.baidu.tieba.frs.g.f cmJ;
    private com.baidu.tieba.e.b cmM;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aMQ = 0;
    private int cmK = 0;
    private boolean cbr = true;
    private boolean cmL = true;
    private boolean aMR = false;
    private final Handler.Callback cbs = new Handler.Callback() { // from class: com.baidu.tieba.frs.am.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && am.this.acP()) {
                am.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    am.this.acO();
                    return true;
                case 2:
                    am.this.acM();
                    return true;
                case 3:
                    am.this.acN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cbs);
    private a.InterfaceC0080a bWR = new a.InterfaceC0080a() { // from class: com.baidu.tieba.frs.am.2
        final int byL = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2)) {
                am.this.eo(false);
                am.this.showFloatingView();
            }
            if (am.this.cmI != null) {
                am.this.cmI.eM(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            if (Y(i2)) {
                am.this.eo(true);
                if (Math.abs(i2) > this.byL) {
                    am.this.hideFloatingView();
                }
            }
            if (am.this.cmI != null) {
                am.this.cmI.eM(false);
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean cbq = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b agG() {
        return this.cmM;
    }

    public void eo(boolean z) {
        this.aMR = z;
    }

    public void eP(boolean z) {
        this.cbr = z;
    }

    public am(Context context, i iVar, com.baidu.tieba.frs.g.f fVar) {
        this.mContext = context;
        this.cmI = iVar;
        this.mNavigationBar = iVar.afM();
        this.cmH = iVar.afT();
        this.cmJ = fVar;
        acQ();
        ep(false);
        this.cmM = new com.baidu.tieba.e.b(context);
        this.cmM.a(this.bWR);
    }

    public void acM() {
        q(false, false);
    }

    public void acN() {
        q(false, true);
    }

    public void q(boolean z, boolean z2) {
        if (this.cmH != null && this.cmI != null && this.cmI.afX() != null && this.cmI.afX().ahr()) {
            t(false, true);
        }
    }

    public void acO() {
        if (this.cmH != null && this.cmI != null && this.cmI.afX() != null && !this.cmI.afX().ahr()) {
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

    public boolean acP() {
        return aj(this.cmH);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void t(boolean z, boolean z2) {
        if (this.cmI != null) {
            this.cmI.t(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.cbr && this.cmL && this.cmH != null && this.aMQ >= this.cmK && this.cmH.getVisibility() != 8) {
            Hn();
        }
    }

    public void showFloatingView() {
        if (this.cbr && this.cmL && this.cmH != null && this.cmH.getVisibility() != 0) {
            Hm();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.cbr) {
            if (i > this.aMQ && i > i4 && this.cmH.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aMQ && this.cmH.getVisibility() != 0) {
                showFloatingView();
            }
            this.aMQ = i;
            this.cmK = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.cbr && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aMQ && firstVisiblePosition > this.cmK) {
                Hn();
            } else if (firstVisiblePosition < this.aMQ) {
                Hm();
            } else if (firstVisiblePosition == this.aMQ) {
                if (!this.aMR || firstVisiblePosition <= this.cmK || a(absListView)) {
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

    private void acQ() {
        if (this.cmI != null && this.cmI.afU() != null) {
            View afU = this.cmI.afU();
            if (this.cbq && afU.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = afU.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                afU.setLayoutParams(layoutParams);
                ep(true);
                return;
            }
            ep(false);
        }
    }

    private void ep(boolean z) {
        if (this.cmI != null && this.cmI.afU() != null) {
            View afU = this.cmI.afU();
            if (this.cbq && z && afU.getVisibility() != 0) {
                afU.setVisibility(0);
            } else if (!z && afU.getVisibility() != 8) {
                afU.setVisibility(8);
            }
        }
    }
}
