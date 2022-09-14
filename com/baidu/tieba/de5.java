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
public class de5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<qn> a;
    public TbPageContext<?> b;
    public jo c;
    public se5 d;
    public oe5 e;
    public he5 f;
    public je5 g;
    public ie5 h;
    public ke5 i;
    public le5 j;
    public ne5 k;
    public me5 l;
    public qe5 m;
    public pe5 n;
    public re5 o;
    public fe5 p;
    public ee5 q;

    public de5(TbPageContext tbPageContext, jo joVar) {
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (qn qnVar : list) {
            if (!c(qnVar.getType())) {
                this.a.add(qnVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            se5 se5Var = new se5(this.b);
            this.d = se5Var;
            se5Var.K(this.c);
            this.a.add(this.d);
            oe5 oe5Var = new oe5(this.b);
            this.e = oe5Var;
            oe5Var.K(this.c);
            this.a.add(this.e);
            re5 re5Var = new re5(this.b);
            this.o = re5Var;
            re5Var.K(this.c);
            this.a.add(this.o);
            he5 he5Var = new he5(this.b);
            this.f = he5Var;
            he5Var.K(this.c);
            this.a.add(this.f);
            je5 je5Var = new je5(this.b);
            this.g = je5Var;
            je5Var.K(this.c);
            this.a.add(this.g);
            ie5 ie5Var = new ie5(this.b);
            this.h = ie5Var;
            ie5Var.K(this.c);
            this.a.add(this.h);
            ke5 ke5Var = new ke5(this.b);
            this.i = ke5Var;
            ke5Var.K(this.c);
            this.a.add(this.i);
            le5 le5Var = new le5(this.b);
            this.j = le5Var;
            le5Var.K(this.c);
            this.a.add(this.j);
            ne5 ne5Var = new ne5(this.b);
            this.k = ne5Var;
            ne5Var.K(this.c);
            this.a.add(this.k);
            me5 me5Var = new me5(this.b);
            this.l = me5Var;
            me5Var.K(this.c);
            this.a.add(this.l);
            qe5 qe5Var = new qe5(this.b);
            this.m = qe5Var;
            qe5Var.K(this.c);
            this.a.add(this.m);
            pe5 pe5Var = new pe5(this.b);
            this.n = pe5Var;
            pe5Var.K(this.c);
            this.a.add(this.n);
            fe5 fe5Var = new fe5(this.b);
            this.p = fe5Var;
            fe5Var.K(this.c);
            this.a.add(this.p);
            ee5 ee5Var = new ee5(this.b, j26.N0);
            this.q = ee5Var;
            this.a.add(ee5Var);
            this.c.a(this.a);
        }
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

    public void d() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (joVar = this.c) == null || joVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof ge5) {
                    ((ge5) qnVar).s(i);
                }
            }
        }
    }

    public void f(te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, te5Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof ge5) {
                    ((ge5) qnVar).G(te5Var);
                }
            }
        }
    }

    public void g(List<qn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
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

    public void i(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dp4Var) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof ge5) {
                    ((ge5) qnVar).H(dp4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof ge5) {
                    ((ge5) qnVar).I(bdUniqueId);
                }
            }
        }
    }

    public void k(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, joVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof ge5) {
                    ((ge5) qnVar).K(joVar);
                }
            }
        }
    }
}
