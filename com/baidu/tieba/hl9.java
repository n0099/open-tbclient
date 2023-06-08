package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class hl9 {
    public static /* synthetic */ Interceptable $ic;
    public static hl9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> a;
    public HashMap<String, String> b;
    public ConcurrentHashMap<String, il9> c;

    public hl9() {
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
        this.b = new HashMap<>();
        this.c = new ConcurrentHashMap<>();
    }

    public static hl9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (hl9.class) {
                    if (d == null) {
                        d = new hl9();
                    }
                }
            }
            return d;
        }
        return (hl9) invokeV.objValue;
    }

    public ConcurrentHashMap<String, il9> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    public il9 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            HashMap<String, String> hashMap = this.a;
            if (hashMap == null || this.c == null) {
                return null;
            }
            String str2 = hashMap.get(str);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return this.c.get(str2);
        }
        return (il9) invokeL.objValue;
    }

    public void f(String str) {
        ConcurrentHashMap<String, il9> concurrentHashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str) && (concurrentHashMap = this.c) != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                il9 il9Var = this.c.get(it.next());
                if (il9Var != null && str.equals(il9Var.b)) {
                    it.remove();
                }
            }
        }
    }

    public void g(boolean z) {
        ConcurrentHashMap<String, il9> concurrentHashMap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || (concurrentHashMap = this.c) == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            il9 il9Var = this.c.get(str);
            if (il9Var != null) {
                il9Var.e = z;
            }
        }
    }

    public il9 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ConcurrentHashMap<String, il9> concurrentHashMap = this.c;
            if (concurrentHashMap == null) {
                return null;
            }
            return concurrentHashMap.get(str);
        }
        return (il9) invokeL.objValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap<String, String> hashMap = this.b;
            if (hashMap == null) {
                return null;
            }
            return hashMap.get(str);
        }
        return (String) invokeL.objValue;
    }

    public void i(HashMap<String, il9> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            this.c.clear();
            if (hashMap == null) {
                return;
            }
            this.c.putAll(hashMap);
        }
    }

    public void h(boolean z, String str) {
        ConcurrentHashMap<String, il9> concurrentHashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) && !TextUtils.isEmpty(str) && (concurrentHashMap = this.c) != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                il9 il9Var = this.c.get(str2);
                if (il9Var != null && str.equals(il9Var.b)) {
                    il9Var.e = z;
                }
            }
        }
    }

    public void j(String str, String str2) {
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (hashMap = this.a) != null) {
            hashMap.put(str, str2);
        }
    }

    public void k(String str, String str2) {
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (hashMap = this.b) != null) {
            hashMap.put(str, str2);
        }
    }

    public void l(String str, HashMap<String, il9> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, hashMap) == null) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap<>();
            }
            f(str);
            this.c.putAll(hashMap);
        }
    }
}
