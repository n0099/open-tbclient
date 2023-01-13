package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.by8;
import com.baidu.tieba.iq4;
import com.baidu.tieba.xx8;
import com.baidu.tieba.zx8;
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
/* loaded from: classes4.dex */
public class OfflineDebugJsBridge_Proxy extends xx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iq4 mJsBridge;

    public OfflineDebugJsBridge_Proxy(iq4 iq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iq4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = iq4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.xx8
    public zx8 dispatch(WebView webView, by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, by8Var, zx8Var)) == null) {
            if (zx8Var == null) {
                zx8Var = new zx8();
            }
            String b = by8Var.b();
            JSONObject e = by8Var.e();
            if (b.equals("hybridDebug/getOfflineUserInfo")) {
                zx8Var.r(true);
                zx8 d = this.mJsBridge.d(webView);
                if (d != null) {
                    zx8Var.x(d.f());
                    zx8Var.t(d.b());
                    zx8Var.o(d.a());
                    zx8Var.w(d.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                zx8Var.r(true);
                zx8 c = this.mJsBridge.c(webView);
                if (c != null) {
                    zx8Var.x(c.f());
                    zx8Var.t(c.b());
                    zx8Var.o(c.a());
                    zx8Var.w(c.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                zx8Var.r(true);
                zx8 i = this.mJsBridge.i(webView);
                if (i != null) {
                    zx8Var.x(i.f());
                    zx8Var.t(i.b());
                    zx8Var.o(i.a());
                    zx8Var.w(i.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                zx8Var.r(true);
                zx8 g = this.mJsBridge.g(webView, e.optString("host"));
                if (g != null) {
                    zx8Var.x(g.f());
                    zx8Var.t(g.b());
                    zx8Var.o(g.a());
                    zx8Var.w(g.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                zx8Var.r(true);
                zx8 f = this.mJsBridge.f(webView, e.optInt("isOn"));
                if (f != null) {
                    zx8Var.x(f.f());
                    zx8Var.t(f.b());
                    zx8Var.o(f.a());
                    zx8Var.w(f.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                zx8Var.r(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("hostArr"));
                zx8 h = this.mJsBridge.h(webView, arrayList);
                if (h != null) {
                    zx8Var.x(h.f());
                    zx8Var.t(h.b());
                    zx8Var.o(h.a());
                    zx8Var.w(h.e());
                }
                zx8Var.y(0);
            }
            return zx8Var;
        }
        return (zx8) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.xx8
    public List<zx8> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
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
