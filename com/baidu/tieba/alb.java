package com.baidu.tieba;

import android.util.Base64;
import com.baidu.searchbox.retrieve.file.util.AESUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class alb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947620434, "Lcom/baidu/tieba/alb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947620434, "Lcom/baidu/tieba/alb;");
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            Charset forName = Charset.forName("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str2.getBytes(forName), 0), "AES");
            Cipher cipher = Cipher.getInstance(AESUtil.ECB_TRANSFORMATION);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str.getBytes(forName), 0)), forName);
        }
        return (String) invokeLL.objValue;
    }
}
