package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes6.dex */
public final class i9c<T> implements r7c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r7c<T> a;
    public final b8c<? super T> b;
    public final b8c<Throwable> c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends s7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final s7c<? super T> b;
        public final b8c<? super T> c;
        public final b8c<Throwable> d;

        public a(s7c<? super T> s7cVar, b8c<? super T> b8cVar, b8c<Throwable> b8cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s7cVar, b8cVar, b8cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s7cVar;
            this.c = b8cVar;
            this.d = b8cVar2;
        }

        @Override // com.baidu.tieba.s7c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    z7c.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.s7c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    z7c.h(th, this, t);
                }
            }
        }
    }

    public i9c(r7c<T> r7cVar, b8c<? super T> b8cVar, b8c<Throwable> b8cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r7cVar, b8cVar, b8cVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = r7cVar;
        this.b = b8cVar;
        this.c = b8cVar2;
    }

    public void call(s7c<? super T> s7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s7cVar) == null) {
            a aVar = new a(s7cVar, this.b, this.c);
            s7cVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.r7c.c, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((s7c) ((s7c) obj));
    }
}
