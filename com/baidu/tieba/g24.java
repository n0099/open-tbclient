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
public class g24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, List<o24>> a;

    public g24() {
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

    public synchronized void a(String str, o24 o24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, o24Var) == null) {
            synchronized (this) {
                if (e(str, o24Var)) {
                    return;
                }
                List<o24> c = c(str);
                if (!c.contains(o24Var)) {
                    c.add(o24Var);
                }
                if (!this.a.containsKey(str)) {
                    this.a.put(str, c);
                }
            }
        }
    }

    public synchronized void b(String str, p24 p24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, p24Var) == null) {
            synchronized (this) {
                for (o24 o24Var : new ArrayList(c(str))) {
                    if (o24Var != null) {
                        o24Var.a(p24Var);
                    }
                }
            }
        }
    }

    public synchronized void g(String str, o24 o24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, o24Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (o24Var == null) {
                    this.a.remove(str);
                    return;
                }
                List<o24> c = c(str);
                if (c.contains(o24Var)) {
                    c.remove(o24Var);
                    if (c.isEmpty()) {
                        this.a.remove(str);
                    }
                }
            }
        }
    }

    public final List<o24> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            List<o24> list = this.a.get(str);
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
                List<o24> list = this.a.get(str);
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

    public final boolean e(String str, o24 o24Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, o24Var)) == null) {
            if (!TextUtils.isEmpty(str) && o24Var != null) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
