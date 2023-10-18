package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ax1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static JSONObject b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947630447, "Lcom/baidu/tieba/ax1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947630447, "Lcom/baidu/tieba/ax1;");
                return;
            }
        }
        a = am1.a;
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (ax1.class) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "release cache system info");
                }
                b = null;
            }
        }
    }

    public static JSONObject a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a) {
                Log.d("SystemInfoCacheHelper", "start create System Info");
            }
            WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            windowManager.getDefaultDisplay().getSize(new Point());
            windowManager.getDefaultDisplay().getRectSize(new Rect());
            Configuration configuration = context.getResources().getConfiguration();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("pixelRatio", displayMetrics.density);
                jSONObject.put("devicePixelRatio", displayMetrics.density);
                jSONObject.put("language", c(configuration));
                jSONObject.put("version", jj3.D());
                jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                jSONObject.put("fontSizeSetting", wo2.o().r());
                jSONObject.put("swanNativeVersion", bm1.a());
                jSONObject.put("host", wo2.n().a());
                jSONObject.put("statusBarHeight", gj3.O(gj3.t()));
                jSONObject.put("navigationBarHeight", gj3.O(gj3.j()));
                if (a) {
                    Log.d("SystemInfoCacheHelper", "end create System Info");
                }
                return jSONObject;
            } catch (JSONException e) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "crate system info error : ");
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Nullable
    public static synchronized JSONObject b(Context context) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (ax1.class) {
                if (b == null && context != null) {
                    if (a) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    b = a(context);
                }
                if (a) {
                    Log.d("SystemInfoCacheHelper", "return cache system info");
                }
                jSONObject = b;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static String c(Configuration configuration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, configuration)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i < 21) {
                return configuration.locale.toString();
            }
            if (i < 24) {
                return configuration.locale.toLanguageTag();
            }
            return configuration.getLocales().toLanguageTags();
        }
        return (String) invokeL.objValue;
    }

    public static void d(int i) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) && (jSONObject = b) != null) {
            try {
                jSONObject.put("fontSizeSetting", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    public static synchronized void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            synchronized (ax1.class) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "start pre cache system info");
                }
                if (!wo2.g0().s()) {
                    return;
                }
                if (b == null && context != null) {
                    if (a) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    b = a(context);
                }
                if (a) {
                    Log.d("SystemInfoCacheHelper", "end pre cache system info");
                }
            }
        }
    }
}
