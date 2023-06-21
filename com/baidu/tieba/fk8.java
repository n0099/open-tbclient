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
public class fk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<wn> b;
    public List<jn> c;
    public bk8 d;
    public bk8 e;
    public bk8 f;
    public dk8 g;
    public dk8 h;
    public dk8 i;

    public fk8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(go goVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, goVar) == null) {
            for (jn jnVar : this.c) {
                if (jnVar != null) {
                    jnVar.setOnAdapterItemClickListener(goVar);
                }
            }
        }
    }

    public void f(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hoVar) == null) {
            for (jn jnVar : this.c) {
                if (jnVar != null) {
                    jnVar.setOnAdapterItemLongClickListener(hoVar);
                }
            }
        }
    }

    public void h(lo6 lo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lo6Var) == null) {
            this.i.x(lo6Var);
            this.h.x(lo6Var);
            this.g.x(lo6Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            bk8 bk8Var = new bk8(tbPageContext, zj8.D);
            this.d = bk8Var;
            bk8Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            bk8 bk8Var2 = new bk8(tbPageContext, zj8.E);
            this.e = bk8Var2;
            bk8Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            bk8 bk8Var3 = new bk8(tbPageContext, zj8.F);
            this.f = bk8Var3;
            bk8Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            dk8 dk8Var = new dk8(tbPageContext, zj8.I);
            this.g = dk8Var;
            dk8Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            dk8 dk8Var2 = new dk8(tbPageContext, zj8.H);
            this.h = dk8Var2;
            dk8Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            dk8 dk8Var3 = new dk8(tbPageContext, zj8.G);
            this.i = dk8Var3;
            dk8Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (jn jnVar : this.c) {
            }
        }
    }
}
