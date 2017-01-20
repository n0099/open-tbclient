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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private b<TextView> aHD;
    private List<ct> aMy;
    private int bJM;
    private int bJN;
    private int bJO;
    private int bJP;
    private a bJQ;
    private ct bJR;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, ct ctVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJM = 2;
        this.bJN = 2;
        this.bJO = 4;
        this.bJP = 5;
        setOrientation(1);
        this.mContext = context;
        this.bJN = com.baidu.adp.lib.util.k.e(context, r.f.ds20);
        this.aHD = new b<>(new cv(this), 17, 0);
        setOnHierarchyChangeListener(new cw(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), ad((getChildAt(0).getMeasuredHeight() * this.bJP) + (this.bJN * (this.bJP - 1)) + (this.bJN * 2), i2));
        }
    }

    private int ad(int i, int i2) {
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
            if (this.bJO > 1) {
                this.bJM = (measuredWidth - (measuredWidth2 * this.bJO)) / (this.bJO - 1);
            }
            int[] iArr = new int[this.bJP + 1];
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
                if (this.bJR != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bJN * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bJN;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bJM + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bJM + i13;
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

    private void setData(List<ct> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds60));
            if (this.bJR != null) {
                if (as(list)) {
                    this.bJR.isSelected = false;
                } else {
                    this.bJR.isSelected = true;
                }
                this.bJP = ((int) Math.ceil(list.size() / this.bJO)) + 1;
                a(this.bJR, layoutParams);
            } else {
                this.bJP = (int) Math.ceil(list.size() / this.bJO);
            }
            this.aMy = list;
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

    private boolean as(List<ct> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(ct ctVar, LinearLayout.LayoutParams layoutParams) {
        if (ctVar != null && layoutParams != null) {
            TextView ew = this.aHD.ew();
            ew.setText(ctVar.name);
            ew.setSelected(ctVar.isSelected);
            ew.setTag(ctVar);
            addView(ew, layoutParams);
        }
    }

    public void a(List<bt> list, bt btVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    ct ctVar = new ct();
                    ctVar.bIQ = list.get(i3).bIQ;
                    ctVar.name = list.get(i3).name;
                    if (i == list.get(i3).bIQ) {
                        ctVar.isSelected = true;
                    }
                    arrayList.add(ctVar);
                }
                i2 = i3 + 1;
            }
            ct ctVar2 = null;
            if (btVar != null) {
                ctVar2 = new ct();
                ctVar2.bIQ = btVar.bIQ;
                ctVar2.name = btVar.name;
                if (i == btVar.bIQ) {
                    ctVar2.isSelected = true;
                }
            }
            a(arrayList, ctVar2);
        }
    }

    public void a(List<ct> list, ct ctVar) {
        this.bJR = ctVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bJN = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bJO = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bJQ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ct) {
            Zt();
            ct ctVar = (ct) view.getTag();
            a(ctVar, true);
            view.setSelected(true);
            if (this.bJQ != null) {
                this.bJQ.a(view, ctVar);
            }
        }
    }

    public void Zt() {
        if (this.aMy != null && getChildCount() > 0) {
            if (this.bJR != null) {
                this.bJR.isSelected = false;
            }
            for (ct ctVar : this.aMy) {
                ctVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(ct ctVar, boolean z) {
        if (ctVar != null && this.aMy != null) {
            if (this.bJR != null && this.bJR.bIQ == ctVar.bIQ) {
                this.bJR.isSelected = z;
                return;
            }
            for (ct ctVar2 : this.aMy) {
                if (ctVar.bIQ == ctVar2.bIQ) {
                    ctVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void ws() {
        com.baidu.tbadk.core.util.ap.k(this, r.e.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ap.j((View) textView, r.g.bg_tab_meun);
                    com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
