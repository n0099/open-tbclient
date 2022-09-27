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
public class he7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<Cdo> b;
    public List<qn> c;
    public je7 d;
    public je7 e;
    public je7 f;

    public he7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            je7 je7Var = new je7(tbPageContext, ie7.F);
            this.d = je7Var;
            je7Var.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            je7 je7Var2 = new je7(tbPageContext, ie7.E);
            this.e = je7Var2;
            je7Var2.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            je7 je7Var3 = new je7(tbPageContext, ie7.D);
            this.f = je7Var3;
            je7Var3.u(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            this.c.add(this.f);
            this.c.add(this.e);
            this.c.add(this.d);
            this.a.a(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(no noVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, noVar) == null) {
            for (qn qnVar : this.c) {
                if (qnVar != null) {
                    qnVar.setOnAdapterItemClickListener(noVar);
                }
            }
        }
    }

    public void e(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void f(oo ooVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ooVar) == null) {
            for (qn qnVar : this.c) {
                if (qnVar != null) {
                    qnVar.setOnAdapterItemLongClickListener(ooVar);
                }
            }
        }
    }

    public void g(i26 i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i26Var) == null) {
            this.f.v(i26Var);
            this.e.v(i26Var);
            this.d.v(i26Var);
        }
    }
}
