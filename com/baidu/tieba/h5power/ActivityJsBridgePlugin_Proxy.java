package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.is9;
import com.baidu.tieba.js9;
import com.baidu.tieba.kh6;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
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
public class ActivityJsBridgePlugin_Proxy extends is9 {
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

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(WebView webView, ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                ks9Var.s(true);
                ks9 h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    ks9Var.y(h.f());
                    ks9Var.u(h.b());
                    ks9Var.o(h.a());
                    ks9Var.x(h.e());
                }
                ks9Var.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                ks9Var.s(true);
                ks9 d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    ks9Var.y(d.f());
                    ks9Var.u(d.b());
                    ks9Var.o(d.a());
                    ks9Var.x(d.e());
                }
                ks9Var.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                ks9Var.s(true);
                ks9 i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    ks9Var.y(i.f());
                    ks9Var.u(i.b());
                    ks9Var.o(i.a());
                    ks9Var.x(i.e());
                }
                ks9Var.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                ks9Var.s(true);
                ks9 g = this.mJsBridge.g(webView);
                if (g != null) {
                    ks9Var.y(g.f());
                    ks9Var.u(g.b());
                    ks9Var.o(g.a());
                    ks9Var.x(g.e());
                }
                ks9Var.z(0);
            } else if (b.equals("activity/completeTask")) {
                ks9Var.s(true);
                ks9 f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    ks9Var.y(f.f());
                    ks9Var.u(f.b());
                    ks9Var.o(f.a());
                    ks9Var.x(f.e());
                }
                ks9Var.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                ks9Var.s(true);
                ks9 c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    ks9Var.y(c.f());
                    ks9Var.u(c.b());
                    ks9Var.o(c.a());
                    ks9Var.x(c.e());
                }
                ks9Var.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                ks9Var.s(true);
                ks9 j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    ks9Var.y(j.f());
                    ks9Var.u(j.b());
                    ks9Var.o(j.a());
                    ks9Var.x(j.e());
                }
                ks9Var.z(0);
            }
            return ks9Var;
        }
        return (ks9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public kh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (kh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ks9 ks9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                ks9Var = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                ks9Var = this.mJsBridge.e(webView, hashMap);
            }
            if (ks9Var != null) {
                ks9Var.z(0);
            }
            List<js9> list = this.mAsyncCallBackMethodList.get(str);
            if (ks9Var != null && list != null) {
                Iterator<js9> it = list.iterator();
                if (!TextUtils.isEmpty(ks9Var.e())) {
                    while (it.hasNext()) {
                        js9 next = it.next();
                        if (next.b().equals(ks9Var.e())) {
                            ks9 ks9Var2 = new ks9();
                            ks9Var2.w(next.a());
                            ks9Var2.y(ks9Var.f());
                            ks9Var2.u(ks9Var.b());
                            ks9Var2.o(ks9Var.a());
                            ks9Var2.A(ks9Var.l());
                            arrayList.add(ks9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        js9 next2 = it.next();
                        ks9 ks9Var3 = new ks9();
                        ks9Var3.w(next2.a());
                        ks9Var3.y(ks9Var.f());
                        ks9Var3.u(ks9Var.b());
                        ks9Var3.o(ks9Var.a());
                        ks9Var3.A(ks9Var.l());
                        arrayList.add(ks9Var3);
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
