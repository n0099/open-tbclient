package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.lx4;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.tm6;
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
public class AccountJsBridgePlugin_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lx4 mJsBridge;

    public AccountJsBridgePlugin_Proxy(lx4 lx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = lx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("authStateResult");
        this.mNotificationNameList.add("realNameAuthResult");
    }

    @Override // com.baidu.tieba.kia
    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar = new mia();
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("account/startLoginModule")) {
                miaVar.s(true);
                mia r = this.mJsBridge.r(webView, e.optString("cssUrl"));
                if (r != null) {
                    miaVar.y(r.f());
                    miaVar.u(r.b());
                    miaVar.o(r.a());
                    miaVar.x(r.e());
                }
                miaVar.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                miaVar.s(true);
                mia g = this.mJsBridge.g(webView, e.optInt("socialType"), e.optString("activityId"));
                if (g != null) {
                    miaVar.y(g.f());
                    miaVar.u(g.b());
                    miaVar.o(g.a());
                    miaVar.x(g.e());
                }
                miaVar.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                miaVar.s(true);
                mia q = this.mJsBridge.q(webView, e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (q != null) {
                    miaVar.y(q.f());
                    miaVar.u(q.b());
                    miaVar.o(q.a());
                    miaVar.x(q.e());
                }
                miaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                miaVar.s(true);
                mia c = this.mJsBridge.c(webView);
                if (c != null) {
                    miaVar.y(c.f());
                    miaVar.u(c.b());
                    miaVar.o(c.a());
                    miaVar.x(c.e());
                }
                miaVar.z(0);
            } else if (b.equals("account/commonLogin")) {
                miaVar.s(true);
                mia p = this.mJsBridge.p(webView, e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (p != null) {
                    miaVar.y(p.f());
                    miaVar.u(p.b());
                    miaVar.o(p.a());
                    miaVar.x(p.e());
                    if (!miaVar.h()) {
                        miaVar.n(false);
                        addObserver(webView, "commonLogin", miaVar, false);
                    }
                }
                miaVar.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                miaVar.s(true);
                mia f = this.mJsBridge.f(webView);
                this.mNotificationNameList.add("aliAuthResult");
                if (f != null) {
                    miaVar.y(f.f());
                    miaVar.u(f.b());
                    miaVar.o(f.a());
                    miaVar.x(f.e());
                    if (!miaVar.h()) {
                        miaVar.n(false);
                        addObserver(webView, "aliAuthResult", miaVar, false);
                    }
                }
                miaVar.z(0);
            } else if (b.equals("account/authState")) {
                miaVar.s(true);
                mia d = this.mJsBridge.d(webView, e.optString("scene"));
                this.mNotificationNameList.add("authStateResult");
                if (d != null) {
                    miaVar.y(d.f());
                    miaVar.u(d.b());
                    miaVar.o(d.a());
                    miaVar.x(d.e());
                    if (!miaVar.h()) {
                        miaVar.n(false);
                        addObserver(webView, "authStateResult", miaVar, false);
                    }
                }
                miaVar.z(0);
            } else if (b.equals("account/realNameAuth")) {
                miaVar.s(true);
                mia n = this.mJsBridge.n(webView, e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (n != null) {
                    miaVar.y(n.f());
                    miaVar.u(n.b());
                    miaVar.o(n.a());
                    miaVar.x(n.e());
                    if (!miaVar.h()) {
                        miaVar.n(false);
                        addObserver(webView, "realNameAuthResult", miaVar, false);
                    }
                }
                miaVar.z(0);
            }
            return miaVar;
        }
        return (mia) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.kia
    public tm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (tm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            mia miaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                miaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                miaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("aliAuthResult")) {
                miaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals("authStateResult")) {
                miaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("realNameAuthResult")) {
                miaVar = this.mJsBridge.o(webView, hashMap);
            }
            if (miaVar != null) {
                miaVar.z(0);
            }
            List<lia> list = this.mAsyncCallBackMethodList.get(str);
            if (miaVar != null && list != null) {
                Iterator<lia> it = list.iterator();
                if (!TextUtils.isEmpty(miaVar.e())) {
                    while (it.hasNext()) {
                        lia next = it.next();
                        if (next.b().equals(miaVar.e())) {
                            mia miaVar2 = new mia();
                            miaVar2.w(next.a());
                            miaVar2.y(miaVar.f());
                            miaVar2.u(miaVar.b());
                            miaVar2.o(miaVar.a());
                            miaVar2.j = miaVar.j;
                            miaVar2.A(miaVar.l());
                            arrayList.add(miaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        lia next2 = it.next();
                        mia miaVar3 = new mia();
                        miaVar3.w(next2.a());
                        miaVar3.y(miaVar.f());
                        miaVar3.u(miaVar.b());
                        miaVar3.o(miaVar.a());
                        miaVar3.j = miaVar.j;
                        miaVar3.A(miaVar.l());
                        arrayList.add(miaVar3);
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
