package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FlowLabelLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f42158e;

    /* renamed from: f  reason: collision with root package name */
    public int f42159f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLabelLayout(Context context) {
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
        this.f42158e = l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f42159f = l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }

    public int getHorizontalSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42159f : invokeV.intValue;
    }

    public int getVerticalSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42158e : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = i4 - i2;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int childCount = getChildCount();
            int i7 = paddingLeft;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    if (childAt.getMeasuredWidth() + i7 + paddingRight > i6) {
                        paddingTop += childAt.getMeasuredHeight() + this.f42158e;
                        i7 = paddingLeft;
                    }
                    if (childAt.getVisibility() != 8) {
                        childAt.layout(i7, paddingTop, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + paddingTop);
                        i7 += childAt.getMeasuredWidth() + this.f42159f;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            measureChildren(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int childCount = getChildCount();
            int i4 = paddingLeft;
            int i5 = paddingTop;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                i5 = Math.max(childAt.getMeasuredHeight() + paddingTop, i5);
                if (childAt.getMeasuredWidth() + i4 + paddingRight > size) {
                    i5 += childAt.getMeasuredHeight() + this.f42158e;
                    i4 = paddingLeft;
                }
                i4 += childAt.getMeasuredWidth() + this.f42159f;
            }
            setMeasuredDimension(size, i5 + paddingBottom);
        }
    }

    public void setHorizontalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f42159f = i2;
        }
    }

    public void setVerticalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f42158e = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLabelLayout(Context context, AttributeSet attributeSet) {
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
        this.f42158e = l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f42159f = l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLabelLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f42158e = l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f42159f = l.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }
}
