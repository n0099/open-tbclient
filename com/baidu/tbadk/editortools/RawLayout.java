package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class RawLayout extends ViewGroup {
    public static final Pattern l = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f13852e;

    /* renamed from: f  reason: collision with root package name */
    public final List<View> f13853f;

    /* renamed from: g  reason: collision with root package name */
    public final List<View> f13854g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f13855h;
    public int i;
    public int j;
    public final int[] k;

    public RawLayout(Context context) {
        this(context, null, 0);
    }

    public final void a(View view, int i) {
        if (i == 1) {
            if (this.f13852e.contains(view)) {
                return;
            }
            this.f13852e.add(view);
        } else if (i != 2) {
            if (i == 3 && !this.f13854g.contains(view)) {
                this.f13854g.add(view);
            }
        } else if (this.f13853f.contains(view)) {
        } else {
            this.f13853f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        a(view, layoutParams2.f13856a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 19, 0);
    }

    public final void c(List<View> list, int i, int i2, int i3) {
        int measuredHeight;
        int i4;
        int measuredWidth;
        int i5;
        int i6 = this.f13855h[0];
        int measuredWidth2 = getMeasuredWidth();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                int i7 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                int i8 = i6 == 1 ? i7 & 7 : i7 & 112;
                if (i8 == 1) {
                    int i9 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    measuredHeight = view.getMeasuredHeight() + i9;
                    view.layout(((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth()) >> 1) + i, i9, ((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) + view.getMeasuredWidth()) >> 1) + i, measuredHeight);
                    i4 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i8 == 3) {
                    int i10 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    int i11 = i + i10;
                    int i12 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    int measuredWidth3 = i10 + i + view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight() + i12;
                    view.layout(i11, i12, measuredWidth3, measuredHeight);
                    i4 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i8 != 5) {
                    if (i8 == 16) {
                        int i13 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i13;
                        view.layout(i13, ((((i3 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight()) >> 1) + i2, measuredWidth, ((((i3 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) + view.getMeasuredHeight()) >> 1) + i2);
                        i5 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i8 == 48) {
                        int i14 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        int measuredWidth4 = view.getMeasuredWidth() + i14;
                        view.layout(i14, ((LinearLayout.LayoutParams) layoutParams).topMargin + i2, measuredWidth4, ((LinearLayout.LayoutParams) layoutParams).topMargin + i2 + view.getMeasuredHeight());
                        i = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i8 == 80) {
                        int i15 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        int i16 = i2 + i3;
                        int measuredHeight2 = (i16 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight();
                        measuredWidth = view.getMeasuredWidth() + i15;
                        view.layout(i15, measuredHeight2, measuredWidth, i16 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                        i5 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i = measuredWidth + i5;
                } else {
                    int i17 = i + measuredWidth2;
                    int measuredWidth5 = (i17 - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth();
                    int i18 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    int i19 = i17 - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    measuredHeight = view.getMeasuredHeight() + i18;
                    view.layout(measuredWidth5, i18, i19, measuredHeight);
                    i4 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                i2 = measuredHeight + i4;
            }
        }
    }

    public final int d(String str) {
        return "vertical".equals(str) ? 1 : 0;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RawLayout);
        String string = obtainStyledAttributes.getString(R$styleable.RawLayout_rawOrientation);
        if (string == null) {
            string = "horizontal";
        }
        if (l.matcher(string).matches()) {
            this.f13855h = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int d2 = d(split[0]);
                int i = 0;
                while (true) {
                    int[] iArr = this.f13855h;
                    if (i >= iArr.length) {
                        break;
                    }
                    iArr[i] = d2;
                    i++;
                }
            } else if (split.length > 1) {
                if (this.f13855h.length != split.length) {
                    throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                }
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.f13855h;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    iArr2[i2] = d(split[i2]);
                    i2++;
                }
            }
        }
        this.i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RawLayout_spacingTop, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RawLayout_spacingBottom, 0);
        obtainStyledAttributes.recycle();
    }

    public final int f(int i, int i2, int i3) {
        if (i3 == 1) {
            return i + i2;
        }
        if (i3 == 0) {
            return Math.max(i2, i);
        }
        return 0;
    }

    public final int g(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void h(View view, int i) {
        if (i == 1) {
            this.f13852e.remove(view);
        } else if (i == 2) {
            this.f13853f.remove(view);
        } else if (i != 3) {
        } else {
            this.f13854g.remove(view);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int[] iArr = this.k;
        if (iArr[0] == -1) {
            return;
        }
        c(this.f13852e, paddingLeft, paddingTop, iArr[0]);
        int[] iArr2 = this.k;
        int i5 = paddingTop + iArr2[0] + this.i;
        if (iArr2[1] == -1) {
            return;
        }
        c(this.f13853f, paddingLeft, i5, iArr2[1]);
        int[] iArr3 = this.k;
        int i6 = i5 + iArr3[1] + this.j;
        if (iArr3[2] == -1) {
            return;
        }
        c(this.f13854g, paddingLeft, i6, iArr3[2]);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = i & 1073741823;
        int i12 = i & (-1073741824);
        int i13 = i2 & 1073741823;
        int i14 = i2 & (-1073741824);
        int i15 = i11 + i12;
        int i16 = this.i + this.j;
        Iterator<View> it = this.f13852e.iterator();
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = 8;
            if (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    LayoutParams layoutParams2 = layoutParams;
                    Iterator<View> it2 = it;
                    measureChildWithMargins(next, i15, i17 + i16, i2, i18);
                    int measuredWidth = next.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredHeight = next.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    i17 = g(i17, measuredWidth, this.f13855h[0]);
                    i18 = f(i18, measuredHeight, this.f13855h[0]);
                    if (i14 != 0 && i18 >= i13) {
                        setMeasuredDimension(i17, this.i + i18);
                        int[] iArr = this.k;
                        iArr[0] = i18;
                        iArr[1] = -1;
                        iArr[2] = -1;
                        return;
                    }
                    it = it2;
                }
            } else {
                int i20 = i17;
                this.k[0] = i18;
                int i21 = 0;
                int i22 = 0;
                for (View view : this.f13854g) {
                    if (view.getVisibility() != i19) {
                        LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = generateDefaultLayoutParams();
                        }
                        LayoutParams layoutParams4 = layoutParams3;
                        int i23 = i11;
                        measureChildWithMargins(view, i15, i21, i2, i22 + i18 + i16);
                        int measuredWidth2 = view.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredHeight2 = view.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin;
                        i21 = g(i21, measuredWidth2, this.f13855h[2]);
                        i22 = f(i22, measuredHeight2, this.f13855h[2]);
                        if (i14 != 0 && i22 > i13 - i18) {
                            setMeasuredDimension(Math.max(i20, i21), i18 + i22 + this.i + this.j);
                            int[] iArr2 = this.k;
                            iArr2[2] = i22;
                            iArr2[1] = -1;
                            return;
                        }
                        i11 = i23;
                        i19 = 8;
                    }
                }
                int i24 = i21;
                int i25 = i11;
                int i26 = i22;
                this.k[2] = i26;
                int i27 = 1073741824;
                int i28 = 0;
                if (this.f13855h[1] == 0) {
                    f2 = 0.0f;
                    i6 = 0;
                    for (View view2 : this.f13853f) {
                        if (view2.getVisibility() != 8) {
                            LayoutParams layoutParams5 = (LayoutParams) view2.getLayoutParams();
                            float f3 = ((LinearLayout.LayoutParams) layoutParams5).weight;
                            float f4 = f2 + f3;
                            if (i12 == i27 && f3 > 0.0f) {
                                i6 += ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin;
                                i10 = i20;
                                i9 = i24;
                            } else {
                                i9 = i24;
                                int i29 = i6;
                                i10 = i20;
                                measureChildWithMargins(view2, i15, f4 == 0.0f ? i6 : 0, i2, 0);
                                i6 = Math.max(i29, i29 + view2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin);
                            }
                            f2 = f4;
                            i24 = i9;
                            i20 = i10;
                            i27 = 1073741824;
                        }
                    }
                    i3 = i20;
                    i4 = i24;
                    i5 = 1073741824;
                } else {
                    i3 = i20;
                    i4 = i24;
                    i5 = 1073741824;
                    f2 = 0.0f;
                    i6 = 0;
                }
                int paddingLeft = i6 + getPaddingLeft() + getPaddingRight();
                int resolveSize = View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i15) - paddingLeft;
                if (i14 == Integer.MIN_VALUE) {
                    i7 = i25;
                    int i30 = (((i13 - i18) - i26) - this.i) - this.j;
                    Iterator<View> it3 = this.f13853f.iterator();
                    int i31 = 0;
                    int i32 = 0;
                    while (it3.hasNext()) {
                        View next2 = it3.next();
                        if (next2.getVisibility() != 8) {
                            LayoutParams layoutParams6 = (LayoutParams) next2.getLayoutParams();
                            if (layoutParams6 == null) {
                                layoutParams6 = generateDefaultLayoutParams();
                            }
                            if (resolveSize != 0 && f2 > 0.0f) {
                                float f5 = ((LinearLayout.LayoutParams) layoutParams6).weight;
                                if (f5 > 0.0f) {
                                    int i33 = (int) ((resolveSize * f5) / f2);
                                    ((LinearLayout.LayoutParams) layoutParams6).width = i33;
                                    f2 -= f5;
                                    resolveSize -= i33;
                                }
                            }
                            float f6 = f2;
                            int i34 = resolveSize;
                            Iterator<View> it4 = it3;
                            LayoutParams layoutParams7 = layoutParams6;
                            measureChildWithMargins(next2, i15, 0, i2, i31 + i18 + i26 + i16);
                            int measuredWidth3 = next2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin;
                            int measuredHeight3 = next2.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin;
                            i32 = g(i32, measuredWidth3, this.f13855h[1]);
                            i31 = f(i31, measuredHeight3, this.f13855h[1]);
                            f2 = f6;
                            resolveSize = i34;
                            it3 = it4;
                            i15 = i15;
                        }
                    }
                    i28 = Math.min(i31, i30);
                    i8 = i32;
                } else if (i14 != 0) {
                    if (i14 == i5) {
                        int paddingTop = ((((i13 - i18) - i26) - i16) - getPaddingTop()) - getPaddingBottom();
                        for (View view3 : this.f13853f) {
                            if (view3.getVisibility() != 8) {
                                LayoutParams layoutParams8 = (LayoutParams) view3.getLayoutParams();
                                if (layoutParams8 == null) {
                                    layoutParams8 = generateDefaultLayoutParams();
                                }
                                LayoutParams layoutParams9 = layoutParams8;
                                if (resolveSize != 0 && f2 > 0.0f) {
                                    float f7 = ((LinearLayout.LayoutParams) layoutParams9).weight;
                                    if (f7 > 0.0f) {
                                        int i35 = (int) ((resolveSize * f7) / f2);
                                        ((LinearLayout.LayoutParams) layoutParams9).width = i35;
                                        f2 -= f7;
                                        resolveSize -= i35;
                                    }
                                }
                                measureChildWithMargins(view3, i15, 0, i2, i18 + i26 + i16);
                                paddingTop = f(paddingTop, view3.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams9).topMargin + ((LinearLayout.LayoutParams) layoutParams9).bottomMargin, this.f13855h[1]);
                                f2 = f2;
                                resolveSize = resolveSize;
                            }
                        }
                        i28 = paddingTop;
                    }
                    i7 = i25;
                    i8 = 0;
                } else {
                    int i36 = 0;
                    i8 = 0;
                    for (View view4 : this.f13853f) {
                        LayoutParams layoutParams10 = (LayoutParams) view4.getLayoutParams();
                        if (layoutParams10 == null) {
                            layoutParams10 = generateDefaultLayoutParams();
                        }
                        if (resolveSize != 0 && f2 > 0.0f) {
                            float f8 = ((LinearLayout.LayoutParams) layoutParams10).weight;
                            if (f8 > 0.0f) {
                                int i37 = (int) ((resolveSize * f8) / f2);
                                ((LinearLayout.LayoutParams) layoutParams10).width = i37;
                                f2 -= f8;
                                resolveSize -= i37;
                            }
                        }
                        int i38 = i25;
                        measureChild(view4, i38, i13);
                        int measuredWidth4 = view4.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin;
                        int measuredHeight4 = view4.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin;
                        i8 = g(i8, measuredWidth4, this.f13855h[1]);
                        i36 = f(i36, measuredHeight4, this.f13855h[1]);
                        i25 = i38;
                    }
                    i7 = i25;
                    i28 = i36;
                }
                this.k[1] = i28;
                if (i12 == Integer.MIN_VALUE || i12 == 0) {
                    i7 = Math.max(Math.max(i3, i8), i4) + getPaddingLeft() + getPaddingRight();
                } else if (i12 != 1073741824) {
                    i7 = 0;
                }
                setMeasuredDimension(i7, i18 + i28 + i26 + this.i + this.j + getPaddingTop() + getPaddingBottom());
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f13852e.clear();
        this.f13853f.clear();
        this.f13854g.clear();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        h(view, ((LayoutParams) view.getLayoutParams()).f13856a);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
    }

    public RawLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public RawLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13852e = new ArrayList();
        this.f13853f = new ArrayList();
        this.f13854g = new ArrayList();
        this.f13855h = new int[]{0, 0, 0};
        this.k = new int[3];
        e(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        a(view, layoutParams2.f13856a);
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f13856a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13856a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RawLayout);
            this.f13856a = obtainStyledAttributes.getInt(R$styleable.RawLayout_layout_raw, 0);
            obtainStyledAttributes.recycle();
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 51;
            }
        }

        public void a(int i) {
            this.f13856a = i;
        }

        public LayoutParams() {
            super(-2, -2);
            this.f13856a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f13856a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f13856a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i3;
        }

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.f13856a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i3;
            this.f13856a = i4;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f13856a = 0;
        }
    }
}
