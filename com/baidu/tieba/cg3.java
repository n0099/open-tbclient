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
public final class cg3 implements zf3, bg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<ag3<?>, Set<b>> l;

    /* loaded from: classes3.dex */
    public interface b extends yi3<Set<ag3<?>>> {
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(cg3 cg3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg3Var, set, set2};
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
        public static final cg3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-891282437, "Lcom/baidu/tieba/cg3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-891282437, "Lcom/baidu/tieba/cg3$c;");
                    return;
                }
            }
            a = new cg3();
        }
    }

    public cg3() {
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

    public static cg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (cg3) invokeV.objValue;
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

    public cg3 e(ag3<?>... ag3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ag3VarArr)) == null) {
            c(Sets.newHashSet(ag3VarArr));
            return this;
        }
        return (cg3) invokeL.objValue;
    }

    public cg3 f(yf3 yf3Var) {
        InterceptResult invokeL;
        String yf3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yf3Var)) == null) {
            if (yf3Var == null) {
                yf3Var2 = "";
            } else {
                yf3Var2 = yf3Var.toString();
            }
            if (zf3.a) {
                Log.i("Tracer-ErrCode", yf3Var2);
            }
            f12.c("Tracer-ErrCode", yf3Var2);
            return this;
        }
        return (cg3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull ag3<?> ag3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ag3Var)) == null) {
            Set<b> set = this.l.get(ag3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(ag3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public cg3 c(Set<ag3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (ag3<?> ag3Var : set) {
                    hashSet.addAll(i(ag3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (cg3) invokeL.objValue;
    }

    public cg3 h(ag3<?>... ag3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ag3VarArr)) == null) {
            synchronized (this.l) {
                for (ag3<?> ag3Var : ag3VarArr) {
                    if (!this.l.containsKey(ag3Var)) {
                        this.l.put(ag3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (cg3) invokeL.objValue;
    }

    public final cg3 d(Set<b> set, Set<ag3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            xx2.j().i(new a(this, set, set2));
            return this;
        }
        return (cg3) invokeLL.objValue;
    }

    public cg3 g(b bVar, ag3<?>... ag3VarArr) {
        InterceptResult invokeLL;
        Set<ag3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, ag3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(ag3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(ag3VarArr);
                    }
                    for (ag3<?> ag3Var : newHashSet) {
                        if (ag3Var != null) {
                            i(ag3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (cg3) invokeLL.objValue;
    }

    public cg3 j(b bVar, ag3<?>... ag3VarArr) {
        InterceptResult invokeLL;
        Set<ag3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, ag3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(ag3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(ag3VarArr);
                    }
                    for (ag3<?> ag3Var : newHashSet) {
                        if (ag3Var != null) {
                            i(ag3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (cg3) invokeLL.objValue;
    }
}
