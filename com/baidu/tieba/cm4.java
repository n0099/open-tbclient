package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cm4 extends hl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xl4 a;
    public boolean b;

    public cm4(xl4 xl4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xl4Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xl4Var;
        this.b = z;
    }

    @Override // com.baidu.tieba.hl4
    public xl4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (xl4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hl4
    public boolean b(xl4 xl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xl4Var)) == null) {
            xl4 xl4Var2 = this.a;
            if (xl4Var2 == xl4Var) {
                return true;
            }
            return xl4Var2.d(xl4Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.hl4
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || this.b) {
            return;
        }
        if (z) {
            xl4 xl4Var = this.a;
            xl4Var.a.b.b = 0L;
            xl4Var.b(0);
        }
        vl4.b().f(this.a);
    }

    @Override // com.baidu.tieba.hl4
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "isAttached=" + this.b + " " + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
