package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hl0 {
    public static /* synthetic */ Interceptable $ic;
    public static IDownloadViewCreator a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947827421, "Lcom/baidu/tieba/hl0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947827421, "Lcom/baidu/tieba/hl0;");
        }
    }

    public static qk0<?> a(@NonNull ViewGroup viewGroup, IDownloadViewCreator.ViewType viewType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, viewGroup, viewType)) == null) {
            if (a == null) {
                synchronized (xh0.class) {
                    if (a == null) {
                        a = (IDownloadViewCreator) ServiceManager.getService(IDownloadViewCreator.a);
                    }
                    if (a == null) {
                        a = IDownloadViewCreator.b;
                    }
                }
            }
            return a.a(viewGroup, viewType);
        }
        return (qk0) invokeLL.objValue;
    }
}
