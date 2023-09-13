package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.kia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.qx4;
import com.baidu.tieba.tm6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class HybridDebugJsBridgePlugin_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qx4 mJsBridge;

    public HybridDebugJsBridgePlugin_Proxy(qx4 qx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
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
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                miaVar.s(true);
                mia d = this.mJsBridge.d(webView);
                if (d != null) {
                    miaVar.y(d.f());
                    miaVar.u(d.b());
                    miaVar.o(d.a());
                    miaVar.x(d.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                miaVar.s(true);
                mia c = this.mJsBridge.c(webView);
                if (c != null) {
                    miaVar.y(c.f());
                    miaVar.u(c.b());
                    miaVar.o(c.a());
                    miaVar.x(c.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                miaVar.s(true);
                mia i = this.mJsBridge.i(webView);
                if (i != null) {
                    miaVar.y(i.f());
                    miaVar.u(i.b());
                    miaVar.o(i.a());
                    miaVar.x(i.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                miaVar.s(true);
                mia g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    miaVar.y(g.f());
                    miaVar.u(g.b());
                    miaVar.o(g.a());
                    miaVar.x(g.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                miaVar.s(true);
                mia f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    miaVar.y(f.f());
                    miaVar.u(f.b());
                    miaVar.o(f.a());
                    miaVar.x(f.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                miaVar.s(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                mia h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    miaVar.y(h.f());
                    miaVar.u(h.b());
                    miaVar.o(h.a());
                    miaVar.x(h.e());
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
            if (!TextUtils.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
