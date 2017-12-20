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
    private com.baidu.adp.lib.e.b<TextView> aVy;
    private int cKF;
    private int cKG;
    private int cKH;
    private int cKI;
    private a cKJ;
    private au cKK;
    private Context mContext;
    private List<au> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, au auVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKF = 2;
        this.cKG = 2;
        this.cKH = 4;
        this.cKI = 5;
        setOrientation(1);
        this.mContext = context;
        this.cKG = com.baidu.adp.lib.util.l.f(context, d.e.ds20);
        this.aVy = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Kj */
            public TextView fI() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.f(TabMenuPopView.this.mContext, d.e.fontsize28));
                com.baidu.tbadk.core.util.aj.j(textView, d.f.bg_tab_meun);
                com.baidu.tbadk.core.util.aj.c(textView, d.C0096d.cp_cont_f, 1);
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
                    com.baidu.tbadk.core.util.aj.c(textView, d.C0096d.cp_cont_f, 1);
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
                    TabMenuPopView.this.aVy.m((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), aA((getChildAt(0).getMeasuredHeight() * this.cKI) + (this.cKG * (this.cKI - 1)) + (this.cKG * 2), i2));
        }
    }

    private int aA(int i, int i2) {
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
            if (this.cKH > 1) {
                this.cKF = (measuredWidth - (measuredWidth2 * this.cKH)) / (this.cKH - 1);
            }
            int[] iArr = new int[this.cKI + 1];
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
                if (this.cKK != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.cKG * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.cKG;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.cKF + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.cKF + i13;
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

    private void setData(List<au> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60));
            if (this.cKK != null) {
                if (aY(list)) {
                    this.cKK.isSelected = false;
                } else {
                    this.cKK.isSelected = true;
                }
                this.cKI = ((int) Math.ceil(list.size() / this.cKH)) + 1;
                a(this.cKK, layoutParams);
            } else {
                this.cKI = (int) Math.ceil(list.size() / this.cKH);
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

    private boolean aY(List<au> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(au auVar, LinearLayout.LayoutParams layoutParams) {
        if (auVar != null && layoutParams != null) {
            TextView fH = this.aVy.fH();
            fH.setText(auVar.name);
            fH.setSelected(auVar.isSelected);
            fH.setTag(auVar);
            addView(fH, layoutParams);
        }
    }

    public void a(List<z> list, z zVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    au auVar = new au();
                    auVar.cKd = list.get(i3).cKd;
                    auVar.name = list.get(i3).name;
                    if (i == list.get(i3).cKd) {
                        auVar.isSelected = true;
                    }
                    arrayList.add(auVar);
                }
                i2 = i3 + 1;
            }
            au auVar2 = null;
            if (zVar != null) {
                auVar2 = new au();
                auVar2.cKd = zVar.cKd;
                auVar2.name = zVar.name;
                if (i == zVar.cKd) {
                    auVar2.isSelected = true;
                }
            }
            a(arrayList, auVar2);
        }
    }

    public void a(List<au> list, au auVar) {
        this.cKK = auVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.cKG = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.cKH = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.cKJ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof au) {
            amJ();
            au auVar = (au) view.getTag();
            a(auVar, true);
            view.setSelected(true);
            if (this.cKJ != null) {
                this.cKJ.a(view, auVar);
            }
        }
    }

    public void amJ() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.cKK != null) {
                this.cKK.isSelected = false;
            }
            for (au auVar : this.mDataList) {
                auVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void a(au auVar, boolean z) {
        if (auVar != null && this.mDataList != null) {
            if (this.cKK != null && this.cKK.cKd == auVar.cKd) {
                this.cKK.isSelected = z;
                return;
            }
            for (au auVar2 : this.mDataList) {
                if (auVar.cKd == auVar2.cKd) {
                    auVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void wC() {
        com.baidu.tbadk.core.util.aj.k(this, d.C0096d.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.aj.j(textView, d.f.bg_tab_meun);
                    com.baidu.tbadk.core.util.aj.c(textView, d.C0096d.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
