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
public class d48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<pm> b;
    public in c;
    public b48 d;
    public g48 e;
    public w38 f;
    public y38 g;
    public x38 h;
    public z38 i;
    public a48 j;
    public c48 k;

    public d48(TbPageContext tbPageContext, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, inVar};
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
        this.c = inVar;
        b();
    }

    public List<cn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        in inVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (inVar = this.c) != null) {
            inVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new f48(this.a));
            this.b.add(new e48(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            b48 b48Var = new b48(this.a);
            this.d = b48Var;
            b48Var.x(this.c);
            this.b.add(this.d);
            g48 g48Var = new g48(this.a);
            this.e = g48Var;
            g48Var.x(this.c);
            this.b.add(this.e);
            w38 w38Var = new w38(this.a);
            this.f = w38Var;
            w38Var.x(this.c);
            this.b.add(this.f);
            y38 y38Var = new y38(this.a);
            this.g = y38Var;
            y38Var.x(this.c);
            this.b.add(this.g);
            x38 x38Var = new x38(this.a);
            this.h = x38Var;
            x38Var.x(this.c);
            this.b.add(this.h);
            z38 z38Var = new z38(this.a);
            this.i = z38Var;
            z38Var.x(this.c);
            this.b.add(this.i);
            a48 a48Var = new a48(this.a);
            this.j = a48Var;
            a48Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            c48 c48Var = new c48(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = c48Var;
            c48Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wz4Var) == null) {
            for (pm pmVar : this.b) {
                if (pmVar instanceof v38) {
                    ((v38) pmVar).u(wz4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (pm pmVar : this.b) {
                pmVar.setPageId(bdUniqueId);
            }
        }
    }
}
