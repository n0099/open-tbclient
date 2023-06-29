package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Deprecated
/* loaded from: classes5.dex */
public abstract class ggb implements dgb {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, ggb> a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947794375, "Lcom/baidu/tieba/ggb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947794375, "Lcom/baidu/tieba/ggb;");
                return;
            }
        }
        a = new HashMap();
        b = new Object();
    }

    public ggb() {
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

    public static ggb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            return d(context, context.getPackageName());
        }
        return (ggb) invokeL.objValue;
    }

    public static ggb d(Context context, String str) {
        InterceptResult invokeLL;
        ggb ggbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (b) {
                ggbVar = a.get(str);
                if (ggbVar == null) {
                    ggbVar = new mgb(context, str);
                    a.put(str, ggbVar);
                }
            }
            return ggbVar;
        }
        return (ggb) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.dgb
    public abstract /* synthetic */ Context getContext();

    @Override // com.baidu.tieba.dgb
    public abstract /* synthetic */ String getIdentifier();
}
