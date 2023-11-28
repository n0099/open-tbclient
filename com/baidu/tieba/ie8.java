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
/* loaded from: classes6.dex */
public class ie8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ci> b;
    public vi c;
    public ge8 d;
    public le8 e;
    public be8 f;
    public de8 g;
    public ce8 h;
    public ee8 i;
    public fe8 j;
    public he8 k;

    public ie8(TbPageContext tbPageContext, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viVar};
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
        this.c = viVar;
        b();
    }

    public List<pi> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (viVar = this.c) != null) {
            viVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ke8(this.a));
            this.b.add(new je8(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            ge8 ge8Var = new ge8(this.a);
            this.d = ge8Var;
            ge8Var.y(this.c);
            this.b.add(this.d);
            le8 le8Var = new le8(this.a);
            this.e = le8Var;
            le8Var.y(this.c);
            this.b.add(this.e);
            be8 be8Var = new be8(this.a);
            this.f = be8Var;
            be8Var.y(this.c);
            this.b.add(this.f);
            de8 de8Var = new de8(this.a);
            this.g = de8Var;
            de8Var.y(this.c);
            this.b.add(this.g);
            ce8 ce8Var = new ce8(this.a);
            this.h = ce8Var;
            ce8Var.y(this.c);
            this.b.add(this.h);
            ee8 ee8Var = new ee8(this.a);
            this.i = ee8Var;
            ee8Var.y(this.c);
            this.b.add(this.i);
            fe8 fe8Var = new fe8(this.a);
            this.j = fe8Var;
            fe8Var.y(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            he8 he8Var = new he8(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = he8Var;
            he8Var.y(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(xu4 xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xu4Var) == null) {
            for (ci ciVar : this.b) {
                if (ciVar instanceof ae8) {
                    ((ae8) ciVar).x(xu4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (ci ciVar : this.b) {
                ciVar.setPageId(bdUniqueId);
            }
        }
    }
}
