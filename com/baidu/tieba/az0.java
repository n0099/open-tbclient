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
public abstract class az0 implements cz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<ww0>> a;
    @Nullable
    public xw0 b;
    @Nullable
    public List<xw0> c;
    @Nullable
    public List<zw0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull vv0 vv0Var);

    public az0() {
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

    @Override // com.baidu.tieba.cz0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<zw0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<xw0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.cz0
    @Deprecated
    public void a(@Nullable xw0 xw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xw0Var) == null) {
            this.b = xw0Var;
        }
    }

    @Override // com.baidu.tieba.cz0
    public void b(@NonNull zw0 zw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zw0Var) == null) {
            j(zw0Var);
        }
    }

    @Override // com.baidu.tieba.cz0
    public void e(ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ww0Var) == null) {
            for (CopyOnWriteArrayList<ww0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(ww0Var);
            }
        }
    }

    @Override // com.baidu.tieba.cz0
    public void f(@NonNull zw0 zw0Var) {
        List<zw0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zw0Var) == null) && (list = this.d) != null) {
            list.remove(zw0Var);
        }
    }

    public final void h(vv0 vv0Var) {
        List<zw0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vv0Var) == null) && (list = this.d) != null) {
            for (zw0 zw0Var : list) {
                zw0Var.a(vv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.cz0
    public void c(int i, @NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ww0Var) == null) {
            CopyOnWriteArrayList<ww0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(ww0Var)) {
                int expectOrder = ww0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), ww0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, ww0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(ww0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.cz0
    public void d(@NonNull vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vv0Var) == null) {
            String type = getType();
            e11.i(type, System.identityHashCode(this) + " notifyEvent " + vv0Var);
            if (vv0Var.j() == 1) {
                if (i(vv0Var)) {
                    return;
                }
                g(vv0Var);
                vv0Var.o();
                return;
            }
            l(vv0Var);
        }
    }

    public final void k(vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vv0Var) == null) {
            if (vv0Var.i() == 0) {
                String type = getType();
                e11.b(type, System.identityHashCode(this) + ": dispatch event :" + vv0Var);
                return;
            }
            String type2 = getType();
            e11.i(type2, System.identityHashCode(this) + ": dispatch event :" + vv0Var);
        }
    }

    public void g(vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vv0Var) == null) {
            k(vv0Var);
            h(vv0Var);
            CopyOnWriteArrayList<ww0> copyOnWriteArrayList = this.a.get(Integer.valueOf(vv0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<ww0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ww0 next = it.next();
                    if (!vv0Var.b(next)) {
                        switch (vv0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(vv0Var);
                                continue;
                            case 1:
                                next.n(vv0Var);
                                continue;
                            case 2:
                                next.q(vv0Var);
                                continue;
                            case 3:
                                next.k(vv0Var);
                                continue;
                            case 4:
                                next.d(vv0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) vv0Var.f(2), (PlayerStatus) vv0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof e01) {
                                    ((e01) next).g(vv0Var);
                                    break;
                                } else {
                                    next.a(vv0Var);
                                    continue;
                                }
                            case 8:
                                next.j(vv0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(vv0 vv0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vv0Var)) == null) {
            xw0 xw0Var = this.b;
            if (xw0Var != null && xw0Var.getInterceptorLayer() != vv0Var.k() && this.b.e(vv0Var)) {
                e11.b("AbsMessenger", "isNeedIntercept() = true, event = " + vv0Var);
                vv0Var.o();
                return true;
            }
            List<xw0> list = this.c;
            if (list != null) {
                for (xw0 xw0Var2 : list) {
                    if (xw0Var2.getInterceptorLayer() != vv0Var.k() && xw0Var2.e(vv0Var)) {
                        e11.b("AbsMessenger", "isNeedIntercept() = true, event = " + vv0Var);
                        vv0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(zw0 zw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zw0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(zw0Var)) {
                int expectOrder = zw0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<zw0> list = this.d;
                            list.add(list.size(), zw0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, zw0Var);
                    return;
                }
                this.d.add(zw0Var);
            }
        }
    }
}
