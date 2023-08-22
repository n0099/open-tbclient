package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tq7 a;

    public dh7(TbPageContext tbPageContext, tq7 tq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tq7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tq7Var;
    }

    public void a(f36 f36Var) {
        tq7 tq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, f36Var) == null) && (tq7Var = this.a) != null && tq7Var.e1() != null && this.a.e1().v0() != null && this.a.L1() != null && f36Var != null && this.a.L1().g0() != null && this.a.F0() != null) {
            BdTypeRecyclerView g0 = this.a.L1().g0();
            int i = f36Var.a;
            if (i != 2) {
                if (i != 3 || f36Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(f36Var.a());
                this.a.F0().A0(0);
            } else if (f36Var.a() == null) {
            } else {
                g0.removeHeaderView(f36Var.a());
                g0.addHeaderView(f36Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.F0().A0(8);
            }
        }
    }
}
