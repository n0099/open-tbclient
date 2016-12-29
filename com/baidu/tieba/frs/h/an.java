package com.baidu.tieba.frs.h;

import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
/* loaded from: classes.dex */
public class an {
    private final BdTypeListView aMc;
    private final ax bBI;
    private final s bCV;
    private final com.baidu.tieba.frs.entelechy.b.d bPA;
    private final ObservedChangeLinearLayout bPB;
    private final FrsActivity bzH;
    private Handler mHandler;
    private int mScreenHeight;
    private View bPC = null;
    private View bPD = null;
    private VelocityTracker mVelocityTracker = null;
    private int bPE = 0;
    private int offset = 0;
    private boolean bPF = false;
    private boolean bPG = true;
    private boolean bPH = false;
    private boolean bPI = false;
    private boolean bPJ = false;
    private long bPK = 0;
    private a bDc = null;
    private ViewTreeObserver.OnGlobalLayoutListener afb = null;

    /* loaded from: classes.dex */
    public interface a {
        void dN(boolean z);
    }

    public an(FrsActivity frsActivity, ax axVar, com.baidu.tieba.frs.entelechy.b.d dVar, s sVar) {
        this.mScreenHeight = 0;
        if (axVar == null || frsActivity == null || dVar == null || sVar == null) {
            throw new IllegalArgumentException("all arguments can not be null value");
        }
        this.bzH = frsActivity;
        this.bBI = axVar;
        this.bCV = sVar;
        this.bPA = dVar;
        this.aMc = this.bBI.Xm();
        this.bPB = this.bBI.WU();
        this.mScreenHeight = com.baidu.adp.lib.util.k.J(this.bzH.getBaseContext());
        this.mHandler = new Handler(new ao(this));
    }

    private boolean acd() {
        return this.bPB == null || this.bPA == null || this.bCV == null || this.bzH == null || this.bBI == null || this.aMc == null;
    }

    public int ace() {
        if (this.offset - 1 > 0) {
            return this.offset - 1;
        }
        return 0;
    }

    private void acf() {
        if (this.bPB != null && this.bPE == 0) {
            this.bPE = this.bPB.getMeasuredHeight();
        }
        if (this.afb == null && this.bPA.Zf() != null) {
            this.afb = new ap(this);
            this.bPA.Zf().getViewTreeObserver().addOnGlobalLayoutListener(this.afb);
        }
    }

    public void dt(boolean z) {
        this.bPG = z;
    }

    public void a(a aVar) {
        this.bDc = aVar;
    }

    private boolean acg() {
        if (this.aMc == null || this.aMc.getAdapter() == null) {
            return false;
        }
        int count = this.aMc.getAdapter().getCount();
        int firstVisiblePosition = this.aMc.getFirstVisiblePosition();
        int childCount = this.aMc.getChildCount();
        int i = firstVisiblePosition + childCount;
        if (childCount <= 0) {
            return false;
        }
        return i == count && this.aMc.getChildAt(childCount + (-1)).getBottom() == this.aMc.getBottom();
    }

