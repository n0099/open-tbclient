package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private b<TextView> aJn;
    private List<dt> aOE;
    private int bUd;
    private int bUe;
    private int bUf;
    private int bUg;
    private a bUh;
    private dt bUi;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, dt dtVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUd = 2;
        this.bUe = 2;
        this.bUf = 4;
        this.bUg = 5;
        setOrientation(1);
        this.mContext = context;
        this.bUe = com.baidu.adp.lib.util.k.e(context, t.e.ds20);
        this.aJn = new b<>(new dv(this), 17, 0);
        setOnHierarchyChangeListener(new dw(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ah((getChildAt(0).getMeasuredHeight() * this.bUg) + (this.bUe * (this.bUg - 1)) + (this.bUe * 2), i2));
        }
    }

    private int ah(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                return size <= i ? size : i;
            case 0:
            default:
                return i;
            case 1073741824:
                return size;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        if (childCount > 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = getChildAt(0).getMeasuredWidth();
            if (this.bUf > 1) {
                this.bUd = (measuredWidth - (measuredWidth2 * this.bUf)) / (this.bUf - 1);
            }
            int[] iArr = new int[this.bUg + 1];
            int i9 = 1;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < childCount) {
                View childAt = getChildAt(i12);
                int measuredWidth3 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = i11 + measuredWidth3;
                int i14 = i10 + measuredHeight;
                if (this.bUi != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bUe * 2) + i14;
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i9++;
                    i8 = i13;
                    i7 = i14;
                } else if (i13 > i3) {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i11 = 0;
                    i10 = iArr[i9] + i10 + this.bUe;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bUd + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bUd + i13;
                    i6 = i10;
                    i7 = i14;
                    i8 = i13;
                }
                if (i8 > i3) {
                    i8 = i3;
                }
                childAt.layout(i11, i10, i8, i7);
                i12++;
                i11 = i5;
                i10 = i6;
            }
        }
    }

    private void setData(List<dt> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds60));
            if (this.bUi != null) {
                if (av(list)) {
                    this.bUi.isSelected = false;
                } else {
                    this.bUi.isSelected = true;
                }
                this.bUg = ((int) Math.ceil(list.size() / this.bUf)) + 1;
                a(this.bUi, layoutParams);
            } else {
                this.bUg = (int) Math.ceil(list.size() / this.bUf);
            }
            this.aOE = list;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a(list.get(i2), layoutParams);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private boolean av(List<dt> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(dt dtVar, LinearLayout.LayoutParams layoutParams) {
        if (dtVar != null && layoutParams != null) {
            TextView ey = this.aJn.ey();
            ey.setText(dtVar.name);
            ey.setSelected(dtVar.isSelected);
            ey.setTag(dtVar);
            addView(ey, layoutParams);
        }
    }

    public void a(List<cy> list, cy cyVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    dt dtVar = new dt();
                    dtVar.bTp = list.get(i3).bTp;
                    dtVar.name = list.get(i3).name;
                    if (i == list.get(i3).bTp) {
                        dtVar.isSelected = true;
                    }
                    arrayList.add(dtVar);
                }
                i2 = i3 + 1;
            }
            dt dtVar2 = null;
            if (cyVar != null) {
                dtVar2 = new dt();
                dtVar2.bTp = cyVar.bTp;
                dtVar2.name = cyVar.name;
                if (i == cyVar.bTp) {
                    dtVar2.isSelected = true;
                }
            }
            a(arrayList, dtVar2);
        }
    }

    public void a(List<dt> list, dt dtVar) {
        this.bUi = dtVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bUe = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bUf = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bUh = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof dt) {
            acw();
            dt dtVar = (dt) view.getTag();
            a(dtVar, true);
            view.setSelected(true);
            if (this.bUh != null) {
                this.bUh.a(view, dtVar);
            }
        }
    }

    public void acw() {
        if (this.aOE != null && getChildCount() > 0) {
            if (this.bUi != null) {
                this.bUi.isSelected = false;
            }
            for (dt dtVar : this.aOE) {
                dtVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(dt dtVar, boolean z) {
        if (dtVar != null && this.aOE != null) {
            if (this.bUi != null && this.bUi.bTp == dtVar.bTp) {
                this.bUi.isSelected = z;
                return;
            }
            for (dt dtVar2 : this.aOE) {
                if (dtVar.bTp == dtVar2.bTp) {
                    dtVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wq() {
        com.baidu.tbadk.core.util.av.l(this, t.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.av.k(textView, t.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
