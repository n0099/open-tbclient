package com.baidu.tieba.frs.j;

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
import com.baidu.tieba.frs.au;
/* loaded from: classes.dex */
public class ai {
    private final BdTypeListView aML;
    private final FrsActivity bTA;
    private final au bVA;
    private final n bWL;
    private final com.baidu.tieba.frs.entelechy.b.d ckr;
    private final ObservedChangeLinearLayout cks;
    private Handler mHandler;
    private int mScreenHeight;
    private View ckt = null;
    private View cku = null;
    private VelocityTracker mVelocityTracker = null;
    private int ckv = 0;
    private int offset = 0;
    private boolean ckw = false;
    private boolean ckx = true;
    private boolean cky = false;
    private boolean ckz = false;
    private boolean ckA = false;
    private long ckB = 0;
    private a bWS = null;
    private ViewTreeObserver.OnGlobalLayoutListener afI = null;

    /* loaded from: classes.dex */
    public interface a {
        void ed(boolean z);
    }

    public ai(FrsActivity frsActivity, au auVar, com.baidu.tieba.frs.entelechy.b.d dVar, n nVar) {
        this.mScreenHeight = 0;
        if (auVar == null || frsActivity == null || dVar == null || nVar == null) {
            throw new IllegalArgumentException("all arguments can not be null value");
        }
        this.bTA = frsActivity;
        this.bVA = auVar;
        this.bWL = nVar;
        this.ckr = dVar;
        this.aML = this.bVA.acW();
        this.cks = this.bVA.acH();
        this.mScreenHeight = com.baidu.adp.lib.util.k.L(this.bTA.getBaseContext());
        this.mHandler = new Handler(new aj(this));
    }

    private boolean ahG() {
        return this.cks == null || this.ckr == null || this.bWL == null || this.bTA == null || this.bVA == null || this.aML == null;
    }

    public int ahH() {
        if (this.offset - 1 > 0) {
            return this.offset - 1;
        }
        return 0;
    }

    private void ahI() {
        if (this.cks != null && this.ckv == 0) {
            this.ckv = this.cks.getMeasuredHeight();
        }
        if (this.afI == null && this.ckr.aeK() != null) {
            this.afI = new ak(this);
            this.ckr.aeK().getViewTreeObserver().addOnGlobalLayoutListener(this.afI);
        }
    }

    public void dL(boolean z) {
        this.ckx = z;
    }

    public void a(a aVar) {
        this.bWS = aVar;
    }

    private boolean ahJ() {
        if (this.aML == null || this.aML.getAdapter() == null) {
            return false;
        }
        int count = this.aML.getAdapter().getCount();
        int firstVisiblePosition = this.aML.getFirstVisiblePosition();
        int childCount = this.aML.getChildCount();
        int i = firstVisiblePosition + childCount;
        if (childCount <= 0) {
            return false;
        }
        return i == count && this.aML.getChildAt(childCount + (-1)).getBottom() == this.aML.getBottom();
    }

