package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
import com.baidu.tieba.sr4;
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
public class AccountJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sr4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(sr4 sr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sr4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = sr4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
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
            if (b.equals("account/startLoginModule")) {
                ifaVar.s(true);
                ifa r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    ifaVar.y(r.f());
                    ifaVar.u(r.b());
                    ifaVar.o(r.a());
                    ifaVar.x(r.e());
                }
                ifaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                ifaVar.s(true);
                ifa g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    ifaVar.y(g.f());
                    ifaVar.u(g.b());
                    ifaVar.o(g.a());
                    ifaVar.x(g.e());
                }
                ifaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                ifaVar.s(true);
                ifa q = this.mJsBridge.q(webView, e.optString("downloadUrl"));
                if (q != null) {
                    ifaVar.y(q.f());
                    ifaVar.u(q.b());
                    ifaVar.o(q.a());
                    ifaVar.x(q.e());
                }
                ifaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                ifaVar.s(true);
                ifa c = this.mJsBridge.c(webView);
                if (c != null) {
                    ifaVar.y(c.f());
                    ifaVar.u(c.b());
                    ifaVar.o(c.a());
                    ifaVar.x(c.e());
                }
                ifaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                ifaVar.s(true);
                ifa p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    ifaVar.y(p.f());
                    ifaVar.u(p.b());
                    ifaVar.o(p.a());
                    ifaVar.x(p.e());
                    if (!ifaVar.h()) {
                        ifaVar.n(false);
                        addObserver(webView, "commonLogin", ifaVar, false);
                    }
                }
                ifaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                ifaVar.s(true);
                ifa f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    ifaVar.y(f.f());
                    ifaVar.u(f.b());
                    ifaVar.o(f.a());
                    ifaVar.x(f.e());
                    if (!ifaVar.h()) {
                        ifaVar.n(false);
                        addObserver(webView, "aliAuthResult", ifaVar, false);
                    }
                }
                ifaVar.z(0);
            } else if (b.equals("account/authState")) {
                ifaVar.s(true);
                ifa d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    ifaVar.y(d.f());
                    ifaVar.u(d.b());
                    ifaVar.o(d.a());
                    ifaVar.x(d.e());
                    if (!ifaVar.h()) {
                        ifaVar.n(false);
                        addObserver(webView, "authStateResult", ifaVar, false);
                    }
                }
                ifaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                ifaVar.s(true);
                ifa n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    ifaVar.y(n.f());
                    ifaVar.u(n.b());
                    ifaVar.o(n.a());
                    ifaVar.x(n.e());
                    if (!ifaVar.h()) {
                        ifaVar.n(false);
                        addObserver(webView, "realNameAuthResult", ifaVar, false);
                    }
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
            if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                ifaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                ifaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                ifaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                ifaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                ifaVar = this.mJsBridge.o(webView, hashMap);
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
