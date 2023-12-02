package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dr0 extends er0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xq0 c;

    public dr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void A() {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (xq0Var = this.c) != null) {
            xq0Var.onVideoSwitchToHalf();
        }
    }

    @Override // com.baidu.tieba.er0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.r();
            this.c = null;
        }
    }

    public void t() {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (xq0Var = this.c) != null) {
            xq0Var.onBeforeSwitchToFull();
        }
    }

    public void u() {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (xq0Var = this.c) != null) {
            xq0Var.onBeforeSwitchToHalf();
        }
    }

    public void v() {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (xq0Var = this.c) != null) {
            xq0Var.onGestureActionEnd();
        }
    }

    public void w() {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (xq0Var = this.c) != null) {
            xq0Var.onGestureActionStart();
        }
    }

    public void z() {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (xq0Var = this.c) != null) {
            xq0Var.onVideoSwitchToFull();
        }
    }

    public boolean x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            xq0 xq0Var = this.c;
            if (xq0Var != null) {
                return xq0Var.onGestureDoubleClick(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(boolean z) {
        xq0 xq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (xq0Var = this.c) != null) {
            xq0Var.onPanelVisibilityChanged(z);
        }
    }
}
