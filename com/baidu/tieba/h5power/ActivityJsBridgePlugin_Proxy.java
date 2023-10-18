package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
import com.baidu.tieba.tr4;
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
public class ActivityJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tr4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(tr4 tr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tr4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = tr4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(WebView webView, kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar = new ifa();
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                ifaVar.s(true);
                ifa h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    ifaVar.y(h.f());
                    ifaVar.u(h.b());
                    ifaVar.o(h.a());
                    ifaVar.x(h.e());
                }
                ifaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                ifaVar.s(true);
                ifa d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    ifaVar.y(d.f());
                    ifaVar.u(d.b());
                    ifaVar.o(d.a());
                    ifaVar.x(d.e());
                }
                ifaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                ifaVar.s(true);
                ifa i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    ifaVar.y(i.f());
                    ifaVar.u(i.b());
                    ifaVar.o(i.a());
                    ifaVar.x(i.e());
                }
                ifaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                ifaVar.s(true);
                ifa g = this.mJsBridge.g(webView);
                if (g != null) {
                    ifaVar.y(g.f());
                    ifaVar.u(g.b());
                    ifaVar.o(g.a());
                    ifaVar.x(g.e());
                }
                ifaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                ifaVar.s(true);
                ifa f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    ifaVar.y(f.f());
                    ifaVar.u(f.b());
                    ifaVar.o(f.a());
                    ifaVar.x(f.e());
                }
                ifaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                ifaVar.s(true);
                ifa c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    ifaVar.y(c.f());
                    ifaVar.u(c.b());
                    ifaVar.o(c.a());
                    ifaVar.x(c.e());
                }
                ifaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                ifaVar.s(true);
                ifa j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    ifaVar.y(j.f());
                    ifaVar.u(j.b());
                    ifaVar.o(j.a());
                    ifaVar.x(j.e());
                }
                ifaVar.z(0);
            }
            return ifaVar;
        }
        return (ifa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public gh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (gh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ifa ifaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                ifaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                ifaVar = this.mJsBridge.e(webView, hashMap);
            }
            if (ifaVar != null) {
                ifaVar.z(0);
            }
            List<hfa> list = this.mAsyncCallBackMethodList.get(str);
            if (ifaVar != null && list != null) {
                Iterator<hfa> it = list.iterator();
                if (!TextUtils.isEmpty(ifaVar.e())) {
                    while (it.hasNext()) {
                        hfa next = it.next();
                        if (next.b().equals(ifaVar.e())) {
                            ifa ifaVar2 = new ifa();
                            ifaVar2.w(next.a());
                            ifaVar2.y(ifaVar.f());
                            ifaVar2.u(ifaVar.b());
                            ifaVar2.o(ifaVar.a());
                            ifaVar2.j = ifaVar.j;
                            ifaVar2.A(ifaVar.l());
                            arrayList.add(ifaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        hfa next2 = it.next();
                        ifa ifaVar3 = new ifa();
                        ifaVar3.w(next2.a());
                        ifaVar3.y(ifaVar.f());
                        ifaVar3.u(ifaVar.b());
                        ifaVar3.o(ifaVar.a());
                        ifaVar3.j = ifaVar.j;
                        ifaVar3.A(ifaVar.l());
                        arrayList.add(ifaVar3);
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
