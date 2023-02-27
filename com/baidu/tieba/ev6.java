package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ev6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h47 a;

    public ev6(TbPageContext tbPageContext, h47 h47Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, h47Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h47Var;
    }

    public void a(qw5 qw5Var) {
        h47 h47Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, qw5Var) == null) && (h47Var = this.a) != null && h47Var.P0() != null && this.a.P0().v0() != null && this.a.u1() != null && qw5Var != null && this.a.u1().g0() != null && this.a.s0() != null) {
            BdTypeRecyclerView g0 = this.a.u1().g0();
            int i = qw5Var.a;
            if (i != 2) {
                if (i != 3 || qw5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(qw5Var.a());
                this.a.s0().h0(0);
            } else if (qw5Var.a() == null) {
            } else {
                g0.removeHeaderView(qw5Var.a());
                g0.t(qw5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.s0().h0(8);
            }
        }
    }
}
