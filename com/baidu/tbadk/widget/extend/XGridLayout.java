package com.baidu.tbadk.widget.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.b1.f.a.b;
import java.util.List;
/* loaded from: classes4.dex */
public class XGridLayout extends AdapterLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f13301h;

    /* renamed from: i  reason: collision with root package name */
    public int f13302i;
    public int j;
    public int k;

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

    @Override // com.baidu.tbadk.widget.extend.AdapterLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13295e == null) {
            return;
        }
        removeAllViews();
        int min = Math.min(this.f13295e.a(), this.k);
        for (int i2 = 0; i2 < min; i2++) {
            addView(this.f13295e.b(i2, this));
        }
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f13295e) == null) {
            return;
        }
        bVar.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int min;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (min = Math.min(getChildCount(), this.k)) <= 0) {
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
                paddingLeft += measuredWidth + this.f13302i;
                if ((i6 + 1) % this.f13301h == 0) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += measuredHeight + this.j;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i4 = this.f13302i;
            int i5 = this.f13301h;
            int i6 = (paddingLeft - (i4 * (i5 - 1))) / i5;
            int min = Math.min(getChildCount(), this.k);
            if (min <= 0) {
                setMeasuredDimension(0, 0);
                return;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < min; i8++) {
                View childAt = getChildAt(i8);
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i3);
                if (i8 != 0) {
                    if (i8 % this.f13301h == 0) {
                        measuredHeight = childAt.getMeasuredHeight() + this.j;
                    }
                } else {
                    measuredHeight = childAt.getMeasuredHeight();
                }
                i7 += measuredHeight;
            }
            setMeasuredDimension(size, i7 + getPaddingTop() + getPaddingBottom());
        }
    }

    public void setAutoGridSpan(List<?> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, list, i2) == null) {
            if (list.size() < i2) {
                i2 = list.size() % i2;
            }
            this.f13301h = i2;
        }
    }

    public void setGridSpan(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f13301h = i2;
        }
    }

    public void setHorizontalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f13302i = i2;
        }
    }

    public void setMaxItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setVerticalSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.j = i2;
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
        this.f13301h = 1;
        this.f13302i = 0;
        this.j = 0;
        this.k = 9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XGridLayout);
        this.f13301h = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridSpan, this.f13301h);
        this.f13302i = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridHorizontalSpace, this.f13302i);
        this.j = (int) obtainStyledAttributes.getDimension(R$styleable.XGridLayout_gridVerticalSpace, this.j);
        this.k = obtainStyledAttributes.getInteger(R$styleable.XGridLayout_gridMaxItem, this.k);
        obtainStyledAttributes.recycle();
    }
}
