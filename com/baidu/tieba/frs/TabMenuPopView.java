package com.baidu.tieba.frs;

import android.content.Context;
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
    private com.baidu.adp.lib.e.b<TextView> aWo;
    private int daC;
    private int daD;
    private int daE;
    private int daF;
    private a daG;
    private ar daH;
    private Context mContext;
    private List<ar> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view2, ar arVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.daC = 2;
        this.daD = 2;
        this.daE = 4;
        this.daF = 5;
        setOrientation(1);
        this.mContext = context;
        this.daD = com.baidu.adp.lib.util.l.e(context, d.e.ds20);
        this.aWo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: KB */
            public TextView fo() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.e(TabMenuPopView.this.mContext, d.e.fontsize28));
                com.baidu.tbadk.core.util.ak.i(textView, d.f.bg_tab_meun);
                com.baidu.tbadk.core.util.ak.c(textView, d.C0126d.cp_cont_f, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void n(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public TextView o(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.ak.i(textView, d.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.ak.c(textView, d.C0126d.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
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
            public void onChildViewRemoved(View view2, View view3) {
                if (view3 instanceof TextView) {
                    TabMenuPopView.this.aWo.m((TextView) view3);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            setMeasuredDimension(getMeasuredWidth(), aA((getChildAt(0).getMeasuredHeight() * this.daF) + (this.daD * (this.daF - 1)) + (this.daD * 2), i2));
        }
    }

    private int aA(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
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
            if (this.daE > 1) {
                this.daC = (measuredWidth - (measuredWidth2 * this.daE)) / (this.daE - 1);
            }
            int[] iArr = new int[this.daF + 1];
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
                if (this.daH != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.daD * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.daD;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.daC + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.daC + i13;
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

    private void setData(List<ar> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60));
            if (this.daH != null) {
                if (be(list)) {
                    this.daH.isSelected = false;
                } else {
                    this.daH.isSelected = true;
                }
                this.daF = ((int) Math.ceil(list.size() / this.daE)) + 1;
                a(this.daH, layoutParams);
            } else {
                this.daF = (int) Math.ceil(list.size() / this.daE);
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

    private boolean be(List<ar> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(ar arVar, LinearLayout.LayoutParams layoutParams) {
        if (arVar != null && layoutParams != null) {
            TextView fn = this.aWo.fn();
            fn.setText(arVar.name);
            fn.setSelected(arVar.isSelected);
            fn.setTag(arVar);
            addView(fn, layoutParams);
        }
    }

    public void setData(List<v> list, v vVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    ar arVar = new ar();
                    arVar.cZZ = list.get(i3).cZZ;
                    arVar.name = list.get(i3).name;
                    if (i == list.get(i3).cZZ) {
                        arVar.isSelected = true;
                    }
                    arrayList.add(arVar);
                }
                i2 = i3 + 1;
            }
            ar arVar2 = null;
            if (vVar != null) {
                arVar2 = new ar();
                arVar2.cZZ = vVar.cZZ;
                arVar2.name = vVar.name;
                if (i == vVar.cZZ) {
                    arVar2.isSelected = true;
                }
            }
            setData(arrayList, arVar2);
        }
    }

    public void setData(List<ar> list, ar arVar) {
        this.daH = arVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.daD = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.daE = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.daG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getTag() instanceof ar) {
            aqQ();
            ar arVar = (ar) view2.getTag();
            setItemSelectState(arVar, true);
            view2.setSelected(true);
            if (this.daG != null) {
                this.daG.a(view2, arVar);
            }
        }
    }

    public void aqQ() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.daH != null) {
                this.daH.isSelected = false;
            }
            for (ar arVar : this.mDataList) {
                arVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void setItemSelectState(ar arVar, boolean z) {
        if (arVar != null && this.mDataList != null) {
            if (this.daH != null && this.daH.cZZ == arVar.cZZ) {
                this.daH.isSelected = z;
                return;
            }
            for (ar arVar2 : this.mDataList) {
                if (arVar.cZZ == arVar2.cZZ) {
                    arVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wY() {
        com.baidu.tbadk.core.util.ak.j(this, d.C0126d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ak.i(textView, d.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.ak.c(textView, d.C0126d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
