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
/* loaded from: classes3.dex */
public class dd4 implements wc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kc4> a;
    public qa4 b;
    public List<wb4> c;
    public List<wb4> d;
    public List<wb4> e;

    public dd4(qa4 qa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qa4Var};
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
        this.b = qa4Var;
        this.a = new ArrayList();
        yc4.b().e(this);
    }

    @Override // com.baidu.tieba.wc4
    public <T> void a(ad4<T> ad4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ad4Var) == null) {
        }
    }

    @Override // com.baidu.tieba.wc4
    public <T> void b(ad4<T> ad4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad4Var) == null) || ad4Var.k()) {
            return;
        }
        Iterator<kc4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            kc4 next = it.next();
            if (next.b(ad4Var)) {
                int i = ad4Var.i();
                this.a.remove(next);
                if (i == 2) {
                    this.e.add(next.a().a.b);
                } else if (i == 3) {
                    this.d.add(next.a().a.b);
                } else if (i == 10) {
                    this.c.add(next.a().a.b);
                }
            }
        }
        d();
    }

    public void c(kc4 kc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kc4Var) == null) || kc4Var == null) {
            return;
        }
        this.a.add(kc4Var);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                yc4.b().g(this);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d()) {
            return;
        }
        for (kc4 kc4Var : this.a) {
            kc4Var.c(false);
        }
    }
}
