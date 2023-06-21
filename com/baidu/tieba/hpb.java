package com.baidu.tieba;

import com.baidu.tieba.gob;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class hpb<T, R> implements gob.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gob.a<T> a;
    public final gob.b<? extends R, ? super T> b;

    public hpb(gob.a<T> aVar, gob.b<? extends R, ? super T> bVar) {
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

    public void call(mob<? super R> mobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mobVar) == null) {
            try {
                mob mobVar2 = (mob) qsb.n(this.b).call(mobVar);
                mobVar2.d();
                this.a.call(mobVar2);
            } catch (Throwable th) {
                sob.e(th);
                mobVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mob) ((mob) obj));
    }
}
