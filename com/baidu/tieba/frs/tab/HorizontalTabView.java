package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aVF;
    private cd cbA;
    private a cbB;
    public int cbo;
    private final LinearLayout cbp;
    private final j cbq;
    private TabItemView cbr;
    private g cbs;
    private final int cbt;
    private final int cbu;
    private int cbv;
    private boolean cbw;
    private int cbx;
    private j.b cby;
    private j.a cbz;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void ii(int i);

        boolean ij(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        cl clVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (iE(tabItemView.getTabId())) {
                if (this.cbA != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    cl clVar2 = new cl();
                    clVar2.bSx = tabItemView.getUrl();
                    this.cbA.a(tabItemView.getTabId(), -1, clVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cbA != null) {
                    this.cbA.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cbr = tabItemView;
                int[] iArr = new int[2];
                this.cbr.getLocationOnScreen(iArr);
                int af = com.baidu.adp.lib.util.k.af(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds160);
                if (iArr[0] < 0) {
                    post(new d(this, dimensionPixelSize));
                } else if (af < dimensionPixelSize) {
                    post(new e(this));
                }
                for (int i2 = 0; i2 < this.cbp.getChildCount(); i2++) {
                    View childAt = this.cbp.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cbr.getTabId() && !iE(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cbG);
                        }
                    }
                }
                if (this.cbr.getState() == TabItemView.cbG || this.cbr.getState() == TabItemView.cbI) {
                    this.cbq.aeu();
                    boolean z2 = this.cbr.getState() == TabItemView.cbG;
                    this.cbr.setState(TabItemView.cbH);
                    i iA = iA(this.cbr.getTabId());
                    if (!TextUtils.isEmpty(iA.url)) {
                        cl clVar3 = new cl();
                        clVar3.bSx = iA.url;
                        clVar3.stType = iA.name;
                        clVar = clVar3;
                    }
                    if (iA.cbF != null && iA.cbF.bSj != null && iA.cbF.bSj.size() > 0) {
                        for (cv cvVar : iA.cbF.bSj) {
                            if (cvVar != null && cvVar.isSelected) {
                                i = cvVar.bSf;
                            }
                        }
                    }
                    if (z2 && this.cbA != null) {
                        this.cbA.a(this.cbr.getTabId(), i, clVar);
                    }
                } else if (iB(this.cbr.getTabId()) && !z) {
                    if (this.cbB == null || this.cbB.ij(this.cbr.getTabId())) {
                        this.cbr.setState(TabItemView.cbI);
                        this.cbq.a((Activity) getContext(), this, this.cbr, iA(this.cbr.getTabId()).cbF);
                    } else {
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.cbo = 0;
        this.cbr = null;
        this.cbs = null;
        this.mPaint = new Paint();
        this.cbt = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cbu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cbv = 0;
        this.cbw = true;
        this.cbx = w.e.common_color_10059;
        this.cby = new com.baidu.tieba.frs.tab.a(this);
        this.cbz = new b(this);
        this.mOnClickListener = new c(this);
        this.cbp = new LinearLayout(activity);
        this.cbp.setOrientation(0);
        this.cbp.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(w.f.ds80));
        this.cbq = new j(activity, this.cby, this.cbz);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbo = 0;
        this.cbr = null;
        this.cbs = null;
        this.mPaint = new Paint();
        this.cbt = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cbu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cbv = 0;
        this.cbw = true;
        this.cbx = w.e.common_color_10059;
        this.cby = new com.baidu.tieba.frs.tab.a(this);
        this.cbz = new b(this);
        this.mOnClickListener = new c(this);
        this.cbp = new LinearLayout(context);
        this.cbp.setOrientation(0);
        this.cbp.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds80));
        this.cbq = new j(context, this.cby, this.cbz);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cbo = 0;
        this.cbr = null;
        this.cbs = null;
        this.mPaint = new Paint();
        this.cbt = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cbu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cbv = 0;
        this.cbw = true;
        this.cbx = w.e.common_color_10059;
        this.cby = new com.baidu.tieba.frs.tab.a(this);
        this.cbz = new b(this);
        this.mOnClickListener = new c(this);
        this.cbp = new LinearLayout(activity);
        this.cbp.setOrientation(0);
        this.cbp.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cbq = new j(activity, this.cby, this.cbz);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cbp, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aq.k(this, w.e.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aw(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i iA = iA(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.cbE == 1) {
                iVar = next;
                break;
            }
        }
        if (iA == null || iVar == null) {
            return false;
        }
        if (iA.cbF == null && iVar.cbF == null) {
            return false;
        }
        if ((iA.cbF != null || iVar.cbF == null) && (iVar.cbF != null || iA.cbF == null)) {
            if (iA.cbF == null || iVar.cbF == null) {
                return false;
            }
            if (iA.cbF.bSj == null && iVar.cbF.bSj == null) {
                return false;
            }
            if ((iA.cbF.bSj != null || iVar.cbF.bSj == null) && (iVar.cbF.bSj != null || iA.cbF.bSj == null)) {
                int size = iA.cbF.bSj.size();
                if (size != iVar.cbF.bSj.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    cv cvVar = iVar.cbF.bSj.get(i);
                    cv cvVar2 = iA.cbF.bSj.get(i);
                    if (cvVar.bSf != cvVar2.bSf || !cvVar.name.equals(cvVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void d(List<i> list, int i, int i2) {
        a(list, i, i2, false);
    }

    private void a(List<i> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cbv > 0 && list.size() == this.cbv) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.af(getContext()) / this.cbv, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aVF = null;
            i iVar = new i();
            iVar.cbE = 1;
            iVar.name = getContext().getResources().getString(w.l.chosen_pb_title);
            this.cbp.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
            this.cbp.addView(tabItemView, layoutParams);
            this.cbr = tabItemView;
            tabItemView.setState(TabItemView.cbH);
            return;
        }
        setVisibility(0);
        if (this.aVF == null || aw(list)) {
            this.aVF = list;
            this.cbp.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    i iVar2 = list.get(i4);
                    if (iVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (iE(iVar2.cbE)) {
                            aq.i(tabItemView2, w.e.cp_other_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
                        }
                        this.cbp.addView(tabItemView2, layoutParams);
                        if (iVar2.cbE == i) {
                            this.cbr = tabItemView2;
                            tabItemView2.setState(TabItemView.cbH);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private i iA(int i) {
        if (i < 0 || this.aVF == null || this.aVF.size() == 0) {
            return null;
        }
        for (i iVar : this.aVF) {
            if (iVar != null && iVar.cbE == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean iB(int i) {
        i iA = iA(i);
        return (iA == null || iA.cbF == null || iA.cbF.bSj == null || iA.cbF.bSj.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.cbs = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cbr != null) {
            this.mPaint.setColor(aq.getColor(w.e.cp_bg_line_b));
            if (this.cbw) {
                canvas.drawRect(this.cbp.getLeft(), getMeasuredHeight() - this.cbu, this.cbp.getRight() > getRight() ? this.cbp.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
            canvas.drawRect(this.cbr.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cbt, (this.cbr.getRight() - getBottomLineMargin()) - this.cbr.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cbr == null || this.cbo == 0) {
            return 0;
        }
        return ((this.cbr.getMeasuredWidth() - this.cbo) - this.cbr.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iC(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cbp.getChildCount()) {
                View childAt = this.cbp.getChildAt(i3);
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

    public void setDataLoadInterface(cd cdVar) {
        this.cbA = cdVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.cbB = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.cbB;
    }

    public void setTabBackgroudColor(int i) {
        this.cbx = i;
    }

    public void xl() {
        aq.k(this, this.cbx);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cbp.getChildCount()) {
                View childAt = this.cbp.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iE(((TabItemView) childAt).getTabId())) {
                        aq.i(childAt, w.e.cp_other_b);
                    } else {
                        ((TabItemView) childAt).xl();
                    }
                }
                i = i2 + 1;
            } else {
                this.cbq.xl();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cbv = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iD(int i) {
        if (this.cbr != null && this.cbA != null) {
            this.cbA.a(this.cbr.getTabId(), i, null);
        }
    }

    public static boolean iE(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cbw = z;
        invalidate();
    }
}
