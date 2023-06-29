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
public abstract class d01 implements f01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<zx0>> a;
    @Nullable
    public ay0 b;
    @Nullable
    public List<ay0> c;
    @Nullable
    public List<cy0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull yw0 yw0Var);

    public d01() {
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

    @Override // com.baidu.tieba.f01
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<cy0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<ay0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.f01
    @Deprecated
    public void a(@Nullable ay0 ay0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ay0Var) == null) {
            this.b = ay0Var;
        }
    }

    @Override // com.baidu.tieba.f01
    public void b(@NonNull cy0 cy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cy0Var) == null) {
            j(cy0Var);
        }
    }

    @Override // com.baidu.tieba.f01
    public void e(zx0 zx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zx0Var) == null) {
            for (CopyOnWriteArrayList<zx0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(zx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.f01
    public void f(@NonNull cy0 cy0Var) {
        List<cy0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, cy0Var) == null) && (list = this.d) != null) {
            list.remove(cy0Var);
        }
    }

    public final void h(yw0 yw0Var) {
        List<cy0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yw0Var) == null) && (list = this.d) != null) {
            for (cy0 cy0Var : list) {
                cy0Var.a(yw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.f01
    public void c(int i, @NonNull zx0 zx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, zx0Var) == null) {
            CopyOnWriteArrayList<zx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(zx0Var)) {
                int expectOrder = zx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), zx0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, zx0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(zx0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.f01
    public void d(@NonNull yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yw0Var) == null) {
            String type = getType();
            i21.i(type, System.identityHashCode(this) + " notifyEvent " + yw0Var);
            if (yw0Var.j() == 1) {
                if (i(yw0Var)) {
                    return;
                }
                g(yw0Var);
                yw0Var.o();
                return;
            }
            l(yw0Var);
        }
    }

    public final void k(yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, yw0Var) == null) {
            if (yw0Var.i() == 0) {
                String type = getType();
                i21.b(type, System.identityHashCode(this) + ": dispatch event :" + yw0Var);
                return;
            }
            String type2 = getType();
            i21.i(type2, System.identityHashCode(this) + ": dispatch event :" + yw0Var);
        }
    }

    public void g(yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yw0Var) == null) {
            k(yw0Var);
            h(yw0Var);
            CopyOnWriteArrayList<zx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(yw0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<zx0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    zx0 next = it.next();
                    if (!yw0Var.b(next)) {
                        switch (yw0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(yw0Var);
                                continue;
                            case 1:
                                next.n(yw0Var);
                                continue;
                            case 2:
                                next.q(yw0Var);
                                continue;
                            case 3:
                                next.k(yw0Var);
                                continue;
                            case 4:
                                next.d(yw0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) yw0Var.f(2), (PlayerStatus) yw0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof h11) {
                                    ((h11) next).g(yw0Var);
                                    break;
                                } else {
                                    next.a(yw0Var);
                                    continue;
                                }
                            case 8:
                                next.j(yw0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(yw0 yw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, yw0Var)) == null) {
            ay0 ay0Var = this.b;
            if (ay0Var != null && ay0Var.getInterceptorLayer() != yw0Var.k() && this.b.e(yw0Var)) {
                i21.b("AbsMessenger", "isNeedIntercept() = true, event = " + yw0Var);
                yw0Var.o();
                return true;
            }
            List<ay0> list = this.c;
            if (list != null) {
                for (ay0 ay0Var2 : list) {
                    if (ay0Var2.getInterceptorLayer() != yw0Var.k() && ay0Var2.e(yw0Var)) {
                        i21.b("AbsMessenger", "isNeedIntercept() = true, event = " + yw0Var);
                        yw0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(cy0 cy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cy0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(cy0Var)) {
                int expectOrder = cy0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<cy0> list = this.d;
                            list.add(list.size(), cy0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, cy0Var);
                    return;
                }
                this.d.add(cy0Var);
            }
        }
    }
}
