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
public final class an3 implements xm3, zm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<ym3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public interface b extends wp3<Set<ym3<?>>> {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(an3 an3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an3Var, set, set2};
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
        public static final an3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-942076092, "Lcom/baidu/tieba/an3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-942076092, "Lcom/baidu/tieba/an3$c;");
                    return;
                }
            }
            a = new an3();
        }
    }

    public an3() {
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

    public static an3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (an3) invokeV.objValue;
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

    public an3 e(ym3<?>... ym3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ym3VarArr)) == null) {
            c(Sets.newHashSet(ym3VarArr));
            return this;
        }
        return (an3) invokeL.objValue;
    }

    public an3 f(wm3 wm3Var) {
        InterceptResult invokeL;
        String wm3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wm3Var)) == null) {
            if (wm3Var == null) {
                wm3Var2 = "";
            } else {
                wm3Var2 = wm3Var.toString();
            }
            if (xm3.a) {
                Log.i("Tracer-ErrCode", wm3Var2);
            }
            d82.c("Tracer-ErrCode", wm3Var2);
            return this;
        }
        return (an3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull ym3<?> ym3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ym3Var)) == null) {
            Set<b> set = this.l.get(ym3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(ym3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public an3 c(Set<ym3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (ym3<?> ym3Var : set) {
                    hashSet.addAll(i(ym3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (an3) invokeL.objValue;
    }

    public an3 h(ym3<?>... ym3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ym3VarArr)) == null) {
            synchronized (this.l) {
                for (ym3<?> ym3Var : ym3VarArr) {
                    if (!this.l.containsKey(ym3Var)) {
                        this.l.put(ym3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (an3) invokeL.objValue;
    }

    public final an3 d(Set<b> set, Set<ym3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            v43.j().i(new a(this, set, set2));
            return this;
        }
        return (an3) invokeLL.objValue;
    }

    public an3 g(b bVar, ym3<?>... ym3VarArr) {
        InterceptResult invokeLL;
        Set<ym3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, ym3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(ym3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(ym3VarArr);
                    }
                    for (ym3<?> ym3Var : newHashSet) {
                        if (ym3Var != null) {
                            i(ym3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (an3) invokeLL.objValue;
    }

    public an3 j(b bVar, ym3<?>... ym3VarArr) {
        InterceptResult invokeLL;
        Set<ym3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, ym3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(ym3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(ym3VarArr);
                    }
                    for (ym3<?> ym3Var : newHashSet) {
                        if (ym3Var != null) {
                            i(ym3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (an3) invokeLL.objValue;
    }
}
