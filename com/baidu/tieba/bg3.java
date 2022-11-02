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
/* loaded from: classes3.dex */
public final class bg3 implements yf3, ag3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<zf3<?>, Set<b>> l;

    /* loaded from: classes3.dex */
    public interface b extends xi3<Set<zf3<?>>> {
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(bg3 bg3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bg3Var, set, set2};
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

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final bg3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-919911588, "Lcom/baidu/tieba/bg3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-919911588, "Lcom/baidu/tieba/bg3$c;");
                    return;
                }
            }
            a = new bg3();
        }
    }

    public bg3() {
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

    public static bg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (bg3) invokeV.objValue;
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

    public bg3 e(zf3<?>... zf3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zf3VarArr)) == null) {
            c(Sets.newHashSet(zf3VarArr));
            return this;
        }
        return (bg3) invokeL.objValue;
    }

    public bg3 f(xf3 xf3Var) {
        InterceptResult invokeL;
        String xf3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xf3Var)) == null) {
            if (xf3Var == null) {
                xf3Var2 = "";
            } else {
                xf3Var2 = xf3Var.toString();
            }
            if (yf3.a) {
                Log.i("Tracer-ErrCode", xf3Var2);
            }
            e12.c("Tracer-ErrCode", xf3Var2);
            return this;
        }
        return (bg3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull zf3<?> zf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zf3Var)) == null) {
            Set<b> set = this.l.get(zf3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(zf3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public bg3 c(Set<zf3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (zf3<?> zf3Var : set) {
                    hashSet.addAll(i(zf3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (bg3) invokeL.objValue;
    }

    public bg3 h(zf3<?>... zf3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zf3VarArr)) == null) {
            synchronized (this.l) {
                for (zf3<?> zf3Var : zf3VarArr) {
                    if (!this.l.containsKey(zf3Var)) {
                        this.l.put(zf3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (bg3) invokeL.objValue;
    }

    public final bg3 d(Set<b> set, Set<zf3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            wx2.j().i(new a(this, set, set2));
            return this;
        }
        return (bg3) invokeLL.objValue;
    }

    public bg3 g(b bVar, zf3<?>... zf3VarArr) {
        InterceptResult invokeLL;
        Set<zf3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, zf3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(zf3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(zf3VarArr);
                    }
                    for (zf3<?> zf3Var : newHashSet) {
                        if (zf3Var != null) {
                            i(zf3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (bg3) invokeLL.objValue;
    }

    public bg3 j(b bVar, zf3<?>... zf3VarArr) {
        InterceptResult invokeLL;
        Set<zf3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, zf3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(zf3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(zf3VarArr);
                    }
                    for (zf3<?> zf3Var : newHashSet) {
                        if (zf3Var != null) {
                            i(zf3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (bg3) invokeLL.objValue;
    }
}
