package com.baidu.tieba.flutter.base.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.flutter.base.util.OpenNative;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class PageRouter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FLUTTER_PAGE_URL = "f2f://";
    public static final String NATIVE_PAGE_URL = "f2n://";
    public transient /* synthetic */ FieldHolder $fh;

    public PageRouter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @TargetApi(11)
    public static boolean openPageByUrl(Context context, String str, Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, map)) == null) {
            try {
                if (str.startsWith(NATIVE_PAGE_URL)) {
                    return OpenNative.toNativePage(context, Uri.parse(str).getHost(), map);
                }
                if (str.startsWith(FLUTTER_PAGE_URL)) {
                    return OpenFlutter.openFlutterPage(context, Uri.parse(str).getHost(), map);
                }
                BdLog.e("flutter openPageByUrl not match");
                return false;
            } catch (Throwable th) {
                BdLog.e("flutter openPageByUrl error:" + th);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
