package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ih6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jq6 a;

    public ih6(TbPageContext tbPageContext, jq6 jq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, jq6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jq6Var;
    }

    public void a(gn5 gn5Var) {
        jq6 jq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gn5Var) == null) || (jq6Var = this.a) == null || jq6Var.J0() == null || this.a.J0().g0() == null || this.a.j1() == null || gn5Var == null || this.a.j1().d0() == null || this.a.n0() == null) {
            return;
        }
        BdTypeRecyclerView d0 = this.a.j1().d0();
        int i = gn5Var.a;
        if (i != 2) {
            if (i == 3 && gn5Var.a() != null) {
                d0.removeHeaderView(gn5Var.a());
                this.a.n0().h0(0);
            }
        } else if (gn5Var.a() == null) {
        } else {
            d0.removeHeaderView(gn5Var.a());
            d0.t(gn5Var.a(), d0.getHeaderViewsCount() - 1);
            this.a.n0().h0(8);
        }
    }
}
