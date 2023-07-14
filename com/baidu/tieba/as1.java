package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class as1 implements pr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public zr1 b;

    public as1() {
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

    @Override // com.baidu.tieba.pr1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zr1 zr1Var = this.b;
            return zr1Var.a(this.a, zr1Var.c);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr1
    public void a(Context context, qr1 qr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qr1Var) == null) {
            this.a = context;
            zr1 zr1Var = new zr1();
            this.b = zr1Var;
            zr1Var.c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                zr1Var.b = cls;
                zr1Var.a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                zr1Var.c = zr1Var.b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                zr1Var.b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                zr1Var.b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (qr1Var != null) {
                qr1Var.a();
            }
        }
    }
}
