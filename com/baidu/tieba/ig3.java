package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ig3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ig3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-719507562, "Lcom/baidu/tieba/ig3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-719507562, "Lcom/baidu/tieba/ig3$b;");
                    return;
                }
            }
            a = new ig3(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947852500, "Lcom/baidu/tieba/ig3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947852500, "Lcom/baidu/tieba/ig3;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public ig3() {
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

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                Resources system = Resources.getSystem();
                int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
                if (identifier != 0) {
                    return system.getInteger(identifier);
                }
                return 255;
            } catch (Exception unused) {
                return 255;
            }
        }
        return invokeV.intValue;
    }

    public static ig3 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return b.a;
        }
        return (ig3) invokeV.objValue;
    }

    public /* synthetic */ ig3(a aVar) {
        this();
    }

    public static float d(Context context) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            return i * (1.0f / b());
        }
        return invokeL.floatValue;
    }

    public float a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            if (activity != null) {
                float f = activity.getWindow().getAttributes().screenBrightness;
                if (f < 0.0f) {
                    return d(activity);
                }
                return f;
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    public void e(Activity activity, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, f) == null) && activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public void f(Activity activity, boolean z) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, activity, z) != null) || activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (z) {
            window.addFlags(128);
        } else {
            window.clearFlags(128);
        }
    }
}
