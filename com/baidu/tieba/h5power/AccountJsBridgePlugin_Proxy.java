package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tieba.iy4;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.zl6;
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
public class AccountJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iy4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = iy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("commonLogin");
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("account/startLoginModule")) {
                t0aVar.s(true);
                t0a q = this.mJsBridge.q(webView, e.optString("cssUrl"));
                if (q != null) {
                    t0aVar.y(q.f());
                    t0aVar.u(q.b());
                    t0aVar.o(q.a());
                    t0aVar.x(q.e());
                }
                t0aVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                t0aVar.s(true);
                t0a g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    t0aVar.y(g.f());
                    t0aVar.u(g.b());
                    t0aVar.o(g.a());
                    t0aVar.x(g.e());
                }
                t0aVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                t0aVar.s(true);
                t0a p = this.mJsBridge.p(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (p != null) {
                    t0aVar.y(p.f());
                    t0aVar.u(p.b());
                    t0aVar.o(p.a());
                    t0aVar.x(p.e());
                }
                t0aVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                t0aVar.s(true);
                t0a c = this.mJsBridge.c(webView);
                if (c != null) {
                    t0aVar.y(c.f());
                    t0aVar.u(c.b());
                    t0aVar.o(c.a());
                    t0aVar.x(c.e());
                }
                t0aVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                t0aVar.s(true);
                t0a o = this.mJsBridge.o(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (o != null) {
                    t0aVar.y(o.f());
                    t0aVar.u(o.b());
                    t0aVar.o(o.a());
                    t0aVar.x(o.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "commonLogin", t0aVar, false);
                    }
                }
                t0aVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                t0aVar.s(true);
                t0a f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    t0aVar.y(f.f());
                    t0aVar.u(f.b());
                    t0aVar.o(f.a());
                    t0aVar.x(f.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "aliAuthResult", t0aVar, false);
                    }
                }
                t0aVar.z(0);
            } else if (b.equals("account/authState")) {
                t0aVar.s(true);
                t0a d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    t0aVar.y(d.f());
                    t0aVar.u(d.b());
                    t0aVar.o(d.a());
                    t0aVar.x(d.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "authStateResult", t0aVar, false);
                    }
                }
                t0aVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                t0aVar.s(true);
                t0a m = this.mJsBridge.m(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (m != null) {
                    t0aVar.y(m.f());
                    t0aVar.u(m.b());
                    t0aVar.o(m.a());
                    t0aVar.x(m.e());
                    if (!t0aVar.h()) {
                        t0aVar.n(false);
                        addObserver(webView, "realNameAuthResult", t0aVar, false);
                    }
                }
                t0aVar.z(0);
            }
            return t0aVar;
        }
        return (t0a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public zl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (zl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            t0a t0aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                t0aVar = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                t0aVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                t0aVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                t0aVar = this.mJsBridge.n(webView, hashMap);
            }
            if (t0aVar != null) {
                t0aVar.z(0);
            }
            List<s0a> list = this.mAsyncCallBackMethodList.get(str);
            if (t0aVar != null && list != null) {
                Iterator<s0a> it = list.iterator();
                if (!TextUtils.isEmpty(t0aVar.e())) {
                    while (it.hasNext()) {
                        s0a next = it.next();
                        if (next.b().equals(t0aVar.e())) {
                            t0a t0aVar2 = new t0a();
                            t0aVar2.w(next.a());
                            t0aVar2.y(t0aVar.f());
                            t0aVar2.u(t0aVar.b());
                            t0aVar2.o(t0aVar.a());
                            t0aVar2.A(t0aVar.l());
                            arrayList.add(t0aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        s0a next2 = it.next();
                        t0a t0aVar3 = new t0a();
                        t0aVar3.w(next2.a());
                        t0aVar3.y(t0aVar.f());
                        t0aVar3.u(t0aVar.b());
                        t0aVar3.o(t0aVar.a());
                        t0aVar3.A(t0aVar.l());
                        arrayList.add(t0aVar3);
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
