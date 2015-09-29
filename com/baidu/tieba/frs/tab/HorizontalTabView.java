package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends HorizontalScrollView implements f {
    private View.OnTouchListener aWQ;
    private final LinearLayout baU;
    private final i baV;
    private TabItemView baW;
    private f baX;
    private final int baY;
    private final int baZ;
    private final int bba;
    private int bbb;
    private i.a bbc;
    private ea bbd;
    private List<g> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    public void a(TabItemView tabItemView, boolean z) {
        ec ecVar;
        int i = 0;
        this.baW = tabItemView;
        int[] iArr = new int[2];
        this.baW.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.baU.getChildCount(); i2++) {
            View childAt = this.baU.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.baW.getTabId()) {
                    tabItemView2.setState(TabItemView.bbi);
                }
            }
        }
        if (this.baW.getState() == TabItemView.bbi || this.baW.getState() == TabItemView.bbk) {
            boolean z2 = this.baW.getState() == TabItemView.bbi;
            this.baW.setState(TabItemView.bbj);
            g fN = fN(this.baW.getTabId());
            if (TextUtils.isEmpty(fN.url)) {
                ecVar = null;
            } else {
                ec ecVar2 = new ec();
                ecVar2.aYN = fN.url;
                ecVar2.stType = fN.name;
                ecVar = ecVar2;
            }
            if (fN.bbh != null && fN.bbh.size() > 0) {
                Iterator<h> it = fN.bbh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.isSelected) {
                        i = next.bbm;
                        break;
                    }
                }
            }
            if (z2 && this.bbd != null) {
                this.bbd.a(this.baW.getTabId(), i, ecVar);
            }
        } else if (fO(this.baW.getTabId()) && !z) {
            this.baW.setState(TabItemView.bbk);
            this.baV.a((Activity) getContext(), this, this.baW, fN(this.baW.getTabId()).bbh);
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.baW = null;
        this.baX = null;
        this.mPaint = new Paint();
        this.baY = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.baZ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bba = 4;
        this.bbb = 0;
        this.bbc = new a(this);
        this.mOnClickListener = new b(this);
        this.aWQ = new c(this);
        this.baU = new LinearLayout(activity);
        this.baU.setOrientation(0);
        this.baU.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(i.d.ds80));
        this.baV = new i(activity, this.bbc);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baW = null;
        this.baX = null;
        this.mPaint = new Paint();
        this.baY = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.baZ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bba = 4;
        this.bbb = 0;
        this.bbc = new a(this);
        this.mOnClickListener = new b(this);
        this.aWQ = new c(this);
        this.baU = new LinearLayout(context);
        this.baU.setOrientation(0);
        this.baU.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds80));
        this.baV = new i(context, this.bbc);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.baW = null;
        this.baX = null;
        this.mPaint = new Paint();
        this.baY = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.baZ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bba = 4;
        this.bbb = 0;
        this.bbc = new a(this);
        this.mOnClickListener = new b(this);
        this.aWQ = new c(this);
        this.baU = new LinearLayout(activity);
        this.baU.setOrientation(0);
        this.baU.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.baV = new i(activity, this.bbc);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.baU, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.j(this, i.c.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void setData(List<g> list, int i) {
        a(list, i, false);
    }

    public void a(List<g> list, int i, boolean z) {
        boolean z2 = true;
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.mData == null) {
            this.mData = list;
            this.baU.removeAllViews();
            boolean z3 = this.bbb > 0 && list.size() == this.bbb;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
            if (z3) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.bbb;
            }
            for (g gVar : list) {
                if (gVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), gVar, i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    if (z) {
                        tabItemView.setOnTouchListener(this.aWQ);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.baU.addView(tabItemView, layoutParams);
                    if (z2) {
                        this.baW = tabItemView;
                        tabItemView.setState(TabItemView.bbj);
                        z2 = false;
                    }
                }
            }
        }
    }

    public void setData(List<g> list) {
        a(list, 4, false);
    }

    public void setData(List<g> list, boolean z) {
        a(list, 4, z);
    }

    private g fN(int i) {
        if (i < 0 || this.mData == null || this.mData.size() == 0) {
            return null;
        }
        for (g gVar : this.mData) {
            if (gVar != null && gVar.bbg == i) {
                return gVar;
            }
        }
        return null;
    }

    private boolean fO(int i) {
        g fN = fN(i);
        return (fN == null || fN.bbh == null || fN.bbh.size() <= 0) ? false : true;
    }

    public boolean Nl() {
        return (this.mData == null || this.mData.size() == 0) ? false : true;
    }

    public void setFakeTab(f fVar) {
        this.baX = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.baW != null) {
            this.mPaint.setColor(am.getColor(i.c.cp_bg_line_b));
            canvas.drawRect(this.baU.getLeft(), getMeasuredHeight() - this.baZ, this.baU.getRight() > getRight() ? this.baU.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(am.d((Resources) null, i.c.s_actionbar_text_line_color_s));
            canvas.drawRect(this.baW.getLeft(), getMeasuredHeight() - this.baY, this.baW.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fP(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.baU.getChildCount()) {
                View childAt = this.baU.getChildAt(i3);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    if (tabItemView.getTabId() == i) {
                        a(tabItemView, true);
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void setDataLoadInterface(ea eaVar) {
        this.bbd = eaVar;
    }

    public void vA() {
        am.j(this, i.c.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.baU.getChildCount()) {
                View childAt = this.baU.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).vA();
                }
                i = i2 + 1;
            } else {
                this.baV.vA();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bbb = i;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fQ(int i) {
        if (this.baW != null && this.bbd != null) {
            this.bbd.a(this.baW.getTabId(), i, null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
