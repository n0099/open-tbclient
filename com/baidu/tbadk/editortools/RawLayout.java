package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ap8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes3.dex */
public class RawLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern h;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<View> a;
    public final List<View> b;
    public final List<View> c;
    public int[] d;
    public int e;
    public int f;
    public final int[] g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2064260723, "Lcom/baidu/tbadk/editortools/RawLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2064260723, "Lcom/baidu/tbadk/editortools/RawLayout;");
                return;
            }
        }
        h = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            if (i == 1) {
                if (this.a.contains(view2)) {
                    return;
                }
                this.a.add(view2);
            } else if (i != 2) {
                if (i == 3 && !this.c.contains(view2)) {
                    this.c.add(view2);
                }
            } else if (this.b.contains(view2)) {
            } else {
                this.b.add(view2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, layoutParams) == null) {
            super.addView(view2, i, layoutParams);
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = generateDefaultLayoutParams();
            }
            a(view2, layoutParams2.a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new LayoutParams(-2, -2, 19, 0) : (LayoutParams) invokeV.objValue;
    }

    public final void c(List<View> list, int i, int i2, int i3) {
        int measuredHeight;
        int i4;
        int measuredWidth;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, list, i, i2, i3) == null) {
            int i6 = this.d[0];
            int measuredWidth2 = getMeasuredWidth();
            for (View view2 : list) {
                if (view2.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    int i7 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    int i8 = i6 == 1 ? i7 & 7 : i7 & 112;
                    if (i8 == 1) {
                        int i9 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        measuredHeight = view2.getMeasuredHeight() + i9;
                        view2.layout(((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view2.getMeasuredWidth()) >> 1) + i, i9, ((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) + view2.getMeasuredWidth()) >> 1) + i, measuredHeight);
                        i4 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    } else if (i8 == 3) {
                        int i10 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        int i11 = i + i10;
                        int i12 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        int measuredWidth3 = i10 + i + view2.getMeasuredWidth();
                        measuredHeight = view2.getMeasuredHeight() + i12;
                        view2.layout(i11, i12, measuredWidth3, measuredHeight);
                        i4 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    } else if (i8 != 5) {
                        if (i8 == 16) {
                            int i13 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                            measuredWidth = view2.getMeasuredWidth() + i13;
                            view2.layout(i13, ((((i3 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view2.getMeasuredHeight()) >> 1) + i2, measuredWidth, ((((i3 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) + view2.getMeasuredHeight()) >> 1) + i2);
                            i5 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        } else if (i8 == 48) {
                            int i14 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                            int measuredWidth4 = view2.getMeasuredWidth() + i14;
                            view2.layout(i14, ((LinearLayout.LayoutParams) layoutParams).topMargin + i2, measuredWidth4, ((LinearLayout.LayoutParams) layoutParams).topMargin + i2 + view2.getMeasuredHeight());
                            i = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        } else if (i8 == 80) {
                            int i15 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                            int i16 = i2 + i3;
                            int measuredHeight2 = (i16 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view2.getMeasuredHeight();
                            measuredWidth = view2.getMeasuredWidth() + i15;
                            view2.layout(i15, measuredHeight2, measuredWidth, i16 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                            i5 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        }
                        i = measuredWidth + i5;
                    } else {
                        int i17 = i + measuredWidth2;
                        int measuredWidth5 = (i17 - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view2.getMeasuredWidth();
                        int i18 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        int i19 = i17 - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        measuredHeight = view2.getMeasuredHeight() + i18;
                        view2.layout(measuredWidth5, i18, i19, measuredHeight);
                        i4 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    i2 = measuredHeight + i4;
                }
            }
        }
    }

    public final int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? "vertical".equals(str) ? 1 : 0 : invokeL.intValue;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ap8.RawLayout);
            String string = obtainStyledAttributes.getString(1);
            if (string == null) {
                string = "horizontal";
            }
            if (h.matcher(string).matches()) {
                this.d = new int[3];
                String[] split = string.split(WebChromeClient.PARAM_SEPARATOR);
                if (split.length == 1) {
                    int d = d(split[0]);
                    int i = 0;
                    while (true) {
                        int[] iArr = this.d;
                        if (i >= iArr.length) {
                            break;
                        }
                        iArr[i] = d;
                        i++;
                    }
                } else if (split.length > 1) {
                    if (this.d.length != split.length) {
                        throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                    }
                    int i2 = 0;
                    while (true) {
                        int[] iArr2 = this.d;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        iArr2[i2] = d(split[i2]);
                        i2++;
                    }
                }
            }
            this.e = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final int f(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i, i2, i3)) == null) {
            if (i3 == 1) {
                return i + i2;
            }
            if (i3 == 0) {
                return Math.max(i2, i);
            }
            return 0;
        }
        return invokeIII.intValue;
    }

    public final int g(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3)) == null) {
            if (i3 == 1) {
                return Math.max(i2, i);
            }
            if (i3 == 0) {
                return i + i2;
            }
            return 0;
        }
        return invokeIII.intValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public final void h(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, view2, i) == null) {
            if (i == 1) {
                this.a.remove(view2);
            } else if (i == 2) {
                this.b.remove(view2);
            } else if (i != 3) {
            } else {
                this.c.remove(view2);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onFinishInflate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int[] iArr = this.g;
            if (iArr[0] == -1) {
                return;
            }
            c(this.a, paddingLeft, paddingTop, iArr[0]);
            int[] iArr2 = this.g;
            int i5 = paddingTop + iArr2[0] + this.e;
            if (iArr2[1] == -1) {
                return;
            }
            c(this.b, paddingLeft, i5, iArr2[1]);
            int[] iArr3 = this.g;
            int i6 = i5 + iArr3[1] + this.f;
            if (iArr3[2] == -1) {
                return;
            }
            c(this.c, paddingLeft, i6, iArr3[2]);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(1048591, this, i, i2) != null) {
            return;
        }
        int i11 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i12 = i & (-1073741824);
        int i13 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i14 = i2 & (-1073741824);
        int i15 = i11 + i12;
        int i16 = this.e + this.f;
        Iterator<View> it = this.a.iterator();
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
                    i17 = g(i17, measuredWidth, this.d[0]);
                    i18 = f(i18, measuredHeight, this.d[0]);
                    if (i14 != 0 && i18 >= i13) {
                        setMeasuredDimension(i17, this.e + i18);
                        int[] iArr = this.g;
                        iArr[0] = i18;
                        iArr[1] = -1;
                        iArr[2] = -1;
                        return;
                    }
                    it = it2;
                }
            } else {
                int i20 = i17;
                this.g[0] = i18;
                int i21 = 0;
                int i22 = 0;
                for (View view2 : this.c) {
                    if (view2.getVisibility() != i19) {
                        LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = generateDefaultLayoutParams();
                        }
                        LayoutParams layoutParams4 = layoutParams3;
                        int i23 = i11;
                        measureChildWithMargins(view2, i15, i21, i2, i22 + i18 + i16);
                        int measuredWidth2 = view2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredHeight2 = view2.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin;
                        i21 = g(i21, measuredWidth2, this.d[2]);
                        i22 = f(i22, measuredHeight2, this.d[2]);
                        if (i14 != 0 && i22 > i13 - i18) {
                            setMeasuredDimension(Math.max(i20, i21), i18 + i22 + this.e + this.f);
                            int[] iArr2 = this.g;
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
                this.g[2] = i26;
                int i27 = 1073741824;
                int i28 = 0;
                if (this.d[1] == 0) {
                    f = 0.0f;
                    i6 = 0;
                    for (View view3 : this.b) {
                        if (view3.getVisibility() != 8) {
                            LayoutParams layoutParams5 = (LayoutParams) view3.getLayoutParams();
                            float f2 = ((LinearLayout.LayoutParams) layoutParams5).weight;
                            float f3 = f + f2;
                            if (i12 == i27 && f2 > 0.0f) {
                                i6 += ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin;
                                i10 = i20;
                                i9 = i24;
                            } else {
                                i9 = i24;
                                int i29 = i6;
                                i10 = i20;
                                measureChildWithMargins(view3, i15, f3 == 0.0f ? i6 : 0, i2, 0);
                                i6 = Math.max(i29, i29 + view3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin);
                            }
                            f = f3;
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
                    f = 0.0f;
                    i6 = 0;
                }
                int paddingLeft = i6 + getPaddingLeft() + getPaddingRight();
                int resolveSize = View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i15) - paddingLeft;
                if (i14 == Integer.MIN_VALUE) {
                    i7 = i25;
                    int i30 = (((i13 - i18) - i26) - this.e) - this.f;
                    Iterator<View> it3 = this.b.iterator();
                    int i31 = 0;
                    int i32 = 0;
                    while (it3.hasNext()) {
                        View next2 = it3.next();
                        if (next2.getVisibility() != 8) {
                            LayoutParams layoutParams6 = (LayoutParams) next2.getLayoutParams();
                            if (layoutParams6 == null) {
                                layoutParams6 = generateDefaultLayoutParams();
                            }
                            if (resolveSize != 0 && f > 0.0f) {
                                float f4 = ((LinearLayout.LayoutParams) layoutParams6).weight;
                                if (f4 > 0.0f) {
                                    int i33 = (int) ((resolveSize * f4) / f);
                                    ((LinearLayout.LayoutParams) layoutParams6).width = i33;
                                    f -= f4;
                                    resolveSize -= i33;
                                }
                            }
                            float f5 = f;
                            int i34 = resolveSize;
                            Iterator<View> it4 = it3;
                            LayoutParams layoutParams7 = layoutParams6;
                            measureChildWithMargins(next2, i15, 0, i2, i31 + i18 + i26 + i16);
                            int measuredWidth3 = next2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin;
                            int measuredHeight3 = next2.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin;
                            i32 = g(i32, measuredWidth3, this.d[1]);
                            i31 = f(i31, measuredHeight3, this.d[1]);
                            f = f5;
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
                        for (View view4 : this.b) {
                            if (view4.getVisibility() != 8) {
                                LayoutParams layoutParams8 = (LayoutParams) view4.getLayoutParams();
                                if (layoutParams8 == null) {
                                    layoutParams8 = generateDefaultLayoutParams();
                                }
                                LayoutParams layoutParams9 = layoutParams8;
                                if (resolveSize != 0 && f > 0.0f) {
                                    float f6 = ((LinearLayout.LayoutParams) layoutParams9).weight;
                                    if (f6 > 0.0f) {
                                        int i35 = (int) ((resolveSize * f6) / f);
                                        ((LinearLayout.LayoutParams) layoutParams9).width = i35;
                                        f -= f6;
                                        resolveSize -= i35;
                                    }
                                }
                                measureChildWithMargins(view4, i15, 0, i2, i18 + i26 + i16);
                                paddingTop = f(paddingTop, view4.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams9).topMargin + ((LinearLayout.LayoutParams) layoutParams9).bottomMargin, this.d[1]);
                                f = f;
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
                    for (View view5 : this.b) {
                        LayoutParams layoutParams10 = (LayoutParams) view5.getLayoutParams();
                        if (layoutParams10 == null) {
                            layoutParams10 = generateDefaultLayoutParams();
                        }
                        if (resolveSize != 0 && f > 0.0f) {
                            float f7 = ((LinearLayout.LayoutParams) layoutParams10).weight;
                            if (f7 > 0.0f) {
                                int i37 = (int) ((resolveSize * f7) / f);
                                ((LinearLayout.LayoutParams) layoutParams10).width = i37;
                                f -= f7;
                                resolveSize -= i37;
                            }
                        }
                        int i38 = i25;
                        measureChild(view5, i38, i13);
                        int measuredWidth4 = view5.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin;
                        int measuredHeight4 = view5.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin;
                        i8 = g(i8, measuredWidth4, this.d[1]);
                        i36 = f(i36, measuredHeight4, this.d[1]);
                        i25 = i38;
                    }
                    i7 = i25;
                    i28 = i36;
                }
                this.g[1] = i28;
                if (i12 == Integer.MIN_VALUE || i12 == 0) {
                    i7 = Math.max(Math.max(i3, i8), i4) + getPaddingLeft() + getPaddingRight();
                } else if (i12 != 1073741824) {
                    i7 = 0;
                }
                setMeasuredDimension(i7, i18 + i28 + i26 + this.e + this.f + getPaddingTop() + getPaddingBottom());
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.removeAllViews();
            this.a.clear();
            this.b.clear();
            this.c.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            super.removeView(view2);
            h(view2, ((LayoutParams) view2.getLayoutParams()).a);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new int[]{0, 0, 0};
        this.g = new int[3];
        e(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, layoutParams) == null) {
            super.addView(view2, layoutParams);
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = generateDefaultLayoutParams();
            }
            a(view2, layoutParams2.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ap8.RawLayout);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 51;
            }
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = i;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams() {
            super(-2, -2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i3;
            this.a = i4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65541, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.a = 0;
        }
    }
}
