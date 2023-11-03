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
public class fq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<bi> a;
    public TbPageContext<?> b;
    public ui c;
    public uq5 d;
    public qq5 e;
    public jq5 f;
    public lq5 g;
    public kq5 h;
    public mq5 i;
    public nq5 j;
    public pq5 k;
    public oq5 l;
    public sq5 m;
    public rq5 n;
    public tq5 o;
    public hq5 p;
    public gq5 q;

    public fq5(TbPageContext tbPageContext, ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, uiVar};
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
        this.c = uiVar;
        b();
    }

    public void a(List<bi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (bi biVar : list) {
            if (!c(biVar.getType())) {
                this.a.add(biVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (bi biVar : this.a) {
                    if (biVar != null && biVar.getType() == bdUniqueId) {
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
            uq5 uq5Var = new uq5(this.b);
            this.d = uq5Var;
            uq5Var.M(this.c);
            this.a.add(this.d);
            qq5 qq5Var = new qq5(this.b);
            this.e = qq5Var;
            qq5Var.M(this.c);
            this.a.add(this.e);
            tq5 tq5Var = new tq5(this.b);
            this.o = tq5Var;
            tq5Var.M(this.c);
            this.a.add(this.o);
            jq5 jq5Var = new jq5(this.b);
            this.f = jq5Var;
            jq5Var.M(this.c);
            this.a.add(this.f);
            lq5 lq5Var = new lq5(this.b);
            this.g = lq5Var;
            lq5Var.M(this.c);
            this.a.add(this.g);
            kq5 kq5Var = new kq5(this.b);
            this.h = kq5Var;
            kq5Var.M(this.c);
            this.a.add(this.h);
            mq5 mq5Var = new mq5(this.b);
            this.i = mq5Var;
            mq5Var.M(this.c);
            this.a.add(this.i);
            nq5 nq5Var = new nq5(this.b);
            this.j = nq5Var;
            nq5Var.M(this.c);
            this.a.add(this.j);
            pq5 pq5Var = new pq5(this.b);
            this.k = pq5Var;
            pq5Var.M(this.c);
            this.a.add(this.k);
            oq5 oq5Var = new oq5(this.b);
            this.l = oq5Var;
            oq5Var.M(this.c);
            this.a.add(this.l);
            sq5 sq5Var = new sq5(this.b);
            this.m = sq5Var;
            sq5Var.M(this.c);
            this.a.add(this.m);
            rq5 rq5Var = new rq5(this.b);
            this.n = rq5Var;
            rq5Var.M(this.c);
            this.a.add(this.n);
            hq5 hq5Var = new hq5(this.b);
            this.p = hq5Var;
            hq5Var.M(this.c);
            this.a.add(this.p);
            gq5 gq5Var = new gq5(this.b, mm6.S0);
            this.q = gq5Var;
            this.a.add(gq5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        ui uiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (uiVar = this.c) != null && uiVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof iq5) {
                    ((iq5) biVar).t(i);
                }
            }
        }
    }

    public void f(vq5 vq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vq5Var) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof iq5) {
                    ((iq5) biVar).J(vq5Var);
                }
            }
        }
    }

    public void g(List<bi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vu4Var) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof iq5) {
                    ((iq5) biVar).K(vu4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof iq5) {
                    ((iq5) biVar).L(bdUniqueId);
                }
            }
        }
    }

    public void k(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, uiVar) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof iq5) {
                    ((iq5) biVar).M(uiVar);
                }
            }
        }
    }
}
