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
public class aq {
    private final FrsActivity bHh;
    private final ax bJc;
    private final com.baidu.tieba.frs.entelechy.b.d bWe;
    private final u bWf;
    private final ObservedChangeLinearLayout bWg;
    private Handler mHandler;
    private final BdTypeListView mListView;
    private int mScreenHeight;
    private View bWh = null;
    private View bWi = null;
    private VelocityTracker mVelocityTracker = null;
    private int bWj = 0;
    private int offset = 0;
    private boolean aJI = false;
    private boolean bWk = true;
    private boolean bWl = false;
    private boolean bWm = false;
    private boolean bWn = false;
    private long bWo = 0;
    private a bWp = null;
    private ViewTreeObserver.OnGlobalLayoutListener aem = null;

    /* loaded from: classes.dex */
    public interface a {
        void en(boolean z);
    }

    public aq(FrsActivity frsActivity, ax axVar, com.baidu.tieba.frs.entelechy.b.d dVar, u uVar) {
        this.mScreenHeight = 0;
        if (axVar == null || frsActivity == null || dVar == null || uVar == null) {
            throw new IllegalArgumentException("all arguments can not be null value");
        }
        this.bHh = frsActivity;
        this.bJc = axVar;
        this.bWf = uVar;
        this.bWe = dVar;
        this.mListView = this.bJc.Iv();
        this.bWg = this.bJc.Yl();
        this.mScreenHeight = com.baidu.adp.lib.util.k.J(this.bHh.getBaseContext());
        this.mHandler = new Handler(new ar(this));
    }

    private boolean adm() {
        return this.bWg == null || this.bWe == null || this.bWf == null || this.bHh == null || this.bJc == null || this.mListView == null;
    }

    public int adn() {
        if (this.offset - 1 > 0) {
            return this.offset - 1;
        }
        return 0;
    }

    private void ado() {
        if (this.bWg != null && this.bWj == 0) {
            this.bWj = this.bWg.getMeasuredHeight();
        }
        if (this.aem == null && this.bWe.aah() != null) {
            this.aem = new as(this);
            this.bWe.aah().getViewTreeObserver().addOnGlobalLayoutListener(this.aem);
        }
    }

    public void dA(boolean z) {
        this.bWk = z;
    }

