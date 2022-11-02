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
/* loaded from: classes4.dex */
public class h17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<jn> b;
    public co c;
    public f17 d;
    public k17 e;
    public a17 f;
    public c17 g;
    public b17 h;
    public d17 i;
    public e17 j;
    public g17 k;

    public h17(TbPageContext tbPageContext, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, coVar};
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
        this.c = coVar;
        b();
    }

    public List<wn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (coVar = this.c) != null) {
            coVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new j17(this.a));
            this.b.add(new i17(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            f17 f17Var = new f17(this.a);
            this.d = f17Var;
            f17Var.v(this.c);
            this.b.add(this.d);
            k17 k17Var = new k17(this.a);
            this.e = k17Var;
            k17Var.v(this.c);
            this.b.add(this.e);
            a17 a17Var = new a17(this.a);
            this.f = a17Var;
            a17Var.v(this.c);
            this.b.add(this.f);
            c17 c17Var = new c17(this.a);
            this.g = c17Var;
            c17Var.v(this.c);
            this.b.add(this.g);
            b17 b17Var = new b17(this.a);
            this.h = b17Var;
            b17Var.v(this.c);
            this.b.add(this.h);
            d17 d17Var = new d17(this.a);
            this.i = d17Var;
            d17Var.v(this.c);
            this.b.add(this.i);
            e17 e17Var = new e17(this.a);
            this.j = e17Var;
            e17Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            g17 g17Var = new g17(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = g17Var;
            g17Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void d(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(iq4 iq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iq4Var) == null) {
            for (jn jnVar : this.b) {
                if (jnVar instanceof z07) {
                    ((z07) jnVar).u(iq4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (jn jnVar : this.b) {
                jnVar.setPageId(bdUniqueId);
            }
        }
    }
}
