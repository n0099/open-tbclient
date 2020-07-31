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
    private com.baidu.adp.lib.d.b<TextView> eUX;
    private int hKA;
    private int hKB;
    private int hKC;
    private int hKD;
    private a hKE;
    private bd hKF;
    private Context mContext;
    private List<bd> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, bd bdVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hKA = 2;
        this.hKB = 2;
        this.hKC = 4;
        this.hKD = 5;
        setOrientation(1);
        this.mContext = context;
        this.hKB = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20);
        this.eUX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bpH */
            public TextView makeObject() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TabMenuPopView.this.mContext, R.dimen.fontsize28));
                com.baidu.tbadk.core.util.ao.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                com.baidu.tbadk.core.util.ao.setViewTextColor(textView, R.color.cp_cont_f, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public void destroyObject(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public TextView activateObject(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.ao.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.ao.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: f */
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
                    TabMenuPopView.this.eUX.returnObject((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), ca((getChildAt(0).getMeasuredHeight() * this.hKD) + (this.hKB * (this.hKD - 1)) + (this.hKB * 2), i2));
        }
    }

    private int ca(int i, int i2) {
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
            if (this.hKC > 1) {
                this.hKA = (measuredWidth - (measuredWidth2 * this.hKC)) / (this.hKC - 1);
            }
            int[] iArr = new int[this.hKD + 1];
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
                if (this.hKF != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.hKB * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.hKB;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.hKA + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.hKA + i13;
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
            if (this.hKF != null) {
                if (cC(list)) {
                    this.hKF.isSelected = false;
                } else {
                    this.hKF.isSelected = true;
                }
                this.hKD = ((int) Math.ceil(list.size() / this.hKC)) + 1;
                a(this.hKF, layoutParams);
            } else {
                this.hKD = (int) Math.ceil(list.size() / this.hKC);
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

    private boolean cC(List<bd> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(bd bdVar, LinearLayout.LayoutParams layoutParams) {
        if (bdVar != null && layoutParams != null) {
            TextView borrowObject = this.eUX.borrowObject();
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
                    bdVar.hJP = list.get(i3).hJP;
                    bdVar.name = list.get(i3).name;
                    if (i == list.get(i3).hJP) {
                        bdVar.isSelected = true;
                    }
                    arrayList.add(bdVar);
                }
                i2 = i3 + 1;
            }
            bd bdVar2 = null;
            if (adVar != null) {
                bdVar2 = new bd();
                bdVar2.hJP = adVar.hJP;
                bdVar2.name = adVar.name;
                if (i == adVar.hJP) {
                    bdVar2.isSelected = true;
                }
            }
            setData(arrayList, bdVar2);
        }
    }

    public void setData(List<bd> list, bd bdVar) {
        this.hKF = bdVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.hKB = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.hKC = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.hKE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof bd) {
            cdO();
            bd bdVar = (bd) view.getTag();
            setItemSelectState(bdVar, true);
            view.setSelected(true);
            if (this.hKE != null) {
                this.hKE.a(view, bdVar);
            }
        }
    }

    public void cdO() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.hKF != null) {
                this.hKF.isSelected = false;
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
            if (this.hKF != null && this.hKF.hJP == bdVar.hJP) {
                this.hKF.isSelected = z;
                return;
            }
            for (bd bdVar2 : this.mDataList) {
                if (bdVar.hJP == bdVar2.hJP) {
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

    public void bci() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ao.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.ao.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
