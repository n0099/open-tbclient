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
    private com.baidu.adp.lib.f.b<TextView> aII;
    private List<fu> aTc;
    private int brR;
    private int brS;
    private int brT;
    private int brU;
    private a brV;
    private fu brW;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, fu fuVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brR = 2;
        this.brS = 2;
        this.brT = 4;
        this.brU = 5;
        setOrientation(1);
        this.mContext = context;
        this.brS = com.baidu.adp.lib.util.k.c(context, t.e.ds32);
        this.aII = new com.baidu.adp.lib.f.b<>(new fw(this), 17, 0);
        setOnHierarchyChangeListener(new fx(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), V((getChildAt(0).getMeasuredHeight() * this.brU) + (this.brS * (this.brU - 1)), i2));
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
            if (this.brT > 1) {
                this.brR = (measuredWidth - (measuredWidth2 * this.brT)) / (this.brT - 1);
            }
            int[] iArr = new int[this.brU + 1];
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
                if (this.brW != null && i12 == 0) {
                    i5 = 0;
                    i6 = this.brS + i14;
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
                    i10 = iArr[i9] + i10 + this.brS;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.brR + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.brR + i13;
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

    private void setData(List<fu> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds146), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60));
            if (this.brW != null) {
                if (ai(list)) {
                    this.brW.isSelected = false;
                } else {
                    this.brW.isSelected = true;
                }
                this.brU = ((int) Math.ceil(list.size() / this.brT)) + 1;
                a(this.brW, layoutParams);
            } else {
                this.brU = (int) Math.ceil(list.size() / this.brT);
            }
            this.aTc = list;
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

    private boolean ai(List<fu> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(fu fuVar, LinearLayout.LayoutParams layoutParams) {
        if (fuVar != null && layoutParams != null) {
            TextView hp = this.aII.hp();
            hp.setText(fuVar.name);
            hp.setSelected(fuVar.isSelected);
            hp.setTag(fuVar);
            addView(hp, layoutParams);
        }
    }

    public void a(List<ev> list, ev evVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    fu fuVar = new fu();
                    fuVar.bqM = list.get(i3).bqM;
                    fuVar.name = list.get(i3).name;
                    if (i == list.get(i3).bqM) {
                        fuVar.isSelected = true;
                    }
                    arrayList.add(fuVar);
                }
                i2 = i3 + 1;
            }
            fu fuVar2 = null;
            if (evVar != null) {
                fuVar2 = new fu();
                fuVar2.bqM = evVar.bqM;
                fuVar2.name = evVar.name;
                if (i == evVar.bqM) {
                    fuVar2.isSelected = true;
                }
            }
            a(arrayList, fuVar2);
        }
    }

    public void a(List<fu> list, fu fuVar) {
        this.brW = fuVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.brS = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.brT = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.brV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof fu) {
            SC();
            fu fuVar = (fu) view.getTag();
            a(fuVar, true);
            view.setSelected(true);
            if (this.brV != null) {
                this.brV.a(view, fuVar);
            }
        }
    }

    public void SC() {
        if (this.aTc != null && getChildCount() > 0) {
            if (this.brW != null) {
                this.brW.isSelected = false;
            }
            for (fu fuVar : this.aTc) {
                fuVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(fu fuVar, boolean z) {
        if (fuVar != null && this.aTc != null) {
            if (this.brW != null && this.brW.bqM == fuVar.bqM) {
                this.brW.isSelected = z;
                return;
            }
            for (fu fuVar2 : this.aTc) {
                if (fuVar.bqM == fuVar2.bqM) {
                    fuVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void xy() {
        com.baidu.tbadk.core.util.at.l(this, t.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.at.k(textView, t.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
