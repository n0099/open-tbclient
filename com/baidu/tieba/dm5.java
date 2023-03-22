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
public class dm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<tm> a;
    public TbPageContext<?> b;
    public mn c;
    public sm5 d;
    public om5 e;
    public hm5 f;
    public jm5 g;
    public im5 h;
    public km5 i;
    public lm5 j;
    public nm5 k;
    public mm5 l;
    public qm5 m;
    public pm5 n;
    public rm5 o;
    public fm5 p;
    public em5 q;

    public dm5(TbPageContext tbPageContext, mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mnVar};
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
        this.c = mnVar;
        b();
    }

    public void a(List<tm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (tm tmVar : list) {
            if (!c(tmVar.getType())) {
                this.a.add(tmVar);
            }
        }
        this.c.addAdapters(this.a);
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (tm tmVar : this.a) {
                    if (tmVar != null && tmVar.getType() == bdUniqueId) {
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
            sm5 sm5Var = new sm5(this.b);
            this.d = sm5Var;
            sm5Var.M(this.c);
            this.a.add(this.d);
            om5 om5Var = new om5(this.b);
            this.e = om5Var;
            om5Var.M(this.c);
            this.a.add(this.e);
            rm5 rm5Var = new rm5(this.b);
            this.o = rm5Var;
            rm5Var.M(this.c);
            this.a.add(this.o);
            hm5 hm5Var = new hm5(this.b);
            this.f = hm5Var;
            hm5Var.M(this.c);
            this.a.add(this.f);
            jm5 jm5Var = new jm5(this.b);
            this.g = jm5Var;
            jm5Var.M(this.c);
            this.a.add(this.g);
            im5 im5Var = new im5(this.b);
            this.h = im5Var;
            im5Var.M(this.c);
            this.a.add(this.h);
            km5 km5Var = new km5(this.b);
            this.i = km5Var;
            km5Var.M(this.c);
            this.a.add(this.i);
            lm5 lm5Var = new lm5(this.b);
            this.j = lm5Var;
            lm5Var.M(this.c);
            this.a.add(this.j);
            nm5 nm5Var = new nm5(this.b);
            this.k = nm5Var;
            nm5Var.M(this.c);
            this.a.add(this.k);
            mm5 mm5Var = new mm5(this.b);
            this.l = mm5Var;
            mm5Var.M(this.c);
            this.a.add(this.l);
            qm5 qm5Var = new qm5(this.b);
            this.m = qm5Var;
            qm5Var.M(this.c);
            this.a.add(this.m);
            pm5 pm5Var = new pm5(this.b);
            this.n = pm5Var;
            pm5Var.M(this.c);
            this.a.add(this.n);
            fm5 fm5Var = new fm5(this.b);
            this.p = fm5Var;
            fm5Var.M(this.c);
            this.a.add(this.p);
            em5 em5Var = new em5(this.b, zf6.Q0);
            this.q = em5Var;
            this.a.add(em5Var);
            this.c.addAdapters(this.a);
        }
    }

    public void d() {
        mn mnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (mnVar = this.c) != null && mnVar.getListAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (tm tmVar : this.a) {
                if (tmVar instanceof gm5) {
                    ((gm5) tmVar).s(i);
                }
            }
        }
    }

    public void f(tm5 tm5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tm5Var) == null) {
            for (tm tmVar : this.a) {
                if (tmVar instanceof gm5) {
                    ((gm5) tmVar).I(tm5Var);
                }
            }
        }
    }

    public void g(List<tm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.addAdapters(this.a);
    }

    public void h(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(xu4 xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xu4Var) == null) {
            for (tm tmVar : this.a) {
                if (tmVar instanceof gm5) {
                    ((gm5) tmVar).J(xu4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (tm tmVar : this.a) {
                if (tmVar instanceof gm5) {
                    ((gm5) tmVar).L(bdUniqueId);
                }
            }
        }
    }

    public void k(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mnVar) == null) {
            for (tm tmVar : this.a) {
                if (tmVar instanceof gm5) {
                    ((gm5) tmVar).M(mnVar);
                }
            }
        }
    }
}
