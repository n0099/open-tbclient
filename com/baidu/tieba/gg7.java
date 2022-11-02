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
/* loaded from: classes4.dex */
public class gg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<wn> b;
    public List<jn> c;
    public cg7 d;
    public cg7 e;
    public cg7 f;
    public eg7 g;
    public eg7 h;
    public eg7 i;

    public gg7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            bdTypeRecyclerView.D(i);
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

    public void h(z36 z36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, z36Var) == null) {
            this.i.v(z36Var);
            this.h.v(z36Var);
            this.g.v(z36Var);
        }
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            cg7 cg7Var = new cg7(tbPageContext, ag7.A);
            this.d = cg7Var;
            cg7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            cg7 cg7Var2 = new cg7(tbPageContext, ag7.B);
            this.e = cg7Var2;
            cg7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            cg7 cg7Var3 = new cg7(tbPageContext, ag7.C);
            this.f = cg7Var3;
            cg7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            eg7 eg7Var = new eg7(tbPageContext, ag7.F);
            this.g = eg7Var;
            eg7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            eg7 eg7Var2 = new eg7(tbPageContext, ag7.E);
            this.h = eg7Var2;
            eg7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            eg7 eg7Var3 = new eg7(tbPageContext, ag7.D);
            this.i = eg7Var3;
            eg7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.c.add(this.f);
            this.a.a(this.c);
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
