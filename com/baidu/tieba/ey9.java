package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes3.dex */
public class ey9<T> implements fx9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gx9<? super T> a;
    public final fx9<T> b;

    /* loaded from: classes3.dex */
    public static final class a<T> extends lx9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final lx9<? super T> e;
        public final gx9<? super T> f;
        public boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lx9<? super T> lx9Var, gx9<? super T> gx9Var) {
            super(lx9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx9Var, gx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((lx9) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = lx9Var;
            this.f = gx9Var;
        }

        @Override // com.baidu.tieba.gx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.g) {
                return;
            }
            try {
                this.f.onCompleted();
                this.g = true;
                this.e.onCompleted();
            } catch (Throwable th) {
                rx9.f(th, this);
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g) {
                    m1a.j(th);
                    return;
                }
                this.g = true;
                try {
                    this.f.onError(th);
                    this.e.onError(th);
                } catch (Throwable th2) {
                    rx9.e(th2);
                    this.e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.g) {
                return;
            }
            try {
                this.f.onNext(t);
                this.e.onNext(t);
            } catch (Throwable th) {
                rx9.g(th, this, t);
            }
        }
    }

    public ey9(fx9<T> fx9Var, gx9<? super T> gx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fx9Var, gx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = fx9Var;
        this.a = gx9Var;
    }

    @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((lx9) ((lx9) obj));
    }

    public void call(lx9<? super T> lx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
            this.b.B(new a(lx9Var, this.a));
        }
    }
}
