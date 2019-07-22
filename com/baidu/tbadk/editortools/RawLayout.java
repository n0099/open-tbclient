package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.c;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class RawLayout extends ViewGroup {
    private static final Pattern csz = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> KR;
    private final List<View> csA;
    private final List<View> csB;
    private int[] csC;
    private int csD;
    private int csE;
    protected final int[] csF;

    public RawLayout(Context context) {
        this(context, null, 0);
    }

    public RawLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RawLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csA = new ArrayList();
        this.KR = new ArrayList();
        this.csB = new ArrayList();
        this.csC = new int[]{0, 0, 0};
        this.csF = new int[3];
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.RawLayout);
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "horizontal";
        }
        if (csz.matcher(string).matches()) {
            this.csC = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int ce = ce(split[0]);
                for (int i = 0; i < this.csC.length; i++) {
                    this.csC[i] = ce;
                }
            } else if (split.length > 1) {
                if (this.csC.length != split.length) {
                    throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.csC.length; i2++) {
                    this.csC[i2] = ce(split[i2]);
                }
            }
        }
        this.csD = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.csE = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    private int ce(String str) {
        return "vertical".equals(str) ? 1 : 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        a aVar = (a) view.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view, aVar.csG);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        a aVar = (a) view.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view, aVar.csG);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        d(view, ((a) view.getLayoutParams()).csG);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.csA.clear();
        this.KR.clear();
        this.csB.clear();
    }

    private void c(View view, int i) {
        switch (i) {
            case 1:
                if (!this.csA.contains(view)) {
                    this.csA.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.KR.contains(view)) {
                    this.KR.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.csB.contains(view)) {
                    this.csB.add(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void d(View view, int i) {
        switch (i) {
            case 1:
                this.csA.remove(view);
                return;
            case 2:
                this.KR.remove(view);
                return;
            case 3:
                this.csB.remove(view);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        int i3;
        int max;
        int max2;
        int i4 = i & 1073741823;
        int i5 = i & (-1073741824);
        int i6 = i2 & 1073741823;
        int i7 = i2 & (-1073741824);
        int i8 = i4 + i5;
        int i9 = this.csD + this.csE;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.csA) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i12);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int h = h(i14, measuredWidth, this.csC[0]);
                i12 = i(i12, measuredHeight, this.csC[0]);
                if (i7 != 0 && i12 >= i6) {
                    setMeasuredDimension(h, this.csD + i12);
                    this.csF[0] = i12;
                    this.csF[1] = -1;
                    this.csF[2] = -1;
                    return;
                }
                i14 = h;
            }
        }
        this.csF[0] = i12;
        int i15 = 0;
        for (View view2 : this.csB) {
            if (view2.getVisibility() != 8) {
                a aVar2 = (a) view2.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i11, i2, i15 + i12 + i9);
                int measuredWidth2 = view2.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = aVar2.bottomMargin + view2.getMeasuredHeight() + aVar2.topMargin;
                i11 = h(i11, measuredWidth2, this.csC[2]);
                int i16 = i(i15, measuredHeight2, this.csC[2]);
                if (i7 != 0 && i16 > i6 - i12) {
                    setMeasuredDimension(Math.max(i14, i11), i12 + i16 + this.csD + this.csE);
                    this.csF[2] = i16;
                    this.csF[1] = -1;
                    return;
                }
                i15 = i16;
            }
        }
        this.csF[2] = i15;
        if (this.csC[1] != 0) {
            f = 0.0f;
            i3 = 0;
        } else {
            f = 0.0f;
            i3 = 0;
            for (View view3 : this.KR) {
                if (view3.getVisibility() != 8) {
                    a aVar3 = (a) view3.getLayoutParams();
                    f += aVar3.weight;
                    if (i5 != 1073741824 || aVar3.weight <= 0.0f) {
                        measureChildWithMargins(view3, i8, f == 0.0f ? i3 : 0, i2, 0);
                        max2 = Math.max(i3, aVar3.rightMargin + view3.getMeasuredWidth() + i3 + aVar3.leftMargin);
                    } else {
                        max2 = aVar3.rightMargin + aVar3.leftMargin + i3;
                    }
                    i3 = max2;
                }
            }
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
        int resolveSize = View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i8) - paddingLeft;
        switch (i7) {
            case Integer.MIN_VALUE:
                int i17 = (((i6 - i12) - i15) - this.csD) - this.csE;
                int i18 = resolveSize;
                int i19 = 0;
                int i20 = 0;
                for (View view4 : this.KR) {
                    if (view4.getVisibility() != 8) {
                        a aVar4 = (a) view4.getLayoutParams();
                        a generateDefaultLayoutParams2 = aVar4 == null ? generateDefaultLayoutParams() : aVar4;
                        if (i18 != 0 && f > 0.0f && generateDefaultLayoutParams2.weight > 0.0f) {
                            generateDefaultLayoutParams2.width = (int) ((generateDefaultLayoutParams2.weight * i18) / f);
                            f -= generateDefaultLayoutParams2.weight;
                            i18 -= generateDefaultLayoutParams2.width;
                        }
                        int i21 = i18;
                        measureChildWithMargins(view4, i8, 0, i2, i19 + i12 + i15 + i9);
                        int measuredWidth3 = view4.getMeasuredWidth() + generateDefaultLayoutParams2.leftMargin + generateDefaultLayoutParams2.rightMargin;
                        int measuredHeight3 = generateDefaultLayoutParams2.bottomMargin + view4.getMeasuredHeight() + generateDefaultLayoutParams2.topMargin;
                        int h2 = h(i20, measuredWidth3, this.csC[1]);
                        i19 = i(i19, measuredHeight3, this.csC[1]);
                        i20 = h2;
                        i18 = i21;
                    }
                }
                i13 = Math.min(i19, i17);
                i10 = i20;
                break;
            case 0:
                int i22 = resolveSize;
                for (View view5 : this.KR) {
                    a aVar5 = (a) view5.getLayoutParams();
                    a generateDefaultLayoutParams3 = aVar5 == null ? generateDefaultLayoutParams() : aVar5;
                    if (i22 != 0 && f > 0.0f && generateDefaultLayoutParams3.weight > 0.0f) {
                        generateDefaultLayoutParams3.width = (int) ((generateDefaultLayoutParams3.weight * i22) / f);
                        f -= generateDefaultLayoutParams3.weight;
                        i22 -= generateDefaultLayoutParams3.width;
                    }
                    int i23 = i22;
                    measureChild(view5, i4, i6);
                    int measuredWidth4 = view5.getMeasuredWidth() + generateDefaultLayoutParams3.leftMargin + generateDefaultLayoutParams3.rightMargin;
                    int measuredHeight4 = view5.getMeasuredHeight() + generateDefaultLayoutParams3.topMargin + generateDefaultLayoutParams3.bottomMargin;
                    i10 = h(i10, measuredWidth4, this.csC[1]);
                    i13 = i(i13, measuredHeight4, this.csC[1]);
                    i22 = i23;
                }
                break;
            case 1073741824:
                int paddingTop = ((((i6 - i12) - i15) - i9) - getPaddingTop()) - getPaddingBottom();
                int i24 = paddingTop;
                int i25 = resolveSize;
                for (View view6 : this.KR) {
                    if (view6.getVisibility() != 8) {
                        a aVar6 = (a) view6.getLayoutParams();
                        a generateDefaultLayoutParams4 = aVar6 == null ? generateDefaultLayoutParams() : aVar6;
                        if (i25 != 0 && f > 0.0f && generateDefaultLayoutParams4.weight > 0.0f) {
                            generateDefaultLayoutParams4.width = (int) ((generateDefaultLayoutParams4.weight * i25) / f);
                            f -= generateDefaultLayoutParams4.weight;
                            i25 -= generateDefaultLayoutParams4.width;
                        }
                        measureChildWithMargins(view6, i8, 0, i2, i12 + i15 + i9);
                        i24 = i(i24, view6.getMeasuredHeight() + generateDefaultLayoutParams4.topMargin + generateDefaultLayoutParams4.bottomMargin, this.csC[1]);
                        i25 = i25;
                    }
                }
                i13 = i24;
                break;
        }
        this.csF[1] = i13;
        switch (i5) {
            case Integer.MIN_VALUE:
            case 0:
                max = Math.max(Math.max(i14, i10), i11) + getPaddingLeft() + getPaddingRight();
                break;
            case 1073741824:
                max = i4;
                break;
            default:
                max = 0;
                break;
        }
        setMeasuredDimension(max, i12 + i13 + i15 + this.csD + this.csE + getPaddingTop() + getPaddingBottom());
    }

    private int h(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int i(int i, int i2, int i3) {
        if (i3 == 1) {
            return i + i2;
        }
        if (i3 == 0) {
            return Math.max(i2, i);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.csF[0] != -1) {
            a(this.csA, paddingLeft, paddingTop, this.csF[0]);
            int i5 = paddingTop + this.csF[0] + this.csD;
            if (this.csF[1] != -1) {
                a(this.KR, paddingLeft, i5, this.csF[1]);
                int i6 = i5 + this.csF[1] + this.csE;
                if (this.csF[2] != -1) {
                    a(this.csB, paddingLeft, i6, this.csF[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4 = this.csC[0];
        int measuredWidth = getMeasuredWidth();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                switch (i4 == 1 ? generateDefaultLayoutParams.gravity & 7 : generateDefaultLayoutParams.gravity & 112) {
                    case 1:
                        int i5 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredHeight = view.getMeasuredHeight() + i5;
                        view.layout(((((measuredWidth - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth()) >> 1) + i, i5, ((((measuredWidth - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) + view.getMeasuredWidth()) >> 1) + i, measuredHeight);
                        i2 = measuredHeight + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 3:
                        int i6 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredWidth2 = generateDefaultLayoutParams.leftMargin + i + view.getMeasuredWidth();
                        int measuredHeight2 = view.getMeasuredHeight() + i6;
                        view.layout(generateDefaultLayoutParams.leftMargin + i, i6, measuredWidth2, measuredHeight2);
                        i2 = measuredHeight2 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 5:
                        int measuredWidth3 = ((i + measuredWidth) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth();
                        int i7 = generateDefaultLayoutParams.topMargin + i2;
                        int i8 = (i + measuredWidth) - generateDefaultLayoutParams.rightMargin;
                        int measuredHeight3 = view.getMeasuredHeight() + i7;
                        view.layout(measuredWidth3, i7, i8, measuredHeight3);
                        i2 = measuredHeight3 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 16:
                        int i9 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth4 = view.getMeasuredWidth() + i9;
                        view.layout(i9, ((((i3 - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight()) >> 1) + i2, measuredWidth4, ((((i3 - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) + view.getMeasuredHeight()) >> 1) + i2);
                        i = measuredWidth4 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 48:
                        int i10 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth5 = view.getMeasuredWidth() + i10;
                        view.layout(i10, generateDefaultLayoutParams.topMargin + i2, measuredWidth5, generateDefaultLayoutParams.topMargin + i2 + view.getMeasuredHeight());
                        i = measuredWidth5 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 80:
                        int i11 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredHeight4 = ((i2 + i3) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight();
                        int measuredWidth6 = view.getMeasuredWidth() + i11;
                        view.layout(i11, measuredHeight4, measuredWidth6, (i2 + i3) - generateDefaultLayoutParams.bottomMargin);
                        i = measuredWidth6 + generateDefaultLayoutParams.rightMargin;
                        continue;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public int csG;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.csG = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.RawLayout);
            this.csG = obtainStyledAttributes.getInt(3, 0);
            obtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = 51;
            }
        }

        public a() {
            super(-2, -2);
            this.csG = 0;
            this.gravity = 51;
        }

        public a(int i, int i2) {
            super(i, i2);
            this.csG = 0;
            this.gravity = 51;
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.csG = 0;
            this.gravity = i3;
        }

        public a(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.csG = 0;
            this.gravity = i3;
            this.csG = i4;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.csG = 0;
        }

        public void kr(int i) {
            this.csG = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: asl */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2, 19, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }
}
