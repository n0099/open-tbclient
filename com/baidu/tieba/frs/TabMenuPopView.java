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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private b<TextView> aJE;
    private List<cx> aOf;
    private int bWm;
    private int bWn;
    private int bWo;
    private int bWp;
    private a bWq;
    private cx bWr;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, cx cxVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWm = 2;
        this.bWn = 2;
        this.bWo = 4;
        this.bWp = 5;
        setOrientation(1);
        this.mContext = context;
        this.bWn = com.baidu.adp.lib.util.k.e(context, r.e.ds20);
        this.aJE = new b<>(new cz(this), 17, 0);
        setOnHierarchyChangeListener(new da(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), aj((getChildAt(0).getMeasuredHeight() * this.bWp) + (this.bWn * (this.bWp - 1)) + (this.bWn * 2), i2));
        }
    }

    private int aj(int i, int i2) {
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
            if (this.bWo > 1) {
                this.bWm = (measuredWidth - (measuredWidth2 * this.bWo)) / (this.bWo - 1);
            }
            int[] iArr = new int[this.bWp + 1];
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
                if (this.bWr != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bWn * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bWn;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bWm + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bWm + i13;
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

    private void setData(List<cx> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60));
            if (this.bWr != null) {
                if (aw(list)) {
                    this.bWr.isSelected = false;
                } else {
                    this.bWr.isSelected = true;
                }
                this.bWp = ((int) Math.ceil(list.size() / this.bWo)) + 1;
                a(this.bWr, layoutParams);
            } else {
                this.bWp = (int) Math.ceil(list.size() / this.bWo);
            }
            this.aOf = list;
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

    private boolean aw(List<cx> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(cx cxVar, LinearLayout.LayoutParams layoutParams) {
        if (cxVar != null && layoutParams != null) {
            TextView ey = this.aJE.ey();
            ey.setText(cxVar.name);
            ey.setSelected(cxVar.isSelected);
            ey.setTag(cxVar);
            addView(ey, layoutParams);
        }
    }

    public void a(List<bw> list, bw bwVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    cx cxVar = new cx();
                    cxVar.bVo = list.get(i3).bVo;
                    cxVar.name = list.get(i3).name;
                    if (i == list.get(i3).bVo) {
                        cxVar.isSelected = true;
                    }
                    arrayList.add(cxVar);
                }
                i2 = i3 + 1;
            }
            cx cxVar2 = null;
            if (bwVar != null) {
                cxVar2 = new cx();
                cxVar2.bVo = bwVar.bVo;
                cxVar2.name = bwVar.name;
                if (i == bwVar.bVo) {
                    cxVar2.isSelected = true;
                }
            }
            a(arrayList, cxVar2);
        }
    }

    public void a(List<cx> list, cx cxVar) {
        this.bWr = cxVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bWn = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bWo = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bWq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof cx) {
            adQ();
            cx cxVar = (cx) view.getTag();
            a(cxVar, true);
            view.setSelected(true);
            if (this.bWq != null) {
                this.bWq.a(view, cxVar);
            }
        }
    }

    public void adQ() {
        if (this.aOf != null && getChildCount() > 0) {
            if (this.bWr != null) {
                this.bWr.isSelected = false;
            }
            for (cx cxVar : this.aOf) {
                cxVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(cx cxVar, boolean z) {
        if (cxVar != null && this.aOf != null) {
            if (this.bWr != null && this.bWr.bVo == cxVar.bVo) {
                this.bWr.isSelected = z;
                return;
            }
            for (cx cxVar2 : this.aOf) {
                if (cxVar.bVo == cxVar2.bVo) {
                    cxVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wM() {
        com.baidu.tbadk.core.util.at.l(this, r.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.at.k(textView, r.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
