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
/* loaded from: classes4.dex */
public abstract class gz0 implements iz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<cx0>> a;
    @Nullable
    public dx0 b;
    @Nullable
    public List<dx0> c;
    @Nullable
    public List<fx0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull bw0 bw0Var);

    public gz0() {
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

    @Override // com.baidu.tieba.iz0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<fx0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<dx0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.iz0
    @Deprecated
    public void a(@Nullable dx0 dx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dx0Var) == null) {
            this.b = dx0Var;
        }
    }

    @Override // com.baidu.tieba.iz0
    public void b(@NonNull fx0 fx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fx0Var) == null) {
            j(fx0Var);
        }
    }

    @Override // com.baidu.tieba.iz0
    public void e(cx0 cx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cx0Var) == null) {
            for (CopyOnWriteArrayList<cx0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(cx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.iz0
    public void f(@NonNull fx0 fx0Var) {
        List<fx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, fx0Var) == null) && (list = this.d) != null) {
            list.remove(fx0Var);
        }
    }

    public final void h(bw0 bw0Var) {
        List<fx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bw0Var) == null) && (list = this.d) != null) {
            for (fx0 fx0Var : list) {
                fx0Var.a(bw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.iz0
    public void c(int i, @NonNull cx0 cx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, cx0Var) == null) {
            CopyOnWriteArrayList<cx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(cx0Var)) {
                int expectOrder = cx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), cx0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, cx0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(cx0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.iz0
    public void d(@NonNull bw0 bw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bw0Var) == null) {
            String type = getType();
            l11.i(type, System.identityHashCode(this) + " notifyEvent " + bw0Var);
            if (bw0Var.j() == 1) {
                if (i(bw0Var)) {
                    return;
                }
                g(bw0Var);
                bw0Var.o();
                return;
            }
            l(bw0Var);
        }
    }

    public final void k(bw0 bw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bw0Var) == null) {
            if (bw0Var.i() == 0) {
                String type = getType();
                l11.b(type, System.identityHashCode(this) + ": dispatch event :" + bw0Var);
                return;
            }
            String type2 = getType();
            l11.i(type2, System.identityHashCode(this) + ": dispatch event :" + bw0Var);
        }
    }

    public void g(bw0 bw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bw0Var) == null) {
            k(bw0Var);
            h(bw0Var);
            CopyOnWriteArrayList<cx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(bw0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<cx0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    cx0 next = it.next();
                    if (!bw0Var.b(next)) {
                        switch (bw0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(bw0Var);
                                continue;
                            case 1:
                                next.n(bw0Var);
                                continue;
                            case 2:
                                next.q(bw0Var);
                                continue;
                            case 3:
                                next.k(bw0Var);
                                continue;
                            case 4:
                                next.d(bw0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) bw0Var.f(2), (PlayerStatus) bw0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof k01) {
                                    ((k01) next).g(bw0Var);
                                    break;
                                } else {
                                    next.a(bw0Var);
                                    continue;
                                }
                            case 8:
                                next.j(bw0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(bw0 bw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bw0Var)) == null) {
            dx0 dx0Var = this.b;
            if (dx0Var != null && dx0Var.getInterceptorLayer() != bw0Var.k() && this.b.e(bw0Var)) {
                l11.b("AbsMessenger", "isNeedIntercept() = true, event = " + bw0Var);
                bw0Var.o();
                return true;
            }
            List<dx0> list = this.c;
            if (list != null) {
                for (dx0 dx0Var2 : list) {
                    if (dx0Var2.getInterceptorLayer() != bw0Var.k() && dx0Var2.e(bw0Var)) {
                        l11.b("AbsMessenger", "isNeedIntercept() = true, event = " + bw0Var);
                        bw0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(fx0 fx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fx0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(fx0Var)) {
                int expectOrder = fx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<fx0> list = this.d;
                            list.add(list.size(), fx0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, fx0Var);
                    return;
                }
                this.d.add(fx0Var);
            }
        }
    }
}
