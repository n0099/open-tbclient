package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class c10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
