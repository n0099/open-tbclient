package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {
    private com.baidu.adp.lib.e.b<TextView> bnv;
    private int dEi;
    private int dEj;
    private int dEk;
    private int dEl;
    private a dEm;
    private at dEn;
    private Context mContext;
    private List<at> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, at atVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEi = 2;
        this.dEj = 2;
        this.dEk = 4;
        this.dEl = 5;
        setOrientation(1);
        this.mContext = context;
        this.dEj = com.baidu.adp.lib.util.l.h(context, e.C0175e.ds20);
        this.bnv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: RE */
            public TextView jB() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.h(TabMenuPopView.this.mContext, e.C0175e.fontsize28));
                com.baidu.tbadk.core.util.al.i(textView, e.f.bg_tab_meun);
                com.baidu.tbadk.core.util.al.c(textView, e.d.cp_cont_f, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void u(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TextView v(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.al.i(textView, e.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.al.c(textView, e.d.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public TextView w(TextView textView) {
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
                    TabMenuPopView.this.bnv.t((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), aK((getChildAt(0).getMeasuredHeight() * this.dEl) + (this.dEj * (this.dEl - 1)) + (this.dEj * 2), i2));
        }
    }

    private int aK(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return size <= i ? size : i;
            case 0:
            default:
                return i;
            case AiAppsFileUtils.GB /* 1073741824 */:
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
            if (this.dEk > 1) {
                this.dEi = (measuredWidth - (measuredWidth2 * this.dEk)) / (this.dEk - 1);
            }
            int[] iArr = new int[this.dEl + 1];
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
                if (this.dEn != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.dEj * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.dEj;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.dEi + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.dEi + i13;
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds60));
            if (this.dEn != null) {
                if (bD(list)) {
                    this.dEn.isSelected = false;
                } else {
                    this.dEn.isSelected = true;
                }
                this.dEl = ((int) Math.ceil(list.size() / this.dEk)) + 1;
                a(this.dEn, layoutParams);
            } else {
                this.dEl = (int) Math.ceil(list.size() / this.dEk);
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

    private boolean bD(List<at> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(at atVar, LinearLayout.LayoutParams layoutParams) {
        if (atVar != null && layoutParams != null) {
            TextView jA = this.bnv.jA();
            jA.setText(atVar.name);
            jA.setSelected(atVar.isSelected);
            jA.setTag(atVar);
            addView(jA, layoutParams);
        }
    }

    public void setData(List<x> list, x xVar, int i) {
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
                    atVar.dDA = list.get(i3).dDA;
                    atVar.name = list.get(i3).name;
                    if (i == list.get(i3).dDA) {
                        atVar.isSelected = true;
                    }
                    arrayList.add(atVar);
                }
                i2 = i3 + 1;
            }
            at atVar2 = null;
            if (xVar != null) {
                atVar2 = new at();
                atVar2.dDA = xVar.dDA;
                atVar2.name = xVar.name;
                if (i == xVar.dDA) {
                    atVar2.isSelected = true;
                }
            }
            setData(arrayList, atVar2);
        }
    }

    public void setData(List<at> list, at atVar) {
        this.dEn = atVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.dEj = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.dEk = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.dEm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof at) {
            aBy();
            at atVar = (at) view.getTag();
            setItemSelectState(atVar, true);
            view.setSelected(true);
            if (this.dEm != null) {
                this.dEm.a(view, atVar);
            }
        }
    }

    public void aBy() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.dEn != null) {
                this.dEn.isSelected = false;
            }
            for (at atVar : this.mDataList) {
                atVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void setItemSelectState(at atVar, boolean z) {
        if (atVar != null && this.mDataList != null) {
            if (this.dEn != null && this.dEn.dDA == atVar.dDA) {
                this.dEn.isSelected = z;
                return;
            }
            for (at atVar2 : this.mDataList) {
                if (atVar.dDA == atVar2.dDA) {
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

    public void DV() {
        com.baidu.tbadk.core.util.al.j(this, e.d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.al.i(textView, e.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.al.c(textView, e.d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
