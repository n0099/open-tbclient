package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
import com.baidu.tieba.ks4;
import com.baidu.tieba.mj6;
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
public class AccountJsBridgePlugin_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ks4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(ks4 ks4Var) {
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
        hashSet.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.exa
    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar = new gxa();
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("account/startLoginModule")) {
                gxaVar.s(true);
                gxa r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    gxaVar.y(r.f());
                    gxaVar.u(r.b());
                    gxaVar.o(r.a());
                    gxaVar.x(r.e());
                }
                gxaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                gxaVar.s(true);
                gxa g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    gxaVar.y(g.f());
                    gxaVar.u(g.b());
                    gxaVar.o(g.a());
                    gxaVar.x(g.e());
                }
                gxaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                gxaVar.s(true);
                gxa q = this.mJsBridge.q(webView, e.optString("downloadUrl"));
                if (q != null) {
                    gxaVar.y(q.f());
                    gxaVar.u(q.b());
                    gxaVar.o(q.a());
                    gxaVar.x(q.e());
                }
                gxaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                gxaVar.s(true);
                gxa c = this.mJsBridge.c(webView);
                if (c != null) {
                    gxaVar.y(c.f());
                    gxaVar.u(c.b());
                    gxaVar.o(c.a());
                    gxaVar.x(c.e());
                }
                gxaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                gxaVar.s(true);
                gxa p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    gxaVar.y(p.f());
                    gxaVar.u(p.b());
                    gxaVar.o(p.a());
                    gxaVar.x(p.e());
                    if (!gxaVar.h()) {
                        gxaVar.n(false);
                        addObserver(webView, "commonLogin", gxaVar, false);
                    }
                }
                gxaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                gxaVar.s(true);
                gxa f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    gxaVar.y(f.f());
                    gxaVar.u(f.b());
                    gxaVar.o(f.a());
                    gxaVar.x(f.e());
                    if (!gxaVar.h()) {
                        gxaVar.n(false);
                        addObserver(webView, "aliAuthResult", gxaVar, false);
                    }
                }
                gxaVar.z(0);
            } else if (b.equals("account/authState")) {
                gxaVar.s(true);
                gxa d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    gxaVar.y(d.f());
                    gxaVar.u(d.b());
                    gxaVar.o(d.a());
                    gxaVar.x(d.e());
                    if (!gxaVar.h()) {
                        gxaVar.n(false);
                        addObserver(webView, "authStateResult", gxaVar, false);
                    }
                }
                gxaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                gxaVar.s(true);
                gxa n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    gxaVar.y(n.f());
                    gxaVar.u(n.b());
                    gxaVar.o(n.a());
                    gxaVar.x(n.e());
                    if (!gxaVar.h()) {
                        gxaVar.n(false);
                        addObserver(webView, "realNameAuthResult", gxaVar, false);
                    }
                }
                gxaVar.z(0);
            }
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public mj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (mj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            gxa gxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                gxaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                gxaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                gxaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                gxaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                gxaVar = this.mJsBridge.o(webView, hashMap);
            }
            if (gxaVar != null) {
                gxaVar.z(0);
            }
            List<fxa> list = this.mAsyncCallBackMethodList.get(str);
            if (gxaVar != null && list != null) {
                Iterator<fxa> it = list.iterator();
                if (!TextUtils.isEmpty(gxaVar.e())) {
                    while (it.hasNext()) {
                        fxa next = it.next();
                        if (next.b().equals(gxaVar.e())) {
                            gxa gxaVar2 = new gxa();
                            gxaVar2.w(next.a());
                            gxaVar2.y(gxaVar.f());
                            gxaVar2.u(gxaVar.b());
                            gxaVar2.o(gxaVar.a());
                            gxaVar2.j = gxaVar.j;
                            gxaVar2.A(gxaVar.l());
                            arrayList.add(gxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        fxa next2 = it.next();
                        gxa gxaVar3 = new gxa();
                        gxaVar3.w(next2.a());
                        gxaVar3.y(gxaVar.f());
                        gxaVar3.u(gxaVar.b());
                        gxaVar3.o(gxaVar.a());
                        gxaVar3.j = gxaVar.j;
                        gxaVar3.A(gxaVar.l());
                        arrayList.add(gxaVar3);
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
