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
/* loaded from: classes6.dex */
public final class hi3 implements ei3, gi3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<fi3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public interface b extends dl3<Set<fi3<?>>> {
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(hi3 hi3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hi3Var, set, set2};
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

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final hi3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-746289640, "Lcom/baidu/tieba/hi3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-746289640, "Lcom/baidu/tieba/hi3$c;");
                    return;
                }
            }
            a = new hi3();
        }
    }

    public hi3() {
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

    public static hi3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (hi3) invokeV.objValue;
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

    public hi3 e(fi3<?>... fi3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fi3VarArr)) == null) {
            c(Sets.newHashSet(fi3VarArr));
            return this;
        }
        return (hi3) invokeL.objValue;
    }

    public hi3 f(di3 di3Var) {
        InterceptResult invokeL;
        String di3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, di3Var)) == null) {
            if (di3Var == null) {
                di3Var2 = "";
            } else {
                di3Var2 = di3Var.toString();
            }
            if (ei3.a) {
                Log.i("Tracer-ErrCode", di3Var2);
            }
            k32.c("Tracer-ErrCode", di3Var2);
            return this;
        }
        return (hi3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull fi3<?> fi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fi3Var)) == null) {
            Set<b> set = this.l.get(fi3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(fi3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public hi3 c(Set<fi3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (fi3<?> fi3Var : set) {
                    hashSet.addAll(i(fi3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (hi3) invokeL.objValue;
    }

    public hi3 h(fi3<?>... fi3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fi3VarArr)) == null) {
            synchronized (this.l) {
                for (fi3<?> fi3Var : fi3VarArr) {
                    if (!this.l.containsKey(fi3Var)) {
                        this.l.put(fi3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (hi3) invokeL.objValue;
    }

    public final hi3 d(Set<b> set, Set<fi3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            c03.j().i(new a(this, set, set2));
            return this;
        }
        return (hi3) invokeLL.objValue;
    }

    public hi3 g(b bVar, fi3<?>... fi3VarArr) {
        InterceptResult invokeLL;
        Set<fi3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, fi3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(fi3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(fi3VarArr);
                    }
                    for (fi3<?> fi3Var : newHashSet) {
                        if (fi3Var != null) {
                            i(fi3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (hi3) invokeLL.objValue;
    }

    public hi3 j(b bVar, fi3<?>... fi3VarArr) {
        InterceptResult invokeLL;
        Set<fi3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, fi3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(fi3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(fi3VarArr);
                    }
                    for (fi3<?> fi3Var : newHashSet) {
                        if (fi3Var != null) {
                            i(fi3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (hi3) invokeLL.objValue;
    }
}
