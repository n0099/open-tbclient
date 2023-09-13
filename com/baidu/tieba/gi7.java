package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gi7 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static ThreadData b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947794964, "Lcom/baidu/tieba/gi7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947794964, "Lcom/baidu/tieba/gi7;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ThreadData b2 = b();
            if (b2 == null || !TbSingleton.getInstance().isPbPreloadSwitchOn() || !ThreadCardUtils.isPreloadType(b2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static ThreadData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (ThreadData) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ThreadData b2 = b();
            if (b2 == null) {
                return false;
            }
            if ((UbsABTestHelper.isConcernFeedTest() && b2.isFromConcern()) || (UbsABTestHelper.isConcernFeedTest() && b2.isFromHomPage)) {
                z = true;
            } else {
                z = false;
            }
            if (!z || !a()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static synchronized void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, obj) == null) {
            synchronized (gi7.class) {
                if (obj instanceof ThreadData) {
                    update((ThreadData) obj);
                }
            }
        }
    }

    public static synchronized void update(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, threadData) == null) {
            synchronized (gi7.class) {
                a = threadData.getTid();
                b = threadData;
            }
        }
    }
}
