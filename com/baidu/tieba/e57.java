package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ie7 a;

    public e57(TbPageContext tbPageContext, ie7 ie7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ie7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ie7Var;
    }

    public void a(dx5 dx5Var) {
        ie7 ie7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dx5Var) == null) && (ie7Var = this.a) != null && ie7Var.S0() != null && this.a.S0().y0() != null && this.a.v1() != null && dx5Var != null && this.a.v1().g0() != null && this.a.v0() != null) {
            BdTypeRecyclerView g0 = this.a.v1().g0();
            int i = dx5Var.a;
            if (i != 2) {
                if (i != 3 || dx5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(dx5Var.a());
                this.a.v0().x0(0);
            } else if (dx5Var.a() == null) {
            } else {
                g0.removeHeaderView(dx5Var.a());
                g0.addHeaderView(dx5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.v0().x0(8);
            }
        }
    }
}
