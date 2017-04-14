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
    private b<TextView> aNr;
    private List<cv> aSB;
    private int bQH;
    private int bQI;
    private int bQJ;
    private int bQK;
    private a bQL;
    private cv bQM;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, cv cvVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQH = 2;
        this.bQI = 2;
        this.bQJ = 4;
        this.bQK = 5;
        setOrientation(1);
        this.mContext = context;
        this.bQI = com.baidu.adp.lib.util.k.g(context, w.f.ds20);
        this.aNr = new b<>(new cx(this), 17, 0);
        setOnHierarchyChangeListener(new cy(this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), aj((getChildAt(0).getMeasuredHeight() * this.bQK) + (this.bQI * (this.bQK - 1)) + (this.bQI * 2), i2));
        }
    }

    private int aj(int i, int i2) {
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
            if (this.bQJ > 1) {
                this.bQH = (measuredWidth - (measuredWidth2 * this.bQJ)) / (this.bQJ - 1);
            }
            int[] iArr = new int[this.bQK + 1];
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
                if (this.bQM != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.bQI * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.bQI;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.bQH + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.bQH + i13;
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

    private void setData(List<cv> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds150), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60));
            if (this.bQM != null) {
                if (ap(list)) {
                    this.bQM.isSelected = false;
                } else {
                    this.bQM.isSelected = true;
                }
                this.bQK = ((int) Math.ceil(list.size() / this.bQJ)) + 1;
                a(this.bQM, layoutParams);
            } else {
                this.bQK = (int) Math.ceil(list.size() / this.bQJ);
            }
            this.aSB = list;
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

    private boolean ap(List<cv> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(cv cvVar, LinearLayout.LayoutParams layoutParams) {
        if (cvVar != null && layoutParams != null) {
            TextView fJ = this.aNr.fJ();
            fJ.setText(cvVar.name);
            fJ.setSelected(cvVar.isSelected);
            fJ.setTag(cvVar);
            addView(fJ, layoutParams);
        }
    }

    public void a(List<bv> list, bv bvVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    cv cvVar = new cv();
                    cvVar.bPO = list.get(i3).bPO;
                    cvVar.name = list.get(i3).name;
                    if (i == list.get(i3).bPO) {
                        cvVar.isSelected = true;
                    }
                    arrayList.add(cvVar);
                }
                i2 = i3 + 1;
            }
            cv cvVar2 = null;
            if (bvVar != null) {
                cvVar2 = new cv();
                cvVar2.bPO = bvVar.bPO;
                cvVar2.name = bvVar.name;
                if (i == bvVar.bPO) {
                    cvVar2.isSelected = true;
                }
            }
            a(arrayList, cvVar2);
        }
    }

    public void a(List<cv> list, cv cvVar) {
        this.bQM = cvVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.bQI = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.bQJ = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.bQL = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof cv) {
            aaO();
            cv cvVar = (cv) view.getTag();
            a(cvVar, true);
            view.setSelected(true);
            if (this.bQL != null) {
                this.bQL.a(view, cvVar);
            }
        }
    }

    public void aaO() {
        if (this.aSB != null && getChildCount() > 0) {
            if (this.bQM != null) {
                this.bQM.isSelected = false;
            }
            for (cv cvVar : this.aSB) {
                cvVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(cv cvVar, boolean z) {
        if (cvVar != null && this.aSB != null) {
            if (this.bQM != null && this.bQM.bPO == cvVar.bPO) {
                this.bQM.isSelected = z;
                return;
            }
            for (cv cvVar2 : this.aSB) {
                if (cvVar.bPO == cvVar2.bPO) {
                    cvVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void xl() {
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
