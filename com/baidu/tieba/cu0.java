package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cu0 extends gu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz0 O;
    public int P;
    @Nullable
    public kz0 Q;

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 23;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fu0
    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.eu0
    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "CyberSysPlayer" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fu0
    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687115, "Lcom/baidu/tieba/cu0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687115, "Lcom/baidu/tieba/cu0;");
                return;
            }
        }
        du0.f();
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            nz0 nz0Var = new nz0();
            this.O = nz0Var;
            b(nz0Var);
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.ru0, com.baidu.tieba.eu0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.P();
        }
    }

    @Override // com.baidu.tieba.eu0
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return V();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.l();
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0
    public void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && W()) {
            super.l0();
        }
    }

    @Override // com.baidu.tieba.fu0
    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.P;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu0(@NonNull xx0 xx0Var, @Nullable Context context) {
        super(xx0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xx0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((xx0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.P = 0;
    }

    @Override // com.baidu.tieba.ru0, com.baidu.tieba.eu0
    public void G0(@Nullable Context context) {
        oz0 oz0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            b(new c01());
            if (context instanceof Activity) {
                oz0Var = new oz0((Activity) context);
            } else {
                oz0Var = new oz0();
            }
            b(oz0Var);
            b(new b01());
            J1();
            b(new wz0());
            I1("ad_video_tail_frame_layer");
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0
    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            super.I0(context);
        }
    }

    public void I1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            pz0 pz0Var = new pz0(str);
            this.Q = pz0Var;
            b(pz0Var);
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && !W() && !a0()) {
            super.f0(i);
        }
    }
}
