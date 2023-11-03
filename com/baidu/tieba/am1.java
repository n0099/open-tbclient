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
public class am1 implements bm1 {
    public static /* synthetic */ Interceptable $ic;
    public static am1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public bm1 a;
    public boolean b;

    public am1() {
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

    public static am1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (am1.class) {
                    if (c == null) {
                        c = new am1();
                    }
                }
            }
            return c;
        }
        return (am1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bm1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bm1 bm1Var = this.a;
            if (bm1Var == null) {
                return null;
            }
            try {
                return bm1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bm1
    public void a(Context context, cm1 cm1Var) {
        bm1 em1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cm1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        em1Var = new em1();
                    } else if (ordinal == 2) {
                        em1Var = new mm1();
                    } else if (ordinal == 3) {
                        em1Var = new km1();
                    } else if (ordinal == 4) {
                        em1Var = new gm1();
                    }
                    this.a = em1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, cm1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
