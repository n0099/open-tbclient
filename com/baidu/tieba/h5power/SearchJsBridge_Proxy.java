package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.is9;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
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
public class SearchJsBridge_Proxy extends is9 {
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

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                ks9Var.s(true);
                ks9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    ks9Var.y(deleteSearchHistory.f());
                    ks9Var.u(deleteSearchHistory.b());
                    ks9Var.o(deleteSearchHistory.a());
                    ks9Var.x(deleteSearchHistory.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                ks9Var.s(true);
                ks9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    ks9Var.y(deleteAllSearchHistory.f());
                    ks9Var.u(deleteAllSearchHistory.b());
                    ks9Var.o(deleteAllSearchHistory.a());
                    ks9Var.x(deleteAllSearchHistory.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                ks9Var.s(true);
                ks9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    ks9Var.y(openSearchPage.f());
                    ks9Var.u(openSearchPage.b());
                    ks9Var.o(openSearchPage.a());
                    ks9Var.x(openSearchPage.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                ks9Var.s(true);
                ks9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    ks9Var.y(searchHistoryJson.f());
                    ks9Var.u(searchHistoryJson.b());
                    ks9Var.o(searchHistoryJson.a());
                    ks9Var.x(searchHistoryJson.e());
                }
                ks9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                ks9Var.s(true);
                ks9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    ks9Var.y(searchAdCookie.f());
                    ks9Var.u(searchAdCookie.b());
                    ks9Var.o(searchAdCookie.a());
                    ks9Var.x(searchAdCookie.e());
                }
                ks9Var.z(0);
            }
            return ks9Var;
        }
        return (ks9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
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
