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
/* loaded from: classes5.dex */
public class brb {
    public static /* synthetic */ Interceptable $ic;
    public static final brb a;
    public transient /* synthetic */ FieldHolder $fh;

    public qmb g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (qmb) invokeV.objValue;
    }

    public qmb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (qmb) invokeV.objValue;
    }

    public qmb j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (qmb) invokeV.objValue;
    }

    @Deprecated
    public anb k(anb anbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, anbVar)) == null) ? anbVar : (anb) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655991, "Lcom/baidu/tieba/brb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655991, "Lcom/baidu/tieba/brb;");
                return;
            }
        }
        a = new brb();
    }

    public brb() {
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

    public static qmb a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b(new RxThreadFactory("RxComputationScheduler-"));
        }
        return (qmb) invokeV.objValue;
    }

    public static qmb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return d(new RxThreadFactory("RxIoScheduler-"));
        }
        return (qmb) invokeV.objValue;
    }

    public static qmb e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return f(new RxThreadFactory("RxNewThreadScheduler-"));
        }
        return (qmb) invokeV.objValue;
    }

    public static brb h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return a;
        }
        return (brb) invokeV.objValue;
    }

    public static qmb b(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadFactory)) == null) {
            if (threadFactory != null) {
                return new lob(threadFactory);
            }
            throw new NullPointerException("threadFactory == null");
        }
        return (qmb) invokeL.objValue;
    }

    public static qmb d(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, threadFactory)) == null) {
            if (threadFactory != null) {
                return new kob(threadFactory);
            }
            throw new NullPointerException("threadFactory == null");
        }
        return (qmb) invokeL.objValue;
    }

    public static qmb f(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadFactory)) == null) {
            if (threadFactory != null) {
                return new pob(threadFactory);
            }
            throw new NullPointerException("threadFactory == null");
        }
        return (qmb) invokeL.objValue;
    }
}
