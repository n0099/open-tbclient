package com.baidu.tieba.frs.f;

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
public class as {
    private final FrsActivity bOq;
    private final ax bQl;
    private final u cdA;
    private final ObservedChangeLinearLayout cdB;
    private final com.baidu.tieba.frs.entelechy.b.d cdz;
    private Handler mHandler;
    private final BdTypeListView mListView;
    private int mScreenHeight;
    private View cdC = null;
    private View cdD = null;
    private VelocityTracker mVelocityTracker = null;
    private int cdE = 0;
    private int offset = 0;
    private boolean aPr = false;
    private boolean cdF = true;
    private boolean cdG = false;
    private boolean cdH = false;
    private boolean cdI = false;
    private long cdJ = 0;
    private a cdK = null;
    private ViewTreeObserver.OnGlobalLayoutListener ajB = null;

    /* loaded from: classes.dex */
    public interface a {
        void en(boolean z);
    }

    public as(FrsActivity frsActivity, ax axVar, com.baidu.tieba.frs.entelechy.b.d dVar, u uVar) {
        this.mScreenHeight = 0;
        if (axVar == null || frsActivity == null || dVar == null || uVar == null) {
            throw new IllegalArgumentException("all arguments can not be null value");
        }
        this.bOq = frsActivity;
        this.bQl = axVar;
        this.cdA = uVar;
        this.cdz = dVar;
        this.mListView = this.bQl.getListView();
        this.cdB = this.bQl.Zk();
        this.mScreenHeight = com.baidu.adp.lib.util.k.ah(this.bOq.getBaseContext());
        this.mHandler = new Handler(new at(this));
    }

    private boolean aem() {
        return this.cdB == null || this.cdz == null || this.cdA == null || this.bOq == null || this.bQl == null || this.mListView == null;
    }

    public int aen() {
        if (this.offset - 1 > 0) {
            return this.offset - 1;
        }
        return 0;
    }

    private void aeo() {
        if (this.cdB != null && this.cdE == 0) {
            this.cdE = this.cdB.getMeasuredHeight();
        }
        if (this.ajB == null && this.cdz.abe() != null) {
            this.ajB = new au(this);
            this.cdz.abe().getViewTreeObserver().addOnGlobalLayoutListener(this.ajB);
        }
    }

    public void dA(boolean z) {
        this.cdF = z;
    }

    private boolean aep() {
        if (this.mListView == null || this.mListView.getAdapter() == null) {
            return false;
        }
        int count = this.mListView.getAdapter().getCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int childCount = this.mListView.getChildCount();
        int i = firstVisiblePosition + childCount;
        if (childCount <= 0) {
            return false;
        }
        return i == count && this.mListView.getChildAt(childCount + (-1)).getBottom() == this.mListView.getBottom();
    }

