package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class RawLayout extends ViewGroup {
    private static final Pattern aDr = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> Dz;
    private final List<View> aDs;
    private final List<View> aDt;
    private int[] aDu;
    private int aDv;
    private int aDw;
    protected final int[] aDx;

    public RawLayout(Context context) {
        this(context, null, 0);
    }

    public RawLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RawLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDs = new ArrayList();
        this.Dz = new ArrayList();
        this.aDt = new ArrayList();
        this.aDu = new int[]{0, 0, 0};
        this.aDx = new int[3];
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.RawLayout);
        String string = obtainStyledAttributes.getString(d.m.RawLayout_rawOrientation);
        if (string == null) {
            string = "horizontal";
        }
        if (aDr.matcher(string).matches()) {
            this.aDu = new int[3];
            String[] split = string.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split.length == 1) {
                int bN = bN(split[0]);
                for (int i = 0; i < this.aDu.length; i++) {
                    this.aDu[i] = bN;
                }
            } else if (split.length > 1) {
                if (this.aDu.length != split.length) {
                    throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.aDu.length; i2++) {
                    this.aDu[i2] = bN(split[i2]);
                }
            }
        }
        this.aDv = obtainStyledAttributes.getDimensionPixelSize(d.m.RawLayout_spacingTop, 0);
        this.aDw = obtainStyledAttributes.getDimensionPixelSize(d.m.RawLayout_spacingBottom, 0);
        obtainStyledAttributes.recycle();
    }

    private int bN(String str) {
        return "vertical".equals(str) ? 1 : 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view2, i, layoutParams);
        a aVar = (a) view2.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view2, aVar.aDy);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view2, layoutParams);
        a aVar = (a) view2.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view2, aVar.aDy);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        super.removeView(view2);
        d(view2, ((a) view2.getLayoutParams()).aDy);
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
        this.aDs.clear();
        this.Dz.clear();
        this.aDt.clear();
    }

    private void c(View view2, int i) {
        switch (i) {
            case 1:
                if (!this.aDs.contains(view2)) {
                    this.aDs.add(view2);
                    return;
                }
                return;
            case 2:
                if (!this.Dz.contains(view2)) {
                    this.Dz.add(view2);
                    return;
                }
                return;
            case 3:
                if (!this.aDt.contains(view2)) {
                    this.aDt.add(view2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void d(View view2, int i) {
        switch (i) {
            case 1:
                this.aDs.remove(view2);
                return;
            case 2:
                this.Dz.remove(view2);
                return;
            case 3:
                this.aDt.remove(view2);
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
        int i9 = this.aDv + this.aDw;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view2 : this.aDs) {
            if (view2.getVisibility() != 8) {
                a aVar = (a) view2.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view2, i8, i14 + i9, i2, i12);
                int measuredWidth = view2.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view2.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int h = h(i14, measuredWidth, this.aDu[0]);
                i12 = i(i12, measuredHeight, this.aDu[0]);
                if (i7 != 0 && i12 >= i6) {
                    setMeasuredDimension(h, this.aDv + i12);
                    this.aDx[0] = i12;
                    this.aDx[1] = -1;
                    this.aDx[2] = -1;
                    return;
                }
                i14 = h;
            }
        }
        this.aDx[0] = i12;
        int i15 = 0;
        for (View view3 : this.aDt) {
            if (view3.getVisibility() != 8) {
                a aVar2 = (a) view3.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view3, i8, i11, i2, i15 + i12 + i9);
                int measuredWidth2 = view3.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = aVar2.bottomMargin + view3.getMeasuredHeight() + aVar2.topMargin;
                i11 = h(i11, measuredWidth2, this.aDu[2]);
                int i16 = i(i15, measuredHeight2, this.aDu[2]);
                if (i7 != 0 && i16 > i6 - i12) {
                    setMeasuredDimension(Math.max(i14, i11), i12 + i16 + this.aDv + this.aDw);
                    this.aDx[2] = i16;
                    this.aDx[1] = -1;
                    return;
                }
                i15 = i16;
            }
        }
        this.aDx[2] = i15;
        if (this.aDu[1] != 0) {
            f = 0.0f;
            i3 = 0;
        } else {
            f = 0.0f;
            i3 = 0;
            for (View view4 : this.Dz) {
                if (view4.getVisibility() != 8) {
                    a aVar3 = (a) view4.getLayoutParams();
                    f += aVar3.weight;
                    if (i5 != 1073741824 || aVar3.weight <= 0.0f) {
                        measureChildWithMargins(view4, i8, f == 0.0f ? i3 : 0, i2, 0);
                        max2 = Math.max(i3, aVar3.rightMargin + view4.getMeasuredWidth() + i3 + aVar3.leftMargin);
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
                int i17 = (((i6 - i12) - i15) - this.aDv) - this.aDw;
                int i18 = resolveSize;
                int i19 = 0;
                int i20 = 0;
                for (View view5 : this.Dz) {
                    if (view5.getVisibility() != 8) {
                        a aVar4 = (a) view5.getLayoutParams();
                        a generateDefaultLayoutParams2 = aVar4 == null ? generateDefaultLayoutParams() : aVar4;
                        if (i18 != 0 && f > 0.0f && generateDefaultLayoutParams2.weight > 0.0f) {
                            generateDefaultLayoutParams2.width = (int) ((generateDefaultLayoutParams2.weight * i18) / f);
                            f -= generateDefaultLayoutParams2.weight;
                            i18 -= generateDefaultLayoutParams2.width;
                        }
                        int i21 = i18;
                        measureChildWithMargins(view5, i8, 0, i2, i19 + i12 + i15 + i9);
                        int measuredWidth3 = view5.getMeasuredWidth() + generateDefaultLayoutParams2.leftMargin + generateDefaultLayoutParams2.rightMargin;
                        int measuredHeight3 = generateDefaultLayoutParams2.bottomMargin + view5.getMeasuredHeight() + generateDefaultLayoutParams2.topMargin;
                        int h2 = h(i20, measuredWidth3, this.aDu[1]);
                        i19 = i(i19, measuredHeight3, this.aDu[1]);
                        i20 = h2;
                        i18 = i21;
                    }
                }
                i13 = Math.min(i19, i17);
                i10 = i20;
                break;
            case 0:
                int i22 = resolveSize;
                for (View view6 : this.Dz) {
                    a aVar5 = (a) view6.getLayoutParams();
                    a generateDefaultLayoutParams3 = aVar5 == null ? generateDefaultLayoutParams() : aVar5;
                    if (i22 != 0 && f > 0.0f && generateDefaultLayoutParams3.weight > 0.0f) {
                        generateDefaultLayoutParams3.width = (int) ((generateDefaultLayoutParams3.weight * i22) / f);
                        f -= generateDefaultLayoutParams3.weight;
                        i22 -= generateDefaultLayoutParams3.width;
                    }
                    int i23 = i22;
                    measureChild(view6, i4, i6);
                    int measuredWidth4 = view6.getMeasuredWidth() + generateDefaultLayoutParams3.leftMargin + generateDefaultLayoutParams3.rightMargin;
                    int measuredHeight4 = view6.getMeasuredHeight() + generateDefaultLayoutParams3.topMargin + generateDefaultLayoutParams3.bottomMargin;
                    i10 = h(i10, measuredWidth4, this.aDu[1]);
                    i13 = i(i13, measuredHeight4, this.aDu[1]);
                    i22 = i23;
                }
                break;
            case 1073741824:
                int paddingTop = ((((i6 - i12) - i15) - i9) - getPaddingTop()) - getPaddingBottom();
                int i24 = paddingTop;
                int i25 = resolveSize;
                for (View view7 : this.Dz) {
                    if (view7.getVisibility() != 8) {
                        a aVar6 = (a) view7.getLayoutParams();
                        a generateDefaultLayoutParams4 = aVar6 == null ? generateDefaultLayoutParams() : aVar6;
                        if (i25 != 0 && f > 0.0f && generateDefaultLayoutParams4.weight > 0.0f) {
                            generateDefaultLayoutParams4.width = (int) ((generateDefaultLayoutParams4.weight * i25) / f);
                            f -= generateDefaultLayoutParams4.weight;
                            i25 -= generateDefaultLayoutParams4.width;
                        }
                        measureChildWithMargins(view7, i8, 0, i2, i12 + i15 + i9);
                        i24 = i(i24, view7.getMeasuredHeight() + generateDefaultLayoutParams4.topMargin + generateDefaultLayoutParams4.bottomMargin, this.aDu[1]);
                        i25 = i25;
                    }
                }
                i13 = i24;
                break;
        }
        this.aDx[1] = i13;
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
        setMeasuredDimension(max, i12 + i13 + i15 + this.aDv + this.aDw + getPaddingTop() + getPaddingBottom());
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
        if (this.aDx[0] != -1) {
            a(this.aDs, paddingLeft, paddingTop, this.aDx[0]);
            int i5 = paddingTop + this.aDx[0] + this.aDv;
            if (this.aDx[1] != -1) {
                a(this.Dz, paddingLeft, i5, this.aDx[1]);
                int i6 = i5 + this.aDx[1] + this.aDw;
                if (this.aDx[2] != -1) {
                    a(this.aDt, paddingLeft, i6, this.aDx[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4 = this.aDu[0];
        int measuredWidth = getMeasuredWidth();
        for (View view2 : list) {
            if (view2.getVisibility() != 8) {
                a aVar = (a) view2.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                switch (i4 == 1 ? generateDefaultLayoutParams.gravity & 7 : generateDefaultLayoutParams.gravity & 112) {
                    case 1:
                        int i5 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredHeight = view2.getMeasuredHeight() + i5;
                        view2.layout(((((measuredWidth - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) - view2.getMeasuredWidth()) >> 1) + i, i5, ((((measuredWidth - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) + view2.getMeasuredWidth()) >> 1) + i, measuredHeight);
                        i2 = measuredHeight + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 3:
                        int i6 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredWidth2 = generateDefaultLayoutParams.leftMargin + i + view2.getMeasuredWidth();
                        int measuredHeight2 = view2.getMeasuredHeight() + i6;
                        view2.layout(generateDefaultLayoutParams.leftMargin + i, i6, measuredWidth2, measuredHeight2);
                        i2 = measuredHeight2 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 5:
                        int measuredWidth3 = ((i + measuredWidth) - generateDefaultLayoutParams.rightMargin) - view2.getMeasuredWidth();
                        int i7 = generateDefaultLayoutParams.topMargin + i2;
                        int i8 = (i + measuredWidth) - generateDefaultLayoutParams.rightMargin;
                        int measuredHeight3 = view2.getMeasuredHeight() + i7;
                        view2.layout(measuredWidth3, i7, i8, measuredHeight3);
                        i2 = measuredHeight3 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 16:
                        int i9 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth4 = view2.getMeasuredWidth() + i9;
                        view2.layout(i9, ((((i3 - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) - view2.getMeasuredHeight()) >> 1) + i2, measuredWidth4, ((((i3 - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) + view2.getMeasuredHeight()) >> 1) + i2);
                        i = measuredWidth4 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 48:
                        int i10 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth5 = view2.getMeasuredWidth() + i10;
                        view2.layout(i10, generateDefaultLayoutParams.topMargin + i2, measuredWidth5, generateDefaultLayoutParams.topMargin + i2 + view2.getMeasuredHeight());
                        i = measuredWidth5 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 80:
                        int i11 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredHeight4 = ((i2 + i3) - generateDefaultLayoutParams.bottomMargin) - view2.getMeasuredHeight();
                        int measuredWidth6 = view2.getMeasuredWidth() + i11;
                        view2.layout(i11, measuredHeight4, measuredWidth6, (i2 + i3) - generateDefaultLayoutParams.bottomMargin);
                        i = measuredWidth6 + generateDefaultLayoutParams.rightMargin;
                        continue;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public int aDy;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.aDy = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.RawLayout);
            this.aDy = obtainStyledAttributes.getInt(d.m.RawLayout_layout_raw, 0);
            obtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = 51;
            }
        }

        public a() {
            super(-2, -2);
            this.aDy = 0;
            this.gravity = 51;
        }

        public a(int i, int i2) {
            super(i, i2);
            this.aDy = 0;
            this.gravity = 51;
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.aDy = 0;
            this.gravity = i3;
        }

        public a(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.aDy = 0;
            this.gravity = i3;
            this.aDy = i4;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.aDy = 0;
        }

        public void eJ(int i) {
            this.aDy = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: DR */
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
