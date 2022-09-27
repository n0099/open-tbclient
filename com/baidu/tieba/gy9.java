package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes4.dex */
public final class gy9<T, R> implements fx9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fx9<T> a;
    public final xx9<? super T, ? extends R> b;

    /* loaded from: classes4.dex */
    public static final class a<T, R> extends lx9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final lx9<? super R> e;
        public final xx9<? super T, ? extends R> f;
        public boolean g;

        public a(lx9<? super R> lx9Var, xx9<? super T, ? extends R> xx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx9Var, xx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = lx9Var;
            this.f = xx9Var;
        }

        @Override // com.baidu.tieba.lx9
        public void f(hx9 hx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hx9Var) == null) {
                this.e.f(hx9Var);
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.g) {
                return;
            }
            this.e.onCompleted();
        }

        @Override // com.baidu.tieba.gx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.g) {
                    m1a.j(th);
                    return;
                }
                this.g = true;
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                try {
                    this.e.onNext(this.f.call(t));
                } catch (Throwable th) {
                    rx9.e(th);
                    unsubscribe();
                    onError(OnErrorThrowable.addValueAsLastCause(th, t));
                }
            }
        }
    }

    public gy9(fx9<T> fx9Var, xx9<? super T, ? extends R> xx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fx9Var, xx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fx9Var;
        this.b = xx9Var;
    }

    @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((lx9) ((lx9) obj));
    }

    public void call(lx9<? super R> lx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
            a aVar = new a(lx9Var, this.b);
            lx9Var.b(aVar);
            this.a.B(aVar);
        }
    }
}