    private void ahK() {
        if (this.ckt == null) {
            this.ckt = BdListViewHelper.a(this.bTA.getPageContext().getPageActivity(), this.aML, BdListViewHelper.HeadType.DEFAULT);
            ViewGroup.LayoutParams layoutParams = this.ckt.getLayoutParams();
            if (layoutParams.height != this.ckv) {
                layoutParams.height = this.ckv;
                this.ckt.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.aML.f(this.ckt, 0);
    }

    private boolean ahL() {
        ViewGroup.LayoutParams layoutParams;
        if (!(!ahJ() || this.bWL.ahq() == null || this.bWL.ahq().ahQ() == null || this.aML.indexOfChild(this.bWL.ahq().ahQ()) < 0)) {
            View ahQ = this.bWL.ahq().ahQ();
            if (ahQ != null) {
                if (ahQ.getTop() >= this.ckv) {
                    return false;
                }
                if (this.cku == null) {
                    this.cku = new View(this.bTA.getBaseContext());
                    layoutParams = new AbsListView.LayoutParams(-1, this.mScreenHeight);
                } else {
                    layoutParams = this.cku.getLayoutParams();
                    layoutParams.height = this.mScreenHeight;
                }
                this.cku.setLayoutParams(layoutParams);
                this.aML.addFooterView(this.cku);
                if (this.bTA.abS() != null && this.bTA.abS().hasMore()) {
                    this.bTA.kx();
                }
            }
            iO(0);
        }
        return true;
    }

    private void dW(boolean z) {
        if (this.bTA.abY() != null) {
            this.bTA.abY().dX(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahM() {
        if (!ahG() && !this.ckw && !this.cky && ahL()) {
            View aeK = this.ckr.aeK();
            int indexOfChild = this.aML.indexOfChild(aeK);
            if (aeK != null && Math.abs(aeK.getTop() - this.ckv) > 25 && indexOfChild >= 0) {
                this.aML.smoothScrollBy(aeK.getTop() - this.ckv, 300);
                this.mHandler.sendEmptyMessageDelayed(1, 300L);
                dW(false);
                return;
            }
            ahs();
            this.bTA.dI(true);
            this.aML.f(this.ckr.aeK(), 0);
            ahK();
            int firstVisiblePosition = this.aML.getFirstVisiblePosition();
            if (indexOfChild >= 0) {
                firstVisiblePosition = 0;
            }
            this.aML.removeFooterView(this.cku);
            this.aML.setSelection(firstVisiblePosition);
            this.ckw = true;
            this.bVA.dS(true);
            dW(true);
            iO(0);
            if (this.bVA.Kp() != null) {
                this.bVA.Kp().a(this.aML.getFirstVisiblePosition(), this.aML.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void ahs() {
        this.offset = -1;
        if (this.bWL.ahq() != null && this.aML.removeHeaderView(this.bWL.ahq().getView())) {
            this.offset++;
        }
        if (this.bWL.ahq() != null && this.aML.removeHeaderView(this.bWL.ahq().ahQ())) {
            this.offset++;
        }
        if (this.aML.removeHeaderView(this.ckr.aeK())) {
            this.offset++;
        }
        this.aML.removeHeaderView(this.bVA.adt());
        this.aML.removeHeaderView(this.ckt);
    }

    public void ahN() {
        if (!ahG() && this.ckw) {
            this.mHandler.removeMessages(1);
            this.cky = true;
            this.ckw = false;
            this.offset = 0;
            this.aML.removeHeaderView(this.ckt);
            this.bTA.acg();
            if (this.aML.getFirstVisiblePosition() == 0 && this.bWL.ahE() > 0) {
                this.aML.setSelection(this.bWL.ahE() - 1);
            }
            this.aML.smoothScrollToPosition(0);
            if (this.bTA.abR() != null) {
                this.bTA.abR().agP();
            }
            this.mHandler.sendEmptyMessageDelayed(0, 50L);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE, this.bTA.getUniqueId()));
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean ach() {
        return this.ckw;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!ahG() && absListView != null) {
            ahI();
            if (this.bWL.ahq() != null) {
                View ahQ = this.bWL.ahq().ahQ();
                View aeK = this.ckr.aeK();
                if (ahQ != null && aeK != null) {
                    if (i == 0) {
                        if (!this.cky) {
                            int top = ahQ.getTop();
                            if (top < this.ckv && absListView.indexOfChild(aeK) >= 0) {
                                int top2 = aeK.getTop();
                                if (top != this.ckv && top2 != this.ckv) {
                                    int i2 = top2 - top;
                                    int i3 = this.ckv - top;
                                    if (i3 > 0 && !this.ckw) {
                                        if (i3 > i2 * 0.5f) {
                                            this.mHandler.sendEmptyMessage(1);
                                            return;
                                        }
                                        if (this.mHandler.hasMessages(1)) {
                                            this.mHandler.removeMessages(1);
                                        }
                                        absListView.smoothScrollBy(-i3, 300);
                                        iO(0);
                                    }
                                }
                            } else if (!this.mHandler.hasMessages(1)) {
                                a(absListView, ahQ, aeK);
                            }
                        }
                    } else if (i == 1) {
                        dW(true);
                        if (this.cky) {
                            this.cky = false;
                            this.mHandler.removeMessages(0);
                            a(absListView, ahQ, aeK);
                        }
                        if (this.mHandler.hasMessages(1)) {
                            this.mHandler.removeMessages(1);
                        }
                        if (this.cku != null && this.cku.getParent() != null) {
                            this.aML.removeFooterView(this.cku);
                        }
                    }
                }
            }
        }
    }

    private void a(AbsListView absListView, View view, View view2) {
        if (absListView != null && view != null && view2 != null && this.bWL.ahq() != null && absListView.indexOfChild(view2) < 0 && absListView.indexOfChild(view) < 0 && absListView.indexOfChild(this.bWL.ahq().getView()) < 0 && !this.ckw) {
            ahM();
        }
    }

    public void a(AbsListView absListView, int i) {
        if (!ahG() && absListView != null && this.bWL.ahq() != null) {
            ahI();
            View ahQ = this.bWL.ahq().ahQ();
            View aeK = this.ckr.aeK();
            if (ahQ != null && aeK != null) {
                int top = aeK.getTop();
                int top2 = ahQ.getTop();
                int indexOfChild = absListView.indexOfChild(aeK);
                if (this.bWS != null) {
                    if (this.ckz != (indexOfChild >= 0)) {
                        this.ckz = indexOfChild >= 0;
                        this.bWS.ed(this.ckz);
                    }
                }
                if (this.cks.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cks.getLayoutParams();
                    if (top2 < this.ckv && indexOfChild >= 0) {
                        int i2 = top - this.ckv;
                        float f = (i2 * 1.0f) / (top - top2);
                        if (i2 > 0) {
                            i2 = 0;
                        }
                        if ((this.ckx || layoutParams.topMargin != 0) && indexOfChild == 1 && (this.ckA || top >= this.cks.getBottom())) {
                            layoutParams.topMargin = i2;
                        }
                        boolean z = f < 0.05f;
                        if (!this.ckw) {
                            this.bVA.dS(z);
                        }
                        float f2 = 2.0f * (1.0f - f);
                        if (f2 > 0.3f) {
                            f2 = 0.3f;
                        }
                        ag(f2);
                        this.ckB = SystemClock.uptimeMillis();
                    } else {
                        if (this.aML.indexOfChild(ahQ) >= 0 || SystemClock.uptimeMillis() - this.ckB > 360) {
                            layoutParams.topMargin = 0;
                        } else {
                            layoutParams.topMargin = -this.ckv;
                        }
                        ag(0.0f);
                    }
                    if (this.ckw && i == 0 && this.bTA.abY() != null) {
                        this.bTA.abY().aaa();
                    }
                    this.cks.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private void ag(float f) {
        float f2 = 1.0f;
        float f3 = TbadkCoreApplication.m9getInst().getSkinType() == 1 ? 1.8f * f : f;
        if (f3 <= 1.0f) {
            f2 = f3 < 0.0f ? 0.0f : f3;
        }
        int argb = Color.argb((int) (f2 * 255.0f), 0, 0, 0);
        if (this.bWL.ahq() != null && this.bWL.ahq().ahR() != null) {
            this.bWL.ahq().ahR().setBackgroundColor(argb);
        }
        if (this.bVA != null && this.bVA.adt() != null) {
            this.bVA.adt().setBannerMaskColor(argb);
        }
    }

    public boolean b(MotionEvent motionEvent, View view) {
        if (!this.ckw && !this.cky && !this.mHandler.hasMessages(1)) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(MotionEvent.obtain(motionEvent));
            this.mVelocityTracker.computeCurrentVelocity(100, 1000.0f);
            if (motionEvent.getAction() == 1 && this.mVelocityTracker.getYVelocity() <= -250.0f && this.aML.indexOfChild(this.ckr.aeK()) >= 0) {
                ahM();
                this.mVelocityTracker.clear();
                return true;
            }
        }
        if (view == this.aML && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            onScrollStateChanged(this.aML, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(int i) {
        if (this.cks != null && (this.cks.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cks.getLayoutParams();
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                this.cks.setLayoutParams(layoutParams);
            }
        }
    }

    public void r(View view, int i) {
        if (view == this.cks) {
            if (this.ckt != null) {
                ViewGroup.LayoutParams layoutParams = this.ckt.getLayoutParams();
                layoutParams.height = i;
                this.ckt.setLayoutParams(layoutParams);
            }
            this.ckv = i;
        }
    }

    public void kj() {
        iO(0);
    }
}
