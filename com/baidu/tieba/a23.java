package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a23 extends y13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean e;
    public final qx1 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a23(qx1 qx1Var, boolean z) {
        super(6);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qx1Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = z;
        this.f = qx1Var;
    }

    @Override // com.baidu.tieba.y13
    public String d() {
        InterceptResult invokeV;
        ff3 params;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            qx1 qx1Var = this.f;
            if (qx1Var != null && (params = qx1Var.getParams()) != null) {
                return params.c;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }
}
