package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class dfc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes5.dex */
    public static class a<T> extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tac e;

        public a(tac tacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tacVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tacVar;
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                this.e.onNext(t);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.onCompleted();
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes5.dex */
    public static class b<T> extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yac e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yac yacVar, yac yacVar2) {
            super(yacVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yacVar, yacVar2};
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
            this.e = yacVar2;
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.onCompleted();
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                this.e.onNext(t);
            }
        }
    }

    public static <T> yac<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return b(yec.a());
        }
        return (yac) invokeV.objValue;
    }

    public static <T> yac<T> b(tac<? super T> tacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tacVar)) == null) {
            return new a(tacVar);
        }
        return (yac) invokeL.objValue;
    }

    public static <T> yac<T> c(yac<? super T> yacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yacVar)) == null) {
            return new b(yacVar, yacVar);
        }
        return (yac) invokeL.objValue;
    }
}
