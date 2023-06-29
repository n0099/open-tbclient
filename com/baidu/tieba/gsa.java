package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.impl.CronetUrlRequestContext;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
@CheckDiscard("crbug.com/993421")
/* loaded from: classes6.dex */
public final class gsa implements CronetUrlRequestContext.f {
    public static /* synthetic */ Interceptable $ic;
    public static CronetUrlRequestContext.f a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947805876, "Lcom/baidu/tieba/gsa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947805876, "Lcom/baidu/tieba/gsa;");
        }
    }

    public gsa() {
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

    public static CronetUrlRequestContext.f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (GEN_JNI.TESTING_ENABLED) {
                CronetUrlRequestContext.f fVar = a;
                if (fVar != null) {
                    return fVar;
                }
                if (GEN_JNI.REQUIRE_MOCK) {
                    throw new UnsupportedOperationException("No mock found for the native implementation for com.baidu.turbonet.net.impl.CronetUrlRequestContext.Natives. The current configuration requires all native implementations to have a mock instance.");
                }
            }
            NativeLibraryLoadedStatus.checkLoaded(false);
            return new gsa();
        }
        return (CronetUrlRequestContext.f) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequestContext.f
    public long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequestContext_createRequestContextAdapter(j);
        }
        return invokeJ.longValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequestContext.f
    public int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequestContext_setMinLogLevel(i);
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequestContext.f
    public void b(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequestContext_applyBaiduConfigDictionary(j, str);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequestContext.f
    public void d(long j, CronetUrlRequestContext cronetUrlRequestContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, cronetUrlRequestContext) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(j, cronetUrlRequestContext);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequestContext.f
    public void f(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048581, this, j, str) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequestContext_applyBaiduConfiguration(j, str);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequestContext.f
    public void c(long j, CronetUrlRequestContext cronetUrlRequestContext, String str, String str2, int i, int i2, long j2, long j3, long j4, long j5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), cronetUrlRequestContext, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)}) == null) {
            GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequestContext_uploadNativeRequestLog(j, cronetUrlRequestContext, str, str2, i, i2, j2, j3, j4, j5);
        }
    }

    @Override // com.baidu.turbonet.net.impl.CronetUrlRequestContext.f
    public long e(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i, long j, String str4, long j2, boolean z5, boolean z6, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), Long.valueOf(j), str4, Long.valueOf(j2), Boolean.valueOf(z5), Boolean.valueOf(z6), Integer.valueOf(i2)})) == null) {
            return GEN_JNI.com_baidu_turbonet_net_impl_CronetUrlRequestContext_createRequestContextConfig(str, str2, z, str3, z2, z3, z4, i, j, str4, j2, z5, z6, i2);
        }
        return invokeCommon.longValue;
    }
}
