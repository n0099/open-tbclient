package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends ViewGroup {
    private static final Pattern aBR = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> Fr;
    private final List<View> aBS;
    private final List<View> aBT;
    private int[] aBU;
    private int aBV;
    private int aBW;
    protected final int[] aBX;

    public p(Context context) {
        this(context, null, 0);
    }

    public p(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBS = new ArrayList();
        this.Fr = new ArrayList();
        this.aBT = new ArrayList();
        this.aBU = new int[]{0, 0, 0};
        this.aBX = new int[3];
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.RawLayout);
        String string = obtainStyledAttributes.getString(d.n.RawLayout_rawOrientation);
        if (string == null) {
            string = "horizontal";
        }
        if (aBR.matcher(string).matches()) {
            this.aBU = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int bI = bI(split[0]);
                for (int i = 0; i < this.aBU.length; i++) {
                    this.aBU[i] = bI;
                }
            } else if (split.length > 1) {
                if (this.aBU.length != split.length) {
                    throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.aBU.length; i2++) {
                    this.aBU[i2] = bI(split[i2]);
                }
            }
        }
        this.aBV = obtainStyledAttributes.getDimensionPixelSize(d.n.RawLayout_spacingTop, 0);
        this.aBW = obtainStyledAttributes.getDimensionPixelSize(d.n.RawLayout_spacingBottom, 0);
        obtainStyledAttributes.recycle();
    }

    private int bI(String str) {
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
        c(view, aVar.aBY);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        a aVar = (a) view.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view, aVar.aBY);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        d(view, ((a) view.getLayoutParams()).aBY);
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
        this.aBS.clear();
        this.Fr.clear();
        this.aBT.clear();
    }

    private void c(View view, int i) {
        switch (i) {
            case 1:
                if (!this.aBS.contains(view)) {
                    this.aBS.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.Fr.contains(view)) {
                    this.Fr.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.aBT.contains(view)) {
                    this.aBT.add(view);
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
                this.aBS.remove(view);
                return;
            case 2:
                this.Fr.remove(view);
                return;
            case 3:
                this.aBT.remove(view);
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
        int i9 = this.aBV + this.aBW;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.aBS) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i12);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int i15 = i(i14, measuredWidth, this.aBU[0]);
                i12 = j(i12, measuredHeight, this.aBU[0]);
                if (i7 != 0 && i12 >= i6) {
                    setMeasuredDimension(i15, this.aBV + i12);
                    this.aBX[0] = i12;
                    this.aBX[1] = -1;
                    this.aBX[2] = -1;
                    return;
                }
                i14 = i15;
            }
        }
        this.aBX[0] = i12;
        int i16 = 0;
        for (View view2 : this.aBT) {
            if (view2.getVisibility() != 8) {
                a aVar2 = (a) view2.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i11, i2, i16 + i12 + i9);
                int measuredWidth2 = view2.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = aVar2.bottomMargin + view2.getMeasuredHeight() + aVar2.topMargin;
                i11 = i(i11, measuredWidth2, this.aBU[2]);
                int j = j(i16, measuredHeight2, this.aBU[2]);
                if (i7 != 0 && j > i6 - i12) {
                    setMeasuredDimension(Math.max(i14, i11), i12 + j + this.aBV + this.aBW);
                    this.aBX[2] = j;
                    this.aBX[1] = -1;
                    return;
                }
                i16 = j;
            }
        }
        this.aBX[2] = i16;
        if (this.aBU[1] != 0) {
            f = 0.0f;
            i3 = 0;
        } else {
            f = 0.0f;
            i3 = 0;
            for (View view3 : this.Fr) {
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
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int i17 = (((i6 - i12) - i16) - this.aBV) - this.aBW;
                int i18 = resolveSize;
                int i19 = 0;
                int i20 = 0;
                for (View view4 : this.Fr) {
                    if (view4.getVisibility() != 8) {
                        a aVar4 = (a) view4.getLayoutParams();
                        a generateDefaultLayoutParams2 = aVar4 == null ? generateDefaultLayoutParams() : aVar4;
                        if (i18 != 0 && f > 0.0f && generateDefaultLayoutParams2.weight > 0.0f) {
                            generateDefaultLayoutParams2.width = (int) ((generateDefaultLayoutParams2.weight * i18) / f);
                            f -= generateDefaultLayoutParams2.weight;
                            i18 -= generateDefaultLayoutParams2.width;
                        }
                        int i21 = i18;
                        measureChildWithMargins(view4, i8, 0, i2, i19 + i12 + i16 + i9);
                        int measuredWidth3 = view4.getMeasuredWidth() + generateDefaultLayoutParams2.leftMargin + generateDefaultLayoutParams2.rightMargin;
                        int measuredHeight3 = generateDefaultLayoutParams2.bottomMargin + view4.getMeasuredHeight() + generateDefaultLayoutParams2.topMargin;
                        int i22 = i(i20, measuredWidth3, this.aBU[1]);
                        i19 = j(i19, measuredHeight3, this.aBU[1]);
                        i20 = i22;
                        i18 = i21;
                    }
                }
                i13 = Math.min(i19, i17);
                i10 = i20;
                break;
            case 0:
                int i23 = resolveSize;
                for (View view5 : this.Fr) {
                    a aVar5 = (a) view5.getLayoutParams();
                    a generateDefaultLayoutParams3 = aVar5 == null ? generateDefaultLayoutParams() : aVar5;
                    if (i23 != 0 && f > 0.0f && generateDefaultLayoutParams3.weight > 0.0f) {
                        generateDefaultLayoutParams3.width = (int) ((generateDefaultLayoutParams3.weight * i23) / f);
                        f -= generateDefaultLayoutParams3.weight;
                        i23 -= generateDefaultLayoutParams3.width;
                    }
                    int i24 = i23;
                    measureChild(view5, i4, i6);
                    int measuredWidth4 = view5.getMeasuredWidth() + generateDefaultLayoutParams3.leftMargin + generateDefaultLayoutParams3.rightMargin;
                    int measuredHeight4 = view5.getMeasuredHeight() + generateDefaultLayoutParams3.topMargin + generateDefaultLayoutParams3.bottomMargin;
                    i10 = i(i10, measuredWidth4, this.aBU[1]);
                    i13 = j(i13, measuredHeight4, this.aBU[1]);
                    i23 = i24;
                }
                break;
            case 1073741824:
                int paddingTop = ((((i6 - i12) - i16) - i9) - getPaddingTop()) - getPaddingBottom();
                int i25 = paddingTop;
                int i26 = resolveSize;
                for (View view6 : this.Fr) {
                    if (view6.getVisibility() != 8) {
                        a aVar6 = (a) view6.getLayoutParams();
                        a generateDefaultLayoutParams4 = aVar6 == null ? generateDefaultLayoutParams() : aVar6;
                        if (i26 != 0 && f > 0.0f && generateDefaultLayoutParams4.weight > 0.0f) {
                            generateDefaultLayoutParams4.width = (int) ((generateDefaultLayoutParams4.weight * i26) / f);
                            f -= generateDefaultLayoutParams4.weight;
                            i26 -= generateDefaultLayoutParams4.width;
                        }
                        measureChildWithMargins(view6, i8, 0, i2, i12 + i16 + i9);
                        i25 = j(i25, view6.getMeasuredHeight() + generateDefaultLayoutParams4.topMargin + generateDefaultLayoutParams4.bottomMargin, this.aBU[1]);
                        i26 = i26;
                    }
                }
                i13 = i25;
                break;
        }
        this.aBX[1] = i13;
        switch (i5) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
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
        setMeasuredDimension(max, i12 + i13 + i16 + this.aBV + this.aBW + getPaddingTop() + getPaddingBottom());
    }

    private int i(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int j(int i, int i2, int i3) {
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
        if (this.aBX[0] != -1) {
            a(this.aBS, paddingLeft, paddingTop, this.aBX[0]);
            int i5 = paddingTop + this.aBX[0] + this.aBV;
            if (this.aBX[1] != -1) {
                a(this.Fr, paddingLeft, i5, this.aBX[1]);
                int i6 = i5 + this.aBX[1] + this.aBW;
                if (this.aBX[2] != -1) {
                    a(this.aBT, paddingLeft, i6, this.aBX[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4 = this.aBU[0];
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
                    case d.n.View_onClick /* 48 */:
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
        public int aBY;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.aBY = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.RawLayout);
            this.aBY = obtainStyledAttributes.getInt(d.n.RawLayout_layout_raw, 0);
            obtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = 51;
            }
        }

        public a() {
            super(-2, -2);
            this.aBY = 0;
            this.gravity = 51;
        }

        public a(int i, int i2) {
            super(i, i2);
            this.aBY = 0;
            this.gravity = 51;
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.aBY = 0;
            this.gravity = i3;
        }

        public a(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.aBY = 0;
            this.gravity = i3;
            this.aBY = i4;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.aBY = 0;
        }

        public void eG(int i) {
            this.aBY = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: Dh */
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
