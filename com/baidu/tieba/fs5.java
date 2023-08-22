package com.baidu.tieba;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fs5 extends ks5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public es5 b;
    public boolean c;
    public boolean d;

    public fs5() {
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

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            es5 es5Var = this.b;
            if (es5Var != null) {
                return es5Var.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c() {
        es5 es5Var;
        os5 os5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.d && (es5Var = this.b) != null && es5Var.b() >= 0 && (os5Var = (os5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            os5Var.d(this);
            this.d = true;
        }
    }

    public void e() {
        es5 es5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && Build.VERSION.SDK_INT >= 16 && (es5Var = this.b) != null) {
            es5Var.d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.c && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            this.c = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.b == null) {
                    this.b = new es5();
                }
                this.b.c();
            }
        }
    }
}
