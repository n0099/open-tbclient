package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.hi;
import com.baidu.tieba.im9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
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
public class SearchJsBridge_Proxy extends im9 {
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

    @Override // com.baidu.tieba.im9
    public km9 dispatch(mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mm9Var, km9Var)) == null) {
            if (km9Var == null) {
                km9Var = new km9();
            }
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                km9Var.r(true);
                km9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    km9Var.x(deleteSearchHistory.f());
                    km9Var.t(deleteSearchHistory.b());
                    km9Var.o(deleteSearchHistory.a());
                    km9Var.w(deleteSearchHistory.e());
                }
                km9Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                km9Var.r(true);
                km9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    km9Var.x(deleteAllSearchHistory.f());
                    km9Var.t(deleteAllSearchHistory.b());
                    km9Var.o(deleteAllSearchHistory.a());
                    km9Var.w(deleteAllSearchHistory.e());
                }
                km9Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                km9Var.r(true);
                km9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    km9Var.x(openSearchPage.f());
                    km9Var.t(openSearchPage.b());
                    km9Var.o(openSearchPage.a());
                    km9Var.w(openSearchPage.e());
                }
                km9Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                km9Var.r(true);
                km9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    km9Var.x(searchHistoryJson.f());
                    km9Var.t(searchHistoryJson.b());
                    km9Var.o(searchHistoryJson.a());
                    km9Var.w(searchHistoryJson.e());
                }
                km9Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                km9Var.r(true);
                km9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    km9Var.x(searchAdCookie.f());
                    km9Var.t(searchAdCookie.b());
                    km9Var.o(searchAdCookie.a());
                    km9Var.w(searchAdCookie.e());
                }
                km9Var.y(0);
            }
            return km9Var;
        }
        return (km9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
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
