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
    private com.baidu.adp.lib.d.b<TextView> eEq;
    private int hrL;
    private int hrM;
    private int hrN;
    private int hrO;
    private a hrP;
    private ax hrQ;
    private Context mContext;
    private List<ax> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, ax axVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrL = 2;
        this.hrM = 2;
        this.hrN = 4;
        this.hrO = 5;
        setOrientation(1);
        this.mContext = context;
        this.hrM = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20);
        this.eEq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bjn */
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
                    TabMenuPopView.this.eEq.returnObject((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), bR((getChildAt(0).getMeasuredHeight() * this.hrO) + (this.hrM * (this.hrO - 1)) + (this.hrM * 2), i2));
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
            if (this.hrN > 1) {
                this.hrL = (measuredWidth - (measuredWidth2 * this.hrN)) / (this.hrN - 1);
            }
            int[] iArr = new int[this.hrO + 1];
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
                if (this.hrQ != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.hrM * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.hrM;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.hrL + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.hrL + i13;
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
            if (this.hrQ != null) {
                if (cn(list)) {
                    this.hrQ.isSelected = false;
                } else {
                    this.hrQ.isSelected = true;
                }
                this.hrO = ((int) Math.ceil(list.size() / this.hrN)) + 1;
                a(this.hrQ, layoutParams);
            } else {
                this.hrO = (int) Math.ceil(list.size() / this.hrN);
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
            TextView borrowObject = this.eEq.borrowObject();
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
                    axVar.hre = list.get(i3).hre;
                    axVar.name = list.get(i3).name;
                    if (i == list.get(i3).hre) {
                        axVar.isSelected = true;
                    }
                    arrayList.add(axVar);
                }
                i2 = i3 + 1;
            }
            ax axVar2 = null;
            if (aaVar != null) {
                axVar2 = new ax();
                axVar2.hre = aaVar.hre;
                axVar2.name = aaVar.name;
                if (i == aaVar.hre) {
                    axVar2.isSelected = true;
                }
            }
            setData(arrayList, axVar2);
        }
    }

    public void setData(List<ax> list, ax axVar) {
        this.hrQ = axVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.hrM = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.hrN = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.hrP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ax) {
            bXe();
            ax axVar = (ax) view.getTag();
            setItemSelectState(axVar, true);
            view.setSelected(true);
            if (this.hrP != null) {
                this.hrP.a(view, axVar);
            }
        }
    }

    public void bXe() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.hrQ != null) {
                this.hrQ.isSelected = false;
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
            if (this.hrQ != null && this.hrQ.hre == axVar.hre) {
                this.hrQ.isSelected = z;
                return;
            }
            for (ax axVar2 : this.mDataList) {
                if (axVar.hre == axVar2.hre) {
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

    public void aWr() {
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
