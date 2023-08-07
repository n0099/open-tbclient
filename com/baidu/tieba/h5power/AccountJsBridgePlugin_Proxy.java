package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.fx4;
import com.baidu.tieba.hca;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
import com.baidu.tieba.pk6;
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
public class AccountJsBridgePlugin_Proxy extends hca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fx4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(fx4 fx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = fx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("commonLogin");
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.hca
    public jca dispatch(WebView webView, lca lcaVar, jca jcaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar = new jca();
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("account/startLoginModule")) {
                jcaVar.s(true);
                jca r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    jcaVar.y(r.f());
                    jcaVar.u(r.b());
                    jcaVar.o(r.a());
                    jcaVar.x(r.e());
                }
                jcaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                jcaVar.s(true);
                jca g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    jcaVar.y(g.f());
                    jcaVar.u(g.b());
                    jcaVar.o(g.a());
                    jcaVar.x(g.e());
                }
                jcaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                jcaVar.s(true);
                jca q = this.mJsBridge.q(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (q != null) {
                    jcaVar.y(q.f());
                    jcaVar.u(q.b());
                    jcaVar.o(q.a());
                    jcaVar.x(q.e());
                }
                jcaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                jcaVar.s(true);
                jca c = this.mJsBridge.c(webView);
                if (c != null) {
                    jcaVar.y(c.f());
                    jcaVar.u(c.b());
                    jcaVar.o(c.a());
                    jcaVar.x(c.e());
                }
                jcaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                jcaVar.s(true);
                jca p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    jcaVar.y(p.f());
                    jcaVar.u(p.b());
                    jcaVar.o(p.a());
                    jcaVar.x(p.e());
                    if (!jcaVar.h()) {
                        jcaVar.n(false);
                        addObserver(webView, "commonLogin", jcaVar, false);
                    }
                }
                jcaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                jcaVar.s(true);
                jca f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    jcaVar.y(f.f());
                    jcaVar.u(f.b());
                    jcaVar.o(f.a());
                    jcaVar.x(f.e());
                    if (!jcaVar.h()) {
                        jcaVar.n(false);
                        addObserver(webView, "aliAuthResult", jcaVar, false);
                    }
                }
                jcaVar.z(0);
            } else if (b.equals("account/authState")) {
                jcaVar.s(true);
                jca d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    jcaVar.y(d.f());
                    jcaVar.u(d.b());
                    jcaVar.o(d.a());
                    jcaVar.x(d.e());
                    if (!jcaVar.h()) {
                        jcaVar.n(false);
                        addObserver(webView, "authStateResult", jcaVar, false);
                    }
                }
                jcaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                jcaVar.s(true);
                jca n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    jcaVar.y(n.f());
                    jcaVar.u(n.b());
                    jcaVar.o(n.a());
                    jcaVar.x(n.e());
                    if (!jcaVar.h()) {
                        jcaVar.n(false);
                        addObserver(webView, "realNameAuthResult", jcaVar, false);
                    }
                }
                jcaVar.z(0);
            }
            return jcaVar;
        }
        return (jca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public pk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (pk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            jca jcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                jcaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                jcaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                jcaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                jcaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                jcaVar = this.mJsBridge.o(webView, hashMap);
            }
            if (jcaVar != null) {
                jcaVar.z(0);
            }
            List<ica> list = this.mAsyncCallBackMethodList.get(str);
            if (jcaVar != null && list != null) {
                Iterator<ica> it = list.iterator();
                if (!TextUtils.isEmpty(jcaVar.e())) {
                    while (it.hasNext()) {
                        ica next = it.next();
                        if (next.b().equals(jcaVar.e())) {
                            jca jcaVar2 = new jca();
                            jcaVar2.w(next.a());
                            jcaVar2.y(jcaVar.f());
                            jcaVar2.u(jcaVar.b());
                            jcaVar2.o(jcaVar.a());
                            jcaVar2.A(jcaVar.l());
                            arrayList.add(jcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ica next2 = it.next();
                        jca jcaVar3 = new jca();
                        jcaVar3.w(next2.a());
                        jcaVar3.y(jcaVar.f());
                        jcaVar3.u(jcaVar.b());
                        jcaVar3.o(jcaVar.a());
                        jcaVar3.A(jcaVar.l());
                        arrayList.add(jcaVar3);
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
