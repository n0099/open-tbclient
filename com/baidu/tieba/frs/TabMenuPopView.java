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
import d.b.b.e.p.l;
import d.b.i0.p0.c0;
import d.b.i0.p0.e1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class TabMenuPopView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f16117e;

    /* renamed from: f  reason: collision with root package name */
    public int f16118f;

    /* renamed from: g  reason: collision with root package name */
    public int f16119g;

    /* renamed from: h  reason: collision with root package name */
    public int f16120h;
    public c i;
    public List<e1> j;
    public d.b.b.e.k.b<TextView> k;
    public Context l;
    public e1 m;

    /* loaded from: classes4.dex */
    public class a implements d.b.b.e.k.c<TextView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
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
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(TextView textView) {
            if (textView != null) {
                textView.setText("");
                textView.setTag(null);
                textView.setSelected(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
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
        this.f16117e = 2;
        this.f16118f = 2;
        this.f16119g = 4;
        this.f16120h = 5;
        setOrientation(1);
        this.l = context;
        this.f16118f = l.g(context, R.dimen.ds20);
        this.k = new d.b.b.e.k.b<>(new a(), 17, 0);
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
                this.m.f57403c = false;
            } else {
                this.m.f57403c = true;
            }
            this.f16120h = ((int) Math.ceil(list.size() / this.f16119g)) + 1;
            c(this.m, layoutParams);
        } else {
            this.f16120h = (int) Math.ceil(list.size() / this.f16119g);
        }
        this.j = list;
        for (int i = 0; i < list.size(); i++) {
            c(list.get(i), layoutParams);
        }
    }

    public final void c(e1 e1Var, LinearLayout.LayoutParams layoutParams) {
        if (e1Var == null || layoutParams == null) {
            return;
        }
        TextView b2 = this.k.b();
        b2.setText(e1Var.f57401a);
        b2.setSelected(e1Var.f57403c);
        b2.setTag(e1Var);
        addView(b2, layoutParams);
    }

    public void d() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof TextView) {
                TextView textView = (TextView) getChildAt(i);
                SkinManager.setBackgroundResource(textView, R.drawable.bg_tab_meun);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final int e(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return i;
            }
        } else if (size > i) {
            return i;
        }
        return size;
    }

    public final boolean f(List<e1> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).f57403c) {
                return true;
            }
        }
        return false;
    }

    public void h() {
        if (this.j == null || getChildCount() <= 0) {
            return;
        }
        e1 e1Var = this.m;
        if (e1Var != null) {
            e1Var.f57403c = false;
        }
        for (e1 e1Var2 : this.j) {
            e1Var2.f57403c = false;
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setSelected(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof e1) {
            h();
            e1 e1Var = (e1) view.getTag();
            setItemSelectState(e1Var, true);
            view.setSelected(true);
            c cVar = this.i;
            if (cVar != null) {
                cVar.a(view, e1Var);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = getChildAt(0).getMeasuredWidth();
        int i9 = this.f16119g;
        int i10 = 1;
        if (i9 > 1) {
            this.f16117e = (measuredWidth - (measuredWidth2 * i9)) / (i9 - 1);
        }
        int[] iArr = new int[this.f16120h + 1];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            int measuredWidth3 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i14 = i12 + measuredWidth3;
            int i15 = i13 + measuredHeight;
            if (this.m != null && i11 == 0) {
                i8 = (this.f16118f * 2) + i15;
                if (measuredHeight > iArr[i10]) {
                    iArr[i10] = measuredHeight;
                }
                i5 = i13;
                i6 = i10 + 1;
                i7 = i12;
                i12 = 0;
            } else if (i14 > i3) {
                if (measuredHeight > iArr[i10]) {
                    iArr[i10] = measuredHeight;
                }
                int i16 = i13 + iArr[i10] + this.f16118f;
                i14 = measuredWidth3 + 0;
                i15 = i16 + measuredHeight;
                i12 = this.f16117e + i14;
                i8 = i16;
                i5 = i8;
                i6 = i10 + 1;
                i7 = 0;
            } else {
                if (measuredHeight > iArr[i10]) {
                    iArr[i10] = measuredHeight;
                }
                i5 = i13;
                i6 = i10;
                i7 = i12;
                i12 = this.f16117e + i14;
                i8 = i5;
            }
            if (i14 > i3) {
                i14 = i3;
            }
            childAt.layout(i7, i5, i14, i15);
            i11++;
            i10 = i6;
            i13 = i8;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            int measuredHeight = getChildAt(0).getMeasuredHeight();
            int i3 = this.f16120h;
            int i4 = this.f16118f;
            setMeasuredDimension(getMeasuredWidth(), e((measuredHeight * i3) + ((i3 - 1) * i4) + (i4 * 2), i2));
        }
    }

    public void setItemSelectState(e1 e1Var, boolean z) {
        if (e1Var == null || this.j == null) {
            return;
        }
        e1 e1Var2 = this.m;
        if (e1Var2 != null && e1Var2.f57402b == e1Var.f57402b) {
            e1Var2.f57403c = z;
            return;
        }
        for (e1 e1Var3 : this.j) {
            if (e1Var.f57402b == e1Var3.f57402b) {
                e1Var.f57403c = z;
                return;
            }
        }
    }

    public void setOnItemClickCallBack(c cVar) {
        this.i = cVar;
    }

    public void setPerLineViewNum(int i) {
        if (i <= 0) {
            return;
        }
        this.f16119g = i;
    }

    public void setViewVerticalMargin(int i) {
        this.f16118f = i;
    }

    public void setData(List<c0> list, c0 c0Var, int i) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) != null) {
                e1 e1Var = new e1();
                e1Var.f57402b = list.get(i2).f57361b;
                e1Var.f57401a = list.get(i2).f57360a;
                if (i == list.get(i2).f57361b) {
                    e1Var.f57403c = true;
                }
                arrayList.add(e1Var);
            }
        }
        e1 e1Var2 = null;
        if (c0Var != null) {
            e1Var2 = new e1();
            int i3 = c0Var.f57361b;
            e1Var2.f57402b = i3;
            e1Var2.f57401a = c0Var.f57360a;
            if (i == i3) {
                e1Var2.f57403c = true;
            }
        }
        setData(arrayList, e1Var2);
    }

    public void setData(List<e1> list, e1 e1Var) {
        this.m = e1Var;
        setData(list);
    }
}
