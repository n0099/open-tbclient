package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ui;
import com.baidu.tieba.zy9;
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
public class SearchJsBridge_Proxy extends zy9 {
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

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                bz9Var.s(true);
                bz9 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    bz9Var.y(deleteSearchHistory.f());
                    bz9Var.u(deleteSearchHistory.b());
                    bz9Var.o(deleteSearchHistory.a());
                    bz9Var.x(deleteSearchHistory.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                bz9Var.s(true);
                bz9 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    bz9Var.y(deleteAllSearchHistory.f());
                    bz9Var.u(deleteAllSearchHistory.b());
                    bz9Var.o(deleteAllSearchHistory.a());
                    bz9Var.x(deleteAllSearchHistory.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                bz9Var.s(true);
                bz9 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    bz9Var.y(openSearchPage.f());
                    bz9Var.u(openSearchPage.b());
                    bz9Var.o(openSearchPage.a());
                    bz9Var.x(openSearchPage.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                bz9Var.s(true);
                bz9 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    bz9Var.y(searchHistoryJson.f());
                    bz9Var.u(searchHistoryJson.b());
                    bz9Var.o(searchHistoryJson.a());
                    bz9Var.x(searchHistoryJson.e());
                }
                bz9Var.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                bz9Var.s(true);
                bz9 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    bz9Var.y(searchAdCookie.f());
                    bz9Var.u(searchAdCookie.b());
                    bz9Var.o(searchAdCookie.a());
                    bz9Var.x(searchAdCookie.e());
                }
                bz9Var.z(0);
            }
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
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
