package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class y extends ViewGroup {
    private static final Pattern arI = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> arJ;
    private final List<View> arK;
    private int[] arL;
    private int arM;
    private int arN;
    protected final int[] arO;
    private final List<View> xc;

    public y(Context context) {
        this(context, null, 0);
    }

    public y(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arJ = new ArrayList();
        this.xc = new ArrayList();
        this.arK = new ArrayList();
        this.arL = new int[3];
        this.arO = new int[3];
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.RawLayout);
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "horizontal";
        }
        if (arI.matcher(string).matches()) {
            this.arL = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int bK = bK(split[0]);
                for (int i = 0; i < this.arL.length; i++) {
                    this.arL[i] = bK;
                }
            } else if (split.length > 1) {
                if (this.arL.length != split.length) {
                    throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.arL.length; i2++) {
                    this.arL[i2] = bK(split[i2]);
                }
            }
        }
        this.arM = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.arN = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
    }

    private int bK(String str) {
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
        c(view, aVar.arP);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        a aVar = (a) view.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view, aVar.arP);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        d(view, ((a) view.getLayoutParams()).arP);
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
        this.arJ.clear();
        this.xc.clear();
        this.arK.clear();
    }

    private void c(View view, int i) {
        switch (i) {
            case 1:
                if (!this.arJ.contains(view)) {
                    this.arJ.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.xc.contains(view)) {
                    this.xc.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.arK.contains(view)) {
                    this.arK.add(view);
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
                this.arJ.remove(view);
                return;
            case 2:
                this.xc.remove(view);
                return;
            case 3:
                this.arK.remove(view);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [489=5, 490=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        int i3;
        int max;
        int i4 = i & 1073741823;
        int i5 = i & (-1073741824);
        int i6 = i2 & 1073741823;
        int i7 = i2 & (-1073741824);
        int i8 = i4 + i5;
        int i9 = this.arM + this.arN;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.arJ) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i12);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int j = j(i14, measuredWidth, this.arL[0]);
                i12 = k(i12, measuredHeight, this.arL[0]);
                if (i7 != 0 && i12 >= i6) {
                    setMeasuredDimension(j, this.arM + i12);
                    this.arO[0] = i12;
                    this.arO[1] = -1;
                    this.arO[2] = -1;
                    return;
                }
                i14 = j;
            }
        }
        this.arO[0] = i12;
        int i15 = 0;
        for (View view2 : this.arK) {
            if (view2.getVisibility() != 8) {
                a aVar2 = (a) view2.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i11, i2, i15 + i12 + i9);
                int measuredWidth2 = view2.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = aVar2.bottomMargin + view2.getMeasuredHeight() + aVar2.topMargin;
                i11 = j(i11, measuredWidth2, this.arL[2]);
                int k = k(i15, measuredHeight2, this.arL[2]);
                if (i7 != 0 && k > i6 - i12) {
                    setMeasuredDimension(Math.max(i14, i11), i12 + k + this.arM + this.arN);
                    this.arO[2] = k;
                    this.arO[1] = -1;
                    return;
                }
                i15 = k;
            }
        }
        this.arO[2] = i15;
        if (this.arL[1] == 0) {
            f = 0.0f;
            i3 = 0;
            for (View view3 : this.xc) {
                if (view3.getVisibility() != 8) {
                    a aVar3 = (a) view3.getLayoutParams();
                    f += aVar3.weight;
                    if (i5 != 1073741824 || aVar3.weight <= 0.0f) {
                        measureChildWithMargins(view3, i8, f == 0.0f ? i3 : 0, i2, 0);
                        i3 = Math.max(i3, aVar3.rightMargin + view3.getMeasuredWidth() + i3 + aVar3.leftMargin);
                    } else {
                        i3 = aVar3.rightMargin + aVar3.leftMargin + i3;
                    }
                }
            }
        } else {
            f = 0.0f;
            i3 = 0;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
        int resolveSize = View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i8) - paddingLeft;
        switch (i7) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int i16 = (((i6 - i12) - i15) - this.arM) - this.arN;
                int i17 = resolveSize;
                int i18 = 0;
                int i19 = 0;
                for (View view4 : this.xc) {
                    if (view4.getVisibility() != 8) {
                        a aVar4 = (a) view4.getLayoutParams();
                        a generateDefaultLayoutParams2 = aVar4 == null ? generateDefaultLayoutParams() : aVar4;
                        if (i17 != 0 && f > 0.0f && generateDefaultLayoutParams2.weight > 0.0f) {
                            generateDefaultLayoutParams2.width = (int) ((generateDefaultLayoutParams2.weight * i17) / f);
                            f -= generateDefaultLayoutParams2.weight;
                            i17 -= generateDefaultLayoutParams2.width;
                        }
                        int i20 = i17;
                        measureChildWithMargins(view4, i8, 0, i2, i18 + i12 + i15 + i9);
                        int measuredWidth3 = view4.getMeasuredWidth() + generateDefaultLayoutParams2.leftMargin + generateDefaultLayoutParams2.rightMargin;
                        int measuredHeight3 = generateDefaultLayoutParams2.bottomMargin + view4.getMeasuredHeight() + generateDefaultLayoutParams2.topMargin;
                        int j2 = j(i19, measuredWidth3, this.arL[1]);
                        i18 = k(i18, measuredHeight3, this.arL[1]);
                        i19 = j2;
                        i17 = i20;
                    }
                }
                i13 = Math.min(i18, i16);
                i10 = i19;
                break;
            case 0:
                int i21 = resolveSize;
                for (View view5 : this.xc) {
                    a aVar5 = (a) view5.getLayoutParams();
                    a generateDefaultLayoutParams3 = aVar5 == null ? generateDefaultLayoutParams() : aVar5;
                    if (i21 != 0 && f > 0.0f && generateDefaultLayoutParams3.weight > 0.0f) {
                        generateDefaultLayoutParams3.width = (int) ((generateDefaultLayoutParams3.weight * i21) / f);
                        f -= generateDefaultLayoutParams3.weight;
                        i21 -= generateDefaultLayoutParams3.width;
                    }
                    int i22 = i21;
                    measureChild(view5, i4, i6);
                    int measuredWidth4 = view5.getMeasuredWidth() + generateDefaultLayoutParams3.leftMargin + generateDefaultLayoutParams3.rightMargin;
                    int measuredHeight4 = view5.getMeasuredHeight() + generateDefaultLayoutParams3.topMargin + generateDefaultLayoutParams3.bottomMargin;
                    i10 = j(i10, measuredWidth4, this.arL[1]);
                    i13 = k(i13, measuredHeight4, this.arL[1]);
                    i21 = i22;
                }
                break;
            case 1073741824:
                int paddingTop = ((((i6 - i12) - i15) - i9) - getPaddingTop()) - getPaddingBottom();
                int i23 = paddingTop;
                int i24 = resolveSize;
                for (View view6 : this.xc) {
                    if (view6.getVisibility() != 8) {
                        a aVar6 = (a) view6.getLayoutParams();
                        a generateDefaultLayoutParams4 = aVar6 == null ? generateDefaultLayoutParams() : aVar6;
                        if (i24 != 0 && f > 0.0f && generateDefaultLayoutParams4.weight > 0.0f) {
                            generateDefaultLayoutParams4.width = (int) ((generateDefaultLayoutParams4.weight * i24) / f);
                            f -= generateDefaultLayoutParams4.weight;
                            i24 -= generateDefaultLayoutParams4.width;
                        }
                        measureChildWithMargins(view6, i8, 0, i2, i12 + i15 + i9);
                        i23 = k(i23, view6.getMeasuredHeight() + generateDefaultLayoutParams4.topMargin + generateDefaultLayoutParams4.bottomMargin, this.arL[1]);
                        i24 = i24;
                    }
                }
                i13 = i23;
                break;
        }
        this.arO[1] = i13;
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
        setMeasuredDimension(max, i12 + i13 + i15 + this.arM + this.arN + getPaddingTop() + getPaddingBottom());
    }

    private int j(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int k(int i, int i2, int i3) {
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
        if (this.arO[0] != -1) {
            a(this.arJ, paddingLeft, paddingTop, this.arO[0]);
            int i5 = paddingTop + this.arO[0] + this.arM;
            if (this.arO[1] != -1) {
                a(this.xc, paddingLeft, i5, this.arO[1]);
                int i6 = i5 + this.arO[1] + this.arN;
                if (this.arO[2] != -1) {
                    a(this.arK, paddingLeft, i6, this.arO[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4;
        int i5 = this.arL[0];
        int measuredWidth = getMeasuredWidth();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                if (i5 == 1) {
                    i4 = generateDefaultLayoutParams.gravity & 7;
                } else {
                    i4 = generateDefaultLayoutParams.gravity & SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY;
                }
                switch (i4) {
                    case 1:
                        int i6 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredHeight = view.getMeasuredHeight() + i6;
                        view.layout(((((measuredWidth - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth()) >> 1) + i, i6, ((((measuredWidth - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) + view.getMeasuredWidth()) >> 1) + i, measuredHeight);
                        i2 = measuredHeight + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 3:
                        int i7 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredWidth2 = generateDefaultLayoutParams.leftMargin + i + view.getMeasuredWidth();
                        int measuredHeight2 = view.getMeasuredHeight() + i7;
                        view.layout(generateDefaultLayoutParams.leftMargin + i, i7, measuredWidth2, measuredHeight2);
                        i2 = measuredHeight2 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 5:
                        int measuredWidth3 = ((i + measuredWidth) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth();
                        int i8 = generateDefaultLayoutParams.topMargin + i2;
                        int i9 = (i + measuredWidth) - generateDefaultLayoutParams.rightMargin;
                        int measuredHeight3 = view.getMeasuredHeight() + i8;
                        view.layout(measuredWidth3, i8, i9, measuredHeight3);
                        i2 = measuredHeight3 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 16:
                        int i10 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth4 = view.getMeasuredWidth() + i10;
                        view.layout(i10, ((((i3 - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight()) >> 1) + i2, measuredWidth4, ((((i3 - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) + view.getMeasuredHeight()) >> 1) + i2);
                        i = measuredWidth4 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 48:
                        int i11 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth5 = view.getMeasuredWidth() + i11;
                        view.layout(i11, generateDefaultLayoutParams.topMargin + i2, measuredWidth5, generateDefaultLayoutParams.topMargin + i2 + view.getMeasuredHeight());
                        i = measuredWidth5 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 80:
                        int i12 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredHeight4 = ((i2 + i3) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight();
                        int measuredWidth6 = view.getMeasuredWidth() + i12;
                        view.layout(i12, measuredHeight4, measuredWidth6, (view.getMeasuredHeight() + i2) - generateDefaultLayoutParams.bottomMargin);
                        i = measuredWidth6 + generateDefaultLayoutParams.rightMargin;
                        continue;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public int arP;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.arP = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.RawLayout);
            this.arP = obtainStyledAttributes.getInt(3, 0);
            obtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = 51;
            }
        }

        public a() {
            super(-2, -2);
            this.arP = 0;
            this.gravity = 51;
        }

        public a(int i, int i2) {
            super(i, i2);
            this.arP = 0;
            this.gravity = 51;
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.arP = 0;
            this.gravity = i3;
        }

        public a(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.arP = 0;
            this.gravity = i3;
            this.arP = i4;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.arP = 0;
        }

        public void en(int i) {
            this.arP = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: BA */
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
