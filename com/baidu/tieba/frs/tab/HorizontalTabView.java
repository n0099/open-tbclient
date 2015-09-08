package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends HorizontalScrollView implements f {
    private View.OnTouchListener aXw;
    private final LinearLayout bbb;
    private final i bbc;
    private TabItemView bbd;
    private f bbe;
    private final int bbf;
    private final int bbg;
    private final int bbh;
    private int bbi;
    private i.a bbj;
    private dh bbk;
    private List<g> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    public void a(TabItemView tabItemView, boolean z) {
        dj djVar;
        int i = 0;
        this.bbd = tabItemView;
        int[] iArr = new int[2];
        this.bbd.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.bbb.getChildCount(); i2++) {
            View childAt = this.bbb.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.bbd.getTabId()) {
                    tabItemView2.setState(TabItemView.bbp);
                }
            }
        }
        if (this.bbd.getState() == TabItemView.bbp || this.bbd.getState() == TabItemView.bbr) {
            boolean z2 = this.bbd.getState() == TabItemView.bbp;
            this.bbd.setState(TabItemView.bbq);
            g fI = fI(this.bbd.getTabId());
            if (TextUtils.isEmpty(fI.url)) {
                djVar = null;
            } else {
                dj djVar2 = new dj();
                djVar2.aYY = fI.url;
                djVar2.stType = fI.name;
                djVar = djVar2;
            }
            if (fI.bbo != null && fI.bbo.size() > 0) {
                Iterator<h> it = fI.bbo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.isSelected) {
                        i = next.aYK;
                        break;
                    }
                }
            }
            if (z2 && this.bbk != null) {
                this.bbk.a(this.bbd.getTabId(), i, djVar);
            }
        } else if (fJ(this.bbd.getTabId()) && !z) {
            this.bbd.setState(TabItemView.bbr);
            this.bbc.a((Activity) getContext(), this, this.bbd, fI(this.bbd.getTabId()).bbo);
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bbd = null;
        this.bbe = null;
        this.mPaint = new Paint();
        this.bbf = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbg = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbh = 4;
        this.bbi = 0;
        this.bbj = new a(this);
        this.mOnClickListener = new b(this);
        this.aXw = new c(this);
        this.bbb = new LinearLayout(activity);
        this.bbb.setOrientation(0);
        this.bbb.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(i.d.ds80));
        this.bbc = new i(activity, this.bbj);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbd = null;
        this.bbe = null;
        this.mPaint = new Paint();
        this.bbf = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbg = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbh = 4;
        this.bbi = 0;
        this.bbj = new a(this);
        this.mOnClickListener = new b(this);
        this.aXw = new c(this);
        this.bbb = new LinearLayout(context);
        this.bbb.setOrientation(0);
        this.bbb.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds80));
        this.bbc = new i(context, this.bbj);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bbd = null;
        this.bbe = null;
        this.mPaint = new Paint();
        this.bbf = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbg = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbh = 4;
        this.bbi = 0;
        this.bbj = new a(this);
        this.mOnClickListener = new b(this);
        this.aXw = new c(this);
        this.bbb = new LinearLayout(activity);
        this.bbb.setOrientation(0);
        this.bbb.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bbc = new i(activity, this.bbj);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bbb, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.i(this, i.c.frs_tab_bg);
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
            this.bbb.removeAllViews();
            boolean z3 = this.bbi > 0 && list.size() == this.bbi;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
            if (z3) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.bbi;
            }
            for (g gVar : list) {
                if (gVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), gVar, i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    if (z) {
                        tabItemView.setOnTouchListener(this.aXw);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.bbb.addView(tabItemView, layoutParams);
                    if (z2) {
                        this.bbd = tabItemView;
                        tabItemView.setState(TabItemView.bbq);
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

    private g fI(int i) {
        if (i < 0 || this.mData == null || this.mData.size() == 0) {
            return null;
        }
        for (g gVar : this.mData) {
            if (gVar != null && gVar.bbn == i) {
                return gVar;
            }
        }
        return null;
    }

    private boolean fJ(int i) {
        g fI = fI(i);
        return (fI == null || fI.bbo == null || fI.bbo.size() <= 0) ? false : true;
    }

    public boolean Nm() {
        return (this.mData == null || this.mData.size() == 0) ? false : true;
    }

    public void setFakeTab(f fVar) {
        this.bbe = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bbd != null) {
            this.mPaint.setColor(al.getColor(i.c.cp_bg_line_b));
            canvas.drawRect(this.bbb.getLeft(), getMeasuredHeight() - this.bbg, this.bbb.getRight() > getRight() ? this.bbb.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(al.getColor(i.c.cp_link_tip_a));
            canvas.drawRect(this.bbd.getLeft(), getMeasuredHeight() - this.bbf, this.bbd.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fK(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bbb.getChildCount()) {
                View childAt = this.bbb.getChildAt(i3);
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

    public void setDataLoadInterface(dh dhVar) {
        this.bbk = dhVar;
    }

    public void vI() {
        al.i(this, i.c.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bbb.getChildCount()) {
                View childAt = this.bbb.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).vI();
                }
                i = i2 + 1;
            } else {
                this.bbc.vI();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bbi = i;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fL(int i) {
        if (this.bbd != null && this.bbk != null) {
            this.bbk.a(this.bbd.getTabId(), i, null);
        }
    }
}
