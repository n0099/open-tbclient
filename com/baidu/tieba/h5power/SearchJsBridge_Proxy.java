package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.gi;
import com.baidu.tieba.rc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
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
public class SearchJsBridge_Proxy extends rc9 {
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

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var = new tc9();
            }
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                tc9Var.r(true);
                tc9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    tc9Var.x(deleteSearchHistory.f());
                    tc9Var.t(deleteSearchHistory.b());
                    tc9Var.o(deleteSearchHistory.a());
                    tc9Var.w(deleteSearchHistory.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                tc9Var.r(true);
                tc9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    tc9Var.x(deleteAllSearchHistory.f());
                    tc9Var.t(deleteAllSearchHistory.b());
                    tc9Var.o(deleteAllSearchHistory.a());
                    tc9Var.w(deleteAllSearchHistory.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                tc9Var.r(true);
                tc9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    tc9Var.x(openSearchPage.f());
                    tc9Var.t(openSearchPage.b());
                    tc9Var.o(openSearchPage.a());
                    tc9Var.w(openSearchPage.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                tc9Var.r(true);
                tc9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    tc9Var.x(searchHistoryJson.f());
                    tc9Var.t(searchHistoryJson.b());
                    tc9Var.o(searchHistoryJson.a());
                    tc9Var.w(searchHistoryJson.e());
                }
                tc9Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                tc9Var.r(true);
                tc9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    tc9Var.x(searchAdCookie.f());
                    tc9Var.t(searchAdCookie.b());
                    tc9Var.o(searchAdCookie.a());
                    tc9Var.w(searchAdCookie.e());
                }
                tc9Var.y(0);
            }
            return tc9Var;
        }
        return (tc9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!gi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
