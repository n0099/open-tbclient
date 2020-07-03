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
    private com.baidu.adp.lib.d.b<TextView> eOC;
    private int hEC;
    private int hED;
    private int hEE;
    private int hEF;
    private a hEG;
    private bd hEH;
    private Context mContext;
    private List<bd> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, bd bdVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEC = 2;
        this.hED = 2;
        this.hEE = 4;
        this.hEF = 5;
        setOrientation(1);
        this.mContext = context;
        this.hED = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20);
        this.eOC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blM */
            public TextView makeObject() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TabMenuPopView.this.mContext, R.dimen.fontsize28));
                com.baidu.tbadk.core.util.an.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                com.baidu.tbadk.core.util.an.setViewTextColor(textView, R.color.cp_cont_f, 1);
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
                    com.baidu.tbadk.core.util.an.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.an.setViewTextColor(textView, R.color.cp_cont_f, 1);
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
                    TabMenuPopView.this.eOC.returnObject((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), bX((getChildAt(0).getMeasuredHeight() * this.hEF) + (this.hED * (this.hEF - 1)) + (this.hED * 2), i2));
        }
    }

    private int bX(int i, int i2) {
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
            if (this.hEE > 1) {
                this.hEC = (measuredWidth - (measuredWidth2 * this.hEE)) / (this.hEE - 1);
            }
            int[] iArr = new int[this.hEF + 1];
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
                if (this.hEH != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.hED * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.hED;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.hEC + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.hEC + i13;
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

    private void setData(List<bd> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
            if (this.hEH != null) {
                if (cx(list)) {
                    this.hEH.isSelected = false;
                } else {
                    this.hEH.isSelected = true;
                }
                this.hEF = ((int) Math.ceil(list.size() / this.hEE)) + 1;
                a(this.hEH, layoutParams);
            } else {
                this.hEF = (int) Math.ceil(list.size() / this.hEE);
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

    private boolean cx(List<bd> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(bd bdVar, LinearLayout.LayoutParams layoutParams) {
        if (bdVar != null && layoutParams != null) {
            TextView borrowObject = this.eOC.borrowObject();
            borrowObject.setText(bdVar.name);
            borrowObject.setSelected(bdVar.isSelected);
            borrowObject.setTag(bdVar);
            addView(borrowObject, layoutParams);
        }
    }

    public void setData(List<ad> list, ad adVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    bd bdVar = new bd();
                    bdVar.hDR = list.get(i3).hDR;
                    bdVar.name = list.get(i3).name;
                    if (i == list.get(i3).hDR) {
                        bdVar.isSelected = true;
                    }
                    arrayList.add(bdVar);
                }
                i2 = i3 + 1;
            }
            bd bdVar2 = null;
            if (adVar != null) {
                bdVar2 = new bd();
                bdVar2.hDR = adVar.hDR;
                bdVar2.name = adVar.name;
                if (i == adVar.hDR) {
                    bdVar2.isSelected = true;
                }
            }
            setData(arrayList, bdVar2);
        }
    }

    public void setData(List<bd> list, bd bdVar) {
        this.hEH = bdVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.hED = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.hEE = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.hEG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof bd) {
            cap();
            bd bdVar = (bd) view.getTag();
            setItemSelectState(bdVar, true);
            view.setSelected(true);
            if (this.hEG != null) {
                this.hEG.a(view, bdVar);
            }
        }
    }

    public void cap() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.hEH != null) {
                this.hEH.isSelected = false;
            }
            for (bd bdVar : this.mDataList) {
                bdVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void setItemSelectState(bd bdVar, boolean z) {
        if (bdVar != null && this.mDataList != null) {
            if (this.hEH != null && this.hEH.hDR == bdVar.hDR) {
                this.hEH.isSelected = z;
                return;
            }
            for (bd bdVar2 : this.mDataList) {
                if (bdVar.hDR == bdVar2.hDR) {
                    bdVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void aYj() {
        com.baidu.tbadk.core.util.an.setBackgroundColor(this, R.color.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.an.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.an.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
