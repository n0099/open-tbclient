package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public abstract class ay0 implements cy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<wv0>> a;
    @Nullable
    public xv0 b;
    @Nullable
    public List<xv0> c;
    @Nullable
    public List<zv0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull vu0 vu0Var);

    public ay0() {
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
    }

    @Override // com.baidu.tieba.cy0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<zv0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<xv0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.cy0
    @Deprecated
    public void a(@Nullable xv0 xv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xv0Var) == null) {
            this.b = xv0Var;
        }
    }

    @Override // com.baidu.tieba.cy0
    public void b(@NonNull zv0 zv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zv0Var) == null) {
            j(zv0Var);
        }
    }

    @Override // com.baidu.tieba.cy0
    public void e(wv0 wv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wv0Var) == null) {
            for (CopyOnWriteArrayList<wv0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(wv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.cy0
    public void f(@NonNull zv0 zv0Var) {
        List<zv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zv0Var) == null) && (list = this.d) != null) {
            list.remove(zv0Var);
        }
    }

    public final void h(vu0 vu0Var) {
        List<zv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vu0Var) == null) && (list = this.d) != null) {
            for (zv0 zv0Var : list) {
                zv0Var.a(vu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.cy0
    public void c(int i, @NonNull wv0 wv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wv0Var) == null) {
            CopyOnWriteArrayList<wv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(wv0Var)) {
                int expectOrder = wv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), wv0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, wv0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(wv0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.cy0
    public void d(@NonNull vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vu0Var) == null) {
            String type = getType();
            f01.i(type, System.identityHashCode(this) + " notifyEvent " + vu0Var);
            if (vu0Var.j() == 1) {
                if (i(vu0Var)) {
                    return;
                }
                g(vu0Var);
                vu0Var.o();
                return;
            }
            l(vu0Var);
        }
    }

    public final void k(vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vu0Var) == null) {
            if (vu0Var.i() == 0) {
                String type = getType();
                f01.b(type, System.identityHashCode(this) + ": dispatch event :" + vu0Var);
                return;
            }
            String type2 = getType();
            f01.i(type2, System.identityHashCode(this) + ": dispatch event :" + vu0Var);
        }
    }

    public void g(vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vu0Var) == null) {
            k(vu0Var);
            h(vu0Var);
            CopyOnWriteArrayList<wv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(vu0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<wv0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    wv0 next = it.next();
                    if (!vu0Var.b(next)) {
                        switch (vu0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(vu0Var);
                                continue;
                            case 1:
                                next.n(vu0Var);
                                continue;
                            case 2:
                                next.q(vu0Var);
                                continue;
                            case 3:
                                next.k(vu0Var);
                                continue;
                            case 4:
                                next.d(vu0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) vu0Var.f(2), (PlayerStatus) vu0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof ez0) {
                                    ((ez0) next).g(vu0Var);
                                    break;
                                } else {
                                    next.a(vu0Var);
                                    continue;
                                }
                            case 8:
                                next.j(vu0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(vu0 vu0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vu0Var)) == null) {
            xv0 xv0Var = this.b;
            if (xv0Var != null && xv0Var.getInterceptorLayer() != vu0Var.k() && this.b.e(vu0Var)) {
                f01.b("AbsMessenger", "isNeedIntercept() = true, event = " + vu0Var);
                vu0Var.o();
                return true;
            }
            List<xv0> list = this.c;
            if (list != null) {
                for (xv0 xv0Var2 : list) {
                    if (xv0Var2.getInterceptorLayer() != vu0Var.k() && xv0Var2.e(vu0Var)) {
                        f01.b("AbsMessenger", "isNeedIntercept() = true, event = " + vu0Var);
                        vu0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(zv0 zv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zv0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(zv0Var)) {
                int expectOrder = zv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<zv0> list = this.d;
                            list.add(list.size(), zv0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, zv0Var);
                    return;
                }
                this.d.add(zv0Var);
            }
        }
    }
}
