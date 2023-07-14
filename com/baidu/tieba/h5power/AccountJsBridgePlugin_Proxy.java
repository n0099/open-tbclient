package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.ey4;
import com.baidu.tieba.in6;
import com.baidu.tieba.oda;
import com.baidu.tieba.pda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
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
public class AccountJsBridgePlugin_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ey4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(ey4 ey4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ey4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ey4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("commonLogin");
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.oda
    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("account/startLoginModule")) {
                qdaVar.s(true);
                qda r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    qdaVar.y(r.f());
                    qdaVar.u(r.b());
                    qdaVar.o(r.a());
                    qdaVar.x(r.e());
                }
                qdaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                qdaVar.s(true);
                qda g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    qdaVar.y(g.f());
                    qdaVar.u(g.b());
                    qdaVar.o(g.a());
                    qdaVar.x(g.e());
                }
                qdaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                qdaVar.s(true);
                qda q = this.mJsBridge.q(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (q != null) {
                    qdaVar.y(q.f());
                    qdaVar.u(q.b());
                    qdaVar.o(q.a());
                    qdaVar.x(q.e());
                }
                qdaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                qdaVar.s(true);
                qda c = this.mJsBridge.c(webView);
                if (c != null) {
                    qdaVar.y(c.f());
                    qdaVar.u(c.b());
                    qdaVar.o(c.a());
                    qdaVar.x(c.e());
                }
                qdaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                qdaVar.s(true);
                qda p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    qdaVar.y(p.f());
                    qdaVar.u(p.b());
                    qdaVar.o(p.a());
                    qdaVar.x(p.e());
                    if (!qdaVar.h()) {
                        qdaVar.n(false);
                        addObserver(webView, "commonLogin", qdaVar, false);
                    }
                }
                qdaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                qdaVar.s(true);
                qda f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    qdaVar.y(f.f());
                    qdaVar.u(f.b());
                    qdaVar.o(f.a());
                    qdaVar.x(f.e());
                    if (!qdaVar.h()) {
                        qdaVar.n(false);
                        addObserver(webView, "aliAuthResult", qdaVar, false);
                    }
                }
                qdaVar.z(0);
            } else if (b.equals("account/authState")) {
                qdaVar.s(true);
                qda d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    qdaVar.y(d.f());
                    qdaVar.u(d.b());
                    qdaVar.o(d.a());
                    qdaVar.x(d.e());
                    if (!qdaVar.h()) {
                        qdaVar.n(false);
                        addObserver(webView, "authStateResult", qdaVar, false);
                    }
                }
                qdaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                qdaVar.s(true);
                qda n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    qdaVar.y(n.f());
                    qdaVar.u(n.b());
                    qdaVar.o(n.a());
                    qdaVar.x(n.e());
                    if (!qdaVar.h()) {
                        qdaVar.n(false);
                        addObserver(webView, "realNameAuthResult", qdaVar, false);
                    }
                }
                qdaVar.z(0);
            }
            return qdaVar;
        }
        return (qda) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (in6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            qda qdaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                qdaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                qdaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                qdaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                qdaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                qdaVar = this.mJsBridge.o(webView, hashMap);
            }
            if (qdaVar != null) {
                qdaVar.z(0);
            }
            List<pda> list = this.mAsyncCallBackMethodList.get(str);
            if (qdaVar != null && list != null) {
                Iterator<pda> it = list.iterator();
                if (!TextUtils.isEmpty(qdaVar.e())) {
                    while (it.hasNext()) {
                        pda next = it.next();
                        if (next.b().equals(qdaVar.e())) {
                            qda qdaVar2 = new qda();
                            qdaVar2.w(next.a());
                            qdaVar2.y(qdaVar.f());
                            qdaVar2.u(qdaVar.b());
                            qdaVar2.o(qdaVar.a());
                            qdaVar2.A(qdaVar.l());
                            arrayList.add(qdaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        pda next2 = it.next();
                        qda qdaVar3 = new qda();
                        qdaVar3.w(next2.a());
                        qdaVar3.y(qdaVar.f());
                        qdaVar3.u(qdaVar.b());
                        qdaVar3.o(qdaVar.a());
                        qdaVar3.A(qdaVar.l());
                        arrayList.add(qdaVar3);
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
