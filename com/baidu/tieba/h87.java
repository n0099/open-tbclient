package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qh7 a;

    public h87(TbPageContext tbPageContext, qh7 qh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, qh7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qh7Var;
    }

    public void a(pz5 pz5Var) {
        qh7 qh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pz5Var) == null) && (qh7Var = this.a) != null && qh7Var.U0() != null && this.a.U0().C0() != null && this.a.x1() != null && pz5Var != null && this.a.x1().g0() != null && this.a.w0() != null) {
            BdTypeRecyclerView g0 = this.a.x1().g0();
            int i = pz5Var.a;
            if (i != 2) {
                if (i != 3 || pz5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(pz5Var.a());
                this.a.w0().y0(0);
            } else if (pz5Var.a() == null) {
            } else {
                g0.removeHeaderView(pz5Var.a());
                g0.addHeaderView(pz5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.w0().y0(8);
            }
        }
    }
}
