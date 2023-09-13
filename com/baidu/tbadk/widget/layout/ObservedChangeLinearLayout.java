package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ObservedChangeLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y06 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservedChangeLinearLayout(Context context) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservedChangeLinearLayout(Context context, AttributeSet attributeSet) {
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
    }

    public y06 getOnSizeChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (y06) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            y06 y06Var = this.a;
            if (y06Var != null) {
                y06Var.a(this, i, i2, i3, i4);
            }
        }
    }

    public void setOnSizeChangeListener(y06 y06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y06Var) == null) {
            this.a = y06Var;
        }
    }
}
