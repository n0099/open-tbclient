package com.baidu.tieba;

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
public abstract class ax0 implements cx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap a;
    public xu0 b;
    public List c;
    public List d;

    public abstract /* synthetic */ String getType();

    public abstract void l(vt0 vt0Var);

    public ax0() {
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
    }

    @Override // com.baidu.tieba.cx0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.cx0
    @Deprecated
    public void a(xu0 xu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xu0Var) == null) {
            this.b = xu0Var;
        }
    }

    @Override // com.baidu.tieba.cx0
    public void b(zu0 zu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zu0Var) == null) {
            j(zu0Var);
        }
    }

    @Override // com.baidu.tieba.cx0
    public void e(wu0 wu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wu0Var) == null) {
            for (CopyOnWriteArrayList copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(wu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.cx0
    public void f(zu0 zu0Var) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zu0Var) == null) && (list = this.d) != null) {
            list.remove(zu0Var);
        }
    }

    public final void h(vt0 vt0Var) {
        List<zu0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vt0Var) == null) && (list = this.d) != null) {
            for (zu0 zu0Var : list) {
                zu0Var.a(vt0Var);
            }
        }
    }

    @Override // com.baidu.tieba.cx0
    public void c(int i, wu0 wu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wu0Var) == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
            }
            if (!copyOnWriteArrayList.contains(wu0Var)) {
                int expectOrder = wu0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), wu0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, wu0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(wu0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.cx0
    public void d(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vt0Var) == null) {
            String type = getType();
            ez0.i(type, System.identityHashCode(this) + " notifyEvent " + vt0Var);
            if (vt0Var.j() == 1) {
                if (i(vt0Var)) {
                    return;
                }
                g(vt0Var);
                vt0Var.o();
                return;
            }
            l(vt0Var);
        }
    }

    public final void k(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vt0Var) == null) {
            if (vt0Var.i() == 0) {
                String type = getType();
                ez0.b(type, System.identityHashCode(this) + ": dispatch event :" + vt0Var);
                return;
            }
            String type2 = getType();
            ez0.i(type2, System.identityHashCode(this) + ": dispatch event :" + vt0Var);
        }
    }

    public void g(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vt0Var) == null) {
            k(vt0Var);
            h(vt0Var);
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(Integer.valueOf(vt0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    wu0 wu0Var = (wu0) it.next();
                    if (!vt0Var.b(wu0Var)) {
                        switch (vt0Var.getType()) {
                            case -1:
                            case 6:
                                wu0Var.a(vt0Var);
                                continue;
                            case 1:
                                wu0Var.n(vt0Var);
                                continue;
                            case 2:
                                wu0Var.q(vt0Var);
                                continue;
                            case 3:
                                wu0Var.k(vt0Var);
                                continue;
                            case 4:
                                wu0Var.d(vt0Var);
                                continue;
                            case 5:
                                wu0Var.h((PlayerStatus) vt0Var.f(2), (PlayerStatus) vt0Var.f(1));
                                continue;
                            case 7:
                                if (wu0Var instanceof ey0) {
                                    ((ey0) wu0Var).g(vt0Var);
                                    break;
                                } else {
                                    wu0Var.a(vt0Var);
                                    continue;
                                }
                            case 8:
                                wu0Var.j(vt0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(vt0 vt0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vt0Var)) == null) {
            xu0 xu0Var = this.b;
            if (xu0Var != null && xu0Var.getInterceptorLayer() != vt0Var.k() && this.b.e(vt0Var)) {
                ez0.b("AbsMessenger", "isNeedIntercept() = true, event = " + vt0Var);
                vt0Var.o();
                return true;
            }
            List<xu0> list = this.c;
            if (list != null) {
                for (xu0 xu0Var2 : list) {
                    if (xu0Var2.getInterceptorLayer() != vt0Var.k() && xu0Var2.e(vt0Var)) {
                        ez0.b("AbsMessenger", "isNeedIntercept() = true, event = " + vt0Var);
                        vt0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(zu0 zu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zu0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(zu0Var)) {
                int expectOrder = zu0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List list = this.d;
                            list.add(list.size(), zu0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, zu0Var);
                    return;
                }
                this.d.add(zu0Var);
            }
        }
    }
}
