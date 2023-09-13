package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class cn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<ln0>> a;
    public final ConcurrentHashMap<Object, ArrayList<ln0>> b;

    public cn0() {
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
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public final void a(@NonNull ln0 ln0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ln0Var) == null) {
            synchronized (this) {
                ArrayList<ln0> arrayList = this.a.get(ln0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(ln0Var.b, arrayList);
                } else {
                    Iterator<ln0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == ln0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(ln0Var);
                }
                ArrayList<ln0> arrayList2 = this.b.get(ln0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(ln0Var.a, arrayList2);
                } else {
                    Iterator<ln0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == ln0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(ln0Var);
                }
            }
        }
    }

    public <T extends gn0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<ln0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<ln0> it = arrayList.iterator();
                while (it.hasNext()) {
                    ln0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends gn0> void c(@NonNull Object obj, int i, @NonNull jn0<T> jn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, jn0Var) == null) {
            a(new ln0(i, obj, jn0Var.a(), jn0Var));
        }
    }

    public <T extends gn0> void d(@NonNull Object obj, @NonNull jn0<T> jn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, jn0Var) == null) {
            c(obj, 0, jn0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<ln0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<ln0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ln0 next = it.next();
                        ArrayList<ln0> arrayList2 = this.a.get(next.b);
                        if (arrayList2 != null) {
                            arrayList2.remove(next);
                        }
                    }
                    arrayList.clear();
                    this.b.remove(obj);
                }
            }
        }
    }

    public final <T extends gn0> void f(ln0 ln0Var, jn0<T> jn0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, ln0Var, jn0Var, t) == null) {
            int i = ln0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            an0.b().a(ln0Var, jn0Var, t);
                            return;
                        }
                        return;
                    }
                    bn0.b().a(ln0Var, jn0Var, t);
                    return;
                }
                kn0.b().a(ln0Var, jn0Var, t);
                return;
            }
            jn0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
