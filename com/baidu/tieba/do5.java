package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class do5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<vm> a;
    public TbPageContext<?> b;
    public on c;
    public so5 d;
    public oo5 e;
    public ho5 f;
    public jo5 g;
    public io5 h;
    public ko5 i;
    public lo5 j;
    public no5 k;
    public mo5 l;
    public qo5 m;
    public po5 n;
    public ro5 o;
    public fo5 p;
    public eo5 q;

    public do5(TbPageContext tbPageContext, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.b = tbPageContext;
        this.c = onVar;
        b();
    }

    public void a(List<vm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (vm vmVar : list) {
            if (!c(vmVar.getType())) {
                this.a.add(vmVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (vm vmVar : this.a) {
                    if (vmVar != null && vmVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            so5 so5Var = new so5(this.b);
            this.d = so5Var;
            so5Var.M(this.c);
            this.a.add(this.d);
            oo5 oo5Var = new oo5(this.b);
            this.e = oo5Var;
            oo5Var.M(this.c);
            this.a.add(this.e);
            ro5 ro5Var = new ro5(this.b);
            this.o = ro5Var;
            ro5Var.M(this.c);
            this.a.add(this.o);
            ho5 ho5Var = new ho5(this.b);
            this.f = ho5Var;
            ho5Var.M(this.c);
            this.a.add(this.f);
            jo5 jo5Var = new jo5(this.b);
            this.g = jo5Var;
            jo5Var.M(this.c);
            this.a.add(this.g);
            io5 io5Var = new io5(this.b);
            this.h = io5Var;
            io5Var.M(this.c);
            this.a.add(this.h);
            ko5 ko5Var = new ko5(this.b);
            this.i = ko5Var;
            ko5Var.M(this.c);
            this.a.add(this.i);
            lo5 lo5Var = new lo5(this.b);
            this.j = lo5Var;
            lo5Var.M(this.c);
            this.a.add(this.j);
            no5 no5Var = new no5(this.b);
            this.k = no5Var;
            no5Var.M(this.c);
            this.a.add(this.k);
            mo5 mo5Var = new mo5(this.b);
            this.l = mo5Var;
            mo5Var.M(this.c);
            this.a.add(this.l);
            qo5 qo5Var = new qo5(this.b);
            this.m = qo5Var;
            qo5Var.M(this.c);
            this.a.add(this.m);
            po5 po5Var = new po5(this.b);
            this.n = po5Var;
            po5Var.M(this.c);
            this.a.add(this.n);
            fo5 fo5Var = new fo5(this.b);
            this.p = fo5Var;
            fo5Var.M(this.c);
            this.a.add(this.p);
            eo5 eo5Var = new eo5(this.b, xi6.Q0);
            this.q = eo5Var;
            this.a.add(eo5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        on onVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (onVar = this.c) != null && onVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof go5) {
                    ((go5) vmVar).s(i);
                }
            }
        }
    }

    public void f(to5 to5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, to5Var) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof go5) {
                    ((go5) vmVar).I(to5Var);
                }
            }
        }
    }

    public void g(List<vm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(qv4 qv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qv4Var) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof go5) {
                    ((go5) vmVar).J(qv4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof go5) {
                    ((go5) vmVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onVar) == null) {
            for (vm vmVar : this.a) {
                if (vmVar instanceof go5) {
                    ((go5) vmVar).M(onVar);
                }
            }
        }
    }
}
