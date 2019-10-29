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
    private com.baidu.adp.lib.e.b<TextView> cXc;
    private int fzN;
    private int fzO;
    private int fzP;
    private int fzQ;
    private a fzR;
    private ar fzS;
    private Context mContext;
    private List<ar> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, ar arVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzN = 2;
        this.fzO = 2;
        this.fzP = 4;
        this.fzQ = 5;
        setOrientation(1);
        this.mContext = context;
        this.fzO = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20);
        this.cXc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aAc */
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
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public TextView activateObject(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.am.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_f, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
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
                    TabMenuPopView.this.cXc.returnObject((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), bp((getChildAt(0).getMeasuredHeight() * this.fzQ) + (this.fzO * (this.fzQ - 1)) + (this.fzO * 2), i2));
        }
    }

    private int bp(int i, int i2) {
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
            if (this.fzP > 1) {
                this.fzN = (measuredWidth - (measuredWidth2 * this.fzP)) / (this.fzP - 1);
            }
            int[] iArr = new int[this.fzQ + 1];
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
                if (this.fzS != null && i12 == 0) {
                    i5 = 0;
                    i6 = (this.fzO * 2) + i14;
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
                    i10 = iArr[i9] + i10 + this.fzO;
                    int i15 = 0 + measuredWidth3;
                    i5 = this.fzN + i15;
                    i9++;
                    i6 = i10;
                    i7 = i10 + measuredHeight;
                    i8 = i15;
                } else {
                    if (measuredHeight > iArr[i9]) {
                        iArr[i9] = measuredHeight;
                    }
                    i5 = this.fzN + i13;
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
            if (this.fzS != null) {
                if (cm(list)) {
                    this.fzS.isSelected = false;
                } else {
                    this.fzS.isSelected = true;
                }
                this.fzQ = ((int) Math.ceil(list.size() / this.fzP)) + 1;
                a(this.fzS, layoutParams);
            } else {
                this.fzQ = (int) Math.ceil(list.size() / this.fzP);
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

    private boolean cm(List<ar> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(ar arVar, LinearLayout.LayoutParams layoutParams) {
        if (arVar != null && layoutParams != null) {
            TextView borrowObject = this.cXc.borrowObject();
            borrowObject.setText(arVar.name);
            borrowObject.setSelected(arVar.isSelected);
            borrowObject.setTag(arVar);
            addView(borrowObject, layoutParams);
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
                    arVar.fyZ = list.get(i3).fyZ;
                    arVar.name = list.get(i3).name;
                    if (i == list.get(i3).fyZ) {
                        arVar.isSelected = true;
                    }
                    arrayList.add(arVar);
                }
                i2 = i3 + 1;
            }
            ar arVar2 = null;
            if (vVar != null) {
                arVar2 = new ar();
                arVar2.fyZ = vVar.fyZ;
                arVar2.name = vVar.name;
                if (i == vVar.fyZ) {
                    arVar2.isSelected = true;
                }
            }
            setData(arrayList, arVar2);
        }
    }

    public void setData(List<ar> list, ar arVar) {
        this.fzS = arVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.fzO = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.fzP = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.fzR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ar) {
            blT();
            ar arVar = (ar) view.getTag();
            setItemSelectState(arVar, true);
            view.setSelected(true);
            if (this.fzR != null) {
                this.fzR.a(view, arVar);
            }
        }
    }

    public void blT() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.fzS != null) {
                this.fzS.isSelected = false;
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
            if (this.fzS != null && this.fzS.fyZ == arVar.fyZ) {
                this.fzS.isSelected = z;
                return;
            }
            for (ar arVar2 : this.mDataList) {
                if (arVar.fyZ == arVar2.fyZ) {
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

    public void anO() {
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
