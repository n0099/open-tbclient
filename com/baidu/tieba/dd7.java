package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vm7 a;

    public dd7(TbPageContext tbPageContext, vm7 vm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vm7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vm7Var;
    }

    public void a(ly5 ly5Var) {
        vm7 vm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ly5Var) == null) && (vm7Var = this.a) != null && vm7Var.l1() != null && this.a.l1().v0() != null && this.a.R1() != null && ly5Var != null && this.a.R1().h0() != null && this.a.N0() != null) {
            BdTypeRecyclerView h0 = this.a.R1().h0();
            int i = ly5Var.a;
            if (i != 2) {
                if (i != 3 || ly5Var.a() == null) {
                    return;
                }
                h0.removeHeaderView(ly5Var.a());
                this.a.N0().x0(0);
            } else if (ly5Var.a() == null) {
            } else {
                h0.removeHeaderView(ly5Var.a());
                h0.addHeaderView(ly5Var.a(), h0.getHeaderViewsCount() - 1);
                this.a.N0().x0(8);
            }
        }
    }
}
