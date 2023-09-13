package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class icc<T> implements sac.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* loaded from: classes6.dex */
    public class a extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int e;
        public final /* synthetic */ yac f;
        public final /* synthetic */ icc g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(icc iccVar, yac yacVar, yac yacVar2) {
            super(yacVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iccVar, yacVar, yacVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((yac) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = iccVar;
            this.f = yacVar2;
        }

        @Override // com.baidu.tieba.yac
        public void f(uac uacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                this.f.f(uacVar);
                uacVar.request(this.g.a);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.f.onError(th);
            }
        }

        @Override // com.baidu.tieba.tac
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

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.onCompleted();
            }
        }
    }

    public icc(int i) {
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

    public yac<? super T> call(yac<? super T> yacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yacVar)) == null) {
            return new a(this, yacVar, yacVar);
        }
        return (yac) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sac.b, com.baidu.tieba.lbc
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((yac) ((yac) obj));
    }
}
