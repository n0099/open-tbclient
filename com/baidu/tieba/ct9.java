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
/* loaded from: classes3.dex */
public final class ct9 {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<ct9> d;
    public transient /* synthetic */ FieldHolder $fh;
    public dt9 a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947686433, "Lcom/baidu/tieba/ct9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947686433, "Lcom/baidu/tieba/ct9;");
        }
    }

    public ct9(Context context, String str) {
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
        ht9.b();
        this.a = new dt9(context, str);
        this.b = str;
        this.c = context;
    }

    public static ct9 b(Context context, String str) {
        InterceptResult invokeLL;
        ct9 ct9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<ct9> softReference = d;
                ct9 ct9Var2 = softReference == null ? null : softReference.get();
                if (ct9Var2 == null || !str.equals(ct9Var2.b)) {
                    synchronized (ct9.class) {
                        ct9Var = new ct9(context, str);
                        d = new SoftReference<>(ct9Var);
                    }
                    return ct9Var;
                }
                return ct9Var2;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (ct9) invokeLL.objValue;
    }

    public final void a(Activity activity, at9 at9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, at9Var) == null) {
            this.a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, at9Var);
        }
    }

    public final void c(int i, int i2, Intent intent, at9 at9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, at9Var}) == null) {
            this.a.d(i, i2, intent, at9Var);
        }
    }
}
