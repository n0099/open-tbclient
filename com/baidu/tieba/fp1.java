package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fp1 implements gp1 {
    public static /* synthetic */ Interceptable $ic;
    public static fp1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public gp1 a;
    public boolean b;

    public fp1() {
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

    public static fp1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (fp1.class) {
                    if (c == null) {
                        c = new fp1();
                    }
                }
            }
            return c;
        }
        return (fp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gp1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            gp1 gp1Var = this.a;
            if (gp1Var == null) {
                return null;
            }
            try {
                return gp1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gp1
    public void a(Context context, hp1 hp1Var) {
        gp1 jp1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hp1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        jp1Var = new jp1();
                    } else if (ordinal == 2) {
                        jp1Var = new rp1();
                    } else if (ordinal == 3) {
                        jp1Var = new pp1();
                    } else if (ordinal == 4) {
                        jp1Var = new lp1();
                    }
                    this.a = jp1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, hp1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
