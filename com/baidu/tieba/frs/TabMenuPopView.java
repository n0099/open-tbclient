package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private b<TextView> aNI;
    private int bXh;
    private int bXi;
    private int bXj;
    private int bXk;
    private a bXl;
    private cn bXm;
    private Context mContext;
    private List<cn> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, cn cnVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXh = 2;
        this.bXi = 2;
        this.bXj = 4;
        this.bXk = 5;
        setOrientation(1);
        this.mContext = context;
        this.bXi = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.aNI = new b<>(new cp(this), 17, 0);
        setOnHierarchyChangeListener(new cq(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ak((getChildAt(0).getMeasuredHeight() * this.bXk) + (this.bXi * (this.bXk - 1)) + (this.bXi * 2), i2));
        }
    }

    private int ak(int i, int i2) {
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
            if (this.bXj > 1) {
                this.bXh = (measuredWidth - (measuredWidth2 * this.bXj)) / (this.bXj - 1);
            }
            int[] iArr = new int[this.bXk + 1];
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
                if (this.bXm != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bXi * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bXi;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bXh + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bXh + i13;
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

    private void setData(List<cn> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60));
            if (this.bXm != null) {
                if (am(list)) {
                    this.bXm.isSelected = false;
                } else {
                    this.bXm.isSelected = true;
                }
                this.bXk = ((int) Math.ceil(list.size() / this.bXj)) + 1;
                a(this.bXm, layoutParams);
            } else {
                this.bXk = (int) Math.ceil(list.size() / this.bXj);
            }
            this.mDataList = list;
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

    private boolean am(List<cn> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(cn cnVar, LinearLayout.LayoutParams layoutParams) {
        if (cnVar != null && layoutParams != null) {
            TextView fK = this.aNI.fK();
            fK.setText(cnVar.name);
            fK.setSelected(cnVar.isSelected);
            fK.setTag(cnVar);
            addView(fK, layoutParams);
        }
    }

    public void a(List<bp> list, bp bpVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    cn cnVar = new cn();
                    cnVar.bWI = list.get(i3).bWI;
                    cnVar.name = list.get(i3).name;
                    if (i == list.get(i3).bWI) {
                        cnVar.isSelected = true;
                    }
                    arrayList.add(cnVar);
                }
                i2 = i3 + 1;
            }
            cn cnVar2 = null;
            if (bpVar != null) {
                cnVar2 = new cn();
                cnVar2.bWI = bpVar.bWI;
                cnVar2.name = bpVar.name;
                if (i == bpVar.bWI) {
                    cnVar2.isSelected = true;
                }
            }
            a(arrayList, cnVar2);
        }
    }

    public void a(List<cn> list, cn cnVar) {
        this.bXm = cnVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bXi = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bXj = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bXl = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof cn) {
            abi();
            cn cnVar = (cn) view.getTag();
            a(cnVar, true);
            view.setSelected(true);
            if (this.bXl != null) {
                this.bXl.a(view, cnVar);
            }
        }
    }

    public void abi() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.bXm != null) {
                this.bXm.isSelected = false;
            }
            for (cn cnVar : this.mDataList) {
                cnVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(cn cnVar, boolean z) {
        if (cnVar != null && this.mDataList != null) {
            if (this.bXm != null && this.bXm.bWI == cnVar.bWI) {
                this.bXm.isSelected = z;
                return;
            }
            for (cn cnVar2 : this.mDataList) {
                if (cnVar.bWI == cnVar2.bWI) {
                    cnVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void ws() {
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.aq.j(textView, w.g.bg_tab_meun);
                    com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
