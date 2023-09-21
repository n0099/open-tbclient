package com.baidu.tieba;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes5.dex */
public class a2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                LogsUtil.f("UriUtil", "whiteListUrl is null");
                return null;
            } else if (!URLUtil.isNetworkUrl(str)) {
                return str;
            } else {
                return b(str);
            }
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(9)
    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                LogsUtil.f("UriUtil", "url is null");
                return str;
            }
            try {
                if (!URLUtil.isNetworkUrl(str)) {
                    LogsUtil.d("UriUtil", "url don't starts with http or https");
                    return "";
                }
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            } catch (MalformedURLException e) {
                LogsUtil.d("UriUtil", "getHostByURI error  MalformedURLException : " + e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, strArr)) == null) {
            if (strArr != null && strArr.length != 0) {
                for (String str2 : strArr) {
                    if (d(str, str2)) {
                        return true;
                    }
                }
                return false;
            }
            LogsUtil.d("UriUtil", "whitelist is null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean e(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, strArr)) == null) {
            if (strArr != null && strArr.length != 0) {
                for (String str2 : strArr) {
                    if (f(str, str2)) {
                        return true;
                    }
                }
                return false;
            }
            LogsUtil.d("UriUtil", "whitelist is null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return TextUtils.equals(b(str), a(str2));
            }
            Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, strArr)) == null) {
            if (strArr != null && strArr.length != 0) {
                for (String str2 : strArr) {
                    if (g(str, str2)) {
                        return true;
                    }
                }
                return false;
            }
            LogsUtil.d("UriUtil", "whitelist is null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!str.contains(IStringUtil.TOP_PATH) && !str.contains("@")) {
                    if (!str2.equals(str)) {
                        if (!str.startsWith(str2 + "?")) {
                            if (!str.startsWith(str2 + "#")) {
                                if (!str2.endsWith("/")) {
                                    return false;
                                }
                                if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                    return false;
                                }
                                return str.startsWith(str2);
                            }
                        }
                    }
                    return true;
                }
                Log.e("UriUtil", "url contains unsafe char");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            String b = b(str);
            if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(str2)) {
                String a = a(str2);
                if (TextUtils.isEmpty(a)) {
                    Log.e("UriUtil", "whitelist host is null");
                    return false;
                } else if (a.equals(b)) {
                    return true;
                } else {
                    if (b.endsWith(a)) {
                        try {
                            String substring = b.substring(0, b.length() - a.length());
                            if (!substring.endsWith(".")) {
                                return false;
                            }
                            return substring.matches("^[A-Za-z0-9.-]+$");
                        } catch (IndexOutOfBoundsException e) {
                            LogsUtil.d("UriUtil", "IndexOutOfBoundsException" + e.getMessage());
                        } catch (Exception e2) {
                            LogsUtil.d("UriUtil", "Exception : " + e2.getMessage());
                            return false;
                        }
                    }
                    return false;
                }
            }
            LogsUtil.d("UriUtil", "url or whitelist is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
