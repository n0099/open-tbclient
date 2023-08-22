package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gq1 extends HandlerThread {
    public static /* synthetic */ Interceptable $ic;
    public static gq1 a;
    public static Handler b;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq1() {
        super("SSOHandlerThread", 10);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && a == null) {
            gq1 gq1Var = new gq1();
            a = gq1Var;
            gq1Var.start();
            b = new Handler(a.getLooper());
        }
    }

    public static Handler b() {
        InterceptResult invokeV;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (gq1.class) {
                a();
                handler = b;
            }
            return handler;
        }
        return (Handler) invokeV.objValue;
    }
}
