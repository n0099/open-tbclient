package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.b39;
import com.baidu.tieba.d39;
import com.baidu.tieba.dj;
import com.baidu.tieba.z29;
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
public class SearchJsBridge_Proxy extends z29 {
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

    @Override // com.baidu.tieba.z29
    public b39 dispatch(d39 d39Var, b39 b39Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d39Var, b39Var)) == null) {
            if (b39Var == null) {
                b39Var = new b39();
            }
            String b = d39Var.b();
            JSONObject e = d39Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                b39Var.r(true);
                b39 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    b39Var.x(deleteSearchHistory.f());
                    b39Var.t(deleteSearchHistory.b());
                    b39Var.o(deleteSearchHistory.a());
                    b39Var.w(deleteSearchHistory.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                b39Var.r(true);
                b39 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    b39Var.x(deleteAllSearchHistory.f());
                    b39Var.t(deleteAllSearchHistory.b());
                    b39Var.o(deleteAllSearchHistory.a());
                    b39Var.w(deleteAllSearchHistory.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                b39Var.r(true);
                b39 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    b39Var.x(openSearchPage.f());
                    b39Var.t(openSearchPage.b());
                    b39Var.o(openSearchPage.a());
                    b39Var.w(openSearchPage.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                b39Var.r(true);
                b39 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    b39Var.x(searchHistoryJson.f());
                    b39Var.t(searchHistoryJson.b());
                    b39Var.o(searchHistoryJson.a());
                    b39Var.w(searchHistoryJson.e());
                }
                b39Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                b39Var.r(true);
                b39 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    b39Var.x(searchAdCookie.f());
                    b39Var.t(searchAdCookie.b());
                    b39Var.o(searchAdCookie.a());
                    b39Var.w(searchAdCookie.e());
                }
                b39Var.y(0);
            }
            return b39Var;
        }
        return (b39) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.z29
    public List<b39> processNotification(WebView webView, String str, HashMap hashMap) {
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
