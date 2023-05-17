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
public final class dl3 implements al3, cl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<bl3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public interface b extends zn3<Set<bl3<?>>> {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(dl3 dl3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl3Var, set, set2};
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
        public static final dl3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-858035681, "Lcom/baidu/tieba/dl3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-858035681, "Lcom/baidu/tieba/dl3$c;");
                    return;
                }
            }
            a = new dl3();
        }
    }

    public dl3() {
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

    public static dl3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (dl3) invokeV.objValue;
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

    public dl3 e(bl3<?>... bl3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bl3VarArr)) == null) {
            c(Sets.newHashSet(bl3VarArr));
            return this;
        }
        return (dl3) invokeL.objValue;
    }

    public dl3 f(zk3 zk3Var) {
        InterceptResult invokeL;
        String zk3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zk3Var)) == null) {
            if (zk3Var == null) {
                zk3Var2 = "";
            } else {
                zk3Var2 = zk3Var.toString();
            }
            if (al3.a) {
                Log.i("Tracer-ErrCode", zk3Var2);
            }
            g62.c("Tracer-ErrCode", zk3Var2);
            return this;
        }
        return (dl3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull bl3<?> bl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bl3Var)) == null) {
            Set<b> set = this.l.get(bl3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(bl3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public dl3 c(Set<bl3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (bl3<?> bl3Var : set) {
                    hashSet.addAll(i(bl3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (dl3) invokeL.objValue;
    }

    public dl3 h(bl3<?>... bl3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bl3VarArr)) == null) {
            synchronized (this.l) {
                for (bl3<?> bl3Var : bl3VarArr) {
                    if (!this.l.containsKey(bl3Var)) {
                        this.l.put(bl3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (dl3) invokeL.objValue;
    }

    public final dl3 d(Set<b> set, Set<bl3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            y23.j().i(new a(this, set, set2));
            return this;
        }
        return (dl3) invokeLL.objValue;
    }

    public dl3 g(b bVar, bl3<?>... bl3VarArr) {
        InterceptResult invokeLL;
        Set<bl3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, bl3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(bl3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(bl3VarArr);
                    }
                    for (bl3<?> bl3Var : newHashSet) {
                        if (bl3Var != null) {
                            i(bl3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (dl3) invokeLL.objValue;
    }

    public dl3 j(b bVar, bl3<?>... bl3VarArr) {
        InterceptResult invokeLL;
        Set<bl3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, bl3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(bl3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(bl3VarArr);
                    }
                    for (bl3<?> bl3Var : newHashSet) {
                        if (bl3Var != null) {
                            i(bl3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (dl3) invokeLL.objValue;
    }
}
