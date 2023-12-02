package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.dxa;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.ns4;
import com.baidu.tieba.qj6;
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
public class AccountJsBridgePlugin_Proxy extends dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ns4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(ns4 ns4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ns4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ns4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("account/startLoginModule")) {
                fxaVar.s(true);
                fxa r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    fxaVar.y(r.f());
                    fxaVar.u(r.b());
                    fxaVar.o(r.a());
                    fxaVar.x(r.e());
                }
                fxaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                fxaVar.s(true);
                fxa g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    fxaVar.y(g.f());
                    fxaVar.u(g.b());
                    fxaVar.o(g.a());
                    fxaVar.x(g.e());
                }
                fxaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                fxaVar.s(true);
                fxa q = this.mJsBridge.q(webView, e.optString("downloadUrl"));
                if (q != null) {
                    fxaVar.y(q.f());
                    fxaVar.u(q.b());
                    fxaVar.o(q.a());
                    fxaVar.x(q.e());
                }
                fxaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                fxaVar.s(true);
                fxa c = this.mJsBridge.c(webView);
                if (c != null) {
                    fxaVar.y(c.f());
                    fxaVar.u(c.b());
                    fxaVar.o(c.a());
                    fxaVar.x(c.e());
                }
                fxaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                fxaVar.s(true);
                fxa p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    fxaVar.y(p.f());
                    fxaVar.u(p.b());
                    fxaVar.o(p.a());
                    fxaVar.x(p.e());
                    if (!fxaVar.h()) {
                        fxaVar.n(false);
                        addObserver(webView, "commonLogin", fxaVar, false);
                    }
                }
                fxaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                fxaVar.s(true);
                fxa f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    fxaVar.y(f.f());
                    fxaVar.u(f.b());
                    fxaVar.o(f.a());
                    fxaVar.x(f.e());
                    if (!fxaVar.h()) {
                        fxaVar.n(false);
                        addObserver(webView, "aliAuthResult", fxaVar, false);
                    }
                }
                fxaVar.z(0);
            } else if (b.equals("account/authState")) {
                fxaVar.s(true);
                fxa d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    fxaVar.y(d.f());
                    fxaVar.u(d.b());
                    fxaVar.o(d.a());
                    fxaVar.x(d.e());
                    if (!fxaVar.h()) {
                        fxaVar.n(false);
                        addObserver(webView, "authStateResult", fxaVar, false);
                    }
                }
                fxaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                fxaVar.s(true);
                fxa n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    fxaVar.y(n.f());
                    fxaVar.u(n.b());
                    fxaVar.o(n.a());
                    fxaVar.x(n.e());
                    if (!fxaVar.h()) {
                        fxaVar.n(false);
                        addObserver(webView, "realNameAuthResult", fxaVar, false);
                    }
                }
                fxaVar.z(0);
            }
            return fxaVar;
        }
        return (fxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            fxa fxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                fxaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                fxaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                fxaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                fxaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                fxaVar = this.mJsBridge.o(webView, hashMap);
            }
            if (fxaVar != null) {
                fxaVar.z(0);
            }
            List<exa> list = this.mAsyncCallBackMethodList.get(str);
            if (fxaVar != null && list != null) {
                Iterator<exa> it = list.iterator();
                if (!TextUtils.isEmpty(fxaVar.e())) {
                    while (it.hasNext()) {
                        exa next = it.next();
                        if (next.b().equals(fxaVar.e())) {
                            fxa fxaVar2 = new fxa();
                            fxaVar2.w(next.a());
                            fxaVar2.y(fxaVar.f());
                            fxaVar2.u(fxaVar.b());
                            fxaVar2.o(fxaVar.a());
                            fxaVar2.j = fxaVar.j;
                            fxaVar2.A(fxaVar.l());
                            arrayList.add(fxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        exa next2 = it.next();
                        fxa fxaVar3 = new fxa();
                        fxaVar3.w(next2.a());
                        fxaVar3.y(fxaVar.f());
                        fxaVar3.u(fxaVar.b());
                        fxaVar3.o(fxaVar.a());
                        fxaVar3.j = fxaVar.j;
                        fxaVar3.A(fxaVar.l());
                        arrayList.add(fxaVar3);
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
