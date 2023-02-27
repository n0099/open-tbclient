package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.l69;
import com.baidu.tieba.m69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
import com.baidu.tieba.vv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShareJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vv4 mJsBridge;

    public ShareJsBridgePlugin_Proxy(vv4 vv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
    }

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        n69 n69Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var2 = new n69();
            } else {
                n69Var2 = n69Var;
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("share/registerShareDataNew")) {
                n69Var2.r(true);
                n69 d = this.mJsBridge.d(webView, e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (d != null) {
                    n69Var2.x(d.f());
                    n69Var2.t(d.b());
                    n69Var2.o(d.a());
                    n69Var2.w(d.e());
                }
                n69Var2.y(0);
            } else if (b.equals("share/share")) {
                n69Var2.r(true);
                n69 f = this.mJsBridge.f(webView, e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"));
                if (f != null) {
                    n69Var2.x(f.f());
                    n69Var2.t(f.b());
                    n69Var2.o(f.a());
                    n69Var2.w(f.e());
                }
                n69Var2.y(0);
            }
            return n69Var2;
        }
        return (n69) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            n69 n69Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                n69Var = this.mJsBridge.h(webView, hashMap);
            }
            if (n69Var != null) {
                n69Var.y(0);
            }
            List<m69> list = this.mAsyncCallBackMethodList.get(str);
            if (n69Var != null && list != null) {
                Iterator<m69> it = list.iterator();
                if (!TextUtils.isEmpty(n69Var.e())) {
                    while (it.hasNext()) {
                        m69 next = it.next();
                        if (next.b().equals(n69Var.e())) {
                            n69 n69Var2 = new n69();
                            n69Var2.v(next.a());
                            n69Var2.x(n69Var.f());
                            n69Var2.t(n69Var.b());
                            n69Var2.o(n69Var.a());
                            n69Var2.z(n69Var.l());
                            arrayList.add(n69Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        m69 next2 = it.next();
                        n69 n69Var3 = new n69();
                        n69Var3.v(next2.a());
                        n69Var3.x(n69Var.f());
                        n69Var3.t(n69Var.b());
                        n69Var3.o(n69Var.a());
                        n69Var3.z(n69Var.l());
                        arrayList.add(n69Var3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
