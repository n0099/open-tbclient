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
/* loaded from: classes3.dex */
public class ak0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<ik0>> a;
    public final ConcurrentHashMap<Object, ArrayList<ik0>> b;

    public ak0() {
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

    public final void a(@NonNull ik0 ik0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ik0Var) == null) {
            synchronized (this) {
                ArrayList<ik0> arrayList = this.a.get(ik0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(ik0Var.b, arrayList);
                } else {
                    Iterator<ik0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == ik0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(ik0Var);
                }
                ArrayList<ik0> arrayList2 = this.b.get(ik0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(ik0Var.a, arrayList2);
                } else {
                    Iterator<ik0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == ik0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(ik0Var);
                }
            }
        }
    }

    public <T extends dk0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<ik0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<ik0> it = arrayList.iterator();
                while (it.hasNext()) {
                    ik0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends dk0> void c(@NonNull Object obj, int i, @NonNull gk0<T> gk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, gk0Var) == null) {
            a(new ik0(i, obj, gk0Var.a(), gk0Var));
        }
    }

    public <T extends dk0> void d(@NonNull Object obj, @NonNull gk0<T> gk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, gk0Var) == null) {
            c(obj, 0, gk0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<ik0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<ik0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ik0 next = it.next();
                        ArrayList<ik0> arrayList2 = this.a.get(next.b);
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

    public final <T extends dk0> void f(ik0 ik0Var, gk0<T> gk0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, ik0Var, gk0Var, t) == null) {
            int i = ik0Var.c;
            if (i == 0) {
                gk0Var.onEvent(t);
            } else if (i == 1) {
                hk0.b().a(ik0Var, gk0Var, t);
            } else if (i == 2) {
                zj0.b().a(ik0Var, gk0Var, t);
            } else if (i != 3) {
            } else {
                yj0.b().a(ik0Var, gk0Var, t);
            }
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
