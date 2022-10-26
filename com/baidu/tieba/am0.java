package com.baidu.tieba;

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
    public final ConcurrentHashMap a;
    public final ConcurrentHashMap b;

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
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public final void a(im0 im0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, im0Var) == null) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.a.get(im0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.a.put(im0Var.b, arrayList);
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((im0) it.next()).a == im0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(im0Var);
                }
                ArrayList arrayList2 = (ArrayList) this.b.get(im0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    this.b.put(im0Var.a, arrayList2);
                } else {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (((im0) it2.next()).d == im0Var.d) {
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

    public void b(dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm0Var) != null) || dm0Var == null) {
            return;
        }
        synchronized (this) {
            ArrayList arrayList = (ArrayList) this.a.get(dm0Var.getClass());
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    im0 im0Var = (im0) it.next();
                    f(im0Var, im0Var.d, dm0Var);
                }
            }
        }
    }

    public void c(Object obj, int i, gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, gm0Var) == null) {
            a(new im0(i, obj, gm0Var.a(), gm0Var));
        }
    }

    public void d(Object obj, gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, gm0Var) == null) {
            c(obj, 0, gm0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.b.get(obj);
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        im0 im0Var = (im0) it.next();
                        ArrayList arrayList2 = (ArrayList) this.a.get(im0Var.b);
                        if (arrayList2 != null) {
                            arrayList2.remove(im0Var);
                        }
                    }
                    arrayList.clear();
                    this.b.remove(obj);
                }
            }
        }
    }

    public final void f(im0 im0Var, gm0 gm0Var, dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, im0Var, gm0Var, dm0Var) == null) {
            int i = im0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            yl0.b().a(im0Var, gm0Var, dm0Var);
                            return;
                        }
                        return;
                    }
                    zl0.b().a(im0Var, gm0Var, dm0Var);
                    return;
                }
                hm0.b().a(im0Var, gm0Var, dm0Var);
                return;
            }
            gm0Var.onEvent(dm0Var);
        }
    }

    public void g(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
