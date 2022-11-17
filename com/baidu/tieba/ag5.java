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
/* loaded from: classes3.dex */
public class ag5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<kn> a;
    public TbPageContext<?> b;
    public Cdo c;
    public pg5 d;
    public lg5 e;
    public eg5 f;
    public gg5 g;
    public fg5 h;
    public hg5 i;
    public ig5 j;
    public kg5 k;
    public jg5 l;
    public ng5 m;
    public mg5 n;
    public og5 o;
    public cg5 p;
    public bg5 q;

    public ag5(TbPageContext tbPageContext, Cdo cdo) {
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
        this.c.a(this.a);
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
            pg5 pg5Var = new pg5(this.b);
            this.d = pg5Var;
            pg5Var.K(this.c);
            this.a.add(this.d);
            lg5 lg5Var = new lg5(this.b);
            this.e = lg5Var;
            lg5Var.K(this.c);
            this.a.add(this.e);
            og5 og5Var = new og5(this.b);
            this.o = og5Var;
            og5Var.K(this.c);
            this.a.add(this.o);
            eg5 eg5Var = new eg5(this.b);
            this.f = eg5Var;
            eg5Var.K(this.c);
            this.a.add(this.f);
            gg5 gg5Var = new gg5(this.b);
            this.g = gg5Var;
            gg5Var.K(this.c);
            this.a.add(this.g);
            fg5 fg5Var = new fg5(this.b);
            this.h = fg5Var;
            fg5Var.K(this.c);
            this.a.add(this.h);
            hg5 hg5Var = new hg5(this.b);
            this.i = hg5Var;
            hg5Var.K(this.c);
            this.a.add(this.i);
            ig5 ig5Var = new ig5(this.b);
            this.j = ig5Var;
            ig5Var.K(this.c);
            this.a.add(this.j);
            kg5 kg5Var = new kg5(this.b);
            this.k = kg5Var;
            kg5Var.K(this.c);
            this.a.add(this.k);
            jg5 jg5Var = new jg5(this.b);
            this.l = jg5Var;
            jg5Var.K(this.c);
            this.a.add(this.l);
            ng5 ng5Var = new ng5(this.b);
            this.m = ng5Var;
            ng5Var.K(this.c);
            this.a.add(this.m);
            mg5 mg5Var = new mg5(this.b);
            this.n = mg5Var;
            mg5Var.K(this.c);
            this.a.add(this.n);
            cg5 cg5Var = new cg5(this.b);
            this.p = cg5Var;
            cg5Var.K(this.c);
            this.a.add(this.p);
            bg5 bg5Var = new bg5(this.b, a56.N0);
            this.q = bg5Var;
            this.a.add(bg5Var);
            this.c.a(this.a);
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
                if (knVar instanceof dg5) {
                    ((dg5) knVar).s(i);
                }
            }
        }
    }

    public void f(qg5 qg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qg5Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof dg5) {
                    ((dg5) knVar).G(qg5Var);
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
        this.c.a(this.a);
    }

    public void h(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(kq4 kq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kq4Var) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof dg5) {
                    ((dg5) knVar).H(kq4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof dg5) {
                    ((dg5) knVar).I(bdUniqueId);
                }
            }
        }
    }

    public void k(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cdo) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof dg5) {
                    ((dg5) knVar).K(cdo);
                }
            }
        }
    }
}
