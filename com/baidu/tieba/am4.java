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
/* loaded from: classes5.dex */
public class am4 implements tl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<hl4> a;
    public nj4 b;
    public List<tk4> c;
    public List<tk4> d;
    public List<tk4> e;

    @Override // com.baidu.tieba.tl4
    public <T> void a(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xl4Var) == null) {
        }
    }

    public am4(nj4 nj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nj4Var};
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
        this.b = nj4Var;
        this.a = new ArrayList();
        vl4.b().e(this);
    }

    @Override // com.baidu.tieba.tl4
    public <T> void b(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xl4Var) != null) || xl4Var.k()) {
            return;
        }
        Iterator<hl4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            hl4 next = it.next();
            if (next.b(xl4Var)) {
                int i = xl4Var.i();
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

    public void c(hl4 hl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hl4Var) == null) && hl4Var != null) {
            this.a.add(hl4Var);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                vl4.b().g(this);
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
        for (hl4 hl4Var : this.a) {
            hl4Var.c(false);
        }
    }
}
