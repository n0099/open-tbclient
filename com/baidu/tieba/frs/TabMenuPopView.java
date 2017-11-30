package com.baidu.tieba.frs;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private com.baidu.adp.lib.e.b<TextView> aVw;
    private at cKA;
    private int cKv;
    private int cKw;
    private int cKx;
    private int cKy;
    private a cKz;
    private Context mContext;
    private List<at> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, at atVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKv = 2;
        this.cKw = 2;
        this.cKx = 4;
        this.cKy = 5;
        setOrientation(1);
        this.mContext = context;
        this.cKw = com.baidu.adp.lib.util.l.f(context, d.e.ds20);
        this.aVw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ki */
            public TextView fI() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.f(TabMenuPopView.this.mContext, d.e.fontsize28));
                com.baidu.tbadk.core.util.aj.j(textView, d.f.bg_tab_meun);
                com.baidu.tbadk.core.util.aj.c(textView, d.C0082d.cp_cont_f, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public TextView o(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.aj.j(textView, d.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.aj.c(textView, d.C0082d.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public TextView p(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
                return textView;
            }
        }, 17, 0);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.TabMenuPopView.2
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof TextView) {
                    TabMenuPopView.this.aVw.m((TextView) view2);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), az((getChildAt(0).getMeasuredHeight() * this.cKy) + (this.cKw * (this.cKy - 1)) + (this.cKw * 2), i2));
        }
    }

    private int az(int i, int i2) {
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
            if (this.cKx > 1) {
                this.cKv = (measuredWidth - (measuredWidth2 * this.cKx)) / (this.cKx - 1);
            }
            int[] iArr = new int[this.cKy + 1];
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
                if (this.cKA != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.cKw * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.cKw;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.cKv + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.cKv + i13;
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

    private void setData(List<at> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60));
            if (this.cKA != null) {
                if (aY(list)) {
                    this.cKA.isSelected = false;
                } else {
                    this.cKA.isSelected = true;
                }
                this.cKy = ((int) Math.ceil(list.size() / this.cKx)) + 1;
                a(this.cKA, layoutParams);
            } else {
                this.cKy = (int) Math.ceil(list.size() / this.cKx);
            }
            this.mDataList = list;
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

    private boolean aY(List<at> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(at atVar, LinearLayout.LayoutParams layoutParams) {
        if (atVar != null && layoutParams != null) {
            TextView fH = this.aVw.fH();
            fH.setText(atVar.name);
            fH.setSelected(atVar.isSelected);
            fH.setTag(atVar);
            addView(fH, layoutParams);
        }
    }

    public void a(List<y> list, y yVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    at atVar = new at();
                    atVar.cJT = list.get(i3).cJT;
                    atVar.name = list.get(i3).name;
                    if (i == list.get(i3).cJT) {
                        atVar.isSelected = true;
                    }
                    arrayList.add(atVar);
                }
                i2 = i3 + 1;
            }
            at atVar2 = null;
            if (yVar != null) {
                atVar2 = new at();
                atVar2.cJT = yVar.cJT;
                atVar2.name = yVar.name;
                if (i == yVar.cJT) {
                    atVar2.isSelected = true;
                }
            }
            a(arrayList, atVar2);
        }
    }

    public void a(List<at> list, at atVar) {
        this.cKA = atVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.cKw = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.cKx = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.cKz = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof at) {
            amB();
            at atVar = (at) view.getTag();
            a(atVar, true);
            view.setSelected(true);
            if (this.cKz != null) {
                this.cKz.a(view, atVar);
            }
        }
    }

    public void amB() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.cKA != null) {
                this.cKA.isSelected = false;
            }
            for (at atVar : this.mDataList) {
                atVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(at atVar, boolean z) {
        if (atVar != null && this.mDataList != null) {
            if (this.cKA != null && this.cKA.cJT == atVar.cJT) {
                this.cKA.isSelected = z;
                return;
            }
            for (at atVar2 : this.mDataList) {
                if (atVar.cJT == atVar2.cJT) {
                    atVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wE() {
        com.baidu.tbadk.core.util.aj.k(this, d.C0082d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.aj.j(textView, d.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.aj.c(textView, d.C0082d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
