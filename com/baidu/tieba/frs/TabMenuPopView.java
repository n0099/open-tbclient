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
    private b<TextView> aOY;
    private int cfq;
    private int cfr;
    private int cfs;
    private int cft;
    private a cfu;
    private co cfv;
    private Context mContext;
    private List<co> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, co coVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfq = 2;
        this.cfr = 2;
        this.cfs = 4;
        this.cft = 5;
        setOrientation(1);
        this.mContext = context;
        this.cfr = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.aOY = new b<>(new cq(this), 17, 0);
        setOnHierarchyChangeListener(new cr(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), aq((getChildAt(0).getMeasuredHeight() * this.cft) + (this.cfr * (this.cft - 1)) + (this.cfr * 2), i2));
        }
    }

    private int aq(int i, int i2) {
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
            if (this.cfs > 1) {
                this.cfq = (measuredWidth - (measuredWidth2 * this.cfs)) / (this.cfs - 1);
            }
            int[] iArr = new int[this.cft + 1];
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
                if (this.cfv != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.cfr * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.cfr;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.cfq + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.cfq + i13;
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

    private void setData(List<co> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60));
            if (this.cfv != null) {
                if (av(list)) {
                    this.cfv.isSelected = false;
                } else {
                    this.cfv.isSelected = true;
                }
                this.cft = ((int) Math.ceil(list.size() / this.cfs)) + 1;
                a(this.cfv, layoutParams);
            } else {
                this.cft = (int) Math.ceil(list.size() / this.cfs);
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

    private boolean av(List<co> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(co coVar, LinearLayout.LayoutParams layoutParams) {
        if (coVar != null && layoutParams != null) {
            TextView fJ = this.aOY.fJ();
            fJ.setText(coVar.name);
            fJ.setSelected(coVar.isSelected);
            fJ.setTag(coVar);
            addView(fJ, layoutParams);
        }
    }

    public void a(List<bq> list, bq bqVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    co coVar = new co();
                    coVar.ceQ = list.get(i3).ceQ;
                    coVar.name = list.get(i3).name;
                    if (i == list.get(i3).ceQ) {
                        coVar.isSelected = true;
                    }
                    arrayList.add(coVar);
                }
                i2 = i3 + 1;
            }
            co coVar2 = null;
            if (bqVar != null) {
                coVar2 = new co();
                coVar2.ceQ = bqVar.ceQ;
                coVar2.name = bqVar.name;
                if (i == bqVar.ceQ) {
                    coVar2.isSelected = true;
                }
            }
            a(arrayList, coVar2);
        }
    }

    public void a(List<co> list, co coVar) {
        this.cfv = coVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.cfr = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.cfs = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.cfu = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof co) {
            aeZ();
            co coVar = (co) view.getTag();
            a(coVar, true);
            view.setSelected(true);
            if (this.cfu != null) {
                this.cfu.a(view, coVar);
            }
        }
    }

    public void aeZ() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.cfv != null) {
                this.cfv.isSelected = false;
            }
            for (co coVar : this.mDataList) {
                coVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(co coVar, boolean z) {
        if (coVar != null && this.mDataList != null) {
            if (this.cfv != null && this.cfv.ceQ == coVar.ceQ) {
                this.cfv.isSelected = z;
                return;
            }
            for (co coVar2 : this.mDataList) {
                if (coVar.ceQ == coVar2.ceQ) {
                    coVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wK() {
        com.baidu.tbadk.core.util.as.k(this, w.e.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.as.j(textView, w.g.bg_tab_meun);
                    com.baidu.tbadk.core.util.as.c(textView, w.e.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
