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
    private b<TextView> aIM;
    private List<dt> aMf;
    private int bTW;
    private int bTX;
    private int bTY;
    private int bTZ;
    private a bUa;
    private dt bUb;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, dt dtVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTW = 2;
        this.bTX = 2;
        this.bTY = 4;
        this.bTZ = 5;
        setOrientation(1);
        this.mContext = context;
        this.bTX = com.baidu.adp.lib.util.k.e(context, r.e.ds20);
        this.aIM = new b<>(new dv(this), 17, 0);
        setOnHierarchyChangeListener(new dw(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ai((getChildAt(0).getMeasuredHeight() * this.bTZ) + (this.bTX * (this.bTZ - 1)) + (this.bTX * 2), i2));
        }
    }

    private int ai(int i, int i2) {
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
            if (this.bTY > 1) {
                this.bTW = (measuredWidth - (measuredWidth2 * this.bTY)) / (this.bTY - 1);
            }
            int[] iArr = new int[this.bTZ + 1];
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
                if (this.bUb != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bTX * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bTX;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bTW + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bTW + i13;
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60));
            if (this.bUb != null) {
                if (av(list)) {
                    this.bUb.isSelected = false;
                } else {
                    this.bUb.isSelected = true;
                }
                this.bTZ = ((int) Math.ceil(list.size() / this.bTY)) + 1;
                a(this.bUb, layoutParams);
            } else {
                this.bTZ = (int) Math.ceil(list.size() / this.bTY);
            }
            this.aMf = list;
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
            TextView ey = this.aIM.ey();
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
                    dtVar.bTi = list.get(i3).bTi;
                    dtVar.name = list.get(i3).name;
                    if (i == list.get(i3).bTi) {
                        dtVar.isSelected = true;
                    }
                    arrayList.add(dtVar);
                }
                i2 = i3 + 1;
            }
            dt dtVar2 = null;
            if (cyVar != null) {
                dtVar2 = new dt();
                dtVar2.bTi = cyVar.bTi;
                dtVar2.name = cyVar.name;
                if (i == cyVar.bTi) {
                    dtVar2.isSelected = true;
                }
            }
            a(arrayList, dtVar2);
        }
    }

    public void a(List<dt> list, dt dtVar) {
        this.bUb = dtVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bTX = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bTY = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bUa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof dt) {
            acI();
            dt dtVar = (dt) view.getTag();
            a(dtVar, true);
            view.setSelected(true);
            if (this.bUa != null) {
                this.bUa.a(view, dtVar);
            }
        }
    }

    public void acI() {
        if (this.aMf != null && getChildCount() > 0) {
            if (this.bUb != null) {
                this.bUb.isSelected = false;
            }
            for (dt dtVar : this.aMf) {
                dtVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(dt dtVar, boolean z) {
        if (dtVar != null && this.aMf != null) {
            if (this.bUb != null && this.bUb.bTi == dtVar.bTi) {
                this.bUb.isSelected = z;
                return;
            }
            for (dt dtVar2 : this.aMf) {
                if (dtVar.bTi == dtVar2.bTi) {
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

    public void wH() {
        com.baidu.tbadk.core.util.av.l(this, r.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.av.k(textView, r.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.av.c(textView, r.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
