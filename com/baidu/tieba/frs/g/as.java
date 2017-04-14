package com.baidu.tieba.frs.g;

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
import com.baidu.tieba.frs.az;
/* loaded from: classes.dex */
public class as {
    private final FrsActivity bOf;
    private final az bQa;
    private final com.baidu.tieba.frs.entelechy.b.d cca;
    private final u ccb;
    private final ObservedChangeLinearLayout ccc;
    private Handler mHandler;
    private final BdTypeListView mListView;
    private int mScreenHeight;
    private View ccd = null;
    private View cce = null;
    private VelocityTracker mVelocityTracker = null;
    private int ccf = 0;
    private int offset = 0;
    private boolean aPH = false;
    private boolean ccg = true;
    private boolean cch = false;
    private boolean cci = false;
    private boolean ccj = false;
    private long cck = 0;
    private a ccl = null;
    private ViewTreeObserver.OnGlobalLayoutListener ajP = null;

    /* loaded from: classes.dex */
    public interface a {
        void en(boolean z);
    }

    public as(FrsActivity frsActivity, az azVar, com.baidu.tieba.frs.entelechy.b.d dVar, u uVar) {
        this.mScreenHeight = 0;
        if (azVar == null || frsActivity == null || dVar == null || uVar == null) {
            throw new IllegalArgumentException("all arguments can not be null value");
        }
        this.bOf = frsActivity;
        this.bQa = azVar;
        this.ccb = uVar;
        this.cca = dVar;
        this.mListView = this.bQa.getListView();
        this.ccc = this.bQa.ZI();
        this.mScreenHeight = com.baidu.adp.lib.util.k.ag(this.bOf.getBaseContext());
        this.mHandler = new Handler(new at(this));
    }

    private boolean aeh() {
        return this.ccc == null || this.cca == null || this.ccb == null || this.bOf == null || this.bQa == null || this.mListView == null;
    }

    public int aei() {
        if (this.offset - 1 > 0) {
            return this.offset - 1;
        }
        return 0;
    }

    private void aej() {
        if (this.ccc != null && this.ccf == 0) {
            this.ccf = this.ccc.getMeasuredHeight();
        }
        if (this.ajP == null && this.cca.abB() != null) {
            this.ajP = new au(this);
            this.cca.abB().getViewTreeObserver().addOnGlobalLayoutListener(this.ajP);
        }
    }

    public void dC(boolean z) {
        this.ccg = z;
    }

