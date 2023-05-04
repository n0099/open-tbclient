package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.fq9;
import com.baidu.tieba.hi;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
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
public class SearchJsBridge_Proxy extends fq9 {
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

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var = new hq9();
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                hq9Var.s(true);
                hq9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    hq9Var.y(deleteSearchHistory.f());
                    hq9Var.u(deleteSearchHistory.b());
                    hq9Var.o(deleteSearchHistory.a());
                    hq9Var.x(deleteSearchHistory.e());
                }
                hq9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                hq9Var.s(true);
                hq9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    hq9Var.y(deleteAllSearchHistory.f());
                    hq9Var.u(deleteAllSearchHistory.b());
                    hq9Var.o(deleteAllSearchHistory.a());
                    hq9Var.x(deleteAllSearchHistory.e());
                }
                hq9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                hq9Var.s(true);
                hq9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    hq9Var.y(openSearchPage.f());
                    hq9Var.u(openSearchPage.b());
                    hq9Var.o(openSearchPage.a());
                    hq9Var.x(openSearchPage.e());
                }
                hq9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                hq9Var.s(true);
                hq9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    hq9Var.y(searchHistoryJson.f());
                    hq9Var.u(searchHistoryJson.b());
                    hq9Var.o(searchHistoryJson.a());
                    hq9Var.x(searchHistoryJson.e());
                }
                hq9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                hq9Var.s(true);
                hq9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    hq9Var.y(searchAdCookie.f());
                    hq9Var.u(searchAdCookie.b());
                    hq9Var.o(searchAdCookie.a());
                    hq9Var.x(searchAdCookie.e());
                }
                hq9Var.z(0);
            }
            return hq9Var;
        }
        return (hq9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!hi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
