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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes3.dex */
public class RawLayout extends ViewGroup {
    public static final Pattern l = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f12900e;

    /* renamed from: f  reason: collision with root package name */
    public final List<View> f12901f;

    /* renamed from: g  reason: collision with root package name */
    public final List<View> f12902g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f12903h;

    /* renamed from: i  reason: collision with root package name */
    public int f12904i;
    public int j;
    public final int[] k;

    public RawLayout(Context context) {
        this(context, null, 0);
    }

    public final void a(View view, int i2) {
        if (i2 == 1) {
            if (this.f12900e.contains(view)) {
                return;
            }
            this.f12900e.add(view);
        } else if (i2 != 2) {
            if (i2 == 3 && !this.f12902g.contains(view)) {
                this.f12902g.add(view);
            }
        } else if (this.f12901f.contains(view)) {
        } else {
            this.f12901f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        a(view, layoutParams2.f12905a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 19, 0);
    }

    public final void c(List<View> list, int i2, int i3, int i4) {
        int measuredHeight;
        int i5;
        int measuredWidth;
        int i6;
        int i7 = this.f12903h[0];
        int measuredWidth2 = getMeasuredWidth();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                int i8 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                int i9 = i7 == 1 ? i8 & 7 : i8 & 112;
                if (i9 == 1) {
                    int i10 = i3 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    measuredHeight = view.getMeasuredHeight() + i10;
                    view.layout(((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth()) >> 1) + i2, i10, ((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) + view.getMeasuredWidth()) >> 1) + i2, measuredHeight);
                    i5 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i9 == 3) {
                    int i11 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    int i12 = i2 + i11;
                    int i13 = i3 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    int measuredWidth3 = i11 + i2 + view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight() + i13;
                    view.layout(i12, i13, measuredWidth3, measuredHeight);
                    i5 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i9 != 5) {
                    if (i9 == 16) {
                        int i14 = i2 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i14;
                        view.layout(i14, ((((i4 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight()) >> 1) + i3, measuredWidth, ((((i4 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) + view.getMeasuredHeight()) >> 1) + i3);
                        i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i9 == 48) {
                        int i15 = i2 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        int measuredWidth4 = view.getMeasuredWidth() + i15;
                        view.layout(i15, ((LinearLayout.LayoutParams) layoutParams).topMargin + i3, measuredWidth4, ((LinearLayout.LayoutParams) layoutParams).topMargin + i3 + view.getMeasuredHeight());
                        i2 = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i9 == 80) {
                        int i16 = i2 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        int i17 = i3 + i4;
                        int measuredHeight2 = (i17 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight();
                        measuredWidth = view.getMeasuredWidth() + i16;
                        view.layout(i16, measuredHeight2, measuredWidth, i17 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                        i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i2 = measuredWidth + i6;
                } else {
                    int i18 = i2 + measuredWidth2;
                    int measuredWidth5 = (i18 - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth();
                    int i19 = i3 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    int i20 = i18 - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    measuredHeight = view.getMeasuredHeight() + i19;
                    view.layout(measuredWidth5, i19, i20, measuredHeight);
                    i5 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                i3 = measuredHeight + i5;
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
            this.f12903h = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int d2 = d(split[0]);
                int i2 = 0;
                while (true) {
                    int[] iArr = this.f12903h;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    iArr[i2] = d2;
                    i2++;
                }
            } else if (split.length > 1) {
                if (this.f12903h.length != split.length) {
                    throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                }
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.f12903h;
                    if (i3 >= iArr2.length) {
                        break;
                    }
                    iArr2[i3] = d(split[i3]);
                    i3++;
                }
            }
        }
        this.f12904i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RawLayout_spacingTop, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RawLayout_spacingBottom, 0);
        obtainStyledAttributes.recycle();
    }

    public final int f(int i2, int i3, int i4) {
        if (i4 == 1) {
            return i2 + i3;
        }
        if (i4 == 0) {
            return Math.max(i3, i2);
        }
        return 0;
    }

    public final int g(int i2, int i3, int i4) {
        if (i4 == 1) {
            return Math.max(i3, i2);
        }
        if (i4 == 0) {
            return i2 + i3;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void h(View view, int i2) {
        if (i2 == 1) {
            this.f12900e.remove(view);
        } else if (i2 == 2) {
            this.f12901f.remove(view);
        } else if (i2 != 3) {
        } else {
            this.f12902g.remove(view);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int[] iArr = this.k;
        if (iArr[0] == -1) {
            return;
        }
        c(this.f12900e, paddingLeft, paddingTop, iArr[0]);
        int[] iArr2 = this.k;
        int i6 = paddingTop + iArr2[0] + this.f12904i;
        if (iArr2[1] == -1) {
            return;
        }
        c(this.f12901f, paddingLeft, i6, iArr2[1]);
        int[] iArr3 = this.k;
        int i7 = i6 + iArr3[1] + this.j;
        if (iArr3[2] == -1) {
            return;
        }
        c(this.f12902g, paddingLeft, i7, iArr3[2]);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i13 = i2 & (-1073741824);
        int i14 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i15 = i3 & (-1073741824);
        int i16 = i12 + i13;
        int i17 = this.f12904i + this.j;
        Iterator<View> it = this.f12900e.iterator();
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i20 = 8;
            if (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    LayoutParams layoutParams2 = layoutParams;
                    Iterator<View> it2 = it;
                    measureChildWithMargins(next, i16, i18 + i17, i3, i19);
                    int measuredWidth = next.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredHeight = next.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    i18 = g(i18, measuredWidth, this.f12903h[0]);
                    i19 = f(i19, measuredHeight, this.f12903h[0]);
                    if (i15 != 0 && i19 >= i14) {
                        setMeasuredDimension(i18, this.f12904i + i19);
                        int[] iArr = this.k;
                        iArr[0] = i19;
                        iArr[1] = -1;
                        iArr[2] = -1;
                        return;
                    }
                    it = it2;
                }
            } else {
                int i21 = i18;
                this.k[0] = i19;
                int i22 = 0;
                int i23 = 0;
                for (View view : this.f12902g) {
                    if (view.getVisibility() != i20) {
                        LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = generateDefaultLayoutParams();
                        }
                        LayoutParams layoutParams4 = layoutParams3;
                        int i24 = i12;
                        measureChildWithMargins(view, i16, i22, i3, i23 + i19 + i17);
                        int measuredWidth2 = view.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredHeight2 = view.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin;
                        i22 = g(i22, measuredWidth2, this.f12903h[2]);
                        i23 = f(i23, measuredHeight2, this.f12903h[2]);
                        if (i15 != 0 && i23 > i14 - i19) {
                            setMeasuredDimension(Math.max(i21, i22), i19 + i23 + this.f12904i + this.j);
                            int[] iArr2 = this.k;
                            iArr2[2] = i23;
                            iArr2[1] = -1;
                            return;
                        }
                        i12 = i24;
                        i20 = 8;
                    }
                }
                int i25 = i22;
                int i26 = i12;
                int i27 = i23;
                this.k[2] = i27;
                int i28 = 1073741824;
                int i29 = 0;
                if (this.f12903h[1] == 0) {
                    f2 = 0.0f;
                    i7 = 0;
                    for (View view2 : this.f12901f) {
                        if (view2.getVisibility() != 8) {
                            LayoutParams layoutParams5 = (LayoutParams) view2.getLayoutParams();
                            float f3 = ((LinearLayout.LayoutParams) layoutParams5).weight;
                            float f4 = f2 + f3;
                            if (i13 == i28 && f3 > 0.0f) {
                                i7 += ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin;
                                i11 = i21;
                                i10 = i25;
                            } else {
                                i10 = i25;
                                int i30 = i7;
                                i11 = i21;
                                measureChildWithMargins(view2, i16, f4 == 0.0f ? i7 : 0, i3, 0);
                                i7 = Math.max(i30, i30 + view2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin);
                            }
                            f2 = f4;
                            i25 = i10;
                            i21 = i11;
                            i28 = 1073741824;
                        }
                    }
                    i4 = i21;
                    i5 = i25;
                    i6 = 1073741824;
                } else {
                    i4 = i21;
                    i5 = i25;
                    i6 = 1073741824;
                    f2 = 0.0f;
                    i7 = 0;
                }
                int paddingLeft = i7 + getPaddingLeft() + getPaddingRight();
                int resolveSize = View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i16) - paddingLeft;
                if (i15 == Integer.MIN_VALUE) {
                    i8 = i26;
                    int i31 = (((i14 - i19) - i27) - this.f12904i) - this.j;
                    Iterator<View> it3 = this.f12901f.iterator();
                    int i32 = 0;
                    int i33 = 0;
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
                                    int i34 = (int) ((resolveSize * f5) / f2);
                                    ((LinearLayout.LayoutParams) layoutParams6).width = i34;
                                    f2 -= f5;
                                    resolveSize -= i34;
                                }
                            }
                            float f6 = f2;
                            int i35 = resolveSize;
                            Iterator<View> it4 = it3;
                            LayoutParams layoutParams7 = layoutParams6;
                            measureChildWithMargins(next2, i16, 0, i3, i32 + i19 + i27 + i17);
                            int measuredWidth3 = next2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin;
                            int measuredHeight3 = next2.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin;
                            i33 = g(i33, measuredWidth3, this.f12903h[1]);
                            i32 = f(i32, measuredHeight3, this.f12903h[1]);
                            f2 = f6;
                            resolveSize = i35;
                            it3 = it4;
                            i16 = i16;
                        }
                    }
                    i29 = Math.min(i32, i31);
                    i9 = i33;
                } else if (i15 != 0) {
                    if (i15 == i6) {
                        int paddingTop = ((((i14 - i19) - i27) - i17) - getPaddingTop()) - getPaddingBottom();
                        for (View view3 : this.f12901f) {
                            if (view3.getVisibility() != 8) {
                                LayoutParams layoutParams8 = (LayoutParams) view3.getLayoutParams();
                                if (layoutParams8 == null) {
                                    layoutParams8 = generateDefaultLayoutParams();
                                }
                                LayoutParams layoutParams9 = layoutParams8;
                                if (resolveSize != 0 && f2 > 0.0f) {
                                    float f7 = ((LinearLayout.LayoutParams) layoutParams9).weight;
                                    if (f7 > 0.0f) {
                                        int i36 = (int) ((resolveSize * f7) / f2);
                                        ((LinearLayout.LayoutParams) layoutParams9).width = i36;
                                        f2 -= f7;
                                        resolveSize -= i36;
                                    }
                                }
                                measureChildWithMargins(view3, i16, 0, i3, i19 + i27 + i17);
                                paddingTop = f(paddingTop, view3.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams9).topMargin + ((LinearLayout.LayoutParams) layoutParams9).bottomMargin, this.f12903h[1]);
                                f2 = f2;
                                resolveSize = resolveSize;
                            }
                        }
                        i29 = paddingTop;
                    }
                    i8 = i26;
                    i9 = 0;
                } else {
                    int i37 = 0;
                    i9 = 0;
                    for (View view4 : this.f12901f) {
                        LayoutParams layoutParams10 = (LayoutParams) view4.getLayoutParams();
                        if (layoutParams10 == null) {
                            layoutParams10 = generateDefaultLayoutParams();
                        }
                        if (resolveSize != 0 && f2 > 0.0f) {
                            float f8 = ((LinearLayout.LayoutParams) layoutParams10).weight;
                            if (f8 > 0.0f) {
                                int i38 = (int) ((resolveSize * f8) / f2);
                                ((LinearLayout.LayoutParams) layoutParams10).width = i38;
                                f2 -= f8;
                                resolveSize -= i38;
                            }
                        }
                        int i39 = i26;
                        measureChild(view4, i39, i14);
                        int measuredWidth4 = view4.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin;
                        int measuredHeight4 = view4.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin;
                        i9 = g(i9, measuredWidth4, this.f12903h[1]);
                        i37 = f(i37, measuredHeight4, this.f12903h[1]);
                        i26 = i39;
                    }
                    i8 = i26;
                    i29 = i37;
                }
                this.k[1] = i29;
                if (i13 == Integer.MIN_VALUE || i13 == 0) {
                    i8 = Math.max(Math.max(i4, i9), i5) + getPaddingLeft() + getPaddingRight();
                } else if (i13 != 1073741824) {
                    i8 = 0;
                }
                setMeasuredDimension(i8, i19 + i29 + i27 + this.f12904i + this.j + getPaddingTop() + getPaddingBottom());
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f12900e.clear();
        this.f12901f.clear();
        this.f12902g.clear();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        h(view, ((LayoutParams) view.getLayoutParams()).f12905a);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
    }

    public RawLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public RawLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12900e = new ArrayList();
        this.f12901f = new ArrayList();
        this.f12902g = new ArrayList();
        this.f12903h = new int[]{0, 0, 0};
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
        a(view, layoutParams2.f12905a);
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f12905a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12905a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RawLayout);
            this.f12905a = obtainStyledAttributes.getInt(R$styleable.RawLayout_layout_raw, 0);
            obtainStyledAttributes.recycle();
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 51;
            }
        }

        public void a(int i2) {
            this.f12905a = i2;
        }

        public LayoutParams() {
            super(-2, -2);
            this.f12905a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f12905a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            this.f12905a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i4;
        }

        public LayoutParams(int i2, int i3, int i4, int i5) {
            super(i2, i3);
            this.f12905a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i4;
            this.f12905a = i5;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12905a = 0;
        }
    }
}
