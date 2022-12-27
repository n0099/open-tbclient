package com.baidu.tieba;

import com.baidu.tieba.c3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class c4a<T, R> implements c3a.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c3a.a<T> a;
    public final c3a.b<? extends R, ? super T> b;

    public c4a(c3a.a<T> aVar, c3a.b<? extends R, ? super T> bVar) {
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

    public void call(i3a<? super R> i3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i3aVar) == null) {
            try {
                i3a i3aVar2 = (i3a) j7a.n(this.b).call(i3aVar);
                i3aVar2.d();
                this.a.call(i3aVar2);
            } catch (Throwable th) {
                o3a.e(th);
                i3aVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.c3a.a, com.baidu.tieba.q3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i3a) ((i3a) obj));
    }
}
