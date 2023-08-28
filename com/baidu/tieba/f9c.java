package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class f9c<T> implements p7c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* loaded from: classes5.dex */
    public class a extends v7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int e;
        public final /* synthetic */ v7c f;
        public final /* synthetic */ f9c g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f9c f9cVar, v7c v7cVar, v7c v7cVar2) {
            super(v7cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f9cVar, v7cVar, v7cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((v7c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = f9cVar;
            this.f = v7cVar2;
        }

        @Override // com.baidu.tieba.v7c
        public void f(r7c r7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r7cVar) == null) {
                this.f.f(r7cVar);
                r7cVar.request(this.g.a);
            }
        }

        @Override // com.baidu.tieba.q7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.f.onError(th);
            }
        }

        @Override // com.baidu.tieba.q7c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                int i = this.e;
                if (i >= this.g.a) {
                    this.f.onNext(t);
                } else {
                    this.e = i + 1;
                }
            }
        }

        @Override // com.baidu.tieba.q7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.onCompleted();
            }
        }
    }

    public f9c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i >= 0) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i);
    }

    public v7c<? super T> call(v7c<? super T> v7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v7cVar)) == null) {
            return new a(this, v7cVar, v7cVar);
        }
        return (v7c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p7c.b, com.baidu.tieba.i8c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((v7c) ((v7c) obj));
    }
}
