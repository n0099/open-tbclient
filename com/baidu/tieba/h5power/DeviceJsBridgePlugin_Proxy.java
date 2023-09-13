package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.ox4;
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
public class DeviceJsBridgePlugin_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ox4 mJsBridge;

    public DeviceJsBridgePlugin_Proxy(ox4 ox4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ox4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ox4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
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
            if (b.equals("device/getZid")) {
                miaVar.s(true);
                mia k = this.mJsBridge.k(webView);
                if (k != null) {
                    miaVar.y(k.f());
                    miaVar.u(k.b());
                    miaVar.o(k.a());
                    miaVar.x(k.e());
                }
                miaVar.z(0);
            } else if (b.equals("device/getHdid")) {
                miaVar.s(true);
                mia i = this.mJsBridge.i(webView);
                if (i != null) {
                    miaVar.y(i.f());
                    miaVar.u(i.b());
                    miaVar.o(i.a());
                    miaVar.x(i.e());
                }
                miaVar.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                miaVar.s(true);
                mia j = this.mJsBridge.j(webView);
                if (j != null) {
                    miaVar.y(j.f());
                    miaVar.u(j.b());
                    miaVar.o(j.a());
                    miaVar.x(j.e());
                }
                miaVar.z(0);
            } else if (b.equals("device/getDeviceInfo")) {
                miaVar.s(true);
                mia h = this.mJsBridge.h(webView);
                if (h != null) {
                    miaVar.y(h.f());
                    miaVar.u(h.b());
                    miaVar.o(h.a());
                    miaVar.x(h.e());
                }
                miaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                miaVar.s(true);
                mia m = this.mJsBridge.m(webView, e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (m != null) {
                    miaVar.y(m.f());
                    miaVar.u(m.b());
                    miaVar.o(m.a());
                    miaVar.x(m.e());
                }
                miaVar.z(0);
            } else if (b.equals("device/deviceMotion")) {
                miaVar.s(true);
                mia d = this.mJsBridge.d(webView, e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (d != null) {
                    miaVar.y(d.f());
                    miaVar.u(d.b());
                    miaVar.o(d.a());
                    miaVar.x(d.e());
                    if (!miaVar.h()) {
                        miaVar.n(false);
                        addObserver(webView, "deviceMotion", miaVar, true);
                    }
                }
                miaVar.z(0);
            } else if (b.equals("device/deviceRefreshRate")) {
                miaVar.s(true);
                mia g = this.mJsBridge.g(webView, e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (g != null) {
                    miaVar.y(g.f());
                    miaVar.u(g.b());
                    miaVar.o(g.a());
                    miaVar.x(g.e());
                    if (!miaVar.h()) {
                        miaVar.n(false);
                        addObserver(webView, "deviceRefreshRate", miaVar, true);
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
            if (str.equals("deviceMotion")) {
                miaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                miaVar = this.mJsBridge.f(webView, hashMap);
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
