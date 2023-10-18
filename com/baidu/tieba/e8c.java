package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l6c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public final class e8c<T> implements l6c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l6c<T> a;
    public final v6c<? super T> b;
    public final v6c<Throwable> c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends m6c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final m6c<? super T> b;
        public final v6c<? super T> c;
        public final v6c<Throwable> d;

        public a(m6c<? super T> m6cVar, v6c<? super T> v6cVar, v6c<Throwable> v6cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6cVar, v6cVar, v6cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m6cVar;
            this.c = v6cVar;
            this.d = v6cVar2;
        }

        @Override // com.baidu.tieba.m6c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    t6c.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.m6c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    t6c.h(th, this, t);
                }
            }
        }
    }

    public e8c(l6c<T> l6cVar, v6c<? super T> v6cVar, v6c<Throwable> v6cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l6cVar, v6cVar, v6cVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = l6cVar;
        this.b = v6cVar;
        this.c = v6cVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v6c
    /* renamed from: a */
    public void call(m6c<? super T> m6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m6cVar) == null) {
            a aVar = new a(m6cVar, this.b, this.c);
            m6cVar.a(aVar);
            this.a.j(aVar);
        }
    }
}
