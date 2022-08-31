package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ff6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ro6 a;

    public ff6(TbPageContext tbPageContext, ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ro6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ro6Var;
    }

    public void a(kk5 kk5Var) {
        ro6 ro6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, kk5Var) == null) || (ro6Var = this.a) == null || ro6Var.K0() == null || this.a.K0().g0() == null || this.a.k1() == null || kk5Var == null || this.a.k1().d0() == null || this.a.o0() == null) {
            return;
        }
        BdTypeRecyclerView d0 = this.a.k1().d0();
        int i = kk5Var.a;
        if (i != 2) {
            if (i == 3 && kk5Var.a() != null) {
                d0.removeHeaderView(kk5Var.a());
                this.a.o0().h0(0);
            }
        } else if (kk5Var.a() == null) {
        } else {
            d0.removeHeaderView(kk5Var.a());
            d0.t(kk5Var.a(), d0.getHeaderViewsCount() - 1);
            this.a.o0().h0(8);
        }
    }
}
