package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<tm> c;
    public List<gn> d;
    public k86 e;
    public o76 f;

    public i76(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, k86 k86Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, k86Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = bdTypeListView;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = k86Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h76 h76Var = new h76(this.a);
            l76 l76Var = new l76(this.a);
            m76 m76Var = new m76(this.a);
            f76 f76Var = new f76(this.a);
            k76 k76Var = new k76(this.a);
            n76 n76Var = new n76(this.a);
            j76 j76Var = new j76(this.a);
            g76 g76Var = new g76(this.a);
            this.f = new o76(this.a);
            q76 q76Var = new q76(this.a, this.e);
            p76 p76Var = new p76(this.a);
            this.c.add(h76Var);
            this.c.add(this.f);
            this.c.add(l76Var);
            this.c.add(m76Var);
            this.c.add(f76Var);
            this.c.add(k76Var);
            this.c.add(n76Var);
            this.c.add(j76Var);
            this.c.add(g76Var);
            this.c.add(q76Var);
            this.c.add(p76Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<gn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        o76 o76Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (o76Var = this.f) != null) {
            o76Var.F(str);
        }
    }

    public void d(String str) {
        o76 o76Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (o76Var = this.f) != null) {
            o76Var.a(str);
        }
    }

    public void e(String str) {
        o76 o76Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (o76Var = this.f) != null) {
            o76Var.G(str);
        }
    }

    public void f(boolean z) {
        o76 o76Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (o76Var = this.f) != null) {
            o76Var.H(z);
        }
    }
}
