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
public class am0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<im0>> a;
    public final ConcurrentHashMap<Object, ArrayList<im0>> b;

    public am0() {
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

    public final void a(@NonNull im0 im0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, im0Var) == null) {
            synchronized (this) {
                ArrayList<im0> arrayList = this.a.get(im0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(im0Var.b, arrayList);
                } else {
                    Iterator<im0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == im0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(im0Var);
                }
                ArrayList<im0> arrayList2 = this.b.get(im0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(im0Var.a, arrayList2);
                } else {
                    Iterator<im0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == im0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(im0Var);
                }
            }
        }
    }

    public <T extends dm0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<im0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<im0> it = arrayList.iterator();
                while (it.hasNext()) {
                    im0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends dm0> void c(@NonNull Object obj, int i, @NonNull gm0<T> gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, gm0Var) == null) {
            a(new im0(i, obj, gm0Var.a(), gm0Var));
        }
    }

    public <T extends dm0> void d(@NonNull Object obj, @NonNull gm0<T> gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, gm0Var) == null) {
            c(obj, 0, gm0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<im0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<im0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        im0 next = it.next();
                        ArrayList<im0> arrayList2 = this.a.get(next.b);
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

    public final <T extends dm0> void f(im0 im0Var, gm0<T> gm0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, im0Var, gm0Var, t) == null) {
            int i = im0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            yl0.b().a(im0Var, gm0Var, t);
                            return;
                        }
                        return;
                    }
                    zl0.b().a(im0Var, gm0Var, t);
                    return;
                }
                hm0.b().a(im0Var, gm0Var, t);
                return;
            }
            gm0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
