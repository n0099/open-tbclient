package com.baidu.tieba;

import com.baidu.tieba.j5b;
import com.baidu.tieba.n5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class d7b<T> implements j5b.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final n5b.c<T> a;

    public d7b(n5b.c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    public void call(p5b<? super T> p5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p5bVar) == null) {
            b7b b7bVar = new b7b(p5bVar);
            p5bVar.b(b7bVar);
            this.a.call(b7bVar);
        }
    }

    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((p5b) ((p5b) obj));
    }
}
