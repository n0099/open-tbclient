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
/* loaded from: classes3.dex */
public class ae7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<Cdo> b;
    public List<qn> c;
    public wd7 d;
    public wd7 e;
    public wd7 f;
    public yd7 g;
    public yd7 h;
    public yd7 i;

    public ae7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (bdTypeRecyclerView = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.D(i);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            wd7 wd7Var = new wd7(tbPageContext, ud7.A);
            this.d = wd7Var;
            wd7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            wd7 wd7Var2 = new wd7(tbPageContext, ud7.B);
            this.e = wd7Var2;
            wd7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            wd7 wd7Var3 = new wd7(tbPageContext, ud7.C);
            this.f = wd7Var3;
            wd7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            yd7 yd7Var = new yd7(tbPageContext, ud7.F);
            this.g = yd7Var;
            yd7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            yd7 yd7Var2 = new yd7(tbPageContext, ud7.E);
            this.h = yd7Var2;
            yd7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            yd7 yd7Var3 = new yd7(tbPageContext, ud7.D);
            this.i = yd7Var3;
            yd7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (qn qnVar : this.c) {
            }
        }
    }

    public void e(no noVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, noVar) == null) {
            for (qn qnVar : this.c) {
                if (qnVar != null) {
                    qnVar.setOnAdapterItemClickListener(noVar);
                }
            }
        }
    }

    public void f(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(oo ooVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ooVar) == null) {
            for (qn qnVar : this.c) {
                if (qnVar != null) {
                    qnVar.setOnAdapterItemLongClickListener(ooVar);
                }
            }
        }
    }

    public void h(v16 v16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, v16Var) == null) {
            this.i.v(v16Var);
            this.h.v(v16Var);
            this.g.v(v16Var);
        }
    }
}
