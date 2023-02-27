package com.baidu.tbadk.editortools;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d89;
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

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d89.RawLayout);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
            if (((LinearLayout.LayoutParams) this).gravity == -1) {
                ((LinearLayout.LayoutParams) this).gravity = 51;
            }
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

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = i;
            }
        }
    }

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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new LayoutParams(-2, -2, 19, 0);
        }
        return (LayoutParams) invokeV.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onFinishInflate();
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

    public final void a(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && !this.c.contains(view2)) {
                        this.c.add(view2);
                    }
                } else if (!this.b.contains(view2)) {
                    this.b.add(view2);
                }
            } else if (!this.a.contains(view2)) {
                this.a.add(view2);
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

    public final void h(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, view2, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.c.remove(view2);
                        return;
                    }
                    return;
                }
                this.b.remove(view2);
                return;
            }
            this.a.remove(view2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
        }
    }

    public final void c(List<View> list, int i, int i2, int i3) {
        int i4;
        int measuredHeight;
        int i5;
        int measuredWidth;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, list, i, i2, i3) == null) {
            int i7 = this.d[0];
            int measuredWidth2 = getMeasuredWidth();
            for (View view2 : list) {
                if (view2.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    int i8 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i7 == 1) {
                        i4 = i8 & 7;
                    } else {
                        i4 = i8 & 112;
                    }
                    if (i4 != 1) {
                        if (i4 != 3) {
                            if (i4 != 5) {
                                if (i4 != 16) {
                                    if (i4 != 48) {
                                        if (i4 == 80) {
                                            int i9 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                                            int i10 = i2 + i3;
                                            int measuredHeight2 = (i10 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view2.getMeasuredHeight();
                                            measuredWidth = view2.getMeasuredWidth() + i9;
                                            view2.layout(i9, measuredHeight2, measuredWidth, i10 - ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                                            i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                                        }
                                    } else {
                                        int i11 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                                        int measuredWidth3 = view2.getMeasuredWidth() + i11;
                                        view2.layout(i11, ((LinearLayout.LayoutParams) layoutParams).topMargin + i2, measuredWidth3, ((LinearLayout.LayoutParams) layoutParams).topMargin + i2 + view2.getMeasuredHeight());
                                        i = measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                                    }
                                } else {
                                    int i12 = i + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                                    measuredWidth = view2.getMeasuredWidth() + i12;
                                    view2.layout(i12, ((((i3 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) - view2.getMeasuredHeight()) >> 1) + i2, measuredWidth, ((((i3 - ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin) + view2.getMeasuredHeight()) >> 1) + i2);
                                    i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                                }
                                i = measuredWidth + i6;
                            } else {
                                int i13 = i + measuredWidth2;
                                int measuredWidth4 = (i13 - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view2.getMeasuredWidth();
                                int i14 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                                int i15 = i13 - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                                measuredHeight = view2.getMeasuredHeight() + i14;
                                view2.layout(measuredWidth4, i14, i15, measuredHeight);
                                i5 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            }
                        } else {
                            int i16 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                            int i17 = i + i16;
                            int i18 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                            int measuredWidth5 = i16 + i + view2.getMeasuredWidth();
                            measuredHeight = view2.getMeasuredHeight() + i18;
                            view2.layout(i17, i18, measuredWidth5, measuredHeight);
                            i5 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        }
                    } else {
                        int i19 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        measuredHeight = view2.getMeasuredHeight() + i19;
                        view2.layout(((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) - view2.getMeasuredWidth()) >> 1) + i, i19, ((((measuredWidth2 - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - ((LinearLayout.LayoutParams) layoutParams).rightMargin) + view2.getMeasuredWidth()) >> 1) + i, measuredHeight);
                        i5 = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    i2 = measuredHeight + i5;
                }
            }
        }
    }

    public final int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if ("vertical".equals(str)) {
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
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

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d89.RawLayout);
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
                    if (this.d.length == split.length) {
                        int i2 = 0;
                        while (true) {
                            int[] iArr2 = this.d;
                            if (i2 >= iArr2.length) {
                                break;
                            }
                            iArr2[i2] = d(split[i2]);
                            i2++;
                        }
                    } else {
                        throw new RuntimeException("Raw number doesn't equal orientation definition number.");
                    }
                }
            }
            this.e = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, layoutParams)) == null) {
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
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
        int i11;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            int i12 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i13 = i & (-1073741824);
            int i14 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i15 = i2 & (-1073741824);
            int i16 = i12 + i13;
            int i17 = this.e + this.f;
            Iterator<View> it = this.a.iterator();
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
                        measureChildWithMargins(next, i16, i18 + i17, i2, i19);
                        int measuredWidth = next.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                        int measuredHeight = next.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                        i18 = g(i18, measuredWidth, this.d[0]);
                        i19 = f(i19, measuredHeight, this.d[0]);
                        if (i15 != 0 && i19 >= i14) {
                            setMeasuredDimension(i18, this.e + i19);
                            int[] iArr = this.g;
                            iArr[0] = i19;
                            iArr[1] = -1;
                            iArr[2] = -1;
                            return;
                        }
                        it = it2;
                    }
                } else {
                    int i21 = i18;
                    this.g[0] = i19;
                    int i22 = 0;
                    int i23 = 0;
                    for (View view2 : this.c) {
                        if (view2.getVisibility() != i20) {
                            LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                            if (layoutParams3 == null) {
                                layoutParams3 = generateDefaultLayoutParams();
                            }
                            LayoutParams layoutParams4 = layoutParams3;
                            int i24 = i12;
                            measureChildWithMargins(view2, i16, i22, i2, i23 + i19 + i17);
                            int measuredWidth2 = view2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                            int measuredHeight2 = view2.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin;
                            i22 = g(i22, measuredWidth2, this.d[2]);
                            i23 = f(i23, measuredHeight2, this.d[2]);
                            if (i15 != 0 && i23 > i14 - i19) {
                                setMeasuredDimension(Math.max(i21, i22), i19 + i23 + this.e + this.f);
                                int[] iArr2 = this.g;
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
                    this.g[2] = i27;
                    int i28 = 1073741824;
                    int i29 = 0;
                    if (this.d[1] == 0) {
                        f = 0.0f;
                        i6 = 0;
                        for (View view3 : this.b) {
                            if (view3.getVisibility() != 8) {
                                LayoutParams layoutParams5 = (LayoutParams) view3.getLayoutParams();
                                float f2 = ((LinearLayout.LayoutParams) layoutParams5).weight;
                                float f3 = f + f2;
                                if (i13 == i28 && f2 > 0.0f) {
                                    i6 += ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin;
                                    i11 = i21;
                                    i10 = i25;
                                } else {
                                    if (f3 == 0.0f) {
                                        i9 = i6;
                                    } else {
                                        i9 = 0;
                                    }
                                    int i30 = i9;
                                    i10 = i25;
                                    int i31 = i6;
                                    i11 = i21;
                                    measureChildWithMargins(view3, i16, i30, i2, 0);
                                    i6 = Math.max(i31, i31 + view3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin);
                                }
                                f = f3;
                                i25 = i10;
                                i21 = i11;
                                i28 = 1073741824;
                            }
                        }
                        i3 = i21;
                        i4 = i25;
                        i5 = 1073741824;
                    } else {
                        i3 = i21;
                        i4 = i25;
                        i5 = 1073741824;
                        f = 0.0f;
                        i6 = 0;
                    }
                    int paddingLeft = i6 + getPaddingLeft() + getPaddingRight();
                    int resolveSize = View.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i16) - paddingLeft;
                    if (i15 != Integer.MIN_VALUE) {
                        if (i15 != 0) {
                            if (i15 == i5) {
                                int paddingTop = ((((i14 - i19) - i27) - i17) - getPaddingTop()) - getPaddingBottom();
                                for (View view4 : this.b) {
                                    if (view4.getVisibility() != 8) {
                                        LayoutParams layoutParams6 = (LayoutParams) view4.getLayoutParams();
                                        if (layoutParams6 == null) {
                                            layoutParams6 = generateDefaultLayoutParams();
                                        }
                                        LayoutParams layoutParams7 = layoutParams6;
                                        if (resolveSize != 0 && f > 0.0f) {
                                            float f4 = ((LinearLayout.LayoutParams) layoutParams7).weight;
                                            if (f4 > 0.0f) {
                                                int i32 = (int) ((resolveSize * f4) / f);
                                                ((LinearLayout.LayoutParams) layoutParams7).width = i32;
                                                f -= f4;
                                                resolveSize -= i32;
                                            }
                                        }
                                        measureChildWithMargins(view4, i16, 0, i2, i19 + i27 + i17);
                                        paddingTop = f(paddingTop, view4.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin, this.d[1]);
                                        f = f;
                                        resolveSize = resolveSize;
                                    }
                                }
                                i29 = paddingTop;
                            }
                            i7 = i26;
                            i8 = 0;
                        } else {
                            int i33 = 0;
                            i8 = 0;
                            for (View view5 : this.b) {
                                LayoutParams layoutParams8 = (LayoutParams) view5.getLayoutParams();
                                if (layoutParams8 == null) {
                                    layoutParams8 = generateDefaultLayoutParams();
                                }
                                if (resolveSize != 0 && f > 0.0f) {
                                    float f5 = ((LinearLayout.LayoutParams) layoutParams8).weight;
                                    if (f5 > 0.0f) {
                                        int i34 = (int) ((resolveSize * f5) / f);
                                        ((LinearLayout.LayoutParams) layoutParams8).width = i34;
                                        f -= f5;
                                        resolveSize -= i34;
                                    }
                                }
                                int i35 = i26;
                                measureChild(view5, i35, i14);
                                int measuredWidth3 = view5.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams8).leftMargin + ((LinearLayout.LayoutParams) layoutParams8).rightMargin;
                                int measuredHeight3 = view5.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams8).topMargin + ((LinearLayout.LayoutParams) layoutParams8).bottomMargin;
                                i8 = g(i8, measuredWidth3, this.d[1]);
                                i33 = f(i33, measuredHeight3, this.d[1]);
                                i26 = i35;
                            }
                            i7 = i26;
                            i29 = i33;
                        }
                    } else {
                        i7 = i26;
                        int i36 = (((i14 - i19) - i27) - this.e) - this.f;
                        Iterator<View> it3 = this.b.iterator();
                        int i37 = 0;
                        int i38 = 0;
                        while (it3.hasNext()) {
                            View next2 = it3.next();
                            if (next2.getVisibility() != 8) {
                                LayoutParams layoutParams9 = (LayoutParams) next2.getLayoutParams();
                                if (layoutParams9 == null) {
                                    layoutParams9 = generateDefaultLayoutParams();
                                }
                                if (resolveSize != 0 && f > 0.0f) {
                                    float f6 = ((LinearLayout.LayoutParams) layoutParams9).weight;
                                    if (f6 > 0.0f) {
                                        int i39 = (int) ((resolveSize * f6) / f);
                                        ((LinearLayout.LayoutParams) layoutParams9).width = i39;
                                        f -= f6;
                                        resolveSize -= i39;
                                    }
                                }
                                float f7 = f;
                                int i40 = resolveSize;
                                Iterator<View> it4 = it3;
                                LayoutParams layoutParams10 = layoutParams9;
                                measureChildWithMargins(next2, i16, 0, i2, i37 + i19 + i27 + i17);
                                int measuredWidth4 = next2.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin;
                                int measuredHeight4 = next2.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin;
                                i38 = g(i38, measuredWidth4, this.d[1]);
                                i37 = f(i37, measuredHeight4, this.d[1]);
                                f = f7;
                                resolveSize = i40;
                                it3 = it4;
                                i16 = i16;
                            }
                        }
                        i29 = Math.min(i37, i36);
                        i8 = i38;
                    }
                    this.g[1] = i29;
                    if (i13 != Integer.MIN_VALUE && i13 != 0) {
                        if (i13 != 1073741824) {
                            i7 = 0;
                        }
                    } else {
                        i7 = Math.max(Math.max(i3, i8), i4) + getPaddingLeft() + getPaddingRight();
                    }
                    setMeasuredDimension(i7, i19 + i29 + i27 + this.e + this.f + getPaddingTop() + getPaddingBottom());
                    return;
                }
            }
        }
    }
}
