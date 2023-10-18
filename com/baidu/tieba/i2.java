package com.baidu.tieba;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class i2 extends h2 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, r2<i2>> j;
    public transient /* synthetic */ FieldHolder $fh;
    public j2 i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448305636, "Lcom/baidu/tieba/i2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448305636, "Lcom/baidu/tieba/i2;");
                return;
            }
        }
        j = new HashMap();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i.a();
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (o()) {
                this.b = y0.c.a();
                p(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
    }

    public static void m(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            j.remove(application);
        }
    }

    public static void n(Application application) {
        r2<i2> r2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, application) != null) || (r2Var = j.get(application)) == null) {
            return;
        }
        for (int i = 0; i < r2Var.b; i++) {
            r2Var.get(i).q();
        }
    }

    public final void p(j2 j2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2Var) == null) {
            if (this.i != null && j2Var.a() != this.i.a()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = j2Var;
            b();
            y0.e.G(35866, 0, j2Var.b(), j2Var.getWidth(), j2Var.getHeight(), j2Var.d(), 0, j2Var.b(), j2Var.e(), null);
            if (!j2Var.isPrepared()) {
                j2Var.prepare();
            }
            j2Var.c();
            f(this.c, this.d);
            g(this.e, this.f);
            y0.c.F(this.a, 0);
        }
    }
}
