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
public class fw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<cn> c;
    public List<pn> d;
    public hx5 e;
    public lw5 f;

    public fw5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, hx5 hx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, hx5Var};
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
        this.e = hx5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ew5 ew5Var = new ew5(this.a);
            iw5 iw5Var = new iw5(this.a);
            jw5 jw5Var = new jw5(this.a);
            cw5 cw5Var = new cw5(this.a);
            hw5 hw5Var = new hw5(this.a);
            kw5 kw5Var = new kw5(this.a);
            gw5 gw5Var = new gw5(this.a);
            dw5 dw5Var = new dw5(this.a);
            this.f = new lw5(this.a);
            nw5 nw5Var = new nw5(this.a, this.e);
            mw5 mw5Var = new mw5(this.a);
            this.c.add(ew5Var);
            this.c.add(this.f);
            this.c.add(iw5Var);
            this.c.add(jw5Var);
            this.c.add(cw5Var);
            this.c.add(hw5Var);
            this.c.add(kw5Var);
            this.c.add(gw5Var);
            this.c.add(dw5Var);
            this.c.add(nw5Var);
            this.c.add(mw5Var);
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
        lw5 lw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (lw5Var = this.f) == null) {
            return;
        }
        lw5Var.D(str);
    }

    public void d(String str) {
        lw5 lw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (lw5Var = this.f) == null) {
            return;
        }
        lw5Var.a(str);
    }

    public void e(String str) {
        lw5 lw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (lw5Var = this.f) == null) {
            return;
        }
        lw5Var.E(str);
    }

    public void f(boolean z) {
        lw5 lw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (lw5Var = this.f) == null) {
            return;
        }
        lw5Var.F(z);
    }
}
