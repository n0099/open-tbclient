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
public class em0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<mm0>> a;
    public final ConcurrentHashMap<Object, ArrayList<mm0>> b;

    public em0() {
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

    public final void a(@NonNull mm0 mm0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mm0Var) == null) {
            synchronized (this) {
                ArrayList<mm0> arrayList = this.a.get(mm0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(mm0Var.b, arrayList);
                } else {
                    Iterator<mm0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == mm0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(mm0Var);
                }
                ArrayList<mm0> arrayList2 = this.b.get(mm0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(mm0Var.a, arrayList2);
                } else {
                    Iterator<mm0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == mm0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(mm0Var);
                }
            }
        }
    }

    public <T extends hm0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<mm0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<mm0> it = arrayList.iterator();
                while (it.hasNext()) {
                    mm0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends hm0> void c(@NonNull Object obj, int i, @NonNull km0<T> km0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, km0Var) == null) {
            a(new mm0(i, obj, km0Var.a(), km0Var));
        }
    }

    public <T extends hm0> void d(@NonNull Object obj, @NonNull km0<T> km0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, km0Var) == null) {
            c(obj, 0, km0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<mm0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<mm0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        mm0 next = it.next();
                        ArrayList<mm0> arrayList2 = this.a.get(next.b);
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

    public final <T extends hm0> void f(mm0 mm0Var, km0<T> km0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, mm0Var, km0Var, t) == null) {
            int i = mm0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            cm0.b().a(mm0Var, km0Var, t);
                            return;
                        }
                        return;
                    }
                    dm0.b().a(mm0Var, km0Var, t);
                    return;
                }
                lm0.b().a(mm0Var, km0Var, t);
                return;
            }
            km0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
