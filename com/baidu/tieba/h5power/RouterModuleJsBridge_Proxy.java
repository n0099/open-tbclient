package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.b39;
import com.baidu.tieba.d39;
import com.baidu.tieba.wu4;
import com.baidu.tieba.z29;
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
public class RouterModuleJsBridge_Proxy extends z29 {
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

    @Override // com.baidu.tieba.z29
    public b39 dispatch(WebView webView, d39 d39Var, b39 b39Var) {
        InterceptResult invokeLLL;
        b39 b39Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, d39Var, b39Var)) == null) {
            if (b39Var == null) {
                b39Var2 = new b39();
            } else {
                b39Var2 = b39Var;
            }
            String b = d39Var.b();
            JSONObject e = d39Var.e();
            if (b.equals("router/finishThisPage")) {
                b39Var2.r(true);
                b39 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    b39Var2.x(c.f());
                    b39Var2.t(c.b());
                    b39Var2.o(c.a());
                    b39Var2.w(c.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/portal")) {
                b39Var2.r(true);
                b39 e2 = this.mJsBridge.e(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (e2 != null) {
                    b39Var2.x(e2.f());
                    b39Var2.t(e2.b());
                    b39Var2.o(e2.a());
                    b39Var2.w(e2.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                b39Var2.r(true);
                b39 b39Var3 = b39Var2;
                b39 d = this.mJsBridge.d(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (d != null) {
                    b39Var3.x(d.f());
                    b39Var3.t(d.b());
                    b39Var3.o(d.a());
                    b39Var3.w(d.e());
                }
                b39Var3.y(0);
                return b39Var3;
            }
            return b39Var2;
        }
        return (b39) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.z29
    public List<b39> processNotification(WebView webView, String str, HashMap hashMap) {
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
