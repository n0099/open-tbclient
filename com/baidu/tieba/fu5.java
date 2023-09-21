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
/* loaded from: classes6.dex */
public class fu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<om> a;
    public TbPageContext<?> b;
    public hn c;
    public uu5 d;
    public qu5 e;
    public ju5 f;
    public lu5 g;
    public ku5 h;
    public mu5 i;
    public nu5 j;
    public pu5 k;
    public ou5 l;
    public su5 m;
    public ru5 n;
    public tu5 o;
    public hu5 p;
    public gu5 q;

    public fu5(TbPageContext tbPageContext, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hnVar};
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
        this.c = hnVar;
        b();
    }

    public void a(List<om> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (om omVar : list) {
            if (!c(omVar.getType())) {
                this.a.add(omVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (om omVar : this.a) {
                    if (omVar != null && omVar.getType() == bdUniqueId) {
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
            uu5 uu5Var = new uu5(this.b);
            this.d = uu5Var;
            uu5Var.L(this.c);
            this.a.add(this.d);
            qu5 qu5Var = new qu5(this.b);
            this.e = qu5Var;
            qu5Var.L(this.c);
            this.a.add(this.e);
            tu5 tu5Var = new tu5(this.b);
            this.o = tu5Var;
            tu5Var.L(this.c);
            this.a.add(this.o);
            ju5 ju5Var = new ju5(this.b);
            this.f = ju5Var;
            ju5Var.L(this.c);
            this.a.add(this.f);
            lu5 lu5Var = new lu5(this.b);
            this.g = lu5Var;
            lu5Var.L(this.c);
            this.a.add(this.g);
            ku5 ku5Var = new ku5(this.b);
            this.h = ku5Var;
            ku5Var.L(this.c);
            this.a.add(this.h);
            mu5 mu5Var = new mu5(this.b);
            this.i = mu5Var;
            mu5Var.L(this.c);
            this.a.add(this.i);
            nu5 nu5Var = new nu5(this.b);
            this.j = nu5Var;
            nu5Var.L(this.c);
            this.a.add(this.j);
            pu5 pu5Var = new pu5(this.b);
            this.k = pu5Var;
            pu5Var.L(this.c);
            this.a.add(this.k);
            ou5 ou5Var = new ou5(this.b);
            this.l = ou5Var;
            ou5Var.L(this.c);
            this.a.add(this.l);
            su5 su5Var = new su5(this.b);
            this.m = su5Var;
            su5Var.L(this.c);
            this.a.add(this.m);
            ru5 ru5Var = new ru5(this.b);
            this.n = ru5Var;
            ru5Var.L(this.c);
            this.a.add(this.n);
            hu5 hu5Var = new hu5(this.b);
            this.p = hu5Var;
            hu5Var.L(this.c);
            this.a.add(this.p);
            gu5 gu5Var = new gu5(this.b, hq6.S0);
            this.q = gu5Var;
            this.a.add(gu5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hnVar = this.c) != null && hnVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof iu5) {
                    ((iu5) omVar).s(i);
                }
            }
        }
    }

    public void f(vu5 vu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vu5Var) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof iu5) {
                    ((iu5) omVar).I(vu5Var);
                }
            }
        }
    }

    public void g(List<om> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wz4Var) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof iu5) {
                    ((iu5) omVar).J(wz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof iu5) {
                    ((iu5) omVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hnVar) == null) {
            for (om omVar : this.a) {
                if (omVar instanceof iu5) {
                    ((iu5) omVar).L(hnVar);
                }
            }
        }
    }
}
