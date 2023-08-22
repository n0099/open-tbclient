package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class il4 implements bl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pk4> a;
    public vi4 b;
    public List<bk4> c;
    public List<bk4> d;
    public List<bk4> e;

    @Override // com.baidu.tieba.bl4
    public <T> void a(fl4<T> fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fl4Var) == null) {
        }
    }

    public il4(vi4 vi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vi4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.b = vi4Var;
        this.a = new ArrayList();
        dl4.b().e(this);
    }

    @Override // com.baidu.tieba.bl4
    public <T> void b(fl4<T> fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fl4Var) != null) || fl4Var.k()) {
            return;
        }
        Iterator<pk4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            pk4 next = it.next();
            if (next.b(fl4Var)) {
                int i = fl4Var.i();
                this.a.remove(next);
                if (i != 2) {
                    if (i != 3) {
                        if (i == 10) {
                            this.c.add(next.a().a.b);
                        }
                    } else {
                        this.d.add(next.a().a.b);
                    }
                } else {
                    this.e.add(next.a().a.b);
                }
            }
        }
        d();
    }

    public void c(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pk4Var) == null) && pk4Var != null) {
            this.a.add(pk4Var);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                dl4.b().g(this);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || d()) {
            return;
        }
        for (pk4 pk4Var : this.a) {
            pk4Var.c(false);
        }
    }
}
