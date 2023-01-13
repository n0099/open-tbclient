package com.baidu.tieba;

import android.app.Application;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.browser.exception.TbWebViewException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g56 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static b9a<String> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947744961, "Lcom/baidu/tieba/g56;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947744961, "Lcom/baidu/tieba/g56;");
                return;
            }
        }
        c = new ArrayList();
    }

    public g56() {
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

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (List) invokeV.objValue;
    }

    public static String b() throws TbWebViewException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b9a<String> b9aVar = b;
            if (b9aVar == null) {
                if (!e()) {
                    return "";
                }
                throw new TbWebViewException("TBWebKit need call initUserAgent first !");
            }
            return b9aVar.call();
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void c(final Application application, g56 g56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, application, g56Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (d76.getContext() == null) {
                d76.b(application);
            }
            if (e()) {
                g76.a().f(new Runnable() { // from class: com.baidu.tieba.f56
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    }
                });
                o76.e(true);
                o76.d(3);
                o76.b("lt-log", "离线包开关状态：" + QuickWebViewSwitch.getInOn());
            }
            try {
                ((s76) ServiceManager.getService(s76.a)).a();
            } catch (Exception unused) {
            }
            if (UbsABTestHelper.isWebViewOptimizeTestGroup() || e()) {
                g76.a().f(new Runnable() { // from class: com.baidu.tieba.e56
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            i56.c().d(application);
                        }
                    }
                });
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    n66.h().k();
                }
            }
            try {
                f76.a().execute(new Runnable() { // from class: com.baidu.tieba.d56
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            p56.a();
                        }
                    }
                });
            } catch (Exception unused2) {
            }
            o76.b("lt-log", "init WebView Env 耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static void d(b9a<String> b9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, b9aVar) == null) {
            b = b9aVar;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            a = z;
        }
    }
}
