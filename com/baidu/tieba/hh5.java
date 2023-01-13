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
public class hh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ln> a;
    public TbPageContext<?> b;
    public eo c;
    public wh5 d;
    public sh5 e;
    public lh5 f;
    public nh5 g;
    public mh5 h;
    public oh5 i;
    public ph5 j;
    public rh5 k;
    public qh5 l;
    public uh5 m;
    public th5 n;
    public vh5 o;
    public jh5 p;
    public ih5 q;

    public hh5(TbPageContext tbPageContext, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eoVar};
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
        this.c = eoVar;
        b();
    }

    public void a(List<ln> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (ln lnVar : list) {
            if (!c(lnVar.getType())) {
                this.a.add(lnVar);
            }
        }
        this.c.a(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (ln lnVar : this.a) {
                    if (lnVar != null && lnVar.getType() == bdUniqueId) {
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
            wh5 wh5Var = new wh5(this.b);
            this.d = wh5Var;
            wh5Var.K(this.c);
            this.a.add(this.d);
            sh5 sh5Var = new sh5(this.b);
            this.e = sh5Var;
            sh5Var.K(this.c);
            this.a.add(this.e);
            vh5 vh5Var = new vh5(this.b);
            this.o = vh5Var;
            vh5Var.K(this.c);
            this.a.add(this.o);
            lh5 lh5Var = new lh5(this.b);
            this.f = lh5Var;
            lh5Var.K(this.c);
            this.a.add(this.f);
            nh5 nh5Var = new nh5(this.b);
            this.g = nh5Var;
            nh5Var.K(this.c);
            this.a.add(this.g);
            mh5 mh5Var = new mh5(this.b);
            this.h = mh5Var;
            mh5Var.K(this.c);
            this.a.add(this.h);
            oh5 oh5Var = new oh5(this.b);
            this.i = oh5Var;
            oh5Var.K(this.c);
            this.a.add(this.i);
            ph5 ph5Var = new ph5(this.b);
            this.j = ph5Var;
            ph5Var.K(this.c);
            this.a.add(this.j);
            rh5 rh5Var = new rh5(this.b);
            this.k = rh5Var;
            rh5Var.K(this.c);
            this.a.add(this.k);
            qh5 qh5Var = new qh5(this.b);
            this.l = qh5Var;
            qh5Var.K(this.c);
            this.a.add(this.l);
            uh5 uh5Var = new uh5(this.b);
            this.m = uh5Var;
            uh5Var.K(this.c);
            this.a.add(this.m);
            th5 th5Var = new th5(this.b);
            this.n = th5Var;
            th5Var.K(this.c);
            this.a.add(this.n);
            jh5 jh5Var = new jh5(this.b);
            this.p = jh5Var;
            jh5Var.K(this.c);
            this.a.add(this.p);
            ih5 ih5Var = new ih5(this.b, n96.O0);
            this.q = ih5Var;
            this.a.add(ih5Var);
            this.c.a(this.a);
        }
    }

    public void d() {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (eoVar = this.c) != null && eoVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof kh5) {
                    ((kh5) lnVar).s(i);
                }
            }
        }
    }

    public void f(xh5 xh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xh5Var) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof kh5) {
                    ((kh5) lnVar).G(xh5Var);
                }
            }
        }
    }

    public void g(List<ln> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(vq4 vq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vq4Var) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof kh5) {
                    ((kh5) lnVar).H(vq4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof kh5) {
                    ((kh5) lnVar).J(bdUniqueId);
                }
            }
        }
    }

    public void k(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eoVar) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof kh5) {
                    ((kh5) lnVar).K(eoVar);
                }
            }
        }
    }
}
