package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public he7 a;

    public d57(TbPageContext tbPageContext, he7 he7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, he7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = he7Var;
    }

    public void a(cx5 cx5Var) {
        he7 he7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cx5Var) == null) && (he7Var = this.a) != null && he7Var.S0() != null && this.a.S0().y0() != null && this.a.v1() != null && cx5Var != null && this.a.v1().g0() != null && this.a.v0() != null) {
            BdTypeRecyclerView g0 = this.a.v1().g0();
            int i = cx5Var.a;
            if (i != 2) {
                if (i != 3 || cx5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(cx5Var.a());
                this.a.v0().x0(0);
            } else if (cx5Var.a() == null) {
            } else {
                g0.removeHeaderView(cx5Var.a());
                g0.addHeaderView(cx5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.v0().x0(8);
            }
        }
    }
}
