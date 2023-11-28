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
public class bm1 implements cm1 {
    public static /* synthetic */ Interceptable $ic;
    public static bm1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public cm1 a;
    public boolean b;

    public bm1() {
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

    public static bm1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (bm1.class) {
                    if (c == null) {
                        c = new bm1();
                    }
                }
            }
            return c;
        }
        return (bm1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            cm1 cm1Var = this.a;
            if (cm1Var == null) {
                return null;
            }
            try {
                return cm1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cm1
    public void a(Context context, dm1 dm1Var) {
        cm1 fm1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dm1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        fm1Var = new fm1();
                    } else if (ordinal == 2) {
                        fm1Var = new nm1();
                    } else if (ordinal == 3) {
                        fm1Var = new lm1();
                    } else if (ordinal == 4) {
                        fm1Var = new hm1();
                    }
                    this.a = fm1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, dm1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
