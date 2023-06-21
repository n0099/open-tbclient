package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.jy4;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.zl6;
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
/* loaded from: classes6.dex */
public class ActivityJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jy4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(jy4 jy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = jy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                t0aVar.s(true);
                t0a h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    t0aVar.y(h.f());
                    t0aVar.u(h.b());
                    t0aVar.o(h.a());
                    t0aVar.x(h.e());
                }
                t0aVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                t0aVar.s(true);
                t0a d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    t0aVar.y(d.f());
                    t0aVar.u(d.b());
                    t0aVar.o(d.a());
                    t0aVar.x(d.e());
                }
                t0aVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                t0aVar.s(true);
                t0a i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    t0aVar.y(i.f());
                    t0aVar.u(i.b());
                    t0aVar.o(i.a());
                    t0aVar.x(i.e());
                }
                t0aVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                t0aVar.s(true);
                t0a g = this.mJsBridge.g(webView);
                if (g != null) {
                    t0aVar.y(g.f());
                    t0aVar.u(g.b());
                    t0aVar.o(g.a());
                    t0aVar.x(g.e());
                }
                t0aVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                t0aVar.s(true);
                t0a f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    t0aVar.y(f.f());
                    t0aVar.u(f.b());
                    t0aVar.o(f.a());
                    t0aVar.x(f.e());
                }
                t0aVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                t0aVar.s(true);
                t0a c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    t0aVar.y(c.f());
                    t0aVar.u(c.b());
                    t0aVar.o(c.a());
                    t0aVar.x(c.e());
                }
                t0aVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                t0aVar.s(true);
                t0a j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    t0aVar.y(j.f());
                    t0aVar.u(j.b());
                    t0aVar.o(j.a());
                    t0aVar.x(j.e());
                }
                t0aVar.z(0);
            }
            return t0aVar;
        }
        return (t0a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public zl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (zl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            t0a t0aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                t0aVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                t0aVar = this.mJsBridge.e(webView, hashMap);
            }
            if (t0aVar != null) {
                t0aVar.z(0);
            }
            List<s0a> list = this.mAsyncCallBackMethodList.get(str);
            if (t0aVar != null && list != null) {
                Iterator<s0a> it = list.iterator();
                if (!TextUtils.isEmpty(t0aVar.e())) {
                    while (it.hasNext()) {
                        s0a next = it.next();
                        if (next.b().equals(t0aVar.e())) {
                            t0a t0aVar2 = new t0a();
                            t0aVar2.w(next.a());
                            t0aVar2.y(t0aVar.f());
                            t0aVar2.u(t0aVar.b());
                            t0aVar2.o(t0aVar.a());
                            t0aVar2.A(t0aVar.l());
                            arrayList.add(t0aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        s0a next2 = it.next();
                        t0a t0aVar3 = new t0a();
                        t0aVar3.w(next2.a());
                        t0aVar3.y(t0aVar.f());
                        t0aVar3.u(t0aVar.b());
                        t0aVar3.o(t0aVar.a());
                        t0aVar3.A(t0aVar.l());
                        arrayList.add(t0aVar3);
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
