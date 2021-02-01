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
    private com.baidu.adp.lib.d.b<TextView> fXB;
    private int jls;
    private int jlt;
    private int jlu;
    private int jlv;
    private a jlw;
    private bc jlx;
    private Context mContext;
    private List<bc> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, bc bcVar);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jls = 2;
        this.jlt = 2;
        this.jlu = 4;
        this.jlv = 5;
        setOrientation(1);
        this.mContext = context;
        this.jlt = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20);
        this.fXB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tieba.frs.TabMenuPopView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bIu */
            public TextView makeObject() {
                TextView textView = new TextView(TabMenuPopView.this.mContext);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(TabMenuPopView.this.mContext, R.dimen.fontsize28));
                com.baidu.tbadk.core.util.ap.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0106, 1);
                textView.setGravity(17);
                textView.setOnClickListener(TabMenuPopView.this);
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: i */
            public void destroyObject(TextView textView) {
                if (textView != null) {
                    textView.setText("");
                    textView.setTag(null);
                    textView.setSelected(false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: j */
            public TextView activateObject(TextView textView) {
                if (textView != null) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0106, 1);
                }
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: k */
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
                    TabMenuPopView.this.fXB.returnObject((TextView) view2);
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
            setMeasuredDimension(getMeasuredWidth(), co((getChildAt(0).getMeasuredHeight() * this.jlv) + (this.jlt * (this.jlv - 1)) + (this.jlt * 2), i2));
        }
    }

    private int co(int i, int i2) {
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
        int childCount = getChildCount();
        if (childCount > 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = getChildAt(0).getMeasuredWidth();
            if (this.jlu > 1) {
                this.jls = (measuredWidth - (measuredWidth2 * this.jlu)) / (this.jlu - 1);
            }
            int[] iArr = new int[this.jlv + 1];
            int i8 = 1;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = getChildAt(i11);
                int measuredWidth3 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = i10 + measuredWidth3;
                int i13 = i9 + measuredHeight;
                if (this.jlx != null && i11 == 0) {
                    i5 = 0;
                    i7 = i13 + (this.jlt * 2);
                    if (measuredHeight > iArr[i8]) {
                        iArr[i8] = measuredHeight;
                    }
                    i8++;
                    i6 = i9;
                } else if (i12 > i3) {
                    if (measuredHeight > iArr[i8]) {
                        iArr[i8] = measuredHeight;
                    }
                    i10 = 0;
                    int i14 = iArr[i8] + i9 + this.jlt;
                    i12 = 0 + measuredWidth3;
                    i13 = i14 + measuredHeight;
                    i5 = i12 + this.jls;
                    i8++;
                    i6 = i14;
                    i7 = i14;
                } else {
                    if (measuredHeight > iArr[i8]) {
                        iArr[i8] = measuredHeight;
                    }
                    i5 = i12 + this.jls;
                    i6 = i9;
                    i7 = i9;
                }
                if (i12 > i3) {
                    i12 = i3;
                }
                childAt.layout(i10, i6, i12, i13);
                i11++;
                i10 = i5;
                i9 = i7;
            }
        }
    }

    private void setData(List<bc> list) {
        int i = 0;
        if (list != null) {
            removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
            if (this.jlx != null) {
                if (dk(list)) {
                    this.jlx.isSelected = false;
                } else {
                    this.jlx.isSelected = true;
                }
                this.jlv = ((int) Math.ceil(list.size() / this.jlu)) + 1;
                a(this.jlx, layoutParams);
            } else {
                this.jlv = (int) Math.ceil(list.size() / this.jlu);
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

    private boolean dk(List<bc> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected) {
                return true;
            }
        }
        return false;
    }

    private void a(bc bcVar, LinearLayout.LayoutParams layoutParams) {
        if (bcVar != null && layoutParams != null) {
            TextView borrowObject = this.fXB.borrowObject();
            borrowObject.setText(bcVar.name);
            borrowObject.setSelected(bcVar.isSelected);
            borrowObject.setTag(bcVar);
            addView(borrowObject, layoutParams);
        }
    }

    public void setData(List<ab> list, ab abVar, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    bc bcVar = new bc();
                    bcVar.jkF = list.get(i3).jkF;
                    bcVar.name = list.get(i3).name;
                    if (i == list.get(i3).jkF) {
                        bcVar.isSelected = true;
                    }
                    arrayList.add(bcVar);
                }
                i2 = i3 + 1;
            }
            bc bcVar2 = null;
            if (abVar != null) {
                bcVar2 = new bc();
                bcVar2.jkF = abVar.jkF;
                bcVar2.name = abVar.name;
                if (i == abVar.jkF) {
                    bcVar2.isSelected = true;
                }
            }
            setData(arrayList, bcVar2);
        }
    }

    public void setData(List<bc> list, bc bcVar) {
        this.jlx = bcVar;
        setData(list);
    }

    public void setViewVerticalMargin(int i) {
        this.jlt = i;
    }

    public void setPerLineViewNum(int i) {
        if (i > 0) {
            this.jlu = i;
        }
    }

    public void setOnItemClickCallBack(a aVar) {
        this.jlw = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof bc) {
            cER();
            bc bcVar = (bc) view.getTag();
            setItemSelectState(bcVar, true);
            view.setSelected(true);
            if (this.jlw != null) {
                this.jlw.a(view, bcVar);
            }
        }
    }

    public void cER() {
        if (this.mDataList != null && getChildCount() > 0) {
            if (this.jlx != null) {
                this.jlx.isSelected = false;
            }
            for (bc bcVar : this.mDataList) {
                bcVar.isSelected = false;
            }
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setSelected(false);
            }
        }
    }

    public void setItemSelectState(bc bcVar, boolean z) {
        if (bcVar != null && this.mDataList != null) {
            if (this.jlx != null && this.jlx.jkF == bcVar.jkF) {
                this.jlx.isSelected = z;
                return;
            }
            for (bc bcVar2 : this.mDataList) {
                if (bcVar.jkF == bcVar2.jkF) {
                    bcVar.isSelected = z;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void bup() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this, R.color.CAM_X0201);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof TextView) {
                    TextView textView = (TextView) getChildAt(i2);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(textView, R.color.CAM_X0106, 1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
