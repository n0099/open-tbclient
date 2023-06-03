package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class fe0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947761112, "Lcom/baidu/tieba/fe0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947761112, "Lcom/baidu/tieba/fe0;");
                return;
            }
        }
        Pattern.compile("^((https|http|ftp|rtsp|mms)?://)?(([0-9a-zA-Z_!~*'().&=+$%-]+: )?[0-9a-zA-Z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-zA-Z_!~*'()-]+\\.)*([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\\.[a-zA-Z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$");
    }

    public static String a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String c = c(map);
                if (!TextUtils.isEmpty(c)) {
                    if (str.contains("?")) {
                        return str + "&" + c;
                    }
                    return str + "?" + c;
                }
                return str;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf <= 0) {
                return null;
            }
            return str.substring(indexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static String c(Map<String, String> map) {
        InterceptResult invokeL;
        String encode;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                String str3 = map.get(str2);
                if (str2 == null) {
                    encode = "";
                } else {
                    try {
                        encode = URLEncoder.encode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        if (de0.i()) {
                            throw new RuntimeException("This method requires UTF-8 encoding support", e);
                        }
                    }
                }
                sb.append(encode);
                sb.append("=");
                if (str3 == null) {
                    str = "";
                } else {
                    str = URLEncoder.encode(str3, "UTF-8");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> d(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                try {
                    String decode = URLDecoder.decode(split[0], "UTF-8");
                    if (split.length > 1) {
                        str2 = URLDecoder.decode(split[1], "UTF-8");
                    } else {
                        str2 = "";
                    }
                    hashMap.put(decode, str2);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
