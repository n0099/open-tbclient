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
public class gq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<bi> a;
    public TbPageContext<?> b;
    public ui c;
    public vq5 d;
    public rq5 e;
    public kq5 f;
    public mq5 g;
    public lq5 h;
    public nq5 i;
    public oq5 j;
    public qq5 k;
    public pq5 l;
    public tq5 m;
    public sq5 n;
    public uq5 o;
    public iq5 p;
    public hq5 q;

    public gq5(TbPageContext tbPageContext, ui uiVar) {
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
            vq5 vq5Var = new vq5(this.b);
            this.d = vq5Var;
            vq5Var.M(this.c);
            this.a.add(this.d);
            rq5 rq5Var = new rq5(this.b);
            this.e = rq5Var;
            rq5Var.M(this.c);
            this.a.add(this.e);
            uq5 uq5Var = new uq5(this.b);
            this.o = uq5Var;
            uq5Var.M(this.c);
            this.a.add(this.o);
            kq5 kq5Var = new kq5(this.b);
            this.f = kq5Var;
            kq5Var.M(this.c);
            this.a.add(this.f);
            mq5 mq5Var = new mq5(this.b);
            this.g = mq5Var;
            mq5Var.M(this.c);
            this.a.add(this.g);
            lq5 lq5Var = new lq5(this.b);
            this.h = lq5Var;
            lq5Var.M(this.c);
            this.a.add(this.h);
            nq5 nq5Var = new nq5(this.b);
            this.i = nq5Var;
            nq5Var.M(this.c);
            this.a.add(this.i);
            oq5 oq5Var = new oq5(this.b);
            this.j = oq5Var;
            oq5Var.M(this.c);
            this.a.add(this.j);
            qq5 qq5Var = new qq5(this.b);
            this.k = qq5Var;
            qq5Var.M(this.c);
            this.a.add(this.k);
            pq5 pq5Var = new pq5(this.b);
            this.l = pq5Var;
            pq5Var.M(this.c);
            this.a.add(this.l);
            tq5 tq5Var = new tq5(this.b);
            this.m = tq5Var;
            tq5Var.M(this.c);
            this.a.add(this.m);
            sq5 sq5Var = new sq5(this.b);
            this.n = sq5Var;
            sq5Var.M(this.c);
            this.a.add(this.n);
            iq5 iq5Var = new iq5(this.b);
            this.p = iq5Var;
            iq5Var.M(this.c);
            this.a.add(this.p);
            hq5 hq5Var = new hq5(this.b, nm6.S0);
            this.q = hq5Var;
            this.a.add(hq5Var);
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
                if (biVar instanceof jq5) {
                    ((jq5) biVar).t(i);
                }
            }
        }
    }

    public void f(wq5 wq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wq5Var) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof jq5) {
                    ((jq5) biVar).J(wq5Var);
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
                if (biVar instanceof jq5) {
                    ((jq5) biVar).K(vu4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof jq5) {
                    ((jq5) biVar).L(bdUniqueId);
                }
            }
        }
    }

    public void k(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, uiVar) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof jq5) {
                    ((jq5) biVar).M(uiVar);
                }
            }
        }
    }
}
