package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.by8;
import com.baidu.tieba.jq4;
import com.baidu.tieba.xx8;
import com.baidu.tieba.zx8;
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
public class RouterModuleJsBridge_Proxy extends xx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jq4 mJsBridge;

    public RouterModuleJsBridge_Proxy(jq4 jq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jq4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = jq4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.xx8
    public zx8 dispatch(WebView webView, by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLLL;
        zx8 zx8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, by8Var, zx8Var)) == null) {
            if (zx8Var == null) {
                zx8Var2 = new zx8();
            } else {
                zx8Var2 = zx8Var;
            }
            String b = by8Var.b();
            JSONObject e = by8Var.e();
            if (b.equals("router/finishThisPage")) {
                zx8Var2.r(true);
                zx8 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    zx8Var2.x(c.f());
                    zx8Var2.t(c.b());
                    zx8Var2.o(c.a());
                    zx8Var2.w(c.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/portal")) {
                zx8Var2.r(true);
                zx8 e2 = this.mJsBridge.e(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (e2 != null) {
                    zx8Var2.x(e2.f());
                    zx8Var2.t(e2.b());
                    zx8Var2.o(e2.a());
                    zx8Var2.w(e2.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                zx8Var2.r(true);
                zx8 zx8Var3 = zx8Var2;
                zx8 d = this.mJsBridge.d(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (d != null) {
                    zx8Var3.x(d.f());
                    zx8Var3.t(d.b());
                    zx8Var3.o(d.a());
                    zx8Var3.w(d.e());
                }
                zx8Var3.y(0);
                return zx8Var3;
            }
            return zx8Var2;
        }
        return (zx8) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.xx8
    public List<zx8> processNotification(WebView webView, String str, HashMap hashMap) {
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
