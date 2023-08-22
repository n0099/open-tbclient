package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.ix4;
import com.baidu.tieba.qga;
import com.baidu.tieba.rga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
import com.baidu.tieba.vl6;
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
public class ActivityJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ix4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(ix4 ix4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ix4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ix4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.qga
    public sga dispatch(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar = new sga();
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                sgaVar.s(true);
                sga h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    sgaVar.y(h.f());
                    sgaVar.u(h.b());
                    sgaVar.o(h.a());
                    sgaVar.x(h.e());
                }
                sgaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                sgaVar.s(true);
                sga d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    sgaVar.y(d.f());
                    sgaVar.u(d.b());
                    sgaVar.o(d.a());
                    sgaVar.x(d.e());
                }
                sgaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                sgaVar.s(true);
                sga i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    sgaVar.y(i.f());
                    sgaVar.u(i.b());
                    sgaVar.o(i.a());
                    sgaVar.x(i.e());
                }
                sgaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                sgaVar.s(true);
                sga g = this.mJsBridge.g(webView);
                if (g != null) {
                    sgaVar.y(g.f());
                    sgaVar.u(g.b());
                    sgaVar.o(g.a());
                    sgaVar.x(g.e());
                }
                sgaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                sgaVar.s(true);
                sga f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    sgaVar.y(f.f());
                    sgaVar.u(f.b());
                    sgaVar.o(f.a());
                    sgaVar.x(f.e());
                }
                sgaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                sgaVar.s(true);
                sga c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    sgaVar.y(c.f());
                    sgaVar.u(c.b());
                    sgaVar.o(c.a());
                    sgaVar.x(c.e());
                }
                sgaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                sgaVar.s(true);
                sga j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    sgaVar.y(j.f());
                    sgaVar.u(j.b());
                    sgaVar.o(j.a());
                    sgaVar.x(j.e());
                }
                sgaVar.z(0);
            }
            return sgaVar;
        }
        return (sga) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public vl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (vl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            sga sgaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                sgaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                sgaVar = this.mJsBridge.e(webView, hashMap);
            }
            if (sgaVar != null) {
                sgaVar.z(0);
            }
            List<rga> list = this.mAsyncCallBackMethodList.get(str);
            if (sgaVar != null && list != null) {
                Iterator<rga> it = list.iterator();
                if (!TextUtils.isEmpty(sgaVar.e())) {
                    while (it.hasNext()) {
                        rga next = it.next();
                        if (next.b().equals(sgaVar.e())) {
                            sga sgaVar2 = new sga();
                            sgaVar2.w(next.a());
                            sgaVar2.y(sgaVar.f());
                            sgaVar2.u(sgaVar.b());
                            sgaVar2.o(sgaVar.a());
                            sgaVar2.A(sgaVar.l());
                            arrayList.add(sgaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rga next2 = it.next();
                        sga sgaVar3 = new sga();
                        sgaVar3.w(next2.a());
                        sgaVar3.y(sgaVar.f());
                        sgaVar3.u(sgaVar.b());
                        sgaVar3.o(sgaVar.a());
                        sgaVar3.A(sgaVar.l());
                        arrayList.add(sgaVar3);
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
