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
public class ao0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<jo0>> a;
    public final ConcurrentHashMap<Object, ArrayList<jo0>> b;

    public ao0() {
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

    public final void a(@NonNull jo0 jo0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jo0Var) == null) {
            synchronized (this) {
                ArrayList<jo0> arrayList = this.a.get(jo0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(jo0Var.b, arrayList);
                } else {
                    Iterator<jo0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == jo0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(jo0Var);
                }
                ArrayList<jo0> arrayList2 = this.b.get(jo0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(jo0Var.a, arrayList2);
                } else {
                    Iterator<jo0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == jo0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(jo0Var);
                }
            }
        }
    }

    public <T extends eo0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<jo0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<jo0> it = arrayList.iterator();
                while (it.hasNext()) {
                    jo0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends eo0> void c(@NonNull Object obj, int i, @NonNull ho0<T> ho0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, ho0Var) == null) {
            a(new jo0(i, obj, ho0Var.a(), ho0Var));
        }
    }

    public <T extends eo0> void d(@NonNull Object obj, @NonNull ho0<T> ho0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, ho0Var) == null) {
            c(obj, 0, ho0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<jo0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<jo0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jo0 next = it.next();
                        ArrayList<jo0> arrayList2 = this.a.get(next.b);
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

    public final <T extends eo0> void f(jo0 jo0Var, ho0<T> ho0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, jo0Var, ho0Var, t) == null) {
            int i = jo0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            yn0.b().a(jo0Var, ho0Var, t);
                            return;
                        }
                        return;
                    }
                    zn0.b().a(jo0Var, ho0Var, t);
                    return;
                }
                io0.b().a(jo0Var, ho0Var, t);
                return;
            }
            ho0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
