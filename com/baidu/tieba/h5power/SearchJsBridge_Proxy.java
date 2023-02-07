package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.dj;
import com.baidu.tieba.v19;
import com.baidu.tieba.x19;
import com.baidu.tieba.z19;
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
public class SearchJsBridge_Proxy extends v19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchJsBridge mJsBridge;

    public SearchJsBridge_Proxy(SearchJsBridge searchJsBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {searchJsBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = searchJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.v19
    public x19 dispatch(z19 z19Var, x19 x19Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z19Var, x19Var)) == null) {
            if (x19Var == null) {
                x19Var = new x19();
            }
            String b = z19Var.b();
            JSONObject e = z19Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                x19Var.r(true);
                x19 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    x19Var.x(deleteSearchHistory.f());
                    x19Var.t(deleteSearchHistory.b());
                    x19Var.o(deleteSearchHistory.a());
                    x19Var.w(deleteSearchHistory.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                x19Var.r(true);
                x19 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    x19Var.x(deleteAllSearchHistory.f());
                    x19Var.t(deleteAllSearchHistory.b());
                    x19Var.o(deleteAllSearchHistory.a());
                    x19Var.w(deleteAllSearchHistory.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                x19Var.r(true);
                x19 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    x19Var.x(openSearchPage.f());
                    x19Var.t(openSearchPage.b());
                    x19Var.o(openSearchPage.a());
                    x19Var.w(openSearchPage.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                x19Var.r(true);
                x19 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    x19Var.x(searchHistoryJson.f());
                    x19Var.t(searchHistoryJson.b());
                    x19Var.o(searchHistoryJson.a());
                    x19Var.w(searchHistoryJson.e());
                }
                x19Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                x19Var.r(true);
                x19 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    x19Var.x(searchAdCookie.f());
                    x19Var.t(searchAdCookie.b());
                    x19Var.o(searchAdCookie.a());
                    x19Var.w(searchAdCookie.e());
                }
                x19Var.y(0);
            }
            return x19Var;
        }
        return (x19) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.v19
    public List<x19> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!dj.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
