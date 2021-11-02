package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.f1.f.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class XGridLayout extends AdapterLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f46189f;

    /* renamed from: g  reason: collision with root package name */
    public int f46190g;

    /* renamed from: h  reason: collision with root package name */
    public int f46191h;

    /* renamed from: i  reason: collision with root package name */
    public int f46192i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XGridLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void adjustGridSpan(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f46189f = i2;
            invalidate();
        }
    }

    public void adjustMaxItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f46192i = i2;
            resetLayout();
        }
    }

    public void onChangeSkinType() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.mAdapter) == null) {
            return;
        }
        bVar.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int min;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (min = Math.min(getChildCount(), this.f46192i)) <= 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < min; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                paddingLeft += measuredWidth + this.f46190g;
                if ((i6 + 1) % this.f46189f == 0) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += measuredHeight + this.f46191h;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i4 = this.f46190g;
            int i5 = this.f46189f;
            int i6 = (paddingLeft - (i4 * (i5 - 1))) / i5;
            int min = Math.min(getChildCount(), this.f46192i);
            if (min <= 0) {
                setMeasuredDimension(0, 0);
                return;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < min; i8++) {
                View childAt = getChildAt(i8);
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i3);
                if (i8 != 0) {
                    if (i8 % this.f46189f == 0) {
                        measuredHeight = childAt.getMeasuredHeight() + this.f46191h;
                    }
                } else {
                    measuredHeight = childAt.getMeasuredHeight();
                }
                i7 += measuredHeight;
            }
            setMeasuredDimension(size, i7 + getPaddingTop() + getPaddingBottom());
        }
    }

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    public void resetLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mAdapter == null) {
            return;
        }
        removeAllViews();
        int min = Math.min(this.mAdapter.a(), this.f46192i);
        for (int i2 = 0; i2 < min; i2++) {
            addView(this.mAdapter.b(i2, this));
        }
    }

    public void setAutoGridSpan(List<?> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, list, i2) == null) {
            if (list.size() < i2) {
                i2 = list.size() % i2;
            }
            this.f46189f = i2;
        }
    }

    public void setGridSpan(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f46189f = i2;
        }
    }

    public void setHorizontalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f46190g = i2;
        }
    }

    public void setMaxItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f46192i = i2;
        }
    }

    public void setVerticalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f46191h = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XGridLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f46189f = 1;
        this.f46190g = 0;
        this.f46191h = 0;
        this.f46192i = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XGridLayout);
        this.f46189f = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridSpan, this.f46189f);
        this.f46190g = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridHorizontalSpace, this.f46190g);
        this.f46191h = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridVerticalSpace, this.f46191h);
        this.f46192i = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridMaxItem, this.f46192i);
        obtainStyledAttributes.recycle();
    }
}
