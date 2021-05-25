package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r0.c0;
import d.a.n0.r0.e1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f15183e;

    /* renamed from: f  reason: collision with root package name */
    public int f15184f;

    /* renamed from: g  reason: collision with root package name */
    public int f15185g;

    /* renamed from: h  reason: collision with root package name */
    public int f15186h;

    /* renamed from: i  reason: collision with root package name */
    public c f15187i;
    public List<e1> j;
    public d.a.c.e.k.b<TextView> k;
    public Context l;
    public e1 m;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.k.c<TextView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TextView c(TextView textView) {
            TextView textView2 = textView;
            h(textView2);
            return textView2;
        }

        public TextView e(TextView textView) {
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            }
            return textView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(TextView textView) {
            if (textView != null) {
                textView.setText("");
                textView.setTag(null);
                textView.setSelected(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TextView d() {
            TextView textView = new TextView(TabMenuPopView.this.l);
            textView.setTextSize(0, l.g(TabMenuPopView.this.l, R.dimen.fontsize28));
            SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            textView.setGravity(17);
            textView.setOnClickListener(TabMenuPopView.this);
            return textView;
        }

        public TextView h(TextView textView) {
            if (textView != null) {
                textView.setText("");
                textView.setTag(null);
                textView.setSelected(false);
            }
            return textView;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewGroup.OnHierarchyChangeListener {
        public b() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view2 instanceof TextView) {
                TabMenuPopView.this.k.e((TextView) view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, e1 e1Var);
    }

    public TabMenuPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15183e = 2;
        this.f15184f = 2;
        this.f15185g = 4;
        this.f15186h = 5;
        setOrientation(1);
        this.l = context;
        this.f15184f = l.g(context, R.dimen.ds20);
        this.k = new d.a.c.e.k.b<>(new a(), 17, 0);
        setOnHierarchyChangeListener(new b());
    }

    private void setData(List<e1> list) {
        if (list == null) {
            return;
        }
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds150), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60));
        if (this.m != null) {
            if (f(list)) {
                this.m.f58450c = false;
            } else {
                this.m.f58450c = true;
            }
            this.f15186h = ((int) Math.ceil(list.size() / this.f15185g)) + 1;
            c(this.m, layoutParams);
        } else {
            this.f15186h = (int) Math.ceil(list.size() / this.f15185g);
        }
        this.j = list;
        for (int i2 = 0; i2 < list.size(); i2++) {
            c(list.get(i2), layoutParams);
        }
    }

    public final void c(e1 e1Var, LinearLayout.LayoutParams layoutParams) {
        if (e1Var == null || layoutParams == null) {
            return;
        }
        TextView b2 = this.k.b();
        b2.setText(e1Var.f58448a);
        b2.setSelected(e1Var.f58450c);
        b2.setTag(e1Var);
        addView(b2, layoutParams);
    }

    public void d() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof TextView) {
                TextView textView = (TextView) getChildAt(i2);
                SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final int e(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return i2;
            }
        } else if (size > i2) {
            return i2;
        }
        return size;
    }

    public final boolean f(List<e1> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f58450c) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        if (this.j == null || getChildCount() <= 0) {
            return;
        }
        e1 e1Var = this.m;
        if (e1Var != null) {
            e1Var.f58450c = false;
        }
        for (e1 e1Var2 : this.j) {
            e1Var2.f58450c = false;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setSelected(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof e1) {
            g();
            e1 e1Var = (e1) view.getTag();
            setItemSelectState(e1Var, true);
            view.setSelected(true);
            c cVar = this.f15187i;
            if (cVar != null) {
                cVar.a(view, e1Var);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = getChildAt(0).getMeasuredWidth();
        int i10 = this.f15185g;
        int i11 = 1;
        if (i10 > 1) {
            this.f15183e = (measuredWidth - (measuredWidth2 * i10)) / (i10 - 1);
        }
        int[] iArr = new int[this.f15186h + 1];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            int measuredWidth3 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i15 = i13 + measuredWidth3;
            int i16 = i14 + measuredHeight;
            if (this.m != null && i12 == 0) {
                i9 = (this.f15184f * 2) + i16;
                if (measuredHeight > iArr[i11]) {
                    iArr[i11] = measuredHeight;
                }
                i6 = i14;
                i7 = i11 + 1;
                i8 = i13;
                i13 = 0;
            } else if (i15 > i4) {
                if (measuredHeight > iArr[i11]) {
                    iArr[i11] = measuredHeight;
                }
                int i17 = i14 + iArr[i11] + this.f15184f;
                i15 = measuredWidth3 + 0;
                i16 = i17 + measuredHeight;
                i13 = this.f15183e + i15;
                i9 = i17;
                i6 = i9;
                i7 = i11 + 1;
                i8 = 0;
            } else {
                if (measuredHeight > iArr[i11]) {
                    iArr[i11] = measuredHeight;
                }
                i6 = i14;
                i7 = i11;
                i8 = i13;
                i13 = this.f15183e + i15;
                i9 = i6;
            }
            if (i15 > i4) {
                i15 = i4;
            }
            childAt.layout(i8, i6, i15, i16);
            i12++;
            i11 = i7;
            i14 = i9;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getChildCount() > 0) {
            int measuredHeight = getChildAt(0).getMeasuredHeight();
            int i4 = this.f15186h;
            int i5 = this.f15184f;
            setMeasuredDimension(getMeasuredWidth(), e((measuredHeight * i4) + ((i4 - 1) * i5) + (i5 * 2), i3));
        }
    }

    public void setItemSelectState(e1 e1Var, boolean z) {
        if (e1Var == null || this.j == null) {
            return;
        }
        e1 e1Var2 = this.m;
        if (e1Var2 != null && e1Var2.f58449b == e1Var.f58449b) {
            e1Var2.f58450c = z;
            return;
        }
        for (e1 e1Var3 : this.j) {
            if (e1Var.f58449b == e1Var3.f58449b) {
                e1Var.f58450c = z;
                return;
            }
        }
    }

    public void setOnItemClickCallBack(c cVar) {
        this.f15187i = cVar;
    }

    public void setPerLineViewNum(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f15185g = i2;
    }

    public void setViewVerticalMargin(int i2) {
        this.f15184f = i2;
    }

    public void setData(List<c0> list, c0 c0Var, int i2) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) != null) {
                e1 e1Var = new e1();
                e1Var.f58449b = list.get(i3).f58406b;
                e1Var.f58448a = list.get(i3).f58405a;
                if (i2 == list.get(i3).f58406b) {
                    e1Var.f58450c = true;
                }
                arrayList.add(e1Var);
            }
        }
        e1 e1Var2 = null;
        if (c0Var != null) {
            e1Var2 = new e1();
            int i4 = c0Var.f58406b;
            e1Var2.f58449b = i4;
            e1Var2.f58448a = c0Var.f58405a;
            if (i2 == i4) {
                e1Var2.f58450c = true;
            }
        }
        setData(arrayList, e1Var2);
    }

    public void setData(List<e1> list, e1 e1Var) {
        this.m = e1Var;
        setData(list);
    }
}
