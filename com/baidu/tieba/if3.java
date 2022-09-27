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
public final class if3 implements ff3, hf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<gf3<?>, Set<b>> l;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(if3 if3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if3Var, set, set2};
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
    public interface b extends ei3<Set<gf3<?>>> {
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final if3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-720431052, "Lcom/baidu/tieba/if3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-720431052, "Lcom/baidu/tieba/if3$c;");
                    return;
                }
            }
            a = new if3();
        }
    }

    public if3() {
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

    public static if3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (if3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public if3 c(Set<gf3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (gf3<?> gf3Var : set) {
                    hashSet.addAll(i(gf3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (if3) invokeL.objValue;
    }

    public final if3 d(Set<b> set, Set<gf3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            dx2.j().i(new a(this, set, set2));
            return this;
        }
        return (if3) invokeLL.objValue;
    }

    public if3 e(gf3<?>... gf3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gf3VarArr)) == null) {
            c(Sets.newHashSet(gf3VarArr));
            return this;
        }
        return (if3) invokeL.objValue;
    }

    public if3 f(ef3 ef3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ef3Var)) == null) {
            String ef3Var2 = ef3Var == null ? "" : ef3Var.toString();
            if (ff3.a) {
                Log.i("Tracer-ErrCode", ef3Var2);
            }
            l02.c("Tracer-ErrCode", ef3Var2);
            return this;
        }
        return (if3) invokeL.objValue;
    }

    public if3 g(b bVar, gf3<?>... gf3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, gf3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<gf3<?>> keySet = b(gf3VarArr) ? this.l.keySet() : Sets.newHashSet(gf3VarArr);
                    for (gf3<?> gf3Var : keySet) {
                        if (gf3Var != null) {
                            i(gf3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (if3) invokeLL.objValue;
    }

    public if3 h(gf3<?>... gf3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gf3VarArr)) == null) {
            synchronized (this.l) {
                for (gf3<?> gf3Var : gf3VarArr) {
                    if (!this.l.containsKey(gf3Var)) {
                        this.l.put(gf3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (if3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull gf3<?> gf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gf3Var)) == null) {
            Set<b> set = this.l.get(gf3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(gf3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public if3 j(b bVar, gf3<?>... gf3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, gf3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (gf3<?> gf3Var : b(gf3VarArr) ? this.l.keySet() : Sets.newHashSet(gf3VarArr)) {
                        if (gf3Var != null) {
                            i(gf3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (if3) invokeLL.objValue;
    }
}
