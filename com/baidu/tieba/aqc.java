package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hoc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public final class aqc<T> implements hoc.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hoc<T> a;
    public final roc<? super T> b;
    public final roc<Throwable> c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends ioc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ioc<? super T> b;
        public final roc<? super T> c;
        public final roc<Throwable> d;

        public a(ioc<? super T> iocVar, roc<? super T> rocVar, roc<Throwable> rocVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iocVar, rocVar, rocVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iocVar;
            this.c = rocVar;
            this.d = rocVar2;
        }

        @Override // com.baidu.tieba.ioc
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    poc.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.ioc
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    poc.h(th, this, t);
                }
            }
        }
    }

    public aqc(hoc<T> hocVar, roc<? super T> rocVar, roc<Throwable> rocVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hocVar, rocVar, rocVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hocVar;
        this.b = rocVar;
        this.c = rocVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.roc
    /* renamed from: a */
    public void call(ioc<? super T> iocVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iocVar) == null) {
            a aVar = new a(iocVar, this.b, this.c);
            iocVar.a(aVar);
            this.a.j(aVar);
        }
    }
}
