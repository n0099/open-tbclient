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
    private com.baidu.adp.lib.e.b<TextView> aQh;
    private int clf;
    private int clg;
    private int clh;
    private int cli;
    private a clj;
    private as clk;
    private Context mContext;
    private List<as> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, as asVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clf = 2;
        this.clg = 2;
        this.clh = 4;
        this.cli = 5;
        setOrientation(1);
        this.mContext = context;
        this.clg = com.baidu.adp.lib.util.k.g(context, d.f.ds20);
        this.aQh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: IY */
            public TextView fI() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.k.g(TabMenuPopView.this.mContext, d.f.fontsize28));
                com.baidu.tbadk.core.util.ai.j(textView, d.g.bg_tab_meun);
                com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_f, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void o(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public TextView p(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.ai.j(textView, d.g.bg_tab_meun);
                    com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public TextView q(TextView textView) {
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
                    TabMenuPopView.this.aQh.n((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), ap((getChildAt(0).getMeasuredHeight() * this.cli) + (this.clg * (this.cli - 1)) + (this.clg * 2), i2));
        }
    }

    private int ap(int i, int i2) {
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
            if (this.clh > 1) {
                this.clf = (measuredWidth - (measuredWidth2 * this.clh)) / (this.clh - 1);
            }
            int[] iArr = new int[this.cli + 1];
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
                if (this.clk != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.clg * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.clg;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.clf + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.clf + i13;
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

    private void setData(List<as> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60));
            if (this.clk != null) {
                if (aG(list)) {
                    this.clk.isSelected = false;
                } else {
                    this.clk.isSelected = true;
                }
                this.cli = ((int) Math.ceil(list.size() / this.clh)) + 1;
                a(this.clk, layoutParams);
            } else {
                this.cli = (int) Math.ceil(list.size() / this.clh);
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

    private boolean aG(List<as> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(as asVar, LinearLayout.LayoutParams layoutParams) {
        if (asVar != null && layoutParams != null) {
            TextView fH = this.aQh.fH();
            fH.setText(asVar.name);
            fH.setSelected(asVar.isSelected);
            fH.setTag(asVar);
            addView(fH, layoutParams);
        }
    }

    public void a(List<x> list, x xVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    as asVar = new as();
                    asVar.ckC = list.get(i3).ckC;
                    asVar.name = list.get(i3).name;
                    if (i == list.get(i3).ckC) {
                        asVar.isSelected = true;
                    }
                    arrayList.add(asVar);
                }
                i2 = i3 + 1;
            }
            as asVar2 = null;
            if (xVar != null) {
                asVar2 = new as();
                asVar2.ckC = xVar.ckC;
                asVar2.name = xVar.name;
                if (i == xVar.ckC) {
                    asVar2.isSelected = true;
                }
            }
            a(arrayList, asVar2);
        }
    }

    public void a(List<as> list, as asVar) {
        this.clk = asVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.clg = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.clh = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.clj = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof as) {
            agg();
            as asVar = (as) view.getTag();
            a(asVar, true);
            view.setSelected(true);
            if (this.clj != null) {
                this.clj.a(view, asVar);
            }
        }
    }

    public void agg() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.clk != null) {
                this.clk.isSelected = false;
            }
            for (as asVar : this.mDataList) {
                asVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(as asVar, boolean z) {
        if (asVar != null && this.mDataList != null) {
            if (this.clk != null && this.clk.ckC == asVar.ckC) {
                this.clk.isSelected = z;
                return;
            }
            for (as asVar2 : this.mDataList) {
                if (asVar.ckC == asVar2.ckC) {
                    asVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wV() {
        com.baidu.tbadk.core.util.ai.k(this, d.e.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ai.j(textView, d.g.bg_tab_meun);
                    com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
