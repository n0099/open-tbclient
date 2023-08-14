package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.fx4;
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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AccountJsBridgePlugin_Proxy extends ica {
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
            if (b.equals("account/startLoginModule")) {
                kcaVar.s(true);
                kca r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    kcaVar.y(r.f());
                    kcaVar.u(r.b());
                    kcaVar.o(r.a());
                    kcaVar.x(r.e());
                }
                kcaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                kcaVar.s(true);
                kca g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    kcaVar.y(g.f());
                    kcaVar.u(g.b());
                    kcaVar.o(g.a());
                    kcaVar.x(g.e());
                }
                kcaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                kcaVar.s(true);
                kca q = this.mJsBridge.q(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (q != null) {
                    kcaVar.y(q.f());
                    kcaVar.u(q.b());
                    kcaVar.o(q.a());
                    kcaVar.x(q.e());
                }
                kcaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                kcaVar.s(true);
                kca c = this.mJsBridge.c(webView);
                if (c != null) {
                    kcaVar.y(c.f());
                    kcaVar.u(c.b());
                    kcaVar.o(c.a());
                    kcaVar.x(c.e());
                }
                kcaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                kcaVar.s(true);
                kca p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    kcaVar.y(p.f());
                    kcaVar.u(p.b());
                    kcaVar.o(p.a());
                    kcaVar.x(p.e());
                    if (!kcaVar.h()) {
                        kcaVar.n(false);
                        addObserver(webView, "commonLogin", kcaVar, false);
                    }
                }
                kcaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                kcaVar.s(true);
                kca f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    kcaVar.y(f.f());
                    kcaVar.u(f.b());
                    kcaVar.o(f.a());
                    kcaVar.x(f.e());
                    if (!kcaVar.h()) {
                        kcaVar.n(false);
                        addObserver(webView, "aliAuthResult", kcaVar, false);
                    }
                }
                kcaVar.z(0);
            } else if (b.equals("account/authState")) {
                kcaVar.s(true);
                kca d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    kcaVar.y(d.f());
                    kcaVar.u(d.b());
                    kcaVar.o(d.a());
                    kcaVar.x(d.e());
                    if (!kcaVar.h()) {
                        kcaVar.n(false);
                        addObserver(webView, "authStateResult", kcaVar, false);
                    }
                }
                kcaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                kcaVar.s(true);
                kca n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    kcaVar.y(n.f());
                    kcaVar.u(n.b());
                    kcaVar.o(n.a());
                    kcaVar.x(n.e());
                    if (!kcaVar.h()) {
                        kcaVar.n(false);
                        addObserver(webView, "realNameAuthResult", kcaVar, false);
                    }
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
            if (str.equals("commonLogin")) {
                kcaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                kcaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                kcaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                kcaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                kcaVar = this.mJsBridge.o(webView, hashMap);
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
