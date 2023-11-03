package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.cj6;
import com.baidu.tieba.ks4;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
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
public class ActivityJsBridgePlugin_Proxy extends lsa {
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

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar = new nsa();
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                nsaVar.s(true);
                nsa h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    nsaVar.y(h.f());
                    nsaVar.u(h.b());
                    nsaVar.o(h.a());
                    nsaVar.x(h.e());
                }
                nsaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                nsaVar.s(true);
                nsa d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    nsaVar.y(d.f());
                    nsaVar.u(d.b());
                    nsaVar.o(d.a());
                    nsaVar.x(d.e());
                }
                nsaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                nsaVar.s(true);
                nsa i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    nsaVar.y(i.f());
                    nsaVar.u(i.b());
                    nsaVar.o(i.a());
                    nsaVar.x(i.e());
                }
                nsaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                nsaVar.s(true);
                nsa g = this.mJsBridge.g(webView);
                if (g != null) {
                    nsaVar.y(g.f());
                    nsaVar.u(g.b());
                    nsaVar.o(g.a());
                    nsaVar.x(g.e());
                }
                nsaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                nsaVar.s(true);
                nsa f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    nsaVar.y(f.f());
                    nsaVar.u(f.b());
                    nsaVar.o(f.a());
                    nsaVar.x(f.e());
                }
                nsaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                nsaVar.s(true);
                nsa c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    nsaVar.y(c.f());
                    nsaVar.u(c.b());
                    nsaVar.o(c.a());
                    nsaVar.x(c.e());
                }
                nsaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                nsaVar.s(true);
                nsa j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    nsaVar.y(j.f());
                    nsaVar.u(j.b());
                    nsaVar.o(j.a());
                    nsaVar.x(j.e());
                }
                nsaVar.z(0);
            }
            return nsaVar;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (cj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            nsa nsaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                nsaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                nsaVar = this.mJsBridge.e(webView, hashMap);
            }
            if (nsaVar != null) {
                nsaVar.z(0);
            }
            List<msa> list = this.mAsyncCallBackMethodList.get(str);
            if (nsaVar != null && list != null) {
                Iterator<msa> it = list.iterator();
                if (!TextUtils.isEmpty(nsaVar.e())) {
                    while (it.hasNext()) {
                        msa next = it.next();
                        if (next.b().equals(nsaVar.e())) {
                            nsa nsaVar2 = new nsa();
                            nsaVar2.w(next.a());
                            nsaVar2.y(nsaVar.f());
                            nsaVar2.u(nsaVar.b());
                            nsaVar2.o(nsaVar.a());
                            nsaVar2.j = nsaVar.j;
                            nsaVar2.A(nsaVar.l());
                            arrayList.add(nsaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        msa next2 = it.next();
                        nsa nsaVar3 = new nsa();
                        nsaVar3.w(next2.a());
                        nsaVar3.y(nsaVar.f());
                        nsaVar3.u(nsaVar.b());
                        nsaVar3.o(nsaVar.a());
                        nsaVar3.j = nsaVar.j;
                        nsaVar3.A(nsaVar.l());
                        arrayList.add(nsaVar3);
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
