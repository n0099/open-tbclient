package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.l69;
import com.baidu.tieba.lv4;
import com.baidu.tieba.m69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
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
public class ActivityJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lv4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(lv4 lv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = lv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                n69Var.r(true);
                n69 h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    n69Var.x(h.f());
                    n69Var.t(h.b());
                    n69Var.o(h.a());
                    n69Var.w(h.e());
                }
                n69Var.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                n69Var.r(true);
                n69 d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    n69Var.x(d.f());
                    n69Var.t(d.b());
                    n69Var.o(d.a());
                    n69Var.w(d.e());
                }
                n69Var.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                n69Var.r(true);
                n69 i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    n69Var.x(i.f());
                    n69Var.t(i.b());
                    n69Var.o(i.a());
                    n69Var.w(i.e());
                }
                n69Var.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                n69Var.r(true);
                n69 g = this.mJsBridge.g(webView);
                if (g != null) {
                    n69Var.x(g.f());
                    n69Var.t(g.b());
                    n69Var.o(g.a());
                    n69Var.w(g.e());
                }
                n69Var.y(0);
            } else if (b.equals("activity/completeTask")) {
                n69Var.r(true);
                n69 f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    n69Var.x(f.f());
                    n69Var.t(f.b());
                    n69Var.o(f.a());
                    n69Var.w(f.e());
                }
                n69Var.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                n69Var.r(true);
                n69 c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    n69Var.x(c.f());
                    n69Var.t(c.b());
                    n69Var.o(c.a());
                    n69Var.w(c.e());
                }
                n69Var.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                n69Var.r(true);
                n69 j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    n69Var.x(j.f());
                    n69Var.t(j.b());
                    n69Var.o(j.a());
                    n69Var.w(j.e());
                }
                n69Var.y(0);
            }
            return n69Var;
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
            if (str.equals("writePostSuccess")) {
                n69Var = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                n69Var = this.mJsBridge.e(webView, hashMap);
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
