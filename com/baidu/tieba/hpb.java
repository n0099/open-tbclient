package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class hpb extends yob {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, yob> a;
    public static final Object b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832815, "Lcom/baidu/tieba/hpb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832815, "Lcom/baidu/tieba/hpb;");
                return;
            }
        }
        a = new HashMap();
        b = new Object();
    }

    public hpb(Context context, String str) {
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
        dpb.d(context, str);
    }

    public static yob a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            String packageName = context.getPackageName();
            c = packageName;
            return b(context, packageName);
        }
        return (yob) invokeL.objValue;
    }

    public static yob b(Context context, String str) {
        InterceptResult invokeLL;
        yob yobVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("packageName can not be empty");
            }
            synchronized (b) {
                yobVar = a.get(str);
                if (yobVar == null) {
                    a.put(str, new hpb(context, str));
                }
            }
            return yobVar;
        }
        return (yob) invokeLL.objValue;
    }
}
