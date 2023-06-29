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
public class au5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<kn> a;
    public TbPageContext<?> b;
    public Cdo c;
    public pu5 d;
    public lu5 e;
    public eu5 f;
    public gu5 g;
    public fu5 h;
    public hu5 i;
    public iu5 j;
    public ku5 k;
    public ju5 l;
    public nu5 m;
    public mu5 n;
    public ou5 o;
    public cu5 p;
    public bu5 q;

    public au5(TbPageContext tbPageContext, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cdo};
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
        this.c = cdo;
        b();
    }

    public void a(List<kn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (kn knVar : list) {
            if (!c(knVar.getType())) {
                this.a.add(knVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (kn knVar : this.a) {
                    if (knVar != null && knVar.getType() == bdUniqueId) {
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
            pu5 pu5Var = new pu5(this.b);
            this.d = pu5Var;
            pu5Var.M(this.c);
            this.a.add(this.d);
            lu5 lu5Var = new lu5(this.b);
            this.e = lu5Var;
            lu5Var.M(this.c);
            this.a.add(this.e);
            ou5 ou5Var = new ou5(this.b);
            this.o = ou5Var;
            ou5Var.M(this.c);
            this.a.add(this.o);
            eu5 eu5Var = new eu5(this.b);
            this.f = eu5Var;
            eu5Var.M(this.c);
            this.a.add(this.f);
            gu5 gu5Var = new gu5(this.b);
            this.g = gu5Var;
            gu5Var.M(this.c);
            this.a.add(this.g);
            fu5 fu5Var = new fu5(this.b);
            this.h = fu5Var;
            fu5Var.M(this.c);
            this.a.add(this.h);
            hu5 hu5Var = new hu5(this.b);
            this.i = hu5Var;
            hu5Var.M(this.c);
            this.a.add(this.i);
            iu5 iu5Var = new iu5(this.b);
            this.j = iu5Var;
            iu5Var.M(this.c);
            this.a.add(this.j);
            ku5 ku5Var = new ku5(this.b);
            this.k = ku5Var;
            ku5Var.M(this.c);
            this.a.add(this.k);
            ju5 ju5Var = new ju5(this.b);
            this.l = ju5Var;
            ju5Var.M(this.c);
            this.a.add(this.l);
            nu5 nu5Var = new nu5(this.b);
            this.m = nu5Var;
            nu5Var.M(this.c);
            this.a.add(this.m);
            mu5 mu5Var = new mu5(this.b);
            this.n = mu5Var;
            mu5Var.M(this.c);
            this.a.add(this.n);
            cu5 cu5Var = new cu5(this.b);
            this.p = cu5Var;
            cu5Var.M(this.c);
            this.a.add(this.p);
            bu5 bu5Var = new bu5(this.b, fp6.R0);
            this.q = bu5Var;
            this.a.add(bu5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (cdo = this.c) != null && cdo.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof du5) {
                    ((du5) knVar).s(i);
                }
            }
        }
    }

    public void f(qu5 qu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qu5Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof du5) {
                    ((du5) knVar).I(qu5Var);
                }
            }
        }
    }

    public void g(List<kn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(zz4 zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zz4Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof du5) {
                    ((du5) knVar).J(zz4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof du5) {
                    ((du5) knVar).K(bdUniqueId);
                }
            }
        }
    }

    public void k(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cdo) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof du5) {
                    ((du5) knVar).M(cdo);
                }
            }
        }
    }
}
