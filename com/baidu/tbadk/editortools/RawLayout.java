package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class RawLayout extends ViewGroup {
    private static final Pattern fEm = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> fEn;
    private final List<View> fEo;
    private int[] fEp;
    private int fEq;
    private int fEr;
    protected final int[] fEs;
    private final List<View> mMiddleGroup;

    public RawLayout(Context context) {
        this(context, null, 0);
    }

    public RawLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RawLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEn = new ArrayList();
        this.mMiddleGroup = new ArrayList();
        this.fEo = new ArrayList();
        this.fEp = new int[]{0, 0, 0};
        this.fEs = new int[3];
        parseAttrs(context, attributeSet);
    }

    private void parseAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RawLayout);
        String string = obtainStyledAttributes.getString(R.styleable.RawLayout_rawOrientation);
        if (string == null) {
            string = HorizontalTranslateLayout.HORIZONTAL;
        }
        if (fEm.matcher(string).matches()) {
            this.fEp = new int[3];
            String[] split = string.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split.length == 1) {
                int orientationStrToI = orientationStrToI(split[0]);
                for (int i = 0; i < this.fEp.length; i++) {
                    this.fEp[i] = orientationStrToI;
                }
            } else if (split.length > 1) {
                if (this.fEp.length != split.length) {
                    throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.fEp.length; i2++) {
                    this.fEp[i2] = orientationStrToI(split[i2]);
                }
            }
        }
        this.fEq = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RawLayout_spacingTop, 0);
        this.fEr = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RawLayout_spacingBottom, 0);
        obtainStyledAttributes.recycle();
    }

    private int orientationStrToI(String str) {
        return VerticalTranslateLayout.VERTICAL.equals(str) ? 1 : 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        addViewToGroup(view, layoutParams2.fEt);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        addViewToGroup(view, layoutParams2.fEt);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        removeViewFromGroup(view, ((LayoutParams) view.getLayoutParams()).fEt);
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
        this.fEn.clear();
        this.mMiddleGroup.clear();
        this.fEo.clear();
    }

    private void addViewToGroup(View view, int i) {
        switch (i) {
            case 1:
                if (!this.fEn.contains(view)) {
                    this.fEn.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.mMiddleGroup.contains(view)) {
                    this.mMiddleGroup.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.fEo.contains(view)) {
                    this.fEo.add(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void removeViewFromGroup(View view, int i) {
        switch (i) {
            case 1:
                this.fEn.remove(view);
                return;
            case 2:
                this.mMiddleGroup.remove(view);
                return;
            case 3:
                this.fEo.remove(view);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int max;
        int max2;
        int i4 = i & 1073741823;
        int i5 = i & (-1073741824);
        int i6 = i2 & 1073741823;
        int i7 = i2 & (-1073741824);
        int i8 = i4 + i5;
        int i9 = this.fEq + this.fEr;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.fEn) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
                measureChildWithMargins(view, i8, i14 + i9, i2, i12);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int populateWidthByOrientation = populateWidthByOrientation(i14, measuredWidth, this.fEp[0]);
                i12 = populateHeightByOrientation(i12, measuredHeight, this.fEp[0]);
                if (i7 != 0 && i12 >= i6) {
                    setMeasuredDimension(populateWidthByOrientation, this.fEq + i12);
                    this.fEs[0] = i12;
                    this.fEs[1] = -1;
                    this.fEs[2] = -1;
                    return;
                }
                i14 = populateWidthByOrientation;
            }
        }
        this.fEs[0] = i12;
        int i15 = 0;
        for (View view2 : this.fEo) {
            if (view2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i11, i2, i15 + i12 + i9);
                int measuredWidth2 = view2.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
                int measuredHeight2 = layoutParams2.bottomMargin + view2.getMeasuredHeight() + layoutParams2.topMargin;
                i11 = populateWidthByOrientation(i11, measuredWidth2, this.fEp[2]);
                int populateHeightByOrientation = populateHeightByOrientation(i15, measuredHeight2, this.fEp[2]);
                if (i7 != 0 && populateHeightByOrientation > i6 - i12) {
                    setMeasuredDimension(Math.max(i14, i11), i12 + populateHeightByOrientation + this.fEq + this.fEr);
                    this.fEs[2] = populateHeightByOrientation;
                    this.fEs[1] = -1;
                    return;
                }
                i15 = populateHeightByOrientation;
            }
        }
        this.fEs[2] = i15;
        float f = 0.0f;
        if (this.fEp[1] != 0) {
            i3 = 0;
        } else {
            i3 = 0;
            for (View view3 : this.mMiddleGroup) {
                if (view3.getVisibility() != 8) {
                    LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                    f += layoutParams3.weight;
                    if (i5 != 1073741824 || layoutParams3.weight <= 0.0f) {
                        measureChildWithMargins(view3, i8, f == 0.0f ? i3 : 0, i2, 0);
                        max2 = Math.max(i3, layoutParams3.rightMargin + view3.getMeasuredWidth() + i3 + layoutParams3.leftMargin);
                    } else {
                        max2 = layoutParams3.rightMargin + layoutParams3.leftMargin + i3;
                    }
                    i3 = max2;
                }
            }
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
        int resolveSize = View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i8) - paddingLeft;
        switch (i7) {
            case Integer.MIN_VALUE:
                int i16 = (((i6 - i12) - i15) - this.fEq) - this.fEr;
                int i17 = resolveSize;
                int i18 = 0;
                int i19 = 0;
                for (View view4 : this.mMiddleGroup) {
                    if (view4.getVisibility() != 8) {
                        LayoutParams layoutParams4 = (LayoutParams) view4.getLayoutParams();
                        LayoutParams generateDefaultLayoutParams2 = layoutParams4 == null ? generateDefaultLayoutParams() : layoutParams4;
                        if (i17 != 0 && f > 0.0f && generateDefaultLayoutParams2.weight > 0.0f) {
                            generateDefaultLayoutParams2.width = (int) ((generateDefaultLayoutParams2.weight * i17) / f);
                            f -= generateDefaultLayoutParams2.weight;
                            i17 -= generateDefaultLayoutParams2.width;
                        }
                        int i20 = i17;
                        measureChildWithMargins(view4, i8, 0, i2, i18 + i12 + i15 + i9);
                        int measuredWidth3 = view4.getMeasuredWidth() + generateDefaultLayoutParams2.leftMargin + generateDefaultLayoutParams2.rightMargin;
                        int measuredHeight3 = generateDefaultLayoutParams2.bottomMargin + view4.getMeasuredHeight() + generateDefaultLayoutParams2.topMargin;
                        i19 = populateWidthByOrientation(i19, measuredWidth3, this.fEp[1]);
                        i17 = i20;
                        i18 = populateHeightByOrientation(i18, measuredHeight3, this.fEp[1]);
                    }
                }
                i13 = Math.min(i18, i16);
                i10 = i19;
                break;
            case 0:
                int i21 = resolveSize;
                for (View view5 : this.mMiddleGroup) {
                    LayoutParams layoutParams5 = (LayoutParams) view5.getLayoutParams();
                    LayoutParams generateDefaultLayoutParams3 = layoutParams5 == null ? generateDefaultLayoutParams() : layoutParams5;
                    if (i21 != 0 && f > 0.0f && generateDefaultLayoutParams3.weight > 0.0f) {
                        generateDefaultLayoutParams3.width = (int) ((generateDefaultLayoutParams3.weight * i21) / f);
                        f -= generateDefaultLayoutParams3.weight;
                        i21 -= generateDefaultLayoutParams3.width;
                    }
                    int i22 = i21;
                    measureChild(view5, i4, i6);
                    int measuredWidth4 = view5.getMeasuredWidth() + generateDefaultLayoutParams3.leftMargin + generateDefaultLayoutParams3.rightMargin;
                    int measuredHeight4 = view5.getMeasuredHeight() + generateDefaultLayoutParams3.topMargin + generateDefaultLayoutParams3.bottomMargin;
                    i10 = populateWidthByOrientation(i10, measuredWidth4, this.fEp[1]);
                    i13 = populateHeightByOrientation(i13, measuredHeight4, this.fEp[1]);
                    i21 = i22;
                }
                break;
            case 1073741824:
                int paddingTop = ((((i6 - i12) - i15) - i9) - getPaddingTop()) - getPaddingBottom();
                int i23 = resolveSize;
                for (View view6 : this.mMiddleGroup) {
                    if (view6.getVisibility() != 8) {
                        LayoutParams layoutParams6 = (LayoutParams) view6.getLayoutParams();
                        LayoutParams generateDefaultLayoutParams4 = layoutParams6 == null ? generateDefaultLayoutParams() : layoutParams6;
                        if (i23 != 0 && f > 0.0f && generateDefaultLayoutParams4.weight > 0.0f) {
                            generateDefaultLayoutParams4.width = (int) ((generateDefaultLayoutParams4.weight * i23) / f);
                            f -= generateDefaultLayoutParams4.weight;
                            i23 -= generateDefaultLayoutParams4.width;
                        }
                        measureChildWithMargins(view6, i8, 0, i2, i12 + i15 + i9);
                        paddingTop = populateHeightByOrientation(paddingTop, view6.getMeasuredHeight() + generateDefaultLayoutParams4.topMargin + generateDefaultLayoutParams4.bottomMargin, this.fEp[1]);
                        i23 = i23;
                    }
                }
                i13 = paddingTop;
                break;
        }
        this.fEs[1] = i13;
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
        setMeasuredDimension(max, i12 + i13 + i15 + this.fEq + this.fEr + getPaddingTop() + getPaddingBottom());
    }

    private int populateWidthByOrientation(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int populateHeightByOrientation(int i, int i2, int i3) {
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
        if (this.fEs[0] != -1) {
            a(this.fEn, paddingLeft, paddingTop, this.fEs[0]);
            int i5 = paddingTop + this.fEs[0] + this.fEq;
            if (this.fEs[1] != -1) {
                a(this.mMiddleGroup, paddingLeft, i5, this.fEs[1]);
                int i6 = i5 + this.fEs[1] + this.fEr;
                if (this.fEs[2] != -1) {
                    a(this.fEo, paddingLeft, i6, this.fEs[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4 = this.fEp[0];
        int measuredWidth = getMeasuredWidth();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
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
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public int fEt;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fEt = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RawLayout);
            this.fEt = obtainStyledAttributes.getInt(R.styleable.RawLayout_layout_raw, 0);
            obtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = 51;
            }
        }

        public LayoutParams() {
            super(-2, -2);
            this.fEt = 0;
            this.gravity = 51;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.fEt = 0;
            this.gravity = 51;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.fEt = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.fEt = 0;
            this.gravity = i3;
            this.fEt = i4;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.fEt = 0;
        }

        public void sx(int i) {
            this.fEt = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: bEY */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 19, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
