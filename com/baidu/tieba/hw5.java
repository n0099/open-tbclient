package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class hw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<cn> c;
    public List<pn> d;
    public jx5 e;
    public nw5 f;

    public hw5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, jx5 jx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, jx5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = bdTypeListView;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = jx5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gw5 gw5Var = new gw5(this.a);
            kw5 kw5Var = new kw5(this.a);
            lw5 lw5Var = new lw5(this.a);
            ew5 ew5Var = new ew5(this.a);
            jw5 jw5Var = new jw5(this.a);
            mw5 mw5Var = new mw5(this.a);
            iw5 iw5Var = new iw5(this.a);
            fw5 fw5Var = new fw5(this.a);
            this.f = new nw5(this.a);
            pw5 pw5Var = new pw5(this.a, this.e);
            ow5 ow5Var = new ow5(this.a);
            this.c.add(gw5Var);
            this.c.add(this.f);
            this.c.add(kw5Var);
            this.c.add(lw5Var);
            this.c.add(ew5Var);
            this.c.add(jw5Var);
            this.c.add(mw5Var);
            this.c.add(iw5Var);
            this.c.add(fw5Var);
            this.c.add(pw5Var);
            this.c.add(ow5Var);
            this.b.a(this.c);
        }
    }

    public void b(List<pn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
        this.b.setData(this.d);
    }

    public void c(String str) {
        nw5 nw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (nw5Var = this.f) == null) {
            return;
        }
        nw5Var.D(str);
    }

    public void d(String str) {
        nw5 nw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (nw5Var = this.f) == null) {
            return;
        }
        nw5Var.a(str);
    }

    public void e(String str) {
        nw5 nw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nw5Var = this.f) == null) {
            return;
        }
        nw5Var.E(str);
    }

    public void f(boolean z) {
        nw5 nw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (nw5Var = this.f) == null) {
            return;
        }
        nw5Var.F(z);
    }
}
