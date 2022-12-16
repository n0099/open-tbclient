package com.baidu.tieba;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dd0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String c = "dd0";
    public transient /* synthetic */ FieldHolder $fh;
    public cd0 a;
    public EGLSurface b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947700569, "Lcom/baidu/tieba/dd0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947700569, "Lcom/baidu/tieba/dd0;");
        }
    }

    public dd0(cd0 cd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cd0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = EGL14.EGL_NO_SURFACE;
        this.a = cd0Var;
    }

    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            if (this.b == EGL14.EGL_NO_SURFACE) {
                this.b = this.a.b(obj);
                return;
            }
            throw new IllegalStateException("surface already created");
        }
    }

    public void b(cd0 cd0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cd0Var) == null) && !cd0Var.d(this.b)) {
            cd0Var.e(this.b);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.a.h(this.b, j);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.g(this.b);
            this.b = EGL14.EGL_NO_SURFACE;
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean i = this.a.i(this.b);
            if (!i) {
                Log.d(c, "WARNING: swapBuffers() failed");
            }
            return i;
        }
        return invokeV.booleanValue;
    }
}
