package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class di7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pr7 a;

    public di7(TbPageContext tbPageContext, pr7 pr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pr7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pr7Var;
    }

    public void a(g56 g56Var) {
        pr7 pr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, g56Var) == null) && (pr7Var = this.a) != null && pr7Var.V0() != null && this.a.V0().D0() != null && this.a.y1() != null && g56Var != null && this.a.y1().g0() != null && this.a.x0() != null) {
            BdTypeRecyclerView g0 = this.a.y1().g0();
            int i = g56Var.a;
            if (i != 2) {
                if (i != 3 || g56Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(g56Var.a());
                this.a.x0().B0(0);
            } else if (g56Var.a() == null) {
            } else {
                g0.removeHeaderView(g56Var.a());
                g0.addHeaderView(g56Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.x0().B0(8);
            }
        }
    }
}
