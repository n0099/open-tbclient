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
public final class dn3 implements an3, cn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<bn3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public interface b extends zp3<Set<bn3<?>>> {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(dn3 dn3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn3Var, set, set2};
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
        public static final dn3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-856188639, "Lcom/baidu/tieba/dn3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-856188639, "Lcom/baidu/tieba/dn3$c;");
                    return;
                }
            }
            a = new dn3();
        }
    }

    public dn3() {
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

    public static dn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (dn3) invokeV.objValue;
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

    public dn3 e(bn3<?>... bn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bn3VarArr)) == null) {
            c(Sets.newHashSet(bn3VarArr));
            return this;
        }
        return (dn3) invokeL.objValue;
    }

    public dn3 f(zm3 zm3Var) {
        InterceptResult invokeL;
        String zm3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zm3Var)) == null) {
            if (zm3Var == null) {
                zm3Var2 = "";
            } else {
                zm3Var2 = zm3Var.toString();
            }
            if (an3.a) {
                Log.i("Tracer-ErrCode", zm3Var2);
            }
            g82.c("Tracer-ErrCode", zm3Var2);
            return this;
        }
        return (dn3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull bn3<?> bn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bn3Var)) == null) {
            Set<b> set = this.l.get(bn3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(bn3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public dn3 c(Set<bn3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (bn3<?> bn3Var : set) {
                    hashSet.addAll(i(bn3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (dn3) invokeL.objValue;
    }

    public dn3 h(bn3<?>... bn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bn3VarArr)) == null) {
            synchronized (this.l) {
                for (bn3<?> bn3Var : bn3VarArr) {
                    if (!this.l.containsKey(bn3Var)) {
                        this.l.put(bn3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (dn3) invokeL.objValue;
    }

    public final dn3 d(Set<b> set, Set<bn3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            y43.j().i(new a(this, set, set2));
            return this;
        }
        return (dn3) invokeLL.objValue;
    }

    public dn3 g(b bVar, bn3<?>... bn3VarArr) {
        InterceptResult invokeLL;
        Set<bn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, bn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(bn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(bn3VarArr);
                    }
                    for (bn3<?> bn3Var : newHashSet) {
                        if (bn3Var != null) {
                            i(bn3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (dn3) invokeLL.objValue;
    }

    public dn3 j(b bVar, bn3<?>... bn3VarArr) {
        InterceptResult invokeLL;
        Set<bn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(bn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(bn3VarArr);
                    }
                    for (bn3<?> bn3Var : newHashSet) {
                        if (bn3Var != null) {
                            i(bn3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (dn3) invokeLL.objValue;
    }
}
