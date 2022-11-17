package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes4.dex */
public final class ew9 {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<ew9> d;
    public transient /* synthetic */ FieldHolder $fh;
    public fw9 a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947748898, "Lcom/baidu/tieba/ew9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947748898, "Lcom/baidu/tieba/ew9;");
        }
    }

    public ew9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        jw9.b();
        this.a = new fw9(context, str);
        this.b = str;
        this.c = context;
    }

    public static ew9 b(Context context, String str) {
        InterceptResult invokeLL;
        ew9 ew9Var;
        ew9 ew9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<ew9> softReference = d;
                if (softReference == null) {
                    ew9Var = null;
                } else {
                    ew9Var = softReference.get();
                }
                if (ew9Var == null || !str.equals(ew9Var.b)) {
                    synchronized (ew9.class) {
                        ew9Var2 = new ew9(context, str);
                        d = new SoftReference<>(ew9Var2);
                    }
                    return ew9Var2;
                }
                return ew9Var;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (ew9) invokeLL.objValue;
    }

    public final void a(Activity activity, cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, cw9Var) == null) {
            this.a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, cw9Var);
        }
    }

    public final void c(int i, int i2, Intent intent, cw9 cw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, cw9Var}) == null) {
            this.a.d(i, i2, intent, cw9Var);
        }
    }
}
