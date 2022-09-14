package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public interface aq0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "nativeCookieMgr");
    public static final ServiceReference b = new ServiceReference("nad.core", "sailorCookieMgr");
    public static final aq0 c = new a();
    public static final aq0 d = new b();

    /* loaded from: classes3.dex */
    public static class a implements aq0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final aq0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ServiceManager.getService(aq0.a) != null) {
                    return (aq0) ServiceManager.getService(aq0.a);
                }
                return aq0.d;
            }
            return (aq0) invokeV.objValue;
        }

        public final aq0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (ServiceManager.getService(aq0.b) != null) {
                    return (aq0) ServiceManager.getService(aq0.b);
                }
                return aq0.d;
            }
            return (aq0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.aq0
        public String getCookie(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(b().getCookie(str))) {
                    return b().getCookie(str);
                }
                return a().getCookie(str);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.aq0
        public boolean shouldAcceptCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.aq0
        public boolean shouldSendCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.aq0
        public void storeCookie(String str, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, list) == null) {
                b().storeCookie(str, list);
                a().storeCookie(str, list);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements aq0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.aq0
        public String getCookie(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? "" : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.aq0
        public boolean shouldAcceptCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.aq0
        public boolean shouldSendCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.aq0
        public void storeCookie(String str, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) {
            }
        }
    }

    String getCookie(String str);

    boolean shouldAcceptCookie(String str, String str2);

    boolean shouldSendCookie(String str, String str2);

    void storeCookie(String str, List<String> list);
}
