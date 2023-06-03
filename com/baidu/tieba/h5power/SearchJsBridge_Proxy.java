package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.ui;
import com.baidu.tieba.uy9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
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
public class SearchJsBridge_Proxy extends uy9 {
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

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var = new wy9();
            }
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                wy9Var.s(true);
                wy9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    wy9Var.y(deleteSearchHistory.f());
                    wy9Var.u(deleteSearchHistory.b());
                    wy9Var.o(deleteSearchHistory.a());
                    wy9Var.x(deleteSearchHistory.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                wy9Var.s(true);
                wy9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    wy9Var.y(deleteAllSearchHistory.f());
                    wy9Var.u(deleteAllSearchHistory.b());
                    wy9Var.o(deleteAllSearchHistory.a());
                    wy9Var.x(deleteAllSearchHistory.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                wy9Var.s(true);
                wy9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    wy9Var.y(openSearchPage.f());
                    wy9Var.u(openSearchPage.b());
                    wy9Var.o(openSearchPage.a());
                    wy9Var.x(openSearchPage.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                wy9Var.s(true);
                wy9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    wy9Var.y(searchHistoryJson.f());
                    wy9Var.u(searchHistoryJson.b());
                    wy9Var.o(searchHistoryJson.a());
                    wy9Var.x(searchHistoryJson.e());
                }
                wy9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                wy9Var.s(true);
                wy9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    wy9Var.y(searchAdCookie.f());
                    wy9Var.u(searchAdCookie.b());
                    wy9Var.o(searchAdCookie.a());
                    wy9Var.x(searchAdCookie.e());
                }
                wy9Var.z(0);
            }
            return wy9Var;
        }
        return (wy9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!ui.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
