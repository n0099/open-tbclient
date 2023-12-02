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
public class em1 implements fm1 {
    public static /* synthetic */ Interceptable $ic;
    public static em1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public fm1 a;
    public boolean b;

    public em1() {
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

    public static em1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (em1.class) {
                    if (c == null) {
                        c = new em1();
                    }
                }
            }
            return c;
        }
        return (em1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fm1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fm1 fm1Var = this.a;
            if (fm1Var == null) {
                return null;
            }
            try {
                return fm1Var.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fm1
    public void a(Context context, gm1 gm1Var) {
        fm1 im1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gm1Var) == null) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                int ordinal = com.baidu.sso.u.a.a(Build.MANUFACTURER).ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        im1Var = new im1();
                    } else if (ordinal == 2) {
                        im1Var = new qm1();
                    } else if (ordinal == 3) {
                        im1Var = new om1();
                    } else if (ordinal == 4) {
                        im1Var = new km1();
                    }
                    this.a = im1Var;
                } else {
                    this.a = null;
                }
                if (this.a != null) {
                    this.a.a(context, gm1Var);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
