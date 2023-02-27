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
public class gn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<qn> a;
    public TbPageContext<?> b;
    public jo c;
    public vn5 d;
    public rn5 e;
    public kn5 f;
    public mn5 g;
    public ln5 h;
    public nn5 i;
    public on5 j;
    public qn5 k;
    public pn5 l;
    public tn5 m;
    public sn5 n;
    public un5 o;
    public in5 p;
    public hn5 q;

    public gn5(TbPageContext tbPageContext, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, joVar};
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
        this.c = joVar;
        b();
    }

    public void a(List<qn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (qn qnVar : list) {
            if (!c(qnVar.getType())) {
                this.a.add(qnVar);
            }
        }
        this.c.a(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (qn qnVar : this.a) {
                    if (qnVar != null && qnVar.getType() == bdUniqueId) {
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
            vn5 vn5Var = new vn5(this.b);
            this.d = vn5Var;
            vn5Var.K(this.c);
            this.a.add(this.d);
            rn5 rn5Var = new rn5(this.b);
            this.e = rn5Var;
            rn5Var.K(this.c);
            this.a.add(this.e);
            un5 un5Var = new un5(this.b);
            this.o = un5Var;
            un5Var.K(this.c);
            this.a.add(this.o);
            kn5 kn5Var = new kn5(this.b);
            this.f = kn5Var;
            kn5Var.K(this.c);
            this.a.add(this.f);
            mn5 mn5Var = new mn5(this.b);
            this.g = mn5Var;
            mn5Var.K(this.c);
            this.a.add(this.g);
            ln5 ln5Var = new ln5(this.b);
            this.h = ln5Var;
            ln5Var.K(this.c);
            this.a.add(this.h);
            nn5 nn5Var = new nn5(this.b);
            this.i = nn5Var;
            nn5Var.K(this.c);
            this.a.add(this.i);
            on5 on5Var = new on5(this.b);
            this.j = on5Var;
            on5Var.K(this.c);
            this.a.add(this.j);
            qn5 qn5Var = new qn5(this.b);
            this.k = qn5Var;
            qn5Var.K(this.c);
            this.a.add(this.k);
            pn5 pn5Var = new pn5(this.b);
            this.l = pn5Var;
            pn5Var.K(this.c);
            this.a.add(this.l);
            tn5 tn5Var = new tn5(this.b);
            this.m = tn5Var;
            tn5Var.K(this.c);
            this.a.add(this.m);
            sn5 sn5Var = new sn5(this.b);
            this.n = sn5Var;
            sn5Var.K(this.c);
            this.a.add(this.n);
            in5 in5Var = new in5(this.b);
            this.p = in5Var;
            in5Var.K(this.c);
            this.a.add(this.p);
            hn5 hn5Var = new hn5(this.b, lg6.P0);
            this.q = hn5Var;
            this.a.add(hn5Var);
            this.c.a(this.a);
        }
    }

    public void d() {
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (joVar = this.c) != null && joVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof jn5) {
                    ((jn5) qnVar).s(i);
                }
            }
        }
    }

    public void f(wn5 wn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wn5Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof jn5) {
                    ((jn5) qnVar).G(wn5Var);
                }
            }
        }
    }

    public void g(List<qn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(pw4 pw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pw4Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof jn5) {
                    ((jn5) qnVar).H(pw4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof jn5) {
                    ((jn5) qnVar).J(bdUniqueId);
                }
            }
        }
    }

    public void k(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, joVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof jn5) {
                    ((jn5) qnVar).K(joVar);
                }
            }
        }
    }
}
