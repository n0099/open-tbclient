package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import com.repackage.rh8;
import com.repackage.th8;
import com.repackage.vh8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends rh8 {
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

    @Override // com.repackage.rh8
    public th8 dispatch(vh8 vh8Var, th8 th8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vh8Var, th8Var)) == null) {
            if (th8Var == null) {
                th8Var = new th8();
            }
            String b = vh8Var.b();
            JSONObject e = vh8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                th8Var.r(true);
                th8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    th8Var.x(deleteSearchHistory.f());
                    th8Var.t(deleteSearchHistory.b());
                    th8Var.o(deleteSearchHistory.a());
                    th8Var.w(deleteSearchHistory.e());
                }
                th8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                th8Var.r(true);
                th8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    th8Var.x(deleteAllSearchHistory.f());
                    th8Var.t(deleteAllSearchHistory.b());
                    th8Var.o(deleteAllSearchHistory.a());
                    th8Var.w(deleteAllSearchHistory.e());
                }
                th8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                th8Var.r(true);
                th8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    th8Var.x(openSearchPage.f());
                    th8Var.t(openSearchPage.b());
                    th8Var.o(openSearchPage.a());
                    th8Var.w(openSearchPage.e());
                }
                th8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                th8Var.r(true);
                th8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    th8Var.x(searchHistoryJson.f());
                    th8Var.t(searchHistoryJson.b());
                    th8Var.o(searchHistoryJson.a());
                    th8Var.w(searchHistoryJson.e());
                }
                th8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                th8Var.r(true);
                th8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    th8Var.x(searchAdCookie.f());
                    th8Var.t(searchAdCookie.b());
                    th8Var.o(searchAdCookie.a());
                    th8Var.w(searchAdCookie.e());
                }
                th8Var.y(0);
            }
            return th8Var;
        }
        return (th8) invokeLL.objValue;
    }

    @Override // com.repackage.rh8
    public List<th8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (ki.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
