package com.baidu.tieba;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class ca0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Hashtable<String, Typeface> a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947667895, "Lcom/baidu/tieba/ca0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947667895, "Lcom/baidu/tieba/ca0;");
                return;
            }
        }
        a = new Hashtable<>();
        b = LiveFeedPageSdk.getInstance().getApplication().getFilesDir().getAbsolutePath() + File.separator + "font/";
        new File(b).mkdirs();
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return new File(str).exists();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Typeface b(String str) {
        InterceptResult invokeL;
        Typeface typeface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (a) {
                if (!a.containsKey(str)) {
                    String str2 = b + str;
                    if (a(str2)) {
                        try {
                            a.put(str, Typeface.createFromFile(str2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                typeface = a.get(str) == null ? Typeface.DEFAULT : a.get(str);
            }
            return typeface;
        }
        return (Typeface) invokeL.objValue;
    }
}
