package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h6c;
import com.baidu.tieba.l6c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
public final class f8c<T> implements l6c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h6c.a<T> a;

    /* loaded from: classes5.dex */
    public static final class a<T> extends n6c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final m6c<? super T> e;
        public T f;
        public int g;

        public a(m6c<? super T> m6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m6cVar;
        }

        @Override // com.baidu.tieba.i6c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g == 2) {
                    xac.j(th);
                    return;
                }
                this.f = null;
                this.e.b(th);
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                int i = this.g;
                if (i == 0) {
                    this.g = 1;
                    this.f = t;
                } else if (i == 1) {
                    this.g = 2;
                    this.e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
                }
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.g;
                if (i == 0) {
                    this.e.b(new NoSuchElementException());
                } else if (i == 1) {
                    this.g = 2;
                    T t = this.f;
                    this.f = null;
                    this.e.c(t);
                }
            }
        }
    }

    public f8c(h6c.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v6c
    /* renamed from: a */
    public void call(m6c<? super T> m6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m6cVar) == null) {
            a aVar = new a(m6cVar);
            m6cVar.a(aVar);
            this.a.call(aVar);
        }
    }
}
