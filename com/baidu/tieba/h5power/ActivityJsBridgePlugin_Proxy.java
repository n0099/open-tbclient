package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.lx4;
import com.baidu.tieba.qka;
import com.baidu.tieba.rka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
import com.baidu.tieba.xm6;
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
public class ActivityJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lx4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(lx4 lx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = lx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.qka
    public ska dispatch(WebView webView, uka ukaVar, ska skaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar = new ska();
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                skaVar.s(true);
                ska h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    skaVar.y(h.f());
                    skaVar.u(h.b());
                    skaVar.o(h.a());
                    skaVar.x(h.e());
                }
                skaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                skaVar.s(true);
                ska d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    skaVar.y(d.f());
                    skaVar.u(d.b());
                    skaVar.o(d.a());
                    skaVar.x(d.e());
                }
                skaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                skaVar.s(true);
                ska i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    skaVar.y(i.f());
                    skaVar.u(i.b());
                    skaVar.o(i.a());
                    skaVar.x(i.e());
                }
                skaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                skaVar.s(true);
                ska g = this.mJsBridge.g(webView);
                if (g != null) {
                    skaVar.y(g.f());
                    skaVar.u(g.b());
                    skaVar.o(g.a());
                    skaVar.x(g.e());
                }
                skaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                skaVar.s(true);
                ska f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    skaVar.y(f.f());
                    skaVar.u(f.b());
                    skaVar.o(f.a());
                    skaVar.x(f.e());
                }
                skaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                skaVar.s(true);
                ska c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    skaVar.y(c.f());
                    skaVar.u(c.b());
                    skaVar.o(c.a());
                    skaVar.x(c.e());
                }
                skaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                skaVar.s(true);
                ska j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    skaVar.y(j.f());
                    skaVar.u(j.b());
                    skaVar.o(j.a());
                    skaVar.x(j.e());
                }
                skaVar.z(0);
            }
            return skaVar;
        }
        return (ska) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public xm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ska skaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                skaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                skaVar = this.mJsBridge.e(webView, hashMap);
            }
            if (skaVar != null) {
                skaVar.z(0);
            }
            List<rka> list = this.mAsyncCallBackMethodList.get(str);
            if (skaVar != null && list != null) {
                Iterator<rka> it = list.iterator();
                if (!TextUtils.isEmpty(skaVar.e())) {
                    while (it.hasNext()) {
                        rka next = it.next();
                        if (next.b().equals(skaVar.e())) {
                            ska skaVar2 = new ska();
                            skaVar2.w(next.a());
                            skaVar2.y(skaVar.f());
                            skaVar2.u(skaVar.b());
                            skaVar2.o(skaVar.a());
                            skaVar2.j = skaVar.j;
                            skaVar2.A(skaVar.l());
                            arrayList.add(skaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rka next2 = it.next();
                        ska skaVar3 = new ska();
                        skaVar3.w(next2.a());
                        skaVar3.y(skaVar.f());
                        skaVar3.u(skaVar.b());
                        skaVar3.o(skaVar.a());
                        skaVar3.j = skaVar.j;
                        skaVar3.A(skaVar.l());
                        arrayList.add(skaVar3);
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
