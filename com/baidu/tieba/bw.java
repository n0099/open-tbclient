package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.matrixstyle.StyleModeContentProvider;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bw {
    public static /* synthetic */ Interceptable $ic = null;
    public static final bw a;
    public static int b = -1;
    public static int c = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301048, "Lcom/baidu/tieba/bw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301048, "Lcom/baidu/tieba/bw;");
                return;
            }
        }
        a = new bw();
    }

    public bw() {
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

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return QuickPersistConfig.getInstance().getBoolean("matrixstyle_force_default_ignore", false);
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (c() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (AppConfig.isDebug() && b()) {
                return false;
            }
            if (-1 == c) {
                c = QuickPersistConfig.getInstance().getInt("matrixstyle_force_default", 0);
            }
            if (1 != c) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return d();
            }
            String type = AppRuntime.getApplication().getContentResolver().getType(StyleModeContentProvider.a.a());
            if (type == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(type)) {
                try {
                } catch (Exception unused) {
                    return 0;
                }
            }
            return Integer.parseInt(type);
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (a()) {
                b = 0;
                return 0;
            }
            if (b == -1) {
                b = QuickPersistConfig.getInstance().getInt("matrixstyle_currentstyle", 0);
            }
            if (b == 2) {
                Context appContext = AppRuntime.getAppContext();
                String oldCUID = DeviceId.getOldCUID(appContext);
                String cuid = DeviceId.getCUID(appContext);
                if (!TextUtils.isEmpty(oldCUID) && !TextUtils.isEmpty(cuid) && !Intrinsics.areEqual(oldCUID, cuid) && !Intrinsics.areEqual(QuickPersistConfig.getInstance().getString("usercuid", ""), cuid)) {
                    QuickPersistConfig.getInstance().putInt("matrixstyle_currentstyle", 0);
                    QuickPersistConfig.getInstance().putString("usercuid", cuid);
                    b = 0;
                }
            }
            return b;
        }
        return invokeV.intValue;
    }
}
