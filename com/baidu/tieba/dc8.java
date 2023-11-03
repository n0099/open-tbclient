package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<bi> b;
    public ui c;
    public cc8 d;
    public hc8 e;
    public bc8 f;
    public fc8 g;
    public ec8 h;
    public gc8 i;
    public ic8 j;

    public dc8(TbPageContext tbPageContext, ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, uiVar};
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
        this.c = uiVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            cc8 cc8Var = new cc8(this.a);
            this.d = cc8Var;
            cc8Var.y(this.c);
            this.b.add(this.d);
            hc8 hc8Var = new hc8(this.a);
            this.e = hc8Var;
            hc8Var.y(this.c);
            this.b.add(this.e);
            bc8 bc8Var = new bc8(this.a);
            this.f = bc8Var;
            bc8Var.y(this.c);
            this.b.add(this.f);
            fc8 fc8Var = new fc8(this.a);
            this.g = fc8Var;
            fc8Var.y(this.c);
            this.b.add(this.g);
            ec8 ec8Var = new ec8(this.a);
            this.h = ec8Var;
            ec8Var.y(this.c);
            this.b.add(this.h);
            gc8 gc8Var = new gc8(this.a);
            this.i = gc8Var;
            gc8Var.y(this.c);
            this.b.add(this.i);
            ic8 ic8Var = new ic8(this.a);
            this.j = ic8Var;
            ic8Var.y(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        ui uiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (uiVar = this.c) != null) {
            uiVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<oi> list) {
        ui uiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (uiVar = this.c) != null) {
            uiVar.setData(list);
            b();
        }
    }

    public void d(vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vu4Var) == null) {
            for (bi biVar : this.b) {
                if (biVar instanceof ac8) {
                    ((ac8) biVar).x(vu4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (bi biVar : this.b) {
                biVar.setPageId(bdUniqueId);
            }
        }
    }
}
