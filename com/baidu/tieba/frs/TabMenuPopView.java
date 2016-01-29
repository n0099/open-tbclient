package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private com.baidu.adp.lib.f.b<TextView> aFP;
    private List<fm> aQh;
    private int bmG;
    private int bmH;
    private int bmI;
    private int bmJ;
    private a bmK;
    private fm bmL;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, fm fmVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmG = 2;
        this.bmH = 2;
        this.bmI = 4;
        this.bmJ = 5;
        setOrientation(1);
        this.mContext = context;
        this.bmH = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.aFP = new com.baidu.adp.lib.f.b<>(new fo(this), 17, 0);
        setOnHierarchyChangeListener(new fp(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), X((getChildAt(0).getMeasuredHeight() * this.bmJ) + (this.bmH * (this.bmJ - 1)), i2));
        }
    }

    private int X(int i, int i2) {
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
            if (this.bmI > 1) {
                this.bmG = (measuredWidth - (measuredWidth2 * this.bmI)) / (this.bmI - 1);
            }
            int[] iArr = new int[this.bmJ + 1];
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
                if (this.bmL != null && i12 == 0) {
                    i5 = 0;
                    i6 = this.bmH + i14;
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
                    i10 = iArr[i9] + i10 + this.bmH;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bmG + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bmG + i13;
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

    private void setData(List<fm> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds146), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60));
            if (this.bmL != null) {
                if (ae(list)) {
                    this.bmL.isSelected = false;
                } else {
                    this.bmL.isSelected = true;
                }
                this.bmJ = ((int) Math.ceil(list.size() / this.bmI)) + 1;
                a(this.bmL, layoutParams);
            } else {
                this.bmJ = (int) Math.ceil(list.size() / this.bmI);
            }
            this.aQh = list;
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

    private boolean ae(List<fm> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(fm fmVar, LinearLayout.LayoutParams layoutParams) {
        if (fmVar != null && layoutParams != null) {
            TextView hj = this.aFP.hj();
            hj.setText(fmVar.name);
            hj.setSelected(fmVar.isSelected);
            hj.setTag(fmVar);
            addView(hj, layoutParams);
        }
    }

    public void a(List<en> list, en enVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    fm fmVar = new fm();
                    fmVar.blu = list.get(i3).blu;
                    fmVar.name = list.get(i3).name;
                    if (i == list.get(i3).blu) {
                        fmVar.isSelected = true;
                    }
                    arrayList.add(fmVar);
                }
                i2 = i3 + 1;
            }
            fm fmVar2 = null;
            if (enVar != null) {
                fmVar2 = new fm();
                fmVar2.blu = enVar.blu;
                fmVar2.name = enVar.name;
                if (i == enVar.blu) {
                    fmVar2.isSelected = true;
                }
            }
            a(arrayList, fmVar2);
        }
    }

    public void a(List<fm> list, fm fmVar) {
        this.bmL = fmVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bmH = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bmI = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bmK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof fm) {
            QK();
            fm fmVar = (fm) view.getTag();
            a(fmVar, true);
            view.setSelected(true);
            if (this.bmK != null) {
                this.bmK.a(view, fmVar);
            }
        }
    }

    public void QK() {
        if (this.aQh != null && getChildCount() > 0) {
            if (this.bmL != null) {
                this.bmL.isSelected = false;
            }
            for (fm fmVar : this.aQh) {
                fmVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(fm fmVar, boolean z) {
        if (fmVar != null && this.aQh != null) {
            if (this.bmL != null && this.bmL.blu == fmVar.blu) {
                this.bmL.isSelected = z;
                return;
            }
            for (fm fmVar2 : this.aQh) {
                if (fmVar.blu == fmVar2.blu) {
                    fmVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void xf() {
        com.baidu.tbadk.core.util.ar.l(this, t.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ar.k(textView, t.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
