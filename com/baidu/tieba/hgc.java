package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public class hgc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hgc c;
    public transient /* synthetic */ FieldHolder $fh;
    public TreeMap<Integer, a> a;
    public TreeMap<Integer, TreeSet<String>> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947824197, "Lcom/baidu/tieba/hgc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947824197, "Lcom/baidu/tieba/hgc;");
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;

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
                    return;
                }
            }
            this.a = false;
            this.b = false;
        }
    }

    public hgc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new TreeMap<>();
        this.b = new TreeMap<>();
    }

    public static hgc c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (hgc.class) {
                    if (c == null) {
                        c = new hgc();
                    }
                }
            }
            return c;
        }
        return (hgc) invokeV.objValue;
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                size = this.b.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized int d() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                size = this.a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized int b() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = 0;
                for (Map.Entry<Integer, TreeSet<String>> entry : this.b.entrySet()) {
                    i += entry.getValue().size();
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int f() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                i = 0;
                for (Map.Entry<Integer, a> entry : this.a.entrySet()) {
                    if (entry.getValue().a && entry.getValue().b) {
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int i() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = 0;
                for (Map.Entry<Integer, a> entry : this.a.entrySet()) {
                    if (entry.getValue().a) {
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized void e(eec eecVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eecVar) == null) {
            synchronized (this) {
                if (eecVar != null) {
                    if (!this.a.containsKey(Integer.valueOf(eecVar.hashCode()))) {
                        this.a.put(Integer.valueOf(eecVar.hashCode()), new a());
                    }
                }
            }
        }
    }

    public synchronized void h(eec eecVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eecVar) == null) {
            synchronized (this) {
                if (eecVar != null) {
                    if (this.a.containsKey(Integer.valueOf(eecVar.hashCode())) && (aVar = this.a.get(Integer.valueOf(eecVar.hashCode()))) != null) {
                        aVar.a = false;
                        aVar.b = false;
                    }
                }
            }
        }
    }

    public synchronized void g(eec eecVar, int i, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{eecVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (eecVar != null) {
                    if (this.a.containsKey(Integer.valueOf(eecVar.hashCode())) && (aVar = this.a.get(Integer.valueOf(eecVar.hashCode()))) != null) {
                        aVar.a = true;
                        aVar.b = z;
                    }
                }
            }
        }
    }
}
