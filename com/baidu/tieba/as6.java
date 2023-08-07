package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.util.io.FileUtils;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class as6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, String> a;
    public static boolean b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            as6.g();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947625797, "Lcom/baidu/tieba/as6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947625797, "Lcom/baidu/tieba/as6;");
                return;
            }
        }
        a = new HashMap();
        b = false;
        c = BdBaseApplication.getInst().getFilesDir().toString() + File.separator + "res_cache" + File.separator + "dynamic_big_res";
        d = BdBaseApplication.getInst().getFilesDir().toString() + File.separator + "res_cache" + File.separator + "dynamic_big_res.zip";
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65542, null) != null) || !FileUtils.exists(d)) {
            return;
        }
        fs6.a(new a(), "ResLoader", 3);
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && d85.b(d, c)) {
            FileUtils.deleteFile(d);
        }
    }

    public static synchronized Uri b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            synchronized (as6.class) {
                Uri c2 = c(str);
                if (c2 != null) {
                    return c2;
                }
                return d(str2);
            }
        }
        return (Uri) invokeLL.objValue;
    }

    public static synchronized Uri c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (as6.class) {
                f();
                String str2 = c + File.separator + str;
                if (FileUtils.exists(str2)) {
                    return new Uri.Builder().scheme("file").path(str2).build();
                }
                return null;
            }
        }
        return (Uri) invokeL.objValue;
    }

    public static synchronized Uri d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            synchronized (as6.class) {
                e();
                String str2 = a.get(str);
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                return Uri.parse(str2);
            }
        }
        return (Uri) invokeL.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65541, null) != null) || b) {
            return;
        }
        b = true;
        try {
            JSONObject jSONObject = new JSONObject(SharedPrefHelper.getInstance().getString("dynamic_res_url", ""));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a.put(next, jSONObject.optString(next));
            }
        } catch (Throwable th) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.e("DynamicResLoader", "exception:" + th);
        }
    }
}
