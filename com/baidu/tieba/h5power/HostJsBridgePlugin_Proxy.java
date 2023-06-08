package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ly4;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zy9;
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
public class HostJsBridgePlugin_Proxy extends zy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly4 mJsBridge;

    public HostJsBridgePlugin_Proxy(ly4 ly4Var) {
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
        this.mNotificationNameList = new HashSet<>();
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
            if (b.equals("host/callNativeSMS")) {
                bz9Var.s(true);
                bz9 c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    bz9Var.y(c.f());
                    bz9Var.u(c.b());
                    bz9Var.o(c.a());
                    bz9Var.x(c.e());
                }
                bz9Var.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                bz9Var.s(true);
                bz9 g = this.mJsBridge.g(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (g != null) {
                    bz9Var.y(g.f());
                    bz9Var.u(g.b());
                    bz9Var.o(g.a());
                    bz9Var.x(g.e());
                }
                bz9Var.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                bz9Var.s(true);
                bz9 e2 = this.mJsBridge.e(webView, e.optBoolean("isPaySuccess"));
                if (e2 != null) {
                    bz9Var.y(e2.f());
                    bz9Var.u(e2.b());
                    bz9Var.o(e2.a());
                    bz9Var.x(e2.e());
                }
                bz9Var.z(0);
            } else if (b.equals("host/preheatWeb")) {
                bz9Var.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                bz9 f = this.mJsBridge.f(webView, arrayList);
                if (f != null) {
                    bz9Var.y(f.f());
                    bz9Var.u(f.b());
                    bz9Var.o(f.a());
                    bz9Var.x(f.e());
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
