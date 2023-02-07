package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.v19;
import com.baidu.tieba.wu4;
import com.baidu.tieba.x19;
import com.baidu.tieba.z19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RouterModuleJsBridge_Proxy extends v19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wu4 mJsBridge;

    public RouterModuleJsBridge_Proxy(wu4 wu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = wu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.v19
    public x19 dispatch(WebView webView, z19 z19Var, x19 x19Var) {
        InterceptResult invokeLLL;
        x19 x19Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, z19Var, x19Var)) == null) {
            if (x19Var == null) {
                x19Var2 = new x19();
            } else {
                x19Var2 = x19Var;
            }
            String b = z19Var.b();
            JSONObject e = z19Var.e();
            if (b.equals("router/finishThisPage")) {
                x19Var2.r(true);
                x19 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    x19Var2.x(c.f());
                    x19Var2.t(c.b());
                    x19Var2.o(c.a());
                    x19Var2.w(c.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/portal")) {
                x19Var2.r(true);
                x19 e2 = this.mJsBridge.e(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (e2 != null) {
                    x19Var2.x(e2.f());
                    x19Var2.t(e2.b());
                    x19Var2.o(e2.a());
                    x19Var2.w(e2.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                x19Var2.r(true);
                x19 x19Var3 = x19Var2;
                x19 d = this.mJsBridge.d(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (d != null) {
                    x19Var3.x(d.f());
                    x19Var3.t(d.b());
                    x19Var3.o(d.a());
                    x19Var3.w(d.e());
                }
                x19Var3.y(0);
                return x19Var3;
            }
            return x19Var2;
        }
        return (x19) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.v19
    public List<x19> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!TextUtils.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
