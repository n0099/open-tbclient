package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes5.dex */
public final class a6c implements t1c, b2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t1c a;
    public b2c b;
    public boolean c;

    public a6c(t1c t1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t1cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t1cVar;
    }

    @Override // com.baidu.tieba.t1c
    public void onSubscribe(b2c b2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2cVar) == null) {
            this.b = b2cVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                g2c.e(th);
                b2cVar.unsubscribe();
                onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.b2c
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.c && !this.b.isUnsubscribed()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t1c
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c) {
            return;
        }
        this.c = true;
        try {
            this.a.onCompleted();
        } catch (Throwable th) {
            g2c.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.unsubscribe();
        }
    }

    @Override // com.baidu.tieba.t1c
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            h6c.j(th);
            if (this.c) {
                return;
            }
            this.c = true;
            try {
                this.a.onError(th);
            } catch (Throwable th2) {
                g2c.e(th2);
                throw new OnErrorFailedException(new CompositeException(th, th2));
            }
        }
    }
}
