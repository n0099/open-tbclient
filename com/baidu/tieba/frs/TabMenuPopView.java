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
    private com.baidu.adp.lib.d.b<TextView> fiD;
    private int ifj;
    private int ifk;
    private int ifl;
    private int ifm;
    private a ifn;
    private bf ifo;
    private Context mContext;
    private List<bf> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, bf bfVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ifj = 2;
        this.ifk = 2;
        this.ifl = 4;
        this.ifm = 5;
        setOrientation(1);
        this.mContext = context;
        this.ifk = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20);
        this.fiD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bzF */
            public TextView makeObject() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TabMenuPopView.this.mContext, R.dimen.fontsize28));
                com.baidu.tbadk.core.util.ap.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.cp_cont_f, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public TextView activateObject(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
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
                    TabMenuPopView.this.fiD.returnObject((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), cl((getChildAt(0).getMeasuredHeight() * this.ifm) + (this.ifk * (this.ifm - 1)) + (this.ifk * 2), i2));
        }
    }

    private int cl(int i, int i2) {
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
            if (this.ifl > 1) {
                this.ifj = (measuredWidth - (measuredWidth2 * this.ifl)) / (this.ifl - 1);
            }
            int[] iArr = new int[this.ifm + 1];
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
                if (this.ifo != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.ifk * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.ifk;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.ifj + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.ifj + i13;
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

    private void setData(List<bf> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
            if (this.ifo != null) {
                if (cK(list)) {
                    this.ifo.isSelected = false;
                } else {
                    this.ifo.isSelected = true;
                }
                this.ifm = ((int) Math.ceil(list.size() / this.ifl)) + 1;
                a(this.ifo, layoutParams);
            } else {
                this.ifm = (int) Math.ceil(list.size() / this.ifl);
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

    private boolean cK(List<bf> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(bf bfVar, LinearLayout.LayoutParams layoutParams) {
        if (bfVar != null && layoutParams != null) {
            TextView borrowObject = this.fiD.borrowObject();
            borrowObject.setText(bfVar.name);
            borrowObject.setSelected(bfVar.isSelected);
            borrowObject.setTag(bfVar);
            addView(borrowObject, layoutParams);
        }
    }

    public void setData(List<af> list, af afVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    bf bfVar = new bf();
                    bfVar.iex = list.get(i3).iex;
                    bfVar.name = list.get(i3).name;
                    if (i == list.get(i3).iex) {
                        bfVar.isSelected = true;
                    }
                    arrayList.add(bfVar);
                }
                i2 = i3 + 1;
            }
            bf bfVar2 = null;
            if (afVar != null) {
                bfVar2 = new bf();
                bfVar2.iex = afVar.iex;
                bfVar2.name = afVar.name;
                if (i == afVar.iex) {
                    bfVar2.isSelected = true;
                }
            }
            setData(arrayList, bfVar2);
        }
    }

    public void setData(List<bf> list, bf bfVar) {
        this.ifo = bfVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.ifk = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.ifl = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.ifn = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof bf) {
            crB();
            bf bfVar = (bf) view.getTag();
            setItemSelectState(bfVar, true);
            view.setSelected(true);
            if (this.ifn != null) {
                this.ifn.a(view, bfVar);
            }
        }
    }

    public void crB() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.ifo != null) {
                this.ifo.isSelected = false;
            }
            for (bf bfVar : this.mDataList) {
                bfVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void setItemSelectState(bf bfVar, boolean z) {
        if (bfVar != null && this.mDataList != null) {
            if (this.ifo != null && this.ifo.iex == bfVar.iex) {
                this.ifo.isSelected = z;
                return;
            }
            for (bf bfVar2 : this.mDataList) {
                if (bfVar.iex == bfVar2.iex) {
                    bfVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void blA() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
