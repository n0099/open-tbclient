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
    private b<TextView> aNL;
    private List<cm> aSY;
    private int bRr;
    private int bRs;
    private int bRt;
    private int bRu;
    private a bRv;
    private cm bRw;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, cm cmVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRr = 2;
        this.bRs = 2;
        this.bRt = 4;
        this.bRu = 5;
        setOrientation(1);
        this.mContext = context;
        this.bRs = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.aNL = new b<>(new co(this), 17, 0);
        setOnHierarchyChangeListener(new cp(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ak((getChildAt(0).getMeasuredHeight() * this.bRu) + (this.bRs * (this.bRu - 1)) + (this.bRs * 2), i2));
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
            if (this.bRt > 1) {
                this.bRr = (measuredWidth - (measuredWidth2 * this.bRt)) / (this.bRt - 1);
            }
            int[] iArr = new int[this.bRu + 1];
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
                if (this.bRw != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bRs * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bRs;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bRr + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bRr + i13;
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

    private void setData(List<cm> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60));
            if (this.bRw != null) {
                if (am(list)) {
                    this.bRw.isSelected = false;
                } else {
                    this.bRw.isSelected = true;
                }
                this.bRu = ((int) Math.ceil(list.size() / this.bRt)) + 1;
                a(this.bRw, layoutParams);
            } else {
                this.bRu = (int) Math.ceil(list.size() / this.bRt);
            }
            this.aSY = list;
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

    private boolean am(List<cm> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(cm cmVar, LinearLayout.LayoutParams layoutParams) {
        if (cmVar != null && layoutParams != null) {
            TextView fK = this.aNL.fK();
            fK.setText(cmVar.name);
            fK.setSelected(cmVar.isSelected);
            fK.setTag(cmVar);
            addView(fK, layoutParams);
        }
    }

    public void a(List<bo> list, bo boVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    cm cmVar = new cm();
                    cmVar.bQR = list.get(i3).bQR;
                    cmVar.name = list.get(i3).name;
                    if (i == list.get(i3).bQR) {
                        cmVar.isSelected = true;
                    }
                    arrayList.add(cmVar);
                }
                i2 = i3 + 1;
            }
            cm cmVar2 = null;
            if (boVar != null) {
                cmVar2 = new cm();
                cmVar2.bQR = boVar.bQR;
                cmVar2.name = boVar.name;
                if (i == boVar.bQR) {
                    cmVar2.isSelected = true;
                }
            }
            a(arrayList, cmVar2);
        }
    }

    public void a(List<cm> list, cm cmVar) {
        this.bRw = cmVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bRs = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bRt = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bRv = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof cm) {
            aag();
            cm cmVar = (cm) view.getTag();
            a(cmVar, true);
            view.setSelected(true);
            if (this.bRv != null) {
                this.bRv.a(view, cmVar);
            }
        }
    }

    public void aag() {
        if (this.aSY != null && getChildCount() > 0) {
            if (this.bRw != null) {
                this.bRw.isSelected = false;
            }
            for (cm cmVar : this.aSY) {
                cmVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(cm cmVar, boolean z) {
        if (cmVar != null && this.aSY != null) {
            if (this.bRw != null && this.bRw.bQR == cmVar.bQR) {
                this.bRw.isSelected = z;
                return;
            }
            for (cm cmVar2 : this.aSY) {
                if (cmVar.bQR == cmVar2.bQR) {
                    cmVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void ww() {
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
