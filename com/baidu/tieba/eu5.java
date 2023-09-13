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
/* loaded from: classes5.dex */
public class eu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<pm> a;
    public TbPageContext<?> b;
    public in c;
    public tu5 d;
    public pu5 e;
    public iu5 f;
    public ku5 g;
    public ju5 h;
    public lu5 i;
    public mu5 j;
    public ou5 k;
    public nu5 l;
    public ru5 m;
    public qu5 n;
    public su5 o;
    public gu5 p;
    public fu5 q;

    public eu5(TbPageContext tbPageContext, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, inVar};
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
        this.c = inVar;
        b();
    }

    public void a(List<pm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (pm pmVar : list) {
            if (!c(pmVar.getType())) {
                this.a.add(pmVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (pm pmVar : this.a) {
                    if (pmVar != null && pmVar.getType() == bdUniqueId) {
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
            tu5 tu5Var = new tu5(this.b);
            this.d = tu5Var;
            tu5Var.L(this.c);
            this.a.add(this.d);
            pu5 pu5Var = new pu5(this.b);
            this.e = pu5Var;
            pu5Var.L(this.c);
            this.a.add(this.e);
            su5 su5Var = new su5(this.b);
            this.o = su5Var;
            su5Var.L(this.c);
            this.a.add(this.o);
            iu5 iu5Var = new iu5(this.b);
            this.f = iu5Var;
            iu5Var.L(this.c);
            this.a.add(this.f);
            ku5 ku5Var = new ku5(this.b);
            this.g = ku5Var;
            ku5Var.L(this.c);
            this.a.add(this.g);
            ju5 ju5Var = new ju5(this.b);
            this.h = ju5Var;
            ju5Var.L(this.c);
            this.a.add(this.h);
            lu5 lu5Var = new lu5(this.b);
            this.i = lu5Var;
            lu5Var.L(this.c);
            this.a.add(this.i);
            mu5 mu5Var = new mu5(this.b);
            this.j = mu5Var;
            mu5Var.L(this.c);
            this.a.add(this.j);
            ou5 ou5Var = new ou5(this.b);
            this.k = ou5Var;
            ou5Var.L(this.c);
            this.a.add(this.k);
            nu5 nu5Var = new nu5(this.b);
            this.l = nu5Var;
            nu5Var.L(this.c);
            this.a.add(this.l);
            ru5 ru5Var = new ru5(this.b);
            this.m = ru5Var;
            ru5Var.L(this.c);
            this.a.add(this.m);
            qu5 qu5Var = new qu5(this.b);
            this.n = qu5Var;
            qu5Var.L(this.c);
            this.a.add(this.n);
            gu5 gu5Var = new gu5(this.b);
            this.p = gu5Var;
            gu5Var.L(this.c);
            this.a.add(this.p);
            fu5 fu5Var = new fu5(this.b, bq6.S0);
            this.q = fu5Var;
            this.a.add(fu5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        in inVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (inVar = this.c) != null && inVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (pm pmVar : this.a) {
                if (pmVar instanceof hu5) {
                    ((hu5) pmVar).s(i);
                }
            }
        }
    }

    public void f(uu5 uu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uu5Var) == null) {
            for (pm pmVar : this.a) {
                if (pmVar instanceof hu5) {
                    ((hu5) pmVar).I(uu5Var);
                }
            }
        }
    }

    public void g(List<pm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wz4Var) == null) {
            for (pm pmVar : this.a) {
                if (pmVar instanceof hu5) {
                    ((hu5) pmVar).J(wz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (pm pmVar : this.a) {
                if (pmVar instanceof hu5) {
                    ((hu5) pmVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, inVar) == null) {
            for (pm pmVar : this.a) {
                if (pmVar instanceof hu5) {
                    ((hu5) pmVar).L(inVar);
                }
            }
        }
    }
}
