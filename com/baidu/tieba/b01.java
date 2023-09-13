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
/* loaded from: classes5.dex */
public abstract class b01 implements d01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<xx0>> a;
    @Nullable
    public yx0 b;
    @Nullable
    public List<yx0> c;
    @Nullable
    public List<ay0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull ww0 ww0Var);

    public b01() {
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

    @Override // com.baidu.tieba.d01
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<ay0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<yx0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.d01
    @Deprecated
    public void a(@Nullable yx0 yx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yx0Var) == null) {
            this.b = yx0Var;
        }
    }

    @Override // com.baidu.tieba.d01
    public void b(@NonNull ay0 ay0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ay0Var) == null) {
            j(ay0Var);
        }
    }

    @Override // com.baidu.tieba.d01
    public void e(xx0 xx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xx0Var) == null) {
            for (CopyOnWriteArrayList<xx0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(xx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.d01
    public void f(@NonNull ay0 ay0Var) {
        List<ay0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ay0Var) == null) && (list = this.d) != null) {
            list.remove(ay0Var);
        }
    }

    public final void h(ww0 ww0Var) {
        List<ay0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ww0Var) == null) && (list = this.d) != null) {
            for (ay0 ay0Var : list) {
                ay0Var.a(ww0Var);
            }
        }
    }

    @Override // com.baidu.tieba.d01
    public void c(int i, @NonNull xx0 xx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, xx0Var) == null) {
            CopyOnWriteArrayList<xx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(xx0Var)) {
                int expectOrder = xx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), xx0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, xx0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(xx0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.d01
    public void d(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ww0Var) == null) {
            String type = getType();
            f21.i(type, System.identityHashCode(this) + " notifyEvent " + ww0Var);
            if (ww0Var.j() == 1) {
                if (i(ww0Var)) {
                    return;
                }
                g(ww0Var);
                ww0Var.o();
                return;
            }
            l(ww0Var);
        }
    }

    public final void k(ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ww0Var) == null) {
            if (ww0Var.i() == 0) {
                String type = getType();
                f21.b(type, System.identityHashCode(this) + ": dispatch event :" + ww0Var);
                return;
            }
            String type2 = getType();
            f21.i(type2, System.identityHashCode(this) + ": dispatch event :" + ww0Var);
        }
    }

    public void g(ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ww0Var) == null) {
            k(ww0Var);
            h(ww0Var);
            CopyOnWriteArrayList<xx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ww0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<xx0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    xx0 next = it.next();
                    if (!ww0Var.b(next)) {
                        switch (ww0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(ww0Var);
                                continue;
                            case 1:
                                next.n(ww0Var);
                                continue;
                            case 2:
                                next.q(ww0Var);
                                continue;
                            case 3:
                                next.k(ww0Var);
                                continue;
                            case 4:
                                next.d(ww0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) ww0Var.f(2), (PlayerStatus) ww0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof f11) {
                                    ((f11) next).g(ww0Var);
                                    break;
                                } else {
                                    next.a(ww0Var);
                                    continue;
                                }
                            case 8:
                                next.j(ww0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(ww0 ww0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ww0Var)) == null) {
            yx0 yx0Var = this.b;
            if (yx0Var != null && yx0Var.getInterceptorLayer() != ww0Var.k() && this.b.e(ww0Var)) {
                f21.b("AbsMessenger", "isNeedIntercept() = true, event = " + ww0Var);
                ww0Var.o();
                return true;
            }
            List<yx0> list = this.c;
            if (list != null) {
                for (yx0 yx0Var2 : list) {
                    if (yx0Var2.getInterceptorLayer() != ww0Var.k() && yx0Var2.e(ww0Var)) {
                        f21.b("AbsMessenger", "isNeedIntercept() = true, event = " + ww0Var);
                        ww0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(ay0 ay0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ay0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(ay0Var)) {
                int expectOrder = ay0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<ay0> list = this.d;
                            list.add(list.size(), ay0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, ay0Var);
                    return;
                }
                this.d.add(ay0Var);
            }
        }
    }
}
