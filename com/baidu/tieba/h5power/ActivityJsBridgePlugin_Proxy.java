package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.hs9;
import com.baidu.tieba.is9;
import com.baidu.tieba.jh6;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
import com.baidu.tieba.qv4;
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
/* loaded from: classes5.dex */
public class ActivityJsBridgePlugin_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qv4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(qv4 qv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(WebView webView, ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var = new js9();
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                js9Var.s(true);
                js9 h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    js9Var.y(h.f());
                    js9Var.u(h.b());
                    js9Var.o(h.a());
                    js9Var.x(h.e());
                }
                js9Var.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                js9Var.s(true);
                js9 d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    js9Var.y(d.f());
                    js9Var.u(d.b());
                    js9Var.o(d.a());
                    js9Var.x(d.e());
                }
                js9Var.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                js9Var.s(true);
                js9 i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    js9Var.y(i.f());
                    js9Var.u(i.b());
                    js9Var.o(i.a());
                    js9Var.x(i.e());
                }
                js9Var.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                js9Var.s(true);
                js9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    js9Var.y(g.f());
                    js9Var.u(g.b());
                    js9Var.o(g.a());
                    js9Var.x(g.e());
                }
                js9Var.z(0);
            } else if (b.equals("activity/completeTask")) {
                js9Var.s(true);
                js9 f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    js9Var.y(f.f());
                    js9Var.u(f.b());
                    js9Var.o(f.a());
                    js9Var.x(f.e());
                }
                js9Var.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                js9Var.s(true);
                js9 c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    js9Var.y(c.f());
                    js9Var.u(c.b());
                    js9Var.o(c.a());
                    js9Var.x(c.e());
                }
                js9Var.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                js9Var.s(true);
                js9 j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    js9Var.y(j.f());
                    js9Var.u(j.b());
                    js9Var.o(j.a());
                    js9Var.x(j.e());
                }
                js9Var.z(0);
            }
            return js9Var;
        }
        return (js9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public jh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (jh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            js9 js9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                js9Var = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                js9Var = this.mJsBridge.e(webView, hashMap);
            }
            if (js9Var != null) {
                js9Var.z(0);
            }
            List<is9> list = this.mAsyncCallBackMethodList.get(str);
            if (js9Var != null && list != null) {
                Iterator<is9> it = list.iterator();
                if (!TextUtils.isEmpty(js9Var.e())) {
                    while (it.hasNext()) {
                        is9 next = it.next();
                        if (next.b().equals(js9Var.e())) {
                            js9 js9Var2 = new js9();
                            js9Var2.w(next.a());
                            js9Var2.y(js9Var.f());
                            js9Var2.u(js9Var.b());
                            js9Var2.o(js9Var.a());
                            js9Var2.A(js9Var.l());
                            arrayList.add(js9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        is9 next2 = it.next();
                        js9 js9Var3 = new js9();
                        js9Var3.w(next2.a());
                        js9Var3.y(js9Var.f());
                        js9Var3.u(js9Var.b());
                        js9Var3.o(js9Var.a());
                        js9Var3.A(js9Var.l());
                        arrayList.add(js9Var3);
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
