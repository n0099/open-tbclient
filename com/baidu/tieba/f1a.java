package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes4.dex */
public final class f1a<T> implements vz9.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vz9<T> a;
    public final f0a<? super T> b;
    public final f0a<Throwable> c;

    /* loaded from: classes4.dex */
    public static final class a<T> extends wz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wz9<? super T> b;
        public final f0a<? super T> c;
        public final f0a<Throwable> d;

        public a(wz9<? super T> wz9Var, f0a<? super T> f0aVar, f0a<Throwable> f0aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz9Var, f0aVar, f0aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wz9Var;
            this.c = f0aVar;
            this.d = f0aVar2;
        }

        @Override // com.baidu.tieba.wz9
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    d0a.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.wz9
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    d0a.h(th, this, t);
                }
            }
        }
    }

    public f1a(vz9<T> vz9Var, f0a<? super T> f0aVar, f0a<Throwable> f0aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vz9Var, f0aVar, f0aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vz9Var;
        this.b = f0aVar;
        this.c = f0aVar2;
    }

    public void call(wz9<? super T> wz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wz9Var) == null) {
            a aVar = new a(wz9Var, this.b, this.c);
            wz9Var.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.vz9.c, com.baidu.tieba.f0a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((wz9) ((wz9) obj));
    }
}
