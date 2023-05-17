package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.hs9;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
import com.baidu.tieba.qi;
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
/* loaded from: classes5.dex */
public class SearchJsBridge_Proxy extends hs9 {
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

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var = new js9();
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                js9Var.s(true);
                js9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    js9Var.y(deleteSearchHistory.f());
                    js9Var.u(deleteSearchHistory.b());
                    js9Var.o(deleteSearchHistory.a());
                    js9Var.x(deleteSearchHistory.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                js9Var.s(true);
                js9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    js9Var.y(deleteAllSearchHistory.f());
                    js9Var.u(deleteAllSearchHistory.b());
                    js9Var.o(deleteAllSearchHistory.a());
                    js9Var.x(deleteAllSearchHistory.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                js9Var.s(true);
                js9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    js9Var.y(openSearchPage.f());
                    js9Var.u(openSearchPage.b());
                    js9Var.o(openSearchPage.a());
                    js9Var.x(openSearchPage.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                js9Var.s(true);
                js9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    js9Var.y(searchHistoryJson.f());
                    js9Var.u(searchHistoryJson.b());
                    js9Var.o(searchHistoryJson.a());
                    js9Var.x(searchHistoryJson.e());
                }
                js9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                js9Var.s(true);
                js9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    js9Var.y(searchAdCookie.f());
                    js9Var.u(searchAdCookie.b());
                    js9Var.o(searchAdCookie.a());
                    js9Var.x(searchAdCookie.e());
                }
                js9Var.z(0);
            }
            return js9Var;
        }
        return (js9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!qi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
