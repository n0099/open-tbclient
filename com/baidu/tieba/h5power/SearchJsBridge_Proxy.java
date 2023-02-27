package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.dj;
import com.baidu.tieba.l69;
import com.baidu.tieba.n69;
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
public class SearchJsBridge_Proxy extends l69 {
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

    @Override // com.baidu.tieba.l69
    public n69 dispatch(p69 p69Var, n69 n69Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                n69Var.r(true);
                n69 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    n69Var.x(deleteSearchHistory.f());
                    n69Var.t(deleteSearchHistory.b());
                    n69Var.o(deleteSearchHistory.a());
                    n69Var.w(deleteSearchHistory.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                n69Var.r(true);
                n69 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    n69Var.x(deleteAllSearchHistory.f());
                    n69Var.t(deleteAllSearchHistory.b());
                    n69Var.o(deleteAllSearchHistory.a());
                    n69Var.w(deleteAllSearchHistory.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                n69Var.r(true);
                n69 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    n69Var.x(openSearchPage.f());
                    n69Var.t(openSearchPage.b());
                    n69Var.o(openSearchPage.a());
                    n69Var.w(openSearchPage.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                n69Var.r(true);
                n69 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    n69Var.x(searchHistoryJson.f());
                    n69Var.t(searchHistoryJson.b());
                    n69Var.o(searchHistoryJson.a());
                    n69Var.w(searchHistoryJson.e());
                }
                n69Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                n69Var.r(true);
                n69 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    n69Var.x(searchAdCookie.f());
                    n69Var.t(searchAdCookie.b());
                    n69Var.o(searchAdCookie.a());
                    n69Var.w(searchAdCookie.e());
                }
                n69Var.y(0);
            }
            return n69Var;
        }
        return (n69) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
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
