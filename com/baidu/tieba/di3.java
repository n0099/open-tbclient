package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public final class di3 implements ai3, ci3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<bi3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public interface b extends zk3<Set<bi3<?>>> {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(di3 di3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {di3Var, set, set2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
            this.b = set2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b bVar : this.a) {
                    bVar.a(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final di3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-860806244, "Lcom/baidu/tieba/di3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-860806244, "Lcom/baidu/tieba/di3$c;");
                    return;
                }
            }
            a = new di3();
        }
    }

    public di3() {
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
        this.l = new HashMap();
    }

    public static di3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (di3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) {
            if (tArr == null || tArr.length < 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public di3 e(bi3<?>... bi3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bi3VarArr)) == null) {
            c(Sets.newHashSet(bi3VarArr));
            return this;
        }
        return (di3) invokeL.objValue;
    }

    public di3 f(zh3 zh3Var) {
        InterceptResult invokeL;
        String zh3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zh3Var)) == null) {
            if (zh3Var == null) {
                zh3Var2 = "";
            } else {
                zh3Var2 = zh3Var.toString();
            }
            if (ai3.a) {
                Log.i("Tracer-ErrCode", zh3Var2);
            }
            g32.c("Tracer-ErrCode", zh3Var2);
            return this;
        }
        return (di3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull bi3<?> bi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bi3Var)) == null) {
            Set<b> set = this.l.get(bi3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(bi3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public di3 c(Set<bi3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (bi3<?> bi3Var : set) {
                    hashSet.addAll(i(bi3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (di3) invokeL.objValue;
    }

    public di3 h(bi3<?>... bi3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bi3VarArr)) == null) {
            synchronized (this.l) {
                for (bi3<?> bi3Var : bi3VarArr) {
                    if (!this.l.containsKey(bi3Var)) {
                        this.l.put(bi3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (di3) invokeL.objValue;
    }

    public final di3 d(Set<b> set, Set<bi3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            yz2.j().i(new a(this, set, set2));
            return this;
        }
        return (di3) invokeLL.objValue;
    }

    public di3 g(b bVar, bi3<?>... bi3VarArr) {
        InterceptResult invokeLL;
        Set<bi3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, bi3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(bi3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(bi3VarArr);
                    }
                    for (bi3<?> bi3Var : newHashSet) {
                        if (bi3Var != null) {
                            i(bi3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (di3) invokeLL.objValue;
    }

    public di3 j(b bVar, bi3<?>... bi3VarArr) {
        InterceptResult invokeLL;
        Set<bi3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bi3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(bi3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(bi3VarArr);
                    }
                    for (bi3<?> bi3Var : newHashSet) {
                        if (bi3Var != null) {
                            i(bi3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (di3) invokeLL.objValue;
    }
}
