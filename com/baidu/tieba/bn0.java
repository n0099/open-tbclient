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
public class bn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<kn0>> a;
    public final ConcurrentHashMap<Object, ArrayList<kn0>> b;

    public bn0() {
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

    public final void a(@NonNull kn0 kn0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kn0Var) == null) {
            synchronized (this) {
                ArrayList<kn0> arrayList = this.a.get(kn0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(kn0Var.b, arrayList);
                } else {
                    Iterator<kn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == kn0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(kn0Var);
                }
                ArrayList<kn0> arrayList2 = this.b.get(kn0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(kn0Var.a, arrayList2);
                } else {
                    Iterator<kn0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == kn0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(kn0Var);
                }
            }
        }
    }

    public <T extends fn0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<kn0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<kn0> it = arrayList.iterator();
                while (it.hasNext()) {
                    kn0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends fn0> void c(@NonNull Object obj, int i, @NonNull in0<T> in0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, in0Var) == null) {
            a(new kn0(i, obj, in0Var.a(), in0Var));
        }
    }

    public <T extends fn0> void d(@NonNull Object obj, @NonNull in0<T> in0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, in0Var) == null) {
            c(obj, 0, in0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<kn0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<kn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        kn0 next = it.next();
                        ArrayList<kn0> arrayList2 = this.a.get(next.b);
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

    public final <T extends fn0> void f(kn0 kn0Var, in0<T> in0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, kn0Var, in0Var, t) == null) {
            int i = kn0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            zm0.b().a(kn0Var, in0Var, t);
                            return;
                        }
                        return;
                    }
                    an0.b().a(kn0Var, in0Var, t);
                    return;
                }
                jn0.b().a(kn0Var, in0Var, t);
                return;
            }
            in0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
