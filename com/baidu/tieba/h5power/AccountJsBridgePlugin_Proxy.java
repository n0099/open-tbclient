package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.d5a;
import com.baidu.tieba.e5a;
import com.baidu.tieba.em6;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.ly4;
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
public class AccountJsBridgePlugin_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(ly4 ly4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ly4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ly4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("commonLogin");
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("account/startLoginModule")) {
                f5aVar.s(true);
                f5a r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    f5aVar.y(r.f());
                    f5aVar.u(r.b());
                    f5aVar.o(r.a());
                    f5aVar.x(r.e());
                }
                f5aVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                f5aVar.s(true);
                f5a g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    f5aVar.y(g.f());
                    f5aVar.u(g.b());
                    f5aVar.o(g.a());
                    f5aVar.x(g.e());
                }
                f5aVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                f5aVar.s(true);
                f5a q = this.mJsBridge.q(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (q != null) {
                    f5aVar.y(q.f());
                    f5aVar.u(q.b());
                    f5aVar.o(q.a());
                    f5aVar.x(q.e());
                }
                f5aVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                f5aVar.s(true);
                f5a c = this.mJsBridge.c(webView);
                if (c != null) {
                    f5aVar.y(c.f());
                    f5aVar.u(c.b());
                    f5aVar.o(c.a());
                    f5aVar.x(c.e());
                }
                f5aVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                f5aVar.s(true);
                f5a p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    f5aVar.y(p.f());
                    f5aVar.u(p.b());
                    f5aVar.o(p.a());
                    f5aVar.x(p.e());
                    if (!f5aVar.h()) {
                        f5aVar.n(false);
                        addObserver(webView, "commonLogin", f5aVar, false);
                    }
                }
                f5aVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                f5aVar.s(true);
                f5a f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    f5aVar.y(f.f());
                    f5aVar.u(f.b());
                    f5aVar.o(f.a());
                    f5aVar.x(f.e());
                    if (!f5aVar.h()) {
                        f5aVar.n(false);
                        addObserver(webView, "aliAuthResult", f5aVar, false);
                    }
                }
                f5aVar.z(0);
            } else if (b.equals("account/authState")) {
                f5aVar.s(true);
                f5a d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    f5aVar.y(d.f());
                    f5aVar.u(d.b());
                    f5aVar.o(d.a());
                    f5aVar.x(d.e());
                    if (!f5aVar.h()) {
                        f5aVar.n(false);
                        addObserver(webView, "authStateResult", f5aVar, false);
                    }
                }
                f5aVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                f5aVar.s(true);
                f5a n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    f5aVar.y(n.f());
                    f5aVar.u(n.b());
                    f5aVar.o(n.a());
                    f5aVar.x(n.e());
                    if (!f5aVar.h()) {
                        f5aVar.n(false);
                        addObserver(webView, "realNameAuthResult", f5aVar, false);
                    }
                }
                f5aVar.z(0);
            }
            return f5aVar;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (em6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            f5a f5aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                f5aVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                f5aVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                f5aVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                f5aVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                f5aVar = this.mJsBridge.o(webView, hashMap);
            }
            if (f5aVar != null) {
                f5aVar.z(0);
            }
            List<e5a> list = this.mAsyncCallBackMethodList.get(str);
            if (f5aVar != null && list != null) {
                Iterator<e5a> it = list.iterator();
                if (!TextUtils.isEmpty(f5aVar.e())) {
                    while (it.hasNext()) {
                        e5a next = it.next();
                        if (next.b().equals(f5aVar.e())) {
                            f5a f5aVar2 = new f5a();
                            f5aVar2.w(next.a());
                            f5aVar2.y(f5aVar.f());
                            f5aVar2.u(f5aVar.b());
                            f5aVar2.o(f5aVar.a());
                            f5aVar2.A(f5aVar.l());
                            arrayList.add(f5aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        e5a next2 = it.next();
                        f5a f5aVar3 = new f5a();
                        f5aVar3.w(next2.a());
                        f5aVar3.y(f5aVar.f());
                        f5aVar3.u(f5aVar.b());
                        f5aVar3.o(f5aVar.a());
                        f5aVar3.A(f5aVar.l());
                        arrayList.add(f5aVar3);
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
