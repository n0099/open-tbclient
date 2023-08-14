package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.gx4;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
import com.baidu.tieba.qk6;
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
public class ActivityJsBridgePlugin_Proxy extends ica {
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

    @Override // com.baidu.tieba.ica
    public kca dispatch(WebView webView, mca mcaVar, kca kcaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar = new kca();
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                kcaVar.s(true);
                kca h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    kcaVar.y(h.f());
                    kcaVar.u(h.b());
                    kcaVar.o(h.a());
                    kcaVar.x(h.e());
                }
                kcaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                kcaVar.s(true);
                kca d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    kcaVar.y(d.f());
                    kcaVar.u(d.b());
                    kcaVar.o(d.a());
                    kcaVar.x(d.e());
                }
                kcaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                kcaVar.s(true);
                kca i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    kcaVar.y(i.f());
                    kcaVar.u(i.b());
                    kcaVar.o(i.a());
                    kcaVar.x(i.e());
                }
                kcaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                kcaVar.s(true);
                kca g = this.mJsBridge.g(webView);
                if (g != null) {
                    kcaVar.y(g.f());
                    kcaVar.u(g.b());
                    kcaVar.o(g.a());
                    kcaVar.x(g.e());
                }
                kcaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                kcaVar.s(true);
                kca f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    kcaVar.y(f.f());
                    kcaVar.u(f.b());
                    kcaVar.o(f.a());
                    kcaVar.x(f.e());
                }
                kcaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                kcaVar.s(true);
                kca c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    kcaVar.y(c.f());
                    kcaVar.u(c.b());
                    kcaVar.o(c.a());
                    kcaVar.x(c.e());
                }
                kcaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                kcaVar.s(true);
                kca j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    kcaVar.y(j.f());
                    kcaVar.u(j.b());
                    kcaVar.o(j.a());
                    kcaVar.x(j.e());
                }
                kcaVar.z(0);
            }
            return kcaVar;
        }
        return (kca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public qk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            kca kcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                kcaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                kcaVar = this.mJsBridge.e(webView, hashMap);
            }
            if (kcaVar != null) {
                kcaVar.z(0);
            }
            List<jca> list = this.mAsyncCallBackMethodList.get(str);
            if (kcaVar != null && list != null) {
                Iterator<jca> it = list.iterator();
                if (!TextUtils.isEmpty(kcaVar.e())) {
                    while (it.hasNext()) {
                        jca next = it.next();
                        if (next.b().equals(kcaVar.e())) {
                            kca kcaVar2 = new kca();
                            kcaVar2.w(next.a());
                            kcaVar2.y(kcaVar.f());
                            kcaVar2.u(kcaVar.b());
                            kcaVar2.o(kcaVar.a());
                            kcaVar2.A(kcaVar.l());
                            arrayList.add(kcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jca next2 = it.next();
                        kca kcaVar3 = new kca();
                        kcaVar3.w(next2.a());
                        kcaVar3.y(kcaVar.f());
                        kcaVar3.u(kcaVar.b());
                        kcaVar3.o(kcaVar.a());
                        kcaVar3.A(kcaVar.l());
                        arrayList.add(kcaVar3);
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
