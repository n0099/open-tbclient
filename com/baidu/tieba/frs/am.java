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
    private ViewGroup ckN;
    private i ckO;
    private com.baidu.tieba.frs.h.f ckP;
    private com.baidu.tieba.e.b ckS;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aLA = 0;
    private int ckQ = 0;
    private boolean bZz = true;
    private boolean ckR = true;
    private boolean aLB = false;
    private final Handler.Callback bZA = new Handler.Callback() { // from class: com.baidu.tieba.frs.am.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && am.this.acp()) {
                am.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    am.this.aco();
                    return true;
                case 2:
                    am.this.acm();
                    return true;
                case 3:
                    am.this.acn();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.bZA);
    private a.InterfaceC0080a bUZ = new a.InterfaceC0080a() { // from class: com.baidu.tieba.frs.am.2
        final int bwS = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds98);

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ag(int i, int i2) {
            if (Y(i2)) {
                am.this.en(false);
                am.this.showFloatingView();
            }
            if (am.this.ckO != null) {
                am.this.ckO.eK(true);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            if (Y(i2)) {
                am.this.en(true);
                if (Math.abs(i2) > this.bwS) {
                    am.this.hideFloatingView();
                }
            }
            if (am.this.ckO != null) {
                am.this.ckO.eK(false);
            }
        }

        private boolean Y(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private boolean bZy = UtilHelper.canUseStyleImmersiveSticky();

    public com.baidu.tieba.e.b age() {
        return this.ckS;
    }

    public void en(boolean z) {
        this.aLB = z;
    }

    public void eN(boolean z) {
        this.bZz = z;
    }

    public am(Context context, i iVar, com.baidu.tieba.frs.h.f fVar) {
        this.mContext = context;
        this.ckO = iVar;
        this.mNavigationBar = iVar.afl();
        this.ckN = iVar.afr();
        this.ckP = fVar;
        acq();
        eo(false);
        this.ckS = new com.baidu.tieba.e.b(context);
        this.ckS.a(this.bUZ);
    }

    public void acm() {
        p(false, false);
    }

    public void acn() {
        p(false, true);
    }

    public void p(boolean z, boolean z2) {
        if (this.ckN != null && this.ckO != null && this.ckO.afv() != null && this.ckO.afv().agP()) {
            s(false, true);
        }
    }

    public void aco() {
        if (this.ckN != null && this.ckO != null && this.ckO.afv() != null && !this.ckO.afv().agP()) {
            s(true, true);
        }
    }

    public void He() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean acp() {
        return aj(this.ckN);
    }

    private boolean aj(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void s(boolean z, boolean z2) {
        if (this.ckO != null) {
            this.ckO.s(z, z2);
        }
    }

    public void hideFloatingView() {
        if (this.bZz && this.ckR && this.ckN != null && this.aLA >= this.ckQ && this.ckN.getVisibility() != 8) {
            Hf();
        }
    }

    public void showFloatingView() {
        if (this.bZz && this.ckR && this.ckN != null && this.ckN.getVisibility() != 0) {
            He();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, boolean z) {
        if (this.bZz) {
            if (i > this.aLA && i > i4 && this.ckN.getVisibility() != 8) {
                hideFloatingView();
            } else if (i < this.aLA && this.ckN.getVisibility() != 0) {
                showFloatingView();
            }
            this.aLA = i;
            this.ckQ = i4;
        }
    }

    public void a(AbsListView absListView, int i, int i2) {
        if (this.bZz && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition() + i2;
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aLA && firstVisiblePosition > this.ckQ) {
                Hf();
            } else if (firstVisiblePosition < this.aLA) {
                He();
            } else if (firstVisiblePosition == this.aLA) {
                if (!this.aLB || firstVisiblePosition <= this.ckQ || a(absListView)) {
                    He();
                } else {
                    Hf();
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

    private void acq() {
        if (this.ckO != null && this.ckO.afs() != null) {
            View afs = this.ckO.afs();
            if (this.bZy && afs.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = afs.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                afs.setLayoutParams(layoutParams);
                eo(true);
                return;
            }
            eo(false);
        }
    }

    private void eo(boolean z) {
        if (this.ckO != null && this.ckO.afs() != null) {
            View afs = this.ckO.afs();
            if (this.bZy && z && afs.getVisibility() != 0) {
                afs.setVisibility(0);
            } else if (!z && afs.getVisibility() != 8) {
                afs.setVisibility(8);
            }
        }
    }
}
