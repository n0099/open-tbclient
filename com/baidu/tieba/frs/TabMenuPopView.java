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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private b<TextView> aFk;
    private List<dy> aJj;
    private int bHG;
    private int bHH;
    private int bHI;
    private int bHJ;
    private a bHK;
    private dy bHL;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, dy dyVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHG = 2;
        this.bHH = 2;
        this.bHI = 4;
        this.bHJ = 5;
        setOrientation(1);
        this.mContext = context;
        this.bHH = com.baidu.adp.lib.util.k.c(context, u.e.ds20);
        this.aFk = new b<>(new ea(this), 17, 0);
        setOnHierarchyChangeListener(new eb(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ab((getChildAt(0).getMeasuredHeight() * this.bHJ) + (this.bHH * (this.bHJ - 1)) + (this.bHH * 2), i2));
        }
    }

    private int ab(int i, int i2) {
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
            if (this.bHI > 1) {
                this.bHG = (measuredWidth - (measuredWidth2 * this.bHI)) / (this.bHI - 1);
            }
            int[] iArr = new int[this.bHJ + 1];
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
                if (this.bHL != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bHH * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bHH;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bHG + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bHG + i13;
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

    private void setData(List<dy> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds60));
            if (this.bHL != null) {
                if (ap(list)) {
                    this.bHL.isSelected = false;
                } else {
                    this.bHL.isSelected = true;
                }
                this.bHJ = ((int) Math.ceil(list.size() / this.bHI)) + 1;
                a(this.bHL, layoutParams);
            } else {
                this.bHJ = (int) Math.ceil(list.size() / this.bHI);
            }
            this.aJj = list;
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

    private boolean ap(List<dy> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(dy dyVar, LinearLayout.LayoutParams layoutParams) {
        if (dyVar != null && layoutParams != null) {
            TextView dE = this.aFk.dE();
            dE.setText(dyVar.name);
            dE.setSelected(dyVar.isSelected);
            dE.setTag(dyVar);
            addView(dE, layoutParams);
        }
    }

    public void a(List<dc> list, dc dcVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    dy dyVar = new dy();
                    dyVar.bGN = list.get(i3).bGN;
                    dyVar.name = list.get(i3).name;
                    if (i == list.get(i3).bGN) {
                        dyVar.isSelected = true;
                    }
                    arrayList.add(dyVar);
                }
                i2 = i3 + 1;
            }
            dy dyVar2 = null;
            if (dcVar != null) {
                dyVar2 = new dy();
                dyVar2.bGN = dcVar.bGN;
                dyVar2.name = dcVar.name;
                if (i == dcVar.bGN) {
                    dyVar2.isSelected = true;
                }
            }
            a(arrayList, dyVar2);
        }
    }

    public void a(List<dy> list, dy dyVar) {
        this.bHL = dyVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bHH = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bHI = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bHK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof dy) {
            Xt();
            dy dyVar = (dy) view.getTag();
            a(dyVar, true);
            view.setSelected(true);
            if (this.bHK != null) {
                this.bHK.a(view, dyVar);
            }
        }
    }

    public void Xt() {
        if (this.aJj != null && getChildCount() > 0) {
            if (this.bHL != null) {
                this.bHL.isSelected = false;
            }
            for (dy dyVar : this.aJj) {
                dyVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(dy dyVar, boolean z) {
        if (dyVar != null && this.aJj != null) {
            if (this.bHL != null && this.bHL.bGN == dyVar.bGN) {
                this.bHL.isSelected = z;
                return;
            }
            for (dy dyVar2 : this.aJj) {
                if (dyVar.bGN == dyVar2.bGN) {
                    dyVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void vm() {
        com.baidu.tbadk.core.util.av.l(this, u.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.av.k(textView, u.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
