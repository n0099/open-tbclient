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
/* loaded from: classes3.dex */
public class cp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<um> b;
    public nn c;
    public ap7 d;
    public fp7 e;
    public vo7 f;
    public xo7 g;
    public wo7 h;
    public yo7 i;
    public zo7 j;
    public bp7 k;

    public cp7(TbPageContext tbPageContext, nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, nnVar};
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
        this.c = nnVar;
        b();
    }

    public List<hn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        nn nnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (nnVar = this.c) != null) {
            nnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ep7(this.a));
            this.b.add(new dp7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            ap7 ap7Var = new ap7(this.a);
            this.d = ap7Var;
            ap7Var.x(this.c);
            this.b.add(this.d);
            fp7 fp7Var = new fp7(this.a);
            this.e = fp7Var;
            fp7Var.x(this.c);
            this.b.add(this.e);
            vo7 vo7Var = new vo7(this.a);
            this.f = vo7Var;
            vo7Var.x(this.c);
            this.b.add(this.f);
            xo7 xo7Var = new xo7(this.a);
            this.g = xo7Var;
            xo7Var.x(this.c);
            this.b.add(this.g);
            wo7 wo7Var = new wo7(this.a);
            this.h = wo7Var;
            wo7Var.x(this.c);
            this.b.add(this.h);
            yo7 yo7Var = new yo7(this.a);
            this.i = yo7Var;
            yo7Var.x(this.c);
            this.b.add(this.i);
            zo7 zo7Var = new zo7(this.a);
            this.j = zo7Var;
            zo7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            bp7 bp7Var = new bp7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = bp7Var;
            bp7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(zu4 zu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zu4Var) == null) {
            for (um umVar : this.b) {
                if (umVar instanceof uo7) {
                    ((uo7) umVar).u(zu4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (um umVar : this.b) {
                umVar.setPageId(bdUniqueId);
            }
        }
    }
}
