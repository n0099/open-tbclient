package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.hi;
import com.baidu.tieba.qm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
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
public class SearchJsBridge_Proxy extends qm9 {
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

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var = new sm9();
            }
            String b = um9Var.b();
            JSONObject e = um9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                sm9Var.r(true);
                sm9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    sm9Var.x(deleteSearchHistory.f());
                    sm9Var.t(deleteSearchHistory.b());
                    sm9Var.o(deleteSearchHistory.a());
                    sm9Var.w(deleteSearchHistory.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                sm9Var.r(true);
                sm9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    sm9Var.x(deleteAllSearchHistory.f());
                    sm9Var.t(deleteAllSearchHistory.b());
                    sm9Var.o(deleteAllSearchHistory.a());
                    sm9Var.w(deleteAllSearchHistory.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                sm9Var.r(true);
                sm9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    sm9Var.x(openSearchPage.f());
                    sm9Var.t(openSearchPage.b());
                    sm9Var.o(openSearchPage.a());
                    sm9Var.w(openSearchPage.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                sm9Var.r(true);
                sm9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    sm9Var.x(searchHistoryJson.f());
                    sm9Var.t(searchHistoryJson.b());
                    sm9Var.o(searchHistoryJson.a());
                    sm9Var.w(searchHistoryJson.e());
                }
                sm9Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                sm9Var.r(true);
                sm9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    sm9Var.x(searchAdCookie.f());
                    sm9Var.t(searchAdCookie.b());
                    sm9Var.o(searchAdCookie.a());
                    sm9Var.w(searchAdCookie.e());
                }
                sm9Var.y(0);
            }
            return sm9Var;
        }
        return (sm9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
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
