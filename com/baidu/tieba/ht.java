package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public class ht {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) ? bArr == null ? "" : new String(bArr, Charset.forName("UTF-8")) : (String) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.isEmpty(str) ? new byte[0] : str.getBytes(Charset.forName("UTF-8")) : (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? bArr == null ? new byte[0] : Base64.encode(bArr, 2) : (byte[]) invokeL.objValue;
    }

    public static byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? (bArr == null || bArr.length == 0) ? new byte[0] : Base64.decode(bArr, 2) : (byte[]) invokeL.objValue;
    }
}
