package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.of6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes4.dex */
public abstract class ec6<T extends of6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final T[] b;

    public ec6(int i) {
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
        this.a = 0;
        if (i > 0) {
            this.b = (T[]) new of6[i];
        } else {
            this.b = (T[]) new of6[5];
        }
        Arrays.fill(this.b, (Object) null);
    }

    public synchronized boolean c(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            synchronized (this) {
                if (b(t)) {
                    return true;
                }
                if (this.a < this.b.length) {
                    T[] tArr = this.b;
                    int i = this.a;
                    this.a = i + 1;
                    tArr[i] = t;
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.a <= 0) {
                    return null;
                }
                T[] tArr = this.b;
                int i = this.a - 1;
                this.a = i;
                T t = tArr[i];
                this.b[i] = null;
                return t;
            }
        }
        return (T) invokeV.objValue;
    }

    public boolean b(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            for (int i = 0; i < this.a; i++) {
                if (Objects.equals(this.b[i], t)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
