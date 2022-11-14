package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes3.dex */
public class c4a {
    public static /* synthetic */ Interceptable $ic;
    public static final c4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public uz9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (uz9) invokeV.objValue;
    }

    public uz9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (uz9) invokeV.objValue;
    }

    public uz9 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (uz9) invokeV.objValue;
    }

    @Deprecated
    public e0a k(e0a e0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e0aVar)) == null) ? e0aVar : (e0a) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947626169, "Lcom/baidu/tieba/c4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947626169, "Lcom/baidu/tieba/c4a;");
                return;
            }
        }
        a = new c4a();
    }

    public c4a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static uz9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b(new RxThreadFactory("RxComputationScheduler-"));
        }
        return (uz9) invokeV.objValue;
    }

    public static uz9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return d(new RxThreadFactory("RxIoScheduler-"));
        }
        return (uz9) invokeV.objValue;
    }

    public static uz9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return f(new RxThreadFactory("RxNewThreadScheduler-"));
        }
        return (uz9) invokeV.objValue;
    }

    public static c4a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return a;
        }
        return (c4a) invokeV.objValue;
    }

    public static uz9 b(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadFactory)) == null) {
            if (threadFactory != null) {
                return new m1a(threadFactory);
            }
            throw new NullPointerException("threadFactory == null");
        }
        return (uz9) invokeL.objValue;
    }

    public static uz9 d(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, threadFactory)) == null) {
            if (threadFactory != null) {
                return new l1a(threadFactory);
            }
            throw new NullPointerException("threadFactory == null");
        }
        return (uz9) invokeL.objValue;
    }

    public static uz9 f(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadFactory)) == null) {
            if (threadFactory != null) {
                return new q1a(threadFactory);
            }
            throw new NullPointerException("threadFactory == null");
        }
        return (uz9) invokeL.objValue;
    }
}
