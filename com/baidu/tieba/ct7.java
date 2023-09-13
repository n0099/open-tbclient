package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public abstract class ct7 implements et7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public Context b;
    public View c;

    @Override // com.baidu.tieba.et7
    @Nullable
    @CallSuper
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            return null;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.tieba.et7
    public void b(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, themeElement) == null) {
        }
    }

    @Override // com.baidu.tieba.kt7
    public void d(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
        }
    }

    @Override // com.baidu.tieba.et7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.kt7
    public void i(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.tieba.kt7
    public void j(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.kt7
    public void k(@NonNull LogicField logicField, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, logicField, i) == null) {
        }
    }

    @Override // com.baidu.tieba.et7
    public int l(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, logicField)) == null) {
            return 8;
        }
        return invokeL.intValue;
    }

    public abstract void m();

    @Override // com.baidu.tieba.kt7
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    public ct7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        zfa.b();
    }

    @Override // com.baidu.tieba.et7
    @NonNull
    public it7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.N1().j0();
        }
        return (it7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kt7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.et7
    public void c(@NonNull FrsFragment frsFragment, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, frsFragment, view2) != null) || this.c != null) {
            return;
        }
        this.a = frsFragment;
        this.b = view2.getContext();
        this.c = view2;
        m();
    }
}
