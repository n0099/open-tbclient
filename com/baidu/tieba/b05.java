package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, webView)) == null) {
            if (webView == null) {
                return h9.f().b();
            }
            Activity a = xm6.a(webView.getContext());
            if (a == null) {
                a = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            if (a == null) {
                a = h9.f().b();
            }
            if (a == null) {
                return webView.getContext();
            }
            return a;
        }
        return (Context) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && str.startsWith(tx4.a)) {
                    Uri parse = Uri.parse(str);
                    if (parse == null) {
                        return str;
                    }
                    String queryParameter = parse.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        return queryParameter;
                    }
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static Bitmap b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitmap)) == null) {
            if (bitmap == null) {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }
}
