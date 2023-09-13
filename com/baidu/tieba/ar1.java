package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ar1 implements br1 {
    public static /* synthetic */ Interceptable $ic;
    public static ar1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public br1 a;
    public boolean b;

    public ar1() {
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
        this.a = null;
        this.b = false;
    }

    public static ar1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ar1.class) {
                    if (c == null) {
                        c = new ar1();
                    }
                }
            }
            return c;
        }
        return (ar1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            br1 br1Var = this.a;
            if (br1Var == null) {
                return null;
            }
            try {
                return br1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br1
    public void a(Context context, cr1 cr1Var) {
        br1 er1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cr1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        er1Var = new er1();
                    } else if (ordinal == 2) {
                        er1Var = new mr1();
                    } else if (ordinal == 3) {
                        er1Var = new kr1();
                    } else if (ordinal == 4) {
                        er1Var = new gr1();
                    }
                    this.a = er1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, cr1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
