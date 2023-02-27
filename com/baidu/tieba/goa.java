package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes4.dex */
public final class goa<T> implements wma.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wma<T> a;
    public final gna<? super T> b;
    public final gna<Throwable> c;

    /* loaded from: classes4.dex */
    public static final class a<T> extends xma<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xma<? super T> b;
        public final gna<? super T> c;
        public final gna<Throwable> d;

        public a(xma<? super T> xmaVar, gna<? super T> gnaVar, gna<Throwable> gnaVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xmaVar, gnaVar, gnaVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xmaVar;
            this.c = gnaVar;
            this.d = gnaVar2;
        }

        @Override // com.baidu.tieba.xma
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    ena.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.xma
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    ena.h(th, this, t);
                }
            }
        }
    }

    public goa(wma<T> wmaVar, gna<? super T> gnaVar, gna<Throwable> gnaVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wmaVar, gnaVar, gnaVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wmaVar;
        this.b = gnaVar;
        this.c = gnaVar2;
    }

    public void call(xma<? super T> xmaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xmaVar) == null) {
            a aVar = new a(xmaVar, this.b, this.c);
            xmaVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.wma.c, com.baidu.tieba.gna
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xma) ((xma) obj));
    }
}
