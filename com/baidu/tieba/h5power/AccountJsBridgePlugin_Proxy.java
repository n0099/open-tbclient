package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.cj6;
import com.baidu.tieba.js4;
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
public class AccountJsBridgePlugin_Proxy extends lsa {
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
            if (b.equals("account/startLoginModule")) {
                nsaVar.s(true);
                nsa r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    nsaVar.y(r.f());
                    nsaVar.u(r.b());
                    nsaVar.o(r.a());
                    nsaVar.x(r.e());
                }
                nsaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                nsaVar.s(true);
                nsa g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    nsaVar.y(g.f());
                    nsaVar.u(g.b());
                    nsaVar.o(g.a());
                    nsaVar.x(g.e());
                }
                nsaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                nsaVar.s(true);
                nsa q = this.mJsBridge.q(webView, e.optString("downloadUrl"));
                if (q != null) {
                    nsaVar.y(q.f());
                    nsaVar.u(q.b());
                    nsaVar.o(q.a());
                    nsaVar.x(q.e());
                }
                nsaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                nsaVar.s(true);
                nsa c = this.mJsBridge.c(webView);
                if (c != null) {
                    nsaVar.y(c.f());
                    nsaVar.u(c.b());
                    nsaVar.o(c.a());
                    nsaVar.x(c.e());
                }
                nsaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                nsaVar.s(true);
                nsa p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    nsaVar.y(p.f());
                    nsaVar.u(p.b());
                    nsaVar.o(p.a());
                    nsaVar.x(p.e());
                    if (!nsaVar.h()) {
                        nsaVar.n(false);
                        addObserver(webView, "commonLogin", nsaVar, false);
                    }
                }
                nsaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                nsaVar.s(true);
                nsa f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    nsaVar.y(f.f());
                    nsaVar.u(f.b());
                    nsaVar.o(f.a());
                    nsaVar.x(f.e());
                    if (!nsaVar.h()) {
                        nsaVar.n(false);
                        addObserver(webView, "aliAuthResult", nsaVar, false);
                    }
                }
                nsaVar.z(0);
            } else if (b.equals("account/authState")) {
                nsaVar.s(true);
                nsa d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    nsaVar.y(d.f());
                    nsaVar.u(d.b());
                    nsaVar.o(d.a());
                    nsaVar.x(d.e());
                    if (!nsaVar.h()) {
                        nsaVar.n(false);
                        addObserver(webView, "authStateResult", nsaVar, false);
                    }
                }
                nsaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                nsaVar.s(true);
                nsa n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    nsaVar.y(n.f());
                    nsaVar.u(n.b());
                    nsaVar.o(n.a());
                    nsaVar.x(n.e());
                    if (!nsaVar.h()) {
                        nsaVar.n(false);
                        addObserver(webView, "realNameAuthResult", nsaVar, false);
                    }
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
            if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                nsaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                nsaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                nsaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                nsaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                nsaVar = this.mJsBridge.o(webView, hashMap);
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