    private boolean aek() {
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

    private void ael() {
        if (this.ccd == null) {
            this.ccd = BdListViewHelper.a(this.bOf.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
            ViewGroup.LayoutParams layoutParams = this.ccd.getLayoutParams();
            if (layoutParams.height != this.ccf) {
                layoutParams.height = this.ccf;
                this.ccd.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.mListView.addHeaderView(this.ccd, 0);
    }

    private boolean aem() {
        ViewGroup.LayoutParams layoutParams;
        if (!(!aek() || this.ccb.adP() == null || this.ccb.adP().aer() == null || this.mListView.indexOfChild(this.ccb.adP().aer()) < 0)) {
            View aer = this.ccb.adP().aer();
            if (aer != null) {
                if (aer.getTop() >= this.ccf) {
                    return false;
                }
                if (this.cce == null) {
                    this.cce = new View(this.bOf.getBaseContext());
                    layoutParams = new AbsListView.LayoutParams(-1, this.mScreenHeight);
                } else {
                    layoutParams = this.cce.getLayoutParams();
                    layoutParams.height = this.mScreenHeight;
                }
                this.cce.setLayoutParams(layoutParams);
                this.mListView.addFooterView(this.cce);
                if (this.bOf.YT() != null && this.bOf.YT().hasMore()) {
                    this.bOf.ln();
                }
            }
            iJ(0);
        }
        return true;
    }

    private void dN(boolean z) {
        if (this.bOf.YZ() != null) {
            this.bOf.YZ().dO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aen() {
        if (!aeh() && !this.aPH && !this.cch && aem()) {
            View abB = this.cca.abB();
            int indexOfChild = this.mListView.indexOfChild(abB);
            if (abB != null && Math.abs(abB.getTop() - this.ccf) > 25 && indexOfChild >= 0) {
                this.mListView.smoothScrollBy(abB.getTop() - this.ccf, 300);
                this.mHandler.sendEmptyMessageDelayed(1, 300L);
                dN(false);
                return;
            }
            adR();
            this.bOf.dz(true);
            this.mListView.addHeaderView(this.cca.abB(), 0);
            ael();
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            if (indexOfChild >= 0) {
                firstVisiblePosition = 0;
            }
            this.mListView.removeFooterView(this.cce);
            this.mListView.setSelection(firstVisiblePosition);
            this.aPH = true;
            this.bQa.dI(true);
            dN(true);
            iJ(0);
            if (this.bQa.Lc() != null) {
                this.bQa.Lc().a(this.mListView.getFirstVisiblePosition(), this.mListView.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void adR() {
        this.offset = -1;
        if (this.ccb.adP() != null && this.mListView.removeHeaderView(this.ccb.adP().getView())) {
            this.offset++;
        }
        if (this.ccb.adP() != null && this.mListView.removeHeaderView(this.ccb.adP().aer())) {
            this.offset++;
        }
        if (this.mListView.removeHeaderView(this.cca.abB())) {
            this.offset++;
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOf.getPageContext(), 3);
        aVar.a(this.mListView);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        this.mListView.removeHeaderView(this.ccd);
    }

    public void aeo() {
        if (!aeh() && this.aPH) {
            this.mHandler.removeMessages(1);
            this.cch = true;
            this.aPH = false;
            this.offset = 0;
            this.mListView.removeHeaderView(this.ccd);
            this.bOf.Zg();
            if (this.mListView.getFirstVisiblePosition() == 0 && this.ccb.aed() > 0) {
                this.mListView.setSelection(this.ccb.aed() - 1);
            }
            this.mListView.smoothScrollToPosition(0);
            if (this.bOf.YS() != null) {
                this.bOf.YS().adj();
            }
            this.mHandler.sendEmptyMessageDelayed(0, 50L);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE, this.bOf.getUniqueId()));
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Zh() {
        return this.aPH;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!aeh() && absListView != null) {
            aej();
            if (this.ccb.adP() != null) {
                View aer = this.ccb.adP().aer();
                View abB = this.cca.abB();
                if (aer != null && abB != null) {
                    if (i == 0) {
                        if (!this.cch) {
                            int top = aer.getTop();
                            if (top < this.ccf && absListView.indexOfChild(abB) >= 0) {
                                int top2 = abB.getTop();
                                if (top != this.ccf && top2 != this.ccf) {
                                    int i2 = top2 - top;
                                    int i3 = this.ccf - top;
                                    if (i3 > 0 && !this.aPH) {
                                        if (i3 > i2 * 0.5f) {
                                            this.mHandler.sendEmptyMessage(1);
                                            return;
                                        }
                                        if (this.mHandler.hasMessages(1)) {
                                            this.mHandler.removeMessages(1);
                                        }
                                        absListView.smoothScrollBy(-i3, 300);
                                        iJ(0);
                                    }
                                }
                            } else if (!this.mHandler.hasMessages(1)) {
                                a(absListView, aer, abB);
                            }
                        }
                    } else if (i == 1) {
                        dN(true);
                        if (this.cch) {
                            this.cch = false;
                            this.mHandler.removeMessages(0);
                            a(absListView, aer, abB);
                        }
                        if (this.mHandler.hasMessages(1)) {
                            this.mHandler.removeMessages(1);
                        }
                        if (this.cce != null && this.cce.getParent() != null) {
                            this.mListView.removeFooterView(this.cce);
                        }
                    }
                }
            }
        }
    }

    private void a(AbsListView absListView, View view, View view2) {
        if (absListView != null && view != null && view2 != null && this.ccb.adP() != null && absListView.indexOfChild(view2) < 0 && absListView.indexOfChild(view) < 0 && absListView.indexOfChild(this.ccb.adP().getView()) < 0 && !this.aPH) {
            aen();
        }
    }

    public void a(AbsListView absListView, int i) {
        if (!aeh() && absListView != null && this.ccb.adP() != null) {
            aej();
            View aer = this.ccb.adP().aer();
            View abB = this.cca.abB();
            if (aer != null && abB != null) {
                int top = abB.getTop();
                int top2 = aer.getTop();
                int indexOfChild = absListView.indexOfChild(abB);
                if (this.ccl != null) {
                    if (this.cci != (indexOfChild >= 0)) {
                        this.cci = indexOfChild >= 0;
                        this.ccl.en(this.cci);
                    }
                }
                if (this.ccc.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ccc.getLayoutParams();
                    if (top2 < this.ccf && indexOfChild >= 0) {
                        int i2 = top - this.ccf;
                        float f = (i2 * 1.0f) / (top - top2);
                        if (i2 > 0) {
                            i2 = 0;
                        }
                        if ((this.ccg || layoutParams.topMargin != 0) && indexOfChild == 1 && (this.ccj || top >= this.ccc.getBottom())) {
                            layoutParams.topMargin = i2;
                        }
                        boolean z = f < 0.05f;
                        if (!this.aPH) {
                            this.bQa.dI(z);
                        }
                        float f2 = 2.0f * (1.0f - f);
                        if (f2 > 0.3f) {
                            f2 = 0.3f;
                        }
                        U(f2);
                        this.cck = SystemClock.uptimeMillis();
                    } else {
                        if (this.mListView.indexOfChild(aer) >= 0 || SystemClock.uptimeMillis() - this.cck > 360) {
                            layoutParams.topMargin = 0;
                        } else {
                            layoutParams.topMargin = -this.ccf;
                        }
                        U(0.0f);
                    }
                    if (this.aPH && i == 0 && this.bOf.YZ() != null) {
                        this.bOf.YZ().Xe();
                    }
                    this.ccc.setLayoutParams(layoutParams);
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
        if (this.ccb.adP() != null && this.ccb.adP().aes() != null) {
            this.ccb.adP().aes().setBackgroundColor(argb);
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bOf.getPageContext(), 2);
        aVar.setMaskColor(argb);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public boolean b(MotionEvent motionEvent, View view) {
        if (!this.aPH && !this.cch && !this.mHandler.hasMessages(1)) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(MotionEvent.obtain(motionEvent));
            this.mVelocityTracker.computeCurrentVelocity(100, 1000.0f);
            if (motionEvent.getAction() == 1 && this.mVelocityTracker.getYVelocity() <= -250.0f && this.mListView.indexOfChild(this.cca.abB()) >= 0) {
                aen();
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
    public void iJ(int i) {
        if (this.ccc != null && (this.ccc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ccc.getLayoutParams();
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                this.ccc.setLayoutParams(layoutParams);
            }
        }
    }

    public void p(View view, int i) {
        if (view == this.ccc) {
            if (this.ccd != null) {
                ViewGroup.LayoutParams layoutParams = this.ccd.getLayoutParams();
                layoutParams.height = i;
                this.ccd.setLayoutParams(layoutParams);
            }
            this.ccf = i;
        }
    }

    public void ld() {
        iJ(0);
    }
}
