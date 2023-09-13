package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.rx4;
import com.baidu.tieba.tm6;
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
public class HybridJsBridgePlugin_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rx4 mJsBridge;

    public HybridJsBridgePlugin_Proxy(rx4 rx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = rx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add("RequestByNativeToH5");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
    }

    @Override // com.baidu.tieba.kia
    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        mia miaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar2 = new mia();
            } else {
                miaVar2 = miaVar;
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                miaVar2.s(true);
                mia e2 = this.mJsBridge.e(webView, e.optString("query"));
                if (e2 != null) {
                    miaVar2.y(e2.f());
                    miaVar2.u(e2.b());
                    miaVar2.o(e2.a());
                    miaVar2.x(e2.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                miaVar2.s(true);
                mia d = this.mJsBridge.d(webView);
                if (d != null) {
                    miaVar2.y(d.f());
                    miaVar2.u(d.b());
                    miaVar2.o(d.a());
                    miaVar2.x(d.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                miaVar2.s(true);
                mia n = this.mJsBridge.n(webView, e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (n != null) {
                    miaVar2.y(n.f());
                    miaVar2.u(n.b());
                    miaVar2.o(n.a());
                    miaVar2.x(n.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                miaVar2.s(true);
                mia i = this.mJsBridge.i(webView);
                this.mNotificationNameList.add(SearchJsBridge.METHOD_GET_SEARCH_HISTORY);
                if (i != null) {
                    miaVar2.y(i.f());
                    miaVar2.u(i.b());
                    miaVar2.o(i.a());
                    miaVar2.x(i.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                miaVar2.s(true);
                mia f = this.mJsBridge.f(webView);
                if (f != null) {
                    miaVar2.y(f.f());
                    miaVar2.u(f.b());
                    miaVar2.o(f.a());
                    miaVar2.x(f.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                miaVar2.s(true);
                mia o = this.mJsBridge.o(webView, e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (o != null) {
                    miaVar2.y(o.f());
                    miaVar2.u(o.b());
                    miaVar2.o(o.a());
                    miaVar2.x(o.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "RequestByNativeToH5", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                miaVar2.s(true);
                mia l = this.mJsBridge.l(webView, e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (l != null) {
                    miaVar2.y(l.f());
                    miaVar2.u(l.b());
                    miaVar2.o(l.a());
                    miaVar2.x(l.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "nativeNetworkProxyResult", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            }
            return miaVar2;
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
            if (str.equals(SearchJsBridge.METHOD_GET_SEARCH_HISTORY)) {
                miaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                miaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                miaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                miaVar = this.mJsBridge.m(webView, hashMap);
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