    private boolean adp() {
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

    private void adq() {
        if (this.bWh == null) {
            this.bWh = BdListViewHelper.a(this.bHh.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
            ViewGroup.LayoutParams layoutParams = this.bWh.getLayoutParams();
            if (layoutParams.height != this.bWj) {
                layoutParams.height = this.bWj;
                this.bWh.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.mListView.addHeaderView(this.bWh, 0);
    }

    private boolean adr() {
        ViewGroup.LayoutParams layoutParams;
        if (!(!adp() || this.bWf.acU() == null || this.bWf.acU().adw() == null || this.mListView.indexOfChild(this.bWf.acU().adw()) < 0)) {
            View adw = this.bWf.acU().adw();
            if (adw != null) {
                if (adw.getTop() >= this.bWj) {
                    return false;
                }
                if (this.bWi == null) {
                    this.bWi = new View(this.bHh.getBaseContext());
                    layoutParams = new AbsListView.LayoutParams(-1, this.mScreenHeight);
                } else {
                    layoutParams = this.bWi.getLayoutParams();
                    layoutParams.height = this.mScreenHeight;
                }
                this.bWi.setLayoutParams(layoutParams);
                this.mListView.addFooterView(this.bWi);
                if (this.bHh.Xy() != null && this.bHh.Xy().hasMore()) {
                    this.bHh.kp();
                }
            }
            iM(0);
        }
        return true;
    }

    private void dL(boolean z) {
        if (this.bHh.XE() != null) {
            this.bHh.XE().dM(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ads() {
        if (!adm() && !this.aJI && !this.bWl && adr()) {
            View aah = this.bWe.aah();
            int indexOfChild = this.mListView.indexOfChild(aah);
            if (aah != null && Math.abs(aah.getTop() - this.bWj) > 25 && indexOfChild >= 0) {
                this.mListView.smoothScrollBy(aah.getTop() - this.bWj, 300);
                this.mHandler.sendEmptyMessageDelayed(1, 300L);
                dL(false);
                return;
            }
            acW();
            this.bHh.dx(true);
            this.mListView.addHeaderView(this.bWe.aah(), 0);
            adq();
            int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
            if (indexOfChild >= 0) {
                firstVisiblePosition = 0;
            }
            this.mListView.removeFooterView(this.bWi);
            this.mListView.setSelection(firstVisiblePosition);
            this.aJI = true;
            this.bJc.dG(true);
            dL(true);
            iM(0);
            if (this.bJc.JX() != null) {
                this.bJc.JX().a(this.mListView.getFirstVisiblePosition(), this.mListView.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void acW() {
        this.offset = -1;
        if (this.bWf.acU() != null && this.mListView.removeHeaderView(this.bWf.acU().getView())) {
            this.offset++;
        }
        if (this.bWf.acU() != null && this.mListView.removeHeaderView(this.bWf.acU().adw())) {
            this.offset++;
        }
        if (this.mListView.removeHeaderView(this.bWe.aah())) {
            this.offset++;
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bHh.getPageContext(), 3);
        aVar.a(this.mListView);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        this.mListView.removeHeaderView(this.bWh);
    }

    public void adt() {
        if (!adm() && this.aJI) {
            this.mHandler.removeMessages(1);
            this.bWl = true;
            this.aJI = false;
            this.offset = 0;
            this.mListView.removeHeaderView(this.bWh);
            this.bHh.XL();
            if (this.mListView.getFirstVisiblePosition() == 0 && this.bWf.adi() > 0) {
                this.mListView.setSelection(this.bWf.adi() - 1);
            }
            this.mListView.smoothScrollToPosition(0);
            if (this.bHh.Xx() != null) {
                this.bHh.Xx().acr();
            }
            this.mHandler.sendEmptyMessageDelayed(0, 50L);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXIT_STICKY_MODE, this.bHh.getUniqueId()));
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean XM() {
        return this.aJI;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (!adm() && absListView != null) {
            ado();
            if (this.bWf.acU() != null) {
                View adw = this.bWf.acU().adw();
                View aah = this.bWe.aah();
                if (adw != null && aah != null) {
                    if (i == 0) {
                        if (!this.bWl) {
                            int top = adw.getTop();
                            if (top < this.bWj && absListView.indexOfChild(aah) >= 0) {
                                int top2 = aah.getTop();
                                if (top != this.bWj && top2 != this.bWj) {
                                    int i2 = top2 - top;
                                    int i3 = this.bWj - top;
                                    if (i3 > 0 && !this.aJI) {
                                        if (i3 > i2 * 0.5f) {
                                            this.mHandler.sendEmptyMessage(1);
                                            return;
                                        }
                                        if (this.mHandler.hasMessages(1)) {
                                            this.mHandler.removeMessages(1);
                                        }
                                        absListView.smoothScrollBy(-i3, 300);
                                        iM(0);
                                    }
                                }
                            } else if (!this.mHandler.hasMessages(1)) {
                                a(absListView, adw, aah);
                            }
                        }
                    } else if (i == 1) {
                        dL(true);
                        if (this.bWl) {
                            this.bWl = false;
                            this.mHandler.removeMessages(0);
                            a(absListView, adw, aah);
                        }
                        if (this.mHandler.hasMessages(1)) {
                            this.mHandler.removeMessages(1);
                        }
                        if (this.bWi != null && this.bWi.getParent() != null) {
                            this.mListView.removeFooterView(this.bWi);
                        }
                    }
                }
            }
        }
    }

    private void a(AbsListView absListView, View view, View view2) {
        if (absListView != null && view != null && view2 != null && this.bWf.acU() != null && absListView.indexOfChild(view2) < 0 && absListView.indexOfChild(view) < 0 && absListView.indexOfChild(this.bWf.acU().getView()) < 0 && !this.aJI) {
            ads();
        }
    }

    public void a(AbsListView absListView, int i) {
        if (!adm() && absListView != null && this.bWf.acU() != null) {
            ado();
            View adw = this.bWf.acU().adw();
            View aah = this.bWe.aah();
            if (adw != null && aah != null) {
                int top = aah.getTop();
                int top2 = adw.getTop();
                int indexOfChild = absListView.indexOfChild(aah);
                if (this.bWp != null) {
                    if (this.bWm != (indexOfChild >= 0)) {
                        this.bWm = indexOfChild >= 0;
                        this.bWp.en(this.bWm);
                    }
                }
                if (this.bWg.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bWg.getLayoutParams();
                    if (top2 < this.bWj && indexOfChild >= 0) {
                        int i2 = top - this.bWj;
                        float f = (i2 * 1.0f) / (top - top2);
                        if (i2 > 0) {
                            i2 = 0;
                        }
                        if ((this.bWk || layoutParams.topMargin != 0) && indexOfChild == 1 && (this.bWn || top >= this.bWg.getBottom())) {
                            layoutParams.topMargin = i2;
                        }
                        boolean z = f < 0.05f;
                        if (!this.aJI) {
                            this.bJc.dG(z);
                        }
                        float f2 = 2.0f * (1.0f - f);
                        if (f2 > 0.3f) {
                            f2 = 0.3f;
                        }
                        U(f2);
                        this.bWo = SystemClock.uptimeMillis();
                    } else {
                        if (this.mListView.indexOfChild(adw) >= 0 || SystemClock.uptimeMillis() - this.bWo > 360) {
                            layoutParams.topMargin = 0;
                        } else {
                            layoutParams.topMargin = -this.bWj;
                        }
                        U(0.0f);
                    }
                    if (this.aJI && i == 0 && this.bHh.XE() != null) {
                        this.bHh.XE().VI();
                    }
                    this.bWg.setLayoutParams(layoutParams);
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
        if (this.bWf.acU() != null && this.bWf.acU().adx() != null) {
            this.bWf.acU().adx().setBackgroundColor(argb);
        }
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.bHh.getPageContext(), 2);
        aVar.setMaskColor(argb);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public boolean b(MotionEvent motionEvent, View view) {
        if (!this.aJI && !this.bWl && !this.mHandler.hasMessages(1)) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(MotionEvent.obtain(motionEvent));
            this.mVelocityTracker.computeCurrentVelocity(100, 1000.0f);
            if (motionEvent.getAction() == 1 && this.mVelocityTracker.getYVelocity() <= -250.0f && this.mListView.indexOfChild(this.bWe.aah()) >= 0) {
                ads();
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
    public void iM(int i) {
        if (this.bWg != null && (this.bWg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bWg.getLayoutParams();
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                this.bWg.setLayoutParams(layoutParams);
            }
        }
    }

    public void p(View view, int i) {
        if (view == this.bWg) {
            if (this.bWh != null) {
                ViewGroup.LayoutParams layoutParams = this.bWh.getLayoutParams();
                layoutParams.height = i;
                this.bWh.setLayoutParams(layoutParams);
            }
            this.bWj = i;
        }
    }

    public void kf() {
        iM(0);
    }
}
