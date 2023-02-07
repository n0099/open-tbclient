package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i17 a;

    public fs6(TbPageContext tbPageContext, i17 i17Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, i17Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i17Var;
    }

    public void a(zu5 zu5Var) {
        i17 i17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, zu5Var) == null) && (i17Var = this.a) != null && i17Var.Q0() != null && this.a.Q0().o0() != null && this.a.u1() != null && zu5Var != null && this.a.u1().g0() != null && this.a.s0() != null) {
            BdTypeRecyclerView g0 = this.a.u1().g0();
            int i = zu5Var.a;
            if (i != 2) {
                if (i != 3 || zu5Var.a() == null) {
                    return;
                }
                g0.removeHeaderView(zu5Var.a());
                this.a.s0().h0(0);
            } else if (zu5Var.a() == null) {
            } else {
                g0.removeHeaderView(zu5Var.a());
                g0.t(zu5Var.a(), g0.getHeaderViewsCount() - 1);
                this.a.s0().h0(8);
            }
        }
    }
}
