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
/* loaded from: classes6.dex */
public class g39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<oi> b;
    public List<bi> c;
    public c39 d;
    public c39 e;
    public c39 f;
    public e39 g;
    public e39 h;
    public e39 i;

    public g39(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void h(yl6 yl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yl6Var) == null) {
            this.i.y(yl6Var);
            this.h.y(yl6Var);
            this.g.y(yl6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            c39 c39Var = new c39(tbPageContext, a39.D);
            this.d = c39Var;
            c39Var.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            c39 c39Var2 = new c39(tbPageContext, a39.E);
            this.e = c39Var2;
            c39Var2.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            c39 c39Var3 = new c39(tbPageContext, a39.F);
            this.f = c39Var3;
            c39Var3.x(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            e39 e39Var = new e39(tbPageContext, a39.I);
            this.g = e39Var;
            e39Var.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            e39 e39Var2 = new e39(tbPageContext, a39.H);
            this.h = e39Var2;
            e39Var2.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            e39 e39Var3 = new e39(tbPageContext, a39.G);
            this.i = e39Var3;
            e39Var3.x(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
