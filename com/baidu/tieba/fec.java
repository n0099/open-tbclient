package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.occ;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes5.dex */
public final class fec<T> implements occ.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final occ<T> a;
    public final ycc<? super T> b;
    public final ycc<Throwable> c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends pcc<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final pcc<? super T> b;
        public final ycc<? super T> c;
        public final ycc<Throwable> d;

        public a(pcc<? super T> pccVar, ycc<? super T> yccVar, ycc<Throwable> yccVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pccVar, yccVar, yccVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pccVar;
            this.c = yccVar;
            this.d = yccVar2;
        }

        @Override // com.baidu.tieba.pcc
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    wcc.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.pcc
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    wcc.h(th, this, t);
                }
            }
        }
    }

    public fec(occ<T> occVar, ycc<? super T> yccVar, ycc<Throwable> yccVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {occVar, yccVar, yccVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = occVar;
        this.b = yccVar;
        this.c = yccVar2;
    }

    public void call(pcc<? super T> pccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pccVar) == null) {
            a aVar = new a(pccVar, this.b, this.c);
            pccVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.occ.c, com.baidu.tieba.ycc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((pcc) ((pcc) obj));
    }
}
