package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (pi.H()) {
                return "WIFI";
            }
            if (pi.x()) {
                int f = pi.f();
                StringBuilder sb = new StringBuilder();
                if (f == 1) {
                    sb.append('M');
                } else if (f == 2) {
                    sb.append('U');
                } else if (f != 3) {
                    sb.append('N');
                } else {
                    sb.append('T');
                }
                if (pi.E()) {
                    sb.append("_WAP_");
                } else {
                    sb.append("_NET_");
                }
                if (pi.u()) {
                    sb.append("3G");
                } else if (pi.v()) {
                    sb.append("4G");
                } else if (pi.t()) {
                    sb.append("2G");
                } else {
                    sb.append('N');
                }
                return sb.toString();
            }
            return "unknown";
        }
        return (String) invokeL.objValue;
    }
}
