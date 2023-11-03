package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class g7c {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Class<?>, c7c> b;
    public static Map<Class<?>, Object> c;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Class<?>, c7c> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748278, "Lcom/baidu/tieba/g7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748278, "Lcom/baidu/tieba/g7c;");
                return;
            }
        }
        b = new HashMap();
        c = new HashMap();
    }

    public g7c(List<c7c> list, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        new HashMap();
        c(list, context);
    }

    public static Constructor a(Class cls, Class... clsArr) {
        InterceptResult invokeLL;
        Constructor<?>[] declaredConstructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, clsArr)) == null) {
            boolean z = false;
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i = 0; i < clsArr.length; i++) {
                        z = parameterTypes[i] == clsArr[i];
                    }
                    if (z) {
                        return constructor;
                    }
                }
            }
            return null;
        }
        return (Constructor) invokeLL.objValue;
    }

    public final void b(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, exc) == null) {
            Log.e("ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("cause message:");
            sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
            Log.e("ServiceRepository", sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[Catch: InvocationTargetException -> 0x007a, InstantiationException -> 0x007e, IllegalAccessException -> 0x0082, TryCatch #2 {IllegalAccessException -> 0x0082, InstantiationException -> 0x007e, InvocationTargetException -> 0x007a, blocks: (B:22:0x004d, B:24:0x005f, B:26:0x0070, B:25:0x0068), top: B:39:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[Catch: InvocationTargetException -> 0x007a, InstantiationException -> 0x007e, IllegalAccessException -> 0x0082, TryCatch #2 {IllegalAccessException -> 0x0082, InstantiationException -> 0x007e, InvocationTargetException -> 0x007a, blocks: (B:22:0x004d, B:24:0x005f, B:26:0x0070, B:25:0x0068), top: B:39:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(List<c7c> list, Context context) {
        Map<Class<?>, c7c> map;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, context) == null) || list == null) {
            return;
        }
        for (c7c c7cVar : list) {
            if (c7cVar.d()) {
                if (!b.containsKey(c7cVar.a())) {
                    map = b;
                }
                if (c7cVar.c() && c7cVar.b() != null && !c.containsKey(c7cVar.a())) {
                    try {
                        Constructor a = a(c7cVar.b(), Context.class);
                        c.put(c7cVar.a(), a == null ? a.newInstance(context) : c7cVar.b().newInstance());
                    } catch (IllegalAccessException e) {
                        e = e;
                        str = "AccessException";
                        b(str, e);
                    } catch (InstantiationException e2) {
                        e = e2;
                        str = "InstantiationException";
                        b(str, e);
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        str = "TargetException";
                        b(str, e);
                    }
                }
            } else {
                map = this.a;
            }
            map.put(c7cVar.a(), c7cVar);
            if (c7cVar.c()) {
                Constructor a2 = a(c7cVar.b(), Context.class);
                c.put(c7cVar.a(), a2 == null ? a2.newInstance(context) : c7cVar.b().newInstance());
            }
        }
    }
}
