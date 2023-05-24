package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class gi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            xh6.b("newHybrid", "基础版本：" + str + ",当前版本：" + str2);
            if (TextUtils.equals(str, str2)) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str.split("[._]");
                    String[] split2 = str2.split("[._]");
                    int min = Math.min(split.length, split2.length);
                    long j = 0;
                    for (int i = 0; i < min; i++) {
                        j = b(split2[i]).longValue() - b(split[i]).longValue();
                        if (j != 0) {
                            break;
                        }
                    }
                    int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                    if (i2 == 0) {
                        if (split2.length > split.length) {
                            return true;
                        }
                        return false;
                    } else if (i2 > 0) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }
}
