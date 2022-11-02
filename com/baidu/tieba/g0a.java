package com.baidu.tieba;

import com.baidu.tieba.gz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class g0a<T, R> implements gz9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gz9.a<T> a;
    public final gz9.b<? extends R, ? super T> b;

    public g0a(gz9.a<T> aVar, gz9.b<? extends R, ? super T> bVar) {
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

    public void call(mz9<? super R> mz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mz9Var) == null) {
            try {
                mz9 mz9Var2 = (mz9) n3a.n(this.b).call(mz9Var);
                mz9Var2.d();
                this.a.call(mz9Var2);
            } catch (Throwable th) {
                sz9.e(th);
                mz9Var.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.gz9.a, com.baidu.tieba.uz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mz9) ((mz9) obj));
    }
}
