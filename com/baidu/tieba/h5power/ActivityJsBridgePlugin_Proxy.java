package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.dj6;
import com.baidu.tieba.ks4;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
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
public class ActivityJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ks4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(ks4 ks4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ks4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar = new osa();
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                osaVar.s(true);
                osa h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    osaVar.y(h.f());
                    osaVar.u(h.b());
                    osaVar.o(h.a());
                    osaVar.x(h.e());
                }
                osaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                osaVar.s(true);
                osa d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    osaVar.y(d.f());
                    osaVar.u(d.b());
                    osaVar.o(d.a());
                    osaVar.x(d.e());
                }
                osaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                osaVar.s(true);
                osa i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    osaVar.y(i.f());
                    osaVar.u(i.b());
                    osaVar.o(i.a());
                    osaVar.x(i.e());
                }
                osaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                osaVar.s(true);
                osa g = this.mJsBridge.g(webView);
                if (g != null) {
                    osaVar.y(g.f());
                    osaVar.u(g.b());
                    osaVar.o(g.a());
                    osaVar.x(g.e());
                }
                osaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                osaVar.s(true);
                osa f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    osaVar.y(f.f());
                    osaVar.u(f.b());
                    osaVar.o(f.a());
                    osaVar.x(f.e());
                }
                osaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                osaVar.s(true);
                osa c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    osaVar.y(c.f());
                    osaVar.u(c.b());
                    osaVar.o(c.a());
                    osaVar.x(c.e());
                }
                osaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                osaVar.s(true);
                osa j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    osaVar.y(j.f());
                    osaVar.u(j.b());
                    osaVar.o(j.a());
                    osaVar.x(j.e());
                }
                osaVar.z(0);
            }
            return osaVar;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            osa osaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                osaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                osaVar = this.mJsBridge.e(webView, hashMap);
            }
            if (osaVar != null) {
                osaVar.z(0);
            }
            List<nsa> list = this.mAsyncCallBackMethodList.get(str);
            if (osaVar != null && list != null) {
                Iterator<nsa> it = list.iterator();
                if (!TextUtils.isEmpty(osaVar.e())) {
                    while (it.hasNext()) {
                        nsa next = it.next();
                        if (next.b().equals(osaVar.e())) {
                            osa osaVar2 = new osa();
                            osaVar2.w(next.a());
                            osaVar2.y(osaVar.f());
                            osaVar2.u(osaVar.b());
                            osaVar2.o(osaVar.a());
                            osaVar2.j = osaVar.j;
                            osaVar2.A(osaVar.l());
                            arrayList.add(osaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nsa next2 = it.next();
                        osa osaVar3 = new osa();
                        osaVar3.w(next2.a());
                        osaVar3.y(osaVar.f());
                        osaVar3.u(osaVar.b());
                        osaVar3.o(osaVar.a());
                        osaVar3.j = osaVar.j;
                        osaVar3.A(osaVar.l());
                        arrayList.add(osaVar3);
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
