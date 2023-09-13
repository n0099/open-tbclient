package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface fp5 {
    public static final a a = a.a;

    boolean a();

    boolean b();

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ a a;
        public static final ServiceReference b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797023775, "Lcom/baidu/tieba/fp5$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-797023775, "Lcom/baidu/tieba/fp5$a;");
                    return;
                }
            }
            a = new a();
            b = new ServiceReference("module_home", "SpriteStateService");
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @JvmStatic
        public final fp5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Object service = ServiceManager.getService(b);
                Intrinsics.checkNotNullExpressionValue(service, "getService(SERVICE_REFERENCE)");
                return (fp5) service;
            }
            return (fp5) invokeV.objValue;
        }
    }
}
