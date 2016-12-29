package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private com.baidu.adp.lib.f.b<TextView> aIW;
    private List<cx> aNw;
    private a bCA;
    private cx bCB;
    private int bCw;
    private int bCx;
    private int bCy;
    private int bCz;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, cx cxVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCw = 2;
        this.bCx = 2;
        this.bCy = 4;
        this.bCz = 5;
        setOrientation(1);
        this.mContext = context;
        this.bCx = com.baidu.adp.lib.util.k.e(context, r.e.ds20);
        this.aIW = new com.baidu.adp.lib.f.b<>(new cz(this), 17, 0);
        setOnHierarchyChangeListener(new da(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ae((getChildAt(0).getMeasuredHeight() * this.bCz) + (this.bCx * (this.bCz - 1)) + (this.bCx * 2), i2));
        }
    }

    private int ae(int i, int i2) {
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
            if (this.bCy > 1) {
                this.bCw = (measuredWidth - (measuredWidth2 * this.bCy)) / (this.bCy - 1);
            }
            int[] iArr = new int[this.bCz + 1];
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
                if (this.bCB != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bCx * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bCx;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bCw + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bCw + i13;
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
            if (this.bCB != null) {
                if (ao(list)) {
                    this.bCB.isSelected = false;
                } else {
                    this.bCB.isSelected = true;
                }
                this.bCz = ((int) Math.ceil(list.size() / this.bCy)) + 1;
                a(this.bCB, layoutParams);
            } else {
                this.bCz = (int) Math.ceil(list.size() / this.bCy);
            }
            this.aNw = list;
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

    private boolean ao(List<cx> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(cx cxVar, LinearLayout.LayoutParams layoutParams) {
        if (cxVar != null && layoutParams != null) {
            TextView ey = this.aIW.ey();
            ey.setText(cxVar.name);
            ey.setSelected(cxVar.isSelected);
            ey.setTag(cxVar);
            addView(ey, layoutParams);
        }
    }

    public void a(List<bv> list, bv bvVar, int i) {
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
                    cxVar.bBw = list.get(i3).bBw;
                    cxVar.name = list.get(i3).name;
                    if (i == list.get(i3).bBw) {
                        cxVar.isSelected = true;
                    }
                    arrayList.add(cxVar);
                }
                i2 = i3 + 1;
            }
            cx cxVar2 = null;
            if (bvVar != null) {
                cxVar2 = new cx();
                cxVar2.bBw = bvVar.bBw;
                cxVar2.name = bvVar.name;
                if (i == bvVar.bBw) {
                    cxVar2.isSelected = true;
                }
            }
            a(arrayList, cxVar2);
        }
    }

    public void a(List<cx> list, cx cxVar) {
        this.bCB = cxVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bCx = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bCy = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bCA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof cx) {
            Yk();
            cx cxVar = (cx) view.getTag();
            a(cxVar, true);
            view.setSelected(true);
            if (this.bCA != null) {
                this.bCA.a(view, cxVar);
            }
        }
    }

    public void Yk() {
        if (this.aNw != null && getChildCount() > 0) {
            if (this.bCB != null) {
                this.bCB.isSelected = false;
            }
            for (cx cxVar : this.aNw) {
                cxVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(cx cxVar, boolean z) {
        if (cxVar != null && this.aNw != null) {
            if (this.bCB != null && this.bCB.bBw == cxVar.bBw) {
                this.bCB.isSelected = z;
                return;
            }
            for (cx cxVar2 : this.aNw) {
                if (cxVar.bBw == cxVar2.bBw) {
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

    public void wx() {
        com.baidu.tbadk.core.util.ar.l(this, r.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ar.k(textView, r.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
