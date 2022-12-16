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
/* loaded from: classes3.dex */
public final class b7a implements a3a, i3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a3a a;
    public i3a b;
    public boolean c;

    public b7a(a3a a3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a3aVar;
    }

    @Override // com.baidu.tieba.a3a
    public void onSubscribe(i3a i3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, i3aVar) == null) {
            this.b = i3aVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                n3a.e(th);
                i3aVar.unsubscribe();
                onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.i3a
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

    @Override // com.baidu.tieba.a3a
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c) {
            return;
        }
        this.c = true;
        try {
            this.a.onCompleted();
        } catch (Throwable th) {
            n3a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // com.baidu.tieba.i3a
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.unsubscribe();
        }
    }

    @Override // com.baidu.tieba.a3a
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            i7a.j(th);
            if (this.c) {
                return;
            }
            this.c = true;
            try {
                this.a.onError(th);
            } catch (Throwable th2) {
                n3a.e(th2);
                throw new OnErrorFailedException(new CompositeException(th, th2));
            }
        }
    }
}
