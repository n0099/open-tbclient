package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.dj;
import com.baidu.tieba.kn8;
import com.baidu.tieba.mn8;
import com.baidu.tieba.on8;
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
public class SearchJsBridge_Proxy extends kn8 {
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

    @Override // com.baidu.tieba.kn8
    public mn8 dispatch(on8 on8Var, mn8 mn8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, on8Var, mn8Var)) == null) {
            if (mn8Var == null) {
                mn8Var = new mn8();
            }
            String b = on8Var.b();
            JSONObject e = on8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                mn8Var.r(true);
                mn8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    mn8Var.x(deleteSearchHistory.f());
                    mn8Var.t(deleteSearchHistory.b());
                    mn8Var.o(deleteSearchHistory.a());
                    mn8Var.w(deleteSearchHistory.e());
                }
                mn8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                mn8Var.r(true);
                mn8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    mn8Var.x(deleteAllSearchHistory.f());
                    mn8Var.t(deleteAllSearchHistory.b());
                    mn8Var.o(deleteAllSearchHistory.a());
                    mn8Var.w(deleteAllSearchHistory.e());
                }
                mn8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                mn8Var.r(true);
                mn8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    mn8Var.x(openSearchPage.f());
                    mn8Var.t(openSearchPage.b());
                    mn8Var.o(openSearchPage.a());
                    mn8Var.w(openSearchPage.e());
                }
                mn8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                mn8Var.r(true);
                mn8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    mn8Var.x(searchHistoryJson.f());
                    mn8Var.t(searchHistoryJson.b());
                    mn8Var.o(searchHistoryJson.a());
                    mn8Var.w(searchHistoryJson.e());
                }
                mn8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                mn8Var.r(true);
                mn8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    mn8Var.x(searchAdCookie.f());
                    mn8Var.t(searchAdCookie.b());
                    mn8Var.o(searchAdCookie.a());
                    mn8Var.w(searchAdCookie.e());
                }
                mn8Var.y(0);
            }
            return mn8Var;
        }
        return (mn8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kn8
    public List<mn8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
