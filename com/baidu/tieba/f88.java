package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f88 extends gx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz9 B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f88(Context context) {
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

    @Override // com.baidu.tieba.gx, com.baidu.tieba.wy
    public uz9 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.m) && this.m.equals("index")) {
                this.B = new h88(this.b, this.i);
            } else {
                this.B = new g88(this.b, this.i);
            }
            this.B.setStageType("2001");
            return this.B;
        }
        return (uz9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wy
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.z();
            uz9 uz9Var = this.l;
            if (uz9Var instanceof h88) {
                ((h88) uz9Var).e();
            }
        }
    }
}
