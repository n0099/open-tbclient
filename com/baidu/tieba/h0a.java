package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes4.dex */
public final class h0a<T, R> implements gz9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gz9<T> a;
    public final yz9<? super T, ? extends R> b;

    /* loaded from: classes4.dex */
    public static final class a<T, R> extends mz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final mz9<? super R> e;
        public final yz9<? super T, ? extends R> f;
        public boolean g;

        public a(mz9<? super R> mz9Var, yz9<? super T, ? extends R> yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz9Var, yz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mz9Var;
            this.f = yz9Var;
        }

        @Override // com.baidu.tieba.mz9
        public void f(iz9 iz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iz9Var) == null) {
                this.e.f(iz9Var);
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.g) {
                    n3a.j(th);
                    return;
                }
                this.g = true;
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                try {
                    this.e.onNext(this.f.call(t));
                } catch (Throwable th) {
                    sz9.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g) {
                return;
            }
            this.e.onCompleted();
        }
    }

    public h0a(gz9<T> gz9Var, yz9<? super T, ? extends R> yz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gz9Var, yz9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gz9Var;
        this.b = yz9Var;
    }

    public void call(mz9<? super R> mz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mz9Var) == null) {
            a aVar = new a(mz9Var, this.b);
            mz9Var.b(aVar);
            this.a.B(aVar);
        }
    }

    @Override // com.baidu.tieba.gz9.a, com.baidu.tieba.uz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mz9) ((mz9) obj));
    }
}
