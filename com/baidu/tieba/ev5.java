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
public class ev5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ln> a;
    public TbPageContext<?> b;
    public eo c;
    public tv5 d;
    public pv5 e;
    public iv5 f;
    public kv5 g;
    public jv5 h;
    public lv5 i;
    public mv5 j;
    public ov5 k;
    public nv5 l;
    public rv5 m;
    public qv5 n;
    public sv5 o;
    public gv5 p;
    public fv5 q;

    public ev5(TbPageContext tbPageContext, eo eoVar) {
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
        this.c.addAdapters(this.a);
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
            tv5 tv5Var = new tv5(this.b);
            this.d = tv5Var;
            tv5Var.M(this.c);
            this.a.add(this.d);
            pv5 pv5Var = new pv5(this.b);
            this.e = pv5Var;
            pv5Var.M(this.c);
            this.a.add(this.e);
            sv5 sv5Var = new sv5(this.b);
            this.o = sv5Var;
            sv5Var.M(this.c);
            this.a.add(this.o);
            iv5 iv5Var = new iv5(this.b);
            this.f = iv5Var;
            iv5Var.M(this.c);
            this.a.add(this.f);
            kv5 kv5Var = new kv5(this.b);
            this.g = kv5Var;
            kv5Var.M(this.c);
            this.a.add(this.g);
            jv5 jv5Var = new jv5(this.b);
            this.h = jv5Var;
            jv5Var.M(this.c);
            this.a.add(this.h);
            lv5 lv5Var = new lv5(this.b);
            this.i = lv5Var;
            lv5Var.M(this.c);
            this.a.add(this.i);
            mv5 mv5Var = new mv5(this.b);
            this.j = mv5Var;
            mv5Var.M(this.c);
            this.a.add(this.j);
            ov5 ov5Var = new ov5(this.b);
            this.k = ov5Var;
            ov5Var.M(this.c);
            this.a.add(this.k);
            nv5 nv5Var = new nv5(this.b);
            this.l = nv5Var;
            nv5Var.M(this.c);
            this.a.add(this.l);
            rv5 rv5Var = new rv5(this.b);
            this.m = rv5Var;
            rv5Var.M(this.c);
            this.a.add(this.m);
            qv5 qv5Var = new qv5(this.b);
            this.n = qv5Var;
            qv5Var.M(this.c);
            this.a.add(this.n);
            gv5 gv5Var = new gv5(this.b);
            this.p = gv5Var;
            gv5Var.M(this.c);
            this.a.add(this.p);
            fv5 fv5Var = new fv5(this.b, jq6.S0);
            this.q = fv5Var;
            this.a.add(fv5Var);
            this.c.addAdapters(this.a);
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
                if (lnVar instanceof hv5) {
                    ((hv5) lnVar).s(i);
                }
            }
        }
    }

    public void f(uv5 uv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uv5Var) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof hv5) {
                    ((hv5) lnVar).I(uv5Var);
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
        this.c.addAdapters(this.a);
    }

    public void h(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i05Var) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof hv5) {
                    ((hv5) lnVar).J(i05Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof hv5) {
                    ((hv5) lnVar).L(bdUniqueId);
                }
            }
        }
    }

    public void k(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eoVar) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof hv5) {
                    ((hv5) lnVar).M(eoVar);
                }
            }
        }
    }
}
