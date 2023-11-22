package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.dj6;
import com.baidu.tieba.js4;
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
public class AccountJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public js4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(js4 js4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {js4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = js4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
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
            if (b.equals("account/startLoginModule")) {
                osaVar.s(true);
                osa r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    osaVar.y(r.f());
                    osaVar.u(r.b());
                    osaVar.o(r.a());
                    osaVar.x(r.e());
                }
                osaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                osaVar.s(true);
                osa g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    osaVar.y(g.f());
                    osaVar.u(g.b());
                    osaVar.o(g.a());
                    osaVar.x(g.e());
                }
                osaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                osaVar.s(true);
                osa q = this.mJsBridge.q(webView, e.optString("downloadUrl"));
                if (q != null) {
                    osaVar.y(q.f());
                    osaVar.u(q.b());
                    osaVar.o(q.a());
                    osaVar.x(q.e());
                }
                osaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                osaVar.s(true);
                osa c = this.mJsBridge.c(webView);
                if (c != null) {
                    osaVar.y(c.f());
                    osaVar.u(c.b());
                    osaVar.o(c.a());
                    osaVar.x(c.e());
                }
                osaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                osaVar.s(true);
                osa p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    osaVar.y(p.f());
                    osaVar.u(p.b());
                    osaVar.o(p.a());
                    osaVar.x(p.e());
                    if (!osaVar.h()) {
                        osaVar.n(false);
                        addObserver(webView, "commonLogin", osaVar, false);
                    }
                }
                osaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                osaVar.s(true);
                osa f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    osaVar.y(f.f());
                    osaVar.u(f.b());
                    osaVar.o(f.a());
                    osaVar.x(f.e());
                    if (!osaVar.h()) {
                        osaVar.n(false);
                        addObserver(webView, "aliAuthResult", osaVar, false);
                    }
                }
                osaVar.z(0);
            } else if (b.equals("account/authState")) {
                osaVar.s(true);
                osa d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    osaVar.y(d.f());
                    osaVar.u(d.b());
                    osaVar.o(d.a());
                    osaVar.x(d.e());
                    if (!osaVar.h()) {
                        osaVar.n(false);
                        addObserver(webView, "authStateResult", osaVar, false);
                    }
                }
                osaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                osaVar.s(true);
                osa n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    osaVar.y(n.f());
                    osaVar.u(n.b());
                    osaVar.o(n.a());
                    osaVar.x(n.e());
                    if (!osaVar.h()) {
                        osaVar.n(false);
                        addObserver(webView, "realNameAuthResult", osaVar, false);
                    }
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
            if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                osaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                osaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                osaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                osaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                osaVar = this.mJsBridge.o(webView, hashMap);
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
