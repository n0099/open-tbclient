package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes3.dex */
public final class cta<T> implements sra.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sra<T> a;
    public final csa<? super T> b;
    public final csa<Throwable> c;

    /* loaded from: classes3.dex */
    public static final class a<T> extends tra<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final tra<? super T> b;
        public final csa<? super T> c;
        public final csa<Throwable> d;

        public a(tra<? super T> traVar, csa<? super T> csaVar, csa<Throwable> csaVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {traVar, csaVar, csaVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = traVar;
            this.c = csaVar;
            this.d = csaVar2;
        }

        @Override // com.baidu.tieba.tra
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    asa.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.tra
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    asa.h(th, this, t);
                }
            }
        }
    }

    public cta(sra<T> sraVar, csa<? super T> csaVar, csa<Throwable> csaVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sraVar, csaVar, csaVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sraVar;
        this.b = csaVar;
        this.c = csaVar2;
    }

    public void call(tra<? super T> traVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, traVar) == null) {
            a aVar = new a(traVar, this.b, this.c);
            traVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.sra.c, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((tra) ((tra) obj));
    }
}
