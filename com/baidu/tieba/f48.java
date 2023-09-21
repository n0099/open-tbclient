package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<om> b;
    public hn c;
    public d48 d;
    public i48 e;
    public y38 f;
    public a48 g;
    public z38 h;
    public b48 i;
    public c48 j;
    public e48 k;

    public f48(TbPageContext tbPageContext, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hnVar};
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
        this.c = hnVar;
        b();
    }

    public List<bn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hnVar = this.c) != null) {
            hnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new h48(this.a));
            this.b.add(new g48(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            d48 d48Var = new d48(this.a);
            this.d = d48Var;
            d48Var.x(this.c);
            this.b.add(this.d);
            i48 i48Var = new i48(this.a);
            this.e = i48Var;
            i48Var.x(this.c);
            this.b.add(this.e);
            y38 y38Var = new y38(this.a);
            this.f = y38Var;
            y38Var.x(this.c);
            this.b.add(this.f);
            a48 a48Var = new a48(this.a);
            this.g = a48Var;
            a48Var.x(this.c);
            this.b.add(this.g);
            z38 z38Var = new z38(this.a);
            this.h = z38Var;
            z38Var.x(this.c);
            this.b.add(this.h);
            b48 b48Var = new b48(this.a);
            this.i = b48Var;
            b48Var.x(this.c);
            this.b.add(this.i);
            c48 c48Var = new c48(this.a);
            this.j = c48Var;
            c48Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            e48 e48Var = new e48(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = e48Var;
            e48Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wz4Var) == null) {
            for (om omVar : this.b) {
                if (omVar instanceof x38) {
                    ((x38) omVar).u(wz4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (om omVar : this.b) {
                omVar.setPageId(bdUniqueId);
            }
        }
    }
}
