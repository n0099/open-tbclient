package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private com.baidu.adp.lib.d.b<TextView> eEf;
    private int hrA;
    private int hrB;
    private int hrC;
    private int hrD;
    private a hrE;
    private ax hrF;
    private Context mContext;
    private List<ax> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, ax axVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrA = 2;
        this.hrB = 2;
        this.hrC = 4;
        this.hrD = 5;
        setOrientation(1);
        this.mContext = context;
        this.hrB = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20);
        this.eEf = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bjl */
            public TextView makeObject() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TabMenuPopView.this.mContext, R.dimen.fontsize28));
                com.baidu.tbadk.core.util.am.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_f, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public void destroyObject(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TextView activateObject(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public TextView passivateObject(TextView textView) {
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
                    TabMenuPopView.this.eEf.returnObject((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), bR((getChildAt(0).getMeasuredHeight() * this.hrD) + (this.hrB * (this.hrD - 1)) + (this.hrB * 2), i2));
        }
    }

    private int bR(int i, int i2) {
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
            if (this.hrC > 1) {
                this.hrA = (measuredWidth - (measuredWidth2 * this.hrC)) / (this.hrC - 1);
            }
            int[] iArr = new int[this.hrD + 1];
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
                if (this.hrF != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.hrB * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.hrB;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.hrA + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.hrA + i13;
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

    private void setData(List<ax> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
            if (this.hrF != null) {
                if (cn(list)) {
                    this.hrF.isSelected = false;
                } else {
                    this.hrF.isSelected = true;
                }
                this.hrD = ((int) Math.ceil(list.size() / this.hrC)) + 1;
                a(this.hrF, layoutParams);
            } else {
                this.hrD = (int) Math.ceil(list.size() / this.hrC);
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

    private boolean cn(List<ax> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(ax axVar, LinearLayout.LayoutParams layoutParams) {
        if (axVar != null && layoutParams != null) {
            TextView borrowObject = this.eEf.borrowObject();
            borrowObject.setText(axVar.name);
            borrowObject.setSelected(axVar.isSelected);
            borrowObject.setTag(axVar);
            addView(borrowObject, layoutParams);
        }
    }

    public void setData(List<aa> list, aa aaVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    ax axVar = new ax();
                    axVar.hqT = list.get(i3).hqT;
                    axVar.name = list.get(i3).name;
                    if (i == list.get(i3).hqT) {
                        axVar.isSelected = true;
                    }
                    arrayList.add(axVar);
                }
                i2 = i3 + 1;
            }
            ax axVar2 = null;
            if (aaVar != null) {
                axVar2 = new ax();
                axVar2.hqT = aaVar.hqT;
                axVar2.name = aaVar.name;
                if (i == aaVar.hqT) {
                    axVar2.isSelected = true;
                }
            }
            setData(arrayList, axVar2);
        }
    }

    public void setData(List<ax> list, ax axVar) {
        this.hrF = axVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.hrB = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.hrC = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.hrE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ax) {
            bXc();
            ax axVar = (ax) view.getTag();
            setItemSelectState(axVar, true);
            view.setSelected(true);
            if (this.hrE != null) {
                this.hrE.a(view, axVar);
            }
        }
    }

    public void bXc() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.hrF != null) {
                this.hrF.isSelected = false;
            }
            for (ax axVar : this.mDataList) {
                axVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void setItemSelectState(ax axVar, boolean z) {
        if (axVar != null && this.mDataList != null) {
            if (this.hrF != null && this.hrF.hqT == axVar.hqT) {
                this.hrF.isSelected = z;
                return;
            }
            for (ax axVar2 : this.mDataList) {
                if (axVar.hqT == axVar2.hqT) {
                    axVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void aWq() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
