package com.baidu.tieba;

import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public BdTypeListView b;
    public final List<lh> c;
    public e96 d;
    public b96 e;
    public z86 f;
    public a96 g;

    public f96(BdPageContext bdPageContext, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = bdPageContext;
        this.b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                b96 b96Var = new b96((TbPageContext) this.a, u96.c);
                this.e = b96Var;
                this.c.add(b96Var);
            } else {
                e96 e96Var = new e96((TbPageContext) this.a, u96.c);
                this.d = e96Var;
                this.c.add(e96Var);
            }
            this.f = new z86((TbPageContext) this.a, h96.a);
            this.g = new a96((TbPageContext) this.a, i96.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.addAdapters(this.c);
        }
    }

    public void b(s56 s56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s56Var) == null) {
            e96 e96Var = this.d;
            if (e96Var != null) {
                e96Var.u(s56Var);
            }
            b96 b96Var = this.e;
            if (b96Var != null) {
                b96Var.u(s56Var);
            }
        }
    }

    public void c(List<yh> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeListView = this.b) != null) {
            bdTypeListView.setData(list);
        }
    }
}
