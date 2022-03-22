package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FlowLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f30813b;

    /* renamed from: c  reason: collision with root package name */
    public int f30814c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30815d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f30813b = 0;
        this.f30814c = 0;
        this.f30815d = false;
        h(context, null);
    }

    public final Paint a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i);
            paint.setStrokeWidth(2.0f);
            return paint;
        }
        return (Paint) invokeI.objValue;
    }

    public final void b(Canvas canvas, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, view) == null) && this.f30815d) {
            Paint a = a(-256);
            Paint a2 = a(-16711936);
            Paint a3 = a(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f30818c > 0) {
                float right = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right, top, right + layoutParams.f30818c, top, a);
                canvas.drawLine((layoutParams.f30818c + right) - 4.0f, top - 4.0f, right + layoutParams.f30818c, top, a);
                canvas.drawLine((layoutParams.f30818c + right) - 4.0f, top + 4.0f, right + layoutParams.f30818c, top, a);
            } else if (this.a > 0) {
                float right2 = view.getRight();
                float top2 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top2, right2 + this.a, top2, a2);
                int i = this.a;
                canvas.drawLine((i + right2) - 4.0f, top2 - 4.0f, right2 + i, top2, a2);
                int i2 = this.a;
                canvas.drawLine((i2 + right2) - 4.0f, top2 + 4.0f, right2 + i2, top2, a2);
            }
            if (layoutParams.f30819d > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom = view.getBottom();
                canvas.drawLine(left, bottom, left, bottom + layoutParams.f30819d, a);
                canvas.drawLine(left - 4.0f, (layoutParams.f30819d + bottom) - 4.0f, left, bottom + layoutParams.f30819d, a);
                canvas.drawLine(left + 4.0f, (layoutParams.f30819d + bottom) - 4.0f, left, bottom + layoutParams.f30819d, a);
            } else if (this.f30813b > 0) {
                float left2 = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left2, bottom2, left2, bottom2 + this.f30813b, a2);
                int i3 = this.f30813b;
                canvas.drawLine(left2 - 4.0f, (i3 + bottom2) - 4.0f, left2, bottom2 + i3, a2);
                int i4 = this.f30813b;
                canvas.drawLine(left2 + 4.0f, (i4 + bottom2) - 4.0f, left2, bottom2 + i4, a2);
            }
            if (layoutParams.f30820e) {
                if (this.f30814c == 0) {
                    float left3 = view.getLeft();
                    float top3 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left3, top3 - 6.0f, left3, top3 + 6.0f, a3);
                    return;
                }
                float left4 = view.getLeft() + (view.getWidth() / 2.0f);
                float top4 = view.getTop();
                canvas.drawLine(left4 - 6.0f, top4, left4 + 6.0f, top4, a3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new LayoutParams(-2, -2) : (LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: d */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{canvas, view, Long.valueOf(j)})) == null) {
            boolean drawChild = super.drawChild(canvas, view, j);
            b(canvas, view);
            return drawChild;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (LayoutParams) invokeL.objValue;
    }

    public final int f(LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutParams)) == null) {
            if (layoutParams.f()) {
                return layoutParams.f30818c;
            }
            return this.a;
        }
        return invokeL.intValue;
    }

    public final int g(LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams)) == null) {
            if (layoutParams.i()) {
                return layoutParams.f30819d;
            }
            return this.f30813b;
        }
        return invokeL.intValue;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0401a5, R.attr.obfuscated_res_0x7f0402a9, R.attr.obfuscated_res_0x7f0402ea, R.attr.obfuscated_res_0x7f0403a6, R.attr.obfuscated_res_0x7f040457, R.attr.obfuscated_res_0x7f040682});
            try {
                this.a = obtainStyledAttributes.getDimensionPixelSize(1, 0);
                this.f30813b = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                this.f30814c = obtainStyledAttributes.getInteger(4, 0);
                this.f30815d = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.layout(layoutParams.a, layoutParams.f30817b, layoutParams.a + childAt.getMeasuredWidth(), layoutParams.f30817b + childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingBottom;
        int paddingLeft;
        int paddingRight;
        int i3;
        int i4;
        int i5;
        int paddingLeft2;
        int paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
            int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (this.f30814c != 0) {
                size = size2;
                mode = mode2;
            }
            int childCount = getChildCount();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i6 < childCount) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() == 8) {
                    i3 = childCount;
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    i3 = childCount;
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), ((ViewGroup.LayoutParams) layoutParams).height));
                    int f2 = f(layoutParams);
                    int g2 = g(layoutParams);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int i13 = f2;
                    if (this.f30814c == 0) {
                        i4 = i13;
                        i13 = g2;
                        i5 = measuredHeight;
                    } else {
                        i4 = g2;
                        i5 = measuredWidth;
                        measuredWidth = measuredHeight;
                    }
                    int i14 = i9 + measuredWidth;
                    int i15 = i14 + i4;
                    if (layoutParams.f30820e || (mode != 0 && i14 > size)) {
                        i12 += i10;
                        i10 = i5 + i13;
                        i15 = i4 + measuredWidth;
                        i11 = i5;
                        i14 = measuredWidth;
                    }
                    i10 = Math.max(i10, i5 + i13);
                    i11 = Math.max(i11, i5);
                    if (this.f30814c == 0) {
                        paddingLeft2 = (getPaddingLeft() + i14) - measuredWidth;
                        paddingTop = getPaddingTop() + i12;
                    } else {
                        paddingLeft2 = getPaddingLeft() + i12;
                        paddingTop = (getPaddingTop() + i14) - measuredHeight;
                    }
                    layoutParams.h(paddingLeft2, paddingTop);
                    i7 = Math.max(i7, i14);
                    i8 = i12 + i11;
                    i9 = i15;
                }
                i6++;
                childCount = i3;
            }
            if (this.f30814c == 0) {
                paddingBottom = i7 + getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingBottom();
                paddingRight = getPaddingTop();
            } else {
                paddingBottom = i7 + getPaddingBottom() + getPaddingTop();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
            }
            int i16 = i8 + paddingLeft + paddingRight;
            if (this.f30814c == 0) {
                setMeasuredDimension(ViewGroup.resolveSize(paddingBottom, i), ViewGroup.resolveSize(i16, i2));
            } else {
                setMeasuredDimension(ViewGroup.resolveSize(i16, i), ViewGroup.resolveSize(paddingBottom, i2));
            }
        }
    }

    public void setHorizontalSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.a = i;
        }
    }

    public void setVerticalSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f30813b = i;
        }
    }

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: f  reason: collision with root package name */
        public static int f30816f = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f30817b;

        /* renamed from: c  reason: collision with root package name */
        public int f30818c;

        /* renamed from: d  reason: collision with root package name */
        public int f30819d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f30820e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-457444100, "Lcom/baidu/tbadk/widget/layout/FlowLayout$LayoutParams;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-457444100, "Lcom/baidu/tbadk/widget/layout/FlowLayout$LayoutParams;");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
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
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            int i3 = f30816f;
            this.f30818c = i3;
            this.f30819d = i3;
            this.f30820e = false;
            g(context, attributeSet);
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30818c != f30816f : invokeV.booleanValue;
        }

        public final void g(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04038e, R.attr.obfuscated_res_0x7f040392, R.attr.obfuscated_res_0x7f040396});
                try {
                    this.f30818c = obtainStyledAttributes.getDimensionPixelSize(0, f30816f);
                    this.f30819d = obtainStyledAttributes.getDimensionPixelSize(2, f30816f);
                    this.f30820e = obtainStyledAttributes.getBoolean(1, false);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }

        public void h(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                this.a = i;
                this.f30817b = i2;
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30819d != f30816f : invokeV.booleanValue;
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
            int i5 = f30816f;
            this.f30818c = i5;
            this.f30819d = i5;
            this.f30820e = false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            int i3 = f30816f;
            this.f30818c = i3;
            this.f30819d = i3;
            this.f30820e = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f30813b = 0;
        this.f30814c = 0;
        this.f30815d = false;
        h(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f30813b = 0;
        this.f30814c = 0;
        this.f30815d = false;
        h(context, attributeSet);
    }
}
