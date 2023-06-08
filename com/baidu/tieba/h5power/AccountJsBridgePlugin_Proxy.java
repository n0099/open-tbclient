package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.hy4;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zy9;
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
public class AccountJsBridgePlugin_Proxy extends zy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hy4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(hy4 hy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = hy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("commonLogin");
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("account/startLoginModule")) {
                bz9Var.s(true);
                bz9 q = this.mJsBridge.q(webView, e.optString("cssUrl"));
                if (q != null) {
                    bz9Var.y(q.f());
                    bz9Var.u(q.b());
                    bz9Var.o(q.a());
                    bz9Var.x(q.e());
                }
                bz9Var.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                bz9Var.s(true);
                bz9 g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    bz9Var.y(g.f());
                    bz9Var.u(g.b());
                    bz9Var.o(g.a());
                    bz9Var.x(g.e());
                }
                bz9Var.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                bz9Var.s(true);
                bz9 p = this.mJsBridge.p(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (p != null) {
                    bz9Var.y(p.f());
                    bz9Var.u(p.b());
                    bz9Var.o(p.a());
                    bz9Var.x(p.e());
                }
                bz9Var.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                bz9Var.s(true);
                bz9 c = this.mJsBridge.c(webView);
                if (c != null) {
                    bz9Var.y(c.f());
                    bz9Var.u(c.b());
                    bz9Var.o(c.a());
                    bz9Var.x(c.e());
                }
                bz9Var.z(0);
            } else if (b.equals("account/commonLogin")) {
                bz9Var.s(true);
                bz9 o = this.mJsBridge.o(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (o != null) {
                    bz9Var.y(o.f());
                    bz9Var.u(o.b());
                    bz9Var.o(o.a());
                    bz9Var.x(o.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "commonLogin", bz9Var, false);
                    }
                }
                bz9Var.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                bz9Var.s(true);
                bz9 f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    bz9Var.y(f.f());
                    bz9Var.u(f.b());
                    bz9Var.o(f.a());
                    bz9Var.x(f.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "aliAuthResult", bz9Var, false);
                    }
                }
                bz9Var.z(0);
            } else if (b.equals("account/authState")) {
                bz9Var.s(true);
                bz9 d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    bz9Var.y(d.f());
                    bz9Var.u(d.b());
                    bz9Var.o(d.a());
                    bz9Var.x(d.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "authStateResult", bz9Var, false);
                    }
                }
                bz9Var.z(0);
            } else if (b.equals("account/realNameAuth")) {
                bz9Var.s(true);
                bz9 m = this.mJsBridge.m(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (m != null) {
                    bz9Var.y(m.f());
                    bz9Var.u(m.b());
                    bz9Var.o(m.a());
                    bz9Var.x(m.e());
                    if (!bz9Var.h()) {
                        bz9Var.n(false);
                        addObserver(webView, "realNameAuthResult", bz9Var, false);
                    }
                }
                bz9Var.z(0);
            }
            return bz9Var;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            bz9 bz9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                bz9Var = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                bz9Var = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                bz9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                bz9Var = this.mJsBridge.n(webView, hashMap);
            }
            if (bz9Var != null) {
                bz9Var.z(0);
            }
            List<az9> list = this.mAsyncCallBackMethodList.get(str);
            if (bz9Var != null && list != null) {
                Iterator<az9> it = list.iterator();
                if (!TextUtils.isEmpty(bz9Var.e())) {
                    while (it.hasNext()) {
                        az9 next = it.next();
                        if (next.b().equals(bz9Var.e())) {
                            bz9 bz9Var2 = new bz9();
                            bz9Var2.w(next.a());
                            bz9Var2.y(bz9Var.f());
                            bz9Var2.u(bz9Var.b());
                            bz9Var2.o(bz9Var.a());
                            bz9Var2.A(bz9Var.l());
                            arrayList.add(bz9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        az9 next2 = it.next();
                        bz9 bz9Var3 = new bz9();
                        bz9Var3.w(next2.a());
                        bz9Var3.y(bz9Var.f());
                        bz9Var3.u(bz9Var.b());
                        bz9Var3.o(bz9Var.a());
                        bz9Var3.A(bz9Var.l());
                        arrayList.add(bz9Var3);
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
