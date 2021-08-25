package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes6.dex */
public class RawLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f48154e;

    /* renamed from: f  reason: collision with root package name */
    public final List<View> f48155f;

    /* renamed from: g  reason: collision with root package name */
    public final List<View> f48156g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f48157h;

    /* renamed from: i  reason: collision with root package name */
    public int f48158i;

    /* renamed from: j  reason: collision with root package name */
    public int f48159j;
    public final int[] mRawHeight;

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
        k = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            if (i2 == 1) {
                if (this.f48154e.contains(view)) {
                    return;
                }
                this.f48154e.add(view);
            } else if (i2 != 2) {
                if (i2 == 3 && !this.f48156g.contains(view)) {
                    this.f48156g.add(view);
                }
            } else if (this.f48155f.contains(view)) {
            } else {
                this.f48155f.add(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, layoutParams) == null) {
            super.addView(view, i2, layoutParams);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = generateDefaultLayoutParams();
            }
            a(view, layoutParams2.f48160a);
        }
    }

    public final void b(List<View> list, int i2, int i3, int i4) {
        int measuredHeight;
        int i5;
        int measuredWidth;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, list, i2, i3, i4) == null) {
            int i7 = this.f48157h[0];
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
    }

    public final int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? VerticalTranslateLayout.VERTICAL.equals(str) ? 1 : 0 : invokeL.intValue;
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RawLayout);
            String string = obtainStyledAttributes.getString(R$styleable.RawLayout_rawOrientation);
            if (string == null) {
                string = HorizontalTranslateLayout.HORIZONTAL;
            }
            if (k.matcher(string).matches()) {
                this.f48157h = new int[3];
                String[] split = string.split("\\|");
                if (split.length == 1) {
                    int c2 = c(split[0]);
                    int i2 = 0;
                    while (true) {
                        int[] iArr = this.f48157h;
                        if (i2 >= iArr.length) {
                            break;
                        }
                        iArr[i2] = c2;
                        i2++;
                    }
                } else if (split.length > 1) {
                    if (this.f48157h.length != split.length) {
                        throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                    }
                    int i3 = 0;
                    while (true) {
                        int[] iArr2 = this.f48157h;
                        if (i3 >= iArr2.length) {
                            break;
                        }
                        iArr2[i3] = c(split[i3]);
                        i3++;
                    }
                }
            }
            this.f48158i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RawLayout_spacingTop, 0);
            this.f48159j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RawLayout_spacingBottom, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final int e(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048582, this, i2, i3, i4)) == null) {
            if (i4 == 1) {
                return i2 + i3;
            }
            if (i4 == 0) {
                return Math.max(i3, i2);
            }
            return 0;
        }
        return invokeIII.intValue;
    }

    public final int f(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i2, i3, i4)) == null) {
            if (i4 == 1) {
                return Math.max(i3, i2);
            }
            if (i4 == 0) {
                return i2 + i3;
            }
            return 0;
        }
        return invokeIII.intValue;
    }

    public final void g(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2) == null) {
            if (i2 == 1) {
                this.f48154e.remove(view);
            } else if (i2 == 2) {
                this.f48155f.remove(view);
            } else if (i2 != 3) {
            } else {
                this.f48156g.remove(view);
            }
        }
    }

    public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, context, attributeSet)) == null) ? new LayoutParams(context, attributeSet) : (LayoutParams) invokeLL.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onFinishInflate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int[] iArr = this.mRawHeight;
            if (iArr[0] == -1) {
                return;
            }
            b(this.f48154e, paddingLeft, paddingTop, iArr[0]);
            int[] iArr2 = this.mRawHeight;
            int i6 = paddingTop + iArr2[0] + this.f48158i;
            if (iArr2[1] == -1) {
                return;
            }
            b(this.f48155f, paddingLeft, i6, iArr2[1]);
            int[] iArr3 = this.mRawHeight;
            int i7 = i6 + iArr3[1] + this.f48159j;
            if (iArr3[2] == -1) {
                return;
            }
            b(this.f48156g, paddingLeft, i7, iArr3[2]);
        }
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
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(1048592, this, i2, i3) != null) {
            return;
        }
        int i12 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i13 = i2 & (-1073741824);
        int i14 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i15 = i3 & (-1073741824);
        int i16 = i12 + i13;
        int i17 = this.f48158i + this.f48159j;
        Iterator<View> it = this.f48154e.iterator();
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
                    i18 = f(i18, measuredWidth, this.f48157h[0]);
                    i19 = e(i19, measuredHeight, this.f48157h[0]);
                    if (i15 != 0 && i19 >= i14) {
                        setMeasuredDimension(i18, this.f48158i + i19);
                        int[] iArr = this.mRawHeight;
                        iArr[0] = i19;
                        iArr[1] = -1;
                        iArr[2] = -1;
                        return;
                    }
                    it = it2;
                }
            } else {
                int i21 = i18;
                this.mRawHeight[0] = i19;
                int i22 = 0;
                int i23 = 0;
                for (View view : this.f48156g) {
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
                        i22 = f(i22, measuredWidth2, this.f48157h[2]);
                        i23 = e(i23, measuredHeight2, this.f48157h[2]);
                        if (i15 != 0 && i23 > i14 - i19) {
                            setMeasuredDimension(Math.max(i21, i22), i19 + i23 + this.f48158i + this.f48159j);
                            int[] iArr2 = this.mRawHeight;
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
                this.mRawHeight[2] = i27;
                int i28 = 1073741824;
                int i29 = 0;
                if (this.f48157h[1] == 0) {
                    f2 = 0.0f;
                    i7 = 0;
                    for (View view2 : this.f48155f) {
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
                    int i31 = (((i14 - i19) - i27) - this.f48158i) - this.f48159j;
                    Iterator<View> it3 = this.f48155f.iterator();
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
                            i33 = f(i33, measuredWidth3, this.f48157h[1]);
                            i32 = e(i32, measuredHeight3, this.f48157h[1]);
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
                        for (View view3 : this.f48155f) {
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
                                paddingTop = e(paddingTop, view3.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams9).topMargin + ((LinearLayout.LayoutParams) layoutParams9).bottomMargin, this.f48157h[1]);
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
                    for (View view4 : this.f48155f) {
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
                        i9 = f(i9, measuredWidth4, this.f48157h[1]);
                        i37 = e(i37, measuredHeight4, this.f48157h[1]);
                        i26 = i39;
                    }
                    i8 = i26;
                    i29 = i37;
                }
                this.mRawHeight[1] = i29;
                if (i13 == Integer.MIN_VALUE || i13 == 0) {
                    i8 = Math.max(Math.max(i4, i9), i5) + getPaddingLeft() + getPaddingRight();
                } else if (i13 != 1073741824) {
                    i8 = 0;
                }
                setMeasuredDimension(i8, i19 + i29 + i27 + this.f48158i + this.f48159j + getPaddingTop() + getPaddingBottom());
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.removeAllViews();
            this.f48154e.clear();
            this.f48155f.clear();
            this.f48156g.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            super.removeView(view);
            g(view, ((LayoutParams) view.getLayoutParams()).f48160a);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new LayoutParams(-2, -2, 19, 0) : (LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f48154e = new ArrayList();
        this.f48155f = new ArrayList();
        this.f48156g = new ArrayList();
        this.f48157h = new int[]{0, 0, 0};
        this.mRawHeight = new int[3];
        d(context, attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, layoutParams) == null) {
            super.addView(view, layoutParams);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = generateDefaultLayoutParams();
            }
            a(view, layoutParams2.f48160a);
        }
    }

    /* loaded from: classes6.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f48160a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.f48160a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RawLayout);
            this.f48160a = obtainStyledAttributes.getInt(R$styleable.RawLayout_layout_raw, 0);
            obtainStyledAttributes.recycle();
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 51;
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f48160a = i2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams() {
            super(-2, -2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48160a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f48160a = 0;
            ((LinearLayout.LayoutParams) this).gravity = 51;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f48160a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i4;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, int i4, int i5) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f48160a = 0;
            ((LinearLayout.LayoutParams) this).gravity = i4;
            this.f48160a = i5;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.f48160a = 0;
        }
    }
}
