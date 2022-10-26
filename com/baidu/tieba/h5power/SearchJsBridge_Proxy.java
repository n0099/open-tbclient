package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.ej;
import com.baidu.tieba.go8;
import com.baidu.tieba.io8;
import com.baidu.tieba.ko8;
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
public class SearchJsBridge_Proxy extends go8 {
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
        this.mNotificationNameList = new HashSet();
    }

    @Override // com.baidu.tieba.go8
    public io8 dispatch(ko8 ko8Var, io8 io8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ko8Var, io8Var)) == null) {
            if (io8Var == null) {
                io8Var = new io8();
            }
            String b = ko8Var.b();
            JSONObject e = ko8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                io8Var.r(true);
                io8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    io8Var.x(deleteSearchHistory.f());
                    io8Var.t(deleteSearchHistory.b());
                    io8Var.o(deleteSearchHistory.a());
                    io8Var.w(deleteSearchHistory.e());
                }
                io8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                io8Var.r(true);
                io8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    io8Var.x(deleteAllSearchHistory.f());
                    io8Var.t(deleteAllSearchHistory.b());
                    io8Var.o(deleteAllSearchHistory.a());
                    io8Var.w(deleteAllSearchHistory.e());
                }
                io8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                io8Var.r(true);
                io8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    io8Var.x(openSearchPage.f());
                    io8Var.t(openSearchPage.b());
                    io8Var.o(openSearchPage.a());
                    io8Var.w(openSearchPage.e());
                }
                io8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                io8Var.r(true);
                io8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    io8Var.x(searchHistoryJson.f());
                    io8Var.t(searchHistoryJson.b());
                    io8Var.o(searchHistoryJson.a());
                    io8Var.w(searchHistoryJson.e());
                }
                io8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                io8Var.r(true);
                io8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    io8Var.x(searchAdCookie.f());
                    io8Var.t(searchAdCookie.b());
                    io8Var.o(searchAdCookie.a());
                    io8Var.w(searchAdCookie.e());
                }
                io8Var.y(0);
            }
            return io8Var;
        }
        return (io8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.go8
    public List processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (!ej.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                List list = (List) this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
