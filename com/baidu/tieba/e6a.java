package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes3.dex */
public final class e6a {
    public static /* synthetic */ Interceptable $ic;
    public static final e6a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687673, "Lcom/baidu/tieba/e6a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687673, "Lcom/baidu/tieba/e6a;");
                return;
            }
        }
        a = new e6a();
    }

    public e6a() {
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

    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    RLog.warn("ViewUtils", "activity is finishing");
                    return false;
                } else if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                    return false;
                } else {
                    return true;
                }
            }
            RLog.warn("ViewUtils", "mContext is null or not activity");
            return false;
        }
        return invokeL.booleanValue;
    }
}
