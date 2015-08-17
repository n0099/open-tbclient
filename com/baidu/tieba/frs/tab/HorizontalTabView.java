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
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends HorizontalScrollView implements f {
    private View.OnTouchListener aXA;
    private final LinearLayout baH;
    private final i baI;
    private TabItemView baJ;
    private f baK;
    private final int baL;
    private final int baM;
    private final int baN;
    private int baO;
    private i.a baP;
    private db baQ;
    private List<g> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    public void a(TabItemView tabItemView, boolean z) {
        de deVar;
        int i = 0;
        this.baJ = tabItemView;
        int[] iArr = new int[2];
        this.baJ.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.baH.getChildCount(); i2++) {
            View childAt = this.baH.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.baJ.getTabId()) {
                    tabItemView2.setState(TabItemView.baV);
                }
            }
        }
        if (this.baJ.getState() == TabItemView.baV || this.baJ.getState() == TabItemView.baX) {
            boolean z2 = this.baJ.getState() == TabItemView.baV;
            this.baJ.setState(TabItemView.baW);
            g fz = fz(this.baJ.getTabId());
            if (TextUtils.isEmpty(fz.url)) {
                deVar = null;
            } else {
                de deVar2 = new de();
                deVar2.aYH = fz.url;
                deVar = deVar2;
            }
            if (fz.baU != null && fz.baU.size() > 0) {
                Iterator<h> it = fz.baU.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.isSelected) {
                        i = next.aYt;
                        break;
                    }
                }
            }
            if (z2 && this.baQ != null) {
                this.baQ.a(this.baJ.getTabId(), i, deVar);
            }
        } else if (fA(this.baJ.getTabId())) {
            this.baJ.setState(TabItemView.baX);
            if (!z) {
                this.baI.a((Activity) getContext(), this, this.baJ, fz(this.baJ.getTabId()).baU);
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.baJ = null;
        this.baK = null;
        this.mPaint = new Paint();
        this.baL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.baM = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.baN = 4;
        this.baO = 0;
        this.baP = new a(this);
        this.mOnClickListener = new b(this);
        this.aXA = new c(this);
        this.baH = new LinearLayout(activity);
        this.baH.setOrientation(0);
        this.baH.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(i.d.ds80));
        this.baI = new i(activity, this.baP);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baJ = null;
        this.baK = null;
        this.mPaint = new Paint();
        this.baL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.baM = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.baN = 4;
        this.baO = 0;
        this.baP = new a(this);
        this.mOnClickListener = new b(this);
        this.aXA = new c(this);
        this.baH = new LinearLayout(context);
        this.baH.setOrientation(0);
        this.baH.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds80));
        this.baI = new i(context, this.baP);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.baJ = null;
        this.baK = null;
        this.mPaint = new Paint();
        this.baL = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.baM = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.baN = 4;
        this.baO = 0;
        this.baP = new a(this);
        this.mOnClickListener = new b(this);
        this.aXA = new c(this);
        this.baH = new LinearLayout(activity);
        this.baH.setOrientation(0);
        this.baH.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.baI = new i(activity, this.baP);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.baH, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.j(this, i.c.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void setData(List<g> list, int i) {
        a(list, i, false);
    }

    public void a(List<g> list, int i, boolean z) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        if (this.mData == null) {
            this.mData = list;
            this.baH.removeAllViews();
            boolean z2 = this.baO > 0 && list.size() == this.baO;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
            if (z2) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.baO;
            }
            boolean z3 = true;
            for (g gVar : list) {
                if (gVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), gVar, i);
                    if (z2) {
                        tabItemView.setWidth(dimensionPixelSize);
                    }
                    if (z) {
                        tabItemView.setOnTouchListener(this.aXA);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.baH.addView(tabItemView);
                    if (z3) {
                        this.baJ = tabItemView;
                        tabItemView.setState(TabItemView.baW);
                        z3 = false;
                    }
                }
            }
        }
        invalidate();
    }

    public void setData(List<g> list) {
        a(list, 4, false);
    }

    public void setData(List<g> list, boolean z) {
        a(list, 4, z);
    }

    private g fz(int i) {
        if (i < 0 || this.mData == null || this.mData.size() == 0) {
            return null;
        }
        for (g gVar : this.mData) {
            if (gVar != null && gVar.baT == i) {
                return gVar;
            }
        }
        return null;
    }

    private boolean fA(int i) {
        g fz = fz(i);
        return (fz == null || fz.baU == null || fz.baU.size() <= 0) ? false : true;
    }

    public boolean Nl() {
        return (this.mData == null || this.mData.size() == 0) ? false : true;
    }

    public void setFakeTab(f fVar) {
        this.baK = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.baJ != null) {
            this.mPaint.setColor(al.getColor(i.c.cp_bg_line_b));
            canvas.drawRect(this.baH.getLeft(), getMeasuredHeight() - this.baM, this.baH.getRight() > getRight() ? this.baH.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(al.getColor(i.c.cp_link_tip_a));
            canvas.drawRect(this.baJ.getLeft(), getMeasuredHeight() - this.baL, this.baJ.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fB(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.baH.getChildCount()) {
                View childAt = this.baH.getChildAt(i3);
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

    public void setDataLoadInterface(db dbVar) {
        this.baQ = dbVar;
    }

    public void vD() {
        al.j(this, i.c.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.baH.getChildCount()) {
                View childAt = this.baH.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).vD();
                }
                i = i2 + 1;
            } else {
                this.baI.vD();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.baO = i;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fC(int i) {
        if (this.baJ != null && this.baQ != null) {
            this.baQ.a(this.baJ.getTabId(), i, null);
        }
    }
}
