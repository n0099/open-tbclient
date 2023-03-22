package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ora;
import com.baidu.tieba.sra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public final class dta<T> implements sra.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ora.a<T> a;

    /* loaded from: classes4.dex */
    public static final class a<T> extends ura<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final tra<? super T> e;
        public T f;
        public int g;

        public a(tra<? super T> traVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {traVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = traVar;
        }

        @Override // com.baidu.tieba.pra
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g == 2) {
                    vva.j(th);
                    return;
                }
                this.f = null;
                this.e.b(th);
            }
        }

        @Override // com.baidu.tieba.pra
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

        @Override // com.baidu.tieba.pra
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

    public dta(ora.a<T> aVar) {
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

    public void call(tra<? super T> traVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, traVar) == null) {
            a aVar = new a(traVar);
            traVar.a(aVar);
            this.a.call(aVar);
        }
    }

    @Override // com.baidu.tieba.sra.c, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((tra) ((tra) obj));
    }
}