    private void ach() {
        if (this.bPC == null) {
            this.bPC = BdListViewHelper.a(this.bzH.getPageContext().getPageActivity(), this.aMc, BdListViewHelper.HeadType.DEFAULT);
            ViewGroup.LayoutParams layoutParams = this.bPC.getLayoutParams();
            if (layoutParams.height != this.bPE) {
                layoutParams.height = this.bPE;
                this.bPC.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.aMc.f(this.bPC, 0);
    }

    private boolean aci() {
        ViewGroup.LayoutParams layoutParams;
        if (!(!acg() || this.bCV.abN() == null || this.bCV.abN().acn() == null || this.aMc.indexOfChild(this.bCV.abN().acn()) < 0)) {
            View acn = this.bCV.abN().acn();
            if (acn != null) {
                if (acn.getTop() >= this.bPE) {
                    return false;
                }
                if (this.bPD == null) {
                    this.bPD = new View(this.bzH.getBaseContext());
                    layoutParams = new AbsListView.LayoutParams(-1, this.mScreenHeight);
                } else {
                    layoutParams = this.bPD.getLayoutParams();
                    layoutParams.height = this.mScreenHeight;
                }
                this.bPD.setLayoutParams(layoutParams);
                this.aMc.addFooterView(this.bPD);
                if (this.bzH.Wh() != null && this.bzH.Wh().hasMore()) {
                    this.bzH.kx();
                }
            }
            hY(0);
        }
        return true;
    }

    private void dF(boolean z) {
        if (this.bzH.Wn() != null) {
            this.bzH.Wn().dG(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acj() {
        if (!acd() && !this.bPF && !this.bPH && aci()) {
            View Zf = this.bPA.Zf();
            int indexOfChild = this.aMc.indexOfChild(Zf);
            if (Zf != null && Math.abs(Zf.getTop() - this.bPE) > 25 && indexOfChild >= 0) {
                this.aMc.smoothScrollBy(Zf.getTop() - this.bPE, 300);
                this.mHandler.sendEmptyMessageDelayed(1, 300L);
                dF(false);
                return;
            }
            abP();
            this.bzH.dq(true);
            this.aMc.f(this.bPA.Zf(), 0);
            ach();
            int firstVisiblePosition = this.aMc.getFirstVisiblePosition();
            if (indexOfChild >= 0) {
                firstVisiblePosition = 0;
            }
            this.aMc.removeFooterView(this.bPD);
            this.aMc.setSelection(firstVisiblePosition);
            this.bPF = true;
            this.bBI.dA(true);
            dF(true);
            hY(0);
            if (this.bBI.JI() != null) {
                this.bBI.JI().a(this.aMc.getFirstVisiblePosition(), this.aMc.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void abP() {
        this.offset = -1;
        if (this.bCV.abN() != null && this.aMc.removeHeaderView(this.bCV.abN().getView())) {
            this.offset++;
        }
        if (this.bCV.abN() != null && this.aMc.removeHeaderView(this.bCV.abN().acn())) {
            this.offset++;
        }
        if (this.aMc.removeHeaderView(this.bPA.Zf())) {
            this.offset++;
        }
        this.aMc.removeHeaderView(this.bBI.XJ());
        this.aMc.removeHeaderView(this.bPC);
    }

    public void ack() {
        if (!acd() && this.bPF) {
            this.mHandler.removeMessages(1);
            this.bPH = true;
            this.bPF = false;
            this.offset = 0;
            this.aMc.removeHeaderView(this.bPC);
            this.bzH.Wu();
            if (this.aMc.getFirstVisiblePosition() == 0 && this.bCV.acb() > 0) {
                this.aMc.setSelection(this.bCV.acb() - 1);
            }
            this.aMc.smoothScrollToPosition(0);
            if (this.bzH.Wg() != null) {
                this.bzH.Wg().abk();
            }
            this.mHandler.sendEmptyMessageDelayed(0, 50L);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE, this.bzH.getUniqueId()));
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Wv() {
        return this.bPF;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!acd() && absListView != null) {
            acf();
            if (this.bCV.abN() != null) {
                View acn = this.bCV.abN().acn();
                View Zf = this.bPA.Zf();
                if (acn != null && Zf != null) {
                    if (i == 0) {
                        if (!this.bPH) {
                            int top = acn.getTop();
                            if (top < this.bPE && absListView.indexOfChild(Zf) >= 0) {
                                int top2 = Zf.getTop();
                                if (top != this.bPE && top2 != this.bPE) {
                                    int i2 = top2 - top;
                                    int i3 = this.bPE - top;
                                    if (i3 > 0 && !this.bPF) {
                                        if (i3 > i2 * 0.5f) {
                                            this.mHandler.sendEmptyMessage(1);
                                            return;
                                        }
                                        if (this.mHandler.hasMessages(1)) {
                                            this.mHandler.removeMessages(1);
                                        }
                                        absListView.smoothScrollBy(-i3, 300);
                                        hY(0);
                                    }
                                }
                            } else if (!this.mHandler.hasMessages(1)) {
                                a(absListView, acn, Zf);
                            }
                        }
                    } else if (i == 1) {
                        dF(true);
                        if (this.bPH) {
                            this.bPH = false;
                            this.mHandler.removeMessages(0);
                            a(absListView, acn, Zf);
                        }
                        if (this.mHandler.hasMessages(1)) {
                            this.mHandler.removeMessages(1);
                        }
                        if (this.bPD != null && this.bPD.getParent() != null) {
                            this.aMc.removeFooterView(this.bPD);
                        }
                    }
                }
            }
        }
    }

    private void a(AbsListView absListView, View view, View view2) {
        if (absListView != null && view != null && view2 != null && this.bCV.abN() != null && absListView.indexOfChild(view2) < 0 && absListView.indexOfChild(view) < 0 && absListView.indexOfChild(this.bCV.abN().getView()) < 0 && !this.bPF) {
            acj();
        }
    }

    public void a(AbsListView absListView, int i) {
        if (!acd() && absListView != null && this.bCV.abN() != null) {
            acf();
            View acn = this.bCV.abN().acn();
            View Zf = this.bPA.Zf();
            if (acn != null && Zf != null) {
                int top = Zf.getTop();
                int top2 = acn.getTop();
                int indexOfChild = absListView.indexOfChild(Zf);
                if (this.bDc != null) {
                    if (this.bPI != (indexOfChild >= 0)) {
                        this.bPI = indexOfChild >= 0;
                        this.bDc.dN(this.bPI);
                    }
                }
                if (this.bPB.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bPB.getLayoutParams();
                    if (top2 < this.bPE && indexOfChild >= 0) {
                        int i2 = top - this.bPE;
                        float f = (i2 * 1.0f) / (top - top2);
                        if (i2 > 0) {
                            i2 = 0;
                        }
                        if ((this.bPG || layoutParams.topMargin != 0) && indexOfChild == 1 && (this.bPJ || top >= this.bPB.getBottom())) {
                            layoutParams.topMargin = i2;
                        }
                        boolean z = f < 0.05f;
                        if (!this.bPF) {
                            this.bBI.dA(z);
                        }
                        float f2 = 2.0f * (1.0f - f);
                        if (f2 > 0.3f) {
                            f2 = 0.3f;
                        }
                        ab(f2);
                        this.bPK = SystemClock.uptimeMillis();
                    } else {
                        if (this.aMc.indexOfChild(acn) >= 0 || SystemClock.uptimeMillis() - this.bPK > 360) {
                            layoutParams.topMargin = 0;
                        } else {
                            layoutParams.topMargin = -this.bPE;
                        }
                        ab(0.0f);
                    }
                    if (this.bPF && i == 0 && this.bzH.Wn() != null) {
                        this.bzH.Wn().Un();
                    }
                    this.bPB.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private void ab(float f) {
        float f2 = 1.0f;
        float f3 = TbadkCoreApplication.m9getInst().getSkinType() == 1 ? 1.8f * f : f;
        if (f3 <= 1.0f) {
            f2 = f3 < 0.0f ? 0.0f : f3;
        }
        int argb = Color.argb((int) (f2 * 255.0f), 0, 0, 0);
        if (this.bCV.abN() != null && this.bCV.abN().aco() != null) {
            this.bCV.abN().aco().setBackgroundColor(argb);
        }
        if (this.bBI != null && this.bBI.XJ() != null) {
            this.bBI.XJ().setBannerMaskColor(argb);
        }
    }

    public boolean b(MotionEvent motionEvent, View view) {
        if (!this.bPF && !this.bPH && !this.mHandler.hasMessages(1)) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(MotionEvent.obtain(motionEvent));
            this.mVelocityTracker.computeCurrentVelocity(100, 1000.0f);
            if (motionEvent.getAction() == 1 && this.mVelocityTracker.getYVelocity() <= -250.0f && this.aMc.indexOfChild(this.bPA.Zf()) >= 0) {
                acj();
                this.mVelocityTracker.clear();
                return true;
            }
        }
        if (view == this.aMc && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            onScrollStateChanged(this.aMc, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(int i) {
        if (this.bPB != null && (this.bPB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bPB.getLayoutParams();
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                this.bPB.setLayoutParams(layoutParams);
            }
        }
    }

    public void p(View view, int i) {
        if (view == this.bPB) {
            if (this.bPC != null) {
                ViewGroup.LayoutParams layoutParams = this.bPC.getLayoutParams();
                layoutParams.height = i;
                this.bPC.setLayoutParams(layoutParams);
            }
            this.bPE = i;
        }
    }

    public void kj() {
        hY(0);
    }
}
