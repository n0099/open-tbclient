package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public final class bcc {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947641607, "Lcom/baidu/tieba/bcc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947641607, "Lcom/baidu/tieba/bcc;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> T a(Class<T> cls, int i, int i2, Context context, PayUIKitConfig payUIKitConfig, qcc qccVar) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{cls, Integer.valueOf(i), Integer.valueOf(i2), context, payUIKitConfig, qccVar})) == null) {
                try {
                    return (T) cls.getClassLoader().loadClass(cls.getCanonicalName() + "$$Factory").getMethod("createInstance", Integer.TYPE, Integer.TYPE, Context.class, PayUIKitConfig.class, qcc.class).invoke(null, Integer.valueOf(i), Integer.valueOf(i2), context, payUIKitConfig, qccVar);
                } catch (Exception e) {
                    RLog.error("ApiInstanceCreator", "getApiInstance error " + e, new Object[0]);
                    return null;
                }
            }
            return (T) invokeCommon.objValue;
        }
    }
}