    private void aeq() {
        if (this.cdC == null) {
            this.cdC = BdListViewHelper.a(this.bOq.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
            ViewGroup.LayoutParams layoutParams = this.cdC.getLayoutParams();
            if (layoutParams.height != this.cdE) {
                layoutParams.height = this.cdE;
                this.cdC.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.mListView.addHeaderView(this.cdC, 0);
    }

    private boolean aer() {
        ViewGroup.LayoutParams layoutParams;
        if (!(!aep() || this.cdA.adU() == null || this.cdA.adU().aew() == null || this.mListView.indexOfChild(this.cdA.adU().aew()) < 0)) {
            View aew = this.cdA.adU().aew();
            if (aew != null) {
                if (aew.getTop() >= this.cdE) {
                    return false;
                }
                if (this.cdD == null) {
                    this.cdD = new View(this.bOq.getBaseContext());
                    layoutParams = new AbsListView.LayoutParams(-1, this.mScreenHeight);
                } else {
                    layoutParams = this.cdD.getLayoutParams();
                    layoutParams.height = this.mScreenHeight;
                }
                this.cdD.setLayoutParams(layoutParams);
                this.mListView.addFooterView(this.cdD);
                if (this.bOq.Yx() != null && this.bOq.Yx().hasMore()) {
                    this.bOq.lj();
                }
            }
            iI(0);
        }
        return true;
    }

    private void dL(boolean z) {
        if (this.bOq.YD() != null) {
            this.bOq.YD().dM(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aes() {
        if (!aem() && !this.aPr && !this.cdG && aer()) {
            View abe = this.cdz.abe();
            int indexOfChild = this.mListView.indexOfChild(abe);
            if (abe != null && Math.abs(abe.getTop() - this.cdE) > 25 && indexOfChild >= 0) {
                this.mListView.smoothScrollBy(abe.getTop() - this.cdE, 300);
                this.mHandler.sendEmptyMessageDelayed(1, 300L);
                dL(false);
                return;
            }
            adW();
            this.bOq.dx(true);
            this.mListView.addHeaderView(this.cdz.abe(), 0);
            aeq();
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            if (indexOfChild >= 0) {
                firstVisiblePosition = 0;
            }
            this.mListView.removeFooterView(this.cdD);
            this.mListView.setSelection(firstVisiblePosition);
            this.aPr = true;
            this.bQl.dG(true);
            dL(true);
            iI(0);
            if (this.bQl.KC() != null) {
                this.bQl.KC().a(this.mListView.getFirstVisiblePosition(), this.mListView.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void adW() {
        this.offset = -1;
        if (this.cdA.adU() != null && this.mListView.removeHeaderView(this.cdA.adU().getView())) {
            this.offset++;
        }
        if (this.cdA.adU() != null && this.mListView.removeHeaderView(this.cdA.adU().aew())) {
            this.offset++;
        }
        if (this.mListView.removeHeaderView(this.cdz.abe())) {
            this.offset++;
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOq.getPageContext(), 3);
        aVar.a(this.mListView);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        this.mListView.removeHeaderView(this.cdC);
    }

    public void aet() {
        if (!aem() && this.aPr) {
            this.mHandler.removeMessages(1);
            this.cdG = true;
            this.aPr = false;
            this.offset = 0;
            this.mListView.removeHeaderView(this.cdC);
            this.bOq.YK();
            if (this.mListView.getFirstVisiblePosition() == 0 && this.cdA.aei() > 0) {
                this.mListView.setSelection(this.cdA.aei() - 1);
            }
            this.mListView.smoothScrollToPosition(0);
            if (this.bOq.Yw() != null) {
                this.bOq.Yw().adp();
            }
            this.mHandler.sendEmptyMessageDelayed(0, 50L);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE, this.bOq.getUniqueId()));
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean YL() {
        return this.aPr;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aem() && absListView != null) {
            aeo();
            if (this.cdA.adU() != null) {
                View aew = this.cdA.adU().aew();
                View abe = this.cdz.abe();
                if (aew != null && abe != null) {
                    if (i == 0) {
                        if (!this.cdG) {
                            int top = aew.getTop();
                            if (top < this.cdE && absListView.indexOfChild(abe) >= 0) {
                                int top2 = abe.getTop();
                                if (top != this.cdE && top2 != this.cdE) {
                                    int i2 = top2 - top;
                                    int i3 = this.cdE - top;
                                    if (i3 > 0 && !this.aPr) {
                                        if (i3 > i2 * 0.5f) {
                                            this.mHandler.sendEmptyMessage(1);
                                            return;
                                        }
                                        if (this.mHandler.hasMessages(1)) {
                                            this.mHandler.removeMessages(1);
                                        }
                                        absListView.smoothScrollBy(-i3, 300);
                                        iI(0);
                                    }
                                }
                            } else if (!this.mHandler.hasMessages(1)) {
                                a(absListView, aew, abe);
                            }
                        }
                    } else if (i == 1) {
                        dL(true);
                        if (this.cdG) {
                            this.cdG = false;
                            this.mHandler.removeMessages(0);
                            a(absListView, aew, abe);
                        }
                        if (this.mHandler.hasMessages(1)) {
                            this.mHandler.removeMessages(1);
                        }
                        if (this.cdD != null && this.cdD.getParent() != null) {
                            this.mListView.removeFooterView(this.cdD);
                        }
                    }
                }
            }
        }
    }

    private void a(AbsListView absListView, View view, View view2) {
        if (absListView != null && view != null && view2 != null && this.cdA.adU() != null && absListView.indexOfChild(view2) < 0 && absListView.indexOfChild(view) < 0 && absListView.indexOfChild(this.cdA.adU().getView()) < 0 && !this.aPr) {
            aes();
        }
    }

    public void a(AbsListView absListView, int i) {
        if (!aem() && absListView != null && this.cdA.adU() != null) {
            aeo();
            View aew = this.cdA.adU().aew();
            View abe = this.cdz.abe();
            if (aew != null && abe != null) {
                int top = abe.getTop();
                int top2 = aew.getTop();
                int indexOfChild = absListView.indexOfChild(abe);
                if (this.cdK != null) {
                    if (this.cdH != (indexOfChild >= 0)) {
                        this.cdH = indexOfChild >= 0;
                        this.cdK.en(this.cdH);
                    }
                }
                if (this.cdB.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cdB.getLayoutParams();
                    if (top2 < this.cdE && indexOfChild >= 0) {
                        int i2 = top - this.cdE;
                        float f = (i2 * 1.0f) / (top - top2);
                        if (i2 > 0) {
                            i2 = 0;
                        }
                        if ((this.cdF || layoutParams.topMargin != 0) && indexOfChild == 1 && (this.cdI || top >= this.cdB.getBottom())) {
                            layoutParams.topMargin = i2;
                        }
                        boolean z = f < 0.05f;
                        if (!this.aPr) {
                            this.bQl.dG(z);
                        }
                        float f2 = 2.0f * (1.0f - f);
                        if (f2 > 0.3f) {
                            f2 = 0.3f;
                        }
                        U(f2);
                        this.cdJ = SystemClock.uptimeMillis();
                    } else {
                        if (this.mListView.indexOfChild(aew) >= 0 || SystemClock.uptimeMillis() - this.cdJ > 360) {
                            layoutParams.topMargin = 0;
                        } else {
                            layoutParams.topMargin = -this.cdE;
                        }
                        U(0.0f);
                    }
                    if (this.aPr && i == 0 && this.bOq.YD() != null) {
                        this.bOq.YD().WG();
                    }
                    this.cdB.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private void U(float f) {
        float f2 = 1.0f;
        float f3 = TbadkCoreApplication.m9getInst().getSkinType() == 1 ? 1.8f * f : f;
        if (f3 <= 1.0f) {
            f2 = f3 < 0.0f ? 0.0f : f3;
        }
        int argb = Color.argb((int) (f2 * 255.0f), 0, 0, 0);
        if (this.cdA.adU() != null && this.cdA.adU().aex() != null) {
            this.cdA.adU().aex().setBackgroundColor(argb);
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOq.getPageContext(), 2);
        aVar.setMaskColor(argb);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public boolean b(MotionEvent motionEvent, View view) {
        if (!this.aPr && !this.cdG && !this.mHandler.hasMessages(1)) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(MotionEvent.obtain(motionEvent));
            this.mVelocityTracker.computeCurrentVelocity(100, 1000.0f);
            if (motionEvent.getAction() == 1 && this.mVelocityTracker.getYVelocity() <= -250.0f && this.mListView.indexOfChild(this.cdz.abe()) >= 0) {
                aes();
                this.mVelocityTracker.clear();
                return true;
            }
        }
        if (view == this.mListView && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            onScrollStateChanged(this.mListView, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI(int i) {
        if (this.cdB != null && (this.cdB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cdB.getLayoutParams();
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                this.cdB.setLayoutParams(layoutParams);
            }
        }
    }

    public void p(View view, int i) {
        if (view == this.cdB) {
            if (this.cdC != null) {
                ViewGroup.LayoutParams layoutParams = this.cdC.getLayoutParams();
                layoutParams.height = i;
                this.cdC.setLayoutParams(layoutParams);
            }
            this.cdE = i;
        }
    }

    public void kZ() {
        iI(0);
    }
}
