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
public class ff7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<tm> b;
    public mn c;
    public df7 d;
    public if7 e;
    public ye7 f;
    public af7 g;
    public ze7 h;
    public bf7 i;
    public cf7 j;
    public ef7 k;

    public ff7(TbPageContext tbPageContext, mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mnVar};
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
        this.c = mnVar;
        b();
    }

    public List<gn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        mn mnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (mnVar = this.c) != null) {
            mnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new hf7(this.a));
            this.b.add(new gf7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            df7 df7Var = new df7(this.a);
            this.d = df7Var;
            df7Var.x(this.c);
            this.b.add(this.d);
            if7 if7Var = new if7(this.a);
            this.e = if7Var;
            if7Var.x(this.c);
            this.b.add(this.e);
            ye7 ye7Var = new ye7(this.a);
            this.f = ye7Var;
            ye7Var.x(this.c);
            this.b.add(this.f);
            af7 af7Var = new af7(this.a);
            this.g = af7Var;
            af7Var.x(this.c);
            this.b.add(this.g);
            ze7 ze7Var = new ze7(this.a);
            this.h = ze7Var;
            ze7Var.x(this.c);
            this.b.add(this.h);
            bf7 bf7Var = new bf7(this.a);
            this.i = bf7Var;
            bf7Var.x(this.c);
            this.b.add(this.i);
            cf7 cf7Var = new cf7(this.a);
            this.j = cf7Var;
            cf7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            ef7 ef7Var = new ef7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = ef7Var;
            ef7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(xu4 xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xu4Var) == null) {
            for (tm tmVar : this.b) {
                if (tmVar instanceof xe7) {
                    ((xe7) tmVar).u(xu4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (tm tmVar : this.b) {
                tmVar.setPageId(bdUniqueId);
            }
        }
    }
}
