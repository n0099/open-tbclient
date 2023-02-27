package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.l69;
import com.baidu.tieba.n69;
import com.baidu.tieba.ov4;
import com.baidu.tieba.p69;
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
public class HostJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ov4 mJsBridge;

    public HostJsBridgePlugin_Proxy(ov4 ov4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ov4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ov4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("host/callNativeSMS")) {
                n69Var.r(true);
                n69 c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    n69Var.x(c.f());
                    n69Var.t(c.b());
                    n69Var.o(c.a());
                    n69Var.w(c.e());
                }
                n69Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                n69Var.r(true);
                n69 g = this.mJsBridge.g(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (g != null) {
                    n69Var.x(g.f());
                    n69Var.t(g.b());
                    n69Var.o(g.a());
                    n69Var.w(g.e());
                }
                n69Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                n69Var.r(true);
                n69 e2 = this.mJsBridge.e(webView, e.optBoolean("isPaySuccess"));
                if (e2 != null) {
                    n69Var.x(e2.f());
                    n69Var.t(e2.b());
                    n69Var.o(e2.a());
                    n69Var.w(e2.e());
                }
                n69Var.y(0);
            } else if (b.equals("host/preheatWeb")) {
                n69Var.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                n69 f = this.mJsBridge.f(webView, arrayList);
                if (f != null) {
                    n69Var.x(f.f());
                    n69Var.t(f.b());
                    n69Var.o(f.a());
                    n69Var.w(f.e());
                }
                n69Var.y(0);
            }
            return n69Var;
        }
        return (n69) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
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
