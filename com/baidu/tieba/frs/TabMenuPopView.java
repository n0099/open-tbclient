package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private com.baidu.adp.lib.e.b<TextView> aAM;
    private List<ek> aNQ;
    private int aZP;
    private int aZQ;
    private int aZR;
    private int aZS;
    private a aZT;
    private ek aZU;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, ek ekVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZP = 2;
        this.aZQ = 2;
        this.aZR = 4;
        this.aZS = 5;
        setOrientation(1);
        this.mContext = context;
        this.aZQ = com.baidu.adp.lib.util.k.d(context, i.d.ds32);
        this.aAM = new com.baidu.adp.lib.e.b<>(new em(this), 17, 0);
        setOnHierarchyChangeListener(new en(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), W((getChildAt(0).getMeasuredHeight() * this.aZS) + (this.aZQ * (this.aZS - 1)), i2));
        }
    }

    private int W(int i, int i2) {
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
            if (this.aZR > 1) {
                this.aZP = (measuredWidth - (measuredWidth2 * this.aZR)) / (this.aZR - 1);
            }
            int[] iArr = new int[this.aZS + 1];
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
                if (this.aZU != null && i12 == 0) {
                    i5 = 0;
                    i6 = this.aZQ + i14;
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
                    i10 = iArr[i9] + i10 + this.aZQ;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.aZP + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.aZP + i13;
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

    private void setData(List<ek> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds146), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60));
            if (this.aZU != null) {
                if (aa(list)) {
                    this.aZU.isSelected = false;
                } else {
                    this.aZU.isSelected = true;
                }
                this.aZS = ((int) Math.ceil(list.size() / this.aZR)) + 1;
                a(this.aZU, layoutParams);
            } else {
                this.aZS = (int) Math.ceil(list.size() / this.aZR);
            }
            this.aNQ = list;
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

    private boolean aa(List<ek> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(ek ekVar, LinearLayout.LayoutParams layoutParams) {
        if (ekVar != null && layoutParams != null) {
            TextView gZ = this.aAM.gZ();
            gZ.setText(ekVar.name);
            gZ.setSelected(ekVar.isSelected);
            gZ.setTag(ekVar);
            addView(gZ, layoutParams);
        }
    }

    public void a(List<dm> list, dm dmVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    ek ekVar = new ek();
                    ekVar.aYG = list.get(i3).aYG;
                    ekVar.name = list.get(i3).name;
                    if (i == list.get(i3).aYG) {
                        ekVar.isSelected = true;
                    }
                    arrayList.add(ekVar);
                }
                i2 = i3 + 1;
            }
            ek ekVar2 = null;
            if (dmVar != null) {
                ekVar2 = new ek();
                ekVar2.aYG = dmVar.aYG;
                ekVar2.name = dmVar.name;
                if (i == dmVar.aYG) {
                    ekVar2.isSelected = true;
                }
            }
            a(arrayList, ekVar2);
        }
    }

    public void a(List<ek> list, ek ekVar) {
        this.aZU = ekVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.aZQ = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.aZR = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.aZT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ek) {
            MR();
            ek ekVar = (ek) view.getTag();
            a(ekVar, true);
            view.setSelected(true);
            if (this.aZT != null) {
                this.aZT.a(view, ekVar);
            }
        }
    }

    public void MR() {
        if (this.aNQ != null && getChildCount() > 0) {
            if (this.aZU != null) {
                this.aZU.isSelected = false;
            }
            for (ek ekVar : this.aNQ) {
                ekVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(ek ekVar, boolean z) {
        if (ekVar != null && this.aNQ != null) {
            if (this.aZU != null && this.aZU.aYG == ekVar.aYG) {
                this.aZU.isSelected = z;
                return;
            }
            for (ek ekVar2 : this.aNQ) {
                if (ekVar.aYG == ekVar2.aYG) {
                    ekVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void vB() {
        com.baidu.tbadk.core.util.an.j(this, i.c.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.an.i((View) textView, i.e.bg_tab_meun);
                    com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
