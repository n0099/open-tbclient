package com.baidu.tieba;

import com.baidu.adp.base.BdPageContext;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public final List<lh> b;
    public BdTypeMultiColumnListView c;
    public d96 d;
    public g96 e;

    public c96(BdPageContext bdPageContext, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, bdTypeMultiColumnListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.a = bdPageContext;
        this.c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = new d96((TbPageContext) this.a, j96.b);
            this.e = new g96((TbPageContext) this.a, j96.c);
            this.b.add(this.d);
            this.b.add(this.e);
            this.c.addAdapters(this.b);
        }
    }

    public void b(s56 s56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s56Var) == null) {
            d96 d96Var = this.d;
            if (d96Var != null) {
                d96Var.u(s56Var);
            }
            g96 g96Var = this.e;
            if (g96Var != null) {
                g96Var.u(s56Var);
            }
        }
    }

    public void c(List<yh> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeMultiColumnListView = this.c) != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
