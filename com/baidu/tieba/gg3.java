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
/* loaded from: classes4.dex */
public final class gg3 implements dg3, fg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<eg3<?>, Set<b>> l;

    /* loaded from: classes4.dex */
    public interface b extends cj3<Set<eg3<?>>> {
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(gg3 gg3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg3Var, set, set2};
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

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final gg3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-776765833, "Lcom/baidu/tieba/gg3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-776765833, "Lcom/baidu/tieba/gg3$c;");
                    return;
                }
            }
            a = new gg3();
        }
    }

    public gg3() {
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

    public static gg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (gg3) invokeV.objValue;
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

    public gg3 e(eg3<?>... eg3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eg3VarArr)) == null) {
            c(Sets.newHashSet(eg3VarArr));
            return this;
        }
        return (gg3) invokeL.objValue;
    }

    public gg3 f(cg3 cg3Var) {
        InterceptResult invokeL;
        String cg3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cg3Var)) == null) {
            if (cg3Var == null) {
                cg3Var2 = "";
            } else {
                cg3Var2 = cg3Var.toString();
            }
            if (dg3.a) {
                Log.i("Tracer-ErrCode", cg3Var2);
            }
            j12.c("Tracer-ErrCode", cg3Var2);
            return this;
        }
        return (gg3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull eg3<?> eg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eg3Var)) == null) {
            Set<b> set = this.l.get(eg3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(eg3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public gg3 c(Set<eg3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (eg3<?> eg3Var : set) {
                    hashSet.addAll(i(eg3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (gg3) invokeL.objValue;
    }

    public gg3 h(eg3<?>... eg3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eg3VarArr)) == null) {
            synchronized (this.l) {
                for (eg3<?> eg3Var : eg3VarArr) {
                    if (!this.l.containsKey(eg3Var)) {
                        this.l.put(eg3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (gg3) invokeL.objValue;
    }

    public final gg3 d(Set<b> set, Set<eg3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            by2.j().i(new a(this, set, set2));
            return this;
        }
        return (gg3) invokeLL.objValue;
    }

    public gg3 g(b bVar, eg3<?>... eg3VarArr) {
        InterceptResult invokeLL;
        Set<eg3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, eg3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(eg3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(eg3VarArr);
                    }
                    for (eg3<?> eg3Var : newHashSet) {
                        if (eg3Var != null) {
                            i(eg3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (gg3) invokeLL.objValue;
    }

    public gg3 j(b bVar, eg3<?>... eg3VarArr) {
        InterceptResult invokeLL;
        Set<eg3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, eg3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(eg3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(eg3VarArr);
                    }
                    for (eg3<?> eg3Var : newHashSet) {
                        if (eg3Var != null) {
                            i(eg3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (gg3) invokeLL.objValue;
    }
}
