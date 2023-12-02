package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes5.dex */
public final class epc<T> extends joc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final joc<? super T> e;
    public final OnSubscribeAmb$Selection<T> f;
    public boolean g;

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.g) {
                return true;
            }
            if (this.f.get() == this) {
                this.g = true;
                return true;
            } else if (this.f.compareAndSet(null, this)) {
                this.f.unsubscribeOthers(this);
                this.g = true;
                return true;
            } else {
                this.f.unsubscribeLosers();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eoc
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && g()) {
            this.e.onCompleted();
        }
    }

    @Override // com.baidu.tieba.eoc
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) && g()) {
            this.e.onError(th);
        }
    }

    @Override // com.baidu.tieba.eoc
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, t) == null) && g()) {
            this.e.onNext(t);
        }
    }
}
