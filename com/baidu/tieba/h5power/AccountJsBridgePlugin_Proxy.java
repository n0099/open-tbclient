package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.hx4;
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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AccountJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hx4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(hx4 hx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = hx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
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
            if (b.equals("account/startLoginModule")) {
                sgaVar.s(true);
                sga r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    sgaVar.y(r.f());
                    sgaVar.u(r.b());
                    sgaVar.o(r.a());
                    sgaVar.x(r.e());
                }
                sgaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                sgaVar.s(true);
                sga g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    sgaVar.y(g.f());
                    sgaVar.u(g.b());
                    sgaVar.o(g.a());
                    sgaVar.x(g.e());
                }
                sgaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                sgaVar.s(true);
                sga q = this.mJsBridge.q(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (q != null) {
                    sgaVar.y(q.f());
                    sgaVar.u(q.b());
                    sgaVar.o(q.a());
                    sgaVar.x(q.e());
                }
                sgaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                sgaVar.s(true);
                sga c = this.mJsBridge.c(webView);
                if (c != null) {
                    sgaVar.y(c.f());
                    sgaVar.u(c.b());
                    sgaVar.o(c.a());
                    sgaVar.x(c.e());
                }
                sgaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                sgaVar.s(true);
                sga p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    sgaVar.y(p.f());
                    sgaVar.u(p.b());
                    sgaVar.o(p.a());
                    sgaVar.x(p.e());
                    if (!sgaVar.h()) {
                        sgaVar.n(false);
                        addObserver(webView, "commonLogin", sgaVar, false);
                    }
                }
                sgaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                sgaVar.s(true);
                sga f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    sgaVar.y(f.f());
                    sgaVar.u(f.b());
                    sgaVar.o(f.a());
                    sgaVar.x(f.e());
                    if (!sgaVar.h()) {
                        sgaVar.n(false);
                        addObserver(webView, "aliAuthResult", sgaVar, false);
                    }
                }
                sgaVar.z(0);
            } else if (b.equals("account/authState")) {
                sgaVar.s(true);
                sga d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    sgaVar.y(d.f());
                    sgaVar.u(d.b());
                    sgaVar.o(d.a());
                    sgaVar.x(d.e());
                    if (!sgaVar.h()) {
                        sgaVar.n(false);
                        addObserver(webView, "authStateResult", sgaVar, false);
                    }
                }
                sgaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                sgaVar.s(true);
                sga n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    sgaVar.y(n.f());
                    sgaVar.u(n.b());
                    sgaVar.o(n.a());
                    sgaVar.x(n.e());
                    if (!sgaVar.h()) {
                        sgaVar.n(false);
                        addObserver(webView, "realNameAuthResult", sgaVar, false);
                    }
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
            if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                sgaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                sgaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                sgaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                sgaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                sgaVar = this.mJsBridge.o(webView, hashMap);
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
