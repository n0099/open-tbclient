package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class f39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<oi> b;
    public List<bi> c;
    public b39 d;
    public b39 e;
    public b39 f;
    public d39 g;
    public d39 h;
    public d39 i;

    public f39(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        if (tbPageContext != null && bdTypeRecyclerView != null) {
            this.a = bdTypeRecyclerView;
            b(tbPageContext);
        }
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (bdTypeRecyclerView = this.a) != null) {
            bdTypeRecyclerView.removeItem(i);
        }
    }

    public void e(yi yiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yiVar) == null) {
            for (bi biVar : this.c) {
                if (biVar != null) {
                    biVar.setOnAdapterItemClickListener(yiVar);
                }
            }
        }
    }

    public void f(ArrayList<oi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(zi ziVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ziVar) == null) {
            for (bi biVar : this.c) {
                if (biVar != null) {
                    biVar.setOnAdapterItemLongClickListener(ziVar);
                }
            }
        }
    }

    public void h(xl6 xl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xl6Var) == null) {
            this.i.y(xl6Var);
            this.h.y(xl6Var);
            this.g.y(xl6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            b39 b39Var = new b39(tbPageContext, z29.D);
            this.d = b39Var;
            b39Var.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b39 b39Var2 = new b39(tbPageContext, z29.E);
            this.e = b39Var2;
            b39Var2.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b39 b39Var3 = new b39(tbPageContext, z29.F);
            this.f = b39Var3;
            b39Var3.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            d39 d39Var = new d39(tbPageContext, z29.I);
            this.g = d39Var;
            d39Var.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            d39 d39Var2 = new d39(tbPageContext, z29.H);
            this.h = d39Var2;
            d39Var2.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            d39 d39Var3 = new d39(tbPageContext, z29.G);
            this.i = d39Var3;
            d39Var3.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.c.add(this.f);
            this.a.addAdapters(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (bi biVar : this.c) {
            }
        }
    }
}
