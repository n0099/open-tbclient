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
public final class en3 implements bn3, dn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<cn3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public interface b extends aq3<Set<cn3<?>>> {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(en3 en3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en3Var, set, set2};
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
        public static final en3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-827559488, "Lcom/baidu/tieba/en3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-827559488, "Lcom/baidu/tieba/en3$c;");
                    return;
                }
            }
            a = new en3();
        }
    }

    public en3() {
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

    public static en3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (en3) invokeV.objValue;
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

    public en3 e(cn3<?>... cn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cn3VarArr)) == null) {
            c(Sets.newHashSet(cn3VarArr));
            return this;
        }
        return (en3) invokeL.objValue;
    }

    public en3 f(an3 an3Var) {
        InterceptResult invokeL;
        String an3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, an3Var)) == null) {
            if (an3Var == null) {
                an3Var2 = "";
            } else {
                an3Var2 = an3Var.toString();
            }
            if (bn3.a) {
                Log.i("Tracer-ErrCode", an3Var2);
            }
            h82.c("Tracer-ErrCode", an3Var2);
            return this;
        }
        return (en3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull cn3<?> cn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cn3Var)) == null) {
            Set<b> set = this.l.get(cn3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(cn3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public en3 c(Set<cn3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (cn3<?> cn3Var : set) {
                    hashSet.addAll(i(cn3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (en3) invokeL.objValue;
    }

    public en3 h(cn3<?>... cn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cn3VarArr)) == null) {
            synchronized (this.l) {
                for (cn3<?> cn3Var : cn3VarArr) {
                    if (!this.l.containsKey(cn3Var)) {
                        this.l.put(cn3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (en3) invokeL.objValue;
    }

    public final en3 d(Set<b> set, Set<cn3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            z43.j().i(new a(this, set, set2));
            return this;
        }
        return (en3) invokeLL.objValue;
    }

    public en3 g(b bVar, cn3<?>... cn3VarArr) {
        InterceptResult invokeLL;
        Set<cn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, cn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(cn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(cn3VarArr);
                    }
                    for (cn3<?> cn3Var : newHashSet) {
                        if (cn3Var != null) {
                            i(cn3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (en3) invokeLL.objValue;
    }

    public en3 j(b bVar, cn3<?>... cn3VarArr) {
        InterceptResult invokeLL;
        Set<cn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, cn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(cn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(cn3VarArr);
                    }
                    for (cn3<?> cn3Var : newHashSet) {
                        if (cn3Var != null) {
                            i(cn3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (en3) invokeLL.objValue;
    }
}
