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
    private b<TextView> aGb;
    private List<dy> aKa;
    private int bJc;
    private int bJd;
    private int bJe;
    private int bJf;
    private a bJg;
    private dy bJh;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, dy dyVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJc = 2;
        this.bJd = 2;
        this.bJe = 4;
        this.bJf = 5;
        setOrientation(1);
        this.mContext = context;
        this.bJd = com.baidu.adp.lib.util.k.c(context, u.e.ds20);
        this.aGb = new b<>(new ea(this), 17, 0);
        setOnHierarchyChangeListener(new eb(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ac((getChildAt(0).getMeasuredHeight() * this.bJf) + (this.bJd * (this.bJf - 1)) + (this.bJd * 2), i2));
        }
    }

    private int ac(int i, int i2) {
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
            if (this.bJe > 1) {
                this.bJc = (measuredWidth - (measuredWidth2 * this.bJe)) / (this.bJe - 1);
            }
            int[] iArr = new int[this.bJf + 1];
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
                if (this.bJh != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bJd * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bJd;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bJc + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bJc + i13;
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds150), TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds60));
            if (this.bJh != null) {
                if (at(list)) {
                    this.bJh.isSelected = false;
                } else {
                    this.bJh.isSelected = true;
                }
                this.bJf = ((int) Math.ceil(list.size() / this.bJe)) + 1;
                a(this.bJh, layoutParams);
            } else {
                this.bJf = (int) Math.ceil(list.size() / this.bJe);
            }
            this.aKa = list;
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

    private boolean at(List<dy> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(dy dyVar, LinearLayout.LayoutParams layoutParams) {
        if (dyVar != null && layoutParams != null) {
            TextView dD = this.aGb.dD();
            dD.setText(dyVar.name);
            dD.setSelected(dyVar.isSelected);
            dD.setTag(dyVar);
            addView(dD, layoutParams);
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
                    dyVar.bIj = list.get(i3).bIj;
                    dyVar.name = list.get(i3).name;
                    if (i == list.get(i3).bIj) {
                        dyVar.isSelected = true;
                    }
                    arrayList.add(dyVar);
                }
                i2 = i3 + 1;
            }
            dy dyVar2 = null;
            if (dcVar != null) {
                dyVar2 = new dy();
                dyVar2.bIj = dcVar.bIj;
                dyVar2.name = dcVar.name;
                if (i == dcVar.bIj) {
                    dyVar2.isSelected = true;
                }
            }
            a(arrayList, dyVar2);
        }
    }

    public void a(List<dy> list, dy dyVar) {
        this.bJh = dyVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bJd = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bJe = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bJg = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof dy) {
            XL();
            dy dyVar = (dy) view.getTag();
            a(dyVar, true);
            view.setSelected(true);
            if (this.bJg != null) {
                this.bJg.a(view, dyVar);
            }
        }
    }

    public void XL() {
        if (this.aKa != null && getChildCount() > 0) {
            if (this.bJh != null) {
                this.bJh.isSelected = false;
            }
            for (dy dyVar : this.aKa) {
                dyVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(dy dyVar, boolean z) {
        if (dyVar != null && this.aKa != null) {
            if (this.bJh != null && this.bJh.bIj == dyVar.bIj) {
                this.bJh.isSelected = z;
                return;
            }
            for (dy dyVar2 : this.aKa) {
                if (dyVar.bIj == dyVar2.bIj) {
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
