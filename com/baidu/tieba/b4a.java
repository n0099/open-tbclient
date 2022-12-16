package com.baidu.tieba;

import com.baidu.tieba.b3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class b4a<T, R> implements b3a.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b3a.a<T> a;
    public final b3a.b<? extends R, ? super T> b;

    public b4a(b3a.a<T> aVar, b3a.b<? extends R, ? super T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.b = bVar;
    }

    public void call(h3a<? super R> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h3aVar) == null) {
            try {
                h3a h3aVar2 = (h3a) i7a.n(this.b).call(h3aVar);
                h3aVar2.d();
                this.a.call(h3aVar2);
            } catch (Throwable th) {
                n3a.e(th);
                h3aVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h3a) ((h3a) obj));
    }
}
