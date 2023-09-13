package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class h24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, List<a34>> a;

    public h24() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public synchronized void a(String str, a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, a34Var) == null) {
            synchronized (this) {
                if (e(str, a34Var)) {
                    return;
                }
                List<a34> c = c(str);
                if (!c.contains(a34Var)) {
                    c.add(a34Var);
                }
                if (!this.a.containsKey(str)) {
                    this.a.put(str, c);
                }
            }
        }
    }

    public synchronized void b(String str, c34 c34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, c34Var) == null) {
            synchronized (this) {
                for (a34 a34Var : new ArrayList(c(str))) {
                    if (a34Var != null) {
                        a34Var.a(c34Var);
                    }
                }
            }
        }
    }

    public synchronized void g(String str, a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, a34Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (a34Var == null) {
                    this.a.remove(str);
                    return;
                }
                List<a34> c = c(str);
                if (c.contains(a34Var)) {
                    c.remove(a34Var);
                    if (c.isEmpty()) {
                        this.a.remove(str);
                    }
                }
            }
        }
    }

    public final List<a34> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            List<a34> list = this.a.get(str);
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                List<a34> list = this.a.get(str);
                if (list != null) {
                    if (!list.isEmpty()) {
                        z = true;
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                g(str, null);
            }
        }
    }

    public final boolean e(String str, a34 a34Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, a34Var)) == null) {
            if (!TextUtils.isEmpty(str) && a34Var != null) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
