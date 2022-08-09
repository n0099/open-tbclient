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
/* loaded from: classes3.dex */
public class FlowLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;

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
        this.b = 0;
        this.c = 0;
        this.d = false;
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

    public final void b(Canvas canvas, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, view2) == null) && this.d) {
            Paint a = a(-256);
            Paint a2 = a(-16711936);
            Paint a3 = a(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.c > 0) {
                float right = view2.getRight();
                float top = view2.getTop() + (view2.getHeight() / 2.0f);
                canvas.drawLine(right, top, right + layoutParams.c, top, a);
                canvas.drawLine((layoutParams.c + right) - 4.0f, top - 4.0f, right + layoutParams.c, top, a);
                canvas.drawLine((layoutParams.c + right) - 4.0f, top + 4.0f, right + layoutParams.c, top, a);
            } else if (this.a > 0) {
                float right2 = view2.getRight();
                float top2 = view2.getTop() + (view2.getHeight() / 2.0f);
                canvas.drawLine(right2, top2, right2 + this.a, top2, a2);
                int i = this.a;
                canvas.drawLine((i + right2) - 4.0f, top2 - 4.0f, right2 + i, top2, a2);
                int i2 = this.a;
                canvas.drawLine((i2 + right2) - 4.0f, top2 + 4.0f, right2 + i2, top2, a2);
            }
            if (layoutParams.d > 0) {
                float left = view2.getLeft() + (view2.getWidth() / 2.0f);
                float bottom = view2.getBottom();
                canvas.drawLine(left, bottom, left, bottom + layoutParams.d, a);
                canvas.drawLine(left - 4.0f, (layoutParams.d + bottom) - 4.0f, left, bottom + layoutParams.d, a);
                canvas.drawLine(left + 4.0f, (layoutParams.d + bottom) - 4.0f, left, bottom + layoutParams.d, a);
            } else if (this.b > 0) {
                float left2 = view2.getLeft() + (view2.getWidth() / 2.0f);
                float bottom2 = view2.getBottom();
                canvas.drawLine(left2, bottom2, left2, bottom2 + this.b, a2);
                int i3 = this.b;
                canvas.drawLine(left2 - 4.0f, (i3 + bottom2) - 4.0f, left2, bottom2 + i3, a2);
                int i4 = this.b;
                canvas.drawLine(left2 + 4.0f, (i4 + bottom2) - 4.0f, left2, bottom2 + i4, a2);
            }
            if (layoutParams.e) {
                if (this.c == 0) {
                    float left3 = view2.getLeft();
                    float top3 = view2.getTop() + (view2.getHeight() / 2.0f);
                    canvas.drawLine(left3, top3 - 6.0f, left3, top3 + 6.0f, a3);
                    return;
                }
                float left4 = view2.getLeft() + (view2.getWidth() / 2.0f);
                float top4 = view2.getTop();
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
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            boolean drawChild = super.drawChild(canvas, view2, j);
            b(canvas, view2);
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
                return layoutParams.c;
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
                return layoutParams.d;
            }
            return this.b;
        }
        return invokeL.intValue;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040201, R.attr.obfuscated_res_0x7f040326, R.attr.obfuscated_res_0x7f040374, R.attr.obfuscated_res_0x7f040433, R.attr.obfuscated_res_0x7f04050f, R.attr.obfuscated_res_0x7f04075f});
            try {
                this.a = obtainStyledAttributes.getDimensionPixelSize(1, 0);
                this.b = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                this.c = obtainStyledAttributes.getInteger(4, 0);
                this.d = obtainStyledAttributes.getBoolean(0, false);
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
                childAt.layout(layoutParams.a, layoutParams.b, layoutParams.a + childAt.getMeasuredWidth(), layoutParams.b + childAt.getMeasuredHeight());
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
            if (this.c != 0) {
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
                    int f = f(layoutParams);
                    int g = g(layoutParams);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int i13 = f;
                    if (this.c == 0) {
                        i4 = i13;
                        i13 = g;
                        i5 = measuredHeight;
                    } else {
                        i4 = g;
                        i5 = measuredWidth;
                        measuredWidth = measuredHeight;
                    }
                    int i14 = i9 + measuredWidth;
                    int i15 = i14 + i4;
                    if (layoutParams.e || (mode != 0 && i14 > size)) {
                        i12 += i10;
                        i10 = i5 + i13;
                        i15 = i4 + measuredWidth;
                        i11 = i5;
                        i14 = measuredWidth;
                    }
                    i10 = Math.max(i10, i5 + i13);
                    i11 = Math.max(i11, i5);
                    if (this.c == 0) {
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
            if (this.c == 0) {
                paddingBottom = i7 + getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingBottom();
                paddingRight = getPaddingTop();
            } else {
                paddingBottom = i7 + getPaddingBottom() + getPaddingTop();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
            }
            int i16 = i8 + paddingLeft + paddingRight;
            if (this.c == 0) {
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
            this.b = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static int f = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;

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
            int i3 = f;
            this.c = i3;
            this.d = i3;
            this.e = false;
            g(context, attributeSet);
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c != f : invokeV.booleanValue;
        }

        public final void g(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040416, R.attr.obfuscated_res_0x7f04041a, R.attr.obfuscated_res_0x7f04041e});
                try {
                    this.c = obtainStyledAttributes.getDimensionPixelSize(0, f);
                    this.d = obtainStyledAttributes.getDimensionPixelSize(2, f);
                    this.e = obtainStyledAttributes.getBoolean(1, false);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }

        public void h(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                this.a = i;
                this.b = i2;
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d != f : invokeV.booleanValue;
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
            int i5 = f;
            this.c = i5;
            this.d = i5;
            this.e = false;
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
            int i3 = f;
            this.c = i3;
            this.d = i3;
            this.e = false;
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
        this.b = 0;
        this.c = 0;
        this.d = false;
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
        this.b = 0;
        this.c = 0;
        this.d = false;
        h(context, attributeSet);
    }
}
