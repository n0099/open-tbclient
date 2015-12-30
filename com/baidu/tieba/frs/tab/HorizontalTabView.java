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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.h implements g {
    private View.OnTouchListener bhe;
    private final LinearLayout blW;
    private final i blX;
    private TabItemView blY;
    private g blZ;
    private final int bma;
    private final int bmb;
    private int bmc;
    private i.a bmd;
    private eu bme;
    private a bmf;
    private List<h> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void gq(int i);

        boolean gr(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        ex exVar;
        int i = 0;
        this.blY = tabItemView;
        int[] iArr = new int[2];
        this.blY.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(n.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.blW.getChildCount(); i2++) {
            View childAt = this.blW.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.blY.getTabId()) {
                    tabItemView2.setState(TabItemView.bmk);
                }
            }
        }
        if (this.blY.getState() == TabItemView.bmk || this.blY.getState() == TabItemView.bmm) {
            boolean z2 = this.blY.getState() == TabItemView.bmk;
            this.blY.setState(TabItemView.bml);
            h gl = gl(this.blY.getTabId());
            if (TextUtils.isEmpty(gl.url)) {
                exVar = null;
            } else {
                ex exVar2 = new ex();
                exVar2.bji = gl.url;
                exVar2.stType = gl.name;
                exVar = exVar2;
            }
            if (gl.bmj != null && gl.bmj.biD != null && gl.bmj.biD.size() > 0) {
                for (fc fcVar : gl.bmj.biD) {
                    if (fcVar != null && fcVar.isSelected) {
                        i = fcVar.biz;
                    }
                }
            }
            if (z2 && this.bme != null) {
                this.bme.a(this.blY.getTabId(), i, exVar);
            }
        } else if (gm(this.blY.getTabId()) && !z) {
            if (this.bmf == null || this.bmf.gr(this.blY.getTabId())) {
                this.blY.setState(TabItemView.bmm);
                this.blX.a((Activity) getContext(), this, this.blY, gl(this.blY.getTabId()).bmj);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.blY = null;
        this.blZ = null;
        this.mPaint = new Paint();
        this.bma = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds6);
        this.bmb = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds1);
        this.bmc = 0;
        this.bmd = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bhe = new c(this);
        this.blW = new LinearLayout(activity);
        this.blW.setOrientation(0);
        this.blW.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(n.e.ds80));
        this.blX = new i(activity, this.bmd);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blY = null;
        this.blZ = null;
        this.mPaint = new Paint();
        this.bma = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds6);
        this.bmb = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds1);
        this.bmc = 0;
        this.bmd = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bhe = new c(this);
        this.blW = new LinearLayout(context);
        this.blW.setOrientation(0);
        this.blW.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(n.e.ds80));
        this.blX = new i(context, this.bmd);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.blY = null;
        this.blZ = null;
        this.mPaint = new Paint();
        this.bma = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds6);
        this.bmb = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds1);
        this.bmc = 0;
        this.bmd = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bhe = new c(this);
        this.blW = new LinearLayout(activity);
        this.blW.setOrientation(0);
        this.blW.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.blX = new i(activity, this.bmd);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.blW, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        as.j(this, n.d.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void setData(List<h> list, int i) {
        a(list, i, false);
    }

    public void a(List<h> list, int i, boolean z) {
        boolean z2 = true;
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.mData == null || aj(list)) {
            this.mData = list;
            this.blW.removeAllViews();
            boolean z3 = this.bmc > 0 && list.size() == this.bmc;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(n.e.ds160);
            if (z3) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.bmc;
            }
            for (h hVar : list) {
                if (hVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), hVar, i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    if (z) {
                        tabItemView.setOnTouchListener(this.bhe);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.blW.addView(tabItemView, layoutParams);
                    if (z2) {
                        this.blY = tabItemView;
                        tabItemView.setState(TabItemView.bml);
                        z2 = false;
                    }
                }
            }
        }
    }

    private boolean aj(List<h> list) {
        h hVar;
        h gl = gl(1);
        Iterator<h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                hVar = null;
                break;
            }
            h next = it.next();
            if (next.bmi == 1) {
                hVar = next;
                break;
            }
        }
        if (gl == null || hVar == null) {
            return false;
        }
        if (gl.bmj == null && hVar.bmj == null) {
            return false;
        }
        if ((gl.bmj != null || hVar.bmj == null) && (hVar.bmj != null || gl.bmj == null)) {
            if (gl.bmj.biD == null && hVar.bmj.biD == null) {
                return false;
            }
            if ((gl.bmj.biD != null || hVar.bmj.biD == null) && (hVar.bmj.biD != null || gl.bmj.biD == null)) {
                int size = gl.bmj.biD.size();
                if (size != hVar.bmj.biD.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    fc fcVar = hVar.bmj.biD.get(i);
                    fc fcVar2 = gl.bmj.biD.get(i);
                    if (fcVar.biz != fcVar2.biz || !fcVar.name.equals(fcVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void setData(List<h> list) {
        a(list, 4, false);
    }

    private h gl(int i) {
        if (i < 0 || this.mData == null || this.mData.size() == 0) {
            return null;
        }
        for (h hVar : this.mData) {
            if (hVar != null && hVar.bmi == i) {
                return hVar;
            }
        }
        return null;
    }

    private boolean gm(int i) {
        h gl = gl(i);
        return (gl == null || gl.bmj == null || gl.bmj.biD == null || gl.bmj.biD.size() <= 0) ? false : true;
    }

    public boolean Pz() {
        return (this.mData == null || this.mData.size() == 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.blZ = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.blY != null) {
            this.mPaint.setColor(as.getColor(n.d.cp_bg_line_b));
            canvas.drawRect(this.blW.getLeft(), getMeasuredHeight() - this.bmb, this.blW.getRight() > getRight() ? this.blW.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(as.d((Resources) null, n.d.s_actionbar_text_line_color_s));
            canvas.drawRect(this.blY.getLeft(), getMeasuredHeight() - this.bma, this.blY.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void gn(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.blW.getChildCount()) {
                View childAt = this.blW.getChildAt(i3);
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

    public void setDataLoadInterface(eu euVar) {
        this.bme = euVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bmf = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bmf;
    }

    public void vR() {
        as.j(this, n.d.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.blW.getChildCount()) {
                View childAt = this.blW.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).vR();
                }
                i = i2 + 1;
            } else {
                this.blX.vR();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bmc = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void go(int i) {
        if (this.blY != null && this.bme != null) {
            this.bme.a(this.blY.getTabId(), i, null);
        }
    }
}
