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
public class ef8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ci> b;
    public vi c;
    public df8 d;
    public if8 e;
    public cf8 f;
    public gf8 g;
    public ff8 h;
    public hf8 i;
    public jf8 j;

    public ef8(TbPageContext tbPageContext, vi viVar) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            df8 df8Var = new df8(this.a);
            this.d = df8Var;
            df8Var.y(this.c);
            this.b.add(this.d);
            if8 if8Var = new if8(this.a);
            this.e = if8Var;
            if8Var.y(this.c);
            this.b.add(this.e);
            cf8 cf8Var = new cf8(this.a);
            this.f = cf8Var;
            cf8Var.y(this.c);
            this.b.add(this.f);
            gf8 gf8Var = new gf8(this.a);
            this.g = gf8Var;
            gf8Var.y(this.c);
            this.b.add(this.g);
            ff8 ff8Var = new ff8(this.a);
            this.h = ff8Var;
            ff8Var.y(this.c);
            this.b.add(this.h);
            hf8 hf8Var = new hf8(this.a);
            this.i = hf8Var;
            hf8Var.y(this.c);
            this.b.add(this.i);
            jf8 jf8Var = new jf8(this.a);
            this.j = jf8Var;
            jf8Var.y(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (viVar = this.c) != null) {
            viVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<pi> list) {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (viVar = this.c) != null) {
            viVar.setData(list);
            b();
        }
    }

    public void d(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, av4Var) == null) {
            for (ci ciVar : this.b) {
                if (ciVar instanceof bf8) {
                    ((bf8) ciVar).x(av4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (ci ciVar : this.b) {
                ciVar.setPageId(bdUniqueId);
            }
        }
    }
}
