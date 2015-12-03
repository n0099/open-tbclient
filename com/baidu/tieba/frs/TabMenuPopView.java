package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private com.baidu.adp.lib.f.b<TextView> aDy;
    private List<fc> aMt;
    private int bfS;
    private int bfT;
    private int bfU;
    private int bfV;
    private a bfW;
    private fc bfX;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, fc fcVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfS = 2;
        this.bfT = 2;
        this.bfU = 4;
        this.bfV = 5;
        setOrientation(1);
        this.mContext = context;
        this.bfT = com.baidu.adp.lib.util.k.d(context, n.d.ds32);
        this.aDy = new com.baidu.adp.lib.f.b<>(new fe(this), 17, 0);
        setOnHierarchyChangeListener(new ff(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), X((getChildAt(0).getMeasuredHeight() * this.bfV) + (this.bfT * (this.bfV - 1)), i2));
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
            if (this.bfU > 1) {
                this.bfS = (measuredWidth - (measuredWidth2 * this.bfU)) / (this.bfU - 1);
            }
            int[] iArr = new int[this.bfV + 1];
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
                if (this.bfX != null && i12 == 0) {
                    i5 = 0;
                    i6 = this.bfT + i14;
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
                    i10 = iArr[i9] + i10 + this.bfT;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bfS + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bfS + i13;
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

    private void setData(List<fc> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds146), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds60));
            if (this.bfX != null) {
                if (ag(list)) {
                    this.bfX.isSelected = false;
                } else {
                    this.bfX.isSelected = true;
                }
                this.bfV = ((int) Math.ceil(list.size() / this.bfU)) + 1;
                a(this.bfX, layoutParams);
            } else {
                this.bfV = (int) Math.ceil(list.size() / this.bfU);
            }
            this.aMt = list;
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

    private boolean ag(List<fc> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(fc fcVar, LinearLayout.LayoutParams layoutParams) {
        if (fcVar != null && layoutParams != null) {
            TextView hb = this.aDy.hb();
            hb.setText(fcVar.name);
            hb.setSelected(fcVar.isSelected);
            hb.setTag(fcVar);
            addView(hb, layoutParams);
        }
    }

    public void a(List<ec> list, ec ecVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    fc fcVar = new fc();
                    fcVar.beF = list.get(i3).beF;
                    fcVar.name = list.get(i3).name;
                    if (i == list.get(i3).beF) {
                        fcVar.isSelected = true;
                    }
                    arrayList.add(fcVar);
                }
                i2 = i3 + 1;
            }
            fc fcVar2 = null;
            if (ecVar != null) {
                fcVar2 = new fc();
                fcVar2.beF = ecVar.beF;
                fcVar2.name = ecVar.name;
                if (i == ecVar.beF) {
                    fcVar2.isSelected = true;
                }
            }
            a(arrayList, fcVar2);
        }
    }

    public void a(List<fc> list, fc fcVar) {
        this.bfX = fcVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bfT = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bfU = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bfW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof fc) {
            Oq();
            fc fcVar = (fc) view.getTag();
            a(fcVar, true);
            view.setSelected(true);
            if (this.bfW != null) {
                this.bfW.a(view, fcVar);
            }
        }
    }

    public void Oq() {
        if (this.aMt != null && getChildCount() > 0) {
            if (this.bfX != null) {
                this.bfX.isSelected = false;
            }
            for (fc fcVar : this.aMt) {
                fcVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(fc fcVar, boolean z) {
        if (fcVar != null && this.aMt != null) {
            if (this.bfX != null && this.bfX.beF == fcVar.beF) {
                this.bfX.isSelected = z;
                return;
            }
            for (fc fcVar2 : this.aMt) {
                if (fcVar.beF == fcVar2.beF) {
                    fcVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wh() {
        com.baidu.tbadk.core.util.as.j(this, n.c.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.as.i((View) textView, n.e.bg_tab_meun);
                    com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
