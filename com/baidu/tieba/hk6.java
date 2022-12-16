package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ht6 a;

    public hk6(TbPageContext tbPageContext, ht6 ht6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ht6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ht6Var;
    }

    public void a(up5 up5Var) {
        ht6 ht6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, up5Var) == null) && (ht6Var = this.a) != null && ht6Var.N0() != null && this.a.N0().o0() != null && this.a.q1() != null && up5Var != null && this.a.q1().e0() != null && this.a.q0() != null) {
            BdTypeRecyclerView e0 = this.a.q1().e0();
            int i = up5Var.a;
            if (i != 2) {
                if (i != 3 || up5Var.a() == null) {
                    return;
                }
                e0.removeHeaderView(up5Var.a());
                this.a.q0().h0(0);
            } else if (up5Var.a() == null) {
            } else {
                e0.removeHeaderView(up5Var.a());
                e0.t(up5Var.a(), e0.getHeaderViewsCount() - 1);
                this.a.q0().h0(8);
            }
        }
    }
}
