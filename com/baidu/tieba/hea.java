package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes4.dex */
public final class hea<T> implements xca.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xca<T> a;
    public final hda<? super T> b;
    public final hda<Throwable> c;

    /* loaded from: classes4.dex */
    public static final class a<T> extends yca<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final yca<? super T> b;
        public final hda<? super T> c;
        public final hda<Throwable> d;

        public a(yca<? super T> ycaVar, hda<? super T> hdaVar, hda<Throwable> hdaVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ycaVar, hdaVar, hdaVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ycaVar;
            this.c = hdaVar;
            this.d = hdaVar2;
        }

        @Override // com.baidu.tieba.yca
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    fda.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.yca
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    fda.h(th, this, t);
                }
            }
        }
    }

    public hea(xca<T> xcaVar, hda<? super T> hdaVar, hda<Throwable> hdaVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xcaVar, hdaVar, hdaVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xcaVar;
        this.b = hdaVar;
        this.c = hdaVar2;
    }

    public void call(yca<? super T> ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ycaVar) == null) {
            a aVar = new a(ycaVar, this.b, this.c);
            ycaVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.xca.c, com.baidu.tieba.hda
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yca) ((yca) obj));
    }
}
