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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private b<TextView> aEJ;
    private List<ft> aZH;
    private int bns;
    private int bnt;
    private int bnu;
    private int bnv;
    private a bnw;
    private ft bnx;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, ft ftVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bns = 2;
        this.bnt = 2;
        this.bnu = 4;
        this.bnv = 5;
        setOrientation(1);
        this.mContext = context;
        this.bnt = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.aEJ = new b<>(new fv(this), 17, 0);
        setOnHierarchyChangeListener(new fw(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), V((getChildAt(0).getMeasuredHeight() * this.bnv) + (this.bnt * (this.bnv - 1)), i2));
        }
    }

    private int V(int i, int i2) {
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
            if (this.bnu > 1) {
                this.bns = (measuredWidth - (measuredWidth2 * this.bnu)) / (this.bnu - 1);
            }
            int[] iArr = new int[this.bnv + 1];
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
                if (this.bnx != null && i12 == 0) {
                    i5 = 0;
                    i6 = this.bnt + i14;
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
                    i10 = iArr[i9] + i10 + this.bnt;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bns + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bns + i13;
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

    private void setData(List<ft> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds146), TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60));
            if (this.bnx != null) {
                if (ae(list)) {
                    this.bnx.isSelected = false;
                } else {
                    this.bnx.isSelected = true;
                }
                this.bnv = ((int) Math.ceil(list.size() / this.bnu)) + 1;
                a(this.bnx, layoutParams);
            } else {
                this.bnv = (int) Math.ceil(list.size() / this.bnu);
            }
            this.aZH = list;
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

    private boolean ae(List<ft> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(ft ftVar, LinearLayout.LayoutParams layoutParams) {
        if (ftVar != null && layoutParams != null) {
            TextView dD = this.aEJ.dD();
            dD.setText(ftVar.name);
            dD.setSelected(ftVar.isSelected);
            dD.setTag(ftVar);
            addView(dD, layoutParams);
        }
    }

    public void a(List<em> list, em emVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    ft ftVar = new ft();
                    ftVar.blZ = list.get(i3).blZ;
                    ftVar.name = list.get(i3).name;
                    if (i == list.get(i3).blZ) {
                        ftVar.isSelected = true;
                    }
                    arrayList.add(ftVar);
                }
                i2 = i3 + 1;
            }
            ft ftVar2 = null;
            if (emVar != null) {
                ftVar2 = new ft();
                ftVar2.blZ = emVar.blZ;
                ftVar2.name = emVar.name;
                if (i == emVar.blZ) {
                    ftVar2.isSelected = true;
                }
            }
            a(arrayList, ftVar2);
        }
    }

    public void a(List<ft> list, ft ftVar) {
        this.bnx = ftVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bnt = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bnu = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bnw = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ft) {
            Sa();
            ft ftVar = (ft) view.getTag();
            a(ftVar, true);
            view.setSelected(true);
            if (this.bnw != null) {
                this.bnw.a(view, ftVar);
            }
        }
    }

    public void Sa() {
        if (this.aZH != null && getChildCount() > 0) {
            if (this.bnx != null) {
                this.bnx.isSelected = false;
            }
            for (ft ftVar : this.aZH) {
                ftVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(ft ftVar, boolean z) {
        if (ftVar != null && this.aZH != null) {
            if (this.bnx != null && this.bnx.blZ == ftVar.blZ) {
                this.bnx.isSelected = z;
                return;
            }
            for (ft ftVar2 : this.aZH) {
                if (ftVar.blZ == ftVar2.blZ) {
                    ftVar.isSelected = z;
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
        com.baidu.tbadk.core.util.at.l(this, t.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.at.k(textView, t.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
