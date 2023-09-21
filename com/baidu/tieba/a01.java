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
public abstract class a01 implements c01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<wx0>> a;
    @Nullable
    public xx0 b;
    @Nullable
    public List<xx0> c;
    @Nullable
    public List<zx0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull vw0 vw0Var);

    public a01() {
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

    @Override // com.baidu.tieba.c01
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<zx0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<xx0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.c01
    @Deprecated
    public void a(@Nullable xx0 xx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xx0Var) == null) {
            this.b = xx0Var;
        }
    }

    @Override // com.baidu.tieba.c01
    public void b(@NonNull zx0 zx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zx0Var) == null) {
            j(zx0Var);
        }
    }

    @Override // com.baidu.tieba.c01
    public void e(wx0 wx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wx0Var) == null) {
            for (CopyOnWriteArrayList<wx0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(wx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.c01
    public void f(@NonNull zx0 zx0Var) {
        List<zx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zx0Var) == null) && (list = this.d) != null) {
            list.remove(zx0Var);
        }
    }

    public final void h(vw0 vw0Var) {
        List<zx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vw0Var) == null) && (list = this.d) != null) {
            for (zx0 zx0Var : list) {
                zx0Var.a(vw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.c01
    public void c(int i, @NonNull wx0 wx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wx0Var) == null) {
            CopyOnWriteArrayList<wx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(wx0Var)) {
                int expectOrder = wx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), wx0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, wx0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(wx0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.c01
    public void d(@NonNull vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vw0Var) == null) {
            String type = getType();
            e21.i(type, System.identityHashCode(this) + " notifyEvent " + vw0Var);
            if (vw0Var.j() == 1) {
                if (i(vw0Var)) {
                    return;
                }
                g(vw0Var);
                vw0Var.o();
                return;
            }
            l(vw0Var);
        }
    }

    public final void k(vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vw0Var) == null) {
            if (vw0Var.i() == 0) {
                String type = getType();
                e21.b(type, System.identityHashCode(this) + ": dispatch event :" + vw0Var);
                return;
            }
            String type2 = getType();
            e21.i(type2, System.identityHashCode(this) + ": dispatch event :" + vw0Var);
        }
    }

    public void g(vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vw0Var) == null) {
            k(vw0Var);
            h(vw0Var);
            CopyOnWriteArrayList<wx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(vw0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<wx0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    wx0 next = it.next();
                    if (!vw0Var.b(next)) {
                        switch (vw0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(vw0Var);
                                continue;
                            case 1:
                                next.n(vw0Var);
                                continue;
                            case 2:
                                next.q(vw0Var);
                                continue;
                            case 3:
                                next.k(vw0Var);
                                continue;
                            case 4:
                                next.d(vw0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) vw0Var.f(2), (PlayerStatus) vw0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof e11) {
                                    ((e11) next).g(vw0Var);
                                    break;
                                } else {
                                    next.a(vw0Var);
                                    continue;
                                }
                            case 8:
                                next.j(vw0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(vw0 vw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vw0Var)) == null) {
            xx0 xx0Var = this.b;
            if (xx0Var != null && xx0Var.getInterceptorLayer() != vw0Var.k() && this.b.e(vw0Var)) {
                e21.b("AbsMessenger", "isNeedIntercept() = true, event = " + vw0Var);
                vw0Var.o();
                return true;
            }
            List<xx0> list = this.c;
            if (list != null) {
                for (xx0 xx0Var2 : list) {
                    if (xx0Var2.getInterceptorLayer() != vw0Var.k() && xx0Var2.e(vw0Var)) {
                        e21.b("AbsMessenger", "isNeedIntercept() = true, event = " + vw0Var);
                        vw0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(zx0 zx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zx0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(zx0Var)) {
                int expectOrder = zx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<zx0> list = this.d;
                            list.add(list.size(), zx0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, zx0Var);
                    return;
                }
                this.d.add(zx0Var);
            }
        }
    }
}
