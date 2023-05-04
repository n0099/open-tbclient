package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.fq9;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
import com.baidu.tieba.ku4;
import com.baidu.tieba.xf6;
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
public class HostJsBridgePlugin_Proxy extends fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ku4 mJsBridge;

    public HostJsBridgePlugin_Proxy(ku4 ku4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ku4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ku4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var = new hq9();
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("host/callNativeSMS")) {
                hq9Var.s(true);
                hq9 c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    hq9Var.y(c.f());
                    hq9Var.u(c.b());
                    hq9Var.o(c.a());
                    hq9Var.x(c.e());
                }
                hq9Var.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                hq9Var.s(true);
                hq9 g = this.mJsBridge.g(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (g != null) {
                    hq9Var.y(g.f());
                    hq9Var.u(g.b());
                    hq9Var.o(g.a());
                    hq9Var.x(g.e());
                }
                hq9Var.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                hq9Var.s(true);
                hq9 e2 = this.mJsBridge.e(webView, e.optBoolean("isPaySuccess"));
                if (e2 != null) {
                    hq9Var.y(e2.f());
                    hq9Var.u(e2.b());
                    hq9Var.o(e2.a());
                    hq9Var.x(e2.e());
                }
                hq9Var.z(0);
            } else if (b.equals("host/preheatWeb")) {
                hq9Var.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                hq9 f = this.mJsBridge.f(webView, arrayList);
                if (f != null) {
                    hq9Var.y(f.f());
                    hq9Var.u(f.b());
                    hq9Var.o(f.a());
                    hq9Var.x(f.e());
                }
                hq9Var.z(0);
            }
            return hq9Var;
        }
        return (hq9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public xf6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xf6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
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
