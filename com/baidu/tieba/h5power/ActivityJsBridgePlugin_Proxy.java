package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.gx4;
import com.baidu.tieba.hca;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
import com.baidu.tieba.pk6;
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
public class ActivityJsBridgePlugin_Proxy extends hca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gx4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(gx4 gx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = gx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.hca
    public jca dispatch(WebView webView, lca lcaVar, jca jcaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar = new jca();
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                jcaVar.s(true);
                jca h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    jcaVar.y(h.f());
                    jcaVar.u(h.b());
                    jcaVar.o(h.a());
                    jcaVar.x(h.e());
                }
                jcaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                jcaVar.s(true);
                jca d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    jcaVar.y(d.f());
                    jcaVar.u(d.b());
                    jcaVar.o(d.a());
                    jcaVar.x(d.e());
                }
                jcaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                jcaVar.s(true);
                jca i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    jcaVar.y(i.f());
                    jcaVar.u(i.b());
                    jcaVar.o(i.a());
                    jcaVar.x(i.e());
                }
                jcaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                jcaVar.s(true);
                jca g = this.mJsBridge.g(webView);
                if (g != null) {
                    jcaVar.y(g.f());
                    jcaVar.u(g.b());
                    jcaVar.o(g.a());
                    jcaVar.x(g.e());
                }
                jcaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                jcaVar.s(true);
                jca f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    jcaVar.y(f.f());
                    jcaVar.u(f.b());
                    jcaVar.o(f.a());
                    jcaVar.x(f.e());
                }
                jcaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                jcaVar.s(true);
                jca c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    jcaVar.y(c.f());
                    jcaVar.u(c.b());
                    jcaVar.o(c.a());
                    jcaVar.x(c.e());
                }
                jcaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                jcaVar.s(true);
                jca j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    jcaVar.y(j.f());
                    jcaVar.u(j.b());
                    jcaVar.o(j.a());
                    jcaVar.x(j.e());
                }
                jcaVar.z(0);
            }
            return jcaVar;
        }
        return (jca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public pk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (pk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            jca jcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                jcaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                jcaVar = this.mJsBridge.e(webView, hashMap);
            }
            if (jcaVar != null) {
                jcaVar.z(0);
            }
            List<ica> list = this.mAsyncCallBackMethodList.get(str);
            if (jcaVar != null && list != null) {
                Iterator<ica> it = list.iterator();
                if (!TextUtils.isEmpty(jcaVar.e())) {
                    while (it.hasNext()) {
                        ica next = it.next();
                        if (next.b().equals(jcaVar.e())) {
                            jca jcaVar2 = new jca();
                            jcaVar2.w(next.a());
                            jcaVar2.y(jcaVar.f());
                            jcaVar2.u(jcaVar.b());
                            jcaVar2.o(jcaVar.a());
                            jcaVar2.A(jcaVar.l());
                            arrayList.add(jcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ica next2 = it.next();
                        jca jcaVar3 = new jca();
                        jcaVar3.w(next2.a());
                        jcaVar3.y(jcaVar.f());
                        jcaVar3.u(jcaVar.b());
                        jcaVar3.o(jcaVar.a());
                        jcaVar3.A(jcaVar.l());
                        arrayList.add(jcaVar3);
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
