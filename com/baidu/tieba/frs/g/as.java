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
    private final FrsActivity bQw;
    private final az bSr;
    private final com.baidu.tieba.frs.entelechy.b.d cer;
    private final u ces;
    private final ObservedChangeLinearLayout cet;
    private Handler mHandler;
    private final BdTypeListView mListView;
    private int mScreenHeight;
    private View ceu = null;
    private View cev = null;
    private VelocityTracker mVelocityTracker = null;
    private int cew = 0;
    private int offset = 0;
    private boolean aPJ = false;
    private boolean cex = true;
    private boolean cey = false;
    private boolean cez = false;
    private boolean ceA = false;
    private long ceB = 0;
    private a ceC = null;
    private ViewTreeObserver.OnGlobalLayoutListener ajQ = null;

    /* loaded from: classes.dex */
    public interface a {
        void ex(boolean z);
    }

    public as(FrsActivity frsActivity, az azVar, com.baidu.tieba.frs.entelechy.b.d dVar, u uVar) {
        this.mScreenHeight = 0;
        if (azVar == null || frsActivity == null || dVar == null || uVar == null) {
            throw new IllegalArgumentException("all arguments can not be null value");
        }
        this.bQw = frsActivity;
        this.bSr = azVar;
        this.ces = uVar;
        this.cer = dVar;
        this.mListView = this.bSr.getListView();
        this.cet = this.bSr.aaJ();
        this.mScreenHeight = com.baidu.adp.lib.util.k.ag(this.bQw.getBaseContext());
        this.mHandler = new Handler(new at(this));
    }

    private boolean afi() {
        return this.cet == null || this.cer == null || this.ces == null || this.bQw == null || this.bSr == null || this.mListView == null;
    }

    public int afj() {
        if (this.offset - 1 > 0) {
            return this.offset - 1;
        }
        return 0;
    }

    private void afk() {
        if (this.cet != null && this.cew == 0) {
            this.cew = this.cet.getMeasuredHeight();
        }
        if (this.ajQ == null && this.cer.acC() != null) {
            this.ajQ = new au(this);
            this.cer.acC().getViewTreeObserver().addOnGlobalLayoutListener(this.ajQ);
        }
    }

    public void dM(boolean z) {
        this.cex = z;
    }

    private boolean afl() {
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

    private void afm() {
        if (this.ceu == null) {
            this.ceu = BdListViewHelper.a(this.bQw.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
            ViewGroup.LayoutParams layoutParams = this.ceu.getLayoutParams();
            if (layoutParams.height != this.cew) {
                layoutParams.height = this.cew;
                this.ceu.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.mListView.addHeaderView(this.ceu, 0);
    }

    private boolean afn() {
        ViewGroup.LayoutParams layoutParams;
        if (!(!afl() || this.ces.aeQ() == null || this.ces.aeQ().afs() == null || this.mListView.indexOfChild(this.ces.aeQ().afs()) < 0)) {
            View afs = this.ces.aeQ().afs();
            if (afs != null) {
                if (afs.getTop() >= this.cew) {
                    return false;
                }
                if (this.cev == null) {
                    this.cev = new View(this.bQw.getBaseContext());
                    layoutParams = new AbsListView.LayoutParams(-1, this.mScreenHeight);
                } else {
                    layoutParams = this.cev.getLayoutParams();
                    layoutParams.height = this.mScreenHeight;
                }
                this.cev.setLayoutParams(layoutParams);
                this.mListView.addFooterView(this.cev);
                if (this.bQw.ZU() != null && this.bQw.ZU().hasMore()) {
                    this.bQw.lo();
                }
            }
            iP(0);
        }
        return true;
    }

    private void dX(boolean z) {
        if (this.bQw.aaa() != null) {
            this.bQw.aaa().dY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        if (!afi() && !this.aPJ && !this.cey && afn()) {
            View acC = this.cer.acC();
            int indexOfChild = this.mListView.indexOfChild(acC);
            if (acC != null && Math.abs(acC.getTop() - this.cew) > 25 && indexOfChild >= 0) {
                this.mListView.smoothScrollBy(acC.getTop() - this.cew, 300);
                this.mHandler.sendEmptyMessageDelayed(1, 300L);
                dX(false);
                return;
            }
            aeS();
            this.bQw.dJ(true);
            this.mListView.addHeaderView(this.cer.acC(), 0);
            afm();
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            if (indexOfChild >= 0) {
                firstVisiblePosition = 0;
            }
            this.mListView.removeFooterView(this.cev);
            this.mListView.setSelection(firstVisiblePosition);
            this.aPJ = true;
            this.bSr.dS(true);
            dX(true);
            iP(0);
            if (this.bSr.Lc() != null) {
                this.bSr.Lc().a(this.mListView.getFirstVisiblePosition(), this.mListView.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void aeS() {
        this.offset = -1;
        if (this.ces.aeQ() != null && this.mListView.removeHeaderView(this.ces.aeQ().getView())) {
            this.offset++;
        }
        if (this.ces.aeQ() != null && this.mListView.removeHeaderView(this.ces.aeQ().afs())) {
            this.offset++;
        }
        if (this.mListView.removeHeaderView(this.cer.acC())) {
            this.offset++;
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bQw.getPageContext(), 3);
        aVar.a(this.mListView);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        this.mListView.removeHeaderView(this.ceu);
    }

    public void afp() {
        if (!afi() && this.aPJ) {
            this.mHandler.removeMessages(1);
            this.cey = true;
            this.aPJ = false;
            this.offset = 0;
            this.mListView.removeHeaderView(this.ceu);
            this.bQw.aah();
            if (this.mListView.getFirstVisiblePosition() == 0 && this.ces.afe() > 0) {
                this.mListView.setSelection(this.ces.afe() - 1);
            }
            this.mListView.smoothScrollToPosition(0);
            if (this.bQw.ZT() != null) {
                this.bQw.ZT().aek();
            }
            this.mHandler.sendEmptyMessageDelayed(0, 50L);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE, this.bQw.getUniqueId()));
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aai() {
        return this.aPJ;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!afi() && absListView != null) {
            afk();
            if (this.ces.aeQ() != null) {
                View afs = this.ces.aeQ().afs();
                View acC = this.cer.acC();
                if (afs != null && acC != null) {
                    if (i == 0) {
                        if (!this.cey) {
                            int top = afs.getTop();
                            if (top < this.cew && absListView.indexOfChild(acC) >= 0) {
                                int top2 = acC.getTop();
                                if (top != this.cew && top2 != this.cew) {
                                    int i2 = top2 - top;
                                    int i3 = this.cew - top;
                                    if (i3 > 0 && !this.aPJ) {
                                        if (i3 > i2 * 0.5f) {
                                            this.mHandler.sendEmptyMessage(1);
                                            return;
                                        }
                                        if (this.mHandler.hasMessages(1)) {
                                            this.mHandler.removeMessages(1);
                                        }
                                        absListView.smoothScrollBy(-i3, 300);
                                        iP(0);
                                    }
                                }
                            } else if (!this.mHandler.hasMessages(1)) {
                                a(absListView, afs, acC);
                            }
                        }
                    } else if (i == 1) {
                        dX(true);
                        if (this.cey) {
                            this.cey = false;
                            this.mHandler.removeMessages(0);
                            a(absListView, afs, acC);
                        }
                        if (this.mHandler.hasMessages(1)) {
                            this.mHandler.removeMessages(1);
                        }
                        if (this.cev != null && this.cev.getParent() != null) {
                            this.mListView.removeFooterView(this.cev);
                        }
                    }
                }
            }
        }
    }

    private void a(AbsListView absListView, View view, View view2) {
        if (absListView != null && view != null && view2 != null && this.ces.aeQ() != null && absListView.indexOfChild(view2) < 0 && absListView.indexOfChild(view) < 0 && absListView.indexOfChild(this.ces.aeQ().getView()) < 0 && !this.aPJ) {
            afo();
        }
    }

    public void a(AbsListView absListView, int i) {
        if (!afi() && absListView != null && this.ces.aeQ() != null) {
            afk();
            View afs = this.ces.aeQ().afs();
            View acC = this.cer.acC();
            if (afs != null && acC != null) {
                int top = acC.getTop();
                int top2 = afs.getTop();
                int indexOfChild = absListView.indexOfChild(acC);
                if (this.ceC != null) {
                    if (this.cez != (indexOfChild >= 0)) {
                        this.cez = indexOfChild >= 0;
                        this.ceC.ex(this.cez);
                    }
                }
                if (this.cet.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cet.getLayoutParams();
                    if (top2 < this.cew && indexOfChild >= 0) {
                        int i2 = top - this.cew;
                        float f = (i2 * 1.0f) / (top - top2);
                        if (i2 > 0) {
                            i2 = 0;
                        }
                        if ((this.cex || layoutParams.topMargin != 0) && indexOfChild == 1 && (this.ceA || top >= this.cet.getBottom())) {
                            layoutParams.topMargin = i2;
                        }
                        boolean z = f < 0.05f;
                        if (!this.aPJ) {
                            this.bSr.dS(z);
                        }
                        float f2 = 2.0f * (1.0f - f);
                        if (f2 > 0.3f) {
                            f2 = 0.3f;
                        }
                        U(f2);
                        this.ceB = SystemClock.uptimeMillis();
                    } else {
                        if (this.mListView.indexOfChild(afs) >= 0 || SystemClock.uptimeMillis() - this.ceB > 360) {
                            layoutParams.topMargin = 0;
                        } else {
                            layoutParams.topMargin = -this.cew;
                        }
                        U(0.0f);
                    }
                    if (this.aPJ && i == 0 && this.bQw.aaa() != null) {
                        this.bQw.aaa().Yf();
                    }
                    this.cet.setLayoutParams(layoutParams);
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
        if (this.ces.aeQ() != null && this.ces.aeQ().aft() != null) {
            this.ces.aeQ().aft().setBackgroundColor(argb);
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bQw.getPageContext(), 2);
        aVar.setMaskColor(argb);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public boolean b(MotionEvent motionEvent, View view) {
        if (!this.aPJ && !this.cey && !this.mHandler.hasMessages(1)) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(MotionEvent.obtain(motionEvent));
            this.mVelocityTracker.computeCurrentVelocity(100, 1000.0f);
            if (motionEvent.getAction() == 1 && this.mVelocityTracker.getYVelocity() <= -250.0f && this.mListView.indexOfChild(this.cer.acC()) >= 0) {
                afo();
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
    public void iP(int i) {
        if (this.cet != null && (this.cet.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cet.getLayoutParams();
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                this.cet.setLayoutParams(layoutParams);
            }
        }
    }

    public void p(View view, int i) {
        if (view == this.cet) {
            if (this.ceu != null) {
                ViewGroup.LayoutParams layoutParams = this.ceu.getLayoutParams();
                layoutParams.height = i;
                this.ceu.setLayoutParams(layoutParams);
            }
            this.cew = i;
        }
    }

    public void le() {
        iP(0);
    }
}
