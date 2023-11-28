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
public final class ei3 implements bi3, di3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<ci3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public interface b extends al3<Set<ci3<?>>> {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(ei3 ei3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var, set, set2};
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
        public static final ei3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-832177093, "Lcom/baidu/tieba/ei3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-832177093, "Lcom/baidu/tieba/ei3$c;");
                    return;
                }
            }
            a = new ei3();
        }
    }

    public ei3() {
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

    public static ei3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (ei3) invokeV.objValue;
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

    public ei3 e(ci3<?>... ci3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ci3VarArr)) == null) {
            c(Sets.newHashSet(ci3VarArr));
            return this;
        }
        return (ei3) invokeL.objValue;
    }

    public ei3 f(ai3 ai3Var) {
        InterceptResult invokeL;
        String ai3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ai3Var)) == null) {
            if (ai3Var == null) {
                ai3Var2 = "";
            } else {
                ai3Var2 = ai3Var.toString();
            }
            if (bi3.a) {
                Log.i("Tracer-ErrCode", ai3Var2);
            }
            h32.c("Tracer-ErrCode", ai3Var2);
            return this;
        }
        return (ei3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull ci3<?> ci3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ci3Var)) == null) {
            Set<b> set = this.l.get(ci3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(ci3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public ei3 c(Set<ci3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (ci3<?> ci3Var : set) {
                    hashSet.addAll(i(ci3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (ei3) invokeL.objValue;
    }

    public ei3 h(ci3<?>... ci3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ci3VarArr)) == null) {
            synchronized (this.l) {
                for (ci3<?> ci3Var : ci3VarArr) {
                    if (!this.l.containsKey(ci3Var)) {
                        this.l.put(ci3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (ei3) invokeL.objValue;
    }

    public final ei3 d(Set<b> set, Set<ci3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            zz2.j().i(new a(this, set, set2));
            return this;
        }
        return (ei3) invokeLL.objValue;
    }

    public ei3 g(b bVar, ci3<?>... ci3VarArr) {
        InterceptResult invokeLL;
        Set<ci3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, ci3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(ci3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(ci3VarArr);
                    }
                    for (ci3<?> ci3Var : newHashSet) {
                        if (ci3Var != null) {
                            i(ci3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (ei3) invokeLL.objValue;
    }

    public ei3 j(b bVar, ci3<?>... ci3VarArr) {
        InterceptResult invokeLL;
        Set<ci3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, ci3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(ci3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(ci3VarArr);
                    }
                    for (ci3<?> ci3Var : newHashSet) {
                        if (ci3Var != null) {
                            i(ci3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (ei3) invokeLL.objValue;
    }
}
