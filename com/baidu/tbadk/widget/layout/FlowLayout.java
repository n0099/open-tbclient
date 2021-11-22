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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class FlowLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47110e;

    /* renamed from: f  reason: collision with root package name */
    public int f47111f;

    /* renamed from: g  reason: collision with root package name */
    public int f47112g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47113h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47110e = 0;
        this.f47111f = 0;
        this.f47112g = 0;
        this.f47113h = false;
        e(context, null);
    }

    public final Paint a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i2);
            paint.setStrokeWidth(2.0f);
            return paint;
        }
        return (Paint) invokeI.objValue;
    }

    public final void b(Canvas canvas, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, view) == null) && this.f47113h) {
            Paint a2 = a(-256);
            Paint a3 = a(-16711936);
            Paint a4 = a(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f47117c > 0) {
                float right = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right, top, right + layoutParams.f47117c, top, a2);
                canvas.drawLine((layoutParams.f47117c + right) - 4.0f, top - 4.0f, right + layoutParams.f47117c, top, a2);
                canvas.drawLine((layoutParams.f47117c + right) - 4.0f, top + 4.0f, right + layoutParams.f47117c, top, a2);
            } else if (this.f47110e > 0) {
                float right2 = view.getRight();
                float top2 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right2, top2, right2 + this.f47110e, top2, a3);
                int i2 = this.f47110e;
                canvas.drawLine((i2 + right2) - 4.0f, top2 - 4.0f, right2 + i2, top2, a3);
                int i3 = this.f47110e;
                canvas.drawLine((i3 + right2) - 4.0f, top2 + 4.0f, right2 + i3, top2, a3);
            }
            if (layoutParams.f47118d > 0) {
                float left = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom = view.getBottom();
                canvas.drawLine(left, bottom, left, bottom + layoutParams.f47118d, a2);
                canvas.drawLine(left - 4.0f, (layoutParams.f47118d + bottom) - 4.0f, left, bottom + layoutParams.f47118d, a2);
                canvas.drawLine(left + 4.0f, (layoutParams.f47118d + bottom) - 4.0f, left, bottom + layoutParams.f47118d, a2);
            } else if (this.f47111f > 0) {
                float left2 = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom2 = view.getBottom();
                canvas.drawLine(left2, bottom2, left2, bottom2 + this.f47111f, a3);
                int i4 = this.f47111f;
                canvas.drawLine(left2 - 4.0f, (i4 + bottom2) - 4.0f, left2, bottom2 + i4, a3);
                int i5 = this.f47111f;
                canvas.drawLine(left2 + 4.0f, (i5 + bottom2) - 4.0f, left2, bottom2 + i5, a3);
            }
            if (layoutParams.f47119e) {
                if (this.f47112g == 0) {
                    float left3 = view.getLeft();
                    float top3 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left3, top3 - 6.0f, left3, top3 + 6.0f, a4);
                    return;
                }
                float left4 = view.getLeft() + (view.getWidth() / 2.0f);
                float top4 = view.getTop();
                canvas.drawLine(left4 - 6.0f, top4, left4 + 6.0f, top4, a4);
            }
        }
    }

    public final int c(LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) {
            if (layoutParams.f()) {
                return layoutParams.f47117c;
            }
            return this.f47110e;
        }
        return invokeL.intValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    public final int d(LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layoutParams)) == null) {
            if (layoutParams.i()) {
                return layoutParams.f47118d;
            }
            return this.f47111f;
        }
        return invokeL.intValue;
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

    public final void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout);
            try {
                this.f47110e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_horizontalSpacing, 0);
                this.f47111f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_verticalSpacing, 0);
                this.f47112g = obtainStyledAttributes.getInteger(R$styleable.FlowLayout_orientation, 0);
                this.f47113h = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_debugDraw, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.layout(layoutParams.f47115a, layoutParams.f47116b, layoutParams.f47115a + childAt.getMeasuredWidth(), layoutParams.f47116b + childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int paddingBottom;
        int paddingLeft;
        int paddingRight;
        int i4;
        int i5;
        int i6;
        int paddingLeft2;
        int paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            int size = (View.MeasureSpec.getSize(i2) - getPaddingRight()) - getPaddingLeft();
            int size2 = (View.MeasureSpec.getSize(i3) - getPaddingTop()) - getPaddingBottom();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            if (this.f47112g != 0) {
                size = size2;
                mode = mode2;
            }
            int childCount = getChildCount();
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i7 < childCount) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() == 8) {
                    i4 = childCount;
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    i4 = childCount;
                    childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), ((ViewGroup.LayoutParams) layoutParams).height));
                    int c2 = c(layoutParams);
                    int d2 = d(layoutParams);
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int i14 = c2;
                    if (this.f47112g == 0) {
                        i5 = i14;
                        i14 = d2;
                        i6 = measuredHeight;
                    } else {
                        i5 = d2;
                        i6 = measuredWidth;
                        measuredWidth = measuredHeight;
                    }
                    int i15 = i10 + measuredWidth;
                    int i16 = i15 + i5;
                    if (layoutParams.f47119e || (mode != 0 && i15 > size)) {
                        i13 += i11;
                        i11 = i6 + i14;
                        i16 = i5 + measuredWidth;
                        i12 = i6;
                        i15 = measuredWidth;
                    }
                    i11 = Math.max(i11, i6 + i14);
                    i12 = Math.max(i12, i6);
                    if (this.f47112g == 0) {
                        paddingLeft2 = (getPaddingLeft() + i15) - measuredWidth;
                        paddingTop = getPaddingTop() + i13;
                    } else {
                        paddingLeft2 = getPaddingLeft() + i13;
                        paddingTop = (getPaddingTop() + i15) - measuredHeight;
                    }
                    layoutParams.h(paddingLeft2, paddingTop);
                    i8 = Math.max(i8, i15);
                    i9 = i13 + i12;
                    i10 = i16;
                }
                i7++;
                childCount = i4;
            }
            if (this.f47112g == 0) {
                paddingBottom = i8 + getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingBottom();
                paddingRight = getPaddingTop();
            } else {
                paddingBottom = i8 + getPaddingBottom() + getPaddingTop();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
            }
            int i17 = i9 + paddingLeft + paddingRight;
            if (this.f47112g == 0) {
                setMeasuredDimension(ViewGroup.resolveSize(paddingBottom, i2), ViewGroup.resolveSize(i17, i3));
            } else {
                setMeasuredDimension(ViewGroup.resolveSize(i17, i2), ViewGroup.resolveSize(paddingBottom, i3));
            }
        }
    }

    public void setHorizontalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f47110e = i2;
        }
    }

    public void setVerticalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f47111f = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new LayoutParams(-2, -2) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (LayoutParams) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: f  reason: collision with root package name */
        public static int f47114f = -1;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47115a;

        /* renamed from: b  reason: collision with root package name */
        public int f47116b;

        /* renamed from: c  reason: collision with root package name */
        public int f47117c;

        /* renamed from: d  reason: collision with root package name */
        public int f47118d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f47119e;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            int i4 = f47114f;
            this.f47117c = i4;
            this.f47118d = i4;
            this.f47119e = false;
            g(context, attributeSet);
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47117c != f47114f : invokeV.booleanValue;
        }

        public final void g(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout_LayoutParams);
                try {
                    this.f47117c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, f47114f);
                    this.f47118d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FlowLayout_LayoutParams_layout_verticalSpacing, f47114f);
                    this.f47119e = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_LayoutParams_layout_newLine, false);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }

        public void h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                this.f47115a = i2;
                this.f47116b = i3;
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f47118d != f47114f : invokeV.booleanValue;
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
            int i6 = f47114f;
            this.f47117c = i6;
            this.f47118d = i6;
            this.f47119e = false;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            int i4 = f47114f;
            this.f47117c = i4;
            this.f47118d = i4;
            this.f47119e = false;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47110e = 0;
        this.f47111f = 0;
        this.f47112g = 0;
        this.f47113h = false;
        e(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47110e = 0;
        this.f47111f = 0;
        this.f47112g = 0;
        this.f47113h = false;
        e(context, attributeSet);
    }
}
